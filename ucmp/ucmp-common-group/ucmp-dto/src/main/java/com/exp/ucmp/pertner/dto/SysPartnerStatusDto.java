package com.exp.ucmp.pertner.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SysPartnerStatusDto", description = "合作商状态信息")
public class SysPartnerStatusDto extends BaseModel {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "合作商id")
    private Long partnerId;

    @ApiModelProperty(value = "合作商id集合")
    private List<Long> partnerIds;

    /**
     * 合作商状态：启用01/禁用00
     */
    @ApiModelProperty(value = "合作商状态：启用01/禁用00")
    private String isEnable;



    public SysPartnerStatusDto() {
    }

    public List<Long> getPartnerIds() {
        return partnerIds;
    }

    public void setPartnerIds(List<Long> partnerIds) {
        this.partnerIds = partnerIds;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
}
