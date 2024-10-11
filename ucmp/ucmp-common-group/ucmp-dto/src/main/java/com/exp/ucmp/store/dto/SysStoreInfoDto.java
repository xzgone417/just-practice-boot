package com.exp.ucmp.store.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysStoreInfoDto", description = "门店信息")
public class SysStoreInfoDto extends PageDto {

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
    private String storeCode;

    /**
     * 门店名称
     */
    @ApiModelProperty(value = "门店名称")
    private String storeName;

    /**
     * 门店负责人

   @ApiModelProperty(value = "门店负责人")
    private String storePersonCharge;

    /**
     * 负责人手机

    @ApiModelProperty(value = "负责人手机")
    private String storePersonChargePhone;

    /**
     * 是否被删除：00、删除，01、未删除

    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;

    */
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
    /**
     * 门店所属区域
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店所属区域")
    private Long storeAreaId;





    /**
     * 门店状态：是否可用(1是，0否)（当前门店是否能在APP端可见）
     */
    @ApiModelProperty(value = "门店状态：是否可用(1是，0否)（当前门店是否能在APP端可见）")
    private String storeStatus;

    /**
     * 官二资质状态（启用01/禁用00）
     */
    @ApiModelProperty(value = "官二资质状态（启用01/禁用00）")
    private String qualificationStatus;



    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public SysStoreInfoDto() {
    }

    public SysStoreInfoDto(Long storeId) {
        this.storeId = storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Long getStoreId() {
        return this.storeId;
    }
    

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
    public String getStoreCode() {
        return this.storeCode;
    }
    
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreName() {
        return this.storeName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setStoreStatus(String storeStatus) {
        this.storeStatus = storeStatus;
    }
    public String getStoreStatus() {
        return this.storeStatus;
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

    public Long getStoreAreaId() {
        return storeAreaId;
    }

    public void setStoreAreaId(Long storeAreaId) {
        this.storeAreaId = storeAreaId;
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

    public String getQualificationStatus() {
        return qualificationStatus;
    }

    public void getQualificationStatus(String qualificationStatus) {
        this.qualificationStatus = qualificationStatus;
    }
}
