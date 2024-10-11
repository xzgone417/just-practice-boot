package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiOrderReceivingRecordPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 记录ID
     */
    private Long recordId;
    
    public PsiOrderReceivingRecordPk() {
    }
    
    public PsiOrderReceivingRecordPk(Long recordId) {
        this.recordId = recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }
    public Long getRecordId() {
        return this.recordId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (recordId == null)
           
               ? true : false;
    }
    
}
