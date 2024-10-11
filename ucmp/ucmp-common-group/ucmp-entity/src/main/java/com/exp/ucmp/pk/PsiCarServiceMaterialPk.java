package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiCarServiceMaterialPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 材料id
     */
    private Long materialId;
    
    public PsiCarServiceMaterialPk() {
    }
    
    public PsiCarServiceMaterialPk(Long materialId) {
        this.materialId = materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }
    public Long getMaterialId() {
        return this.materialId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (materialId == null)
           
               ? true : false;
    }
    
}
