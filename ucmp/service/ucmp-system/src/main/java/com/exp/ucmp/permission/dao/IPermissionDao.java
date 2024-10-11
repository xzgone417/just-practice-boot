/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
 package com.exp.ucmp.permission.dao;

import java.util.List;

import com.exp.ucmp.entity.MenuInfoEntity;
import com.exp.ucmp.entity.ResourceIdentifierEntity;

/**
 * @author Yiyongfei
 * @date 2022/07/12
 */
public interface IPermissionDao {

    /**
     * Description: 根据条件查询集合实体
     * @param resourceIdentifierEntity 查询条件(URL或权限ID)
     * @return 实体集合
     */
    public List<ResourceIdentifierEntity> selectByPermissionOrUrl(ResourceIdentifierEntity resourceIdentifierEntity);
    
    /**
     * Description: 获取菜单的序号(用于生成菜单)
     * @param menuInfoEntity
     * @return
     */
    public Integer selectMenuSeqenceByParent(MenuInfoEntity menuInfoEntity);
}
