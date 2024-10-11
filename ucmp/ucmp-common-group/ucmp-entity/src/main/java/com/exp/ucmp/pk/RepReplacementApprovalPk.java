package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class RepReplacementApprovalPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 置换ID
     */
    private Long replacementId;
    
    public RepReplacementApprovalPk() {
    }
    
    public RepReplacementApprovalPk(Long replacementId) {
        this.replacementId = replacementId;
    }

    public void setReplacementId(Long replacementId) {
        this.replacementId = replacementId;
    }
    public Long getReplacementId() {
        return this.replacementId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (replacementId == null)
           
               ? true : false;
    }
    
}
