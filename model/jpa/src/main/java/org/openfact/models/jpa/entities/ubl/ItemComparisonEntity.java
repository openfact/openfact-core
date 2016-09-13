package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;

import org.openfact.models.ubl.type.QuantityType;

/**
 * A class to provide information about price and quantity of an item for use in
 * price comparisons based on price, quantity, or measurements.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:15:40 a. m.
 */
public class ItemComparisonEntity {

    /**
     * The price for the ItemComparison
     */
    private BigDecimal priceAmount;
    /**
     * The quantity for which this comparison is valid.
     */
    private QuantityType quantity;

}