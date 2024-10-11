package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysUserBehaviorPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 用户行为ID
     */
    private Long behaviorId;
    
    public SysUserBehaviorPk() {
    }
    
    public SysUserBehaviorPk(Long behaviorId) {
        this.behaviorId = behaviorId;
    }

    public void setBehaviorId(Long behaviorId) {
        this.behaviorId = behaviorId;
    }
    public Long getBehaviorId() {
        return this.behaviorId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (behaviorId == null)
           
               ? true : false;
    }
    
}
