package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InquiryQuotingDto", description = "询价报价对象")
public class InquiryQuotingDto extends BaseModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6985996612987118008L;
	
	/**
     * 询价ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "询价ID")
    private Long inquiryId;

    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    /**
     * 放弃报价原因
     */
    @ApiModelProperty(value = "放弃报价原因")
    private String orderAbandonedReason;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getOrderAbandonedReason() {
        return orderAbandonedReason;
    }

    public void setOrderAbandonedReason(String orderAbandonedReason) {
        this.orderAbandonedReason = orderAbandonedReason;
    }
}
