package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description: 收购查询dto
 * @date 2022/10/24 16:12
 */
public class AcquisitionDetailQueryDto extends BaseModel {

    private static final long serialVersionUID = -3291796939001886409L;
    @ApiModelProperty(value = "预约id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long reservationId;

    public AcquisitionDetailQueryDto() {
    }

    public AcquisitionDetailQueryDto(Long reservationId) {
        this.reservationId = reservationId;
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

    public String toString() {
        return "AcquisitionDetailQueryDto{reservationId = " + reservationId + "}";
    }
}
