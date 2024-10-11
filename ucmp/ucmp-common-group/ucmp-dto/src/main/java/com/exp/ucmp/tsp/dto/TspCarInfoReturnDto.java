package com.exp.ucmp.tsp.dto;

import com.exp.ucmp.car.dto.TspBasicsCarInfoDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TspCarInfoReturnDto", description = "tsp车辆信息返回类")
public class TspCarInfoReturnDto {
	
	@ApiModelProperty(value = "状态码")
	private String code;
	
	@ApiModelProperty(value = "车辆信息")
    private TspBasicsCarInfoDto data;
	
	@ApiModelProperty(value = "状态信息")
    private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TspBasicsCarInfoDto getData() {
		return data;
	}

	public void setData(TspBasicsCarInfoDto data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
