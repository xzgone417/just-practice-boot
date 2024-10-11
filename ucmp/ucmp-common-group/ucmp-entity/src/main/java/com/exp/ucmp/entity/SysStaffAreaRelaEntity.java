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

@ApiModel(value = "SysStaffAreaRelaEntity", description = "区域人员关系表")
@GroupSequence({SysStaffAreaRelaEntity.class, SysStaffAreaRelaEntity.SysStaffAreaRelaEntityValidGroup.class,SysStaffAreaRelaEntity.RelaIdValidGroup.class,SysStaffAreaRelaEntity.PartyIdValidGroup.class,SysStaffAreaRelaEntity.AreaIdValidGroup.class,SysStaffAreaRelaEntity.CreatedByValidGroup.class,SysStaffAreaRelaEntity.CreatedDateValidGroup.class,SysStaffAreaRelaEntity.UpdatedByValidGroup.class,SysStaffAreaRelaEntity.UpdatedDateValidGroup.class}) 
public class SysStaffAreaRelaEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键 不能是Null", groups = {SysStaffAreaRelaEntityValidGroup.class, RelaIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键 数字精度必须符合(19,0)", groups = {SysStaffAreaRelaEntityValidGroup.class, RelaIdValidGroup.class})
    @ApiModelProperty(value = "主键")
    private Long relaId;
    
    
    /**
     * 人员标识
     */
    @NotNull(message = "人员标识 不能是Null", groups = {SysStaffAreaRelaEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="人员标识 数字精度必须符合(19,0)", groups = {SysStaffAreaRelaEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "人员标识")
    private Long partyId;
    
    /**
     * 区域标识
     */
    @NotNull(message = "区域标识 不能是Null", groups = {SysStaffAreaRelaEntityValidGroup.class, AreaIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="区域标识 数字精度必须符合(19,0)", groups = {SysStaffAreaRelaEntityValidGroup.class, AreaIdValidGroup.class})
    @ApiModelProperty(value = "区域标识")
    private Long areaId;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysStaffAreaRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysStaffAreaRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysStaffAreaRelaEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysStaffAreaRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysStaffAreaRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysStaffAreaRelaEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysStaffAreaRelaEntity() {
    }
    
    public SysStaffAreaRelaEntity(Long relaId) {
        this.relaId = relaId;
    }

    public void setRelaId(Long relaId) {
        this.relaId = relaId;
    }
    public Long getRelaId() {
        return this.relaId;
    }
    

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
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

    public interface SysStaffAreaRelaEntityValidGroup {}
    public interface RelaIdValidGroup {}
    public interface PartyIdValidGroup {}
    public interface AreaIdValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RelaIdValidGroup.class
            , PartyIdValidGroup.class
            , AreaIdValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
