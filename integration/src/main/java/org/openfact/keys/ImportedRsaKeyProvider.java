package org.openfact.keys;

import org.openfact.models.OrganizationModel;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.List;

public class ImportedRsaKeyProvider extends AbstractRsaKeyProvider {

    @Override
    public PrivateKey getPrivateKey() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PublicKey getPublicKey(String kid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public X509Certificate getCertificate(String kid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getKid() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<RsaKeyMetadata> getKeyMetadata() {
        // TODO Auto-generated method stub
        return null;
    }

//    public ImportedRsaKeyProvider(OrganizationModel realm, ComponentModel model) {
//        super(realm, model);
//    }
//
//    @Override
//    public Keys loadKeys(OrganizationModel realm, ComponentModel model) {
//        String privateRsaKeyPem = model.getConfig().getFirst(Attributes.PRIVATE_KEY_KEY);
//        String certificatePem = model.getConfig().getFirst(Attributes.CERTIFICATE_KEY);
//
//        PrivateKey privateKey = PemUtils.decodePrivateKey(privateRsaKeyPem);
//        PublicKey publicKey = KeyUtils.extractPublicKey(privateKey);
//
//        KeyPair keyPair = new KeyPair(publicKey, privateKey);
//        X509Certificate certificate = PemUtils.decodeCertificate(certificatePem);
//
//        String kid = KeyUtils.createKeyId(keyPair.getPublic());
//
//        return new Keys(kid, keyPair, certificate);
//    }

}
