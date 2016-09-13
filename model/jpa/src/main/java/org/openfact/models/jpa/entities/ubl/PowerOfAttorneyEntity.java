package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe a power of attorney.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:16:51 a. m.
 */
public class PowerOfAttorneyEntity {

    /**
     * Text describing this power of attorney.
     */
    private TextType description;
    /**
     * An identifier for this power of attorney.
     */
    private IdentifierType ID;
    /**
     * The date on which this power of attorney was issued.
     */
    private LocalDate issueDate;
    /**
     * The time at which this power of attorney was issued.
     */
    private LocalTime issueTime;
    private DocumentReferenceEntity mandateDocumentReference;
    private PartyEntity agentParty;
    private PartyEntity notaryParty;
    private PartyEntity witnessParty;

}