package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarTransferApplyPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 调度申请id
     */
    private Long transferApplyId;
    
    public PsiCarTransferApplyPk() {
    }
    
    public PsiCarTransferApplyPk(Long transferApplyId) {
        this.transferApplyId = transferApplyId;
    }

    public void setTransferApplyId(Long transferApplyId) {
        this.transferApplyId = transferApplyId;
    }
    public Long getTransferApplyId() {
        return this.transferApplyId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (transferApplyId == null)
           
               ? true : false;
    }
    
}
