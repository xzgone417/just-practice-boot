package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiWorkOrderApprovalHistoryPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 工单审批记录id
     */
    private Long wordOrderApprovalId;
    
    public PsiWorkOrderApprovalHistoryPk() {
    }
    
    public PsiWorkOrderApprovalHistoryPk(Long wordOrderApprovalId) {
        this.wordOrderApprovalId = wordOrderApprovalId;
    }

    public void setWordOrderApprovalId(Long wordOrderApprovalId) {
        this.wordOrderApprovalId = wordOrderApprovalId;
    }
    public Long getWordOrderApprovalId() {
        return this.wordOrderApprovalId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (wordOrderApprovalId == null)
           
               ? true : false;
    }
    
}
