package com.exp.ucmp.xxljob.dao;


import com.exp.ucmp.parentUser.dto.JobReceiveRspUserInfoDto;

import java.util.List;

/**
 * @author hailele
 * @date 2022/10/20
 * 人员管理DAO
 */
public interface JobReceiveRspUserInfoDao {

    /**
     * Description: 查询合作商详情信息
     * @param parentUserInfoDto 查询条件
     * @return 实体集合
     */
     List<JobReceiveRspUserInfoDto> findListPage(JobReceiveRspUserInfoDto parentUserInfoDto);



}
