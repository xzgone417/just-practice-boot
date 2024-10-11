package com.exp.ucmp.xxljob.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.EncrytPassword;
import com.egrid.core.util.Md5Util;
import com.egrid.core.util.StringUtil;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.parentUser.dto.JobReceiveRspUserInfoDto;
import com.exp.ucmp.storeApp.dto.UserInfoInsertDto;
import com.exp.ucmp.user.service.IdmUserService;
import com.exp.ucmp.util.AesUtils;
import com.exp.ucmp.xxljob.dao.IXxlJobDao;
import com.exp.ucmp.xxljob.dao.JobReceiveRspUserInfoDao;
import com.exp.ucmp.xxljob.service.JobReceiveRspUserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JobReceiveRspUserInfoImpl implements JobReceiveRspUserInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobReceiveRspUserInfoImpl.class);
    @Autowired
    private ISysOrganizationStaffInfoDao iJobReceiveRspUserInfoDao;
    @Autowired
    private JobReceiveRspUserInfoDao jobReceiveRspUserInfoDao;

    @Autowired
    private IdmUserService idmUserService;

    @Autowired
    private IXxlJobDao iXxlJobDao;

    @Autowired
    private IJobReceiveInfoDao iJobReceiveInfoDao;

    @Autowired
    private  IPartyInfoDao iPartyInfoDao;

    @Autowired
    private  IPersonInfoDao iPersonInfoDao;

    @Autowired
    private  IUserInfoDao iUserInfoDao;
    @Autowired
    private UcmpAesConfig ucmpAesConfig;
    @Autowired
    private  ILoginInfoDao iLoginInfoDao;

    @Autowired
    private  IPartyRelationshipDao iPartyRelationshipDao;

    @Autowired
    private IPartyRoleRelaDao iPartyRoleRelaDao;

    @Autowired
    ISysStaffDetailsDao iSysStaffDetailsDao;

    @Override
    @Transactional
    public void batchUpdateParentUserInfo(List<JobReceiveRspEntity> rspList){
//            try{
                rspList.forEach(rsp->{
                    JSONObject jsonObject = JSON.parseObject(rsp.getReceiveRspData());
                    Object data = jsonObject.get("data");
                    if(!Objects.isNull(data) && jsonObject.get("status").equals("200")){
                        List<SysOrganizationStaffInfoEntity> list  = JSON.parseArray(data.toString(),SysOrganizationStaffInfoEntity.class);
                        //对数据进行更新
                        LOGGER.info("[人员管理]待更新{}条",list.size());
                        batchInsertOrUpdateParentUser(list);
                    }
                    //更新接收表状态为已处理
                    JobReceiveInfoEntity jobReceiveInfo = new JobReceiveInfoEntity();
                    jobReceiveInfo.setReceiveId(rsp.getReceiveId());
                    jobReceiveInfo.setProcessingStatus(Constants.JobProcessingStatus.SUCCESS.value());
                    iJobReceiveInfoDao.updateSelective(jobReceiveInfo);
                });
//            }catch (Exception e){
//                LOGGER.error("[人员管理]更新异常:",e);
//                e.printStackTrace();
//                throw new RuntimeException();
//            }

    }

    /**
     * 新增系统人员信息相关表
     * t_login_info表需生成2条记录，
     * 一条记录为需要密码登录，一条记录为免提登录
     * 用户名和密码都为 idmAccountName字段
     * @param sysUserList
     * @param  isStoreUser 是否是门店人员，门店人员需要手动新增组织关系表
     */
    @Override
    public void insertSysUserList(List<UserInfoInsertDto> sysUserList,boolean isStoreUser) {
        try{
            if(!CollectionUtils.isEmpty(sysUserList)){
                //获取所有登录信息
                List<LoginInfoEntity> loginInfoEntities = iLoginInfoDao.selectBySelective(new LoginInfoEntity());
                Map<String, LoginInfoEntity> loginInfoEntityMap;
                if(CollectionUtils.isEmpty(loginInfoEntities)){
                    loginInfoEntityMap = new HashMap<>();
                }else{
                    loginInfoEntityMap = loginInfoEntities.stream().collect(Collectors.toMap(p -> p.getLoginName(), p -> p ));
                }

                List<PartyInfoEntity> partyInfoList = new LinkedList();
                List<PersonInfoEntity> personInfoList = new LinkedList();
                List<UserInfoEntity> userInfoList = new LinkedList<>();
                List<LoginInfoEntity> loginInfoList = new LinkedList<>();
                List<PartyRelationshipEntity> partyRelationshipList = new LinkedList<>();
                Long createdBy = AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
                //Long createdBy = 666L;
                for (UserInfoInsertDto item :sysUserList) {
                    //已有的账户不进行创建操作
                    if(loginInfoEntityMap.containsKey(item.getIdmAccountName())||
                            loginInfoEntityMap.containsKey(Md5Util.getMD5String(item.getIdmAccountName()))){
                        continue;
                    }
                    PartyInfoEntity partyInfoEntity = new PartyInfoEntity();
                    partyInfoEntity.setPartyId(item.getPartyId());
                    partyInfoEntity.setCreatedBy(createdBy);
                    partyInfoEntity.setUpdatedBy(createdBy);
                    partyInfoEntity.setPartyType(Constants.PartyType.PERSON.value());
                    partyInfoList.add(partyInfoEntity);

                    PersonInfoEntity personInfoEntity = new PersonInfoEntity();
                    personInfoEntity.setPartyId(item.getPartyId());
                    personInfoEntity.setCreatedBy(createdBy);
                    personInfoEntity.setUpdatedBy(createdBy);
                    personInfoEntity.setSexTypeCode(item.getSexTypeCode());
                    personInfoEntity.setPersonName(item.getPersonName());
                    personInfoList.add(personInfoEntity);

                    //用户名和密码都为 idmAccountName字段
                    UserInfoEntity userInfoEntity = new UserInfoEntity();
                    userInfoEntity.setPartyId(item.getPartyId());
                    EncrytPassword encrytPassword = new EncrytPassword(item.getIdmAccountName());
                    userInfoEntity.setLoginPassword(encrytPassword.getEncrytPassword());
                    userInfoEntity.setLoginSalt(encrytPassword.getSalt());
                    userInfoEntity.setIsLock(Constants.IsLock.UNLOCK.value());
                    userInfoEntity.setCreatedBy(createdBy);
                    userInfoEntity.setUpdatedBy(createdBy);
                    userInfoList.add(userInfoEntity);

                    //t_login_info表需要生成2条记录，
                    //一条记录为需要密码登录，一条记录为免提登录
                    LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
                    loginInfoEntity.generatePk();
                    loginInfoEntity.setPartyId(item.getPartyId());
                    loginInfoEntity.setLoginName(item.getIdmAccountName());
                    loginInfoEntity.setIsPrimary(Constants.IsPrimary.YES.value());
                    loginInfoEntity.setIsPassword(Constants.IsPassword.password.value());

                    loginInfoEntity.setValidMark(item.getValidMark());
                    loginInfoEntity.setCreatedBy(createdBy);
                    loginInfoEntity.setUpdatedBy(createdBy);
                    loginInfoList.add(loginInfoEntity);

                    LoginInfoEntity loginInfoEntity1 = new LoginInfoEntity();
                    loginInfoEntity1.generatePk();
                    loginInfoEntity1.setPartyId(item.getPartyId());
                    loginInfoEntity1.setLoginName(Md5Util.getMD5String(item.getIdmAccountName()));
                    loginInfoEntity1.setIsPrimary(Constants.IsPrimary.NO.value());
                    loginInfoEntity1.setIsPassword(Constants.IsPassword.nopassword.value());
                    loginInfoEntity1.setValidMark(item.getValidMark());

                    loginInfoEntity1.setCreatedBy(createdBy);
                    loginInfoEntity1.setUpdatedBy(createdBy);
                    loginInfoList.add(loginInfoEntity1);
                    //新增人员组织关系表
                    if(!isStoreUser){
                        PartyRelationshipEntity partyRelationshipEntity = new PartyRelationshipEntity();
                        partyRelationshipEntity.generatePk();
                        partyRelationshipEntity.setRelationshipTypeCode(Constants.RelationshipTypeCode.USER.value());
                        partyRelationshipEntity.setSrcPartyId(item.getPartyId());
                        partyRelationshipEntity.setTagPartyId(Constants.HRYT_PARTY_ID);
                        partyRelationshipEntity.setCreatedBy(createdBy);
                        partyRelationshipEntity.setUpdatedBy(createdBy);
                        partyRelationshipList.add(partyRelationshipEntity);
                    }
                }
                //统一新增
                if(!CollectionUtils.isEmpty(partyInfoList)){
                    iPartyInfoDao.batchInsert(partyInfoList);
                }
                if(!CollectionUtils.isEmpty(personInfoList)){
                    iPersonInfoDao.batchInsert(personInfoList);
                }
                if(!CollectionUtils.isEmpty(userInfoList)){
                    iUserInfoDao.batchInsert(userInfoList);
                }
                if(!CollectionUtils.isEmpty(loginInfoList)){
                    iLoginInfoDao.batchInsert(loginInfoList);
                }
                if(!CollectionUtils.isEmpty(partyRelationshipList)){
                    iPartyRelationshipDao.batchInsert(partyRelationshipList);
                }
            }
        }catch (Exception e){
            LOGGER.error("SysParentUserInfoServiceImpl.insertSysUserList()批量插入或更新人员数据异常:",e);
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
		LOGGER.info("========="+Md5Util.getMD5String("JiaShen"));
	}
    @Transactional
    @Override
    public SysStaffDetailsEntity insertParentUserInfo(SysStaffDetailsEntity staffDetailsEntity,Long tagPartyId) {
        Long createdBy = AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();

        //获取所有登录信息
        List<LoginInfoEntity> loginInfoEntities = iLoginInfoDao.selectBySelective(new LoginInfoEntity());
        Map<String, LoginInfoEntity> loginInfoEntityMap;
        if(CollectionUtils.isEmpty(loginInfoEntities)){
            loginInfoEntityMap = new HashMap<>();
        }else{
            loginInfoEntityMap = loginInfoEntities.stream().collect(Collectors.toMap(p -> p.getLoginName(), p -> p ));
        }

        //获取所有业务信息
        Long partyId = null;
        //判断该手机号是否已创建
        if(loginInfoEntityMap.containsKey(staffDetailsEntity.getStaffIphone())){
            partyId = loginInfoEntityMap.get(staffDetailsEntity.getStaffIphone()).getPartyId();
        }else if(loginInfoEntityMap.containsKey(Md5Util.getMD5String(staffDetailsEntity.getStaffIphone()))){
            partyId = loginInfoEntityMap.get(Md5Util.getMD5String(staffDetailsEntity.getStaffIphone())).getPartyId();
        }
        if(null == partyId){
            //新增人员业务信息
            staffDetailsEntity.generatePk();
            staffDetailsEntity.setCreatedBy(createdBy);
            staffDetailsEntity.setUpdatedBy(createdBy);
            staffDetailsEntity.setIsDelete(Constants.IsDelete.NO.value());
            staffDetailsEntity.setStaffStatus(Constants.staffStatus.disable.value());
            staffDetailsEntity.setStaffCode(String.valueOf(RandomIDGennerator.getCurrentCounter()));
            iSysStaffDetailsDao.insertSelective(staffDetailsEntity);
        }else{
            staffDetailsEntity.setPartyId(partyId);
            staffDetailsEntity.setUpdatedBy(createdBy);
            staffDetailsEntity.setUpdatedDate(new Date());
            staffDetailsEntity.setIsDelete(Constants.IsDelete.NO.value());
            staffDetailsEntity.setStaffStatus(Constants.staffStatus.disable.value());
            iSysStaffDetailsDao.updateSelective(staffDetailsEntity);
        }
        //新增人员组织关系表
        PartyRelationshipEntity partyRelationshipEntity = new PartyRelationshipEntity();
        partyRelationshipEntity.generatePk();
        partyRelationshipEntity.setRelationshipTypeCode(Constants.RelationshipTypeCode.USER.value());
        partyRelationshipEntity.setSrcPartyId(staffDetailsEntity.getPartyId());
        partyRelationshipEntity.setTagPartyId(tagPartyId == null ? Constants.HRYT_PARTY_ID:tagPartyId);
        partyRelationshipEntity.setCreatedBy(createdBy);
        partyRelationshipEntity.setUpdatedBy(createdBy);
        iPartyRelationshipDao.insert(partyRelationshipEntity);


        if(!loginInfoEntityMap.containsKey(staffDetailsEntity.getStaffIphone())&&
                !loginInfoEntityMap.containsKey(Md5Util.getMD5String(staffDetailsEntity.getStaffIphone()))){
            //新增系统相关信息
            PartyInfoEntity partyInfoEntity = new PartyInfoEntity();
            partyInfoEntity.setPartyId(staffDetailsEntity.getPartyId());
            partyInfoEntity.setCreatedBy(createdBy);
            partyInfoEntity.setUpdatedBy(createdBy);
            partyInfoEntity.setPartyType(Constants.PartyType.PERSON.value());
            iPartyInfoDao.insert(partyInfoEntity);

            PersonInfoEntity personInfoEntity = new PersonInfoEntity();
            personInfoEntity.setPartyId(staffDetailsEntity.getPartyId());
            personInfoEntity.setCreatedBy(createdBy);
            personInfoEntity.setUpdatedBy(createdBy);
            personInfoEntity.setSexTypeCode(staffDetailsEntity.getStaffSex());
            personInfoEntity.setPersonName(staffDetailsEntity.getStaffName());
            iPersonInfoDao.insert(personInfoEntity);

            //用户名为手机号，密码默认123456
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            userInfoEntity.setPartyId(staffDetailsEntity.getPartyId());
            EncrytPassword encrytPassword = new EncrytPassword(Constants.DEFAULT_PASSWORD);
            userInfoEntity.setLoginPassword(encrytPassword.getEncrytPassword());
            userInfoEntity.setLoginSalt(encrytPassword.getSalt());
            userInfoEntity.setIsLock(Constants.IsLock.UNLOCK.value());
            userInfoEntity.setCreatedBy(createdBy);
            userInfoEntity.setUpdatedBy(createdBy);
            iUserInfoDao.insert(userInfoEntity);

            //t_login_info表需要生成2条记录，
            //一条记录为需要密码登录，一条记录为免提登录
            LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
            loginInfoEntity.generatePk();
            loginInfoEntity.setPartyId(staffDetailsEntity.getPartyId());
            loginInfoEntity.setLoginName(AesUtils.encryptHex(staffDetailsEntity.getStaffIphone(), ucmpAesConfig.getSecret()));
            loginInfoEntity.setIsPrimary(Constants.IsPrimary.YES.value());
            loginInfoEntity.setIsPassword(Constants.IsPassword.password.value());
            loginInfoEntity.setValidMark(Constants.ValidMark.VALID.value());
            loginInfoEntity.setCreatedBy(createdBy);
            loginInfoEntity.setUpdatedBy(createdBy);
            iLoginInfoDao.insert(loginInfoEntity);

            LoginInfoEntity loginInfoEntity1 = new LoginInfoEntity();
            loginInfoEntity1.generatePk();
            loginInfoEntity1.setPartyId(staffDetailsEntity.getPartyId());
            loginInfoEntity1.setLoginName(Md5Util.getMD5String(staffDetailsEntity.getStaffIphone()));
            loginInfoEntity1.setIsPrimary(Constants.IsPrimary.NO.value());
            loginInfoEntity1.setIsPassword(Constants.IsPassword.nopassword.value());
            loginInfoEntity1.setValidMark(Constants.ValidMark.VALID.value());
            loginInfoEntity1.setCreatedBy(createdBy);
            loginInfoEntity1.setUpdatedBy(createdBy);
            iLoginInfoDao.insert(loginInfoEntity1);
        }


        return staffDetailsEntity;
    }

    @Override
    @Transactional
    public void updateParentUserInfo(SysStaffDetailsEntity parentUserInfo) {
        //更新人员业务表信息
        Long userBy = AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
        parentUserInfo.setUpdatedBy(userBy);
        parentUserInfo.setUpdatedDate(new Date());
        iSysStaffDetailsDao.updateSelective(parentUserInfo);
        //更新t_person_info表信息
        PersonInfoEntity personInfoEntity = new PersonInfoEntity();
        personInfoEntity.setPartyId(parentUserInfo.getPartyId());
        personInfoEntity.setPersonName(parentUserInfo.getStaffName());
        iPersonInfoDao.updateSelective(personInfoEntity);
        //判断是否需要更新登录信息
        LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
        loginInfoEntity.setPartyId(parentUserInfo.getPartyId());
        List<LoginInfoEntity> loginInfoEntities = iLoginInfoDao.selectBySelective(loginInfoEntity);
        boolean isUpdate = false;
        for (LoginInfoEntity item: loginInfoEntities) {
            String encryptHex = AesUtils.encryptHex(parentUserInfo.getStaffIphone(), ucmpAesConfig.getSecret());
            if(item.getIsPrimary().equals(Constants.IsPrimary.YES.value())
                    && !item.getLoginName().equals(encryptHex)
                    ){
                isUpdate = true;
                item.setLoginName(encryptHex);
            }else if(item.getIsPrimary().equals(Constants.IsPrimary.NO.value())
                    &&!item.getLoginName().equals(Md5Util.getMD5String(parentUserInfo.getStaffIphone()))){
                isUpdate = true;
                item.setLoginName(Md5Util.getMD5String(parentUserInfo.getStaffIphone()));
            }
        }
        //更新登录信息
        if(isUpdate){
            iLoginInfoDao.batchUpdate(loginInfoEntities);
        }
    }

    /**
     * 批量新增或更新总部人员信息
     * @param list 最新响应数据
     */
    @Override
    @Transactional
    public void batchInsertOrUpdateParentUser(List<SysOrganizationStaffInfoEntity> list){
        if(!CollectionUtils.isEmpty(list)){
            //查询所有人员数据
            SysOrganizationStaffInfoEntity parentUserInfoEntity1 = new SysOrganizationStaffInfoEntity();
            parentUserInfoEntity1.setIsDelete(Constants.IsDelete.NO.value());
            List<SysOrganizationStaffInfoEntity> userInfoList = iJobReceiveRspUserInfoDao.selectBySelective(parentUserInfoEntity1);

            SysStaffDetailsEntity staffDetailsEntity1 = new SysStaffDetailsEntity();
            staffDetailsEntity1.setIsDelete("0");
            staffDetailsEntity1.setStaffType(Constants.StaffType.headquarters.value());
            List<SysStaffDetailsEntity> staffDetailsList = iSysStaffDetailsDao.selectBySelective(staffDetailsEntity1);

            //进行比对，筛选所有需要新增和更新的人员
            Map<String, SysOrganizationStaffInfoEntity> userInfoMapAll = userInfoList.stream().collect(Collectors.toMap(p -> p.getHhrEmpid(), p -> p ));
            Map<String, SysStaffDetailsEntity> staffDetailsMapAll = staffDetailsList.stream().collect(Collectors.toMap(p -> p.getStaffCode(), p -> p ,(k,v)->k));

            List<SysOrganizationStaffInfoEntity> insertUserInfoList = new LinkedList<>();
            List<SysOrganizationStaffInfoEntity> updateUserInfoList = new LinkedList<>();
            List<SysStaffDetailsEntity> insertStaffDetailsUserInfoList = new LinkedList<>();
            List<SysStaffDetailsEntity> updateStaffDetailsUserInfoList = new LinkedList<>();
            //Long userBy = 888L;
            Long userBy= AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
            list.forEach(item->{
            	//idmAccountname为空的先忽略
            	if(!StringUtil.isEmpty(item.getIdmAccountname())){
            		SysOrganizationStaffInfoEntity parentUserInfoEntity;
            		SysStaffDetailsEntity staffDetailsEntity;
            		if(userInfoMapAll.containsKey(item.getHhrEmpid())){
            			parentUserInfoEntity = userInfoMapAll.get(item.getHhrEmpid());
            			item.setRspUserInfoId(parentUserInfoEntity.getRspUserInfoId());
            			item.setIsEnable(parentUserInfoEntity.getIsEnable());
            			item.setUpdatedBy(userBy);
            			item.setUpdatedDate(new Date());
            			updateUserInfoList.add(item);
            		}else{
            			item.generatePk();
            			item.setCreatedBy(userBy);
            			item.setCreatedDate(new Date());
            			item.setUpdatedBy(userBy);
            			item.setUpdatedDate(new Date());
            			item.setIsDelete(Constants.IsDelete.NO.value());
            			//总部人员默认禁用
            			item.setIsEnable(Constants.ParentUserInfoStatus.DISABLE.value());
            			insertUserInfoList.add(item);
            		}
            		if(staffDetailsMapAll.containsKey(item.getHhrEmpid())){
            			staffDetailsEntity = staffDetailsMapAll.get(item.getHhrEmpid());
            			staffDetailsEntity.setUpdatedBy(userBy);
            			staffDetailsEntity.setUpdatedDate(new Date());
            			staffDetailsEntity.setStaffEmail(item.getIdmEmail());
            			staffDetailsEntity.setStaffSex(item.getHhrGender());
            			staffDetailsEntity.setStaffIphone(item.getHhrPhoneNum());
            			updateStaffDetailsUserInfoList.add(staffDetailsEntity);
            		}else{
            			//同时更新基础业务表
            			staffDetailsEntity = new SysStaffDetailsEntity();
            			staffDetailsEntity.setPartyId(item.getRspUserInfoId());
            			staffDetailsEntity.setIsDelete(Constants.IsDelete.NO.value());
            			staffDetailsEntity.setCreatedBy(userBy);
            			staffDetailsEntity.setCreatedDate(new Date());
            			staffDetailsEntity.setUpdatedBy(userBy);
            			staffDetailsEntity.setUpdatedDate(new Date());
            			//总部人员默认禁用
            			staffDetailsEntity.setStaffStatus(Constants.staffStatus.enable.value());
            			staffDetailsEntity.setStaffType(Constants.StaffType.headquarters.value());
            			staffDetailsEntity.setStaffCode(item.getHhrEmpid());
            			staffDetailsEntity.setStaffName(item.getHhrName());
            			staffDetailsEntity.setStaffEmail(item.getIdmEmail());
            			staffDetailsEntity.setStaffSex(item.getHhrGender());
            			staffDetailsEntity.setStaffIphone(item.getHhrPhoneNum());
            			insertStaffDetailsUserInfoList.add(staffDetailsEntity);
            		}
            	}
            });
             //统一更新或新增
            if(!CollectionUtils.isEmpty(updateUserInfoList)){
                iJobReceiveRspUserInfoDao.batchUpdateSelective(updateUserInfoList);
            }
            if(!CollectionUtils.isEmpty(updateStaffDetailsUserInfoList)){
                iSysStaffDetailsDao.batchUpdateSelective(updateStaffDetailsUserInfoList);
            }
            if(!CollectionUtils.isEmpty(insertUserInfoList)){
                iJobReceiveRspUserInfoDao.batchInsert(insertUserInfoList);
                iSysStaffDetailsDao.batchInsert(insertStaffDetailsUserInfoList);
                List<UserInfoInsertDto> sysUserList = new LinkedList<>();
                insertUserInfoList.forEach(item->{
                    //只有状态为已入职的员工才会创建登录相关账户
                    if(StringUtils.isNotBlank(item.getIdmAccountname()) && "Y".equals(item.getHhrStatus())){
                        sysUserList.add(new UserInfoInsertDto(
                                item.getRspUserInfoId(),
                                Constants.PartyType.PERSON.value(),
                                item.getHhrName(),
                                item.getHhrGender(),
                                item.getIdmAccountname(),
                                Constants.ValidMark.VALID.value()
                                )
                        );
                    }
                });
                //同时同步更新到系统相关用户表
                insertSysUserList(sysUserList,false);

            }
        }
    }

    @Override
    public PageInfo<JobReceiveRspUserInfoDto> findPage(JobReceiveRspUserInfoDto sysParentUserInfoDto) {
        PageHelper.startPage(sysParentUserInfoDto.getPageNum(), sysParentUserInfoDto.getPageSize());
        List<JobReceiveRspUserInfoDto> userInfoDtos = jobReceiveRspUserInfoDao.findListPage(sysParentUserInfoDto);
        return new PageInfo<>(userInfoDtos);
    }

    @Override
    @Transactional
    public void deleteUserInfoById(Long partyId) {
        //人员业务表逻辑删除
        SysStaffDetailsEntity sysStaffDetailsEntity = new SysStaffDetailsEntity();
        sysStaffDetailsEntity.setPartyId(partyId);
        sysStaffDetailsEntity.setIsDelete(Constants.IsDelete.YES.value());
        iSysStaffDetailsDao.updateSelective(sysStaffDetailsEntity);

        SysOrganizationStaffInfoEntity parentUserInfoEntity = new SysOrganizationStaffInfoEntity();
        parentUserInfoEntity.setRspUserInfoId(partyId);
        parentUserInfoEntity.setIsDelete(Constants.IsDelete.YES.value());
        iJobReceiveRspUserInfoDao.updateSelective(parentUserInfoEntity);

        //人员系统表相关删除
        PartyInfoEntity partyInfoEntity = new PartyInfoEntity();
        partyInfoEntity.setPartyId(partyId);
        iPartyInfoDao.deleteBySelective(partyInfoEntity);

        PersonInfoEntity personInfoEntity = new PersonInfoEntity();
        personInfoEntity.setPartyId(partyId);
        iPersonInfoDao.deleteBySelective(personInfoEntity);


        //用户名为手机号，密码默认123456
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setPartyId(partyId);
        iUserInfoDao.deleteBySelective(userInfoEntity);

        LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
        loginInfoEntity.setPartyId(partyId);
        iLoginInfoDao.deleteBySelective(loginInfoEntity);

        //删除人员组织关系表
        PartyRelationshipEntity partyRelationshipEntity = new PartyRelationshipEntity();
        partyRelationshipEntity.setSrcPartyId(partyId);
        partyRelationshipEntity.setTagPartyId(Constants.HRYT_PARTY_ID);
        iPartyRelationshipDao.deleteBySelective(partyRelationshipEntity);

        //删除角色关联表
        PartyRoleRelaEntity partyRoleRelaEntity = new PartyRoleRelaEntity();
        partyRoleRelaEntity.setPartyId(partyId);
        iPartyRoleRelaDao.deleteBySelective(partyRoleRelaEntity);

    }
}
