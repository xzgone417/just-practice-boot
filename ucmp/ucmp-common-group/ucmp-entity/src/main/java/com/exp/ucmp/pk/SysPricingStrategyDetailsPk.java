package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysPricingStrategyDetailsPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 策略详情id
     */
    private Long strategyDetailsId;
    
    public SysPricingStrategyDetailsPk() {
    }
    
    public SysPricingStrategyDetailsPk(Long strategyDetailsId) {
        this.strategyDetailsId = strategyDetailsId;
    }

    public void setStrategyDetailsId(Long strategyDetailsId) {
        this.strategyDetailsId = strategyDetailsId;
    }
    public Long getStrategyDetailsId() {
        return this.strategyDetailsId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (strategyDetailsId == null)
           
               ? true : false;
    }
    
}
