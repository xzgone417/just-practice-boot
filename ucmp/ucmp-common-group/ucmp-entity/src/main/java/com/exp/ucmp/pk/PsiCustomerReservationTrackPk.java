package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCustomerReservationTrackPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 预约ID
     */
    private Long reservationId;
    
    public PsiCustomerReservationTrackPk() {
    }
    
    public PsiCustomerReservationTrackPk(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (reservationId == null)
           
               ? true : false;
    }
    
}
