package org.openfact.models.ubl.common;

import java.math.BigDecimal;

public interface PercentType {

    BigDecimal getValue();

    void setValue(BigDecimal value);

    String getId();

    void setId(String value);

}
