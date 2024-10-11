package com.exp.ucmp.replacement.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "PsiNewCarOrderDto", description = "新车信息")
public class PsiNewCarOrderDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 新车ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "新车ID")
    private Long newCarId;


    /**
     * 预约id
     */
    @ApiModelProperty(value = "预约id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long reservationId;

    /**
     * 新车车型
     */
    @ApiModelProperty(value = "新车车型")
    private String newCarModels;

    /**
     * 新车VIN码
     */
    @ApiModelProperty(value = "新车VIN码")
    private String newCarVin;

    /**
     * 新车发票号
     */
    @ApiModelProperty(value = "新车发票号")
    private String newCarInvoiceNo;

    /**
     * 新车订单号
     */
    @ApiModelProperty(value = "新车订单号")
    private String newCarOrderNo;

    /**
     * 新车交付日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "新车交付日期")
    private Date newCarDeliveryDate;

    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态")
    private String orderStatus;

    /**
     * 车辆所有人名称
     */
    @ApiModelProperty(value = "车辆所有人名称")
    private String ownerName;

    /**
     * 车辆所有人电话
     */
    @ApiModelProperty(value = "车辆所有人电话")
    private String ownerPhone;

    /**
     * 主用车人
     */
    @ApiModelProperty(value = "主用车人")
    private String mainUserName;

    /**
     * 主用车手机号
     */
    @ApiModelProperty(value = "主用车手机号")
    private String mainUserPhone;

    /**
     * 工程车型编码
     */
    @ApiModelProperty(value = "工程车型编码")
    private String carSeriesCode;

    /**
     * 工程车型名称
     */
   @ApiModelProperty(value = "工程车型名称")
    private String carSeries;

    /**
     * 基础车型编码
     */
   @ApiModelProperty(value = "基础车型编码")
    private String carTypeCode;

    /**
     * 基础车型名称
     */
    @ApiModelProperty(value = "基础车型名称")
    private String carType;

    /**
     * 所有人证件号
     */
    @ApiModelProperty(value = "所有人证件号")
    private String ownerCardNo;

    /**
     * 订单交付状态
     */
    @ApiModelProperty(value = "订单交付状态")
    private String orderDeliverStatus;

    @ApiModelProperty(value = "权益OR积分选择，3401 权益 3402 积分")
    private String isRightOrPoints;
    
    @ApiModelProperty(value = "权益包名称")
    private String rightActivityName;
    
    @ApiModelProperty(value = "积分值")
    private Integer pointsValue;


    public PsiNewCarOrderDto() {
    }

    public String getMainUserName() {
        return mainUserName;
    }

    public void setMainUserName(String mainUserName) {
        this.mainUserName = mainUserName;
    }

    public String getMainUserPhone() {
        return mainUserPhone;
    }

    public void setMainUserPhone(String mainUserPhone) {
        this.mainUserPhone = mainUserPhone;
    }

    public Long getNewCarId() {
        return newCarId;
    }

    public void setNewCarId(Long newCarId) {
        this.newCarId = newCarId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getNewCarModels() {
        return newCarModels;
    }

    public void setNewCarModels(String newCarModels) {
        this.newCarModels = newCarModels;
    }

    public String getNewCarVin() {
        return newCarVin;
    }

    public void setNewCarVin(String newCarVin) {
        this.newCarVin = newCarVin;
    }

    public String getNewCarInvoiceNo() {
        return newCarInvoiceNo;
    }

    public void setNewCarInvoiceNo(String newCarInvoiceNo) {
        this.newCarInvoiceNo = newCarInvoiceNo;
    }

    public String getNewCarOrderNo() {
        return newCarOrderNo;
    }

    public void setNewCarOrderNo(String newCarOrderNo) {
        this.newCarOrderNo = newCarOrderNo;
    }

    public Date getNewCarDeliveryDate() {
        return newCarDeliveryDate;
    }

    public void setNewCarDeliveryDate(Date newCarDeliveryDate) {
        this.newCarDeliveryDate = newCarDeliveryDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getCarSeriesCode() {
        return carSeriesCode;
    }

    public void setCarSeriesCode(String carSeriesCode) {
        this.carSeriesCode = carSeriesCode;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getCarTypeCode() {
        return carTypeCode;
    }

    public void setCarTypeCode(String carTypeCode) {
        this.carTypeCode = carTypeCode;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getOwnerCardNo() {
        return ownerCardNo;
    }

    public void setOwnerCardNo(String ownerCardNo) {
        this.ownerCardNo = ownerCardNo;
    }

    public String getOrderDeliverStatus() {
        return orderDeliverStatus;
    }

    public void setOrderDeliverStatus(String orderDeliverStatus) {
        this.orderDeliverStatus = orderDeliverStatus;
    }

	public String getIsRightOrPoints() {
		return isRightOrPoints;
	}

	public void setIsRightOrPoints(String isRightOrPoints) {
		this.isRightOrPoints = isRightOrPoints;
	}

	public String getRightActivityName() {
		return rightActivityName;
	}

	public void setRightActivityName(String rightActivityName) {
		this.rightActivityName = rightActivityName;
	}

	public Integer getPointsValue() {
		return pointsValue;
	}

	public void setPointsValue(Integer pointsValue) {
		this.pointsValue = pointsValue;
	}
}
