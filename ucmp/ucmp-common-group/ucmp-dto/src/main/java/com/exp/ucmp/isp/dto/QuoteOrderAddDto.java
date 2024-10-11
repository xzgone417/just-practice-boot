package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuoteOrderAddDto", description = "添加整备报价单实体类")
public class QuoteOrderAddDto {
	
	@ApiModelProperty(value = "整备报价单id")
	private Long quoteOrderId;
	
	@ApiModelProperty(value = "UCMP的整备单号")
	private String ucmpOrderNo;
	
	@ApiModelProperty(value = "ISP的报价单号")
    private String quoteOrderNo;
	
	@ApiModelProperty(value = "预估交车时间")
    private String planCompleteDate;
	
	@ApiModelProperty(value = "整备总价")
    private Double totalPrice;
	
	@ApiModelProperty(value = "创建人")
	private Long createdBy;
	
	@ApiModelProperty(value = "更新人")
	private Long updateBy;

	public Long getQuoteOrderId() {
		return quoteOrderId;
	}

	public void setQuoteOrderId(Long quoteOrderId) {
		this.quoteOrderId = quoteOrderId;
	}

	public String getUcmpOrderNo() {
		return ucmpOrderNo;
	}

	public void setUcmpOrderNo(String ucmpOrderNo) {
		this.ucmpOrderNo = ucmpOrderNo;
	}

	public String getQuoteOrderNo() {
		return quoteOrderNo;
	}

	public void setQuoteOrderNo(String quoteOrderNo) {
		this.quoteOrderNo = quoteOrderNo;
	}

	public String getPlanCompleteDate() {
		return planCompleteDate;
	}

	public void setPlanCompleteDate(String planCompleteDate) {
		this.planCompleteDate = planCompleteDate;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

}
