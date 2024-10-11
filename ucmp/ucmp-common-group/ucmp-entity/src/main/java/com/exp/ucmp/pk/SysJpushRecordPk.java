package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysJpushRecordPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 主键ID
     */
    private Long jpushId;
    
    public SysJpushRecordPk() {
    }
    
    public SysJpushRecordPk(Long jpushId) {
        this.jpushId = jpushId;
    }

    public void setJpushId(Long jpushId) {
        this.jpushId = jpushId;
    }
    public Long getJpushId() {
        return this.jpushId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (jpushId == null)
           
               ? true : false;
    }
    
}
