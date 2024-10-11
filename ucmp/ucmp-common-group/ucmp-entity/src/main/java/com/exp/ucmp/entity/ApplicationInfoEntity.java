/**
 * ApplicationInfoEntity.java
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
 * ClassName: ApplicationInfoEntity
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
@ApiModel(value = "ApplicationInfoEntity", description = "应用信息")
@GroupSequence({ApplicationInfoEntity.class, ApplicationInfoEntity.ApplicationInfoEntityValidGroup.class,ApplicationInfoEntity.ApplicationIdValidGroup.class,ApplicationInfoEntity.ApplicationNameValidGroup.class,ApplicationInfoEntity.ApplicationPathValidGroup.class,ApplicationInfoEntity.ApplicationDescValidGroup.class,ApplicationInfoEntity.CreatedByValidGroup.class,ApplicationInfoEntity.CreatedDateValidGroup.class,ApplicationInfoEntity.UpdatedByValidGroup.class,ApplicationInfoEntity.UpdatedDateValidGroup.class}) 
public class ApplicationInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 应用标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "应用标识 不能是Null", groups = {ApplicationInfoEntityValidGroup.class, ApplicationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="应用标识 数字精度必须符合(19,0)", groups = {ApplicationInfoEntityValidGroup.class, ApplicationIdValidGroup.class})
    @ApiModelProperty(value = "应用标识")
    private Long applicationId;
    
    
    /**
     * 应用名
     */
    @NotNull(message = "应用名 不能是Null", groups = {ApplicationInfoEntityValidGroup.class, ApplicationNameValidGroup.class})
    @Size(min=0, max=10, message="应用名 字符长度必须小于等于10", groups = {ApplicationInfoEntityValidGroup.class, ApplicationNameValidGroup.class})
    @ApiModelProperty(value = "应用名")
    private String applicationName;
    
    /**
     * 应用路径
     */
    @Size(min=0, max=120, message="应用路径 字符长度必须小于等于120", groups = {ApplicationInfoEntityValidGroup.class, ApplicationPathValidGroup.class})
    @ApiModelProperty(value = "应用路径")
    private String applicationPath;
    
    /**
     * 应用描述
     */
    @Size(min=0, max=200, message="应用描述 字符长度必须小于等于200", groups = {ApplicationInfoEntityValidGroup.class, ApplicationDescValidGroup.class})
    @ApiModelProperty(value = "应用描述")
    private String applicationDesc;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {ApplicationInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {ApplicationInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {ApplicationInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {ApplicationInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {ApplicationInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {ApplicationInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public ApplicationInfoEntity() {
    }
    
    public ApplicationInfoEntity(Long applicationId) {
        this.applicationId = applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
    public Long getApplicationId() {
        return this.applicationId;
    }
    

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
    public String getApplicationName() {
        return this.applicationName;
    }
    
    public void setApplicationPath(String applicationPath) {
        this.applicationPath = applicationPath;
    }
    public String getApplicationPath() {
        return this.applicationPath;
    }
    
    public void setApplicationDesc(String applicationDesc) {
        this.applicationDesc = applicationDesc;
    }
    public String getApplicationDesc() {
        return this.applicationDesc;
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
              (applicationId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                applicationId = RandomIDGennerator.get().generate();
    }

    public interface ApplicationInfoEntityValidGroup {}
    public interface ApplicationIdValidGroup {}
    public interface ApplicationNameValidGroup {}
    public interface ApplicationPathValidGroup {}
    public interface ApplicationDescValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            ApplicationInfoEntity.ApplicationIdValidGroup.class
            , ApplicationInfoEntity.ApplicationNameValidGroup.class
            , ApplicationInfoEntity.ApplicationPathValidGroup.class
            , ApplicationInfoEntity.ApplicationDescValidGroup.class
            , ApplicationInfoEntity.CreatedByValidGroup.class
            , ApplicationInfoEntity.CreatedDateValidGroup.class
            , ApplicationInfoEntity.UpdatedByValidGroup.class
            , ApplicationInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
