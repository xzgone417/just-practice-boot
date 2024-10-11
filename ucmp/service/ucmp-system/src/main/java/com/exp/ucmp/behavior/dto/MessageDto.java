package com.exp.ucmp.behavior.dto;

import java.util.Date;

import com.egrid.core.base.model.BaseModel;

public class MessageDto extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long messageId;
	Long userId;
	String behaviorType;
	String behaviorTarget;
	String behaviorTargetUrl;
	String behaviorEndpoint;
	String requestId;
	String queryParams;
	String bodyParams;
	String bodyResponse;
	Date responseTime;
	String behaviorTags;
	Date behaviorTime;
	String httpStatus;
	
	public MessageDto (Long messageId, Long userId, String behaviorType, String behaviorTarget, String behaviorTargetUrl, String behaviorEndpoint, String requestId, String queryParams, String bodyParams, String bodyResponse, Date responseTime, String behaviorTags, Date behaviorTime, String httpStatus) {
		this.messageId = messageId;
		this.userId = userId;
		this.behaviorType = behaviorType;
		this.behaviorTarget = behaviorTarget;
		this.behaviorTargetUrl = behaviorTargetUrl;
		this.behaviorEndpoint = behaviorEndpoint;
		this.requestId = requestId;
		this.queryParams = queryParams;
		this.bodyParams = bodyParams;
		this.bodyResponse = bodyResponse;
		this.responseTime = responseTime;
		this.behaviorTags = behaviorTags;
		this.behaviorTime = behaviorTime;
		this.httpStatus = httpStatus;
	}
	public MessageDto (Long messageId) {
		this.messageId = messageId;
	}
	
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getBehaviorType() {
		return behaviorType;
	}
	public void setBehaviorType(String behaviorType) {
		this.behaviorType = behaviorType;
	}
	public String getBehaviorTarget() {
		return behaviorTarget;
	}
	public void setBehaviorTarget(String behaviorTarget) {
		this.behaviorTarget = behaviorTarget;
	}
	public String getBehaviorTargetUrl() {
		return behaviorTargetUrl;
	}
	public void setBehaviorTargetUrl(String behaviorTargetUrl) {
		this.behaviorTargetUrl = behaviorTargetUrl;
	}
	public String getBehaviorEndpoint() {
		return behaviorEndpoint;
	}
	public void setBehaviorEndpoint(String behaviorEndpoint) {
		this.behaviorEndpoint = behaviorEndpoint;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getQueryParams() {
		return queryParams;
	}
	public void setQueryParams(String queryParams) {
		this.queryParams = queryParams;
	}
	public String getBodyParams() {
		return bodyParams;
	}
	public void setBodyParams(String bodyParams) {
		this.bodyParams = bodyParams;
	}
	public String getBodyResponse() {
		return bodyResponse;
	}
	public void setBodyResponse(String bodyResponse) {
		this.bodyResponse = bodyResponse;
	}
	public Date getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Date responseTime) {
		this.responseTime = responseTime;
	}
	public String getBehaviorTags() {
		return behaviorTags;
	}
	public void setBehaviorTags(String behaviorTags) {
		this.behaviorTags = behaviorTags;
	}
	public Date getBehaviorTime() {
		return behaviorTime;
	}
	public void setBehaviorTime(Date behaviorTime) {
		this.behaviorTime = behaviorTime;
	}
	public String getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
}
