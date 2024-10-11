package com.exp.ucmp.staff.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022年8月12日
 */
@ApiModel(value = "SysStaffDetailsDto", description = "人员信息详情")
public class SysStaffDetailsDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "员工ID")
    private Long partyId;

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
     * 人员邮箱
     */
    @ApiModelProperty(value = "人员邮箱")
    private String staffEmail;

    /**
     * 人员状态:启用00/禁用01
     */
    @ApiModelProperty(value = "人员状态:启用00/禁用01")
    private String staffStatus;


    /**
     * 角色标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "角色标识")
    private Long roleId;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;



    /**
     * 部门名称
     */
   @ApiModelProperty(value = "部门名称")
    private String departmentName;

    /**
     * 人员类型
     */
    private String staffType;


    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String passWord;
    /**
     * 人员性别
     */
    @ApiModelProperty(value = "人员性别")
    private String staffSex;

    /**
     * 该人员是否已经存在该角色
     */
    @ApiModelProperty(value = "是否存在该角色标记:01存在/OO不存在")
    private String roleFlag;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键/合作商标识")
    private Long partnerId;
    /****/
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "登录标识")
    private List<Long> loginId;



    /**
     * 人员管辖城市名称
     */
    @ApiModelProperty(value = "人员管辖城市名称")
    private List<String> partyCity;
    /**
     * 人员管辖城市标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "人员管辖城市标识")
    private List<Long> partyCityId;

    public SysStaffDetailsDto() {
    }

    public SysStaffDetailsDto(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
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

    public void setStaffIphone(String staffIphone) {
        this.staffIphone = staffIphone;
    }

    public String getStaffIphone() {
        return this.staffIphone;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getStaffStatus() {
        return this.staffStatus;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<Long> getLoginId() {
        return loginId;
    }

    public void setLoginId(List<Long> loginId) {
        this.loginId = loginId;
    }

    public List<String> getPartyCity() {
        return partyCity;
    }

    public void setPartyCity(List<String> partyCity) {
        this.partyCity = partyCity;
    }

    public List<Long> getPartyCityId() {
        return partyCityId;
    }

    public void setPartyCityId(List<Long> partyCityId) {
        this.partyCityId = partyCityId;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(String roleFlag) {
        this.roleFlag = roleFlag;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }
}
