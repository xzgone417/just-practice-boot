package com.exp.ucmp.huawei.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RelationNumDto", description = "X号码绑定关系列表")
public class RelationNumDto {
	
	@ApiModelProperty(value = "绑定关系保持时间，单位为秒，0表示永不过期")
	private Integer duration;
	
	@ApiModelProperty(value = "AXB中的A号码")
	private String callerNum;
	
	@ApiModelProperty(value = "设置或者最近一次修改该绑定关系的时间")
	private String subscribeTime;
	
	@ApiModelProperty(value = "表示该绑定关系允许的呼叫方向")
	private Integer callDirection;
	
	@ApiModelProperty(value = "录音标识")
	private String recordFlag;
	
	@ApiModelProperty(value = "AXB中的X号码")
	private String relationNum;
	
	@ApiModelProperty(value = "AXB中的B号码")
	private String calleeNum;
	
	@ApiModelProperty(value = "绑定ID")
	private String subscriptionId;
	
	@ApiModelProperty(value = "允许单次通话进行的最长时间")
	private Integer maxDuration;

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getCallerNum() {
		return callerNum;
	}

	public void setCallerNum(String callerNum) {
		this.callerNum = callerNum;
	}

	public String getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(String subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public Integer getCallDirection() {
		return callDirection;
	}

	public void setCallDirection(Integer callDirection) {
		this.callDirection = callDirection;
	}

	public String getRecordFlag() {
		return recordFlag;
	}

	public void setRecordFlag(String recordFlag) {
		this.recordFlag = recordFlag;
	}

	public String getRelationNum() {
		return relationNum;
	}

	public void setRelationNum(String relationNum) {
		this.relationNum = relationNum;
	}

	public String getCalleeNum() {
		return calleeNum;
	}

	public void setCalleeNum(String calleeNum) {
		this.calleeNum = calleeNum;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public Integer getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(Integer maxDuration) {
		this.maxDuration = maxDuration;
	}
	
}
