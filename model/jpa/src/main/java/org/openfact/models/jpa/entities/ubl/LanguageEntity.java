package org.openfact.models.jpa.entities.ubl;

import org.openfact.models.ubl.type.CodeType;
import org.openfact.models.ubl.type.IdentifierType;
import org.openfact.models.ubl.type.NameType;

/**
 * A class to describe a language.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:15:54 a. m.
 */
public class LanguageEntity {

    /**
     * An identifier for this language.
     */
    private IdentifierType ID;
    /**
     * A code signifying the locale in which this language is used.
     */
    private CodeType localeCode;
    /**
     * The name of this language.
     */
    private NameType name;

}