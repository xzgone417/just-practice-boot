package com.exp.ucmp.storeApp.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OneselfAcquisitionDto", description = "本品收购列表数据")
public class OneselfAcquisitionDto {
	
	@ApiModelProperty(value = "业务单号")
	private String businessOrderNo;
	
	@ApiModelProperty(value = "待收购车辆vin码")
	private String vin;
	
	@ApiModelProperty(value = "客户手机号")
	private String customerIphone;
	
	@ApiModelProperty(value = "客户姓名")
	private String customerName;
	
	@ApiModelProperty(value = "订单状态")
	private String status;
	
	@ApiModelProperty(value = "订单状态名称")
	private String statusName;

	@ApiModelProperty(value = "预约id")
	private Long reservationId;
	
	@ApiModelProperty(value = "询价id")
	private Long inquiryId;
	
	@ApiModelProperty(value = "密文手机号")
    private String enCustomerIphone;

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

	public String getCustomerIphone() {
		return customerIphone;
	}

	public void setCustomerIphone(String customerIphone) {
		this.customerIphone = customerIphone;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Long getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(Long inquiryId) {
		this.inquiryId = inquiryId;
	}

	public String getEnCustomerIphone() {
		return enCustomerIphone;
	}

	public void setEnCustomerIphone(String enCustomerIphone) {
		this.enCustomerIphone = enCustomerIphone;
	}
	
}
