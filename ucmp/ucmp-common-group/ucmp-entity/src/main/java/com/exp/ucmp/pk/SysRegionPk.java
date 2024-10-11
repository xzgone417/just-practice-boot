package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysRegionPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 区划代码
     */
    private Long regionCode;
    
    public SysRegionPk() {
    }
    
    public SysRegionPk(Long regionCode) {
        this.regionCode = regionCode;
    }

    public void setRegionCode(Long regionCode) {
        this.regionCode = regionCode;
    }
    public Long getRegionCode() {
        return this.regionCode;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (regionCode == null)
           
               ? true : false;
    }
    
}
