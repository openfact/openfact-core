package org.openfact.models.ubl.common;

public interface BinaryObjectType {

    byte[] getValue();

    void setValue(byte[] value);

    String getFormat();

    void setFormat(String value);

    Byte[] getMimeCode();

    void setMimeCode(Byte[] value);

    String getEncodingCode();

    void setEncodingCode(String value);

    String getCharacterSetCode();

    void setCharacterSetCode(String value);

    String getUri();

    void setUri(String value);

    String getFilename();

    void setFilename(String value);

    String getId();

    void setId(String value);

}
