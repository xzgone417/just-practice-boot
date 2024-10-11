package com.exp.ucmp.replacement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


import org.springframework.format.annotation.DateTimeFormat;


@ApiModel(value = "OldCarInfoDto", description = "旧车信息实体类")
public class OldCarInfoDto {
	
	@ApiModelProperty(value = "旧车品牌")
	private String brand;
	
	@ApiModelProperty(value = "旧车品牌名称")
	private String brandChineseDescribe;
	
    @ApiModelProperty(value = "车系")
    private String carSeries;
	
	@ApiModelProperty(value = "旧车车系名称")
	private String carSeriesChineseDescribe;
	
	@ApiModelProperty(value = "年款")
    private String carYear;
	
	@ApiModelProperty(value = "旧车年款")
	private String carYearChineseDescribe;
	
	@ApiModelProperty(value = "车型")
    private String carType;
	
	@ApiModelProperty(value = "旧车车型名称")
	private String carTypeChineseDescribe;
	
	@ApiModelProperty(value = "旧车VIN")
	private String vinCode;
	
	@ApiModelProperty(value = "旧车车牌号")
	private String licensePlateNum;
	
	@ApiModelProperty(value = "旧车颜色代码")
	private String color;
	
	@ApiModelProperty(value = "旧车颜色名称")
	private String colorName;
	
	@ApiModelProperty(value = "旧车使用性质代码")
	private String usingNature;
	
	@ApiModelProperty(value = "旧车使用性质名称")
	private String usingNatureName;
	
	@ApiModelProperty(value = "旧车过户次数")
	private String transferTimes;
	
	@ApiModelProperty(value = "旧车行驶里程")
	private String drivingMileage;
	
	@ApiModelProperty(value = "上牌时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String licensingDate;
	
	@ApiModelProperty(value = "车辆定级")
	private String rank;
	
    @ApiModelProperty(value = "报价价格")
    private Long quoteEndPrice;
    
    @ApiModelProperty(value = "车辆主体")
    private String revertBody;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getBrandChineseDescribe() {
		return brandChineseDescribe;
	}

	public void setBrandChineseDescribe(String brandChineseDescribe) {
		this.brandChineseDescribe = brandChineseDescribe;
	}

	public String getCarSeries() {
		return carSeries;
	}

	public void setCarSeries(String carSeries) {
		this.carSeries = carSeries;
	}

	public String getCarSeriesChineseDescribe() {
		return carSeriesChineseDescribe;
	}

	public void setCarSeriesChineseDescribe(String carSeriesChineseDescribe) {
		this.carSeriesChineseDescribe = carSeriesChineseDescribe;
	}

	public String getCarYear() {
		return carYear;
	}

	public void setCarYear(String carYear) {
		this.carYear = carYear;
	}

	public String getCarYearChineseDescribe() {
		return carYearChineseDescribe;
	}

	public void setCarYearChineseDescribe(String carYearChineseDescribe) {
		this.carYearChineseDescribe = carYearChineseDescribe;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarTypeChineseDescribe() {
		return carTypeChineseDescribe;
	}

	public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
		this.carTypeChineseDescribe = carTypeChineseDescribe;
	}

	public String getVinCode() {
		return vinCode;
	}

	public void setVinCode(String vinCode) {
		this.vinCode = vinCode;
	}

	public String getLicensePlateNum() {
		return licensePlateNum;
	}

	public void setLicensePlateNum(String licensePlateNum) {
		this.licensePlateNum = licensePlateNum;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUsingNature() {
		return usingNature;
	}

	public void setUsingNature(String usingNature) {
		this.usingNature = usingNature;
	}

	public String getTransferTimes() {
		return transferTimes;
	}

	public void setTransferTimes(String transferTimes) {
		this.transferTimes = transferTimes;
	}

	public String getDrivingMileage() {
		return drivingMileage;
	}

	public void setDrivingMileage(String drivingMileage) {
		this.drivingMileage = drivingMileage;
	}

	public String getLicensingDate() {
		return licensingDate;
	}

	public void setLicensingDate(String licensingDate) {
		this.licensingDate = licensingDate;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Long getQuoteEndPrice() {
		return quoteEndPrice;
	}

	public void setQuoteEndPrice(Long quoteEndPrice) {
		this.quoteEndPrice = quoteEndPrice;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getUsingNatureName() {
		return usingNatureName;
	}

	public void setUsingNatureName(String usingNatureName) {
		this.usingNatureName = usingNatureName;
	}

	public String getRevertBody() {
		return revertBody;
	}

	public void setRevertBody(String revertBody) {
		this.revertBody = revertBody;
	}
	
}
