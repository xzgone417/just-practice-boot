package com.exp.ucmp.stock.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "CarStockBaseInfoDto", description = "库存车辆基本信息Dto")
public class CarStockBaseInfoDto {

    /**
     * 库存车辆id
     */
    @ApiModelProperty(value = "库存车辆id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stockId;

    @ApiModelProperty(value = "过户次数")
    private Integer transferCount;

    @ApiModelProperty(value = "牌照号")
    private String licenseNumber;

    @ApiModelProperty(value = "牌照属地")
    private String licensePlace;

    @ApiModelProperty(value = "交强险到期日期")
    private Date accidentInsuranceEndDate;

    @ApiModelProperty(value = "年检到期日期")
    private Date yearlyInspectionEndDate;

    @ApiModelProperty(value = "综合续航里程（kM）")
    private String comprehensiveRange;

    @ApiModelProperty(value = "电池容量（kWh）")
    private String batteryCapacity;
    /**
     * 车辆级别（1.S级 2.A级 3.B级 4.C级）
     */
    @ApiModelProperty(value = "车辆级别（1.S级 2.A级 3.B级 4.C级）")
    private String carLevel;
    
    @ApiModelProperty(value = "仓储点id")
    private Long storageId;
    
    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Integer getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(Integer transferCount) {
        this.transferCount = transferCount;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicensePlace() {
        return licensePlace;
    }

    public void setLicensePlace(String licensePlace) {
        this.licensePlace = licensePlace;
    }

    public Date getAccidentInsuranceEndDate() {
        return accidentInsuranceEndDate;
    }

    public void setAccidentInsuranceEndDate(Date accidentInsuranceEndDate) {
        this.accidentInsuranceEndDate = accidentInsuranceEndDate;
    }

    public Date getYearlyInspectionEndDate() {
        return yearlyInspectionEndDate;
    }

    public void setYearlyInspectionEndDate(Date yearlyInspectionEndDate) {
        this.yearlyInspectionEndDate = yearlyInspectionEndDate;
    }

    public String getComprehensiveRange() {
        return comprehensiveRange;
    }

    public void setComprehensiveRange(String comprehensiveRange) {
        this.comprehensiveRange = comprehensiveRange;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getCarLevel() {
        return carLevel;
    }

    public void setCarLevel(String carLevel) {
        this.carLevel = carLevel;
    }

	public Long getStorageId() {
		return storageId;
	}

	public void setStorageId(Long storageId) {
		this.storageId = storageId;
	}
}
