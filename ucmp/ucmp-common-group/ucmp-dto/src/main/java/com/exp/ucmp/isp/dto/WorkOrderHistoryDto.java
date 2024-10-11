package com.exp.ucmp.isp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WorkOrderHistoryDto", description = "isp维修配件查询参数类")
public class WorkOrderHistoryDto {
	
	@ApiModelProperty(value = "vin.支持模糊查询，必传")
	private String vin;
	
	@ApiModelProperty(value = "页码")
    private String pageNum;
	
	@ApiModelProperty(value = "分页条数")
    private String pageSize;
	
	@ApiModelProperty(value = "工单来源,ISP,UC,B-APP,UCMP;UCMP为整备工单")
	private List<String> workOrderFlags;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public List<String> getWorkOrderFlags() {
		return workOrderFlags;
	}

	public void setWorkOrderFlags(List<String> workOrderFlags) {
		this.workOrderFlags = workOrderFlags;
	}

}
