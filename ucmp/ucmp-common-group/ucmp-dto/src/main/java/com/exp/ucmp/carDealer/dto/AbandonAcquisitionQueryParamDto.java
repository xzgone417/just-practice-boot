package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/16 14:46
 */
public class AbandonAcquisitionQueryParamDto extends BaseModel {

    private static final long serialVersionUID = -1822208424838435653L;

    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;

    /**
     * 收购放弃原因
     */
    @ApiModelProperty(value = "收购放弃原因")
    private String acquisitionAbandonedReason;

    public AbandonAcquisitionQueryParamDto() {
    }

    public AbandonAcquisitionQueryParamDto(Long reservationId, String acquisitionAbandonedReason) {
        this.reservationId = reservationId;
        this.acquisitionAbandonedReason = acquisitionAbandonedReason;
    }

    /**
     * 获取
     * @return reservationId
     */
    public Long getReservationId() {
        return reservationId;
    }

    /**
     * 设置
     * @param reservationId
     */
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * 获取
     * @return acquisitionAbandonedReason
     */
    public String getAcquisitionAbandonedReason() {
        return acquisitionAbandonedReason;
    }

    /**
     * 设置
     * @param acquisitionAbandonedReason
     */
    public void setAcquisitionAbandonedReason(String acquisitionAbandonedReason) {
        this.acquisitionAbandonedReason = acquisitionAbandonedReason;
    }

    public String toString() {
        return "AbandonAcquisitionQueryParamDto{reservationId = " + reservationId + ", acquisitionAbandonedReason = " + acquisitionAbandonedReason + "}";
    }
}
