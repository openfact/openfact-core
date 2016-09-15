package org.openfact.models.ubl.common;

import java.util.List;

public interface GoodsItemModel {

    String getID();

    void setID(String value);

    String getSequenceNumberID();

    void setSequenceNumberID(String value);

    List<String> getDescription();

    void setDescription(List<String> description);

    boolean getHazardousRiskIndicator();

    void setHazardousRiskIndicator(boolean value);

    DeclaredCustomsValueAmountModel getDeclaredCustomsValueAmount();

    void setDeclaredCustomsValueAmount(DeclaredCustomsValueAmountModel value);

    DeclaredForCarriageValueAmountModel getDeclaredForCarriageValueAmount();

    void setDeclaredForCarriageValueAmount(DeclaredForCarriageValueAmountModel value);

    DeclaredStatisticsValueAmountModel getDeclaredStatisticsValueAmount();

    void setDeclaredStatisticsValueAmount(DeclaredStatisticsValueAmountModel value);

    FreeOnBoardValueAmountModel getFreeOnBoardValueAmount();

    void setFreeOnBoardValueAmount(FreeOnBoardValueAmountModel value);

    InsuranceValueAmountModel getInsuranceValueAmount();

    void setInsuranceValueAmount(InsuranceValueAmountModel value);

    ValueAmountModel getValueAmount();

    void setValueAmount(ValueAmountModel value);

    GrossWeightMeasureModel getGrossWeightMeasure();

    void setGrossWeightMeasure(GrossWeightMeasureModel value);

    NetWeightMeasureModel getNetWeightMeasure();

    void setNetWeightMeasure(NetWeightMeasureModel value);

    NetNetWeightMeasureModel getNetNetWeightMeasure();

    void setNetNetWeightMeasure(NetNetWeightMeasureModel value);

    ChargeableWeightMeasureModel getChargeableWeightMeasure();

    void setChargeableWeightMeasure(ChargeableWeightMeasureModel value);

    GrossVolumeMeasureModel getGrossVolumeMeasure();

    void setGrossVolumeMeasure(GrossVolumeMeasureModel value);

    NetVolumeMeasureModel getNetVolumeMeasure();

    void setNetVolumeMeasure(NetVolumeMeasureModel value);

    QuantityModelCommBas getQuantity();

    void setQuantity(QuantityModelCommBas value);

    String getPreferenceCriterionCode();

    void setPreferenceCriterionCode(String value);

    String getRequiredCustomsID();

    void setRequiredCustomsID(String value);

    String getCustomsStatusCode();

    void setCustomsStatusCode(String value);

    CustomsTariffQuantityModel getCustomsTariffQuantity();

    void setCustomsTariffQuantity(CustomsTariffQuantityModel value);

    boolean getCustomsImportClassifiedIndicator();

    void setCustomsImportClassifiedIndicator(boolean value);

    List<ItemModel> getItem();

    void setItem(List<ItemModel> item);

    List<GoodsItemContainerModel> getGoodsItemContainer();

    void setGoodsItemContainer(List<GoodsItemContainerModel> goodsItemContainer);

    List<AllowanceChargeModel> getFreightAllowanceCharge();

    void setFreightAllowanceCharge(List<AllowanceChargeModel> freightAllowanceCharge);

    List<InvoiceLineModel> getInvoiceLine();

    void setInvoiceLine(List<InvoiceLineModel> invoiceLine);

    List<TemperatureModel> getTemperature();

    void setTemperature(List<TemperatureModel> temperature);

    List<GoodsItemModel> getContainedGoodsItem();

    void setContainedGoodsItem(List<GoodsItemModel> containedGoodsItem);

    AddressModel getOriginAddress();

    void setOriginAddress(AddressModel value);

    String getId();

    void setId(String value);

}
