package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysRightActivitiesPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 权益活动主键ID
     */
    private Long rightId;
    
    public SysRightActivitiesPk() {
    }
    
    public SysRightActivitiesPk(Long rightId) {
        this.rightId = rightId;
    }

    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }
    public Long getRightId() {
        return this.rightId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (rightId == null)
           
               ? true : false;
    }
    
}
