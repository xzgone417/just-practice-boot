package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiAcquisitionMaterialFilePk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 材料文件ID
     */
    private Long materialFileId;
    
    public PsiAcquisitionMaterialFilePk() {
    }
    
    public PsiAcquisitionMaterialFilePk(Long materialFileId) {
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
