package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.IdentifierType;

/**
 * A class to define a reference to a transaction line in a billing document.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:09 a. m.
 */
public class BillingReferenceLineEntity {

    /**
     * The monetary amount of the transaction line, including any allowances and
     * charges but excluding taxes.
     */
    private BigDecimal amount;
    /**
     * An identifier for this transaction line in a billing document.
     */
    private IdentifierType ID;
    private List<AllowanceChargeEntity> allowanceCharges = new ArrayList<>();

}