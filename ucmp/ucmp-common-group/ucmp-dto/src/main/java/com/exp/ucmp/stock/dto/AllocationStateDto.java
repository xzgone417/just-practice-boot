/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.stock.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@ApiModel(value = "AllocationStateDto对象", description = "调拨状态信息")
public class AllocationStateDto {
    @ApiModelProperty(value = "调度信息id")
    private Long dispatchInfoId;

    @ApiModelProperty(value = "预计到店时间")
    private String estimatedTime;

    @ApiModelProperty(value = "发运时间")
    private String dispatchEffectiveTime;

    @ApiModelProperty(value = "发运地")
    private String departureName;

    @ApiModelProperty(value = "目的地")
    private String destinationName;

    @ApiModelProperty(value = "调拨申请人")
    private String staffName;

    @ApiModelProperty(value = "调拨申请日期")
    private String staffDate;

    @ApiModelProperty(value = "物流公司名称")
    private String carrierName;

    @ApiModelProperty(value = "联系人")
    private String driverName;

    @ApiModelProperty(value = "联系人电话")
    private String driverPhone;

    @ApiModelProperty(value = "运输开始时间")
    private String actualDepartureTime;

    @ApiModelProperty(value = "运输到达时间")
    private String actualTime;

    @ApiModelProperty(value = "验收入库人")
    private String warehousingName;

    @ApiModelProperty(value = "入库时间")
    private String warehousingTime;


    @ApiModelProperty(value = "到达城市1")
    private String arriveCityOne;

    @ApiModelProperty(value = "到达时间1")
    private String arriveTimeOne;


    @ApiModelProperty(value = "到达城市2")
    private String arriveCityTwo;

    @ApiModelProperty(value = "到达时间2")
    private String arriveTimeTwo;

    public String getArriveCityOne() {
        return arriveCityOne;
    }

    public void setArriveCityOne(String arriveCityOne) {
        this.arriveCityOne = arriveCityOne;
    }

    public String getArriveTimeOne() {
        return arriveTimeOne;
    }

    public void setArriveTimeOne(String arriveTimeOne) {
        this.arriveTimeOne = arriveTimeOne;
    }

    public String getArriveCityTwo() {
        return arriveCityTwo;
    }

    public void setArriveCityTwo(String arriveCityTwo) {
        this.arriveCityTwo = arriveCityTwo;
    }

    public String getArriveTimeTwo() {
        return arriveTimeTwo;
    }

    public void setArriveTimeTwo(String arriveTimeTwo) {
        this.arriveTimeTwo = arriveTimeTwo;
    }

    public String getDispatchEffectiveTime() {
        return dispatchEffectiveTime;
    }

    public void setDispatchEffectiveTime(String dispatchEffectiveTime) {
        this.dispatchEffectiveTime = dispatchEffectiveTime;
    }


    public Long getDispatchInfoId() {
        return dispatchInfoId;
    }

    public void setDispatchInfoId(Long dispatchInfoId) {
        this.dispatchInfoId = dispatchInfoId;
    }

    public String getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getDepartureName() {
        return departureName;
    }

    public void setDepartureName(String departureName) {
        this.departureName = departureName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffDate() {
        return staffDate;
    }

    public void setStaffDate(String staffDate) {
        this.staffDate = staffDate;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getActualDepartureTime() {
        return actualDepartureTime;
    }

    public void setActualDepartureTime(String actualDepartureTime) {
        this.actualDepartureTime = actualDepartureTime;
    }

    public String getActualTime() {
        return actualTime;
    }

    public void setActualTime(String actualTime) {
        this.actualTime = actualTime;
    }

    public String getWarehousingName() {
        return warehousingName;
    }

    public void setWarehousingName(String warehousingName) {
        this.warehousingName = warehousingName;
    }

    public String getWarehousingTime() {
        return warehousingTime;
    }

    public void setWarehousingTime(String warehousingTime) {
        this.warehousingTime = warehousingTime;
    }
}
