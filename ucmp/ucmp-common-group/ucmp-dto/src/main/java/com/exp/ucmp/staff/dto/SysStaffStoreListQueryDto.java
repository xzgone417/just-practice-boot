package com.exp.ucmp.staff.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "SysStaffDetailsRoleQueryDto", description = "授权门店列表查询参数")
public class SysStaffStoreListQueryDto extends PageDto {

    private static final long serialVersionUID = 1L;

    /**
     * 员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "员工ID")
    private Long partyId;

    /**
     * 所属省份
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "所属省份")
    private String province;

    /**
     * 所属省份Id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "所属省份Id")
    private String provinceId;

    /**
     * 所属城市
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "所属城市")
    private String city;
    /**
     * 所属城市Id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "所属城市Id")
    private String cityId;

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
