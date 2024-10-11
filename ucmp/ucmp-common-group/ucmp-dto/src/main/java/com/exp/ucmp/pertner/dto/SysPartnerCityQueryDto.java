package com.exp.ucmp.pertner.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysPartnerCityQueryDto", description = "合作商管辖城市查询条件")
public class SysPartnerCityQueryDto extends PageDto {

    private static final long serialVersionUID = 1L;



    /**
     * 合作商标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "合作商标识")
    private Long partnerId;

    /**
     * 人员标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "人员标识")
    private Long partyId;





    public SysPartnerCityQueryDto() {
    }




    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
    public Long getPartnerId() {
        return this.partnerId;
    }


    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
}
