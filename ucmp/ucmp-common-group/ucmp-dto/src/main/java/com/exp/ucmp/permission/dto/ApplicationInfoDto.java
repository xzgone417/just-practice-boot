/**
 * ApplicationInfoDto.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.permission.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.model.BaseModel;

/**
 * ClassName: ApplicationInfoEntity
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
@ApiModel(value = "ApplicationInfoDto", description = "应用信息")
public class ApplicationInfoDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 应用标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "应用标识")
    private Long applicationId;
    
    
    /**
     * 应用名
     */
    @ApiModelProperty(value = "应用名")
    private String applicationName;
    
    /**
     * 应用路径
     */
    @ApiModelProperty(value = "应用路径")
    private String applicationPath;
    
    /**
     * 应用描述
     */
    @ApiModelProperty(value = "应用描述")
    private String applicationDesc;
    
    public ApplicationInfoDto() {
    }
    
    public ApplicationInfoDto(Long applicationId) {
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
    
}
