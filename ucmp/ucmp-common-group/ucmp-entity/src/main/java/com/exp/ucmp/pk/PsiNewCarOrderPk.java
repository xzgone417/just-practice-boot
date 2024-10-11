package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiNewCarOrderPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 新车ID
     */
    private Long newCarId;
    
    public PsiNewCarOrderPk() {
    }
    
    public PsiNewCarOrderPk(Long newCarId) {
        this.newCarId = newCarId;
    }

    public void setNewCarId(Long newCarId) {
        this.newCarId = newCarId;
    }
    public Long getNewCarId() {
        return this.newCarId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (newCarId == null)
           
               ? true : false;
    }
    
}
