package com.exp.ucmp.carDealer.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InquiryQueryResultDto", description = "询价查询记录结果对象")
public class InquiryQueryResultDto extends BaseModel {

	private static final long serialVersionUID = 6812270748133420213L;
	/**
     * 询价ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "询价ID")
    private Long inquiryId;
    
    /**
     * 预约ID
     */
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    /**
     * 制单人ID(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人ID(指的是预约表里面的顾问或者经理、店长)")
    private Long makeOrderPersonId;
    
    /**
     * 制单人姓名(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人姓名(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonName;
    
    /**
     * 制单人联系电话(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人联系电话(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonIphone;

    /**
     * 密文制单人联系电话
     */
    @ApiModelProperty(value = "密文制单人联系电话")
    private String enMakeOrderPersonIphone;

	/**
	 * 制单人角色(指的是预约表里面的顾问或者经理、店长)
	 */
	@ApiModelProperty(value = "制单人角色(指的是预约表里面的顾问或者经理、店长)")
	private String makeOrderPersonRole;
    
    /**
     * 接单截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "接单截止时间")
    private Date orderReceivingDeadline;
    
    /**
     * 询价单状态：01、待接单，02、已接单，09、放弃接单，11、待报价，12、已报价，18、逾期未报价，19、放弃报价
     */
    @ApiModelProperty(value = "询价单状态：01、待接单，02、已接单，09、放弃接单，11、待报价，12、已报价，18、逾期未报价，19、放弃报价")
    private String inquiryStatus;
    
    /**
     * 品牌中文描述
     */
    @ApiModelProperty(value = "品牌中文描述")
    private String brandChineseDescribe;
    
    /**
     * 车系中文描述
     */
    @ApiModelProperty(value = "车系中文描述")
    private String carSeriesChineseDescribe;
    
    /**
     * 车型中文描述
     */
    @ApiModelProperty(value = "车型中文描述")
    private String carTypeChineseDescribe;
    
    /**
     * 上牌时间
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "上牌时间")
    private Date licensingDate;
    
    /**
     * 行驶里程
     */
    @ApiModelProperty(value = "行驶里程")
    private Long drivingMileage;
    
    /**
     * 预约检测时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预约检测时间")
    private Date reservationDetectionDate;
    
    /**
     * 预约检测地点
     */
    @ApiModelProperty(value = "预约检测地点")
    private String reservationDetectionAddress;
    
    /**
     * 客户期望价格
     */
    @ApiModelProperty(value = "客户期望价格")
    private Long customerExpectPrice;

	/**
	 * 放弃接单原因
	 */
	@ApiModelProperty(value = "放弃接单原因")
	private String orderAbandonedReason;

	/**
	 * 姓名
	 */
	@ApiModelProperty(value = "姓名")
	private String  customerName;

	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
	private String customerIphone;

	/**
	 * 密文手机号
	 */
	@ApiModelProperty(value = "密文手机号")
	private String enCustomerIphone;

	/**
	 * 预约单号
	 */
	@ApiModelProperty(value = "预约单号")
	private String businessOrderNo;
	
	@ApiModelProperty(value = "派单门店名称")
	private String storeName;
	
	@ApiModelProperty(value = "是否联系过门店人员")
    private Boolean isCallStore;
	
	public InquiryQueryResultDto() {
	}

	public InquiryQueryResultDto(Long inquiryId, Long reservationId, Long makeOrderPersonId, String makeOrderPersonName,
			String makeOrderPersonIphone, String enMakeOrderPersonIphone, String makeOrderPersonRole,
			Date orderReceivingDeadline, String inquiryStatus, String brandChineseDescribe,
			String carSeriesChineseDescribe, String carTypeChineseDescribe, Date licensingDate, Long drivingMileage,
			Date reservationDetectionDate, String reservationDetectionAddress, Long customerExpectPrice,
			String orderAbandonedReason, String customerName, String customerIphone, String enCustomerIphone,
			String businessOrderNo, Long allotPersonId, String allotPerson, String allotPersonIphone,
			String enAllotPersonIphone) {
		super();
		this.inquiryId = inquiryId;
		this.reservationId = reservationId;
		this.makeOrderPersonId = makeOrderPersonId;
		this.makeOrderPersonName = makeOrderPersonName;
		this.makeOrderPersonIphone = makeOrderPersonIphone;
		this.enMakeOrderPersonIphone = enMakeOrderPersonIphone;
		this.makeOrderPersonRole = makeOrderPersonRole;
		this.orderReceivingDeadline = orderReceivingDeadline;
		this.inquiryStatus = inquiryStatus;
		this.brandChineseDescribe = brandChineseDescribe;
		this.carSeriesChineseDescribe = carSeriesChineseDescribe;
		this.carTypeChineseDescribe = carTypeChineseDescribe;
		this.licensingDate = licensingDate;
		this.drivingMileage = drivingMileage;
		this.reservationDetectionDate = reservationDetectionDate;
		this.reservationDetectionAddress = reservationDetectionAddress;
		this.customerExpectPrice = customerExpectPrice;
		this.orderAbandonedReason = orderAbandonedReason;
		this.customerName = customerName;
		this.customerIphone = customerIphone;
		this.enCustomerIphone = enCustomerIphone;
	}


	/**
	 * 获取
	 * @return inquiryId
	 */
	public Long getInquiryId() {
		return inquiryId;
	}

	/**
	 * 设置
	 * @param inquiryId
	 */
	public void setInquiryId(Long inquiryId) {
		this.inquiryId = inquiryId;
	}

	/**
	 * 获取
	 * @return reservationId
	 */
	public Long getReservationId() {
		return reservationId;
	}

	/**
	 * 设置
	 * @param reservationId
	 */
	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * 获取
	 * @return makeOrderPersonId
	 */
	public Long getMakeOrderPersonId() {
		return makeOrderPersonId;
	}

	/**
	 * 设置
	 * @param makeOrderPersonId
	 */
	public void setMakeOrderPersonId(Long makeOrderPersonId) {
		this.makeOrderPersonId = makeOrderPersonId;
	}

	/**
	 * 获取
	 * @return makeOrderPersonName
	 */
	public String getMakeOrderPersonName() {
		return makeOrderPersonName;
	}

	/**
	 * 设置
	 * @param makeOrderPersonName
	 */
	public void setMakeOrderPersonName(String makeOrderPersonName) {
		this.makeOrderPersonName = makeOrderPersonName;
	}

	/**
	 * 获取
	 * @return makeOrderPersonIphone
	 */
	public String getMakeOrderPersonIphone() {
		return makeOrderPersonIphone;
	}

	/**
	 * 设置
	 * @param makeOrderPersonIphone
	 */
	public void setMakeOrderPersonIphone(String makeOrderPersonIphone) {
		this.makeOrderPersonIphone = makeOrderPersonIphone;
	}

	/**
	 * 获取
	 * @return makeOrderPersonRole
	 */
	public String getMakeOrderPersonRole() {
		return makeOrderPersonRole;
	}

	/**
	 * 设置
	 * @param makeOrderPersonRole
	 */
	public void setMakeOrderPersonRole(String makeOrderPersonRole) {
		this.makeOrderPersonRole = makeOrderPersonRole;
	}

	/**
	 * 获取
	 * @return orderReceivingDeadline
	 */
	public Date getOrderReceivingDeadline() {
		return orderReceivingDeadline;
	}

	/**
	 * 设置
	 * @param orderReceivingDeadline
	 */
	public void setOrderReceivingDeadline(Date orderReceivingDeadline) {
		this.orderReceivingDeadline = orderReceivingDeadline;
	}

	/**
	 * 获取
	 * @return inquiryStatus
	 */
	public String getInquiryStatus() {
		return inquiryStatus;
	}

	/**
	 * 设置
	 * @param inquiryStatus
	 */
	public void setInquiryStatus(String inquiryStatus) {
		this.inquiryStatus = inquiryStatus;
	}

	/**
	 * 获取
	 * @return brandChineseDescribe
	 */
	public String getBrandChineseDescribe() {
		return brandChineseDescribe;
	}

	/**
	 * 设置
	 * @param brandChineseDescribe
	 */
	public void setBrandChineseDescribe(String brandChineseDescribe) {
		this.brandChineseDescribe = brandChineseDescribe;
	}

	/**
	 * 获取
	 * @return carSeriesChineseDescribe
	 */
	public String getCarSeriesChineseDescribe() {
		return carSeriesChineseDescribe;
	}

	/**
	 * 设置
	 * @param carSeriesChineseDescribe
	 */
	public void setCarSeriesChineseDescribe(String carSeriesChineseDescribe) {
		this.carSeriesChineseDescribe = carSeriesChineseDescribe;
	}

	/**
	 * 获取
	 * @return carTypeChineseDescribe
	 */
	public String getCarTypeChineseDescribe() {
		return carTypeChineseDescribe;
	}

	/**
	 * 设置
	 * @param carTypeChineseDescribe
	 */
	public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
		this.carTypeChineseDescribe = carTypeChineseDescribe;
	}

	/**
	 * 获取
	 * @return licensingDate
	 */
	public Date getLicensingDate() {
		return licensingDate;
	}

	/**
	 * 设置
	 * @param licensingDate
	 */
	public void setLicensingDate(Date licensingDate) {
		this.licensingDate = licensingDate;
	}

	/**
	 * 获取
	 * @return drivingMileage
	 */
	public Long getDrivingMileage() {
		return drivingMileage;
	}

	/**
	 * 设置
	 * @param drivingMileage
	 */
	public void setDrivingMileage(Long drivingMileage) {
		this.drivingMileage = drivingMileage;
	}

	/**
	 * 获取
	 * @return reservationDetectionDate
	 */
	public Date getReservationDetectionDate() {
		return reservationDetectionDate;
	}

	/**
	 * 设置
	 * @param reservationDetectionDate
	 */
	public void setReservationDetectionDate(Date reservationDetectionDate) {
		this.reservationDetectionDate = reservationDetectionDate;
	}

	/**
	 * 获取
	 * @return reservationDetectionAddress
	 */
	public String getReservationDetectionAddress() {
		return reservationDetectionAddress;
	}

	/**
	 * 设置
	 * @param reservationDetectionAddress
	 */
	public void setReservationDetectionAddress(String reservationDetectionAddress) {
		this.reservationDetectionAddress = reservationDetectionAddress;
	}

	/**
	 * 获取
	 * @return customerExpectPrice
	 */
	public Long getCustomerExpectPrice() {
		return customerExpectPrice;
	}

	/**
	 * 设置
	 * @param customerExpectPrice
	 */
	public void setCustomerExpectPrice(Long customerExpectPrice) {
		this.customerExpectPrice = customerExpectPrice;
	}

	/**
	 * 获取
	 * @return orderAbandonedReason
	 */
	public String getOrderAbandonedReason() {
		return orderAbandonedReason;
	}

	/**
	 * 设置
	 * @param orderAbandonedReason
	 */
	public void setOrderAbandonedReason(String orderAbandonedReason) {
		this.orderAbandonedReason = orderAbandonedReason;
	}

	/**
	 * 获取
	 * @return customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * 设置
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * 获取
	 * @return customerIphone
	 */
	public String getCustomerIphone() {
		return customerIphone;
	}

	/**
	 * 设置
	 * @param customerIphone
	 */
	public void setCustomerIphone(String customerIphone) {
		this.customerIphone = customerIphone;
	}

	/**
	 * 获取
	 * @return enCustomerIphone
	 */
	public String getEnCustomerIphone() {
		return enCustomerIphone;
	}

	/**
	 * 设置
	 * @param enCustomerIphone
	 */
	public void setEnCustomerIphone(String enCustomerIphone) {
		this.enCustomerIphone = enCustomerIphone;
	}

	/**
	 * 获取
	 * @return businessOrderNo
	 */
	public String getBusinessOrderNo() {
		return businessOrderNo;
	}

	/**
	 * 设置
	 * @param businessOrderNo
	 */
	public void setBusinessOrderNo(String businessOrderNo) {
		this.businessOrderNo = businessOrderNo;
	}

	/**
	 * 获取
	 * @return enMakeOrderPersonIphone
	 */
	public String getEnMakeOrderPersonIphone() {
		return enMakeOrderPersonIphone;
	}

	/**
	 * 设置
	 * @param enMakeOrderPersonIphone
	 */
	public void setEnMakeOrderPersonIphone(String enMakeOrderPersonIphone) {
		this.enMakeOrderPersonIphone = enMakeOrderPersonIphone;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Boolean getIsCallStore() {
		return isCallStore;
	}

	public void setIsCallStore(Boolean isCallStore) {
		this.isCallStore = isCallStore;
	}

	@Override
	public String toString() {
		return "InquiryQueryResultDto [inquiryId=" + inquiryId + ", reservationId=" + reservationId
				+ ", makeOrderPersonId=" + makeOrderPersonId + ", makeOrderPersonName=" + makeOrderPersonName
				+ ", makeOrderPersonIphone=" + makeOrderPersonIphone + ", enMakeOrderPersonIphone="
				+ enMakeOrderPersonIphone + ", makeOrderPersonRole=" + makeOrderPersonRole + ", orderReceivingDeadline="
				+ orderReceivingDeadline + ", inquiryStatus=" + inquiryStatus + ", brandChineseDescribe="
				+ brandChineseDescribe + ", carSeriesChineseDescribe=" + carSeriesChineseDescribe
				+ ", carTypeChineseDescribe=" + carTypeChineseDescribe + ", licensingDate=" + licensingDate
				+ ", drivingMileage=" + drivingMileage + ", reservationDetectionDate=" + reservationDetectionDate
				+ ", reservationDetectionAddress=" + reservationDetectionAddress + ", customerExpectPrice="
				+ customerExpectPrice + ", orderAbandonedReason=" + orderAbandonedReason + ", customerName="
				+ customerName + ", customerIphone=" + customerIphone + ", enCustomerIphone=" + enCustomerIphone
				+ ", businessOrderNo=" + businessOrderNo + "]";
	}

}
