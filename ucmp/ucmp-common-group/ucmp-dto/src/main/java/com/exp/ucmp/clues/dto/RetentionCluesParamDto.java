/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.clues.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@ApiModel(value = "RetentionCluesParamDto对象", description = "商城留资线索列表查询参数")
public class RetentionCluesParamDto extends PageDto {

    @ApiModelProperty(value = "姓名")
    private String customerName;

    @ApiModelProperty(value = "手机号")
    private String customerPhone;

    @ApiModelProperty(value = "留资日期(开始)")
    private String startRetentionTime;

    @ApiModelProperty(value = "留资日期(截止)")
    private String endRetentionTime;

    @ApiModelProperty(value = "归属仓储名称")
    private String storageName;

    @ApiModelProperty(value = "销售定价(最低价)")
    private BigDecimal startSalePrice;

    @ApiModelProperty(value = "销售定价(最高价)")
    private BigDecimal endSalePrice;

    @ApiModelProperty(value = "跟进状态")
    private String followStatus;

    @ApiModelProperty(value = "是否展示(后端使用)")
    private String isShow;

    @ApiModelProperty(value = "二手车主管授权（01：授权）")
    private String isEmpower;

    @ApiModelProperty(value = "门店ID")
    private List<Long> empowerStoreIds;

    @ApiModelProperty(value = "创建人ID")
    private Long empowerCreatedBy;

    @ApiModelProperty(value = "来源type=68")
    private String empowerCluesSource;

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
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

    public String getStartRetentionTime() {
        return startRetentionTime;
    }

    public void setStartRetentionTime(String startRetentionTime) {
        this.startRetentionTime = startRetentionTime;
    }

    public String getEndRetentionTime() {
        return endRetentionTime;
    }

    public void setEndRetentionTime(String endRetentionTime) {
        this.endRetentionTime = endRetentionTime;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public BigDecimal getStartSalePrice() {
        return startSalePrice;
    }

    public void setStartSalePrice(BigDecimal startSalePrice) {
        this.startSalePrice = startSalePrice;
    }

    public BigDecimal getEndSalePrice() {
        return endSalePrice;
    }

    public void setEndSalePrice(BigDecimal endSalePrice) {
        this.endSalePrice = endSalePrice;
    }

    public String getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(String followStatus) {
        this.followStatus = followStatus;
    }

    public String getIsEmpower() {
        return isEmpower;
    }

    public void setIsEmpower(String isEmpower) {
        this.isEmpower = isEmpower;
    }

    public List<Long> getEmpowerStoreIds() {
        return empowerStoreIds;
    }

    public void setEmpowerStoreIds(List<Long> empowerStoreIds) {
        this.empowerStoreIds = empowerStoreIds;
    }

    public Long getEmpowerCreatedBy() {
        return empowerCreatedBy;
    }

    public void setEmpowerCreatedBy(Long empowerCreatedBy) {
        this.empowerCreatedBy = empowerCreatedBy;
    }

    public String getEmpowerCluesSource() {
        return empowerCluesSource;
    }

    public void setEmpowerCluesSource(String empowerCluesSource) {
        this.empowerCluesSource = empowerCluesSource;
    }
}
