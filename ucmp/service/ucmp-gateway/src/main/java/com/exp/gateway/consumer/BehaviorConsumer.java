package com.exp.gateway.consumer;

import com.egrid.core.web.response.RestResponse;

import feign.Headers;
import feign.RequestLine;


/**
 * 
 * 
 * @author likai
 *
 */
public interface BehaviorConsumer {
	
	@Headers({ "Content-Type: application/json; charset=UTF-8", "Accept: application/json" })
	@RequestLine("POST /api/sys/behavior/record")
    public RestResponse<String> record(BehaviorDto behaviorParams);
	
//	@Headers({ "Content-Type: application/x-www-form-urlencoded; charset=UTF-8", "Accept: application/json" })
	@Headers({ "Content-Type: application/json; charset=UTF-8", "Accept: application/json" })
	@RequestLine("POST /api/sys/behavior/record/response")
    public RestResponse<String> recordResonse(BehaviorDto behaviorParams);
	
	public static class BehaviorDto {
		private Long partyId = -999L;
		private String requestId = "";
		private String behaviorType = "01";
		private String behaviorTarget = "gateway-trace";
		private String behaviorTargetUrl = "";
		private String queryParams = "";
		private String bodyParams = "";
		private String bodyResponse = "";
		private String behaviorTags = "";
		private String behaviorEndpoint = "";
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
}
