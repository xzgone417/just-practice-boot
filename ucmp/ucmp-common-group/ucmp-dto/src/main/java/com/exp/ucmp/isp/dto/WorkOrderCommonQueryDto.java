package com.exp.ucmp.isp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "WorkOrderCommonQueryDto", description = "isp维修历史查询参数类")
public class WorkOrderCommonQueryDto {
	
	@ApiModelProperty(value = "页码")
	private String pageNum;
	
	@ApiModelProperty(value = "分页条数")
	private String pageSize;
	
	@ApiModelProperty(value = "vin.支持模糊查询，必传")
	private String vin;
	
	@ApiModelProperty(value = "网点编码")
	private String siteCode;
	
	@ApiModelProperty(value = "订单类型 11850090:To C,11850095: To B,11850110: 负工单")
	private List<Integer> orderTypes;
	
	@ApiModelProperty(value = "维修类型  sgwx:事故维修,shwx:售后维修,sqwx:售前维修,jcd:检测单")
	private List<String> maintenanceTypes;
	
	@ApiModelProperty(value = "工单号")
	private String workOrderNo;
	
	@ApiModelProperty(value = "工单来源,ISP,UC,B-APP,UCMP;UCMP为整备工单")
	private List<String> workOrderFlags;

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
	
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public List<Integer> getOrderTypes() {
		return orderTypes;
	}

	public void setOrderTypes(List<Integer> orderTypes) {
		this.orderTypes = orderTypes;
	}

	public List<String> getMaintenanceTypes() {
		return maintenanceTypes;
	}

	public void setMaintenanceTypes(List<String> maintenanceTypes) {
		this.maintenanceTypes = maintenanceTypes;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public List<String> getWorkOrderFlags() {
		return workOrderFlags;
	}

	public void setWorkOrderFlags(List<String> workOrderFlags) {
		this.workOrderFlags = workOrderFlags;
	}

}
