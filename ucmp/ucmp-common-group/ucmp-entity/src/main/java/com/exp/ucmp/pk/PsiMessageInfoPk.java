package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiMessageInfoPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 消息标识
     */
    private Long messageId;
    
    public PsiMessageInfoPk() {
    }
    
    public PsiMessageInfoPk(Long messageId) {
        this.messageId = messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
    public Long getMessageId() {
        return this.messageId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (messageId == null)
           
               ? true : false;
    }
    
}
