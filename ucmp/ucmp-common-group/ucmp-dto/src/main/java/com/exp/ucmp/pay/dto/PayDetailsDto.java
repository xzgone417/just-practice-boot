package com.exp.ucmp.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RecordDetailsDto", description = "收款详情")
public class PayDetailsDto {
	
	@ApiModelProperty(value = "订单号")
	private String orderNum;
	
	@ApiModelProperty(value = "收款单号")
	private String recordCode;
	
	@ApiModelProperty(value = "收款项目")
	private String paymentItem;
	
	@ApiModelProperty(value = "收款项目名称")
	private String paymentItemName;
	
	@ApiModelProperty(value = "收款状态")
	private String payStatus;
	
	@ApiModelProperty(value = "收款状态名称")
	private String payStatusName;
	
	@ApiModelProperty(value = "收款人")
	private String payee;
	
	@ApiModelProperty(value = "收款登记时间")
	private String createDate;
	
	@ApiModelProperty(value = "收款方式")
	private String paymentMethod;
	
	@ApiModelProperty(value = "收款方式名称")
	private String paymentMethodName;
	
	@ApiModelProperty(value = "收款金额")
	private Double amount;
	
	@ApiModelProperty(value = "付款账号")
	private String paymentAccount;
	
	@ApiModelProperty(value = "客户姓名")
	private String customerName;
	
	@ApiModelProperty(value = "付款流水号")
	private String serialNumber;
	
	@ApiModelProperty(value = "匹配记录id")
	private Long matchingId;
	
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}

	public String getPaymentItem() {
		return paymentItem;
	}

	public void setPaymentItem(String paymentItem) {
		this.paymentItem = paymentItem;
	}

	public String getPaymentItemName() {
		return paymentItemName;
	}

	public void setPaymentItemName(String paymentItemName) {
		this.paymentItemName = paymentItemName;
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

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getPaymentAccount() {
		return paymentAccount;
	}

	public void setPaymentAccount(String paymentAccount) {
		this.paymentAccount = paymentAccount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Long getMatchingId() {
		return matchingId;
	}

	public void setMatchingId(Long matchingId) {
		this.matchingId = matchingId;
	}

	
}
