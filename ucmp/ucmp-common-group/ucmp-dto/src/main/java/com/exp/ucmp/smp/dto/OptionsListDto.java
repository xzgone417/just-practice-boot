package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OptionsListDto", description = "选装List")
public class OptionsListDto {

	@ApiModelProperty(value = "特征族Id")
	private String faimlyId;
	
	@ApiModelProperty(value = "特征族编码")
    private String faimlyCode;
	
	@ApiModelProperty(value = "特征族中文名称")
    private String faimlyName;
	
	@ApiModelProperty(value = "特征族英文名称")
    private String faimlyNameEn;
	
	@ApiModelProperty(value = "特征值Id")
    private String featureId;
	
	@ApiModelProperty(value = "特征值编码")
    private String featureCode;
	
	@ApiModelProperty(value = "特征值类型")
    private String featureType;
	
	@ApiModelProperty(value = "特征值中文名称")
    private String featureName;
	
	@ApiModelProperty(value = "特征值英文名称")
    private String featureNameEn;
	
	@ApiModelProperty(value = "价格")
    private String price;
	
	@ApiModelProperty(value = "选配关系 S=标配，-=无，O=选配")
    private String relationShip;
	
	@ApiModelProperty(value = "抵用卡券名")
    private String couponName;

	public String getFaimlyId() {
		return faimlyId;
	}

	public void setFaimlyId(String faimlyId) {
		this.faimlyId = faimlyId;
	}

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

	public String getFaimlyNameEn() {
		return faimlyNameEn;
	}

	public void setFaimlyNameEn(String faimlyNameEn) {
		this.faimlyNameEn = faimlyNameEn;
	}

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public String getFeatureCode() {
		return featureCode;
	}

	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}

	public String getFeatureType() {
		return featureType;
	}

	public void setFeatureType(String featureType) {
		this.featureType = featureType;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getFeatureNameEn() {
		return featureNameEn;
	}

	public void setFeatureNameEn(String featureNameEn) {
		this.featureNameEn = featureNameEn;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
}
