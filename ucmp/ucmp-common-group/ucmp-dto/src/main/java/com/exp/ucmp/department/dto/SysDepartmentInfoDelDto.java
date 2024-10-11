package com.exp.ucmp.department.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author zhouchengwei
 * @date 2022年8月9日
 */


@ApiModel(value = "SysDepartmentInfoDelDto", description = "删除部门信息")
public class SysDepartmentInfoDelDto extends BaseModel {


    private static final long serialVersionUID = 1L;



    /**
     * 部门标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "部门标识")
    private Long departmentId;

    /**
     * 部门代码
     */
    @ApiModelProperty(value = "部门代码")
    private String departmentCode;

    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    /**
     * 是否被删除：00、删除，01、未删除
     */
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;


    public SysDepartmentInfoDelDto() {
    }




    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    public String getDepartmentCode() {
        return this.departmentCode;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
