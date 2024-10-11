package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCustomerVehiclePk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 车辆ID
     */
    private Long vehicleId;
    
    public PsiCustomerVehiclePk() {
    }
    
    public PsiCustomerVehiclePk(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
    public Long getVehicleId() {
        return this.vehicleId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (vehicleId == null)
           
               ? true : false;
    }
    
}
