package com.exp.ucmp.storeApp.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@ApiModel(value = "CarDealerMsgDto", description = "车商信息")
public class CarDealerMsgDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 主键/合作商标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键/合作商标识")
    private Long partnerId;




    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人")
    private String partnerChargePerson;

    /**
     * 负责人手机号
     */
    @ApiModelProperty(value = "负责人手机号")
    private String chargePersonIphone;

    /**
     * 密文负责人手机号
     */
    @ApiModelProperty(value = "密文负责人手机号")
    private String enChargePersonIphone;

    /**
     * 合作商名称
     */
    @ApiModelProperty(value = "合作商名称")
    private String partnerName;

    /**
     * 合作商简称
     */
    @ApiModelProperty(value = "合作商简称")
    private String partnerAbbreviation;

    @ApiModelProperty("所占分值")
    private Double partnerOrder;

    @ApiModelProperty("排名")
    private Integer partnerSort;

    /**
     * 接单时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "接单时间")
    private Date orderReceivingDate;


    /**
     * 估价时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "估价时间")
    private Date quoteEndDate;



    /**
     * 估价截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "估价截止时间")
    private Date quoteDeadline;



    /**
     * 估价
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "估价")
    private Long quoteEndPrice;



    /**
     * 车商状态 0901待接单   0902已接单   0909放弃接单   0911待报价  0912已报价  0918逾期未报价  0919放弃报价
     */
    @ApiModelProperty(value = "状态:0901待接单   0902已接单   0909放弃接单   0911待报价  0912已报价  0918逾期未报价  0919放弃报价")
    private String inquiryStatus;

    public CarDealerMsgDto() {
    }

    public CarDealerMsgDto(Long partnerId, String partnerChargePerson, String chargePersonIphone, String enChargePersonIphone, String partnerName, String partnerAbbreviation, Date orderReceivingDate, Date quoteEndDate, Date quoteDeadline, Long quoteEndPrice, String inquiryStatus) {
        this.partnerId = partnerId;
        this.partnerChargePerson = partnerChargePerson;
        this.chargePersonIphone = chargePersonIphone;
        this.enChargePersonIphone = enChargePersonIphone;
        this.partnerName = partnerName;
        this.partnerAbbreviation = partnerAbbreviation;
        this.orderReceivingDate = orderReceivingDate;
        this.quoteEndDate = quoteEndDate;
        this.quoteDeadline = quoteDeadline;
        this.quoteEndPrice = quoteEndPrice;
        this.inquiryStatus = inquiryStatus;
    }

    /**
     * 获取
     * @return partnerId
     */
    public Long getPartnerId() {
        return partnerId;
    }

    /**
     * 设置
     * @param partnerId
     */
    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    /**
     * 获取
     * @return partnerChargePerson
     */
    public String getPartnerChargePerson() {
        return partnerChargePerson;
    }

    /**
     * 设置
     * @param partnerChargePerson
     */
    public void setPartnerChargePerson(String partnerChargePerson) {
        this.partnerChargePerson = partnerChargePerson;
    }

    /**
     * 获取
     * @return chargePersonIphone
     */
    public String getChargePersonIphone() {
        return chargePersonIphone;
    }

    /**
     * 设置
     * @param chargePersonIphone
     */
    public void setChargePersonIphone(String chargePersonIphone) {
        this.chargePersonIphone = chargePersonIphone;
    }

    /**
     * 获取
     * @return partnerName
     */
    public String getPartnerName() {
        return partnerName;
    }

    /**
     * 设置
     * @param partnerName
     */
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    /**
     * 获取
     * @return partnerAbbreviation
     */
    public String getPartnerAbbreviation() {
        return partnerAbbreviation;
    }

    /**
     * 设置
     * @param partnerAbbreviation
     */
    public void setPartnerAbbreviation(String partnerAbbreviation) {
        this.partnerAbbreviation = partnerAbbreviation;
    }

    /**
     * 获取
     * @return orderReceivingDate
     */
    public Date getOrderReceivingDate() {
        return orderReceivingDate;
    }

    /**
     * 设置
     * @param orderReceivingDate
     */
    public void setOrderReceivingDate(Date orderReceivingDate) {
        this.orderReceivingDate = orderReceivingDate;
    }

    /**
     * 获取
     * @return quoteEndDate
     */
    public Date getQuoteEndDate() {
        return quoteEndDate;
    }

    /**
     * 设置
     * @param quoteEndDate
     */
    public void setQuoteEndDate(Date quoteEndDate) {
        this.quoteEndDate = quoteEndDate;
    }

    public Double getPartnerOrder() {
        return partnerOrder;
    }

    public void setPartnerOrder(Double partnerOrder) {
        this.partnerOrder = partnerOrder;
    }

    public Integer getPartnerSort() {
        return partnerSort;
    }

    public void setPartnerSort(Integer partnerSort) {
        this.partnerSort = partnerSort;
    }

    /**
     * 获取
     * @return quoteDeadline
     */
    public Date getQuoteDeadline() {
        return quoteDeadline;
    }

    /**
     * 设置
     * @param quoteDeadline
     */
    public void setQuoteDeadline(Date quoteDeadline) {
        this.quoteDeadline = quoteDeadline;
    }

    /**
     * 获取
     * @return quoteEndPrice
     */
    public Long getQuoteEndPrice() {
        return quoteEndPrice;
    }

    /**
     * 设置
     * @param quoteEndPrice
     */
    public void setQuoteEndPrice(Long quoteEndPrice) {
        this.quoteEndPrice = quoteEndPrice;
    }

    /**
     * 获取
     * @return inquiryStatus
     */
    public String getInquiryStatus() {
        return inquiryStatus;
    }

    /**
     * 设置
     * @param inquiryStatus
     */
    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    public String toString() {
        return "CarDealerMsgDto{" + "partnerId = " + partnerId + ", partnerChargePerson = " + partnerChargePerson + ", chargePersonIphone = " + chargePersonIphone + ", partnerName = " + partnerName + ", partnerAbbreviation = " + partnerAbbreviation + ", orderReceivingDate = " + orderReceivingDate + ", quoteEndDate = " + quoteEndDate + ", quoteDeadline = " + quoteDeadline + ", quoteEndPrice = " + quoteEndPrice + ", inquiryStatus = " + inquiryStatus + "}";
    }

    /**
     * 获取
     * @return enChargePersonIphone
     */
    public String getEnChargePersonIphone() {
        return enChargePersonIphone;
    }

    /**
     * 设置
     * @param enChargePersonIphone
     */
    public void setEnChargePersonIphone(String enChargePersonIphone) {
        this.enChargePersonIphone = enChargePersonIphone;
    }
}
