package com.exp.ucmp.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AddPaymentRecordDto", description = "线下付款(转账或现金添加付款记录)参数类")
public class AddPaymentRecordDto {
	
	@ApiModelProperty(value = "订单id")
	private Long orderId;
	
	@ApiModelProperty(value = "订单金额 单位：元，如0.01")
	private String amount;
	
	@ApiModelProperty(value = "订单标题即付款项目 6701:小定,6702:大定,6703:尾款,6704:其它款项")
	private String subject;
	
	@ApiModelProperty(value = "交易方式  2501:微信扫码支付,2500:支付宝扫码支付,2503:快捷,2505:POS,2506:转账,2507:现金")
	private String paytype;
	
	@ApiModelProperty(value = "付款账户")
    private String paymentAccount;
	
	@ApiModelProperty(value = "付款账户名称")
    private String accountName;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
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
	
}
