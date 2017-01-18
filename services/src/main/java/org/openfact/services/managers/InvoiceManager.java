/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.services.managers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.xml.transform.TransformerException;

import org.jboss.logging.Logger;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.email.EmailException;
import org.openfact.email.EmailTemplateProvider;
import org.openfact.file.FileModel;
import org.openfact.file.FileMymeTypeModel;
import org.openfact.file.FileProvider;
import org.openfact.models.*;
import org.openfact.models.enums.DestinyType;
import org.openfact.models.enums.RequiredAction;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.utils.OpenfactModelUtils;
import org.openfact.models.utils.TypeToModel;
import org.openfact.report.ExportFormat;
import org.openfact.report.ReportException;
import org.openfact.representations.idm.ThirdPartyEmailRepresentation;
import org.openfact.ubl.SignerProvider;
import org.openfact.ubl.UBLInvoiceProvider;
import org.openfact.ubl.UBLReportProvider;
import org.w3c.dom.Document;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class InvoiceManager {

    protected static final Logger logger = Logger.getLogger(DebitNoteManager.class);

    protected OpenfactSession session;
    protected InvoiceProvider model;
    protected UBLInvoiceProvider ublProvider;

    public InvoiceManager(OpenfactSession session) {
        this.session = session;
        this.model = session.invoices();
        this.ublProvider = session.getProvider(UBLInvoiceProvider.class);
    }

    public InvoiceModel getInvoiceByDocumentId(OrganizationModel organization, String documentId) {
        return model.getInvoiceByDocumentId(organization, documentId);
    }

    public InvoiceModel addInvoice(OrganizationModel organization, InvoiceType invoiceType, Map<String, List<String>> attributes) {
        // Model persist
        IDType documentId = invoiceType.getID();
        if (documentId == null) {
            String newDocumentId = ublProvider.idGenerator().generateID(organization, invoiceType);
            documentId = new IDType(newDocumentId);
            invoiceType.setID(documentId);
        }
        InvoiceModel invoiceModel = model.addInvoice(organization, documentId.getValue());

        // Attributes
        for (Map.Entry<String, List<String>> entry : attributes.entrySet()) {
            invoiceModel.setAttribute(entry.getKey(), entry.getValue());
        }

        // Type to Model
        TypeToModel.importInvoice(session, organization, invoiceModel, invoiceType);

        // Required actions
        Arrays.stream(RequiredAction.values()).forEach(c -> invoiceModel.addRequiredAction(c));

        try {
            // Generate Document
            Document baseDocument = ublProvider.writer().write(organization, invoiceType, attributes);
            Document signedDocument = session.getProvider(SignerProvider.class).sign(baseDocument, organization);
            byte[] signedDocumentBytes = DocumentUtils.getBytesFromDocument(signedDocument);

            // File
            FileModel xmlFile = session.getProvider(FileProvider.class).createFile(organization, OpenfactModelUtils.generateId() + ".xml", signedDocumentBytes);
            invoiceModel.attachXmlFile(xmlFile);
        } catch (TransformerException e) {
            logger.error("Error parsing XML to byte", e);
            throw new ModelException(e);
        }

        fireInvoicePostCreate(invoiceModel);
        return invoiceModel;
    }

    private void fireInvoicePostCreate(InvoiceModel invoice) {
        session.getOpenfactSessionFactory().publish(new InvoiceModel.InvoicePostCreateEvent() {
            @Override
            public InvoiceModel getCreatedInvoice() {
                return invoice;
            }

            @Override
            public OpenfactSession getOpenfactSession() {
                return session;
            }
        });
    }

    public boolean removeInvoice(OrganizationModel organization, InvoiceModel invoice) {
        if (model.removeInvoice(organization, invoice)) {
            return true;
        }
        return false;
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, InvoiceModel invoice) throws SendException {
        return sendToCustomerParty(organization, invoice, null);
    }

    public SendEventModel sendToCustomerParty(OrganizationModel organization, InvoiceModel invoice, SendEventModel sendEvent) throws SendException {
        if(sendEvent == null) {
            return ublProvider.sender().sendToCustomer(organization, invoice);
        } else {
            return ublProvider.sender().sendToCustomer(organization, invoice, sendEvent);
        }
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, InvoiceModel invoice) throws SendException {
        return sendToTrirdParty(organization, invoice, null);
    }

    public SendEventModel sendToTrirdParty(OrganizationModel organization, InvoiceModel invoice, SendEventModel sendEvent) throws SendException {
        if(sendEvent == null) {
            return ublProvider.sender().sendToThirdParty(organization, invoice);
        } else {
            return ublProvider.sender().sendToThirdParty(organization, invoice, sendEvent);
        }
    }

    public SendEventModel sendToThirdPartyByEmail(OrganizationModel organization, InvoiceModel invoice, String email) throws SendException {
        return sendToThirdPartyByEmail(organization, invoice, invoice.addSendEvent(DestinyType.CUSTOMER), email);
    }

    public SendEventModel sendToThirdPartyByEmail(OrganizationModel organization, InvoiceModel invoice, SendEventModel sendEvent, String email) throws SendException {
        sendEvent.setType("EMAIL");

        if (organization.getSmtpConfig().size() == 0) {
            sendEvent.setResult(SendResultType.ERROR);
            sendEvent.setDescription("Could not find a valid smtp configuration on organization.");
            return sendEvent;
        }

        // User where the email will be send
        UserSenderModel user = new UserSenderModel(email);

        try {
            FileProvider fileProvider = session.getProvider(FileProvider.class);

            // Attatchments
            FileModel xmlFile = fileProvider.createFile(organization, OpenfactModelUtils.generateId() + ".xml", invoice.getXmlAsFile().getFile());
            FileMymeTypeModel xmlFileMymeType = new FileMymeTypeModel(xmlFile, "application/xml");

            byte[] pdfFileBytes = session.getProvider(UBLReportProvider.class).invoice().setOrganization(organization).getReport(invoice, ExportFormat.PDF);
            FileModel pdfFile = fileProvider.createFile(organization, OpenfactModelUtils.generateId() + ".pdf", pdfFileBytes);
            FileMymeTypeModel pdfFileMymeType = new FileMymeTypeModel(pdfFile, "application/pdf");

            session.getProvider(EmailTemplateProvider.class)
                    .setOrganization(organization).setUser(user)
                    .setAttachments(Arrays.asList(xmlFileMymeType, pdfFileMymeType))
                    .sendInvoice(invoice);

            // Write event to the database
            sendEvent.setDescription("Ivoice successfully sended");
            sendEvent.attachFile(xmlFile);
            sendEvent.attachFile(pdfFile);
            sendEvent.setResult(SendResultType.SUCCESS);

            sendEvent.setSingleDestinyAttribute("email", user.getEmail());

            return sendEvent;
        } catch (ReportException e) {
            sendEvent.setResult(SendResultType.ERROR);
            sendEvent.setDescription("Internal Server Error on generate report");
            throw new SendException("Could not generate pdf report", e);
        } catch (EmailException e) {
            sendEvent.setResult(SendResultType.ERROR);
            sendEvent.setDescription("Internal Server Error on send email");
            throw new SendException("Could not send email", e);
        }
    }
}
