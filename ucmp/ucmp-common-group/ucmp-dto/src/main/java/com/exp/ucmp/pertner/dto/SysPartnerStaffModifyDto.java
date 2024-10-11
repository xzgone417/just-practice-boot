package com.exp.ucmp.pertner.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysPartnerStaffModifyDto", description = "合作商管辖城市查询条件")
public class SysPartnerStaffModifyDto extends PageDto {

    private static final long serialVersionUID = 1L;



    /**
     * 人员标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "人员标识")
    private Long partyId;





    public SysPartnerStaffModifyDto() {
    }


    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
}
