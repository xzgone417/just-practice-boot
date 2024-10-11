package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysJpushTemplateConfigPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 消息模板id
     */
    private Long templateId;
    
    public SysJpushTemplateConfigPk() {
    }
    
    public SysJpushTemplateConfigPk(Long templateId) {
        this.templateId = templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
    public Long getTemplateId() {
        return this.templateId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (templateId == null)
           
               ? true : false;
    }
    
}
