package com.exp.ucmp.emdm.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AreaDataDto", description = "行政区DATA")
public class AreaDataDto {
	
	@ApiModelProperty(value = "行政区总数量")
	private Integer total;
	
	@ApiModelProperty(value = "数据集合")
	private List<AreaDto> records;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<AreaDto> getRecords() {
		return records;
	}

	public void setRecords(List<AreaDto> records) {
		this.records = records;
	}
	
}
