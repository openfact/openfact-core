package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a delivery unit.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:25 a. m.
 */
public class DeliveryUnitModel {

    /**
     * The quantity of ordered Items that constitutes a batch for delivery
     * purposes.
     */
    private QuantityModel batchQuantity;
    /**
     * The quantity of units in the DeliveryUnitModel expressed in the units
     * used by the consumer.
     */
    private QuantityModel consumerUnitQuantity;
    /**
     * An indication that the transported goods are subject to an international
     * regulation concerning the carriage of dangerous goods (true) or not
     * (false).
     */
    private boolean hazardousRiskIndicator;

}