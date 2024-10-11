package com.exp.ucmp.emdm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PersonDto", description = "人员属性")
public class PersonDto {

	@ApiModelProperty(value = "人员编号")
	private String hhrEmpid;
	
	@ApiModelProperty(value = "旧工号")
	private String hhrOtherContact;
	
	@ApiModelProperty(value = "iscPersonId")
	private String iscPersonId;
	
	@ApiModelProperty(value = "姓名")
	private String hhrName;
	
	@ApiModelProperty(value = "英文名")
	private String hhrOtherName;
	
	@ApiModelProperty(value = "性别:M:男，F:女")
	private String hhrGender;
	
	@ApiModelProperty(value = "手机号")
	private String hhrPhoneNum;
	
	@ApiModelProperty(value = "入职日期")
	private String hhrLastHireDate;
	
	@ApiModelProperty(value = "离职日期")
	private String hhrLastDateWorked;
	
	@ApiModelProperty(value = "账号有效期")
	private String hhrEndDate;
	
	@ApiModelProperty(value = "任职记录号")
	private String hhrEmpRcd;
	
	@ApiModelProperty(value = "状态：Y:未离职,N:已离职")
	private String hhrStatus;
	
	@ApiModelProperty(value = "职位编码")
	private String hhrPositionCode;
	
	@ApiModelProperty(value = "部门编码")
	private String hhrDeptCode;
	
	@ApiModelProperty(value = "工作地点")
	private String hhrLocation;
	
	@ApiModelProperty(value = "安全级别")
	private String hhrOrgSequenceAttr01;
	
	@ApiModelProperty(value = "直接上级")
	private String hhrDirectEmpid;
	
	@ApiModelProperty(value = "虚线上级")
	private String hhrIndirectEmpid;
	
	@ApiModelProperty(value = "人员类别")
	private String hhrEmpClass;
	
	@ApiModelProperty(value = "人员子类别")
	private String hhrSubEmpClass;
	
	@ApiModelProperty(value = "最后修改日期")
	private String lastUpdateDate;
	
	@ApiModelProperty(value = "公司编码")
	private String hhrCompanyCode;
	
	@ApiModelProperty(value = "公司中文名")
	private String hhrCompanyNameZh;
	
	@ApiModelProperty(value = "公司英文名")
	private String hhrCompanyNameEn;
	
	@ApiModelProperty(value = "企业微信")
	private String hhrQyWeixin;
	
	@ApiModelProperty(value = "账户名称")
	private String idmAccountName;
	
	@ApiModelProperty(value = "邮箱")
	private String idmEmail;
	
	@ApiModelProperty(value = "用户类型名称")
	private String idmUserTypeName;

	public String getHhrEmpid() {
		return hhrEmpid;
	}

	public void setHhrEmpid(String hhrEmpid) {
		this.hhrEmpid = hhrEmpid;
	}

	public String getHhrOtherContact() {
		return hhrOtherContact;
	}

	public void setHhrOtherContact(String hhrOtherContact) {
		this.hhrOtherContact = hhrOtherContact;
	}

	public String getIscPersonId() {
		return iscPersonId;
	}

	public void setIscPersonId(String iscPersonId) {
		this.iscPersonId = iscPersonId;
	}

	public String getHhrName() {
		return hhrName;
	}

	public void setHhrName(String hhrName) {
		this.hhrName = hhrName;
	}

	public String getHhrOtherName() {
		return hhrOtherName;
	}

	public void setHhrOtherName(String hhrOtherName) {
		this.hhrOtherName = hhrOtherName;
	}

	public String getHhrGender() {
		return hhrGender;
	}

	public void setHhrGender(String hhrGender) {
		this.hhrGender = hhrGender;
	}

	public String getHhrPhoneNum() {
		return hhrPhoneNum;
	}

	public void setHhrPhoneNum(String hhrPhoneNum) {
		this.hhrPhoneNum = hhrPhoneNum;
	}

	public String getHhrLastHireDate() {
		return hhrLastHireDate;
	}

	public void setHhrLastHireDate(String hhrLastHireDate) {
		this.hhrLastHireDate = hhrLastHireDate;
	}

	public String getHhrLastDateWorked() {
		return hhrLastDateWorked;
	}

	public void setHhrLastDateWorked(String hhrLastDateWorked) {
		this.hhrLastDateWorked = hhrLastDateWorked;
	}

	public String getHhrEndDate() {
		return hhrEndDate;
	}

	public void setHhrEndDate(String hhrEndDate) {
		this.hhrEndDate = hhrEndDate;
	}

	public String getHhrEmpRcd() {
		return hhrEmpRcd;
	}

	public void setHhrEmpRcd(String hhrEmpRcd) {
		this.hhrEmpRcd = hhrEmpRcd;
	}

	public String getHhrStatus() {
		return hhrStatus;
	}

	public void setHhrStatus(String hhrStatus) {
		this.hhrStatus = hhrStatus;
	}

	public String getHhrPositionCode() {
		return hhrPositionCode;
	}

	public void setHhrPositionCode(String hhrPositionCode) {
		this.hhrPositionCode = hhrPositionCode;
	}

	public String getHhrDeptCode() {
		return hhrDeptCode;
	}

	public void setHhrDeptCode(String hhrDeptCode) {
		this.hhrDeptCode = hhrDeptCode;
	}

	public String getHhrLocation() {
		return hhrLocation;
	}

	public void setHhrLocation(String hhrLocation) {
		this.hhrLocation = hhrLocation;
	}

	public String getHhrOrgSequenceAttr01() {
		return hhrOrgSequenceAttr01;
	}

	public void setHhrOrgSequenceAttr01(String hhrOrgSequenceAttr01) {
		this.hhrOrgSequenceAttr01 = hhrOrgSequenceAttr01;
	}

	public String getHhrDirectEmpid() {
		return hhrDirectEmpid;
	}

	public void setHhrDirectEmpid(String hhrDirectEmpid) {
		this.hhrDirectEmpid = hhrDirectEmpid;
	}

	public String getHhrIndirectEmpid() {
		return hhrIndirectEmpid;
	}

	public void setHhrIndirectEmpid(String hhrIndirectEmpid) {
		this.hhrIndirectEmpid = hhrIndirectEmpid;
	}

	public String getHhrEmpClass() {
		return hhrEmpClass;
	}

	public void setHhrEmpClass(String hhrEmpClass) {
		this.hhrEmpClass = hhrEmpClass;
	}

	public String getHhrSubEmpClass() {
		return hhrSubEmpClass;
	}

	public void setHhrSubEmpClass(String hhrSubEmpClass) {
		this.hhrSubEmpClass = hhrSubEmpClass;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getHhrCompanyCode() {
		return hhrCompanyCode;
	}

	public void setHhrCompanyCode(String hhrCompanyCode) {
		this.hhrCompanyCode = hhrCompanyCode;
	}

	public String getHhrCompanyNameZh() {
		return hhrCompanyNameZh;
	}

	public void setHhrCompanyNameZh(String hhrCompanyNameZh) {
		this.hhrCompanyNameZh = hhrCompanyNameZh;
	}

	public String getHhrCompanyNameEn() {
		return hhrCompanyNameEn;
	}

	public void setHhrCompanyNameEn(String hhrCompanyNameEn) {
		this.hhrCompanyNameEn = hhrCompanyNameEn;
	}

	public String getHhrQyWeixin() {
		return hhrQyWeixin;
	}

	public void setHhrQyWeixin(String hhrQyWeixin) {
		this.hhrQyWeixin = hhrQyWeixin;
	}

	public String getIdmAccountName() {
		return idmAccountName;
	}

	public void setIdmAccountName(String idmAccountName) {
		this.idmAccountName = idmAccountName;
	}

	public String getIdmEmail() {
		return idmEmail;
	}

	public void setIdmEmail(String idmEmail) {
		this.idmEmail = idmEmail;
	}

	public String getIdmUserTypeName() {
		return idmUserTypeName;
	}

	public void setIdmUserTypeName(String idmUserTypeName) {
		this.idmUserTypeName = idmUserTypeName;
	}
	
}

