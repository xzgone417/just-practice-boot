package com.exp.ucmp.huawei.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VoiceBundRelationDto", description = "绑定信息")
public class VoiceBundRelationDto {
	
	@ApiModelProperty(value = "请求中携带的app_key")
	private String app_key;
	
	@ApiModelProperty(value = "X号码绑定关系列表")
    private List<RelationNumDto> relationNumList;
	
	@ApiModelProperty(value = "查询的分页索引")
    private String pageIndex;
	
	@ApiModelProperty(value = "查询的分页大小")
    private String pageSize;
	
	@ApiModelProperty(value = "请求返回的结果码")
    private String resultcode;
	
	@ApiModelProperty(value = "查询结果的记录总数")
	private Integer totalCount;
	
	@ApiModelProperty(value = "操作结果描述")
	private String resultdesc;

	public String getApp_key() {
		return app_key;
	}

	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}

	public List<RelationNumDto> getRelationNumList() {
		return relationNumList;
	}

	public void setRelationNumList(List<RelationNumDto> relationNumList) {
		this.relationNumList = relationNumList;
	}

	public String getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getResultcode() {
		return resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getResultdesc() {
		return resultdesc;
	}

	public void setResultdesc(String resultdesc) {
		this.resultdesc = resultdesc;
	}
	
}
