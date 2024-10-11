package com.exp.ucmp.contract.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarInfoDto", description = "车辆信息类")
public class CarInfoDto {
	
	@ApiModelProperty(value = "车型")
    private String carSeriesName;
	
	@ApiModelProperty(value = "车架号")
    private String vinCode;
	
	@ApiModelProperty(value = "配置")
	private String baseCarTypeName;
	
	@ApiModelProperty(value = "内饰")
	private String interiorColor;
	
	@ApiModelProperty(value = "颜色")
	private String carColour;
	
	@ApiModelProperty(value = "新车指导价")
	private String newCarPrice;
	
	@ApiModelProperty(value = "首次上牌时间")
	private String firstLicenseDate;
	
	@ApiModelProperty(value = "行驶里程")
	private String stockMileage;
	
	@ApiModelProperty(value = "价格")
	private Double salePrice;

	public String getCarSeriesName() {
		return carSeriesName;
	}

	public void setCarSeriesName(String carSeriesName) {
		this.carSeriesName = carSeriesName;
	}

	public String getVinCode() {
		return vinCode;
	}

	public void setVinCode(String vinCode) {
		this.vinCode = vinCode;
	}

	public String getBaseCarTypeName() {
		return baseCarTypeName;
	}

	public void setBaseCarTypeName(String baseCarTypeName) {
		this.baseCarTypeName = baseCarTypeName;
	}

	public String getInteriorColor() {
		return interiorColor;
	}

	public void setInteriorColor(String interiorColor) {
		this.interiorColor = interiorColor;
	}

	public String getCarColour() {
		return carColour;
	}

	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}

	public String getNewCarPrice() {
		return newCarPrice;
	}

	public void setNewCarPrice(String newCarPrice) {
		this.newCarPrice = newCarPrice;
	}

	public String getFirstLicenseDate() {
		return firstLicenseDate;
	}

	public void setFirstLicenseDate(String firstLicenseDate) {
		this.firstLicenseDate = firstLicenseDate;
	}

	public String getStockMileage() {
		return stockMileage;
	}

	public void setStockMileage(String stockMileage) {
		this.stockMileage = stockMileage;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

}
