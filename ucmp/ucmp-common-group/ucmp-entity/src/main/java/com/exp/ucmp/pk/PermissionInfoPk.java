/**
 * PermissionInfoPk.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

/**
 * ClassName: PermissionInfoPk
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
public class PermissionInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 权限标识
     */
    private Long permissionId;
    
    public PermissionInfoPk() {
    }
    
    public PermissionInfoPk(Long permissionId) {
        this.permissionId = permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
    public Long getPermissionId() {
        return this.permissionId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (permissionId == null)
           
               ? true : false;
    }
    
}
