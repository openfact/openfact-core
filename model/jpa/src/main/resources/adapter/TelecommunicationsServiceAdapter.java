package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a telecommunications service (e.g., a telephone call or a
 * video on demand service).
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:09 a. m.
 */
public class TelecommunicationsServiceAdapter{

	/**
	 * The amount to be payed as the base for one call
	 */
	private BigDecimal callBaseAmount; 
	/**
	 * In the case of a telephone call, the date of the call.
	 */
	private LocalDate callDate; 
	/**
	 * The amount to be payed for the call
	 */
	private BigDecimal callExtensionAmount; 
	/**
	 * In the case of a telephone call, the time of the call.
	 */
	private LocalTime callTime; 
	/**
	 * An identifier for this telecommunications service.
	 */
	private IdentifierType ID; 
	/**
	 * The title of a movie delivered via this telecommunications service.
	 */
	private TextType movieTitle; 
	/**
	 * A pay-per-view delivered via this telecommunications service.
	 */
	private TextType payPerView; 
	/**
	 * The number of calls.
	 */
	private QuantityType quantity; 
	/**
	 * StatementAdapter of the roaming partner name.
	 */
	private NameType roamingPartnerName; 
	/**
	 * In the case of a telephone call, the phone number called.
	 */
	private TextType serviceNumberCalled; 
	/**
	 * The telecommunications call described as a text
	 */
	private TextType telecommunicationsServiceCall; 
	/**
	 * The telecommunications call described as a code
	 */
	private CodeType telecommunicationsServiceCallCode; 
	/**
	 * The telecommunications category, expressed as text.
	 */
	private TextType telecommunicationsServiceCategory; 
	/**
	 * The telecommunications category, expressed as a code.
	 */
	private CodeType telecommunicationsServiceCategoryCode; 
	private List<AllowanceChargeAdapter> allowanceCharges = new ArrayList<>(); 
	private List<CountryAdapter> countries = new ArrayList<>(); 
	private DutyAdapter callDuty; 
	private DutyAdapter timeDuty; 
	private List<ExchangeRateAdapter> exchangeRates = new ArrayList<>(); 
	private List<PriceAdapter> prices = new ArrayList<>(); 
	private List<TaxTotalAdapter> taxTotals = new ArrayList<>(); 

}