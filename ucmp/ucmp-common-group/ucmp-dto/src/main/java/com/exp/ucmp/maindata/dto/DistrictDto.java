package com.exp.ucmp.maindata.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DistrictDto", description = "区县实体类")
public class DistrictDto {
	
	@ApiModelProperty(value = "区县编码")
	private String districtId;
	
	@ApiModelProperty(value = "区县名称")
    private String districtName;

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
}
