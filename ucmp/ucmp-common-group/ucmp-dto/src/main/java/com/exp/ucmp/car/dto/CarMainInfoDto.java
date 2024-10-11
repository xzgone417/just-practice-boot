package com.exp.ucmp.car.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarMainInfoDto", description = "车辆基本信息实体类")
public class CarMainInfoDto {
	
	@ApiModelProperty(value = "车辆id")
    private Long stockId;
	
	@ApiModelProperty(value = "商品代码")
	private String productCode;
	
	@ApiModelProperty(value = "工程车型")
	private String carSeriesCode;
	
	@ApiModelProperty(value = "工程车型")
	private String carSeriesName;
	
	@ApiModelProperty(value = "基础车型")
	private String baseCarTypeCode;
	
	@ApiModelProperty(value = "基础车型")
	private String baseCarTypeName;
	
	@ApiModelProperty(value = "vin码")
	private String vin;
	
	@ApiModelProperty(value = "内饰色")
	private String interiorColor;
	
	@ApiModelProperty(value = "外饰色")
	private String vehicleColor;
	
	@ApiModelProperty(value = "牌照号")
	private String license;
	
	@ApiModelProperty(value = "过户次数")
	private int transfersNum;
	
	@ApiModelProperty(value = "首次上牌日期")
	private String licensedFirstDate;
	
	@ApiModelProperty(value = "牌照属地")
	private String licensedCity;
	
	@ApiModelProperty(value = "出厂日期")
	private String manufactureDate;
	
	@ApiModelProperty(value = "新车开票日期")
	private String invoiceDate;
	
	@ApiModelProperty(value = "整车质保到期日期")
	private String vehicleWarrantyDate;
	
	@ApiModelProperty(value = "交强险到期日期")
	private String insuranceDueDate;
	
	@ApiModelProperty(value = "年检到期日期")
	private String yearlyCheckDueDate;
	
	@ApiModelProperty(value = "三电质保到期日期")
	private String threePowerWarrantyDate;
	
	@ApiModelProperty(value = "表显里程")
	private String showMileage;
	
	@ApiModelProperty(value = "实际里程")
	private String actualMileage;
	
	@ApiModelProperty(value = "综合续航里程（kM）")
	private String comprehensiveRange;
	
	@ApiModelProperty(value = "电池容量（kWh）")
	private String batteryCapacity;
	
	@ApiModelProperty(value = "新车指导价")
	private String newCarPrice;
	
	@ApiModelProperty(value = "激活状态 1:已激活 0:未激活")
	private Integer activeStatus;
	
	@ApiModelProperty(value = "首次激活时间")
	private String activeTime;
	
	@ApiModelProperty(value = "车辆使用性质")
	private String usage;

	@ApiModelProperty(value = "车辆定级")
	private String carLevel;

	@ApiModelProperty(value = "车辆状态")
	private String stockState;
	
	@ApiModelProperty(value = "选装件")
	private List<OptionalPartsDto> optionalPartsList;
	
	@ApiModelProperty(value = "当前销售价")
    private Double curCarPrice;

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
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

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getInteriorColor() {
		return interiorColor;
	}

	public void setInteriorColor(String interiorColor) {
		this.interiorColor = interiorColor;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public int getTransfersNum() {
		return transfersNum;
	}

	public void setTransfersNum(int transfersNum) {
		this.transfersNum = transfersNum;
	}

	public String getLicensedFirstDate() {
		return licensedFirstDate;
	}

	public void setLicensedFirstDate(String licensedFirstDate) {
		this.licensedFirstDate = licensedFirstDate;
	}

	public String getLicensedCity() {
		return licensedCity;
	}

	public void setLicensedCity(String licensedCity) {
		this.licensedCity = licensedCity;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	public String getVehicleWarrantyDate() {
		return vehicleWarrantyDate;
	}

	public void setVehicleWarrantyDate(String vehicleWarrantyDate) {
		this.vehicleWarrantyDate = vehicleWarrantyDate;
	}

	public String getInsuranceDueDate() {
		return insuranceDueDate;
	}

	public void setInsuranceDueDate(String insuranceDueDate) {
		this.insuranceDueDate = insuranceDueDate;
	}

	public String getYearlyCheckDueDate() {
		return yearlyCheckDueDate;
	}

	public void setYearlyCheckDueDate(String yearlyCheckDueDate) {
		this.yearlyCheckDueDate = yearlyCheckDueDate;
	}

	public String getThreePowerWarrantyDate() {
		return threePowerWarrantyDate;
	}

	public void setThreePowerWarrantyDate(String threePowerWarrantyDate) {
		this.threePowerWarrantyDate = threePowerWarrantyDate;
	}

	public String getShowMileage() {
		return showMileage;
	}

	public void setShowMileage(String showMileage) {
		this.showMileage = showMileage;
	}

	public String getActualMileage() {
		return actualMileage;
	}

	public void setActualMileage(String actualMileage) {
		this.actualMileage = actualMileage;
	}

	public String getComprehensiveRange() {
		return comprehensiveRange;
	}

	public void setComprehensiveRange(String comprehensiveRange) {
		this.comprehensiveRange = comprehensiveRange;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getNewCarPrice() {
		return newCarPrice;
	}

	public void setNewCarPrice(String newCarPrice) {
		this.newCarPrice = newCarPrice;
	}

	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getCarLevel() {
		return carLevel;
	}

	public void setCarLevel(String carLevel) {
		this.carLevel = carLevel;
	}

	public String getStockState() {
		return stockState;
	}

	public void setStockState(String stockState) {
		this.stockState = stockState;
	}

	public List<OptionalPartsDto> getOptionalPartsList() {
		return optionalPartsList;
	}

	public void setOptionalPartsList(List<OptionalPartsDto> optionalPartsList) {
		this.optionalPartsList = optionalPartsList;
	}

	public Double getCurCarPrice() {
		return curCarPrice;
	}

	public void setCurCarPrice(Double curCarPrice) {
		this.curCarPrice = curCarPrice;
	}
}
