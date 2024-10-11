/**
 * MenuInfoPk.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

/**
 * ClassName: MenuInfoPk
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
public class MenuInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 菜单标识
     */
    private Long menuId;
    
    public MenuInfoPk() {
    }
    
    public MenuInfoPk(Long menuId) {
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
