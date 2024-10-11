package com.exp.ucmp.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PayCallBackDto", description = "支付中心回调类")
public class PayCallBackDto {
	
	@ApiModelProperty(value = "支付中心应用id")
	private String appId;
	
	@ApiModelProperty(value = "通知类型 0-退款 1-支付")
	private String notifyType;
	
	@ApiModelProperty(value = "支付渠道交易单号 状态为成功（000000）的时候必传，000001的时候非必传，目前传的是支付渠道流水号")
	private String paymentCenterNum;

	@ApiModelProperty(value = "订单号")
	private String orderNum;
	
	@ApiModelProperty(value = "金额 分为单位")
	private String amount;
	
	@ApiModelProperty(value = "000000 - 成功 000001 - 失败")
	private String status;
	
	@ApiModelProperty(value = "支付方式，00-支付宝，01-微信支付，03-快捷，05-POS")
	private String paymentType;
	
	@ApiModelProperty(value = "错误信息")
	private String errorMessage;
	
	@ApiModelProperty(value = "交易完成时间")
	private String payTime;
	
	@ApiModelProperty(value = "支付渠道商户号  支付方式为支付宝则表示appId，为微信则表示微信商户号，其它表示通联商户号")
	private String merchantId;
	
	@ApiModelProperty(value = "扩展字段")
	private String ext;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getNotifyType() {
		return notifyType;
	}

	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}

	public String getPaymentCenterNum() {
		return paymentCenterNum;
	}

	public void setPaymentCenterNum(String paymentCenterNum) {
		this.paymentCenterNum = paymentCenterNum;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}
	
}
