package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * <p>@ClassName: SalesSaveFollowDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/30 17:23<p>
 */
public class SalesSaveFollowDto {

    @ApiModelProperty(value = "线索id")
    private Long cluesId;

    /**
     * 工程车型代码
     */
    @ApiModelProperty(value = "工程车型代码")
    private String modelCode;

    /**
     * 工程车型名称
     */
    @ApiModelProperty(value = "工程车型名称")
    private String modelName;

    /**
     * VIN
     */
    @ApiModelProperty(value = "VIN")
    private String vin;

    /**
     * 仓储点id
     */
    @ApiModelProperty(value = "仓储点id")
    private Long storageId;

    /**
     * 库存车辆id
     */
    @ApiModelProperty(value = "库存车辆id")
    private Long stockId;

    @ApiModelProperty(value = "跟进时间")
    private Date followTime;

    @ApiModelProperty(value = "跟进信息")
    private String followInfo;

    @ApiModelProperty(value = "下次跟进时间")
    private Date lastFollowTime;

    @ApiModelProperty(value = "跟进方式(7701云电话7702企业微信7703面谈7704活动)")
    private String followType;

    @ApiModelProperty(value = "是否到店(00不到店 01到店)")
    private String isArrival;

    public Long getCluesId() {
        return cluesId;
    }

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public String getFollowInfo() {
        return followInfo;
    }

    public void setFollowInfo(String followInfo) {
        this.followInfo = followInfo;
    }

    public Date getLastFollowTime() {
        return lastFollowTime;
    }

    public void setLastFollowTime(Date lastFollowTime) {
        this.lastFollowTime = lastFollowTime;
    }

    public String getFollowType() {
        return followType;
    }

    public void setFollowType(String followType) {
        this.followType = followType;
    }

    public String getIsArrival() {
        return isArrival;
    }

    public void setIsArrival(String isArrival) {
        this.isArrival = isArrival;
    }
}
