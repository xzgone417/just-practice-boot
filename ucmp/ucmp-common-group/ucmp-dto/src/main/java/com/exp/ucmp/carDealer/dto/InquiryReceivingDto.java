package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InquiryReceivingDto", description = "询价接单对象")
public class InquiryReceivingDto extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6985996612987118008L;
	
	/**
     * 询价ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "询价ID 总部端操作接单时为空")
    private Long inquiryId;

    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    /**
     * 放弃接单原因
     */
    @ApiModelProperty(value = "放弃接单原因")
    private String abandonReceivingReason;

	public Long getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(Long inquiryId) {
		this.inquiryId = inquiryId;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public String getAbandonReceivingReason() {
		return abandonReceivingReason;
	}

	public void setAbandonReceivingReason(String abandonReceivingReason) {
		this.abandonReceivingReason = abandonReceivingReason;
	}
	
}
