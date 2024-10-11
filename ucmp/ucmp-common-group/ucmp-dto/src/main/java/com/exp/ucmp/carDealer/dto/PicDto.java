package com.exp.ucmp.carDealer.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PicDto", description = "图片")
public class PicDto {
	
	@ApiModelProperty(value = "文件ID")
	private Long materialId;
	
	@ApiModelProperty(value = "材料类型")
	private String materialType;

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public String getMaterialType() {
		return materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
}
