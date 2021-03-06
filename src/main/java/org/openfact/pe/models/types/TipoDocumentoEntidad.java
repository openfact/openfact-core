package org.openfact.pe.models.types;

import java.util.Optional;
import java.util.stream.Stream;

public enum TipoDocumentoEntidad {

    DOC_TRIB_NO_DOM_SIN_RUC("0", "NO DOMICILIADO", "DOC. TRIBUTARIO NO DOMICILIADO SIN RUC", 8),
    DNI("1", "DNI", "DOC.NACIONAL DE IDENTIDAD", 8),
    EXTRANJERIA("4", "C.EXTRANJERIA", "CARNET DE EXTRANJERIA", 20),
    RUC("6", "RUC", "REGISTRO UNICO DE CONTRIBUYENTE", 11),
    PASAPORTE("7", "PASS.", "PASAPORT", 7),
    DEC_DIPLOMATICA("A", "CED.DIPLOMATICA", "CEDULA DIPLOMATICA DE IDENTIDAD", 0),
    NO_IDENTIFICADO_EXPORTACION("-", "NO IDENTIFICADO POR EXPORTACION", "NO IDENTIFICADO POR EXPORTACION", 1);

    private final String codigo;
    private final String abreviatura;
    private final String denominacion;
    private final int length;

    public String getCodigo() {
        return codigo;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public int getLength() {
        return length;
    }

    TipoDocumentoEntidad(String codigo, String abreviatura, String denominacion, int length) {
        this.codigo = codigo;
        this.abreviatura = abreviatura;
        this.denominacion = denominacion;
        this.length = length;
    }

    public static Optional<TipoDocumentoEntidad> getByCode(String codigo) {
        return Stream.of(TipoDocumentoEntidad.values()).filter(p -> p.getCodigo().equals(codigo)).findFirst();
    }
}
