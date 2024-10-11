package com.exp.ucmp.car.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QueryChangePriceDto", description = "查询改价审批返回类")
public class QueryChangePriceDto {
	
	@ApiModelProperty(value = "库存车辆id")
    private Long stockId;
	
	@ApiModelProperty(value = "改价记录id")
    private Long recordId;
	
	@ApiModelProperty(value = "车辆类型code")
	private String carType;
	
	@ApiModelProperty(value = "车辆类型名称")
	private String carTypeName;
	
	@ApiModelProperty(value = "归属主体code")
	private String revertBody;
	
	@ApiModelProperty(value = "归属主体名称")
	private String revertBodyName;
	
	@ApiModelProperty(value = "vin码")
	private String vin;
	
	@ApiModelProperty(value = "商品编号")
	private String productCode;
	
	@ApiModelProperty(value = "采购价")
	private Double purchasePrice;
	
	@ApiModelProperty(value = "模型价格")
	private Double suggestedPrice;
	
	@ApiModelProperty(value = "申请价格")
	private Double changePrice;
	
	@ApiModelProperty(value = "车辆级别（S、A、B、C）")
	private String carLevel;
	
	@ApiModelProperty(value = "决策类型code")
	private String decisionType;
	
	@ApiModelProperty(value = "决策类型名称")
	private String decisionTypeName;
	
	@ApiModelProperty(value = "入库时间")
	private String warehousDate;
	
	@ApiModelProperty(value = "首次上牌日期")
	private String firstLicenseDate;
	
	@ApiModelProperty(value = "车龄(天)")
    private Integer carAge;

    @ApiModelProperty(value = "库龄(天)")
    private Integer stockAge;
	
	@ApiModelProperty(value = "工程车型code")
	private String carSeriesCode;
	
	@ApiModelProperty(value = "工程车型名称")
    private String carSeriesName;
	
	@ApiModelProperty(value = "基础车型code")
	private String baseCarTypeCode;
	
	@ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;
	
	@ApiModelProperty(value = "外色")
    private String carColour;
	
	@ApiModelProperty(value = "审批状态")
    private Integer approveStatus;
	
	@ApiModelProperty(value = "审批状态名称")
    private String approveStatusName;

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public String getRevertBody() {
		return revertBody;
	}

	public void setRevertBody(String revertBody) {
		this.revertBody = revertBody;
	}

	public String getRevertBodyName() {
		return revertBodyName;
	}

	public void setRevertBodyName(String revertBodyName) {
		this.revertBodyName = revertBodyName;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getSuggestedPrice() {
		return suggestedPrice;
	}

	public void setSuggestedPrice(Double suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}

	public Double getChangePrice() {
		return changePrice;
	}

	public void setChangePrice(Double changePrice) {
		this.changePrice = changePrice;
	}

	public String getCarLevel() {
		return carLevel;
	}

	public void setCarLevel(String carLevel) {
		this.carLevel = carLevel;
	}

	public String getDecisionType() {
		return decisionType;
	}

	public void setDecisionType(String decisionType) {
		this.decisionType = decisionType;
	}

	public String getDecisionTypeName() {
		return decisionTypeName;
	}

	public void setDecisionTypeName(String decisionTypeName) {
		this.decisionTypeName = decisionTypeName;
	}

	public String getWarehousDate() {
		return warehousDate;
	}

	public void setWarehousDate(String warehousDate) {
		this.warehousDate = warehousDate;
	}

	public String getFirstLicenseDate() {
		return firstLicenseDate;
	}

	public void setFirstLicenseDate(String firstLicenseDate) {
		this.firstLicenseDate = firstLicenseDate;
	}

	public Integer getCarAge() {
		return carAge;
	}

	public void setCarAge(Integer carAge) {
		this.carAge = carAge;
	}

	public Integer getStockAge() {
		return stockAge;
	}

	public void setStockAge(Integer stockAge) {
		this.stockAge = stockAge;
	}

	public String getCarSeriesCode() {
		return carSeriesCode;
	}

	public void setCarSeriesCode(String carSeriesCode) {
		this.carSeriesCode = carSeriesCode;
	}

	public String getCarSeriesName() {
		return carSeriesName;
	}

	public void setCarSeriesName(String carSeriesName) {
		this.carSeriesName = carSeriesName;
	}

	public String getBaseCarTypeCode() {
		return baseCarTypeCode;
	}

	public void setBaseCarTypeCode(String baseCarTypeCode) {
		this.baseCarTypeCode = baseCarTypeCode;
	}

	public String getBaseCarTypeName() {
		return baseCarTypeName;
	}

	public void setBaseCarTypeName(String baseCarTypeName) {
		this.baseCarTypeName = baseCarTypeName;
	}

	public String getCarColour() {
		return carColour;
	}

	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}

	public Integer getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Integer approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getApproveStatusName() {
		return approveStatusName;
	}

	public void setApproveStatusName(String approveStatusName) {
		this.approveStatusName = approveStatusName;
	}

}
