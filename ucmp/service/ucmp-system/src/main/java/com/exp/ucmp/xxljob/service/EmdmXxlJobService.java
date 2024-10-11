package com.exp.ucmp.xxljob.service;


import com.exp.ucmp.entity.JobReceiveReqEntity;
import com.exp.ucmp.entity.JobReceiveRspEntity;

public interface EmdmXxlJobService {
	JobReceiveReqEntity queryReveiveReqByMaxtimestamp(String jobType, String receiveType, String receiveTaskType,
													  String receiveResult);

	void synEmdmPersonInfo(String handlerName, String startTime, String endTime) throws Exception;

	void synEmdmAreaInfo(String handlerName, String startTime, String endDate) throws Exception;

	void synEmdmDeptInfo(String handlerName, String startTime, String endTime) throws Exception;

	void synEosUserInfo(JobReceiveRspEntity rsp);

	void refreshStoreStaffRela(Long storeId,Long receiveId);

	void synSlfUserInfo(JobReceiveRspEntity slf, String orgId);

	void synSmpUserInfo(JobReceiveRspEntity smp, String orgId);

}

