/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.openfact.keys;

import org.openfact.Config;
import org.openfact.common.util.CertificateUtils;
import org.openfact.common.util.KeyUtils;
import org.openfact.common.util.PemUtils;
import org.openfact.component.ComponentModel;
import org.openfact.component.ComponentValidationException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OpenfactSessionFactory;
import org.openfact.models.OrganizationModel;
import org.openfact.provider.ConfigurationValidationHelper;
import org.openfact.provider.ProviderConfigProperty;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.util.List;

/**
 * @author <a href="mailto:carlosthe19916@sistcoop.com">Carlos Feria</a>
 */
public class RsaKeyProviderFactory extends AbstractRsaKeyProviderFactory {

    public static final String ID = "rsa";

    private static final String HELP_TEXT = "RSA key provider that can optionally generated a self-signed certificate";

    private static final List<ProviderConfigProperty> CONFIG_PROPERTIES = AbstractRsaKeyProviderFactory.configurationBuilder()
            .property(Attributes.PRIVATE_KEY_PROPERTY)
            .property(Attributes.CERTIFICATE_PROPERTY)
            .build();

    @Override
    public KeyProvider create(OpenfactSession session, ComponentModel model) {
        return new RsaKeyProvider(session.getContext().getOrganization(), model);
    }

    @Override
    public void validateConfiguration(OpenfactSession session, ComponentModel model) throws ComponentValidationException {
        super.validateConfiguration(session, model);

        ConfigurationValidationHelper.check(model)
                .checkSingle(Attributes.PRIVATE_KEY_PROPERTY, true)
                .checkSingle(Attributes.CERTIFICATE_PROPERTY, false);

        KeyPair keyPair;
        try {
            PrivateKey privateKey = PemUtils.decodePrivateKey(model.get(Attributes.PRIVATE_KEY_KEY));
            PublicKey publicKey = KeyUtils.extractPublicKey(privateKey);
            keyPair = new KeyPair(publicKey, privateKey);
        } catch (Throwable t) {
            throw new ComponentValidationException("Failed to decode private key", t);
        }

        if (model.contains(Attributes.CERTIFICATE_KEY)) {
            Certificate certificate = null;
            try {
                certificate = PemUtils.decodeCertificate(model.get(Attributes.CERTIFICATE_KEY));
            } catch (Throwable t) {
                throw new ComponentValidationException("Failed to decode certificate", t);
            }

            if (certificate == null) {
                throw new ComponentValidationException("Failed to decode certificate");
            }

            if (!certificate.getPublicKey().equals(keyPair.getPublic())) {
                throw new ComponentValidationException("Certificate does not match private key");
            }
        } else {
            try {
                OrganizationModel organization = session.organizations().getOrganization(model.getParentId());
                Certificate certificate = CertificateUtils.generateV1SelfSignedCertificate(keyPair, organization.getName());
                model.put(Attributes.CERTIFICATE_KEY, PemUtils.encodeCertificate(certificate));
            } catch (Throwable t) {
                throw new ComponentValidationException("Failed to generate self-signed certificate");
            }
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

    @Override
    public void init(Config.Scope config) {
    }

    @Override
    public void postInit(OpenfactSessionFactory factory) {
    }

    @Override
    public void close() {
    }

    @Override
    public String getId() {
        return ID;
    }

}
