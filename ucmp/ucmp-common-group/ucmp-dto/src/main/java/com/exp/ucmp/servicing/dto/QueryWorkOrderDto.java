/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.servicing.dto;

import com.exp.ucmp.isp.dto.IspOrderHistoryDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


@ApiModel(value = "QueryWorkOrderDto", description = "历史维修项目返回类")
public class QueryWorkOrderDto {

	@ApiModelProperty(value = "总条数")
	private int total;
	
	@ApiModelProperty(value = "")
    private List<IspOrderHistoryDto> list;
	
	@ApiModelProperty(value = "页码")
    private int pageNum;
	
	@ApiModelProperty(value = "每页条数")
    private int pageSize;
	
	@ApiModelProperty(value = "总页数")
    private int pages;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<IspOrderHistoryDto> getList() {
		return list;
	}

	public void setList(List<IspOrderHistoryDto> list) {
		this.list = list;
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

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
}
