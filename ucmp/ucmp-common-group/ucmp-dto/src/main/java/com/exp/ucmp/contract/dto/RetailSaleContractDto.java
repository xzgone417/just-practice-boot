package com.exp.ucmp.contract.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RetailSaleContractDto", description = "零售合同生成参数类")
public class RetailSaleContractDto {
	
	@ApiModelProperty(value = "公司税号")
    private String taxNumber;
	
	@ApiModelProperty(value = "乙方名称,必传")
    private String partyBName;
	
	@ApiModelProperty(value = "乙方联系电话,必传")
	private String partyBContactNumber;
	
	@ApiModelProperty(value = "乙方身份证号/统一社会信用代码,必传")
	private String partyBCreditIdentifier;
	
	@ApiModelProperty(value = "车辆首次登记时间")
	private String firstRegistrationTime;
	
	@ApiModelProperty(value = "不含税总价,必传")
	private String transactionPriceLowercase;

	@ApiModelProperty(value = "小定金额,必传")
	private String handsel;
	
	@ApiModelProperty(value = "改价原因尾款金额,必传")
	private String balancePayment;
	
	@ApiModelProperty(value = "大定金额,必传")
	private String largeAmount;
	
	@ApiModelProperty(value = "vin码")
	private String vin;
	
	@ApiModelProperty(value = "基础车型")
	private String baseCarTypeName;
	
	@ApiModelProperty(value = "牌照号")
	private String license;
	
	@ApiModelProperty(value = "库存车辆ID")
	private Long stockId;

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getPartyBName() {
		return partyBName;
	}

	public void setPartyBName(String partyBName) {
		this.partyBName = partyBName;
	}

	public String getPartyBContactNumber() {
		return partyBContactNumber;
	}

	public void setPartyBContactNumber(String partyBContactNumber) {
		this.partyBContactNumber = partyBContactNumber;
	}

	public String getPartyBCreditIdentifier() {
		return partyBCreditIdentifier;
	}

	public void setPartyBCreditIdentifier(String partyBCreditIdentifier) {
		this.partyBCreditIdentifier = partyBCreditIdentifier;
	}

	public String getFirstRegistrationTime() {
		return firstRegistrationTime;
	}

	public void setFirstRegistrationTime(String firstRegistrationTime) {
		this.firstRegistrationTime = firstRegistrationTime;
	}

	public String getTransactionPriceLowercase() {
		return transactionPriceLowercase;
	}

	public void setTransactionPriceLowercase(String transactionPriceLowercase) {
		this.transactionPriceLowercase = transactionPriceLowercase;
	}

	public String getHandsel() {
		return handsel;
	}

	public void setHandsel(String handsel) {
		this.handsel = handsel;
	}

	public String getBalancePayment() {
		return balancePayment;
	}

	public void setBalancePayment(String balancePayment) {
		this.balancePayment = balancePayment;
	}

	public String getLargeAmount() {
		return largeAmount;
	}

	public void setLargeAmount(String largeAmount) {
		this.largeAmount = largeAmount;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getBaseCarTypeName() {
		return baseCarTypeName;
	}

	public void setBaseCarTypeName(String baseCarTypeName) {
		this.baseCarTypeName = baseCarTypeName;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

}
