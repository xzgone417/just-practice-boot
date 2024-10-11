/**
 * ResourceIdentifierEntity.java
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
 * ClassName: ResourceIdentifierEntity
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
@ApiModel(value = "ResourceIdentifierEntity", description = "资源标识")
@GroupSequence({ResourceIdentifierEntity.class, ResourceIdentifierEntity.ResourceIdentifierEntityValidGroup.class,ResourceIdentifierEntity.IdentifierIdValidGroup.class,ResourceIdentifierEntity.PermissionIdValidGroup.class,ResourceIdentifierEntity.IdentifierNameValidGroup.class,ResourceIdentifierEntity.IdentifierPathValidGroup.class,ResourceIdentifierEntity.IdentifierTypeValidGroup.class,ResourceIdentifierEntity.AccessTypeValidGroup.class,ResourceIdentifierEntity.IsValidValidGroup.class,ResourceIdentifierEntity.IsDeleteValidGroup.class,ResourceIdentifierEntity.CreatedByValidGroup.class,ResourceIdentifierEntity.CreatedDateValidGroup.class,ResourceIdentifierEntity.UpdatedByValidGroup.class,ResourceIdentifierEntity.UpdatedDateValidGroup.class}) 
public class ResourceIdentifierEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 资源标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "资源标识 不能是Null", groups = {ResourceIdentifierEntityValidGroup.class, IdentifierIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="资源标识 数字精度必须符合(19,0)", groups = {ResourceIdentifierEntityValidGroup.class, IdentifierIdValidGroup.class})
    @ApiModelProperty(value = "资源标识")
    private Long identifierId;
    
    
    /**
     * 权限标识，每个URL只能对应一份权限
     */
    @Digits(integer=19, fraction=0, message="权限标识，每个URL只能对应一份权限 数字精度必须符合(19,0)", groups = {ResourceIdentifierEntityValidGroup.class, PermissionIdValidGroup.class})
    @ApiModelProperty(value = "权限标识，每个URL只能对应一份权限")
    private Long permissionId;
    
    /**
     * 资源标识名称
     */
    @Size(min=0, max=45, message="资源标识名称 字符长度必须小于等于45", groups = {ResourceIdentifierEntityValidGroup.class, IdentifierNameValidGroup.class})
    @ApiModelProperty(value = "资源标识名称")
    private String identifierName;
    
    /**
     * 资源标识路径
     */
    @NotNull(message = "资源标识路径 不能是Null", groups = {ResourceIdentifierEntityValidGroup.class, IdentifierPathValidGroup.class})
    @Size(min=0, max=500, message="资源标识路径 字符长度必须小于等于500", groups = {ResourceIdentifierEntityValidGroup.class, IdentifierPathValidGroup.class})
    @ApiModelProperty(value = "资源标识路径")
    private String identifierPath;
    
    /**
     * 资源标识类型：01、URI，02、METHOD
     */
    @Size(min=0, max=2, message="资源标识类型：01、URI，02、METHOD 字符长度必须小于等于2", groups = {ResourceIdentifierEntityValidGroup.class, IdentifierTypeValidGroup.class})
    @ApiModelProperty(value = "资源标识类型：01、URI，02、METHOD")
    private String identifierType;
    
    /**
     * 访问类型：01、匿名访问；02、基于用户（已登录验证或记住我验证均可）；03、登录验证
     */
    @NotNull(message = "访问类型：01、匿名访问；02、基于用户（已登录验证或记住我验证均可）；03、登录验证 不能是Null", groups = {ResourceIdentifierEntityValidGroup.class, AccessTypeValidGroup.class})
    @Size(min=0, max=2, message="访问类型：01、匿名访问；02、基于用户（已登录验证或记住我验证均可）；03、登录验证 字符长度必须小于等于2", groups = {ResourceIdentifierEntityValidGroup.class, AccessTypeValidGroup.class})
    @ApiModelProperty(value = "访问类型：01、匿名访问；02、基于用户（已登录验证或记住我验证均可）；03、登录验证")
    private String accessType;
    
    /**
     * 是否有效：01、有效，09、无效
     */
    @NotNull(message = "是否有效：01、有效，09、无效 不能是Null", groups = {ResourceIdentifierEntityValidGroup.class, IsValidValidGroup.class})
    @Size(min=0, max=2, message="是否有效：01、有效，09、无效 字符长度必须小于等于2", groups = {ResourceIdentifierEntityValidGroup.class, IsValidValidGroup.class})
    @ApiModelProperty(value = "是否有效：01、有效，09、无效")
    private String isValid;
    
    /**
     * 是否被删除：00、删除，01、未删除
     */
    @NotNull(message = "是否被删除：00、删除，01、未删除 不能是Null", groups = {ResourceIdentifierEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、删除，01、未删除 字符长度必须小于等于2", groups = {ResourceIdentifierEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {ResourceIdentifierEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {ResourceIdentifierEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {ResourceIdentifierEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {ResourceIdentifierEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {ResourceIdentifierEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {ResourceIdentifierEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public ResourceIdentifierEntity() {
    }
    
    public ResourceIdentifierEntity(Long identifierId) {
        this.identifierId = identifierId;
    }

    public void setIdentifierId(Long identifierId) {
        this.identifierId = identifierId;
    }
    public Long getIdentifierId() {
        return this.identifierId;
    }
    

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
    public Long getPermissionId() {
        return this.permissionId;
    }
    
    public void setIdentifierName(String identifierName) {
        this.identifierName = identifierName;
    }
    public String getIdentifierName() {
        return this.identifierName;
    }
    
    public void setIdentifierPath(String identifierPath) {
        this.identifierPath = identifierPath;
    }
    public String getIdentifierPath() {
        return this.identifierPath;
    }
    
    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
    }
    public String getIdentifierType() {
        return this.identifierType;
    }
    
    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }
    public String getAccessType() {
        return this.accessType;
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
              (identifierId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                identifierId = RandomIDGennerator.get().generate();
    }

    public interface ResourceIdentifierEntityValidGroup {}
    public interface IdentifierIdValidGroup {}
    public interface PermissionIdValidGroup {}
    public interface IdentifierNameValidGroup {}
    public interface IdentifierPathValidGroup {}
    public interface IdentifierTypeValidGroup {}
    public interface AccessTypeValidGroup {}
    public interface IsValidValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            ResourceIdentifierEntity.IdentifierIdValidGroup.class
            , ResourceIdentifierEntity.PermissionIdValidGroup.class
            , ResourceIdentifierEntity.IdentifierNameValidGroup.class
            , ResourceIdentifierEntity.IdentifierPathValidGroup.class
            , ResourceIdentifierEntity.IdentifierTypeValidGroup.class
            , ResourceIdentifierEntity.AccessTypeValidGroup.class
            , ResourceIdentifierEntity.IsValidValidGroup.class
            , ResourceIdentifierEntity.IsDeleteValidGroup.class
            , ResourceIdentifierEntity.CreatedByValidGroup.class
            , ResourceIdentifierEntity.CreatedDateValidGroup.class
            , ResourceIdentifierEntity.UpdatedByValidGroup.class
            , ResourceIdentifierEntity.UpdatedDateValidGroup.class
        };
    }
}
