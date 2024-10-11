package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PartyPermissionRelaPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 人员权限标识
     */
    private Long partyPermissionId;
    
    public PartyPermissionRelaPk() {
    }
    
    public PartyPermissionRelaPk(Long partyPermissionId) {
        this.partyPermissionId = partyPermissionId;
    }

    public void setPartyPermissionId(Long partyPermissionId) {
        this.partyPermissionId = partyPermissionId;
    }
    public Long getPartyPermissionId() {
        return this.partyPermissionId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (partyPermissionId == null)
           
               ? true : false;
    }
    
}
