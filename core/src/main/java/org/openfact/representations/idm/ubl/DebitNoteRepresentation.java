package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.common.BillingReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.CustomerPartyRepresentation;
import org.openfact.representations.idm.ubl.common.DebitNoteLineRepresentation;
import org.openfact.representations.idm.ubl.common.DocumentReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.ExchangeRateRepresentation;
import org.openfact.representations.idm.ubl.common.MonetaryTotalRepresentation;
import org.openfact.representations.idm.ubl.common.OrderReferenceRepresentation;
import org.openfact.representations.idm.ubl.common.PartyRepresentation;
import org.openfact.representations.idm.ubl.common.PaymentRepresentation;
import org.openfact.representations.idm.ubl.common.PeriodRepresentation;
import org.openfact.representations.idm.ubl.common.ResponseRepresentation;
import org.openfact.representations.idm.ubl.common.SignatureRepresentation;
import org.openfact.representations.idm.ubl.common.SupplierPartyRepresentation;
import org.openfact.representations.idm.ubl.common.TaxTotalRepresentation;
import org.openfact.representations.idm.ubl.common.UBLExtensionsRepresentation;

public class DebitNoteRepresentation {
    private UBLExtensionsRepresentation ublExtensions;
    private String ublVersionID;
    private String customizationID;
    private String profileID;
    private String idUbl;
    private Boolean copyIndicator;
    private String uuid;
    private LocalDate issueDate;
    private LocalTime issueTime;
    private List<String> note;
    private LocalDate taxPointDate;
    private String documentCurrencyCode;
    private String taxCurrencyCode;
    private String pricingCurrencyCode;
    private String paymentCurrencyCode;
    private String paymentAlternativeCurrencyCode;
    private String accountingCostCode;
    private String accountingCost;
    private BigDecimal lineCountNumeric;
    private List<PeriodRepresentation> invoicePeriod;
    private List<ResponseRepresentation> discrepancyResponse;
    private OrderReferenceRepresentation orderReference;
    private List<BillingReferenceRepresentation> billingReference;
    private List<DocumentReferenceRepresentation> despatchDocumentReference;
    private List<DocumentReferenceRepresentation> receiptDocumentReference;
    private List<DocumentReferenceRepresentation> contractDocumentReference;
    private List<DocumentReferenceRepresentation> additionalDocumentReference;
    private List<SignatureRepresentation> signature;
    private SupplierPartyRepresentation accountingSupplierParty;
    private CustomerPartyRepresentation accountingCustomerParty;
    private PartyRepresentation payeeParty;
    private PartyRepresentation taxRepresentativeParty;
    private List<PaymentRepresentation> prepaidPayment;
    private ExchangeRateRepresentation taxExchangeRate;
    private ExchangeRateRepresentation pricingExchangeRate;
    private ExchangeRateRepresentation paymentExchangeRate;
    private ExchangeRateRepresentation paymentAlternativeExchangeRate;
    private List<TaxTotalRepresentation> taxTotal;
    private MonetaryTotalRepresentation requestedMonetaryTotal;
    private List<DebitNoteLineRepresentation> debitNoteLine;
    private String id;

    /**
     * Custom methods
     */
    public void addNote(String representation) {
        if (note == null) {
            note = new ArrayList<>();
        }
        note.add(representation);
    }

    public void addSignature(SignatureRepresentation representation) {
        if (signature == null) {
            signature = new ArrayList<>();
        }
        signature.add(representation);
    }

    public void addPrepaidPayment(PaymentRepresentation representation) {
        if (prepaidPayment == null) {
            prepaidPayment = new ArrayList<>();
        }
        prepaidPayment.add(representation);
    }

    public void addInvoicePeriod(PeriodRepresentation representation) {
        if (invoicePeriod == null) {
            invoicePeriod = new ArrayList<>();
        }
        invoicePeriod.add(representation);
    }

    public void addDiscrepancyResponse(ResponseRepresentation representation) {
        if (discrepancyResponse == null) {
            discrepancyResponse = new ArrayList<>();
        }
        discrepancyResponse.add(representation);
    }

    public void addDebitNoteLine(DebitNoteLineRepresentation representation) {
        if (debitNoteLine == null) {
            debitNoteLine = new ArrayList<>();
        }
        debitNoteLine.add(representation);
    }

    public void addTaxTotal(TaxTotalRepresentation representation) {
        if (taxTotal == null) {
            taxTotal = new ArrayList<>();
        }
        taxTotal.add(representation);
    }

    public void addBillingReference(BillingReferenceRepresentation representation) {
        if (billingReference == null) {
            billingReference = new ArrayList<>();
        }
        billingReference.add(representation);
    }

    public void addDespatchDocumentReference(DocumentReferenceRepresentation representation) {
        if (despatchDocumentReference == null) {
            despatchDocumentReference = new ArrayList<>();
        }
        despatchDocumentReference.add(representation);
    }

    public void addReceiptDocumentReference(DocumentReferenceRepresentation representation) {
        if (receiptDocumentReference == null) {
            receiptDocumentReference = new ArrayList<>();
        }
        receiptDocumentReference.add(representation);
    }

    public void addContractDocumentReference(DocumentReferenceRepresentation representation) {
        if (contractDocumentReference == null) {
            contractDocumentReference = new ArrayList<>();
        }
        contractDocumentReference.add(representation);
    }

    public void addAdditionalDocumentReference(DocumentReferenceRepresentation representation) {
        if (additionalDocumentReference == null) {
            additionalDocumentReference = new ArrayList<>();
        }
        additionalDocumentReference.add(representation);
    }

    /**
     * Getter and Setter
     */
    public UBLExtensionsRepresentation getUblExtensions() {
        return ublExtensions;
    }

    public void setUblExtensions(UBLExtensionsRepresentation ublExtensions) {
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

    public String getIdUbl() {
        return idUbl;
    }

    public void setIdUbl(String idUbl) {
        this.idUbl = idUbl;
    }

    public Boolean getCopyIndicator() {
        return copyIndicator;
    }

    public void setCopyIndicator(Boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalTime getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
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

    public List<PeriodRepresentation> getInvoicePeriod() {
        return invoicePeriod;
    }

    public void setInvoicePeriod(List<PeriodRepresentation> invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    public List<ResponseRepresentation> getDiscrepancyResponse() {
        return discrepancyResponse;
    }

    public void setDiscrepancyResponse(List<ResponseRepresentation> discrepancyResponse) {
        this.discrepancyResponse = discrepancyResponse;
    }

    public OrderReferenceRepresentation getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(OrderReferenceRepresentation orderReference) {
        this.orderReference = orderReference;
    }

    public List<BillingReferenceRepresentation> getBillingReference() {
        return billingReference;
    }

    public void setBillingReference(List<BillingReferenceRepresentation> billingReference) {
        this.billingReference = billingReference;
    }

    public List<DocumentReferenceRepresentation> getDespatchDocumentReference() {
        return despatchDocumentReference;
    }

    public void setDespatchDocumentReference(
            List<DocumentReferenceRepresentation> despatchDocumentReference) {
        this.despatchDocumentReference = despatchDocumentReference;
    }

    public List<DocumentReferenceRepresentation> getReceiptDocumentReference() {
        return receiptDocumentReference;
    }

    public void setReceiptDocumentReference(List<DocumentReferenceRepresentation> receiptDocumentReference) {
        this.receiptDocumentReference = receiptDocumentReference;
    }

    public List<DocumentReferenceRepresentation> getContractDocumentReference() {
        return contractDocumentReference;
    }

    public void setContractDocumentReference(
            List<DocumentReferenceRepresentation> contractDocumentReference) {
        this.contractDocumentReference = contractDocumentReference;
    }

    public List<DocumentReferenceRepresentation> getAdditionalDocumentReference() {
        return additionalDocumentReference;
    }

    public void setAdditionalDocumentReference(
            List<DocumentReferenceRepresentation> additionalDocumentReference) {
        this.additionalDocumentReference = additionalDocumentReference;
    }

    public List<SignatureRepresentation> getSignature() {
        return signature;
    }

    public void setSignature(List<SignatureRepresentation> signature) {
        this.signature = signature;
    }

    public SupplierPartyRepresentation getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    public void setAccountingSupplierParty(SupplierPartyRepresentation accountingSupplierParty) {
        this.accountingSupplierParty = accountingSupplierParty;
    }

    public CustomerPartyRepresentation getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    public void setAccountingCustomerParty(CustomerPartyRepresentation accountingCustomerParty) {
        this.accountingCustomerParty = accountingCustomerParty;
    }

    public PartyRepresentation getPayeeParty() {
        return payeeParty;
    }

    public void setPayeeParty(PartyRepresentation payeeParty) {
        this.payeeParty = payeeParty;
    }

    public PartyRepresentation getTaxRepresentativeParty() {
        return taxRepresentativeParty;
    }

    public void setTaxRepresentativeParty(PartyRepresentation taxRepresentativeParty) {
        this.taxRepresentativeParty = taxRepresentativeParty;
    }

    public List<PaymentRepresentation> getPrepaidPayment() {
        return prepaidPayment;
    }

    public void setPrepaidPayment(List<PaymentRepresentation> prepaidPayment) {
        this.prepaidPayment = prepaidPayment;
    }

    public ExchangeRateRepresentation getTaxExchangeRate() {
        return taxExchangeRate;
    }

    public void setTaxExchangeRate(ExchangeRateRepresentation taxExchangeRate) {
        this.taxExchangeRate = taxExchangeRate;
    }

    public ExchangeRateRepresentation getPricingExchangeRate() {
        return pricingExchangeRate;
    }

    public void setPricingExchangeRate(ExchangeRateRepresentation pricingExchangeRate) {
        this.pricingExchangeRate = pricingExchangeRate;
    }

    public ExchangeRateRepresentation getPaymentExchangeRate() {
        return paymentExchangeRate;
    }

    public void setPaymentExchangeRate(ExchangeRateRepresentation paymentExchangeRate) {
        this.paymentExchangeRate = paymentExchangeRate;
    }

    public ExchangeRateRepresentation getPaymentAlternativeExchangeRate() {
        return paymentAlternativeExchangeRate;
    }

    public void setPaymentAlternativeExchangeRate(ExchangeRateRepresentation paymentAlternativeExchangeRate) {
        this.paymentAlternativeExchangeRate = paymentAlternativeExchangeRate;
    }

    public List<TaxTotalRepresentation> getTaxTotal() {
        return taxTotal;
    }

    public void setTaxTotal(List<TaxTotalRepresentation> taxTotal) {
        this.taxTotal = taxTotal;
    }

    public MonetaryTotalRepresentation getRequestedMonetaryTotal() {
        return requestedMonetaryTotal;
    }

    public void setRequestedMonetaryTotal(MonetaryTotalRepresentation requestedMonetaryTotal) {
        this.requestedMonetaryTotal = requestedMonetaryTotal;
    }

    public List<DebitNoteLineRepresentation> getDebitNoteLine() {
        return debitNoteLine;
    }

    public void setDebitNoteLine(List<DebitNoteLineRepresentation> debitNoteLine) {
        this.debitNoteLine = debitNoteLine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter and setters
     */

}