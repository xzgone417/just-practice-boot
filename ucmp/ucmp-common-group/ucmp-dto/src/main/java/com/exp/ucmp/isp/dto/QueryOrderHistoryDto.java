package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QueryOrderHistoryDto", description = "查询维修历史数据参数类")
public class QueryOrderHistoryDto {
	
	@ApiModelProperty(value = "vin.支持模糊查询，必传")
	private String vin;
	
	@ApiModelProperty(value = "页码")
    private int pageNum;
	
	@ApiModelProperty(value = "分页条数")
    private int pageSize;
	
	@ApiModelProperty(value = "工单类型 1 维修工单 2 整备工单")
	private int workOrderType;
	
	@ApiModelProperty(value = "关键字")
	private String keyword;
	
	@ApiModelProperty(value = "是否去重 0 去重 1 不去重")
	private int isDuplicateRemoval;
	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getWorkOrderType() {
		return workOrderType;
	}

	public void setWorkOrderType(int workOrderType) {
		this.workOrderType = workOrderType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getIsDuplicateRemoval() {
		return isDuplicateRemoval;
	}

	public void setIsDuplicateRemoval(int isDuplicateRemoval) {
		this.isDuplicateRemoval = isDuplicateRemoval;
	}
	
}
