//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

import java.time.LocalDate;
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

@Entity(name = "CreditNoteLineType")
@Table(name = "CREDITNOTELINETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class CreditNoteLineEntity {

    protected String ID;
    protected String uuid;
    protected String note;
    protected QuantityEntity creditedQuantity;
    protected LineExtensionAmountType lineExtensionAmount;
    protected LocalDate taxPointDate;
    protected AccountingCostCodeType accountingCostCode;
    protected AccountingCostType accountingCost;
    protected List<ResponseEntity> discrepancyResponse;
    protected List<LineReferenceType> despatchLineReference;
    protected List<LineReferenceType> receiptLineReference;
    protected List<BillingReferenceEntity> billingReference;
    protected List<DocumentReferenceEntity> documentReference;
    protected PricingReferenceEntity pricingReference;
    protected List<DeliveryEntity> delivery;
    protected List<TaxTotalEntity> taxTotal;
    protected ItemType item;
    protected PriceEntity price;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_CREDITNOTELINETYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = UUIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UUID_CREDITNOTELINETYPE_OFID")
    public UUIDType getUUID() {
        return uuid;
    }

    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    @ManyToOne(targetEntity = NoteType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NOTE_CREDITNOTELINETYPE_OFID")
    public NoteType getNote() {
        return note;
    }

    public void setNote(NoteType value) {
        this.note = value;
    }

    @ManyToOne(targetEntity = CreditedQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CREDITEDQUANTITY_CREDITNOTEL_0")
    public CreditedQuantityType getCreditedQuantity() {
        return creditedQuantity;
    }

    public void setCreditedQuantity(CreditedQuantityType value) {
        this.creditedQuantity = value;
    }

    @ManyToOne(targetEntity = LineExtensionAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LINEEXTENSIONAMOUNT_CREDITNO_0")
    public LineExtensionAmountType getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public void setLineExtensionAmount(LineExtensionAmountType value) {
        this.lineExtensionAmount = value;
    }

    @ManyToOne(targetEntity = TaxPointDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXPOINTDATE_CREDITNOTELINET_0")
    public TaxPointDateType getTaxPointDate() {
        return taxPointDate;
    }

    public void setTaxPointDate(TaxPointDateType value) {
        this.taxPointDate = value;
    }

    @ManyToOne(targetEntity = AccountingCostCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCOSTCODE_CREDITNOT_1")
    public AccountingCostCodeType getAccountingCostCode() {
        return accountingCostCode;
    }

    public void setAccountingCostCode(AccountingCostCodeType value) {
        this.accountingCostCode = value;
    }

    @ManyToOne(targetEntity = AccountingCostType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCOST_CREDITNOTELIN_0")
    public AccountingCostType getAccountingCost() {
        return accountingCost;
    }

    public void setAccountingCost(AccountingCostType value) {
        this.accountingCost = value;
    }

    @OneToMany(targetEntity = ResponseEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DISCREPANCYRESPONSE_CREDITNO_1")
    public List<ResponseEntity> getDiscrepancyResponse() {
        if (discrepancyResponse == null) {
            discrepancyResponse = new ArrayList<ResponseEntity>();
        }
        return this.discrepancyResponse;
    }

    public void setDiscrepancyResponse(List<ResponseEntity> discrepancyResponse) {
        this.discrepancyResponse = discrepancyResponse;
    }

    @OneToMany(targetEntity = LineReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DESPATCHLINEREFERENCE_CREDIT_0")
    public List<LineReferenceType> getDespatchLineReference() {
        if (despatchLineReference == null) {
            despatchLineReference = new ArrayList<LineReferenceType>();
        }
        return this.despatchLineReference;
    }

    public void setDespatchLineReference(List<LineReferenceType> despatchLineReference) {
        this.despatchLineReference = despatchLineReference;
    }

    @OneToMany(targetEntity = LineReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "RECEIPTLINEREFERENCE_CREDITN_0")
    public List<LineReferenceType> getReceiptLineReference() {
        if (receiptLineReference == null) {
            receiptLineReference = new ArrayList<LineReferenceType>();
        }
        return this.receiptLineReference;
    }

    public void setReceiptLineReference(List<LineReferenceType> receiptLineReference) {
        this.receiptLineReference = receiptLineReference;
    }

    @OneToMany(targetEntity = BillingReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BILLINGREFERENCE_CREDITNOTEL_0")
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
    @JoinColumn(name = "DOCUMENTREFERENCE_CREDITNOTE_0")
    public List<DocumentReferenceEntity> getDocumentReference() {
        if (documentReference == null) {
            documentReference = new ArrayList<DocumentReferenceEntity>();
        }
        return this.documentReference;
    }

    public void setDocumentReference(List<DocumentReferenceEntity> documentReference) {
        this.documentReference = documentReference;
    }

    @ManyToOne(targetEntity = PricingReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRICINGREFERENCE_CREDITNOTEL_0")
    public PricingReferenceEntity getPricingReference() {
        return pricingReference;
    }

    public void setPricingReference(PricingReferenceEntity value) {
        this.pricingReference = value;
    }

    @OneToMany(targetEntity = DeliveryEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERY_CREDITNOTELINETYPE__0")
    public List<DeliveryEntity> getDelivery() {
        if (delivery == null) {
            delivery = new ArrayList<DeliveryEntity>();
        }
        return this.delivery;
    }

    public void setDelivery(List<DeliveryEntity> delivery) {
        this.delivery = delivery;
    }

    @OneToMany(targetEntity = TaxTotalEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TAXTOTAL_CREDITNOTELINETYPE__0")
    public List<TaxTotalEntity> getTaxTotal() {
        if (taxTotal == null) {
            taxTotal = new ArrayList<TaxTotalEntity>();
        }
        return this.taxTotal;
    }

    public void setTaxTotal(List<TaxTotalEntity> taxTotal) {
        this.taxTotal = taxTotal;
    }

    @ManyToOne(targetEntity = ItemType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ITEM_CREDITNOTELINETYPE_OFID")
    public ItemType getItem() {
        return item;
    }

    public void setItem(ItemType value) {
        this.item = value;
    }

    @ManyToOne(targetEntity = PriceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRICE_CREDITNOTELINETYPE_OFID")
    public PriceEntity getPrice() {
        return price;
    }

    public void setPrice(PriceEntity value) {
        this.price = value;
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
