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

@ApiModel(value = "PsiOrderReceivingRecordEntity", description = "接单记录表")
@GroupSequence({PsiOrderReceivingRecordEntity.class, PsiOrderReceivingRecordEntity.PsiOrderReceivingRecordEntityValidGroup.class,PsiOrderReceivingRecordEntity.RecordIdValidGroup.class,PsiOrderReceivingRecordEntity.ReservationIdValidGroup.class,PsiOrderReceivingRecordEntity.RecordTypeValidGroup.class,PsiOrderReceivingRecordEntity.OrderStatusValidGroup.class,PsiOrderReceivingRecordEntity.ReasonValidGroup.class,PsiOrderReceivingRecordEntity.OperationValidGroup.class,PsiOrderReceivingRecordEntity.OperationByValidGroup.class,PsiOrderReceivingRecordEntity.OperationDateValidGroup.class}) 
public class PsiOrderReceivingRecordEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 记录ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "记录ID 不能是Null", groups = {PsiOrderReceivingRecordEntityValidGroup.class, RecordIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="记录ID 数字精度必须符合(19,0)", groups = {PsiOrderReceivingRecordEntityValidGroup.class, RecordIdValidGroup.class})
    @ApiModelProperty(value = "记录ID")
    private Long recordId;
    
    
    /**
     * 预约ID
     */
    @NotNull(message = "预约ID 不能是Null", groups = {PsiOrderReceivingRecordEntityValidGroup.class, ReservationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="预约ID 数字精度必须符合(19,0)", groups = {PsiOrderReceivingRecordEntityValidGroup.class, ReservationIdValidGroup.class})
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    /**
     * 记录类型 01:接单,02:报价,03:收购
     */
    @NotNull(message = "记录类型 01:接单,02:报价,03:收购 不能是Null", groups = {PsiOrderReceivingRecordEntityValidGroup.class, RecordTypeValidGroup.class})
    @Size(min=0, max=10, message="记录类型 01:接单,02:报价,03:收购 字符长度必须小于等于10", groups = {PsiOrderReceivingRecordEntityValidGroup.class, RecordTypeValidGroup.class})
    @ApiModelProperty(value = "记录类型 01:接单,02:报价,03:收购")
    private String recordType;
    
    /**
     * 订单状态
     */
    @NotNull(message = "订单状态 不能是Null", groups = {PsiOrderReceivingRecordEntityValidGroup.class, OrderStatusValidGroup.class})
    @Size(min=0, max=100, message="订单状态 字符长度必须小于等于100", groups = {PsiOrderReceivingRecordEntityValidGroup.class, OrderStatusValidGroup.class})
    @ApiModelProperty(value = "订单状态")
    private String orderStatus;
    
    /**
     * 原因
     */
    @Size(min=0, max=100, message="原因 字符长度必须小于等于100", groups = {PsiOrderReceivingRecordEntityValidGroup.class, ReasonValidGroup.class})
    @ApiModelProperty(value = "原因")
    private String reason;
    
    /**
     * 操作名称
     */
    @NotNull(message = "操作名称 不能是Null", groups = {PsiOrderReceivingRecordEntityValidGroup.class, OperationValidGroup.class})
    @Size(min=0, max=100, message="操作名称 字符长度必须小于等于100", groups = {PsiOrderReceivingRecordEntityValidGroup.class, OperationValidGroup.class})
    @ApiModelProperty(value = "操作名称")
    private String operation;
    
    /**
     * 操作人
     */
    @Digits(integer=19, fraction=0, message="操作人 数字精度必须符合(19,0)", groups = {PsiOrderReceivingRecordEntityValidGroup.class, OperationByValidGroup.class})
    @ApiModelProperty(value = "操作人")
    private Long operationBy;
    
    /**
     * 操作时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "操作时间 不能是Null", groups = {PsiOrderReceivingRecordEntityValidGroup.class, OperationDateValidGroup.class})
    @ApiModelProperty(value = "操作时间")
    private Date operationDate;
    
    public PsiOrderReceivingRecordEntity() {
    }
    
    public PsiOrderReceivingRecordEntity(Long recordId) {
        this.recordId = recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }
    public Long getRecordId() {
        return this.recordId;
    }
    

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
    }
    
    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }
    public String getRecordType() {
        return this.recordType;
    }
    
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getReason() {
        return this.reason;
    }
    
    public void setOperation(String operation) {
        this.operation = operation;
    }
    public String getOperation() {
        return this.operation;
    }
    
    public void setOperationBy(Long operationBy) {
        this.operationBy = operationBy;
    }
    public Long getOperationBy() {
        return this.operationBy;
    }
    
    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }
    public Date getOperationDate() {
        return this.operationDate;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (recordId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                recordId = RandomIDGennerator.get().generate();
    }

    public interface PsiOrderReceivingRecordEntityValidGroup {}
    public interface RecordIdValidGroup {}
    public interface ReservationIdValidGroup {}
    public interface RecordTypeValidGroup {}
    public interface OrderStatusValidGroup {}
    public interface ReasonValidGroup {}
    public interface OperationValidGroup {}
    public interface OperationByValidGroup {}
    public interface OperationDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiOrderReceivingRecordEntity.RecordIdValidGroup.class
            , PsiOrderReceivingRecordEntity.ReservationIdValidGroup.class
            , PsiOrderReceivingRecordEntity.RecordTypeValidGroup.class
            , PsiOrderReceivingRecordEntity.OrderStatusValidGroup.class
            , PsiOrderReceivingRecordEntity.ReasonValidGroup.class
            , PsiOrderReceivingRecordEntity.OperationValidGroup.class
            , PsiOrderReceivingRecordEntity.OperationByValidGroup.class
            , PsiOrderReceivingRecordEntity.OperationDateValidGroup.class
        };
    }
}
