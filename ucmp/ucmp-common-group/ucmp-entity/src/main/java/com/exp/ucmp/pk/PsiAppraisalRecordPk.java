package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiAppraisalRecordPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 估价ID
     */
    private Long appraisalId;
    
    public PsiAppraisalRecordPk() {
    }
    
    public PsiAppraisalRecordPk(Long appraisalId) {
        this.appraisalId = appraisalId;
    }

    public void setAppraisalId(Long appraisalId) {
        this.appraisalId = appraisalId;
    }
    public Long getAppraisalId() {
        return this.appraisalId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (appraisalId == null)
           
               ? true : false;
    }
    
}
