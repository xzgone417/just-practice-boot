package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SmpStoreReturnDto", description = "smp返回类")
public class SmpStoreReturnDto {
	
	@ApiModelProperty(value = "状态码")
	private String code;
	
	@ApiModelProperty(value = "信息描述")
    private String msg;
	
	@ApiModelProperty(value = "数据体")
    private SmpDataDto data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public SmpDataDto getData() {
		return data;
	}

	public void setData(SmpDataDto data) {
		this.data = data;
	}
}
