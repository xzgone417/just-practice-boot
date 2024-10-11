package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiTransferRouteInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 途径点位id
     */
    private Long routeId;
    
    public PsiTransferRouteInfoPk() {
    }
    
    public PsiTransferRouteInfoPk(Long routeId) {
        this.routeId = routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
    public Long getRouteId() {
        return this.routeId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (routeId == null)
           
               ? true : false;
    }
    
}
