package com.exp.ucmp.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PayDto", description = "统一下单接口参数类")
public class PayDto {
	
	@ApiModelProperty(value = "订单id")
	private Long orderId;
	
	@ApiModelProperty(value = "订单号 不用传")
	private String orderNo;
	
	@ApiModelProperty(value = "订单金额 单位：元，如0.01")
	private String amount;
	
	@ApiModelProperty(value = "订单标题即付款项目 6701:小定,6702:大定,6703:尾款,6704:其它款项")
	private String subject;
	
	@ApiModelProperty(value = "订单标题名称")
	private String subjectName;
	
	@ApiModelProperty(value = "交易方式  2501:微信扫码支付,2500:支付宝扫码支付,2503:快捷,2505:POS,2506:转账,2507:现金")
	private String paytype;
	
	@ApiModelProperty(value = "支付平台用户标识 交易方式为W06时必传 微信小程序-用户小程序的openid")
	private String acct;
	
	@ApiModelProperty(value = "车辆主体code")
	private String revertBody;
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public String getAcct() {
		return acct;
	}

	public void setAcct(String acct) {
		this.acct = acct;
	}

	public String getRevertBody() {
		return revertBody;
	}

	public void setRevertBody(String revertBody) {
		this.revertBody = revertBody;
	}
}
