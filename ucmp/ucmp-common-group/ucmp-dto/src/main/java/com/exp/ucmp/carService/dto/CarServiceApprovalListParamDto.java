package com.exp.ucmp.carService.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "CarServiceApprovalListParamDto", description = "整备审批列表查询Dto")
public class CarServiceApprovalListParamDto extends PageDto {

    private static final long serialVersionUID = 1L;

    /**
     * 整备单号
     */
    @ApiModelProperty(value = "整备单号")
    private String serviceNumber;

    /**
     * 工单号
     */
    @ApiModelProperty(value = "工单号")
    private String singleNumber;

    /**
     * 整备发起人
     */
    @ApiModelProperty(value = "整备发起人")
    private String startPeople;


    /**
     * 整备发起开始时间
     */
    @ApiModelProperty(value = "整备发起开始时间")
    private Date startDate;

    /**
     * 整备发起结束时间
     */
    @ApiModelProperty(value = "整备发起结束时间")
    private Date endDate;

    /**
     * VIN
     */
    @ApiModelProperty(value = "VIN")
    private String vinCode;


    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库编码")
    private String storageCode;
    /**
     * 整备单状态(5301:待反馈 5302:已反馈待审批 5303:已通过-待生成工单 5304:已生成工单-待实施 5305:实施完成 5306:已验收入库 5307:驳回 5308:放弃整备-转批售 5309:取消整备)
     */
    @ApiModelProperty(value = "整备单状态(5301:待反馈 5302:已反馈待审批 5303:已通过-待生成工单 5304:已生成工单-待实施 5305:实施完成 5306:已验收入库 5307:驳回 5308:放弃整备-转批售 5309:取消整备)")
    private String serviceState;

    /**
     * 选项卡状态(前端不用传)
     */
    @ApiModelProperty(value = "选项卡状态(前端不用传)")
    private String[] tabState;
    
    @ApiModelProperty(value = "tab页类型(1:维修项目反馈/2:维修工单反馈)")
    private Integer type; 

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(String singleNumber) {
        this.singleNumber = singleNumber;
    }

    public String getServiceState() {
        return serviceState;
    }

    public String[] getTabState() {
        return tabState;
    }

    public void setTabState(String[] tabState) {
        this.tabState = tabState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
    
}
