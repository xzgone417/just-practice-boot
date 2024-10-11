package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class RolePermissionRelaPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 角色权限标识
     */
    private Long rolePermissionId;
    
    public RolePermissionRelaPk() {
    }
    
    public RolePermissionRelaPk(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }
    public Long getRolePermissionId() {
        return this.rolePermissionId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (rolePermissionId == null)
           
               ? true : false;
    }
    
}
