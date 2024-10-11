package com.exp.ucmp.store.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.PartyInfoEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@ApiModel(value = "SysStoreStaffStatusDto", description = "门店员工状态信息")

public class SysStoreStaffStatusDto extends BaseModel {

    private static final long serialVersionUID = 1L;



    /**
     * 当事人标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "当事人标识")
    private Long partyId;



    /**
     * 人员编号
     */
    @ApiModelProperty(value = "人员编号")
    private String staffCode;


    /**
     * 人员状态:启用00/禁用01
     */
    @ApiModelProperty(value = "人员状态:启用00/禁用01")
    private String staffStatus;




    public SysStoreStaffStatusDto() {
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
}
