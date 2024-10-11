package com.exp.ucmp.urm.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UrmDataDto", description = "urm返回数据类")
public class UrmDataDto {
	
	@ApiModelProperty(value = "数据条数")
	private int total;
	
	@ApiModelProperty(value = "用户数据集合")
    private List<UserDto> dataList;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<UserDto> getDataList() {
		return dataList;
	}

	public void setDataList(List<UserDto> dataList) {
		this.dataList = dataList;
	}
}
