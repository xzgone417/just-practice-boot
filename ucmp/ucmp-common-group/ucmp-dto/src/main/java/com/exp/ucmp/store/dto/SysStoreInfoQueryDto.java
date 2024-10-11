package com.exp.ucmp.store.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysStoreInfoQueryDto", description = "门店查询信息")
public class SysStoreInfoQueryDto extends PageDto {

    private static final long serialVersionUID = 1L;



    /**
     * 门店名称
     */
    @ApiModelProperty(value = "门店名称")
    private String storeName;

    /**
     * 门店所属区域
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店所属区域")
    private Long storeAreaId;

    /**
     * 门店状态：启用01/禁用00（当前门店是否能在APP端可见）
     */
    @ApiModelProperty(value = "门店状态：启用01/禁用00（当前门店是否能在APP端可见）")
    private String storeStatus;

    /**
     * 是否被删除：00、删除，01、未删除
     */
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;


    @ApiModelProperty("官二资质状态（启用01/禁用00）")
    private String qualificationStatus;

    @ApiModelProperty(value = "组织类型")
    private String orgType;

    @ApiModelProperty(value = "所属城市")
    private String city;
    @ApiModelProperty("城市(ID)")
    private String cityId;
    @ApiModelProperty("'省份(ID)'")
    private String provinceId;
    @ApiModelProperty("省市")
    private String province;

    public SysStoreInfoQueryDto() {
    }

    public String getQualificationStatus() {
        return qualificationStatus;
    }

    public void setQualificationStatus(String qualificationStatus) {
        this.qualificationStatus = qualificationStatus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }


    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreName() {
        return this.storeName;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
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

    public void setStoreStatus(String storeStatus) {
        this.storeStatus = storeStatus;
    }
    public String getStoreStatus() {
        return this.storeStatus;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }

    public Long getStoreAreaId() {
        return storeAreaId;
    }

    public void setStoreAreaId(Long storeAreaId) {
        this.storeAreaId = storeAreaId;
    }
}
