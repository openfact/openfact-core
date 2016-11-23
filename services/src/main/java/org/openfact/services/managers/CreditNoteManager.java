/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.services.managers;

import java.util.Map;

import javax.xml.transform.TransformerException;

import org.jboss.logging.Logger;
import org.openfact.common.converts.DocumentUtils;
import org.openfact.models.CreditNoteModel;
import org.openfact.models.CreditNoteProvider;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequiredActionDocument;
import org.openfact.models.utils.TypeToModel;
import org.openfact.ubl.CreditNoteIDGeneratorProvider;
import org.openfact.ubl.CreditNoteReaderWriterProvider;
import org.openfact.ubl.SignerProvider;
import org.w3c.dom.Document;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;

public class CreditNoteManager {

    protected static final Logger logger = Logger.getLogger(CreditNoteManager.class);

    protected OpenfactSession session;
    protected CreditNoteProvider model;

    public CreditNoteManager(OpenfactSession session) {
        this.session = session;
        this.model = session.creditNotes();
    }

    public CreditNoteModel getCreditNoteByID(OrganizationModel organization, String ID) {
        return model.getCreditNoteByID(organization, ID);
    }

    public CreditNoteModel addCreditNote(OrganizationModel organization, CreditNoteType type,
            Map<String, String> attributes) {
        IDType documentId = type.getID();
        if (documentId == null) {
            String generatedId = session.getProvider(CreditNoteIDGeneratorProvider.class)
                    .generateID(organization, type);
            documentId = new IDType(generatedId);
            type.setID(documentId);
        }

        CreditNoteModel creditNote = model.addCreditNote(organization, documentId.getValue());
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            creditNote.setAttribute(entry.getKey(), entry.getValue());
        }

        TypeToModel.importCreditNote(session, organization, creditNote, type);
        RequiredActionDocument.getDefaults().stream().forEach(c -> creditNote.addRequiredAction(c));

        try {
            // Generate Document
            CreditNoteReaderWriterProvider creditNoteReaderProvider = session
                    .getProvider(CreditNoteReaderWriterProvider.class);
            Document baseDocument = creditNoteReaderProvider.writeAsDocument(organization, type, attributes);

            // Sign Document
            SignerProvider signerProvider = session.getProvider(SignerProvider.class);
            Document signedDocument = signerProvider.sign(baseDocument, organization);

            byte[] bytes = DocumentUtils.getBytesFromDocument(signedDocument);
            creditNote.setXmlDocument(bytes);
        } catch (TransformerException e) {
            logger.error("Error parsing to byte XML", e);
            throw new ModelException(e);
        }

        return creditNote;
    }

    public boolean removeCreditNote(OrganizationModel organization, CreditNoteModel creditNote) {
        if (model.removeCreditNote(organization, creditNote)) {
            return true;
        }
        return false;
    }

    public void sendToCustomerParty(OrganizationModel organization, CreditNoteModel creditNote) {
        // TODO Auto-generated method stub

    }

    public void sendToTrirdParty(OrganizationModel organization, CreditNoteModel creditNote) {
        // TODO Auto-generated method stub

    }

}
