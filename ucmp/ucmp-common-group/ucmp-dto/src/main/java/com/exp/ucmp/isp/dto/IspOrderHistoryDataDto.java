package com.exp.ucmp.isp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IspQuoteApplyReturnDto", description = "isp报价单申请返回类")
public class IspOrderHistoryDataDto {
	
	@ApiModelProperty(value = "总条数")
	private int total;
	
	@ApiModelProperty(value = "维修数据集合")
    private List<IspOrderHistoryDto> list;
	
	@ApiModelProperty(value = "页码")
    private int pageNum;
	
	@ApiModelProperty(value = "每页条数")
    private int pageSize;
	
	@ApiModelProperty(value = "")
    private int size;
	
	@ApiModelProperty(value = "行游标-开始")
    private int startRow;
	
	@ApiModelProperty(value = "行游标-截止")
    private int endRow;
	
	@ApiModelProperty(value = "总页数")
    private int pages;
	
	@ApiModelProperty(value = "")
    private int prePage;
	
	@ApiModelProperty(value = "下一页页码")
    private int nextPage;
	
	@ApiModelProperty(value = "是否是第一页")
    private boolean isFirstPage;
	
	@ApiModelProperty(value = "是否是最后一页")
    private boolean isLastPage;
	
	@ApiModelProperty(value = "")
    private boolean hasPreviousPage;
	
	@ApiModelProperty(value = "是否有下一页")
    private boolean hasNextPage;
	
	@ApiModelProperty(value = "")
    private int navigatePages;
	
	@ApiModelProperty(value = "")
    private List<Integer> navigatepageNums;
	
	@ApiModelProperty(value = "")
    private int navigateFirstPage;
	
	@ApiModelProperty(value = "")
    private int navigateLastPage;

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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getNavigatePages() {
		return navigatePages;
	}

	public void setNavigatePages(int navigatePages) {
		this.navigatePages = navigatePages;
	}

	public List<Integer> getNavigatepageNums() {
		return navigatepageNums;
	}

	public void setNavigatepageNums(List<Integer> navigatepageNums) {
		this.navigatepageNums = navigatepageNums;
	}

	public int getNavigateFirstPage() {
		return navigateFirstPage;
	}

	public void setNavigateFirstPage(int navigateFirstPage) {
		this.navigateFirstPage = navigateFirstPage;
	}

	public int getNavigateLastPage() {
		return navigateLastPage;
	}

	public void setNavigateLastPage(int navigateLastPage) {
		this.navigateLastPage = navigateLastPage;
	}

}
