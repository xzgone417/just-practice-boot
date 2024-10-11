package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiPricingJournalPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 定价日志表id
     */
    private Long journalId;
    
    public PsiPricingJournalPk() {
    }
    
    public PsiPricingJournalPk(Long journalId) {
        this.journalId = journalId;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }
    public Long getJournalId() {
        return this.journalId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (journalId == null)
           
               ? true : false;
    }
    
}
