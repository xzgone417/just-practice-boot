package com.exp.ucmp.emdm.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ModelParamDto", description = "EMDM车型数据查询参数类")
public class ModelParamDto {

	@ApiModelProperty(value = "公告号")
	private String announcementCode;
	
	@ApiModelProperty(value = "业务级别：平台、车型、车型年、基础车型、销售车型")
    private String businessLevel;
	
	@ApiModelProperty(value = "描述")
    private String description;
	
	@ApiModelProperty(value = "是否可构建BOM:true可构建，false不可构建")
    private String isBomNode;
	
	@ApiModelProperty(value = "是否可配置:true可配置，false不可配置")
    private String isConfigNode;
	
	@ApiModelProperty(value = "是否销售车型:true是，false不是")
    private String isSaleModelNode;
	
	@ApiModelProperty(value = "编码")
    private String nodeCode;
	
	@ApiModelProperty(value = "名称")
    private String nodeName;
	
	@ApiModelProperty(value = "查询页数，默认第一页")
    private int pageIndex;
	
	@ApiModelProperty(value = "查询页条数限制，默认为10条")
    private int pageSize;
	
	@ApiModelProperty(value = "父编码")
    private String parentNodeCode;
	
	@ApiModelProperty(value = "首次投产工厂")
    private String plantName;
	
	@ApiModelProperty(value = "项目编码")
    private String projectCode;
	
	@ApiModelProperty(value = "简码")
    private String shortCode;
	
	@ApiModelProperty(value = "时间范围开始时间")
    private String startTime;
	
	@ApiModelProperty(value = "时间范围结束时间")
    private String endTime;
	
	@ApiModelProperty(value = "状态")
    private String status;
	
	@NotNull
	@ApiModelProperty(value = "调用系统名称")
    private String targetSysId;

	public String getAnnouncementCode() {
		return announcementCode;
	}

	public void setAnnouncementCode(String announcementCode) {
		this.announcementCode = announcementCode;
	}

	public String getBusinessLevel() {
		return businessLevel;
	}

	public void setBusinessLevel(String businessLevel) {
		this.businessLevel = businessLevel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsBomNode() {
		return isBomNode;
	}

	public void setIsBomNode(String isBomNode) {
		this.isBomNode = isBomNode;
	}

	public String getIsConfigNode() {
		return isConfigNode;
	}

	public void setIsConfigNode(String isConfigNode) {
		this.isConfigNode = isConfigNode;
	}

	public String getIsSaleModelNode() {
		return isSaleModelNode;
	}

	public void setIsSaleModelNode(String isSaleModelNode) {
		this.isSaleModelNode = isSaleModelNode;
	}

	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getParentNodeCode() {
		return parentNodeCode;
	}

	public void setParentNodeCode(String parentNodeCode) {
		this.parentNodeCode = parentNodeCode;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTargetSysId() {
		return targetSysId;
	}

	public void setTargetSysId(String targetSysId) {
		this.targetSysId = targetSysId;
	}
	
}
