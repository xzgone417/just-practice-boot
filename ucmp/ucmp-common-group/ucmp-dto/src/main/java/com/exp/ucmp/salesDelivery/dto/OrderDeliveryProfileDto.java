package com.exp.ucmp.salesDelivery.dto;


import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderDeliveryProfileDto", description = "订单交付确认信息详情")
public class OrderDeliveryProfileDto {
	
	@ApiModelProperty(value = "订单id 必传")
	private Long orderInfoId;
	
	@ApiModelProperty(value = "更新人ID 不用传")
	private Long updateBy;
	
	@ApiModelProperty(value = "登记证图片")
	private List<DeliveryOrderPicDto> registrationCertificateList;
	
	@ApiModelProperty(value = "行驶证图片")
	private List<DeliveryOrderPicDto> drivingLicenseList;
	
	@ApiModelProperty(value = "交付确认书")
	private List<DeliveryOrderPicDto> deliveryConfirmationList;
	
	@ApiModelProperty(value = "二手车交易发票")
	private List<DeliveryOrderPicDto> deliveryInvoiceList;
	
	@ApiModelProperty(value = "增值税发票（邮件申请开票）")
	private List<DeliveryOrderPicDto> vatInvoiceList;
	
    @ApiModelProperty(value = "主用车人姓名")
    private String mainUserName;
    
    @ApiModelProperty(value = "主用车人电话")
    private String mainUserPhone;
    
    @ApiModelProperty(value = "主用车人证件号")
    private String mainCardNo;
	
	@ApiModelProperty(value = "操作类型 1 提交 2 保存 必传")
    private Integer operationType;
	
	public Long getOrderInfoId() {
		return orderInfoId;
	}

	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public List<DeliveryOrderPicDto> getRegistrationCertificateList() {
		return registrationCertificateList;
	}

	public void setRegistrationCertificateList(List<DeliveryOrderPicDto> registrationCertificateList) {
		this.registrationCertificateList = registrationCertificateList;
	}

	public List<DeliveryOrderPicDto> getDrivingLicenseList() {
		return drivingLicenseList;
	}

	public void setDrivingLicenseList(List<DeliveryOrderPicDto> drivingLicenseList) {
		this.drivingLicenseList = drivingLicenseList;
	}

	public List<DeliveryOrderPicDto> getDeliveryConfirmationList() {
		return deliveryConfirmationList;
	}

	public void setDeliveryConfirmationList(List<DeliveryOrderPicDto> deliveryConfirmationList) {
		this.deliveryConfirmationList = deliveryConfirmationList;
	}

	public List<DeliveryOrderPicDto> getDeliveryInvoiceList() {
		return deliveryInvoiceList;
	}

	public void setDeliveryInvoiceList(List<DeliveryOrderPicDto> deliveryInvoiceList) {
		this.deliveryInvoiceList = deliveryInvoiceList;
	}

	public List<DeliveryOrderPicDto> getVatInvoiceList() {
		return vatInvoiceList;
	}

	public void setVatInvoiceList(List<DeliveryOrderPicDto> vatInvoiceList) {
		this.vatInvoiceList = vatInvoiceList;
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

	public String getMainCardNo() {
		return mainCardNo;
	}

	public void setMainCardNo(String mainCardNo) {
		this.mainCardNo = mainCardNo;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}
	
}
