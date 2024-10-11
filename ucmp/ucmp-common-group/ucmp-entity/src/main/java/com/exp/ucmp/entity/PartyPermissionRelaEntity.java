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

@ApiModel(value = "PartyPermissionRelaEntity", description = "人员权限关系(人员特殊授权)")
@GroupSequence({PartyPermissionRelaEntity.class, PartyPermissionRelaEntity.PartyPermissionRelaEntityValidGroup.class,PartyPermissionRelaEntity.PartyPermissionIdValidGroup.class,PartyPermissionRelaEntity.PartyIdValidGroup.class,PartyPermissionRelaEntity.PermissionIdValidGroup.class,PartyPermissionRelaEntity.PermissionWildcardsValidGroup.class,PartyPermissionRelaEntity.CreatedByValidGroup.class,PartyPermissionRelaEntity.CreatedDateValidGroup.class,PartyPermissionRelaEntity.UpdatedByValidGroup.class,PartyPermissionRelaEntity.UpdatedDateValidGroup.class}) 
public class PartyPermissionRelaEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 人员权限标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "人员权限标识 不能是Null", groups = {PartyPermissionRelaEntityValidGroup.class, PartyPermissionIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="人员权限标识 数字精度必须符合(19,0)", groups = {PartyPermissionRelaEntityValidGroup.class, PartyPermissionIdValidGroup.class})
    @ApiModelProperty(value = "人员权限标识")
    private Long partyPermissionId;
    
    
    /**
     * 人员ID
     */
    @NotNull(message = "人员ID 不能是Null", groups = {PartyPermissionRelaEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="人员ID 数字精度必须符合(19,0)", groups = {PartyPermissionRelaEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "人员ID")
    private Long partyId;
    
    /**
     * 权限标识，按照资源+操作的通配符方式定义角色可操作的资源时，该字段为空
     */
    @Digits(integer=19, fraction=0, message="权限标识，按照资源+操作的通配符方式定义角色可操作的资源时，该字段为空 数字精度必须符合(19,0)", groups = {PartyPermissionRelaEntityValidGroup.class, PermissionIdValidGroup.class})
    @ApiModelProperty(value = "权限标识，按照资源+操作的通配符方式定义角色可操作的资源时，该字段为空")
    private Long permissionId;
    
    /**
     * 通配符权限，由资源+操作组成，资源和操作可能都存在通配符
     */
    @Size(min=0, max=100, message="通配符权限，由资源+操作组成，资源和操作可能都存在通配符 字符长度必须小于等于100", groups = {PartyPermissionRelaEntityValidGroup.class, PermissionWildcardsValidGroup.class})
    @ApiModelProperty(value = "通配符权限，由资源+操作组成，资源和操作可能都存在通配符")
    private String permissionWildcards;
    
    /**
     * 生效时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "生效时间")
    private Date effectiveDate;
    
    /**
     * 失效时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "失效时间")
    private Date expiryDate;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PartyPermissionRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PartyPermissionRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PartyPermissionRelaEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PartyPermissionRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PartyPermissionRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PartyPermissionRelaEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PartyPermissionRelaEntity() {
    }
    
    public PartyPermissionRelaEntity(Long partyPermissionId) {
        this.partyPermissionId = partyPermissionId;
    }

    public void setPartyPermissionId(Long partyPermissionId) {
        this.partyPermissionId = partyPermissionId;
    }
    public Long getPartyPermissionId() {
        return this.partyPermissionId;
    }
    

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    
    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
    public Long getPermissionId() {
        return this.permissionId;
    }
    
    public void setPermissionWildcards(String permissionWildcards) {
        this.permissionWildcards = permissionWildcards;
    }
    public String getPermissionWildcards() {
        return this.permissionWildcards;
    }
    
    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
    public Date getEffectiveDate() {
        return this.effectiveDate;
    }
    
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    public Date getExpiryDate() {
        return this.expiryDate;
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
              (partyPermissionId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                partyPermissionId = RandomIDGennerator.get().generate();
    }

    public interface PartyPermissionRelaEntityValidGroup {}
    public interface PartyPermissionIdValidGroup {}
    public interface PartyIdValidGroup {}
    public interface PermissionIdValidGroup {}
    public interface PermissionWildcardsValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PartyPermissionRelaEntity.PartyPermissionIdValidGroup.class
            , PartyPermissionRelaEntity.PartyIdValidGroup.class
            , PartyPermissionRelaEntity.PermissionIdValidGroup.class
            , PartyPermissionRelaEntity.PermissionWildcardsValidGroup.class
            , PartyPermissionRelaEntity.CreatedByValidGroup.class
            , PartyPermissionRelaEntity.CreatedDateValidGroup.class
            , PartyPermissionRelaEntity.UpdatedByValidGroup.class
            , PartyPermissionRelaEntity.UpdatedDateValidGroup.class
        };
    }
}
