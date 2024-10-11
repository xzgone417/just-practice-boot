package com.exp.ucmp.behavior.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @创建人 admin
 * @创建时间 2020-12-01 16:31
 * @描述
 */
public class BehaviorDto {
	@ApiModelProperty("登录用户ID")
	Long partyId;
	@ApiModelProperty("请求ID")
	String requestId;
	@ApiModelProperty("行为类型:01、系统行为，02、进联盟行为")
	String behaviorType;
	@ApiModelProperty("目标：如果是系统行为，固定为system，如果是进联盟行为，为绑定类型如ele、jd�?")
	String behaviorTarget;
	@ApiModelProperty("目标URL")
	String behaviorTargetUrl;
	@ApiModelProperty("Query参数")
	String queryParams;
	@ApiModelProperty("请求体参数")
	String bodyParams;
	@ApiModelProperty("响应结果")
	String bodyResponse;
	@ApiModelProperty("标签参数，登记的标签格式[{\"tag01\":\"value01\"},{\"tag02\":\"value02\"},{\"tag03\":\"value03\"}]")
	String behaviorTags;
	@ApiModelProperty("目标终端设备")
	private String behaviorEndpoint;
	@ApiModelProperty("响应的http状态")
	private String httpStatus = "200";

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
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

	public String getBehaviorTags() {
		return behaviorTags;
	}

	public void setBehaviorTags(String behaviorTags) {
		this.behaviorTags = behaviorTags;
	}

	public String getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
}
