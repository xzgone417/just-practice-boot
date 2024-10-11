package com.exp.ucmp.smp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarSeriesDto", description = "基础车型")
public class CarModelDto {
	
	@ApiModelProperty(value = "销售配置ID")
	private String saleConfId;
	
	@ApiModelProperty(value = "基础车型ID")
    private String carTypeId;
	
	@ApiModelProperty(value = "基础车型编码")
    private String carTypeCode;
	
	@ApiModelProperty(value = "基础车型中文名称")
    private String carTypeCn;
	
	@ApiModelProperty(value = "基础车型英文名称")
    private String carTypeEn;
	
	@ApiModelProperty(value = "价格")
    private String price;
	
	@ApiModelProperty(value = "显示价格")
    private String showPrice;
	
	@ApiModelProperty(value = "配置List")
    private List<VeFaimlyDto> veFaimlyList;

	public String getSaleConfId() {
		return saleConfId;
	}

	public void setSaleConfId(String saleConfId) {
		this.saleConfId = saleConfId;
	}

	public String getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(String carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getCarTypeCode() {
		return carTypeCode;
	}

	public void setCarTypeCode(String carTypeCode) {
		this.carTypeCode = carTypeCode;
	}

	public String getCarTypeCn() {
		return carTypeCn;
	}

	public void setCarTypeCn(String carTypeCn) {
		this.carTypeCn = carTypeCn;
	}

	public String getCarTypeEn() {
		return carTypeEn;
	}

	public void setCarTypeEn(String carTypeEn) {
		this.carTypeEn = carTypeEn;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getShowPrice() {
		return showPrice;
	}

	public void setShowPrice(String showPrice) {
		this.showPrice = showPrice;
	}

	public List<VeFaimlyDto> getVeFaimlyList() {
		return veFaimlyList;
	}

	public void setVeFaimlyList(List<VeFaimlyDto> veFaimlyList) {
		this.veFaimlyList = veFaimlyList;
	}
	
}
