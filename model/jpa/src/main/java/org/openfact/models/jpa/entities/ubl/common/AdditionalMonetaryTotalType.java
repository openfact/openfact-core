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

@Entity(name = "AdditionalMonetaryTotalType")
@Table(name = "ADDITIONALMONETARYTOTALTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class AdditionalMonetaryTotalType {

    protected IDType ID;
    protected NameTypeCommBas name;
    protected AmountTypeCommBas referenceAmount;
    protected PayableAmountType payableAmount;
    protected PercentType percent;
    protected AmountTypeCommBas totalAmount;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_ADDITIONALMONETARYTOTALTY_0")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = NameTypeCommBas.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "NAME__ADDITIONALMONETARYTOTA_0")
    public NameTypeCommBas getName() {
        return name;
    }

    public void setName(NameTypeCommBas value) {
        this.name = value;
    }

    @ManyToOne(targetEntity = AmountTypeCommBas.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REFERENCEAMOUNT_ADDITIONALMO_0")
    public AmountTypeCommBas getReferenceAmount() {
        return referenceAmount;
    }

    public void setReferenceAmount(AmountTypeCommBas value) {
        this.referenceAmount = value;
    }

    @ManyToOne(targetEntity = PayableAmountType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PAYABLEAMOUNT_ADDITIONALMONE_0")
    public PayableAmountType getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(PayableAmountType value) {
        this.payableAmount = value;
    }

    @ManyToOne(targetEntity = PercentType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PERCENT_ADDITIONALMONETARYTO_0")
    public PercentType getPercent() {
        return percent;
    }

    public void setPercent(PercentType value) {
        this.percent = value;
    }

    @ManyToOne(targetEntity = AmountTypeCommBas.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TOTALAMOUNT_ADDITIONALMONETA_0")
    public AmountTypeCommBas getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(AmountTypeCommBas value) {
        this.totalAmount = value;
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
