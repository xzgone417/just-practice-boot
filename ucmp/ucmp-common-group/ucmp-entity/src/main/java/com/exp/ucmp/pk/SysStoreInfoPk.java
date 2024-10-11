package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysStoreInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 
     */
    private Long storeId;
    
    public SysStoreInfoPk() {
    }
    
    public SysStoreInfoPk(Long storeId) {
        this.storeId = storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Long getStoreId() {
        return this.storeId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (storeId == null)
           
               ? true : false;
    }
    
}
