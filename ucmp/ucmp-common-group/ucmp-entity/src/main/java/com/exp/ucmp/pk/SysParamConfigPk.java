package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysParamConfigPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 主键id
     */
    private Long paramId;
    
    public SysParamConfigPk() {
    }
    
    public SysParamConfigPk(Long paramId) {
        this.paramId = paramId;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }
    public Long getParamId() {
        return this.paramId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (paramId == null)
           
               ? true : false;
    }
    
}
