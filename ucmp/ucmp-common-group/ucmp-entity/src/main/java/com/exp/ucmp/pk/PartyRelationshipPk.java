package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PartyRelationshipPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 当事人标识
     */
    private Long relationshipId;
    
    public PartyRelationshipPk() {
    }
    
    public PartyRelationshipPk(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }
    public Long getRelationshipId() {
        return this.relationshipId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (relationshipId == null)
           
               ? true : false;
    }
    
}
