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

@ApiModel(value = "PsiDispatchInfoEntity", description = "调度信息表(v2)")
@GroupSequence({PsiDispatchInfoEntity.class, PsiDispatchInfoEntity.PsiDispatchInfoEntityValidGroup.class,PsiDispatchInfoEntity.DispatchInfoIdValidGroup.class,PsiDispatchInfoEntity.DispatchApplyIdValidGroup.class,PsiDispatchInfoEntity.DispatchNumberValidGroup.class,PsiDispatchInfoEntity.DispatchStatusValidGroup.class,PsiDispatchInfoEntity.CarrierNameValidGroup.class,PsiDispatchInfoEntity.DriverNameValidGroup.class,PsiDispatchInfoEntity.DriverPhoneValidGroup.class,PsiDispatchInfoEntity.CarLicenseValidGroup.class,PsiDispatchInfoEntity.CreatedByValidGroup.class,PsiDispatchInfoEntity.CreatedDateValidGroup.class,PsiDispatchInfoEntity.UpdatedByValidGroup.class,PsiDispatchInfoEntity.UpdatedDateValidGroup.class,PsiDispatchInfoEntity.IsEnableValidGroup.class,PsiDispatchInfoEntity.IsDeleteValidGroup.class,PsiDispatchInfoEntity.WarehousingByValidGroup.class,PsiDispatchInfoEntity.DestinationValidGroup.class,PsiDispatchInfoEntity.DepartureValidGroup.class}) 
public class PsiDispatchInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 调度信息id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "调度信息id 不能是Null", groups = {PsiDispatchInfoEntityValidGroup.class, DispatchInfoIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="调度信息id 数字精度必须符合(19,0)", groups = {PsiDispatchInfoEntityValidGroup.class, DispatchInfoIdValidGroup.class})
    @ApiModelProperty(value = "调度信息id")
    private Long dispatchInfoId;
    
    
    /**
     * 调度申请id
     */
    @NotNull(message = "调度申请id 不能是Null", groups = {PsiDispatchInfoEntityValidGroup.class, DispatchApplyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="调度申请id 数字精度必须符合(19,0)", groups = {PsiDispatchInfoEntityValidGroup.class, DispatchApplyIdValidGroup.class})
    @ApiModelProperty(value = "调度申请id")
    private Long dispatchApplyId;
    
    /**
     * 调度编号
     */
    @NotNull(message = "调度编号 不能是Null", groups = {PsiDispatchInfoEntityValidGroup.class, DispatchNumberValidGroup.class})
    @Size(min=0, max=22, message="调度编号 字符长度必须小于等于22", groups = {PsiDispatchInfoEntityValidGroup.class, DispatchNumberValidGroup.class})
    @ApiModelProperty(value = "调度编号")
    private String dispatchNumber;
    
    /**
     * 调度生效时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "调度生效时间")
    private Date dispatchEffectiveTime;
    
    /**
     * 调度状态
     */
    @Size(min=0, max=10, message="调度状态 字符长度必须小于等于10", groups = {PsiDispatchInfoEntityValidGroup.class, DispatchStatusValidGroup.class})
    @ApiModelProperty(value = "调度状态")
    private String dispatchStatus;
    
    /**
     * 承运商名称
     */
    @Size(min=0, max=20, message="承运商名称 字符长度必须小于等于20", groups = {PsiDispatchInfoEntityValidGroup.class, CarrierNameValidGroup.class})
    @ApiModelProperty(value = "承运商名称")
    private String carrierName;
    
    /**
     * 司机姓名
     */
    @Size(min=0, max=20, message="司机姓名 字符长度必须小于等于20", groups = {PsiDispatchInfoEntityValidGroup.class, DriverNameValidGroup.class})
    @ApiModelProperty(value = "司机姓名")
    private String driverName;
    
    /**
     * 司机移动电话
     */
    @Size(min=0, max=100, message="司机移动电话 字符长度必须小于等于100", groups = {PsiDispatchInfoEntityValidGroup.class, DriverPhoneValidGroup.class})
    @ApiModelProperty(value = "司机移动电话")
    private String driverPhone;
    
    /**
     * 车牌号
     */
    @Size(min=0, max=20, message="车牌号 字符长度必须小于等于20", groups = {PsiDispatchInfoEntityValidGroup.class, CarLicenseValidGroup.class})
    @ApiModelProperty(value = "车牌号")
    private String carLicense;
    
    /**
     * 实际出发时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际出发时间")
    private Date actualDepartureTime;
    
    /**
     * 预计到达时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预计到达时间")
    private Date estimatedTime;
    
    /**
     * 实际到达时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际到达时间")
    private Date actualTime;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiDispatchInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiDispatchInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiDispatchInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiDispatchInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiDispatchInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiDispatchInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiDispatchInfoEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiDispatchInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    /**
     * 入库时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "入库时间")
    private Date warehousingTime;
    
    /**
     * 入库人id
     */
    @Digits(integer=19, fraction=0, message="入库人id 数字精度必须符合(19,0)", groups = {PsiDispatchInfoEntityValidGroup.class, WarehousingByValidGroup.class})
    @ApiModelProperty(value = "入库人id")
    private Long warehousingBy;
    
    /**
     * 目的地
     */
    @NotNull(message = "目的地 不能是Null", groups = {PsiDispatchInfoEntityValidGroup.class, DestinationValidGroup.class})
    @Size(min=0, max=200, message="目的地 字符长度必须小于等于200", groups = {PsiDispatchInfoEntityValidGroup.class, DestinationValidGroup.class})
    @ApiModelProperty(value = "目的地")
    private String destination;
    
    /**
     * 出发地
     */
    @NotNull(message = "vin码不能为空", groups = {PsiDispatchInfoEntityValidGroup.class, DepartureValidGroup.class})
    @Size(min=0, max=200, message="出发地 字符长度必须小于等于200", groups = {PsiDispatchInfoEntityValidGroup.class, DepartureValidGroup.class})
    @ApiModelProperty(value = "出发地")
    private String carVin;
    
    /**
     * 出发地
     */
    @NotNull(message = "出发地 不能是Null", groups = {PsiDispatchInfoEntityValidGroup.class, DepartureValidGroup.class})
    @Size(min=0, max=200, message="出发地 字符长度必须小于等于200", groups = {PsiDispatchInfoEntityValidGroup.class, DepartureValidGroup.class})
    @ApiModelProperty(value = "出发地")
    private String departure;
    
    public PsiDispatchInfoEntity() {
    }
    
    public PsiDispatchInfoEntity(Long dispatchInfoId) {
        this.dispatchInfoId = dispatchInfoId;
    }

    public void setDispatchInfoId(Long dispatchInfoId) {
        this.dispatchInfoId = dispatchInfoId;
    }
    public Long getDispatchInfoId() {
        return this.dispatchInfoId;
    }
    

    public void setDispatchApplyId(Long dispatchApplyId) {
        this.dispatchApplyId = dispatchApplyId;
    }
    public Long getDispatchApplyId() {
        return this.dispatchApplyId;
    }
    
    public void setDispatchNumber(String dispatchNumber) {
        this.dispatchNumber = dispatchNumber;
    }
    public String getDispatchNumber() {
        return this.dispatchNumber;
    }
    
    public void setDispatchEffectiveTime(Date dispatchEffectiveTime) {
        this.dispatchEffectiveTime = dispatchEffectiveTime;
    }
    public Date getDispatchEffectiveTime() {
        return this.dispatchEffectiveTime;
    }
    
    public void setDispatchStatus(String dispatchStatus) {
        this.dispatchStatus = dispatchStatus;
    }
    public String getDispatchStatus() {
        return this.dispatchStatus;
    }
    
    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }
    public String getCarrierName() {
        return this.carrierName;
    }
    
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
    public String getDriverName() {
        return this.driverName;
    }
    
    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }
    public String getDriverPhone() {
        return this.driverPhone;
    }
    
    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }
    public String getCarLicense() {
        return this.carLicense;
    }
    
    public void setActualDepartureTime(Date actualDepartureTime) {
        this.actualDepartureTime = actualDepartureTime;
    }
    public Date getActualDepartureTime() {
        return this.actualDepartureTime;
    }
    
    public void setEstimatedTime(Date estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
    public Date getEstimatedTime() {
        return this.estimatedTime;
    }
    
    public void setActualTime(Date actualTime) {
        this.actualTime = actualTime;
    }
    public Date getActualTime() {
        return this.actualTime;
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
    
    public void setWarehousingTime(Date warehousingTime) {
        this.warehousingTime = warehousingTime;
    }
    public Date getWarehousingTime() {
        return this.warehousingTime;
    }
    
    public void setWarehousingBy(Long warehousingBy) {
        this.warehousingBy = warehousingBy;
    }
    public Long getWarehousingBy() {
        return this.warehousingBy;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getDestination() {
        return this.destination;
    }
    
    public void setDeparture(String departure) {
        this.departure = departure;
    }
    public String getDeparture() {
        return this.departure;
    }
    
    public String getCarVin() {
		return carVin;
	}

	public void setCarVin(String carVin) {
		this.carVin = carVin;
	}

	/**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (dispatchInfoId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                dispatchInfoId = RandomIDGennerator.get().generate();
    }

    public interface PsiDispatchInfoEntityValidGroup {}
    public interface DispatchInfoIdValidGroup {}
    public interface DispatchApplyIdValidGroup {}
    public interface DispatchNumberValidGroup {}
    public interface DispatchStatusValidGroup {}
    public interface CarrierNameValidGroup {}
    public interface DriverNameValidGroup {}
    public interface DriverPhoneValidGroup {}
    public interface CarLicenseValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface WarehousingByValidGroup {}
    public interface DestinationValidGroup {}
    public interface DepartureValidGroup {}
    public interface CarVinValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiDispatchInfoEntity.DispatchInfoIdValidGroup.class
            , PsiDispatchInfoEntity.DispatchApplyIdValidGroup.class
            , PsiDispatchInfoEntity.DispatchNumberValidGroup.class
            , PsiDispatchInfoEntity.DispatchStatusValidGroup.class
            , PsiDispatchInfoEntity.CarrierNameValidGroup.class
            , PsiDispatchInfoEntity.DriverNameValidGroup.class
            , PsiDispatchInfoEntity.DriverPhoneValidGroup.class
            , PsiDispatchInfoEntity.CarLicenseValidGroup.class
            , PsiDispatchInfoEntity.CreatedByValidGroup.class
            , PsiDispatchInfoEntity.CreatedDateValidGroup.class
            , PsiDispatchInfoEntity.UpdatedByValidGroup.class
            , PsiDispatchInfoEntity.UpdatedDateValidGroup.class
            , PsiDispatchInfoEntity.IsEnableValidGroup.class
            , PsiDispatchInfoEntity.IsDeleteValidGroup.class
            , PsiDispatchInfoEntity.WarehousingByValidGroup.class
            , PsiDispatchInfoEntity.DestinationValidGroup.class
            , PsiDispatchInfoEntity.DepartureValidGroup.class
            , PsiDispatchInfoEntity.CarVinValidGroup.class
        };
    }
}
