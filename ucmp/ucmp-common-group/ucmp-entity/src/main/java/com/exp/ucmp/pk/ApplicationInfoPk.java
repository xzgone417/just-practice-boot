/**
 * ApplicationInfoPk.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

/**
 * ClassName: ApplicationInfoPk
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
public class ApplicationInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 应用标识
     */
    private Long applicationId;
    
    public ApplicationInfoPk() {
    }
    
    public ApplicationInfoPk(Long applicationId) {
        this.applicationId = applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
    public Long getApplicationId() {
        return this.applicationId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (applicationId == null)
           
               ? true : false;
    }
    
}
