package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiInquiryCarsPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 询价ID
     */
    private Long inquiryId;
    
    public PsiInquiryCarsPk() {
    }
    
    public PsiInquiryCarsPk(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }
    public Long getInquiryId() {
        return this.inquiryId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (inquiryId == null)
           
               ? true : false;
    }
    
}
