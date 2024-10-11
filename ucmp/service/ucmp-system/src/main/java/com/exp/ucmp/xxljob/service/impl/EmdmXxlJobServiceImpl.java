package com.exp.ucmp.xxljob.service.impl;


import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.alibaba.nacos.common.utils.StringUtils;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.esb.consumer.EmdmConsumer;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.emdm.dto.AreaDto;
import com.exp.ucmp.emdm.dto.EmdmAreaReturnDto;
import com.exp.ucmp.emdm.dto.EmdmDeptReturnDto;
import com.exp.ucmp.emdm.dto.EmdmReturnDto;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.eos.dto.AccountInfoDto;
import com.exp.ucmp.eos.dto.SlfAccountInfoDto;
import com.exp.ucmp.eos.dto.SmpRoleListDto;
import com.exp.ucmp.eos.dto.SmpUserInfoDto;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.SysRegionPk;
import com.exp.ucmp.store.dao.SysStoreDetailsDao;
import com.exp.ucmp.store.dto.SysStoreStaffDetailsDto;
import com.exp.ucmp.storeApp.dto.UserInfoInsertDto;
import com.exp.ucmp.util.AesUtils;
import com.exp.ucmp.xxljob.dao.IXxlJobDao;
import com.exp.ucmp.xxljob.service.EmdmXxlJobService;
import com.exp.ucmp.xxljob.service.JobReceiveRspUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmdmXxlJobServiceImpl implements EmdmXxlJobService {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmdmXxlJobServiceImpl.class);

	@Autowired
	private IXxlJobDao iXxlJobDao;
	
	@Autowired
	private IJobReceiveInfoDao iJobReceiveInfoDao;
	
	@Autowired
	private IJobReceiveReqDao iJobReceiveReqDao;
	@Autowired
	private  ILoginInfoDao iLoginInfoDao;
	@Autowired
	private IJobReceiveRspDao iJobReceiveRspDao;

	@Autowired
	private  ISysStoreStaffDetailsDao iSysStoreStaffDetailsDao;
	@Autowired
	private ISysRegionDao iSysRegionDao;

    @Autowired
    private ISysStoreStaffInfoDao iSysStoreStaffInfoDao;

	@Autowired
	private ISysStoreStaffRelaDao iSysStoreStaffRelaDao;
	@Autowired
	private ISysStoreInfoDao iSysStoreInfoDao;
	@Autowired
	private SysStoreDetailsDao sysStoreDetailsDao;
    @Autowired
    private ISysStaffDetailsDao iSysStaffDetailsDao;
	@Autowired
	private JobReceiveRspUserInfoService jobReceiveRspUserInfoService;
	@Autowired
	private EmdmConsumer emdmConsumer;
	@Autowired
	private  IPartyRelationshipDao iPartyRelationshipDao;
	@Autowired
    private ISysStoreStaffUserMappingDao iSysStoreStaffUserMappingDao;

	@Autowired
	private UcmpAesConfig ucmpAesConfig;

	/**
	 * <p>
	 * 功能说明：事物管理器
	 * </p>
	 * <p>
	 * 取值范围：事物管理器
	 * </p>
	 * <p>
	 * 依赖属性：事物管理器
	 * </p>
	 */
//	@Autowired
//	@Qualifier("localManager")
//	private DataSourceTransactionManager localManager;
	
	@Override
	public JobReceiveReqEntity queryReveiveReqByMaxtimestamp(String jobType, String receiveType, String receiveTaskType, String receiveResult) {
		JobReceiveInfoEntity jobReceiveInfoEntity=new JobReceiveInfoEntity();
		jobReceiveInfoEntity.setJobType(jobType);
		jobReceiveInfoEntity.setReceiveType(receiveType);
		jobReceiveInfoEntity.setReceiveTaskType(receiveTaskType);
		jobReceiveInfoEntity.setReceiveResult(receiveResult);
		//查询信息接收表该任务最新一次成功请求的时间戳
		Long maxtimestamp=this.iXxlJobDao.selectMaxtimestampByReveive(jobReceiveInfoEntity);
		if(maxtimestamp!=null){
			jobReceiveInfoEntity.setReceiveTimestamp(maxtimestamp);
			//根据时间戳查询上次请求信息
			return this.iXxlJobDao.selectReqByTimestamp(jobReceiveInfoEntity);
		}
		return null;
	}

	@Override
	public void synEmdmPersonInfo(String handlerName, String startTime, String endTime) throws Exception {
		try {
	    	Map<String,Object> paramMap=new HashMap<>();
	    	paramMap.put("targetSysId", "EMDM");
	    	if(startTime !=null){
	    		paramMap.put("startTime", startTime);
	    	}
	    	if(StringUtil.isNotEmpty(ucmpAesConfig.getEndTime())){
	    		paramMap.put("endTime", ucmpAesConfig.getEndTime());
	    	}else{
	    		paramMap.put("endTime", endTime);
	    	}
	
			String result = this.emdmConsumer.getEmdmPersonInfo(paramMap);
			
			if(StringUtil.isNotEmpty(result)){
				EmdmReturnDto emdmReturnDto=JsonBeanUtil.jsonToBean(result, EmdmReturnDto.class);
				LOGGER.info("======EmdmReturnDto==="+emdmReturnDto.getTotal());
				addReceive(handlerName,endTime,emdmReturnDto.getTotal(),"01",result,paramMap);
			}
		} catch (Exception e) {
			LOGGER.error("=========",e);
		}
	}

	@Override
	public void synEmdmAreaInfo(String handlerName, String startTime, String endTime) throws Exception {
		try {
			Map<String,Object> paramMap=new HashMap<>();
	    	paramMap.put("targetSysId", "EMDM");
	    	paramMap.put("pageIndex", 1);
	    	paramMap.put("pageSize", 5000);
	    	if(startTime !=null){
	    		paramMap.put("startTime", startTime);
	    	}
	    	if(endTime != null){
	    		paramMap.put("endTime", endTime);
	    	}
	    	String result = this.emdmConsumer.getEmdmAreaInfo(paramMap);
	    	if(StringUtil.isNotEmpty(result)){
	    		 EmdmAreaReturnDto returnDto=JsonBeanUtil.jsonToBean(result, EmdmAreaReturnDto.class);;
				LOGGER.info("======EmdmAreaReturnDto==="+JsonBeanUtil.beanToJson(returnDto));
				List<AreaDto> areaDtoList = returnDto.getData().getRecords();
				Long partyId=AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
				for (AreaDto areaDto : areaDtoList) {
					SysRegionEntity sysRegionEntity = new SysRegionEntity();
					sysRegionEntity.setCreatedBy(partyId);
					sysRegionEntity.setUpdatedBy(partyId);
					sysRegionEntity.setRegionCode(Long.parseLong(areaDto.getAreaCode()));
					sysRegionEntity.setRegionName(areaDto.getAreaName());
					if(StringUtil.isNotEmpty(areaDto.getParentAreaCode())){
						sysRegionEntity.setParentCode(Long.parseLong(areaDto.getParentAreaCode()));
					}
					switch (areaDto.getAreaLevel()) {
					case "country":
						sysRegionEntity.setRegionLevel(1);
						break;
					case "province":
						sysRegionEntity.setRegionLevel(2);
						break;
					case "city":
						sysRegionEntity.setRegionLevel(3);
						break;
					case "district":
						sysRegionEntity.setRegionLevel(4);
						break;	
					default:
						sysRegionEntity.setRegionLevel(5);
						break;
					}
					
					//查询行政区主数据是否存在
					SysRegionPk sysRegionPk=new SysRegionPk();
					sysRegionPk.setRegionCode(Long.parseLong(areaDto.getAreaCode()));
					if(this.iSysRegionDao.load(sysRegionPk) == null){
						this.iSysRegionDao.insert(sysRegionEntity);
					}else{
						this.iSysRegionDao.update(sysRegionEntity);
					}
				}
				addReceive(handlerName,endTime,returnDto.getTotal(),"01",result,paramMap);
			}
		} catch (Exception e) {
			LOGGER.error("=========",e);
		}
	}
	
	@Override
	public void synEmdmDeptInfo(String handlerName, String startTime, String endTime) throws Exception {
		try {
			Map<String,Object> paramMap=new HashMap<>();
	    	paramMap.put("targetSysId", "EMDM");
	    	paramMap.put("pageIndex", 1);
	    	paramMap.put("pageSize", 1000);
	    	if(startTime !=null){
	    		paramMap.put("startTime", startTime);
	    	}
	    	if(endTime != null){
	    		paramMap.put("endTime", endTime);
	    	}
	    	String result = this.emdmConsumer.getEmdmDeptInfo(paramMap);
	    	if(StringUtil.isNotEmpty(result)){
	    		 EmdmDeptReturnDto returnDto=JsonBeanUtil.jsonToBean(result, EmdmDeptReturnDto.class);;
				LOGGER.info("======EmdmDeptReturnDto==="+JsonBeanUtil.beanToJson(returnDto));
				addReceive(handlerName,endTime,returnDto.getData().size(),"01",result,paramMap);
			}
		} catch (Exception e) {
			LOGGER.error("=========",e);
		}
	}
	/**
	@Override
	@Transactional
	public void synEosUserInfo(JobReceiveRspEntity rsp) {
		JSONObject jsonObject = JSON.parseObject(rsp.getReceiveRspData());
		Object data = jsonObject.get("data");
        List<AccountInfoDto> accountInfoDtos = JSON.parseArray(JSON.toJSONString(data), AccountInfoDto.class);

		//获取所有登录信息
		List<LoginInfoEntity> loginInfoEntities = iLoginInfoDao.selectBySelective(new LoginInfoEntity());
		Map<String, LoginInfoEntity> loginInfoEntityMap;
		if(org.springframework.util.CollectionUtils.isEmpty(loginInfoEntities)){
			loginInfoEntityMap = new HashMap<>();
		}else{
			loginInfoEntityMap = loginInfoEntities.stream().collect(Collectors.toMap(p -> p.getLoginName(), p -> p ));
		}

        //查询所有门店人员数据
        List<SysStoreStaffInfoEntity> storeStaffInfoList = iSysStoreStaffInfoDao.selectBySelective(new SysStoreStaffInfoEntity());
        //查询所有基础人员信息表
        List<SysStoreStaffDetailsDto> sysStoreStaffDetailsEntities = sysStoreDetailsDao.selectAllStoreStaffList();
        //查询所有可用门店数据
		SysStoreInfoEntity sysStoreInfoEntity = new SysStoreInfoEntity();
		List<SysStoreInfoEntity> sysStoreInfoList = iSysStoreInfoDao.selectBySelective(sysStoreInfoEntity);

		//进行比对，筛选所有需要新增和更新的人员
		Map<String, SysStoreInfoEntity> sysStoreInfoyMap;
		if(CollectionUtils.isEmpty(sysStoreInfoList)){
			sysStoreInfoyMap = new HashMap<>();
		}else{
			sysStoreInfoyMap = sysStoreInfoList.stream().collect(Collectors.toMap(p -> p.getOrgId(), p -> p ));
		}

		Map<String, SysStoreStaffInfoEntity> userInfoMapAll;
		if(CollectionUtils.isEmpty(storeStaffInfoList)){
			userInfoMapAll = new HashMap<>();
		}else{
			userInfoMapAll = storeStaffInfoList.stream().collect(Collectors.toMap(p -> p.getIdmAccountName()+p.getStoreId()+p.getRoleCode(), p -> p ));
		}

		Map<String, SysStoreStaffDetailsDto> staffDetailsMapAll;
		if(CollectionUtils.isEmpty(sysStoreStaffDetailsEntities)){
			staffDetailsMapAll = new HashMap<>();
		}else{
			System.out.println("[调试日志]当前获取到的所有门店人员信息:"+sysStoreStaffDetailsEntities.size());
			staffDetailsMapAll = sysStoreStaffDetailsEntities.stream().collect(Collectors.toMap(p -> p.getStaffCode() + p.getLoginName(), p -> p ));
			System.out.println("[调试日志]是否存在25047:"+staffDetailsMapAll.containsKey("25047赛比亚·热合木"));

		}
		Long userBy= AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
        //Long userBy= 777L;
		//记录map
		List<SysStoreStaffInfoEntity> insertUserInfoList = new LinkedList<>();
		List<SysStoreStaffInfoEntity> updateUserInfoList = new LinkedList<>();
		List<SysStoreStaffDetailsEntity> insertStaffDetailsUserInfoList = new LinkedList<>();
		List<SysStoreStaffDetailsEntity> updateStaffDetailsUserInfoList = new LinkedList<>();
		List<SysStoreStaffRelaEntity> sysStoreStaffRelaInserts = new LinkedList<>();
		List<UserInfoInsertDto> userInfoInsertDtos = new LinkedList<>();
		List<PartyRelationshipEntity> partyRelationshipList = new LinkedList<>();

		SysStoreStaffInfoEntity storeStaff;
		SysStoreStaffDetailsEntity staffDetailsEntity;
		SysStoreStaffRelaEntity staffRelaEntity;
		UserInfoInsertDto userInfoInsertDto;
        PartyRelationshipEntity relationshipEntity;
		List<AccountInfoDto> accountInfoDtoList = accountInfoDtos.stream().filter(s-> StringUtils.isNotBlank(s.getIdmAccountName())).collect(Collectors.toList());
		Long partyId;
		LOGGER.info("准备过滤门店人员数据....1");
		for (AccountInfoDto item:accountInfoDtoList) {
			String staffKey = item.getUserId() + item.getIdmAccountName();
			System.out.println("[调试日志]当前key:"+staffKey);
			if(loginInfoEntityMap.containsKey(item.getIdmAccountName())){
				partyId = loginInfoEntityMap.get(item.getIdmAccountName()).getPartyId();
			}else{
				partyId = RandomIDGennerator.get().generate();
			}

			if(!loginInfoEntityMap.containsKey(item.getIdmAccountName())){
				//创建用户系统登录相关表
				userInfoInsertDto = new UserInfoInsertDto(
						partyId,
						Constants.PartyType.PERSON.value(),
						item.getUserName(),
						null,
						item.getIdmAccountName(),
						Constants.ValidMark.VALID.value()
				);
				userInfoInsertDtos.add(userInfoInsertDto);
                loginInfoEntityMap.put(item.getIdmAccountName(),Copiers.beanToBean(userInfoInsertDto, UserInfoInsertDto.class, LoginInfoEntity.class));
				//loginInfoEntityMap.put(item.getIdmAccountName(),null);
			}

			//维护人员基础信息表和登录相关
			if(staffDetailsMapAll.containsKey(staffKey)){
				//staffDetailsEntity = staffDetailsMapAll.get(staffKey);
                SysStoreStaffDetailsDto detailsDto = staffDetailsMapAll.get(staffKey);
                staffDetailsEntity =
                        Copiers.beanToBean(detailsDto, SysStoreStaffDetailsDto.class, SysStoreStaffDetailsEntity.class);

                staffDetailsEntity.setUpdatedBy(userBy);
				staffDetailsEntity.setStaffName(item.getUserName());
				staffDetailsEntity.setStaffCode(item.getUserId().toString());
				staffDetailsEntity.setUpdatedDate(new Date());
				if(item.getUserName().contains("刘洋")){
					System.out.println("[调试日志]刘洋准备更新:"+JSON.toJSONString(staffDetailsEntity));
				}
				updateStaffDetailsUserInfoList.add(staffDetailsEntity);
			}else{
				if(item.getUserName().contains("刘洋")){
					System.out.println("[调试日志]"+JSON.toJSONString(item));
				}
				staffDetailsEntity = new SysStoreStaffDetailsEntity();
				staffDetailsEntity.setPartyId(partyId);
				staffDetailsEntity.setIsDelete(Constants.IsDelete.NO.value());
				staffDetailsEntity.setCreatedBy(userBy);
				staffDetailsEntity.setCreatedDate(new Date());
				staffDetailsEntity.setUpdatedBy(userBy);
				staffDetailsEntity.setUpdatedDate(new Date());
				//门店人员默认启用
				staffDetailsEntity.setStaffStatus(Constants.staffStatus.disable.value());
				staffDetailsEntity.setStaffType(Constants.StaffType.store.value());
				staffDetailsEntity.setStaffCode(item.getUserId().toString());
				staffDetailsEntity.setStaffName(item.getUserName());
				staffDetailsEntity.setStaffIphone(AesUtils.encryptHex(item.getPhoneNumber(), ucmpAesConfig.getSecret()));
				insertStaffDetailsUserInfoList.add(staffDetailsEntity);
				System.out.println("[调试日志]最后新增的数据:"+JSON.toJSONString(staffDetailsEntity));

                SysStoreStaffDetailsDto staffDetailsDto = Copiers.beanToBean(staffDetailsEntity, SysStoreStaffDetailsEntity.class, SysStoreStaffDetailsDto.class);
                staffDetailsDto.setLoginName(item.getIdmAccountName());
                staffDetailsMapAll.put(staffDetailsEntity.getStaffCode() + item.getIdmAccountName(),staffDetailsDto);

			}
			//维护门店人员业务信息表
			if(userInfoMapAll.containsKey(item.getIdmAccountName()+sysStoreInfoyMap.get(item.getDepartmentId()).getStoreId()+item.getRoleCode())){
				storeStaff = userInfoMapAll.get(item.getIdmAccountName()+sysStoreInfoyMap.get(item.getDepartmentId()).getStoreId()+item.getRoleCode());
				storeStaff.setUserName(item.getUserName());
				storeStaff.setPhoneNumber(item.getPhoneNumber());
				storeStaff.setRoleCode(item.getRoleCode());
				storeStaff.setRoleName(item.getRoleName());
				storeStaff.setUpdatedBy(userBy);
				storeStaff.setUpdatedDate(new Date());
				updateUserInfoList.add(storeStaff);
			}else{
				storeStaff = new SysStoreStaffInfoEntity();
				storeStaff.generatePk();
				storeStaff.setPartyId(partyId);
				storeStaff.setUserId(Long.valueOf(item.getUserId()));
				storeStaff.setUserName(item.getUserName());
				storeStaff.setIdmAccountName(item.getIdmAccountName());
				storeStaff.setPhoneNumber(item.getPhoneNumber());
				storeStaff.setRoleCode(item.getRoleCode());
				storeStaff.setRoleName(item.getRoleName());
				storeStaff.setUpdatedBy(userBy);
				storeStaff.setCreatedBy(userBy);
				SysStoreInfoEntity storeInfoEntity = sysStoreInfoyMap.get(item.getDepartmentId());
				//设置对应的门店id
				storeStaff.setStoreId(storeInfoEntity.getStoreId());
				insertUserInfoList.add(storeStaff);

                //创建人员门店关系表
                staffRelaEntity = new SysStoreStaffRelaEntity();
                staffRelaEntity.generatePk();
                staffRelaEntity.setPartyId(partyId);
                staffRelaEntity.setStoreId(sysStoreInfoyMap.get(item.getDepartmentId()).getStoreId());
                staffRelaEntity.setUpdatedBy(userBy);
                staffRelaEntity.setCreatedBy(userBy);
                sysStoreStaffRelaInserts.add(staffRelaEntity);
                //创建组织关系表
                relationshipEntity = new PartyRelationshipEntity();
                relationshipEntity.generatePk();
                relationshipEntity.setRelationshipTypeCode(Constants.RelationshipTypeCode.USER.value());
                relationshipEntity.setSrcPartyId(partyId);
                //这一块填写门店id
                relationshipEntity.setTagPartyId(staffRelaEntity.getStoreId());
                relationshipEntity.setCreatedBy(userBy);
                relationshipEntity.setUpdatedBy(userBy);
                partyRelationshipList.add(relationshipEntity);

			}
		}
		LOGGER.info("准备更新门店人员数据....2");
        //统一更新或新增
		if(!CollectionUtils.isEmpty(updateUserInfoList)){
			iSysStoreStaffInfoDao.batchUpdateSelective(updateUserInfoList);
		}
		LOGGER.info("准备更新门店人员数据....3");
		if(!CollectionUtils.isEmpty(insertUserInfoList)){
			iSysStoreStaffInfoDao.batchInsert(insertUserInfoList);
		}
		LOGGER.info("准备更新门店人员数据....4");
		//统一更新或新增
		if(!CollectionUtils.isEmpty(updateStaffDetailsUserInfoList)){
            iSysStoreStaffDetailsDao.batchUpdateSelective(updateStaffDetailsUserInfoList);
		}
		LOGGER.info("准备更新门店人员数据....5");
		if(!CollectionUtils.isEmpty(insertStaffDetailsUserInfoList)){
			LOGGER.info("准备更新门店人员数据:{}条",insertStaffDetailsUserInfoList.size());
			iSysStoreStaffDetailsDao.batchInsert(insertStaffDetailsUserInfoList);
		}
		LOGGER.info("准备更新门店人员数据....5.5");
		if(!CollectionUtils.isEmpty(sysStoreStaffRelaInserts)){
			LOGGER.info("准备更新门店人员数据:{}条",sysStoreStaffRelaInserts.size());
			iSysStoreStaffRelaDao.batchInsert(sysStoreStaffRelaInserts);
		}
		LOGGER.info("准备更新门店人员数据....6");
        if(!CollectionUtils.isEmpty(userInfoInsertDtos)){
            //同时同步更新到系统相关用户表
            jobReceiveRspUserInfoService.insertSysUserList(userInfoInsertDtos,true);
        }
		LOGGER.info("准备更新门店人员数据....7");
		if(CollectionUtils.isNotEmpty(partyRelationshipList)){
			iPartyRelationshipDao.batchInsert(partyRelationshipList);
		}
		LOGGER.info("准备定时任务数据....8");
		//更新接收表状态为已处理
		JobReceiveInfoEntity jobReceiveInfo = new JobReceiveInfoEntity();
		jobReceiveInfo.setReceiveId(rsp.getReceiveId());
		jobReceiveInfo.setProcessingStatus(Constants.JobProcessingStatus.SUCCESS.value());
		iJobReceiveInfoDao.updateSelective(jobReceiveInfo);

	}**/

	//最新版门店人员同步接口(同步数据的同时重新生成门店人员关系表)
	@Override
	@Transactional
	public void synEosUserInfo(JobReceiveRspEntity rsp) {
		JSONObject jsonObject = JSON.parseObject(rsp.getReceiveRspData());
		Object data = jsonObject.get("data");
		List<AccountInfoDto> accountInfoDtos = JSON.parseArray(JSON.toJSONString(data), AccountInfoDto.class);

		//获取所有登录信息
		List<LoginInfoEntity> loginInfoEntities = iLoginInfoDao.selectBySelective(new LoginInfoEntity());
		Map<String, LoginInfoEntity> loginInfoEntityMap;
		if(org.springframework.util.CollectionUtils.isEmpty(loginInfoEntities)){
			loginInfoEntityMap = new HashMap<>();
		}else{
			loginInfoEntityMap = loginInfoEntities.stream().collect(Collectors.toMap(p -> p.getLoginName(), p -> p ));
		}

		//查询所有基础人员信息表
		List<SysStoreStaffDetailsDto> sysStoreStaffDetailsEntities = sysStoreDetailsDao.selectAllStoreStaffList();
		//查询所有可用门店数据
		SysStoreInfoEntity sysStoreInfoEntity = new SysStoreInfoEntity();
		List<SysStoreInfoEntity> sysStoreInfoList = iSysStoreInfoDao.selectBySelective(sysStoreInfoEntity);

		//进行比对，筛选所有需要新增和更新的人员
		Map<String, SysStoreInfoEntity> sysStoreInfoyMap;
		if(CollectionUtils.isEmpty(sysStoreInfoList)){
			sysStoreInfoyMap = new HashMap<>();
		}else{
			sysStoreInfoyMap = sysStoreInfoList.stream().collect(Collectors.toMap(p -> p.getOrgId(), p -> p ));
		}

		Map<String, SysStoreStaffDetailsDto> staffDetailsMapAll;
		if(CollectionUtils.isEmpty(sysStoreStaffDetailsEntities)){
			staffDetailsMapAll = new HashMap<>();
		}else{
			staffDetailsMapAll = sysStoreStaffDetailsEntities.stream().collect(Collectors.toMap(p -> p.getStaffCode() + p.getLoginName(), p -> p ));
		}
		Long userBy= AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
		//记录map
		List<SysStoreStaffInfoEntity> insertUserInfoList = new LinkedList<>();
		List<SysStoreStaffDetailsEntity> insertStaffDetailsUserInfoList = new LinkedList<>();
		List<SysStoreStaffDetailsEntity> updateStaffDetailsUserInfoList = new LinkedList<>();
		List<SysStoreStaffRelaEntity> sysStoreStaffRelaInserts = new LinkedList<>();
		List<UserInfoInsertDto> userInfoInsertDtos = new LinkedList<>();
		List<PartyRelationshipEntity> partyRelationshipList = new LinkedList<>();

		SysStoreStaffInfoEntity storeStaff;
		SysStoreStaffDetailsEntity staffDetailsEntity;
		SysStoreStaffRelaEntity staffRelaEntity;
		UserInfoInsertDto userInfoInsertDto;
		PartyRelationshipEntity relationshipEntity;
		List<AccountInfoDto> accountInfoDtoList = accountInfoDtos.stream().filter(s-> StringUtils.isNotBlank(s.getIdmAccountName())).collect(Collectors.toList());
		LOGGER.info("过滤后的有效数据:"+JSON.toJSONString(accountInfoDtoList));
		Long partyId;
		//先清空对应的人员门店关系表数据
		if(CollectionUtils.isNotEmpty(accountInfoDtoList)){
			//获取当前数据的门店id
			Long storeId = sysStoreInfoyMap.get(accountInfoDtoList.get(0).getDepartmentId()).getStoreId();
			refreshStoreStaffRela(storeId,null);
		}
		LOGGER.info("准备过滤门店人员数据....1");
		for (AccountInfoDto item:accountInfoDtoList) {
			String staffKey = item.getUserId() + item.getIdmAccountName();
			if(loginInfoEntityMap.containsKey(item.getIdmAccountName())){
				partyId = loginInfoEntityMap.get(item.getIdmAccountName()).getPartyId();
			}else{
				partyId = RandomIDGennerator.get().generate();
			}

			if(!loginInfoEntityMap.containsKey(item.getIdmAccountName())){
				//创建用户系统登录相关表
				userInfoInsertDto = new UserInfoInsertDto(
						partyId,
						Constants.PartyType.PERSON.value(),
						item.getUserName(),
						null,
						item.getIdmAccountName(),
						Constants.ValidMark.VALID.value()
				);
				userInfoInsertDtos.add(userInfoInsertDto);
				loginInfoEntityMap.put(item.getIdmAccountName(),Copiers.beanToBean(userInfoInsertDto, UserInfoInsertDto.class, LoginInfoEntity.class));
			}

			//维护人员基础信息表和登录相关
			if(staffDetailsMapAll.containsKey(staffKey)){
				SysStoreStaffDetailsDto detailsDto = staffDetailsMapAll.get(staffKey);
				staffDetailsEntity =
						Copiers.beanToBean(detailsDto, SysStoreStaffDetailsDto.class, SysStoreStaffDetailsEntity.class);

				staffDetailsEntity.setUpdatedBy(userBy);
				staffDetailsEntity.setStaffName(item.getUserName());
				staffDetailsEntity.setStaffCode(item.getUserId().toString());
				staffDetailsEntity.setUpdatedDate(new Date());
				updateStaffDetailsUserInfoList.add(staffDetailsEntity);
			}else{
				staffDetailsEntity = new SysStoreStaffDetailsEntity();
				staffDetailsEntity.setPartyId(partyId);
				staffDetailsEntity.setIsDelete(Constants.IsDelete.NO.value());
				staffDetailsEntity.setCreatedBy(userBy);
				staffDetailsEntity.setCreatedDate(new Date());
				staffDetailsEntity.setUpdatedBy(userBy);
				staffDetailsEntity.setUpdatedDate(new Date());
				//门店人员默认启用
				staffDetailsEntity.setStaffStatus(Constants.staffStatus.disable.value());
				staffDetailsEntity.setStaffType(Constants.StaffType.store.value());
				staffDetailsEntity.setStaffCode(item.getUserId().toString());
				staffDetailsEntity.setStaffName(item.getUserName());
				staffDetailsEntity.setStaffIphone(AesUtils.encryptHex(item.getPhoneNumber(), ucmpAesConfig.getSecret()));
				insertStaffDetailsUserInfoList.add(staffDetailsEntity);
				SysStoreStaffDetailsDto staffDetailsDto = Copiers.beanToBean(staffDetailsEntity, SysStoreStaffDetailsEntity.class, SysStoreStaffDetailsDto.class);
				staffDetailsDto.setLoginName(item.getIdmAccountName());
				staffDetailsMapAll.put(staffDetailsEntity.getStaffCode() + item.getIdmAccountName(),staffDetailsDto);
			}
			//重新创建门店人员业务关联信息表
			storeStaff = new SysStoreStaffInfoEntity();
			storeStaff.generatePk();
			storeStaff.setPartyId(partyId);
			storeStaff.setUserId(Long.valueOf(item.getUserId()));
			storeStaff.setUserName(item.getUserName());
			storeStaff.setIdmAccountName(item.getIdmAccountName());
			storeStaff.setPhoneNumber(AesUtils.encryptHex(item.getPhoneNumber(), ucmpAesConfig.getSecret()));
			storeStaff.setRoleCode(item.getRoleCode());
			storeStaff.setRoleName(item.getRoleName());
			storeStaff.setUpdatedBy(userBy);
			storeStaff.setCreatedBy(userBy);
			SysStoreInfoEntity storeInfoEntity = sysStoreInfoyMap.get(item.getDepartmentId());
			//设置对应的门店id
			storeStaff.setStoreId(storeInfoEntity.getStoreId());
			insertUserInfoList.add(storeStaff);

			//创建人员门店关系表
			staffRelaEntity = new SysStoreStaffRelaEntity();
			staffRelaEntity.generatePk();
			staffRelaEntity.setPartyId(partyId);
			staffRelaEntity.setStoreId(sysStoreInfoyMap.get(item.getDepartmentId()).getStoreId());
			staffRelaEntity.setUpdatedBy(userBy);
			staffRelaEntity.setCreatedBy(userBy);
			sysStoreStaffRelaInserts.add(staffRelaEntity);
			//创建组织关系表
			relationshipEntity = new PartyRelationshipEntity();
			relationshipEntity.generatePk();
			relationshipEntity.setRelationshipTypeCode(Constants.RelationshipTypeCode.USER.value());
			relationshipEntity.setSrcPartyId(partyId);
			//这一块填写门店id
			relationshipEntity.setTagPartyId(staffRelaEntity.getStoreId());
			relationshipEntity.setCreatedBy(userBy);
			relationshipEntity.setUpdatedBy(userBy);
			partyRelationshipList.add(relationshipEntity);

		}
		LOGGER.info("准备更新门店人员数据....2");
		//统一更新或新增
		if(!CollectionUtils.isEmpty(insertUserInfoList)){
			iSysStoreStaffInfoDao.batchInsert(insertUserInfoList);
		}
		LOGGER.info("准备更新门店人员数据....3");
		//统一更新或新增
		if(!CollectionUtils.isEmpty(updateStaffDetailsUserInfoList)){
			iSysStoreStaffDetailsDao.batchUpdateSelective(updateStaffDetailsUserInfoList);
		}
		LOGGER.info("准备更新门店人员数据....4");
		if(!CollectionUtils.isEmpty(insertStaffDetailsUserInfoList)){
			LOGGER.info("准备更新门店人员数据:{}条",insertStaffDetailsUserInfoList.size());
			LOGGER.info("准备更新门店人员数据JSON:"+JSON.toJSONString(insertStaffDetailsUserInfoList));
			iSysStoreStaffDetailsDao.batchInsert(insertStaffDetailsUserInfoList);
		}
		LOGGER.info("准备更新门店人员数据....5");
		if(!CollectionUtils.isEmpty(sysStoreStaffRelaInserts)){
			LOGGER.info("准备更新门店人员数据:{}条",sysStoreStaffRelaInserts.size());
			iSysStoreStaffRelaDao.batchInsert(sysStoreStaffRelaInserts);
		}
		LOGGER.info("准备更新门店人员数据....6");
		if(!CollectionUtils.isEmpty(userInfoInsertDtos)){
			//同时同步更新到系统相关用户表
			jobReceiveRspUserInfoService.insertSysUserList(userInfoInsertDtos,true);
		}
		LOGGER.info("准备更新门店人员数据....7");
		if(CollectionUtils.isNotEmpty(partyRelationshipList)){
			iPartyRelationshipDao.batchInsert(partyRelationshipList);
		}
		LOGGER.info("准备定时任务数据....8");
		//更新接收表状态为已处理
		JobReceiveInfoEntity jobReceiveInfo = new JobReceiveInfoEntity();
		jobReceiveInfo.setReceiveId(rsp.getReceiveId());
		jobReceiveInfo.setProcessingStatus(Constants.JobProcessingStatus.SUCCESS.value());
		iJobReceiveInfoDao.updateSelective(jobReceiveInfo);

	}
	
	@Override
	@Transactional
	public void refreshStoreStaffRela(Long storeId,Long receiveId) {
		//删除相关业务信息表
		SysStoreStaffInfoEntity storeStaff = new SysStoreStaffInfoEntity();
		//设置对应的门店id
		storeStaff.setStoreId(storeId);
		iSysStoreStaffInfoDao.deleteBySelective(storeStaff);

		//删除人员门店关系表
		SysStoreStaffRelaEntity staffRelaEntity = new SysStoreStaffRelaEntity();
		staffRelaEntity.setStoreId(storeId);
		//用创建人来区分总部人员和门店人员关系
		staffRelaEntity.setCreatedBy(-999L);
		iSysStoreStaffRelaDao.deleteBySelective(staffRelaEntity);

		//删除对应组织关系表
		PartyRelationshipEntity relationshipEntity = new PartyRelationshipEntity();
		relationshipEntity.setRelationshipTypeCode(Constants.RelationshipTypeCode.USER.value());
		//这一块填写门店id
		relationshipEntity.setTagPartyId(staffRelaEntity.getStoreId());
		iPartyRelationshipDao.deleteBySelective(relationshipEntity);
		//更新接收表状态为已处理
		if(receiveId != null){
			JobReceiveInfoEntity jobReceiveInfo = new JobReceiveInfoEntity();
			jobReceiveInfo.setReceiveId(receiveId);
			jobReceiveInfo.setProcessingStatus(Constants.JobProcessingStatus.SUCCESS.value());
			iJobReceiveInfoDao.updateSelective(jobReceiveInfo);
		}
	}


	public  static  void main(String[] args){
		Map<String,String> map = new HashMap<>();

		String staffKey = "25047赛比亚·热合木";
		map.put(staffKey,"123");
		if(map.containsKey(staffKey)){
			System.out.println("存在");
		}else {
			System.out.println("不存在");
		}
	}
	private void addReceive(String handlerName, String endTime, Integer receiveCount, String receiveResult, 
			String result, Map<String, Object> paramMap) {
		Long partyId=AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
		LOGGER.info("=====addReceive=partyId==="+partyId);
		// 记录接收到的数据信息
		JobReceiveInfoEntity jobReceiveInfoEntity=new JobReceiveInfoEntity();
		jobReceiveInfoEntity.setCreatedBy(partyId);//待定
		jobReceiveInfoEntity.setJobType("emdm");
		jobReceiveInfoEntity.setProcessingStatus("01");
		jobReceiveInfoEntity.setReceiveCount(receiveCount);
		jobReceiveInfoEntity.generatePk();
		jobReceiveInfoEntity.setReceiveResult(receiveResult);
		jobReceiveInfoEntity.setReceiveTaskType(handlerName);
		jobReceiveInfoEntity.setReceiveTimestamp(Long.parseLong(endTime.replace(" ", "").replace(":", "").replace("-", "")));
		jobReceiveInfoEntity.setReceiveType("http");
		jobReceiveInfoEntity.setUpdatedBy(partyId);
		
		this.iJobReceiveInfoDao.insert(jobReceiveInfoEntity);
		
		//记录请求参数
		JobReceiveReqEntity jobReceiveReqEntity=new JobReceiveReqEntity();
		jobReceiveReqEntity.setCreatedBy(partyId);
		jobReceiveReqEntity.setReceiveReqData(JsonBeanUtil.beanToJson(paramMap));
		jobReceiveReqEntity.setReceiveId(jobReceiveInfoEntity.getReceiveId());
		jobReceiveReqEntity.setUpdatedBy(partyId);
		
		this.iJobReceiveReqDao.insert(jobReceiveReqEntity);
		
		//记录响应数据
		JobReceiveRspEntity jobReceiveRspEntity=new JobReceiveRspEntity();
		jobReceiveRspEntity.setCreatedBy(partyId);
		jobReceiveRspEntity.setReceiveId(jobReceiveInfoEntity.getReceiveId());
		jobReceiveRspEntity.setReceiveRspData(result);
		jobReceiveRspEntity.setUpdatedBy(partyId);
		
		this.iJobReceiveRspDao.insert(jobReceiveRspEntity);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void synSlfUserInfo(JobReceiveRspEntity slf, String orgId) {
		JSONObject jsonObject = JSON.parseObject(slf.getReceiveRspData());
		Object data = jsonObject.get("data");
		List<SlfAccountInfoDto> accountInfoDtos  = JSON.parseArray(JSON.toJSONString(data), SlfAccountInfoDto.class);	
		
		//获取所有登录信息
		List<LoginInfoEntity> loginInfoEntities = iLoginInfoDao.selectBySelective(new LoginInfoEntity());
		Map<String, LoginInfoEntity> loginInfoEntityMap;
		if(org.springframework.util.CollectionUtils.isEmpty(loginInfoEntities)){
			loginInfoEntityMap = new HashMap<>();
		}else{
			loginInfoEntityMap = loginInfoEntities.stream().collect(Collectors.toMap(p -> p.getLoginName(), p -> p ));
		}

		//查询所有门店人员数据
		//List<SysStoreStaffInfoEntity> storeStaffInfoList = iSysStoreStaffInfoDao.selectBySelective(new SysStoreStaffInfoEntity());
		//查询所有基础人员信息表
		List<SysStoreStaffDetailsDto> sysStoreStaffDetailsEntities = sysStoreDetailsDao.selectAllStoreStaffList();
		//查询所有可用门店数据
		SysStoreInfoEntity sysStoreInfoEntity = new SysStoreInfoEntity();
		List<SysStoreInfoEntity> sysStoreInfoList = iSysStoreInfoDao.selectBySelective(sysStoreInfoEntity);

		//进行比对，筛选所有需要新增和更新的人员
		Map<String, SysStoreInfoEntity> sysStoreInfoyMap;
		if(CollectionUtils.isEmpty(sysStoreInfoList)){
			sysStoreInfoyMap = new HashMap<>();
		}else{
			sysStoreInfoyMap = sysStoreInfoList.stream().collect(Collectors.toMap(p -> p.getOrgId(), p -> p ));
		}

		Map<String, SysStoreStaffDetailsDto> staffDetailsMapAll;
		if(CollectionUtils.isEmpty(sysStoreStaffDetailsEntities)){
			staffDetailsMapAll = new HashMap<>();
		}else{
			staffDetailsMapAll = sysStoreStaffDetailsEntities.stream().collect(Collectors.toMap(p -> p.getLoginName(), p -> p ,(p1,p2) ->p1));
		}
		Long userBy= AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
		//记录map
		List<SysStoreStaffInfoEntity> insertUserInfoList = new LinkedList<>();
		List<SysStoreStaffDetailsEntity> insertStaffDetailsUserInfoList = new LinkedList<>();
		List<SysStoreStaffDetailsEntity> updateStaffDetailsUserInfoList = new LinkedList<>();
		List<SysStoreStaffRelaEntity> sysStoreStaffRelaInserts = new LinkedList<>();
		List<UserInfoInsertDto> userInfoInsertDtos = new LinkedList<>();
		List<PartyRelationshipEntity> partyRelationshipList = new LinkedList<>();

		SysStoreStaffInfoEntity storeStaff;
		SysStoreStaffDetailsEntity staffDetailsEntity;
		SysStoreStaffRelaEntity staffRelaEntity;
		UserInfoInsertDto userInfoInsertDto;
		PartyRelationshipEntity relationshipEntity;
		List<AccountInfoDto> accountInfoDtoList=new ArrayList<>();
		if(accountInfoDtos !=null){
			accountInfoDtos.forEach(slfAccount ->{
				if(StringUtils.isNotBlank(slfAccount.getIdmAccountName())){
					AccountInfoDto dto=Copiers.beanToBean(slfAccount, SlfAccountInfoDto.class, AccountInfoDto.class);
					try{
						if(StringUtil.isNotEmpty(slfAccount.getUserId())){
							dto.setUserId(Integer.parseInt(slfAccount.getUserId()));
						}
						if(StringUtil.isNotEmpty(slfAccount.getSuperiorUserId())){
							dto.setSuperiorUserId(Integer.parseInt(slfAccount.getSuperiorUserId()));
						}
						accountInfoDtoList.add(dto);
					}catch(Exception e){
						LOGGER.info("===slf数据转换报错===="+JSON.toJSONString(data));
					}
				}
			});
//			LOGGER.info("slf过滤后的有效数据:"+JSON.toJSONString(accountInfoDtoList));
			Long partyId;
			//先清空对应的人员门店关系表数据
			if(CollectionUtils.isNotEmpty(accountInfoDtoList)){
				//获取当前数据的门店id
				Long storeId = sysStoreInfoyMap.get(orgId).getStoreId();
				refreshStoreStaffRela(storeId,null);
			}
			LOGGER.info("准备过滤slf门店人员数据....1");
			for (AccountInfoDto item:accountInfoDtoList) {
				item.setDepartmentId(orgId);
				String staffKey = item.getIdmAccountName();
				if(loginInfoEntityMap.containsKey(item.getIdmAccountName())){
					partyId = loginInfoEntityMap.get(item.getIdmAccountName()).getPartyId();
				}else{
					partyId = RandomIDGennerator.get().generate();
				}
				
				if(!loginInfoEntityMap.containsKey(item.getIdmAccountName())){
					//创建用户系统登录相关表
					userInfoInsertDto = new UserInfoInsertDto(
							partyId,
							Constants.PartyType.PERSON.value(),
							item.getUserName(),
							null,
							item.getIdmAccountName(),
							Constants.ValidMark.VALID.value()
							);
					userInfoInsertDtos.add(userInfoInsertDto);
					loginInfoEntityMap.put(item.getIdmAccountName(),Copiers.beanToBean(userInfoInsertDto, UserInfoInsertDto.class, LoginInfoEntity.class));
				}
				Date nowDate = new Date();
				//维护人员基础信息表和登录相关
				if(staffDetailsMapAll.containsKey(staffKey)){
					SysStoreStaffDetailsDto detailsDto = staffDetailsMapAll.get(staffKey);
					staffDetailsEntity =
							Copiers.beanToBean(detailsDto, SysStoreStaffDetailsDto.class, SysStoreStaffDetailsEntity.class);
					
					staffDetailsEntity.setUpdatedBy(userBy);
					staffDetailsEntity.setStaffName(item.getUserName());
					staffDetailsEntity.setStaffCode(item.getUserId().toString());
					staffDetailsEntity.setUpdatedDate(nowDate);
					updateStaffDetailsUserInfoList.add(staffDetailsEntity);
				}else{
					staffDetailsEntity = new SysStoreStaffDetailsEntity();
					staffDetailsEntity.setPartyId(partyId);
					staffDetailsEntity.setIsDelete(Constants.IsDelete.NO.value());
					staffDetailsEntity.setCreatedBy(userBy);
					staffDetailsEntity.setCreatedDate(nowDate);
					staffDetailsEntity.setUpdatedBy(userBy);
					staffDetailsEntity.setUpdatedDate(nowDate);
					//门店人员默认启用
					staffDetailsEntity.setStaffStatus(Constants.staffStatus.disable.value());
					staffDetailsEntity.setStaffType(Constants.StaffType.store.value());
					staffDetailsEntity.setStaffCode(item.getUserId().toString());
					staffDetailsEntity.setStaffName(item.getUserName());
					staffDetailsEntity.setStaffIphone(AesUtils.encryptHex(item.getPhoneNumber(), ucmpAesConfig.getSecret()));
					insertStaffDetailsUserInfoList.add(staffDetailsEntity);
					SysStoreStaffDetailsDto staffDetailsDto = Copiers.beanToBean(staffDetailsEntity, SysStoreStaffDetailsEntity.class, SysStoreStaffDetailsDto.class);
					staffDetailsDto.setLoginName(item.getIdmAccountName());
					staffDetailsMapAll.put(staffDetailsEntity.getStaffCode() + item.getIdmAccountName(),staffDetailsDto);
				}
				//重新创建门店人员业务关联信息表
				storeStaff = new SysStoreStaffInfoEntity();
				storeStaff.generatePk();
				storeStaff.setPartyId(partyId);
				storeStaff.setUserId(Long.valueOf(item.getUserId()));
				storeStaff.setUserName(item.getUserName());
				storeStaff.setIdmAccountName(item.getIdmAccountName());
				storeStaff.setPhoneNumber(AesUtils.encryptHex(item.getPhoneNumber(), ucmpAesConfig.getSecret()));
				storeStaff.setRoleCode(item.getRoleCode());
				storeStaff.setRoleName(item.getRoleName());
				storeStaff.setUpdatedBy(userBy);
				storeStaff.setCreatedBy(userBy);
				SysStoreInfoEntity storeInfoEntity = sysStoreInfoyMap.get(item.getDepartmentId());
				//设置对应的门店id
				storeStaff.setStoreId(storeInfoEntity.getStoreId());
				insertUserInfoList.add(storeStaff);
				
				//创建人员门店关系表
				staffRelaEntity = new SysStoreStaffRelaEntity();
				staffRelaEntity.generatePk();
				staffRelaEntity.setPartyId(partyId);
				staffRelaEntity.setStoreId(sysStoreInfoyMap.get(item.getDepartmentId()).getStoreId());
				staffRelaEntity.setUpdatedBy(userBy);
				staffRelaEntity.setCreatedBy(userBy);
				sysStoreStaffRelaInserts.add(staffRelaEntity);
				//创建组织关系表
				relationshipEntity = new PartyRelationshipEntity();
				relationshipEntity.generatePk();
				relationshipEntity.setRelationshipTypeCode(Constants.RelationshipTypeCode.USER.value());
				relationshipEntity.setSrcPartyId(partyId);
				//这一块填写门店id
				relationshipEntity.setTagPartyId(staffRelaEntity.getStoreId());
				relationshipEntity.setCreatedBy(userBy);
				relationshipEntity.setUpdatedBy(userBy);
				partyRelationshipList.add(relationshipEntity);
				
			}
			LOGGER.info("准备更新门店人员数据....2");
			//统一更新或新增
			if(!CollectionUtils.isEmpty(insertUserInfoList)){
				HashSet<String> set = new HashSet<>(insertUserInfoList.size());
				List<SysStoreStaffInfoEntity> result = new ArrayList<>(insertUserInfoList.size());
				for (SysStoreStaffInfoEntity entity : insertUserInfoList) {
		            if (set.add(entity.getIdmAccountName())) {
		                result.add(entity);
		            }
		        }
				insertUserInfoList.clear();
				insertUserInfoList.addAll(result);
				iSysStoreStaffInfoDao.batchInsert(insertUserInfoList);
			}
			LOGGER.info("准备更新门店人员数据....3");
			//统一更新或新增
			if(!CollectionUtils.isEmpty(updateStaffDetailsUserInfoList)){
				HashSet<String> set = new HashSet<>(updateStaffDetailsUserInfoList.size());
				List<SysStoreStaffDetailsEntity> result = new ArrayList<>(updateStaffDetailsUserInfoList.size());
				for (SysStoreStaffDetailsEntity entity : updateStaffDetailsUserInfoList) {
		            if (set.add(entity.getStaffCode())) {
		                result.add(entity);
		            }
		        }
				updateStaffDetailsUserInfoList.clear();
				updateStaffDetailsUserInfoList.addAll(result);
				iSysStoreStaffDetailsDao.batchUpdateSelective(updateStaffDetailsUserInfoList);
			}
			LOGGER.info("准备更新门店人员数据....4");
			if(!CollectionUtils.isEmpty(insertStaffDetailsUserInfoList)){
				HashSet<String> set = new HashSet<>(insertStaffDetailsUserInfoList.size());
				List<SysStoreStaffDetailsEntity> result = new ArrayList<>(insertStaffDetailsUserInfoList.size());
				for (SysStoreStaffDetailsEntity entity : insertStaffDetailsUserInfoList) {
		            if (set.add(entity.getStaffCode())) {
		                result.add(entity);
		            }
		        }
				insertStaffDetailsUserInfoList.clear();
				insertStaffDetailsUserInfoList.addAll(result);
				LOGGER.info("准备更新门店人员数据:{}条",insertStaffDetailsUserInfoList.size());
//				LOGGER.info("准备更新门店人员数据JSON:"+JSON.toJSONString(insertStaffDetailsUserInfoList));
				iSysStoreStaffDetailsDao.batchInsert(insertStaffDetailsUserInfoList);
			}
			LOGGER.info("准备更新门店人员数据....5");
			if(!CollectionUtils.isEmpty(sysStoreStaffRelaInserts)){
				HashSet<Long> set = new HashSet<>(sysStoreStaffRelaInserts.size());
				List<SysStoreStaffRelaEntity> result = new ArrayList<>(sysStoreStaffRelaInserts.size());
				for (SysStoreStaffRelaEntity entity : sysStoreStaffRelaInserts) {
		            if (set.add(entity.getPartyId())) {
		                result.add(entity);
		            }
		        }
				sysStoreStaffRelaInserts.clear();
				sysStoreStaffRelaInserts.addAll(result);
				LOGGER.info("准备更新门店人员数据:{}条",sysStoreStaffRelaInserts.size());
				iSysStoreStaffRelaDao.batchInsert(sysStoreStaffRelaInserts);
			}
			LOGGER.info("准备更新门店人员数据....6");
			if(!CollectionUtils.isEmpty(userInfoInsertDtos)){
				HashSet<String> set = new HashSet<>(userInfoInsertDtos.size());
				List<UserInfoInsertDto> result = new ArrayList<>(userInfoInsertDtos.size());
				for (UserInfoInsertDto entity : userInfoInsertDtos) {
		            if (set.add(entity.getIdmAccountName())) {
		                result.add(entity);
		            }
		        }
				userInfoInsertDtos.clear();
				userInfoInsertDtos.addAll(result);
				//同时同步更新到系统相关用户表
				jobReceiveRspUserInfoService.insertSysUserList(userInfoInsertDtos,true);
			}
			LOGGER.info("准备更新门店人员数据....7");
			if(CollectionUtils.isNotEmpty(partyRelationshipList)){
				HashSet<Long> set = new HashSet<>(partyRelationshipList.size());
				List<PartyRelationshipEntity> result = new ArrayList<>(partyRelationshipList.size());
				for (PartyRelationshipEntity entity : partyRelationshipList) {
		            if (set.add(entity.getSrcPartyId())) {
		                result.add(entity);
		            }
		        }
				partyRelationshipList.clear();
				partyRelationshipList.addAll(result);
				iPartyRelationshipDao.batchInsert(partyRelationshipList);
			}
			LOGGER.info("准备定时任务数据....8");
		}
		
		//更新接收表状态为已处理
		JobReceiveInfoEntity jobReceiveInfo = new JobReceiveInfoEntity();
		jobReceiveInfo.setReceiveId(slf.getReceiveId());
		jobReceiveInfo.setProcessingStatus(Constants.JobProcessingStatus.SUCCESS.value());
		iJobReceiveInfoDao.updateSelective(jobReceiveInfo);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void synSmpUserInfo(JobReceiveRspEntity smp, String orgId) {
		LOGGER.info("===smp人员数据orgId==="+orgId);
		JSONObject jsonObject = JSON.parseObject(smp.getReceiveRspData());
		Object data = jsonObject.get("data");
		List<SmpUserInfoDto> accountInfoDtos = JSON.parseArray(JSON.toJSONString(data), SmpUserInfoDto.class);

		//获取所有登录信息
		List<LoginInfoEntity> loginInfoEntities = iLoginInfoDao.selectBySelective(new LoginInfoEntity());
		Map<String, LoginInfoEntity> loginInfoEntityMap;
		if(org.springframework.util.CollectionUtils.isEmpty(loginInfoEntities)){
			loginInfoEntityMap = new HashMap<>();
		}else{
			loginInfoEntityMap = loginInfoEntities.stream().collect(Collectors.toMap(p -> p.getLoginName(), p -> p ));
		}

		//查询所有基础人员信息表
		List<SysStoreStaffDetailsDto> sysStoreStaffDetailsEntities = sysStoreDetailsDao.selectAllStoreStaffList();
		//查询所有可用门店数据
		SysStoreInfoEntity sysStoreInfoEntity = new SysStoreInfoEntity();
		List<SysStoreInfoEntity> sysStoreInfoList = iSysStoreInfoDao.selectBySelective(sysStoreInfoEntity);

		//进行比对，筛选所有需要新增和更新的人员
		Map<String, SysStoreInfoEntity> sysStoreInfoyMap;
		if(CollectionUtils.isEmpty(sysStoreInfoList)){
			sysStoreInfoyMap = new HashMap<>();
		}else{
			sysStoreInfoyMap = sysStoreInfoList.stream().collect(Collectors.toMap(p -> p.getOrgId(), p -> p ));
		}

		Map<String, SysStoreStaffDetailsDto> staffDetailsMapAll;
		if(CollectionUtils.isEmpty(sysStoreStaffDetailsEntities)){
			staffDetailsMapAll = new HashMap<>();
		}else{
			staffDetailsMapAll = sysStoreStaffDetailsEntities.stream().collect(Collectors.toMap(p -> p.getLoginName(), p -> p,(p1,p2) ->p1 ));
		}
		Long userBy= AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
		//记录map
		List<SysStoreStaffInfoEntity> insertUserInfoList = new LinkedList<>();
		List<SysStoreStaffDetailsEntity> insertStaffDetailsUserInfoList = new LinkedList<>();
		List<SysStoreStaffDetailsEntity> updateStaffDetailsUserInfoList = new LinkedList<>();
		List<SysStoreStaffRelaEntity> sysStoreStaffRelaInserts = new LinkedList<>();
		List<UserInfoInsertDto> userInfoInsertDtos = new LinkedList<>();
		List<PartyRelationshipEntity> partyRelationshipList = new LinkedList<>();

		SysStoreStaffInfoEntity storeStaff;
		SysStoreStaffDetailsEntity staffDetailsEntity;
		SysStoreStaffRelaEntity staffRelaEntity;
		UserInfoInsertDto userInfoInsertDto;
		PartyRelationshipEntity relationshipEntity;
		List<SmpUserInfoDto> accountInfoDtoList = accountInfoDtos.stream().filter(s-> StringUtils.isNotBlank(s.getIdmAccountName())).collect(Collectors.toList());
//		LOGGER.info("smp过滤后的有效数据:"+JSON.toJSONString(accountInfoDtoList));
		Long partyId;
		//先清空对应的人员门店关系表数据
		if(CollectionUtils.isNotEmpty(accountInfoDtoList)){
			//获取当前数据的门店id
			Long storeId = sysStoreInfoyMap.get(orgId).getStoreId();
			refreshStoreStaffRela(storeId,null);
		}
		List<SysStoreStaffUserMappingEntity> listSysStoreStaffUserMappingEntity=new ArrayList<SysStoreStaffUserMappingEntity>();
		LOGGER.info("准备过滤门店人员数据....1");
		for (SmpUserInfoDto item:accountInfoDtoList) {
			item.setDepartmentId(orgId);
			String staffKey = item.getIdmAccountName();
			if(loginInfoEntityMap.containsKey(item.getIdmAccountName())){
				partyId = loginInfoEntityMap.get(item.getIdmAccountName()).getPartyId();
			}else{
				partyId = RandomIDGennerator.get().generate();
			}

			if(!loginInfoEntityMap.containsKey(item.getIdmAccountName())){
				//创建用户系统登录相关表
				userInfoInsertDto = new UserInfoInsertDto(
						partyId,
						Constants.PartyType.PERSON.value(),
						item.getUserName(),
						null,
						item.getIdmAccountName(),
						Constants.ValidMark.VALID.value()
				);
				userInfoInsertDtos.add(userInfoInsertDto);
				loginInfoEntityMap.put(item.getIdmAccountName(),Copiers.beanToBean(userInfoInsertDto, UserInfoInsertDto.class, LoginInfoEntity.class));
			}
			
			//维护人员基础信息表和登录相关
			if(staffDetailsMapAll.containsKey(staffKey)){
				SysStoreStaffDetailsDto detailsDto = staffDetailsMapAll.get(staffKey);
				staffDetailsEntity =
						Copiers.beanToBean(detailsDto, SysStoreStaffDetailsDto.class, SysStoreStaffDetailsEntity.class);

				staffDetailsEntity.setUpdatedBy(userBy);
				staffDetailsEntity.setStaffName(item.getUserName());
//				staffDetailsEntity.setStaffCode(item.getUserId());
				staffDetailsEntity.setUpdatedDate(new Date());
				updateStaffDetailsUserInfoList.add(staffDetailsEntity);
			}else{
				staffDetailsEntity = new SysStoreStaffDetailsEntity();
				staffDetailsEntity.setPartyId(partyId);
				staffDetailsEntity.setIsDelete(Constants.IsDelete.NO.value());
				staffDetailsEntity.setCreatedBy(userBy);
				staffDetailsEntity.setCreatedDate(new Date());
				staffDetailsEntity.setUpdatedBy(userBy);
				staffDetailsEntity.setUpdatedDate(new Date());
				//门店人员默认启用
				staffDetailsEntity.setStaffStatus(Constants.staffStatus.disable.value());
				staffDetailsEntity.setStaffType(Constants.StaffType.store.value());
				staffDetailsEntity.setStaffCode(item.getUserId());
				staffDetailsEntity.setStaffName(item.getUserName());
				staffDetailsEntity.setStaffIphone(AesUtils.encryptHex(item.getPhoneNumber(), ucmpAesConfig.getSecret()));
				insertStaffDetailsUserInfoList.add(staffDetailsEntity);
				SysStoreStaffDetailsDto staffDetailsDto = Copiers.beanToBean(staffDetailsEntity, SysStoreStaffDetailsEntity.class, SysStoreStaffDetailsDto.class);
				staffDetailsDto.setLoginName(item.getIdmAccountName());
				staffDetailsMapAll.put(staffDetailsEntity.getStaffCode() + item.getIdmAccountName(),staffDetailsDto);
			}

			SysStoreStaffUserMappingEntity sysStoreStaffUserMappingEntity=new SysStoreStaffUserMappingEntity();
			sysStoreStaffUserMappingEntity.setPartyId(partyId);
			sysStoreStaffUserMappingEntity.setUserId(item.getUserId());
			int count = this.iSysStoreStaffUserMappingDao.selectBySelectiveCount(sysStoreStaffUserMappingEntity);
			if(count==0){
				//添加SMP 人员 userId映射
				SysStoreStaffUserMappingEntity insert=new SysStoreStaffUserMappingEntity();
				insert.setCreatedBy(77777L);
				insert.setUpdatedBy(77777L);
				insert.setIsDelete("01");
				insert.generatePk();
				insert.setPartyId(partyId);
				insert.setUserId(item.getUserId());
				iSysStoreStaffUserMappingDao.insert(insert);
				listSysStoreStaffUserMappingEntity.add(insert);
			}
			
			//重新创建门店人员业务关联信息表
			if(CollectionUtils.isNotEmpty(item.getRoleList())){
				for (SmpRoleListDto smpRole : item.getRoleList()) {
					if(smpRole !=null){
						storeStaff = new SysStoreStaffInfoEntity();
						storeStaff.generatePk();
						storeStaff.setPartyId(partyId);
						storeStaff.setUserId(Long.valueOf(item.getUserId()));
						storeStaff.setUserName(item.getUserName());
						storeStaff.setIdmAccountName(item.getIdmAccountName());
						storeStaff.setPhoneNumber(AesUtils.encryptHex(item.getPhoneNumber(), ucmpAesConfig.getSecret()));
						storeStaff.setRoleCode(smpRole.getRoleCode());
						storeStaff.setRoleName(smpRole.getRoleName());
						storeStaff.setUpdatedBy(userBy);
						storeStaff.setCreatedBy(userBy);
						SysStoreInfoEntity storeInfoEntity = sysStoreInfoyMap.get(item.getDepartmentId());
						//设置对应的门店id
						storeStaff.setStoreId(storeInfoEntity.getStoreId());
						insertUserInfoList.add(storeStaff);
					}
				}
			}

			//创建人员门店关系表
			staffRelaEntity = new SysStoreStaffRelaEntity();
			staffRelaEntity.generatePk();
			staffRelaEntity.setPartyId(partyId);
			staffRelaEntity.setStoreId(sysStoreInfoyMap.get(item.getDepartmentId()).getStoreId());
			staffRelaEntity.setUpdatedBy(userBy);
			staffRelaEntity.setCreatedBy(userBy);
			sysStoreStaffRelaInserts.add(staffRelaEntity);
			//创建组织关系表
			relationshipEntity = new PartyRelationshipEntity();
			relationshipEntity.generatePk();
			relationshipEntity.setRelationshipTypeCode(Constants.RelationshipTypeCode.USER.value());
			relationshipEntity.setSrcPartyId(partyId);
			//这一块填写门店id
			relationshipEntity.setTagPartyId(staffRelaEntity.getStoreId());
			relationshipEntity.setCreatedBy(userBy);
			relationshipEntity.setUpdatedBy(userBy);
			partyRelationshipList.add(relationshipEntity);

		}
		
//		this.iSysStoreStaffUserMappingDao.batchInsert(listSysStoreStaffUserMappingEntity);
		
		LOGGER.info("准备更新门店人员数据....2");
		//统一更新或新增
		if(!CollectionUtils.isEmpty(insertUserInfoList)){
//			LOGGER.info("====iSysStoreStaffInfoDao.batchInsert===="+JsonBeanUtil.beanToJson(insertUserInfoList));
			iSysStoreStaffInfoDao.batchInsert(insertUserInfoList);
		}
		LOGGER.info("准备更新门店人员数据....3");
		//统一更新或新增
		if(!CollectionUtils.isEmpty(updateStaffDetailsUserInfoList)){
			iSysStoreStaffDetailsDao.batchUpdateSelective(updateStaffDetailsUserInfoList);
		}
		LOGGER.info("准备更新门店人员数据....4");
		if(!CollectionUtils.isEmpty(insertStaffDetailsUserInfoList)){
			LOGGER.info("准备更新门店人员数据:{}条",insertStaffDetailsUserInfoList.size());
//			LOGGER.info("准备更新门店人员数据JSON:"+JSON.toJSONString(insertStaffDetailsUserInfoList));
			iSysStoreStaffDetailsDao.batchInsert(insertStaffDetailsUserInfoList);
		}
		LOGGER.info("准备更新门店人员数据....5");
		if(!CollectionUtils.isEmpty(sysStoreStaffRelaInserts)){
			LOGGER.info("准备更新门店人员数据:{}条",sysStoreStaffRelaInserts.size());
			iSysStoreStaffRelaDao.batchInsert(sysStoreStaffRelaInserts);
		}
		LOGGER.info("准备更新门店人员数据....6");
		if(!CollectionUtils.isEmpty(userInfoInsertDtos)){
			//同时同步更新到系统相关用户表
			jobReceiveRspUserInfoService.insertSysUserList(userInfoInsertDtos,true);
		}
		LOGGER.info("准备更新门店人员数据....7");
		if(CollectionUtils.isNotEmpty(partyRelationshipList)){
			iPartyRelationshipDao.batchInsert(partyRelationshipList);
		}
		LOGGER.info("准备定时任务数据....8");
		//更新接收表状态为已处理
		JobReceiveInfoEntity jobReceiveInfo = new JobReceiveInfoEntity();
		jobReceiveInfo.setReceiveId(smp.getReceiveId());
		jobReceiveInfo.setProcessingStatus(Constants.JobProcessingStatus.SUCCESS.value());
		iJobReceiveInfoDao.updateSelective(jobReceiveInfo);
	}
}
