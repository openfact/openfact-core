package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to define a line in a ForecastRevision describing a revision to a line
 * in a Forecast.
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:15:21 a. m.
 */
public class ForecastRevisionLine{

	/**
	 * A code signifying the reason for the adjustment specified in this forecast
	 * revision line.
	 */
	private CodeType AdjustmentReasonCode;
	/**
	 * Text describing the revision to this line.
	 */
	private TextType Description;
	/**
	 * An identifier for this forecast revision line.
	 */
	private IdentifierType ID;
	/**
	 * Free-form text conveying information that is not contained explicitly in other
	 * structures.
	 */
	private TextType Note;
	/**
	 * An identifier for the revised forecast line.
	 */
	private IdentifierType RevisedForecastLineID;
	/**
	 * The date on which the forecast modified by this revision was generated or
	 * created.
	 */
	private LocalDate SourceForecastIssueDate;
	/**
	 * The time at which the forecast modified by this revision was generated or
	 * created.
	 */
	private LocalTime SourceForecastIssueTime;
	private Period ForecastPeriod;
	private List<SalesItem> SalesItems = new ArrayList<>();

}