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

@Entity(name = "OrderReferenceType")
@Table(name = "ORDERREFERENCETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class OrderReferenceType {

    protected IDType ID;
    protected SalesOrderIDType salesOrderID;
    protected CopyIndicatorType copyIndicator;
    protected UUIDType uuid;
    protected IssueDateType issueDate;
    protected IssueTimeType issueTime;
    protected CustomerReferenceType customerReference;
    protected DocumentReferenceType documentReference;
    protected String id;

    @ManyToOne(targetEntity = IDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ID_ORDERREFERENCETYPE_OFID")
    public IDType getID() {
        return ID;
    }

    public void setID(IDType value) {
        this.ID = value;
    }

    @ManyToOne(targetEntity = SalesOrderIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "SALESORDERID_ORDERREFERENCET_0")
    public SalesOrderIDType getSalesOrderID() {
        return salesOrderID;
    }

    public void setSalesOrderID(SalesOrderIDType value) {
        this.salesOrderID = value;
    }

    @ManyToOne(targetEntity = CopyIndicatorType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "COPYINDICATOR_ORDERREFERENCE_0")
    public CopyIndicatorType getCopyIndicator() {
        return copyIndicator;
    }

    public void setCopyIndicator(CopyIndicatorType value) {
        this.copyIndicator = value;
    }

    @ManyToOne(targetEntity = UUIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "UUID_ORDERREFERENCETYPE_OFID")
    public UUIDType getUUID() {
        return uuid;
    }

    public void setUUID(UUIDType value) {
        this.uuid = value;
    }

    @ManyToOne(targetEntity = IssueDateType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ISSUEDATE_ORDERREFERENCETYPE_0")
    public IssueDateType getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(IssueDateType value) {
        this.issueDate = value;
    }

    @ManyToOne(targetEntity = IssueTimeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ISSUETIME_ORDERREFERENCETYPE_0")
    public IssueTimeType getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(IssueTimeType value) {
        this.issueTime = value;
    }

    @ManyToOne(targetEntity = CustomerReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "CUSTOMERREFERENCE_ORDERREFER_0")
    public CustomerReferenceType getCustomerReference() {
        return customerReference;
    }

    public void setCustomerReference(CustomerReferenceType value) {
        this.customerReference = value;
    }

    @ManyToOne(targetEntity = DocumentReferenceType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DOCUMENTREFERENCE_ORDERREFER_0")
    public DocumentReferenceType getDocumentReference() {
        return documentReference;
    }

    public void setDocumentReference(DocumentReferenceType value) {
        this.documentReference = value;
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
