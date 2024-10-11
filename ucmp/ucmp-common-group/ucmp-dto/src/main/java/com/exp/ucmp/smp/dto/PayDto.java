package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PayDto", description = "收款流水")
public class PayDto {

	@ApiModelProperty(value = "收款单号")
	private String gatheringOrderCode;
	
	@ApiModelProperty(value = "收款项目 4退款,5:意向金,10:大定补差,15:定金,20:首付款,25:尾款,30金融放款,35贴息")
    private String gatheringItemCode;
	
	@ApiModelProperty(value = "单据类型 0:收款 1:退款")
    private String orderType;
	
	@ApiModelProperty(value = "收款人员")
    private String gatheringEmpName;
	
	@ApiModelProperty(value = "收款日期")
    private String gateringDate;
	
	@ApiModelProperty(value = "退/付款人")
    private String payer;
	
	@ApiModelProperty(value = "支付流水号")
    private String payFlowNo;
	
	@ApiModelProperty(value = "付款方式")
    private String payType;
	
	@ApiModelProperty(value = "实收/退金额")
    private String factReceivedAmount;
	
	@ApiModelProperty(value = "银行名称")
    private String bankName;
	
	@ApiModelProperty(value = "银行账号")
    private String bankAccount;

	public String getGatheringOrderCode() {
		return gatheringOrderCode;
	}

	public void setGatheringOrderCode(String gatheringOrderCode) {
		this.gatheringOrderCode = gatheringOrderCode;
	}

	public String getGatheringItemCode() {
		return gatheringItemCode;
	}

	public void setGatheringItemCode(String gatheringItemCode) {
		this.gatheringItemCode = gatheringItemCode;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getGatheringEmpName() {
		return gatheringEmpName;
	}

	public void setGatheringEmpName(String gatheringEmpName) {
		this.gatheringEmpName = gatheringEmpName;
	}

	public String getGateringDate() {
		return gateringDate;
	}

	public void setGateringDate(String gateringDate) {
		this.gateringDate = gateringDate;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public String getPayFlowNo() {
		return payFlowNo;
	}

	public void setPayFlowNo(String payFlowNo) {
		this.payFlowNo = payFlowNo;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getFactReceivedAmount() {
		return factReceivedAmount;
	}

	public void setFactReceivedAmount(String factReceivedAmount) {
		this.factReceivedAmount = factReceivedAmount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
}
