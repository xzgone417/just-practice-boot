/**
 * ResourceIdentifierPk.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

/**
 * ClassName: ResourceIdentifierPk
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
public class ResourceIdentifierPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 资源标识
     */
    private Long identifierId;
    
    public ResourceIdentifierPk() {
    }
    
    public ResourceIdentifierPk(Long identifierId) {
        this.identifierId = identifierId;
    }

    public void setIdentifierId(Long identifierId) {
        this.identifierId = identifierId;
    }
    public Long getIdentifierId() {
        return this.identifierId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (identifierId == null)
           
               ? true : false;
    }
    
}
