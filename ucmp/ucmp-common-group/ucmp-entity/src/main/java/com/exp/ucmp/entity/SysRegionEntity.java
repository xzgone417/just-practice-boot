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

@ApiModel(value = "SysRegionEntity", description = "行政区域字典表")
@GroupSequence({SysRegionEntity.class, SysRegionEntity.SysRegionEntityValidGroup.class,SysRegionEntity.RegionCodeValidGroup.class,SysRegionEntity.RegionNameValidGroup.class,SysRegionEntity.RegionLevelValidGroup.class,SysRegionEntity.ParentCodeValidGroup.class,SysRegionEntity.CreatedByValidGroup.class,SysRegionEntity.CreatedDateValidGroup.class,SysRegionEntity.UpdatedByValidGroup.class,SysRegionEntity.UpdatedDateValidGroup.class}) 
public class SysRegionEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 区划代码
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "区划代码 不能是Null", groups = {SysRegionEntityValidGroup.class, RegionCodeValidGroup.class})
    @Digits(integer=20, fraction=0, message="区划代码 数字精度必须符合(20,0)", groups = {SysRegionEntityValidGroup.class, RegionCodeValidGroup.class})
    @ApiModelProperty(value = "区划代码")
    private Long regionCode;
    
    
    /**
     * 名称
     */
    @NotNull(message = "名称 不能是Null", groups = {SysRegionEntityValidGroup.class, RegionNameValidGroup.class})
    @Size(min=0, max=128, message="名称 字符长度必须小于等于128", groups = {SysRegionEntityValidGroup.class, RegionNameValidGroup.class})
    @ApiModelProperty(value = "名称")
    private String regionName;
    
    /**
     * 级别1-5,省市县镇村
     */
    @NotNull(message = "级别1-5,省市县镇村 不能是Null", groups = {SysRegionEntityValidGroup.class, RegionLevelValidGroup.class})
    @ApiModelProperty(value = "级别1-5,省市县镇村")
    private Integer regionLevel;
    
    /**
     * 父级区划代码
     */
    @Digits(integer=19, fraction=0, message="父级区划代码 数字精度必须符合(19,0)", groups = {SysRegionEntityValidGroup.class, ParentCodeValidGroup.class})
    @ApiModelProperty(value = "父级区划代码")
    private Long parentCode;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysRegionEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysRegionEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysRegionEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysRegionEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysRegionEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysRegionEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysRegionEntity() {
    }
    
    public SysRegionEntity(Long regionCode) {
        this.regionCode = regionCode;
    }

    public void setRegionCode(Long regionCode) {
        this.regionCode = regionCode;
    }
    public Long getRegionCode() {
        return this.regionCode;
    }
    

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    public String getRegionName() {
        return this.regionName;
    }
    
    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }
    public Integer getRegionLevel() {
        return this.regionLevel;
    }
    
    public void setParentCode(Long parentCode) {
        this.parentCode = parentCode;
    }
    public Long getParentCode() {
        return this.parentCode;
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
              (regionCode == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                regionCode = RandomIDGennerator.get().generate();
    }

    public interface SysRegionEntityValidGroup {}
    public interface RegionCodeValidGroup {}
    public interface RegionNameValidGroup {}
    public interface RegionLevelValidGroup {}
    public interface ParentCodeValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RegionCodeValidGroup.class
            , RegionNameValidGroup.class
            , RegionLevelValidGroup.class
            , ParentCodeValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
