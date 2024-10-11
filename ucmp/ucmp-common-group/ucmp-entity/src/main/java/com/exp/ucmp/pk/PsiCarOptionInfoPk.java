package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarOptionInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 选装id
     */
    private Long optionId;
    
    public PsiCarOptionInfoPk() {
    }
    
    public PsiCarOptionInfoPk(Long optionId) {
        this.optionId = optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }
    public Long getOptionId() {
        return this.optionId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (optionId == null)
           
               ? true : false;
    }
    
}
