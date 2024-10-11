package com.exp.ucmp.carService.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "CarServiceApprovalListInfoDto", description = "整备审批列表信息Dto")
public class CarServiceApprovalListInfoDto{

    private static final long serialVersionUID = 1L;
    /**
     * 整备信息id
     */
    @ApiModelProperty(value = "整备信息id")
    private String serviceId;
    /**
     * 库存id
     */
    @ApiModelProperty(value = "库存id")
    private String stockId;
    /**
     * 整备单号
     */
    @ApiModelProperty(value = "整备单号")
    private String serviceNumber;

    /**
     * 仓储点名称
     */
    @ApiModelProperty(value = "仓储点名称")
    private String storageName;

    /**
     * 车辆来源
     */
    @ApiModelProperty(value = "车辆来源")
    private String carSource;


    /**
     * 库存类型
     */
    @ApiModelProperty(value = "库存类型")
    private String stockType;

    /**
     * 车源批次
     */
    @ApiModelProperty(value = "车源批次")
    private String sourceBatch;

    /**
     * 归属主体
     */
    @ApiModelProperty(value = "归属主体")
    private String revertBody;

    /**
     * VIN
     */
    @ApiModelProperty(value = "VIN")
    private String vinCode;

    /**
     * 决策类型
     */
    @ApiModelProperty(value = "决策类型")
    private String decisionType;


    /**
     * 整备发起人
     */
    @ApiModelProperty(value = "整备发起人")
    private String startPeople;

    /**
     * 整备发起人Id
     */
    @ApiModelProperty(value = "整备发起人Id")
    private Long startPeopleId;
    /**
     * 整备发起时间
     */
    @ApiModelProperty(value = "整备发起时间")
    private Date startDate;

    /**
     * 工单号
     */
    @ApiModelProperty(value = "工单号")
    private String singleNumber;

    /**
     * 工单生成时间
     */
    @ApiModelProperty(value = "工单生成时间")
    private Date singleNumberGenerateDate;

    /**
     * 计划服务时间-开始
     */
    @ApiModelProperty(value = "计划服务时间-开始")
    private Date planStartDate;

    /**
     * 计划服务时间-截止
     */
    @ApiModelProperty(value = "计划服务时间-截止")
    private Date planEndDate;


    /**
     * 维修项目反馈时间
     */
    @ApiModelProperty(value = "维修项目反馈时间")
    private Date feedbackDate;

    /**
     * 期望整备结束时间
     */
    @ApiModelProperty(value = "期望整备结束时间")
    private Date expectEndTime;

    /**
     * 工程车型名称
     */
    @ApiModelProperty(value = "工程车型名称")
    private String carSeriesName;

    /**
     * 基础车型名称
     */
    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;

    /**
     * 外色
     */
    @ApiModelProperty(value = "外色")
    private String carColour;


    /**
     * 整备单状态(5301:待反馈 5302:已反馈待审批 5303:已通过-待生成工单 5304:已生成工单-待实施 5305:实施完成 5306:已验收入库 5307:驳回 5308:放弃整备-转批售 5309:取消整备)
     */
    @ApiModelProperty(value = "整备单状态(5301:待反馈 5302:已反馈待审批 5303:已通过-待生成工单 5304:已生成工单-待实施 5305:实施完成 5306:已验收入库 5307:驳回 5308:放弃整备-转批售 5309:取消整备)")
    private String serviceState;

    public Long getStartPeopleId() {
        return startPeopleId;
    }

    public void setStartPeopleId(Long startPeopleId) {
        this.startPeopleId = startPeopleId;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
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

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
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

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }

    public String getStartPeople() {
        return startPeople;
    }

    public void setStartPeople(String startPeople) {
        this.startPeople = startPeople;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
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

    public Date getExpectEndTime() {
        return expectEndTime;
    }

    public void setExpectEndTime(Date expectEndTime) {
        this.expectEndTime = expectEndTime;
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

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public String getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(String singleNumber) {
        this.singleNumber = singleNumber;
    }

    public Date getSingleNumberGenerateDate() {
        return singleNumberGenerateDate;
    }

    public void setSingleNumberGenerateDate(Date singleNumberGenerateDate) {
        this.singleNumberGenerateDate = singleNumberGenerateDate;
    }
}
