package com.exp.ucmp.behavior.service;

public interface IBehaviorService {

	void recordBehavior(Long userId, String behaviorType, String behaviorTarget, String behaviorTargetUrl,
			String behaviorEndpoint, String requestId, String queryParams, String bodyParams, String bodyResponse,
			String behaviorTags);

	void recordBehaviorResponse(String httpStatus, String requestId, String bodyResponse);
	
}
