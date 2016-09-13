package org.openfact.models.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe a line item for utility consumption. To specify more than
 * one utility item, use separate consumption lines.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:13:52 a. m.
 */
public class ConsumptionLineModel {

    /**
     * An identifier for this consumption line.
     */
    private IdentifierModel ID;
    /**
     * The quantity invoiced.
     */
    private QuantityModel invoicedQuantity;
    /**
     * The monetary amount, including discount, to be charged for this
     * consumption line.
     */
    private BigDecimal lineExtensionAmount;
    /**
     * An identifier for the transaction line on a related document (such as an
     * invoice) that covers this consumption line.
     */
    private IdentifierModel parentDocumentLineReferenceID;
    private List<AllowanceChargeModel> allowanceCharges = new ArrayList<>();
    private List<DeliveryModel> deliveries = new ArrayList<>();
    private List<PeriodModel> periods = new ArrayList<>();
    private List<PriceModel> prices = new ArrayList<>();
    private List<TaxTotalModel> taxTotals = new ArrayList<>();
    private List<UnstructuredPriceModel> unstructuredprices = new ArrayList<>();
    private List<UtilityItemModel> utilityItems = new ArrayList<>();

}