package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCreateOrderAccountInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 创建预约单顾问信息标识
     */
    private Long infoId;
    
    public PsiCreateOrderAccountInfoPk() {
    }
    
    public PsiCreateOrderAccountInfoPk(Long infoId) {
        this.infoId = infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }
    public Long getInfoId() {
        return this.infoId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (infoId == null)
           
               ? true : false;
    }
    
}
