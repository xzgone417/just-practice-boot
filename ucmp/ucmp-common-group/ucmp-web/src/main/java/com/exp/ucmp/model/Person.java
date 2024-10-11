package com.exp.ucmp.model;

import com.egrid.core.shiro.model.User;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 自然人
 * @author yiyongfei
 *
 */
@ApiModel(value = "Person", description = "人员信息")
public class Person extends User {
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "人员姓名")
	protected String personName;
	@ApiModelProperty(value = "登录名称")
	protected String loginName;
	@ApiModelProperty(value = "机构名称")
	protected String organName;
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "区域标识")
	protected String areaId;
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "角色标识")
	protected String roleId;

	@ApiModelProperty(value = "扩展信息")
	protected Object extendInfo;

	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
	public Object getExtendInfo() {
		return extendInfo;
	}
	public void setExtendInfo(Object extendInfo) {
		this.extendInfo = extendInfo;
	}
}

