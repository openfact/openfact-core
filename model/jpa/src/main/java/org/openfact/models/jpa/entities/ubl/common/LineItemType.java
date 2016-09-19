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

@Entity(name = "LineItemType")
@Table(name = "LINEITEMTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class LineItemType {

    protected IDType ID;
    protected SalesOrderIDType salesOrderID;
    protected UUIDType uuid;
    protected NoteType note;
    protected LineStatusCodeTypeCommBas lineStatusCode;
    protected QuantityTypeCommBas quantity;
    protected LineExtensionAmountType lineExtensionAmount;
    protected TotalTaxAmountType totalTaxAmount;
    protected MinimumQuantityType minimumQuantity;
    protected MaximumQuantityType maximumQuantity;
    protected MinimumBackorderQuantityType minimumBackorderQuantity;
    protected MaximumBackorderQuantityType maximumBackorderQuantity;
    protected InspectionMethodCodeType inspectionMethodCode;
    protected PartialDeliveryIndicatorType partialDeliveryIndicator;
    protected BackOrderAllowedIndicatorType backOrderAllowedIndicator;
    protected AccountingCostCodeType accountingCostCode;
    protected AccountingCostType accountingCost;
    protected List<DeliveryEntity> delivery;
    protected DeliveryTermsType deliveryTerms;
    protected PartyEntity originatorParty;
    protected List<OrderedShipmentType> orderedShipment;
    protected PricingReferenceEntity pricingReference;
    protected List<AllowanceChargeEntity> allowanceCharge;
    protected PriceEntity price;
    protected ItemType item;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_LINEITEMTYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = SalesOrderIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SALESORDERID_LINEITEMTYPE_HJ_0")
    public SalesOrderIDType getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(SalesOrderIDType value) {
        this.salesOrderID = value;
    }

    @ManyToOne(targetEntity = UUIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UUID_LINEITEMTYPE_OFID")
    public UUIDType getUUID() {
        return uuid;
    }

    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    @ManyToOne(targetEntity = NoteType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NOTE_LINEITEMTYPE_OFID")
    public NoteType getNote() {
        return note;
    }

    public void setNote(NoteType value) {
        this.note = value;
    }

    @ManyToOne(targetEntity = LineStatusCodeTypeCommBas.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LINESTATUSCODE_LINEITEMTYPE__0")
    public LineStatusCodeTypeCommBas getLineStatusCode() {
        return lineStatusCode;
    }

    public void setLineStatusCode(LineStatusCodeTypeCommBas value) {
        this.lineStatusCode = value;
    }

    @ManyToOne(targetEntity = QuantityTypeCommBas.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "QUANTITY_LINEITEMTYPE_OFID")
    public QuantityTypeCommBas getQuantity() {
        return quantity;
    }

    public void setQuantity(QuantityTypeCommBas value) {
        this.quantity = value;
    }

    @ManyToOne(targetEntity = LineExtensionAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LINEEXTENSIONAMOUNT_LINEITEM_0")
    public LineExtensionAmountType getLineExtensionAmount() {
        return lineExtensionAmount;
    }

    public void setLineExtensionAmount(LineExtensionAmountType value) {
        this.lineExtensionAmount = value;
    }

    @ManyToOne(targetEntity = TotalTaxAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TOTALTAXAMOUNT_LINEITEMTYPE__0")
    public TotalTaxAmountType getTotalTaxAmount() {
        return totalTaxAmount;
    }

    public void setTotalTaxAmount(TotalTaxAmountType value) {
        this.totalTaxAmount = value;
    }

    @ManyToOne(targetEntity = MinimumQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MINIMUMQUANTITY_LINEITEMTYPE_0")
    public MinimumQuantityType getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(MinimumQuantityType value) {
        this.minimumQuantity = value;
    }

    @ManyToOne(targetEntity = MaximumQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MAXIMUMQUANTITY_LINEITEMTYPE_0")
    public MaximumQuantityType getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(MaximumQuantityType value) {
        this.maximumQuantity = value;
    }

    @ManyToOne(targetEntity = MinimumBackorderQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MINIMUMBACKORDERQUANTITY_LIN_0")
    public MinimumBackorderQuantityType getMinimumBackorderQuantity() {
        return minimumBackorderQuantity;
    }

    public void setMinimumBackorderQuantity(MinimumBackorderQuantityType value) {
        this.minimumBackorderQuantity = value;
    }

    @ManyToOne(targetEntity = MaximumBackorderQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MAXIMUMBACKORDERQUANTITY_LIN_0")
    public MaximumBackorderQuantityType getMaximumBackorderQuantity() {
        return maximumBackorderQuantity;
    }

    public void setMaximumBackorderQuantity(MaximumBackorderQuantityType value) {
        this.maximumBackorderQuantity = value;
    }

    @ManyToOne(targetEntity = InspectionMethodCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INSPECTIONMETHODCODE_LINEITE_0")
    public InspectionMethodCodeType getInspectionMethodCode() {
        return inspectionMethodCode;
    }

    public void setInspectionMethodCode(InspectionMethodCodeType value) {
        this.inspectionMethodCode = value;
    }

    @ManyToOne(targetEntity = PartialDeliveryIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PARTIALDELIVERYINDICATOR_LIN_0")
    public PartialDeliveryIndicatorType getPartialDeliveryIndicator() {
        return partialDeliveryIndicator;
    }

    public void setPartialDeliveryIndicator(PartialDeliveryIndicatorType value) {
        this.partialDeliveryIndicator = value;
    }

    @ManyToOne(targetEntity = BackOrderAllowedIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "BACKORDERALLOWEDINDICATOR_LI_0")
    public BackOrderAllowedIndicatorType getBackOrderAllowedIndicator() {
        return backOrderAllowedIndicator;
    }

    public void setBackOrderAllowedIndicator(BackOrderAllowedIndicatorType value) {
        this.backOrderAllowedIndicator = value;
    }

    @ManyToOne(targetEntity = AccountingCostCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCOSTCODE_LINEITEMT_0")
    public AccountingCostCodeType getAccountingCostCode() {
        return accountingCostCode;
    }

    public void setAccountingCostCode(AccountingCostCodeType value) {
        this.accountingCostCode = value;
    }

    @ManyToOne(targetEntity = AccountingCostType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCOUNTINGCOST_LINEITEMTYPE__0")
    public AccountingCostType getAccountingCost() {
        return accountingCost;
    }

    public void setAccountingCost(AccountingCostType value) {
        this.accountingCost = value;
    }

    @OneToMany(targetEntity = DeliveryEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERY_LINEITEMTYPE_OFID")
    public List<DeliveryEntity> getDelivery() {
        if (delivery == null) {
            delivery = new ArrayList<DeliveryEntity>();
        }
        return this.delivery;
    }

    public void setDelivery(List<DeliveryEntity> delivery) {
        this.delivery = delivery;
    }

    @ManyToOne(targetEntity = DeliveryTermsType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DELIVERYTERMS_LINEITEMTYPE_H_0")
    public DeliveryTermsType getDeliveryTerms() {
        return deliveryTerms;
    }

    public void setDeliveryTerms(DeliveryTermsType value) {
        this.deliveryTerms = value;
    }

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINATORPARTY_LINEITEMTYPE_0")
    public PartyEntity getOriginatorParty() {
        return originatorParty;
    }

    public void setOriginatorParty(PartyEntity value) {
        this.originatorParty = value;
    }

    @OneToMany(targetEntity = OrderedShipmentType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORDEREDSHIPMENT_LINEITEMTYPE_0")
    public List<OrderedShipmentType> getOrderedShipment() {
        if (orderedShipment == null) {
            orderedShipment = new ArrayList<OrderedShipmentType>();
        }
        return this.orderedShipment;
    }

    public void setOrderedShipment(List<OrderedShipmentType> orderedShipment) {
        this.orderedShipment = orderedShipment;
    }

    @ManyToOne(targetEntity = PricingReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRICINGREFERENCE_LINEITEMTYP_0")
    public PricingReferenceEntity getPricingReference() {
        return pricingReference;
    }

    public void setPricingReference(PricingReferenceEntity value) {
        this.pricingReference = value;
    }

    @OneToMany(targetEntity = AllowanceChargeEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ALLOWANCECHARGE_LINEITEMTYPE_0")
    public List<AllowanceChargeEntity> getAllowanceCharge() {
        if (allowanceCharge == null) {
            allowanceCharge = new ArrayList<AllowanceChargeEntity>();
        }
        return this.allowanceCharge;
    }

    public void setAllowanceCharge(List<AllowanceChargeEntity> allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

    @ManyToOne(targetEntity = PriceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRICE_LINEITEMTYPE_OFID")
    public PriceEntity getPrice() {
        return price;
    }

    public void setPrice(PriceEntity value) {
        this.price = value;
    }

    @ManyToOne(targetEntity = ItemType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ITEM_LINEITEMTYPE_OFID")
    public ItemType getItem() {
        return item;
    }

    public void setItem(ItemType value) {
        this.item = value;
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
