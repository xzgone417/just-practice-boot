package com.exp.ucmp.stock.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


/**
 * @author GeYiJiang
 * @Description: 零售上架dto
 * @date 2023/2/18 15:07
 */
@ApiModel(value = "RetailLoadingDto对象", description = "零售上架dto查询参数")
public class RetailLoadingDto extends BaseModel {

	@NotNull
    @ApiModelProperty(value = "车辆id")
    private Long stockId;
    
    @ApiModelProperty(value = "上下架状态(上架-on,下架-off)")
    private String status;
    
    @ApiModelProperty(value = "权益包编号")
    private Long rightPackId;
    
    @ApiModelProperty(value = "定价")
    private String price;

    public Long getRightPackId() {
        return rightPackId;
    }

    public void setRightPackId(Long rightPackId) {
        this.rightPackId = rightPackId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
