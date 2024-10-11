package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysKeyWordPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 主键id
     */
    private Long keyWordsId;
    
    public SysKeyWordPk() {
    }
    
    public SysKeyWordPk(Long keyWordsId) {
        this.keyWordsId = keyWordsId;
    }

    public void setKeyWordsId(Long keyWordsId) {
        this.keyWordsId = keyWordsId;
    }
    public Long getKeyWordsId() {
        return this.keyWordsId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (keyWordsId == null)
           
               ? true : false;
    }
    
}
