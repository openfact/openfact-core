package org.openfact.models.jpa.entities.ubl;import java.math.BigDecimal;import java.time.LocalDate;import java.time.LocalTime;
import java.util.List; 
import java.util.ArrayList; 
import org.openfact.models.jpa.entities.ublType.*;


/**
 * A class to describe a taxation scheme applying to a party.
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:31 a. m.
 */
public class PartyTaxScheme{

	/**
	 * An identifier for the party assigned for tax purposes by the taxation authority.
	 */
	private IdentifierType CompanyID;
	/**
	 * A reason for the party's exemption from tax, expressed as text.
	 */
	private TextType ExemptionReason;
	/**
	 * A reason for the party's exemption from tax, expressed as a code.
	 */
	private CodeType ExemptionReasonCode;
	/**
	 * The name of the party as registered with the relevant fiscal authority.
	 */
	private NameType RegistrationName;
	/**
	 * A code signifying the tax level applicable to the party within this taxation
	 * scheme.
	 */
	private CodeType TaxLevelCode;
	private Address RegistrationAddress;
	private List<TaxScheme> TaxSchemes = new ArrayList<>();

}