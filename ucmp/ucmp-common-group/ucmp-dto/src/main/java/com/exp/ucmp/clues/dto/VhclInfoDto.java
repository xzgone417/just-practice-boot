package com.exp.ucmp.clues.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author gubonai
 * @Description: 车辆基本信息
 * @date 2023/2/6 10:52
 */
@ApiModel(value = "VhclInfoDto", description = "车辆信息Dto")
public class VhclInfoDto extends BaseModel {
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("库存车辆id")
    private Long stockId;
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("仓储点id")
    private Long storageId;

    @ApiModelProperty(value = "工程车型名称")
    private String carSeriesName;

    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;

    @ApiModelProperty(value = "内饰")
    private String interiorColor;

    @ApiModelProperty(value = "外色")
    private String carColour;

    @ApiModelProperty(value = "车辆价格")
    private BigDecimal salePrice;

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
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

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
}
