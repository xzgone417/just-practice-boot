/**
 * PermissionInfoEntity.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
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

/**
 * ClassName: PermissionInfoEntity
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
@ApiModel(value = "PermissionInfoEntity", description = "权限信息")
@GroupSequence({PermissionInfoEntity.class, PermissionInfoEntity.PermissionInfoEntityValidGroup.class,PermissionInfoEntity.PermissionIdValidGroup.class,PermissionInfoEntity.ResourceIdValidGroup.class,PermissionInfoEntity.OperationIdValidGroup.class,PermissionInfoEntity.PermissionNameValidGroup.class,PermissionInfoEntity.PermissionDescValidGroup.class,PermissionInfoEntity.IsValidValidGroup.class,PermissionInfoEntity.IsDeleteValidGroup.class,PermissionInfoEntity.CreatedByValidGroup.class,PermissionInfoEntity.CreatedDateValidGroup.class,PermissionInfoEntity.UpdatedByValidGroup.class,PermissionInfoEntity.UpdatedDateValidGroup.class}) 
public class PermissionInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 权限标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "权限标识 不能是Null", groups = {PermissionInfoEntityValidGroup.class, PermissionIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="权限标识 数字精度必须符合(19,0)", groups = {PermissionInfoEntityValidGroup.class, PermissionIdValidGroup.class})
    @ApiModelProperty(value = "权限标识")
    private Long permissionId;
    
    
    /**
     * 资源标识
     */
    @NotNull(message = "资源标识 不能是Null", groups = {PermissionInfoEntityValidGroup.class, ResourceIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="资源标识 数字精度必须符合(19,0)", groups = {PermissionInfoEntityValidGroup.class, ResourceIdValidGroup.class})
    @ApiModelProperty(value = "资源标识")
    private Long resourceId;
    
    /**
     * 操作标识
     */
    @NotNull(message = "操作标识 不能是Null", groups = {PermissionInfoEntityValidGroup.class, OperationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="操作标识 数字精度必须符合(19,0)", groups = {PermissionInfoEntityValidGroup.class, OperationIdValidGroup.class})
    @ApiModelProperty(value = "操作标识")
    private Long operationId;
    
    /**
     * 权限名称，当不设置权限名时，此时不能通过权限名来进行授权判断
     */
    @Size(min=0, max=30, message="权限名称，当不设置权限名时，此时不能通过权限名来进行授权判断 字符长度必须小于等于30", groups = {PermissionInfoEntityValidGroup.class, PermissionNameValidGroup.class})
    @ApiModelProperty(value = "权限名称，当不设置权限名时，此时不能通过权限名来进行授权判断")
    private String permissionName;
    
    /**
     * 权限描述
     */
    @Size(min=0, max=45, message="权限描述 字符长度必须小于等于45", groups = {PermissionInfoEntityValidGroup.class, PermissionDescValidGroup.class})
    @ApiModelProperty(value = "权限描述")
    private String permissionDesc;
    
    /**
     * 是否有效：01、有效，09、无效
     */
    @NotNull(message = "是否有效：01、有效，09、无效 不能是Null", groups = {PermissionInfoEntityValidGroup.class, IsValidValidGroup.class})
    @Size(min=0, max=2, message="是否有效：01、有效，09、无效 字符长度必须小于等于2", groups = {PermissionInfoEntityValidGroup.class, IsValidValidGroup.class})
    @ApiModelProperty(value = "是否有效：01、有效，09、无效")
    private String isValid;
    
    /**
     * 是否被删除：00、删除，01、未删除
     */
    @NotNull(message = "是否被删除：00、删除，01、未删除 不能是Null", groups = {PermissionInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、删除，01、未删除 字符长度必须小于等于2", groups = {PermissionInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PermissionInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PermissionInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PermissionInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PermissionInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PermissionInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PermissionInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PermissionInfoEntity() {
    }
    
    public PermissionInfoEntity(Long permissionId) {
        this.permissionId = permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
    public Long getPermissionId() {
        return this.permissionId;
    }
    

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    public Long getResourceId() {
        return this.resourceId;
    }
    
    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }
    public Long getOperationId() {
        return this.operationId;
    }
    
    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
    public String getPermissionName() {
        return this.permissionName;
    }
    
    public void setPermissionDesc(String permissionDesc) {
        this.permissionDesc = permissionDesc;
    }
    public String getPermissionDesc() {
        return this.permissionDesc;
    }
    
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }
    public String getIsValid() {
        return this.isValid;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
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
              (permissionId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                permissionId = RandomIDGennerator.get().generate();
    }

    public interface PermissionInfoEntityValidGroup {}
    public interface PermissionIdValidGroup {}
    public interface ResourceIdValidGroup {}
    public interface OperationIdValidGroup {}
    public interface PermissionNameValidGroup {}
    public interface PermissionDescValidGroup {}
    public interface IsValidValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PermissionInfoEntity.PermissionIdValidGroup.class
            , PermissionInfoEntity.ResourceIdValidGroup.class
            , PermissionInfoEntity.OperationIdValidGroup.class
            , PermissionInfoEntity.PermissionNameValidGroup.class
            , PermissionInfoEntity.PermissionDescValidGroup.class
            , PermissionInfoEntity.IsValidValidGroup.class
            , PermissionInfoEntity.IsDeleteValidGroup.class
            , PermissionInfoEntity.CreatedByValidGroup.class
            , PermissionInfoEntity.CreatedDateValidGroup.class
            , PermissionInfoEntity.UpdatedByValidGroup.class
            , PermissionInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
