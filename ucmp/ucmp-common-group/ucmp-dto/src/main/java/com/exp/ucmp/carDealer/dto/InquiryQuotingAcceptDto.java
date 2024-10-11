package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@ApiModel(value = "InquiryQuotingAcceptDto", description = "询价报价对象")
public class InquiryQuotingAcceptDto extends BaseModel {
    /**
     *
     */
    private static final long serialVersionUID = 6985996612987118008L;

    /**
     * 询价ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "询价ID")
    private Long inquiryId;

    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;

    /**
     * 品牌
     */
    @ApiModelProperty(value = "品牌")
    private String brand;

    /**
     * 品牌中文描述
     */
    @ApiModelProperty(value = "品牌中文描述")
    private String brandChineseDescribe;

    /**
     * 车型
     */
    @ApiModelProperty(value = "车型")
    private String carType;

    /**
     * 车型中文描述
     */
    @ApiModelProperty(value = "车型中文描述")
    private String carTypeChineseDescribe;

    /**
     * 车系中文描述
     */
    @ApiModelProperty(value = "车系中文描述")
    private String carSeriesChineseDescribe;

    /**
     * 车系
     */
    @ApiModelProperty(value = "车系")
    private String carSeries;

    /**
     * 年款中文描述
     */
    @ApiModelProperty(value = "年款中文描述")
    private String carYearChineseDescribe;

    /**
     * 年款
     */
    @ApiModelProperty(value = "年款")
    private String carYear;

    /**
     * 行驶里程
     */
    @ApiModelProperty(value = "行驶里程")
    private Long drivingMileage;

    
    @ApiModelProperty(value = "旧车颜色代码")
	private String color;
	
	@ApiModelProperty(value = "旧车颜色名称")
	private String colorName;
	
	@ApiModelProperty(value = "旧车使用性质代码")
	private String usingNature;
	
	@ApiModelProperty(value = "旧车使用性质名称")
	private String usingNatureName;

    /**
     * 上牌时间
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "上牌时间")
    private Date licensingDate;

    /**
     * 上牌城市
     */
    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;


    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String licensePlateNum;

    /**
     * 过户次数
     */
    @ApiModelProperty(value = "过户次数")
    private String transferTimes;

    /**
     * VIN码
     */
    @ApiModelProperty(value = "VIN码")
    private String vinCode;

    /**
     *报价
     */
    @ApiModelProperty(value = "报价")
    private Long quoteEndPrice;
    
    /**
     *车辆定级 S、A、B、C
     */
    @ApiModelProperty(value = "车辆定级 S、A、B、C")
    private String rank;
    
    @ApiModelProperty(value = "操作类型 1 提交 2 保存")
    private Integer operationType;
    
    @ApiModelProperty(value = "车辆图片材料集合")
    private List<PicDto> picList;
    
    @ApiModelProperty(value = "车辆图片材料集合")
    private List<PicDto> testReportList;

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getUsingNature() {
        return usingNature;
    }

    public void setUsingNature(String usingNature) {
        this.usingNature = usingNature;
    }

    public String getLicensingCity() {
        return licensingCity;
    }

    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }

    public String getLicensePlateNum() {
        return licensePlateNum;
    }

    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum;
    }

    public String getTransferTimes() {
        return transferTimes;
    }

    public void setTransferTimes(String transferTimes) {
        this.transferTimes = transferTimes;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getQuoteEndPrice() {
        return quoteEndPrice;
    }

    public void setQuoteEndPrice(Long quoteEndPrice) {
        this.quoteEndPrice = quoteEndPrice;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBrandChineseDescribe() {
        return brandChineseDescribe;
    }

    public void setBrandChineseDescribe(String brandChineseDescribe) {
        this.brandChineseDescribe = brandChineseDescribe;
    }

    public String getCarTypeChineseDescribe() {
        return carTypeChineseDescribe;
    }

    public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
        this.carTypeChineseDescribe = carTypeChineseDescribe;
    }

    public Date getLicensingDate() {
        return licensingDate;
    }

    public void setLicensingDate(Date licensingDate) {
        this.licensingDate = licensingDate;
    }

    public Long getDrivingMileage() {
        return drivingMileage;
    }

    public void setDrivingMileage(Long drivingMileage) {
        this.drivingMileage = drivingMileage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarSeriesChineseDescribe() {
        return carSeriesChineseDescribe;
    }

    public void setCarSeriesChineseDescribe(String carSeriesChineseDescribe) {
        this.carSeriesChineseDescribe = carSeriesChineseDescribe;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getCarYearChineseDescribe() {
        return carYearChineseDescribe;
    }

    public void setCarYearChineseDescribe(String carYearChineseDescribe) {
        this.carYearChineseDescribe = carYearChineseDescribe;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Integer getOperationType() {
		if(operationType ==null || operationType==0){
			operationType=1;	
		}
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	public List<PicDto> getPicList() {
		return picList;
	}

	public void setPicList(List<PicDto> picList) {
		this.picList = picList;
	}

	public List<PicDto> getTestReportList() {
		return testReportList;
	}

	public void setTestReportList(List<PicDto> testReportList) {
		this.testReportList = testReportList;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public String getUsingNatureName() {
		return usingNatureName;
	}

	public void setUsingNatureName(String usingNatureName) {
		this.usingNatureName = usingNatureName;
	}

	
}
