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

@ApiModel(value = "SysPartnerStaffRelaEntity", description = "合作商人员关系表")
@GroupSequence({SysPartnerStaffRelaEntity.class, SysPartnerStaffRelaEntity.SysPartnerStaffRelaEntityValidGroup.class,SysPartnerStaffRelaEntity.RelaIdValidGroup.class,SysPartnerStaffRelaEntity.PartyIdValidGroup.class,SysPartnerStaffRelaEntity.PartnerIdValidGroup.class,SysPartnerStaffRelaEntity.CreatedByValidGroup.class,SysPartnerStaffRelaEntity.CreatedDateValidGroup.class,SysPartnerStaffRelaEntity.UpdatedByValidGroup.class,SysPartnerStaffRelaEntity.UpdatedDateValidGroup.class}) 
public class SysPartnerStaffRelaEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "主键 不能是Null", groups = {SysPartnerStaffRelaEntityValidGroup.class, RelaIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="主键 数字精度必须符合(19,0)", groups = {SysPartnerStaffRelaEntityValidGroup.class, RelaIdValidGroup.class})
    @ApiModelProperty(value = "主键")
    private Long relaId;
    
    
    /**
     * 人员标识
     */
    @NotNull(message = "人员标识 不能是Null", groups = {SysPartnerStaffRelaEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="人员标识 数字精度必须符合(19,0)", groups = {SysPartnerStaffRelaEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "人员标识")
    private Long partyId;
    
    /**
     * 合作商标识
     */
    @NotNull(message = "合作商标识 不能是Null", groups = {SysPartnerStaffRelaEntityValidGroup.class, PartnerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="合作商标识 数字精度必须符合(19,0)", groups = {SysPartnerStaffRelaEntityValidGroup.class, PartnerIdValidGroup.class})
    @ApiModelProperty(value = "合作商标识")
    private Long partnerId;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysPartnerStaffRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysPartnerStaffRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysPartnerStaffRelaEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysPartnerStaffRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysPartnerStaffRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysPartnerStaffRelaEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysPartnerStaffRelaEntity() {
    }
    
    public SysPartnerStaffRelaEntity(Long relaId) {
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

    public interface SysPartnerStaffRelaEntityValidGroup {}
    public interface RelaIdValidGroup {}
    public interface PartyIdValidGroup {}
    public interface PartnerIdValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RelaIdValidGroup.class
            , PartyIdValidGroup.class
            , PartnerIdValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
