/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.permission.dto;

import java.util.List;

import com.egrid.core.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Yiyongfei
 * @date 2018年9月29日
 */
@ApiModel(value = "BatchMenuUrlDto", description = "菜单URL，用于批量生成")
public class BatchMenuUrlDto extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 菜单内容
     */
    @ApiModelProperty(value = "菜单内容")
    private List<MenuUrlDto> listMenuUrl;

    public List<MenuUrlDto> getListMenuUrl() {
        return listMenuUrl;
    }
    public void setListMenuUrl(List<MenuUrlDto> listMenuUrl) {
        this.listMenuUrl = listMenuUrl;
    }
    
    
}
