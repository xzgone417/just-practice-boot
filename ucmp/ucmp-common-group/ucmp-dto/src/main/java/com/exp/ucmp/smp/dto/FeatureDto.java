package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FeatureDto", description = "选装信息")
public class FeatureDto {
	
	@ApiModelProperty(value = "特征族编码")
	private String faimlyCode;
	
	@ApiModelProperty(value = "特征族中文名称")
    private String faimlyName;
	
	@ApiModelProperty(value = "特征值编码")
    private String featureCode;
	
	@ApiModelProperty(value = "特征值中文名称")
    private String featureName;
	
	@ApiModelProperty(value = "特征价格")
    private String price;
	
	@ApiModelProperty(value = "抵用卡券名")
    private String couponName;

	public String getFaimlyCode() {
		return faimlyCode;
	}

	public void setFaimlyCode(String faimlyCode) {
		this.faimlyCode = faimlyCode;
	}

	public String getFaimlyName() {
		return faimlyName;
	}

	public void setFaimlyName(String faimlyName) {
		this.faimlyName = faimlyName;
	}

	public String getFeatureCode() {
		return featureCode;
	}

	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
    
}
