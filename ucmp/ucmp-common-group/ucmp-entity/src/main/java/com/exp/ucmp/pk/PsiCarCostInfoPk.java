package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarCostInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 费用信息id
     */
    private Long costInfoId;
    
    public PsiCarCostInfoPk() {
    }
    
    public PsiCarCostInfoPk(Long costInfoId) {
        this.costInfoId = costInfoId;
    }

    public void setCostInfoId(Long costInfoId) {
        this.costInfoId = costInfoId;
    }
    public Long getCostInfoId() {
        return this.costInfoId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (costInfoId == null)
           
               ? true : false;
    }
    
}
