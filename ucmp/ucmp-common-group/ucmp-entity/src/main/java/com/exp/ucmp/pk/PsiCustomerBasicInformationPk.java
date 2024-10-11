package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCustomerBasicInformationPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 客户ID
     */
    private Long customerId;
    
    public PsiCustomerBasicInformationPk() {
    }
    
    public PsiCustomerBasicInformationPk(Long customerId) {
        this.customerId = customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return this.customerId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (customerId == null)
           
               ? true : false;
    }
    
}
