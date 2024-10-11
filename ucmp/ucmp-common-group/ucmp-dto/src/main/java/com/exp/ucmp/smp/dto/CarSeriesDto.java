package com.exp.ucmp.smp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarSeriesDto", description = "工程车型")
public class CarSeriesDto {
	
	@ApiModelProperty(value = "销售配置ID")
	private String saleConfId;
	
	@ApiModelProperty(value = "工程车型编码")
    private String carSeriesCode;
	
	@ApiModelProperty(value = "工程车型中文名称")
    private String carSeriesCn;
	
	@ApiModelProperty(value = "工程车型英文名称")
    private String carSeriesEn;
	
	@ApiModelProperty(value = "车型大定金额")
    private double carDeposit;
	
	@ApiModelProperty(value = "车型意向金金额")
    private double intentionMoney;
	
	@ApiModelProperty(value = "车型大定显示金额")
    private String showCarDeposit;
	
	@ApiModelProperty(value = "车型意向金显示金额")
    private String showIntentionMoney;
	
	@ApiModelProperty(value = "基础车型List")
    private List<CarModelDto> veTypeList;

	public String getSaleConfId() {
		return saleConfId;
	}

	public void setSaleConfId(String saleConfId) {
		this.saleConfId = saleConfId;
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

	public String getCarSeriesEn() {
		return carSeriesEn;
	}

	public void setCarSeriesEn(String carSeriesEn) {
		this.carSeriesEn = carSeriesEn;
	}

	public double getCarDeposit() {
		return carDeposit;
	}

	public void setCarDeposit(double carDeposit) {
		this.carDeposit = carDeposit;
	}

	public double getIntentionMoney() {
		return intentionMoney;
	}

	public void setIntentionMoney(double intentionMoney) {
		this.intentionMoney = intentionMoney;
	}

	public String getShowCarDeposit() {
		return showCarDeposit;
	}

	public void setShowCarDeposit(String showCarDeposit) {
		this.showCarDeposit = showCarDeposit;
	}

	public String getShowIntentionMoney() {
		return showIntentionMoney;
	}

	public void setShowIntentionMoney(String showIntentionMoney) {
		this.showIntentionMoney = showIntentionMoney;
	}

	public List<CarModelDto> getVeTypeList() {
		return veTypeList;
	}

	public void setVeTypeList(List<CarModelDto> veTypeList) {
		this.veTypeList = veTypeList;
	}
	
}
