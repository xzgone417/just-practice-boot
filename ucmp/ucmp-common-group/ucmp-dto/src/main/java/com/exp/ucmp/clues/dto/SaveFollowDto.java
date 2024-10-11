/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;


@ApiModel(value = "SaveFollowDto", description = "添加跟进参数")
public class SaveFollowDto {

    @ApiModelProperty(value = "线索id")
    private Long cluesId;

    @ApiModelProperty(value = "跟进时间")
    private Date followTime;

    @ApiModelProperty(value = "跟进信息")
    private String followInfo;

    @ApiModelProperty(value = "下次跟进时间")
    private Date lastFollowTime;

    @ApiModelProperty(value = "跟进方式(7701云电话7702企业微信7703面谈7704活动)")
    private String followType;

    @ApiModelProperty(value = "是否到店(00不到店 01到店)")
    private String isArrival;

    public Long getCluesId() {
        return cluesId;
    }

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public String getFollowInfo() {
        return followInfo;
    }

    public void setFollowInfo(String followInfo) {
        this.followInfo = followInfo;
    }

    public Date getLastFollowTime() {
        return lastFollowTime;
    }

    public void setLastFollowTime(Date lastFollowTime) {
        this.lastFollowTime = lastFollowTime;
    }

    public String getFollowType() {
        return followType;
    }

    public void setFollowType(String followType) {
        this.followType = followType;
    }

    public String getIsArrival() {
        return isArrival;
    }

    public void setIsArrival(String isArrival) {
        this.isArrival = isArrival;
    }
}
