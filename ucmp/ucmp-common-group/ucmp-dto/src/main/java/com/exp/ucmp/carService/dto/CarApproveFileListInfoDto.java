package com.exp.ucmp.carService.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "CarApproveFileListInfoDto", description = "车辆图片审批列表信息Dto")
public class CarApproveFileListInfoDto {

    private static final long serialVersionUID = 1L;

    /**
     * 整备信息id
     */
    @ApiModelProperty(value = "整备信息id")
    private String serviceId;

    /**
     * 整备单号
     */
    @ApiModelProperty(value = "整备单号")
    private String serviceNumber;

    /**
     * 仓储点名称
     */
    @ApiModelProperty(value = "仓储点名称")
    private String storageName;

    /**
     * 车辆来源
     */
    @ApiModelProperty(value = "车辆来源")
    private String carSource;
    /**
     * 车源批次
     */
    @ApiModelProperty(value = "车源批次")
    private String sourceBatch;

    /**
     * VIN
     */
    @ApiModelProperty(value = "VIN")
    private String vinCode;

    /**
     * 归属主体
     */
    @ApiModelProperty(value = "归属主体")
    private String revertBody;

    /**
     * 决策类型
     */
    @ApiModelProperty(value = "决策类型")
    private String decisionType;

    /**
     * 服务点
     */
    @ApiModelProperty(value = "服务点")
    private String servicePlace;

    /**
     * 整备发起人
     */
    @ApiModelProperty(value = "整备发起人")
    private String startPeople;

    /**
     * 整备验收入库人id
     */
    @ApiModelProperty(value = "整备验收入库人id")
    private String warehousPeopleId;

    /**
     * 整备验收入库人
     */
    @ApiModelProperty(value = "整备验收入库人")
    private String warehousPeople;

    /**
     * 整备入库时间
     */
    @ApiModelProperty(value = "整备入库时间")
    private Date warehousDate;

    /**
     * 工程车型名称
     */
    @ApiModelProperty(value = "工程车型名称")
    private String carSeriesName;

    /**
     * 基础车型名称
     */
    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;

    /**
     * 外色
     */
    @ApiModelProperty(value = "外色")
    private String carColour;

    /**
     * 外色
     */
    @ApiModelProperty(value = "审批时间")
    private Date approvalDate;
    
    @ApiModelProperty(value = "整备发起时间")
    private String startDate;
    
    @ApiModelProperty(value = "车辆所在城市")
    private String city;
    
    @ApiModelProperty(value = "整备状态")
    private String serviceState;
    
    @ApiModelProperty(value = "整备状态名称")
    private String serviceStateName;

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getCarSource() {
        return carSource;
    }

    public void setCarSource(String carSource) {
        this.carSource = carSource;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getSourceBatch() {
        return sourceBatch;
    }

    public void setSourceBatch(String sourceBatch) {
        this.sourceBatch = sourceBatch;
    }

    public String getRevertBody() {
        return revertBody;
    }

    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }

    public String getStartPeople() {
        return startPeople;
    }

    public void setStartPeople(String startPeople) {
        this.startPeople = startPeople;
    }


    public String getCarSeriesName() {
        return carSeriesName;
    }

    public void setCarSeriesName(String carSeriesName) {
        this.carSeriesName = carSeriesName;
    }

    public String getBaseCarTypeName() {
        return baseCarTypeName;
    }

    public void setBaseCarTypeName(String baseCarTypeName) {
        this.baseCarTypeName = baseCarTypeName;
    }

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }

    public String getServicePlace() {
        return servicePlace;
    }

    public void setServicePlace(String servicePlace) {
        this.servicePlace = servicePlace;
    }

    public String getWarehousPeopleId() {
        return warehousPeopleId;
    }

    public void setWarehousPeopleId(String warehousPeopleId) {
        this.warehousPeopleId = warehousPeopleId;
    }

    public String getWarehousPeople() {
        return warehousPeople;
    }

    public void setWarehousPeople(String warehousPeople) {
        this.warehousPeople = warehousPeople;
    }

    public Date getWarehousDate() {
        return warehousDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public void setWarehousDate(Date warehousDate) {
        this.warehousDate = warehousDate;
    }

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getServiceState() {
		return serviceState;
	}

	public void setServiceState(String serviceState) {
		this.serviceState = serviceState;
	}

	public String getServiceStateName() {
		return serviceStateName;
	}

	public void setServiceStateName(String serviceStateName) {
		this.serviceStateName = serviceStateName;
	}
}
