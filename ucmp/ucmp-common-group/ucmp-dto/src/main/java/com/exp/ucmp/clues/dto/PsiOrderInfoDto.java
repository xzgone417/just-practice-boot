package com.exp.ucmp.clues.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * <p>@ClassName: PsiOrderInfoDto</p>
 * <p>@Description: 订单详情</p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/28 9:53<p>
 */
public class PsiOrderInfoDto extends BaseModel {
    /**
     * 订单信息id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "订单信息id")
    private Long orderInfoId;

    /**
     * 销售客户id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "销售客户id")
    private Long customerId;

    /**
     * 线索id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "线索id")
    private Long cluesId;

    /**
     * 订单编号
     */
    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    @ApiModelProperty(value = "库存车辆id")
    private String stockId;


    @ApiModelProperty(value = "车辆类型")
    private String carType;

    /**
     * vin码
     */
    @ApiModelProperty(value = "vin码")
    private String carVin;

    /**
     * 上牌城市
     */
    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;

    /**
     * 订单价格
     */
    @ApiModelProperty(value = "订单价格")
    private BigDecimal orderPrice;

    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态")
    private String orderStatus;

    /**
     * 大定支付时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "大定支付时间")
    private Date setPaymentTime;

    /**
     * 大定支付时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "小定支付时间")
    private Date intentionPayTime;

    /**
     * 外饰色
     */
    @ApiModelProperty(value = "外饰色")
    private String exteriorColor;

    /**
     * 内饰色
     */
    @ApiModelProperty(value = "内饰色")
    private String interiorColor;

    /**
     * 车辆价格
     */
    @ApiModelProperty(value = "车辆价格")
    private BigDecimal carPrice;

    /**
     * 交付门店
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "交付门店")
    private Long deliveryStore;

    @ApiModelProperty(value = "交付门店名称")
    private String deliveryStoreName;

    /**
     * 销售门店
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "销售门店")
    private Long salesStore;

    @ApiModelProperty(value = "销售门店名称")
    private String salesStoreName;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    /**
     * 客户手机号
     */
    @ApiModelProperty(value = "客户手机号")
    private String customerPhone;

    @ApiModelProperty("加密客户手机号")
    private String encryptionCustomerPhone;

    /**
     * 车主身份证
     */
    @ApiModelProperty(value = "车主身份证")
    private String ownerCardNo;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "交付顾问")
    private Long deliveryPerson;

    @ApiModelProperty(value = "交付顾问名称")
    private String deliveryPersonName;

    /**
     * 跟进人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "跟进人（出行顾问）")
    private Long followPerson;

    @ApiModelProperty(value = "出行顾问名称")
    private String followPersonName;

    /**
     * 车辆所有人类型01个人02企业
     */
    @ApiModelProperty(value = "车辆所有人类型01个人02企业")
    private String carOwnerType;

    /**
     * 证件类型字典type81
     */
    @ApiModelProperty(value = "证件类型字典type81")
    private String typeId;

    /**
     * 应收总金额
     */
    @ApiModelProperty(value = "应收总金额")
    private BigDecimal receivablePrice;

    /**
     * 已收总金额
     */
    @ApiModelProperty(value = "已收总金额")
    private BigDecimal receivedPrice;

    /**
     * 未收总金额
     */
    @ApiModelProperty(value = "未收总金额")
    private BigDecimal notReceivedPrice;

    /**
     * 尾款支付时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "尾款支付时间")
    private Date balancePaymentTime;

    /**
     * 基础车型名称
     */
    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;


    /**
     * 主用车人姓名
     */
    @ApiModelProperty(value = "主用车人姓名")
    private String mainUserName;

    /**
     * 主用车人电话
     */
    @ApiModelProperty(value = "主用车人电话")
    private String mainUserPhone;

    /**
     * 主用车人证件号
     */
    @ApiModelProperty(value = "主用车人证件号")
    private String mainCardNo;

    /**
     * 创建人ID
     */
    @ApiModelProperty(value = "创建人ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createdBy;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;

    /**
     * 更新人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;

    /**
     * 是否可用00、无效，01、有效
     */
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;

    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;

    @ApiModelProperty(value = "订单备注")
    private String orderRemark;

    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;

    @ApiModelProperty("发放权益(01.权益发放 02权益不发放)")
    private String legalRight;

    @ApiModelProperty(value = "材料信息")
    private List<PsiSalesOrderMaterialDto> salesOrderMaterialDtoList;


    @ApiModelProperty("归属主体")
    private String revertBody;

    @ApiModelProperty("定金")
    private BigDecimal deposit;
    
    @ApiModelProperty(value = "驳回原因")
    private String rejectReasons;
    
    @ApiModelProperty(value = "收款记录")
    private List<PayRecordDto> payRecordList;
    
    @ApiModelProperty(value = "改价记录")
    private OrderChangePriceDto orderChangePriceDto;

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public String getLegalRight() {
        return legalRight;
    }

    public void setLegalRight(String legalRight) {
        this.legalRight = legalRight;
    }

    public String getCarSeriesName() {
        return carSeriesName;
    }

    public void setCarSeriesName(String carSeriesName) {
        this.carSeriesName = carSeriesName;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCluesId() {
        return cluesId;
    }

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    public String getLicensingCity() {
        return licensingCity;
    }

    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getSetPaymentTime() {
        return setPaymentTime;
    }

    public void setSetPaymentTime(Date setPaymentTime) {
        this.setPaymentTime = setPaymentTime;
    }

    public Date getIntentionPayTime() {
        return intentionPayTime;
    }

    public void setIntentionPayTime(Date intentionPayTime) {
        this.intentionPayTime = intentionPayTime;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    public Long getDeliveryStore() {
        return deliveryStore;
    }

    public void setDeliveryStore(Long deliveryStore) {
        this.deliveryStore = deliveryStore;
    }

    public String getDeliveryStoreName() {
        return deliveryStoreName;
    }

    public void setDeliveryStoreName(String deliveryStoreName) {
        this.deliveryStoreName = deliveryStoreName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getOwnerCardNo() {
        return ownerCardNo;
    }

    public void setOwnerCardNo(String ownerCardNo) {
        this.ownerCardNo = ownerCardNo;
    }

    public Long getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(Long deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public String getDeliveryPersonName() {
        return deliveryPersonName;
    }

    public void setDeliveryPersonName(String deliveryPersonName) {
        this.deliveryPersonName = deliveryPersonName;
    }

    public Long getFollowPerson() {
        return followPerson;
    }

    public void setFollowPerson(Long followPerson) {
        this.followPerson = followPerson;
    }

    public String getFollowPersonName() {
        return followPersonName;
    }

    public void setFollowPersonName(String followPersonName) {
        this.followPersonName = followPersonName;
    }

    public String getCarOwnerType() {
        return carOwnerType;
    }

    public void setCarOwnerType(String carOwnerType) {
        this.carOwnerType = carOwnerType;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public BigDecimal getReceivablePrice() {
        return receivablePrice;
    }

    public void setReceivablePrice(BigDecimal receivablePrice) {
        this.receivablePrice = receivablePrice;
    }

    public BigDecimal getReceivedPrice() {
        return receivedPrice;
    }

    public void setReceivedPrice(BigDecimal receivedPrice) {
        this.receivedPrice = receivedPrice;
    }

    public BigDecimal getNotReceivedPrice() {
        return notReceivedPrice;
    }

    public void setNotReceivedPrice(BigDecimal notReceivedPrice) {
        this.notReceivedPrice = notReceivedPrice;
    }

    public Date getBalancePaymentTime() {
        return balancePaymentTime;
    }

    public void setBalancePaymentTime(Date balancePaymentTime) {
        this.balancePaymentTime = balancePaymentTime;
    }

    public String getBaseCarTypeName() {
        return baseCarTypeName;
    }

    public void setBaseCarTypeName(String baseCarTypeName) {
        this.baseCarTypeName = baseCarTypeName;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public List<PsiSalesOrderMaterialDto> getSalesOrderMaterialDtoList() {
        return salesOrderMaterialDtoList;
    }

    public void setSalesOrderMaterialDtoList(List<PsiSalesOrderMaterialDto> salesOrderMaterialDtoList) {
        this.salesOrderMaterialDtoList = salesOrderMaterialDtoList;
    }

    public Long getSalesStore() {
        return salesStore;
    }

    public void setSalesStore(Long salesStore) {
        this.salesStore = salesStore;
    }

    public String getSalesStoreName() {
        return salesStoreName;
    }

    public void setSalesStoreName(String salesStoreName) {
        this.salesStoreName = salesStoreName;
    }

    public String getEncryptionCustomerPhone() {
        return encryptionCustomerPhone;
    }

    public void setEncryptionCustomerPhone(String encryptionCustomerPhone) {
        this.encryptionCustomerPhone = encryptionCustomerPhone;
    }

    public String getMainUserName() {
        return mainUserName;
    }

    public void setMainUserName(String mainUserName) {
        this.mainUserName = mainUserName;
    }

    public String getMainUserPhone() {
        return mainUserPhone;
    }

    public void setMainUserPhone(String mainUserPhone) {
        this.mainUserPhone = mainUserPhone;
    }

    public String getMainCardNo() {
        return mainCardNo;
    }

    public void setMainCardNo(String mainCardNo) {
        this.mainCardNo = mainCardNo;
    }

    public String getRevertBody() {
        return revertBody;
    }

    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }

	public String getRejectReasons() {
		return rejectReasons;
	}

	public void setRejectReasons(String rejectReasons) {
		this.rejectReasons = rejectReasons;
	}

	public List<PayRecordDto> getPayRecordList() {
		return payRecordList;
	}

	public void setPayRecordList(List<PayRecordDto> payRecordList) {
		this.payRecordList = payRecordList;
	}

	public OrderChangePriceDto getOrderChangePriceDto() {
		return orderChangePriceDto;
	}

	public void setOrderChangePriceDto(OrderChangePriceDto orderChangePriceDto) {
		this.orderChangePriceDto = orderChangePriceDto;
	}
}
