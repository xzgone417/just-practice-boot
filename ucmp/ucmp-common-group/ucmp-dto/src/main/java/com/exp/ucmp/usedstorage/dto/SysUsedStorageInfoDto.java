package com.exp.ucmp.usedstorage.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysUsedStorageInfoDto", description = "仓储点信息Dto")
public class SysUsedStorageInfoDto {

    private static final long serialVersionUID = 1L;

    /**
     * 所属交付中心id
     */
    @ApiModelProperty(value = "所属交付中心id")
    private Long orgId;

    /**
     * 仓储点id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "仓储点id")
    private Long storageId;

    /**
     * 仓储点名称
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "仓储点名称")
    private String storageName;

    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库编码")
    private String storageCode;

    /**
     * 仓储点地址
     */
    @ApiModelProperty(value = "仓储点地址")
    private String storageAddress;

    /**
     * 管理员姓名
     */
    @ApiModelProperty(value = "管理员姓名")
    private String managerName;

    /**
     * 管理员电话
     */
    @ApiModelProperty(value = "管理员电话")
    private String managerPhone;

    /**
     * 城市
     */
    @ApiModelProperty(value = "城市")
    private String city;

    /**
     * 城市(ID)
     */
    @ApiModelProperty(value = "城市(ID)")
    private String cityId;

    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String province;

    /**
     * 省份(ID)
     */
    @ApiModelProperty(value = "省份ID")
    private String provinceId;

    /**
     * 地区
     */
    @ApiModelProperty(value = "地区")
    private String district;

    /**
     * 地区(ID)
     */
    @ApiModelProperty(value = "地区(ID)")
    private String districtId;

    /**
     * 默认搬入地(00否01是)
     */
    @ApiModelProperty(value = "默认搬入地(00否01是)")
    private String defaultMoveAddress;

    /**
     * 是否可用00、无效，01、有效
     */
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 库存容量
     */
    @ApiModelProperty(value = "库存容量")
    private Integer inventoryCapacity;


    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getStorageAddress() {
        return storageAddress;
    }

    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDefaultMoveAddress() {
        return defaultMoveAddress;
    }

    public void setDefaultMoveAddress(String defaultMoveAddress) {
        this.defaultMoveAddress = defaultMoveAddress;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getInventoryCapacity() {
        return inventoryCapacity;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public void setInventoryCapacity(Integer inventoryCapacity) {
        this.inventoryCapacity = inventoryCapacity;
    }
}
