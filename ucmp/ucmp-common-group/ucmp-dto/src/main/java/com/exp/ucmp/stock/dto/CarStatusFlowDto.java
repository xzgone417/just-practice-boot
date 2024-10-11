package com.exp.ucmp.stock.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author GeYiJiang
 * @Description: 车辆流转状态信息DTO
 * @date 2023/2/6 11:05
 */
@ApiModel(value = "车辆流转状态信息DTO对象", description = "车辆流转状态信息")
public class CarStatusFlowDto extends BaseModel {

    @ApiModelProperty(value = "库存类型")
    private String stockType;

    @ApiModelProperty(value = "车辆来源")
    private String carSource;

    @ApiModelProperty(value = "状态")
    private String stockState;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "入库时间")
    private Date warehousDate;

    @ApiModelProperty(value = "决策类型：2301零售 2302批售")
    private String decisionType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "决策时间")
    private Date decisionTime;

    @ApiModelProperty(value = "整备状态")
    private String serviceStart;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "整备发起时间")
    private Date startDate;

    @ApiModelProperty(value = "是否维修0-已调整 1-未调整")
    private String isRepair;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "维修发起时间")
    private Date updatedDate;

    public String getIsRepair() {
        return isRepair;
    }

    public void setIsRepair(String isRepair) {
        this.isRepair = isRepair;
    }

    public String getCarSource() {
        return carSource;
    }

    public void setCarSource(String carSource) {
        this.carSource = carSource;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @ApiModelProperty(value = "素材审批结果")
    private int approvalResult;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "素材审批发起日期")
    private Date approvalDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "上架时间")
    private Date groundingDate;

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public Date getWarehousDate() {
        return warehousDate;
    }

    public void setWarehousDate(Date warehousDate) {
        this.warehousDate = warehousDate;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }

    public Date getDecisionTime() {
        return decisionTime;
    }

    public void setDecisionTime(Date decisionTime) {
        this.decisionTime = decisionTime;
    }

    public String getServiceStart() {
        return serviceStart;
    }

    public void setServiceStart(String serviceStart) {
        this.serviceStart = serviceStart;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getApprovalResult() {
        return approvalResult;
    }

    public void setApprovalResult(int approvalResult) {
        this.approvalResult = approvalResult;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public Date getGroundingDate() {
        return groundingDate;
    }

    public void setGroundingDate(Date groundingDate) {
        this.groundingDate = groundingDate;
    }

    public String getStockState() {
        return stockState;
    }

    public void setStockState(String stockState) {
        this.stockState = stockState;
    }
}
