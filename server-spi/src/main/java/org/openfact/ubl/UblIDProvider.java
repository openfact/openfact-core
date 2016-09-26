package org.openfact.ubl;

import org.openfact.models.OrganizationModel;
import org.openfact.models.UblDocumentType;
import org.openfact.provider.Provider;

public interface UblIDProvider extends Provider {

    public String getID(OrganizationModel organization, UblDocumentType type);

}