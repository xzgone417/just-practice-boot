package com.exp.ucmp.replacement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

@ApiModel(value = "AcquisitionRecordDto", description = "收购记录实体类")
public class AcquisitionRecordDto {
	
	@ApiModelProperty(value = "原因")
	private String reason;

	@ApiModelProperty(value = "报价商户名称")
	private String quoteMerchantsName;
	
	@ApiModelProperty(value = "最优价")
	private String estimateDealPrice;
	
	@ApiModelProperty(value = "客户是否同意价格")
	private String customerIntention;
	
	@ApiModelProperty(value = "同意日期")
	private String createdDate;
	
	@ApiModelProperty(value = "车商收购日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String generateAcquisitionsTime;
	
	@ApiModelProperty(value = "车商收购状态")
	private String acquisitionStatus;
	
	@ApiModelProperty(value = "审批状态")
	private String approvalStatus;
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getQuoteMerchantsName() {
		return quoteMerchantsName;
	}

	public void setQuoteMerchantsName(String quoteMerchantsName) {
		this.quoteMerchantsName = quoteMerchantsName;
	}

	public String getEstimateDealPrice() {
		return estimateDealPrice;
	}

	public void setEstimateDealPrice(String estimateDealPrice) {
		this.estimateDealPrice = estimateDealPrice;
	}

	public String getCustomerIntention() {
		return customerIntention;
	}

	public void setCustomerIntention(String customerIntention) {
		this.customerIntention = customerIntention;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getGenerateAcquisitionsTime() {
		return generateAcquisitionsTime;
	}

	public void setGenerateAcquisitionsTime(String generateAcquisitionsTime) {
		this.generateAcquisitionsTime = generateAcquisitionsTime;
	}

	public String getAcquisitionStatus() {
		return acquisitionStatus;
	}

	public void setAcquisitionStatus(String acquisitionStatus) {
		this.acquisitionStatus = acquisitionStatus;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
}
