package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysDatadictPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * PKID
     */
    private Long dictId;
    
    public SysDatadictPk() {
    }
    
    public SysDatadictPk(Long dictId) {
        this.dictId = dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }
    public Long getDictId() {
        return this.dictId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (dictId == null)
           
               ? true : false;
    }
    
}
