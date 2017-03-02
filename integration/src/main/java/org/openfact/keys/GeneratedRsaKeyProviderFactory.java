package org.openfact.keys;

import org.jboss.logging.Logger;
import org.keycloak.common.util.CertificateUtils;
import org.keycloak.common.util.KeyUtils;
import org.keycloak.common.util.PemUtils;
import org.openfact.keys.qualifiers.Key;
import org.openfact.keys.qualifiers.RsaKey;
import org.openfact.models.OrganizationModel;
import org.openfact.models.component.ComponentModel;
import org.openfact.models.component.ComponentValidationException;
import org.openfact.models.provider.ProviderConfigProperty;
import org.openfact.provider.ConfigurationValidationHelper;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.util.List;

@Key(type = Key.Type.RSA)
@RsaKey(type = RsaKey.Type.GENERATED)
public class GeneratedRsaKeyProviderFactory extends AbstractRsaKeyProviderFactory {

    private static final Logger logger = Logger.getLogger(GeneratedRsaKeyProviderFactory.class);

    public static final String ID = "rsa-generated";

    private static final String HELP_TEXT = "Generates RSA keys and creates a self-signed certificate";

    private static final List<ProviderConfigProperty> CONFIG_PROPERTIES = AbstractRsaKeyProviderFactory.configurationBuilder()
            .property(Attributes.KEY_SIZE_PROPERTY)
            .build();

    @Override
    public KeyProvider create(ComponentModel model) {
        //return new ImportedRsaKeyProvider(organization, model);
        return null;
    }

    @Override
    public void validateConfiguration(OrganizationModel organization, ComponentModel model) throws ComponentValidationException {
        super.validateConfiguration(organization, model);

        ConfigurationValidationHelper.check(model).checkList(Attributes.KEY_SIZE_PROPERTY, false);

        int size = model.get(Attributes.KEY_SIZE_KEY, 2048);

        if (!(model.contains(Attributes.PRIVATE_KEY_KEY) && model.contains(Attributes.CERTIFICATE_KEY))) {
            generateKeys(organization, model, size);

            logger.debugv("Generated keys for {0}", organization.getName());
        } else {
            PrivateKey privateKey = PemUtils.decodePrivateKey(model.get(Attributes.PRIVATE_KEY_KEY));
            int currentSize = ((RSAPrivateKey) privateKey).getModulus().bitLength();
            if (currentSize != size) {
                generateKeys(organization, model, size);

                logger.debugv("Key size changed, generating new keys for {0}", organization.getName());
            }
        }
    }

    private void generateKeys(OrganizationModel organization, ComponentModel model, int size) {
        KeyPair keyPair;
        try {
            keyPair = KeyUtils.generateRsaKeyPair(size);
            model.put(Attributes.PRIVATE_KEY_KEY, PemUtils.encodeKey(keyPair.getPrivate()));
        } catch (Throwable t) {
            throw new ComponentValidationException("Failed to generate keys", t);
        }

        generateCertificate(organization, model, keyPair);
    }

    private void generateCertificate(OrganizationModel organization, ComponentModel model, KeyPair keyPair) {
        try {
            Certificate certificate = CertificateUtils.generateV1SelfSignedCertificate(keyPair, organization.getName());
            model.put(Attributes.CERTIFICATE_KEY, PemUtils.encodeCertificate(certificate));
        } catch (Throwable t) {
            throw new ComponentValidationException("Failed to generate certificate", t);
        }
    }

    @Override
    public String getHelpText() {
        return HELP_TEXT;
    }

    @Override
    public List<ProviderConfigProperty> getConfigProperties() {
        return CONFIG_PROPERTIES;
    }

}