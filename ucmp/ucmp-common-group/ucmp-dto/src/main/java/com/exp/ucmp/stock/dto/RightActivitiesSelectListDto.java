package com.exp.ucmp.stock.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RightActivitiesSelectListDto", description = "权益包选择列表Dto")
public class RightActivitiesSelectListDto {

    private static final long serialVersionUID = 1L;

    /**
     * 权益活动主键ID
     */
    @ApiModelProperty(value = "权益活动主键ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long rightId;


    /**
     * 权益包编号
     */
    @ApiModelProperty(value = "权益包编号")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long rightPackId;

    /**
     * 权益代码
     */
    @ApiModelProperty(value = "权益代码")
    private String campaignCode;

    /**
     * 权益活动名称
     */
    @ApiModelProperty(value = "权益活动名称")
    private String campaignName;


    public RightActivitiesSelectListDto() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getRightId() {
        return rightId;
    }

    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }

    public Long getRightPackId() {
        return rightPackId;
    }

    public void setRightPackId(Long rightPackId) {
        this.rightPackId = rightPackId;
    }

    public String getCampaignCode() {
        return campaignCode;
    }

    public void setCampaignCode(String campaignCode) {
        this.campaignCode = campaignCode;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
}
