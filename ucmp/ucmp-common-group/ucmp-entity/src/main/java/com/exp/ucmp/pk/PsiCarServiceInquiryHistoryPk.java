package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarServiceInquiryHistoryPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 业务id
     */
    private Long inquiryHistoryId;
    
    public PsiCarServiceInquiryHistoryPk() {
    }
    
    public PsiCarServiceInquiryHistoryPk(Long inquiryHistoryId) {
        this.inquiryHistoryId = inquiryHistoryId;
    }

    public void setInquiryHistoryId(Long inquiryHistoryId) {
        this.inquiryHistoryId = inquiryHistoryId;
    }
    public Long getInquiryHistoryId() {
        return this.inquiryHistoryId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (inquiryHistoryId == null)
           
               ? true : false;
    }
    
}
