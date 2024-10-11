package com.exp.ucmp.area.service.impl;

import com.egrid.core.copiers.Copiers;
import com.exp.ucmp.area.dto.SysAreaInfoDto;
import com.exp.ucmp.area.service.SysAreaService;
import com.exp.ucmp.dao.ISysAreaInfoDao;
import com.exp.ucmp.entity.SysAreaInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author zhouchengwei
 * @date 2022年08月24日
 */

@Service
public class SysAreaServiceImp implements SysAreaService {


    @Autowired
    private ISysAreaInfoDao iSysAreaInfoDao;

    /**
     * Description: 根据条件查询集合实体(区域信息)
     * @return 实体集合
     */
    @Override
    public List<SysAreaInfoDto> queryAreaMsg() {
        SysAreaInfoEntity sysAreaInfoEntity = new SysAreaInfoEntity();
        List<SysAreaInfoEntity> sysAreaInfoEntities = iSysAreaInfoDao.selectBySelective(sysAreaInfoEntity);
        return Copiers.beansToBeans(sysAreaInfoEntities, SysAreaInfoEntity.class, SysAreaInfoDto.class);
    }
}
