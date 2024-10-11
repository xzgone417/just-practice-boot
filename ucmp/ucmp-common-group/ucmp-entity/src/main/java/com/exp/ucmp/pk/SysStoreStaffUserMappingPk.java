package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysStoreStaffUserMappingPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 映射id
     */
    private Long mappingId;
    
    public SysStoreStaffUserMappingPk() {
    }
    
    public SysStoreStaffUserMappingPk(Long mappingId) {
        this.mappingId = mappingId;
    }

    public void setMappingId(Long mappingId) {
        this.mappingId = mappingId;
    }
    public Long getMappingId() {
        return this.mappingId;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (mappingId == null)
           
               ? true : false;
    }
    
}
