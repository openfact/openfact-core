package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;

/**
 * A class to describe a planned effect of a retail event (e.g., a promotion or
 * a change in inventory policy) upon supply or demand.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:35 a. m.
 */
public class RetailPlannedImpactRepresentation {

    /**
     * Estimated monetary value of the planned event as an impact
     */
    private BigDecimal amount;
    /**
     * It will have impact on either Sales forecast or OrderRepresentation
     * Forecast
     */
    private CodeRepresentation forecastPurposeCode;
    /**
     * A code signifying the type of forecast. Examples of values are: BASE
     * PROMOTIONAL SEASONAL TOTAL
     */
    private CodeRepresentation forecastTypeCode;
    private List<PeriodRepresentation> periods = new ArrayList<>();

}