package com.exp.ucmp.staff.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(value = "SysStaffDetailsAddDto", description = "添加人员信息")
public class SysStaffDetailsAddDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "员工ID")
    private Long partyId;


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
     * 人员部门类型
     */
    @ApiModelProperty(value = "人员部门类型")
    private String departmentType;



    public SysStaffDetailsAddDto() {
    }

    public SysStaffDetailsAddDto(Long partyId) {
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

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }
    public String getStaffStatus() {
        return this.staffStatus;
    }

    public String getDepartmentType() {
        return departmentType;
    }

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }
}
