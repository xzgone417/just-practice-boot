/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.servicing.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "WorkOrderCommonDto", description = "车辆维修历史数据")
public class WorkOrderCommonDto {
	
	@ApiModelProperty(value = "维修日期")
    private Long createTime;
	
	@ApiModelProperty(value = "维修日期")
    private String createTimeStr;
	
	@ApiModelProperty(value = "工单号")
    private String workOrderNo;
	
	@ApiModelProperty(value = "维修里程")
    private long inMileage;
	
	@ApiModelProperty(value = "维修金额")
    private Double lastMoney;
	
	@ApiModelProperty(value = "维修地点")
    private String innerCustomerCode;
	
	@ApiModelProperty(value = "维修类型")
    private String maintenanceTypeLabel;

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public long getInMileage() {
		return inMileage;
	}

	public void setInMileage(long inMileage) {
		this.inMileage = inMileage;
	}

	public Double getLastMoney() {
		return lastMoney;
	}

	public void setLastMoney(Double lastMoney) {
		this.lastMoney = lastMoney;
	}

	public String getInnerCustomerCode() {
		return innerCustomerCode;
	}

	public void setInnerCustomerCode(String innerCustomerCode) {
		this.innerCustomerCode = innerCustomerCode;
	}

	public String getMaintenanceTypeLabel() {
		return maintenanceTypeLabel;
	}

	public void setMaintenanceTypeLabel(String maintenanceTypeLabel) {
		this.maintenanceTypeLabel = maintenanceTypeLabel;
	}
	
}
