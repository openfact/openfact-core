package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.MeasureType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define a measurable condition of an object.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:42 a. m.
 */
public class ConditionEntity {

    /**
     * An identifier for the attribute that applies to the condition.
     */
    private IdentifierType attributeID;
    /**
     * Text describing the attribute that applies to the condition.
     */
    private TextType description;
    /**
     * The maximum value in a range of measurement for this condition.
     */
    private MeasureType maximumMeasure;
    /**
     * The measurement value.
     */
    private MeasureType measure;
    /**
     * The minimum value in a range of measurement for this condition.
     */
    private MeasureType minimumMeasure;

}