package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarInsuranceDto", description = "保险")
public class CarInsuranceDto {
	
	@ApiModelProperty(value = "是否有服务包")
	private String servicePkgFlag;
	
	@ApiModelProperty(value = "签单时间")
    private String issueTime;
	
	@ApiModelProperty(value = "新续标识 NEW:新保 ，RENEW：续保")
    private String renewFlag;
	
	@ApiModelProperty(value = "省份名称")
    private String provinceDesc;
	
	@ApiModelProperty(value = "城市名称")
    private String cityDesc;
	
	@ApiModelProperty(value = "初登日期")
    private String registerDate;
	
	@ApiModelProperty(value = "车辆使用性质")
    private String usage;
	
	@ApiModelProperty(value = "投保单号")
    private String applicationNo;
	
	@ApiModelProperty(value = "保单号")
    private String policyNo;
	
	@ApiModelProperty(value = "起保时间")
    private String startDate;
	
	@ApiModelProperty(value = "终保时间")
    private String endDate;
	
	@ApiModelProperty(value = "折扣系数 保留小数后8位")
    private String discount;
	
	@ApiModelProperty(value = "实际保费")
    private String actualPremium;
	
	@ApiModelProperty(value = "印花税")
    private String stampTaxAmount;
	
	@ApiModelProperty(value = "生效时间")
    private String enforceTime;
	
	@ApiModelProperty(value = "保单介质 PAPER:监制保单 ，ARBITRATION：仲裁")
    private String policyMedium;
	
	@ApiModelProperty(value = "险种 1:交强险 2:商业险")
    private String insuranceItem;
	
	@ApiModelProperty(value = "车牌号")
	private String carLincense;

	public String getServicePkgFlag() {
		return servicePkgFlag;
	}

	public void setServicePkgFlag(String servicePkgFlag) {
		this.servicePkgFlag = servicePkgFlag;
	}

	public String getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(String issueTime) {
		this.issueTime = issueTime;
	}

	public String getRenewFlag() {
		return renewFlag;
	}

	public void setRenewFlag(String renewFlag) {
		this.renewFlag = renewFlag;
	}

	public String getProvinceDesc() {
		return provinceDesc;
	}

	public void setProvinceDesc(String provinceDesc) {
		this.provinceDesc = provinceDesc;
	}

	public String getCityDesc() {
		return cityDesc;
	}

	public void setCityDesc(String cityDesc) {
		this.cityDesc = cityDesc;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getActualPremium() {
		return actualPremium;
	}

	public void setActualPremium(String actualPremium) {
		this.actualPremium = actualPremium;
	}

	public String getStampTaxAmount() {
		return stampTaxAmount;
	}

	public void setStampTaxAmount(String stampTaxAmount) {
		this.stampTaxAmount = stampTaxAmount;
	}

	public String getEnforceTime() {
		return enforceTime;
	}

	public void setEnforceTime(String enforceTime) {
		this.enforceTime = enforceTime;
	}

	public String getPolicyMedium() {
		return policyMedium;
	}

	public void setPolicyMedium(String policyMedium) {
		this.policyMedium = policyMedium;
	}

	public String getInsuranceItem() {
		return insuranceItem;
	}

	public void setInsuranceItem(String insuranceItem) {
		this.insuranceItem = insuranceItem;
	}

	public String getCarLincense() {
		return carLincense;
	}

	public void setCarLincense(String carLincense) {
		this.carLincense = carLincense;
	}
	
}
