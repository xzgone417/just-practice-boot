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

@ApiModel(value = "PartyRoleRelaEntity", description = "当事人角色关系")
@GroupSequence({PartyRoleRelaEntity.class, PartyRoleRelaEntity.PartyRoleRelaEntityValidGroup.class,PartyRoleRelaEntity.PartyRoleIdValidGroup.class,PartyRoleRelaEntity.PartyIdValidGroup.class,PartyRoleRelaEntity.RoleIdValidGroup.class,PartyRoleRelaEntity.CreatedByValidGroup.class,PartyRoleRelaEntity.CreatedDateValidGroup.class,PartyRoleRelaEntity.UpdatedByValidGroup.class,PartyRoleRelaEntity.UpdatedDateValidGroup.class}) 
public class PartyRoleRelaEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 当事人角色标识
     */

    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "当事人角色标识 不能是Null", groups = {PartyRoleRelaEntityValidGroup.class, PartyRoleIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="当事人角色标识 数字精度必须符合(19,0)", groups = {PartyRoleRelaEntityValidGroup.class, PartyRoleIdValidGroup.class})
    @ApiModelProperty(value = "当事人角色标识")
    private Long partyRoleId;
    
    
    /**
     * 当事人标识
     */
    @NotNull(message = "当事人标识 不能是Null", groups = {PartyRoleRelaEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="当事人标识 数字精度必须符合(19,0)", groups = {PartyRoleRelaEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "当事人标识")
    private Long partyId;
    
    /**
     * 角色标识
     */
    @NotNull(message = "角色标识 不能是Null", groups = {PartyRoleRelaEntityValidGroup.class, RoleIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="角色标识 数字精度必须符合(19,0)", groups = {PartyRoleRelaEntityValidGroup.class, RoleIdValidGroup.class})
    @ApiModelProperty(value = "角色标识")
    private Long roleId;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PartyRoleRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PartyRoleRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PartyRoleRelaEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PartyRoleRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PartyRoleRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PartyRoleRelaEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PartyRoleRelaEntity() {
    }
    
    public PartyRoleRelaEntity(Long partyRoleId) {
        this.partyRoleId = partyRoleId;
    }

    public void setPartyRoleId(Long partyRoleId) {
        this.partyRoleId = partyRoleId;
    }
    public Long getPartyRoleId() {
        return this.partyRoleId;
    }
    

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getRoleId() {
        return this.roleId;
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
              (partyRoleId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                partyRoleId = RandomIDGennerator.get().generate();
    }

    public interface PartyRoleRelaEntityValidGroup {}
    public interface PartyRoleIdValidGroup {}
    public interface PartyIdValidGroup {}
    public interface RoleIdValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PartyRoleRelaEntity.PartyRoleIdValidGroup.class
            , PartyRoleRelaEntity.PartyIdValidGroup.class
            , PartyRoleRelaEntity.RoleIdValidGroup.class
            , PartyRoleRelaEntity.CreatedByValidGroup.class
            , PartyRoleRelaEntity.CreatedDateValidGroup.class
            , PartyRoleRelaEntity.UpdatedByValidGroup.class
            , PartyRoleRelaEntity.UpdatedDateValidGroup.class
        };
    }
}
