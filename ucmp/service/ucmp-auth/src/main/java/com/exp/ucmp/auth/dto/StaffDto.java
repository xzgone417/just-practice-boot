package com.exp.ucmp.auth.dto;

import com.egrid.core.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StaffDto", description = "员工信息")
public class StaffDto extends BaseModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5509890868352694083L;
	@ApiModelProperty(value = "员工类型")
	private String staffType;
	@ApiModelProperty(value = "员工状态")
	private String staffStatus;
	@ApiModelProperty(value = "是否删除")
	private String staffIsDelete;
	@ApiModelProperty(value = "组织Id")
	private String orgId;
	@ApiModelProperty(value = "组织名称")
	private String orgName;
	@ApiModelProperty(value = "组织类型，门店和合作商类型不一样")
	private String orgType;
	@ApiModelProperty(value = "组织状态")
	private String orgStatus;
	@ApiModelProperty(value = "是否删除")
	private String orgIsDelete;
	
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public String getStaffStatus() {
		return staffStatus;
	}
	public void setStaffStatus(String staffStatus) {
		this.staffStatus = staffStatus;
	}
	public String getStaffIsDelete() {
		return staffIsDelete;
	}
	public void setStaffIsDelete(String staffIsDelete) {
		this.staffIsDelete = staffIsDelete;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getOrgStatus() {
		return orgStatus;
	}
	public void setOrgStatus(String orgStatus) {
		this.orgStatus = orgStatus;
	}
	public String getOrgIsDelete() {
		return orgIsDelete;
	}
	public void setOrgIsDelete(String isDelete) {
		this.orgIsDelete = isDelete;
	}
}
