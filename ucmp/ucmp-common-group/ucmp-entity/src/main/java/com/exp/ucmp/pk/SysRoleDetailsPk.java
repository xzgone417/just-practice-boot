package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysRoleDetailsPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 角色标识
     */
    private Long roleId;
    
    public SysRoleDetailsPk() {
    }
    
    public SysRoleDetailsPk(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getRoleId() {
        return this.roleId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (roleId == null)
           
               ? true : false;
    }
    
}
