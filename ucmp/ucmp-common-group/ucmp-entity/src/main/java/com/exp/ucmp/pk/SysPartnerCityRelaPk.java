package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysPartnerCityRelaPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 城市标识/主键
     */
    private Long cityId;
    
    public SysPartnerCityRelaPk() {
    }
    
    public SysPartnerCityRelaPk(Long cityId) {
        this.cityId = cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    public Long getCityId() {
        return this.cityId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (cityId == null)
           
               ? true : false;
    }
    
}
