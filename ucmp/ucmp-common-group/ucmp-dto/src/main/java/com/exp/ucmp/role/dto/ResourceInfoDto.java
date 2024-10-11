/**
 * ResourceInfoEntity.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.role.dto;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.GroupSequence;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhouchengwei
 * @date 2022年8月11日
 */
@ApiModel(value = "ResourceInfoDto", description = "资源信息")
public class ResourceInfoDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 资源标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "资源标识")
    private Long resourceId;


    /**
     * 角色标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "角色标识")
    private Long roleId;


    /**
     * 应用标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "应用标识")
    private Long applicationId;

    /**
     * 上级资源标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "上级资源标识")
    private Long parentResourceId;

    /**
     * 资源名
     */
    @ApiModelProperty(value = "资源名")
    private String resourceName;

    /**
     * 资源内容：若是顶层资源，存放资源名(应用名:资源名)，否则存放(上层资源内容+:+资源名，类似system:user)
     */
    @ApiModelProperty(value = "资源内容：若是顶层资源，存放资源名(应用名:资源名)，否则存放(上层资源内容+:+资源名，类似system:user)")
    private String resourceContent;

    /**
     * 资源描述
     */
   @ApiModelProperty(value = "资源描述")
    private String resourceDesc;



    /**
     * 所有无须资源列表集合
     */
    @ApiModelProperty(value = "所有无须资源列表集合")
    private List<String> resourceContentList;

    /**
     * 权限，操作信息
     */
    @ApiModelProperty(value = "权限，操作信息")
    private List<Map> roleOpeList;


    /**
     * 资源列表集合
     */
    @ApiModelProperty(value = "资源列表集合")
    private List<ResourceInfoDto> resourceList;


    /**
     * 勾选标记
     */
    @ApiModelProperty(value = "勾选标记")
    private Boolean tickFlag;


    public ResourceInfoDto() {
    }

    public ResourceInfoDto(Long resourceId) {
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

    public List<String> getResourceContentList() {
        return resourceContentList;
    }

    public void setResourceContentList(List<String> resourceContentList) {
        this.resourceContentList = resourceContentList;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<ResourceInfoDto> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<ResourceInfoDto> resourceList) {
        this.resourceList = resourceList;
    }

    public List<Map> getRoleOpeList() {
        return roleOpeList;
    }

    public void setRoleOpeList(List<Map> roleOpeList) {
        this.roleOpeList = roleOpeList;
    }

    public Boolean getTickFlag() {
        return tickFlag;
    }

    public void setTickFlag(Boolean tickFlag) {
        this.tickFlag = tickFlag;
    }
}
