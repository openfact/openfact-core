//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "CardAccountType")
@Table(name = "CARDACCOUNTTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class CardAccountType {

    protected PrimaryAccountNumberIDType primaryAccountNumberID;
    protected NetworkIDType networkID;
    protected CardTypeCodeType cardTypeCode;
    protected ValidityStartDateType validityStartDate;
    protected ExpiryDateType expiryDate;
    protected IssuerIDType issuerID;
    protected IssueNumberIDType issueNumberID;
    protected CV2IDType cv2ID;
    protected CardChipCodeType cardChipCode;
    protected ChipApplicationIDType chipApplicationID;
    protected HolderNameType holderName;
    protected String id;

    @ManyToOne(targetEntity = PrimaryAccountNumberIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PRIMARYACCOUNTNUMBERID_CARDA_0")
    public PrimaryAccountNumberIDType getPrimaryAccountNumberID() {
        return primaryAccountNumberID;
    }

    public void setPrimaryAccountNumberID(PrimaryAccountNumberIDType value) {
        this.primaryAccountNumberID = value;
    }

    @ManyToOne(targetEntity = NetworkIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NETWORKID_CARDACCOUNTTYPE_HJ_0")
    public NetworkIDType getNetworkID() {
        return networkID;
    }

    public void setNetworkID(NetworkIDType value) {
        this.networkID = value;
    }

    @ManyToOne(targetEntity = CardTypeCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CARDTYPECODE_CARDACCOUNTTYPE_0")
    public CardTypeCodeType getCardTypeCode() {
        return cardTypeCode;
    }

    public void setCardTypeCode(CardTypeCodeType value) {
        this.cardTypeCode = value;
    }

    @ManyToOne(targetEntity = ValidityStartDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "VALIDITYSTARTDATE_CARDACCOUN_0")
    public ValidityStartDateType getValidityStartDate() {
        return validityStartDate;
    }

    public void setValidityStartDate(ValidityStartDateType value) {
        this.validityStartDate = value;
    }

    @ManyToOne(targetEntity = ExpiryDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "EXPIRYDATE_CARDACCOUNTTYPE_H_0")
    public ExpiryDateType getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(ExpiryDateType value) {
        this.expiryDate = value;
    }

    @ManyToOne(targetEntity = IssuerIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ISSUERID_CARDACCOUNTTYPE_OFID")
    public IssuerIDType getIssuerID() {
        return issuerID;
    }

    public void setIssuerID(IssuerIDType value) {
        this.issuerID = value;
    }

    @ManyToOne(targetEntity = IssueNumberIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ISSUENUMBERID_CARDACCOUNTTYP_0")
    public IssueNumberIDType getIssueNumberID() {
        return issueNumberID;
    }

    public void setIssueNumberID(IssueNumberIDType value) {
        this.issueNumberID = value;
    }

    @ManyToOne(targetEntity = CV2IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CV2ID_CARDACCOUNTTYPE_OFID")
    public CV2IDType getCV2ID() {
        return cv2ID;
    }

    public void setCV2ID(CV2IDType value) {
        this.cv2ID = value;
    }

    @ManyToOne(targetEntity = CardChipCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CARDCHIPCODE_CARDACCOUNTTYPE_0")
    public CardChipCodeType getCardChipCode() {
        return cardChipCode;
    }

    public void setCardChipCode(CardChipCodeType value) {
        this.cardChipCode = value;
    }

    @ManyToOne(targetEntity = ChipApplicationIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CHIPAPPLICATIONID_CARDACCOUN_0")
    public ChipApplicationIDType getChipApplicationID() {
        return chipApplicationID;
    }

    public void setChipApplicationID(ChipApplicationIDType value) {
        this.chipApplicationID = value;
    }

    @ManyToOne(targetEntity = HolderNameType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "HOLDERNAME_CARDACCOUNTTYPE_H_0")
    public HolderNameType getHolderName() {
        return holderName;
    }

    public void setHolderName(HolderNameType value) {
        this.holderName = value;
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
