/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.stock.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SaveMaintenceParamDto", description = "保存维修项目信息参数")
public class SaveMaintenceParamDto {

    @ApiModelProperty(value = "库存车辆ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stockId;

    @ApiModelProperty(value = "vin")
    private String vinCode;

    @ApiModelProperty(value = "项目编号")
    private String projectNo;

    @ApiModelProperty(value = "项目名称")
    private String projectName;
    
    @ApiModelProperty(value = "配件编号")
    private String partCode;
    
    @ApiModelProperty(value = "配件名称")
    private String partName;
    
    @ApiModelProperty(value = "维修时间戳")
    private Long workOrderTime;
    
    @ApiModelProperty(value = "收费类型")
    private String feeType;
    
    @ApiModelProperty(value = "收费类型名称")
    private String feeTypeLabel;

    @ApiModelProperty(value = "收费类型")
    private String collectFees;
    
    @ApiModelProperty(value = "收费类型名称")
    private String collectFeesName;
    
    @ApiModelProperty(value = "维修类型(001维修工单项目002整备工单项目)")
    private String maintainType;

    @ApiModelProperty(value = "维修时间")
    private String maintainTime;

    @ApiModelProperty(value = "不用传(返回的维修日期)")
    private String times;

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPartCode() {
		return partCode;
	}

	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public Long getWorkOrderTime() {
		return workOrderTime;
	}

	public void setWorkOrderTime(Long workOrderTime) {
		this.workOrderTime = workOrderTime;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getFeeTypeLabel() {
		return feeTypeLabel;
	}

	public void setFeeTypeLabel(String feeTypeLabel) {
		this.feeTypeLabel = feeTypeLabel;
	}

	public String getCollectFees() {
        return collectFees;
    }

    public void setCollectFees(String collectFees) {
        this.collectFees = collectFees;
    }

	public String getCollectFeesName() {
		return collectFeesName;
	}

	public void setCollectFeesName(String collectFeesName) {
		this.collectFeesName = collectFeesName;
	}

	public String getMaintainType() {
        return maintainType;
    }

    public void setMaintainType(String maintainType) {
        this.maintainType = maintainType;
    }

    public String getMaintainTime() {
        return maintainTime;
    }

    public void setMaintainTime(String maintainTime) {
        this.maintainTime = maintainTime;
    }

}
