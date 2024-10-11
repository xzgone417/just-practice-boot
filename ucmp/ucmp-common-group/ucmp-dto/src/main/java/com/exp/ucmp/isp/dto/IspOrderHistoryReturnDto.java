package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IspQuoteApplyReturnDto", description = "isp报价单申请返回类")
public class IspOrderHistoryReturnDto {
	
	@ApiModelProperty(value = "状态码")
	private String code;
	
	@ApiModelProperty(value = "数据")
    private IspOrderHistoryDataDto data;
	
	@ApiModelProperty(value = "状态信息")
    private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public IspOrderHistoryDataDto getData() {
		return data;
	}

	public void setData(IspOrderHistoryDataDto data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
