package com.exp.ucmp.department.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author zhouchengwei
 * @date 2022年8月9日
 */


@ApiModel(value = "SysDepartmentInfoDto", description = "部门信息")
public class SysDepartmentInfoDto extends PageDto {


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
     * 部门类型(0010总部,0020门店.....)
     */
    @ApiModelProperty(value = "部门类型(0010总部,0020门店.....)")
    private String departmentType;

    /**
     * 是否被删除：00、删除，01、未删除
     */
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;


    public SysDepartmentInfoDto() {
    }

    public SysDepartmentInfoDto(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    public Long getDepartmentId() {
        return this.departmentId;
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

    public void setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }
    public String getDepartmentType() {
        return this.departmentType;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }
}
