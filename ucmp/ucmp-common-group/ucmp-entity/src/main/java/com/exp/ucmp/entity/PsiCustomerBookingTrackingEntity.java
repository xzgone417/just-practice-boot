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

@ApiModel(value = "PsiCustomerBookingTrackingEntity", description = "客户预约跟踪表")
@GroupSequence({PsiCustomerBookingTrackingEntity.class, PsiCustomerBookingTrackingEntity.PsiCustomerBookingTrackingEntityValidGroup.class,PsiCustomerBookingTrackingEntity.BookingIdValidGroup.class,PsiCustomerBookingTrackingEntity.CluesIdValidGroup.class,PsiCustomerBookingTrackingEntity.CustomerIdValidGroup.class,PsiCustomerBookingTrackingEntity.StoreIdValidGroup.class,PsiCustomerBookingTrackingEntity.AdviserIdValidGroup.class,PsiCustomerBookingTrackingEntity.DrivingFileIdValidGroup.class,PsiCustomerBookingTrackingEntity.BusinessTypeValidGroup.class,PsiCustomerBookingTrackingEntity.BusinessNumberValidGroup.class,PsiCustomerBookingTrackingEntity.ScheduledTestTimeValidGroup.class,PsiCustomerBookingTrackingEntity.ScheduledTestAddressValidGroup.class,PsiCustomerBookingTrackingEntity.CustomerExpectedPriceValidGroup.class,PsiCustomerBookingTrackingEntity.ReceivingOrdersDeadlineValidGroup.class,PsiCustomerBookingTrackingEntity.TrackStatusValidGroup.class,PsiCustomerBookingTrackingEntity.CreatedByValidGroup.class,PsiCustomerBookingTrackingEntity.CreatedDateValidGroup.class,PsiCustomerBookingTrackingEntity.UpdatedByValidGroup.class,PsiCustomerBookingTrackingEntity.UpdatedDateValidGroup.class}) 
public class PsiCustomerBookingTrackingEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 预约id 
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "预约id  不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, BookingIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="预约id  数字精度必须符合(19,0)", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, BookingIdValidGroup.class})
    @ApiModelProperty(value = "预约id ")
    private Long bookingId;
    
    
    /**
     * 线索id 
     */
    @NotNull(message = "线索id  不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, CluesIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="线索id  数字精度必须符合(19,0)", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, CluesIdValidGroup.class})
    @ApiModelProperty(value = "线索id ")
    private Long cluesId;
    
    /**
     * 客户ID 
     */
    @NotNull(message = "客户ID  不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, CustomerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="客户ID  数字精度必须符合(19,0)", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, CustomerIdValidGroup.class})
    @ApiModelProperty(value = "客户ID ")
    private Long customerId;
    
    /**
     * 门店ID\n
     */
    @NotNull(message = "门店ID\n 不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, StoreIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="门店ID\n 数字精度必须符合(19,0)", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, StoreIdValidGroup.class})
    @ApiModelProperty(value = "门店ID\n")
    private Long storeId;
    
    /**
     * 顾问ID 
     */
    @NotNull(message = "顾问ID  不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, AdviserIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="顾问ID  数字精度必须符合(19,0)", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, AdviserIdValidGroup.class})
    @ApiModelProperty(value = "顾问ID ")
    private Long adviserId;
    
    /**
     * 行驶证文件ID\n
     */
    @Digits(integer=19, fraction=0, message="行驶证文件ID\n 数字精度必须符合(19,0)", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, DrivingFileIdValidGroup.class})
    @ApiModelProperty(value = "行驶证文件ID\n")
    private Long drivingFileId;
    
    /**
     * 业务类型：01、置换业务
     */
    @NotNull(message = "业务类型：01、置换业务 不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, BusinessTypeValidGroup.class})
    @Size(min=0, max=2, message="业务类型：01、置换业务 字符长度必须小于等于2", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, BusinessTypeValidGroup.class})
    @ApiModelProperty(value = "业务类型：01、置换业务")
    private String businessType;
    
    /**
     * 业务单号\n
     */
    @NotNull(message = "业务单号\n 不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, BusinessNumberValidGroup.class})
    @Size(min=0, max=20, message="业务单号\n 字符长度必须小于等于20", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, BusinessNumberValidGroup.class})
    @ApiModelProperty(value = "业务单号\n")
    private String businessNumber;
    
    /**
     * 预约检测时间 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "预约检测时间  不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, ScheduledTestTimeValidGroup.class})
    @ApiModelProperty(value = "预约检测时间 ")
    private Date scheduledTestTime;
    
    /**
     * 预约检测地点 
     */
    @NotNull(message = "预约检测地点  不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, ScheduledTestAddressValidGroup.class})
    @Size(min=0, max=50, message="预约检测地点  字符长度必须小于等于50", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, ScheduledTestAddressValidGroup.class})
    @ApiModelProperty(value = "预约检测地点 ")
    private String scheduledTestAddress;
    
    /**
     * 客户期望价格
     */
    @Size(min=0, max=10, message="客户期望价格 字符长度必须小于等于10", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, CustomerExpectedPriceValidGroup.class})
    @ApiModelProperty(value = "客户期望价格")
    private String customerExpectedPrice;
    
    /**
     * 接单截止时间 
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "接单截止时间  不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, ReceivingOrdersDeadlineValidGroup.class})
    @ApiModelProperty(value = "接单截止时间 ")
    private Date receivingOrdersDeadline;
    
    /**
     * 跟踪状态：01、待分配，02、已分配，03、开始检测，04、已关闭
     */
    @NotNull(message = "跟踪状态：01、待分配，02、已分配，03、开始检测，04、已关闭 不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, TrackStatusValidGroup.class})
    @Size(min=0, max=2, message="跟踪状态：01、待分配，02、已分配，03、开始检测，04、已关闭 字符长度必须小于等于2", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, TrackStatusValidGroup.class})
    @ApiModelProperty(value = "跟踪状态：01、待分配，02、已分配，03、开始检测，04、已关闭")
    private String trackStatus;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 最后更新人
     */
    @NotNull(message = "最后更新人 不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="最后更新人 数字精度必须符合(19,0)", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "最后更新人")
    private Long updatedBy;
    
    /**
     * 最后更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "最后更新时间 不能是Null", groups = {PsiCustomerBookingTrackingEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "最后更新时间")
    private Date updatedDate;
    
    public PsiCustomerBookingTrackingEntity() {
    }
    
    public PsiCustomerBookingTrackingEntity(Long bookingId) {
        this.bookingId = bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public Long getBookingId() {
        return this.bookingId;
    }
    

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }
    public Long getCluesId() {
        return this.cluesId;
    }
    
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Long getStoreId() {
        return this.storeId;
    }
    
    public void setAdviserId(Long adviserId) {
        this.adviserId = adviserId;
    }
    public Long getAdviserId() {
        return this.adviserId;
    }
    
    public void setDrivingFileId(Long drivingFileId) {
        this.drivingFileId = drivingFileId;
    }
    public Long getDrivingFileId() {
        return this.drivingFileId;
    }
    
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    public String getBusinessType() {
        return this.businessType;
    }
    
    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }
    public String getBusinessNumber() {
        return this.businessNumber;
    }
    
    public void setScheduledTestTime(Date scheduledTestTime) {
        this.scheduledTestTime = scheduledTestTime;
    }
    public Date getScheduledTestTime() {
        return this.scheduledTestTime;
    }
    
    public void setScheduledTestAddress(String scheduledTestAddress) {
        this.scheduledTestAddress = scheduledTestAddress;
    }
    public String getScheduledTestAddress() {
        return this.scheduledTestAddress;
    }
    
    public void setCustomerExpectedPrice(String customerExpectedPrice) {
        this.customerExpectedPrice = customerExpectedPrice;
    }
    public String getCustomerExpectedPrice() {
        return this.customerExpectedPrice;
    }
    
    public void setReceivingOrdersDeadline(Date receivingOrdersDeadline) {
        this.receivingOrdersDeadline = receivingOrdersDeadline;
    }
    public Date getReceivingOrdersDeadline() {
        return this.receivingOrdersDeadline;
    }
    
    public void setTrackStatus(String trackStatus) {
        this.trackStatus = trackStatus;
    }
    public String getTrackStatus() {
        return this.trackStatus;
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
              (bookingId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                bookingId = RandomIDGennerator.get().generate();
    }

    public interface PsiCustomerBookingTrackingEntityValidGroup {}
    public interface BookingIdValidGroup {}
    public interface CluesIdValidGroup {}
    public interface CustomerIdValidGroup {}
    public interface StoreIdValidGroup {}
    public interface AdviserIdValidGroup {}
    public interface DrivingFileIdValidGroup {}
    public interface BusinessTypeValidGroup {}
    public interface BusinessNumberValidGroup {}
    public interface ScheduledTestTimeValidGroup {}
    public interface ScheduledTestAddressValidGroup {}
    public interface CustomerExpectedPriceValidGroup {}
    public interface ReceivingOrdersDeadlineValidGroup {}
    public interface TrackStatusValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            BookingIdValidGroup.class
            , CluesIdValidGroup.class
            , CustomerIdValidGroup.class
            , StoreIdValidGroup.class
            , AdviserIdValidGroup.class
            , DrivingFileIdValidGroup.class
            , BusinessTypeValidGroup.class
            , BusinessNumberValidGroup.class
            , ScheduledTestTimeValidGroup.class
            , ScheduledTestAddressValidGroup.class
            , CustomerExpectedPriceValidGroup.class
            , ReceivingOrdersDeadlineValidGroup.class
            , TrackStatusValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
