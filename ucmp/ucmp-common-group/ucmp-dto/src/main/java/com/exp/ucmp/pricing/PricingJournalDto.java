/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.pricing;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


@ApiModel(value = "PricingJournalDto", description = "定价日志信息")
public class PricingJournalDto {
    @ApiModelProperty(value = "定价日志表id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long journalId;

    @ApiModelProperty(value = "定价金额")
    private BigDecimal pricingAmount;

    @ApiModelProperty(value = "操作人名称")
    private String createName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "修改定价时间")
    private Date createDate;

    @ApiModelProperty(value = "操作人id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long createBy;

    public Long getJournalId() {
        return journalId;
    }

    public void setJournalId(Long journalId) {
        this.journalId = journalId;
    }

    public BigDecimal getPricingAmount() {
        return pricingAmount;
    }

    public void setPricingAmount(BigDecimal pricingAmount) {
        this.pricingAmount = pricingAmount;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
}
