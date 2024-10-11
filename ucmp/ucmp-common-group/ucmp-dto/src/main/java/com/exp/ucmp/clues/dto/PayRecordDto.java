package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PayRecordDto", description = "收款记录")
public class PayRecordDto {
	
	@ApiModelProperty(value = "收款单号")
	private String recordCode;
	
	@ApiModelProperty(value = "收款状态 tag=28")
	private String payStatus;
	
	@ApiModelProperty(value = "收款状态名称")
	private String payStatusName;
	
	@ApiModelProperty(value = "收款项目 tag=67")
	private String paymentItem;
	
	@ApiModelProperty(value = "收款项目名称")
	private String paymentItemName;
	
	@ApiModelProperty(value = "收款方式 tag=25")
	private String paymentMethod;
	
	@ApiModelProperty(value = "收款方式名称")
	private String paymentMethodName;
	
	@ApiModelProperty(value = "收款人")
	private String payee;
	
	@ApiModelProperty(value = "收款金额")
	private Double amount;
	
	@ApiModelProperty(value = "收款登记时间")
	private String createDate;
	
	@ApiModelProperty(value = "商户号")
	private String merchantnumber;
	
	@ApiModelProperty(value = "流水号")
	private String zbiiln;
	
	@ApiModelProperty(value = "到账方式")
	private String receiptMethod;
	
	@ApiModelProperty(value = "付款账号")
	private String zdbankn;
	
	@ApiModelProperty(value = "账号名称")
	private String zdname;
	
	@ApiModelProperty(value = "到账金额")
	private Double receiptAmount;

	@ApiModelProperty(value = "到账时间")
	private String receiptDate;

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
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

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getMerchantnumber() {
		return merchantnumber;
	}

	public void setMerchantnumber(String merchantnumber) {
		this.merchantnumber = merchantnumber;
	}

	public String getZbiiln() {
		return zbiiln;
	}

	public void setZbiiln(String zbiiln) {
		this.zbiiln = zbiiln;
	}

	public String getReceiptMethod() {
		return receiptMethod;
	}

	public void setReceiptMethod(String receiptMethod) {
		this.receiptMethod = receiptMethod;
	}

	public String getZdbankn() {
		return zdbankn;
	}

	public void setZdbankn(String zdbankn) {
		this.zdbankn = zdbankn;
	}

	public String getZdname() {
		return zdname;
	}

	public void setZdname(String zdname) {
		this.zdname = zdname;
	}

	public Double getReceiptAmount() {
		return receiptAmount;
	}

	public void setReceiptAmount(Double receiptAmount) {
		this.receiptAmount = receiptAmount;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}
}
