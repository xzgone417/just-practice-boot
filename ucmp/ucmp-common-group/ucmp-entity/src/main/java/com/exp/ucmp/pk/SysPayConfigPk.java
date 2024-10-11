package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysPayConfigPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 车辆主体code
     */
    private String revertBody;
    
    public SysPayConfigPk() {
    }
    
    public SysPayConfigPk(String revertBody) {
        this.revertBody = revertBody;
    }

    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }
    public String getRevertBody() {
        return this.revertBody;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (revertBody == null || revertBody.trim().length() == 0)
           
               ? true : false;
    }
    
}
