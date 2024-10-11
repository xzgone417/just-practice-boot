package com.exp.ucmp.parentUser.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysParentStoreQueryDto", description = "合作商添加门店Dto")
public class SysParentAddStoreListDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 门店标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店标识 ")
    private Long storeId;


    /**
     * 门店所属部门标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店所属部门标识 ")
    private Long storeDepartmentId;

    /**
     * 门店所属部门名称
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店所属部门名称 ")
    private String departmentName;

    @ApiModelProperty(value = "门店类型")
    private String orgType;

    @ApiModelProperty(value = "门店类型名称")
    private String orgTypeName;


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


    @ApiModelProperty("该门店是否属于该合作商")
    private Boolean storeFlag;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getStoreDepartmentId() {
        return storeDepartmentId;
    }

    public void setStoreDepartmentId(Long storeDepartmentId) {
        this.storeDepartmentId = storeDepartmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

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

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public Boolean getStoreFlag() {
        return storeFlag;
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

    public void setStoreFlag(Boolean storeFlag) {
        this.storeFlag = storeFlag;
    }
}
