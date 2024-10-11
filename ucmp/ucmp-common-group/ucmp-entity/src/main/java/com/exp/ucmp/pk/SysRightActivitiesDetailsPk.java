package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysRightActivitiesDetailsPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 明细主键ID
     */
    private Long detailId;
    
    public SysRightActivitiesDetailsPk() {
    }
    
    public SysRightActivitiesDetailsPk(Long detailId) {
        this.detailId = detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }
    public Long getDetailId() {
        return this.detailId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (detailId == null)
           
               ? true : false;
    }
    
}
