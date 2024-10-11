package com.exp.ucmp.store.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysFindPartnerByNameDto", description = "车商信息")
public class SysFindPartnerByNameDto extends BaseModel {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "车商标识 ")
    private Long partnerId;

    @ApiModelProperty(value = "车商名称")
    private String partnerName;

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
}
