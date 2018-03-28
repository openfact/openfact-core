package org.openfact.models;

import java.util.Map;

public interface CompanyModel extends Model {

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    boolean getUseCustomCertificates();

    void setUseCustomCertificates(boolean useCustomCertificates);

    boolean getUseCustomSmtpConfig();

    void setUseCustomSmtpConfig(boolean useCustomSmtpConfig);

    Map<String, String> getSmtpConfig();

    void setSmtpConfig(Map<String, String> smtpConfig);

    UserModel getOwner();
}
