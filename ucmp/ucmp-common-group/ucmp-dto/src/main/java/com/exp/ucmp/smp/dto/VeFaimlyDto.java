package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VeFaimlyDto", description = "车型配置")
public class VeFaimlyDto {
	
	@ApiModelProperty(value = "特征族Id")
	private String faimlyId;
	
	@ApiModelProperty(value = "特征族中文名称")
    private String faimlyName;
	
	@ApiModelProperty(value = "特征族英文名称")
    private String faimlyNameEn;
	
	@ApiModelProperty(value = "特征族选项类型")
    private int optionType;
	
	@ApiModelProperty(value = "特征值ID")
    private String featureId;
	
	@ApiModelProperty(value = "特征值中文名称")
    private String featureName;
	
	@ApiModelProperty(value = "特征值英文名称")
    private String featureNameEn;
	
	@ApiModelProperty(value = "选配关系")
    private String relationShip;
	
	@ApiModelProperty(value = "特征价格")
    private String price;
	
	@ApiModelProperty(value = "特征显示价格")
    private String showPrice;
	
	@ApiModelProperty(value = "特征族编码")
    private String faimlyCode;
	
	@ApiModelProperty(value = "特征值编码")
    private String featureCode;

	public String getFaimlyId() {
		return faimlyId;
	}

	public void setFaimlyId(String faimlyId) {
		this.faimlyId = faimlyId;
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

	public int getOptionType() {
		return optionType;
	}

	public void setOptionType(int optionType) {
		this.optionType = optionType;
	}

	public String getFeatureId() {
		return featureId;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
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

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
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

	public String getFaimlyCode() {
		return faimlyCode;
	}

	public void setFaimlyCode(String faimlyCode) {
		this.faimlyCode = faimlyCode;
	}

	public String getFeatureCode() {
		return featureCode;
	}

	public void setFeatureCode(String featureCode) {
		this.featureCode = featureCode;
	}
	
}
