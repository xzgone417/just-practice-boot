package com.exp.ucmp.dictionary.service;


import com.exp.ucmp.dictionary.SysDictionaryDto;
import com.exp.ucmp.dictionary.SysDictionaryQueryDto;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022/10/16
 * 查询字典信息
 */
public interface SysDictionaryService {


    /**
     * Description: 查询字典信息
     * @param sysDictionaryQueryDto 查询条件
     * @return 实体集合
     */
    public List<SysDictionaryDto> queryDictionary(SysDictionaryQueryDto sysDictionaryQueryDto);
}
