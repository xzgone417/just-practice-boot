package com.exp.ucmp.replacement.dto;

import com.alibaba.excel.annotation.ExcelProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReplacementOrderExportNewDto", description = "置换单导出dto")
public class ReplacementOrderExportNewDto{

	@ApiModelProperty(value = "客户姓名")
	@ExcelProperty(value = "客户姓名", index = 0)
	private String customerName;
	
	@ApiModelProperty(value = "客户手机号")
	@ExcelProperty(value = "客户手机号", index = 1)
    private String customerIphone;
	
	@ApiModelProperty(value = "派单人id")
	@ExcelProperty(value = "派单人id", index = 2)
	private String staffCode;
	
	@ApiModelProperty(value = "派单人")
	@ExcelProperty(value = "派单人", index = 3)
	private String userName;
	
	@ApiModelProperty(value = "门店代码")
	@ExcelProperty(value = "门店代码", index = 4)
	private String orgCode;
	
	@ApiModelProperty(value = "门店名称")
	@ExcelProperty(value = "门店名称", index = 5)
	private String orgName;
	
	@ApiModelProperty(value = "派单时间")
	@ExcelProperty(value = "派单时间", index = 6)
	private String createdDate;
	
	@ApiModelProperty(value = "评估完成时间")
	@ExcelProperty(value = "评估完成时间", index = 7)
	private String quoteEndDate;
	
	@ApiModelProperty(value = "评估报价（元）")
	@ExcelProperty(value = "评估报价（元）", index = 8)
	private String quoteEndPrice;
	
	@ApiModelProperty(value = "旧车车型")
	@ExcelProperty(value = "旧车车型", index = 9)
	private String carTypeChineseDescribe;
	
	@ApiModelProperty(value = "旧车VIN")
	@ExcelProperty(value = "旧车VIN", index = 10)
	private String vinCode;
	
	@ApiModelProperty(value = "旧车表显里程")
	@ExcelProperty(value = "旧车表显里程", index = 11)
	private String drivingMileage;
	
	@ApiModelProperty(value = "收购材料上传时间")
	@ExcelProperty(value = "收购材料上传时间", index = 12)
	private String firstEscalationTime;
	
	@ApiModelProperty(value = "最终成交价")
	@ExcelProperty(value = "最终成交价", index = 13)
	private String dealPriceEnd;
	
	@ApiModelProperty(value = "过户材料上传时间")
	@ExcelProperty(value = "过户材料上传时间", index = 14)
	private String secondEscalationTime;
	
	@ApiModelProperty(value = "车商询价单状态")
	@ExcelProperty(value = "车商询价单状态", index = 15)
	private String inquiryStatus;
	
	@ApiModelProperty(value = "合作商简称")
	@ExcelProperty(value = "合作商简称", index = 16)
	private String partnerAbbreviation;
	
	@ApiModelProperty(value = "关联新车时间")
	@ExcelProperty(value = "关联新车时间", index = 17)
	private String newCarCreatedDate;
	
	@ApiModelProperty(value = "关联新车操作人ID")
	@ExcelProperty(value = "关联新车操作人ID", index = 18)
	private String newCarStaffCode;
	
	@ApiModelProperty(value = "关联新车操作人")
	@ExcelProperty(value = "关联新车操作人", index = 19)
	private String newCarStaffName;
	
	@ApiModelProperty(value = "新车订单号")
	@ExcelProperty(value = "新车订单号", index = 20)
	private String newCarOrderNo;
	
	@ApiModelProperty(value = "权益是否发放")
	@ExcelProperty(value = "权益是否发放", index = 21)
	private String rightsIssueSign;
	
	@ApiModelProperty(value = "放弃原因")
	@ExcelProperty(value = "放弃原因", index = 22)
	private String orderAbandonedReason;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerIphone() {
		return customerIphone;
	}

	public void setCustomerIphone(String customerIphone) {
		this.customerIphone = customerIphone;
	}

	public String getStaffCode() {
		return staffCode;
	}

	public void setStaffCode(String staffCode) {
		this.staffCode = staffCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getQuoteEndDate() {
		return quoteEndDate;
	}

	public void setQuoteEndDate(String quoteEndDate) {
		this.quoteEndDate = quoteEndDate;
	}

	public String getQuoteEndPrice() {
		return quoteEndPrice;
	}

	public void setQuoteEndPrice(String quoteEndPrice) {
		this.quoteEndPrice = quoteEndPrice;
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

	public String getDrivingMileage() {
		return drivingMileage;
	}

	public void setDrivingMileage(String drivingMileage) {
		this.drivingMileage = drivingMileage;
	}

	public String getFirstEscalationTime() {
		return firstEscalationTime;
	}

	public void setFirstEscalationTime(String firstEscalationTime) {
		this.firstEscalationTime = firstEscalationTime;
	}

	public String getDealPriceEnd() {
		return dealPriceEnd;
	}

	public void setDealPriceEnd(String dealPriceEnd) {
		this.dealPriceEnd = dealPriceEnd;
	}

	public String getSecondEscalationTime() {
		return secondEscalationTime;
	}

	public void setSecondEscalationTime(String secondEscalationTime) {
		this.secondEscalationTime = secondEscalationTime;
	}

	public String getInquiryStatus() {
		return inquiryStatus;
	}

	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}

	public String getPartnerAbbreviation() {
		return partnerAbbreviation;
	}

	public void setPartnerAbbreviation(String partnerAbbreviation) {
		this.partnerAbbreviation = partnerAbbreviation;
	}

	public String getNewCarCreatedDate() {
		return newCarCreatedDate;
	}

	public void setNewCarCreatedDate(String newCarCreatedDate) {
		this.newCarCreatedDate = newCarCreatedDate;
	}

	public String getNewCarStaffCode() {
		return newCarStaffCode;
	}

	public void setNewCarStaffCode(String newCarStaffCode) {
		this.newCarStaffCode = newCarStaffCode;
	}

	public String getNewCarStaffName() {
		return newCarStaffName;
	}

	public void setNewCarStaffName(String newCarStaffName) {
		this.newCarStaffName = newCarStaffName;
	}

	public String getNewCarOrderNo() {
		return newCarOrderNo;
	}

	public void setNewCarOrderNo(String newCarOrderNo) {
		this.newCarOrderNo = newCarOrderNo;
	}

	public String getRightsIssueSign() {
		return rightsIssueSign;
	}

	public void setRightsIssueSign(String rightsIssueSign) {
		this.rightsIssueSign = rightsIssueSign;
	}

	public String getOrderAbandonedReason() {
		return orderAbandonedReason;
	}

	public void setOrderAbandonedReason(String orderAbandonedReason) {
		this.orderAbandonedReason = orderAbandonedReason;
	}
	
}
