package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * <p>@ClassName: PsiRetentionCluesParamDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/25 17:09<p>
 */
public class PsiRetentionCluesParamDto {

    @ApiModelProperty(value = "线索留资日期")
    private Date retentionTime;


    @ApiModelProperty(value = "更新日期")
    private Date updatedDate;

    @ApiModelProperty(value = "是否分配门店（未分配跟进门店：01，已分配跟进门店:00）")
    private String isEmptyFollowStore;

    @ApiModelProperty(value = "是否分配到人（未分配跟进人：01，已分配跟进人:00）")
    private String isEmptyFollowPerson;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "跟进日期")
    private Date followTime;

    @ApiModelProperty(value = "跟进状态")
    private List<String> followStatusList;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上次跟进时间")
    private Date lastFollowTime;

    public Date getRetentionTime() {
        return retentionTime;
    }

    public void setRetentionTime(Date retentionTime) {
        this.retentionTime = retentionTime;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getIsEmptyFollowStore() {
        return isEmptyFollowStore;
    }

    public void setIsEmptyFollowStore(String isEmptyFollowStore) {
        this.isEmptyFollowStore = isEmptyFollowStore;
    }

    public String getIsEmptyFollowPerson() {
        return isEmptyFollowPerson;
    }

    public void setIsEmptyFollowPerson(String isEmptyFollowPerson) {
        this.isEmptyFollowPerson = isEmptyFollowPerson;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public List<String> getFollowStatusList() {
        return followStatusList;
    }

    public void setFollowStatusList(List<String> followStatusList) {
        this.followStatusList = followStatusList;
    }

    public Date getLastFollowTime() {
        return lastFollowTime;
    }

    public void setLastFollowTime(Date lastFollowTime) {
        this.lastFollowTime = lastFollowTime;
    }
}
