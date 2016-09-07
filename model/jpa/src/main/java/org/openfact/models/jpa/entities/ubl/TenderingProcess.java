package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe the process of a formal offer and response to execute
 * work or supply goods at a stated price.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:27 a. m.
 */
public class TenderingProcess {

    /**
     * An indicator that the number of candidates participating in this process
     * has been reduced (true) or not (false).
     */
    private boolean CandidateReductionConstraintIndicator;
    /**
     * A code signifying the type of contracting system (e.g., framework
     * agreement, dynamic purchasing system). If the procedure is individual
     * (nonrepetitive), this code should be omitted.
     */
    private String ContractingSystemCode;
    /**
     * Text describing the tendering process.
     */
    private String Description;
    /**
     * A code signifying the type of expense for this tendering process.
     */
    private String ExpenseCode;
    /**
     * An indicator that the project associated with this tendering process is
     * constrained by a government procurement agreement (true) or not (false).
     */
    private boolean GovernmentAgreementConstraintIndicator;
    /**
     * An identifier for this tendering process.
     */
    private String ID;
    /**
     * Text describing the negotiation to be followed during the tendering
     * process.
     */
    private String NegotiationDescription;
    /**
     * When reopening a tendering process, the identifier of the original
     * framework agreement or dynamic purchasing system.
     */
    private String OriginalContractingSystemID;
    /**
     * A code signifying the type of presentation of tenders required (e.g., one
     * lot, multiple lots, or all the lots).
     */
    private String PartPresentationCode;
    /**
     * A code signifying the type of this tendering procedure.
     */
    private String ProcedureCode;
    /**
     * A code signifying the method to be followed in submitting tenders.
     */
    private String SubmissionMethodCode;
    /**
     * A code signifying the urgency of this tendering process.
     */
    private String UrgencyCode;
    private AuctionTerms m_AuctionTerms;
    private DocumentReference NoticeDocumentReference;
    private DocumentReference AdditionalDocumentReference;
    private EconomicOperatorShortList m_EconomicOperatorShortList;
    private Event OpenTenderEvent;
    private FrameworkAgreement m_FrameworkAgreement;
    private Period ParticipationRequestReceptionPeriod;
    private Period InvitationSubmissionPeriod;
    private Period TenderSubmissionDeadlinePeriod;
    private Period DocumentAvailabilityPeriod;
    private ProcessJustification m_ProcessJustification;

    /**
     * @return the candidateReductionConstraintIndicator
     */
    public boolean isCandidateReductionConstraintIndicator() {
        return CandidateReductionConstraintIndicator;
    }

    /**
     * @param candidateReductionConstraintIndicator
     *            the candidateReductionConstraintIndicator to set
     */
    public void setCandidateReductionConstraintIndicator(boolean candidateReductionConstraintIndicator) {
        CandidateReductionConstraintIndicator = candidateReductionConstraintIndicator;
    }

    /**
     * @return the contractingSystemCode
     */
    public String getContractingSystemCode() {
        return ContractingSystemCode;
    }

    /**
     * @param contractingSystemCode
     *            the contractingSystemCode to set
     */
    public void setContractingSystemCode(String contractingSystemCode) {
        ContractingSystemCode = contractingSystemCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        Description = description;
    }

    /**
     * @return the expenseCode
     */
    public String getExpenseCode() {
        return ExpenseCode;
    }

    /**
     * @param expenseCode
     *            the expenseCode to set
     */
    public void setExpenseCode(String expenseCode) {
        ExpenseCode = expenseCode;
    }

    /**
     * @return the governmentAgreementConstraintIndicator
     */
    public boolean isGovernmentAgreementConstraintIndicator() {
        return GovernmentAgreementConstraintIndicator;
    }

    /**
     * @param governmentAgreementConstraintIndicator
     *            the governmentAgreementConstraintIndicator to set
     */
    public void setGovernmentAgreementConstraintIndicator(boolean governmentAgreementConstraintIndicator) {
        GovernmentAgreementConstraintIndicator = governmentAgreementConstraintIndicator;
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
     * @return the negotiationDescription
     */
    public String getNegotiationDescription() {
        return NegotiationDescription;
    }

    /**
     * @param negotiationDescription
     *            the negotiationDescription to set
     */
    public void setNegotiationDescription(String negotiationDescription) {
        NegotiationDescription = negotiationDescription;
    }

    /**
     * @return the originalContractingSystemID
     */
    public String getOriginalContractingSystemID() {
        return OriginalContractingSystemID;
    }

    /**
     * @param originalContractingSystemID
     *            the originalContractingSystemID to set
     */
    public void setOriginalContractingSystemID(String originalContractingSystemID) {
        OriginalContractingSystemID = originalContractingSystemID;
    }

    /**
     * @return the partPresentationCode
     */
    public String getPartPresentationCode() {
        return PartPresentationCode;
    }

    /**
     * @param partPresentationCode
     *            the partPresentationCode to set
     */
    public void setPartPresentationCode(String partPresentationCode) {
        PartPresentationCode = partPresentationCode;
    }

    /**
     * @return the procedureCode
     */
    public String getProcedureCode() {
        return ProcedureCode;
    }

    /**
     * @param procedureCode
     *            the procedureCode to set
     */
    public void setProcedureCode(String procedureCode) {
        ProcedureCode = procedureCode;
    }

    /**
     * @return the submissionMethodCode
     */
    public String getSubmissionMethodCode() {
        return SubmissionMethodCode;
    }

    /**
     * @param submissionMethodCode
     *            the submissionMethodCode to set
     */
    public void setSubmissionMethodCode(String submissionMethodCode) {
        SubmissionMethodCode = submissionMethodCode;
    }

    /**
     * @return the urgencyCode
     */
    public String getUrgencyCode() {
        return UrgencyCode;
    }

    /**
     * @param urgencyCode
     *            the urgencyCode to set
     */
    public void setUrgencyCode(String urgencyCode) {
        UrgencyCode = urgencyCode;
    }

    /**
     * @return the m_AuctionTerms
     */
    public AuctionTerms getM_AuctionTerms() {
        return m_AuctionTerms;
    }

    /**
     * @param m_AuctionTerms
     *            the m_AuctionTerms to set
     */
    public void setM_AuctionTerms(AuctionTerms m_AuctionTerms) {
        this.m_AuctionTerms = m_AuctionTerms;
    }

    /**
     * @return the noticeDocumentReference
     */
    public DocumentReference getNoticeDocumentReference() {
        return NoticeDocumentReference;
    }

    /**
     * @param noticeDocumentReference
     *            the noticeDocumentReference to set
     */
    public void setNoticeDocumentReference(DocumentReference noticeDocumentReference) {
        NoticeDocumentReference = noticeDocumentReference;
    }

    /**
     * @return the additionalDocumentReference
     */
    public DocumentReference getAdditionalDocumentReference() {
        return AdditionalDocumentReference;
    }

    /**
     * @param additionalDocumentReference
     *            the additionalDocumentReference to set
     */
    public void setAdditionalDocumentReference(DocumentReference additionalDocumentReference) {
        AdditionalDocumentReference = additionalDocumentReference;
    }

    /**
     * @return the m_EconomicOperatorShortList
     */
    public EconomicOperatorShortList getM_EconomicOperatorShortList() {
        return m_EconomicOperatorShortList;
    }

    /**
     * @param m_EconomicOperatorShortList
     *            the m_EconomicOperatorShortList to set
     */
    public void setM_EconomicOperatorShortList(EconomicOperatorShortList m_EconomicOperatorShortList) {
        this.m_EconomicOperatorShortList = m_EconomicOperatorShortList;
    }

    /**
     * @return the openTenderEvent
     */
    public Event getOpenTenderEvent() {
        return OpenTenderEvent;
    }

    /**
     * @param openTenderEvent
     *            the openTenderEvent to set
     */
    public void setOpenTenderEvent(Event openTenderEvent) {
        OpenTenderEvent = openTenderEvent;
    }

    /**
     * @return the m_FrameworkAgreement
     */
    public FrameworkAgreement getM_FrameworkAgreement() {
        return m_FrameworkAgreement;
    }

    /**
     * @param m_FrameworkAgreement
     *            the m_FrameworkAgreement to set
     */
    public void setM_FrameworkAgreement(FrameworkAgreement m_FrameworkAgreement) {
        this.m_FrameworkAgreement = m_FrameworkAgreement;
    }

    /**
     * @return the participationRequestReceptionPeriod
     */
    public Period getParticipationRequestReceptionPeriod() {
        return ParticipationRequestReceptionPeriod;
    }

    /**
     * @param participationRequestReceptionPeriod
     *            the participationRequestReceptionPeriod to set
     */
    public void setParticipationRequestReceptionPeriod(Period participationRequestReceptionPeriod) {
        ParticipationRequestReceptionPeriod = participationRequestReceptionPeriod;
    }

    /**
     * @return the invitationSubmissionPeriod
     */
    public Period getInvitationSubmissionPeriod() {
        return InvitationSubmissionPeriod;
    }

    /**
     * @param invitationSubmissionPeriod
     *            the invitationSubmissionPeriod to set
     */
    public void setInvitationSubmissionPeriod(Period invitationSubmissionPeriod) {
        InvitationSubmissionPeriod = invitationSubmissionPeriod;
    }

    /**
     * @return the tenderSubmissionDeadlinePeriod
     */
    public Period getTenderSubmissionDeadlinePeriod() {
        return TenderSubmissionDeadlinePeriod;
    }

    /**
     * @param tenderSubmissionDeadlinePeriod
     *            the tenderSubmissionDeadlinePeriod to set
     */
    public void setTenderSubmissionDeadlinePeriod(Period tenderSubmissionDeadlinePeriod) {
        TenderSubmissionDeadlinePeriod = tenderSubmissionDeadlinePeriod;
    }

    /**
     * @return the documentAvailabilityPeriod
     */
    public Period getDocumentAvailabilityPeriod() {
        return DocumentAvailabilityPeriod;
    }

    /**
     * @param documentAvailabilityPeriod
     *            the documentAvailabilityPeriod to set
     */
    public void setDocumentAvailabilityPeriod(Period documentAvailabilityPeriod) {
        DocumentAvailabilityPeriod = documentAvailabilityPeriod;
    }

    /**
     * @return the m_ProcessJustification
     */
    public ProcessJustification getM_ProcessJustification() {
        return m_ProcessJustification;
    }

    /**
     * @param m_ProcessJustification
     *            the m_ProcessJustification to set
     */
    public void setM_ProcessJustification(ProcessJustification m_ProcessJustification) {
        this.m_ProcessJustification = m_ProcessJustification;
    }

}// end Tendering Process