package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarServiceRepairProjectComponentPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 配件id
     */
    private Long componentId;
    
    public PsiCarServiceRepairProjectComponentPk() {
    }
    
    public PsiCarServiceRepairProjectComponentPk(Long componentId) {
        this.componentId = componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }
    public Long getComponentId() {
        return this.componentId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (componentId == null)
           
               ? true : false;
    }
    
}
