package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysDatadictTypeCodePk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 分类编码
     */
    private String dictTag;
    
    public SysDatadictTypeCodePk() {
    }
    
    public SysDatadictTypeCodePk(String dictTag) {
        this.dictTag = dictTag;
    }

    public void setDictTag(String dictTag) {
        this.dictTag = dictTag;
    }
    public String getDictTag() {
        return this.dictTag;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (dictTag == null || dictTag.trim().length() == 0)
           
               ? true : false;
    }
    
}
