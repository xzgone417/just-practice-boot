package com.exp.ucmp.usc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EvaluateCategoryDto", description = "评价问卷类")
public class EvaluateCategoryDto {
	
	@ApiModelProperty(value = "业务类别")
	private String categoryCode;
	
	@ApiModelProperty(value = "渠道CODE")
    private String channelCode;
	
	@ApiModelProperty(value = "创建时间")
    private long createTime;
	
	private String evaluateCategoryId;
    private String channelName;
    private int status;
    private long updateTime;
    private boolean deleted;
    private int maxLevel;
    private String batchNo;
    private int editStatus;
    private int feedbackStatus;

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getEvaluateCategoryId() {
		return evaluateCategoryId;
	}

	public void setEvaluateCategoryId(String evaluateCategoryId) {
		this.evaluateCategoryId = evaluateCategoryId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public int getEditStatus() {
		return editStatus;
	}

	public void setEditStatus(int editStatus) {
		this.editStatus = editStatus;
	}

	public int getFeedbackStatus() {
		return feedbackStatus;
	}

	public void setFeedbackStatus(int feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}
	
}
