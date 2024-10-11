package com.exp.ucmp.parameter.dao;

import com.exp.ucmp.config.dto.SysParamConfigDto;

import java.util.List;

/**
 * @author hailele
 * @date 2022年10月27日
 */

public interface SysParamConfigDao {

    SysParamConfigDto findByType(String paramType);

    List<SysParamConfigDto> selectList();

}
