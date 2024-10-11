package com.exp.ucmp.pk;


import com.egrid.core.base.entity.AbstractBasePk;

public class SysConfigTopPicPk extends AbstractBasePk {

    private static final long serialVersionUID = 1L;
    
    /**
     * 工程车型编码
     */
    private String carSeriesCode;
    
    public SysConfigTopPicPk() {
    }
    
    public SysConfigTopPicPk(String carSeriesCode) {
        this.carSeriesCode = carSeriesCode;
    }

    public void setCarSeriesCode(String carSeriesCode) {
        this.carSeriesCode = carSeriesCode;
    }
    public String getCarSeriesCode() {
        return this.carSeriesCode;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (carSeriesCode == null || carSeriesCode.trim().length() == 0)
           
               ? true : false;
    }
    
}
