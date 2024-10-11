package com.exp.ucmp.emdm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AreaDto", description = "省市区")
public class AreaDto {

	@ApiModelProperty(value = "省市区编码")
	private String areaCode;
	
	@ApiModelProperty(value = "省市区编码名称")
    private String areaName;
	
	@ApiModelProperty(value = "电话区号")
    private String cityCode;
	
	@ApiModelProperty(value = "省市区级别")
    private String areaLevel;
	
	@ApiModelProperty(value = "数据来源")
    private String areaSource;
	
	@ApiModelProperty(value = "中心点坐标")
    private String areaCenter;
	
	@ApiModelProperty(value = "上级省市区编码")
    private String parentAreaCode;
	
	@ApiModelProperty(value = "是否可用")
    private String isAvailable;
	
	@ApiModelProperty(value = "更新日期")
    private String lastUpdateDate;
	
	@ApiModelProperty(value = "备注")
    private String comment;
	
	@ApiModelProperty(value = "省市区别名")
    private int version;
	
	@ApiModelProperty(value = "省市区别名")
    private String areaAlias;
    
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getAreaLevel() {
		return areaLevel;
	}
	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}
	public String getAreaSource() {
		return areaSource;
	}
	public void setAreaSource(String areaSource) {
		this.areaSource = areaSource;
	}
	public String getAreaCenter() {
		return areaCenter;
	}
	public void setAreaCenter(String areaCenter) {
		this.areaCenter = areaCenter;
	}
	public String getParentAreaCode() {
		return parentAreaCode;
	}
	public void setParentAreaCode(String parentAreaCode) {
		this.parentAreaCode = parentAreaCode;
	}
	public String getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getAreaAlias() {
		return areaAlias;
	}
	public void setAreaAlias(String areaAlias) {
		this.areaAlias = areaAlias;
	}
}

