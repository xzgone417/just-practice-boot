package com.exp.ucmp.stock.dto;

import com.exp.ucmp.entity.PsiCarOptionInfoEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "CarStockGroundingDetailDto", description = "商城车辆详情信息")
public class CarStockGroundingDetailDto {
    @ApiModelProperty(value = "vin")
    private String vin;
    
    @ApiModelProperty(value = "工程车型code")
    private String carSeriesCode;
    
    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;
    
    @ApiModelProperty(value = "基础车型名称code")
    private String baseCarTypeCode;

    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;

    @ApiModelProperty(value = "外色")
    private String carColour;

    @ApiModelProperty(value = "售价")
    private BigDecimal salePrice;

    @ApiModelProperty(value = "上牌日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String firstLicenseDate;

    @ApiModelProperty(value = "行驶里程")
    private String stockMileage;

    @ApiModelProperty(value = "电池容量")
    private String batteryCapacity;

    @ApiModelProperty(value = "车辆所在地")
    private String city;

    @ApiModelProperty(value = "交强险到期日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String accidentInsuranceEndDate;

    @ApiModelProperty(value = "年检到期日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String yearlyInspectionEndDate;

    @ApiModelProperty(value = "新车指导价")
    private BigDecimal guidePrice;

    @ApiModelProperty(value = "综合续航里程")
    private String comprehensiveRange;

    @ApiModelProperty(value = "表现里程")
    private String performanceMileage;

    @ApiModelProperty(value = "整车质保到期")
    private String warrantyEndDate;

    @ApiModelProperty(value = "三电质保到期")
    private String electricityEndDate;

    @ApiModelProperty(value = "认证报告链接")
    private String url;
    
    @ApiModelProperty(value = "过户次数")
    private Integer transferCount;
    
    @ApiModelProperty(value = "新车开票日期")
	private String invoiceDate;
    
    @ApiModelProperty(value = "标签")
    private List<CarLabelDto> labelList;

    @ApiModelProperty(value = "服务权益")
    private List<CarRightDto> rightList;

    @ApiModelProperty(value = "图片列表")
    private List<CarServiceFileDto> fileDtoList;
    
    @ApiModelProperty(value = "配置亮点顶部图")
    private String configTopPicUrl;

    @ApiModelProperty(value = "选装件集合（配置亮点）")
    private List<PsiCarOptionInfoEntity> optionInfoList;
    
    @ApiModelProperty(value = "更多推荐")
    private List<CarStockGroundingDto> moreList;

    private String rightPackId;

    public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getConfigTopPicUrl() {
		return configTopPicUrl;
	}

	public void setConfigTopPicUrl(String configTopPicUrl) {
		this.configTopPicUrl = configTopPicUrl;
	}

	public List<PsiCarOptionInfoEntity> getOptionInfoList() {
        return optionInfoList;
    }

    public void setOptionInfoList(List<PsiCarOptionInfoEntity> optionInfoList) {
        this.optionInfoList = optionInfoList;
    }

    public String getRightPackId() {
        return rightPackId;
    }

    public void setRightPackId(String rightPackId) {
        this.rightPackId = rightPackId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCarSeriesCode() {
		return carSeriesCode;
	}

	public void setCarSeriesCode(String carSeriesCode) {
		this.carSeriesCode = carSeriesCode;
	}

	public String getCarSeriesName() {
		return carSeriesName;
	}

	public void setCarSeriesName(String carSeriesName) {
		this.carSeriesName = carSeriesName;
	}

	public String getBaseCarTypeCode() {
		return baseCarTypeCode;
	}

	public void setBaseCarTypeCode(String baseCarTypeCode) {
		this.baseCarTypeCode = baseCarTypeCode;
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

	public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getFirstLicenseDate() {
        return firstLicenseDate;
    }

    public void setFirstLicenseDate(String firstLicenseDate) {
        this.firstLicenseDate = firstLicenseDate;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAccidentInsuranceEndDate() {
        return accidentInsuranceEndDate;
    }

    public void setAccidentInsuranceEndDate(String accidentInsuranceEndDate) {
        this.accidentInsuranceEndDate = accidentInsuranceEndDate;
    }

    public String getYearlyInspectionEndDate() {
        return yearlyInspectionEndDate;
    }

    public void setYearlyInspectionEndDate(String yearlyInspectionEndDate) {
        this.yearlyInspectionEndDate = yearlyInspectionEndDate;
    }

    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(BigDecimal guidePrice) {
        this.guidePrice = guidePrice;
    }

    public String getComprehensiveRange() {
        return comprehensiveRange;
    }

    public void setComprehensiveRange(String comprehensiveRange) {
        this.comprehensiveRange = comprehensiveRange;
    }

    public String getPerformanceMileage() {
        return performanceMileage;
    }

    public void setPerformanceMileage(String performanceMileage) {
        this.performanceMileage = performanceMileage;
    }

    public String getWarrantyEndDate() {
        return warrantyEndDate;
    }

    public void setWarrantyEndDate(String warrantyEndDate) {
        this.warrantyEndDate = warrantyEndDate;
    }

    public String getElectricityEndDate() {
        return electricityEndDate;
    }

    public void setElectricityEndDate(String electricityEndDate) {
        this.electricityEndDate = electricityEndDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTransferCount() {
		return transferCount;
	}

	public void setTransferCount(Integer transferCount) {
		this.transferCount = transferCount;
	}

	public List<CarLabelDto> getLabelList() {
		return labelList;
	}

	public void setLabelList(List<CarLabelDto> labelList) {
		this.labelList = labelList;
	}

	public List<CarRightDto> getRightList() {
        return rightList;
    }

    public void setRightList(List<CarRightDto> rightList) {
        this.rightList = rightList;
    }

    public List<CarServiceFileDto> getFileDtoList() {
        return fileDtoList;
    }

    public void setFileDtoList(List<CarServiceFileDto> fileDtoList) {
        this.fileDtoList = fileDtoList;
    }

	public List<CarStockGroundingDto> getMoreList() {
		return moreList;
	}

	public void setMoreList(List<CarStockGroundingDto> moreList) {
		this.moreList = moreList;
	}
}
