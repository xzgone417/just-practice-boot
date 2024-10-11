package com.exp.ucmp.pay.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QueryOrderInfoDto", description = "查询订单信息返回类")
public class QueryOrderInfoDto {
	
	@ApiModelProperty(value = "订单号")
	@ExcelProperty(value = "订单号", index = 0)
	private String orderNum;
	
	@ApiModelProperty(value = "交付中心名称")
	@ExcelProperty(value = "交付中心名称", index = 1)
	private String deliveryStoreName;
	
	@ApiModelProperty(value = "收款单号")
	@ExcelProperty(value = "收款单号", index = 2)
	private String recordCode;
	
	@ApiModelProperty(value = "收款项目 tag=67")
	@ExcelIgnore
	private String paymentItem;
	
	@ApiModelProperty(value = "收款项目名称")
	@ExcelProperty(value = "收款项目", index = 3)
	private String paymentItemName;
	
	@ApiModelProperty(value = "收款状态 tag=28")
	@ExcelIgnore
	private String payStatus;
	
	@ApiModelProperty(value = "收款状态名称")
	@ExcelProperty(value = "收款状态", index = 4)
	private String payStatusName;
	
	@ApiModelProperty(value = "财务审批操作，01 匹配 02 确认 03 解绑")
	@ExcelIgnore
	private String approvalOperation;
	
	@ApiModelProperty(value = "收款人")
	@ExcelProperty(value = "收款人", index = 5)
	private String payee;
	
	@ApiModelProperty(value = "收款登记时间")
	@ExcelProperty(value = "收款登记时间", index = 6)
	private String createDate;
	
	@ApiModelProperty(value = "收款方式 tag=25")
	@ExcelIgnore
	private String paymentMethod;
	
	@ApiModelProperty(value = "收款方式名称")
	@ExcelProperty(value = "收款方式", index = 7)
	private String paymentMethodName;
	
	@ApiModelProperty(value = "收款金额")
	@ExcelProperty(value = "收款金额", index = 8)
	private Double amount;
	
	@ApiModelProperty(value = "流水号")
	@ExcelProperty(value = "流水号", index = 9)
	private String zbiiln;
	
	@ApiModelProperty(value = "账号名称")
	@ExcelProperty(value = "账号名称", index = 10)
	private String zdname;
	
	@ApiModelProperty(value = "付款账号")
	@ExcelProperty(value = "付款账号", index = 11)
	private String zdbankn;

	@ApiModelProperty(value = "到账方式")
	@ExcelProperty(value = "到账方式", index = 12)
	private String receiptMethod;

	@ApiModelProperty(value = "到账时间")
	@ExcelProperty(value = "到账时间", index = 13)
	private String receiptDate;
	
	@ApiModelProperty(value = "审核时间")
	@ExcelProperty(value = "审核时间(匹配)", index = 14)
	private String approvalDate;
	
	@ApiModelProperty(value = "订单金额")
	@ExcelProperty(value = "订单金额", index = 15)
	private Double orderAmount;
	
	@ApiModelProperty(value = "应收金额")
	@ExcelProperty(value = "应收金额", index = 16)
	private Double receivableAmount;
	
	@ApiModelProperty(value = "已收金额")
	@ExcelProperty(value = "已收金额", index = 17)
	private Double receivedAmount;
	
	@ApiModelProperty(value = "VIN")
	@ExcelProperty(value = "VIN", index = 18)
	private String vin;
	
	@ApiModelProperty(value = "交付顾问")
	@ExcelProperty(value = "交付顾问", index = 19)
	private String deliveryPersonName;
	
	@ApiModelProperty(value = "客户姓名")
	@ExcelProperty(value = "客户姓名", index = 20)
	private String customerName;
	
	@ApiModelProperty(value = "客户联系电话")
	@ExcelProperty(value = "联系电话", index = 21)
	private String customerPhone;
	
	@ApiModelProperty(value = "订单状态")
	@ExcelIgnore
	private String orderStatus;
	
	@ApiModelProperty(value = "订单状态名称")
	@ExcelProperty(value = "订单状态", index = 22)
	private String orderStatusName;
	
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getDeliveryStoreName() {
		return deliveryStoreName;
	}

	public void setDeliveryStoreName(String deliveryStoreName) {
		this.deliveryStoreName = deliveryStoreName;
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

	public String getApprovalOperation() {
		return approvalOperation;
	}

	public void setApprovalOperation(String approvalOperation) {
		this.approvalOperation = approvalOperation;
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

	public String getPaymentMethodName() {
		return paymentMethodName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getZbiiln() {
		return zbiiln;
	}

	public void setZbiiln(String zbiiln) {
		this.zbiiln = zbiiln;
	}

	public String getZdname() {
		return zdname;
	}

	public void setZdname(String zdname) {
		this.zdname = zdname;
	}

	public String getZdbankn() {
		return zdbankn;
	}

	public void setZdbankn(String zdbankn) {
		this.zdbankn = zdbankn;
	}

	public String getReceiptMethod() {
		return receiptMethod;
	}

	public void setReceiptMethod(String receiptMethod) {
		this.receiptMethod = receiptMethod;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Double getReceivableAmount() {
		return receivableAmount;
	}

	public void setReceivableAmount(Double receivableAmount) {
		this.receivableAmount = receivableAmount;
	}

	public Double getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(Double receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getDeliveryPersonName() {
		return deliveryPersonName;
	}

	public void setDeliveryPersonName(String deliveryPersonName) {
		this.deliveryPersonName = deliveryPersonName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

}
