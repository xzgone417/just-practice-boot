/**
 * OperationInfoPk.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

/**
 * ClassName: OperationInfoPk
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
public class OperationInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 操作标识
     */
    private Long operationId;
    
    public OperationInfoPk() {
    }
    
    public OperationInfoPk(Long operationId) {
        this.operationId = operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }
    public Long getOperationId() {
        return this.operationId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (operationId == null)
           
               ? true : false;
    }
    
}
