package com.exp.ucmp.clues.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author gubonai
 * @Description: 订单跟进记录
 * @date 2023/2/6 10:52
 */
@ApiModel(value = "OrderCluesFollowRecordDto", description = "订单跟进记录Dto")
public class OrderCluesFollowRecordDto extends BaseModel {

    @ApiModelProperty(value = "跟进记录id")
    private Long orderFollowId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "跟进时间")
    private Date followTime;

    @ApiModelProperty(value = "跟进信息")
    private String followInfo;

    public Long getOrderFollowId() {
        return orderFollowId;
    }

    public void setOrderFollowId(Long orderFollowId) {
        this.orderFollowId = orderFollowId;
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
}
