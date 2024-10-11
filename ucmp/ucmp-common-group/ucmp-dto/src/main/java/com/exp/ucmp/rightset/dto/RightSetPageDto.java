package com.exp.ucmp.rightset.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author GeYiJiang
 * @Description: 权益活动列表分页结果对象
 * @date 2022/11/18 14:19
 */
@ApiModel(value = "RightSetPageDto", description = "权益活动列表分页结果对象")
public class RightSetPageDto extends BaseModel {

    /**
     * 权益活动ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "权益活动ID")
    private Long rightId;

    /**
     * 权益包编号
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "权益包编号ID")
    private Long rightPackId;


    /**
     * 权益活动名称
     */
    @ApiModelProperty(value = "权益活动名称")
    private String campaignName;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型(3101置换，3102官二销售)")
    private String campaignType;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String campaignDescribe;

    /**
     * 权益代码
     */
    @ApiModelProperty(value = "权益代码")
    private String campaignCode;

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
     * 达成条件
     */
    @ApiModelProperty(value = "达成条件(3201置换审批已通过，3202官二销售已交付)")
    private String conditions;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private Date startDate;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private Date endDate;

    /**
     * 创建人姓名
     */
    @ApiModelProperty(value = "创建人姓名")
    private String createdPersonName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;

    /**
     * 权益发放人数
     */
    @ApiModelProperty(value = "权益发放人数")
    private Integer distributeCount;

    /**
     * 是否可用
     */
    @ApiModelProperty(value = "是否可用：00、不可用，01、可用")
    private String isEnable;

    public RightSetPageDto() {
    }

    public RightSetPageDto(Long rightId, Long rightPackId, String campaignName, String campaignType, String campaignDescribe, String campaignCode, String modelCode, String modelName, String shapeCode, String shapeName, String conditions, Date startDate, Date endDate, String createdPersonName, Date createdDate, Integer distributeCount, String isEnable) {
        this.rightId = rightId;
        this.rightPackId = rightPackId;
        this.campaignName = campaignName;
        this.campaignType = campaignType;
        this.campaignDescribe = campaignDescribe;
        this.campaignCode = campaignCode;
        this.modelCode = modelCode;
        this.modelName = modelName;
        this.shapeCode = shapeCode;
        this.shapeName = shapeName;
        this.conditions = conditions;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createdPersonName = createdPersonName;
        this.createdDate = createdDate;
        this.distributeCount = distributeCount;
        this.isEnable = isEnable;
    }

    /**
     * 获取
     * @return rightId
     */
    public Long getRightId() {
        return rightId;
    }

    /**
     * 设置
     * @param rightId
     */
    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }

    /**
     * 获取
     * @return rightPackId
     */
    public Long getRightPackId() {
        return rightPackId;
    }

    /**
     * 设置
     * @param rightPackId
     */
    public void setRightPackId(Long rightPackId) {
        this.rightPackId = rightPackId;
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
     * @return startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取
     * @return endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
     * @return createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取
     * @return distributeCount
     */
    public Integer getDistributeCount() {
        return distributeCount;
    }

    /**
     * 设置
     * @param distributeCount
     */
    public void setDistributeCount(Integer distributeCount) {
        this.distributeCount = distributeCount;
    }

    /**
     * 获取
     * @return isEnable
     */
    public String getIsEnable() {
        return isEnable;
    }

    /**
     * 设置
     * @param isEnable
     */
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String toString() {
        return "RightSetPageDto{rightId = " + rightId + ", rightPackId = " + rightPackId + ", campaignName = " + campaignName + ", campaignType = " + campaignType + ", campaignDescribe = " + campaignDescribe + ", campaignCode = " + campaignCode + ", modelCode = " + modelCode + ", modelName = " + modelName + ", shapeCode = " + shapeCode + ", shapeName = " + shapeName + ", conditions = " + conditions + ", startDate = " + startDate + ", endDate = " + endDate + ", createdPersonName = " + createdPersonName + ", createdDate = " + createdDate + ", distributeCount = " + distributeCount + ", isEnable = " + isEnable + "}";
    }
}
