package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class RepReplacementApprovalRecordPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 审批ID
     */
    private Long approvalId;
    
    public RepReplacementApprovalRecordPk() {
    }
    
    public RepReplacementApprovalRecordPk(Long approvalId) {
        this.approvalId = approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }
    public Long getApprovalId() {
        return this.approvalId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (approvalId == null)
           
               ? true : false;
    }
    
}
