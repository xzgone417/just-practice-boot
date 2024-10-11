package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiSalesMessageRecordPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 消息标识
     */
    private Long messageRecordId;
    
    public PsiSalesMessageRecordPk() {
    }
    
    public PsiSalesMessageRecordPk(Long messageRecordId) {
        this.messageRecordId = messageRecordId;
    }

    public void setMessageRecordId(Long messageRecordId) {
        this.messageRecordId = messageRecordId;
    }
    public Long getMessageRecordId() {
        return this.messageRecordId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (messageRecordId == null)
           
               ? true : false;
    }
    
}
