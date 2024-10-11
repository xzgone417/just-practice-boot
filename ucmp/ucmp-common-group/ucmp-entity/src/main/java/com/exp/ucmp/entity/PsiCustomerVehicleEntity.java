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

@ApiModel(value = "PsiCustomerVehicleEntity", description = "客户车辆表")
@GroupSequence({PsiCustomerVehicleEntity.class, PsiCustomerVehicleEntity.PsiCustomerVehicleEntityValidGroup.class,PsiCustomerVehicleEntity.VehicleIdValidGroup.class,PsiCustomerVehicleEntity.BookingIdValidGroup.class,PsiCustomerVehicleEntity.CustomerIdValidGroup.class,PsiCustomerVehicleEntity.BrandValidGroup.class,PsiCustomerVehicleEntity.CarTypeValidGroup.class,PsiCustomerVehicleEntity.RegistrationTimeValidGroup.class,PsiCustomerVehicleEntity.DriverMileageValidGroup.class,PsiCustomerVehicleEntity.CarColorValidGroup.class,PsiCustomerVehicleEntity.CarCardNumberValidGroup.class,PsiCustomerVehicleEntity.VinCodeValidGroup.class,PsiCustomerVehicleEntity.TransferOwnershipTimesValidGroup.class,PsiCustomerVehicleEntity.UsingNatureValidGroup.class,PsiCustomerVehicleEntity.CreatedByValidGroup.class,PsiCustomerVehicleEntity.CreatedDateValidGroup.class,PsiCustomerVehicleEntity.UpdatedByValidGroup.class,PsiCustomerVehicleEntity.UpdatedDateValidGroup.class}) 
public class PsiCustomerVehicleEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 车辆ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "车辆ID 不能是Null", groups = {PsiCustomerVehicleEntityValidGroup.class, VehicleIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="车辆ID 数字精度必须符合(19,0)", groups = {PsiCustomerVehicleEntityValidGroup.class, VehicleIdValidGroup.class})
    @ApiModelProperty(value = "车辆ID")
    private Long vehicleId;
    
    
    /**
     * 预约ID
     */
    @NotNull(message = "预约ID 不能是Null", groups = {PsiCustomerVehicleEntityValidGroup.class, BookingIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="预约ID 数字精度必须符合(19,0)", groups = {PsiCustomerVehicleEntityValidGroup.class, BookingIdValidGroup.class})
    @ApiModelProperty(value = "预约ID")
    private Long bookingId;
    
    /**
     * 客户ID
     */
    @NotNull(message = "客户ID 不能是Null", groups = {PsiCustomerVehicleEntityValidGroup.class, CustomerIdValidGroup.class})
    @Size(min=0, max=50, message="客户ID 字符长度必须小于等于50", groups = {PsiCustomerVehicleEntityValidGroup.class, CustomerIdValidGroup.class})
    @ApiModelProperty(value = "客户ID")
    private String customerId;
    
    /**
     * 品牌
     */
    @NotNull(message = "品牌 不能是Null", groups = {PsiCustomerVehicleEntityValidGroup.class, BrandValidGroup.class})
    @Size(min=0, max=20, message="品牌 字符长度必须小于等于20", groups = {PsiCustomerVehicleEntityValidGroup.class, BrandValidGroup.class})
    @ApiModelProperty(value = "品牌")
    private String brand;
    
    /**
     * 车型
     */
    @NotNull(message = "车型 不能是Null", groups = {PsiCustomerVehicleEntityValidGroup.class, CarTypeValidGroup.class})
    @Size(min=0, max=50, message="车型 字符长度必须小于等于50", groups = {PsiCustomerVehicleEntityValidGroup.class, CarTypeValidGroup.class})
    @ApiModelProperty(value = "车型")
    private String carType;
    
    /**
     * 上牌时间
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @NotNull(message = "上牌时间 不能是Null", groups = {PsiCustomerVehicleEntityValidGroup.class, RegistrationTimeValidGroup.class})
    @ApiModelProperty(value = "上牌时间")
    private Date registrationTime;
    
    /**
     * 行驶里程
     */
    @NotNull(message = "行驶里程 不能是Null", groups = {PsiCustomerVehicleEntityValidGroup.class, DriverMileageValidGroup.class})
    @Size(min=0, max=20, message="行驶里程 字符长度必须小于等于20", groups = {PsiCustomerVehicleEntityValidGroup.class, DriverMileageValidGroup.class})
    @ApiModelProperty(value = "行驶里程")
    private String driverMileage;
    
    /**
     * 颜色
     */
    @Size(min=0, max=10, message="颜色 字符长度必须小于等于10", groups = {PsiCustomerVehicleEntityValidGroup.class, CarColorValidGroup.class})
    @ApiModelProperty(value = "颜色")
    private String carColor;
    
    /**
     * 车牌号
     */
    @Size(min=0, max=10, message="车牌号 字符长度必须小于等于10", groups = {PsiCustomerVehicleEntityValidGroup.class, CarCardNumberValidGroup.class})
    @ApiModelProperty(value = "车牌号")
    private String carCardNumber;
    
    /**
     * VIN码
     */
    @Size(min=0, max=20, message="VIN码 字符长度必须小于等于20", groups = {PsiCustomerVehicleEntityValidGroup.class, VinCodeValidGroup.class})
    @ApiModelProperty(value = "VIN码")
    private String vinCode;
    
    /**
     * 过户次数
     */
    @Size(min=0, max=3, message="过户次数 字符长度必须小于等于3", groups = {PsiCustomerVehicleEntityValidGroup.class, TransferOwnershipTimesValidGroup.class})
    @ApiModelProperty(value = "过户次数")
    private String transferOwnershipTimes;
    
    /**
     * 使用性质
     */
    @Size(min=0, max=2, message="使用性质 字符长度必须小于等于2", groups = {PsiCustomerVehicleEntityValidGroup.class, UsingNatureValidGroup.class})
    @ApiModelProperty(value = "使用性质")
    private String usingNature;
    
    /**
     * 创建人
     */
    @NotNull(message = "创建人 不能是Null", groups = {PsiCustomerVehicleEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人 数字精度必须符合(19,0)", groups = {PsiCustomerVehicleEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCustomerVehicleEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 最后更新人
     */
    @NotNull(message = "最后更新人 不能是Null", groups = {PsiCustomerVehicleEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="最后更新人 数字精度必须符合(19,0)", groups = {PsiCustomerVehicleEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "最后更新人")
    private Long updatedBy;
    
    /**
     * 最后更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "最后更新时间 不能是Null", groups = {PsiCustomerVehicleEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "最后更新时间")
    private Date updatedDate;
    
    public PsiCustomerVehicleEntity() {
    }
    
    public PsiCustomerVehicleEntity(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
    public Long getVehicleId() {
        return this.vehicleId;
    }
    

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public Long getBookingId() {
        return this.bookingId;
    }
    
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public String getCustomerId() {
        return this.customerId;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return this.brand;
    }
    
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public String getCarType() {
        return this.carType;
    }
    
    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }
    public Date getRegistrationTime() {
        return this.registrationTime;
    }
    
    public void setDriverMileage(String driverMileage) {
        this.driverMileage = driverMileage;
    }
    public String getDriverMileage() {
        return this.driverMileage;
    }
    
    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
    public String getCarColor() {
        return this.carColor;
    }
    
    public void setCarCardNumber(String carCardNumber) {
        this.carCardNumber = carCardNumber;
    }
    public String getCarCardNumber() {
        return this.carCardNumber;
    }
    
    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }
    public String getVinCode() {
        return this.vinCode;
    }
    
    public void setTransferOwnershipTimes(String transferOwnershipTimes) {
        this.transferOwnershipTimes = transferOwnershipTimes;
    }
    public String getTransferOwnershipTimes() {
        return this.transferOwnershipTimes;
    }
    
    public void setUsingNature(String usingNature) {
        this.usingNature = usingNature;
    }
    public String getUsingNature() {
        return this.usingNature;
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
              (vehicleId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                vehicleId = RandomIDGennerator.get().generate();
    }

    public interface PsiCustomerVehicleEntityValidGroup {}
    public interface VehicleIdValidGroup {}
    public interface BookingIdValidGroup {}
    public interface CustomerIdValidGroup {}
    public interface BrandValidGroup {}
    public interface CarTypeValidGroup {}
    public interface RegistrationTimeValidGroup {}
    public interface DriverMileageValidGroup {}
    public interface CarColorValidGroup {}
    public interface CarCardNumberValidGroup {}
    public interface VinCodeValidGroup {}
    public interface TransferOwnershipTimesValidGroup {}
    public interface UsingNatureValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            VehicleIdValidGroup.class
            , BookingIdValidGroup.class
            , CustomerIdValidGroup.class
            , BrandValidGroup.class
            , CarTypeValidGroup.class
            , RegistrationTimeValidGroup.class
            , DriverMileageValidGroup.class
            , CarColorValidGroup.class
            , CarCardNumberValidGroup.class
            , VinCodeValidGroup.class
            , TransferOwnershipTimesValidGroup.class
            , UsingNatureValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
