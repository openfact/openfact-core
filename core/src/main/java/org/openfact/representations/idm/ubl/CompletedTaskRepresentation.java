package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A class to describe the completion of a specific task in the tendering
 * process.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:40 a. m.
 */
public class CompletedTaskRepresentation {

    /**
     * The average monetary amount of a task such as this completed task.
     */
    private BigDecimal annualAverageAmount;
    /**
     * Text describing this completed task.
     */
    private TextRepresentation description;
    /**
     * A monetary amount corresponding to the financial capacity of the party
     * that carried out this completed task.
     */
    private BigDecimal partyCapacityAmount;
    /**
     * The actual total monetary amount of this completed task.
     */
    private BigDecimal totalTaskAmount;
    private CustomerPartyRepresentation recipientCustomerParty;
    private List<EvidenceSuppliedRepresentation> evidenceSupplieds = new ArrayList<>();
    private List<PeriodRepresentation> periods = new ArrayList<>();

}