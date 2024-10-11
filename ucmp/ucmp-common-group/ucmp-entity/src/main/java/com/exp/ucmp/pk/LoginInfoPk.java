package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class LoginInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 登录标识
     */
    private Long loginId;
    
    public LoginInfoPk() {
    }
    
    public LoginInfoPk(Long loginId) {
        this.loginId = loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }
    public Long getLoginId() {
        return this.loginId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (loginId == null)
           
               ? true : false;
    }
    
}
