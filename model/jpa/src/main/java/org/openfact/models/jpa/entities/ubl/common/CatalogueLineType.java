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

@Entity(name = "CatalogueLineType")
@Table(name = "CATALOGUELINETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class CatalogueLineType {

    protected IDType ID;
    protected ActionCodeType actionCode;
    protected LifeCycleStatusCodeType lifeCycleStatusCode;
    protected ContractSubdivisionType contractSubdivision;
    protected List<NoteType> note;
    protected OrderableIndicatorType orderableIndicator;
    protected OrderableUnitType orderableUnit;
    protected ContentUnitQuantityType contentUnitQuantity;
    protected OrderQuantityIncrementNumericType orderQuantityIncrementNumeric;
    protected MinimumOrderQuantityType minimumOrderQuantity;
    protected MaximumOrderQuantityType maximumOrderQuantity;
    protected List<WarrantyInformationType> warrantyInformation;
    protected PackLevelCodeType packLevelCode;
    protected CustomerPartyType contractorCustomerParty;
    protected SupplierPartyEntity sellerSupplierParty;
    protected PartyEntity warrantyParty;
    protected PeriodEntity warrantyValidityPeriod;
    protected PeriodEntity lineValidityPeriod;
    protected List<ItemComparisonType> itemComparison;
    protected List<RelatedItemType> componentRelatedItem;
    protected List<RelatedItemType> accessoryRelatedItem;
    protected List<RelatedItemType> requiredRelatedItem;
    protected List<RelatedItemType> replacementRelatedItem;
    protected List<RelatedItemType> complementaryRelatedItem;
    protected List<ItemLocationQuantityEntity> requiredItemLocationQuantity;
    protected List<DocumentReferenceEntity> documentReference;
    protected ItemType item;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_CATALOGUELINETYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = ActionCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACTIONCODE_CATALOGUELINETYPE_0")
    public ActionCodeType getActionCode() {
        return actionCode;
    }

    public void setActionCode(ActionCodeType value) {
        this.actionCode = value;
    }

    @ManyToOne(targetEntity = LifeCycleStatusCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LIFECYCLESTATUSCODE_CATALOGU_0")
    public LifeCycleStatusCodeType getLifeCycleStatusCode() {
        return lifeCycleStatusCode;
    }

    public void setLifeCycleStatusCode(LifeCycleStatusCodeType value) {
        this.lifeCycleStatusCode = value;
    }

    @ManyToOne(targetEntity = ContractSubdivisionType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CONTRACTSUBDIVISION_CATALOGU_0")
    public ContractSubdivisionType getContractSubdivision() {
        return contractSubdivision;
    }

    public void setContractSubdivision(ContractSubdivisionType value) {
        this.contractSubdivision = value;
    }

    @OneToMany(targetEntity = NoteType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NOTE_CATALOGUELINETYPE_OFID")
    public List<NoteType> getNote() {
        if (note == null) {
            note = new ArrayList<NoteType>();
        }
        return this.note;
    }

    public void setNote(List<NoteType> note) {
        this.note = note;
    }

    @ManyToOne(targetEntity = OrderableIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORDERABLEINDICATOR_CATALOGUE_0")
    public OrderableIndicatorType getOrderableIndicator() {
        return orderableIndicator;
    }

    public void setOrderableIndicator(OrderableIndicatorType value) {
        this.orderableIndicator = value;
    }

    @ManyToOne(targetEntity = OrderableUnitType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORDERABLEUNIT_CATALOGUELINET_0")
    public OrderableUnitType getOrderableUnit() {
        return orderableUnit;
    }

    public void setOrderableUnit(OrderableUnitType value) {
        this.orderableUnit = value;
    }

    @ManyToOne(targetEntity = ContentUnitQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CONTENTUNITQUANTITY_CATALOGU_0")
    public ContentUnitQuantityType getContentUnitQuantity() {
        return contentUnitQuantity;
    }

    public void setContentUnitQuantity(ContentUnitQuantityType value) {
        this.contentUnitQuantity = value;
    }

    @ManyToOne(targetEntity = OrderQuantityIncrementNumericType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORDERQUANTITYINCREMENTNUMERI_0")
    public OrderQuantityIncrementNumericType getOrderQuantityIncrementNumeric() {
        return orderQuantityIncrementNumeric;
    }

    public void setOrderQuantityIncrementNumeric(OrderQuantityIncrementNumericType value) {
        this.orderQuantityIncrementNumeric = value;
    }

    @ManyToOne(targetEntity = MinimumOrderQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MINIMUMORDERQUANTITY_CATALOG_0")
    public MinimumOrderQuantityType getMinimumOrderQuantity() {
        return minimumOrderQuantity;
    }

    public void setMinimumOrderQuantity(MinimumOrderQuantityType value) {
        this.minimumOrderQuantity = value;
    }

    @ManyToOne(targetEntity = MaximumOrderQuantityType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "MAXIMUMORDERQUANTITY_CATALOG_0")
    public MaximumOrderQuantityType getMaximumOrderQuantity() {
        return maximumOrderQuantity;
    }

    public void setMaximumOrderQuantity(MaximumOrderQuantityType value) {
        this.maximumOrderQuantity = value;
    }

    @OneToMany(targetEntity = WarrantyInformationType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "WARRANTYINFORMATION_CATALOGU_0")
    public List<WarrantyInformationType> getWarrantyInformation() {
        if (warrantyInformation == null) {
            warrantyInformation = new ArrayList<WarrantyInformationType>();
        }
        return this.warrantyInformation;
    }

    public void setWarrantyInformation(List<WarrantyInformationType> warrantyInformation) {
        this.warrantyInformation = warrantyInformation;
    }

    @ManyToOne(targetEntity = PackLevelCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PACKLEVELCODE_CATALOGUELINET_0")
    public PackLevelCodeType getPackLevelCode() {
        return packLevelCode;
    }

    public void setPackLevelCode(PackLevelCodeType value) {
        this.packLevelCode = value;
    }

    @ManyToOne(targetEntity = CustomerPartyType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CONTRACTORCUSTOMERPARTY_CATA_1")
    public CustomerPartyType getContractorCustomerParty() {
        return contractorCustomerParty;
    }

    public void setContractorCustomerParty(CustomerPartyType value) {
        this.contractorCustomerParty = value;
    }

    @ManyToOne(targetEntity = SupplierPartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SELLERSUPPLIERPARTY_CATALOGU_1")
    public SupplierPartyEntity getSellerSupplierParty() {
        return sellerSupplierParty;
    }

    public void setSellerSupplierParty(SupplierPartyEntity value) {
        this.sellerSupplierParty = value;
    }

    @ManyToOne(targetEntity = PartyEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "WARRANTYPARTY_CATALOGUELINET_0")
    public PartyEntity getWarrantyParty() {
        return warrantyParty;
    }

    public void setWarrantyParty(PartyEntity value) {
        this.warrantyParty = value;
    }

    @ManyToOne(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "WARRANTYVALIDITYPERIOD_CATAL_0")
    public PeriodEntity getWarrantyValidityPeriod() {
        return warrantyValidityPeriod;
    }

    public void setWarrantyValidityPeriod(PeriodEntity value) {
        this.warrantyValidityPeriod = value;
    }

    @ManyToOne(targetEntity = PeriodEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LINEVALIDITYPERIOD_CATALOGUE_0")
    public PeriodEntity getLineValidityPeriod() {
        return lineValidityPeriod;
    }

    public void setLineValidityPeriod(PeriodEntity value) {
        this.lineValidityPeriod = value;
    }

    @OneToMany(targetEntity = ItemComparisonType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ITEMCOMPARISON_CATALOGUELINE_0")
    public List<ItemComparisonType> getItemComparison() {
        if (itemComparison == null) {
            itemComparison = new ArrayList<ItemComparisonType>();
        }
        return this.itemComparison;
    }

    public void setItemComparison(List<ItemComparisonType> itemComparison) {
        this.itemComparison = itemComparison;
    }

    @OneToMany(targetEntity = RelatedItemType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "COMPONENTRELATEDITEM_CATALOG_0")
    public List<RelatedItemType> getComponentRelatedItem() {
        if (componentRelatedItem == null) {
            componentRelatedItem = new ArrayList<RelatedItemType>();
        }
        return this.componentRelatedItem;
    }

    public void setComponentRelatedItem(List<RelatedItemType> componentRelatedItem) {
        this.componentRelatedItem = componentRelatedItem;
    }

    @OneToMany(targetEntity = RelatedItemType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ACCESSORYRELATEDITEM_CATALOG_0")
    public List<RelatedItemType> getAccessoryRelatedItem() {
        if (accessoryRelatedItem == null) {
            accessoryRelatedItem = new ArrayList<RelatedItemType>();
        }
        return this.accessoryRelatedItem;
    }

    public void setAccessoryRelatedItem(List<RelatedItemType> accessoryRelatedItem) {
        this.accessoryRelatedItem = accessoryRelatedItem;
    }

    @OneToMany(targetEntity = RelatedItemType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REQUIREDRELATEDITEM_CATALOGU_0")
    public List<RelatedItemType> getRequiredRelatedItem() {
        if (requiredRelatedItem == null) {
            requiredRelatedItem = new ArrayList<RelatedItemType>();
        }
        return this.requiredRelatedItem;
    }

    public void setRequiredRelatedItem(List<RelatedItemType> requiredRelatedItem) {
        this.requiredRelatedItem = requiredRelatedItem;
    }

    @OneToMany(targetEntity = RelatedItemType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REPLACEMENTRELATEDITEM_CATAL_0")
    public List<RelatedItemType> getReplacementRelatedItem() {
        if (replacementRelatedItem == null) {
            replacementRelatedItem = new ArrayList<RelatedItemType>();
        }
        return this.replacementRelatedItem;
    }

    public void setReplacementRelatedItem(List<RelatedItemType> replacementRelatedItem) {
        this.replacementRelatedItem = replacementRelatedItem;
    }

    @OneToMany(targetEntity = RelatedItemType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "COMPLEMENTARYRELATEDITEM_CAT_0")
    public List<RelatedItemType> getComplementaryRelatedItem() {
        if (complementaryRelatedItem == null) {
            complementaryRelatedItem = new ArrayList<RelatedItemType>();
        }
        return this.complementaryRelatedItem;
    }

    public void setComplementaryRelatedItem(List<RelatedItemType> complementaryRelatedItem) {
        this.complementaryRelatedItem = complementaryRelatedItem;
    }

    @OneToMany(targetEntity = ItemLocationQuantityEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REQUIREDITEMLOCATIONQUANTITY_0")
    public List<ItemLocationQuantityEntity> getRequiredItemLocationQuantity() {
        if (requiredItemLocationQuantity == null) {
            requiredItemLocationQuantity = new ArrayList<ItemLocationQuantityEntity>();
        }
        return this.requiredItemLocationQuantity;
    }

    public void setRequiredItemLocationQuantity(List<ItemLocationQuantityEntity> requiredItemLocationQuantity) {
        this.requiredItemLocationQuantity = requiredItemLocationQuantity;
    }

    @OneToMany(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DOCUMENTREFERENCE_CATALOGUEL_0")
    public List<DocumentReferenceEntity> getDocumentReference() {
        if (documentReference == null) {
            documentReference = new ArrayList<DocumentReferenceEntity>();
        }
        return this.documentReference;
    }

    public void setDocumentReference(List<DocumentReferenceEntity> documentReference) {
        this.documentReference = documentReference;
    }

    @ManyToOne(targetEntity = ItemType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ITEM_CATALOGUELINETYPE_OFID")
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
