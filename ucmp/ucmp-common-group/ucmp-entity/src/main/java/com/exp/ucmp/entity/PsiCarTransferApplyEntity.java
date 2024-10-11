package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "PsiCarTransferApplyEntity", description = "车辆调拨申请表(v2)")
@GroupSequence({PsiCarTransferApplyEntity.class, PsiCarTransferApplyEntity.PsiCarTransferApplyEntityValidGroup.class,PsiCarTransferApplyEntity.TransferApplyIdValidGroup.class,PsiCarTransferApplyEntity.StockIdValidGroup.class,PsiCarTransferApplyEntity.OrderInfoIdValidGroup.class,PsiCarTransferApplyEntity.StorageIdValidGroup.class,PsiCarTransferApplyEntity.TransferStorageIdValidGroup.class,PsiCarTransferApplyEntity.StartTimeValidGroup.class,PsiCarTransferApplyEntity.ExpectedTimeValidGroup.class,PsiCarTransferApplyEntity.TransferTypeValidGroup.class,PsiCarTransferApplyEntity.MarksValidGroup.class,PsiCarTransferApplyEntity.TransferStatusValidGroup.class,PsiCarTransferApplyEntity.InitiatorValidGroup.class,PsiCarTransferApplyEntity.InitiatorTimeValidGroup.class,PsiCarTransferApplyEntity.IsSubmitValidGroup.class,PsiCarTransferApplyEntity.DispatchNumberValidGroup.class,PsiCarTransferApplyEntity.InstructionNumberValidGroup.class,PsiCarTransferApplyEntity.CreatedByValidGroup.class,PsiCarTransferApplyEntity.CreatedDateValidGroup.class,PsiCarTransferApplyEntity.UpdatedByValidGroup.class,PsiCarTransferApplyEntity.UpdatedDateValidGroup.class,PsiCarTransferApplyEntity.IsEnableValidGroup.class,PsiCarTransferApplyEntity.IsDeleteValidGroup.class}) 
public class PsiCarTransferApplyEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 调度申请id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "调度申请id 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, TransferApplyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="调度申请id 数字精度必须符合(19,0)", groups = {PsiCarTransferApplyEntityValidGroup.class, TransferApplyIdValidGroup.class})
    @ApiModelProperty(value = "调度申请id")
    private Long transferApplyId;
    
    
    /**
     * 库存车辆id
     */
    @NotNull(message = "库存车辆id 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, StockIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="库存车辆id 数字精度必须符合(19,0)", groups = {PsiCarTransferApplyEntityValidGroup.class, StockIdValidGroup.class})
    @ApiModelProperty(value = "库存车辆id")
    private Long stockId;
    
    /**
     * 官二销售订单id
     */
    @Digits(integer=19, fraction=0, message="官二销售订单id 数字精度必须符合(19,0)", groups = {PsiCarTransferApplyEntityValidGroup.class, OrderInfoIdValidGroup.class})
    @ApiModelProperty(value = "官二销售订单id")
    private Long orderInfoId;
    
    /**
     * 入库时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "入库时间")
    private Date warehousDate;
    
    /**
     * 所在仓储点id
     */
    @NotNull(message = "所在仓储点id 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, StorageIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="所在仓储点id 数字精度必须符合(19,0)", groups = {PsiCarTransferApplyEntityValidGroup.class, StorageIdValidGroup.class})
    @ApiModelProperty(value = "所在仓储点id")
    private Long storageId;
    
    /**
     * 调往仓储点id
     */
    @NotNull(message = "调往仓储点id 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, TransferStorageIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="调往仓储点id 数字精度必须符合(19,0)", groups = {PsiCarTransferApplyEntityValidGroup.class, TransferStorageIdValidGroup.class})
    @ApiModelProperty(value = "调往仓储点id")
    private Long transferStorageId;
    
    /**
     * 开始调拨时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "开始调拨时间 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, StartTimeValidGroup.class})
    @ApiModelProperty(value = "开始调拨时间")
    private Date startTime;
    
    /**
     * 期望到达时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "期望到达时间 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, ExpectedTimeValidGroup.class})
    @ApiModelProperty(value = "期望到达时间")
    private Date expectedTime;
    
    /**
     * 调拨类型
     */
    @NotNull(message = "调拨类型 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, TransferTypeValidGroup.class})
    @Size(min=0, max=4, message="调拨类型 字符长度必须小于等于4", groups = {PsiCarTransferApplyEntityValidGroup.class, TransferTypeValidGroup.class})
    @ApiModelProperty(value = "调拨类型")
    private String transferType;
    
    /**
     * 备注
     */
    @Size(min=0, max=200, message="备注 字符长度必须小于等于200", groups = {PsiCarTransferApplyEntityValidGroup.class, MarksValidGroup.class})
    @ApiModelProperty(value = "备注")
    private String marks;
    
    /**
     * 调拨状态(5201:待发运/5202:已调度/5203:待发运出库/5204:已出库/5205:运输中/5206:到达待入库/5207:已入库/5208:等待取消中/5209:已取消)
     */
    @Size(min=0, max=4, message="调拨状态(5201:待发运/5202:已调度/5203:待发运出库/5204:已出库/5205:运输中/5206:到达待入库/5207:已入库/5208:等待取消中/5209:已取消) 字符长度必须小于等于4", groups = {PsiCarTransferApplyEntityValidGroup.class, TransferStatusValidGroup.class})
    @ApiModelProperty(value = "调拨状态(5201:待发运/5202:已调度/5203:待发运出库/5204:已出库/5205:运输中/5206:到达待入库/5207:已入库/5208:等待取消中/5209:已取消)")
    private String transferStatus;
    
    /**
     * 发起人
     */
    @NotNull(message = "发起人 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, InitiatorValidGroup.class})
    @Digits(integer=19, fraction=0, message="发起人 数字精度必须符合(19,0)", groups = {PsiCarTransferApplyEntityValidGroup.class, InitiatorValidGroup.class})
    @ApiModelProperty(value = "发起人")
    private Long initiator;
    
    /**
     * 发起时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "发起时间 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, InitiatorTimeValidGroup.class})
    @ApiModelProperty(value = "发起时间")
    private Date initiatorTime;
    
    /**
     * 反馈预计到达时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "反馈预计到达时间")
    private Date feedbackEstimatedArrivalTime;
    
    /**
     * 出库时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "出库时间")
    private Date deliveryTime;
    
    /**
     * 是否提交(00未提交 01已提交 02 交付端保存)
     */
    @NotNull(message = "是否提交(00未提交 01已提交 02 交付端保存) 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, IsSubmitValidGroup.class})
    @Size(min=0, max=2, message="是否提交(00未提交 01已提交 02 交付端保存) 字符长度必须小于等于2", groups = {PsiCarTransferApplyEntityValidGroup.class, IsSubmitValidGroup.class})
    @ApiModelProperty(value = "是否提交(00未提交 01已提交 02 交付端保存)")
    private String isSubmit;
    
    /**
     * 调度编号
     */
    @Size(min=0, max=22, message="调度编号 字符长度必须小于等于22", groups = {PsiCarTransferApplyEntityValidGroup.class, DispatchNumberValidGroup.class})
    @ApiModelProperty(value = "调度编号")
    private String dispatchNumber;
    
    /**
     * 指令编号
     */
    @Size(min=0, max=20, message="指令编号 字符长度必须小于等于20", groups = {PsiCarTransferApplyEntityValidGroup.class, InstructionNumberValidGroup.class})
    @ApiModelProperty(value = "指令编号")
    private String instructionNumber;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarTransferApplyEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarTransferApplyEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarTransferApplyEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiCarTransferApplyEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiCarTransferApplyEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiCarTransferApplyEntity() {
    }
    
    public PsiCarTransferApplyEntity(Long transferApplyId) {
        this.transferApplyId = transferApplyId;
    }

    public void setTransferApplyId(Long transferApplyId) {
        this.transferApplyId = transferApplyId;
    }
    public Long getTransferApplyId() {
        return this.transferApplyId;
    }
    

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
    public Long getStockId() {
        return this.stockId;
    }
    
    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }
    public Long getOrderInfoId() {
        return this.orderInfoId;
    }
    
    public void setWarehousDate(Date warehousDate) {
        this.warehousDate = warehousDate;
    }
    public Date getWarehousDate() {
        return this.warehousDate;
    }
    
    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }
    public Long getStorageId() {
        return this.storageId;
    }
    
    public void setTransferStorageId(Long transferStorageId) {
        this.transferStorageId = transferStorageId;
    }
    public Long getTransferStorageId() {
        return this.transferStorageId;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }
    public Date getExpectedTime() {
        return this.expectedTime;
    }
    
    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }
    public String getTransferType() {
        return this.transferType;
    }
    
    public void setMarks(String marks) {
        this.marks = marks;
    }
    public String getMarks() {
        return this.marks;
    }
    
    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }
    public String getTransferStatus() {
        return this.transferStatus;
    }
    
    public void setInitiator(Long initiator) {
        this.initiator = initiator;
    }
    public Long getInitiator() {
        return this.initiator;
    }
    
    public void setInitiatorTime(Date initiatorTime) {
        this.initiatorTime = initiatorTime;
    }
    public Date getInitiatorTime() {
        return this.initiatorTime;
    }
    
    public void setFeedbackEstimatedArrivalTime(Date feedbackEstimatedArrivalTime) {
        this.feedbackEstimatedArrivalTime = feedbackEstimatedArrivalTime;
    }
    public Date getFeedbackEstimatedArrivalTime() {
        return this.feedbackEstimatedArrivalTime;
    }
    
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    public Date getDeliveryTime() {
        return this.deliveryTime;
    }
    
    public void setIsSubmit(String isSubmit) {
        this.isSubmit = isSubmit;
    }
    public String getIsSubmit() {
        return this.isSubmit;
    }
    
    public void setDispatchNumber(String dispatchNumber) {
        this.dispatchNumber = dispatchNumber;
    }
    public String getDispatchNumber() {
        return this.dispatchNumber;
    }
    
    public void setInstructionNumber(String instructionNumber) {
        this.instructionNumber = instructionNumber;
    }
    public String getInstructionNumber() {
        return this.instructionNumber;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Long getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Long getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public String getIsEnable() {
        return this.isEnable;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (transferApplyId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                transferApplyId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarTransferApplyEntityValidGroup {}
    public interface TransferApplyIdValidGroup {}
    public interface StockIdValidGroup {}
    public interface OrderInfoIdValidGroup {}
    public interface StorageIdValidGroup {}
    public interface TransferStorageIdValidGroup {}
    public interface StartTimeValidGroup {}
    public interface ExpectedTimeValidGroup {}
    public interface TransferTypeValidGroup {}
    public interface MarksValidGroup {}
    public interface TransferStatusValidGroup {}
    public interface InitiatorValidGroup {}
    public interface InitiatorTimeValidGroup {}
    public interface IsSubmitValidGroup {}
    public interface DispatchNumberValidGroup {}
    public interface InstructionNumberValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiCarTransferApplyEntity.TransferApplyIdValidGroup.class
            , PsiCarTransferApplyEntity.StockIdValidGroup.class
            , PsiCarTransferApplyEntity.OrderInfoIdValidGroup.class
            , PsiCarTransferApplyEntity.StorageIdValidGroup.class
            , PsiCarTransferApplyEntity.TransferStorageIdValidGroup.class
            , PsiCarTransferApplyEntity.StartTimeValidGroup.class
            , PsiCarTransferApplyEntity.ExpectedTimeValidGroup.class
            , PsiCarTransferApplyEntity.TransferTypeValidGroup.class
            , PsiCarTransferApplyEntity.MarksValidGroup.class
            , PsiCarTransferApplyEntity.TransferStatusValidGroup.class
            , PsiCarTransferApplyEntity.InitiatorValidGroup.class
            , PsiCarTransferApplyEntity.InitiatorTimeValidGroup.class
            , PsiCarTransferApplyEntity.IsSubmitValidGroup.class
            , PsiCarTransferApplyEntity.DispatchNumberValidGroup.class
            , PsiCarTransferApplyEntity.InstructionNumberValidGroup.class
            , PsiCarTransferApplyEntity.CreatedByValidGroup.class
            , PsiCarTransferApplyEntity.CreatedDateValidGroup.class
            , PsiCarTransferApplyEntity.UpdatedByValidGroup.class
            , PsiCarTransferApplyEntity.UpdatedDateValidGroup.class
            , PsiCarTransferApplyEntity.IsEnableValidGroup.class
            , PsiCarTransferApplyEntity.IsDeleteValidGroup.class
        };
    }
}
