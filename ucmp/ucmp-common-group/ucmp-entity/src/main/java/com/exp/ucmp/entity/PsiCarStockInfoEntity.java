package com.exp.ucmp.entity;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "PsiCarStockInfoEntity", description = "库存车辆信息表")
@GroupSequence({PsiCarStockInfoEntity.class, PsiCarStockInfoEntity.PsiCarStockInfoEntityValidGroup.class,PsiCarStockInfoEntity.StockIdValidGroup.class,PsiCarStockInfoEntity.StorageIdValidGroup.class,PsiCarStockInfoEntity.StorageNameValidGroup.class,PsiCarStockInfoEntity.StorageCodeValidGroup.class,PsiCarStockInfoEntity.CarSourceValidGroup.class,PsiCarStockInfoEntity.CarTypeValidGroup.class,PsiCarStockInfoEntity.StockTypeValidGroup.class,PsiCarStockInfoEntity.SourceBatchValidGroup.class,PsiCarStockInfoEntity.RevertBodyValidGroup.class,PsiCarStockInfoEntity.VinCodeValidGroup.class,PsiCarStockInfoEntity.PurchasePriceValidGroup.class,PsiCarStockInfoEntity.SalePriceValidGroup.class,PsiCarStockInfoEntity.DecisionTypeValidGroup.class,PsiCarStockInfoEntity.WarehousDateValidGroup.class,PsiCarStockInfoEntity.RefundSignValidGroup.class,PsiCarStockInfoEntity.CarSeriesNameValidGroup.class,PsiCarStockInfoEntity.BaseCarTypeCodeValidGroup.class,PsiCarStockInfoEntity.CarSeriesCodeValidGroup.class,PsiCarStockInfoEntity.BaseCarTypeNameValidGroup.class,PsiCarStockInfoEntity.InteriorColorValidGroup.class,PsiCarStockInfoEntity.CarColourValidGroup.class,PsiCarStockInfoEntity.CarNatureValidGroup.class,PsiCarStockInfoEntity.LicensePlaceValidGroup.class,PsiCarStockInfoEntity.LicenseNumberValidGroup.class,PsiCarStockInfoEntity.StockStateValidGroup.class,PsiCarStockInfoEntity.RepealIsValidGroup.class,PsiCarStockInfoEntity.RepealReasonValidGroup.class,PsiCarStockInfoEntity.RightPackIdValidGroup.class,PsiCarStockInfoEntity.StockMileageValidGroup.class,PsiCarStockInfoEntity.BatteryCapacityValidGroup.class,PsiCarStockInfoEntity.ItemNoValidGroup.class,PsiCarStockInfoEntity.CreatedByValidGroup.class,PsiCarStockInfoEntity.CreatedDateValidGroup.class,PsiCarStockInfoEntity.UpdatedByValidGroup.class,PsiCarStockInfoEntity.UpdatedDateValidGroup.class,PsiCarStockInfoEntity.IsEnableValidGroup.class,PsiCarStockInfoEntity.IsDeleteValidGroup.class,PsiCarStockInfoEntity.ManufactureDateValidGroup.class,PsiCarStockInfoEntity.ComprehensiveRangeValidGroup.class,PsiCarStockInfoEntity.ActiveTimeValidGroup.class,PsiCarStockInfoEntity.CurActiveStatusValidGroup.class,PsiCarStockInfoEntity.NewCarPriceValidGroup.class,PsiCarStockInfoEntity.CarLevelValidGroup.class}) 
public class PsiCarStockInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 库存车辆id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "库存车辆id 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, StockIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="库存车辆id 数字精度必须符合(19,0)", groups = {PsiCarStockInfoEntityValidGroup.class, StockIdValidGroup.class})
    @ApiModelProperty(value = "库存车辆id")
    private Long stockId;
    
    
    /**
     * 仓储点id
     */
    @NotNull(message = "仓储点id 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, StorageIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="仓储点id 数字精度必须符合(19,0)", groups = {PsiCarStockInfoEntityValidGroup.class, StorageIdValidGroup.class})
    @ApiModelProperty(value = "仓储点id")
    private Long storageId;
    
    /**
     * 仓储点名称
     */
    @NotNull(message = "仓储点名称 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, StorageNameValidGroup.class})
    @Size(min=0, max=20, message="仓储点名称 字符长度必须小于等于20", groups = {PsiCarStockInfoEntityValidGroup.class, StorageNameValidGroup.class})
    @ApiModelProperty(value = "仓储点名称")
    private String storageName;
    
    /**
     * 仓库编码
     */
    @NotNull(message = "仓库编码 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, StorageCodeValidGroup.class})
    @Size(min=0, max=20, message="仓库编码 字符长度必须小于等于20", groups = {PsiCarStockInfoEntityValidGroup.class, StorageCodeValidGroup.class})
    @ApiModelProperty(value = "仓库编码")
    private String storageCode;
    
    /**
     * 车辆来源
     */
    @NotNull(message = "车辆来源 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, CarSourceValidGroup.class})
    @Size(min=0, max=20, message="车辆来源 字符长度必须小于等于20", groups = {PsiCarStockInfoEntityValidGroup.class, CarSourceValidGroup.class})
    @ApiModelProperty(value = "车辆来源")
    private String carSource;
    
    /**
     * 车辆类型
     */
    @NotNull(message = "车辆类型 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, CarTypeValidGroup.class})
    @Size(min=0, max=20, message="车辆类型 字符长度必须小于等于20", groups = {PsiCarStockInfoEntityValidGroup.class, CarTypeValidGroup.class})
    @ApiModelProperty(value = "车辆类型")
    private String carType;
    
    /**
     * 库存类型
     */
    @NotNull(message = "库存类型 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, StockTypeValidGroup.class})
    @Size(min=0, max=20, message="库存类型 字符长度必须小于等于20", groups = {PsiCarStockInfoEntityValidGroup.class, StockTypeValidGroup.class})
    @ApiModelProperty(value = "库存类型")
    private String stockType;
    
    /**
     * 车源批次
     */
    @Size(min=0, max=20, message="车源批次 字符长度必须小于等于20", groups = {PsiCarStockInfoEntityValidGroup.class, SourceBatchValidGroup.class})
    @ApiModelProperty(value = "车源批次")
    private String sourceBatch;
    
    /**
     * 归属主体
     */
    @Size(min=0, max=100, message="归属主体 字符长度必须小于等于100", groups = {PsiCarStockInfoEntityValidGroup.class, RevertBodyValidGroup.class})
    @ApiModelProperty(value = "归属主体")
    private String revertBody;
    
    /**
     * VIN码
     */
    @Size(min=0, max=20, message="VIN码 字符长度必须小于等于20", groups = {PsiCarStockInfoEntityValidGroup.class, VinCodeValidGroup.class})
    @ApiModelProperty(value = "VIN码")
    private String vinCode;
    
    /**
     * 采购价格
     */
    @Digits(integer=9, fraction=2, message="采购价格 数字精度必须符合(9,2)", groups = {PsiCarStockInfoEntityValidGroup.class, PurchasePriceValidGroup.class})
    @ApiModelProperty(value = "采购价格")
    private BigDecimal purchasePrice;
    
    /**
     * 销售定价
     */
    @Digits(integer=9, fraction=2, message="销售定价 数字精度必须符合(9,2)", groups = {PsiCarStockInfoEntityValidGroup.class, SalePriceValidGroup.class})
    @ApiModelProperty(value = "销售定价")
    private BigDecimal salePrice;
    
    /**
     * 决策类型
     */
    @Size(min=0, max=10, message="决策类型 字符长度必须小于等于10", groups = {PsiCarStockInfoEntityValidGroup.class, DecisionTypeValidGroup.class})
    @ApiModelProperty(value = "决策类型")
    private String decisionType;
    
    /**
     * 决策时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "决策时间")
    private Date decisionTime;
    
    /**
     * 上架时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上架时间")
    private Date groundingTime;
    
    /**
     * 入库时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "入库时间 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, WarehousDateValidGroup.class})
    @ApiModelProperty(value = "入库时间")
    private Date warehousDate;
    
    /**
     * 退款标记(00、否，01、是 )
     */
    @Size(min=0, max=10, message="退款标记(00、否，01、是 ) 字符长度必须小于等于10", groups = {PsiCarStockInfoEntityValidGroup.class, RefundSignValidGroup.class})
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
    @Size(min=0, max=80, message="工程车型名称 字符长度必须小于等于80", groups = {PsiCarStockInfoEntityValidGroup.class, CarSeriesNameValidGroup.class})
    @ApiModelProperty(value = "工程车型名称")
    private String carSeriesName;
    
    /**
     * 基础车型编码
     */
    @Size(min=0, max=30, message="基础车型编码 字符长度必须小于等于30", groups = {PsiCarStockInfoEntityValidGroup.class, BaseCarTypeCodeValidGroup.class})
    @ApiModelProperty(value = "基础车型编码")
    private String baseCarTypeCode;
    
    /**
     * 工程车型编码
     */
    @Size(min=0, max=30, message="工程车型编码 字符长度必须小于等于30", groups = {PsiCarStockInfoEntityValidGroup.class, CarSeriesCodeValidGroup.class})
    @ApiModelProperty(value = "工程车型编码")
    private String carSeriesCode;
    
    /**
     * 基础车型名称
     */
    @Size(min=0, max=80, message="基础车型名称 字符长度必须小于等于80", groups = {PsiCarStockInfoEntityValidGroup.class, BaseCarTypeNameValidGroup.class})
    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;
    
    /**
     * 内饰
     */
    @Size(min=0, max=50, message="内饰 字符长度必须小于等于50", groups = {PsiCarStockInfoEntityValidGroup.class, InteriorColorValidGroup.class})
    @ApiModelProperty(value = "内饰")
    private String interiorColor;
    
    /**
     * 外色
     */
    @Size(min=0, max=50, message="外色 字符长度必须小于等于50", groups = {PsiCarStockInfoEntityValidGroup.class, CarColourValidGroup.class})
    @ApiModelProperty(value = "外色")
    private String carColour;
    
    /**
     * 车辆使用性质
     */
    @Size(min=0, max=50, message="车辆使用性质 字符长度必须小于等于50", groups = {PsiCarStockInfoEntityValidGroup.class, CarNatureValidGroup.class})
    @ApiModelProperty(value = "车辆使用性质")
    private String carNature;
    
    /**
     * 牌照属地
     */
    @Size(min=0, max=80, message="牌照属地 字符长度必须小于等于80", groups = {PsiCarStockInfoEntityValidGroup.class, LicensePlaceValidGroup.class})
    @ApiModelProperty(value = "牌照属地")
    private String licensePlace;
    
    /**
     * 牌照号
     */
    @Size(min=0, max=50, message="牌照号 字符长度必须小于等于50", groups = {PsiCarStockInfoEntityValidGroup.class, LicenseNumberValidGroup.class})
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
    
    /**
     * 过户次数
     */
    @ApiModelProperty(value = "过户次数")
    private Integer transferCount;
    
    /**
     * 状态(5101:在库待售/5102:整备中/5103:待上架/5104:在售中/5105:已预订/5106:已售出/5107:退款待上架/)
     */
    @Size(min=0, max=20, message="状态(5101:在库待售/5102:整备中/5103:待上架/5104:在售中/5105:已预订/5106:已售出/5107:退款待上架/) 字符长度必须小于等于20", groups = {PsiCarStockInfoEntityValidGroup.class, StockStateValidGroup.class})
    @ApiModelProperty(value = "状态(5101:在库待售/5102:整备中/5103:待上架/5104:在售中/5105:已预订/5106:已售出/5107:退款待上架/)")
    private String stockState;
    
    /**
     * 是否作废(00、否，01、是 )
     */
    @Size(min=0, max=20, message="是否作废(00、否，01、是 ) 字符长度必须小于等于20", groups = {PsiCarStockInfoEntityValidGroup.class, RepealIsValidGroup.class})
    @ApiModelProperty(value = "是否作废(00、否，01、是 )")
    private String repealIs;
    
    /**
     * 作废日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "作废日期")
    private Date repealDate;
    
    /**
     * 作废理由
     */
    @Size(min=0, max=150, message="作废理由 字符长度必须小于等于150", groups = {PsiCarStockInfoEntityValidGroup.class, RepealReasonValidGroup.class})
    @ApiModelProperty(value = "作废理由")
    private String repealReason;
    
    /**
     * 权益活动编号
     */
    @Digits(integer=19, fraction=0, message="权益活动编号 数字精度必须符合(19,0)", groups = {PsiCarStockInfoEntityValidGroup.class, RightPackIdValidGroup.class})
    @ApiModelProperty(value = "权益活动编号")
    private Long rightPackId;
    
    /**
     * 行驶里程
     */
    @Digits(integer=19, fraction=0, message="行驶里程 数字精度必须符合(19,0)", groups = {PsiCarStockInfoEntityValidGroup.class, StockMileageValidGroup.class})
    @ApiModelProperty(value = "行驶里程")
    private Long stockMileage;
    
    /**
     * 电池容量
     */
    @Digits(integer=19, fraction=0, message="电池容量 数字精度必须符合(19,0)", groups = {PsiCarStockInfoEntityValidGroup.class, BatteryCapacityValidGroup.class})
    @ApiModelProperty(value = "电池容量")
    private Double batteryCapacity;
    
    /**
     * 商品编号
     */
    @Size(min=0, max=50, message="商品编号 字符长度必须小于等于50", groups = {PsiCarStockInfoEntityValidGroup.class, ItemNoValidGroup.class})
    @ApiModelProperty(value = "商品编号")
    private String itemNo;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarStockInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarStockInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiCarStockInfoEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {PsiCarStockInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiCarStockInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    /**
     * 出厂日期
     */
    @Size(min=0, max=20, message="出厂日期 字符长度必须小于等于20", groups = {PsiCarStockInfoEntityValidGroup.class, ManufactureDateValidGroup.class})
    @ApiModelProperty(value = "出厂日期")
    private String manufactureDate;
    
    /**
     * 综合续航里程
     */
    @Size(min=0, max=20, message="综合续航里程 字符长度必须小于等于20", groups = {PsiCarStockInfoEntityValidGroup.class, ComprehensiveRangeValidGroup.class})
    @ApiModelProperty(value = "综合续航里程")
    private String comprehensiveRange;
    
    /**
     * 首次激活日期
     */
    @Size(min=0, max=20, message="首次激活日期 字符长度必须小于等于20", groups = {PsiCarStockInfoEntityValidGroup.class, ActiveTimeValidGroup.class})
    @ApiModelProperty(value = "首次激活日期")
    private String activeTime;
    
    /**
     * 当前激活状态 1已激活 0 未激活
     */
    @Digits(integer=10, fraction=0, message="当前激活状态 1已激活 0 未激活 数字精度必须符合(10,0)", groups = {PsiCarStockInfoEntityValidGroup.class, CurActiveStatusValidGroup.class})
    @ApiModelProperty(value = "当前激活状态 1已激活 0 未激活")
    private Integer curActiveStatus;
    
    /**
     * 新车指导价
     */
    @Digits(integer=10, fraction=0, message="新车指导价 数字精度必须符合(10,0)", groups = {PsiCarStockInfoEntityValidGroup.class, NewCarPriceValidGroup.class})
    @ApiModelProperty(value = "新车指导价")
    private Long newCarPrice;
    
    /**
     * 车辆级别（1.S级 2.A级 3.B级 4.C级）
     */
    @Size(min=0, max=2, message="车辆级别（1.S级 2.A级 3.B级 4.C级） 字符长度必须小于等于2", groups = {PsiCarStockInfoEntityValidGroup.class, CarLevelValidGroup.class})
    @ApiModelProperty(value = "车辆级别（1.S级 2.A级 3.B级 4.C级）")
    private String carLevel;
    
    /**
     * 整备时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "整备时间")
    private Date serviceTime;
    
    @ApiModelProperty(value = "模型建议价")
    private Double suggestedPrice;
    
    @ApiModelProperty("公司代码")
    private String companyCode;
    
    public PsiCarStockInfoEntity() {
    }
    
    public PsiCarStockInfoEntity(Long stockId) {
        this.stockId = stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
    public Long getStockId() {
        return this.stockId;
    }
    

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }
    public Long getStorageId() {
        return this.storageId;
    }
    
    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }
    public String getStorageName() {
        return this.storageName;
    }
    
    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }
    public String getStorageCode() {
        return this.storageCode;
    }
    
    public void setCarSource(String carSource) {
        this.carSource = carSource;
    }
    public String getCarSource() {
        return this.carSource;
    }
    
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public String getCarType() {
        return this.carType;
    }
    
    public void setStockType(String stockType) {
        this.stockType = stockType;
    }
    public String getStockType() {
        return this.stockType;
    }
    
    public void setSourceBatch(String sourceBatch) {
        this.sourceBatch = sourceBatch;
    }
    public String getSourceBatch() {
        return this.sourceBatch;
    }
    
    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }
    public String getRevertBody() {
        return this.revertBody;
    }
    
    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }
    public String getVinCode() {
        return this.vinCode;
    }
    
    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public BigDecimal getPurchasePrice() {
        return this.purchasePrice;
    }
    
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
    public BigDecimal getSalePrice() {
        return this.salePrice;
    }
    
    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }
    public String getDecisionType() {
        return this.decisionType;
    }
    
    public void setDecisionTime(Date decisionTime) {
        this.decisionTime = decisionTime;
    }
    public Date getDecisionTime() {
        return this.decisionTime;
    }
    
    public void setGroundingTime(Date groundingTime) {
        this.groundingTime = groundingTime;
    }
    public Date getGroundingTime() {
        return this.groundingTime;
    }
    
    public void setWarehousDate(Date warehousDate) {
        this.warehousDate = warehousDate;
    }
    public Date getWarehousDate() {
        return this.warehousDate;
    }
    
    public void setRefundSign(String refundSign) {
        this.refundSign = refundSign;
    }
    public String getRefundSign() {
        return this.refundSign;
    }
    
    public void setRefundWarehousDate(Date refundWarehousDate) {
        this.refundWarehousDate = refundWarehousDate;
    }
    public Date getRefundWarehousDate() {
        return this.refundWarehousDate;
    }
    
    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }
    public Date getDeliverDate() {
        return this.deliverDate;
    }
    
    public void setCarSeriesName(String carSeriesName) {
        this.carSeriesName = carSeriesName;
    }
    public String getCarSeriesName() {
        return this.carSeriesName;
    }
    
    public void setBaseCarTypeCode(String baseCarTypeCode) {
        this.baseCarTypeCode = baseCarTypeCode;
    }
    public String getBaseCarTypeCode() {
        return this.baseCarTypeCode;
    }
    
    public void setCarSeriesCode(String carSeriesCode) {
        this.carSeriesCode = carSeriesCode;
    }
    public String getCarSeriesCode() {
        return this.carSeriesCode;
    }
    
    public void setBaseCarTypeName(String baseCarTypeName) {
        this.baseCarTypeName = baseCarTypeName;
    }
    public String getBaseCarTypeName() {
        return this.baseCarTypeName;
    }
    
    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }
    public String getInteriorColor() {
        return this.interiorColor;
    }
    
    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }
    public String getCarColour() {
        return this.carColour;
    }
    
    public void setCarNature(String carNature) {
        this.carNature = carNature;
    }
    public String getCarNature() {
        return this.carNature;
    }
    
    public void setLicensePlace(String licensePlace) {
        this.licensePlace = licensePlace;
    }
    public String getLicensePlace() {
        return this.licensePlace;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
    public String getLicenseNumber() {
        return this.licenseNumber;
    }
    
    public void setFirstLicenseDate(Date firstLicenseDate) {
        this.firstLicenseDate = firstLicenseDate;
    }
    public Date getFirstLicenseDate() {
        return this.firstLicenseDate;
    }
    
    public void setAccidentInsuranceEndDate(Date accidentInsuranceEndDate) {
        this.accidentInsuranceEndDate = accidentInsuranceEndDate;
    }
    public Date getAccidentInsuranceEndDate() {
        return this.accidentInsuranceEndDate;
    }
    
    public void setYearlyInspectionEndDate(Date yearlyInspectionEndDate) {
        this.yearlyInspectionEndDate = yearlyInspectionEndDate;
    }
    public Date getYearlyInspectionEndDate() {
        return this.yearlyInspectionEndDate;
    }
    
    public void setInvoicingDate(Date invoicingDate) {
        this.invoicingDate = invoicingDate;
    }
    public Date getInvoicingDate() {
        return this.invoicingDate;
    }
    
    public void setTransferCount(Integer transferCount) {
        this.transferCount = transferCount;
    }
    public Integer getTransferCount() {
        return this.transferCount;
    }
    
    public void setStockState(String stockState) {
        this.stockState = stockState;
    }
    public String getStockState() {
        return this.stockState;
    }
    
    public void setRepealIs(String repealIs) {
        this.repealIs = repealIs;
    }
    public String getRepealIs() {
        return this.repealIs;
    }
    
    public void setRepealDate(Date repealDate) {
        this.repealDate = repealDate;
    }
    public Date getRepealDate() {
        return this.repealDate;
    }
    
    public void setRepealReason(String repealReason) {
        this.repealReason = repealReason;
    }
    public String getRepealReason() {
        return this.repealReason;
    }
    
    public void setRightPackId(Long rightPackId) {
        this.rightPackId = rightPackId;
    }
    public Long getRightPackId() {
        return this.rightPackId;
    }
    
    public void setStockMileage(Long stockMileage) {
        this.stockMileage = stockMileage;
    }
    public Long getStockMileage() {
        return this.stockMileage;
    }
    
    public void setBatteryCapacity(Double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
    public Double getBatteryCapacity() {
        return this.batteryCapacity;
    }
    
    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }
    public String getItemNo() {
        return this.itemNo;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Long getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Long getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public String getIsEnable() {
        return this.isEnable;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }
    
    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
    public String getManufactureDate() {
        return this.manufactureDate;
    }
    
    public void setComprehensiveRange(String comprehensiveRange) {
        this.comprehensiveRange = comprehensiveRange;
    }
    public String getComprehensiveRange() {
        return this.comprehensiveRange;
    }
    
    public void setActiveTime(String activeTime) {
        this.activeTime = activeTime;
    }
    public String getActiveTime() {
        return this.activeTime;
    }
    
    public void setCurActiveStatus(Integer curActiveStatus) {
        this.curActiveStatus = curActiveStatus;
    }
    public Integer getCurActiveStatus() {
        return this.curActiveStatus;
    }
    
    public void setNewCarPrice(Long newCarPrice) {
        this.newCarPrice = newCarPrice;
    }
    public Long getNewCarPrice() {
        return this.newCarPrice;
    }
    
    public void setCarLevel(String carLevel) {
        this.carLevel = carLevel;
    }
    public String getCarLevel() {
        return this.carLevel;
    }
    
    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }
    public Date getServiceTime() {
        return this.serviceTime;
    }
    
    public Double getSuggestedPrice() {
		return suggestedPrice;
	}

	public void setSuggestedPrice(Double suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (stockId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                stockId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarStockInfoEntityValidGroup {}
    public interface StockIdValidGroup {}
    public interface StorageIdValidGroup {}
    public interface StorageNameValidGroup {}
    public interface StorageCodeValidGroup {}
    public interface CarSourceValidGroup {}
    public interface CarTypeValidGroup {}
    public interface StockTypeValidGroup {}
    public interface SourceBatchValidGroup {}
    public interface RevertBodyValidGroup {}
    public interface VinCodeValidGroup {}
    public interface PurchasePriceValidGroup {}
    public interface SalePriceValidGroup {}
    public interface DecisionTypeValidGroup {}
    public interface WarehousDateValidGroup {}
    public interface RefundSignValidGroup {}
    public interface CarSeriesNameValidGroup {}
    public interface BaseCarTypeCodeValidGroup {}
    public interface CarSeriesCodeValidGroup {}
    public interface BaseCarTypeNameValidGroup {}
    public interface InteriorColorValidGroup {}
    public interface CarColourValidGroup {}
    public interface CarNatureValidGroup {}
    public interface LicensePlaceValidGroup {}
    public interface LicenseNumberValidGroup {}
    public interface StockStateValidGroup {}
    public interface RepealIsValidGroup {}
    public interface RepealReasonValidGroup {}
    public interface RightPackIdValidGroup {}
    public interface StockMileageValidGroup {}
    public interface BatteryCapacityValidGroup {}
    public interface ItemNoValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface ManufactureDateValidGroup {}
    public interface ComprehensiveRangeValidGroup {}
    public interface ActiveTimeValidGroup {}
    public interface CurActiveStatusValidGroup {}
    public interface NewCarPriceValidGroup {}
    public interface CarLevelValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            StockIdValidGroup.class
            , StorageIdValidGroup.class
            , StorageNameValidGroup.class
            , StorageCodeValidGroup.class
            , CarSourceValidGroup.class
            , CarTypeValidGroup.class
            , StockTypeValidGroup.class
            , SourceBatchValidGroup.class
            , RevertBodyValidGroup.class
            , VinCodeValidGroup.class
            , PurchasePriceValidGroup.class
            , SalePriceValidGroup.class
            , DecisionTypeValidGroup.class
            , WarehousDateValidGroup.class
            , RefundSignValidGroup.class
            , CarSeriesNameValidGroup.class
            , BaseCarTypeCodeValidGroup.class
            , CarSeriesCodeValidGroup.class
            , BaseCarTypeNameValidGroup.class
            , InteriorColorValidGroup.class
            , CarColourValidGroup.class
            , CarNatureValidGroup.class
            , LicensePlaceValidGroup.class
            , LicenseNumberValidGroup.class
            , StockStateValidGroup.class
            , RepealIsValidGroup.class
            , RepealReasonValidGroup.class
            , RightPackIdValidGroup.class
            , StockMileageValidGroup.class
            , BatteryCapacityValidGroup.class
            , ItemNoValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
            , ManufactureDateValidGroup.class
            , ComprehensiveRangeValidGroup.class
            , ActiveTimeValidGroup.class
            , CurActiveStatusValidGroup.class
            , NewCarPriceValidGroup.class
            , CarLevelValidGroup.class
        };
    }
}
