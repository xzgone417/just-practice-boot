package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysDepartmentInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 部门标识
     */
    private Long departmentId;
    
    public SysDepartmentInfoPk() {
    }
    
    public SysDepartmentInfoPk(Long departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    public Long getDepartmentId() {
        return this.departmentId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (departmentId == null)
           
               ? true : false;
    }
    
}
