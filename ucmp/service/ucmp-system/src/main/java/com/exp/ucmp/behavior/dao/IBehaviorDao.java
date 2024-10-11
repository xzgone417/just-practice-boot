package com.exp.ucmp.behavior.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IBehaviorDao {

	List<Map<String, Object>> queryResponseByUrl(@Param("userId") Long partyId, @Param("lowerLimitTime") Long lowerLimitTime, @Param("behaviorTargetUrl") String url);
}
