package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarServiceInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 整备信息id
     */
    private Long serviceId;
    
    public PsiCarServiceInfoPk() {
    }
    
    public PsiCarServiceInfoPk(Long serviceId) {
        this.serviceId = serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
    public Long getServiceId() {
        return this.serviceId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (serviceId == null)
           
               ? true : false;
    }
    
}
