package com.exp.ucmp.department.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhouchengwei
 * @date 2022年8月12日
 */
@ApiModel(value = "SysStaffAllDto", description = "人员信息详情返回信息")
public class SysStaffAllDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "员工ID")
    private Long partyId;

    /**
     * 角色类型
     */
    @ApiModelProperty(value = "角色类型")
    private String roleDetailsType;



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
     * 人员状态
     */
    @ApiModelProperty(value = "人员状态")
    private String staffStatus;

    /**
     * 部门id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "部门id")
    private String departmentId;


    /**
     * 角色标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "角色标识")
    private Long roleId;
    /**
     * 部门标识(当有角色参数传入的时候，此参数作为可选参数，数值和部门ID一样)
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "部门标识")
    private Long departmentRoleId;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleDetailsName;


    /**
     * 部门编码
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "部门编码")
    private Long departmentCode;


    /**
     * 部门名称
     */
   @ApiModelProperty(value = "部门名称")
    private String departmentName;


    /**
     * 是否存在部门中的标记
     */
    @ApiModelProperty(value = "是否存在部门中的标记")
    private Boolean departmentFlag;







    public SysStaffAllDto() {
    }

    public SysStaffAllDto(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public Long getPartyId() {
        return this.partyId;
    }


    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffCode() {
        return this.staffCode;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffName() {
        return this.staffName;
    }


    public Boolean getDepartmentFlag() {
        return departmentFlag;
    }

    public void setDepartmentFlag(Boolean departmentFlag) {
        this.departmentFlag = departmentFlag;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getRoleDetailsName() {
        return roleDetailsName;
    }

    public void setRoleDetailsName(String roleDetailsName) {
        this.roleDetailsName = roleDetailsName;
    }

    public Long getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(Long departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoleDetailsType() {
        return roleDetailsType;
    }

    public void setRoleDetailsType(String roleDetailsType) {
        this.roleDetailsType = roleDetailsType;
    }

    public Long getDepartmentRoleId() {
        return departmentRoleId;
    }

    public void setDepartmentRoleId(Long departmentRoleId) {
        this.departmentRoleId = departmentRoleId;
    }
}
