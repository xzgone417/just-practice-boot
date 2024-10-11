package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SmpCarInfoReturnDto", description = "smp车辆信息返回类")
public class SmpCarInfoReturnDto {
	
	@ApiModelProperty(value = "状态码")
	private String code;
	
	@ApiModelProperty(value = "信息描述")
    private String msg;
	
	@ApiModelProperty(value = "数据体")
    private CarInfoDto data;

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

	public CarInfoDto getData() {
		return data;
	}

	public void setData(CarInfoDto data) {
		this.data = data;
	}

}
