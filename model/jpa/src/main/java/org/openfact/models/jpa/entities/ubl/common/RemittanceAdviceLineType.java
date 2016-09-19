//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

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

@Entity(name = "RemittanceAdviceLineType")
@Table(name = "REMITTANCEADVICELINETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class RemittanceAdviceLineType {

    protected IDType ID;
    protected NoteType note;
    protected UUIDType uuid;
    protected DebitLineAmountType debitLineAmount;
    protected CreditLineAmountType creditLineAmount;
    protected BalanceAmountType balanceAmount;
    protected SupplierPartyEntity accountingSupplierParty;
    protected CustomerPartyType accountingCustomerParty;
    protected CustomerPartyType buyerCustomerParty;
    protected SupplierPartyEntity sellerSupplierParty;
    protected CustomerPartyType originatorCustomerParty;
    protected PartyEntity payeeParty;
    protected List<PeriodEntity> invoicePeriod;
    protected List<BillingReferenceEntity> billingReference;
    protected List<DocumentReferenceEntity> documentReference;
    protected ExchangeRateType exchangeRate;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_REMITTANCEADVICELINETYPE__0")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = NoteType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NOTE_REMITTANCEADVICELINETYP_0")
    public NoteType getNote() {
        return note;
    }

    public void setNote(NoteType value) {
        this.note = value;
    }

    @ManyToOne(targetEntity = UUIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UUID_REMITTANCEADVICELINETYP_0")
    public UUIDType getUUID() {
        return uuid;
    }

    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    @ManyToOne(targetEntity = DebitLineAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DEBITLINEAMOUNT_REMITTANCEAD_0")
    public DebitLineAmountType getDebitLineAmount() {
        return debitLineAmount;
    }

    public void setDebitLineAmount(DebitLineAmountType value) {
        this.debitLineAmount = value;
    }

    @ManyToOne(targetEntity = CreditLineAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CREDITLINEAMOUNT_REMITTANCEA_0")
    public CreditLineAmountType getCreditLineAmount() {
        return creditLineAmount;
    }

    public void setCreditLineAmount(CreditLineAmountType value) {
        this.creditLineAmount = value;
    }

    @ManyToOne(targetEntity = BalanceAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BALANCEAMOUNT_REMITTANCEADVI_0")
    public BalanceAmountType getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BalanceAmountType value) {
        this.balanceAmount = value;
    }

    @ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGSUPPLIERPARTY_REMI_0")
    public SupplierPartyEntity getAccountingSupplierParty() {
        return accountingSupplierParty;
    }

    public void setAccountingSupplierParty(SupplierPartyEntity value) {
        this.accountingSupplierParty = value;
    }

    @ManyToOne(targetEntity = CustomerPartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCUSTOMERPARTY_REMI_0")
    public CustomerPartyType getAccountingCustomerParty() {
        return accountingCustomerParty;
    }

    public void setAccountingCustomerParty(CustomerPartyType value) {
        this.accountingCustomerParty = value;
    }

    @ManyToOne(targetEntity = CustomerPartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BUYERCUSTOMERPARTY_REMITTANC_0")
    public CustomerPartyType getBuyerCustomerParty() {
        return buyerCustomerParty;
    }

    public void setBuyerCustomerParty(CustomerPartyType value) {
        this.buyerCustomerParty = value;
    }

    @ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SELLERSUPPLIERPARTY_REMITTAN_0")
    public SupplierPartyEntity getSellerSupplierParty() {
        return sellerSupplierParty;
    }

    public void setSellerSupplierParty(SupplierPartyEntity value) {
        this.sellerSupplierParty = value;
    }

    @ManyToOne(targetEntity = CustomerPartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINATORCUSTOMERPARTY_REMI_0")
    public CustomerPartyType getOriginatorCustomerParty() {
        return originatorCustomerParty;
    }

    public void setOriginatorCustomerParty(CustomerPartyType value) {
        this.originatorCustomerParty = value;
    }

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYEEPARTY_REMITTANCEADVICEL_0")
    public PartyEntity getPayeeParty() {
        return payeeParty;
    }

    public void setPayeeParty(PartyEntity value) {
        this.payeeParty = value;
    }

    @OneToMany(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INVOICEPERIOD_REMITTANCEADVI_0")
    public List<PeriodEntity> getInvoicePeriod() {
        if (invoicePeriod == null) {
            invoicePeriod = new ArrayList<PeriodEntity>();
        }
        return this.invoicePeriod;
    }

    public void setInvoicePeriod(List<PeriodEntity> invoicePeriod) {
        this.invoicePeriod = invoicePeriod;
    }

    @OneToMany(targetEntity = BillingReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BILLINGREFERENCE_REMITTANCEA_0")
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
    @JoinColumn(name = "DOCUMENTREFERENCE_REMITTANCE_0")
    public List<DocumentReferenceEntity> getDocumentReference() {
        if (documentReference == null) {
            documentReference = new ArrayList<DocumentReferenceEntity>();
        }
        return this.documentReference;
    }

    public void setDocumentReference(List<DocumentReferenceEntity> documentReference) {
        this.documentReference = documentReference;
    }

    @ManyToOne(targetEntity = ExchangeRateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "EXCHANGERATE_REMITTANCEADVIC_0")
    public ExchangeRateType getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(ExchangeRateType value) {
        this.exchangeRate = value;
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
