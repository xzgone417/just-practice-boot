package com.exp.ucmp.smp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PdiDto", description = "PDI单")
public class PdiDto {
	
	@ApiModelProperty(value = "PDI单ID")
	private String pdiId;
	
	@ApiModelProperty(value = "PDI状态 1:PDI OK,2:PDI NOT OK,3:PDI HOLD")
    private String pdiStatus;
	
	@ApiModelProperty(value = "PDI开始时间")
    private String pdiStartDate;
	
	@ApiModelProperty(value = "异常处理等级 1:L1,3:L2,5:L3,7:L4,9:L5")
    private String exceptionLevel;
	
	@ApiModelProperty(value = "风险等级 1:H1,2:H2,3:H3,4:H4")
    private String riskLevel;
	
	@ApiModelProperty(value = "PDI状态操作人")
    private String pdiEmpId;
	
	@ApiModelProperty(value = "说明")
    private String remark;
	
	@ApiModelProperty(value = "是否完成检测")
    private String isDetect;
	
	@ApiModelProperty(value = "检测操作人ID")
    private String detectEmpId;
	
	@ApiModelProperty(value = "检测完成时间")
    private String detectDate;
	
	@ApiModelProperty(value = "是否维修 0:否,1:是")
    private String isService;
	
	@ApiModelProperty(value = "维修状态 1:未展开,2:维修中,3:已完成")
    private String serviceStatus;
	
	@ApiModelProperty(value = "维修完成时间")
    private String serviceDate;
	
	@ApiModelProperty(value = "PDI单项目List")
    private List<PdiItemDto> pdiItemList;

	public String getPdiId() {
		return pdiId;
	}

	public void setPdiId(String pdiId) {
		this.pdiId = pdiId;
	}

	public String getPdiStatus() {
		return pdiStatus;
	}

	public void setPdiStatus(String pdiStatus) {
		this.pdiStatus = pdiStatus;
	}

	public String getPdiStartDate() {
		return pdiStartDate;
	}

	public void setPdiStartDate(String pdiStartDate) {
		this.pdiStartDate = pdiStartDate;
	}

	public String getExceptionLevel() {
		return exceptionLevel;
	}

	public void setExceptionLevel(String exceptionLevel) {
		this.exceptionLevel = exceptionLevel;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getPdiEmpId() {
		return pdiEmpId;
	}

	public void setPdiEmpId(String pdiEmpId) {
		this.pdiEmpId = pdiEmpId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsDetect() {
		return isDetect;
	}

	public void setIsDetect(String isDetect) {
		this.isDetect = isDetect;
	}

	public String getDetectEmpId() {
		return detectEmpId;
	}

	public void setDetectEmpId(String detectEmpId) {
		this.detectEmpId = detectEmpId;
	}

	public String getDetectDate() {
		return detectDate;
	}

	public void setDetectDate(String detectDate) {
		this.detectDate = detectDate;
	}

	public String getIsService() {
		return isService;
	}

	public void setIsService(String isService) {
		this.isService = isService;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(String serviceDate) {
		this.serviceDate = serviceDate;
	}

	public List<PdiItemDto> getPdiItemList() {
		return pdiItemList;
	}

	public void setPdiItemList(List<PdiItemDto> pdiItemList) {
		this.pdiItemList = pdiItemList;
	}
	
}
