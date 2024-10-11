package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "SysAreaRegionRelaEntity", description = "区域省份关系表")
@GroupSequence({SysAreaRegionRelaEntity.class, SysAreaRegionRelaEntity.SysAreaRegionRelaEntityValidGroup.class,SysAreaRegionRelaEntity.RelaIdValidGroup.class,SysAreaRegionRelaEntity.RegionCodeValidGroup.class,SysAreaRegionRelaEntity.AreaIdValidGroup.class,SysAreaRegionRelaEntity.CreatedByValidGroup.class,SysAreaRegionRelaEntity.CreatedDateValidGroup.class,SysAreaRegionRelaEntity.UpdatedByValidGroup.class,SysAreaRegionRelaEntity.UpdatedDateValidGroup.class}) 
public class SysAreaRegionRelaEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键 不能是Null", groups = {SysAreaRegionRelaEntityValidGroup.class, RelaIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键 数字精度必须符合(19,0)", groups = {SysAreaRegionRelaEntityValidGroup.class, RelaIdValidGroup.class})
    @ApiModelProperty(value = "主键")
    private Long relaId;
    
    
    /**
     * 行政区域编码
     */
    @NotNull(message = "行政区域编码 不能是Null", groups = {SysAreaRegionRelaEntityValidGroup.class, RegionCodeValidGroup.class})
    @Digits(integer=19, fraction=0, message="行政区域编码 数字精度必须符合(19,0)", groups = {SysAreaRegionRelaEntityValidGroup.class, RegionCodeValidGroup.class})
    @ApiModelProperty(value = "行政区域编码")
    private Long regionCode;
    
    /**
     * 区域标识
     */
    @NotNull(message = "区域标识 不能是Null", groups = {SysAreaRegionRelaEntityValidGroup.class, AreaIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="区域标识 数字精度必须符合(19,0)", groups = {SysAreaRegionRelaEntityValidGroup.class, AreaIdValidGroup.class})
    @ApiModelProperty(value = "区域标识")
    private Long areaId;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysAreaRegionRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysAreaRegionRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysAreaRegionRelaEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysAreaRegionRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysAreaRegionRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysAreaRegionRelaEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysAreaRegionRelaEntity() {
    }
    
    public SysAreaRegionRelaEntity(Long relaId) {
        this.relaId = relaId;
    }

    public void setRelaId(Long relaId) {
        this.relaId = relaId;
    }
    public Long getRelaId() {
        return this.relaId;
    }
    

    public void setRegionCode(Long regionCode) {
        this.regionCode = regionCode;
    }
    public Long getRegionCode() {
        return this.regionCode;
    }
    
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
    public Long getAreaId() {
        return this.areaId;
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
              (relaId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                relaId = RandomIDGennerator.get().generate();
    }

    public interface SysAreaRegionRelaEntityValidGroup {}
    public interface RelaIdValidGroup {}
    public interface RegionCodeValidGroup {}
    public interface AreaIdValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RelaIdValidGroup.class
            , RegionCodeValidGroup.class
            , AreaIdValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
