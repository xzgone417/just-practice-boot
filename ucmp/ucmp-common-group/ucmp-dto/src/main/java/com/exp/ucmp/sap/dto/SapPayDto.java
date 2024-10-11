package com.exp.ucmp.sap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SapPayDto", description = "营销收款同步")
public class SapPayDto {
	
	@ApiModelProperty(value = "业务系统")
	@JsonProperty("ZBUSSYS")
	private String zbussys;
	
	@ApiModelProperty(value = "业务单据号 ,业务系统订单号")
	@JsonProperty("ZBORDER_FQ")
	private String zborderFq;
	
	@ApiModelProperty(value = "执行端业务单据号")
	@JsonProperty("ZBORDER_EX")
	private String zborderEx;
	
	@ApiModelProperty(value = "支付流水号,支付平台订单")
	@JsonProperty("ZZFPTNO")
	private String zzfptno;
	
	@ApiModelProperty(value = "时间戳")
	@JsonProperty("ZZTIMESTEMP")
	private String zztimestemp;
	
	@ApiModelProperty(value = "绑定/解绑,Y-绑定，N-解绑,S-手工确认 当支付通道ZZFTD=40-银行转账的时候，需要必输")
	@JsonProperty("ZBAND")
	private String zband;
	
	@ApiModelProperty(value = "收款公司代码,收款公司代码和商户号不能同时为空,财务提供公司码表+公司名称，线下收款及线下退款时选择公司代码。")
	@JsonProperty("BUKRS")
	private String bukrs;
	
	@ApiModelProperty(value = "支付通道,根据订单支付通道传：10-通联、20-支付宝。30-微信，40-银行转账,银行转账必填40")
	@JsonProperty("ZZFTD")
	private String zzftd;
	
	@ApiModelProperty(value = "商户号,通联给子商户号,收款公司代码和商户号不能同时为空,收款银行账户，微信支付宝直连的给各自的商户号")
	@JsonProperty("ZSHH")
	private String zshh;
	
	@ApiModelProperty(value = "支付状态,10收款成功,20退款成功")
	@JsonProperty("ZZFSTATUS")
	private String zzfstatus;
	
	@ApiModelProperty(value = "收款类型,01整车 02 配件03 充电桩04附件05服务包06洗冲停07精品 08售后维修")
	@JsonProperty("ZRECTYPE")
	private String zrectype;
	
	@ApiModelProperty(value = "支付方式,10第三方支付平台、20银行转账、30现金40贷款")
	@JsonProperty("ZPAYMETH")
	private String zpaymeth;
	
	@ApiModelProperty(value = "SAP客户号")
	@JsonProperty("KUNNR")
	private String kunnr;
	
	@ApiModelProperty(value = "收款日期")
	@JsonProperty("ZDATE")
	private String zdate;
	
	@ApiModelProperty(value = "付款人")
	@JsonProperty("ZPAYNAME")
	private String zpayname;
	
	@ApiModelProperty(value = "收款金额")
	@JsonProperty("WRBTR")
	private String wrbtr;
	
	@ApiModelProperty(value = "币种")
	@JsonProperty("WAERS")
	private String waers;
	
	@ApiModelProperty(value = "备注")
	@JsonProperty("ZMEMO")
	private String zmemo;
	
	@ApiModelProperty(value = "预留字段01")
	@JsonProperty("FIELD01")
	private String field01;
	
	@ApiModelProperty(value = "预留字段02")
	@JsonProperty("FIELD02")
	private String field02;
	
	@ApiModelProperty(value = "预留字段03")
	@JsonProperty("FIELD03")
	private String field03;
	
	@ApiModelProperty(value = "预留字段04")
	@JsonProperty("FIELD04")
	private String field04;
	
	@ApiModelProperty(value = "预留字段05")
	@JsonProperty("FIELD05")
	private String field05;

	public String getZbussys() {
		return zbussys;
	}

	public void setZbussys(String zbussys) {
		this.zbussys = zbussys;
	}

	public String getZborderFq() {
		return zborderFq;
	}

	public void setZborderFq(String zborderFq) {
		this.zborderFq = zborderFq;
	}

	public String getZborderEx() {
		return zborderEx;
	}

	public void setZborderEx(String zborderEx) {
		this.zborderEx = zborderEx;
	}

	public String getZzfptno() {
		return zzfptno;
	}

	public void setZzfptno(String zzfptno) {
		this.zzfptno = zzfptno;
	}

	public String getZztimestemp() {
		return zztimestemp;
	}

	public void setZztimestemp(String zztimestemp) {
		this.zztimestemp = zztimestemp;
	}

	public String getZband() {
		return zband;
	}

	public void setZband(String zband) {
		this.zband = zband;
	}

	public String getBukrs() {
		return bukrs;
	}

	public void setBukrs(String bukrs) {
		this.bukrs = bukrs;
	}

	public String getZzftd() {
		return zzftd;
	}

	public void setZzftd(String zzftd) {
		this.zzftd = zzftd;
	}

	public String getZshh() {
		return zshh;
	}

	public void setZshh(String zshh) {
		this.zshh = zshh;
	}

	public String getZzfstatus() {
		return zzfstatus;
	}

	public void setZzfstatus(String zzfstatus) {
		this.zzfstatus = zzfstatus;
	}

	public String getZrectype() {
		return zrectype;
	}

	public void setZrectype(String zrectype) {
		this.zrectype = zrectype;
	}

	public String getZpaymeth() {
		return zpaymeth;
	}

	public void setZpaymeth(String zpaymeth) {
		this.zpaymeth = zpaymeth;
	}

	public String getKunnr() {
		return kunnr;
	}

	public void setKunnr(String kunnr) {
		this.kunnr = kunnr;
	}

	public String getZdate() {
		return zdate;
	}

	public void setZdate(String zdate) {
		this.zdate = zdate;
	}

	public String getZpayname() {
		return zpayname;
	}

	public void setZpayname(String zpayname) {
		this.zpayname = zpayname;
	}

	public String getWrbtr() {
		return wrbtr;
	}

	public void setWrbtr(String wrbtr) {
		this.wrbtr = wrbtr;
	}

	public String getWaers() {
		return waers;
	}

	public void setWaers(String waers) {
		this.waers = waers;
	}

	public String getZmemo() {
		return zmemo;
	}

	public void setZmemo(String zmemo) {
		this.zmemo = zmemo;
	}

	public String getField01() {
		return field01;
	}

	public void setField01(String field01) {
		this.field01 = field01;
	}

	public String getField02() {
		return field02;
	}

	public void setField02(String field02) {
		this.field02 = field02;
	}

	public String getField03() {
		return field03;
	}

	public void setField03(String field03) {
		this.field03 = field03;
	}

	public String getField04() {
		return field04;
	}

	public void setField04(String field04) {
		this.field04 = field04;
	}

	public String getField05() {
		return field05;
	}

	public void setField05(String field05) {
		this.field05 = field05;
	}
}
