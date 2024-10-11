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

@ApiModel(value = "RolePermissionRelaEntity", description = "角色权限关系")
@GroupSequence({RolePermissionRelaEntity.class, RolePermissionRelaEntity.RolePermissionRelaEntityValidGroup.class,RolePermissionRelaEntity.RolePermissionIdValidGroup.class,RolePermissionRelaEntity.RoleIdValidGroup.class,RolePermissionRelaEntity.PermissionIdValidGroup.class,RolePermissionRelaEntity.PermissionWildcardsValidGroup.class,RolePermissionRelaEntity.CreatedByValidGroup.class,RolePermissionRelaEntity.CreatedDateValidGroup.class,RolePermissionRelaEntity.UpdatedByValidGroup.class,RolePermissionRelaEntity.UpdatedDateValidGroup.class}) 
public class RolePermissionRelaEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 角色权限标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "角色权限标识 不能是Null", groups = {RolePermissionRelaEntityValidGroup.class, RolePermissionIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="角色权限标识 数字精度必须符合(19,0)", groups = {RolePermissionRelaEntityValidGroup.class, RolePermissionIdValidGroup.class})
    @ApiModelProperty(value = "角色权限标识")
    private Long rolePermissionId;
    
    
    /**
     * 角色标识
     */
    @NotNull(message = "角色标识 不能是Null", groups = {RolePermissionRelaEntityValidGroup.class, RoleIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="角色标识 数字精度必须符合(19,0)", groups = {RolePermissionRelaEntityValidGroup.class, RoleIdValidGroup.class})
    @ApiModelProperty(value = "角色标识")
    private Long roleId;
    
    /**
     * 权限标识，按照资源+操作的通配符方式定义角色可操作的资源时，该字段为空
     */
    @Digits(integer=19, fraction=0, message="权限标识，按照资源+操作的通配符方式定义角色可操作的资源时，该字段为空 数字精度必须符合(19,0)", groups = {RolePermissionRelaEntityValidGroup.class, PermissionIdValidGroup.class})
    @ApiModelProperty(value = "权限标识，按照资源+操作的通配符方式定义角色可操作的资源时，该字段为空")
    private Long permissionId;
    
    /**
     * 通配符权限，由资源+操作组成，资源和操作可能都存在通配符
     */
    @Size(min=0, max=100, message="通配符权限，由资源+操作组成，资源和操作可能都存在通配符 字符长度必须小于等于100", groups = {RolePermissionRelaEntityValidGroup.class, PermissionWildcardsValidGroup.class})
    @ApiModelProperty(value = "通配符权限，由资源+操作组成，资源和操作可能都存在通配符")
    private String permissionWildcards;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {RolePermissionRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {RolePermissionRelaEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {RolePermissionRelaEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {RolePermissionRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {RolePermissionRelaEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {RolePermissionRelaEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public RolePermissionRelaEntity() {
    }
    
    public RolePermissionRelaEntity(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }
    public Long getRolePermissionId() {
        return this.rolePermissionId;
    }
    

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getRoleId() {
        return this.roleId;
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
              (rolePermissionId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                rolePermissionId = RandomIDGennerator.get().generate();
    }

    public interface RolePermissionRelaEntityValidGroup {}
    public interface RolePermissionIdValidGroup {}
    public interface RoleIdValidGroup {}
    public interface PermissionIdValidGroup {}
    public interface PermissionWildcardsValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RolePermissionRelaEntity.RolePermissionIdValidGroup.class
            , RolePermissionRelaEntity.RoleIdValidGroup.class
            , RolePermissionRelaEntity.PermissionIdValidGroup.class
            , RolePermissionRelaEntity.PermissionWildcardsValidGroup.class
            , RolePermissionRelaEntity.CreatedByValidGroup.class
            , RolePermissionRelaEntity.CreatedDateValidGroup.class
            , RolePermissionRelaEntity.UpdatedByValidGroup.class
            , RolePermissionRelaEntity.UpdatedDateValidGroup.class
        };
    }
}
