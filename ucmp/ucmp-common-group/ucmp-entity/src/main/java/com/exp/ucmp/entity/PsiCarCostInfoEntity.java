package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

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

@ApiModel(value = "PsiCarCostInfoEntity", description = "车辆费用信息表(二期)")
@GroupSequence({PsiCarCostInfoEntity.class, PsiCarCostInfoEntity.PsiCarCostInfoEntityValidGroup.class,PsiCarCostInfoEntity.CostInfoIdValidGroup.class,PsiCarCostInfoEntity.StockIdValidGroup.class,PsiCarCostInfoEntity.IncomePriceValidGroup.class,PsiCarCostInfoEntity.ServiceCostValidGroup.class,PsiCarCostInfoEntity.FacialCostValidGroup.class,PsiCarCostInfoEntity.LogisticsCostValidGroup.class,PsiCarCostInfoEntity.TestCostValidGroup.class,PsiCarCostInfoEntity.RetainCostValidGroup.class,PsiCarCostInfoEntity.FriendlyCostValidGroup.class,PsiCarCostInfoEntity.RightCostValidGroup.class,PsiCarCostInfoEntity.InterestCostValidGroup.class,PsiCarCostInfoEntity.GiftCostValidGroup.class,PsiCarCostInfoEntity.BrokerageCostValidGroup.class,PsiCarCostInfoEntity.OtherCostValidGroup.class,PsiCarCostInfoEntity.SellPriceValidGroup.class,PsiCarCostInfoEntity.CreatedByValidGroup.class,PsiCarCostInfoEntity.CreatedDateValidGroup.class,PsiCarCostInfoEntity.UpdatedByValidGroup.class,PsiCarCostInfoEntity.UpdatedDateValidGroup.class,PsiCarCostInfoEntity.IsEnableValidGroup.class,PsiCarCostInfoEntity.IsDeleteValidGroup.class}) 
public class PsiCarCostInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 费用信息id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "费用信息id 不能是Null", groups = {PsiCarCostInfoEntityValidGroup.class, CostInfoIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="费用信息id 数字精度必须符合(19,0)", groups = {PsiCarCostInfoEntityValidGroup.class, CostInfoIdValidGroup.class})
    @ApiModelProperty(value = "费用信息id")
    private Long costInfoId;
    
    
    /**
     * 库存车辆id
     */
    @NotNull(message = "库存车辆id 不能是Null", groups = {PsiCarCostInfoEntityValidGroup.class, StockIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="库存车辆id 数字精度必须符合(19,0)", groups = {PsiCarCostInfoEntityValidGroup.class, StockIdValidGroup.class})
    @ApiModelProperty(value = "库存车辆id")
    private Long stockId;
    
    /**
     * 销售出库时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "销售出库时间")
    private Date checkoutDate;
    
    /**
     * 收入价格
     */
    @Digits(integer=9, fraction=2, message="收入价格 数字精度必须符合(9,2)", groups = {PsiCarCostInfoEntityValidGroup.class, IncomePriceValidGroup.class})
    @ApiModelProperty(value = "收入价格")
    private BigDecimal incomePrice;
    
    /**
     * 整备价格
     */
    @Digits(integer=9, fraction=2, message="整备价格 数字精度必须符合(9,2)", groups = {PsiCarCostInfoEntityValidGroup.class, ServiceCostValidGroup.class})
    @ApiModelProperty(value = "整备价格")
    private BigDecimal serviceCost;
    
    /**
     * 美容款
     */
    @Digits(integer=9, fraction=2, message="美容款 数字精度必须符合(9,2)", groups = {PsiCarCostInfoEntityValidGroup.class, FacialCostValidGroup.class})
    @ApiModelProperty(value = "美容款")
    private BigDecimal facialCost;
    
    /**
     * 物流费用
     */
    @Digits(integer=9, fraction=2, message="物流费用 数字精度必须符合(9,2)", groups = {PsiCarCostInfoEntityValidGroup.class, LogisticsCostValidGroup.class})
    @ApiModelProperty(value = "物流费用")
    private BigDecimal logisticsCost;
    
    /**
     * 检测费用
     */
    @Digits(integer=9, fraction=2, message="检测费用 数字精度必须符合(9,2)", groups = {PsiCarCostInfoEntityValidGroup.class, TestCostValidGroup.class})
    @ApiModelProperty(value = "检测费用")
    private BigDecimal testCost;
    
    /**
     * 保全费用
     */
    @Size(min=0, max=50, message="保全费用 字符长度必须小于等于50", groups = {PsiCarCostInfoEntityValidGroup.class, RetainCostValidGroup.class})
    @ApiModelProperty(value = "保全费用")
    private BigDecimal retainCost;
    
    /**
     * 亲善费用
     */
    @Digits(integer=9, fraction=2, message="亲善费用 数字精度必须符合(9,2)", groups = {PsiCarCostInfoEntityValidGroup.class, FriendlyCostValidGroup.class})
    @ApiModelProperty(value = "亲善费用")
    private BigDecimal friendlyCost;
    
    /**
     * 权益费用
     */
    @Digits(integer=9, fraction=2, message="权益费用 数字精度必须符合(9,2)", groups = {PsiCarCostInfoEntityValidGroup.class, RightCostValidGroup.class})
    @ApiModelProperty(value = "权益费用")
    private BigDecimal rightCost;
    
    /**
     * 贴息费用
     */
    @Digits(integer=9, fraction=2, message="贴息费用 数字精度必须符合(9,2)", groups = {PsiCarCostInfoEntityValidGroup.class, InterestCostValidGroup.class})
    @ApiModelProperty(value = "贴息费用")
    private BigDecimal interestCost;
    
    /**
     * 礼品费用
     */
    @Digits(integer=9, fraction=2, message="礼品费用 数字精度必须符合(9,2)", groups = {PsiCarCostInfoEntityValidGroup.class, GiftCostValidGroup.class})
    @ApiModelProperty(value = "礼品费用")
    private BigDecimal giftCost;
    
    /**
     * 佣金费用
     */
    @Digits(integer=9, fraction=2, message="佣金费用 数字精度必须符合(9,2)", groups = {PsiCarCostInfoEntityValidGroup.class, BrokerageCostValidGroup.class})
    @ApiModelProperty(value = "佣金费用")
    private BigDecimal brokerageCost;
    
    /**
     * 其他费用
     */
    @Digits(integer=9, fraction=2, message="其他费用 数字精度必须符合(9,2)", groups = {PsiCarCostInfoEntityValidGroup.class, OtherCostValidGroup.class})
    @ApiModelProperty(value = "其他费用")
    private BigDecimal otherCost;
    
    /**
     * 售出价格
     */
    @Digits(integer=9, fraction=2, message="售出价格 数字精度必须符合(9,2)", groups = {PsiCarCostInfoEntityValidGroup.class, SellPriceValidGroup.class})
    @ApiModelProperty(value = "售出价格")
    private BigDecimal sellPrice;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarCostInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarCostInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarCostInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarCostInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarCostInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarCostInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiCarCostInfoEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {PsiCarCostInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiCarCostInfoEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiCarCostInfoEntity() {
    }
    
    public PsiCarCostInfoEntity(Long costInfoId) {
        this.costInfoId = costInfoId;
    }

    public void setCostInfoId(Long costInfoId) {
        this.costInfoId = costInfoId;
    }
    public Long getCostInfoId() {
        return this.costInfoId;
    }
    

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
    public Long getStockId() {
        return this.stockId;
    }
    
    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
    public Date getCheckoutDate() {
        return this.checkoutDate;
    }
    
    public void setIncomePrice(BigDecimal incomePrice) {
        this.incomePrice = incomePrice;
    }
    public BigDecimal getIncomePrice() {
        return this.incomePrice;
    }
    
    public void setServiceCost(BigDecimal serviceCost) {
        this.serviceCost = serviceCost;
    }
    public BigDecimal getServiceCost() {
        return this.serviceCost;
    }
    
    public void setFacialCost(BigDecimal facialCost) {
        this.facialCost = facialCost;
    }
    public BigDecimal getFacialCost() {
        return this.facialCost;
    }
    
    public void setLogisticsCost(BigDecimal logisticsCost) {
        this.logisticsCost = logisticsCost;
    }
    public BigDecimal getLogisticsCost() {
        return this.logisticsCost;
    }
    
    public void setTestCost(BigDecimal testCost) {
        this.testCost = testCost;
    }
    public BigDecimal getTestCost() {
        return this.testCost;
    }
    
    public void setRetainCost(BigDecimal retainCost) {
        this.retainCost = retainCost;
    }
    public BigDecimal getRetainCost() {
        return this.retainCost;
    }
    
    public void setFriendlyCost(BigDecimal friendlyCost) {
        this.friendlyCost = friendlyCost;
    }
    public BigDecimal getFriendlyCost() {
        return this.friendlyCost;
    }
    
    public void setRightCost(BigDecimal rightCost) {
        this.rightCost = rightCost;
    }
    public BigDecimal getRightCost() {
        return this.rightCost;
    }
    
    public void setInterestCost(BigDecimal interestCost) {
        this.interestCost = interestCost;
    }
    public BigDecimal getInterestCost() {
        return this.interestCost;
    }
    
    public void setGiftCost(BigDecimal giftCost) {
        this.giftCost = giftCost;
    }
    public BigDecimal getGiftCost() {
        return this.giftCost;
    }
    
    public void setBrokerageCost(BigDecimal brokerageCost) {
        this.brokerageCost = brokerageCost;
    }
    public BigDecimal getBrokerageCost() {
        return this.brokerageCost;
    }
    
    public void setOtherCost(BigDecimal otherCost) {
        this.otherCost = otherCost;
    }
    public BigDecimal getOtherCost() {
        return this.otherCost;
    }
    
    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }
    public BigDecimal getSellPrice() {
        return this.sellPrice;
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
              (costInfoId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                costInfoId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarCostInfoEntityValidGroup {}
    public interface CostInfoIdValidGroup {}
    public interface StockIdValidGroup {}
    public interface IncomePriceValidGroup {}
    public interface ServiceCostValidGroup {}
    public interface FacialCostValidGroup {}
    public interface LogisticsCostValidGroup {}
    public interface TestCostValidGroup {}
    public interface RetainCostValidGroup {}
    public interface FriendlyCostValidGroup {}
    public interface RightCostValidGroup {}
    public interface InterestCostValidGroup {}
    public interface GiftCostValidGroup {}
    public interface BrokerageCostValidGroup {}
    public interface OtherCostValidGroup {}
    public interface SellPriceValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            CostInfoIdValidGroup.class
            , StockIdValidGroup.class
            , IncomePriceValidGroup.class
            , ServiceCostValidGroup.class
            , FacialCostValidGroup.class
            , LogisticsCostValidGroup.class
            , TestCostValidGroup.class
            , RetainCostValidGroup.class
            , FriendlyCostValidGroup.class
            , RightCostValidGroup.class
            , InterestCostValidGroup.class
            , GiftCostValidGroup.class
            , BrokerageCostValidGroup.class
            , OtherCostValidGroup.class
            , SellPriceValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
