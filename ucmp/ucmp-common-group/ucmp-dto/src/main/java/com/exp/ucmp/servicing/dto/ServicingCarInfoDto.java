/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.servicing.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


@ApiModel(value = "ServicingCarInfoDto", description = "整备车辆基本信息")
public class ServicingCarInfoDto {

    @ApiModelProperty(value = "仓储点")
    private String storageName;

    @ApiModelProperty(value = "vin")
    private String vinCode;

    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;

    @ApiModelProperty(value = "车辆类型")
    private String carType;

    @ApiModelProperty(value = "整备发起人")
    private String startPeople;

    @ApiModelProperty(value = "基础车型")
    private String baseCarTypeName;

    @ApiModelProperty(value = "服务点")
    private String servicePlace;

    @ApiModelProperty(value = "服务点类型")
    private String placeType;

    @ApiModelProperty(value = "整备单号")
    private String serviceNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "预估交车时间")
    private Date estimatedDeliveryTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "整备发起时间")
    private Date startDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "期望整备结束时间")
    private Date expectEndTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "维修项目反馈时间")
    private Date feedbackDate;

    /*@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "计划服务时间-开始")
    private Date planStartDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "计划服务时间-截止")
    private Date planEndDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "反馈预估维修时间-开始")
    private Date planRepairStartDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "反馈预估维修时间-截止")
    private Date planRepairEndDate;

    @ApiModelProperty(value = "工单号")
    private String singleNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "工单反馈时间")
    private Date singleNumberFeedbackDate;*/

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "预计完工时间")
    private Date planCompleteDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "实际完工时间")
    private Date completeDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "整备入库时间")
    private Date warehousDate;

    @ApiModelProperty(value = "入库人")
    private String warehousPeopleName;

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getCarSeriesName() {
        return carSeriesName;
    }

    public void setCarSeriesName(String carSeriesName) {
        this.carSeriesName = carSeriesName;
    }

    public String getBaseCarTypeName() {
        return baseCarTypeName;
    }

    public void setBaseCarTypeName(String baseCarTypeName) {
        this.baseCarTypeName = baseCarTypeName;
    }

    public String getServicePlace() {
        return servicePlace;
    }

    public void setServicePlace(String servicePlace) {
        this.servicePlace = servicePlace;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExpectEndTime() {
        return expectEndTime;
    }

    public void setExpectEndTime(Date expectEndTime) {
        this.expectEndTime = expectEndTime;
    }

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    /*public Date getPlanRepairStartDate() {
        return planRepairStartDate;
    }

    public void setPlanRepairStartDate(Date planRepairStartDate) {
        this.planRepairStartDate = planRepairStartDate;
    }

    public Date getPlanRepairEndDate() {
        return planRepairEndDate;
    }

    public void setPlanRepairEndDate(Date planRepairEndDate) {
        this.planRepairEndDate = planRepairEndDate;
    }

    public String getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(String singleNumber) {
        this.singleNumber = singleNumber;
    }

    public Date getSingleNumberFeedbackDate() {
        return singleNumberFeedbackDate;
    }

    public void setSingleNumberFeedbackDate(Date singleNumberFeedbackDate) {
        this.singleNumberFeedbackDate = singleNumberFeedbackDate;
    }*/

    public Date getPlanCompleteDate() {
        return planCompleteDate;
    }

    public void setPlanCompleteDate(Date planCompleteDate) {
        this.planCompleteDate = planCompleteDate;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Date getWarehousDate() {
        return warehousDate;
    }

    public void setWarehousDate(Date warehousDate) {
        this.warehousDate = warehousDate;
    }

    public String getWarehousPeopleName() {
        return warehousPeopleName;
    }

    public void setWarehousPeopleName(String warehousPeopleName) {
        this.warehousPeopleName = warehousPeopleName;
    }

    /*public Date getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Date getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Date planEndDate) {
        this.planEndDate = planEndDate;
    }
*/
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getStartPeople() {
        return startPeople;
    }

    public void setStartPeople(String startPeople) {
        this.startPeople = startPeople;
    }

    public Date getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(Date estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }
}
