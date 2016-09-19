//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.jpa.entities.ubl.common.*;


@Entity(name = "CreditNoteType")
@Table(name = "CREDITNOTETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class CreditNoteEntity {

    protected UBLExtensionsEntity ublExtensions;
    protected UBLVersionIDType ublVersionID;
    protected CustomizationIDType customizationID;
    protected ProfileIDType profileID;
    protected IDType ID;
    protected CopyIndicatorType copyIndicator;
    protected UUIDType uuid;
    protected IssueDateType issueDate;
    protected IssueTimeType issueTime;
    protected TaxPointDateType taxPointDate;
    protected List<NoteType> note;
    protected DocumentCurrencyCodeType documentCurrencyCode;
    protected TaxCurrencyCodeType taxCurrencyCode;
    protected PricingCurrencyCodeType pricingCurrencyCode;
    protected PaymentCurrencyCodeType paymentCurrencyCode;
    protected PaymentAlternativeCurrencyCodeType paymentAlternativeCurrencyCode;
    protected AccountingCostCodeType accountingCostCode;
    protected AccountingCostType accountingCost;
    protected LineCountNumericType lineCountNumeric;
    protected List<PeriodEntity> invoicePeriod;
    protected List<ResponseEntity> discrepancyResponse;
    protected OrderReferenceType orderReference;
    protected List<BillingReferenceEntity> billingReference;
    protected List<DocumentReferenceEntity> despatchDocumentReference;
    protected List<DocumentReferenceEntity> receiptDocumentReference;
    protected List<DocumentReferenceEntity> contractDocumentReference;
    protected List<DocumentReferenceEntity> additionalDocumentReference;
    protected List<SignatureEntity> signature;
    protected SupplierPartyEntity accountingSupplierParty;
    protected CustomerPartyType accountingCustomerParty;
    protected PartyEntity payeeParty;
    protected PartyEntity taxRepresentativeParty;
    protected ExchangeRateType taxExchangeRate;
    protected ExchangeRateType pricingExchangeRate;
    protected ExchangeRateType paymentExchangeRate;
    protected ExchangeRateType paymentAlternativeExchangeRate;
    protected List<AllowanceChargeEntity> allowanceCharge;
    protected List<TaxTotalEntity> taxTotal;
    protected MonetaryTotalEntity legalMonetaryTotal;
    protected List<CreditNoteLineEntity> creditNoteLine;
    protected String id;

    @ManyToOne(targetEntity = UBLExtensionsEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UBLEXTENSIONS_CREDITNOTETYPE_0")
    public UBLExtensionsEntity getUBLExtensions() {
        return ublExtensions;
    }

    public void setUBLExtensions(UBLExtensionsEntity value) {
        this.ublExtensions = value;
    }

    @ManyToOne(targetEntity = UBLVersionIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UBLVERSIONID_CREDITNOTETYPE__0")
    public UBLVersionIDType getUBLVersionID() {
        return ublVersionID;
    }

    public void setUBLVersionID(UBLVersionIDType value) {
        this.ublVersionID = value;
    }

    @ManyToOne(targetEntity = CustomizationIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CUSTOMIZATIONID_CREDITNOTETY_0")
    public CustomizationIDType getCustomizationID() {
        return customizationID;
    }

    public void setCustomizationID(CustomizationIDType value) {
        this.customizationID = value;
    }

    @ManyToOne(targetEntity = ProfileIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PROFILEID_CREDITNOTETYPE_OFID")
    public ProfileIDType getProfileID() {
        return profileID;
    }

    public void setProfileID(ProfileIDType value) {
        this.profileID = value;
    }

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_CREDITNOTETYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = CopyIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "COPYINDICATOR_CREDITNOTETYPE_0")
    public CopyIndicatorType getCopyIndicator() {
        return copyIndicator;
    }

    public void setCopyIndicator(CopyIndicatorType value) {
        this.copyIndicator = value;
    }

    @ManyToOne(targetEntity = UUIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UUID_CREDITNOTETYPE_OFID")
    public UUIDType getUUID() {
        return uuid;
    }

    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    @ManyToOne(targetEntity = IssueDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ISSUEDATE_CREDITNOTETYPE_OFID")
    public IssueDateType getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(IssueDateType value) {
        this.issueDate = value;
    }

    @ManyToOne(targetEntity = IssueTimeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ISSUETIME_CREDITNOTETYPE_OFID")
    public IssueTimeType getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(IssueTimeType value) {
        this.issueTime = value;
    }

    @ManyToOne(targetEntity = TaxPointDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXPOINTDATE_CREDITNOTETYPE__0")
    public TaxPointDateType getTaxPointDate() {
        return taxPointDate;
    }

    public void setTaxPointDate(TaxPointDateType value) {
        this.taxPointDate = value;
    }

    @OneToMany(targetEntity = NoteType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NOTE_CREDITNOTETYPE_OFID")
    public List<NoteType> getNote() {
        if (note == null) {
            note = new ArrayList<NoteType>();
        }
        return this.note;
    }

    public void setNote(List<NoteType> note) {
        this.note = note;
    }

    @ManyToOne(targetEntity = DocumentCurrencyCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DOCUMENTCURRENCYCODE_CREDITN_0")
    public DocumentCurrencyCodeType getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }

    public void setDocumentCurrencyCode(DocumentCurrencyCodeType value) {
        this.documentCurrencyCode = value;
    }

    @ManyToOne(targetEntity = TaxCurrencyCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXCURRENCYCODE_CREDITNOTETY_0")
    public TaxCurrencyCodeType getTaxCurrencyCode() {
        return taxCurrencyCode;
    }

    public void setTaxCurrencyCode(TaxCurrencyCodeType value) {
        this.taxCurrencyCode = value;
    }

    @ManyToOne(targetEntity = PricingCurrencyCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRICINGCURRENCYCODE_CREDITNO_0")
    public PricingCurrencyCodeType getPricingCurrencyCode() {
        return pricingCurrencyCode;
    }

    public void setPricingCurrencyCode(PricingCurrencyCodeType value) {
        this.pricingCurrencyCode = value;
    }

    @ManyToOne(targetEntity = PaymentCurrencyCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTCURRENCYCODE_CREDITNO_0")
    public PaymentCurrencyCodeType getPaymentCurrencyCode() {
        return paymentCurrencyCode;
    }

    public void setPaymentCurrencyCode(PaymentCurrencyCodeType value) {
        this.paymentCurrencyCode = value;
    }

    @ManyToOne(targetEntity = PaymentAlternativeCurrencyCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTALTERNATIVECURRENCYCO_2")
    public PaymentAlternativeCurrencyCodeType getPaymentAlternativeCurrencyCode() {
        return paymentAlternativeCurrencyCode;
    }

    public void setPaymentAlternativeCurrencyCode(PaymentAlternativeCurrencyCodeType value) {
        this.paymentAlternativeCurrencyCode = value;
    }

    @ManyToOne(targetEntity = AccountingCostCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCOSTCODE_CREDITNOT_0")
    public AccountingCostCodeType getAccountingCostCode() {
        return accountingCostCode;
    }

    public void setAccountingCostCode(AccountingCostCodeType value) {
        this.accountingCostCode = value;
    }

    @ManyToOne(targetEntity = AccountingCostType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCOST_CREDITNOTETYP_0")
    public AccountingCostType getAccountingCost() {
        return accountingCost;
    }

    public void setAccountingCost(AccountingCostType value) {
        this.accountingCost = value;
    }

    @ManyToOne(targetEntity = LineCountNumericType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LINECOUNTNUMERIC_CREDITNOTET_0")
    public LineCountNumericType getLineCountNumeric() {
        return lineCountNumeric;
    }

    public void setLineCountNumeric(LineCountNumericType value) {
        this.lineCountNumeric = value;
    }

    @OneToMany(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INVOICEPERIOD_CREDITNOTETYPE_0")
    public List<PeriodEntity> getInvoicePeriod() {
        if (invoicePeriod == null) {
            invoicePeriod = new ArrayList<PeriodEntity>();
        }
        return this.invoicePeriod;
    }

    public void setInvoicePeriod(List<PeriodEntity> invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    @OneToMany(targetEntity = ResponseEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DISCREPANCYRESPONSE_CREDITNO_0")
    public List<ResponseEntity> getDiscrepancyResponse() {
        if (discrepancyResponse == null) {
            discrepancyResponse = new ArrayList<ResponseEntity>();
        }
        return this.discrepancyResponse;
    }

    public void setDiscrepancyResponse(List<ResponseEntity> discrepancyResponse) {
        this.discrepancyResponse = discrepancyResponse;
    }

    @ManyToOne(targetEntity = OrderReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORDERREFERENCE_CREDITNOTETYP_0")
    public OrderReferenceType getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(OrderReferenceType value) {
        this.orderReference = value;
    }

    @OneToMany(targetEntity = BillingReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BILLINGREFERENCE_CREDITNOTET_0")
    public List<BillingReferenceEntity> getBillingReference() {
        if (billingReference == null) {
            billingReference = new ArrayList<BillingReferenceEntity>();
        }
        return this.billingReference;
    }

    public void setBillingReference(List<BillingReferenceEntity> billingReference) {
        this.billingReference = billingReference;
    }

    @OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DESPATCHDOCUMENTREFERENCE_CR_0")
    public List<DocumentReferenceEntity> getDespatchDocumentReference() {
        if (despatchDocumentReference == null) {
            despatchDocumentReference = new ArrayList<DocumentReferenceEntity>();
        }
        return this.despatchDocumentReference;
    }

    public void setDespatchDocumentReference(List<DocumentReferenceEntity> despatchDocumentReference) {
        this.despatchDocumentReference = despatchDocumentReference;
    }

    @OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "RECEIPTDOCUMENTREFERENCE_CRE_0")
    public List<DocumentReferenceEntity> getReceiptDocumentReference() {
        if (receiptDocumentReference == null) {
            receiptDocumentReference = new ArrayList<DocumentReferenceEntity>();
        }
        return this.receiptDocumentReference;
    }

    public void setReceiptDocumentReference(List<DocumentReferenceEntity> receiptDocumentReference) {
        this.receiptDocumentReference = receiptDocumentReference;
    }

    @OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CONTRACTDOCUMENTREFERENCE_CR_0")
    public List<DocumentReferenceEntity> getContractDocumentReference() {
        if (contractDocumentReference == null) {
            contractDocumentReference = new ArrayList<DocumentReferenceEntity>();
        }
        return this.contractDocumentReference;
    }

    public void setContractDocumentReference(List<DocumentReferenceEntity> contractDocumentReference) {
        this.contractDocumentReference = contractDocumentReference;
    }

    @OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ADDITIONALDOCUMENTREFERENCE__1")
    public List<DocumentReferenceEntity> getAdditionalDocumentReference() {
        if (additionalDocumentReference == null) {
            additionalDocumentReference = new ArrayList<DocumentReferenceEntity>();
        }
        return this.additionalDocumentReference;
    }

    public void setAdditionalDocumentReference(List<DocumentReferenceEntity> additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    @OneToMany(targetEntity = SignatureEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SIGNATURE_CREDITNOTETYPE_OFID")
    public List<SignatureEntity> getSignature() {
        if (signature == null) {
            signature = new ArrayList<SignatureEntity>();
        }
        return this.signature;
    }

    public void setSignature(List<SignatureEntity> signature) {
        this.signature = signature;
    }

    @ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGSUPPLIERPARTY_CRED_0")
    public SupplierPartyEntity getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    public void setAccountingSupplierParty(SupplierPartyEntity value) {
        this.accountingSupplierParty = value;
    }

    @ManyToOne(targetEntity = CustomerPartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCUSTOMERPARTY_CRED_0")
    public CustomerPartyType getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    public void setAccountingCustomerParty(CustomerPartyType value) {
        this.accountingCustomerParty = value;
    }

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYEEPARTY_CREDITNOTETYPE_HJ_0")
    public PartyEntity getPayeeParty() {
        return payeeParty;
    }

    public void setPayeeParty(PartyEntity value) {
        this.payeeParty = value;
    }

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXREPRESENTATIVEPARTY_CREDI_0")
    public PartyEntity getTaxRepresentativeParty() {
        return taxRepresentativeParty;
    }

    public void setTaxRepresentativeParty(PartyEntity value) {
        this.taxRepresentativeParty = value;
    }

    @ManyToOne(targetEntity = ExchangeRateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXEXCHANGERATE_CREDITNOTETY_0")
    public ExchangeRateType getTaxExchangeRate() {
        return taxExchangeRate;
    }

    public void setTaxExchangeRate(ExchangeRateType value) {
        this.taxExchangeRate = value;
    }

    @ManyToOne(targetEntity = ExchangeRateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRICINGEXCHANGERATE_CREDITNO_0")
    public ExchangeRateType getPricingExchangeRate() {
        return pricingExchangeRate;
    }

    public void setPricingExchangeRate(ExchangeRateType value) {
        this.pricingExchangeRate = value;
    }

    @ManyToOne(targetEntity = ExchangeRateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTEXCHANGERATE_CREDITNO_0")
    public ExchangeRateType getPaymentExchangeRate() {
        return paymentExchangeRate;
    }

    public void setPaymentExchangeRate(ExchangeRateType value) {
        this.paymentExchangeRate = value;
    }

    @ManyToOne(targetEntity = ExchangeRateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYMENTALTERNATIVEEXCHANGERA_2")
    public ExchangeRateType getPaymentAlternativeExchangeRate() {
        return paymentAlternativeExchangeRate;
    }

    public void setPaymentAlternativeExchangeRate(ExchangeRateType value) {
        this.paymentAlternativeExchangeRate = value;
    }

    @OneToMany(targetEntity = AllowanceChargeEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ALLOWANCECHARGE_CREDITNOTETY_0")
    public List<AllowanceChargeEntity> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<AllowanceChargeEntity>();
        }
        return this.allowanceCharge;
    }

    public void setAllowanceCharge(List<AllowanceChargeEntity> allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

    @OneToMany(targetEntity = TaxTotalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXTOTAL_CREDITNOTETYPE_OFID")
    public List<TaxTotalEntity> getTaxTotal() {
        if (taxTotal == null) {
            taxTotal = new ArrayList<TaxTotalEntity>();
        }
        return this.taxTotal;
    }

    public void setTaxTotal(List<TaxTotalEntity> taxTotal) {
        this.taxTotal = taxTotal;
    }

    @ManyToOne(targetEntity = MonetaryTotalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LEGALMONETARYTOTAL_CREDITNOT_0")
    public MonetaryTotalEntity getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }

    public void setLegalMonetaryTotal(MonetaryTotalEntity value) {
        this.legalMonetaryTotal = value;
    }

    @OneToMany(targetEntity = CreditNoteLineEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CREDITNOTELINE_CREDITNOTETYP_0")
    public List<CreditNoteLineEntity> getCreditNoteLine() {
        if (creditNoteLine == null) {
            creditNoteLine = new ArrayList<CreditNoteLineEntity>();
        }
        return this.creditNoteLine;
    }

    public void setCreditNoteLine(List<CreditNoteLineEntity> creditNoteLine) {
        this.creditNoteLine = creditNoteLine;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}
