/**
 * SysCarUsedStorageEntity
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "SysCarUsedStorageEntity", description = "二手车仓储点表(v2)")
@GroupSequence({SysCarUsedStorageEntity.class, SysCarUsedStorageEntity.SysCarUsedStorageEntityValidGroup.class,SysCarUsedStorageEntity.StorageIdValidGroup.class,SysCarUsedStorageEntity.StorageNameValidGroup.class,SysCarUsedStorageEntity.StorageAddressValidGroup.class,SysCarUsedStorageEntity.StorageCodeValidGroup.class,SysCarUsedStorageEntity.ManagerNameValidGroup.class,SysCarUsedStorageEntity.ManagerPhoneValidGroup.class,SysCarUsedStorageEntity.CityValidGroup.class,SysCarUsedStorageEntity.CityIdValidGroup.class,SysCarUsedStorageEntity.ProvinceValidGroup.class,SysCarUsedStorageEntity.ProvinceIdValidGroup.class,SysCarUsedStorageEntity.DistrictValidGroup.class,SysCarUsedStorageEntity.DistrictIdValidGroup.class,SysCarUsedStorageEntity.InventoryCapacityValidGroup.class,SysCarUsedStorageEntity.DefaultMoveAddressValidGroup.class,SysCarUsedStorageEntity.OrgIdValidGroup.class,SysCarUsedStorageEntity.RemarksValidGroup.class,SysCarUsedStorageEntity.IsManualCreationValidGroup.class,SysCarUsedStorageEntity.CreatedByValidGroup.class,SysCarUsedStorageEntity.CreatedDateValidGroup.class,SysCarUsedStorageEntity.UpdatedByValidGroup.class,SysCarUsedStorageEntity.UpdatedDateValidGroup.class,SysCarUsedStorageEntity.IsEnableValidGroup.class,SysCarUsedStorageEntity.IsDeleteValidGroup.class}) 
public class SysCarUsedStorageEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 仓储点id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "仓储点id 不能是Null", groups = {SysCarUsedStorageEntityValidGroup.class, StorageIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="仓储点id 数字精度必须符合(19,0)", groups = {SysCarUsedStorageEntityValidGroup.class, StorageIdValidGroup.class})
    @ApiModelProperty(value = "仓储点id")
    private Long storageId;
    
    
    /**
     * 仓储点名称
     */
    @NotNull(message = "仓储点名称 不能是Null", groups = {SysCarUsedStorageEntityValidGroup.class, StorageNameValidGroup.class})
    @Size(min=0, max=20, message="仓储点名称 字符长度必须小于等于20", groups = {SysCarUsedStorageEntityValidGroup.class, StorageNameValidGroup.class})
    @ApiModelProperty(value = "仓储点名称")
    private String storageName;
    
    /**
     * 仓储点地址
     */
    @NotNull(message = "仓储点地址 不能是Null", groups = {SysCarUsedStorageEntityValidGroup.class, StorageAddressValidGroup.class})
    @Size(min=0, max=100, message="仓储点地址 字符长度必须小于等于100", groups = {SysCarUsedStorageEntityValidGroup.class, StorageAddressValidGroup.class})
    @ApiModelProperty(value = "仓储点地址")
    private String storageAddress;
    
    /**
     * 仓库编码
     */
    @NotNull(message = "仓库编码 不能是Null", groups = {SysCarUsedStorageEntityValidGroup.class, StorageCodeValidGroup.class})
    @Size(min=0, max=10, message="仓库编码 字符长度必须小于等于10", groups = {SysCarUsedStorageEntityValidGroup.class, StorageCodeValidGroup.class})
    @ApiModelProperty(value = "仓库编码")
    private String storageCode;
    
    /**
     * 管理员姓名
     */
    @Size(min=0, max=20, message="管理员姓名 字符长度必须小于等于20", groups = {SysCarUsedStorageEntityValidGroup.class, ManagerNameValidGroup.class})
    @ApiModelProperty(value = "管理员姓名")
    private String managerName;
    
    /**
     * 管理员电话
     */
    @Size(min=0, max=50, message="管理员电话 字符长度必须小于等于50", groups = {SysCarUsedStorageEntityValidGroup.class, ManagerPhoneValidGroup.class})
    @ApiModelProperty(value = "管理员电话")
    private String managerPhone;
    
    /**
     * 城市
     */
    @Size(min=0, max=20, message="城市 字符长度必须小于等于20", groups = {SysCarUsedStorageEntityValidGroup.class, CityValidGroup.class})
    @ApiModelProperty(value = "城市")
    private String city;
    
    /**
     * 城市(ID)
     */
    @Size(min=0, max=11, message="城市(ID) 字符长度必须小于等于11", groups = {SysCarUsedStorageEntityValidGroup.class, CityIdValidGroup.class})
    @ApiModelProperty(value = "城市(ID)")
    private String cityId;
    
    /**
     * 省份
     */
    @Size(min=0, max=20, message="省份 字符长度必须小于等于20", groups = {SysCarUsedStorageEntityValidGroup.class, ProvinceValidGroup.class})
    @ApiModelProperty(value = "省份")
    private String province;
    
    /**
     * 省份(ID)
     */
    @Size(min=0, max=11, message="省份(ID) 字符长度必须小于等于11", groups = {SysCarUsedStorageEntityValidGroup.class, ProvinceIdValidGroup.class})
    @ApiModelProperty(value = "省份(ID)")
    private String provinceId;
    
    /**
     * 地区
     */
    @Size(min=0, max=20, message="地区 字符长度必须小于等于20", groups = {SysCarUsedStorageEntityValidGroup.class, DistrictValidGroup.class})
    @ApiModelProperty(value = "地区")
    private String district;
    
    /**
     * 地区(ID)
     */
    @Size(min=0, max=11, message="地区(ID) 字符长度必须小于等于11", groups = {SysCarUsedStorageEntityValidGroup.class, DistrictIdValidGroup.class})
    @ApiModelProperty(value = "地区(ID)")
    private String districtId;
    
    /**
     * 库存容量
     */
    @Digits(integer=10, fraction=0, message="库存容量 数字精度必须符合(10,0)", groups = {SysCarUsedStorageEntityValidGroup.class, InventoryCapacityValidGroup.class})
    @ApiModelProperty(value = "库存容量")
    private Integer inventoryCapacity;
    
    /**
     * 默认搬入地(00否01是)
     */
    @NotNull(message = "默认搬入地(00否01是) 不能是Null", groups = {SysCarUsedStorageEntityValidGroup.class, DefaultMoveAddressValidGroup.class})
    @Size(min=0, max=2, message="默认搬入地(00否01是) 字符长度必须小于等于2", groups = {SysCarUsedStorageEntityValidGroup.class, DefaultMoveAddressValidGroup.class})
    @ApiModelProperty(value = "默认搬入地(00否01是)")
    private String defaultMoveAddress;
    
    /**
     * 所属交付中心id
     */
    @NotNull(message = "所属交付中心id 不能是Null", groups = {SysCarUsedStorageEntityValidGroup.class, OrgIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="所属交付中心id 数字精度必须符合(19,0)", groups = {SysCarUsedStorageEntityValidGroup.class, OrgIdValidGroup.class})
    @ApiModelProperty(value = "所属交付中心id")
    private Long orgId;
    
    /**
     * 备注
     */
    @Size(min=0, max=200, message="备注 字符长度必须小于等于200", groups = {SysCarUsedStorageEntityValidGroup.class, RemarksValidGroup.class})
    @ApiModelProperty(value = "备注")
    private String remarks;
    
    /**
     * 是否手动创建(00否01是)
     */
    @NotNull(message = "是否手动创建(00否01是) 不能是Null", groups = {SysCarUsedStorageEntityValidGroup.class, IsManualCreationValidGroup.class})
    @Size(min=0, max=2, message="是否手动创建(00否01是) 字符长度必须小于等于2", groups = {SysCarUsedStorageEntityValidGroup.class, IsManualCreationValidGroup.class})
    @ApiModelProperty(value = "是否手动创建(00否01是)")
    private String isManualCreation;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysCarUsedStorageEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysCarUsedStorageEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysCarUsedStorageEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysCarUsedStorageEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysCarUsedStorageEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysCarUsedStorageEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {SysCarUsedStorageEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {SysCarUsedStorageEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public SysCarUsedStorageEntity() {
    }
    
    public SysCarUsedStorageEntity(Long storageId) {
        this.storageId = storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }
    public Long getStorageId() {
        return this.storageId;
    }
    

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }
    public String getStorageName() {
        return this.storageName;
    }
    
    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }
    public String getStorageAddress() {
        return this.storageAddress;
    }
    
    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }
    public String getStorageCode() {
        return this.storageCode;
    }
    
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
    public String getManagerName() {
        return this.managerName;
    }
    
    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }
    public String getManagerPhone() {
        return this.managerPhone;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
    public String getCityId() {
        return this.cityId;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    public String getProvince() {
        return this.province;
    }
    
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
    public String getProvinceId() {
        return this.provinceId;
    }
    
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getDistrict() {
        return this.district;
    }
    
    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }
    public String getDistrictId() {
        return this.districtId;
    }
    
    public void setInventoryCapacity(Integer inventoryCapacity) {
        this.inventoryCapacity = inventoryCapacity;
    }
    public Integer getInventoryCapacity() {
        return this.inventoryCapacity;
    }
    
    public void setDefaultMoveAddress(String defaultMoveAddress) {
        this.defaultMoveAddress = defaultMoveAddress;
    }
    public String getDefaultMoveAddress() {
        return this.defaultMoveAddress;
    }
    
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }
    public Long getOrgId() {
        return this.orgId;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getRemarks() {
        return this.remarks;
    }
    
    public void setIsManualCreation(String isManualCreation) {
        this.isManualCreation = isManualCreation;
    }
    public String getIsManualCreation() {
        return this.isManualCreation;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Long getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Long getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public String getIsEnable() {
        return this.isEnable;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (storageId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                storageId = RandomIDGennerator.get().generate();
    }

    public interface SysCarUsedStorageEntityValidGroup {}
    public interface StorageIdValidGroup {}
    public interface StorageNameValidGroup {}
    public interface StorageAddressValidGroup {}
    public interface StorageCodeValidGroup {}
    public interface ManagerNameValidGroup {}
    public interface ManagerPhoneValidGroup {}
    public interface CityValidGroup {}
    public interface CityIdValidGroup {}
    public interface ProvinceValidGroup {}
    public interface ProvinceIdValidGroup {}
    public interface DistrictValidGroup {}
    public interface DistrictIdValidGroup {}
    public interface InventoryCapacityValidGroup {}
    public interface DefaultMoveAddressValidGroup {}
    public interface OrgIdValidGroup {}
    public interface RemarksValidGroup {}
    public interface IsManualCreationValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            StorageIdValidGroup.class
            , StorageNameValidGroup.class
            , StorageAddressValidGroup.class
            , StorageCodeValidGroup.class
            , ManagerNameValidGroup.class
            , ManagerPhoneValidGroup.class
            , CityValidGroup.class
            , CityIdValidGroup.class
            , ProvinceValidGroup.class
            , ProvinceIdValidGroup.class
            , DistrictValidGroup.class
            , DistrictIdValidGroup.class
            , InventoryCapacityValidGroup.class
            , DefaultMoveAddressValidGroup.class
            , OrgIdValidGroup.class
            , RemarksValidGroup.class
            , IsManualCreationValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
