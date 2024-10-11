package com.exp.ucmp.salesDelivery.dto;


import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DeliveryOrderFinancialDto", description = "销售交付订单金融凭证材料参数")
public class DeliveryOrderFinancialDto {
	
	@NotNull
	@ApiModelProperty(value = "订单ID")
	private Long orderInfoId;
	
	@ApiModelProperty(value = "更新人ID 不用传")
	private Long updateBy;
	
	@ApiModelProperty(value = "金融金额")
	private Double amount;
	
	@ApiModelProperty(value = "金融凭证材料")
    private List<DeliveryOrderPicDto> financialtList;
	
	@ApiModelProperty(value = "大定金额")
	private Double setPaymentSum;
	
	@ApiModelProperty(value = "大定凭证")
	private List<DeliveryOrderPicDto> setPaymentProofList;
	
	@ApiModelProperty(value = "尾款金额")
	private Double balancePaymentSum;
	
	@ApiModelProperty(value = "尾款凭证")
	private List<DeliveryOrderPicDto> balancePaymentProofList;
	
	@ApiModelProperty(value = "其他款项金额")
	private Double otherPayments;
	
	@ApiModelProperty(value = "其他款项凭证")
	private List<DeliveryOrderPicDto> otherPaymentsProofList;

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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		if(amount == null){
			amount=(double) 0;
		}
		this.amount = amount;
	}

	public List<DeliveryOrderPicDto> getFinancialtList() {
		return financialtList;
	}

	public void setFinancialtList(List<DeliveryOrderPicDto> financialtList) {
		this.financialtList = financialtList;
	}

	public List<DeliveryOrderPicDto> getSetPaymentProofList() {
		return setPaymentProofList;
	}

	public void setSetPaymentProofList(List<DeliveryOrderPicDto> setPaymentProofList) {
		this.setPaymentProofList = setPaymentProofList;
	}

	public List<DeliveryOrderPicDto> getBalancePaymentProofList() {
		return balancePaymentProofList;
	}

	public void setBalancePaymentProofList(List<DeliveryOrderPicDto> balancePaymentProofList) {
		this.balancePaymentProofList = balancePaymentProofList;
	}

	public List<DeliveryOrderPicDto> getOtherPaymentsProofList() {
		return otherPaymentsProofList;
	}

	public void setOtherPaymentsProofList(List<DeliveryOrderPicDto> otherPaymentsProofList) {
		this.otherPaymentsProofList = otherPaymentsProofList;
	}

	public Double getSetPaymentSum() {
		return setPaymentSum;
	}

	public void setSetPaymentSum(Double setPaymentSum) {
		if(setPaymentSum == null){
			setPaymentSum=(double) 0;
		}
		this.setPaymentSum = setPaymentSum;
	}

	public Double getBalancePaymentSum() {
		return balancePaymentSum;
	}

	public void setBalancePaymentSum(Double balancePaymentSum) {
		if(balancePaymentSum == null){
			balancePaymentSum=(double) 0;
		}
		this.balancePaymentSum = balancePaymentSum;
	}

	public Double getOtherPayments() {
		return otherPayments;
	}

	public void setOtherPayments(Double otherPayments) {
		if(otherPayments == null){
			otherPayments=(double) 0;
		}
		this.otherPayments = otherPayments;
	}
    
}
