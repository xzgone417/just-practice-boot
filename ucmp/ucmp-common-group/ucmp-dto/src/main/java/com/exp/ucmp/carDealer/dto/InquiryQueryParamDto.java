package com.exp.ucmp.carDealer.dto;

import com.exp.ucmp.PageDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InquiryQueryParamDto", description = "询价查询对象")
public class InquiryQueryParamDto extends PageDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7788138777809760539L;

	public enum InquiryQueryTypeEnum {
		inquiryReceivingAwait, inquiryReceivingAccept, inquiryReceivingGiveup;
	}

	/**
	 * 预约单号
	 */
	@ApiModelProperty(value = "预约单号")
	private String businessOrderNo;

	/**
     * 查询类型
     */
    @ApiModelProperty(value = "查询类型: inquiryReceivingAwait, inquiryReceivingAccept, inquiryReceivingGiveup")
    private String inquiryQueryType;

	public String getInquiryQueryType() {
		return inquiryQueryType;
	}

	public void setInquiryQueryType(String inquiryQueryType) {
		this.inquiryQueryType = inquiryQueryType;
	}

	public String getBusinessOrderNo() {
		return businessOrderNo;
	}

	public void setBusinessOrderNo(String businessOrderNo) {
		this.businessOrderNo = businessOrderNo;
	}
}
