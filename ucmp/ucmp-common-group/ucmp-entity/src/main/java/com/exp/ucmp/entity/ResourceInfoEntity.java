/**
 * ResourceInfoEntity.java
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
 * ClassName: ResourceInfoEntity
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
@ApiModel(value = "ResourceInfoEntity", description = "资源信息")
@GroupSequence({ResourceInfoEntity.class, ResourceInfoEntity.ResourceInfoEntityValidGroup.class,ResourceInfoEntity.ResourceIdValidGroup.class,ResourceInfoEntity.ApplicationIdValidGroup.class,ResourceInfoEntity.ParentResourceIdValidGroup.class,ResourceInfoEntity.ResourceNameValidGroup.class,ResourceInfoEntity.ResourceContentValidGroup.class,ResourceInfoEntity.ResourceDescValidGroup.class,ResourceInfoEntity.CreatedByValidGroup.class,ResourceInfoEntity.CreatedDateValidGroup.class,ResourceInfoEntity.UpdatedByValidGroup.class,ResourceInfoEntity.UpdatedDateValidGroup.class}) 
public class ResourceInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 资源标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "资源标识 不能是Null", groups = {ResourceInfoEntityValidGroup.class, ResourceIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="资源标识 数字精度必须符合(19,0)", groups = {ResourceInfoEntityValidGroup.class, ResourceIdValidGroup.class})
    @ApiModelProperty(value = "资源标识")
    private Long resourceId;
    
    
    /**
     * 应用标识
     */
    @NotNull(message = "应用标识 不能是Null", groups = {ResourceInfoEntityValidGroup.class, ApplicationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="应用标识 数字精度必须符合(19,0)", groups = {ResourceInfoEntityValidGroup.class, ApplicationIdValidGroup.class})
    @ApiModelProperty(value = "应用标识")
    private Long applicationId;
    
    /**
     * 上级资源标识
     */
    @Digits(integer=19, fraction=0, message="上级资源标识 数字精度必须符合(19,0)", groups = {ResourceInfoEntityValidGroup.class, ParentResourceIdValidGroup.class})
    @ApiModelProperty(value = "上级资源标识")
    private Long parentResourceId;
    
    /**
     * 资源名
     */
    @NotNull(message = "资源名 不能是Null", groups = {ResourceInfoEntityValidGroup.class, ResourceNameValidGroup.class})
    @Size(min=0, max=10, message="资源名 字符长度必须小于等于10", groups = {ResourceInfoEntityValidGroup.class, ResourceNameValidGroup.class})
    @ApiModelProperty(value = "资源名")
    private String resourceName;
    
    /**
     * 资源内容：若是顶层资源，存放资源名(应用名:资源名)，否则存放(上层资源内容+:+资源名，类似system:user)
     */
    @NotNull(message = "资源内容：若是顶层资源，存放资源名(应用名:资源名)，否则存放(上层资源内容+:+资源名，类似system:user) 不能是Null", groups = {ResourceInfoEntityValidGroup.class, ResourceContentValidGroup.class})
    @Size(min=0, max=120, message="资源内容：若是顶层资源，存放资源名(应用名:资源名)，否则存放(上层资源内容+:+资源名，类似system:user) 字符长度必须小于等于120", groups = {ResourceInfoEntityValidGroup.class, ResourceContentValidGroup.class})
    @ApiModelProperty(value = "资源内容：若是顶层资源，存放资源名(应用名:资源名)，否则存放(上层资源内容+:+资源名，类似system:user)")
    private String resourceContent;
    
    /**
     * 资源描述
     */
    @Size(min=0, max=45, message="资源描述 字符长度必须小于等于45", groups = {ResourceInfoEntityValidGroup.class, ResourceDescValidGroup.class})
    @ApiModelProperty(value = "资源描述")
    private String resourceDesc;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {ResourceInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {ResourceInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {ResourceInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {ResourceInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {ResourceInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {ResourceInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public ResourceInfoEntity() {
    }
    
    public ResourceInfoEntity(Long resourceId) {
        this.resourceId = resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    public Long getResourceId() {
        return this.resourceId;
    }
    

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
    public Long getApplicationId() {
        return this.applicationId;
    }
    
    public void setParentResourceId(Long parentResourceId) {
        this.parentResourceId = parentResourceId;
    }
    public Long getParentResourceId() {
        return this.parentResourceId;
    }
    
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    public String getResourceName() {
        return this.resourceName;
    }
    
    public void setResourceContent(String resourceContent) {
        this.resourceContent = resourceContent;
    }
    public String getResourceContent() {
        return this.resourceContent;
    }
    
    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }
    public String getResourceDesc() {
        return this.resourceDesc;
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
              (resourceId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                resourceId = RandomIDGennerator.get().generate();
    }

    public interface ResourceInfoEntityValidGroup {}
    public interface ResourceIdValidGroup {}
    public interface ApplicationIdValidGroup {}
    public interface ParentResourceIdValidGroup {}
    public interface ResourceNameValidGroup {}
    public interface ResourceContentValidGroup {}
    public interface ResourceDescValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            ResourceInfoEntity.ResourceIdValidGroup.class
            , ResourceInfoEntity.ApplicationIdValidGroup.class
            , ResourceInfoEntity.ParentResourceIdValidGroup.class
            , ResourceInfoEntity.ResourceNameValidGroup.class
            , ResourceInfoEntity.ResourceContentValidGroup.class
            , ResourceInfoEntity.ResourceDescValidGroup.class
            , ResourceInfoEntity.CreatedByValidGroup.class
            , ResourceInfoEntity.CreatedDateValidGroup.class
            , ResourceInfoEntity.UpdatedByValidGroup.class
            , ResourceInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
