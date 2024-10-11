package com.exp.ucmp.warehouse.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 零售批售出库参数
 * @date 2023/3/8 10:26
 */

public class BatchDeliveryParamsDto extends BaseModel {

    @ApiModelProperty(value = "1-零售、2-批售出库",required = true)
    private Integer type;

    @ApiModelProperty(value = "库存id集合",required = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private List<Long> stockIds;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Long> getStockIds() {
        return stockIds;
    }

    public void setStockIds(List<Long> stockIds) {
        this.stockIds = stockIds;
    }
}
