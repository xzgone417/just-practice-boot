/**
 * ResourceInfoPk.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

/**
 * ClassName: ResourceInfoPk
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
public class ResourceInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 资源标识
     */
    private Long resourceId;
    
    public ResourceInfoPk() {
    }
    
    public ResourceInfoPk(Long resourceId) {
        this.resourceId = resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    public Long getResourceId() {
        return this.resourceId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (resourceId == null)
           
               ? true : false;
    }
    
}
