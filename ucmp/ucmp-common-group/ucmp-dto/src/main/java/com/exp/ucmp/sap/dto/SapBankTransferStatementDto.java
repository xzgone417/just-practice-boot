package com.exp.ucmp.sap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SapBankTransferStatementDto", description = "SAP银行流水实体类")
public class SapBankTransferStatementDto {
	
	@ApiModelProperty(value = "银行流水号")
	@JsonProperty("ZBIILN")
	private String zbiiln;
	
	@ApiModelProperty(value = "公司代码")
	@JsonProperty("BUKRS")
	private String bukrs;
	
	@ApiModelProperty(value = "本方账号")
	@JsonProperty("ZPWBANKN")
	private String zpwbankn;
	
	@ApiModelProperty(value = "本方户名")
	@JsonProperty("ZPWNAME")
	private String zpwname;
	
	@ApiModelProperty(value = "对方账号")
	@JsonProperty("ZDBANKN")
	private String zdbankn;
	
	@ApiModelProperty(value = "对方户名")
	@JsonProperty("ZDNAME")
	private String zdname;
	
	@ApiModelProperty(value = "交易日期")
	@JsonProperty("ZTRDATE")
	private String ztrdate;
	
	@ApiModelProperty(value = "交易时间")
	@JsonProperty("ZTRTIME")
	private String ztrtime;
	
	@ApiModelProperty(value = "收款金额")
	@JsonProperty("ZCRTRSAMT")
	private String zcrtrsamt;
	
	@ApiModelProperty(value = "币种名称")
	@JsonProperty("WAERS")
	private String waers;
	
	@ApiModelProperty(value = "备注信息")
	@JsonProperty("ZTEXT")
	private String ztext;

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

	public String getZpwname() {
		return zpwname;
	}

	public void setZpwname(String zpwname) {
		this.zpwname = zpwname;
	}

	public String getZdbankn() {
		return zdbankn;
	}

	public void setZdbankn(String zdbankn) {
		this.zdbankn = zdbankn;
	}

	public String getZdname() {
		return zdname;
	}

	public void setZdname(String zdname) {
		this.zdname = zdname;
	}

	public String getZtrdate() {
		return ztrdate;
	}

	public void setZtrdate(String ztrdate) {
		this.ztrdate = ztrdate;
	}

	public String getZtrtime() {
		return ztrtime;
	}

	public void setZtrtime(String ztrtime) {
		this.ztrtime = ztrtime;
	}

	public String getZcrtrsamt() {
		return zcrtrsamt;
	}

	public void setZcrtrsamt(String zcrtrsamt) {
		this.zcrtrsamt = zcrtrsamt;
	}

	public String getWaers() {
		return waers;
	}

	public void setWaers(String waers) {
		this.waers = waers;
	}

	public String getZtext() {
		return ztext;
	}

	public void setZtext(String ztext) {
		this.ztext = ztext;
	}
	
}
