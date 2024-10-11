package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysFileMsgPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 文件ID
     */
    private Long fileId;
    
    public SysFileMsgPk() {
    }
    
    public SysFileMsgPk(Long fileId) {
        this.fileId = fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
    public Long getFileId() {
        return this.fileId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (fileId == null)
           
               ? true : false;
    }
    
}
