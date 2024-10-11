package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiDispatchInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 调度信息id
     */
    private Long dispatchInfoId;
    
    public PsiDispatchInfoPk() {
    }
    
    public PsiDispatchInfoPk(Long dispatchInfoId) {
        this.dispatchInfoId = dispatchInfoId;
    }

    public void setDispatchInfoId(Long dispatchInfoId) {
        this.dispatchInfoId = dispatchInfoId;
    }
    public Long getDispatchInfoId() {
        return this.dispatchInfoId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (dispatchInfoId == null)
           
               ? true : false;
    }
    
}
