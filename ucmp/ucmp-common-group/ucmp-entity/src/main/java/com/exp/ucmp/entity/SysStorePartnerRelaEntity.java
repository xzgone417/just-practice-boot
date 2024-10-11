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

@ApiModel(value = "SysStorePartnerRelaEntity", description = "门店车商关系表")
@GroupSequence({SysStorePartnerRelaEntity.class, SysStorePartnerRelaEntity.SysStorePartnerRelaEntityValidGroup.class,SysStorePartnerRelaEntity.RelaIdValidGroup.class,SysStorePartnerRelaEntity.StoreIdValidGroup.class,SysStorePartnerRelaEntity.PartnerIdValidGroup.class,SysStorePartnerRelaEntity.CreatedByValidGroup.class,SysStorePartnerRelaEntity.CreatedDateValidGroup.class,SysStorePartnerRelaEntity.UpdatedByValidGroup.class,SysStorePartnerRelaEntity.UpdatedDateValidGroup.class,SysStorePartnerRelaEntity.IsEnableValidGroup.class}) 
public class SysStorePartnerRelaEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键 不能是Null", groups = {SysStorePartnerRelaEntityValidGroup.class, RelaIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键 数字精度必须符合(19,0)", groups = {SysStorePartnerRelaEntityValidGroup.class, RelaIdValidGroup.class})
    @ApiModelProperty(value = "主键")
    private Long relaId;
    
    
    /**
     * 门店id
     */
    @NotNull(message = "门店id 不能是Null", groups = {SysStorePartnerRelaEntityValidGroup.class, StoreIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="门店id 数字精度必须符合(19,0)", groups = {SysStorePartnerRelaEntityValidGroup.class, StoreIdValidGroup.class})
    @ApiModelProperty(value = "门店id")
    private Long storeId;
    
    /**
     * 车商id
     */
    @NotNull(message = "车商id 不能是Null", groups = {SysStorePartnerRelaEntityValidGroup.class, PartnerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="车商id 数字精度必须符合(19,0)", groups = {SysStorePartnerRelaEntityValidGroup.class, PartnerIdValidGroup.class})
    @ApiModelProperty(value = "车商id")
    private Long partnerId;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysStorePartnerRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysStorePartnerRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysStorePartnerRelaEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysStorePartnerRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysStorePartnerRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysStorePartnerRelaEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {SysStorePartnerRelaEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    public SysStorePartnerRelaEntity() {
    }
    
    public SysStorePartnerRelaEntity(Long relaId) {
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
    
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
    public Long getPartnerId() {
        return this.partnerId;
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

    public interface SysStorePartnerRelaEntityValidGroup {}
    public interface RelaIdValidGroup {}
    public interface StoreIdValidGroup {}
    public interface PartnerIdValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RelaIdValidGroup.class
            , StoreIdValidGroup.class
            , PartnerIdValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
        };
    }
}
