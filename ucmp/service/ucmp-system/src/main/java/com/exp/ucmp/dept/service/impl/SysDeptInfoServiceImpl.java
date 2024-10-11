package com.exp.ucmp.dept.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.DateUtil;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IJobReceiveInfoDao;
import com.exp.ucmp.dao.ISysDeptInfoDao;
import com.exp.ucmp.dept.service.SysDeptInfoService;
import com.exp.ucmp.emdm.dto.DeptDto;
import com.exp.ucmp.entity.JobReceiveInfoEntity;
import com.exp.ucmp.entity.JobReceiveRspEntity;
import com.exp.ucmp.entity.SysDeptInfoEntity;
import com.exp.ucmp.model.Person;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hailele
 * @date 2022年11月18日
 */
@Service
public class SysDeptInfoServiceImpl implements SysDeptInfoService {


    @Autowired
    private IJobReceiveInfoDao iJobReceiveInfoDao;
    @Autowired
    private ISysDeptInfoDao iSysDeptInfoDao;

    @Transactional
    @Override
    public void synEmdmDeptInfo(JobReceiveRspEntity rsp) {
        JSONObject jsonObject = JSON.parseObject(rsp.getReceiveRspData());
        Object data = jsonObject.get("data");
        //EmdmDeptReturnDto returnDto= JsonBeanUtil.jsonToBean(result, EmdmDeptReturnDto.class);;
        List<DeptDto> deptReturnDtos = JSON.parseArray(JSON.toJSONString(data), DeptDto.class);
        //查询所有已有部门
        List<SysDeptInfoEntity> deptInfoEntities = iSysDeptInfoDao.selectBySelective(new SysDeptInfoEntity());
        Map<String, SysDeptInfoEntity> deptInfoMapAll = deptInfoEntities.stream().collect(Collectors.toMap(p -> p.getHhrDeptCode(), p -> p ));
        //进行比对，筛选所有需要新增和更新的部门
        List<SysDeptInfoEntity> insertList = new LinkedList<>();
        List<SysDeptInfoEntity> updateList = new LinkedList<>();
        Long userBy= AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
        if(CollectionUtils.isNotEmpty(deptReturnDtos)){
            deptReturnDtos.stream().forEach(item ->{
                SysDeptInfoEntity deptInfoEntity = Copiers.beanToBean(item,DeptDto.class,SysDeptInfoEntity.class);
                deptInfoEntity.setVersion(item.getVersion());
                if(StringUtils.isNotBlank(item.getLastUpdateDate())){
                    deptInfoEntity.setLastUpdateDate(DateUtil.parseDateTime(item.getLastUpdateDate(),DateUtil.FORMAT_DATETIME_DEFAULT));
                }
                if(deptInfoMapAll.containsKey(item.getHhrDeptCode())){
                    deptInfoEntity.setDeptInfoId(deptInfoMapAll.get(item.getHhrDeptCode()).getDeptInfoId());
                    deptInfoEntity.setUpdatedBy(userBy);
                    deptInfoEntity.setUpdatedDate(new Date());
                    updateList.add(deptInfoEntity);
                }else{
                    deptInfoEntity.generatePk();
                    deptInfoEntity.setIsDelete(Constants.IsDelete.NO.value());
                    deptInfoEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
                    deptInfoEntity.setCreatedBy(userBy);
                    //deptInfoEntity.setCreatedDate(new Date());
                    deptInfoEntity.setUpdatedBy(userBy);
                    //deptInfoEntity.setUpdatedDate(new Date());
                    insertList.add(deptInfoEntity);
                }
            });
        }
        //统一更新或新增
        if(CollectionUtils.isNotEmpty(updateList)){
            iSysDeptInfoDao.batchUpdateSelective(updateList);
        }
        //统一更新或新增
        if(CollectionUtils.isNotEmpty(insertList)){
            iSysDeptInfoDao.batchInsert(insertList);
        }

        //更新接收表状态为已处理
        JobReceiveInfoEntity jobReceiveInfo = new JobReceiveInfoEntity();
        jobReceiveInfo.setReceiveId(rsp.getReceiveId());
        jobReceiveInfo.setProcessingStatus(Constants.JobProcessingStatus.SUCCESS.value());
        iJobReceiveInfoDao.updateSelective(jobReceiveInfo);
    }

}
