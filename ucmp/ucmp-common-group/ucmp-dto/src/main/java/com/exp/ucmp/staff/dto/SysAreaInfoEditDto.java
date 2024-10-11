package com.exp.ucmp.staff.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SysAreaInfoEditDto", description = "人员区域修改信息")
public class SysAreaInfoEditDto extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 当事人标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "当事人标识")
    private Long partyId;


    /**
     * 区域标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "区域标识")
    private List<Long> areaId;



    public SysAreaInfoEditDto() {
    }


    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public List<Long> getAreaId() {
        return areaId;
    }

    public void setAreaId(List<Long> areaId) {
        this.areaId = areaId;
    }
}
