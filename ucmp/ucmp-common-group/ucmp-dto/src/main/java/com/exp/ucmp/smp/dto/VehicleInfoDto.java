package com.exp.ucmp.smp.dto;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VehicleInfoDto", description = "车辆信息返回类")
public class VehicleInfoDto {

	@ApiModelProperty(value = "车辆vin")
	private String vin;
	
	@ApiModelProperty(value = "电机号")
    private String engineNo;
	
	@ApiModelProperty(value = "合格证")
    private String vehicleModel;
	
	@ApiModelProperty(value = "车辆销售发票代码")
    private String invoiceNo;
	
	@ApiModelProperty(value = "开票日期")
    private String invoiceDate;
	
	@ApiModelProperty(value = "车辆销售发票金额")
    private String invoiceAmount;
	
	@ApiModelProperty(value = "工程车型编码")
    private String carSeriesCode;
	
	@ApiModelProperty(value = "工程车型名称")
    private String carSeriesCn;
	
	@ApiModelProperty(value = "车型年")
    private String modelYear;
	
	@ApiModelProperty(value = "基础车型编码")
    private String carTypeCode;
	
	@ApiModelProperty(value = "基础车型名称")
    private String carType;
	
	@ApiModelProperty(value = "外色名称")
    private String carColorName;
	
	@ApiModelProperty(value = "外色code")
    private String carColorCode;
	
	@ApiModelProperty(value = "内饰色名称")
    private String carIncolorName;
	
	@ApiModelProperty(value = "内饰色code")
    private String carIncolorCode;
	
	@ApiModelProperty(value = "选装List")
    private List<OptionsListDto> optionsList;
	
	@ApiModelProperty(value = "MSRP价格")
    private BigDecimal actualPrice;
	
	@ApiModelProperty(value = "车辆标识: 1-库存车；2-展车；3-试驾车 注：1-商品车；2或3是内部车")
    private String carFlag;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getEngineNo() {
		return engineNo;
	}

	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getCarSeriesCode() {
		return carSeriesCode;
	}

	public void setCarSeriesCode(String carSeriesCode) {
		this.carSeriesCode = carSeriesCode;
	}

	public String getCarSeriesCn() {
		return carSeriesCn;
	}

	public void setCarSeriesCn(String carSeriesCn) {
		this.carSeriesCn = carSeriesCn;
	}

	public String getModelYear() {
		return modelYear;
	}

	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	public String getCarTypeCode() {
		return carTypeCode;
	}

	public void setCarTypeCode(String carTypeCode) {
		this.carTypeCode = carTypeCode;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarColorName() {
		return carColorName;
	}

	public void setCarColorName(String carColorName) {
		this.carColorName = carColorName;
	}

	public String getCarColorCode() {
		return carColorCode;
	}

	public void setCarColorCode(String carColorCode) {
		this.carColorCode = carColorCode;
	}

	public String getCarIncolorName() {
		return carIncolorName;
	}

	public void setCarIncolorName(String carIncolorName) {
		this.carIncolorName = carIncolorName;
	}

	public String getCarIncolorCode() {
		return carIncolorCode;
	}

	public void setCarIncolorCode(String carIncolorCode) {
		this.carIncolorCode = carIncolorCode;
	}

	public List<OptionsListDto> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(List<OptionsListDto> optionsList) {
		this.optionsList = optionsList;
	}

	public BigDecimal getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(BigDecimal actualPrice) {
		this.actualPrice = actualPrice;
	}

	public String getCarFlag() {
		return carFlag;
	}

	public void setCarFlag(String carFlag) {
		this.carFlag = carFlag;
	}
}
