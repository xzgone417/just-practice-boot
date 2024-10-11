package com.exp.ucmp.carService.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QueryServiceParamDto", description = "整备列表查询Dto")
public class QueryServiceParamDto extends PageDto {

    private static final long serialVersionUID = 1L;

    /**
     * 整备单号
     */
    @ApiModelProperty(value = "整备单号")
    private String serviceNumber;

    /**
     * 整备发起人
     */
    @ApiModelProperty(value = "整备发起人")
    private String startPeople;


    /**
     * 整备发起开始时间
     */
    @ApiModelProperty(value = "整备发起开始时间")
    private String startDate;

    /**
     * 整备发起结束时间
     */
    @ApiModelProperty(value = "整备发起结束时间")
    private String endDate;

    /**
     * VIN
     */
    @ApiModelProperty(value = "VIN")
    private String vinCode;


    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库id")
    private Long storageId;
    
    /**
     * 整备单状态(5301:待反馈 5302:已反馈-待审批 5303:已通过-施工中 5304:有增项-待审批 5306:实施完成-待验收 5307:驳回 5308:放弃整备-转批售 5309:取消整备 5310:审批通过 5311:反结算)
     */
    @ApiModelProperty(value = "整备单状态(5301:待反馈 5302:已反馈-待审批 5303:已通过-施工中 5304:有增项-待审批 5306:实施完成-待验收 5307:驳回 5308:放弃整备-转批售 5309:取消整备 5310:审批通过 5311:反结算)")
    private String serviceState;
    
    @ApiModelProperty(value = "是否反结算 1 否 2是")
    private int isSettlement;

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getStartPeople() {
        return startPeople;
    }

    public void setStartPeople(String startPeople) {
        this.startPeople = startPeople;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public Long getStorageId() {
		return storageId;
	}

	public void setStorageId(Long storageId) {
		this.storageId = storageId;
	}

	public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

	public int getIsSettlement() {
		return isSettlement;
	}

	public void setIsSettlement(int isSettlement) {
		this.isSettlement = isSettlement;
	}
}
