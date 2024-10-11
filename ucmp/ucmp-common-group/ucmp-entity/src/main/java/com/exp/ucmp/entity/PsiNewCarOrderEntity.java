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

@ApiModel(value = "PsiNewCarOrderEntity", description = "新车订单表")
@GroupSequence({PsiNewCarOrderEntity.class, PsiNewCarOrderEntity.PsiNewCarOrderEntityValidGroup.class,PsiNewCarOrderEntity.NewCarIdValidGroup.class,PsiNewCarOrderEntity.ReservationIdValidGroup.class,PsiNewCarOrderEntity.NewCarModelsValidGroup.class,PsiNewCarOrderEntity.NewCarVinValidGroup.class,PsiNewCarOrderEntity.NewCarInvoiceNoValidGroup.class,PsiNewCarOrderEntity.NewCarOrderNoValidGroup.class,PsiNewCarOrderEntity.OrderStatusValidGroup.class,PsiNewCarOrderEntity.OwnerNameValidGroup.class,PsiNewCarOrderEntity.OwnerPhoneValidGroup.class,PsiNewCarOrderEntity.MainUserNameValidGroup.class,PsiNewCarOrderEntity.MainUserPhoneValidGroup.class,PsiNewCarOrderEntity.CarSeriesCodeValidGroup.class,PsiNewCarOrderEntity.CarSeriesValidGroup.class,PsiNewCarOrderEntity.CarTypeCodeValidGroup.class,PsiNewCarOrderEntity.CarTypeValidGroup.class,PsiNewCarOrderEntity.OwnerCardNoValidGroup.class,PsiNewCarOrderEntity.OrderDeliverStatusValidGroup.class,PsiNewCarOrderEntity.CreatedByValidGroup.class,PsiNewCarOrderEntity.CreatedDateValidGroup.class,PsiNewCarOrderEntity.UpdatedByValidGroup.class,PsiNewCarOrderEntity.UpdatedDateValidGroup.class}) 
public class PsiNewCarOrderEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 新车ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "新车ID 不能是Null", groups = {PsiNewCarOrderEntityValidGroup.class, NewCarIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="新车ID 数字精度必须符合(19,0)", groups = {PsiNewCarOrderEntityValidGroup.class, NewCarIdValidGroup.class})
    @ApiModelProperty(value = "新车ID")
    private Long newCarId;
    
    
    /**
     * 客户ID
     */
    @NotNull(message = "客户ID 不能是Null", groups = {PsiNewCarOrderEntityValidGroup.class, ReservationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="客户ID 数字精度必须符合(19,0)", groups = {PsiNewCarOrderEntityValidGroup.class, ReservationIdValidGroup.class})
    @ApiModelProperty(value = "客户ID")
    private Long reservationId;
    
    /**
     * 新车车型
     */
    @Size(min=0, max=20, message="新车车型 字符长度必须小于等于20", groups = {PsiNewCarOrderEntityValidGroup.class, NewCarModelsValidGroup.class})
    @ApiModelProperty(value = "新车车型")
    private String newCarModels;
    
    /**
     * 新车VIN码
     */
    @Size(min=0, max=30, message="新车VIN码 字符长度必须小于等于30", groups = {PsiNewCarOrderEntityValidGroup.class, NewCarVinValidGroup.class})
    @ApiModelProperty(value = "新车VIN码")
    private String newCarVin;
    
    /**
     * 新车发票号
     */
    @Size(min=0, max=30, message="新车发票号 字符长度必须小于等于30", groups = {PsiNewCarOrderEntityValidGroup.class, NewCarInvoiceNoValidGroup.class})
    @ApiModelProperty(value = "新车发票号")
    private String newCarInvoiceNo;
    
    /**
     * 新车订单号
     */
    @Size(min=0, max=50, message="新车订单号 字符长度必须小于等于50", groups = {PsiNewCarOrderEntityValidGroup.class, NewCarOrderNoValidGroup.class})
    @ApiModelProperty(value = "新车订单号")
    private String newCarOrderNo;
    
    /**
     * 新车交付日期
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "新车交付日期")
    private Date newCarDeliveryDate;
    
    /**
     * 订单状态
     */
    @Size(min=0, max=10, message="订单状态 字符长度必须小于等于10", groups = {PsiNewCarOrderEntityValidGroup.class, OrderStatusValidGroup.class})
    @ApiModelProperty(value = "订单状态")
    private String orderStatus;
    
    /**
     * 车辆所有人名称
     */
    @Size(min=0, max=50, message="车辆所有人名称 字符长度必须小于等于50", groups = {PsiNewCarOrderEntityValidGroup.class, OwnerNameValidGroup.class})
    @ApiModelProperty(value = "车辆所有人名称")
    private String ownerName;
    
    /**
     * 车辆所有人手机号
     */
    @NotNull(message = "车辆所有人手机号 不能是Null", groups = {PsiNewCarOrderEntityValidGroup.class, OwnerPhoneValidGroup.class})
    @Size(min=0, max=100, message="车辆所有人手机号 字符长度必须小于等于100", groups = {PsiNewCarOrderEntityValidGroup.class, OwnerPhoneValidGroup.class})
    @ApiModelProperty(value = "车辆所有人手机号")
    private String ownerPhone;
    
    /**
     * 主用车人
     */
    @Size(min=0, max=50, message="主用车人 字符长度必须小于等于50", groups = {PsiNewCarOrderEntityValidGroup.class, MainUserNameValidGroup.class})
    @ApiModelProperty(value = "主用车人")
    private String mainUserName;
    
    /**
     * 主用车手机号
     */
    @Size(min=0, max=100, message="主用车手机号 字符长度必须小于等于100", groups = {PsiNewCarOrderEntityValidGroup.class, MainUserPhoneValidGroup.class})
    @ApiModelProperty(value = "主用车手机号")
    private String mainUserPhone;
    
    /**
     * 工程车型编码
     */
    @Size(min=0, max=20, message="工程车型编码 字符长度必须小于等于20", groups = {PsiNewCarOrderEntityValidGroup.class, CarSeriesCodeValidGroup.class})
    @ApiModelProperty(value = "工程车型编码")
    private String carSeriesCode;
    
    /**
     * 工程车型名称
     */
    @Size(min=0, max=100, message="工程车型名称 字符长度必须小于等于100", groups = {PsiNewCarOrderEntityValidGroup.class, CarSeriesValidGroup.class})
    @ApiModelProperty(value = "工程车型名称")
    private String carSeries;
    
    /**
     * 基础车型编码
     */
    @Size(min=0, max=20, message="基础车型编码 字符长度必须小于等于20", groups = {PsiNewCarOrderEntityValidGroup.class, CarTypeCodeValidGroup.class})
    @ApiModelProperty(value = "基础车型编码")
    private String carTypeCode;
    
    /**
     * 基础车型名称
     */
    @Size(min=0, max=100, message="基础车型名称 字符长度必须小于等于100", groups = {PsiNewCarOrderEntityValidGroup.class, CarTypeValidGroup.class})
    @ApiModelProperty(value = "基础车型名称")
    private String carType;
    
    /**
     * 车辆所有人身份证
     */
    @NotNull(message = "车辆所有人身份证 不能是Null", groups = {PsiNewCarOrderEntityValidGroup.class, OwnerCardNoValidGroup.class})
    @Size(min=0, max=100, message="车辆所有人身份证 字符长度必须小于等于100", groups = {PsiNewCarOrderEntityValidGroup.class, OwnerCardNoValidGroup.class})
    @ApiModelProperty(value = "车辆所有人身份证")
    private String ownerCardNo;
    
    /**
     * 订单交付状态
     */
    @Size(min=0, max=4, message="订单交付状态 字符长度必须小于等于4", groups = {PsiNewCarOrderEntityValidGroup.class, OrderDeliverStatusValidGroup.class})
    @ApiModelProperty(value = "订单交付状态")
    private String orderDeliverStatus;
    
    @ApiModelProperty(value = "权益OR积分选择，3401 权益 3402 积分")
    private String isRightOrPoints;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiNewCarOrderEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiNewCarOrderEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiNewCarOrderEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiNewCarOrderEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiNewCarOrderEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiNewCarOrderEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PsiNewCarOrderEntity() {
    }
    
    public PsiNewCarOrderEntity(Long newCarId) {
        this.newCarId = newCarId;
    }

    public void setNewCarId(Long newCarId) {
        this.newCarId = newCarId;
    }
    public Long getNewCarId() {
        return this.newCarId;
    }
    

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
    }
    
    public void setNewCarModels(String newCarModels) {
        this.newCarModels = newCarModels;
    }
    public String getNewCarModels() {
        return this.newCarModels;
    }
    
    public void setNewCarVin(String newCarVin) {
        this.newCarVin = newCarVin;
    }
    public String getNewCarVin() {
        return this.newCarVin;
    }
    
    public void setNewCarInvoiceNo(String newCarInvoiceNo) {
        this.newCarInvoiceNo = newCarInvoiceNo;
    }
    public String getNewCarInvoiceNo() {
        return this.newCarInvoiceNo;
    }
    
    public void setNewCarOrderNo(String newCarOrderNo) {
        this.newCarOrderNo = newCarOrderNo;
    }
    public String getNewCarOrderNo() {
        return this.newCarOrderNo;
    }
    
    public void setNewCarDeliveryDate(Date newCarDeliveryDate) {
        this.newCarDeliveryDate = newCarDeliveryDate;
    }
    public Date getNewCarDeliveryDate() {
        return this.newCarDeliveryDate;
    }
    
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getOwnerName() {
        return this.ownerName;
    }
    
    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
    public String getOwnerPhone() {
        return this.ownerPhone;
    }
    
    public void setMainUserName(String mainUserName) {
        this.mainUserName = mainUserName;
    }
    public String getMainUserName() {
        return this.mainUserName;
    }
    
    public void setMainUserPhone(String mainUserPhone) {
        this.mainUserPhone = mainUserPhone;
    }
    public String getMainUserPhone() {
        return this.mainUserPhone;
    }
    
    public void setCarSeriesCode(String carSeriesCode) {
        this.carSeriesCode = carSeriesCode;
    }
    public String getCarSeriesCode() {
        return this.carSeriesCode;
    }
    
    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }
    public String getCarSeries() {
        return this.carSeries;
    }
    
    public void setCarTypeCode(String carTypeCode) {
        this.carTypeCode = carTypeCode;
    }
    public String getCarTypeCode() {
        return this.carTypeCode;
    }
    
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public String getCarType() {
        return this.carType;
    }
    
    public void setOwnerCardNo(String ownerCardNo) {
        this.ownerCardNo = ownerCardNo;
    }
    public String getOwnerCardNo() {
        return this.ownerCardNo;
    }
    
    public void setOrderDeliverStatus(String orderDeliverStatus) {
        this.orderDeliverStatus = orderDeliverStatus;
    }
    public String getOrderDeliverStatus() {
        return this.orderDeliverStatus;
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
    
    public String getIsRightOrPoints() {
		return isRightOrPoints;
	}

	public void setIsRightOrPoints(String isRightOrPoints) {
		this.isRightOrPoints = isRightOrPoints;
	}

	/**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (newCarId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                newCarId = RandomIDGennerator.get().generate();
    }

    public interface PsiNewCarOrderEntityValidGroup {}
    public interface NewCarIdValidGroup {}
    public interface ReservationIdValidGroup {}
    public interface NewCarModelsValidGroup {}
    public interface NewCarVinValidGroup {}
    public interface NewCarInvoiceNoValidGroup {}
    public interface NewCarOrderNoValidGroup {}
    public interface OrderStatusValidGroup {}
    public interface OwnerNameValidGroup {}
    public interface OwnerPhoneValidGroup {}
    public interface MainUserNameValidGroup {}
    public interface MainUserPhoneValidGroup {}
    public interface CarSeriesCodeValidGroup {}
    public interface CarSeriesValidGroup {}
    public interface CarTypeCodeValidGroup {}
    public interface CarTypeValidGroup {}
    public interface OwnerCardNoValidGroup {}
    public interface OrderDeliverStatusValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            NewCarIdValidGroup.class
            , ReservationIdValidGroup.class
            , NewCarModelsValidGroup.class
            , NewCarVinValidGroup.class
            , NewCarInvoiceNoValidGroup.class
            , NewCarOrderNoValidGroup.class
            , OrderStatusValidGroup.class
            , OwnerNameValidGroup.class
            , OwnerPhoneValidGroup.class
            , MainUserNameValidGroup.class
            , MainUserPhoneValidGroup.class
            , CarSeriesCodeValidGroup.class
            , CarSeriesValidGroup.class
            , CarTypeCodeValidGroup.class
            , CarTypeValidGroup.class
            , OwnerCardNoValidGroup.class
            , OrderDeliverStatusValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
