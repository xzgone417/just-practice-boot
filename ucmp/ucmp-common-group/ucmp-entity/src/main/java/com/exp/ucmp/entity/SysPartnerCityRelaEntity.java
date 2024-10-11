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

@ApiModel(value = "SysPartnerCityRelaEntity", description = "合作商管辖城市表")
@GroupSequence({SysPartnerCityRelaEntity.class, SysPartnerCityRelaEntity.SysPartnerCityRelaEntityValidGroup.class,SysPartnerCityRelaEntity.CityIdValidGroup.class,SysPartnerCityRelaEntity.PartnerIdValidGroup.class,SysPartnerCityRelaEntity.RegionCodeValidGroup.class,SysPartnerCityRelaEntity.CityAreaValidGroup.class,SysPartnerCityRelaEntity.CityProvinceValidGroup.class,SysPartnerCityRelaEntity.CityNameValidGroup.class,SysPartnerCityRelaEntity.CreatedByValidGroup.class,SysPartnerCityRelaEntity.CreatedDateValidGroup.class,SysPartnerCityRelaEntity.UpdatedByValidGroup.class,SysPartnerCityRelaEntity.UpdatedDateValidGroup.class}) 
public class SysPartnerCityRelaEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 城市标识/主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "城市标识/主键 不能是Null", groups = {SysPartnerCityRelaEntityValidGroup.class, CityIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="城市标识/主键 数字精度必须符合(19,0)", groups = {SysPartnerCityRelaEntityValidGroup.class, CityIdValidGroup.class})
    @ApiModelProperty(value = "城市标识/主键")
    private Long cityId;
    
    
    /**
     * 合作商标识
     */
    @NotNull(message = "合作商标识 不能是Null", groups = {SysPartnerCityRelaEntityValidGroup.class, PartnerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="合作商标识 数字精度必须符合(19,0)", groups = {SysPartnerCityRelaEntityValidGroup.class, PartnerIdValidGroup.class})
    @ApiModelProperty(value = "合作商标识")
    private Long partnerId;
    
    /**
     * 行政区域编码
     */
    @NotNull(message = "行政区域编码 不能是Null", groups = {SysPartnerCityRelaEntityValidGroup.class, RegionCodeValidGroup.class})
    @Digits(integer=19, fraction=0, message="行政区域编码 数字精度必须符合(19,0)", groups = {SysPartnerCityRelaEntityValidGroup.class, RegionCodeValidGroup.class})
    @ApiModelProperty(value = "行政区域编码")
    private Long regionCode;
    
    /**
     * 区域
     */
    @NotNull(message = "区域 不能是Null", groups = {SysPartnerCityRelaEntityValidGroup.class, CityAreaValidGroup.class})
    @Size(min=0, max=20, message="区域 字符长度必须小于等于20", groups = {SysPartnerCityRelaEntityValidGroup.class, CityAreaValidGroup.class})
    @ApiModelProperty(value = "区域")
    private String cityArea;
    
    /**
     * 省份
     */
    @NotNull(message = "省份 不能是Null", groups = {SysPartnerCityRelaEntityValidGroup.class, CityProvinceValidGroup.class})
    @Size(min=0, max=20, message="省份 字符长度必须小于等于20", groups = {SysPartnerCityRelaEntityValidGroup.class, CityProvinceValidGroup.class})
    @ApiModelProperty(value = "省份")
    private String cityProvince;
    
    /**
     * 城市名称
     */
    @NotNull(message = "城市名称 不能是Null", groups = {SysPartnerCityRelaEntityValidGroup.class, CityNameValidGroup.class})
    @Size(min=0, max=50, message="城市名称 字符长度必须小于等于50", groups = {SysPartnerCityRelaEntityValidGroup.class, CityNameValidGroup.class})
    @ApiModelProperty(value = "城市名称")
    private String cityName;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysPartnerCityRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysPartnerCityRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysPartnerCityRelaEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysPartnerCityRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysPartnerCityRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysPartnerCityRelaEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysPartnerCityRelaEntity() {
    }
    
    public SysPartnerCityRelaEntity(Long cityId) {
        this.cityId = cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    public Long getCityId() {
        return this.cityId;
    }
    

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
    public Long getPartnerId() {
        return this.partnerId;
    }
    
    public void setRegionCode(Long regionCode) {
        this.regionCode = regionCode;
    }
    public Long getRegionCode() {
        return this.regionCode;
    }
    
    public void setCityArea(String cityArea) {
        this.cityArea = cityArea;
    }
    public String getCityArea() {
        return this.cityArea;
    }
    
    public void setCityProvince(String cityProvince) {
        this.cityProvince = cityProvince;
    }
    public String getCityProvince() {
        return this.cityProvince;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCityName() {
        return this.cityName;
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
              (cityId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                cityId = RandomIDGennerator.get().generate();
    }

    public interface SysPartnerCityRelaEntityValidGroup {}
    public interface CityIdValidGroup {}
    public interface PartnerIdValidGroup {}
    public interface RegionCodeValidGroup {}
    public interface CityAreaValidGroup {}
    public interface CityProvinceValidGroup {}
    public interface CityNameValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            CityIdValidGroup.class
            , PartnerIdValidGroup.class
            , RegionCodeValidGroup.class
            , CityAreaValidGroup.class
            , CityProvinceValidGroup.class
            , CityNameValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
