package com.exp.ucmp.department.dto;

import com.exp.ucmp.PageDto;
import com.exp.ucmp.entity.SysDepartmentStaffRelaEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * @author zhouchengwei
 * @date 2022年8月9日
 */


@ApiModel(value = "SysDepartmentStaffRelaDto", description = "部门人员信息")
public class SysDepartmentStaffRelaDto extends PageDto {


    private static final long serialVersionUID = 1L;






    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;


    /**
     * 角色类型
     */
    @ApiModelProperty(value = "角色类型")
    private String roleType;





    /**
     * 所属部门
     */
    @ApiModelProperty(value = "所属部门")
    private String staffDepartment;


    /**
     * 是否存在部门中的标记
     */
    @ApiModelProperty(value = "是否存在部门中的标记")
    private Boolean departmentFlag;




    public SysDepartmentStaffRelaDto() {
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }



    public String getStaffDepartment() {
        return staffDepartment;
    }

    public void setStaffDepartment(String staffDepartment) {
        this.staffDepartment = staffDepartment;
    }


    public Boolean getDepartmentFlag() {
        return departmentFlag;
    }

    public void setDepartmentFlag(Boolean departmentFlag) {
        this.departmentFlag = departmentFlag;
    }
}
