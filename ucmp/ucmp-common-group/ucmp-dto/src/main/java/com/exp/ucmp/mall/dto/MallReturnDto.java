package com.exp.ucmp.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MallReturnDto", description = "商城APP调用返回类")
public class MallReturnDto<T> {
	
	@ApiModelProperty(value = "响应代码")
	private String code;
	
	@ApiModelProperty(value = "响应信息")
	private String msg;
	
	@ApiModelProperty(value = "数据体")
	private T data;

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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
