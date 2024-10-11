package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysPricingStrategyPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 策略id
     */
    private Long strategyId;
    
    public SysPricingStrategyPk() {
    }
    
    public SysPricingStrategyPk(Long strategyId) {
        this.strategyId = strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
    public Long getStrategyId() {
        return this.strategyId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (strategyId == null)
           
               ? true : false;
    }
    
}
