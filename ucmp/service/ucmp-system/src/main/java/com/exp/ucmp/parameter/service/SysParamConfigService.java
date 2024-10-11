package com.exp.ucmp.parameter.service;

import com.exp.ucmp.config.dto.SysParamConfigDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author hailele
 * @date 2022年10月27日
 */

public interface SysParamConfigService {


    SysParamConfigDto findByType(String parameterType);

    PageInfo<SysParamConfigDto> findPage(Integer pageNum, Integer pageSize);

    void updateById(String paramId, String paramValues);

    void updateBatch(List<SysParamConfigDto> updateList);
}
