package com.exp.ucmp.replacement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

@ApiModel(value = "TakeOrdersDto", description = "接单记录实体类")
public class TakeOrdersDto {

	@ApiModelProperty(value = "原因")
	private String reason;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@ApiModelProperty(value = "下发给车商时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String issuedCarDealerDate;
	
	@ApiModelProperty(value = "合作商简称")
	private String partnerAbbreviation;
	
	@ApiModelProperty(value = "接单时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String orderReceivingDate;
	
	@ApiModelProperty(value = "接单状态")
	private String inquiryStatus;

	public String getIssuedCarDealerDate() {
		return issuedCarDealerDate;
	}

	public void setIssuedCarDealerDate(String issuedCarDealerDate) {
		this.issuedCarDealerDate = issuedCarDealerDate;
	}

	public String getPartnerAbbreviation() {
		return partnerAbbreviation;
	}

	public void setPartnerAbbreviation(String partnerAbbreviation) {
		this.partnerAbbreviation = partnerAbbreviation;
	}

	public String getOrderReceivingDate() {
		return orderReceivingDate;
	}

	public void setOrderReceivingDate(String orderReceivingDate) {
		this.orderReceivingDate = orderReceivingDate;
	}

	public String getInquiryStatus() {
		return inquiryStatus;
	}

	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}
}
