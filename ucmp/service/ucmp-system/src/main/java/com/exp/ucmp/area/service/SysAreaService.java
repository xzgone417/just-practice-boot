package com.exp.ucmp.area.service;

import com.exp.ucmp.area.dto.SysAreaInfoDto;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022年08月24日
 */

public interface SysAreaService {

    /**
     * Description: 根据条件查询集合实体(区域信息)
     * @return 实体集合
     */
    public List<SysAreaInfoDto> queryAreaMsg() ;




}
