package com.exp.ucmp.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QueryBankStatementDto", description = "查询银行流水返回类")
public class QueryBankStatementDto {
	
	@ApiModelProperty(value = "转账户名")
	private String zdname;
	
	@ApiModelProperty(value = "转账账号")
	private String zdbankn;
	
	@ApiModelProperty(value = "收款日期")
	private String ztrdate;
	
	@ApiModelProperty(value = "交易时间")
	private String receiptDate;
	
	@ApiModelProperty(value = "转账金额")
	private Double zcrtrsamt;
	
	@ApiModelProperty(value = "可匹配金额")
	private Double matchingAmount;
	
	@ApiModelProperty(value = "备注信息")
	private String ztext;
	
	@ApiModelProperty(value = "流水号")
	private String zbiiln;
	
	@ApiModelProperty(value = "公司代码")
	private String bukrs;
	
	@ApiModelProperty(value = "本方账号")
	private String zpwbankn;

	public String getZdname() {
		return zdname;
	}

	public void setZdname(String zdname) {
		this.zdname = zdname;
	}

	public String getZdbankn() {
		return zdbankn;
	}

	public void setZdbankn(String zdbankn) {
		this.zdbankn = zdbankn;
	}

	public String getZtrdate() {
		return ztrdate;
	}

	public void setZtrdate(String ztrdate) {
		this.ztrdate = ztrdate;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public Double getZcrtrsamt() {
		return zcrtrsamt;
	}

	public void setZcrtrsamt(Double zcrtrsamt) {
		this.zcrtrsamt = zcrtrsamt;
	}

	public Double getMatchingAmount() {
		return matchingAmount;
	}

	public void setMatchingAmount(Double matchingAmount) {
		this.matchingAmount = matchingAmount;
	}

	public String getZtext() {
		return ztext;
	}

	public void setZtext(String ztext) {
		this.ztext = ztext;
	}

	public String getZbiiln() {
		return zbiiln;
	}

	public void setZbiiln(String zbiiln) {
		this.zbiiln = zbiiln;
	}

	public String getBukrs() {
		return bukrs;
	}

	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}

	public String getZpwbankn() {
		return zpwbankn;
	}

	public void setZpwbankn(String zpwbankn) {
		this.zpwbankn = zpwbankn;
	}

}
