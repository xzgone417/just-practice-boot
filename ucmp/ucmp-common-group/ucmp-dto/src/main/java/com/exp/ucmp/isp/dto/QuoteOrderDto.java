package com.exp.ucmp.isp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuoteOrderDto", description = "isp预估报价单实体类")
public class QuoteOrderDto {
	
	@ApiModelProperty(value = "UCMP的整备单号")
	private String ucmpOrderNo;
	
	@ApiModelProperty(value = "ISP的报价单号")
    private String quoteOrderNo;
	
	@ApiModelProperty(value = "预估交车时间")
    private String planCompleteDate;
	
	@ApiModelProperty(value = "维修项目数据")
    private List<QuoteProjectDto> projectList;

	public String getUcmpOrderNo() {
		return ucmpOrderNo;
	}

	public void setUcmpOrderNo(String ucmpOrderNo) {
		this.ucmpOrderNo = ucmpOrderNo;
	}

	public String getQuoteOrderNo() {
		return quoteOrderNo;
	}

	public void setQuoteOrderNo(String quoteOrderNo) {
		this.quoteOrderNo = quoteOrderNo;
	}

	public String getPlanCompleteDate() {
		return planCompleteDate;
	}

	public void setPlanCompleteDate(String planCompleteDate) {
		this.planCompleteDate = planCompleteDate;
	}

	public List<QuoteProjectDto> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<QuoteProjectDto> projectList) {
		this.projectList = projectList;
	}

}
