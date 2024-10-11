package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysStoreStaffDetailsPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 员工ID
     */
    private Long partyId;
    
    public SysStoreStaffDetailsPk() {
    }
    
    public SysStoreStaffDetailsPk(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (partyId == null)
           
               ? true : false;
    }
    
}
