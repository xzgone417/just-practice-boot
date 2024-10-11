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

@ApiModel(value = "PsiCustomerReservationMsgEntity", description = "客户预约信息表")
@GroupSequence({PsiCustomerReservationMsgEntity.class, PsiCustomerReservationMsgEntity.PsiCustomerReservationMsgEntityValidGroup.class,PsiCustomerReservationMsgEntity.ReservationIdValidGroup.class,PsiCustomerReservationMsgEntity.ReservationDetectionAddressValidGroup.class,PsiCustomerReservationMsgEntity.CustomerExpectPriceValidGroup.class,PsiCustomerReservationMsgEntity.VehicleRegistrationFileIdValidGroup.class,PsiCustomerReservationMsgEntity.CreatedByValidGroup.class,PsiCustomerReservationMsgEntity.CreatedDateValidGroup.class,PsiCustomerReservationMsgEntity.UpdatedByValidGroup.class,PsiCustomerReservationMsgEntity.UpdatedDateValidGroup.class}) 
public class PsiCustomerReservationMsgEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "预约ID 不能是Null", groups = {PsiCustomerReservationMsgEntityValidGroup.class, ReservationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="预约ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationMsgEntityValidGroup.class, ReservationIdValidGroup.class})
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    
    /**
     * 预约检测时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预约检测时间")
    private Date reservationDetectionDate;
    
    /**
     * 预约检测地点
     */
    @NotNull(message = "预约检测地点 不能是Null", groups = {PsiCustomerReservationMsgEntityValidGroup.class, ReservationDetectionAddressValidGroup.class})
    @Size(min=0, max=50, message="预约检测地点 字符长度必须小于等于50", groups = {PsiCustomerReservationMsgEntityValidGroup.class, ReservationDetectionAddressValidGroup.class})
    @ApiModelProperty(value = "预约检测地点")
    private String reservationDetectionAddress;
    
    /**
     * 客户期望价格
     */
    @Digits(integer=9, fraction=0, message="客户期望价格 数字精度必须符合(9,0)", groups = {PsiCustomerReservationMsgEntityValidGroup.class, CustomerExpectPriceValidGroup.class})
    @ApiModelProperty(value = "客户期望价格")
    private Long customerExpectPrice;
    
    /**
     * 接单截止时间(录入)
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "接单截止时间(录入)")
    private Date orderReceivingDeadline;
    
    /**
     * 行驶证文件ID
     */
    @Digits(integer=19, fraction=0, message="行驶证文件ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationMsgEntityValidGroup.class, VehicleRegistrationFileIdValidGroup.class})
    @ApiModelProperty(value = "行驶证文件ID")
    private Long vehicleRegistrationFileId;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCustomerReservationMsgEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationMsgEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCustomerReservationMsgEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCustomerReservationMsgEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationMsgEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCustomerReservationMsgEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PsiCustomerReservationMsgEntity() {
    }
    
    public PsiCustomerReservationMsgEntity(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
    }
    

    public void setReservationDetectionDate(Date reservationDetectionDate) {
        this.reservationDetectionDate = reservationDetectionDate;
    }
    public Date getReservationDetectionDate() {
        return this.reservationDetectionDate;
    }
    
    public void setReservationDetectionAddress(String reservationDetectionAddress) {
        this.reservationDetectionAddress = reservationDetectionAddress;
    }
    public String getReservationDetectionAddress() {
        return this.reservationDetectionAddress;
    }
    
    public void setCustomerExpectPrice(Long customerExpectPrice) {
        this.customerExpectPrice = customerExpectPrice;
    }
    public Long getCustomerExpectPrice() {
        return this.customerExpectPrice;
    }
    
    public void setOrderReceivingDeadline(Date orderReceivingDeadline) {
        this.orderReceivingDeadline = orderReceivingDeadline;
    }
    public Date getOrderReceivingDeadline() {
        return this.orderReceivingDeadline;
    }
    
    public void setVehicleRegistrationFileId(Long vehicleRegistrationFileId) {
        this.vehicleRegistrationFileId = vehicleRegistrationFileId;
    }
    public Long getVehicleRegistrationFileId() {
        return this.vehicleRegistrationFileId;
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
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (reservationId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                reservationId = RandomIDGennerator.get().generate();
    }

    public interface PsiCustomerReservationMsgEntityValidGroup {}
    public interface ReservationIdValidGroup {}
    public interface ReservationDetectionAddressValidGroup {}
    public interface CustomerExpectPriceValidGroup {}
    public interface VehicleRegistrationFileIdValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            ReservationIdValidGroup.class
            , ReservationDetectionAddressValidGroup.class
            , CustomerExpectPriceValidGroup.class
            , VehicleRegistrationFileIdValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
