package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysAreaInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 区域标识
     */
    private Long areaId;
    
    public SysAreaInfoPk() {
    }
    
    public SysAreaInfoPk(Long areaId) {
        this.areaId = areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
    public Long getAreaId() {
        return this.areaId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (areaId == null)
           
               ? true : false;
    }
    
}
