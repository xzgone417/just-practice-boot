package com.exp.ucmp.staff.service.impl;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.alibaba.nacos.common.utils.StringUtils;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.EncrytPassword;
import com.egrid.core.util.Md5Util;
import com.exp.ucmp.area.dto.SysAreaInfoDto;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.staff.dao.SysStaffDetailsDao;
import com.exp.ucmp.staff.dto.*;
import com.exp.ucmp.staff.service.SysStaffService;
import com.exp.ucmp.store.dao.SysStoreDetailsDao;
import com.exp.ucmp.store.dto.SysStoreInfoDto;
import com.exp.ucmp.store.dto.SysStoreStaffListDto;
import com.exp.ucmp.util.AesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhouchengwei
 * @date 2022年08月12日
 */
@Service
public class SysStaffServiceImpl implements SysStaffService {
    @Autowired
    private SysStaffDetailsDao sysStaffDetailsDao;
    @Autowired
    private ISysDepartmentStaffRelaDao iSysDepartmentStaffRelaDao;
    @Autowired
    private IPartyRoleRelaDao iPartyRoleRelaDao;
    @Autowired
    private IUserInfoDao iUserInfoDao;
    @Autowired
    private ILoginInfoDao iLoginInfoDao;
    @Autowired
    private IPartyInfoDao iPartyInfoDao;
    @Autowired
    private IPersonInfoDao iPersonInfoDao;
    @Autowired
    private ISysStaffDetailsDao iSysStaffDetailsDao;
    @Autowired
    private ISysStaffAreaRelaDao iSysStaffAreaRelaDao;
    @Autowired
    private ISysStaffAreaLogDao iSysStaffAreaLogDao;
    @Autowired
    private ISysPartnerDetailsDao iSysPartnerDetailsDao;
    @Autowired
    private ISysStoreInfoDao iSysStoreInfoDao;
    @Autowired
    private SysStoreDetailsDao storeDetailsDao;
    @Autowired
    private ISysStoreStaffRelaDao iSysStoreStaffRelaDao;
    @Autowired
    private ISysStoreStaffInfoDao iSysStoreStaffInfoDao;
    @Autowired
    private IOrganizationInfoDao organizationInfoDao;
    @Autowired
    private ISysStoreStaffDetailsDao iSysStoreStaffDetailsDao;
    @Autowired
    private UcmpAesConfig ucmpAesConfig;
    @Autowired
    private ISysPartnerStaffInfoDao iSysPartnerStaffInfoDao;
    @Autowired
    private ISysOrganizationStaffInfoDao iSysOrganizationStaffInfoDao;
    @Autowired
    private ISysStoreStaffUserMappingDao iSysStoreStaffUserMappingDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(SysStaffServiceImpl.class);

    @Transactional
    @Override
    public void insertPartyAndOrganization(Long partyId, String organName, String partyType) {
        PartyInfoEntity partyInfoEntity = new PartyInfoEntity();
        Long createdBy = AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
        partyInfoEntity.setPartyId(partyId);
        partyInfoEntity.setPartyType(partyType);
        partyInfoEntity.setCreatedBy(createdBy);
        partyInfoEntity.setUpdatedBy(createdBy);
        iPartyInfoDao.insert(partyInfoEntity);

        OrganizationInfoEntity organizationInfoEntity = new OrganizationInfoEntity();
        organizationInfoEntity.setPartyId(partyId);
        organizationInfoEntity.setCreatedBy(createdBy);
        organizationInfoEntity.setUpdatedBy(createdBy);
        organizationInfoEntity.setOrganName(organName);
        organizationInfoDao.insert(organizationInfoEntity);
    }

    /**
     * Description: 根据条件查询集合实体(人员信息)
     *
     * @param sysStaffDetailsDto 查询条件
     * @return 实体集合
     */
    @Override
    public PageInfo<SysStaffDetailsDto> queryStaff(SysStaffDetailsDto sysStaffDetailsDto) {
        //手机号加密查询
        if(StringUtils.isNotBlank(sysStaffDetailsDto.getStaffIphone())){
            sysStaffDetailsDto.setStaffIphone(AesUtils.encryptHex(sysStaffDetailsDto.getStaffIphone(), ucmpAesConfig.getSecret()));
        }
        PageHelper.startPage(sysStaffDetailsDto.getPageNum(), sysStaffDetailsDto.getPageSize());
        //人员管理列表只查询总部人员
        sysStaffDetailsDto.setStaffType(Constants.StaffType.headquarters.value());
        List<SysStaffDetailsDto> sysStaffDetailsDtoList = sysStaffDetailsDao.selectStaffMsg(sysStaffDetailsDto);
        try {
            //手机号解密再返回
            for (SysStaffDetailsDto item :sysStaffDetailsDtoList) {
                if(StringUtils.isNotBlank(item.getStaffIphone())){
                    item.setStaffIphone(AesUtils.decryptHex(item.getStaffIphone(), ucmpAesConfig.getSecret()));
                }
            }
        }catch (Exception e){
            LOGGER.error("手机号解密失败=========",e);
        }
        PageInfo<SysStaffDetailsDto> page = new PageInfo<>(sysStaffDetailsDtoList);
        return page;

    }

    @Override
    public List<String> queryStaffStatus() {
        return sysStaffDetailsDao.selectStaffStatus();
    }


    /**
     * Description: 新增人员信息
     *
     * @param sysStaffDetailsEditDto 新增内容
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void addStaffMsg(SysStaffDetailsAddDto sysStaffDetailsEditDto) {
        SysStaffDetailsEntity sysStaffDetailsEntity = new SysStaffDetailsEntity();
        sysStaffDetailsEntity.setStaffCode(sysStaffDetailsEditDto.getStaffCode());

        int staffCount = iSysStaffDetailsDao.selectBySelectiveCount(sysStaffDetailsEntity);
        try {
            if (staffCount > 0) {
                throw new IllegalParameterException("人员(" + sysStaffDetailsEditDto.getStaffName() + ")已存在，不能新增!");
            } else {
                sysStaffDetailsEntity =
                        Copiers.beanToBean(sysStaffDetailsEditDto, SysStaffDetailsAddDto.class, SysStaffDetailsEntity.class);
                sysStaffDetailsEntity.generatePk();
                sysStaffDetailsEntity.setStaffType(Constants.StaffType.headquarters.value());
                sysStaffDetailsEntity.setStaffStatus(Constants.staffStatus.enable.value());
                sysStaffDetailsEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                sysStaffDetailsEntity.setUpdatedBy(sysStaffDetailsEntity.getCreatedBy());
                iSysStaffDetailsDao.insertSelective(sysStaffDetailsEntity);


                LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
                loginInfoEntity.setLoginName(sysStaffDetailsEditDto.getStaffIphone());
                List<LoginInfoEntity> loginInfoEntities = iLoginInfoDao.selectBySelective(loginInfoEntity);
                if (loginInfoEntities.size()<=0){
                    loginInfoEntity.setLoginName(sysStaffDetailsEditDto.getStaffIphone());
                    loginInfoEntity.generatePk();
                    loginInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                    loginInfoEntity.setUpdatedBy(loginInfoEntity.getCreatedBy());
                    loginInfoEntity.setPartyId(sysStaffDetailsEntity.getPartyId());
                    loginInfoEntity.setIsPrimary(Constants.IsPrimary.YES.value());
                    iLoginInfoDao.insertSelective(loginInfoEntity);
                    loginInfoEntity.setLoginName(Md5Util.getMD5String(sysStaffDetailsEditDto.getStaffIphone()));
                    loginInfoEntity.setIsPassword(Constants.IsPassword.nopassword.value());
                    loginInfoEntity.generatePk();
                    iLoginInfoDao.insertSelective(loginInfoEntity);
                }else {
                    for (int i = 0; i <loginInfoEntities.size() ; i++) {
                        if (Constants.ValidMark.VALID.value().equals(loginInfoEntities.get(i).getValidMark()) && sysStaffDetailsEditDto.getStaffIphone().equals(loginInfoEntities.get(i).getLoginName())){
                            loginInfoEntity.setValidMark(Constants.ValidMark.VALID.value());
                            loginInfoEntity.setLoginId(loginInfoEntities.get(i).getLoginId());
                            iLoginInfoDao.updateSelective(loginInfoEntity);
                        }else if (Constants.ValidMark.VALID.value().equals(loginInfoEntities.get(i).getValidMark()) && sysStaffDetailsEditDto.getStaffIphone().equals(loginInfoEntities.get(i).getLoginName())){
                            throw new IllegalParameterException("人员登录名(" + sysStaffDetailsEditDto.getStaffIphone() + ")已存在，不能新增!");
                        }
                }
                }

                PartyInfoEntity partyInfoEntity = new PartyInfoEntity();
                partyInfoEntity.setPartyId(sysStaffDetailsEntity.getPartyId());
                partyInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                partyInfoEntity.setUpdatedBy(partyInfoEntity.getCreatedBy());
                partyInfoEntity.setPartyType(Constants.PartyType.PERSON.value());
                iPartyInfoDao.insertSelective(partyInfoEntity);


                PersonInfoEntity personInfoEntity = new PersonInfoEntity();
                personInfoEntity.setPartyId(sysStaffDetailsEntity.getPartyId());
                personInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                personInfoEntity.setUpdatedBy(personInfoEntity.getCreatedBy());
                personInfoEntity.setPersonName(sysStaffDetailsEditDto.getStaffName());
                iPersonInfoDao.insertSelective(personInfoEntity);

                UserInfoEntity userInfoEntity = new UserInfoEntity();
                userInfoEntity.setPartyId(sysStaffDetailsEntity.getPartyId());
                String passWord = Constants.UserPassword.defaultPwd.value();
                EncrytPassword encrytPassword = new EncrytPassword(passWord);
                final String salt = encrytPassword.getSalt();
                userInfoEntity.setLoginPassword(encrytPassword.getEncrytPassword());
                userInfoEntity.setLoginSalt(salt);
                userInfoEntity.setIsLock(Constants.IsLock.UNLOCK.value());
                userInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                userInfoEntity.setUpdatedBy(userInfoEntity.getCreatedBy());
                iUserInfoDao.insertSelective(userInfoEntity);

                PartyRoleRelaEntity partyRoleRelaEntity = new PartyRoleRelaEntity();
                partyRoleRelaEntity.generatePk();
                partyRoleRelaEntity.setPartyId(sysStaffDetailsEntity.getPartyId());
                partyRoleRelaEntity.setRoleId(188471577922862069L);
                partyRoleRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                partyRoleRelaEntity.setUpdatedBy(userInfoEntity.getCreatedBy());
                iPartyRoleRelaDao.insertSelective(partyRoleRelaEntity);
            }
        } finally {
            sysStaffDetailsEntity = null;

        }
    }

    /**
     * Description: 修改人员信息
     *
     * @param sysStaffDetailsModifyDto 修改内容
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void modifyStaffMsg(SysStaffDetailsModifyDto sysStaffDetailsModifyDto) {
        //人员信息修改参数
        SysStaffDetailsEntity sysStaffDetailsEntity = new SysStaffDetailsEntity();
        sysStaffDetailsEntity.setStaffCode(sysStaffDetailsModifyDto.getStaffCode());
        //人员部门信息修改参数
        SysDepartmentStaffRelaEntity sysDepartmentStaffRelaEntity = new SysDepartmentStaffRelaEntity();
        //人员密码信息修改参数
        UserInfoEntity userInfoEntity = new UserInfoEntity();

        //通过编码查询
        sysStaffDetailsEntity.setStaffCode(sysStaffDetailsModifyDto.getStaffCode());


        int departmentCount = iSysStaffDetailsDao.selectBySelectiveCount(sysStaffDetailsEntity);
        try {
            if (departmentCount <= 0) {
                throw new IllegalParameterException("人员编号不能修改!");
            } else {
                sysStaffDetailsEntity =
                        Copiers.beanToBean(sysStaffDetailsModifyDto, SysStaffDetailsModifyDto.class, SysStaffDetailsEntity.class);
                sysStaffDetailsEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                sysStaffDetailsEntity.setPartyId(sysStaffDetailsModifyDto.getPartyId());

                //修改人员部门信息
                sysDepartmentStaffRelaEntity =
                        Copiers.beanToBean(sysStaffDetailsModifyDto, SysStaffDetailsModifyDto.class, SysDepartmentStaffRelaEntity.class);

                sysDepartmentStaffRelaEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                sysDepartmentStaffRelaEntity.setPartyId(sysStaffDetailsModifyDto.getPartyId());


                //修改人员密码信息

                userInfoEntity =
                        Copiers.beanToBean(sysStaffDetailsModifyDto, SysStaffDetailsModifyDto.class, UserInfoEntity.class);
                userInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                if (!ObjectUtils.isEmpty(sysStaffDetailsModifyDto.getPassWord())){
                    String passWord = sysStaffDetailsModifyDto.getPassWord();
                    EncrytPassword encrytPassword = new EncrytPassword(passWord);
                    final String salt = encrytPassword.getSalt();
                    userInfoEntity.setLoginPassword(encrytPassword.getEncrytPassword());
                    userInfoEntity.setLoginSalt(salt);
                }

                userInfoEntity.setPartyId(sysStaffDetailsModifyDto.getPartyId());
                userInfoEntity.setIsLock(Constants.IsLock.UNLOCK.value());
                //修改人员信息
                iSysStaffDetailsDao.updateSelective(sysStaffDetailsEntity);

                //修改人员部门信息
                iSysDepartmentStaffRelaDao.deleteBySelective(sysDepartmentStaffRelaEntity);
                List<SysDepartmentStaffRelaEntity> departmentIdList = sysStaffDetailsModifyDto.getDepartmentIdList();
                for (int i = 0; i < departmentIdList.size(); i++) {
                    departmentIdList.get(i).setPartyId(sysStaffDetailsModifyDto.getPartyId());
                    departmentIdList.get(i).generatePk();
                    departmentIdList.get(i).setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                    departmentIdList.get(i).setUpdatedBy(departmentIdList.get(i).getCreatedBy());
                }
                iSysDepartmentStaffRelaDao.batchInsert(departmentIdList);

                //修改人员密码信息
                iUserInfoDao.updateSelective(userInfoEntity);

                //修改登录信息表
                LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
                loginInfoEntity.setLoginId(sysStaffDetailsModifyDto.getLoginId().get(0));
                List<LoginInfoEntity> loginInfoEntities = iLoginInfoDao.selectBySelective(loginInfoEntity);
                if (Constants.IsPassword.password.equals(loginInfoEntities.get(0).getIsPassword())){
                    loginInfoEntity.setLoginName(sysStaffDetailsModifyDto.getStaffIphone());
                    loginInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                    iLoginInfoDao.updateSelective(loginInfoEntity);
                }else {
                    loginInfoEntity.setLoginName(Md5Util.getMD5String(sysStaffDetailsModifyDto.getStaffIphone()));
                    loginInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                    iLoginInfoDao.updateSelective(loginInfoEntity);
                }







                //修改人员信息
                PersonInfoEntity personInfoEntity = new PersonInfoEntity();
                personInfoEntity.setPartyId(sysStaffDetailsModifyDto.getPartyId());
                personInfoEntity.setPersonName(sysStaffDetailsModifyDto.getStaffName());
                personInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                iPersonInfoDao.updateSelective(personInfoEntity);


            }
        } finally {
            sysStaffDetailsEntity = null;
            sysDepartmentStaffRelaEntity = null;
            userInfoEntity = null;
        }
    }
    /**
     * Description: 人员角色维护
     * @param roleRelaDto 维护内容
     @Override
     **/
    @Transactional
    public void staffRoleEdit(PartyRoleRelaDto roleRelaDto) {
        PartyRoleRelaEntity relaEntity = new PartyRoleRelaEntity();
        relaEntity.setPartyId(roleRelaDto.getPartyId());
        relaEntity.setRoleId(roleRelaDto.getSelectRoleId());
        if(roleRelaDto.isRoleFlag()){
            int i = iPartyRoleRelaDao.selectBySelectiveCount(relaEntity);
            if(i > 0){
                throw new IllegalParameterException("当前人员已存在该角色信息，不能新增!");
            }
            relaEntity.generatePk();
            relaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            relaEntity.setUpdatedBy(relaEntity.getCreatedBy());
            iPartyRoleRelaDao.insert(relaEntity);
        }else{
            iPartyRoleRelaDao.deleteBySelective(relaEntity);
        }


        /**
        PartyRoleRelaEntity partyRoleRelaEntity = new PartyRoleRelaEntity();
        partyRoleRelaEntity.setPartyId(partyRoleRelaDto.getPartyId());
        iPartyRoleRelaDao.deleteBySelective(partyRoleRelaEntity);
        Long[] selectRoleIds = partyRoleRelaDto.getSelectRoleIds();
        if(selectRoleIds != null && selectRoleIds.length > 0){
            PartyRoleRelaEntity insertRoleIds;
            List<PartyRoleRelaEntity> insertList = new LinkedList<>();
            for (Long selectRoleId : selectRoleIds) {
                insertRoleIds = new PartyRoleRelaEntity();
                insertRoleIds.generatePk();
                insertRoleIds.setPartyId(partyRoleRelaDto.getPartyId());
                insertRoleIds.setRoleId(selectRoleId);
                insertRoleIds.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                insertRoleIds.setUpdatedBy(insertRoleIds.getCreatedBy());
                insertList.add(insertRoleIds);
            }
            if(CollectionUtils.isNotEmpty(insertList)){
                iPartyRoleRelaDao.batchInsert(insertList);
            }
        }**/

    }

    /**
     * Description: 人员角色维护
     * @param partyRoleRelaDto 维护内容
    @Override
    public void staffRoleEdit(PartyRoleRelaDto partyRoleRelaDto) {
        PartyRoleRelaEntity partyRoleRelaEntity = new PartyRoleRelaEntity();
        try {
            partyRoleRelaEntity.setRoleId(partyRoleRelaDto.getRoleId());
            partyRoleRelaEntity.setPartyId(partyRoleRelaDto.getPartyId());
            if (Constants.StaffOpe.delete.value().equals(partyRoleRelaDto.getStaffRoleOpe())) {
                iPartyRoleRelaDao.deleteBySelective(partyRoleRelaEntity);
            } else if (Constants.StaffOpe.insert.value().equals(partyRoleRelaDto.getStaffRoleOpe())) {
                //partyRoleRelaEntity.setPartyId(null);
                int roleStaffCount = iPartyRoleRelaDao.selectBySelectiveCount(partyRoleRelaEntity);
                if (roleStaffCount > 0) {
                    throw new IllegalParameterException("当前人员已存在该角色信息，不能新增!");
                } else {
                    partyRoleRelaEntity =
                            Copiers.beanToBean(partyRoleRelaDto, PartyRoleRelaDto.class, PartyRoleRelaEntity.class);
                    partyRoleRelaEntity.generatePk();
                    partyRoleRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                    partyRoleRelaEntity.setUpdatedBy(partyRoleRelaEntity.getCreatedBy());
                    iPartyRoleRelaDao.insertSelective(partyRoleRelaEntity);
                }
            }
        } finally {
            partyRoleRelaEntity = null;
        }

    } */


    /**
     * Description: 人员状态(启用/禁用)
     *
     * @param staffDetailsStatusDto 维护内容
     */
    @Override
    public void StaffStatusEdit(SysStaffDetailsStatusDto staffDetailsStatusDto) {
        SysStaffDetailsEntity sysStaffDetailsEntity = new SysStaffDetailsEntity();
        sysStaffDetailsEntity =
                Copiers.beanToBean(staffDetailsStatusDto, SysStaffDetailsStatusDto.class, SysStaffDetailsEntity.class);
        sysStaffDetailsEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        iSysStaffDetailsDao.updateSelective(sysStaffDetailsEntity);
    }

    /**
     * Description: 人员角色查询
     *
     * @param sysStaffDetailsRoleQueryDto 查询内容
     */
    @Override
    public PageInfo<SysStaffDetailsRoleQueryDto> staffRoleQuery(SysStaffDetailsRoleQueryDto sysStaffDetailsRoleQueryDto) {
        Integer pageNum = sysStaffDetailsRoleQueryDto.getPageNum();
        Integer pageSize = sysStaffDetailsRoleQueryDto.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SysStaffDetailsRoleQueryDto> sysStaffDetailsDtoList = null;
//        List<SysStaffDetailsRoleQueryDto> sysStaffDetailsDtoList = sysStaffDetailsDao.selectStaffRole(sysStaffDetailsRoleQueryDto);
        if(StringUtils.isNotBlank(sysStaffDetailsRoleQueryDto.getRoleType()) && sysStaffDetailsRoleQueryDto.getRoleType().equals(Constants.RoleType.store.value())){
            //如果查的是门店人员，需要改查另外一张角色关系表
            sysStaffDetailsDtoList = sysStaffDetailsDao.selectStoreStaffRole(sysStaffDetailsRoleQueryDto);
        }else{
            sysStaffDetailsDtoList = sysStaffDetailsDao.selectStaffRole(sysStaffDetailsRoleQueryDto);
        }
        for (int i = 0; i < sysStaffDetailsDtoList.size(); i++) {
                if (sysStaffDetailsDtoList.get(i).getPartyId() != null) {
                    sysStaffDetailsDtoList.get(i).setStaffRoleFlag(true);
                }else {
                    sysStaffDetailsDtoList.get(i).setStaffRoleFlag(false);
                }
            }


        PageInfo<SysStaffDetailsRoleQueryDto> page = new PageInfo<SysStaffDetailsRoleQueryDto>(sysStaffDetailsDtoList);
        return page;

    }

    @Override
    public List<SysAreaInfoDto> staffAreaQuery(SysAreaInfoQueryDto sysAreaInfoQueryDto) {
        List<SysAreaInfoDto> sysAreaInfoDtos = sysStaffDetailsDao.selectStaffArea(sysAreaInfoQueryDto);
        SysStaffAreaRelaEntity sysStaffAreaRelaEntity = new SysStaffAreaRelaEntity();
        sysStaffAreaRelaEntity.setPartyId(sysAreaInfoQueryDto.getPartyId());
        List<SysStaffAreaRelaEntity> sysStaffAreaRelaEntities = iSysStaffAreaRelaDao.selectBySelective(sysStaffAreaRelaEntity);
        for (int i = 0; i <sysAreaInfoDtos.size() ; i++) {
            for (int j = 0; j <sysStaffAreaRelaEntities.size() ; j++) {
                if (String.valueOf(sysAreaInfoDtos.get(i).getAreaId()).equals(String.valueOf(sysStaffAreaRelaEntities.get(j).getAreaId()))){
                    sysAreaInfoDtos.get(i).setStaffAreaFlag(true);
                    break;
                }else {
                    sysAreaInfoDtos.get(i).setStaffAreaFlag(false);
                }
            }
        }


        return sysAreaInfoDtos;
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void staffAreaEdit(SysAreaInfoEditDto sysAreaInfoEditDto) {
        //获取用户信息
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();

        //获取区域标识集合
        List<Long> areaId = sysAreaInfoEditDto.getAreaId();

        //删除当前人员所有区域信息
        SysStaffAreaRelaEntity areaRelaEntity = new SysStaffAreaRelaEntity();
        areaRelaEntity.setPartyId(sysAreaInfoEditDto.getPartyId());
        iSysStaffAreaRelaDao.deleteBySelective(areaRelaEntity);
        List<SysStaffAreaRelaEntity> sysStaffAreaRelaEntities = iSysStaffAreaRelaDao.selectBySelective(areaRelaEntity);
        //在日志表中加入删除操作
        SysStaffAreaLogEntity sysStaffAreaLogEntity = new SysStaffAreaLogEntity();
        sysStaffAreaLogEntity.setLogOpePersonId(user.getPartyId());
        sysStaffAreaLogEntity.setOpePersonId(sysAreaInfoEditDto.getPartyId());
        sysStaffAreaLogEntity.setLogOpeDate(new Date());
        sysStaffAreaLogEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        sysStaffAreaLogEntity.setUpdatedBy(sysStaffAreaLogEntity.getCreatedBy());

        for (int i = 0; i <sysStaffAreaRelaEntities.size() ; i++) {
            sysStaffAreaLogEntity.generatePk();
            sysStaffAreaLogEntity.setLogOpeContent("操作人"+user.getPartyId()+"执行删除操作,删除被操作人"+sysAreaInfoEditDto.getPartyId()+"区域标识:"+sysStaffAreaRelaEntities.get(i).getAreaId());
            iSysStaffAreaLogDao.insert(sysStaffAreaLogEntity);
        }
        //新增人员区域关系信息
        areaRelaEntity =
                Copiers.beanToBean(sysAreaInfoEditDto, SysAreaInfoEditDto.class, SysStaffAreaRelaEntity.class);

        areaRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        areaRelaEntity.setUpdatedBy(areaRelaEntity.getCreatedBy());
        for (int i = 0; i <areaId.size() ; i++) {
            areaRelaEntity.generatePk();
            areaRelaEntity.setAreaId(areaId.get(i));
            iSysStaffAreaRelaDao.insert(areaRelaEntity);
            sysStaffAreaLogEntity.setLogOpeContent("操作人"+user.getPartyId()+"执行新增操作,新增被操作人的区域信息，区域标识："+areaId.get(i));
            sysStaffAreaLogEntity.generatePk();
            //在日志表中加入新增操作
            iSysStaffAreaLogDao.insert(sysStaffAreaLogEntity);
        }




    }


    /**
     * Description: 删除人员信息
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void delStaffMsg(SysStaffDetailsDelDto sysStaffDetailsDelDto) {
        //人员信息删除参数
        SysStaffDetailsEntity sysStaffDetailsEntity = new SysStaffDetailsEntity();
        //人员部门信息删除参数
        SysDepartmentStaffRelaEntity sysDepartmentStaffRelaEntity = new SysDepartmentStaffRelaEntity();
        //人员锁定
        LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
        //人员角色信息删除参数
        PartyRoleRelaEntity roleRelaEntity = new PartyRoleRelaEntity();

        try {

            sysStaffDetailsEntity =
                    Copiers.beanToBean(sysStaffDetailsDelDto, SysStaffDetailsDelDto.class, SysStaffDetailsEntity.class);


            //删除人员部门信息
            sysDepartmentStaffRelaEntity =
                    Copiers.beanToBean(sysStaffDetailsDelDto, SysStaffDetailsDelDto.class, SysDepartmentStaffRelaEntity.class);


            //人员信息锁定

            loginInfoEntity =
                    Copiers.beanToBean(sysStaffDetailsDelDto, SysStaffDetailsDelDto.class, LoginInfoEntity.class);
            loginInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            loginInfoEntity.setValidMark(Constants.ValidMark.VALID.value());
            loginInfoEntity.setLoginId(sysStaffDetailsDelDto.getLoginId().get(0));

            //删除人员角色信息
            roleRelaEntity =
                    Copiers.beanToBean(sysStaffDetailsDelDto, SysStaffDetailsDelDto.class, PartyRoleRelaEntity.class);

            PartyInfoEntity partyInfoEntity =
                    Copiers.beanToBean(sysStaffDetailsDelDto, SysStaffDetailsDelDto.class, PartyInfoEntity.class);

            PersonInfoEntity personInfoEntity =
                    Copiers.beanToBean(sysStaffDetailsDelDto, SysStaffDetailsDelDto.class, PersonInfoEntity.class);

            //删除人员信息
            iSysStaffDetailsDao.deleteBySelective(sysStaffDetailsEntity);

            //删除人员部门信息
            iSysDepartmentStaffRelaDao.deleteBySelective(sysDepartmentStaffRelaEntity);

            //修改登录人员信息
            iLoginInfoDao.updateSelective(loginInfoEntity);
            loginInfoEntity =
                    Copiers.beanToBean(sysStaffDetailsDelDto, SysStaffDetailsDelDto.class, LoginInfoEntity.class);
            loginInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            loginInfoEntity.setValidMark(Constants.ValidMark.VALID.value());
            loginInfoEntity.setLoginId(sysStaffDetailsDelDto.getLoginId().get(1));
            iLoginInfoDao.updateSelective(loginInfoEntity);

            //删除人员角色信息
            iPartyRoleRelaDao.deleteBySelective(roleRelaEntity);


             iPartyInfoDao.deleteBySelective(partyInfoEntity);

            iPersonInfoDao.deleteBySelective(personInfoEntity);

            UserInfoEntity userInfoEntity = new UserInfoEntity();
            userInfoEntity.setIsLock(Constants.IsLock.LOCK.value());
            userInfoEntity.setPartyId(sysStaffDetailsDelDto.getPartyId());
            iUserInfoDao.updateSelective(userInfoEntity);
        } finally {
            sysStaffDetailsEntity = null;
            sysDepartmentStaffRelaEntity = null;
            loginInfoEntity = null;
        }
    }

    @Override
    public PageInfo<SysStaffDetailsDto> queryAddStaffMsg(SysStaffDetailsDto sysStaffDetailsDto) {
        PageHelper.startPage(sysStaffDetailsDto.getPageNum(), sysStaffDetailsDto.getPageSize());
        List<SysStaffDetailsDto> sysStaffDetailsDtoList = sysStaffDetailsDao.selectAddStaffMsg(sysStaffDetailsDto);
        PageInfo<SysStaffDetailsDto> page = new PageInfo<SysStaffDetailsDto>(sysStaffDetailsDtoList);
        return page;
    }

    @Override
    public PageInfo<SysStoreStaffListDto> findStorePage(SysStaffStoreListQueryDto storeListQueryDto) {
        SysStoreInfoEntity infoEntity = new SysStoreInfoEntity();
        infoEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
        if(StringUtils.isNotBlank(storeListQueryDto.getProvinceId())){
            infoEntity.setProvinceId(storeListQueryDto.getProvinceId());
        }
        if(StringUtils.isNotBlank(storeListQueryDto.getCityId())){
            infoEntity.setCityId(storeListQueryDto.getCityId());
        }
        PageHelper.startPage(storeListQueryDto.getPageNum(), storeListQueryDto.getPageSize());
        List<SysStoreInfoEntity> storeInfoEntities = iSysStoreInfoDao.selectBySelective(infoEntity);
        List<SysStoreStaffListDto> staffListDtos = Copiers.beansToBeans(storeInfoEntities, SysStoreInfoEntity.class, SysStoreStaffListDto.class);

        SysStoreStaffRelaEntity sysStoreInfoEntity = new SysStoreStaffRelaEntity();
        sysStoreInfoEntity.setPartyId(storeListQueryDto.getPartyId());
        
        //查询的时候要过滤掉门店人员自动生成的关系数据
        sysStoreInfoEntity.setUpdatedBy(-999L);
        List<SysStoreStaffRelaEntity> staffRelaEntities = iSysStoreStaffRelaDao.selectBySelective(sysStoreInfoEntity);
        Map<Long, SysStoreStaffRelaEntity> storeStaffRelaMap = staffRelaEntities.stream().collect(Collectors.toMap(p -> p.getStoreId(), p -> p ));

        staffListDtos.forEach(item->{
                if(storeStaffRelaMap.containsKey(item.getStoreId())){
                    item.setStoreFlag(true);
                }else{
                    item.setStoreFlag(false);
                }
        });
        PageInfo<SysStoreStaffListDto> objectPageInfo = new PageInfo<>();
        objectPageInfo.setTotal(iSysStoreInfoDao.selectBySelectiveCount(infoEntity));
        objectPageInfo.setList(staffListDtos);
        Long count = objectPageInfo.getTotal() % storeListQueryDto.getPageSize() == 0 ? objectPageInfo.getTotal() / storeListQueryDto.getPageSize() : objectPageInfo.getTotal() /storeListQueryDto.getPageSize() + 1 ;
        objectPageInfo.setPages(Integer.valueOf(count.toString()));
        return objectPageInfo;
        //return new PageInfo<>(staffListDtos);
    }

    @Override
    public void authorizeStore(SysStaffStoreAuthDto storeAuthDto) {
        String[] selectStoreId = storeAuthDto.getSelectStoreId();
        if(!Objects.isNull(selectStoreId) && selectStoreId.length > 0){
            List<SysStoreStaffRelaEntity> insertList = new LinkedList<>();
            SysStoreStaffRelaEntity staffRelaEntity;
            for (String selectStore : storeAuthDto.getSelectStoreId()) {
                staffRelaEntity = new SysStoreStaffRelaEntity();
                staffRelaEntity.setPartyId(storeAuthDto.getPartyId());
                staffRelaEntity.setStoreId(Long.valueOf(selectStore.toString()));
                if(storeAuthDto.isStoreFlag()){
                    //查询当事人的所有门店
                    int i = iSysStoreStaffRelaDao.selectBySelectiveCount(staffRelaEntity);
                    if(i > 0){
                        //当前人员已存在该门店信息，不做新增操作
                        continue;
                    }else{
                        staffRelaEntity.generatePk();
                        staffRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                        staffRelaEntity.setUpdatedBy(staffRelaEntity.getCreatedBy());
                        insertList.add(staffRelaEntity);
                    }
                }else{
                    iSysStoreStaffRelaDao.deleteBySelective(staffRelaEntity);
                }
            }
            if(CollectionUtils.isNotEmpty(insertList)){
                iSysStoreStaffRelaDao.batchInsert(insertList);
            }
        }
        /**
        iSysStoreStaffRelaDao.selectBySelective()
        iSysStoreStaffRelaDao.deleteBySelective(staffRelaEntity);
        Long[] selectStoreIds = storeAuthDto.getSelectStoreIds();
        if(selectStoreIds != null && selectStoreIds.length > 0){
            SysStoreStaffRelaEntity insertRoleIds;
            List<SysStoreStaffRelaEntity> insertList = new LinkedList<>();
            for (Long selectStore : selectStoreIds) {
                insertRoleIds = new SysStoreStaffRelaEntity();
                insertRoleIds.generatePk();
                insertRoleIds.setPartyId(storeAuthDto.getPartyId());
                insertRoleIds.setStoreId(selectStore);
                insertRoleIds.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                insertRoleIds.setUpdatedBy(insertRoleIds.getCreatedBy());
                insertList.add(insertRoleIds);
            }
            if(CollectionUtils.isNotEmpty(insertList)){
                iSysStoreStaffRelaDao.batchInsert(insertList);
            }
        }**/

    }

    @Override
    public PageInfo<SysStoreInfoDto> findStorePageByPartyId(SysStaffStoreListQueryDto staffListDtos) {
        PageHelper.startPage(staffListDtos.getPageNum(), staffListDtos.getPageSize());
        List<SysStoreInfoDto> sysStoreInfoDtos = storeDetailsDao.selectStoreByPartyId(staffListDtos.getPartyId());
        PageInfo<SysStoreInfoDto> page = new PageInfo<>(sysStoreInfoDtos);
        return page;
    }
    @Transactional
    @Override
    public void modifyStaffStatus(SysStaffStatusEditDto statusEditDto) {
        SysStaffDetailsEntity sysStaffDetailsEntity = new SysStaffDetailsEntity();
        sysStaffDetailsEntity.setStaffType(Constants.StaffType.headquarters.value());
        sysStaffDetailsEntity.setStaffStatus(statusEditDto.getIsEnable());
        sysStaffDetailsEntity.setPartyId(statusEditDto.getPartyId());
        sysStaffDetailsEntity.setUpdatedDate(new Date());
        iSysStaffDetailsDao.updateSelective(sysStaffDetailsEntity);

        //更新t_sys_organization_staff_info总部人员信息状态
        SysOrganizationStaffInfoEntity sysOrganizationStaffInfo = new SysOrganizationStaffInfoEntity();
        sysOrganizationStaffInfo.setRspUserInfoId(statusEditDto.getPartyId());
        sysOrganizationStaffInfo.setIsEnable(statusEditDto.getIsEnable());
        iSysOrganizationStaffInfoDao.updateSelective(sysOrganizationStaffInfo);

        LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
        loginInfoEntity.setPartyId(statusEditDto.getPartyId());
        List<LoginInfoEntity> loginInfoLists = iLoginInfoDao.selectBySelective(loginInfoEntity);
        //再次判断启用禁用，更改登录状态
        if(CollectionUtils.isNotEmpty(loginInfoLists)){
            loginInfoLists.stream().forEach(item->{ item.setValidMark
                    (Constants.IsEnable.ENABLE.value().equals(statusEditDto.getIsEnable())?Constants.ValidMark.VALID.value():Constants.ValidMark.TEMP_FAIL.value());});
            iLoginInfoDao.batchUpdate(loginInfoLists);
        }

    }

    @Override
    @Transactional
    public void testUpdatePhone() {
        try {
            //获取所有门店人员
            List<SysStoreStaffInfoEntity> storeStaffInfoEntities = iSysStoreStaffInfoDao.selectBySelective(new SysStoreStaffInfoEntity());
            for (SysStoreStaffInfoEntity item :storeStaffInfoEntities) {
                if(StringUtils.isNotBlank(item.getPhoneNumber())&&item.getPhoneNumber().length() <= 14){
                    item.setPhoneNumber(AesUtils.encryptHex(item.getPhoneNumber(), ucmpAesConfig.getSecret()));
                }
            }
            //获取所有门店人员详情
            List<SysStoreStaffDetailsEntity> storeStaffDetailsEntities = iSysStoreStaffDetailsDao.selectBySelective(new SysStoreStaffDetailsEntity());
            for (SysStoreStaffDetailsEntity item :storeStaffDetailsEntities) {
                if(StringUtils.isNotBlank(item.getStaffIphone())&&item.getStaffIphone().length() <= 14){
                    item.setStaffIphone(AesUtils.encryptHex(item.getStaffIphone(), ucmpAesConfig.getSecret()));
                }
            }
            //获取所有合作商
            List<SysPartnerDetailsEntity> sysPartnerDetailsEntities = iSysPartnerDetailsDao.selectBySelective(new SysPartnerDetailsEntity());
            for (SysPartnerDetailsEntity item :sysPartnerDetailsEntities) {
                if(StringUtils.isNotBlank(item.getChargePersonIphone()) && item.getChargePersonIphone().length() <= 14){
                    item.setChargePersonIphone(AesUtils.encryptHex(item.getChargePersonIphone(), ucmpAesConfig.getSecret()));
                }
            }
            //获取所有的合作商人员信息
            List<SysPartnerStaffInfoEntity> sysPartnerStaffInfoEntities = iSysPartnerStaffInfoDao.selectBySelective(new SysPartnerStaffInfoEntity());
            for (SysPartnerStaffInfoEntity item :sysPartnerStaffInfoEntities) {
                if(StringUtils.isNotBlank(item.getPartnerStaffIphone()) && item.getPartnerStaffIphone().length() <= 14){
                    item.setPartnerStaffIphone(AesUtils.encryptHex(item.getPartnerStaffIphone(), ucmpAesConfig.getSecret()));
                }
            }
            //获取所有的人员基础信息
            List<SysStaffDetailsEntity> sysStaffDetailsEntities = iSysStaffDetailsDao.selectBySelective(new SysStaffDetailsEntity());
            for (SysStaffDetailsEntity item :sysStaffDetailsEntities) {
                if(StringUtils.isNotBlank(item.getStaffIphone()) && item.getStaffIphone().length() <= 14){
                    item.setStaffIphone(AesUtils.encryptHex(item.getStaffIphone(), ucmpAesConfig.getSecret()));
                }
            }

            if(CollectionUtils.isNotEmpty(storeStaffInfoEntities)){
                iSysStoreStaffInfoDao.batchUpdateSelective(storeStaffInfoEntities);
            }
            if(CollectionUtils.isNotEmpty(storeStaffDetailsEntities)){
                iSysStoreStaffDetailsDao.batchUpdateSelective(storeStaffDetailsEntities);
            }
            if(CollectionUtils.isNotEmpty(sysPartnerDetailsEntities)){
                iSysPartnerDetailsDao.batchUpdateSelective(sysPartnerDetailsEntities);
            }
            if(CollectionUtils.isNotEmpty(sysPartnerStaffInfoEntities)){
                iSysPartnerStaffInfoDao.batchUpdateSelective(sysPartnerStaffInfoEntities);
            }
            if(CollectionUtils.isNotEmpty(sysStaffDetailsEntities)){
                iSysStaffDetailsDao.batchUpdateSelective(sysStaffDetailsEntities);
            }

//            String iph = "13122233213";
//            String encryptHex = AesUtils.encryptHex(iph, ucmpAesConfig.getSecret());
//            System.out.println("加密结果:"+encryptHex);
//            String s = AesUtils.decryptHex(encryptHex, ucmpAesConfig.getSecret());
//            System.out.println("解密结果:"+s);
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException(e);
        }


    }
    
	@Override
	public void testUpdateUserMapping() {
		//查询t_sys_store_staff_details表所有数据
		SysStoreStaffDetailsEntity sysStoreStaffDetailsEntity=new SysStoreStaffDetailsEntity();
		List<SysStoreStaffDetailsEntity> list=this.iSysStoreStaffDetailsDao.selectBySelective(sysStoreStaffDetailsEntity);
		List<SysStoreStaffUserMappingEntity> listSysStoreStaffUserMappingEntity=new ArrayList<SysStoreStaffUserMappingEntity>();
		if(CollectionUtils.isNotEmpty(list)){
			for (SysStoreStaffDetailsEntity entity : list) {
				SysStoreStaffUserMappingEntity insert=new SysStoreStaffUserMappingEntity();
				insert.setCreatedBy(-88888L);
				insert.setIsDelete("01");
				insert.generatePk();
				insert.setPartyId(entity.getPartyId());
				insert.setUserId(entity.getStaffCode());
				listSysStoreStaffUserMappingEntity.add(insert);
			}
			this.iSysStoreStaffUserMappingDao.batchInsert(listSysStoreStaffUserMappingEntity);
		}
	}

}
