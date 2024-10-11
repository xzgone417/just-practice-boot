package com.exp.ucmp.storeApp.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.PsiCustomerReservationMsgEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import java.util.Date;
import java.util.List;


@ApiModel(value = "ReplaceCluesCloseDto", description = "置换单关闭传入条件")
public class ReplaceCluesCloseDto extends BaseModel {
    private static final long serialVersionUID = 1L;
    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;

    /*@ApiModelProperty(value = "跟踪状态：0701\t待分配\n" +
            "0702\t已分配\n" +
            "0703\t待检测\n" +
            "0704\t检测中\n" +
            "0705\t已报价\n" +
            "0706\t已完成\n" +
            "0709\t已关闭\n/" +
            "0711\t无车商接单\n/" +
            "0712\t无车商报价\n/" +
            "0713\t无车商收购\n/")
    private String trackStatus;*/

    /**
     * 关闭描述
     */
    @ApiModelProperty(value = "关闭描述")
    private String shutDescribe;


    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

   /* public String getTrackStatus() {
        return trackStatus;
    }

    public void setTrackStatus(String trackStatus) {
        this.trackStatus = trackStatus;
    }*/

    public String getShutDescribe() {
        return shutDescribe;
    }

    public void setShutDescribe(String shutDescribe) {
        this.shutDescribe = shutDescribe;
    }
}
