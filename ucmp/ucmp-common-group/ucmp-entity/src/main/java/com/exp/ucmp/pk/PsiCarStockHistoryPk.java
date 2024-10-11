package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarStockHistoryPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 历史表id
     */
    private Long historyId;
    
    public PsiCarStockHistoryPk() {
    }
    
    public PsiCarStockHistoryPk(Long historyId) {
        this.historyId = historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }
    public Long getHistoryId() {
        return this.historyId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (historyId == null)
           
               ? true : false;
    }
    
}
