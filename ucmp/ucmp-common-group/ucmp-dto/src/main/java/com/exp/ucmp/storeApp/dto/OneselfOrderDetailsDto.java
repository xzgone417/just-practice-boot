package com.exp.ucmp.storeApp.dto;


import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.exp.ucmp.carDealer.dto.PicDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OneselfOrderDetailsDto", description = "本品订单详情")
public class OneselfOrderDetailsDto {
	
	@ApiModelProperty(value = "预约ID")
	private Long reservationId;
	
	@ApiModelProperty(value = "客户姓名")
	private String customerName;
	
	@ApiModelProperty(value = "客户手机号")
	private String customerIphone;
	
	@ApiModelProperty(value = "密文手机号")
    private String enCustomerIphone;
	
	@ApiModelProperty(value = "业务单号")
	private String businessOrderNo;
	
	@ApiModelProperty(value = "待收购车辆vin码")
	private String vin;
	
	@ApiModelProperty(value = "订单状态")
	private String status;
	
	@ApiModelProperty(value = "订单状态名称")
	private String statusName;
	
	@ApiModelProperty(value = "旧车品牌名称")
	private String brandChineseDescribe;
	
	@ApiModelProperty(value = "旧车车系名称")
	private String carSeriesChineseDescribe;
	
	@ApiModelProperty(value = "旧车年款")
	private String carYearChineseDescribe;
	
	@ApiModelProperty(value = "旧车车型名称")
	private String carTypeChineseDescribe;
	
	@ApiModelProperty(value = "旧车车牌号")
	private String licensePlateNum;
	
	@ApiModelProperty(value = "旧车颜色")
	private String color;
	
	@ApiModelProperty(value = "旧车使用性质")
	private String usingNature;
	
	@ApiModelProperty(value = "旧车过户次数")
	private String transferTimes;
	
	@ApiModelProperty(value = "旧车行驶里程")
	private String drivingMileage;
	
	@ApiModelProperty(value = "上牌时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String licensingDate;
	
	@ApiModelProperty(value = "预计过户时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String estimatedTransferTime;
	
	@ApiModelProperty(value = "驳回（关闭）原因")
	private String reason;
	
	@ApiModelProperty(value = "入库仓储点ID")
	private Long storageId;
	
	@ApiModelProperty(value = "入库仓储点名称")
	private String storageName;
	
	@ApiModelProperty(value = "评估车辆照片")
	private List<OneselfCarPicDto> pic;
	
	@ApiModelProperty(value = "检测报告材料")
    private List<OneselfCarPicDto> testReportList;
	
	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
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

	public String getLicensePlateNum() {
		return licensePlateNum;
	}

	public void setLicensePlateNum(String licensePlateNum) {
		this.licensePlateNum = licensePlateNum;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getUsingNature() {
		return usingNature;
	}

	public void setUsingNature(String usingNature) {
		this.usingNature = usingNature;
	}

	public String getTransferTimes() {
		return transferTimes;
	}

	public void setTransferTimes(String transferTimes) {
		this.transferTimes = transferTimes;
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

	public String getEstimatedTransferTime() {
		return estimatedTransferTime;
	}

	public void setEstimatedTransferTime(String estimatedTransferTime) {
		this.estimatedTransferTime = estimatedTransferTime;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Long getStorageId() {
		return storageId;
	}

	public void setStorageId(Long storageId) {
		this.storageId = storageId;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public List<OneselfCarPicDto> getPic() {
		return pic;
	}

	public void setPic(List<OneselfCarPicDto> pic) {
		this.pic = pic;
	}

	public List<OneselfCarPicDto> getTestReportList() {
		return testReportList;
	}

	public void setTestReportList(List<OneselfCarPicDto> testReportList) {
		this.testReportList = testReportList;
	}
}
