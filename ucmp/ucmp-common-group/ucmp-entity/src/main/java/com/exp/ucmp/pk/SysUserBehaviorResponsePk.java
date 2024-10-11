package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysUserBehaviorResponsePk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 请求ID
     */
    private String requestId;
    
    public SysUserBehaviorResponsePk() {
    }
    
    public SysUserBehaviorResponsePk(String requestId) {
        this.requestId = requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public String getRequestId() {
        return this.requestId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (requestId == null || requestId.trim().length() == 0)
           
               ? true : false;
    }
    
}
