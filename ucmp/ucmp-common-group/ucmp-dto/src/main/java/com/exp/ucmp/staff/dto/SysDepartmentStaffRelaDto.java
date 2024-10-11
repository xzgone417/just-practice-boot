package com.exp.ucmp.staff.dto;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.GroupSequence;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Date;
/**
 * @author zhouchengwei
 * @date 2022年8月12日
 */
@ApiModel(value = "SysDepartmentStaffRelaDto", description = "人员部门关系")
public class SysDepartmentStaffRelaDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键")
    private Long relaId;


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



    public SysDepartmentStaffRelaDto() {
    }

    public SysDepartmentStaffRelaDto(Long relaId) {
        this.relaId = relaId;
    }

    public void setRelaId(Long relaId) {
        this.relaId = relaId;
    }
    public Long getRelaId() {
        return this.relaId;
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
    

}
