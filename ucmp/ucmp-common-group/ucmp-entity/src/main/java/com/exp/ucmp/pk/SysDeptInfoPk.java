package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysDeptInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 主键标识
     */
    private Long deptInfoId;
    
    public SysDeptInfoPk() {
    }
    
    public SysDeptInfoPk(Long deptInfoId) {
        this.deptInfoId = deptInfoId;
    }

    public void setDeptInfoId(Long deptInfoId) {
        this.deptInfoId = deptInfoId;
    }
    public Long getDeptInfoId() {
        return this.deptInfoId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (deptInfoId == null)
           
               ? true : false;
    }
    
}
