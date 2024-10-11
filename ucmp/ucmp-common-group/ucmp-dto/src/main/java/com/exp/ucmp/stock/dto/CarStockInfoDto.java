package com.exp.ucmp.stock.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "CarStockInfoDto", description = "库存车辆Dto")
public class CarStockInfoDto {

    private static final long serialVersionUID = 1L;

    /**
     * 库存车辆id
     */
    @ApiModelProperty(value = "库存车辆id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stockId;

    @ApiModelProperty(value = "商品代码")
	private String productCode;

    /**
     * 仓储点id
     */
    @ApiModelProperty(value = "仓储点id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long storageId;

    /**
     * 仓储点名称
     */
    @ApiModelProperty(value = "仓储点名称")
    private String storageName;

    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库编码")
    private String storageCode;

    /**
     * 车辆来源
     */
    @ApiModelProperty(value = "车辆来源")
    private String carSource;
    
    /**
     * 车辆来源
     */
    @ApiModelProperty(value = "车辆来源名称")
    private String carSourceName;

    /**
     * 车辆类型
     */
    @ApiModelProperty(value = "车辆类型")
    private String carType;
    
    /**
     * 车辆类型
     */
    @ApiModelProperty(value = "车辆类型名称")
    private String carTypeName;

    /**
     * 库存类型
     */
    @ApiModelProperty(value = "库存类型")
    private String stockType;
    
    @ApiModelProperty(value = "库存类型名称")
    private String stockTypeName;

    /**
     * 车源批次
     */
    @ApiModelProperty(value = "车源批次")
    private String sourceBatch;

    /**
     * 归属主体
     */
    @ApiModelProperty(value = "归属主体")
    private String revertBody;
    
    @ApiModelProperty(value = "归属主体名称")
    private String revertBodyName;

    /**
     * VIN码
     */
    @ApiModelProperty(value = "VIN码")
    private String vinCode;

    /**
     * 采购价格
     */
    @ApiModelProperty(value = "采购价格")
    private BigDecimal purchasePrice;

    /**
     * 销售定价
     */
    @ApiModelProperty(value = "销售定价")
    private BigDecimal salePrice;

    /**
     * 决策类型
     */
    @ApiModelProperty(value = "决策类型")
    private String decisionType;
    
    @ApiModelProperty(value = "决策类型名称")
    private String decisionTypeName;

    /**
     * 入库时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "入库时间")
    private Date warehousDate;

    /**
     * 退款标记(00、否，01、是 )
     */
    @ApiModelProperty(value = "退款标记(00、否，01、是 )")
    private String refundSign;

    /**
     * 退款入库时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "退款入库时间")
    private Date refundWarehousDate;

    /**
     * 交付出库时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "交付出库时间")
    private Date deliverDate;

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
     * 车辆使用性质
     */
    @ApiModelProperty(value = "车辆使用性质")
    private String carNature;
    
    @ApiModelProperty(value = "车辆使用性质名称")
    private String carNatureName;

    /**
     * 牌照属地
     */
    @ApiModelProperty(value = "牌照属地")
    private String licensePlace;

    /**
     * 牌照号
     */
    @ApiModelProperty(value = "牌照号")
    private String licenseNumber;

    /**
     * 首次上牌时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "首次上牌时间")
    private Date firstLicenseDate;

    /**
     * 交强险到期日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "交强险到期日")
    private Date accidentInsuranceEndDate;

    /**
     * 年检到期日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "年检到期日")
    private Date yearlyInspectionEndDate;

    /**
     * 新车开票日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "新车开票日")
    private Date invoicingDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "入库时间")
    private Date inTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "出库时间")
    private Date outTime;

    
    /**
     * 过户次数
     */
    @ApiModelProperty(value = "过户次数")
    private Integer transferCount;

    /**
     * 状态(001:在库待售/002:整备中/003:待上架/004:在售中/005:已预订/006:已售出/007:退款待上架/)
     */
    @ApiModelProperty(value = "状态(001:在库待售/002:整备中/003:待上架/004:在售中/005:已预订/006:已售出/007:退款待上架/)")
    private String stockState;
    
    @ApiModelProperty(value = "状态名称")
    private String stockStateName;

    /**
     * 作废日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "作废日期")
    private Date repealDate;

    /**
     * 作废理由
     */
    @ApiModelProperty(value = "作废理由")
    private String repealReason;

    /**
     * 是否作废(00、否，01、是 )
     */
    @ApiModelProperty(value = "是否作废(00、否，01、是 )")
    private String repealIs;

    /**
     * 行驶里程
     */
    @ApiModelProperty(value = "行驶里程")
    private Integer stockMileage;

    /**
     * 电池容量
     */
    @ApiModelProperty(value = "电池容量")
    private Integer batteryCapacity;

    /**
     * 车辆级别（1.S级 2.A级 3.B级 4.C级）
     */
    @ApiModelProperty(value = "车辆级别（1.S级 2.A级 3.B级 4.C级）")
    private String carLevel;
    
    /**
     * 车龄
     */
    @ApiModelProperty(value = "车龄(天)")
    private Integer carAge;

    /**
     * 库龄
     */
    @ApiModelProperty(value = "库龄(天)")
    private Integer stockAge;
    /**
     * 出厂日期
     */
    @ApiModelProperty(value = "出厂日期")
    private String manufactureDate;

    public CarStockInfoDto() {
    }
    
    public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public String getCarLevel() {
        return carLevel;
    }

    public void setCarLevel(String carLevel) {
        this.carLevel = carLevel;
    }

    public Integer getCarAge() {
        return carAge;
    }

    public void setCarAge(Integer carAge) {
        this.carAge = carAge;
    }

    public Integer getStockAge() {
        return stockAge;
    }

    public void setStockAge(Integer stockAge) {
        this.stockAge = stockAge;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getCarSource() {
        return carSource;
    }

    public void setCarSource(String carSource) {
        this.carSource = carSource;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getSourceBatch() {
        return sourceBatch;
    }

    public void setSourceBatch(String sourceBatch) {
        this.sourceBatch = sourceBatch;
    }

    public String getRevertBody() {
        return revertBody;
    }

    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }

    public Date getWarehousDate() {
        return warehousDate;
    }

    public void setWarehousDate(Date warehousDate) {
        this.warehousDate = warehousDate;
    }

    public String getRefundSign() {
        return refundSign;
    }

    public void setRefundSign(String refundSign) {
        this.refundSign = refundSign;
    }

    public Date getRefundWarehousDate() {
        return refundWarehousDate;
    }

    public void setRefundWarehousDate(Date refundWarehousDate) {
        this.refundWarehousDate = refundWarehousDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
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

    public String getCarNature() {
        return carNature;
    }

    public void setCarNature(String carNature) {
        this.carNature = carNature;
    }

    public String getLicensePlace() {
        return licensePlace;
    }

    public void setLicensePlace(String licensePlace) {
        this.licensePlace = licensePlace;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getFirstLicenseDate() {
        return firstLicenseDate;
    }

    public void setFirstLicenseDate(Date firstLicenseDate) {
        this.firstLicenseDate = firstLicenseDate;
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

    public Date getInvoicingDate() {
        return invoicingDate;
    }

    public void setInvoicingDate(Date invoicingDate) {
        this.invoicingDate = invoicingDate;
    }

    public Integer getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(Integer transferCount) {
        this.transferCount = transferCount;
    }

    public String getStockState() {
        return stockState;
    }

    public void setStockState(String stockState) {
        this.stockState = stockState;
    }

    public String getRepealIs() {
        return repealIs;
    }

    public Date getRepealDate() {
        return repealDate;
    }

    public void setRepealDate(Date repealDate) {
        this.repealDate = repealDate;
    }

    public String getRepealReason() {
        return repealReason;
    }

    public void setRepealReason(String repealReason) {
        this.repealReason = repealReason;
    }

    public void setRepealIs(String repealIs) {
        this.repealIs = repealIs;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public Integer getStockMileage() {
        return stockMileage;
    }

    public void setStockMileage(Integer stockMileage) {
        this.stockMileage = stockMileage;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

	public String getCarSourceName() {
		return carSourceName;
	}

	public void setCarSourceName(String carSourceName) {
		this.carSourceName = carSourceName;
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public String getStockTypeName() {
		return stockTypeName;
	}

	public void setStockTypeName(String stockTypeName) {
		this.stockTypeName = stockTypeName;
	}

	public String getRevertBodyName() {
		return revertBodyName;
	}

	public void setRevertBodyName(String revertBodyName) {
		this.revertBodyName = revertBodyName;
	}

	public String getDecisionTypeName() {
		return decisionTypeName;
	}

	public void setDecisionTypeName(String decisionTypeName) {
		this.decisionTypeName = decisionTypeName;
	}

	public String getCarNatureName() {
		return carNatureName;
	}

	public void setCarNatureName(String carNatureName) {
		this.carNatureName = carNatureName;
	}

	public String getStockStateName() {
		return stockStateName;
	}

	public void setStockStateName(String stockStateName) {
		this.stockStateName = stockStateName;
	}
}
