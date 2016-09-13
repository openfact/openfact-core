package org.openfact.models.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a taxation scheme applying to a party.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:31 a. m.
 */
public class PartyTaxSchemeModel {

    /**
     * An identifier for the party assigned for tax purposes by the taxation
     * authority.
     */
    private IdentifierModel companyID;
    /**
     * A reason for the party's exemption from tax, expressed as text.
     */
    private TextModel exemptionReason;
    /**
     * A reason for the party's exemption from tax, expressed as a code.
     */
    private CodeModel exemptionReasonCode;
    /**
     * The name of the party as registered with the relevant fiscal authority.
     */
    private NameModel registrationName;
    /**
     * A code signifying the tax level applicable to the party within this
     * taxation scheme.
     */
    private CodeModel taxLevelCode;
    private AddressModel registrationAddress;
    private List<TaxSchemeModel> taxSchemes = new ArrayList<>();

}