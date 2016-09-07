package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A document issued to a forwarder, giving instructions regarding the action to
 * be taken for the forwarding of goods described therein. Forwarding
 * Instructions is used by any party who gives instructions for the
 * transportation services required for a consig
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:20:38 a. m.
 */
public class ForwardingInstructions {

    /**
     * A term used in commerce in reference to certain duties, called ad valorem
     * duties, which are levied on commodities at certain rates per centum on
     * their value.
     */
    private boolean adValoremIndicator;
    /**
     * Reference number assigned by a carrier or its agent to identify a
     * specific shipment, such as a booking reference number when cargo space is
     * reserved prior to loading.
     */
    private String carrierAssignedID;
    /**
     * Identifies a user-defined customization of UBL for a specific use.
     */
    private String customizationID;
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
    private String description;
    /**
     * A code signifying the status of the Forwarding Instructions with respect
     * to its original state. This code may be used if the document precedes the
     * event and is subsequently found to be incorrect and in need of
     * cancellation or revision.
     */
    private String documentStatusCode;
    /**
     * An identifier for this document, assigned by the sender.
     */
    private String ID;
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
    private String name;
    /**
     * Free-form text pertinent to this document, conveying information that is
     * not contained explicitly in other structures.
     */
    private String note;
    /**
     * Contains other free-text instructions to the forwarders or carriers
     * related to the shipment. This should only be used where such information
     * cannot be represented in other structured information entities within the
     * document.
     */
    private String otherInstruction;
    /**
     * Identifies an instance of executing a profile, to associate all
     * transactions in a collaboration.
     */
    private String profileExecutionID;
    /**
     * Identifies a user-defined profile of the customization of UBL being used.
     */
    private String profileID;
    /**
     * Reference number to identify a Shipping Order.
     */
    private String shippingOrderID;
    /**
     * Indicates whether the transport document is consigned to order.
     */
    private boolean toOrderIndicator;
    /**
     * Identifies the earliest version of the UBL 2 schema for this document
     * type that defines all of the elements that might be encountered in the
     * current instance.
     */
    private String UBLVersionID;
    /**
     * A universally unique identifier for an instance of this document.
     */
    private String UUID;
    private List<DocumentReference> documentReferences = new ArrayList<>();
    private List<ExchangeRate> exchangeRates = new ArrayList<>();
    private Party freightForwarderParty;
    private Party consignorParty;
    private Party carrierParty;
    private List<Shipment> shipments = new ArrayList<>();
    private List<Signature> signatures = new ArrayList<>();

    /**
     * @return the adValoremIndicator
     */
    public boolean isAdValoremIndicator() {
        return adValoremIndicator;
    }

    /**
     * @param adValoremIndicator
     *            the adValoremIndicator to set
     */
    public void setAdValoremIndicator(boolean adValoremIndicator) {
        this.adValoremIndicator = adValoremIndicator;
    }

    /**
     * @return the carrierAssignedID
     */
    public String getCarrierAssignedID() {
        return carrierAssignedID;
    }

    /**
     * @param carrierAssignedID
     *            the carrierAssignedID to set
     */
    public void setCarrierAssignedID(String carrierAssignedID) {
        this.carrierAssignedID = carrierAssignedID;
    }

    /**
     * @return the customizationID
     */
    public String getCustomizationID() {
        return customizationID;
    }

    /**
     * @param customizationID
     *            the customizationID to set
     */
    public void setCustomizationID(String customizationID) {
        this.customizationID = customizationID;
    }

    /**
     * @return the declaredCarriageValueAmount
     */
    public BigDecimal getDeclaredCarriageValueAmount() {
        return declaredCarriageValueAmount;
    }

    /**
     * @param declaredCarriageValueAmount
     *            the declaredCarriageValueAmount to set
     */
    public void setDeclaredCarriageValueAmount(BigDecimal declaredCarriageValueAmount) {
        this.declaredCarriageValueAmount = declaredCarriageValueAmount;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the documentStatusCode
     */
    public String getDocumentStatusCode() {
        return documentStatusCode;
    }

    /**
     * @param documentStatusCode
     *            the documentStatusCode to set
     */
    public void setDocumentStatusCode(String documentStatusCode) {
        this.documentStatusCode = documentStatusCode;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the issueTime
     */
    public LocalTime getIssueTime() {
        return issueTime;
    }

    /**
     * @param issueTime
     *            the issueTime to set
     */
    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the otherInstruction
     */
    public String getOtherInstruction() {
        return otherInstruction;
    }

    /**
     * @param otherInstruction
     *            the otherInstruction to set
     */
    public void setOtherInstruction(String otherInstruction) {
        this.otherInstruction = otherInstruction;
    }

    /**
     * @return the profileExecutionID
     */
    public String getProfileExecutionID() {
        return profileExecutionID;
    }

    /**
     * @param profileExecutionID
     *            the profileExecutionID to set
     */
    public void setProfileExecutionID(String profileExecutionID) {
        this.profileExecutionID = profileExecutionID;
    }

    /**
     * @return the profileID
     */
    public String getProfileID() {
        return profileID;
    }

    /**
     * @param profileID
     *            the profileID to set
     */
    public void setProfileID(String profileID) {
        this.profileID = profileID;
    }

    /**
     * @return the shippingOrderID
     */
    public String getShippingOrderID() {
        return shippingOrderID;
    }

    /**
     * @param shippingOrderID
     *            the shippingOrderID to set
     */
    public void setShippingOrderID(String shippingOrderID) {
        this.shippingOrderID = shippingOrderID;
    }

    /**
     * @return the toOrderIndicator
     */
    public boolean isToOrderIndicator() {
        return toOrderIndicator;
    }

    /**
     * @param toOrderIndicator
     *            the toOrderIndicator to set
     */
    public void setToOrderIndicator(boolean toOrderIndicator) {
        this.toOrderIndicator = toOrderIndicator;
    }

    /**
     * @return the uBLVersionID
     */
    public String getUBLVersionID() {
        return UBLVersionID;
    }

    /**
     * @param uBLVersionID
     *            the uBLVersionID to set
     */
    public void setUBLVersionID(String uBLVersionID) {
        UBLVersionID = uBLVersionID;
    }

    /**
     * @return the uUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(String uUID) {
        UUID = uUID;
    }

    /**
     * @return the documentReferences
     */
    public List<DocumentReference> getDocumentReferences() {
        return documentReferences;
    }

    /**
     * @param documentReferences
     *            the documentReferences to set
     */
    public void setDocumentReferences(List<DocumentReference> documentReferences) {
        this.documentReferences = documentReferences;
    }

    /**
     * @return the exchangeRates
     */
    public List<ExchangeRate> getExchangeRates() {
        return exchangeRates;
    }

    /**
     * @param exchangeRates
     *            the exchangeRates to set
     */
    public void setExchangeRates(List<ExchangeRate> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    /**
     * @return the freightForwarderParty
     */
    public Party getFreightForwarderParty() {
        return freightForwarderParty;
    }

    /**
     * @param freightForwarderParty
     *            the freightForwarderParty to set
     */
    public void setFreightForwarderParty(Party freightForwarderParty) {
        this.freightForwarderParty = freightForwarderParty;
    }

    /**
     * @return the consignorParty
     */
    public Party getConsignorParty() {
        return consignorParty;
    }

    /**
     * @param consignorParty
     *            the consignorParty to set
     */
    public void setConsignorParty(Party consignorParty) {
        this.consignorParty = consignorParty;
    }

    /**
     * @return the carrierParty
     */
    public Party getCarrierParty() {
        return carrierParty;
    }

    /**
     * @param carrierParty
     *            the carrierParty to set
     */
    public void setCarrierParty(Party carrierParty) {
        this.carrierParty = carrierParty;
    }

    /**
     * @return the shipments
     */
    public List<Shipment> getShipments() {
        return shipments;
    }

    /**
     * @param shipments
     *            the shipments to set
     */
    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    /**
     * @return the signatures
     */
    public List<Signature> getSignatures() {
        return signatures;
    }

    /**
     * @param signatures
     *            the signatures to set
     */
    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }

}// end Forwarding Instructions