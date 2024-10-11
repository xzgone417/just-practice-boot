package com.exp.ucmp.parentUser.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "JobReceiveRspUserInfoDto", description = "总部人员信息")
public class JobReceiveRspUserInfoDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 主键标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键标识 ")
    private Long rspUserInfoId;

    /**
     * 人员编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "人员编号")
    private String hhrEmpid;

    /**
     * 姓名
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "姓名")
    private String hhrName;

    /**
     * 角色名称
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "角色名称")
    private String roleName;


    /**
     * 状态(是否可用00：禁用，01：启用)
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "状态(是否可用00：禁用，01：启用)")
    private String isEnable;

    /**
     * 状态格式化字段
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "状态格式化字段")
    private String isEnableStr;


    /**
     * 部门编码
     */
    @ApiModelProperty(value = "部门编码")
    @JsonSerialize(using = ToStringSerializer.class)
    private String hhrDeptCode;

    /**
     * 部门名称
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "部门名称")
    private String hhrDeptName;

    /**
     * 工作地点
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "工作地点")
    private String hhrLocation;


    /**
     * 性别:M:男，F:女
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "性别:M:男，F:女")
    private String hhrGender;

    /**
     * 手机号码
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "手机号码")
    private String hhrPhoneNum;

    /**
     * 邮箱
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "邮箱")
    private String idmEmail;


    public Long getRspUserInfoId() {
        return rspUserInfoId;
    }

    public void setRspUserInfoId(Long rspUserInfoId) {
        this.rspUserInfoId = rspUserInfoId;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String getIsEnableStr() {
        return "00".equals(isEnableStr)?"禁用":"启用";
    }

    public void setIsEnableStr(String isEnableStr) {
        this.isEnableStr = isEnableStr;
    }

    public String getHhrEmpid() {
        return hhrEmpid;
    }

    public void setHhrEmpid(String hhrEmpid) {
        this.hhrEmpid = hhrEmpid;
    }

    public String getHhrName() {
        return hhrName;
    }

    public void setHhrName(String hhrName) {
        this.hhrName = hhrName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getHhrDeptCode() {
        return hhrDeptCode;
    }

    public void setHhrDeptCode(String hhrDeptCode) {
        this.hhrDeptCode = hhrDeptCode;
    }

    public String getHhrDeptName() {
        return hhrDeptName;
    }

    public void setHhrDeptName(String hhrDeptName) {
        this.hhrDeptName = hhrDeptName;
    }

    public String getHhrLocation() {
        return hhrLocation;
    }

    public void setHhrLocation(String hhrLocation) {
        this.hhrLocation = hhrLocation;
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

    public String getIdmEmail() {
        return idmEmail;
    }

    public void setIdmEmail(String idmEmail) {
        this.idmEmail = idmEmail;
    }
}
