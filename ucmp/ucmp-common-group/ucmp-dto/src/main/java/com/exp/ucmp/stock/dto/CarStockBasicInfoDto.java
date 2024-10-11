package com.exp.ucmp.stock.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author gubonai
 * @Description: 车辆基本信息
 * @date 2023/2/6 10:52
 */
@ApiModel(value = "CarStorageInfoDto", description = "车辆基本信息Dto")
public class CarStockBasicInfoDto extends BaseModel {

    @ApiModelProperty(value = "工程车型名称")
    private String carSeriesName;

    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;

    @ApiModelProperty(value = "车辆使用性质")
    private String carNature;

    @ApiModelProperty(value = "所在地")
    private String city;

    @ApiModelProperty(value = "vin")
    private String vin;

    @ApiModelProperty(value = "认证时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date completeDate;
    
    @ApiModelProperty(value = "检测报告URL")
    private String testReportUrl;
    
    @ApiModelProperty(value = "库存车辆ID")
    private Long stockId;

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

    public String getCarNature() {
        return carNature;
    }

    public void setCarNature(String carNature) {
        this.carNature = carNature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

	public String getTestReportUrl() {
		return testReportUrl;
	}

	public void setTestReportUrl(String testReportUrl) {
		this.testReportUrl = testReportUrl;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
}
