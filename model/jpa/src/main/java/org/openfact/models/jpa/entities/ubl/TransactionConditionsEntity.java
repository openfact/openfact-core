package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.TextType;

/**
 * A class to describe purchasing, sales, or payment conditions.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:35 a. m.
 */
public class TransactionConditionsEntity {

    /**
     * A code signifying a type of action relating to sales or payment
     * conditions.
     */
    private CodeType actionCode;
    /**
     * Text describing the transaction conditions.
     */
    private TextType description;
    /**
     * An identifier for conditions of the transaction, typically purchase/sales
     * conditions.
     */
    private IdentifierType ID;
    private List<DocumentReferenceEntity> documentReferences = new ArrayList<>();

}