package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysMenuExtendedInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 菜单ID
     */
    private Long menuId;
    
    public SysMenuExtendedInfoPk() {
    }
    
    public SysMenuExtendedInfoPk(Long menuId) {
        this.menuId = menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
    public Long getMenuId() {
        return this.menuId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (menuId == null)
           
               ? true : false;
    }
    
}
