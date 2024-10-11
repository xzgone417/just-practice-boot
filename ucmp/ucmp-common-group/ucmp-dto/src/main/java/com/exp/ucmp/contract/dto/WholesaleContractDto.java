package com.exp.ucmp.contract.dto;


import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WholesaleContractDto", description = "批售合同生成参数类")
public class WholesaleContractDto {
	
	@ApiModelProperty(value = "公司税号")
    private String taxNumber;
	
	@ApiModelProperty(value = "乙方名称,必传")
    private String partyBName;
	
	@ApiModelProperty(value = "乙方账号,必传")
    private String partyBAccountName;
	
	@ApiModelProperty(value = "乙方联系电话,必传")
	private String partyBContactNumber;
	
	@ApiModelProperty(value = "乙方公司名称,必传")
	private String partyBCompanyName;
	
	@ApiModelProperty(value = "乙方身份证号/统一社会信用代码,必传")
	private String partyBCreditIdentifier;
	
	@ApiModelProperty(value = "乙方纳税人识别号,必传")
	private String partyBTaxpayerNumber;
	
	@ApiModelProperty(value = "乙方地址,必传")
	private String partyBAddress;
	
	@ApiModelProperty(value = "乙方开户行,必传")
	private String partyBBankDeposit;
	
	@ApiModelProperty(value = "3日内意向金,必传")
	private String handsel;
	
	@ApiModelProperty(value = "合计意向金,必传")
	private String totalHandsel;
	
	@ApiModelProperty(value = "最晚提车日期,yyyy-mm-dd,必传")
	private String latestPickupDate;
	
	@ApiModelProperty(value = "过户期限(自然日),必传")
	private int dayAmount;
	
	@ApiModelProperty(value = "库存车辆ID集合,必传")
	private List<Long> stockId;

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

	public String getPartyBAccountName() {
		return partyBAccountName;
	}

	public void setPartyBAccountName(String partyBAccountName) {
		this.partyBAccountName = partyBAccountName;
	}

	public String getPartyBCompanyName() {
		return partyBCompanyName;
	}

	public void setPartyBCompanyName(String partyBCompanyName) {
		this.partyBCompanyName = partyBCompanyName;
	}

	public String getPartyBTaxpayerNumber() {
		return partyBTaxpayerNumber;
	}

	public void setPartyBTaxpayerNumber(String partyBTaxpayerNumber) {
		this.partyBTaxpayerNumber = partyBTaxpayerNumber;
	}

	public String getPartyBAddress() {
		return partyBAddress;
	}

	public void setPartyBAddress(String partyBAddress) {
		this.partyBAddress = partyBAddress;
	}

	public String getPartyBBankDeposit() {
		return partyBBankDeposit;
	}

	public void setPartyBBankDeposit(String partyBBankDeposit) {
		this.partyBBankDeposit = partyBBankDeposit;
	}

	public String getHandsel() {
		return handsel;
	}

	public void setHandsel(String handsel) {
		this.handsel = handsel;
	}

	public String getTotalHandsel() {
		return totalHandsel;
	}

	public void setTotalHandsel(String totalHandsel) {
		this.totalHandsel = totalHandsel;
	}

	public String getLatestPickupDate() {
		return latestPickupDate;
	}

	public void setLatestPickupDate(String latestPickupDate) {
		this.latestPickupDate = latestPickupDate;
	}

	public int getDayAmount() {
		return dayAmount;
	}

	public void setDayAmount(int dayAmount) {
		this.dayAmount = dayAmount;
	}

	public List<Long> getStockId() {
		return stockId;
	}

	public void setStockId(List<Long> stockId) {
		this.stockId = stockId;
	}
}
