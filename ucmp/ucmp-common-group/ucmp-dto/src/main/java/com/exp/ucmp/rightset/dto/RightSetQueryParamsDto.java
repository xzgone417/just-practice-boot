package com.exp.ucmp.rightset.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author GeYiJiang
 * @Description: 权益活动列表查询参数
 * @date 2022/11/18 14:19
 */
@ApiModel(value = "RightSetQueryParamsDto", description = "权益活动列表查询参数")
public class RightSetQueryParamsDto extends PageDto {

        /**
         * 权益活动名称
         */
        @ApiModelProperty(value = "权益活动名称")
        private String campaignName;

        /**
         * 类型
         */
        @ApiModelProperty(value = "类型 置换:3102,官二销售:3103")
        private String campaignType;

        /**
         * 权益代码
         */
        @ApiModelProperty(value = "权益代码")
        private String campaignCode;

        /**
         * 开始时间
         */
        @ApiModelProperty(value = "开始时间")
        private String startDate;

        /**
         * 结束时间
         */
        @ApiModelProperty(value = "结束时间")
        private String endDate;
        
        private int flag;


    public RightSetQueryParamsDto() {
    }

    public RightSetQueryParamsDto(String campaignName, String campaignType, String campaignCode, String startDate, String endDate) {
        this.campaignName = campaignName;
        this.campaignType = campaignType;
        this.campaignCode = campaignCode;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * 获取
     * @return campaignName
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * 设置
     * @param campaignName
     */
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    /**
     * 获取
     * @return campaignType
     */
    public String getCampaignType() {
        return campaignType;
    }

    /**
     * 设置
     * @param campaignType
     */
    public void setCampaignType(String campaignType) {
        this.campaignType = campaignType;
    }

    /**
     * 获取
     * @return campaignCode
     */
    public String getCampaignCode() {
        return campaignCode;
    }

    /**
     * 设置
     * @param campaignCode
     */
    public void setCampaignCode(String campaignCode) {
        this.campaignCode = campaignCode;
    }

    /**
     * 获取
     * @return startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * 设置
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * 设置
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String toString() {
        return "RightSetQueryParamsDto{campaignName = " + campaignName + ", campaignType = " + campaignType + ", campaignCode = " + campaignCode + ", startDate = " + startDate + ", endDate = " + endDate + "}";
    }
}
