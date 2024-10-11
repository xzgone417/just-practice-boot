package com.exp.ucmp.storeApp.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@ApiModel(value = "DivisionCarDealerDto", description = "分配车商入参")
public class DivisionCarDealerDto extends BaseModel {

    private static final long serialVersionUID = 1L;


    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;



    /**
     * 门店id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店id")
    private Long storeId;


    /**
     * 接单截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "接单截止时间")
    private Date orderReceivingDeadline;




    /**
     * 预约检测时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预约检测时间")
    private Date reservationDetectionDate;



    /**
     * 车商ID
     */
    @ApiModelProperty(value = "车商ID")
    private List<Long> carDealerId;



    /**
     * 业务编号
     */

    @ApiModelProperty(value = "业务编号")
    private String businessOrderNo;


    public Date getOrderReceivingDeadline() {
        return orderReceivingDeadline;
    }

    public void setOrderReceivingDeadline(Date orderReceivingDeadline) {
        this.orderReceivingDeadline = orderReceivingDeadline;
    }


    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }


    public List<Long> getCarDealerId() {
        return carDealerId;
    }

    public void setCarDealerId(List<Long> carDealerId) {
        this.carDealerId = carDealerId;
    }

    public Date getReservationDetectionDate() {
        return reservationDetectionDate;
    }

    public void setReservationDetectionDate(Date reservationDetectionDate) {
        this.reservationDetectionDate = reservationDetectionDate;
    }

    public String getBusinessOrderNo() {
        return businessOrderNo;
    }

    public void setBusinessOrderNo(String businessOrderNo) {
        this.businessOrderNo = businessOrderNo;
    }


    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
