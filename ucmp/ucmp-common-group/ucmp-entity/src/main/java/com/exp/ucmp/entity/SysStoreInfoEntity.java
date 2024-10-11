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

@ApiModel(value = "SysStoreInfoEntity", description = "门店信息表")
@GroupSequence({SysStoreInfoEntity.class, SysStoreInfoEntity.SysStoreInfoEntityValidGroup.class,SysStoreInfoEntity.StoreIdValidGroup.class,SysStoreInfoEntity.OrgIdValidGroup.class,SysStoreInfoEntity.OrgCodeValidGroup.class,SysStoreInfoEntity.OrgNameValidGroup.class,SysStoreInfoEntity.OrgTypeValidGroup.class,SysStoreInfoEntity.OrgTypeNameValidGroup.class,SysStoreInfoEntity.ParentOrgIdValidGroup.class,SysStoreInfoEntity.DlrShortNameValidGroup.class,SysStoreInfoEntity.DlrFullNameValidGroup.class,SysStoreInfoEntity.DlrTypeValidGroup.class,SysStoreInfoEntity.DlrEnNameValidGroup.class,SysStoreInfoEntity.LinkAddrValidGroup.class,SysStoreInfoEntity.ProvinceIdValidGroup.class,SysStoreInfoEntity.ProvinceValidGroup.class,SysStoreInfoEntity.CityIdValidGroup.class,SysStoreInfoEntity.CityValidGroup.class,SysStoreInfoEntity.AreaCodeValidGroup.class,SysStoreInfoEntity.AreaNameValidGroup.class,SysStoreInfoEntity.CountyIdValidGroup.class,SysStoreInfoEntity.SaleTelValidGroup.class,SysStoreInfoEntity.DlrStatusValidGroup.class,SysStoreInfoEntity.OnlineTimeValidGroup.class,SysStoreInfoEntity.ShutDownDateValidGroup.class,SysStoreInfoEntity.LngValidGroup.class,SysStoreInfoEntity.LatValidGroup.class,SysStoreInfoEntity.BusinessTimeValidGroup.class,SysStoreInfoEntity.IsDriveValidGroup.class,SysStoreInfoEntity.IsCShowValidGroup.class,SysStoreInfoEntity.DlrCodeValidGroup.class,SysStoreInfoEntity.OrderNoValidGroup.class,SysStoreInfoEntity.SyncIsEnableValidGroup.class,SysStoreInfoEntity.IsEnableValidGroup.class,SysStoreInfoEntity.RemarkValidGroup.class,SysStoreInfoEntity.CreatedByValidGroup.class,SysStoreInfoEntity.CreatedDateValidGroup.class,SysStoreInfoEntity.UpdatedByValidGroup.class,SysStoreInfoEntity.UpdatedDateValidGroup.class}) 
public class SysStoreInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = " 不能是Null", groups = {SysStoreInfoEntityValidGroup.class, StoreIdValidGroup.class})
    @Digits(integer=19, fraction=0, message=" 数字精度必须符合(19,0)", groups = {SysStoreInfoEntityValidGroup.class, StoreIdValidGroup.class})
    @ApiModelProperty(value = "")
    private Long storeId;
    
    
    /**
     * 门店id
     */
    @Size(min=0, max=20, message="门店id 字符长度必须小于等于20", groups = {SysStoreInfoEntityValidGroup.class, OrgIdValidGroup.class})
    @ApiModelProperty(value = "门店id")
    private String orgId;
    
    /**
     * 门店编码
     */
    @Size(min=0, max=20, message="门店编码 字符长度必须小于等于20", groups = {SysStoreInfoEntityValidGroup.class, OrgCodeValidGroup.class})
    @ApiModelProperty(value = "门店编码")
    private String orgCode;
    
    @ApiModelProperty(value = "门店代码")
    private String storeCode;
    
    /**
     * 门店名称
     */
    @Size(min=0, max=50, message="门店名称 字符长度必须小于等于50", groups = {SysStoreInfoEntityValidGroup.class, OrgNameValidGroup.class})
    @ApiModelProperty(value = "门店名称")
    private String orgName;
    
    /**
     * 门店类型(1:总公司;2:大区;3:子公司;4:交付中心;5:高合中心)
     */
    @Size(min=0, max=10, message="门店类型(1:总公司;2:大区;3:子公司;4:交付中心;5:高合中心) 字符长度必须小于等于10", groups = {SysStoreInfoEntityValidGroup.class, OrgTypeValidGroup.class})
    @ApiModelProperty(value = "门店类型(1:总公司;2:大区;3:子公司;4:交付中心;5:高合中心)")
    private String orgType;
    
    /**
     * 门店类型名称
     */
    @Size(min=0, max=20, message="门店类型名称 字符长度必须小于等于20", groups = {SysStoreInfoEntityValidGroup.class, OrgTypeNameValidGroup.class})
    @ApiModelProperty(value = "门店类型名称")
    private String orgTypeName;
    
    /**
     * 门店上级id
     */
    @Size(min=0, max=50, message="门店上级id 字符长度必须小于等于50", groups = {SysStoreInfoEntityValidGroup.class, ParentOrgIdValidGroup.class})
    @ApiModelProperty(value = "门店上级id")
    private String parentOrgId;
    
    /**
     * 网点简称
     */
    @Size(min=0, max=50, message="网点简称 字符长度必须小于等于50", groups = {SysStoreInfoEntityValidGroup.class, DlrShortNameValidGroup.class})
    @ApiModelProperty(value = "网点简称")
    private String dlrShortName;
    
    /**
     * 网点全称
     */
    @Size(min=0, max=200, message="网点全称 字符长度必须小于等于200", groups = {SysStoreInfoEntityValidGroup.class, DlrFullNameValidGroup.class})
    @ApiModelProperty(value = "网点全称")
    private String dlrFullName;
    
    /**
     * 网点类型
     */
    @Size(min=0, max=10, message="网点类型 字符长度必须小于等于10", groups = {SysStoreInfoEntityValidGroup.class, DlrTypeValidGroup.class})
    @ApiModelProperty(value = "网点类型")
    private String dlrType;
    
    /**
     * 网点英文名
     */
    @Size(min=0, max=200, message="网点英文名 字符长度必须小于等于200", groups = {SysStoreInfoEntityValidGroup.class, DlrEnNameValidGroup.class})
    @ApiModelProperty(value = "网点英文名")
    private String dlrEnName;
    
    /**
     * 详细地址
     */
    @Size(min=0, max=200, message="详细地址 字符长度必须小于等于200", groups = {SysStoreInfoEntityValidGroup.class, LinkAddrValidGroup.class})
    @ApiModelProperty(value = "详细地址")
    private String linkAddr;
    
    /**
     * 省份(ID)
     */
    @Size(min=0, max=11, message="省份(ID) 字符长度必须小于等于11", groups = {SysStoreInfoEntityValidGroup.class, ProvinceIdValidGroup.class})
    @ApiModelProperty(value = "省份(ID)")
    private String provinceId;
    
    /**
     * 省份
     */
    @Size(min=0, max=50, message="省份 字符长度必须小于等于50", groups = {SysStoreInfoEntityValidGroup.class, ProvinceValidGroup.class})
    @ApiModelProperty(value = "省份")
    private String province;
    
    /**
     * 城市(ID)
     */
    @Size(min=0, max=11, message="城市(ID) 字符长度必须小于等于11", groups = {SysStoreInfoEntityValidGroup.class, CityIdValidGroup.class})
    @ApiModelProperty(value = "城市(ID)")
    private String cityId;
    
    /**
     * 城市
     */
    @Size(min=0, max=50, message="城市 字符长度必须小于等于50", groups = {SysStoreInfoEntityValidGroup.class, CityValidGroup.class})
    @ApiModelProperty(value = "城市")
    private String city;
    
    /**
     * 区域编码
     */
    @Size(min=0, max=20, message="区域编码 字符长度必须小于等于20", groups = {SysStoreInfoEntityValidGroup.class, AreaCodeValidGroup.class})
    @ApiModelProperty(value = "区域编码")
    private String areaCode;
    
    /**
     * 区域名称
     */
    @Size(min=0, max=30, message="区域名称 字符长度必须小于等于30", groups = {SysStoreInfoEntityValidGroup.class, AreaNameValidGroup.class})
    @ApiModelProperty(value = "区域名称")
    private String areaName;
    
    /**
     * 区县(ID)
     */
    @Size(min=0, max=11, message="区县(ID) 字符长度必须小于等于11", groups = {SysStoreInfoEntityValidGroup.class, CountyIdValidGroup.class})
    @ApiModelProperty(value = "区县(ID)")
    private String countyId;
    
    /**
     * 销售热线电话
     */
    @Size(min=0, max=200, message="销售热线电话 字符长度必须小于等于200", groups = {SysStoreInfoEntityValidGroup.class, SaleTelValidGroup.class})
    @ApiModelProperty(value = "销售热线电话")
    private String saleTel;
    
    /**
     * 开业状态
     */
    @Size(min=0, max=5, message="开业状态 字符长度必须小于等于5", groups = {SysStoreInfoEntityValidGroup.class, DlrStatusValidGroup.class})
    @ApiModelProperty(value = "开业状态")
    private String dlrStatus;
    
    /**
     * 上线时间
     */
    @Size(min=0, max=23, message="上线时间 字符长度必须小于等于23", groups = {SysStoreInfoEntityValidGroup.class, OnlineTimeValidGroup.class})
    @ApiModelProperty(value = "上线时间")
    private String onlineTime;
    
    /**
     * 停业时间
     */
    @Size(min=0, max=23, message="停业时间 字符长度必须小于等于23", groups = {SysStoreInfoEntityValidGroup.class, ShutDownDateValidGroup.class})
    @ApiModelProperty(value = "停业时间")
    private String shutDownDate;
    
    /**
     * 经度
     */
    @Size(min=0, max=20, message="经度 字符长度必须小于等于20", groups = {SysStoreInfoEntityValidGroup.class, LngValidGroup.class})
    @ApiModelProperty(value = "经度")
    private String lng;
    
    /**
     * 纬度
     */
    @Size(min=0, max=20, message="纬度 字符长度必须小于等于20", groups = {SysStoreInfoEntityValidGroup.class, LatValidGroup.class})
    @ApiModelProperty(value = "纬度")
    private String lat;
    
    /**
     * 营业时间
     */
    @Size(min=0, max=20, message="营业时间 字符长度必须小于等于20", groups = {SysStoreInfoEntityValidGroup.class, BusinessTimeValidGroup.class})
    @ApiModelProperty(value = "营业时间")
    private String businessTime;
    
    /**
     * 是否试驾
     */
    @Size(min=0, max=2, message="是否试驾 字符长度必须小于等于2", groups = {SysStoreInfoEntityValidGroup.class, IsDriveValidGroup.class})
    @ApiModelProperty(value = "是否试驾")
    private String isDrive;
    
    /**
     * 是否在C端露出
     */
    @Size(min=0, max=2, message="是否在C端露出 字符长度必须小于等于2", groups = {SysStoreInfoEntityValidGroup.class, IsCShowValidGroup.class})
    @ApiModelProperty(value = "是否在C端露出")
    private String isCShow;
    
    /**
     * 门店所属交付中心编码
     */
    @Size(min=0, max=20, message="门店所属交付中心编码 字符长度必须小于等于20", groups = {SysStoreInfoEntityValidGroup.class, DlrCodeValidGroup.class})
    @ApiModelProperty(value = "门店所属交付中心编码")
    private String dlrCode;
    
    /**
     * 排序(ID)
     */
    @Size(min=0, max=10, message="排序(ID) 字符长度必须小于等于10", groups = {SysStoreInfoEntityValidGroup.class, OrderNoValidGroup.class})
    @ApiModelProperty(value = "排序(ID)")
    private String orderNo;
    
    /**
     * 同步过来的状态00、无效，01、有效
     */
    @NotNull(message = "同步过来的状态00、无效，01、有效 不能是Null", groups = {SysStoreInfoEntityValidGroup.class, SyncIsEnableValidGroup.class})
    @Size(min=0, max=20, message="同步过来的状态00、无效，01、有效 字符长度必须小于等于20", groups = {SysStoreInfoEntityValidGroup.class, SyncIsEnableValidGroup.class})
    @ApiModelProperty(value = "同步过来的状态00、无效，01、有效")
    private String syncIsEnable;
    
    /**
     * 是否可用(00:禁用/01:启用)
     */
    @Size(min=0, max=45, message="是否可用(00:禁用/01:启用) 字符长度必须小于等于45", groups = {SysStoreInfoEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用(00:禁用/01:启用)")
    private String isEnable;
    
    /**
     * 
     */
    @Size(min=0, max=200, message=" 字符长度必须小于等于200", groups = {SysStoreInfoEntityValidGroup.class, RemarkValidGroup.class})
    @ApiModelProperty(value = "")
    private String remark;

    /**
     * 官二资质状态（启用1/禁用0）
     */
    @Size(min=0, max=1, message="官二资质状态(00:禁用/01:启用)", groups = {SysStoreInfoEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "官二资质状态（启用01/禁用00）")
    private String qualificationStatus;

    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysStoreInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysStoreInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysStoreInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysStoreInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysStoreInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysStoreInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysStoreInfoEntity() {
    }
    
    public SysStoreInfoEntity(Long storeId) {
        this.storeId = storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Long getStoreId() {
        return this.storeId;
    }
    

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
    public String getOrgId() {
        return this.orgId;
    }
    
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }
    public String getOrgCode() {
        return this.orgCode;
    }
    
    public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    public String getOrgName() {
        return this.orgName;
    }
    
    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }
    public String getOrgType() {
        return this.orgType;
    }
    
    public void setOrgTypeName(String orgTypeName) {
        this.orgTypeName = orgTypeName;
    }
    public String getOrgTypeName() {
        return this.orgTypeName;
    }
    
    public void setParentOrgId(String parentOrgId) {
        this.parentOrgId = parentOrgId;
    }
    public String getParentOrgId() {
        return this.parentOrgId;
    }
    
    public void setDlrShortName(String dlrShortName) {
        this.dlrShortName = dlrShortName;
    }
    public String getDlrShortName() {
        return this.dlrShortName;
    }
    
    public void setDlrFullName(String dlrFullName) {
        this.dlrFullName = dlrFullName;
    }
    public String getDlrFullName() {
        return this.dlrFullName;
    }
    
    public void setDlrType(String dlrType) {
        this.dlrType = dlrType;
    }
    public String getDlrType() {
        return this.dlrType;
    }
    
    public void setDlrEnName(String dlrEnName) {
        this.dlrEnName = dlrEnName;
    }
    public String getDlrEnName() {
        return this.dlrEnName;
    }
    
    public void setLinkAddr(String linkAddr) {
        this.linkAddr = linkAddr;
    }
    public String getLinkAddr() {
        return this.linkAddr;
    }
    
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }
    public String getProvinceId() {
        return this.provinceId;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    public String getProvince() {
        return this.province;
    }
    
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }
    public String getCityId() {
        return this.cityId;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return this.city;
    }
    
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    public String getAreaCode() {
        return this.areaCode;
    }
    
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public String getAreaName() {
        return this.areaName;
    }
    
    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }
    public String getCountyId() {
        return this.countyId;
    }
    
    public void setSaleTel(String saleTel) {
        this.saleTel = saleTel;
    }
    public String getSaleTel() {
        return this.saleTel;
    }
    
    public void setDlrStatus(String dlrStatus) {
        this.dlrStatus = dlrStatus;
    }
    public String getDlrStatus() {
        return this.dlrStatus;
    }
    
    public void setOnlineTime(String onlineTime) {
        this.onlineTime = onlineTime;
    }
    public String getOnlineTime() {
        return this.onlineTime;
    }
    
    public void setShutDownDate(String shutDownDate) {
        this.shutDownDate = shutDownDate;
    }
    public String getShutDownDate() {
        return this.shutDownDate;
    }
    
    public void setLng(String lng) {
        this.lng = lng;
    }
    public String getLng() {
        return this.lng;
    }
    
    public void setLat(String lat) {
        this.lat = lat;
    }
    public String getLat() {
        return this.lat;
    }
    
    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }
    public String getBusinessTime() {
        return this.businessTime;
    }
    
    public void setIsDrive(String isDrive) {
        this.isDrive = isDrive;
    }
    public String getIsDrive() {
        return this.isDrive;
    }
    
    public void setIsCShow(String isCShow) {
        this.isCShow = isCShow;
    }
    public String getIsCShow() {
        return this.isCShow;
    }
    
    public void setDlrCode(String dlrCode) {
        this.dlrCode = dlrCode;
    }
    public String getDlrCode() {
        return this.dlrCode;
    }
    
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getOrderNo() {
        return this.orderNo;
    }
    
    public void setSyncIsEnable(String syncIsEnable) {
        this.syncIsEnable = syncIsEnable;
    }
    public String getSyncIsEnable() {
        return this.syncIsEnable;
    }
    
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public String getIsEnable() {
        return this.isEnable;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getRemark() {
        return this.remark;
    }

    public String getQualificationStatus() {
        return qualificationStatus;
    }
    public void setQualificationStatus(String qualificationStatus) {
        this.qualificationStatus = qualificationStatus;
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
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (storeId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                storeId = RandomIDGennerator.get().generate();
    }

    public interface SysStoreInfoEntityValidGroup {}
    public interface StoreIdValidGroup {}
    public interface OrgIdValidGroup {}
    public interface OrgCodeValidGroup {}
    public interface OrgNameValidGroup {}
    public interface OrgTypeValidGroup {}
    public interface OrgTypeNameValidGroup {}
    public interface ParentOrgIdValidGroup {}
    public interface DlrShortNameValidGroup {}
    public interface DlrFullNameValidGroup {}
    public interface DlrTypeValidGroup {}
    public interface DlrEnNameValidGroup {}
    public interface LinkAddrValidGroup {}
    public interface ProvinceIdValidGroup {}
    public interface ProvinceValidGroup {}
    public interface CityIdValidGroup {}
    public interface CityValidGroup {}
    public interface AreaCodeValidGroup {}
    public interface AreaNameValidGroup {}
    public interface CountyIdValidGroup {}
    public interface SaleTelValidGroup {}
    public interface DlrStatusValidGroup {}
    public interface OnlineTimeValidGroup {}
    public interface ShutDownDateValidGroup {}
    public interface LngValidGroup {}
    public interface LatValidGroup {}
    public interface BusinessTimeValidGroup {}
    public interface IsDriveValidGroup {}
    public interface IsCShowValidGroup {}
    public interface DlrCodeValidGroup {}
    public interface OrderNoValidGroup {}
    public interface SyncIsEnableValidGroup {}
    public interface IsEnableValidGroup {}
    public interface RemarkValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            StoreIdValidGroup.class
            , OrgIdValidGroup.class
            , OrgCodeValidGroup.class
            , OrgNameValidGroup.class
            , OrgTypeValidGroup.class
            , OrgTypeNameValidGroup.class
            , ParentOrgIdValidGroup.class
            , DlrShortNameValidGroup.class
            , DlrFullNameValidGroup.class
            , DlrTypeValidGroup.class
            , DlrEnNameValidGroup.class
            , LinkAddrValidGroup.class
            , ProvinceIdValidGroup.class
            , ProvinceValidGroup.class
            , CityIdValidGroup.class
            , CityValidGroup.class
            , AreaCodeValidGroup.class
            , AreaNameValidGroup.class
            , CountyIdValidGroup.class
            , SaleTelValidGroup.class
            , DlrStatusValidGroup.class
            , OnlineTimeValidGroup.class
            , ShutDownDateValidGroup.class
            , LngValidGroup.class
            , LatValidGroup.class
            , BusinessTimeValidGroup.class
            , IsDriveValidGroup.class
            , IsCShowValidGroup.class
            , DlrCodeValidGroup.class
            , OrderNoValidGroup.class
            , SyncIsEnableValidGroup.class
            , IsEnableValidGroup.class
            , RemarkValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
