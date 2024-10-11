package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class RelationshipTypeCodePk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 当事人关系类型Code
     */
    private String relationshipTypeCode;
    
    public RelationshipTypeCodePk() {
    }
    
    public RelationshipTypeCodePk(String relationshipTypeCode) {
        this.relationshipTypeCode = relationshipTypeCode;
    }

    public void setRelationshipTypeCode(String relationshipTypeCode) {
        this.relationshipTypeCode = relationshipTypeCode;
    }
    public String getRelationshipTypeCode() {
        return this.relationshipTypeCode;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (relationshipTypeCode == null || relationshipTypeCode.trim().length() == 0)
           
               ? true : false;
    }
    
}
