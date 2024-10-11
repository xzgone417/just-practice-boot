package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysStaffAreaLogPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 
     */
    private Long logId;
    
    public SysStaffAreaLogPk() {
    }
    
    public SysStaffAreaLogPk(Long logId) {
        this.logId = logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }
    public Long getLogId() {
        return this.logId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (logId == null)
           
               ? true : false;
    }
    
}
