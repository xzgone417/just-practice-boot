package com.exp.ucmp.xxljob.service;


import com.exp.ucmp.entity.JobReceiveReqEntity;

public interface SmpXxlJobService {

	JobReceiveReqEntity queryReveiveReqByMaxtimestamp(String jobType, String receiveType, String receiveTaskType,
			String receiveResult);

	void getOrgList(String handlerName, String startTime, String endTime) throws Exception;

	void getStoreCodeList(String handlerName, String startTime, String endTime) throws Exception;
}
