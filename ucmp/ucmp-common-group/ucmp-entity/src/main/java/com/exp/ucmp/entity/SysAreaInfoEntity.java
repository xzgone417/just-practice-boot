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

@ApiModel(value = "SysAreaInfoEntity", description = "区域信息表")
@GroupSequence({SysAreaInfoEntity.class, SysAreaInfoEntity.SysAreaInfoEntityValidGroup.class,SysAreaInfoEntity.AreaIdValidGroup.class,SysAreaInfoEntity.AreaCodeValidGroup.class,SysAreaInfoEntity.AreaNameValidGroup.class,SysAreaInfoEntity.CreatedByValidGroup.class,SysAreaInfoEntity.CreatedDateValidGroup.class,SysAreaInfoEntity.UpdatedByValidGroup.class,SysAreaInfoEntity.UpdatedDateValidGroup.class}) 
public class SysAreaInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 区域标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "区域标识 不能是Null", groups = {SysAreaInfoEntityValidGroup.class, AreaIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="区域标识 数字精度必须符合(19,0)", groups = {SysAreaInfoEntityValidGroup.class, AreaIdValidGroup.class})
    @ApiModelProperty(value = "区域标识")
    private Long areaId;
    
    
    /**
     * 区域编码
     */
    @NotNull(message = "区域编码 不能是Null", groups = {SysAreaInfoEntityValidGroup.class, AreaCodeValidGroup.class})
    @Size(min=0, max=20, message="区域编码 字符长度必须小于等于20", groups = {SysAreaInfoEntityValidGroup.class, AreaCodeValidGroup.class})
    @ApiModelProperty(value = "区域编码")
    private String areaCode;
    
    /**
     * 区域名称
     */
    @NotNull(message = "区域名称 不能是Null", groups = {SysAreaInfoEntityValidGroup.class, AreaNameValidGroup.class})
    @Size(min=0, max=30, message="区域名称 字符长度必须小于等于30", groups = {SysAreaInfoEntityValidGroup.class, AreaNameValidGroup.class})
    @ApiModelProperty(value = "区域名称")
    private String areaName;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysAreaInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysAreaInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysAreaInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysAreaInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysAreaInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysAreaInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysAreaInfoEntity() {
    }
    
    public SysAreaInfoEntity(Long areaId) {
        this.areaId = areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
    public Long getAreaId() {
        return this.areaId;
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
              (areaId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                areaId = RandomIDGennerator.get().generate();
    }

    public interface SysAreaInfoEntityValidGroup {}
    public interface AreaIdValidGroup {}
    public interface AreaCodeValidGroup {}
    public interface AreaNameValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            AreaIdValidGroup.class
            , AreaCodeValidGroup.class
            , AreaNameValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
