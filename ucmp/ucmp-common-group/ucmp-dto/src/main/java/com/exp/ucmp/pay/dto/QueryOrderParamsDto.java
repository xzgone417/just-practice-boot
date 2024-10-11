package com.exp.ucmp.pay.dto;

import javax.validation.constraints.NotNull;

import com.exp.ucmp.PageDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QueryOrderParamsDto", description = "查询订单信息参数类")
public class QueryOrderParamsDto  extends PageDto{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2888929672065767127L;

	@ApiModelProperty(value = "订单号,支持模糊查询")
	private String orderNo;
	
	@ApiModelProperty(value = "客户姓名,支持模糊查询")
	private String customerName;
	
	@ApiModelProperty(value = "客户联系电话")
	private String customerPhone;
	
	@ApiModelProperty(value = "交付中心id，登陆人员位门店人员时必传")
	private Long deliveryStore;
	
	@ApiModelProperty(value = "交付顾问id")
	private Long deliveryPerson;
	
	@ApiModelProperty(value = "交付顾问名称")
	private Long deliveryPersonName;
	
	@ApiModelProperty(value = "收款登记时间--起始")
	private String paymentStartDate;
	
	@ApiModelProperty(value = "收款登记时间--截止")
	private String paymentEndDate;
	
	@ApiModelProperty(value = "收款状态")
	private String payStatus;
	
	@ApiModelProperty(value = "收款单号,支持模糊查询")
	private String recordCode;
	
	@ApiModelProperty(value = "确认时间--起始")
	private String approvalStartDate;
	
	@ApiModelProperty(value = "确认时间--截止")
	private String approvalEndDate;
	
	@ApiModelProperty(value = "收款类型")
	private String paymentType;
	
	@ApiModelProperty(value = "流水号,支持模糊查询")
	private String zbiiln;
	
	@NotNull
	@ApiModelProperty(value = "人员类型,总部 0010 门店 0020")
	private String staffType;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public Long getDeliveryStore() {
		return deliveryStore;
	}

	public void setDeliveryStore(Long deliveryStore) {
		this.deliveryStore = deliveryStore;
	}

	public Long getDeliveryPerson() {
		return deliveryPerson;
	}

	public void setDeliveryPerson(Long deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}

	public Long getDeliveryPersonName() {
		return deliveryPersonName;
	}

	public void setDeliveryPersonName(Long deliveryPersonName) {
		this.deliveryPersonName = deliveryPersonName;
	}

	public String getPaymentStartDate() {
		return paymentStartDate;
	}

	public void setPaymentStartDate(String paymentStartDate) {
		this.paymentStartDate = paymentStartDate;
	}

	public String getPaymentEndDate() {
		return paymentEndDate;
	}

	public void setPaymentEndDate(String paymentEndDate) {
		this.paymentEndDate = paymentEndDate;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}

	public String getApprovalStartDate() {
		return approvalStartDate;
	}

	public void setApprovalStartDate(String approvalStartDate) {
		this.approvalStartDate = approvalStartDate;
	}

	public String getApprovalEndDate() {
		return approvalEndDate;
	}

	public void setApprovalEndDate(String approvalEndDate) {
		this.approvalEndDate = approvalEndDate;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getZbiiln() {
		return zbiiln;
	}

	public void setZbiiln(String zbiiln) {
		this.zbiiln = zbiiln;
	}

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

}
