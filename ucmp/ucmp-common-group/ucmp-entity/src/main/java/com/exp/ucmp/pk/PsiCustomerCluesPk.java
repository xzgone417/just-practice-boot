package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCustomerCluesPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 线索ID
     */
    private Long cluesId;
    
    public PsiCustomerCluesPk() {
    }
    
    public PsiCustomerCluesPk(Long cluesId) {
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
