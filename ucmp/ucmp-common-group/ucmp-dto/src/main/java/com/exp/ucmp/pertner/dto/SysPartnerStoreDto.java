package com.exp.ucmp.pertner.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.model.BaseModel;

@ApiModel(value = "SysPartnerStoreDto", description = "车商门店对象")
public class SysPartnerStoreDto extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7016005326258402861L;

	/**
     * 
     */
    @ApiModelProperty(value = "门店ID")
    private Long storeId;
    
    /**
     * 
     */
    @ApiModelProperty(value = "车商ID")
    private Long partnerId;
    

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Long getStoreId() {
        return this.storeId;
    }
    
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
    public Long getPartnerId() {
        return this.partnerId;
    }
    
}
