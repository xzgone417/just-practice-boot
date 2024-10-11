package com.exp.ucmp.replacement.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "PsiCustomerCarsQueryDto", description = "旧车信息查询")
public class PsiCustomerCarsQueryDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;






    public PsiCustomerCarsQueryDto() {
    }

    public PsiCustomerCarsQueryDto(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
    }





}
