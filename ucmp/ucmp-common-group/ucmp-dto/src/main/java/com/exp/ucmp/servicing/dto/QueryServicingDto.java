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


@ApiModel(value = "QueryServicingDto对象", description = "整备工单列表")
public class QueryServicingDto {
    @ApiModelProperty(value = "整备信息id")
    private String serviceId;

    @ApiModelProperty(value = "仓储点")
    private String storageName;

    @ApiModelProperty(value = "车辆来源")
    private String carSource;

    @ApiModelProperty(value = "库存类型")
    private String stockType;

    @ApiModelProperty(value = "决策类型")
    private String decisionType;

    @ApiModelProperty(value = "车源批次")
    private String sourceBatch;

    @ApiModelProperty(value = "归属主体")
    private String revertBody;

    @ApiModelProperty(value = "vin")
    private String vin;

    @ApiModelProperty(value = "发起整备时间")
    private String startDate;

    @ApiModelProperty(value = "发起人")
    private String startPeople;

    @ApiModelProperty(value = "服务中心")
    private String servicePlace;

    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;

    @ApiModelProperty(value = "基础车型")
    private String baseCarTypeName;

    @ApiModelProperty(value = "外色")
    private String carColour;

    @ApiModelProperty(value = "反馈工单时间")
    private String singleNumberFeedbackDate;

    @ApiModelProperty(value = "工单号")
    private String singleNumber;

    @ApiModelProperty(value = "整备单号")
    private String serviceNumber;

    @ApiModelProperty(value = "完工时间")
    private String completeDate;

    @ApiModelProperty(value = "验收入库时间")
    private String warehousDate;

    @ApiModelProperty(value = "验收人")
    private String warehousPeople;

    @ApiModelProperty(value = "整备单状态(5301:待反馈,5302:已反馈待审批,5303:已通过-待生成工单,5304:已生成工单-待审批,5305:已生成工单-待实施,5306:实施完成-待验收,5307:已验收入库,5308:项目审批驳回,5309:放弃整备-转批售, 5310:项目审批通过,5311:取消整备,5312:工单审批驳回,5313:工单审批通过)")
    private String serviceStates;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "计划服务时间-开始")
    private Date planStartDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "计划服务时间-截止")
    private Date planEndDate;

    @ApiModelProperty(value = "库存id")
    private String stockId;
    
    @ApiModelProperty(value = "审批结果 1 通过 2 驳回")
    private int approvalResult;
    
    @ApiModelProperty(value = "是否待验收 0 未验收  1已验收  ")
    private int waitAcceptance;
    
    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public Date getPlanStartDate() {
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


    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getCarSource() {
        return carSource;
    }

    public void setCarSource(String carSource) {
        this.carSource = carSource;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }

    public String getSourceBatch() {
        return sourceBatch;
    }

    public void setSourceBatch(String sourceBatch) {
        this.sourceBatch = sourceBatch;
    }

    public String getRevertBody() {
        return revertBody;
    }

    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartPeople() {
        return startPeople;
    }

    public void setStartPeople(String startPeople) {
        this.startPeople = startPeople;
    }

    public String getServicePlace() {
        return servicePlace;
    }

    public void setServicePlace(String servicePlace) {
        this.servicePlace = servicePlace;
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

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }

    public String getSingleNumberFeedbackDate() {
        return singleNumberFeedbackDate;
    }

    public void setSingleNumberFeedbackDate(String singleNumberFeedbackDate) {
        this.singleNumberFeedbackDate = singleNumberFeedbackDate;
    }

    public String getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(String singleNumber) {
        this.singleNumber = singleNumber;
    }

    public String getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(String completeDate) {
        this.completeDate = completeDate;
    }

    public String getWarehousDate() {
        return warehousDate;
    }

    public void setWarehousDate(String warehousDate) {
        this.warehousDate = warehousDate;
    }

    public String getWarehousPeople() {
        return warehousPeople;
    }

    public void setWarehousPeople(String warehousPeople) {
        this.warehousPeople = warehousPeople;
    }

    public String getServiceStates() {
        return serviceStates;
    }

    public void setServiceStates(String serviceStates) {
        this.serviceStates = serviceStates;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

	public int getApprovalResult() {
		return approvalResult;
	}

	public void setApprovalResult(int approvalResult) {
		this.approvalResult = approvalResult;
	}

	public int getWaitAcceptance() {
		return waitAcceptance;
	}

	public void setWaitAcceptance(int waitAcceptance) {
		this.waitAcceptance = waitAcceptance;
	}
    
}
