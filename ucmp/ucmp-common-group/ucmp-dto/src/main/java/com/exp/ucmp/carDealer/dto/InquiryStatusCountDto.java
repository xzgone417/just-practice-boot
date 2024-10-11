package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InquiryStatusCountDto", description = "询价状态统计对象")
public class InquiryStatusCountDto extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5087842066068587630L;

	/**
	 * 预约单ID
	 */
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "预约单ID")
	private Long reservationId;
	
    /**
     * 询价单状态：01、待接单，02、已接单，09、放弃接单，11、待报价，12、已报价，18、逾期未报价，19、放弃报价
     */
    @ApiModelProperty(value = "询价单状态：01、待接单，02、已接单，09、放弃接单，11、待报价，12、已报价，18、逾期未报价，19、放弃报价")
    private String inquiryStatus;
    
    /**
     * 各状态的统计
     */
    @ApiModelProperty(value = "各状态的统计")
    private Integer inquiryStatusCount;

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public String getInquiryStatus() {
		return inquiryStatus;
	}

	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}

	public Integer getInquiryStatusCount() {
		return inquiryStatusCount;
	}

	public void setInquiryStatusCount(Integer inquiryStatusCount) {
		this.inquiryStatusCount = inquiryStatusCount;
	}
    
}
