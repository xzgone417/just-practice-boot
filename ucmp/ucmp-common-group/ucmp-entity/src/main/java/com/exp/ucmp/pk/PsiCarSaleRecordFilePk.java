/**
 * PsiCarSaleRecordFilePk.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarSaleRecordFilePk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 业务主键
     */
    private Long recordFileId;
    
    public PsiCarSaleRecordFilePk() {
    }
    
    public PsiCarSaleRecordFilePk(Long recordFileId) {
        this.recordFileId = recordFileId;
    }

    public void setRecordFileId(Long recordFileId) {
        this.recordFileId = recordFileId;
    }
    public Long getRecordFileId() {
        return this.recordFileId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (recordFileId == null)
           
               ? true : false;
    }
    
}
