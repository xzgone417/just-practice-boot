package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiOrderInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 订单信息id
     */
    private Long orderInfoId;
    
    public PsiOrderInfoPk() {
    }
    
    public PsiOrderInfoPk(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }
    public Long getOrderInfoId() {
        return this.orderInfoId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (orderInfoId == null)
           
               ? true : false;
    }
    
}
