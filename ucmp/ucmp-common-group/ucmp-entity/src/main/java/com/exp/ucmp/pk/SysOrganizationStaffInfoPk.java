package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysOrganizationStaffInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 主键标识
     */
    private Long rspUserInfoId;
    
    public SysOrganizationStaffInfoPk() {
    }
    
    public SysOrganizationStaffInfoPk(Long rspUserInfoId) {
        this.rspUserInfoId = rspUserInfoId;
    }

    public void setRspUserInfoId(Long rspUserInfoId) {
        this.rspUserInfoId = rspUserInfoId;
    }
    public Long getRspUserInfoId() {
        return this.rspUserInfoId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (rspUserInfoId == null)
           
               ? true : false;
    }
    
}
