package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/24 13:38
 */
@ApiModel(value = "HomePageStatus", description = "首页状态统计对象")
public class HomePageStatus extends BaseModel {

    @ApiModelProperty("待接单数")
    private Integer notReceived;

    @ApiModelProperty("待收购数")
    private Integer pendingAcquisitions;

    @ApiModelProperty("待报价数")
    private Integer negotiations;

    @ApiModelProperty("待过户数")
    private Integer notTransferred;

    public HomePageStatus() {
    }

    public HomePageStatus(Integer notReceived, Integer pendingAcquisitions, Integer negotiations, Integer notTransferred) {
        this.notReceived = notReceived;
        this.pendingAcquisitions = pendingAcquisitions;
        this.negotiations = negotiations;
        this.notTransferred = notTransferred;
    }

    /**
     * 获取
     * @return notReceived
     */
    public Integer getNotReceived() {
        return notReceived;
    }

    /**
     * 设置
     * @param notReceived
     */
    public void setNotReceived(Integer notReceived) {
        this.notReceived = notReceived;
    }

    /**
     * 获取
     * @return pendingAcquisitions
     */
    public Integer getPendingAcquisitions() {
        return pendingAcquisitions;
    }

    /**
     * 设置
     * @param pendingAcquisitions
     */
    public void setPendingAcquisitions(Integer pendingAcquisitions) {
        this.pendingAcquisitions = pendingAcquisitions;
    }

    /**
     * 获取
     * @return negotiations
     */
    public Integer getNegotiations() {
        return negotiations;
    }

    /**
     * 设置
     * @param negotiations
     */
    public void setNegotiations(Integer negotiations) {
        this.negotiations = negotiations;
    }

    /**
     * 获取
     * @return notTransferred
     */
    public Integer getNotTransferred() {
        return notTransferred;
    }

    /**
     * 设置
     * @param notTransferred
     */
    public void setNotTransferred(Integer notTransferred) {
        this.notTransferred = notTransferred;
    }

    public String toString() {
        return "HomePageStatus{notReceived = " + notReceived + ", pendingAcquisitions = " + pendingAcquisitions + ", negotiations = " + negotiations + ", notTransferred = " + notTransferred + "}";
    }
}
