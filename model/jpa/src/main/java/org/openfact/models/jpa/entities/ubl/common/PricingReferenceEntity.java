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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PRICINGREFERENCE")
public class PricingReferenceEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @ManyToOne(targetEntity = ItemLocationQuantityEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ORIGINALITEMLOCATIONQUANTITY_PRICINGREFERENCE_ID")
    protected ItemLocationQuantityEntity originalItemLocationQuantity = new ItemLocationQuantityEntity();

    @OneToMany(targetEntity = PriceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ALTERNATIVECONDITIONPRICE_PRICINGREFERENCE_ID")
    protected List<PriceEntity> alternativeConditionPrice = new ArrayList<>();

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
     * @return the originalItemLocationQuantity
     */
    public ItemLocationQuantityEntity getOriginalItemLocationQuantity() {
        return originalItemLocationQuantity;
    }

    /**
     * @param originalItemLocationQuantity
     *            the originalItemLocationQuantity to set
     */
    public void setOriginalItemLocationQuantity(ItemLocationQuantityEntity originalItemLocationQuantity) {
        this.originalItemLocationQuantity = originalItemLocationQuantity;
    }

    /**
     * @return the alternativeConditionPrice
     */
    public List<PriceEntity> getAlternativeConditionPrice() {
        return alternativeConditionPrice;
    }

    /**
     * @param alternativeConditionPrice
     *            the alternativeConditionPrice to set
     */
    public void setAlternativeConditionPrice(List<PriceEntity> alternativeConditionPrice) {
        this.alternativeConditionPrice = alternativeConditionPrice;
    }

}
