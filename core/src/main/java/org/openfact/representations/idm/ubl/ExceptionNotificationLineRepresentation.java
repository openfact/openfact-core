package org.openfact.representations.idm.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.CodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.MeasureRepresentation;
import org.openfact.representations.idm.ubl.type.QuantityRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to define a line in an ExceptionNotification.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:07 a. m.
 */
public class ExceptionNotificationLineRepresentation {

    /**
     * Priority of Exception.
     */
    private CodeRepresentation collaborationPriorityCode;
    /**
     * The value that was compared with the source value that resulted in the
     * exception
     */
    private MeasureRepresentation comparedValueMeasure;
    /**
     * Text describing the exception.
     */
    private TextRepresentation description;
    /**
     * A code signifying status specific to a shipment exception.
     */
    private CodeRepresentation exceptionStatusCode;
    /**
     * An identifier for this exception notification line.
     */
    private IdentifierRepresentation ID;
    /**
     * Free-form text conveying information that is not contained explicitly in
     * other structures.
     */
    private TextRepresentation note;
    /**
     * A code used to identify a measure of performance. It defines the type of
     * the Performance Metric on which an exception criteria is being defined
     */
    private CodeRepresentation performanceMetricTypeCode;
    /**
     * Coded representation of possible resolution methods". Possible values
     * are: DEFAULT_TO_AVERAGE_OF_COMPARED_VALUES DEFAULT_TO_BUYERS_VALUE
     * DEFAULT_TO_HIGH_VALUE DEFAULT_TO_LOW_VALUE DEFAULT_TO_SELLERS_VALUE
     * MANUAL_RESOLUTION MUTUALLY_DEFINED
     */
    private CodeRepresentation resolutionCode;
    /**
     * The value used as the basis of comparison
     */
    private MeasureRepresentation sourceValueMeasure;
    /**
     * Establishes the criterion for one of the three types of exceptions:
     * Operational, performance metric and forecast. This reports an exception
     * notification about an operational exception. description could be: A code
     * used to identify an operational exception
     */
    private CodeRepresentation supplyChainActivityTypeCode;
    /**
     * The variance of a data item from an expected value during a particular
     * time interval.
     */
    private QuantityRepresentation varianceQuantity;
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private List<ForecastExceptionRepresentation> forecastExceptions = new ArrayList<>();
    private ItemRepresentation supplyItem;
    private PeriodRepresentation exceptionObservationPeriod;

}