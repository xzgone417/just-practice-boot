package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarServiceRepairProjectPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 项目id
     */
    private Long projectId;
    
    public PsiCarServiceRepairProjectPk() {
    }
    
    public PsiCarServiceRepairProjectPk(Long projectId) {
        this.projectId = projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
    public Long getProjectId() {
        return this.projectId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (projectId == null)
           
               ? true : false;
    }
    
}
