/**
 * PsiCarServiceMaterialApprovalRecordPk.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarServiceMaterialApprovalRecordPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 业务id
     */
    private Long materialApprovalRecordId;
    
    public PsiCarServiceMaterialApprovalRecordPk() {
    }
    
    public PsiCarServiceMaterialApprovalRecordPk(Long materialApprovalRecordId) {
        this.materialApprovalRecordId = materialApprovalRecordId;
    }

    public void setMaterialApprovalRecordId(Long materialApprovalRecordId) {
        this.materialApprovalRecordId = materialApprovalRecordId;
    }
    public Long getMaterialApprovalRecordId() {
        return this.materialApprovalRecordId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (materialApprovalRecordId == null)
           
               ? true : false;
    }
    
}
