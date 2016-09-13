package org.openfact.models.jpa.entities.ubl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe the distribution of a document to an interested party.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:14:32 a. m.
 */
public class DocumentDistributionEntity {

    /**
     * The maximum number of printed copies of the document that the interested
     * party is allowed to make.
     */
    private BigDecimal maximumCopiesNumeric;
    /**
     * Text describing the interested party's distribution rights.
     */
    private TextType printQualifier;
    private List<PartyEntity> parties = new ArrayList<>();

}