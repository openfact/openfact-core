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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "INVOICE", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "ORGANIZATION_ID", "DOCUMENT_ID" }) })
@NamedQueries({
        @NamedQuery(name = "getAllInvoicesByOrganization", query = "select i from InvoiceEntity i where i.organization.id = :organizationId order by i.issueDateTime"),
        @NamedQuery(name = "getOrganizationInvoiceById", query = "select i from InvoiceEntity i where i.id = :id and i.organization.id = :organizationId"),
        @NamedQuery(name = "getOrganizationInvoiceByDocumentId", query = "select i from InvoiceEntity i where i.documentId = :documentId and i.organization.id = :organizationId"),
        @NamedQuery(name = "searchForInvoice", query = "select i from InvoiceEntity i where i.organization.id = :organizationId and i.documentId like :search order by i.issueDateTime"),
        @NamedQuery(name = "getOrganizationInvoiceCount", query = "select count(i) from InvoiceEntity i where i.organization.id = :organizationId") })
public class InvoiceEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "DOCUMENT_ID")
    protected String documentId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "XML_DOCUMENT")
    protected byte[] xmlDocument;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
    private OrganizationEntity organization;
    
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @Column(name = "CREATED_TIMESTAMP")
    private LocalDateTime createdTimestamp;

    /**
     * UBL
     */
    @Column(name = "ISSUE_DATE")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    protected LocalDateTime issueDateTime;

    @Column(name = "INVOICE_TYPE_CODE")
    protected String invoiceTypeCode;

    @Column(name = "DOCUMENT_CURRENCY_CODE")
    protected String documentCurrencyCode;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SupplierPartyEntity.class, cascade = {
            CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGSUPPLIERPARTY_INVOICE")
    protected SupplierPartyEntity accountingSupplierParty;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = CustomerPartyEntity.class, cascade = {
            CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCUSTOMERPARTY_INVOICE")
    protected CustomerPartyEntity accountingCustomerParty;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = MonetaryTotalEntity.class, cascade = {
            CascadeType.ALL })
    @JoinColumn(name = "LEGALMONETARYTOTAL_INVOICE")
    protected MonetaryTotalEntity legalMonetaryTotal;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = TaxTotalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXTOTAL_INVOICE_ID")
    protected List<TaxTotalEntity> taxTotal = new ArrayList<>();

    /**
     * Openfact
     */
    @ElementCollection
    @MapKeyColumn(name = "NAME")
    @Column(name = "VALUE")
    @CollectionTable(name = "INVOICE_NOTE_ATTRIBUTES", joinColumns = {
            @JoinColumn(name = "INVOICE_NOTE_ID") })
    protected Map<String, String> attributes = new HashMap<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Collection<InvoiceRequiredActionEntity> requiredActions = new ArrayList<>();

    /**
     * Send Events
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice", cascade = { CascadeType.ALL })
    protected Collection<InvoiceSendEventEntity> sendEvents = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public byte[] getXmlDocument() {
        return xmlDocument;
    }

    public void setXmlDocument(byte[] xmlDocument) {
        this.xmlDocument = xmlDocument;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public LocalDateTime getIssueDateTime() {
        return issueDateTime;
    }

    public void setIssueDateTime(LocalDateTime issueDateTime) {
        this.issueDateTime = issueDateTime;
    }

    public String getInvoiceTypeCode() {
        return invoiceTypeCode;
    }

    public void setInvoiceTypeCode(String invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
    }

    public String getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    public void setDocumentCurrencyCode(String documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    public SupplierPartyEntity getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    public void setAccountingSupplierParty(SupplierPartyEntity accountingSupplierParty) {
        this.accountingSupplierParty = accountingSupplierParty;
    }

    public CustomerPartyEntity getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    public void setAccountingCustomerParty(CustomerPartyEntity accountingCustomerParty) {
        this.accountingCustomerParty = accountingCustomerParty;
    }

    public MonetaryTotalEntity getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    public void setLegalMonetaryTotal(MonetaryTotalEntity legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
    }

    public List<TaxTotalEntity> getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(List<TaxTotalEntity> taxTotal) {
        this.taxTotal = taxTotal;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Collection<InvoiceRequiredActionEntity> getRequiredActions() {
        return requiredActions;
    }

    public void setRequiredActions(Collection<InvoiceRequiredActionEntity> requiredActions) {
        this.requiredActions = requiredActions;
    }

    public Collection<InvoiceSendEventEntity> getSendEvents() {
        return sendEvents;
    }

    public void setSendEvents(Collection<InvoiceSendEventEntity> sendEvents) {
        this.sendEvents = sendEvents;
    }

    
}
