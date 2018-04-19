package org.openfact.pe.models.utils;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ResponseType;
import org.openfact.core.models.ModelRuntimeException;
import org.openfact.core.utils.files.UncompressFileProvider;
import org.openfact.core.utils.files.UncompressFileProviderFactory;
import org.openfact.core.utils.files.exceptions.NotReadableCompressFileException;

import javax.xml.bind.JAXBException;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SunatUtils {

    private SunatUtils() {
        // Just utils class
    }

    public static String getNumeroSerie(String serie) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(serie);
        String numeroSerie = null;
        while (matcher.find()) {
            numeroSerie = matcher.group();
        }
        if (numeroSerie == null) {
            throw new IllegalStateException("Serie Invalida, no se pudo extraer el Numero de Serie");
        }

        return numeroSerie;
    }

    public static String incrementarSerie(String serie) {
        String numeroSerie = getNumeroSerie(serie);
        String prefijoSerie = serie.replaceFirst(numeroSerie, "");
        return prefijoSerie + (Integer.parseInt(numeroSerie) + 1);
    }

    public static String getSerieConCerosCompletados(String serie, int n) {
        String numeroSerie = getNumeroSerie(serie);
        String prefijoSerie = serie.replaceFirst(numeroSerie, "");

        int longitud = numeroSerie.length() + prefijoSerie.length();
        if (4 > longitud) {
            int cerosFaltantes = n - longitud + 1;
            numeroSerie = String.format("%0" + cerosFaltantes + "d", Integer.parseInt(numeroSerie));
        }

        return prefijoSerie + numeroSerie;
    }
}
