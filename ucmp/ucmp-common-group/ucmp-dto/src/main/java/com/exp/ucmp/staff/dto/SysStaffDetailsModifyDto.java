package com.exp.ucmp.staff.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.SysDepartmentStaffRelaEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


@ApiModel(value = "SysStaffDetailsModifyDto", description = "人员信息修改")
public class SysStaffDetailsModifyDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "员工ID")
    private Long partyId;


    /**
     * 登录标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "登录标识")
    private List<Long> loginId;





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
     * 部门标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "部门标识")
    private Long departmentId;

    /**
     * 部门标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "部门标识集合")
    private List<SysDepartmentStaffRelaEntity> departmentIdList;


    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String passWord;




    public SysStaffDetailsModifyDto() {
    }

    public SysStaffDetailsModifyDto(Long partyId) {
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

    public void setStaffIphone(String staffIphone) {
        this.staffIphone = staffIphone;
    }
    public String getStaffIphone() {
        return this.staffIphone;
    }


    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<SysDepartmentStaffRelaEntity> getDepartmentIdList() {
        return departmentIdList;
    }

    public void setDepartmentIdList(List<SysDepartmentStaffRelaEntity> departmentIdList) {
        this.departmentIdList = departmentIdList;
    }

    public List<Long> getLoginId() {
        return loginId;
    }

    public void setLoginId(List<Long> loginId) {
        this.loginId = loginId;
    }
}
