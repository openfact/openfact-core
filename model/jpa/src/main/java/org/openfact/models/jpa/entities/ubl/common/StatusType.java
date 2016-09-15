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

@Entity(name = "StatusType")
@Table(name = "STATUSTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class StatusType {

    protected ConditionCodeType conditionCode;
    protected ReferenceDateType referenceDate;
    protected ReferenceTimeType referenceTime;
    protected DescriptionType description;
    protected StatusReasonCodeType statusReasonCode;
    protected StatusReasonType statusReason;
    protected SequenceIDType sequenceID;
    protected TextType text;
    protected IndicationIndicatorType indicationIndicator;
    protected PercentType percent;
    protected String id;

    @ManyToOne(targetEntity = ConditionCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CONDITIONCODE_STATUSTYPE_OFID")
    public ConditionCodeType getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(ConditionCodeType value) {
        this.conditionCode = value;
    }

    @ManyToOne(targetEntity = ReferenceDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REFERENCEDATE_STATUSTYPE_OFID")
    public ReferenceDateType getReferenceDate() {
        return referenceDate;
    }

    public void setReferenceDate(ReferenceDateType value) {
        this.referenceDate = value;
    }

    @ManyToOne(targetEntity = ReferenceTimeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "REFERENCETIME_STATUSTYPE_OFID")
    public ReferenceTimeType getReferenceTime() {
        return referenceTime;
    }

    public void setReferenceTime(ReferenceTimeType value) {
        this.referenceTime = value;
    }

    @ManyToOne(targetEntity = DescriptionType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DESCRIPTION_STATUSTYPE_OFID")
    public DescriptionType getDescription() {
        return description;
    }

    public void setDescription(DescriptionType value) {
        this.description = value;
    }

    @ManyToOne(targetEntity = StatusReasonCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "STATUSREASONCODE_STATUSTYPE__0")
    public StatusReasonCodeType getStatusReasonCode() {
        return statusReasonCode;
    }

    public void setStatusReasonCode(StatusReasonCodeType value) {
        this.statusReasonCode = value;
    }

    @ManyToOne(targetEntity = StatusReasonType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "STATUSREASON_STATUSTYPE_OFID")
    public StatusReasonType getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(StatusReasonType value) {
        this.statusReason = value;
    }

    @ManyToOne(targetEntity = SequenceIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SEQUENCEID_STATUSTYPE_OFID")
    public SequenceIDType getSequenceID() {
        return sequenceID;
    }

    public void setSequenceID(SequenceIDType value) {
        this.sequenceID = value;
    }

    @ManyToOne(targetEntity = TextType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "TEXT_STATUSTYPE_OFID")
    public TextType getText() {
        return text;
    }

    public void setText(TextType value) {
        this.text = value;
    }

    @ManyToOne(targetEntity = IndicationIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "INDICATIONINDICATOR_STATUSTY_0")
    public IndicationIndicatorType getIndicationIndicator() {
        return indicationIndicator;
    }

    public void setIndicationIndicator(IndicationIndicatorType value) {
        this.indicationIndicator = value;
    }

    @ManyToOne(targetEntity = PercentType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "PERCENT_STATUSTYPE_OFID")
    public PercentType getPercent() {
        return percent;
    }

    public void setPercent(PercentType value) {
        this.percent = value;
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
