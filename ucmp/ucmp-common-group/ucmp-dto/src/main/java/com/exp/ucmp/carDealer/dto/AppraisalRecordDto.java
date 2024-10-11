package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AppraisalRecordDto", description = "估价记录")
public class AppraisalRecordDto extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6608935284280456633L;

	@ApiModelProperty(value = "车商人员Id")
	private Long appraisalStaffId;

	@ApiModelProperty(value = "估价记录Id")
	private Long appraisalId;
	
	@ApiModelProperty(value = "估价记录Id")
	private Long reservationId;
	
	@ApiModelProperty(value = "旧车品牌")
	private String brandChineseDescribe;
	
	@ApiModelProperty(value = "旧车车系")
	private String carSeriesChineseDescribe;
	
	@ApiModelProperty(value = "旧车年款")
	private String carYearChineseDescribe;
	
	@ApiModelProperty(value = "旧车车型")
	private String carTypeChineseDescribe;
	
	@ApiModelProperty(value = "旧车颜色")
	private String color;
	
	@ApiModelProperty(value = "旧车里程")
	private String drivingMileage;
	
	@ApiModelProperty(value = "旧车上牌时间")
	private String licensingDate;
	
	@ApiModelProperty(value = "旧车车牌号")
	private String licensePlateNum;
	
	@ApiModelProperty(value = "旧车vin码")
	private String vinCode;
	
	@ApiModelProperty(value = "旧车过户次数")
	private String transferTimes;
	
	@ApiModelProperty(value = "旧车使用性质")
	private String usingNature;
	
	@ApiModelProperty(value = "客户期望价格")
	private String customerExpectPrice;
	
	@ApiModelProperty(value = "预约检测地点")
	private String reservationDetectionAddress;
	
	@ApiModelProperty(value = "预约检测时间")
	private String reservationDetectionDate;
	
	@ApiModelProperty(value = "制单人Id")
	private String makeOrderPersonId;
	
	@ApiModelProperty(value = "制单人姓名")
	private String makeOrderPersonName;
	
	@ApiModelProperty(value = "加密制单人手机号")
	private String enMakeOrderPersonIphone;
	
	@ApiModelProperty(value = "制单人手机号")
	private String makeOrderPersonIphone;
	
	@ApiModelProperty(value = "制单人角色")
	private String makeOrderPersonRole;
	
	@ApiModelProperty(value = "估价时间")
	private String appraisalDate;
	
	@ApiModelProperty(value = "我的估价")
	private String appraisalPrice;
	
	@ApiModelProperty(value = "客户姓名")
	private String customerName;
	
	@ApiModelProperty(value = "客户手机")
	private String customerIphone;
	
	@ApiModelProperty(value = "加密客户手机")
	private String enCustomerIphone;
	
	@ApiModelProperty(value = "线索来源")
	private String cluesSource;
	
	@ApiModelProperty(value = "派单门店名称")
	private String storeName;

	public Long getAppraisalStaffId() {
		return appraisalStaffId;
	}

	public void setAppraisalStaffId(Long appraisalStaffId) {
		this.appraisalStaffId = appraisalStaffId;
	}

	public Long getAppraisalId() {
		return appraisalId;
	}

	public void setAppraisalId(Long appraisalId) {
		this.appraisalId = appraisalId;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public String getBrandChineseDescribe() {
		return brandChineseDescribe;
	}

	public void setBrandChineseDescribe(String brandChineseDescribe) {
		this.brandChineseDescribe = brandChineseDescribe;
	}

	public String getCarSeriesChineseDescribe() {
		return carSeriesChineseDescribe;
	}

	public void setCarSeriesChineseDescribe(String carSeriesChineseDescribe) {
		this.carSeriesChineseDescribe = carSeriesChineseDescribe;
	}

	public String getCarYearChineseDescribe() {
		return carYearChineseDescribe;
	}

	public void setCarYearChineseDescribe(String carYearChineseDescribe) {
		this.carYearChineseDescribe = carYearChineseDescribe;
	}

	public String getCarTypeChineseDescribe() {
		return carTypeChineseDescribe;
	}

	public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
		this.carTypeChineseDescribe = carTypeChineseDescribe;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDrivingMileage() {
		return drivingMileage;
	}

	public void setDrivingMileage(String drivingMileage) {
		this.drivingMileage = drivingMileage;
	}

	public String getLicensingDate() {
		return licensingDate;
	}

	public void setLicensingDate(String licensingDate) {
		this.licensingDate = licensingDate;
	}

	public String getLicensePlateNum() {
		return licensePlateNum;
	}

	public void setLicensePlateNum(String licensePlateNum) {
		this.licensePlateNum = licensePlateNum;
	}

	public String getVinCode() {
		return vinCode;
	}

	public void setVinCode(String vinCode) {
		this.vinCode = vinCode;
	}

	public String getTransferTimes() {
		return transferTimes;
	}

	public void setTransferTimes(String transferTimes) {
		this.transferTimes = transferTimes;
	}

	public String getUsingNature() {
		return usingNature;
	}

	public void setUsingNature(String usingNature) {
		this.usingNature = usingNature;
	}

	public String getCustomerExpectPrice() {
		return customerExpectPrice;
	}

	public void setCustomerExpectPrice(String customerExpectPrice) {
		this.customerExpectPrice = customerExpectPrice;
	}

	public String getReservationDetectionAddress() {
		return reservationDetectionAddress;
	}

	public void setReservationDetectionAddress(String reservationDetectionAddress) {
		this.reservationDetectionAddress = reservationDetectionAddress;
	}

	public String getReservationDetectionDate() {
		return reservationDetectionDate;
	}

	public void setReservationDetectionDate(String reservationDetectionDate) {
		this.reservationDetectionDate = reservationDetectionDate;
	}

	public String getMakeOrderPersonId() {
		return makeOrderPersonId;
	}

	public void setMakeOrderPersonId(String makeOrderPersonId) {
		this.makeOrderPersonId = makeOrderPersonId;
	}

	public String getMakeOrderPersonName() {
		return makeOrderPersonName;
	}

	public void setMakeOrderPersonName(String makeOrderPersonName) {
		this.makeOrderPersonName = makeOrderPersonName;
	}

	public String getEnMakeOrderPersonIphone() {
		return enMakeOrderPersonIphone;
	}

	public void setEnMakeOrderPersonIphone(String enMakeOrderPersonIphone) {
		this.enMakeOrderPersonIphone = enMakeOrderPersonIphone;
	}

	public String getMakeOrderPersonIphone() {
		return makeOrderPersonIphone;
	}

	public void setMakeOrderPersonIphone(String makeOrderPersonIphone) {
		this.makeOrderPersonIphone = makeOrderPersonIphone;
	}

	public String getMakeOrderPersonRole() {
		return makeOrderPersonRole;
	}

	public void setMakeOrderPersonRole(String makeOrderPersonRole) {
		this.makeOrderPersonRole = makeOrderPersonRole;
	}

	public String getAppraisalDate() {
		return appraisalDate;
	}

	public void setAppraisalDate(String appraisalDate) {
		this.appraisalDate = appraisalDate;
	}

	public String getAppraisalPrice() {
		return appraisalPrice;
	}

	public void setAppraisalPrice(String appraisalPrice) {
		this.appraisalPrice = appraisalPrice;
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

	public String getCluesSource() {
		return cluesSource;
	}

	public void setCluesSource(String cluesSource) {
		this.cluesSource = cluesSource;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
}

