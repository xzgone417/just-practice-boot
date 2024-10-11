package com.exp.ucmp.isp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuoteProjecDto", description = "isp预估报价单维修项目实体类")
public class QuoteProjectDto {
	
	@ApiModelProperty(value = "维修项目id")
	private Long projectId;
	
	@ApiModelProperty(value = "报价单id")
	private Long quoteOrderId;
	
	@ApiModelProperty(value = "维修项目类型代码")
	private String repairProjectTypeCode;
	
	@ApiModelProperty(value = "维修项目类型")
    private String repairProjectType;
	
	@ApiModelProperty(value = "维修项目代码")
    private String repairProjectCode;
	
	@ApiModelProperty(value = "维修项目")
    private String repairProjectName;
	
	@ApiModelProperty(value = "维修工时费用")
    private Double timePrice;
	
	@ApiModelProperty(value = "收费区分")
    private String differentiate;
	
	@ApiModelProperty(value = "收费区分代码")
    private String differentiateCode;
	
	@ApiModelProperty(value = "是否维修(0 是 1 否)")
	private Integer isRepair;
	
	@ApiModelProperty(value = "驳回原因")
	private String rejectReasons;
	
	@ApiModelProperty(value = "维修配件集合")
    private List<QuoteComponentDto> componentList;
	
	@ApiModelProperty(value = "其他费用数据")
    private List<QuoteOtherFeesDto> otherFeesList;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getQuoteOrderId() {
		return quoteOrderId;
	}

	public void setQuoteOrderId(Long quoteOrderId) {
		this.quoteOrderId = quoteOrderId;
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

	public String getRepairProjectName() {
		return repairProjectName;
	}

	public void setRepairProjectName(String repairProjectName) {
		this.repairProjectName = repairProjectName;
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

	public Integer getIsRepair() {
		return isRepair;
	}

	public void setIsRepair(Integer isRepair) {
		this.isRepair = isRepair;
	}

	public String getRejectReasons() {
		return rejectReasons;
	}

	public void setRejectReasons(String rejectReasons) {
		this.rejectReasons = rejectReasons;
	}

	public List<QuoteComponentDto> getComponentList() {
		return componentList;
	}

	public void setComponentList(List<QuoteComponentDto> componentList) {
		this.componentList = componentList;
	}

	public List<QuoteOtherFeesDto> getOtherFeesList() {
		return otherFeesList;
	}

	public void setOtherFeesList(List<QuoteOtherFeesDto> otherFeesList) {
		this.otherFeesList = otherFeesList;
	}

}
