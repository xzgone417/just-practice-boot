package com.exp.ucmp.isp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SiteQueryDto", description = "isp网点查询实体类")
public class SiteQueryDto {
	
	@ApiModelProperty(value = "网点类型-SC:直营服务中心,BP:授权IM,SP:第三方服务商,HH:高合总部,PS:驿站,AS:附件服务商,UC:用户中心")
	private List<String> siteTypes;
	
	@ApiModelProperty(value = "网点ID")
	private String siteId;
	
	@ApiModelProperty(value = "网点名称")
	private String siteName;
	
	@ApiModelProperty(value = "网点编码")
	private String siteCode;
	
	@ApiModelProperty(value = "营业状态 T:待营业 N:正常营业 S:停止营业")
	private String operatingStatus;
	
	@ApiModelProperty(value = "是否在C端展示 1-是，0-否")
	private int isCShow;
	
	@ApiModelProperty(value = "1-是，0-否")
	private int isReserve;

	public List<String> getSiteTypes() {
		return siteTypes;
	}

	public void setSiteTypes(List<String> siteTypes) {
		this.siteTypes = siteTypes;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getOperatingStatus() {
		return operatingStatus;
	}

	public void setOperatingStatus(String operatingStatus) {
		this.operatingStatus = operatingStatus;
	}

	public int getIsCShow() {
		return isCShow;
	}

	public void setIsCShow(int isCShow) {
		this.isCShow = isCShow;
	}

	public int getIsReserve() {
		return isReserve;
	}

	public void setIsReserve(int isReserve) {
		this.isReserve = isReserve;
	}

}
