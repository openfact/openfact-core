package org.openfact.models.ubl;

import org.openfact.models.ubl.type.*;

/**
 * A class to describe access to a web site.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:57 a. m.
 */
public class WebSiteAccessModel {

    /**
     * Text describing login details.
     */
    private TextModel login;
    /**
     * A password to the web site.
     */
    private TextModel password;
    /**
     * The Uniform Resource Identifier (URI) for this web site; i.e., its
     * Uniform Resource Locator (URL).
     */
    private IdentifierModel URIID;

}