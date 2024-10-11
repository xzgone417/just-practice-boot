package com.exp.ucmp.replacement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

@ApiModel(value = "QuoteRecordDto", description = "报价记录实体类")
public class QuoteRecordDto {

	@ApiModelProperty(value = "原因")
	private String reason;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@ApiModelProperty(value = "合作商简称")
	private String partnerAbbreviation;
	
	@ApiModelProperty(value = "报价截止时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String quoteDeadline;
	
	@ApiModelProperty(value = "报价状态")
	private String inquiryStatus;
	
	@ApiModelProperty(value = "估价（元）")
	private String appraisalPrice;
	
	@ApiModelProperty(value = "报价日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String appraisalDate;

	public String getPartnerAbbreviation() {
		return partnerAbbreviation;
	}

	public void setPartnerAbbreviation(String partnerAbbreviation) {
		this.partnerAbbreviation = partnerAbbreviation;
	}

	public String getQuoteDeadline() {
		return quoteDeadline;
	}

	public void setQuoteDeadline(String quoteDeadline) {
		this.quoteDeadline = quoteDeadline;
	}

	public String getInquiryStatus() {
		return inquiryStatus;
	}

	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}

	public String getAppraisalPrice() {
		return appraisalPrice;
	}

	public void setAppraisalPrice(String appraisalPrice) {
		this.appraisalPrice = appraisalPrice;
	}

	public String getAppraisalDate() {
		return appraisalDate;
	}

	public void setAppraisalDate(String appraisalDate) {
		this.appraisalDate = appraisalDate;
	}
	
}
