package com.exp.ucmp.contract.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RetailSaleContractDto", description = "零售合同生成参数类")
public class CompanyDto {
	
	@ApiModelProperty(value = "公司税号")
    private String taxNumber;
	
	@ApiModelProperty(value = "公司抬头")
    private String companyTitle;
	
	@ApiModelProperty(value = "地址")
	private String address;
	
	@ApiModelProperty(value = "电话")
	private String phone;
	
	@ApiModelProperty(value = "收款开户银行")
	private String receivingBank;
	
	@ApiModelProperty(value = "收款银行账号")
	private String receivingBankAccount;

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getCompanyTitle() {
		return companyTitle;
	}

	public void setCompanyTitle(String companyTitle) {
		this.companyTitle = companyTitle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReceivingBank() {
		return receivingBank;
	}

	public void setReceivingBank(String receivingBank) {
		this.receivingBank = receivingBank;
	}

	public String getReceivingBankAccount() {
		return receivingBankAccount;
	}

	public void setReceivingBankAccount(String receivingBankAccount) {
		this.receivingBankAccount = receivingBankAccount;
	}

}
