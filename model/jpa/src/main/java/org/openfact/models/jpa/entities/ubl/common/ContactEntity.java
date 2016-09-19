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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CONTACT")
@Inheritance(strategy = InheritanceType.JOINED)
public class ContactEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "ID")
    protected String ID;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "TELEPHONE")
    protected String telephone;

    @Column(name = "TELEFAX")
    protected String telefax;

    @Column(name = "ELECTRONIC_MAIL")
    protected String electronicMail;

    @Column(name = "NOTE")
    protected String note;

    @OneToMany(targetEntity = CommunicationEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "OTHERCOMMUNICATION_CONTACT")
    protected List<CommunicationEntity> otherCommunication = new ArrayList<>();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * @return the telefax
     */
    public String getTelefax() {
        return telefax;
    }

    /**
     * @param telefax
     *            the telefax to set
     */
    public void setTelefax(String telefax) {
        this.telefax = telefax;
    }

    /**
     * @return the electronicMail
     */
    public String getElectronicMail() {
        return electronicMail;
    }

    /**
     * @param electronicMail
     *            the electronicMail to set
     */
    public void setElectronicMail(String electronicMail) {
        this.electronicMail = electronicMail;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the otherCommunication
     */
    public List<CommunicationEntity> getOtherCommunication() {
        return otherCommunication;
    }

    /**
     * @param otherCommunication
     *            the otherCommunication to set
     */
    public void setOtherCommunication(List<CommunicationEntity> otherCommunication) {
        this.otherCommunication = otherCommunication;
    }

}
