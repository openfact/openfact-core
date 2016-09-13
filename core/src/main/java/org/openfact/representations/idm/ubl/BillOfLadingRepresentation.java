package org.openfact.representations.idm.ubl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.representations.idm.ubl.type.DocumentStatusCodeRepresentation;
import org.openfact.representations.idm.ubl.type.IdentifierRepresentation;
import org.openfact.representations.idm.ubl.type.NameRepresentation;
import org.openfact.representations.idm.ubl.type.TextRepresentation;

/**
 * A document issued by the party who acts as an agent for a transportation
 * carrier or other agents to the party who gives instructions for the
 * transportation services (shipper, consignor, etc.) stating the details of the
 * transportation, charges, and terms a
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:19:12 a. m.
 */
public class BillOfLadingRepresentation {

    /**
     * A term used in commerce in reference to certain duties, called ad valorem
     * duties, which are levied on commodities at certain rates per centum on
     * their value.
     */
    private boolean adValoremIndicator;
    /**
     * Reference number (such as a booking reference number) assigned by a
     * carrier or its agent to identify a specific shipment when cargo space is
     * reserved prior to loading.
     */
    private IdentifierRepresentation carrierAssignedID;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierRepresentation customizationID;
    /**
     * Value declared by the shipper or his agent solely for the purpose of
     * varying the carrier's level of liability from that provided in the
     * contract of carriage in case of loss or damage to goods or delayed
     * delivery.
     */
    private BigDecimal declaredCarriageValueAmount;
    /**
     * Textual description of the document instance.
     */
    private TextRepresentation description;
    /**
     * A code signifying the status of the BillOfLadingRepresentation (revision,
     * replacement, etc. ).
     */
    private DocumentStatusCodeRepresentation codeTypeDocumentStatusCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierRepresentation ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * Text, assigned by the sender, that identifies this document to business
     * users.
     */
    private NameRepresentation name;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextRepresentation note;
    /**
     * Other free-text instructions to the forwarders or carriers related to the
     * shipment. This element should only be used where such information cannot
     * be represented in other structured information entities within the
     * document.
     */
    private TextRepresentation otherInstruction;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierRepresentation profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierRepresentation profileID;
    /**
     * Reference number to identify a Shipping OrderRepresentation or Forwarding
     * Instruction.
     */
    private IdentifierRepresentation shippingOrderID;
    /**
     * Indicates whether the transport document is consigned to order.
     */
    private boolean toOrderIndicator;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierRepresentation UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierRepresentation UUID;
    private List<DocumentDistributionRepresentation> documentDistributions = new ArrayList<>();
    private List<DocumentReferenceRepresentation> documentReferences = new ArrayList<>();
    private List<ExchangeRateRepresentation> exchangeRates = new ArrayList<>();
    private PartyRepresentation consignorParty;
    private PartyRepresentation carrierParty;
    private PartyRepresentation freightForwarderParty;
    private List<ShipmentRepresentation> shipments = new ArrayList<>();
    private List<SignatureRepresentation> signatures = new ArrayList<>();

}