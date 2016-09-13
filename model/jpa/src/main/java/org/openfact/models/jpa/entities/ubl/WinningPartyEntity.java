package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.TextType;

/**
 * A party that is identified as the awarded by a tender result.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:59 a. m.
 */
public class WinningPartyEntity {

    /**
     * Indicates the rank obtained in the award.
     */
    private TextType rank;
    private List<PartyEntity> parties = new ArrayList<>();

}