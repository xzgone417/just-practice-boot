/**
 * ResourceInfoEntity.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.role.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhouchengwei
 * @date 2022年8月29日
 */
@ApiModel(value = "ResourceContentDto", description = "资源列表信息")
public class ResourceContentDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 资源标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "资源标识")
    private Long resourceId;


    /**
     * 权限.操作内容
     */
    @ApiModelProperty(value = "权限.操作内容")
    private String operPermission;



    /**
     * 资源内容：若是顶层资源，存放资源名(应用名:资源名)，否则存放(上层资源内容+:+资源名，类似system:user)
     */
    @ApiModelProperty(value = "资源内容")
    private String resourceContent;





    public ResourceContentDto() {
    }

    public ResourceContentDto(Long resourceId) {
        this.resourceId = resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    public Long getResourceId() {
        return this.resourceId;
    }


    public String getOperPermission() {
        return operPermission;
    }

    public void setOperPermission(String operPermission) {
        this.operPermission = operPermission;
    }

    public String getResourceContent() {
        return resourceContent;
    }

    public void setResourceContent(String resourceContent) {
        this.resourceContent = resourceContent;
    }


}
