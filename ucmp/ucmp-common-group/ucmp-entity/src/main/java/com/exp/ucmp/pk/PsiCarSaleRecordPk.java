/**
 * PsiCarSaleRecordPk.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarSaleRecordPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 车辆批售记录id
     */
    private Long saleRecordId;
    
    public PsiCarSaleRecordPk() {
    }
    
    public PsiCarSaleRecordPk(Long saleRecordId) {
        this.saleRecordId = saleRecordId;
    }

    public void setSaleRecordId(Long saleRecordId) {
        this.saleRecordId = saleRecordId;
    }
    public Long getSaleRecordId() {
        return this.saleRecordId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (saleRecordId == null)
           
               ? true : false;
    }
    
}
