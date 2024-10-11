package com.exp.ucmp.warehouse.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 出入库查询条件dto
 * @date 2023/2/17 10:10
 */
@ApiModel(value = "WarehouseQueryDto", description = "出入库查询条件dto")
public class WarehouseQueryDto extends PageDto {

    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;

    @ApiModelProperty(value = "基础车型")
    private String baseCarTypeName;

    @ApiModelProperty(value = "vin")
    private String vin;

    @ApiModelProperty(value = "不用传")
    private List<Long> storeIds;

    public enum queryEnum {
//        ReadinessWarehousing, ReadyMadeWarehouse,
        TransferReceipt,TransferIssue,RetailOutbound,BatchIssue;
    }
    @ApiModelProperty(value = "查询类型: " +
//            "ReadinessWarehousing(整备入库),ReadyMadeWarehouse(整备出库)," +
            "TransferReceipt(调拨入库),TransferIssue(调拨出库)" +
            "RetailOutbound(零售出库),BatchIssue(批售出库)",required = true)
    private String queryEnum;

    public String getQueryEnum() {
        return queryEnum;
    }

    public void setQueryEnum(String queryEnum) {
        this.queryEnum = queryEnum;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public List<Long> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
    }

    public String getCarSeriesName() {
        return carSeriesName;
    }

    public void setCarSeriesName(String carSeriesName) {
        this.carSeriesName = carSeriesName;
    }

    public String getBaseCarTypeName() {
        return baseCarTypeName;
    }

    public void setBaseCarTypeName(String baseCarTypeName) {
        this.baseCarTypeName = baseCarTypeName;
    }
}
