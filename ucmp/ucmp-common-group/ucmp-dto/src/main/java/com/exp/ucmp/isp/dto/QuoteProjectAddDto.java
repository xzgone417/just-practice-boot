package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuoteProjectAddDto", description = "添加预估报价单维修项目实体类")
public class QuoteProjectAddDto {
	
	@ApiModelProperty(value = "整备报价单id")
	private Long quoteOrderId;
	
	@ApiModelProperty(value = "维修项目id")
	private Long projectId;
	
	@ApiModelProperty(value = "维修项目类型代码")
	private String repairProjectTypeCode;
	
	@ApiModelProperty(value = "维修项目类型")
    private String repairProjectType;
	
	@ApiModelProperty(value = "维修项目代码")
    private String repairProjectCode;
	
	@ApiModelProperty(value = "维修项目")
    private String repairProject;
	
	@ApiModelProperty(value = "维修工时费用")
    private Double timePrice;
	
	@ApiModelProperty(value = "收费区分")
    private String differentiate;
	
	@ApiModelProperty(value = "收费区分代码")
    private String differentiateCode;
	
	@ApiModelProperty(value = "是否有配件(0 是 1 否)")
    private int isComponent;
	
	@ApiModelProperty(value = "是否有其他费用 0 有 1 没有")
    private int isOther;
	
	@ApiModelProperty(value = "创建人")
	private Long createdBy;
	
	@ApiModelProperty(value = "更新人")
	private Long updateBy;

	public Long getQuoteOrderId() {
		return quoteOrderId;
	}

	public void setQuoteOrderId(Long quoteOrderId) {
		this.quoteOrderId = quoteOrderId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getRepairProjectTypeCode() {
		return repairProjectTypeCode;
	}

	public void setRepairProjectTypeCode(String repairProjectTypeCode) {
		this.repairProjectTypeCode = repairProjectTypeCode;
	}

	public String getRepairProjectType() {
		return repairProjectType;
	}

	public void setRepairProjectType(String repairProjectType) {
		this.repairProjectType = repairProjectType;
	}

	public String getRepairProjectCode() {
		return repairProjectCode;
	}

	public void setRepairProjectCode(String repairProjectCode) {
		this.repairProjectCode = repairProjectCode;
	}

	public String getRepairProject() {
		return repairProject;
	}

	public void setRepairProject(String repairProject) {
		this.repairProject = repairProject;
	}

	public Double getTimePrice() {
		return timePrice;
	}

	public void setTimePrice(Double timePrice) {
		this.timePrice = timePrice;
	}

	public String getDifferentiate() {
		return differentiate;
	}

	public void setDifferentiate(String differentiate) {
		this.differentiate = differentiate;
	}

	public String getDifferentiateCode() {
		return differentiateCode;
	}

	public void setDifferentiateCode(String differentiateCode) {
		this.differentiateCode = differentiateCode;
	}

	public int getIsComponent() {
		return isComponent;
	}

	public void setIsComponent(int isComponent) {
		this.isComponent = isComponent;
	}

	public int getIsOther() {
		return isOther;
	}

	public void setIsOther(int isOther) {
		this.isOther = isOther;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

}
