package com.exp.ucmp.store.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysStoreStaffListDto", description = "授权门店页面展示")
public class SysStoreStaffListDto extends PageDto {

    private static final long serialVersionUID = 1L;

    /**
     * 人员标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "人员标识 ")
    private Long partyId;

    @ApiModelProperty(value = "门店类型")
    private String orgType;

    @ApiModelProperty(value = "门店类型名称")
    private String orgTypeName;

    @ApiModelProperty(value = "'省份(ID)'")
    private String provinceId;

    @ApiModelProperty(value = "'省份'")
    private String province;

    @ApiModelProperty(value = "城市(ID)")
    private String cityId;

    @ApiModelProperty(value = "城市'")
    private String city;


    /**
     * 门店标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店标识 ")
    private Long storeId;

    @ApiModelProperty(value = "门店代码")
    private String orgCode;

    /**
     * 门店名称
     */
    @ApiModelProperty(value = "门店名称")
    private String orgName;


    /**
     * 区域名称
     */
    @ApiModelProperty(value = "区域名称")
    private String areaName;



    @ApiModelProperty("该人员是否属于该门店")
    private Boolean storeFlag;

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgTypeName() {
        return orgTypeName;
    }

    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Boolean getStoreFlag() {
        return storeFlag;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStoreFlag(Boolean storeFlag) {
        this.storeFlag = storeFlag;
    }
}
