package com.exp.ucmp.pay.dto;

import com.exp.ucmp.PageDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QueryStatementParamsDto", description = "查询银行流水参数类")
public class QueryStatementParamsDto  extends PageDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7218815814951071560L;

	@ApiModelProperty(value = "转账户名")
	private String zdname;
	
	@ApiModelProperty(value = "交易时间")
	private String ztrdate;
	
	@ApiModelProperty(value = "转账金额")
	private Double zcrtrsamt;
	
	@ApiModelProperty(value = "备注信息")
	private String ztext;
	
	@ApiModelProperty(value = "银行流水号")
	private String zbiiln;

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

	public Double getZcrtrsamt() {
		return zcrtrsamt;
	}

	public void setZcrtrsamt(Double zcrtrsamt) {
		this.zcrtrsamt = zcrtrsamt;
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

}
