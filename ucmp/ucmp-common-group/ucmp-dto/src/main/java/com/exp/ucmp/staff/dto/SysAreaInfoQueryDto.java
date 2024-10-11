package com.exp.ucmp.staff.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysAreaInfoQueryDto", description = "区域查询信息")
public class SysAreaInfoQueryDto extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 当事人标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "当事人标识")
    private Long partyId;



    public SysAreaInfoQueryDto() {
    }


    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
}
