package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCustomerBookingTrackingPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 预约id 
     */
    private Long bookingId;
    
    public PsiCustomerBookingTrackingPk() {
    }
    
    public PsiCustomerBookingTrackingPk(Long bookingId) {
        this.bookingId = bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public Long getBookingId() {
        return this.bookingId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (bookingId == null)
           
               ? true : false;
    }
    
}
