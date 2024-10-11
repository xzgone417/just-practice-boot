package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysPricingRulesPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 规则id
     */
    private Long ruleId;
    
    public SysPricingRulesPk() {
    }
    
    public SysPricingRulesPk(Long ruleId) {
        this.ruleId = ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }
    public Long getRuleId() {
        return this.ruleId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (ruleId == null)
           
               ? true : false;
    }
    
}
