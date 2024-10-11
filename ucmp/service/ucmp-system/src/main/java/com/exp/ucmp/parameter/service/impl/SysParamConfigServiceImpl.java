package com.exp.ucmp.parameter.service.impl;

import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.exp.ucmp.config.dto.SysParamConfigDto;
import com.exp.ucmp.dao.ISysParamConfigDao;
import com.exp.ucmp.entity.SysParamConfigEntity;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.parameter.dao.SysParamConfigDao;
import com.exp.ucmp.parameter.service.SysParamConfigService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class SysParamConfigServiceImpl implements SysParamConfigService {


    @Autowired
    private ISysParamConfigDao iSysParamConfigDao;

    @Autowired
    private SysParamConfigDao sysParamConfigDao;

    @Override
    public SysParamConfigDto findByType(String parameterType) {
        return  sysParamConfigDao.findByType(parameterType);
    }

    @Override
    public PageInfo<SysParamConfigDto> findPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysParamConfigDto> sysPartnerDetailsDtos = sysParamConfigDao.selectList();
        return new PageInfo<>(sysPartnerDetailsDtos);
    }

    @Override
    public void updateById(String paramId, String paramValues) {
        SysParamConfigEntity configEntity = new SysParamConfigEntity();
        configEntity.setUpdatedDate(new Date());
        configEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        configEntity.setParamId(Long.parseLong(paramId));
        configEntity.setParamValues(paramValues);
        iSysParamConfigDao.updateSelective(configEntity);
    }
    @Transactional
    @Override
    public void updateBatch(List<SysParamConfigDto> updateList) {
        List<SysParamConfigEntity> paramConfigEntities = Copiers.beansToBeans(updateList, SysParamConfigDto.class, SysParamConfigEntity.class);
        iSysParamConfigDao.batchUpdateSelective(paramConfigEntities);
    }
}
