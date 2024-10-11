package com.exp.ucmp.usc.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "EvaluationReturnDto", description = "urc返回类")
public class EvaluationReturnDto<T> {
	
	private String code;
	
    private T data;
    
    private String msg;
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
    
}
