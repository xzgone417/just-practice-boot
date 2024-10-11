/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.permission.service;

import com.exp.ucmp.permission.dto.ApplicationInfoDto;
import com.exp.ucmp.permission.dto.BatchMenuUrlDto;
import com.exp.ucmp.permission.dto.BatchPermissionUrlDto;

/**
 * @author Yiyongfei
 * @date 2022年07月12日
 */
public interface PermissionService {

    /**
     * 添加应用（用于生成权限数据）
     * @param applicationInfoDto
     */
    void addApplication(ApplicationInfoDto applicationInfoDto);
    
    /**
     * 添加权限（用于生成权限数据）
     * @param batchPermissionUrlDto
     */
    void batchAddPermission(BatchPermissionUrlDto batchPermissionUrlDto);
    /**
     * 添加菜单（用于生成权限数据）
     * @param batchMenuUrlDto
     */
    void batchAddMenu(BatchMenuUrlDto batchMenuUrlDto);
}
