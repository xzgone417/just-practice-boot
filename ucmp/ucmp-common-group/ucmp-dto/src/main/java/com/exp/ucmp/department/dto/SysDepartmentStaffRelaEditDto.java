package com.exp.ucmp.department.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhouchengwei
 * @date 2022年8月9日
 */


@ApiModel(value = "SysDepartmentStaffRelaEditDto", description = "部门人员编辑信息")
public class SysDepartmentStaffRelaEditDto extends BaseModel {


    private static final long serialVersionUID = 1L;


    /**
     * 员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "员工ID")
    private Long partyId;



    /**
     * 部门标识
     */

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "部门标识")
    private Long departmentId;






    /**
     * 操作(判断是否新增还是删除)
     */
    @ApiModelProperty(value = "操作:00：删除/01:新增")
    private String departmentOpe;


    public SysDepartmentStaffRelaEditDto() {
    }
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    public Long getDepartmentId() {
        return this.departmentId;
    }

    public String getDepartmentOpe() {
        return departmentOpe;
    }

    public void setDepartmentOpe(String departmentOpe) {
        this.departmentOpe = departmentOpe;
    }

}
