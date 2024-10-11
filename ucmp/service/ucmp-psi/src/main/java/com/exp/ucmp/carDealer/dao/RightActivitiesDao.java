package com.exp.ucmp.carDealer.dao;

import com.exp.ucmp.stock.dto.RightActivitiesSelectListDto;

import java.util.List;

/**
 * t_sys_right_activities表DAO
 * @author hailele
 * @date 2023-2-1
 */
public interface RightActivitiesDao {

    //权益包选择列表查询
    List<RightActivitiesSelectListDto> selectActivitiesList();

}
