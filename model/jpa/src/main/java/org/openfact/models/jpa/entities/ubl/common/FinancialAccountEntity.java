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
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "FINANCIALACCOUNT")
public class FinancialAccountEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "ID_UBL")
    protected String ID;

    @Column(name = "NAME")
    protected String name;

    @Column(name = "ACCOUNT_TYPE_CODE")
    protected String accountTypeCode;

    @Column(name = "CURRENCY_CODE")
    protected String currencyCode;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "FINANCIALACCOUNT_PAYMENTNOTE", joinColumns = {
            @JoinColumn(name = "FINANCIALACCOUNT_ID") })
    protected List<String> paymentNote = new ArrayList<>();

    @ManyToOne(targetEntity = BranchEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "FINANCIALINSTITUTIONBRANCH")
    protected BranchEntity financialInstitutionBranch = new BranchEntity();

    @ManyToOne(targetEntity = CountryEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "COUNTRY")
    protected CountryEntity country = new CountryEntity();

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
     * @return the accountTypeCode
     */
    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    /**
     * @param accountTypeCode
     *            the accountTypeCode to set
     */
    public void setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    /**
     * @return the currencyCode
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * @param currencyCode
     *            the currencyCode to set
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * @return the paymentNote
     */
    public List<String> getPaymentNote() {
        return paymentNote;
    }

    /**
     * @param paymentNote
     *            the paymentNote to set
     */
    public void setPaymentNote(List<String> paymentNote) {
        this.paymentNote = paymentNote;
    }

    /**
     * @return the financialInstitutionBranch
     */
    public BranchEntity getFinancialInstitutionBranch() {
        return financialInstitutionBranch;
    }

    /**
     * @param financialInstitutionBranch
     *            the financialInstitutionBranch to set
     */
    public void setFinancialInstitutionBranch(BranchEntity financialInstitutionBranch) {
        this.financialInstitutionBranch = financialInstitutionBranch;
    }

    /**
     * @return the country
     */
    public CountryEntity getCountry() {
        return country;
    }

    /**
     * @param country
     *            the country to set
     */
    public void setCountry(CountryEntity country) {
        this.country = country;
    }

}