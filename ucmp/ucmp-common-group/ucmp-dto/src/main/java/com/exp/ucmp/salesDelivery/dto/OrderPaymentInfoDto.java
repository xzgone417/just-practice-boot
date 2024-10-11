package com.exp.ucmp.salesDelivery.dto;


import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderPaymentInfoDto", description = "订单付款与资金单信息详情")
public class OrderPaymentInfoDto {
	
	@ApiModelProperty(value = "订单id")
	private Long orderInfoId;
	
	@ApiModelProperty(value = "订单编号")
	private String orderNo;
	
	@ApiModelProperty(value = "库存车辆id")
	private Long stockId;
	
	@ApiModelProperty(value = "应收金额")
	private Double receivablePrice;
	
	@ApiModelProperty(value = "已收金额")
	private Double receivedPrice;
	
	@ApiModelProperty(value = "未收金额")
	private Double notReceivedPrice;
	
	@ApiModelProperty(value = "车辆主体")
	private String revertBody;
	
	@ApiModelProperty(value = "车辆主体名称")
	private String revertBodyName;
	
	@ApiModelProperty(value = "金融凭证")
	private List<DeliveryOrderPicDto> financialProofList;
	
	@ApiModelProperty(value = "金融金额")
	private Double financialAmount;
	
	@ApiModelProperty(value = "大定凭证")
	private List<DeliveryOrderPicDto> setPaymentProofList;
	
	@ApiModelProperty(value = "大定金额")
	private Double setPaymentSum;
	
	@ApiModelProperty(value = "尾款凭证")
	private List<DeliveryOrderPicDto> balancePaymentProofList;
	
	@ApiModelProperty(value = "尾款金额")
	private Double balancePaymentSum;
	
	@ApiModelProperty(value = "其他款项凭证")
	private List<DeliveryOrderPicDto> otherPaymentsProofList;
	
	@ApiModelProperty(value = "其他款项金额")
	private Double otherPayments;
	
	@ApiModelProperty(value = "付款记录")
	private List<OrderPaymentRecordDto> paymentRecord;

	public Long getOrderInfoId() {
		return orderInfoId;
	}

	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Double getReceivablePrice() {
		return receivablePrice;
	}

	public void setReceivablePrice(Double receivablePrice) {
		this.receivablePrice = receivablePrice;
	}

	public Double getReceivedPrice() {
		return receivedPrice;
	}

	public void setReceivedPrice(Double receivedPrice) {
		this.receivedPrice = receivedPrice;
	}

	public Double getNotReceivedPrice() {
		return notReceivedPrice;
	}

	public void setNotReceivedPrice(Double notReceivedPrice) {
		this.notReceivedPrice = notReceivedPrice;
	}

	public String getRevertBody() {
		return revertBody;
	}

	public void setRevertBody(String revertBody) {
		this.revertBody = revertBody;
	}

	public String getRevertBodyName() {
		return revertBodyName;
	}

	public void setRevertBodyName(String revertBodyName) {
		this.revertBodyName = revertBodyName;
	}

	public List<DeliveryOrderPicDto> getFinancialProofList() {
		return financialProofList;
	}

	public void setFinancialProofList(List<DeliveryOrderPicDto> financialProofList) {
		this.financialProofList = financialProofList;
	}

	public Double getFinancialAmount() {
		return financialAmount;
	}

	public void setFinancialAmount(Double financialAmount) {
		if(financialAmount==0){
			financialAmount=null;
		}
		this.financialAmount = financialAmount;
	}

	public List<DeliveryOrderPicDto> getSetPaymentProofList() {
		return setPaymentProofList;
	}

	public void setSetPaymentProofList(List<DeliveryOrderPicDto> setPaymentProofList) {
		this.setPaymentProofList = setPaymentProofList;
	}

	public Double getSetPaymentSum() {
		return setPaymentSum;
	}

	public void setSetPaymentSum(Double setPaymentSum) {
		if(setPaymentSum==0){
			setPaymentSum=null;
		}
		this.setPaymentSum = setPaymentSum;
	}

	public List<DeliveryOrderPicDto> getBalancePaymentProofList() {
		return balancePaymentProofList;
	}

	public void setBalancePaymentProofList(List<DeliveryOrderPicDto> balancePaymentProofList) {
		this.balancePaymentProofList = balancePaymentProofList;
	}

	public Double getBalancePaymentSum() {
		return balancePaymentSum;
	}

	public void setBalancePaymentSum(Double balancePaymentSum) {
		if(balancePaymentSum==0){
			balancePaymentSum=null;
		}
		this.balancePaymentSum = balancePaymentSum;
	}

	public List<DeliveryOrderPicDto> getOtherPaymentsProofList() {
		return otherPaymentsProofList;
	}

	public void setOtherPaymentsProofList(List<DeliveryOrderPicDto> otherPaymentsProofList) {
		this.otherPaymentsProofList = otherPaymentsProofList;
	}

	public Double getOtherPayments() {
		return otherPayments;
	}

	public void setOtherPayments(Double otherPayments) {
		if(otherPayments==0){
			otherPayments=null;
		}
		this.otherPayments = otherPayments;
	}

	public List<OrderPaymentRecordDto> getPaymentRecord() {
		return paymentRecord;
	}

	public void setPaymentRecord(List<OrderPaymentRecordDto> paymentRecord) {
		this.paymentRecord = paymentRecord;
	}
	
}
