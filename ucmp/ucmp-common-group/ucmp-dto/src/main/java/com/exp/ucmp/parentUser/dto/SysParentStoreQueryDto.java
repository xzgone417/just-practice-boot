package com.exp.ucmp.parentUser.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysParentStoreQueryDto", description = "合作商管辖门店查询Dto")
public class SysParentStoreQueryDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 当前合作商partnerId
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "当前合作商partnerId")
    private Long partnerId;

    /**
     * 省市
     */
    @ApiModelProperty(value = "省市")
    private String province;
    @ApiModelProperty(value = "'省份(ID)'")
    private String provinceId;
    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String city;
    @ApiModelProperty(value = "城市(ID)")
    private String cityId;


    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
}
