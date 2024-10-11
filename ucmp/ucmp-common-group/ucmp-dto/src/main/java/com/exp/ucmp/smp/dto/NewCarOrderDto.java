package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "NewCarOrderDto", description = "新车订单信息")
public class NewCarOrderDto {

	@ApiModelProperty(value = "订单号")
	private String orderNum;
	
	@ApiModelProperty(value = "订单状态")
    private String status;
	
	@ApiModelProperty(value = "订单状态描述")
    private String statusDesc;
	
	@ApiModelProperty(value = "主用车人")
    private String mainUserName;
	
	@ApiModelProperty(value = "主用车人电话号码")
    private String mainUserPhone;
	
	@ApiModelProperty(value = "VIN码")
    private String vin;
	
	@ApiModelProperty(value = "工程车型编码")
    private String carSeriesCode;
    
    @ApiModelProperty(value = "工程车型名称")
    private String carSeries;
    
    @ApiModelProperty(value = "基础车型编码")
    private String carTypeCode;
    
    @ApiModelProperty(value = "基础车型名称")
    private String carType;
    
    @ApiModelProperty(value = "外色编码")
    private String carColorCode;
    
    @ApiModelProperty(value = "外色名称")
    private String carColor;
    
    @ApiModelProperty(value = "收款时间")
    private String paymentTime;
    
    @ApiModelProperty(value = "金额")
    private String amount;
    
    @ApiModelProperty(value = "付款方式")
    private String paymentMethod;
    
    @ApiModelProperty(value = "用户的superId")
    private String superId;
    
    @ApiModelProperty(value = "urm 用户id")
    private String uid;
    
    @ApiModelProperty(value = "客户姓名")
    private String name;
    
    @ApiModelProperty(value = "车辆所有人名称")
    private String ownerName;
    
    @ApiModelProperty(value = "车辆所有人电话")
    private String ownerPhone;
    
    @ApiModelProperty(value = "车辆所有人证件号")
    private String ownerCardNo;
    
    @ApiModelProperty(value = "客户手机号")
    private String mobile;
    
    @ApiModelProperty(value = "发票号")
    private String invoiceNo;
    
    @ApiModelProperty(value = "交付时间")
    private String deliveryDate;
    
    @ApiModelProperty(value = "订单交付状态")
    private String orderStatus;
    
    @ApiModelProperty(value = "订单交付状态描述")
    private String orderStatusDesc;

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
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

	public String getCarColorCode() {
		return carColorCode;
	}

	public void setCarColorCode(String carColorCode) {
		this.carColorCode = carColorCode;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getSuperId() {
		return superId;
	}

	public void setSuperId(String superId) {
		this.superId = superId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getOwnerCardNo() {
		return ownerCardNo;
	}

	public void setOwnerCardNo(String ownerCardNo) {
		this.ownerCardNo = ownerCardNo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatusDesc() {
		return orderStatusDesc;
	}

	public void setOrderStatusDesc(String orderStatusDesc) {
		this.orderStatusDesc = orderStatusDesc;
	}
}
