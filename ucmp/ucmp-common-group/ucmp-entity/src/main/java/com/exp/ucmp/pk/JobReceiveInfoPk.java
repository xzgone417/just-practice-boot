package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class JobReceiveInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 主键
     */
    private Long receiveId;
    
    public JobReceiveInfoPk() {
    }
    
    public JobReceiveInfoPk(Long receiveId) {
        this.receiveId = receiveId;
    }

    public void setReceiveId(Long receiveId) {
        this.receiveId = receiveId;
    }
    public Long getReceiveId() {
        return this.receiveId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (receiveId == null)
           
               ? true : false;
    }
    
}
