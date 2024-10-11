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

@ApiModel(value = "PsiRetentionCluesEntity", description = "留资线索表(v2)")
@GroupSequence({PsiRetentionCluesEntity.class, PsiRetentionCluesEntity.PsiRetentionCluesEntityValidGroup.class,PsiRetentionCluesEntity.CluesIdValidGroup.class,PsiRetentionCluesEntity.StorageIdValidGroup.class,PsiRetentionCluesEntity.StockIdValidGroup.class,PsiRetentionCluesEntity.CustomerIdValidGroup.class,PsiRetentionCluesEntity.ModelCodeValidGroup.class,PsiRetentionCluesEntity.ModelNameValidGroup.class,PsiRetentionCluesEntity.ShapeCodeValidGroup.class,PsiRetentionCluesEntity.ShapeNameValidGroup.class,PsiRetentionCluesEntity.SalePriceValidGroup.class,PsiRetentionCluesEntity.CustomerNameValidGroup.class,PsiRetentionCluesEntity.CustomerPhoneValidGroup.class,PsiRetentionCluesEntity.RetentionTimeValidGroup.class,PsiRetentionCluesEntity.FollowPersonValidGroup.class,PsiRetentionCluesEntity.CluesSourceValidGroup.class,PsiRetentionCluesEntity.FollowStatusValidGroup.class,PsiRetentionCluesEntity.CustomerCharacterValidGroup.class,PsiRetentionCluesEntity.PurchaseTimeValidGroup.class,PsiRetentionCluesEntity.FamilySituationValidGroup.class,PsiRetentionCluesEntity.IsShowValidGroup.class,PsiRetentionCluesEntity.CreatedByValidGroup.class,PsiRetentionCluesEntity.CreatedDateValidGroup.class,PsiRetentionCluesEntity.UpdatedByValidGroup.class,PsiRetentionCluesEntity.UpdatedDateValidGroup.class,PsiRetentionCluesEntity.IsEnableValidGroup.class,PsiRetentionCluesEntity.IsDeleteValidGroup.class}) 
public class PsiRetentionCluesEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 线索id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "线索id 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, CluesIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="线索id 数字精度必须符合(19,0)", groups = {PsiRetentionCluesEntityValidGroup.class, CluesIdValidGroup.class})
    @ApiModelProperty(value = "线索id")
    private Long cluesId;
    
    
    /**
     * 仓储点id
     */
    @NotNull(message = "仓储点id 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, StorageIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="仓储点id 数字精度必须符合(19,0)", groups = {PsiRetentionCluesEntityValidGroup.class, StorageIdValidGroup.class})
    @ApiModelProperty(value = "仓储点id")
    private Long storageId;
    
    /**
     * 库存车辆id
     */
    @NotNull(message = "库存车辆id 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, StockIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="库存车辆id 数字精度必须符合(19,0)", groups = {PsiRetentionCluesEntityValidGroup.class, StockIdValidGroup.class})
    @ApiModelProperty(value = "库存车辆id")
    private Long stockId;
    
    /**
     * 销售客户id
     */
    @NotNull(message = "销售客户id 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, CustomerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="销售客户id 数字精度必须符合(19,0)", groups = {PsiRetentionCluesEntityValidGroup.class, CustomerIdValidGroup.class})
    @ApiModelProperty(value = "销售客户id")
    private Long customerId;
    
    /**
     * 工程车型代码
     */
    @Size(min=0, max=20, message="工程车型代码 字符长度必须小于等于20", groups = {PsiRetentionCluesEntityValidGroup.class, ModelCodeValidGroup.class})
    @ApiModelProperty(value = "工程车型代码")
    private String modelCode;
    
    /**
     * 工程车型名称
     */
    @Size(min=0, max=100, message="工程车型名称 字符长度必须小于等于100", groups = {PsiRetentionCluesEntityValidGroup.class, ModelNameValidGroup.class})
    @ApiModelProperty(value = "工程车型名称")
    private String modelName;
    
    /**
     * 基本车型代码
     */
    @Size(min=0, max=20, message="基本车型代码 字符长度必须小于等于20", groups = {PsiRetentionCluesEntityValidGroup.class, ShapeCodeValidGroup.class})
    @ApiModelProperty(value = "基本车型代码")
    private String shapeCode;
    
    /**
     * 基本车型名称
     */
    @Size(min=0, max=100, message="基本车型名称 字符长度必须小于等于100", groups = {PsiRetentionCluesEntityValidGroup.class, ShapeNameValidGroup.class})
    @ApiModelProperty(value = "基本车型名称")
    private String shapeName;
    
    /**
     * 销售定价
     */
    @NotNull(message = "销售定价 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, SalePriceValidGroup.class})
    @Digits(integer=9, fraction=0, message="销售定价 数字精度必须符合(9,0)", groups = {PsiRetentionCluesEntityValidGroup.class, SalePriceValidGroup.class})
    @ApiModelProperty(value = "销售定价")
    private BigDecimal salePrice;
    
    /**
     * 客户姓名
     */
    @NotNull(message = "客户姓名 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, CustomerNameValidGroup.class})
    @Size(min=0, max=20, message="客户姓名 字符长度必须小于等于20", groups = {PsiRetentionCluesEntityValidGroup.class, CustomerNameValidGroup.class})
    @ApiModelProperty(value = "客户姓名")
    private String customerName;
    
    /**
     * 客户手机号
     */
    @NotNull(message = "客户手机号 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, CustomerPhoneValidGroup.class})
    @Size(min=0, max=100, message="客户手机号 字符长度必须小于等于100", groups = {PsiRetentionCluesEntityValidGroup.class, CustomerPhoneValidGroup.class})
    @ApiModelProperty(value = "客户手机号")
    private String customerPhone;
    
    /**
     * 留资日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "线索留资日期 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, RetentionTimeValidGroup.class})
    @ApiModelProperty(value = "线索留资日期")
    private Date retentionTime;


    @Digits(integer=19, fraction=0, message="跟进门店ID 数字精度必须符合(19,0)", groups = {PsiRetentionCluesEntityValidGroup.class, FollowPersonValidGroup.class})
    @ApiModelProperty(value = "跟进门店ID")
    private Long followStore;
    
    /**
     * 跟进人
     */
    @Digits(integer=19, fraction=0, message="跟进人 数字精度必须符合(19,0)", groups = {PsiRetentionCluesEntityValidGroup.class, FollowPersonValidGroup.class})
    @ApiModelProperty(value = "跟进人")
    private Long followPerson;
    
    /**
     * 跟进日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "跟进日期")
    private Date followTime;
    
    /**
     * 来源
     */
    @Size(min=0, max=10, message="来源 字符长度必须小于等于10", groups = {PsiRetentionCluesEntityValidGroup.class, CluesSourceValidGroup.class})
    @ApiModelProperty(value = "来源")
    private String cluesSource;
    
    /**
     * 跟进状态
     */
    @NotNull(message = "跟进状态 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, FollowStatusValidGroup.class})
    @Size(min=0, max=10, message="跟进状态 字符长度必须小于等于10", groups = {PsiRetentionCluesEntityValidGroup.class, FollowStatusValidGroup.class})
    @ApiModelProperty(value = "跟进状态")
    private String followStatus;
    
    /**
     * 上次跟进时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上次跟进时间")
    private Date lastFollowTime;
    
    /**
     * 下次跟进时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "下次跟进时间")
    private Date nextFollowTime;
    
    /**
     * 客户性格(00外向 01内向)
     */
    @NotNull(message = "客户性格(00外向 01内向) 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, CustomerCharacterValidGroup.class})
    @Size(min=0, max=2, message="客户性格(00外向 01内向) 字符长度必须小于等于2", groups = {PsiRetentionCluesEntityValidGroup.class, CustomerCharacterValidGroup.class})
    @ApiModelProperty(value = "客户性格(00外向 01内向)")
    private String customerCharacter;
    
    /**
     * 购车时间
     */
    @NotNull(message = "购车时间 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, PurchaseTimeValidGroup.class})
    @Size(min=0, max=4, message="购车时间 字符长度必须小于等于4", groups = {PsiRetentionCluesEntityValidGroup.class, PurchaseTimeValidGroup.class})
    @ApiModelProperty(value = "购车时间")
    private String purchaseTime;
    
    /**
     * 家庭情况
     */
    @NotNull(message = "家庭情况 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, FamilySituationValidGroup.class})
    @Size(min=0, max=4, message="家庭情况 字符长度必须小于等于4", groups = {PsiRetentionCluesEntityValidGroup.class, FamilySituationValidGroup.class})
    @ApiModelProperty(value = "家庭情况")
    private String familySituation;
    
    /**
     * 是否展示(00展示 01不展示)
     */
    @NotNull(message = "是否展示(00展示 01不展示) 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, IsShowValidGroup.class})
    @Size(min=0, max=2, message="是否展示(00展示 01不展示) 字符长度必须小于等于2", groups = {PsiRetentionCluesEntityValidGroup.class, IsShowValidGroup.class})
    @ApiModelProperty(value = "是否展示(00展示 01不展示)")
    private String isShow;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiRetentionCluesEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiRetentionCluesEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiRetentionCluesEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiRetentionCluesEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiRetentionCluesEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;

    @ApiModelProperty(value = "意向交付地")
    private String deliveryPlace;
    
    public PsiRetentionCluesEntity() {
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public PsiRetentionCluesEntity(Long cluesId) {
        this.cluesId = cluesId;
    }

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }
    public Long getCluesId() {
        return this.cluesId;
    }
    

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }
    public Long getStorageId() {
        return this.storageId;
    }
    
    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
    public Long getStockId() {
        return this.stockId;
    }
    
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }
    public String getModelCode() {
        return this.modelCode;
    }
    
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getModelName() {
        return this.modelName;
    }
    
    public void setShapeCode(String shapeCode) {
        this.shapeCode = shapeCode;
    }
    public String getShapeCode() {
        return this.shapeCode;
    }
    
    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }
    public String getShapeName() {
        return this.shapeName;
    }
    
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
    public BigDecimal getSalePrice() {
        return this.salePrice;
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
    
    public void setRetentionTime(Date retentionTime) {
        this.retentionTime = retentionTime;
    }
    public Date getRetentionTime() {
        return this.retentionTime;
    }
    
    public void setFollowPerson(Long followPerson) {
        this.followPerson = followPerson;
    }
    public Long getFollowPerson() {
        return this.followPerson;
    }
    
    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
    public Date getFollowTime() {
        return this.followTime;
    }
    
    public void setCluesSource(String cluesSource) {
        this.cluesSource = cluesSource;
    }
    public String getCluesSource() {
        return this.cluesSource;
    }
    
    public void setFollowStatus(String followStatus) {
        this.followStatus = followStatus;
    }
    public String getFollowStatus() {
        return this.followStatus;
    }
    
    public void setLastFollowTime(Date lastFollowTime) {
        this.lastFollowTime = lastFollowTime;
    }
    public Date getLastFollowTime() {
        return this.lastFollowTime;
    }
    
    public void setNextFollowTime(Date nextFollowTime) {
        this.nextFollowTime = nextFollowTime;
    }
    public Date getNextFollowTime() {
        return this.nextFollowTime;
    }
    
    public void setCustomerCharacter(String customerCharacter) {
        this.customerCharacter = customerCharacter;
    }
    public String getCustomerCharacter() {
        return this.customerCharacter;
    }
    
    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
    public String getPurchaseTime() {
        return this.purchaseTime;
    }
    
    public void setFamilySituation(String familySituation) {
        this.familySituation = familySituation;
    }
    public String getFamilySituation() {
        return this.familySituation;
    }
    
    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }
    public String getIsShow() {
        return this.isShow;
    }

    public Long getFollowStore() {
        return followStore;
    }

    public void setFollowStore(Long followStore) {
        this.followStore = followStore;
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
              (cluesId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                cluesId = RandomIDGennerator.get().generate();
    }

    public interface PsiRetentionCluesEntityValidGroup {}
    public interface CluesIdValidGroup {}
    public interface StorageIdValidGroup {}
    public interface StockIdValidGroup {}
    public interface CustomerIdValidGroup {}
    public interface ModelCodeValidGroup {}
    public interface ModelNameValidGroup {}
    public interface ShapeCodeValidGroup {}
    public interface ShapeNameValidGroup {}
    public interface SalePriceValidGroup {}
    public interface CustomerNameValidGroup {}
    public interface CustomerPhoneValidGroup {}
    public interface RetentionTimeValidGroup {}
    public interface FollowPersonValidGroup {}
    public interface CluesSourceValidGroup {}
    public interface FollowStatusValidGroup {}
    public interface CustomerCharacterValidGroup {}
    public interface PurchaseTimeValidGroup {}
    public interface FamilySituationValidGroup {}
    public interface IsShowValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            CluesIdValidGroup.class
            , StorageIdValidGroup.class
            , StockIdValidGroup.class
            , CustomerIdValidGroup.class
            , ModelCodeValidGroup.class
            , ModelNameValidGroup.class
            , ShapeCodeValidGroup.class
            , ShapeNameValidGroup.class
            , SalePriceValidGroup.class
            , CustomerNameValidGroup.class
            , CustomerPhoneValidGroup.class
            , RetentionTimeValidGroup.class
            , FollowPersonValidGroup.class
            , CluesSourceValidGroup.class
            , FollowStatusValidGroup.class
            , CustomerCharacterValidGroup.class
            , PurchaseTimeValidGroup.class
            , FamilySituationValidGroup.class
            , IsShowValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
