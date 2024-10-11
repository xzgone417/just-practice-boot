package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiOrderFollowRecordPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 订单状态变更记录id
     */
    private Long orderFollowId;
    
    public PsiOrderFollowRecordPk() {
    }
    
    public PsiOrderFollowRecordPk(Long orderFollowId) {
        this.orderFollowId = orderFollowId;
    }

    public void setOrderFollowId(Long orderFollowId) {
        this.orderFollowId = orderFollowId;
    }
    public Long getOrderFollowId() {
        return this.orderFollowId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (orderFollowId == null)
           
               ? true : false;
    }
    
}
