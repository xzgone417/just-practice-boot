package com.exp.ucmp.salesDelivery.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderPaymentRecordDto", description = "付款记录信息")
public class OrderPaymentRecordDto {
	
	@ApiModelProperty(value = "付款记录ID")
	private Long recordId;
	
	@ApiModelProperty(value = "付款记录Code")
	private String recordCode;
	
	@ApiModelProperty(value = "订单id")
	private Long orderInfoId;
	
	@ApiModelProperty(value = "付款项目")
	private String paymentItem;
	
	@ApiModelProperty(value = "付款金额")
	private Double paymentAmount;
	
	@ApiModelProperty(value = "流水号")
	private String serialNumber;
	
	@ApiModelProperty(value = "收款人")
	private String proceedsBy;
	
	@ApiModelProperty(value = "收款方式")
	private String paymentMethod;
	
	@ApiModelProperty(value = "收款方式名称")
	private String paymentMethodName;
	
	@ApiModelProperty(value = "创建时间")
	private String createDate;
	
	@ApiModelProperty(value = "付款账户")
    private String paymentAccount;
	
	@ApiModelProperty(value = "付款账户名称")
    private String accountName;
	
	@ApiModelProperty(value = "收款状态")
	private String payStatus;
	
	@ApiModelProperty(value = "收款状态名称")
	private String payStatusName;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}

	public Long getOrderInfoId() {
		return orderInfoId;
	}

	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}

	public String getPaymentItem() {
		return paymentItem;
	}

	public void setPaymentItem(String paymentItem) {
		this.paymentItem = paymentItem;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getProceedsBy() {
		return proceedsBy;
	}

	public void setProceedsBy(String proceedsBy) {
		this.proceedsBy = proceedsBy;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPaymentMethodName() {
		return paymentMethodName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getPaymentAccount() {
		return paymentAccount;
	}

	public void setPaymentAccount(String paymentAccount) {
		this.paymentAccount = paymentAccount;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getPayStatusName() {
		return payStatusName;
	}

	public void setPayStatusName(String payStatusName) {
		this.payStatusName = payStatusName;
	}
}
