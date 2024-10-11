package com.exp.ucmp.rightset.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;


/**
 * @author GeYiJiang
 * @Description: 权益活动设置入参
 * @date 2022/11/21 14:19
 */
@ApiModel(value = "RightSetSaveDto", description = "权益活动设置入参")
public class RightSetSaveDto extends BaseModel {

    /**
     * 权益活动名称
     */
    @ApiModelProperty(value = "权益活动名称")
    private String campaignName;

    /**
     * 权益活动代码
     */
    @ApiModelProperty(value = "权益活动代码")
    private String campaignCode;

    /**
     * 创建人姓名
     */
    @ApiModelProperty(value = "创建人姓名")
    private String createdPersonName;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private String campaignType;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String campaignDescribe;

    /**
     * 工程车型代码
     */
    @ApiModelProperty(value = "工程车型代码")
    private String modelCode;

    /**
     * 工程车型名称
     */
    @ApiModelProperty(value = "工程车型名称")
    private String modelName;

    /**
     * 基本车型代码
     */
    @ApiModelProperty(value = "基本车型代码")
    private String shapeCode;

    /**
     * 基本车型名称
     */
    @ApiModelProperty(value = "基本车型名称")
    private String shapeName;

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

    /**
     * 达成条件
     */
    @ApiModelProperty(value = "达成条件(3201置换审批已通过，3202官二销售已交付)")
    private String conditions;

    /**
     * 权益对象列表
     */
    @ApiModelProperty(value = "权益对象列表")
    private List<RightSetDetailSaveDto> detailList;

    public RightSetSaveDto() {
    }

    public RightSetSaveDto(String campaignName, String campaignCode, String createdPersonName, String campaignType, String campaignDescribe, String modelCode, String modelName, String shapeCode, String shapeName, String startDate, String endDate, String conditions, List<RightSetDetailSaveDto> detailList) {
        this.campaignName = campaignName;
        this.campaignCode = campaignCode;
        this.createdPersonName = createdPersonName;
        this.campaignType = campaignType;
        this.campaignDescribe = campaignDescribe;
        this.modelCode = modelCode;
        this.modelName = modelName;
        this.shapeCode = shapeCode;
        this.shapeName = shapeName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.conditions = conditions;
        this.detailList = detailList;
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
     * @return createdPersonName
     */
    public String getCreatedPersonName() {
        return createdPersonName;
    }

    /**
     * 设置
     * @param createdPersonName
     */
    public void setCreatedPersonName(String createdPersonName) {
        this.createdPersonName = createdPersonName;
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
     * @return campaignDescribe
     */
    public String getCampaignDescribe() {
        return campaignDescribe;
    }

    /**
     * 设置
     * @param campaignDescribe
     */
    public void setCampaignDescribe(String campaignDescribe) {
        this.campaignDescribe = campaignDescribe;
    }

    /**
     * 获取
     * @return modelCode
     */
    public String getModelCode() {
        return modelCode;
    }

    /**
     * 设置
     * @param modelCode
     */
    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    /**
     * 获取
     * @return modelName
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 设置
     * @param modelName
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * 获取
     * @return shapeCode
     */
    public String getShapeCode() {
        return shapeCode;
    }

    /**
     * 设置
     * @param shapeCode
     */
    public void setShapeCode(String shapeCode) {
        this.shapeCode = shapeCode;
    }

    /**
     * 获取
     * @return shapeName
     */
    public String getShapeName() {
        return shapeName;
    }

    /**
     * 设置
     * @param shapeName
     */
    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
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

    /**
     * 获取
     * @return conditions
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * 设置
     * @param conditions
     */
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    /**
     * 获取
     * @return detailList
     */
    public List<RightSetDetailSaveDto> getDetailList() {
        return detailList;
    }

    /**
     * 设置
     * @param detailList
     */
    public void setDetailList(List<RightSetDetailSaveDto> detailList) {
        this.detailList = detailList;
    }

    public String toString() {
        return "RightSetSaveDto{campaignName = " + campaignName + ", campaignCode = " + campaignCode + ", createdPersonName = " + createdPersonName + ", campaignType = " + campaignType + ", campaignDescribe = " + campaignDescribe + ", modelCode = " + modelCode + ", modelName = " + modelName + ", shapeCode = " + shapeCode + ", shapeName = " + shapeName + ", startDate = " + startDate + ", endDate = " + endDate + ", conditions = " + conditions + ", detailList = " + detailList + "}";
    }
}
