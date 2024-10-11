package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysRightActivitiesDistributeDetailsPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 发放明细主键ID
     */
    private Long distributeDetailId;
    
    public SysRightActivitiesDistributeDetailsPk() {
    }
    
    public SysRightActivitiesDistributeDetailsPk(Long distributeDetailId) {
        this.distributeDetailId = distributeDetailId;
    }

    public void setDistributeDetailId(Long distributeDetailId) {
        this.distributeDetailId = distributeDetailId;
    }
    public Long getDistributeDetailId() {
        return this.distributeDetailId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (distributeDetailId == null)
           
               ? true : false;
    }
    
}
