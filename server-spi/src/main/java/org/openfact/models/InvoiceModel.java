package org.openfact.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.openfact.models.enums.AdditionalInformationType;
import org.openfact.models.enums.InvoiceType;
import org.openfact.models.enums.MonetaryTotalType;

public interface InvoiceModel {

    String TYPE = "type";
    String CURRENCY_CODE = "currencyCode";

    String getId();

    LocalDate getIssueDate();

    String getCurrencyCode();

    InvoiceType getInvoiceType();

    InvoiceIdModel getInvoiceId();

    void setInvoiceId(InvoiceIdModel invoiceId);

    CustomerModel getCustomer();

    void setCustomer(CustomerModel customer);

    Map<AdditionalInformationType, BigDecimal> getAdditionalInformation();

    void addAdditionalInformation(AdditionalInformationType type, BigDecimal ammount);

    Map<MonetaryTotalType, BigDecimal> getLegalMonetaryTotal();

    void addLegalMonetaryTotal(MonetaryTotalType type, BigDecimal ammount);

    OrganizationModel getOrganization();

    /*
     * InvoiceId resources
     */
    InvoiceIdModel registerInvoiceId(InvoiceModel invoice, int series, int number);

    /*
     * Customer resources
     */
    CustomerModel registerCustomer(InvoiceModel invoice, String registrationName);

    /*
     * Invoice lines
     */
    List<InvoiceLineModel> getInvoiceLines();

    InvoiceLineModel addInvoiceLine(BigDecimal ammount, BigDecimal quantity, String description);

}
