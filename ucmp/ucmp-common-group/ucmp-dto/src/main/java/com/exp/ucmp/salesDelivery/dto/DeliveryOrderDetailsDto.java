package com.exp.ucmp.salesDelivery.dto;


import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DeliveryOrderDetailsDto", description = "销售交付订单详情")
public class DeliveryOrderDetailsDto {
	
	@ApiModelProperty(value = "订单ID")
	private Long orderInfoId;
	
	@ApiModelProperty(value = "客户姓名")
	private String customerName;
	
	@ApiModelProperty(value = "客户手机号")
	private String customerIphone;
	
	@ApiModelProperty(value = "密文手机号")
    private String enCustomerIphone;
	
	@ApiModelProperty(value = "业务单号")
	private String businessOrderNo;
	
	@ApiModelProperty(value = "订单车辆vin码")
	private String vin;
	
	@ApiModelProperty(value = "车型名称")
	private String baseCarTypeName;
	
	@ApiModelProperty(value = "销售价格")
	private Double orderPrice;
	
	@ApiModelProperty(value = "创建时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String createdDate;
	
	@ApiModelProperty(value = "订单状态")
	private String status;
	
	@ApiModelProperty(value = "订单状态名称")
	private String statusName;
	
	@ApiModelProperty(value = "下定时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private String intentionPayTime;
	
	@ApiModelProperty(value = "购车类型")
	private String carOwnerType;
	
	@ApiModelProperty(value = "上牌城市")
	private String licensingCity;
	
	@ApiModelProperty(value = "销售门店ID")
	private Long salesStoreId;
	
	@ApiModelProperty(value = "销售门店名称")
	private String salesStoreName;
	
	@ApiModelProperty(value = "出行顾问ID")
	private Long salesConsultantId;
	
	@ApiModelProperty(value = "出行顾问名称")
	private String salesConsultantName;
	
	@ApiModelProperty(value = "证件类型")
	private String type;
	
	@ApiModelProperty(value = "证件号码")
	private String ownerCardNo;
	
	@ApiModelProperty(value = "订单备注")
	private String orderRemark;
	
	@ApiModelProperty(value = "外饰色")
	private String exteriorColor;
	
	@ApiModelProperty(value = "内饰色")
	private String interiorColor;
	
	@ApiModelProperty(value = "是否可以跟进 1 可以 2 不可以")
	private Integer isFollow;
	
	public Long getOrderInfoId() {
		return orderInfoId;
	}

	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerIphone() {
		return customerIphone;
	}

	public void setCustomerIphone(String customerIphone) {
		this.customerIphone = customerIphone;
	}

	public String getEnCustomerIphone() {
		return enCustomerIphone;
	}

	public void setEnCustomerIphone(String enCustomerIphone) {
		this.enCustomerIphone = enCustomerIphone;
	}

	public String getBusinessOrderNo() {
		return businessOrderNo;
	}

	public void setBusinessOrderNo(String businessOrderNo) {
		this.businessOrderNo = businessOrderNo;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getBaseCarTypeName() {
		return baseCarTypeName;
	}

	public void setBaseCarTypeName(String baseCarTypeName) {
		this.baseCarTypeName = baseCarTypeName;
	}

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getIntentionPayTime() {
		return intentionPayTime;
	}

	public void setIntentionPayTime(String intentionPayTime) {
		this.intentionPayTime = intentionPayTime;
	}

	public String getCarOwnerType() {
		return carOwnerType;
	}

	public void setCarOwnerType(String carOwnerType) {
		this.carOwnerType = carOwnerType;
	}

	public String getLicensingCity() {
		return licensingCity;
	}

	public void setLicensingCity(String licensingCity) {
		this.licensingCity = licensingCity;
	}

	public Long getSalesStoreId() {
		return salesStoreId;
	}

	public void setSalesStoreId(Long salesStoreId) {
		this.salesStoreId = salesStoreId;
	}

	public String getSalesStoreName() {
		return salesStoreName;
	}

	public void setSalesStoreName(String salesStoreName) {
		this.salesStoreName = salesStoreName;
	}

	public Long getSalesConsultantId() {
		return salesConsultantId;
	}

	public void setSalesConsultantId(Long salesConsultantId) {
		this.salesConsultantId = salesConsultantId;
	}

	public String getSalesConsultantName() {
		return salesConsultantName;
	}

	public void setSalesConsultantName(String salesConsultantName) {
		this.salesConsultantName = salesConsultantName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwnerCardNo() {
		return ownerCardNo;
	}

	public void setOwnerCardNo(String ownerCardNo) {
		this.ownerCardNo = ownerCardNo;
	}

	public String getOrderRemark() {
		return orderRemark;
	}

	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}

	public String getExteriorColor() {
		return exteriorColor;
	}

	public void setExteriorColor(String exteriorColor) {
		this.exteriorColor = exteriorColor;
	}

	public String getInteriorColor() {
		return interiorColor;
	}

	public void setInteriorColor(String interiorColor) {
		this.interiorColor = interiorColor;
	}

	public Integer getIsFollow() {
		return isFollow;
	}

	public void setIsFollow(Integer isFollow) {
		this.isFollow = isFollow;
	}

}
