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


@ApiModel(value = "SysDepartmentInfoEditDto", description = "部门新增信息")
public class SysDepartmentInfoEditDto extends BaseModel {


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




    public SysDepartmentInfoEditDto() {
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


}
