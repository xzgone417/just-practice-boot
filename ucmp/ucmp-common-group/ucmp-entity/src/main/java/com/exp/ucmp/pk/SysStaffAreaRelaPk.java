package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysStaffAreaRelaPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 主键
     */
    private Long relaId;
    
    public SysStaffAreaRelaPk() {
    }
    
    public SysStaffAreaRelaPk(Long relaId) {
        this.relaId = relaId;
    }

    public void setRelaId(Long relaId) {
        this.relaId = relaId;
    }
    public Long getRelaId() {
        return this.relaId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (relaId == null)
           
               ? true : false;
    }
    
}
