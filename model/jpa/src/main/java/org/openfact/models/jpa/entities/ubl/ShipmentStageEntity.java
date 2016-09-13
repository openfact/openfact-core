package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.QuantityType;
import org.openfact.models.ubl.type.TextType;

import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.TransportModeCodeType;

/**
 * A class to describe one stage of movement in a transport of goods.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:17:45 a. m.
 */
public class ShipmentStageEntity {

    /**
     * The total number of crew aboard a transport means.
     */
    private QuantityType crewQuantity;
    /**
     * Text of instructions relating to demurrage (the case in which a vessel is
     * prevented from loading or discharging cargo within the stipulated
     * laytime).
     */
    private TextType demurrageInstructions;
    /**
     * The estimated date of delivery in this shipment stage.
     */
    private LocalDate estimatedDeliveryDate;
    /**
     * The estimated time of delivery in this shipment stage.
     */
    private LocalTime estimatedDeliveryTime;
    /**
     * An identifier for this shipment stage.
     */
    private IdentifierType ID;
    /**
     * Text of instructions applicable to a shipment stage.
     */
    private TextType instructions;
    /**
     * An identifier for the loading sequence (of consignments) associated with
     * this shipment stage.
     */
    private IdentifierType loadingSequenceID;
    /**
     * An indicator that this stage takes place after the main carriage of the
     * shipment (true) or not (false).
     */
    private boolean onCarriageIndicator;
    /**
     * The total number of passengers aboard a transport means.
     */
    private QuantityType passengerQuantity;
    /**
     * An indicator that this stage takes place before the main carriage of the
     * shipment (true) or not (false).
     */
    private boolean preCarriageIndicator;
    /**
     * The delivery date required by the buyer in this shipment stage.
     */
    private LocalDate requiredDeliveryDate;
    /**
     * The delivery time required by the buyer in this shipment stage.
     */
    private LocalTime requiredDeliveryTime;
    /**
     * Identifies the successive loading sequence (of consignments) associated
     * with a shipment stage.
     */
    private IdentifierType successiveSequenceID;
    /**
     * A code signifying the direction of transit in this shipment stage.
     */
    private CodeType transitDirectionCode;
    /**
     * A code signifying the kind of transport means (truck, vessel, etc.) used
     * for this shipment stage.
     */
    private CodeType transportMeansTypeCode;
    /**
     * A code signifying the method of transport used for this shipment stage.
     */
    private TransportModeCodeType transportModeCode;
    private AllowanceChargeEntity freightAllowanceCharge;
    private LocationEntity loadingPortLocation;
    private LocationEntity transshipPortLocation;
    private LocationEntity unloadingPortLocation;
    private LocationEntity freightChargeLocation;
    private PartyEntity customsAgentParty;
    private PartyEntity terminalOperatorParty;
    private PartyEntity carrierParty;
    private PeriodEntity estimatedTransitPeriod;
    private PeriodEntity transitPeriod;
    private PersonEntity reportingPerson;
    private PersonEntity shipsSurgeonPerson;
    private PersonEntity masterPerson;
    private PersonEntity crewMemberPerson;
    private PersonEntity driverPerson;
    private PersonEntity passengerPerson;
    private PersonEntity securityOfficerPerson;
    private List<TransportEventEntity> exportationTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> actualArrivalTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> warehousingTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> examinationTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> actualDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> estimatedDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> requestedDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> plannedWaypointTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> optionaltakeoverTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> availabilityTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> loadingTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> takeoverTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> requestedArrivalTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> requestedWaypointTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> plannedDepartureTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> plannedArrivalTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> detentionTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> dischargeTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> transportEvents = new ArrayList<>();
    private List<TransportEventEntity> actualWaypointTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> deliveryTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> actualPickupTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> dropoffTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> receiptTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> acceptanceTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> storageTransportEvent = new ArrayList<>();
    private List<TransportEventEntity> estimatedArrivalTransportEvent = new ArrayList<>();
    private List<TransportMeansEntity> transportMeanses = new ArrayList<>();

}