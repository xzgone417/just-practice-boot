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

@ApiModel(value = "PsiOrderInfoEntity", description = "订单信息表")
@GroupSequence({PsiOrderInfoEntity.class, PsiOrderInfoEntity.PsiOrderInfoEntityValidGroup.class,PsiOrderInfoEntity.OrderInfoIdValidGroup.class,PsiOrderInfoEntity.CustomerIdValidGroup.class,PsiOrderInfoEntity.CluesIdValidGroup.class,PsiOrderInfoEntity.OrderNoValidGroup.class,PsiOrderInfoEntity.StockIdValidGroup.class,PsiOrderInfoEntity.DeliveryStorageIdValidGroup.class,PsiOrderInfoEntity.DeliveryStorageNameValidGroup.class,PsiOrderInfoEntity.CarVinValidGroup.class,PsiOrderInfoEntity.LicensingCityValidGroup.class,PsiOrderInfoEntity.OrderPriceValidGroup.class,PsiOrderInfoEntity.DepositValidGroup.class,PsiOrderInfoEntity.OrderStatusValidGroup.class,PsiOrderInfoEntity.SetPaymentSumValidGroup.class,PsiOrderInfoEntity.IntentionPaySumValidGroup.class,PsiOrderInfoEntity.BalancePaymentSumValidGroup.class,PsiOrderInfoEntity.FinancialLoanValidGroup.class,PsiOrderInfoEntity.OtherPaymentsValidGroup.class,PsiOrderInfoEntity.CarPriceValidGroup.class,PsiOrderInfoEntity.SalesStoreValidGroup.class,PsiOrderInfoEntity.DeliveryStoreValidGroup.class,PsiOrderInfoEntity.DeliveryPersonValidGroup.class,PsiOrderInfoEntity.CustomerNameValidGroup.class,PsiOrderInfoEntity.CustomerPhoneValidGroup.class,PsiOrderInfoEntity.OwnerCardNoValidGroup.class,PsiOrderInfoEntity.FollowPersonValidGroup.class,PsiOrderInfoEntity.CarOwnerTypeValidGroup.class,PsiOrderInfoEntity.TypeIdValidGroup.class,PsiOrderInfoEntity.ReceivablePriceValidGroup.class,PsiOrderInfoEntity.ReceivedPriceValidGroup.class,PsiOrderInfoEntity.NotReceivedPriceValidGroup.class,PsiOrderInfoEntity.BaseCarTypeNameValidGroup.class,PsiOrderInfoEntity.ExteriorColorValidGroup.class,PsiOrderInfoEntity.InteriorColorValidGroup.class,PsiOrderInfoEntity.OrderRemarkValidGroup.class,PsiOrderInfoEntity.CancelRemarkValidGroup.class,PsiOrderInfoEntity.PdiStatusValidGroup.class,PsiOrderInfoEntity.PdiResultValidGroup.class,PsiOrderInfoEntity.MainUserNameValidGroup.class,PsiOrderInfoEntity.MainUserPhoneValidGroup.class,PsiOrderInfoEntity.MainCardNoValidGroup.class,PsiOrderInfoEntity.CreatedByValidGroup.class,PsiOrderInfoEntity.CreatedDateValidGroup.class,PsiOrderInfoEntity.UpdatedByValidGroup.class,PsiOrderInfoEntity.UpdatedDateValidGroup.class,PsiOrderInfoEntity.IsEnableValidGroup.class,PsiOrderInfoEntity.IsDeleteValidGroup.class}) 
public class PsiOrderInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 订单信息id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "订单信息id 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, OrderInfoIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="订单信息id 数字精度必须符合(19,0)", groups = {PsiOrderInfoEntityValidGroup.class, OrderInfoIdValidGroup.class})
    @ApiModelProperty(value = "订单信息id")
    private Long orderInfoId;
    
    
    /**
     * 销售客户id
     */
    @NotNull(message = "销售客户id 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, CustomerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="销售客户id 数字精度必须符合(19,0)", groups = {PsiOrderInfoEntityValidGroup.class, CustomerIdValidGroup.class})
    @ApiModelProperty(value = "销售客户id")
    private Long customerId;
    
    /**
     * 线索id
     */
    @Digits(integer=19, fraction=0, message="线索id 数字精度必须符合(19,0)", groups = {PsiOrderInfoEntityValidGroup.class, CluesIdValidGroup.class})
    @ApiModelProperty(value = "线索id")
    private Long cluesId;
    
    /**
     * 订单编号
     */
    @NotNull(message = "订单编号 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, OrderNoValidGroup.class})
    @Size(min=0, max=50, message="订单编号 字符长度必须小于等于50", groups = {PsiOrderInfoEntityValidGroup.class, OrderNoValidGroup.class})
    @ApiModelProperty(value = "订单编号")
    private String orderNo;
    
    /**
     * 库存车辆id
     */
    @NotNull(message = "库存车辆id 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, StockIdValidGroup.class})
    @Size(min=0, max=100, message="库存车辆id 字符长度必须小于等于100", groups = {PsiOrderInfoEntityValidGroup.class, StockIdValidGroup.class})
    @ApiModelProperty(value = "库存车辆id")
    private String stockId;
    
    /**
     * vin码
     */
    @NotNull(message = "vin码 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, CarVinValidGroup.class})
    @Size(min=0, max=50, message="vin码 字符长度必须小于等于50", groups = {PsiOrderInfoEntityValidGroup.class, CarVinValidGroup.class})
    @ApiModelProperty(value = "vin码")
    private String carVin;
    
    /**
     * 上牌城市
     */
    @Size(min=0, max=50, message="上牌城市 字符长度必须小于等于50", groups = {PsiOrderInfoEntityValidGroup.class, LicensingCityValidGroup.class})
    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;
    
    /**
     * 订单价格
     */
    @Digits(integer=9, fraction=2, message="订单价格 数字精度必须符合(9,2)", groups = {PsiOrderInfoEntityValidGroup.class, OrderPriceValidGroup.class})
    @ApiModelProperty(value = "订单价格")
    private BigDecimal orderPrice;
    
    /**
     * 定金
     */
    @Digits(integer=9, fraction=2, message="定金 数字精度必须符合(9,2)", groups = {PsiOrderInfoEntityValidGroup.class, DepositValidGroup.class})
    @ApiModelProperty(value = "定金")
    private BigDecimal deposit;
    
    /**
     * 订单状态:7401 待下定,7402 已下定待转交付,7403 已分配待付全款,7404  已全款待过户,7405 已过户待交付,7406 已交付,7407 订单取消,7408 改配申请中,7409 已转交付待分配
     */
    @NotNull(message = "订单状态:7401 待下定,7402 已下定待转交付,7403 已分配待付全款,7404  已全款待过户,7405 已过户待交付,7406 已交付,7407 订单取消,7408 改配申请中,7409 已转交付待分配 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, OrderStatusValidGroup.class})
    @Size(min=0, max=4, message="订单状态:7401 待下定,7402 已下定待转交付,7403 已分配待付全款,7404  已全款待过户,7405 已过户待交付,7406 已交付,7407 订单取消,7408 改配申请中,7409 已转交付待分配 字符长度必须小于等于4", groups = {PsiOrderInfoEntityValidGroup.class, OrderStatusValidGroup.class})
    @ApiModelProperty(value = "订单状态:7401 待下定,7402 已下定待转交付,7403 已分配待付全款,7404  已全款待过户,7405 已过户待交付,7406 已交付,7407 订单取消,7408 改配申请中,7409 已转交付待分配")
    private String orderStatus;
    
    /**
     * 大定支付时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "大定支付时间")
    private Date setPaymentTime;
    
    /**
     * 大定金额
     */
    @Digits(integer=10, fraction=0, message="大定金额 数字精度必须符合(10,0)", groups = {PsiOrderInfoEntityValidGroup.class, SetPaymentSumValidGroup.class})
    @ApiModelProperty(value = "大定金额")
    private Long setPaymentSum;
    
    /**
     * 小定支付时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "小定支付时间")
    private Date intentionPayTime;
    
    /**
     * 小定金额
     */
    @Digits(integer=10, fraction=0, message="小定金额 数字精度必须符合(10,0)", groups = {PsiOrderInfoEntityValidGroup.class, IntentionPaySumValidGroup.class})
    @ApiModelProperty(value = "小定金额")
    private Long intentionPaySum;
    
    /**
     * 尾款金额
     */
    @Digits(integer=10, fraction=0, message="尾款金额 数字精度必须符合(10,0)", groups = {PsiOrderInfoEntityValidGroup.class, BalancePaymentSumValidGroup.class})
    @ApiModelProperty(value = "尾款金额")
    private Long balancePaymentSum;
    
    /**
     * 金融放款
     */
    @Digits(integer=10, fraction=0, message="金融放款 数字精度必须符合(10,0)", groups = {PsiOrderInfoEntityValidGroup.class, FinancialLoanValidGroup.class})
    @ApiModelProperty(value = "金融放款")
    private Long financialLoan;
    
    /**
     * 其它款项
     */
    @Digits(integer=10, fraction=0, message="其它款项 数字精度必须符合(10,0)", groups = {PsiOrderInfoEntityValidGroup.class, OtherPaymentsValidGroup.class})
    @ApiModelProperty(value = "其它款项")
    private Long otherPayments;
    
    /**
     * 车辆价格
     */
    @Digits(integer=9, fraction=2, message="车辆价格 数字精度必须符合(9,2)", groups = {PsiOrderInfoEntityValidGroup.class, CarPriceValidGroup.class})
    @ApiModelProperty(value = "车辆价格")
    private BigDecimal carPrice;
    
    /**
     * 销售门店ID
     */
    @NotNull(message = "销售门店ID 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, SalesStoreValidGroup.class})
    @Digits(integer=19, fraction=0, message="销售门店ID 数字精度必须符合(19,0)", groups = {PsiOrderInfoEntityValidGroup.class, SalesStoreValidGroup.class})
    @ApiModelProperty(value = "销售门店ID")
    private Long salesStore;
    
    /**
     * 交付门店id
     */
    @Digits(integer=19, fraction=0, message="交付门店id 数字精度必须符合(19,0)", groups = {PsiOrderInfoEntityValidGroup.class, DeliveryStoreValidGroup.class})
    @ApiModelProperty(value = "交付门店id")
    private Long deliveryStore;
    
    /**
     * 交付顾问
     */
    @Digits(integer=19, fraction=0, message="交付顾问 数字精度必须符合(19,0)", groups = {PsiOrderInfoEntityValidGroup.class, DeliveryPersonValidGroup.class})
    @ApiModelProperty(value = "交付顾问")
    private Long deliveryPerson;
    
    /**
     * 客户姓名
     */
    @NotNull(message = "客户姓名 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, CustomerNameValidGroup.class})
    @Size(min=0, max=20, message="客户姓名 字符长度必须小于等于20", groups = {PsiOrderInfoEntityValidGroup.class, CustomerNameValidGroup.class})
    @ApiModelProperty(value = "客户姓名")
    private String customerName;
    
    /**
     * 客户手机号
     */
    @NotNull(message = "客户手机号 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, CustomerPhoneValidGroup.class})
    @Size(min=0, max=100, message="客户手机号 字符长度必须小于等于100", groups = {PsiOrderInfoEntityValidGroup.class, CustomerPhoneValidGroup.class})
    @ApiModelProperty(value = "客户手机号")
    private String customerPhone;
    
    /**
     * 车主身份证
     */
    @NotNull(message = "车主身份证 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, OwnerCardNoValidGroup.class})
    @Size(min=0, max=100, message="车主身份证 字符长度必须小于等于100", groups = {PsiOrderInfoEntityValidGroup.class, OwnerCardNoValidGroup.class})
    @ApiModelProperty(value = "车主身份证")
    private String ownerCardNo;
    
    /**
     * 跟进人（出行顾问）
     */
    @Digits(integer=19, fraction=0, message="跟进人（出行顾问） 数字精度必须符合(19,0)", groups = {PsiOrderInfoEntityValidGroup.class, FollowPersonValidGroup.class})
    @ApiModelProperty(value = "跟进人（出行顾问）")
    private Long followPerson;
    
    /**
     * 车辆所有人类型01个人02企业
     */
    @NotNull(message = "车辆所有人类型01个人02企业 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, CarOwnerTypeValidGroup.class})
    @Size(min=0, max=4, message="车辆所有人类型01个人02企业 字符长度必须小于等于4", groups = {PsiOrderInfoEntityValidGroup.class, CarOwnerTypeValidGroup.class})
    @ApiModelProperty(value = "车辆所有人类型01个人02企业")
    private String carOwnerType;
    
    /**
     * 证件类型字典type81
     */
    @NotNull(message = "证件类型字典type81 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, TypeIdValidGroup.class})
    @Size(min=0, max=4, message="证件类型字典type81 字符长度必须小于等于4", groups = {PsiOrderInfoEntityValidGroup.class, TypeIdValidGroup.class})
    @ApiModelProperty(value = "证件类型字典type81")
    private String typeId;
    
    /**
     * 应收总金额
     */
    @Digits(integer=9, fraction=2, message="应收总金额 数字精度必须符合(9,2)", groups = {PsiOrderInfoEntityValidGroup.class, ReceivablePriceValidGroup.class})
    @ApiModelProperty(value = "应收总金额")
    private BigDecimal receivablePrice;
    
    /**
     * 已收总金额
     */
    @Digits(integer=9, fraction=2, message="已收总金额 数字精度必须符合(9,2)", groups = {PsiOrderInfoEntityValidGroup.class, ReceivedPriceValidGroup.class})
    @ApiModelProperty(value = "已收总金额")
    private BigDecimal receivedPrice;
    
    /**
     * 未收总金额
     */
    @Digits(integer=9, fraction=2, message="未收总金额 数字精度必须符合(9,2)", groups = {PsiOrderInfoEntityValidGroup.class, NotReceivedPriceValidGroup.class})
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
    @Size(min=0, max=80, message="基础车型名称 字符长度必须小于等于80", groups = {PsiOrderInfoEntityValidGroup.class, BaseCarTypeNameValidGroup.class})
    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;
    
    /**
     * 外饰色
     */
    @NotNull(message = "外饰色 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, ExteriorColorValidGroup.class})
    @Size(min=0, max=100, message="外饰色 字符长度必须小于等于100", groups = {PsiOrderInfoEntityValidGroup.class, ExteriorColorValidGroup.class})
    @ApiModelProperty(value = "外饰色")
    private String exteriorColor;
    
    /**
     * 内饰色
     */
    @NotNull(message = "内饰色 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, InteriorColorValidGroup.class})
    @Size(min=0, max=100, message="内饰色 字符长度必须小于等于100", groups = {PsiOrderInfoEntityValidGroup.class, InteriorColorValidGroup.class})
    @ApiModelProperty(value = "内饰色")
    private String interiorColor;
    
    /**
     * 订单备注
     */
    @Size(min=0, max=500, message="订单备注 字符长度必须小于等于500", groups = {PsiOrderInfoEntityValidGroup.class, OrderRemarkValidGroup.class})
    @ApiModelProperty(value = "订单备注")
    private String orderRemark;
    
    /**
     * 订单取消原因
     */
    @Size(min=0, max=500, message="订单取消原因 字符长度必须小于等于500", groups = {PsiOrderInfoEntityValidGroup.class, CancelRemarkValidGroup.class})
    @ApiModelProperty(value = "订单取消原因")
    private String cancelRemark;
    
    /**
     * 发放权益(01.权益发放 02权益不发放)
     */
    @ApiModelProperty(value = "发放权益(01.权益发放 02权益不发放)")
    private String legalRight;
    
    /**
     * PDI状态 01 待检测 02 待整备 03 已完成
     */
    @Size(min=0, max=10, message="PDI状态 01 待检测 02 待整备 03 已完成 字符长度必须小于等于10", groups = {PsiOrderInfoEntityValidGroup.class, PdiStatusValidGroup.class})
    @ApiModelProperty(value = "PDI状态 01 待检测 02 待整备 03 已完成")
    private String pdiStatus;
    
    /**
     * PDI结果 01 有问题，已转处理流程 02 检查合格
     */
    @Size(min=0, max=10, message="PDI结果 01 有问题，已转处理流程 02 检查合格 字符长度必须小于等于10", groups = {PsiOrderInfoEntityValidGroup.class, PdiResultValidGroup.class})
    @ApiModelProperty(value = "PDI结果 01 有问题，已转处理流程 02 检查合格")
    private String pdiResult;
    
    /**
     * 主用车人姓名
     */
    @Size(min=0, max=100, message="主用车人姓名 字符长度必须小于等于100", groups = {PsiOrderInfoEntityValidGroup.class, MainUserNameValidGroup.class})
    @ApiModelProperty(value = "主用车人姓名")
    private String mainUserName;
    
    /**
     * 主用车人电话
     */
    @Size(min=0, max=20, message="主用车人电话 字符长度必须小于等于20", groups = {PsiOrderInfoEntityValidGroup.class, MainUserPhoneValidGroup.class})
    @ApiModelProperty(value = "主用车人电话")
    private String mainUserPhone;
    
    /**
     * 主用车人证件号
     */
    @Size(min=0, max=20, message="主用车人证件号 字符长度必须小于等于20", groups = {PsiOrderInfoEntityValidGroup.class, MainCardNoValidGroup.class})
    @ApiModelProperty(value = "主用车人证件号")
    private String mainCardNo;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiOrderInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiOrderInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiOrderInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiOrderInfoEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiOrderInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiOrderInfoEntity() {
    }
    
    public PsiOrderInfoEntity(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }
    public Long getOrderInfoId() {
        return this.orderInfoId;
    }
    

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }
    public Long getCluesId() {
        return this.cluesId;
    }
    
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getOrderNo() {
        return this.orderNo;
    }
    
    public void setStockId(String stockId) {
        this.stockId = stockId;
    }
    public String getStockId() {
        return this.stockId;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }
    public String getCarVin() {
        return this.carVin;
    }
    
    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }
    public String getLicensingCity() {
        return this.licensingCity;
    }
    
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
    public BigDecimal getOrderPrice() {
        return this.orderPrice;
    }
    
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }
    public BigDecimal getDeposit() {
        return this.deposit;
    }
    
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setSetPaymentTime(Date setPaymentTime) {
        this.setPaymentTime = setPaymentTime;
    }
    public Date getSetPaymentTime() {
        return this.setPaymentTime;
    }
    
    public void setSetPaymentSum(Long setPaymentSum) {
        this.setPaymentSum = setPaymentSum;
    }
    public Long getSetPaymentSum() {
        return this.setPaymentSum;
    }
    
    public void setIntentionPayTime(Date intentionPayTime) {
        this.intentionPayTime = intentionPayTime;
    }
    public Date getIntentionPayTime() {
        return this.intentionPayTime;
    }
    
    public void setIntentionPaySum(Long intentionPaySum) {
        this.intentionPaySum = intentionPaySum;
    }
    public Long getIntentionPaySum() {
        return this.intentionPaySum;
    }
    
    public void setBalancePaymentSum(Long balancePaymentSum) {
        this.balancePaymentSum = balancePaymentSum;
    }
    public Long getBalancePaymentSum() {
        return this.balancePaymentSum;
    }
    
    public void setFinancialLoan(Long financialLoan) {
        this.financialLoan = financialLoan;
    }
    public Long getFinancialLoan() {
        return this.financialLoan;
    }
    
    public void setOtherPayments(Long otherPayments) {
        this.otherPayments = otherPayments;
    }
    public Long getOtherPayments() {
        return this.otherPayments;
    }
    
    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }
    public BigDecimal getCarPrice() {
        return this.carPrice;
    }
    
    public void setSalesStore(Long salesStore) {
        this.salesStore = salesStore;
    }
    public Long getSalesStore() {
        return this.salesStore;
    }
    
    public void setDeliveryStore(Long deliveryStore) {
        this.deliveryStore = deliveryStore;
    }
    public Long getDeliveryStore() {
        return this.deliveryStore;
    }
    
    public void setDeliveryPerson(Long deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }
    public Long getDeliveryPerson() {
        return this.deliveryPerson;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public String getCustomerPhone() {
        return this.customerPhone;
    }
    
    public void setOwnerCardNo(String ownerCardNo) {
        this.ownerCardNo = ownerCardNo;
    }
    public String getOwnerCardNo() {
        return this.ownerCardNo;
    }
    
    public void setFollowPerson(Long followPerson) {
        this.followPerson = followPerson;
    }
    public Long getFollowPerson() {
        return this.followPerson;
    }
    
    public void setCarOwnerType(String carOwnerType) {
        this.carOwnerType = carOwnerType;
    }
    public String getCarOwnerType() {
        return this.carOwnerType;
    }
    
    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }
    public String getTypeId() {
        return this.typeId;
    }
    
    public void setReceivablePrice(BigDecimal receivablePrice) {
        this.receivablePrice = receivablePrice;
    }
    public BigDecimal getReceivablePrice() {
        return this.receivablePrice;
    }
    
    public void setReceivedPrice(BigDecimal receivedPrice) {
        this.receivedPrice = receivedPrice;
    }
    public BigDecimal getReceivedPrice() {
        return this.receivedPrice;
    }
    
    public void setNotReceivedPrice(BigDecimal notReceivedPrice) {
        this.notReceivedPrice = notReceivedPrice;
    }
    public BigDecimal getNotReceivedPrice() {
        return this.notReceivedPrice;
    }
    
    public void setBalancePaymentTime(Date balancePaymentTime) {
        this.balancePaymentTime = balancePaymentTime;
    }
    public Date getBalancePaymentTime() {
        return this.balancePaymentTime;
    }
    
    public void setBaseCarTypeName(String baseCarTypeName) {
        this.baseCarTypeName = baseCarTypeName;
    }
    public String getBaseCarTypeName() {
        return this.baseCarTypeName;
    }
    
    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }
    public String getExteriorColor() {
        return this.exteriorColor;
    }
    
    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }
    public String getInteriorColor() {
        return this.interiorColor;
    }
    
    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }
    public String getOrderRemark() {
        return this.orderRemark;
    }
    
    public void setCancelRemark(String cancelRemark) {
        this.cancelRemark = cancelRemark;
    }
    public String getCancelRemark() {
        return this.cancelRemark;
    }
    
    public void setLegalRight(String legalRight) {
        this.legalRight = legalRight;
    }
    public String getLegalRight() {
        return this.legalRight;
    }
    
    public void setPdiStatus(String pdiStatus) {
        this.pdiStatus = pdiStatus;
    }
    public String getPdiStatus() {
        return this.pdiStatus;
    }
    
    public void setPdiResult(String pdiResult) {
        this.pdiResult = pdiResult;
    }
    public String getPdiResult() {
        return this.pdiResult;
    }
    
    public void setMainUserName(String mainUserName) {
        this.mainUserName = mainUserName;
    }
    public String getMainUserName() {
        return this.mainUserName;
    }
    
    public void setMainUserPhone(String mainUserPhone) {
        this.mainUserPhone = mainUserPhone;
    }
    public String getMainUserPhone() {
        return this.mainUserPhone;
    }
    
    public void setMainCardNo(String mainCardNo) {
        this.mainCardNo = mainCardNo;
    }
    public String getMainCardNo() {
        return this.mainCardNo;
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
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (orderInfoId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                orderInfoId = RandomIDGennerator.get().generate();
    }

    public interface PsiOrderInfoEntityValidGroup {}
    public interface OrderInfoIdValidGroup {}
    public interface CustomerIdValidGroup {}
    public interface CluesIdValidGroup {}
    public interface OrderNoValidGroup {}
    public interface StockIdValidGroup {}
    public interface DeliveryStorageIdValidGroup {}
    public interface DeliveryStorageNameValidGroup {}
    public interface CarVinValidGroup {}
    public interface LicensingCityValidGroup {}
    public interface OrderPriceValidGroup {}
    public interface DepositValidGroup {}
    public interface OrderStatusValidGroup {}
    public interface SetPaymentSumValidGroup {}
    public interface IntentionPaySumValidGroup {}
    public interface BalancePaymentSumValidGroup {}
    public interface FinancialLoanValidGroup {}
    public interface OtherPaymentsValidGroup {}
    public interface CarPriceValidGroup {}
    public interface SalesStoreValidGroup {}
    public interface DeliveryStoreValidGroup {}
    public interface DeliveryPersonValidGroup {}
    public interface CustomerNameValidGroup {}
    public interface CustomerPhoneValidGroup {}
    public interface OwnerCardNoValidGroup {}
    public interface FollowPersonValidGroup {}
    public interface CarOwnerTypeValidGroup {}
    public interface TypeIdValidGroup {}
    public interface ReceivablePriceValidGroup {}
    public interface ReceivedPriceValidGroup {}
    public interface NotReceivedPriceValidGroup {}
    public interface BaseCarTypeNameValidGroup {}
    public interface ExteriorColorValidGroup {}
    public interface InteriorColorValidGroup {}
    public interface OrderRemarkValidGroup {}
    public interface CancelRemarkValidGroup {}
    public interface PdiStatusValidGroup {}
    public interface PdiResultValidGroup {}
    public interface MainUserNameValidGroup {}
    public interface MainUserPhoneValidGroup {}
    public interface MainCardNoValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiOrderInfoEntity.OrderInfoIdValidGroup.class
            , PsiOrderInfoEntity.CustomerIdValidGroup.class
            , PsiOrderInfoEntity.CluesIdValidGroup.class
            , PsiOrderInfoEntity.OrderNoValidGroup.class
            , PsiOrderInfoEntity.StockIdValidGroup.class
            , PsiOrderInfoEntity.DeliveryStorageIdValidGroup.class
            , PsiOrderInfoEntity.DeliveryStorageNameValidGroup.class
            , PsiOrderInfoEntity.CarVinValidGroup.class
            , PsiOrderInfoEntity.LicensingCityValidGroup.class
            , PsiOrderInfoEntity.OrderPriceValidGroup.class
            , PsiOrderInfoEntity.DepositValidGroup.class
            , PsiOrderInfoEntity.OrderStatusValidGroup.class
            , PsiOrderInfoEntity.SetPaymentSumValidGroup.class
            , PsiOrderInfoEntity.IntentionPaySumValidGroup.class
            , PsiOrderInfoEntity.BalancePaymentSumValidGroup.class
            , PsiOrderInfoEntity.FinancialLoanValidGroup.class
            , PsiOrderInfoEntity.OtherPaymentsValidGroup.class
            , PsiOrderInfoEntity.CarPriceValidGroup.class
            , PsiOrderInfoEntity.SalesStoreValidGroup.class
            , PsiOrderInfoEntity.DeliveryStoreValidGroup.class
            , PsiOrderInfoEntity.DeliveryPersonValidGroup.class
            , PsiOrderInfoEntity.CustomerNameValidGroup.class
            , PsiOrderInfoEntity.CustomerPhoneValidGroup.class
            , PsiOrderInfoEntity.OwnerCardNoValidGroup.class
            , PsiOrderInfoEntity.FollowPersonValidGroup.class
            , PsiOrderInfoEntity.CarOwnerTypeValidGroup.class
            , PsiOrderInfoEntity.TypeIdValidGroup.class
            , PsiOrderInfoEntity.ReceivablePriceValidGroup.class
            , PsiOrderInfoEntity.ReceivedPriceValidGroup.class
            , PsiOrderInfoEntity.NotReceivedPriceValidGroup.class
            , PsiOrderInfoEntity.BaseCarTypeNameValidGroup.class
            , PsiOrderInfoEntity.ExteriorColorValidGroup.class
            , PsiOrderInfoEntity.InteriorColorValidGroup.class
            , PsiOrderInfoEntity.OrderRemarkValidGroup.class
            , PsiOrderInfoEntity.CancelRemarkValidGroup.class
            , PsiOrderInfoEntity.PdiStatusValidGroup.class
            , PsiOrderInfoEntity.PdiResultValidGroup.class
            , PsiOrderInfoEntity.MainUserNameValidGroup.class
            , PsiOrderInfoEntity.MainUserPhoneValidGroup.class
            , PsiOrderInfoEntity.MainCardNoValidGroup.class
            , PsiOrderInfoEntity.CreatedByValidGroup.class
            , PsiOrderInfoEntity.CreatedDateValidGroup.class
            , PsiOrderInfoEntity.UpdatedByValidGroup.class
            , PsiOrderInfoEntity.UpdatedDateValidGroup.class
            , PsiOrderInfoEntity.IsEnableValidGroup.class
            , PsiOrderInfoEntity.IsDeleteValidGroup.class
        };
    }
}
