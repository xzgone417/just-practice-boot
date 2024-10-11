package com.exp.ucmp.eos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReservationParamDto", description = "置换单查询参数类")
public class ReservationParamDto {
	
	@ApiModelProperty(value = "URM的U-ID")
	private String uid;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
}
