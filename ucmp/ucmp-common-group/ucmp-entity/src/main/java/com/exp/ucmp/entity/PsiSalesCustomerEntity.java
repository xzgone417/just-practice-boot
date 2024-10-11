package com.exp.ucmp.entity;

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

@ApiModel(value = "PsiSalesCustomerEntity", description = "销售客户表")
@GroupSequence({PsiSalesCustomerEntity.class, PsiSalesCustomerEntity.PsiSalesCustomerEntityValidGroup.class,PsiSalesCustomerEntity.CustomerIdValidGroup.class,PsiSalesCustomerEntity.UidValidGroup.class,PsiSalesCustomerEntity.StoreIdValidGroup.class,PsiSalesCustomerEntity.PartyIdValidGroup.class,PsiSalesCustomerEntity.CustomerNameValidGroup.class,PsiSalesCustomerEntity.CustomerPhoneValidGroup.class,PsiSalesCustomerEntity.ModelCodeValidGroup.class,PsiSalesCustomerEntity.ModelNameValidGroup.class,PsiSalesCustomerEntity.DeliveryPlaceValidGroup.class,PsiSalesCustomerEntity.VinValidGroup.class,PsiSalesCustomerEntity.FollowByValidGroup.class,PsiSalesCustomerEntity.CustomerCharacterValidGroup.class,PsiSalesCustomerEntity.PurchaseTimeValidGroup.class,PsiSalesCustomerEntity.FamilyValidGroup.class,PsiSalesCustomerEntity.CreatedByValidGroup.class,PsiSalesCustomerEntity.CreatedDateValidGroup.class,PsiSalesCustomerEntity.UpdatedByValidGroup.class,PsiSalesCustomerEntity.UpdatedDateValidGroup.class}) 
public class PsiSalesCustomerEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 客户id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "客户id 不能是Null", groups = {PsiSalesCustomerEntityValidGroup.class, CustomerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="客户id 数字精度必须符合(19,0)", groups = {PsiSalesCustomerEntityValidGroup.class, CustomerIdValidGroup.class})
    @ApiModelProperty(value = "客户id")
    private Long customerId;
    
    
    /**
     * UID
     */
    @Size(min=0, max=50, message="UID 字符长度必须小于等于50", groups = {PsiSalesCustomerEntityValidGroup.class, UidValidGroup.class})
    @ApiModelProperty(value = "UID")
    private String uid;
    
    /**
     * 客户门店ID
     */
    @NotNull(message = "客户门店ID 不能是Null", groups = {PsiSalesCustomerEntityValidGroup.class, StoreIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="客户门店ID 数字精度必须符合(19,0)", groups = {PsiSalesCustomerEntityValidGroup.class, StoreIdValidGroup.class})
    @ApiModelProperty(value = "客户门店ID")
    private Long storeId;
    
    /**
     * 客户跟进人
     */
    @NotNull(message = "客户跟进人 不能是Null", groups = {PsiSalesCustomerEntityValidGroup.class, PartyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="客户跟进人 数字精度必须符合(19,0)", groups = {PsiSalesCustomerEntityValidGroup.class, PartyIdValidGroup.class})
    @ApiModelProperty(value = "客户跟进人")
    private Long partyId;
    
    /**
     * 客户姓名
     */
    @NotNull(message = "客户姓名 不能是Null", groups = {PsiSalesCustomerEntityValidGroup.class, CustomerNameValidGroup.class})
    @Size(min=0, max=20, message="客户姓名 字符长度必须小于等于20", groups = {PsiSalesCustomerEntityValidGroup.class, CustomerNameValidGroup.class})
    @ApiModelProperty(value = "客户姓名")
    private String customerName;
    
    /**
     * 客户手机号
     */
    @NotNull(message = "客户手机号 不能是Null", groups = {PsiSalesCustomerEntityValidGroup.class, CustomerPhoneValidGroup.class})
    @Size(min=0, max=100, message="客户手机号 字符长度必须小于等于100", groups = {PsiSalesCustomerEntityValidGroup.class, CustomerPhoneValidGroup.class})
    @ApiModelProperty(value = "客户手机号")
    private String customerPhone;
    
    /**
     * 意向车型代码
     */
    @Size(min=0, max=10, message="意向车型代码 字符长度必须小于等于10", groups = {PsiSalesCustomerEntityValidGroup.class, ModelCodeValidGroup.class})
    @ApiModelProperty(value = "意向车型代码")
    private String modelCode;
    
    /**
     * 意向车型名称
     */
    @Size(min=0, max=50, message="意向车型名称 字符长度必须小于等于50", groups = {PsiSalesCustomerEntityValidGroup.class, ModelNameValidGroup.class})
    @ApiModelProperty(value = "意向车型名称")
    private String modelName;
    
    /**
     * 意向交付地
     */
    @NotNull(message = "意向交付地 不能是Null", groups = {PsiSalesCustomerEntityValidGroup.class, DeliveryPlaceValidGroup.class})
    @Size(min=0, max=200, message="意向交付地 字符长度必须小于等于200", groups = {PsiSalesCustomerEntityValidGroup.class, DeliveryPlaceValidGroup.class})
    @ApiModelProperty(value = "意向交付地")
    private String deliveryPlace;
    
    /**
     * 意向VIN
     */
    @Size(min=0, max=20, message="意向VIN 字符长度必须小于等于20", groups = {PsiSalesCustomerEntityValidGroup.class, VinValidGroup.class})
    @ApiModelProperty(value = "意向VIN")
    private String vin;
    
    /**
     * 上次跟进时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上次跟进时间")
    private Date followTime;
    
    /**
     * 上次跟人
     */
    @Digits(integer=19, fraction=0, message="上次跟人 数字精度必须符合(19,0)", groups = {PsiSalesCustomerEntityValidGroup.class, FollowByValidGroup.class})
    @ApiModelProperty(value = "上次跟人")
    private Long followBy;
    
    /**
     * 上次跟人姓名
     */
    @ApiModelProperty(value = "上次跟人姓名")
    private String followName;
    
    /**
     * 客户性格(00外向 01内向)
     */
    @Size(min=0, max=2, message="客户性格(00外向 01内向) 字符长度必须小于等于2", groups = {PsiSalesCustomerEntityValidGroup.class, CustomerCharacterValidGroup.class})
    @ApiModelProperty(value = "客户性格(00外向 01内向)")
    private String customerCharacter;
    
    /**
     * 购车时间
     */
    @Size(min=0, max=4, message="购车时间 字符长度必须小于等于4", groups = {PsiSalesCustomerEntityValidGroup.class, PurchaseTimeValidGroup.class})
    @ApiModelProperty(value = "购车时间")
    private String purchaseTime;
    
    /**
     * 家庭情况
     */
    @Size(min=0, max=4, message="家庭情况 字符长度必须小于等于4", groups = {PsiSalesCustomerEntityValidGroup.class, FamilyValidGroup.class})
    @ApiModelProperty(value = "家庭情况")
    private String family;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiSalesCustomerEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiSalesCustomerEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiSalesCustomerEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiSalesCustomerEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiSalesCustomerEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiSalesCustomerEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PsiSalesCustomerEntity() {
    }
    
    public PsiSalesCustomerEntity(Long customerId) {
        this.customerId = customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return this.customerId;
    }
    

    public void setUid(String uid) {
        this.uid = uid;
    }
    public String getUid() {
        return this.uid;
    }
    
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Long getStoreId() {
        return this.storeId;
    }
    
    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
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
    
    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }
    public String getDeliveryPlace() {
        return this.deliveryPlace;
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }
    public String getVin() {
        return this.vin;
    }
    
    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
    public Date getFollowTime() {
        return this.followTime;
    }
    
    public void setFollowBy(Long followBy) {
        this.followBy = followBy;
    }
    public Long getFollowBy() {
        return this.followBy;
    }
    
    public void setFollowName(String followName) {
        this.followName = followName;
    }
    public String getFollowName() {
        return this.followName;
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
    
    public void setFamily(String family) {
        this.family = family;
    }
    public String getFamily() {
        return this.family;
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
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (customerId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                customerId = RandomIDGennerator.get().generate();
    }

    public interface PsiSalesCustomerEntityValidGroup {}
    public interface CustomerIdValidGroup {}
    public interface UidValidGroup {}
    public interface StoreIdValidGroup {}
    public interface PartyIdValidGroup {}
    public interface CustomerNameValidGroup {}
    public interface CustomerPhoneValidGroup {}
    public interface ModelCodeValidGroup {}
    public interface ModelNameValidGroup {}
    public interface DeliveryPlaceValidGroup {}
    public interface VinValidGroup {}
    public interface FollowByValidGroup {}
    public interface CustomerCharacterValidGroup {}
    public interface PurchaseTimeValidGroup {}
    public interface FamilyValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            CustomerIdValidGroup.class
            , UidValidGroup.class
            , StoreIdValidGroup.class
            , PartyIdValidGroup.class
            , CustomerNameValidGroup.class
            , CustomerPhoneValidGroup.class
            , ModelCodeValidGroup.class
            , ModelNameValidGroup.class
            , DeliveryPlaceValidGroup.class
            , VinValidGroup.class
            , FollowByValidGroup.class
            , CustomerCharacterValidGroup.class
            , PurchaseTimeValidGroup.class
            , FamilyValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
