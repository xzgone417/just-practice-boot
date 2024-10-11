package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysCarUsedStoragePk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 仓储点id
     */
    private Long storageId;
    
    public SysCarUsedStoragePk() {
    }
    
    public SysCarUsedStoragePk(Long storageId) {
        this.storageId = storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }
    public Long getStorageId() {
        return this.storageId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (storageId == null)
           
               ? true : false;
    }
    
}
