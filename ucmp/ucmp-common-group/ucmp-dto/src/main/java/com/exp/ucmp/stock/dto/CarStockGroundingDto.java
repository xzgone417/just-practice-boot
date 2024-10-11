package com.exp.ucmp.stock.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@ApiModel(value = "CarStockGroundingDto", description = "商城车辆上架列表")
public class CarStockGroundingDto {

    private static final long serialVersionUID = 1L;

    /**
     * 库存车辆id
     */
    @ApiModelProperty(value = "库存车辆id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stockId;


    /**
     * VIN码
     */
    @ApiModelProperty(value = "VIN码")
    private String vinCode;

    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;

    /**
     * 基础车型名称
     */
    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;

    /**
     * 外色
     */
    @ApiModelProperty(value = "外色")
    private String carColour;

    @ApiModelProperty(value = "内饰色名称")
    private String interiorColor;

    @ApiModelProperty(value = "上牌年")
    private String licenseYear;

    @ApiModelProperty(value = "业务id(查大图传)")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long materialFileId;

    @ApiModelProperty(value = "缩略图")
    private String fileUrl;


    @ApiModelProperty(value = "销售定价")
    private BigDecimal salePrice;

    @ApiModelProperty(value = "车辆所在地")
    private String city;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "整备id")
    private Long serviceId;

    @ApiModelProperty(value = "是否加装")
    private String flag;

    @ApiModelProperty(value = "行驶里程")
    private String stockMileage;

    @ApiModelProperty(value = "电池容量")
    private String batteryCapacity;

    @ApiModelProperty(value = "商品编号")
    private String itemNo;

    @ApiModelProperty(value = "标签")
    private List<CarLabelDto> labelList;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "首次上牌时间")
    private Date firstLicenseDate;

    @ApiModelProperty(value = "过户次数")
    private Integer transferCount;

    @ApiModelProperty(value = "权益活动编号")
    private String rightPackId;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getStockMileage() {
        return stockMileage;
    }

    public void setStockMileage(String stockMileage) {
        this.stockMileage = stockMileage;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
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

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getLicenseYear() {
        return licenseYear;
    }

    public void setLicenseYear(String licenseYear) {
        this.licenseYear = licenseYear;
    }

    public Long getMaterialFileId() {
        return materialFileId;
    }

    public void setMaterialFileId(Long materialFileId) {
        this.materialFileId = materialFileId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public List<CarLabelDto> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<CarLabelDto> labelList) {
        this.labelList = labelList;
    }

    public Date getFirstLicenseDate() {
        return firstLicenseDate;
    }

    public void setFirstLicenseDate(Date firstLicenseDate) {
        this.firstLicenseDate = firstLicenseDate;
    }

    public Integer getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(Integer transferCount) {
        this.transferCount = transferCount;
    }

    public String getRightPackId() {
        return rightPackId;
    }

    public void setRightPackId(String rightPackId) {
        this.rightPackId = rightPackId;
    }
}
