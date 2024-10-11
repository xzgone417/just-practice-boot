package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiRetentionCluesPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 线索id
     */
    private Long cluesId;
    
    public PsiRetentionCluesPk() {
    }
    
    public PsiRetentionCluesPk(Long cluesId) {
        this.cluesId = cluesId;
    }

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }
    public Long getCluesId() {
        return this.cluesId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (cluesId == null)
           
               ? true : false;
    }
    
}
