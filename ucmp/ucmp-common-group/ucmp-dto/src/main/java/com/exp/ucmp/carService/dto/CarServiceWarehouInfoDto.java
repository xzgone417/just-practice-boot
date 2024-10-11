package com.exp.ucmp.carService.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarServiceWarehouInfoDto", description = "整备待入库车辆基础信息DTO")
public class CarServiceWarehouInfoDto {

    private static final long serialVersionUID = 1L;

    /**
     * 库存车辆id
     */
    @ApiModelProperty("库存车辆id")
    private Long stockId;

    /**
     * 车辆类型
     */
    @ApiModelProperty(value = "车辆类型")
    private String carType;

    /**
     * 工程车型名称
     */
    @ApiModelProperty(value = "工程车型名称")
    private String carSeriesName;

    /**
     * 基础车型名称
     */
    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;

    /**
     * VIN
     */
    @ApiModelProperty(value = "VIN")
    private String vinCode;

    /**
     * 内饰
     */
    @ApiModelProperty(value = "内饰")
    private String interiorColor;

    /**
     * 外色
     */
    @ApiModelProperty(value = "外色")
    private String carColour;

    /**
     * 牌照号
     */
    @ApiModelProperty(value = "牌照号")
    private String licenseNumber;


    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
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

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
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

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public CarServiceWarehouInfoDto() {
    }

}
