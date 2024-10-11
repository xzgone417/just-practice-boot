/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
 package com.exp.ucmp;

import com.egrid.core.base.model.BaseModel;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lx
 * @date 2018/10/11
 */
public class PageDto extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 页数
     */
    @ApiModelProperty(value = "页数")
    private Integer pageNum;
    
    /**
     * 行数
     */
    @ApiModelProperty(value = "行数")
    private Integer pageSize;

    /**
     * @return the pageNum
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * @param pageNum the pageNum to set
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * @return the pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
