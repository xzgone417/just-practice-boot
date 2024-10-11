package com.exp.ucmp.carDealer.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuotingQueryParamDto", description = "报价查询对象")
public class QuotingQueryParamDto extends PageDto {

	private static final long serialVersionUID = 6437836749108288882L;

	public String getBusinessOrderNo() {
		return businessOrderNo;
	}

	public void setBusinessOrderNo(String businessOrderNo) {
		this.businessOrderNo = businessOrderNo;
	}

	/**
	 * 预约单号
	 */
	@ApiModelProperty(value = "预约单号")
	private String businessOrderNo;

	public enum QuotingQueryTypeEnum {
		inquiryQuotingAwait, inquiryQuotingAccept, inquiryQuotingGiveup, customerRefusal, all;
	}

	/**
	 * 查询类型
	 */
	@ApiModelProperty(value = "查询类型: inquiryQuotingAwait(待报价), inquiryQuotingAccept(已报价), inquiryQuotingGiveup(放弃报价),customerRefusal(已报价-客户拒绝),all(全部)")
	private String quotingQueryType;

	public String getQuotingQueryType() {
		return quotingQueryType;
	}

	public void setQuotingQueryType(String quotingQueryType) {
		this.quotingQueryType = quotingQueryType;
	}
}
