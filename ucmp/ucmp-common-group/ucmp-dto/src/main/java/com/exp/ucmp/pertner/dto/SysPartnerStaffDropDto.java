package com.exp.ucmp.pertner.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SysPartnerStaffDropDto", description = "合作商管辖城市查询条件")
public class SysPartnerStaffDropDto extends PageDto {

    private static final long serialVersionUID = 1L;



    /**
     * 人员标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "人员标识")
    private Long partyId;


    /**
     * 登录标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "登录标识")
    private List<Long> loginId;





    public SysPartnerStaffDropDto() {
    }


    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }


    public List<Long> getLoginId() {
        return loginId;
    }

    public void setLoginId(List<Long> loginId) {
        this.loginId = loginId;
    }
}
