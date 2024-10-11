package com.exp.ucmp.pertner.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysPartnerStaffQueryDto", description = "合作商下人员名单查询dto")
public class SysPartnerStaffQueryDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 主键/合作商标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键/合作商标识")
    private Long partnerId;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键/合作商标识")
    private Long partnerId1;


    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键/合作商标识")
    private Long partnerId2;

    public SysPartnerStaffQueryDto() {
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Long getPartnerId1() {
        return partnerId;
    }

    public void setPartnerId1(Long partnerId1) {
        this.partnerId1 = partnerId1;
    }

    public Long getPartnerId2() {
        return partnerId;
    }

    public void setPartnerId2(Long partnerId2) {
        this.partnerId2 = partnerId2;
    }
}
