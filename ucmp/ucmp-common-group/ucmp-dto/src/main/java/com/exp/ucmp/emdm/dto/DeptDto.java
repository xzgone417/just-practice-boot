package com.exp.ucmp.emdm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EmdmDeptReturnDto", description = "Emdm返回类")
public class DeptDto {

	@ApiModelProperty(value = "部门编码")
	private String hhrDeptCode;
	
	@ApiModelProperty(value = "状态")
    private String hhrStatus;
	
	@ApiModelProperty(value = "部门名称（中文）")
    private String hhrDeptZhName;
	
	@ApiModelProperty(value = "部门缩写（中文）")
    private String hhrDeptZhShortName;
	
	@ApiModelProperty(value = "部门名称（英文）")
    private String hhrDeptEnName;
	
	@ApiModelProperty(value = "部门缩写（英文）")
    private String hhrDeptEnShortName;
	
	@ApiModelProperty(value = "部门层级")
    private String hhrDeptLevel;
	
	@ApiModelProperty(value = "上级部门编码")
    private String hhrDeptHigherDept;
	
	@ApiModelProperty(value = "成本中心编码")
    private String hhrOrgDeptAttr02;
	
	@ApiModelProperty(value = "所属分部编码")
    private String hhrPartDept;
	
	@ApiModelProperty(value = "HR BP")
    private String hhrOrgDeptAttr09;
	
	@ApiModelProperty(value = "高级经理")
    private String hhrOrgDeptAttr06;
	
	@ApiModelProperty(value = "部门总监")
    private String hhrOrgDeptAttr05;
	
	@ApiModelProperty(value = "分管副总")
    private String hhrOrgDeptAttr08;
	
	@ApiModelProperty(value = "分管总裁")
    private String hhrOrgDeptAttr07;
	
	@ApiModelProperty(value = "总裁")
    private String hhrOrgDeptAttr10;
	
	@ApiModelProperty(value = "部门详情说明更新日期")
    private String hhrDeptDetailDesc;
	
	@ApiModelProperty(value = "更新日期")
    private String lastUpdateDate;
	
	@ApiModelProperty(value = "版本")
    private int version;

	public String getHhrDeptCode() {
		return hhrDeptCode;
	}

	public void setHhrDeptCode(String hhrDeptCode) {
		this.hhrDeptCode = hhrDeptCode;
	}

	public String getHhrStatus() {
		return hhrStatus;
	}

	public void setHhrStatus(String hhrStatus) {
		this.hhrStatus = hhrStatus;
	}

	public String getHhrDeptZhName() {
		return hhrDeptZhName;
	}

	public void setHhrDeptZhName(String hhrDeptZhName) {
		this.hhrDeptZhName = hhrDeptZhName;
	}

	public String getHhrDeptZhShortName() {
		return hhrDeptZhShortName;
	}

	public void setHhrDeptZhShortName(String hhrDeptZhShortName) {
		this.hhrDeptZhShortName = hhrDeptZhShortName;
	}

	public String getHhrDeptEnName() {
		return hhrDeptEnName;
	}

	public void setHhrDeptEnName(String hhrDeptEnName) {
		this.hhrDeptEnName = hhrDeptEnName;
	}

	public String getHhrDeptEnShortName() {
		return hhrDeptEnShortName;
	}

	public void setHhrDeptEnShortName(String hhrDeptEnShortName) {
		this.hhrDeptEnShortName = hhrDeptEnShortName;
	}

	public String getHhrDeptLevel() {
		return hhrDeptLevel;
	}

	public void setHhrDeptLevel(String hhrDeptLevel) {
		this.hhrDeptLevel = hhrDeptLevel;
	}

	public String getHhrDeptHigherDept() {
		return hhrDeptHigherDept;
	}

	public void setHhrDeptHigherDept(String hhrDeptHigherDept) {
		this.hhrDeptHigherDept = hhrDeptHigherDept;
	}

	public String getHhrOrgDeptAttr02() {
		return hhrOrgDeptAttr02;
	}

	public void setHhrOrgDeptAttr02(String hhrOrgDeptAttr02) {
		this.hhrOrgDeptAttr02 = hhrOrgDeptAttr02;
	}

	public String getHhrPartDept() {
		return hhrPartDept;
	}

	public void setHhrPartDept(String hhrPartDept) {
		this.hhrPartDept = hhrPartDept;
	}

	public String getHhrOrgDeptAttr09() {
		return hhrOrgDeptAttr09;
	}

	public void setHhrOrgDeptAttr09(String hhrOrgDeptAttr09) {
		this.hhrOrgDeptAttr09 = hhrOrgDeptAttr09;
	}

	public String getHhrOrgDeptAttr06() {
		return hhrOrgDeptAttr06;
	}

	public void setHhrOrgDeptAttr06(String hhrOrgDeptAttr06) {
		this.hhrOrgDeptAttr06 = hhrOrgDeptAttr06;
	}

	public String getHhrOrgDeptAttr05() {
		return hhrOrgDeptAttr05;
	}

	public void setHhrOrgDeptAttr05(String hhrOrgDeptAttr05) {
		this.hhrOrgDeptAttr05 = hhrOrgDeptAttr05;
	}

	public String getHhrOrgDeptAttr08() {
		return hhrOrgDeptAttr08;
	}

	public void setHhrOrgDeptAttr08(String hhrOrgDeptAttr08) {
		this.hhrOrgDeptAttr08 = hhrOrgDeptAttr08;
	}

	public String getHhrOrgDeptAttr07() {
		return hhrOrgDeptAttr07;
	}

	public void setHhrOrgDeptAttr07(String hhrOrgDeptAttr07) {
		this.hhrOrgDeptAttr07 = hhrOrgDeptAttr07;
	}

	public String getHhrOrgDeptAttr10() {
		return hhrOrgDeptAttr10;
	}

	public void setHhrOrgDeptAttr10(String hhrOrgDeptAttr10) {
		this.hhrOrgDeptAttr10 = hhrOrgDeptAttr10;
	}

	public String getHhrDeptDetailDesc() {
		return hhrDeptDetailDesc;
	}

	public void setHhrDeptDetailDesc(String hhrDeptDetailDesc) {
		this.hhrDeptDetailDesc = hhrDeptDetailDesc;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
