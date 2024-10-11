package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class PsiSalesOrderMaterialPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 材料ID
     */
    private Long materialId;
    
    public PsiSalesOrderMaterialPk() {
    }
    
    public PsiSalesOrderMaterialPk(Long materialId) {
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
