package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface MeasureType {

    BigDecimal getValue();

    void setValue(BigDecimal value);

    String getUnitCode();

    void setUnitCode(String value);

    String getId();

    void setId(String value);

}
