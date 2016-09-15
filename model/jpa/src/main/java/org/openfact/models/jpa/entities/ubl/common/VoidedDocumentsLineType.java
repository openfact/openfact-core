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

@Entity(name = "VoidedDocumentsLineType")
@Table(name = "VOIDEDDOCUMENTSLINETYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public class VoidedDocumentsLineType {

    protected LineIDType lineID;
    protected DocumentTypeCodeType documentTypeCode;
    protected IdentifierType documentSerialID;
    protected IdentifierType documentNumberID;
    protected TextTypeUnqDat voidReasonDescription;
    protected String id;

    @ManyToOne(targetEntity = LineIDType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "LINEID_VOIDEDDOCUMENTSLINETY_0")
    public LineIDType getLineID() {
        return lineID;
    }

    public void setLineID(LineIDType value) {
        this.lineID = value;
    }

    @ManyToOne(targetEntity = DocumentTypeCodeType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DOCUMENTTYPECODE_VOIDEDDOCUM_0")
    public DocumentTypeCodeType getDocumentTypeCode() {
        return documentTypeCode;
    }

    public void setDocumentTypeCode(DocumentTypeCodeType value) {
        this.documentTypeCode = value;
    }

    @ManyToOne(targetEntity = IdentifierType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DOCUMENTSERIALID_VOIDEDDOCUM_0")
    public IdentifierType getDocumentSerialID() {
        return documentSerialID;
    }

    public void setDocumentSerialID(IdentifierType value) {
        this.documentSerialID = value;
    }

    @ManyToOne(targetEntity = IdentifierType.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DOCUMENTNUMBERID_VOIDEDDOCUM_0")
    public IdentifierType getDocumentNumberID() {
        return documentNumberID;
    }

    public void setDocumentNumberID(IdentifierType value) {
        this.documentNumberID = value;
    }

    @ManyToOne(targetEntity = TextTypeUnqDat.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "VOIDREASONDESCRIPTION_VOIDED_0")
    public TextTypeUnqDat getVoidReasonDescription() {
        return voidReasonDescription;
    }

    public void setVoidReasonDescription(TextTypeUnqDat value) {
        this.voidReasonDescription = value;
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
