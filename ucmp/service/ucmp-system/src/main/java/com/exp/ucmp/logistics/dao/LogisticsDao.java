package com.exp.ucmp.logistics.dao;

import org.apache.ibatis.annotations.Param;

public interface LogisticsDao {

	Long getDispatchApplyInfo(@Param("requestNo") String requestNo);

	Long getDispatchInfo(@Param("dispatchApplyId") Long dispatchApplyId);

	String getAddressById(@Param("stockId")Long stockId);


}
