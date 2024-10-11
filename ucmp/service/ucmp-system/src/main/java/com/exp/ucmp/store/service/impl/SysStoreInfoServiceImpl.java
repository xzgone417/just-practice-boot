package com.exp.ucmp.store.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.alibaba.nacos.common.utils.StringUtils;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.smp.dto.SmpStoreDataDto;
import com.exp.ucmp.smp.dto.SmpStoreReturnDto;
import com.exp.ucmp.store.service.SysStoreInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SysStoreInfoServiceImpl implements SysStoreInfoService {

    @Autowired
    private ISysStoreInfoDao iSysStoreInfoDao;
    @Autowired
    private IPartyInfoDao iPartyInfoDao;
    @Autowired
    private ISysRegionDao sysRegionDao;
    @Autowired
    private IOrganizationInfoDao organizationInfoDao;
    @Autowired
    private IJobReceiveInfoDao iJobReceiveInfoDao;
    @Autowired
    private UcmpAesConfig ucmpAesConfig;
    @Autowired
    private ISysStoreStaffRelaDao iSysStoreStaffRelaDao;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SysStoreInfoServiceImpl.class);

    @Override
    @Transactional
    public void batchInsertorUpdate(List<SysStoreInfoEntity> sysStoreInfoList) {
        if(!CollectionUtils.isEmpty(sysStoreInfoList)){
            //查询所有门店数据
            List<SysStoreInfoEntity> sysStoreInfoEntityList = iSysStoreInfoDao.selectBySelective(new SysStoreInfoEntity());
            //查询所有省份信息
            List<SysRegionEntity> sysRegionEntityList = sysRegionDao.selectBySelective(new SysRegionEntity());

            Map<String, SysRegionEntity> regionMapAll = sysRegionEntityList.stream().collect(Collectors.toMap(p -> String.valueOf(p.getRegionCode()), p -> p ));
            Map<String, SysStoreInfoEntity> storeInfoMapAll = sysStoreInfoEntityList.stream().collect(Collectors.toMap(p -> p.getOrgId(), p -> p ));
            //进行比对，筛选所有需要新增和更新的门店
            List<SysStoreInfoEntity> insertStoreInfoList = new LinkedList<>();
            List<SysStoreInfoEntity> updateStoreInfoist = new LinkedList<>();

            Long userBy= AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
            sysStoreInfoList.forEach(item->{
            	LOGGER.info("=====item====="+JsonBeanUtil.beanToJson(item));
                SysStoreInfoEntity sysStoreInfo;
                if(StringUtils.isBlank(item.getProvince()) &&
                        StringUtils.isNotBlank(item.getProvinceId())){
                    item.setProvince(regionMapAll.get(item.getProvinceId()).getRegionName());
                }
                if(StringUtils.isBlank(item.getCity()) &&
                        StringUtils.isNotBlank(item.getCityId())&&regionMapAll.get(item.getCityId())!=null){
                    item.setCity(regionMapAll.get(item.getCityId()).getRegionName());
                }
                if(StringUtils.isNotBlank(item.getOrgType())){
                    item.setOrgTypeName(Constants.OrgType.getOrgType(item.getOrgType()));
                }
                if(StringUtils.isNotBlank(item.getIsEnable())){
                    item.setSyncIsEnable("0"+item.getIsEnable());
                    item.setIsEnable(null);
                }
                if(storeInfoMapAll.containsKey(item.getOrgId())){
                    sysStoreInfo = storeInfoMapAll.get(item.getOrgId());
                    item.setStoreId(sysStoreInfo.getStoreId());
                    item.setUpdatedBy(userBy);
                    item.setUpdatedDate(new Date());
                    updateStoreInfoist.add(item);
                }else{
                    item.generatePk();
                    //同步过来的门店默认禁用
                    item.setIsEnable(Constants.IsEnable.DISABLE.value());
                    item.setCreatedBy(userBy);
                    item.setCreatedDate(new Date());
                    item.setUpdatedBy(userBy);
                    item.setUpdatedDate(new Date());
                    insertStoreInfoList.add(item);
                }
            });
            //统一更新或新增
            if(!CollectionUtils.isEmpty(updateStoreInfoist)){
                iSysStoreInfoDao.batchUpdateSelective(updateStoreInfoist);
            }
            if(!CollectionUtils.isEmpty(insertStoreInfoList)){
                iSysStoreInfoDao.batchInsert(insertStoreInfoList);
                List<PartyInfoEntity> partyInfos = new LinkedList<>();
                List<OrganizationInfoEntity> organizationInfos = new LinkedList<>();
                //新增的门店数据需要同时新增组织机构表
                insertStoreInfoList.forEach(item->{

                    PartyInfoEntity partyInfoEntity = new PartyInfoEntity();
                    partyInfoEntity.setPartyId(item.getStoreId());
                    partyInfoEntity.setPartyType(Constants.PartyType.ORGANIZATION.value());
                    partyInfoEntity.setCreatedBy(userBy);
                    partyInfoEntity.setUpdatedBy(userBy);
                    partyInfos.add(partyInfoEntity);

                    OrganizationInfoEntity organizationInfoEntity = new OrganizationInfoEntity();
                    organizationInfoEntity.setPartyId(item.getStoreId());
                    organizationInfoEntity.setCreatedBy(userBy);
                    organizationInfoEntity.setUpdatedBy(userBy);
                    organizationInfoEntity.setOrganName(item.getOrgName());
                    organizationInfos.add(organizationInfoEntity);

                });
                iPartyInfoDao.batchInsert(partyInfos);
                organizationInfoDao.batchInsert(organizationInfos);
                
                //查询二手车系统负责的总部人员
                String roleIdStr = ucmpAesConfig.getRoleId();
                ArrayList<String> roleIdList = new ArrayList<>(Arrays.asList(roleIdStr.split(",")));
                LOGGER.info("=====roleIdList====="+JsonBeanUtil.beanToJson(roleIdList));
                List<SysStoreStaffRelaEntity> insertList = new LinkedList<>();
                List<Long> storeList = insertStoreInfoList.stream().map(SysStoreInfoEntity::getStoreId).collect(Collectors.toList());
                for (String roleId : roleIdList) {
                	List<Long> partyIdList = this.iPartyInfoDao.getParyId(Long.parseLong(roleId));
                	for (Long partyId : partyIdList) {
                		for (Long store : storeList) {
                			SysStoreStaffRelaEntity staffRelaEntity = new SysStoreStaffRelaEntity();
                			staffRelaEntity.setPartyId(partyId);
                			staffRelaEntity.setStoreId(Long.valueOf(store.toString()));
                			 //查询当事人的所有门店
                            int i = iSysStoreStaffRelaDao.selectBySelectiveCount(staffRelaEntity);
                            if(i > 0){
                                //当前人员已存在该门店信息，不做新增操作
                                continue;
                            }else{
                                staffRelaEntity.generatePk();
                                staffRelaEntity.setCreatedBy(-888L);
                                staffRelaEntity.setUpdatedBy(staffRelaEntity.getCreatedBy());
                                insertList.add(staffRelaEntity);
                            }
						}
					}
				}
                if(CollectionUtils.isNotEmpty(insertList)){
                    iSysStoreStaffRelaDao.batchInsert(insertList);
                }
            }

        }

    }
    @Transactional
    @Override
    public void synStoreArea(List<SysStoreInfoEntity> storeInfoEntitie) {
        SysStoreInfoEntity storeInfoEntity = new SysStoreInfoEntity();
        storeInfoEntity.setOrgType(Constants.OrgType.REGION.getOrgCode());
        List<SysStoreInfoEntity> twoEntities = iSysStoreInfoDao.selectBySelective(storeInfoEntity);
        Map<String, SysStoreInfoEntity> twoStoreMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(twoEntities)){
            twoStoreMap = twoEntities.stream().collect(Collectors.toMap(p -> p.getOrgId(), p -> p ));
        }

        storeInfoEntity = new SysStoreInfoEntity();
        storeInfoEntity.setOrgType(Constants.OrgType.CHILD_OFFICE.getOrgCode());
        List<SysStoreInfoEntity> threeEntities = iSysStoreInfoDao.selectBySelective(storeInfoEntity);
        Map<String, SysStoreInfoEntity> threeStoreMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(threeEntities)){
            threeStoreMap = threeEntities.stream().collect(Collectors.toMap(p -> p.getOrgId(), p -> p ));
        }

        storeInfoEntity = new SysStoreInfoEntity();
        storeInfoEntity.setOrgType(Constants.OrgType.SUBMIT_CORE.getOrgCode());
        List<SysStoreInfoEntity> fourEntities = iSysStoreInfoDao.selectBySelective(storeInfoEntity);
        Map<String, SysStoreInfoEntity> fourStoreMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(fourEntities)){
            fourStoreMap = fourEntities.stream().collect(Collectors.toMap(p -> p.getOrgId(), p -> p ));
        }
        List<SysStoreInfoEntity> updateDate = new LinkedList<>();
        for(SysStoreInfoEntity  item : storeInfoEntitie) {
//            if(item.getOrgId().equals("1410535443128512514")){
//            }
            SysStoreInfoEntity storeInfo = null;
            if(!Constants.OrgType.PARENT_OFFICE.getOrgCode().equals(item.getOrgType())
            && !Constants.OrgType.REGION.getOrgCode().equals(item.getOrgType())
            ){
                storeInfo = fourStoreMap.get(item.getParentOrgId());
                //获取第三级省市
                if(Objects.isNull(storeInfo) || !Constants.OrgType.REGION.getOrgCode().equals(storeInfo.getOrgType())){
                    if(Objects.isNull(storeInfo) || "4".equals(storeInfo.getOrgType())){
                        storeInfo = threeStoreMap.get(Objects.isNull(storeInfo)?item.getParentOrgId():storeInfo.getParentOrgId());
                    }
                }
                //获取第二级省市
                if(Objects.isNull(storeInfo) || !Constants.OrgType.REGION.getOrgCode().equals(storeInfo.getOrgType())){
                    storeInfo = twoStoreMap.get(Objects.isNull(storeInfo)?item.getParentOrgId():storeInfo.getParentOrgId());
                }
            }
            if(!Objects.isNull(storeInfo)){
                item.setUpdatedDate(new Date());
                item.setAreaCode(storeInfo.getOrgCode());
                item.setAreaName(storeInfo.getOrgName());
                updateDate.add(item);
            }
        }
        if(CollectionUtils.isNotEmpty(updateDate)){
            iSysStoreInfoDao.batchUpdate(updateDate);
        }

    }

    @Override
    @Transactional
    public void synSmpStoresInfo(JobReceiveRspEntity rsp) {
        LOGGER.info("当前解析数据:"+ JSON.toJSONString(rsp));
        JSONObject jsonObject = JSON.parseObject(rsp.getReceiveRspData());
        Object data = jsonObject.get("data");
        if(!Objects.isNull(data) && jsonObject.get("msg").equals("SUCCESS")){
            List<SysStoreInfoEntity> list  = JSON.parseArray(data.toString(),SysStoreInfoEntity.class);
            //对数据进行更新
            LOGGER.info("[门店管理]待更新{}条",list.size());
            this.batchInsertorUpdate(list);
        }
        //更新接收表状态为已处理
        JobReceiveInfoEntity jobReceiveInfo = new JobReceiveInfoEntity();
        jobReceiveInfo.setReceiveId(rsp.getReceiveId());
        jobReceiveInfo.setProcessingStatus(Constants.JobProcessingStatus.SUCCESS.value());
        iJobReceiveInfoDao.updateSelective(jobReceiveInfo);
    }
    
	@Override
	public void synStoreCodeInfo(JobReceiveRspEntity rsp) {
		SmpStoreReturnDto returnDto=JsonBeanUtil.jsonToBean(rsp.getReceiveRspData(), SmpStoreReturnDto.class);
		LOGGER.info("======synStoreCodeInfo==="+JsonBeanUtil.beanToJson(returnDto));
		if(returnDto != null && returnDto.getCode().equals(Constants.CodeEnum.smpCode.value())&&returnDto.getData() != null 
				&& CollectionUtils.isNotEmpty(returnDto.getData().getStoreList())){
			for (SmpStoreDataDto dto : returnDto.getData().getStoreList()) {
				this.iSysStoreInfoDao.updateStoreCode(dto);
			}
		}
	}
}
