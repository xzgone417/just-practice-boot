package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysMaterialFilePk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 材料文件ID
     */
    private Long materialFileId;
    
    public SysMaterialFilePk() {
    }
    
    public SysMaterialFilePk(Long materialFileId) {
        this.materialFileId = materialFileId;
    }

    public void setMaterialFileId(Long materialFileId) {
        this.materialFileId = materialFileId;
    }
    public Long getMaterialFileId() {
        return this.materialFileId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (materialFileId == null)
           
               ? true : false;
    }
    
}
