package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiBusinessNodesMaterialPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * ID
     */
    private Long id;
    
    public PsiBusinessNodesMaterialPk() {
    }
    
    public PsiBusinessNodesMaterialPk(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return this.id;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (id == null)
           
               ? true : false;
    }
    
}
