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

package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.openfact.models.enums.RequiredActionDocument;
import org.openfact.models.jpa.entities.OrganizationEntity;
import org.openfact.models.jpa.entities.ubl.common.AllowanceChargeEntity;
import org.openfact.models.jpa.entities.ubl.common.BillingReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.CustomerPartyEntity;
import org.openfact.models.jpa.entities.ubl.common.DeliveryEntity;
import org.openfact.models.jpa.entities.ubl.common.DeliveryTermsEntity;
import org.openfact.models.jpa.entities.ubl.common.DocumentReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.ExchangeRateEntity;
import org.openfact.models.jpa.entities.ubl.common.InvoiceLineEntity;
import org.openfact.models.jpa.entities.ubl.common.MonetaryTotalEntity;
import org.openfact.models.jpa.entities.ubl.common.OrderReferenceEntity;
import org.openfact.models.jpa.entities.ubl.common.PartyEntity;
import org.openfact.models.jpa.entities.ubl.common.PaymentEntity;
import org.openfact.models.jpa.entities.ubl.common.PaymentMeansEntity;
import org.openfact.models.jpa.entities.ubl.common.PaymentTermsEntity;
import org.openfact.models.jpa.entities.ubl.common.PeriodEntity;
import org.openfact.models.jpa.entities.ubl.common.SignatureEntity;
import org.openfact.models.jpa.entities.ubl.common.SupplierPartyEntity;
import org.openfact.models.jpa.entities.ubl.common.TaxTotalEntity;
import org.openfact.models.jpa.entities.ubl.common.UBLExtensionsEntity;

@Entity
@Table(name = "INVOICE", uniqueConstraints = { @UniqueConstraint(columnNames = { "ORGANIZATION_ID", "ID_UBL" }) })
@NamedQueries({
		@NamedQuery(name = "getAllInvoicesByOrganization", query = "select i from InvoiceEntity i where i.organization.id = :organizationId order by i.issueDateTime"),
		@NamedQuery(name = "getOrganizationInvoiceById", query = "select i from InvoiceEntity i where i.id = :id and i.organization.id = :organizationId"),
		@NamedQuery(name = "getOrganizationInvoiceByID", query = "select i from InvoiceEntity i where i.ID = :ID and i.organization.id = :organizationId"),
		@NamedQuery(name = "searchForInvoice", query = "select i from InvoiceEntity i where i.organization.id = :organizationId and i.ID like :search order by i.issueDateTime"),
		@NamedQuery(name = "getOrganizationInvoiceCount", query = "select count(i) from InvoiceEntity i where i.organization.id = :organizationId"),
		@NamedQuery(name = "getLastInvoiceByOrganization", query = "select i from InvoiceEntity i where i.organization.id = :organizationId and length(i.ID)=:IDLength and i.ID like :formatter order by i.issueDateTime desc") })
public class InvoiceEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Access(AccessType.PROPERTY)
	protected String id;

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "invoice")
	protected Collection<InvoiceAttributeEntity> attributes = new ArrayList<>();

	@ManyToMany(mappedBy = "invoices", cascade = { CascadeType.ALL })
	protected List<SendEventEntity> sendEvents = new ArrayList<>();

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
	private OrganizationEntity organization;

	/**
	 * */
	@ManyToOne(targetEntity = UBLExtensionsEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "UBLEXTENSIONS_INVOICE_ID")
	protected UBLExtensionsEntity ublExtensions = new UBLExtensionsEntity();

	@Column(name = "UBL_VERSIONID")
	protected String ublVersionID;

	@Column(name = "CUSTOMIZATIONID")
	protected String customizationID;

	@Column(name = "PROFILEID")
	protected String profileID;

	@Column(name = "ID_UBL")
	protected String ID;

	@Column(name = "COPY_INDICATOR")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	protected boolean copyIndicator;

	@Column(name = "UUID")
	protected String uuid;

	@Column(name = "ISSUE_DATE")
	@Type(type = "org.hibernate.type.LocalDateTimeType")
	protected LocalDateTime issueDateTime;

	@Column(name = "INVOICE_TYOE_CODE")
	protected String invoiceTypeCode;

	@ElementCollection
	@Column(name = "VALUE")
	@CollectionTable(name = "INVOICE_NOTE", joinColumns = { @JoinColumn(name = "INVOICE_ID") })
	protected List<String> note = new ArrayList<>();

	@Column(name = "TAX_POINT_DATE")
	@Type(type = "org.hibernate.type.LocalDateType")
	protected LocalDate taxPointDate;

	@Column(name = "DOCUMENT_CURRENCY_CODE")
	protected String documentCurrencyCode;

	@Column(name = "TAX_CURRENCY_CODE")
	protected String taxCurrencyCode;

	@Column(name = "PRICING_CURRENCY_CODE")
	protected String pricingCurrencyCode;

	@Column(name = "PAYMENT_CURRENCY_CODE")
	protected String paymentCurrencyCode;

	@Column(name = "PAYMENT_ALTERNATIVE_CURRENCY_CODE")
	protected String paymentAlternativeCurrencyCode;

	@Column(name = "ACCOUNTING_COST_CODE")
	protected String accountingCostCode;

	@Column(name = "ACCOUNTING_COST")
	protected String accountingCost;

	@Column(name = "LINE_COUNT_NUMERIC")
	protected BigDecimal lineCountNumeric;

	@OneToMany(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INVOICEPERIOD_INVOICE")
	protected List<PeriodEntity> invoicePeriod = new ArrayList<>();

	@ManyToOne(targetEntity = OrderReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORDERREFERENCE_INVOICE")
	protected OrderReferenceEntity orderReference = new OrderReferenceEntity();

	@OneToMany(targetEntity = BillingReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "BILLINGREFERENCE_INVOICE")
	protected List<BillingReferenceEntity> billingReference = new ArrayList<>();

	@OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DESPATCHDOCUMENTREFERENCE_INVOICE")
	protected List<DocumentReferenceEntity> despatchDocumentReference = new ArrayList<>();

	@OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "RECEIPTDOCUMENTREFERENCE_INVOICE")
	protected List<DocumentReferenceEntity> receiptDocumentReference = new ArrayList<>();

	@OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ORIGINATORDOCUMENTREFERENCE_INVOICE")
	protected List<DocumentReferenceEntity> originatorDocumentReference = new ArrayList<>();

	@OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "CONTRACTDOCUMENTREFERENCE_INVOICE")
	protected List<DocumentReferenceEntity> contractDocumentReference = new ArrayList<>();

	@OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ADDITIONALDOCUMENTREFERENCE_INVOICE")
	protected List<DocumentReferenceEntity> additionalDocumentReference = new ArrayList<>();

	@OneToMany(targetEntity = SignatureEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SIGNATURE_INVOICE")
	protected List<SignatureEntity> signature = new ArrayList<>();

	@ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACCOUNTINGSUPPLIERPARTY_INVOICE")
	protected SupplierPartyEntity accountingSupplierParty = new SupplierPartyEntity();

	@ManyToOne(targetEntity = CustomerPartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ACCOUNTINGCUSTOMERPARTY_INVOICE")
	protected CustomerPartyEntity accountingCustomerParty = new CustomerPartyEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PAYEEPARTY_INVOICE_ID")
	protected PartyEntity payeeParty = new PartyEntity();

	@ManyToOne(targetEntity = CustomerPartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "BUYERCUSTOMERPARTY_INVOICE")
	protected CustomerPartyEntity buyerCustomerParty = new CustomerPartyEntity();

	@ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "SELLERSUPPLIERPARTY_INVOICE")
	protected SupplierPartyEntity sellerSupplierParty = new SupplierPartyEntity();

	@ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TAXREPRESENTATIVEPARTY_INVOICE")
	protected PartyEntity taxRepresentativeParty = new PartyEntity();

	@OneToMany(targetEntity = DeliveryEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DELIVERY_INVOICETYPE_ID")
	protected List<DeliveryEntity> delivery = new ArrayList<>();

	@ManyToOne(targetEntity = DeliveryTermsEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "DELIVERYTERMS_INVOICE")
	protected DeliveryTermsEntity deliveryTerms = new DeliveryTermsEntity();

	@OneToMany(targetEntity = PaymentMeansEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PAYMENTMEANS_INVOICE_ID")
	protected List<PaymentMeansEntity> paymentMeans = new ArrayList<>();

	@OneToMany(targetEntity = PaymentTermsEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PAYMENTTERMS_INVOICE_ID")
	protected List<PaymentTermsEntity> paymentTerms = new ArrayList<>();

	@OneToMany(targetEntity = PaymentEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PREPAIDPAYMENT_INVOICE")
	protected List<PaymentEntity> prepaidPayment = new ArrayList<>();

	@OneToMany(targetEntity = AllowanceChargeEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "ALLOWANCECHARGE_INVOICE")
	protected List<AllowanceChargeEntity> allowanceCharge = new ArrayList<>();

	@ManyToOne(targetEntity = ExchangeRateEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TAXEXCHANGERATE_INVOICE")
	protected ExchangeRateEntity taxExchangeRate = new ExchangeRateEntity();

	@ManyToOne(targetEntity = ExchangeRateEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PRICINGEXCHANGERATE_INVOICE")
	protected ExchangeRateEntity pricingExchangeRate = new ExchangeRateEntity();

	@ManyToOne(targetEntity = ExchangeRateEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PAYMENTEXCHANGERATE_INVOICE")
	protected ExchangeRateEntity paymentExchangeRate = new ExchangeRateEntity();

	@ManyToOne(targetEntity = ExchangeRateEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "PAYMENTALTERNATIVEEXCHANGERATE_INVOICE")
	protected ExchangeRateEntity paymentAlternativeExchangeRate = new ExchangeRateEntity();

	@OneToMany(targetEntity = TaxTotalEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TAXTOTAL_INVOICE_ID")
	protected List<TaxTotalEntity> taxTotal = new ArrayList<>();

	@ManyToOne(targetEntity = MonetaryTotalEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "LEGALMONETARYTOTAL_INVOICE")
	protected MonetaryTotalEntity legalMonetaryTotal = new MonetaryTotalEntity();

	@OneToMany(targetEntity = InvoiceLineEntity.class, cascade = { CascadeType.ALL })
	@JoinColumn(name = "INVOICELINE_INVOICE_ID")
	protected List<InvoiceLineEntity> invoiceLine = new ArrayList<>();

	@Lob
	@Column(name = "XML_DOCUMENT")
	protected Byte[] xmlDocument;

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy="invoice")
	private Collection<InvoiceRequiredActionEntity> requiredActions = new ArrayList<InvoiceRequiredActionEntity>();

	public Byte[] getXmlDocument() {
		return xmlDocument;
	}

	public void setXmlDocument(Byte[] xmlDocument) {
		this.xmlDocument = xmlDocument;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Collection<InvoiceAttributeEntity> getAttributes() {
		return attributes;
	}

	public void setAttributes(Collection<InvoiceAttributeEntity> attributes) {
		this.attributes = attributes;
	}

	public OrganizationEntity getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationEntity organization) {
		this.organization = organization;
	}

	public UBLExtensionsEntity getUblExtensions() {
		return ublExtensions;
	}

	public void setUblExtensions(UBLExtensionsEntity ublExtensions) {
		this.ublExtensions = ublExtensions;
	}

	public String getUblVersionID() {
		return ublVersionID;
	}

	public void setUblVersionID(String ublVersionID) {
		this.ublVersionID = ublVersionID;
	}

	public String getCustomizationID() {
		return customizationID;
	}

	public void setCustomizationID(String customizationID) {
		this.customizationID = customizationID;
	}

	public String getProfileID() {
		return profileID;
	}

	public void setProfileID(String profileID) {
		this.profileID = profileID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public boolean isCopyIndicator() {
		return copyIndicator;
	}

	public void setCopyIndicator(boolean copyIndicator) {
		this.copyIndicator = copyIndicator;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public List<String> getNote() {
		return note;
	}

	public void setNote(List<String> note) {
		this.note = note;
	}

	public LocalDate getTaxPointDate() {
		return taxPointDate;
	}

	public void setTaxPointDate(LocalDate taxPointDate) {
		this.taxPointDate = taxPointDate;
	}

	public String getDocumentCurrencyCode() {
		return documentCurrencyCode;
	}

	public void setDocumentCurrencyCode(String documentCurrencyCode) {
		this.documentCurrencyCode = documentCurrencyCode;
	}

	public String getTaxCurrencyCode() {
		return taxCurrencyCode;
	}

	public void setTaxCurrencyCode(String taxCurrencyCode) {
		this.taxCurrencyCode = taxCurrencyCode;
	}

	public String getPricingCurrencyCode() {
		return pricingCurrencyCode;
	}

	public void setPricingCurrencyCode(String pricingCurrencyCode) {
		this.pricingCurrencyCode = pricingCurrencyCode;
	}

	public String getPaymentCurrencyCode() {
		return paymentCurrencyCode;
	}

	public void setPaymentCurrencyCode(String paymentCurrencyCode) {
		this.paymentCurrencyCode = paymentCurrencyCode;
	}

	public String getPaymentAlternativeCurrencyCode() {
		return paymentAlternativeCurrencyCode;
	}

	public void setPaymentAlternativeCurrencyCode(String paymentAlternativeCurrencyCode) {
		this.paymentAlternativeCurrencyCode = paymentAlternativeCurrencyCode;
	}

	public String getAccountingCostCode() {
		return accountingCostCode;
	}

	public void setAccountingCostCode(String accountingCostCode) {
		this.accountingCostCode = accountingCostCode;
	}

	public String getAccountingCost() {
		return accountingCost;
	}

	public void setAccountingCost(String accountingCost) {
		this.accountingCost = accountingCost;
	}

	public BigDecimal getLineCountNumeric() {
		return lineCountNumeric;
	}

	public void setLineCountNumeric(BigDecimal lineCountNumeric) {
		this.lineCountNumeric = lineCountNumeric;
	}

	public List<PeriodEntity> getInvoicePeriod() {
		return invoicePeriod;
	}

	public void setInvoicePeriod(List<PeriodEntity> invoicePeriod) {
		this.invoicePeriod = invoicePeriod;
	}

	public OrderReferenceEntity getOrderReference() {
		return orderReference;
	}

	public void setOrderReference(OrderReferenceEntity orderReference) {
		this.orderReference = orderReference;
	}

	public List<BillingReferenceEntity> getBillingReference() {
		return billingReference;
	}

	public void setBillingReference(List<BillingReferenceEntity> billingReference) {
		this.billingReference = billingReference;
	}

	public List<DocumentReferenceEntity> getDespatchDocumentReference() {
		return despatchDocumentReference;
	}

	public void setDespatchDocumentReference(List<DocumentReferenceEntity> despatchDocumentReference) {
		this.despatchDocumentReference = despatchDocumentReference;
	}

	public List<DocumentReferenceEntity> getReceiptDocumentReference() {
		return receiptDocumentReference;
	}

	public void setReceiptDocumentReference(List<DocumentReferenceEntity> receiptDocumentReference) {
		this.receiptDocumentReference = receiptDocumentReference;
	}

	public List<DocumentReferenceEntity> getOriginatorDocumentReference() {
		return originatorDocumentReference;
	}

	public void setOriginatorDocumentReference(List<DocumentReferenceEntity> originatorDocumentReference) {
		this.originatorDocumentReference = originatorDocumentReference;
	}

	public List<DocumentReferenceEntity> getContractDocumentReference() {
		return contractDocumentReference;
	}

	public void setContractDocumentReference(List<DocumentReferenceEntity> contractDocumentReference) {
		this.contractDocumentReference = contractDocumentReference;
	}

	public List<DocumentReferenceEntity> getAdditionalDocumentReference() {
		return additionalDocumentReference;
	}

	public void setAdditionalDocumentReference(List<DocumentReferenceEntity> additionalDocumentReference) {
		this.additionalDocumentReference = additionalDocumentReference;
	}

	public List<SignatureEntity> getSignature() {
		return signature;
	}

	public void setSignature(List<SignatureEntity> signature) {
		this.signature = signature;
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

	public PartyEntity getPayeeParty() {
		return payeeParty;
	}

	public void setPayeeParty(PartyEntity payeeParty) {
		this.payeeParty = payeeParty;
	}

	public CustomerPartyEntity getBuyerCustomerParty() {
		return buyerCustomerParty;
	}

	public void setBuyerCustomerParty(CustomerPartyEntity buyerCustomerParty) {
		this.buyerCustomerParty = buyerCustomerParty;
	}

	public SupplierPartyEntity getSellerSupplierParty() {
		return sellerSupplierParty;
	}

	public void setSellerSupplierParty(SupplierPartyEntity sellerSupplierParty) {
		this.sellerSupplierParty = sellerSupplierParty;
	}

	public PartyEntity getTaxRepresentativeParty() {
		return taxRepresentativeParty;
	}

	public void setTaxRepresentativeParty(PartyEntity taxRepresentativeParty) {
		this.taxRepresentativeParty = taxRepresentativeParty;
	}

	public List<DeliveryEntity> getDelivery() {
		return delivery;
	}

	public void setDelivery(List<DeliveryEntity> delivery) {
		this.delivery = delivery;
	}

	public DeliveryTermsEntity getDeliveryTerms() {
		return deliveryTerms;
	}

	public void setDeliveryTerms(DeliveryTermsEntity deliveryTerms) {
		this.deliveryTerms = deliveryTerms;
	}

	public List<PaymentMeansEntity> getPaymentMeans() {
		return paymentMeans;
	}

	public void setPaymentMeans(List<PaymentMeansEntity> paymentMeans) {
		this.paymentMeans = paymentMeans;
	}

	public List<PaymentTermsEntity> getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(List<PaymentTermsEntity> paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public List<PaymentEntity> getPrepaidPayment() {
		return prepaidPayment;
	}

	public void setPrepaidPayment(List<PaymentEntity> prepaidPayment) {
		this.prepaidPayment = prepaidPayment;
	}

	public List<AllowanceChargeEntity> getAllowanceCharge() {
		return allowanceCharge;
	}

	public void setAllowanceCharge(List<AllowanceChargeEntity> allowanceCharge) {
		this.allowanceCharge = allowanceCharge;
	}

	public ExchangeRateEntity getTaxExchangeRate() {
		return taxExchangeRate;
	}

	public void setTaxExchangeRate(ExchangeRateEntity taxExchangeRate) {
		this.taxExchangeRate = taxExchangeRate;
	}

	public ExchangeRateEntity getPricingExchangeRate() {
		return pricingExchangeRate;
	}

	public void setPricingExchangeRate(ExchangeRateEntity pricingExchangeRate) {
		this.pricingExchangeRate = pricingExchangeRate;
	}

	public ExchangeRateEntity getPaymentExchangeRate() {
		return paymentExchangeRate;
	}

	public void setPaymentExchangeRate(ExchangeRateEntity paymentExchangeRate) {
		this.paymentExchangeRate = paymentExchangeRate;
	}

	public ExchangeRateEntity getPaymentAlternativeExchangeRate() {
		return paymentAlternativeExchangeRate;
	}

	public void setPaymentAlternativeExchangeRate(ExchangeRateEntity paymentAlternativeExchangeRate) {
		this.paymentAlternativeExchangeRate = paymentAlternativeExchangeRate;
	}

	public List<TaxTotalEntity> getTaxTotal() {
		return taxTotal;
	}

	public void setTaxTotal(List<TaxTotalEntity> taxTotal) {
		this.taxTotal = taxTotal;
	}

	public MonetaryTotalEntity getLegalMonetaryTotal() {
		return legalMonetaryTotal;
	}

	public void setLegalMonetaryTotal(MonetaryTotalEntity legalMonetaryTotal) {
		this.legalMonetaryTotal = legalMonetaryTotal;
	}

	public List<InvoiceLineEntity> getInvoiceLine() {
		return invoiceLine;
	}

	public void setInvoiceLine(List<InvoiceLineEntity> invoiceLine) {
		this.invoiceLine = invoiceLine;
	}

	public List<SendEventEntity> getSendEvents() {
		return sendEvents;
	}

	public void setSendEvents(List<SendEventEntity> sendEvents) {
		this.sendEvents = sendEvents;
	}

	public Collection<InvoiceRequiredActionEntity> getRequiredActions() {
		return requiredActions;
	}

	public void setRequiredActions(Collection<InvoiceRequiredActionEntity> requiredActions) {
		this.requiredActions = requiredActions;
	}
}
