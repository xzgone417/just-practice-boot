package com.exp.ucmp.smp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SmpDataDto", description = "smp返回类")
public class SmpDataDto{
	
	@ApiModelProperty(value = "数据体")
    private List<SmpStoreDataDto> storeList;

	public List<SmpStoreDataDto> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<SmpStoreDataDto> storeList) {
		this.storeList = storeList;
	}
}
