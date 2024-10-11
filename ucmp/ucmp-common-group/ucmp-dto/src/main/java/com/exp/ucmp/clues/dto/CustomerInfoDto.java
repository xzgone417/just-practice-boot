package com.exp.ucmp.clues.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author gubonai
 * @Description: 车辆基本信息
 * @date 2023/2/6 10:52
 */
@ApiModel(value = "CustomerInfoDto", description = "客户信息Dto")
public class CustomerInfoDto extends BaseModel {
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "客户id")
    private Long customerId;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "手机号")
    private String customerPhone;

    @ApiModelProperty(value = "客户性格")
    private String customerCharacter;

    @ApiModelProperty(value = "客户性格名称")
    private String customerCharacterName;

    @ApiModelProperty(value = "购车时间")
    private String purchaseTime;

    @ApiModelProperty(value = "购车时间名称")
    private String purchaseTimeName;

    @ApiModelProperty(value = "家庭情况")
    private String familySituation;

    @ApiModelProperty(value = "家庭情况")
    private String familySituationName;

    @ApiModelProperty("跟进人")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long followPerson;

    @ApiModelProperty("跟进人姓名")
    private String followPersonName;

    @ApiModelProperty(value = "上次跟进时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastFollowTime;

    @ApiModelProperty(value = "计划下次跟进时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date nextFollowTime;

    @ApiModelProperty(value = "意向交付地")
    private String deliveryPlace;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public String getCustomerCharacter() {
        return customerCharacter;
    }

    public void setCustomerCharacter(String customerCharacter) {
        this.customerCharacter = customerCharacter;
    }

    public String getCustomerCharacterName() {
        return customerCharacterName;
    }

    public void setCustomerCharacterName(String customerCharacterName) {
        this.customerCharacterName = customerCharacterName;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getPurchaseTimeName() {
        return purchaseTimeName;
    }

    public void setPurchaseTimeName(String purchaseTimeName) {
        this.purchaseTimeName = purchaseTimeName;
    }

    public String getFamilySituation() {
        return familySituation;
    }

    public void setFamilySituation(String familySituation) {
        this.familySituation = familySituation;
    }

    public String getFamilySituationName() {
        return familySituationName;
    }

    public void setFamilySituationName(String familySituationName) {
        this.familySituationName = familySituationName;
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

    public Date getLastFollowTime() {
        return lastFollowTime;
    }

    public void setLastFollowTime(Date lastFollowTime) {
        this.lastFollowTime = lastFollowTime;
    }

    public Date getNextFollowTime() {
        return nextFollowTime;
    }

    public void setNextFollowTime(Date nextFollowTime) {
        this.nextFollowTime = nextFollowTime;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }
}
