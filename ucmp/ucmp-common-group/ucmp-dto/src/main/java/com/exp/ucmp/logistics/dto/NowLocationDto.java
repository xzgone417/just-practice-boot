package com.exp.ucmp.logistics.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "NowLocationDto", description = "当前地址集合")
public class NowLocationDto {
	
	@ApiModelProperty(value = "当前地址")
    private String nowLocation;
	
	@ApiModelProperty(value = "过点时间")
    private String operateTime;

	public String getNowLocation() {
		return nowLocation;
	}

	public void setNowLocation(String nowLocation) {
		this.nowLocation = nowLocation;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}


}
