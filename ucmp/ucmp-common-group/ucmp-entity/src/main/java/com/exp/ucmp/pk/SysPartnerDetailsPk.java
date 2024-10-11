package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysPartnerDetailsPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 主键/合作商标识
     */
    private Long partnerId;
    
    public SysPartnerDetailsPk() {
    }
    
    public SysPartnerDetailsPk(Long partnerId) {
        this.partnerId = partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
    public Long getPartnerId() {
        return this.partnerId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (partnerId == null)
           
               ? true : false;
    }
    
}
