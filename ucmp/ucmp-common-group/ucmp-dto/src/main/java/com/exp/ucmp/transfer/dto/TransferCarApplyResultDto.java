package com.exp.ucmp.transfer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author GeYiJiang
 * @Description: 调拨车辆申请列表查询结果
 * @date 2023/2/13 13:51
 */
@ApiModel(value = "TransferCarApplyResultDto", description = "调拨车辆申请列表查询结果")
public class TransferCarApplyResultDto extends BaseModel {

    @ApiModelProperty(value = "调度编号")
    private String dispatchNumber;

    @ApiModelProperty(value = "车辆来源")
    private String carSource;
    
    @ApiModelProperty(value = "车辆来源名称")
    private String carSourceName;

    @ApiModelProperty(value = "vin")
    private String vinCode;

    @ApiModelProperty(value = "所在仓储点")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long storageId;

    @ApiModelProperty(value = "所在仓储点")
    @JsonSerialize(using = ToStringSerializer.class)
    private String storageName;

    @ApiModelProperty(value = "调往仓储点id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long transferStorageId;

    @ApiModelProperty(value = "调往仓储点")
    @JsonSerialize(using = ToStringSerializer.class)
    private String transferStorageName;

    @ApiModelProperty(value = "调拨状态(00:待发运/01:已调度/02:待发运出库/03:已出库/04:运输中/05:到达待入库/06:已入库/07:等待取消中/08:已取消)")
    private String transferStatus;

    @ApiModelProperty(value = "调拨类型")
    private String transferType;
    
    @ApiModelProperty(value = "调拨类型名称")
    private String transferTypeName;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "调度申请id")
    private Long transferApplyId;

    @ApiModelProperty(value = "库存车辆id")
    private Long stockId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "入库时间")
    private Date warehousDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "开始调拨时间")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "期望到达时间")
    private Date expectedTime;

    @ApiModelProperty(value = "备注")
    private String marks;

    @ApiModelProperty(value = "发起人")
    private String initiator;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "调拨发起时间")
    private Date initiatorTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际出发时间")
    private Date actualDepartureTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预计到达时间")
    private Date estimatedTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "反馈预计到达时间")
    private Date feedbackEstimatedArrivalTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "出库时间")
    private Date deliveryTime;

    @ApiModelProperty(value = "是否提交(00未提交 01已提交)")
    private String isSubmit;

    @ApiModelProperty(value = "指令编号")
    private String instructionNumber;

    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;

    @ApiModelProperty(value = "基础车型")
    private String baseCarTypeName;

    @ApiModelProperty(value = "外色")
    private String carColour;

    public String getCarSourceName() {
		return carSourceName;
	}

	public void setCarSourceName(String carSourceName) {
		this.carSourceName = carSourceName;
	}

	public String getTransferTypeName() {
		return transferTypeName;
	}

	public void setTransferTypeName(String transferTypeName) {
		this.transferTypeName = transferTypeName;
	}

	public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public Long getTransferStorageId() {
        return transferStorageId;
    }

    public void setTransferStorageId(Long transferStorageId) {
        this.transferStorageId = transferStorageId;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public Long getTransferApplyId() {
        return transferApplyId;
    }

    public void setTransferApplyId(Long transferApplyId) {
        this.transferApplyId = transferApplyId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Date getWarehousDate() {
        return warehousDate;
    }

    public void setWarehousDate(Date warehousDate) {
        this.warehousDate = warehousDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public Date getInitiatorTime() {
        return initiatorTime;
    }

    public void setInitiatorTime(Date initiatorTime) {
        this.initiatorTime = initiatorTime;
    }

    public Date getFeedbackEstimatedArrivalTime() {
        return feedbackEstimatedArrivalTime;
    }

    public void setFeedbackEstimatedArrivalTime(Date feedbackEstimatedArrivalTime) {
        this.feedbackEstimatedArrivalTime = feedbackEstimatedArrivalTime;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getIsSubmit() {
        return isSubmit;
    }

    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit;
    }

    public String getDispatchNumber() {
        return dispatchNumber;
    }

    public void setDispatchNumber(String dispatchNumber) {
        this.dispatchNumber = dispatchNumber;
    }

    public String getInstructionNumber() {
        return instructionNumber;
    }

    public void setInstructionNumber(String instructionNumber) {
        this.instructionNumber = instructionNumber;
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

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getTransferStorageName() {
        return transferStorageName;
    }

    public void setTransferStorageName(String transferStorageName) {
        this.transferStorageName = transferStorageName;
    }

    public String getCarSource() {
        return carSource;
    }

    public void setCarSource(String carSource) {
        this.carSource = carSource;
    }

    public Date getActualDepartureTime() {
        return actualDepartureTime;
    }

    public void setActualDepartureTime(Date actualDepartureTime) {
        this.actualDepartureTime = actualDepartureTime;
    }

    public Date getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Date estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}
