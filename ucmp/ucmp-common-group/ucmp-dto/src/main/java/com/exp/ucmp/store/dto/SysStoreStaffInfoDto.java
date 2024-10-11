package com.exp.ucmp.store.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysStoreStaffInfoDto", description = "门店人员信息")
public class SysStoreStaffInfoDto extends PageDto {

    private static final long serialVersionUID = 1L;


    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "人员标识 ")
    private Long partyId;

    /**
     * 门店标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店标识 ")
    private Long storeId;


    @ApiModelProperty(value = "门店代码")
    private String storeCode;

    /**
     * 门店名称
     */
    @ApiModelProperty(value = "门店名称")
    private String storeName;


    /**
     * 人员编号
     */
    @ApiModelProperty(value = "人员编号")
    private String staffCode;

    /**
     * 人员姓名
     */
    @ApiModelProperty(value = "人员姓名")
    private String staffName;


    /**
     * 人员手机号
     */
    @ApiModelProperty(value = "人员手机号")
    private String staffIphone;


    /**
     * 人员状态:启用00/禁用01
     */
    @ApiModelProperty(value = "人员状态:启用00/禁用01")
    private String staffStatus;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    
    /**
     * EOS角色
     */
//    @ApiModelProperty(value = "EOS角色")
//    private String eosRoleName;

    /**
     * UCMP角色
     */
//    @ApiModelProperty(value = "UCMP角色")
//    private String ucmpRoleName;

    /**
     * 部门标识
     */
    @ApiModelProperty(value = "部门标识")
    private Long departmentId;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    /**
     * 官二资质状态（启用01/禁用00）
     */
    @ApiModelProperty(value = "官二资质状态（启用01/禁用00）")
    private String qualificationStatus;

    public SysStoreStaffInfoDto() {
    }
    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffIphone() {
        return staffIphone;
    }

    public void setStaffIphone(String staffIphone) {
        this.staffIphone = staffIphone;
    }

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

//    public String getEosRoleName() {
//        return eosRoleName;
//    }
//
//    public void setEosRoleName(String eosRoleName) {
//        this.eosRoleName = eosRoleName;
//    }

    public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

//    public String getUcmpRoleName() {
//        return ucmpRoleName;
//    }
//
//    public void setUcmpRoleName(String ucmpRoleName) {
//        this.ucmpRoleName = ucmpRoleName;
//    }

    public SysStoreStaffInfoDto(Long storeId) {
        this.storeId = storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Long getStoreId() {
        return this.storeId;
    }
    

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
    public String getStoreCode() {
        return this.storeCode;
    }
    
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreName() {
        return this.storeName;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getQualificationStatus() {
        return qualificationStatus;
    }

    public void getQualificationStatus(String qualificationStatus) {
        this.qualificationStatus = qualificationStatus;
    }
}
