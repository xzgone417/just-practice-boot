package com.exp.ucmp.clues.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>@ClassName: PsiCluesFollowRecordDto</p>
 * <p>@Description: 跟进记录Dto</p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/25 11:30<p>
 */

@ApiModel(value = "PsiCluesFollowRecordDto", description = "跟进记录Dto")
public class PsiCluesFollowRecordDto {
    /**
     * 跟进记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "跟进记录id")
    private Long followId;


    /**
     * 线索id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "线索id")
    private Long cluesId;

    /**
     * 跟进时间
     */
    @ApiModelProperty(value = "跟进时间")
    private Date followTime;

    /**
     * 跟进信息
     */
    @ApiModelProperty(value = "跟进信息")
    private String followInfo;

    /**
     * 上次跟进时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上次跟进时间")
    private Date lastFollowTime;

    /**
     * 跟进方式
     */
    @ApiModelProperty(value = "跟进方式")
    private String followType;

    /**
     * 是否到店(00不到店 01到店)
     */
    @ApiModelProperty(value = "是否到店(00不到店 01到店)")
    private String isArrival;

    /**
     * 跟进状态
     */
    @ApiModelProperty(value = "跟进状态")
    private String followStatus;

    /**
     * 跟进门店名称
     */
    @ApiModelProperty(value = "跟进门店名称")
    private String followStoreName;

    /**
     * 跟进人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "跟进人")
    private Long followPerson;

    /**
     * 跟进人
     */
    @ApiModelProperty(value = "跟进人名称")
    private String followPersonName;

    /**
     * 创建人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;

    /**
     * 更新人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

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

    public String getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(String followStatus) {
        this.followStatus = followStatus;
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

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getFollowStoreName() {
        return followStoreName;
    }

    public void setFollowStoreName(String followStoreName) {
        this.followStoreName = followStoreName;
    }
}
