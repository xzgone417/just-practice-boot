package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PartyRoleRelaPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 当事人角色标识
     */
    private Long partyRoleId;
    
    public PartyRoleRelaPk() {
    }
    
    public PartyRoleRelaPk(Long partyRoleId) {
        this.partyRoleId = partyRoleId;
    }

    public void setPartyRoleId(Long partyRoleId) {
        this.partyRoleId = partyRoleId;
    }
    public Long getPartyRoleId() {
        return this.partyRoleId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (partyRoleId == null)
           
               ? true : false;
    }
    
}
