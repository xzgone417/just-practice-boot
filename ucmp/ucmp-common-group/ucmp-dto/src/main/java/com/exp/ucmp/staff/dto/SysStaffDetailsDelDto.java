package com.exp.ucmp.staff.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


@ApiModel(value = "SysStaffDetailsDelDto", description = "人员信息删除")
public class SysStaffDetailsDelDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "员工ID")
    private Long partyId;


    /**
     * 登录ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "登录ID")
    private List<Long> loginId;






    public SysStaffDetailsDelDto() {
    }

    public SysStaffDetailsDelDto(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }


    public List<Long> getLoginId() {
        return loginId;
    }

    public void setLoginId(List<Long> loginId) {
        this.loginId = loginId;
    }
}
