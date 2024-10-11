package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarStockInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 库存车辆id
     */
    private Long stockId;
    
    public PsiCarStockInfoPk() {
    }
    
    public PsiCarStockInfoPk(Long stockId) {
        this.stockId = stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
    public Long getStockId() {
        return this.stockId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (stockId == null)
           
               ? true : false;
    }
    
}
