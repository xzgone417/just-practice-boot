/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.permission.dto;

import com.egrid.core.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Yiyongfei
 * @date 2018年9月29日
 */
@ApiModel(value = "MenuUrlDto", description = "菜单URL，用于批量生成")
public class MenuUrlDto extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 权限内容
     */
    @ApiModelProperty(value = "层级菜单")
    private String menu;

    /**
     * Url内容
     */
    @ApiModelProperty(value = "URL内容")
    private String url;
    /**
     * 访问类型
     */
    @ApiModelProperty(value = "菜单序号")
    private Integer seq;
    
    @ApiModelProperty(value = "同一个菜单更新URL还是新增菜单")
    private Boolean update = false;
    
    public Boolean getUpdate() {
        return update;
    }
    public void setUpdate(Boolean update) {
        this.update = update;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getMenu() {
        return menu;
    }
    public void setMenu(String menu) {
        this.menu = menu;
    }
    public Integer getSeq() {
        return seq;
    }
    public void setSeq(Integer seq) {
        this.seq = seq;
    }
    
    
}
