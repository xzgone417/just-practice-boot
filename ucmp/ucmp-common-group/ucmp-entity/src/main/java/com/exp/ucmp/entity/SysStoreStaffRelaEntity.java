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

@ApiModel(value = "SysStoreStaffRelaEntity", description = "门店人员关系表")
@GroupSequence({SysStoreStaffRelaEntity.class, SysStoreStaffRelaEntity.SysStoreStaffRelaEntityValidGroup.class,SysStoreStaffRelaEntity.RelaIdValidGroup.class,SysStoreStaffRelaEntity.StoreIdValidGroup.class,SysStoreStaffRelaEntity.PartyIdValidGroup.class,SysStoreStaffRelaEntity.CreatedByValidGroup.class,SysStoreStaffRelaEntity.CreatedDateValidGroup.class,SysStoreStaffRelaEntity.UpdatedByValidGroup.class,SysStoreStaffRelaEntity.UpdatedDateValidGroup.class}) 
public class SysStoreStaffRelaEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键 不能是Null", groups = {SysStoreStaffRelaEntityValidGroup.class, RelaIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键 数字精度必须符合(19,0)", groups = {SysStoreStaffRelaEntityValidGroup.class, RelaIdValidGroup.class})
    @ApiModelProperty(value = "主键")
    private Long relaId;
    
    
    /**
     * 门店标识
     */
    @NotNull(message = "门店标识 不能是Null", groups = {SysStoreStaffRelaEntityValidGroup.class, StoreIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="门店标识 数字精度必须符合(19,0)", groups = {SysStoreStaffRelaEntityValidGroup.class, StoreIdValidGroup.class})
    @ApiModelProperty(value = "门店标识")
    private Long storeId;
    
    /**
     * 当事人标识
     */
    @NotNull(message = "当事人标识 不能是Null", groups = {SysStoreStaffRelaEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="当事人标识 数字精度必须符合(19,0)", groups = {SysStoreStaffRelaEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "当事人标识")
    private Long partyId;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysStoreStaffRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysStoreStaffRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysStoreStaffRelaEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysStoreStaffRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysStoreStaffRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysStoreStaffRelaEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysStoreStaffRelaEntity() {
    }
    
    public SysStoreStaffRelaEntity(Long relaId) {
        this.relaId = relaId;
    }

    public void setRelaId(Long relaId) {
        this.relaId = relaId;
    }
    public Long getRelaId() {
        return this.relaId;
    }
    

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Long getStoreId() {
        return this.storeId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
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

    public interface SysStoreStaffRelaEntityValidGroup {}
    public interface RelaIdValidGroup {}
    public interface StoreIdValidGroup {}
    public interface PartyIdValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RelaIdValidGroup.class
            , StoreIdValidGroup.class
            , PartyIdValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
