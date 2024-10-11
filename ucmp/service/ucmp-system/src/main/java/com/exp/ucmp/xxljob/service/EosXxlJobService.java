package com.exp.ucmp.xxljob.service;


public interface EosXxlJobService {

	void allUsersInTheDepartment(String handlerName, String startTime, String endTime) throws Exception;

	void getUsersInTheDepartment(String handlerName, String startTime, String endTime) throws Exception;

	void smpAllUsersInTheDepartment(String handlerName, String startTime, String endTime) throws Exception;

}
