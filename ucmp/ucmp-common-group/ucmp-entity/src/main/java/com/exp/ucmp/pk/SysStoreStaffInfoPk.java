package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysStoreStaffInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 主键
     */
    private Long storeStaffId;
    
    public SysStoreStaffInfoPk() {
    }
    
    public SysStoreStaffInfoPk(Long storeStaffId) {
        this.storeStaffId = storeStaffId;
    }

    public void setStoreStaffId(Long storeStaffId) {
        this.storeStaffId = storeStaffId;
    }
    public Long getStoreStaffId() {
        return this.storeStaffId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (storeStaffId == null)
           
               ? true : false;
    }
    
}
