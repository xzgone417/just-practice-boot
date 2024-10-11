package com.exp.ucmp.staff.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhouchengwei
 * @date 2022年8月12日
 */
@ApiModel(value = "PartyRoleRelaDto", description = "人员角色关系")
public class PartyRoleRelaDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 当事人角色标识
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "当事人角色标识")
    private Long partyRoleId;*/


    /**
     * 人员主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "人员主键id")
    private Long partyId;

    /**
     * 角色标识
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "角色标识")
    private Long roleId;*/

    /**
     * 选中的角色id
     */
    @ApiModelProperty("选中的角色id")
    private Long selectRoleId;

    @ApiModelProperty("true是选中，false是取消选中")
    private boolean roleFlag;


    public PartyRoleRelaDto() {
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public Long getSelectRoleId() {
        return selectRoleId;
    }

    public void setSelectRoleId(Long selectRoleId) {
        this.selectRoleId = selectRoleId;
    }

    public boolean isRoleFlag() {
        return roleFlag;
    }

    public void setRoleFlag(boolean roleFlag) {
        this.roleFlag = roleFlag;
    }
}
