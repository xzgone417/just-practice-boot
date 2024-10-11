package com.exp.ucmp.clues.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author gubonai
 * @Description: 订单信息
 * @date 2023/2/6 10:52
 */
@ApiModel(value = "OrderInfoDto", description = "订单信息Dto")
public class OrderInfoDto extends BaseModel {

    private static final long serialVersionUID = -5912489984574795138L;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "订单id")
    private Long orderInfoId;

    @ApiModelProperty(value = "订单编号")
    private String orderNo;

    @ApiModelProperty(value = "下定时间")
    private Date intentionPayTime;

    @ApiModelProperty(value = "vin")
    private String vin;
    
    @ApiModelProperty(value = "商品编号")
    private String productCode;

    @ApiModelProperty(value = "订单价格（销售价格）")
    private BigDecimal orderPrice;

    @ApiModelProperty(value = "'客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户手机号")
    private String customerPhone;

    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;


    @ApiModelProperty(value = "销售门店")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long salesStore;

    @ApiModelProperty(value = "销售门店名称")
    private String salesStoreName;

    @ApiModelProperty(value = "出行顾问")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long followPerson;

    @ApiModelProperty(value = "出行顾问名称")
    private String followPersonName;

    @ApiModelProperty(value = "交付门店")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long deliveryStore;

    @ApiModelProperty(value = "交付门店名称")
    private String deliveryStoreName;

    @ApiModelProperty(value = "交付顾问")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long deliveryPerson;

    @ApiModelProperty(value = "交付顾问名称")
    private String deliveryPersonName;

    @ApiModelProperty(value = "车辆仓库编码")
    private String storageCode;

    @ApiModelProperty(value = "车辆仓库名称")
    private String storageName;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "交付中心ID")
    private Long deliveryStorageId;

    @ApiModelProperty(value = "交付中心名称")
    private String deliveryStorageName;

    @ApiModelProperty(value = "订单状态")
    private String orderStatus;

    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;

    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private Date createdDate;

    /**
     * 车主身份证
     */
    @ApiModelProperty(value = "车主身份证")
    private String ownerCardNo;


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

    @ApiModelProperty(value = "发放权益(1.权益发放 2权益不发放)")
    private String legalRight;


    @ApiModelProperty(value = "权益活动编号")
    private Long rightPackId;
    
    @ApiModelProperty(value = "审批状态 0 待审批 1 审批通过 2 审批驳回")
    private Integer approveStatus;
    
    @ApiModelProperty(value = "审批状态 0 待审批 1 审批通过 2 审批驳回")
    private String approveStatusName;

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getBaseCarTypeName() {
        return baseCarTypeName;
    }

    public void setBaseCarTypeName(String baseCarTypeName) {
        this.baseCarTypeName = baseCarTypeName;
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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    public Long getFollowPerson() {
        return followPerson;
    }

    public void setFollowPerson(Long followPerson) {
        this.followPerson = followPerson;
    }

    public Long getDeliveryStore() {
        return deliveryStore;
    }

    public void setDeliveryStore(Long deliveryStore) {
        this.deliveryStore = deliveryStore;
    }

    public Date getIntentionPayTime() {
        return intentionPayTime;
    }

    public void setIntentionPayTime(Date intentionPayTime) {
        this.intentionPayTime = intentionPayTime;
    }

    public String getFollowPersonName() {
        return followPersonName;
    }

    public void setFollowPersonName(String followPersonName) {
        this.followPersonName = followPersonName;
    }

    public String getDeliveryStoreName() {
        return deliveryStoreName;
    }

    public void setDeliveryStoreName(String deliveryStoreName) {
        this.deliveryStoreName = deliveryStoreName;
    }

    public String getDeliveryPersonName() {
        return deliveryPersonName;
    }

    public void setDeliveryPersonName(String deliveryPersonName) {
        this.deliveryPersonName = deliveryPersonName;
    }

    public Long getDeliveryPerson() {
        return deliveryPerson;
    }

    public void setDeliveryPerson(Long deliveryPerson) {
        this.deliveryPerson = deliveryPerson;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getCarSeriesName() {
        return carSeriesName;
    }

    public void setCarSeriesName(String carSeriesName) {
        this.carSeriesName = carSeriesName;
    }

    public String getOwnerCardNo() {
        return ownerCardNo;
    }

    public void setOwnerCardNo(String ownerCardNo) {
        this.ownerCardNo = ownerCardNo;
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

    public Long getDeliveryStorageId() {
        return deliveryStorageId;
    }

    public void setDeliveryStorageId(Long deliveryStorageId) {
        this.deliveryStorageId = deliveryStorageId;
    }

    public String getDeliveryStorageName() {
        return deliveryStorageName;
    }

    public void setDeliveryStorageName(String deliveryStorageName) {
        this.deliveryStorageName = deliveryStorageName;
    }

    public String getLegalRight() {
        return legalRight;
    }

    public void setLegalRight(String legalRight) {
        this.legalRight = legalRight;
    }

    public Long getRightPackId() {
        return rightPackId;
    }

    public void setRightPackId(Long rightPackId) {
        this.rightPackId = rightPackId;
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

	public Integer getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Integer approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getApproveStatusName() {
		return approveStatusName;
	}

	public void setApproveStatusName(String approveStatusName) {
		this.approveStatusName = approveStatusName;
	}
}
