package com.exp.ucmp.pertner.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysPartnerCityDropDto", description = "合作商管辖城市查询条件")
public class SysPartnerCityDropDto extends PageDto {

    private static final long serialVersionUID = 1L;



    /**
     * 城市标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "城市标识")
    private Long cityId;


    /**
     * 合作商标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "合作商标识")
    private Long partnerId;


    /**
     * 行政区域编码
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "行政区域编码")
    private Long regionCode;





    public SysPartnerCityDropDto() {
    }


    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Long getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Long regionCode) {
        this.regionCode = regionCode;
    }
}
