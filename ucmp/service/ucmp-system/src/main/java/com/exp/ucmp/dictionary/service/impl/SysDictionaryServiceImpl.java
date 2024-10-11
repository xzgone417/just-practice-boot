package com.exp.ucmp.dictionary.service.impl;

import com.exp.ucmp.dictionary.SysDictionaryDto;
import com.exp.ucmp.dictionary.SysDictionaryQueryDto;
import com.exp.ucmp.dictionary.dao.SysDictionaryDao;
import com.exp.ucmp.dictionary.service.SysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022/10/16
 * 查询字典信息
 */
@Service
public class SysDictionaryServiceImpl implements SysDictionaryService {

    @Autowired
    private SysDictionaryDao sysDictionaryDao;



    @Override
    public List<SysDictionaryDto> queryDictionary(SysDictionaryQueryDto sysDictionaryQueryDto) {
        return sysDictionaryDao.selectDictionary(sysDictionaryQueryDto);
    }
}
