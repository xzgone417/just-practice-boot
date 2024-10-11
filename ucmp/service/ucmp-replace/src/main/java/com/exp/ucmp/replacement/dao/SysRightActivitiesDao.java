package com.exp.ucmp.replacement.dao;


import com.exp.ucmp.entity.SysRightActivitiesEntity;
import com.exp.ucmp.grantPointsRecord.dto.GrantPointsDto;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hailele
 * @date 2022/11/22
 * 权益活动表DAO
 */
public interface SysRightActivitiesDao {

    List<SysRightActivitiesEntity> selectByModelAndShapeCode(@Param("modelCode") String modelCode, @Param("shapeCode") String shapeCode,@Param("campaignType") String campaignType);

	SysRightActivitiesEntity getActivitiesByRightPackId(@Param("rightId")Long rightId,@Param("campaignType") String campaignType);

	void addRecordInfo(GrantPointsDto grantPointsDto);
}
