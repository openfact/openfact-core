package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CurrencyCodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A report on the quantities of each item that are, or will be, in stock. This
 * document is sent by a Seller (for example a producer) to a Buyer (for example
 * a retailer).
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:21:27 a. m.
 */
public class StockAvailabilityReportEntity {

    /**
     * Indicates whether this document is a copy (true) or not (false).
     */
    private boolean copyIndicator;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private IdentifierType customizationID;
    /**
     * A code signifying the default currency for this document.
     */
    private CurrencyCodeType codeTypeDocumentCurrencyCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private IdentifierType ID;
    /**
     * The date, assigned by the sender, on which this document was issued.
     */
    private LocalDate issueDate;
    /**
     * The time, assigned by the sender, at which this document was issued.
     */
    private LocalTime issueTime;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private TextType note;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private IdentifierType profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private IdentifierType profileID;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private IdentifierType UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private IdentifierType UUID;
    private CustomerPartyEntity retailerCustomerParty;
    private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();
    private PartyEntity inventoryReportingParty;
    private PeriodEntity inventoryPeriod;
    private List<SignatureEntity> signatures = new ArrayList<>();
    private List<StockAvailabilityReportEntity> lineStockAvailabilityReportLines = new ArrayList<>();
    private SupplierPartyEntity sellerSupplierParty;

}