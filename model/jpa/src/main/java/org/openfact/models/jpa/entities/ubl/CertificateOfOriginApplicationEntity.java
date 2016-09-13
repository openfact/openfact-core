package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to define an application for a CertificateEntity of Origin (CoO).
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:13:30 a. m.
 */
public class CertificateOfOriginApplicationEntity {

    /**
     * A code signifying the status of the application (revision, replacement,
     * etc.).
     */
    private CodeType applicationStatusCode;
    /**
     * The type of CoO being applied for (Ordinary, Re-export, Commonwealth
     * Preferential, etc.).
     */
    private TextType certificateType;
    /**
     * The latest job number given to the CoO application. This is used by the
     * system to keep track of amendments to or cancellation of any earlier
     * applications.
     */
    private IdentifierType originalJobID;
    /**
     * An identifier for the previous job used in case the application requires
     * query or change.
     */
    private IdentifierType previousJobID;
    /**
     * An identifier for a reference as part of the CoO application.
     */
    private IdentifierType referenceID;
    /**
     * remarks by the applicant for the CoO.
     */
    private TextType remarks;
    private List<DocumentDistributionEntity> documentDistributions = new ArrayList<>();
    private DocumentReferenceEntity supportingDocumentReference;
    private List<EndorserPartyEntity> endorserParties = new ArrayList<>();
    private PartyEntity preparationParty;
    private PartyEntity exporterParty;
    private PartyEntity issuerParty;
    private PartyEntity importerParty;
    private List<ShipmentEntity> shipments = new ArrayList<>();
    private List<SignatureEntity> signatures = new ArrayList<>();
    private CountryEntity issuingCountry;

}