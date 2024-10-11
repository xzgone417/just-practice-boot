package com.exp.ucmp.mall.dao;

import com.exp.ucmp.entity.SysRightActivitiesEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>@ClassName: SysRightActivitiesDao</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/18 19:26<p>
 */
public interface SysRightActivitiesDao {

    List<SysRightActivitiesEntity> selectByRightPackId(@Param("rightPackId") Long rightPackId);

}
