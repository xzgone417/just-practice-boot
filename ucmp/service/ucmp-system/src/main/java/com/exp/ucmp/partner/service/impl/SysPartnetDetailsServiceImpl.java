package com.exp.ucmp.partner.service.impl;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.alibaba.nacos.common.utils.StringUtils;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.EncrytPassword;
import com.egrid.core.util.Md5Util;
import com.egrid.core.util.StringUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.idm.dto.IdmUserDto;
import com.exp.ucmp.idm.dto.IdmUserStatusDto;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.parentUser.dto.SysParentAddStoreListDto;
import com.exp.ucmp.parentUser.dto.SysParentStoreQueryDto;
import com.exp.ucmp.parentUser.dto.SysPartnerStaffInfoInsertDto;
import com.exp.ucmp.parentUser.dto.SysPartnerStoreAuthDto;
import com.exp.ucmp.partner.dao.AutoOrderReceivingDao;
import com.exp.ucmp.partner.dao.SysPartnerDetailsDao;
import com.exp.ucmp.partner.service.SysPartnetDetailsService;
import com.exp.ucmp.pertner.dto.*;
import com.exp.ucmp.pk.SysPartnerDetailsPk;
import com.exp.ucmp.pk.SysPartnerStaffInfoPk;
import com.exp.ucmp.staff.dto.SysStaffDetailsDto;
import com.exp.ucmp.staff.service.SysStaffService;
import com.exp.ucmp.store.dao.SysStoreDetailsDao;
import com.exp.ucmp.store.dto.SysStoreInfoDto;
import com.exp.ucmp.user.service.IdmUserService;
import com.exp.ucmp.util.AesUtils;
import com.exp.ucmp.xxljob.dao.JobReceiveRspUserInfoDao;
import com.exp.ucmp.xxljob.service.JobReceiveRspUserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SysPartnetDetailsServiceImpl implements SysPartnetDetailsService {

    @Autowired
    private SysPartnerDetailsDao sysPartnerDetailsDao;
    @Autowired
    private ISysPartnerCityRelaDao sysPartnerCityRelaDao;
    @Autowired
    private ISysAreaInfoDao iSysAreaInfoDao;
    @Autowired
    private ISysRegionDao iSysRegionDao;
    @Autowired
    private ISysPartnerDetailsDao iSysPartnerDetailsDao;
    @Autowired
    private ISysStaffDetailsDao sysStaffDetailsDao;
    @Autowired
    private ISysStaffRegionRelaDao iSysStaffRegionRelaDao;
    @Autowired
    private ISysPartnerStaffRelaDao iSysPartnerStaffRelaDao;
    @Autowired
    private ILoginInfoDao iLoginInfoDao;
    @Autowired
    private IPartyInfoDao partyInfoDao;
    @Autowired
    private IPersonInfoDao iPersonInfoDao;
    @Autowired
    private IUserInfoDao userInfoDao;
    @Autowired
    private ISysAreaRegionRelaDao iSysAreaRegionRelaDao;
    @Autowired
    private IPartyRoleRelaDao iPartyRoleRelaDao;
    @Autowired
    private ISysPartnerStaffStoreRelaDao sysPartnerStaffStoreRelaDao;

    @Autowired
    private IdmUserService idmUserService;
    @Autowired
    private SysStaffService sysStaffService;
    @Autowired
    private ISysPartnerStaffInfoDao iSysPartnerStaffInfoDao;

    @Autowired
    private SysStoreDetailsDao sysStoreDetailsDao;
    @Autowired
    private UcmpAesConfig ucmpAesConfig;
    @Autowired
    private ISysStoreInfoDao iSysStoreInfoDao;
    @Autowired
    private  ISysStorePartnerRelaDao iSysStorePartnerRelaDao;
    @Autowired
    private JobReceiveRspUserInfoDao sysParentUserInfoDao;

    @Autowired
    private JobReceiveRspUserInfoService sysParentUserInfoService;

    @Autowired
    private AutoOrderReceivingDao autoOrderReceivingDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(SysPartnetDetailsServiceImpl.class);

    /**
     * Description: 查询合作商详情信息
     *
     * @param sysPartnerDetailsDto 参数
     * @return 实体集合
     */
    @Override
    public PageInfo<SysPartnerDetailsDto> queryPartnerMsg(SysPartnerDetailsDto sysPartnerDetailsDto) {
        /**一期优化功能，现已去掉
        //先查询出排名前三的合作商
        List<SysPartnerDetailsDto> sysPartnerDetailsOrders = sysPartnerDetailsDao.selectPartnerMsg(sysPartnerDetailsDto);
        Map<Long,Integer> detailsSortMap = new HashMap();
        for (int i = 0; i < sysPartnerDetailsOrders.size(); i++) {
            if(detailsSortMap.size() >= 3 || Objects.isNull(sysPartnerDetailsOrders.get(i).getPartnerOrder())){
                break;
            }
            detailsSortMap.put(sysPartnerDetailsOrders.get(i).getPartnerId(),i + 1);
        }**/

        PageHelper.startPage(sysPartnerDetailsDto.getPageNum(), sysPartnerDetailsDto.getPageSize());
        if(StringUtils.isNotBlank(sysPartnerDetailsDto.getChargePersonIphone())){
            sysPartnerDetailsDto.setChargePersonIphone(AesUtils.encryptHex(sysPartnerDetailsDto.getChargePersonIphone(), ucmpAesConfig.getSecret()));
        }
        List<SysPartnerDetailsDto> sysPartnerDetailsDtos = sysPartnerDetailsDao.selectPartnerMsg(sysPartnerDetailsDto);
        try {
            for (SysPartnerDetailsDto item :sysPartnerDetailsDtos) {
                //手机号解密再返回
                if(StringUtils.isNotBlank(item.getChargePersonIphone())){
                    item.setChargePersonIphone(AesUtils.decryptHex(item.getChargePersonIphone(), ucmpAesConfig.getSecret()));
                }
                //排名赋值
                //if(detailsSortMap.containsKey(item.getPartnerId())){
                    //item.setPartnerSort(detailsSortMap.get(item.getPartnerId()));
                //}
            }
        }catch (Exception e){
            LOGGER.error("手机号解密失败=========",e);
        }
        return new PageInfo<>(sysPartnerDetailsDtos);
    }


    /**
     * Description: 查询当前合作商下人员详情
     *
     * @param sysPartnerStaffDetailsDto 参数
     * @return 实体集合
     */
    @Override
    public PageInfo<SysPartnerStaffDetailsDto> queryPartnerStaffMsg(SysPartnerStaffDetailsDto sysPartnerStaffDetailsDto) {
        PageHelper.startPage(sysPartnerStaffDetailsDto.getPageNum(), sysPartnerStaffDetailsDto.getPageSize());
        List<SysPartnerStaffDetailsDto> sysPartnerStaffDetailsDtos = sysPartnerDetailsDao.selectPartnerStaffMsg(sysPartnerStaffDetailsDto);
        if (sysPartnerStaffDetailsDtos.size() > 0) {
            PageInfo<SysPartnerStaffDetailsDto> page = new PageInfo<SysPartnerStaffDetailsDto>(sysPartnerStaffDetailsDtos);
            return page;
        } else {
            return null;
        }
    }


    /**
     * Description: 查询公司管辖城市信息
     *
     * @param sysPartnerCityQueryDto 参数
     * @return 实体集合
     */
    @Override
    public PageInfo<SysPartnerCityRelaDto> queryPartnerCitiesMsg(SysPartnerCityQueryDto sysPartnerCityQueryDto) {
        SysPartnerCityRelaEntity sysPartnerCityRelaEntity = new SysPartnerCityRelaEntity();
        sysPartnerCityRelaEntity.setPartnerId(sysPartnerCityQueryDto.getPartnerId());
        PageHelper.startPage(sysPartnerCityQueryDto.getPageNum(), sysPartnerCityQueryDto.getPageSize());
        List<SysPartnerCityRelaEntity> sysPartnerCityRelaEntities = sysPartnerCityRelaDao.selectBySelective(sysPartnerCityRelaEntity);
        List<SysPartnerCityRelaDto> sysPartnerCityQueryDtos = Copiers.beansToBeans(sysPartnerCityRelaEntities, SysPartnerCityRelaEntity.class, SysPartnerCityRelaDto.class);
        if (sysPartnerCityQueryDtos.size() > 0) {
            PageInfo<SysPartnerCityRelaDto> page = new PageInfo<SysPartnerCityRelaDto>(sysPartnerCityQueryDtos);
            return page;
        } else {
            return null;
        }
    }


    /**
     * Description: 查询区域省市信息
     *
     * @param sysAreaRegionDetailsDto 参数
     * @return 实体集合
     */
    @Override
    public List<Map> queryAreaRegionMsg(SysAreaRegionDetailsDto sysAreaRegionDetailsDto) {
        if (Constants.DataType.area.value().equals(sysAreaRegionDetailsDto.getDataTypeFlag())) {
            SysAreaInfoEntity sysAreaInfoEntity = new SysAreaInfoEntity();
            List<SysAreaInfoEntity> sysAreaInfoEntities = iSysAreaInfoDao.selectBySelective(sysAreaInfoEntity);
            if (sysAreaInfoEntities.size() > 0) {
                List<Map> list = new ArrayList<>();
                for (int i = 0; i < sysAreaInfoEntities.size(); i++) {
                    HashMap map = new HashMap();
                    map.put("areaId", sysAreaInfoEntities.get(i).getAreaId());
                    map.put("areaName", sysAreaInfoEntities.get(i).getAreaName());
                    list.add(map);
                }
                sysAreaRegionDetailsDto.setDataList(list);
                return sysAreaRegionDetailsDto.getDataList();
            } else {
                return null;
            }
        } else if (Constants.DataType.province.value().equals(sysAreaRegionDetailsDto.getDataTypeFlag())) {
            return sysPartnerDetailsDao.selectPartnerProvinceMsg(sysAreaRegionDetailsDto);
        } else if (Constants.DataType.city.value().equals(sysAreaRegionDetailsDto.getDataTypeFlag())) {
            SysRegionEntity sysRegionEntity = new SysRegionEntity();
            sysRegionEntity.setParentCode(sysAreaRegionDetailsDto.getDataId());
            List<SysRegionEntity> sysRegionEntities = iSysRegionDao.selectBySelective(sysRegionEntity);
            if (sysRegionEntities.size() > 0) {
                List<Map> list = new ArrayList<>();
                for (int i = 0; i < sysRegionEntities.size(); i++) {
                    Map map = new HashMap();
                    map.put("regionCode", sysRegionEntities.get(i).getRegionCode());
                    map.put("regionName", sysRegionEntities.get(i).getRegionName());
                    list.add(map);
                }
                sysAreaRegionDetailsDto.setDataList(list);
                return sysAreaRegionDetailsDto.getDataList();
            } else {
                return null;
            }
        } else {
            return null;
        }

    }




    /**
     * Description: 添加合作商
     *
     * @param sysPartnerDetailsDto 参数
     */
    @Transactional
    @Override
    public String insertPartner(SysPartnerDetailsDto sysPartnerDetailsDto) {
        SysPartnerDetailsEntity sysPartnerDetailsEntity = new SysPartnerDetailsEntity();
        sysPartnerDetailsEntity.setPartnerName(sysPartnerDetailsDto.getPartnerName());
        sysPartnerDetailsEntity.setIsDelete(0);
        int partnerCount = iSysPartnerDetailsDao.selectBySelectiveCount(sysPartnerDetailsEntity);
        if (partnerCount > 0) {
            throw new IllegalParameterException("合作商名称为" + sysPartnerDetailsDto.getPartnerName() + "的合作商已存在，不能新增");
        } else {
            sysPartnerDetailsEntity =
                    Copiers.beanToBean(sysPartnerDetailsDto, SysPartnerDetailsDto.class, SysPartnerDetailsEntity.class);
            sysPartnerDetailsEntity.generatePk();
            sysPartnerDetailsEntity.setPartnerCode(String.valueOf(RandomIDGennerator.getGeneratedMachineProcessIdentifier()));
            sysPartnerDetailsEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            sysPartnerDetailsEntity.setUpdatedBy(sysPartnerDetailsEntity.getCreatedBy());
            if(StringUtils.isNotBlank(sysPartnerDetailsEntity.getChargePersonIphone())){
                sysPartnerDetailsEntity.setChargePersonIphone(AesUtils.encryptHex(sysPartnerDetailsEntity.getChargePersonIphone(), ucmpAesConfig.getSecret()));
            }
            iSysPartnerDetailsDao.insertSelective(sysPartnerDetailsEntity);
            //同时添加组织信息
            sysStaffService.insertPartyAndOrganization(sysPartnerDetailsEntity.getPartnerId(),sysPartnerDetailsEntity.getPartnerName(),Constants.PartyType.ORGANIZATION.value());
            return sysPartnerDetailsEntity.getPartnerId().toString();
        }
    }


    /**
     * Description: 添加当前合作商人员
     *
     * @param sysPartnerStaffDetailsDto 参数
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void insertPartnerStaff(SysStaffDetailsDto  sysPartnerStaffDetailsDto) {

        //新增人员详情表
        SysStaffDetailsEntity sysStaffDetailsEntity = new SysStaffDetailsEntity();
        sysStaffDetailsEntity.setStaffIphone(sysPartnerStaffDetailsDto.getStaffIphone());
        sysStaffDetailsEntity.setStaffName(sysPartnerStaffDetailsDto.getStaffName());
        int staffCount = sysStaffDetailsDao.selectBySelectiveCount(sysStaffDetailsEntity);
        if (staffCount > 0) {
            throw new IllegalParameterException("手机号为" + sysPartnerStaffDetailsDto.getStaffIphone() + "名字为" + sysPartnerStaffDetailsDto.getStaffName() + "的人员已存在，不能新增");
        } else {
            sysStaffDetailsEntity =
                    Copiers.beanToBean(sysPartnerStaffDetailsDto, SysStaffDetailsDto.class, SysStaffDetailsEntity.class);
            sysStaffDetailsEntity.generatePk();
            sysStaffDetailsEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            sysStaffDetailsEntity.setUpdatedBy(sysStaffDetailsEntity.getCreatedBy());
            sysStaffDetailsEntity.setStaffType(Constants.StaffType.carDealer.value());
            sysStaffDetailsDao.insertSelective(sysStaffDetailsEntity);

        }

        //新增人员区域关系表
        if (sysPartnerStaffDetailsDto.getPartyCityId().size()>=0){
            List<SysStaffRegionRelaEntity> list = new ArrayList<>();
            for (int i = 0; i < sysPartnerStaffDetailsDto.getPartyCityId().size(); i++) {
                SysStaffRegionRelaEntity sysStaffRegionRelaEntity = new SysStaffRegionRelaEntity();
                sysStaffRegionRelaEntity.setPartyId(sysStaffDetailsEntity.getPartyId());
                sysStaffRegionRelaEntity.setRegionCode(sysPartnerStaffDetailsDto.getPartyCityId().get(i));
                sysStaffRegionRelaEntity.generatePk();
                sysStaffRegionRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                sysStaffRegionRelaEntity.setUpdatedBy(sysStaffRegionRelaEntity.getCreatedBy());
                list.add(sysStaffRegionRelaEntity);
            }
            iSysStaffRegionRelaDao.batchInsert(list);
        }


        //新增合作商人员关系表
        SysPartnerStaffRelaEntity sysPartnerStaffRelaEntity = new SysPartnerStaffRelaEntity();
        sysPartnerStaffRelaEntity.setPartnerId(sysPartnerStaffDetailsDto.getPartnerId());
        sysPartnerStaffRelaEntity.setPartyId(sysStaffDetailsEntity.getPartyId());
        sysPartnerStaffRelaEntity.generatePk();
        sysPartnerStaffRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        sysPartnerStaffRelaEntity.setUpdatedBy(sysPartnerStaffRelaEntity.getCreatedBy());
        iSysPartnerStaffRelaDao.insertSelective(sysPartnerStaffRelaEntity);

        //新增登录信息
        LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
        loginInfoEntity.setPartyId(sysStaffDetailsEntity.getPartyId());
        List<LoginInfoEntity> loginInfoEntities = iLoginInfoDao.selectBySelective(loginInfoEntity);
        if (loginInfoEntities.size()<=0){
            loginInfoEntity.setLoginName(sysPartnerStaffDetailsDto.getStaffIphone());
            loginInfoEntity.setIsPrimary(Constants.IsPrimary.YES.value());
            loginInfoEntity.setIsPassword(Constants.IsPassword.password.value());
            loginInfoEntity.setValidMark(Constants.ValidMark.VALID.value());
            loginInfoEntity.generatePk();
            loginInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            loginInfoEntity.setUpdatedBy(loginInfoEntity.getCreatedBy());
            iLoginInfoDao.insertSelective(loginInfoEntity);
            loginInfoEntity.setLoginName(Md5Util.getMD5String(sysPartnerStaffDetailsDto.getStaffIphone()));
            loginInfoEntity.setIsPassword(Constants.IsPassword.nopassword.value());
            iLoginInfoDao.insertSelective(loginInfoEntity);
        }else {
            for (int i = 0; i <loginInfoEntities.size() ; i++) {
                if (Constants.ValidMark.INVALID.value().equals(loginInfoEntities.get(i).getValidMark()) && sysPartnerStaffDetailsDto.getStaffIphone().equals(loginInfoEntities.get(i).getLoginName())){
                    loginInfoEntity.setValidMark(Constants.ValidMark.VALID.value());
                    loginInfoEntity.setLoginId(loginInfoEntities.get(i).getLoginId());
                    iLoginInfoDao.updateSelective(loginInfoEntity);
                }else if (Constants.ValidMark.VALID.value().equals(loginInfoEntities.get(i).getValidMark()) && sysPartnerStaffDetailsDto.getStaffIphone().equals(loginInfoEntities.get(i).getLoginName())){
                    throw new IllegalParameterException("人员登录名(" + sysPartnerStaffDetailsDto.getStaffIphone() + ")已存在，不能新增!");
                }
            }
        }


        //新增当事人信息
        PartyInfoEntity partyInfoEntity = new PartyInfoEntity();
        partyInfoEntity.setPartyId(sysStaffDetailsEntity.getPartyId());
        partyInfoEntity.setPartyType(Constants.PartyType.PERSON.value());
        partyInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        partyInfoEntity.setUpdatedBy(partyInfoEntity.getCreatedBy());
        partyInfoDao.insertSelective(partyInfoEntity);

        //新增人员信息
        PersonInfoEntity personInfoEntity = new PersonInfoEntity();
        personInfoEntity.setPartyId(sysStaffDetailsEntity.getPartyId());
        personInfoEntity.setPersonName(sysPartnerStaffDetailsDto.getStaffName());
        if (StringUtil.isEmpty(sysPartnerStaffDetailsDto.getStaffSex())){
            if (Constants.SexType.man.equals(sysPartnerStaffDetailsDto.getStaffSex())){
                personInfoEntity.setSexTypeCode(Constants.Sex.man.value());
            }else if (Constants.SexType.women.equals(sysPartnerStaffDetailsDto.getStaffSex())){
                personInfoEntity.setSexTypeCode(Constants.Sex.women.value());
            }
        }
        personInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        personInfoEntity.setUpdatedBy(personInfoEntity.getCreatedBy());
        iPersonInfoDao.insertSelective(personInfoEntity);

        //新增用户信息
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setPartyId(sysStaffDetailsEntity.getPartyId());
        userInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        userInfoEntity.setUpdatedBy(userInfoEntity.getCreatedBy());
        EncrytPassword encrytPassword = new EncrytPassword(sysPartnerStaffDetailsDto.getStaffIphone());
        final String salt = encrytPassword.getSalt();
        userInfoEntity.setLoginPassword(encrytPassword.getEncrytPassword());
        userInfoEntity.setLoginSalt(salt);
        userInfoEntity.setIsLock(Constants.IsLock.UNLOCK.value());
        userInfoDao.insertSelective(userInfoEntity);



        PartyRoleRelaEntity partyRoleRelaEntity = new PartyRoleRelaEntity();
        partyRoleRelaEntity.generatePk();
        partyRoleRelaEntity.setPartyId(sysPartnerStaffDetailsDto.getPartyId());
        partyRoleRelaEntity.setRoleId(188471577922862069L);
        partyRoleRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        partyRoleRelaEntity.setUpdatedBy(userInfoEntity.getCreatedBy());
        iPartyRoleRelaDao.insertSelective(partyRoleRelaEntity);
    }


    /**
     * Description: 添加合作商管辖城市
     *
     * @param sysPartnerCityRelaDto 参数
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void insertPartnerCities(SysPartnerCityRelaDto sysPartnerCityRelaDto) {
        SysPartnerCityRelaEntity sysPartnerCityRelaEntity = new SysPartnerCityRelaEntity();
        sysPartnerCityRelaEntity =
                Copiers.beanToBean(sysPartnerCityRelaDto, SysPartnerCityRelaDto.class, SysPartnerCityRelaEntity.class);
        int partnerCityCount = sysPartnerCityRelaDao.selectBySelectiveCount(sysPartnerCityRelaEntity);
        if (partnerCityCount > 0) {
            throw new IllegalParameterException("当前合作商已存在,区域为" + sysPartnerCityRelaDto.getCityArea() + ",省份为" + sysPartnerCityRelaDto.getCityProvince() + ",城市为" + sysPartnerCityRelaDto.getCityName() + "的数据");
        } else {
            sysPartnerCityRelaEntity.generatePk();
            sysPartnerCityRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            sysPartnerCityRelaEntity.setUpdatedBy(sysPartnerCityRelaEntity.getCreatedBy());
            sysPartnerCityRelaDao.insertSelective(sysPartnerCityRelaEntity);

        }

    }


    /**
     * Description: 修改合作商信息
     *
     * @param sysPartnerDetailsDto 参数
     */
    @Override
    public void updatePartner(SysPartnerDetailsDto sysPartnerDetailsDto) {
        SysPartnerDetailsEntity sysPartnerDetailsEntity =
                Copiers.beanToBean(sysPartnerDetailsDto, SysPartnerDetailsDto.class, SysPartnerDetailsEntity.class);
        sysPartnerDetailsEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        sysPartnerDetailsEntity.setUpdatedDate(new Date());
        if(StringUtils.isNotBlank(sysPartnerDetailsEntity.getChargePersonIphone())){
            sysPartnerDetailsEntity.setChargePersonIphone(AesUtils.encryptHex(sysPartnerDetailsEntity.getChargePersonIphone(), ucmpAesConfig.getSecret()));
        }
        iSysPartnerDetailsDao.updateSelective(sysPartnerDetailsEntity);
    }


    /**
     * Description: 修改当前合作商人员信息
     *
     * @param sysPartnerStaffDetailsDto 参数
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void updatePartnerStaff(SysStaffDetailsDto  sysPartnerStaffDetailsDto) {
        //修改人员详情信息
        SysStaffDetailsEntity sysPartnerDetailsEntity = new SysStaffDetailsEntity();
        sysPartnerDetailsEntity =
                Copiers.beanToBean(sysPartnerStaffDetailsDto, SysStaffDetailsDto.class, SysStaffDetailsEntity.class);
        sysPartnerDetailsEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        sysStaffDetailsDao.updateSelective(sysPartnerDetailsEntity);

        //修改人员所属区域信息
        sysPartnerDetailsDao.updateStaffRegion(sysPartnerStaffDetailsDto.getPartyId());
        List<SysStaffRegionRelaEntity> list = new ArrayList<>();
        for (int i = 0; i < sysPartnerStaffDetailsDto.getPartyCityId().size(); i++) {
            SysStaffRegionRelaEntity sysStaffRegionRelaEntity = new SysStaffRegionRelaEntity();
            sysStaffRegionRelaEntity.setPartyId(sysPartnerStaffDetailsDto.getPartyId());
            sysStaffRegionRelaEntity.setRegionCode(sysPartnerStaffDetailsDto.getPartyCityId().get(i));
            sysStaffRegionRelaEntity.generatePk();
            sysStaffRegionRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            sysStaffRegionRelaEntity.setUpdatedBy(sysStaffRegionRelaEntity.getCreatedBy());
            list.add(sysStaffRegionRelaEntity);
        }
        iSysStaffRegionRelaDao.batchInsert(list);

        //修改登录信息
        LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
        loginInfoEntity.setLoginId(sysPartnerStaffDetailsDto.getLoginId().get(0));
        List<LoginInfoEntity> loginInfoEntities = iLoginInfoDao.selectBySelective(loginInfoEntity);
        if (Constants.IsPassword.nopassword.value().equals(loginInfoEntities.get(0).getIsPassword())){
            loginInfoEntity.setLoginName(sysPartnerStaffDetailsDto.getStaffIphone());
            loginInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            iLoginInfoDao.updateSelective(loginInfoEntity);
        }else {
            loginInfoEntity.setLoginName(Md5Util.getMD5String(sysPartnerStaffDetailsDto.getStaffIphone()));
            loginInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            iLoginInfoDao.updateSelective(loginInfoEntity);
        }



        //修改人员信息
        PersonInfoEntity personInfoEntity = new PersonInfoEntity();
        personInfoEntity.setPartyId(sysPartnerStaffDetailsDto.getPartyId());
        personInfoEntity.setPersonName(sysPartnerStaffDetailsDto.getStaffName());
        if (StringUtil.isEmpty(sysPartnerStaffDetailsDto.getStaffSex())){
            if (Constants.SexType.man.equals(sysPartnerStaffDetailsDto.getStaffName())){
                personInfoEntity.setSexTypeCode(Constants.Sex.man.value());
            }else if (Constants.SexType.women.equals(sysPartnerStaffDetailsDto.getStaffName())){
                personInfoEntity.setSexTypeCode(Constants.Sex.women.value());
            }
        }
        personInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        iPersonInfoDao.updateSelective(personInfoEntity);



    }


    /**
     * Description: 删除当前合作商信息
     * @param partnerId 合作商id
     */
    @Override
    public void dropPartnerMsg(Long partnerId) {
        SysPartnerStaffRelaEntity sysPartnerStaffRelaEntity = new SysPartnerStaffRelaEntity();
        sysPartnerStaffRelaEntity.setPartnerId(partnerId);
        if (iSysPartnerStaffRelaDao.selectBySelectiveCount(sysPartnerStaffRelaEntity)>0){
            throw new IllegalParameterException("当前合作商下存在人员，不能删除");
        }else {
            SysPartnerDetailsEntity sysPartnerDetailsEntity = new SysPartnerDetailsEntity();
            sysPartnerDetailsEntity.setPartnerId(partnerId);
            sysPartnerDetailsEntity.setIsDelete(1);
            iSysPartnerDetailsDao.updateSelective(sysPartnerDetailsEntity);
        }

    }


    /**
     * Description: 删除当前合作商管辖城市信息
     *
     * @param sysPartnerCityDropDto 参数
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void dropPartnerCitiesMsg(SysPartnerCityDropDto sysPartnerCityDropDto) {
        sysPartnerDetailsDao.deleteStaffRegion(sysPartnerCityDropDto);
        /*sysPartnerDetailsDao.deletePartnerArea(sysPartnerCityDropDto);*/
        SysPartnerCityRelaEntity sysPartnerCityRelaEntity = new SysPartnerCityRelaEntity();
        sysPartnerCityRelaEntity.setCityId(sysPartnerCityDropDto.getCityId());
        sysPartnerCityRelaDao.deleteBySelective(sysPartnerCityRelaEntity);
    }


    /**
     * Description: 删除当前合作商人员信息
     *
     * @param sysPartnerStaffDropDto 参数
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public void dropPartnerStaffMsg(SysPartnerStaffDropDto sysPartnerStaffDropDto) {
        //人员详情删除
        SysStaffDetailsEntity sysStaffDetailsEntity = new SysStaffDetailsEntity();
        sysStaffDetailsEntity.setPartyId(sysPartnerStaffDropDto.getPartyId());
        sysStaffDetailsDao.deleteBySelective(sysStaffDetailsEntity);

        //人员行政区域删除
        sysPartnerDetailsDao.updateStaffRegion(sysPartnerStaffDropDto.getPartyId());

        //人员登录信息用户锁定
        LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
        loginInfoEntity.setLoginId(sysPartnerStaffDropDto.getLoginId().get(0));
        loginInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        loginInfoEntity.setValidMark(Constants.ValidMark.INVALID.value());
        iLoginInfoDao.updateSelective(loginInfoEntity);
        loginInfoEntity.setLoginId(sysPartnerStaffDropDto.getLoginId().get(1));
        iLoginInfoDao.updateSelective(loginInfoEntity);

        //人员信息删除
        PersonInfoEntity personInfoEntity = new PersonInfoEntity();
        personInfoEntity.setPartyId(sysPartnerStaffDropDto.getPartyId());
        iPersonInfoDao.deleteBySelective(personInfoEntity);

        //用户信息锁定
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setIsLock(Constants.IsLock.LOCK.value());
        userInfoEntity.setPartyId(sysPartnerStaffDropDto.getPartyId());
        userInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
        userInfoDao.updateSelective(userInfoEntity);

        //当事人信息删除
        PartyInfoEntity partyInfoEntity = new PartyInfoEntity();
        partyInfoEntity.setPartyId(sysPartnerStaffDropDto.getPartyId());
        partyInfoDao.deleteBySelective(partyInfoEntity);

        //合作商人员关系删除
        SysPartnerCityQueryDto sysPartnerCityQueryDto = new SysPartnerCityQueryDto();
        sysPartnerCityQueryDto.setPartyId(sysPartnerStaffDropDto.getPartyId());
        sysPartnerDetailsDao.updatePartnerStaff(sysPartnerCityQueryDto);

        PartyRoleRelaEntity partyRoleRelaEntity = new PartyRoleRelaEntity();
        partyRoleRelaEntity.setPartyId(sysPartnerStaffDropDto.getPartyId());
        iPartyRoleRelaDao.deleteBySelective(partyRoleRelaEntity);
    }


	@Override
	public List<Long> findStoreIdByCurrPartnerStaff() {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity = new SysPartnerStaffStoreRelaEntity();
		sysPartnerStaffStoreRelaEntity = new SysPartnerStaffStoreRelaEntity();
		sysPartnerStaffStoreRelaEntity.setPartnerId(user.getOrganId());
		sysPartnerStaffStoreRelaEntity.setPartyId(user.getPartyId());
		List<SysPartnerStaffStoreRelaEntity> list = sysPartnerStaffStoreRelaDao.selectBySelective(sysPartnerStaffStoreRelaEntity);
		List<Long> stores = new ArrayList<>();
		for(SysPartnerStaffStoreRelaEntity entity : list) {
			stores.add(entity.getStoreId());
		}
		return stores;
	}

    @Override
    public List<Long> findPartnerStaffIdByStoreByAuto(Long storeId, Long partnerId) {
        SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity = new SysPartnerStaffStoreRelaEntity();
        sysPartnerStaffStoreRelaEntity.setPartnerId(partnerId);
        sysPartnerStaffStoreRelaEntity.setStoreId(storeId);
        List<SysPartnerStaffStoreRelaEntity> list = autoOrderReceivingDao.selectBySelective(sysPartnerStaffStoreRelaEntity);
        List<Long> listStaff = new ArrayList<>();
        for(SysPartnerStaffStoreRelaEntity entity : list) {
            listStaff.add(entity.getPartyId());
        }
        return listStaff;
    }

    @Override
	public List<Long> findPartnerStaffIdByStore(Long storeId, Long partnerId) {
		SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity = new SysPartnerStaffStoreRelaEntity();
		sysPartnerStaffStoreRelaEntity = new SysPartnerStaffStoreRelaEntity();
		sysPartnerStaffStoreRelaEntity.setPartnerId(partnerId);
		sysPartnerStaffStoreRelaEntity.setStoreId(storeId);
		List<SysPartnerStaffStoreRelaEntity> list = sysPartnerStaffStoreRelaDao.selectBySelective(sysPartnerStaffStoreRelaEntity);
		List<Long> listStaff = new ArrayList<>();
		for(SysPartnerStaffStoreRelaEntity entity : list) {
			listStaff.add(entity.getPartyId());
		}
		return listStaff;
	}

	@Override
	public List<Long> findPartnerStaffId(Long partnerId) {
		SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity = new SysPartnerStaffStoreRelaEntity();
		sysPartnerStaffStoreRelaEntity = new SysPartnerStaffStoreRelaEntity();
		sysPartnerStaffStoreRelaEntity.setPartnerId(partnerId);
		List<SysPartnerStaffStoreRelaEntity> list = sysPartnerStaffStoreRelaDao.selectBySelective(sysPartnerStaffStoreRelaEntity);
		List<Long> listStaff = new ArrayList<>();
		for(SysPartnerStaffStoreRelaEntity entity : list) {
			listStaff.add(entity.getPartyId());
		}
		return listStaff;
	}
    /*****************************************************************/
    @Override
    @Transactional
    public void insertParentUserInfo(SysPartnerStaffInfoInsertDto sysPartnerStaffDetailsDto) {
        SysStaffDetailsEntity sysStaffDetailsEntity = new SysStaffDetailsEntity();
        sysStaffDetailsEntity.setStaffIphone(sysPartnerStaffDetailsDto.getStaffIphone());
        sysStaffDetailsEntity.setStaffName(sysPartnerStaffDetailsDto.getStaffName());
        sysStaffDetailsEntity.setIsDelete(Constants.IsDelete.NO.value());

        if(StringUtils.isNotBlank(sysStaffDetailsEntity.getStaffIphone())){
            sysStaffDetailsEntity.setStaffIphone(AesUtils.encryptHex(sysStaffDetailsEntity.getStaffIphone(), ucmpAesConfig.getSecret()));
        }
        int count = sysStaffDetailsDao.selectBySelectiveCount(sysStaffDetailsEntity);
        if (count > 0) {
            throw new IllegalParameterException("手机号为" + sysPartnerStaffDetailsDto.getStaffIphone() + "名字为" + sysPartnerStaffDetailsDto.getStaffName() + "的人员已存在，不能新增");
        } else {
            sysStaffDetailsEntity =
                    Copiers.beanToBean(sysPartnerStaffDetailsDto, SysPartnerStaffInfoInsertDto.class, SysStaffDetailsEntity.class);
            //新增用户相关信息
            sysStaffDetailsEntity.setStaffType(Constants.StaffType.carDealer.value());
            SysStaffDetailsEntity sysStaffDetailsEntity1 = sysParentUserInfoService.insertParentUserInfo(sysStaffDetailsEntity,sysPartnerStaffDetailsDto.getPartnerId());

            SysPartnerStaffInfoEntity load = iSysPartnerStaffInfoDao.load(new SysPartnerStaffInfoPk(sysStaffDetailsEntity1.getPartyId()));

            //更新合作商人员信息
            SysPartnerStaffInfoEntity staffInfoEntity = new SysPartnerStaffInfoEntity();
            staffInfoEntity.setPartyId(sysStaffDetailsEntity1.getPartyId());
            staffInfoEntity.setPartnerStaffName(sysPartnerStaffDetailsDto.getStaffName());
            staffInfoEntity.setPartnerStaffIphone(AesUtils.encryptHex(sysPartnerStaffDetailsDto.getStaffIphone(), ucmpAesConfig.getSecret()));
            staffInfoEntity.setPartnerStaffSex(sysPartnerStaffDetailsDto.getStaffSex());
            staffInfoEntity.setPartnerStaffEmail(sysPartnerStaffDetailsDto.getStaffEmail());
            staffInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            staffInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            if(null == load){
                iSysPartnerStaffInfoDao.insertSelective(staffInfoEntity);
            }else{
                iSysPartnerStaffInfoDao.updateSelective(staffInfoEntity);
            }

            //新增合作商人员关系表
            SysPartnerStaffRelaEntity sysPartnerStaffRelaEntity = new SysPartnerStaffRelaEntity();
            sysPartnerStaffRelaEntity.setPartnerId(sysPartnerStaffDetailsDto.getPartnerId());
            sysPartnerStaffRelaEntity.setPartyId(sysStaffDetailsEntity1.getPartyId());
            sysPartnerStaffRelaEntity.generatePk();
            sysPartnerStaffRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            sysPartnerStaffRelaEntity.setUpdatedBy(sysPartnerStaffRelaEntity.getCreatedBy());
            iSysPartnerStaffRelaDao.insertSelective(sysPartnerStaffRelaEntity);
            //新增合作商人员门店关系表
            SysPartnerStaffStoreRelaEntity staffStoreRelaEntity;
            List<SysPartnerStaffStoreRelaEntity> sysPartnerStaffStoreRelas = new LinkedList<>();
            for (String item : sysPartnerStaffDetailsDto.getStoreIds() ) {
                staffStoreRelaEntity = new SysPartnerStaffStoreRelaEntity();
                staffStoreRelaEntity.setPartnerId(sysPartnerStaffDetailsDto.getPartnerId());
                staffStoreRelaEntity.setStoreId(Long.valueOf(item));
                staffStoreRelaEntity.setPartyId(sysStaffDetailsEntity1.getPartyId());
                staffStoreRelaEntity.generatePk();
                staffStoreRelaEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
                staffStoreRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                staffStoreRelaEntity.setUpdatedBy(staffStoreRelaEntity.getCreatedBy());
                sysPartnerStaffStoreRelas.add(staffStoreRelaEntity);
            }
            if(CollectionUtils.isNotEmpty(sysPartnerStaffStoreRelas)){
                sysPartnerStaffStoreRelaDao.batchInsert(sysPartnerStaffStoreRelas);
            }

            //创建idm账号和更新状态
            IdmUserDto idmUserDto = new IdmUserDto();
            IdmUserStatusDto idmUserStatusDto = new IdmUserStatusDto();
            try {
                idmUserDto.setUid(sysPartnerStaffDetailsDto.getStaffIphone());
                idmUserDto.setEmail(sysPartnerStaffDetailsDto.getStaffEmail());
                idmUserDto.setUserEmail(sysPartnerStaffDetailsDto.getStaffEmail());
                idmUserDto.setSex(sysPartnerStaffDetailsDto.getStaffSex());
                idmUserDto.setUserName(sysPartnerStaffDetailsDto.getStaffName());
                idmUserService.createUser(idmUserDto);

                idmUserStatusDto.setIsSendEmail("0");
                idmUserStatusDto.setStatus("1");
                idmUserStatusDto.setUid(sysPartnerStaffDetailsDto.getStaffIphone());
                idmUserService.updateUserStatus(idmUserStatusDto);
            } catch (Exception e) {
                LOGGER.error("[合作商管理]新增合作商人员时,创建idm账号和更新状态报错");
                LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
                new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
            }

        }


    }

    @Override
    public void updateParentUserInfo(SysPartnerStaffInfoInsertDto sysStaffDetailsDto) {
        SysStaffDetailsEntity sysStaffDetailsEntity = new SysStaffDetailsEntity();
        sysStaffDetailsEntity.setStaffIphone(sysStaffDetailsDto.getStaffIphone());
        sysStaffDetailsEntity.setIsDelete(Constants.IsDelete.NO.value());
        if(StringUtils.isNotBlank(sysStaffDetailsEntity.getStaffIphone())){
            sysStaffDetailsEntity.setStaffIphone(AesUtils.encryptHex(sysStaffDetailsEntity.getStaffIphone(), ucmpAesConfig.getSecret()));
        }
        List<SysStaffDetailsEntity> sysStaffDetailsEntities = sysStaffDetailsDao.selectBySelective(sysStaffDetailsEntity);
        if (sysStaffDetailsEntities.size() > 0 && ! sysStaffDetailsEntities.get(0).getPartyId().equals(sysStaffDetailsDto.getPartyId()) ) {
            throw new IllegalParameterException("手机号为" + sysStaffDetailsDto.getStaffIphone()+"的人员已存在，不能更新");
        }else{
            SysStaffDetailsEntity updateStaffDetailsEntity =
                    Copiers.beanToBean(sysStaffDetailsDto, SysPartnerStaffInfoInsertDto.class, SysStaffDetailsEntity.class);
            //更新人员信息和登录相关信息
            sysParentUserInfoService.updateParentUserInfo(updateStaffDetailsEntity);

            //更新合作商人员信息
            SysPartnerStaffInfoEntity staffInfoEntity = new SysPartnerStaffInfoEntity();
            staffInfoEntity.setPartyId(sysStaffDetailsDto.getPartyId());
            staffInfoEntity.setPartnerStaffName(sysStaffDetailsDto.getStaffName());
            staffInfoEntity.setPartnerStaffIphone(AesUtils.encryptHex(sysStaffDetailsDto.getStaffIphone(), ucmpAesConfig.getSecret()));
            staffInfoEntity.setPartnerStaffSex(sysStaffDetailsDto.getStaffSex());
            staffInfoEntity.setPartnerStaffEmail(sysStaffDetailsDto.getStaffEmail());
            staffInfoEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            staffInfoEntity.setUpdatedDate(new Date());
            iSysPartnerStaffInfoDao.updateSelective(staffInfoEntity);

            //更新合作商人员关系表
//            SysPartnerStaffRelaEntity sysPartnerStaffRelaEntity = new SysPartnerStaffRelaEntity();
//            sysPartnerStaffRelaEntity.setPartyId(sysStaffDetailsDto.getPartyId());
//            sysPartnerStaffRelaEntity.setPartnerId(sysStaffDetailsDto.getPartnerId());
//            iSysPartnerStaffRelaDao.deleteBySelective(sysPartnerStaffRelaEntity);
            //更新合作商人员关系表
            SysPartnerStaffStoreRelaEntity sysPartnerStaffRelaEntity = new SysPartnerStaffStoreRelaEntity();
            sysPartnerStaffRelaEntity.setPartyId(sysStaffDetailsDto.getPartyId());
            sysPartnerStaffRelaEntity.setPartnerId(sysStaffDetailsDto.getPartnerId());
            sysPartnerStaffStoreRelaDao.deleteBySelective(sysPartnerStaffRelaEntity);

            SysPartnerStaffStoreRelaEntity staffStoreRelaEntity;
            List<SysPartnerStaffStoreRelaEntity> sysPartnerStaffStoreRelas = new LinkedList<>();
            for (String item : sysStaffDetailsDto.getStoreIds() ) {
                staffStoreRelaEntity = new SysPartnerStaffStoreRelaEntity();
                staffStoreRelaEntity.setPartnerId(sysStaffDetailsDto.getPartnerId());
                staffStoreRelaEntity.setStoreId(Long.valueOf(item));
                staffStoreRelaEntity.setPartyId(sysStaffDetailsDto.getPartyId());
                staffStoreRelaEntity.generatePk();
                staffStoreRelaEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
                staffStoreRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                staffStoreRelaEntity.setUpdatedBy(staffStoreRelaEntity.getCreatedBy());
                sysPartnerStaffStoreRelas.add(staffStoreRelaEntity);
            }
            if(CollectionUtils.isNotEmpty(sysPartnerStaffStoreRelas)){
                sysPartnerStaffStoreRelaDao.batchInsert(sysPartnerStaffStoreRelas);
            }

        }

    }

    @Override
    @Transactional
    public void deleteUserInfoById(Long partnerId, Long partyId) {
        //删除合作商和人员关系表数据
        SysPartnerStaffRelaEntity sysPartnerStaffRelaEntity = new SysPartnerStaffRelaEntity();
        sysPartnerStaffRelaEntity.setPartyId(partyId);
        sysPartnerStaffRelaEntity.setPartnerId(partnerId);
        iSysPartnerStaffRelaDao.deleteBySelective(sysPartnerStaffRelaEntity);
        //删除合作商人员门店关系表数据
        SysPartnerStaffStoreRelaEntity staffStoreRelaEntity = new SysPartnerStaffStoreRelaEntity();
        staffStoreRelaEntity.setPartyId(partyId);
        staffStoreRelaEntity.setPartnerId(partnerId);
        sysPartnerStaffStoreRelaDao.deleteBySelective(staffStoreRelaEntity);
        //删除系统表相关数据
        sysParentUserInfoService.deleteUserInfoById(partyId);
        //合作商人员信息表标记为无效
        SysPartnerStaffInfoEntity staffInfoEntity = new SysPartnerStaffInfoEntity();
        staffInfoEntity.setIsDelete(Constants.IsDelete.YES.value());
        staffInfoEntity.setPartyId(partyId);
        staffInfoEntity.setUpdatedDate(new Date());
        iSysPartnerStaffInfoDao.updateSelective(staffInfoEntity);

        //创建idm账号更新状态
        IdmUserStatusDto idmUserStatusDto = new IdmUserStatusDto();
        try {
            SysPartnerStaffInfoEntity load = iSysPartnerStaffInfoDao.load(new SysPartnerStaffInfoPk(partyId));
            if(Objects.isNull(load)){
                LOGGER.error("[合作商管理]删除合作商人员时，没有找到对应合作商人员信息,partyId:{}",partyId);
            }else{
                idmUserStatusDto.setStatus("0");
                idmUserStatusDto.setIsSendEmail("0");
                staffInfoEntity.setPartnerStaffIphone(AesUtils.encryptHex(load.getPartnerStaffIphone(), ucmpAesConfig.getSecret()));
                idmUserStatusDto.setUid(AesUtils.decryptHex(load.getPartnerStaffIphone(), ucmpAesConfig.getSecret()));
                idmUserService.updateUserStatus(idmUserStatusDto);
            }
        } catch (Exception e) {
            LOGGER.error("[合作商管理]删除合作商人员时，更新idm账号状态报错");
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }

    }

    @Override
    public PageInfo<SysStoreInfoDto> findPartnerStorePage(SysParentStoreQueryDto sysPartnerStaffDetailsDto) {
        PageHelper.startPage(sysPartnerStaffDetailsDto.getPageNum(), sysPartnerStaffDetailsDto.getPageSize());
        List<SysStoreInfoDto> sysStoreInfoDtos = sysStoreDetailsDao.selectStoreByPartnerId(sysPartnerStaffDetailsDto.getPartnerId());
        return new PageInfo<>(sysStoreInfoDtos);
    }

    @Override
    public PageInfo<SysParentAddStoreListDto> findAddPartnerStorePage(SysParentStoreQueryDto sysParentStoreQueryDto) {
        SysStoreInfoEntity infoEntity = new SysStoreInfoEntity();
        infoEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
        if(StringUtils.isNotBlank(sysParentStoreQueryDto.getProvinceId())){
            infoEntity.setProvinceId(sysParentStoreQueryDto.getProvinceId());
        }
        if(StringUtils.isNotBlank(sysParentStoreQueryDto.getCityId())){
            infoEntity.setCityId(sysParentStoreQueryDto.getCityId());
        }
        //获取所有门店数据
        PageHelper.startPage(sysParentStoreQueryDto.getPageNum(), sysParentStoreQueryDto.getPageSize());
        List<SysStoreInfoEntity> storeInfoEntities = iSysStoreInfoDao.selectBySelective(infoEntity);
        List<SysParentAddStoreListDto> staffListDtos = Copiers.beansToBeans(storeInfoEntities, SysStoreInfoEntity.class, SysParentAddStoreListDto.class);

        //获取当前合作商和门店关系数据
        SysStorePartnerRelaEntity sysStoreInfoEntity = new SysStorePartnerRelaEntity();
        sysStoreInfoEntity.setPartnerId(sysParentStoreQueryDto.getPartnerId());
        List<SysStorePartnerRelaEntity> storeStaffRelaMap = iSysStorePartnerRelaDao.selectBySelective(sysStoreInfoEntity);

        Map<Long, SysStorePartnerRelaEntity> collect = storeStaffRelaMap.stream().collect(Collectors.toMap(p -> p.getStoreId(), p -> p));

        staffListDtos.forEach(item->{
            if(collect.containsKey(item.getStoreId())){
                item.setStoreFlag(true);
            }else{
                item.setStoreFlag(false);
            }
        });
        PageInfo<SysParentAddStoreListDto> objectPageInfo = new PageInfo<>();
        objectPageInfo.setTotal(iSysStoreInfoDao.selectBySelectiveCount(infoEntity));
        objectPageInfo.setList(staffListDtos);
        Long count = objectPageInfo.getTotal() % sysParentStoreQueryDto.getPageSize() == 0 ? objectPageInfo.getTotal() / sysParentStoreQueryDto.getPageSize() : objectPageInfo.getTotal() /sysParentStoreQueryDto.getPageSize() + 1 ;
        objectPageInfo.setPages(Integer.valueOf(count.toString()));
        return objectPageInfo;
    }
    @Transactional
    @Override
    public void authorizeStore(SysPartnerStoreAuthDto storeAuthDto) {
        SysStorePartnerRelaEntity staffRelaEntity = new SysStorePartnerRelaEntity();
        staffRelaEntity.setPartnerId(storeAuthDto.getPartnerId());
        staffRelaEntity.setStoreId(storeAuthDto.getSelectStoreId());
        if(storeAuthDto.isStoreFlag()){
            int i = iSysStorePartnerRelaDao.selectBySelectiveCount(staffRelaEntity);
            if(i > 0){
                throw new IllegalParameterException("当前合作商已存在该门店信息，不能新增!");
            }
            staffRelaEntity.generatePk();
            staffRelaEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
            staffRelaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            staffRelaEntity.setUpdatedBy(staffRelaEntity.getCreatedBy());
            iSysStorePartnerRelaDao.insertSelective(staffRelaEntity);
        }else{
            iSysStorePartnerRelaDao.deleteBySelective(staffRelaEntity);
            SysPartnerStaffStoreRelaEntity partnerStaffStoreRela = new SysPartnerStaffStoreRelaEntity();
            partnerStaffStoreRela.setPartnerId(storeAuthDto.getPartnerId());
            partnerStaffStoreRela.setStoreId(storeAuthDto.getSelectStoreId());
            //同时删除合作商人员关系表 t_sys_partner_staff_rela
            List<SysPartnerStaffStoreRelaEntity> partnerStaffStoreRelaEntities = sysPartnerStaffStoreRelaDao.selectBySelective(partnerStaffStoreRela);
            for (SysPartnerStaffStoreRelaEntity item :partnerStaffStoreRelaEntities) {
                SysPartnerStaffRelaEntity partnerStaffRelaEntity = new SysPartnerStaffRelaEntity();
                partnerStaffRelaEntity.setPartyId(item.getPartyId());
                partnerStaffRelaEntity.setPartnerId(storeAuthDto.getPartnerId());
                iSysPartnerStaffRelaDao.deleteBySelective(partnerStaffRelaEntity);
            }
            //最后删除合作商门店人员关系表 t_sys_partner_staff_store_rela
            sysPartnerStaffStoreRelaDao.deleteBySelective(partnerStaffStoreRela);
        }
    }

    @Override
    public void modifyPartnerStatus(SysPartnerStatusDto sysPartnerStatusDto) {
        SysPartnerDetailsEntity sysPartnerDetailsEntity = new SysPartnerDetailsEntity();
        sysPartnerDetailsEntity.setPartnerId(sysPartnerStatusDto.getPartnerId());
        sysPartnerDetailsEntity.setPartnerStatus(sysPartnerStatusDto.getIsEnable());
        iSysPartnerDetailsDao.updateSelective(sysPartnerDetailsEntity);
    }
    @Override
    public void batchModifyPartnerStatus(SysPartnerStatusDto sysPartnerStatusDto) {
        List<SysPartnerDetailsEntity> list = new ArrayList<>();
        SysPartnerDetailsEntity sysPartnerDetailsEntity;
        for (Long item : sysPartnerStatusDto.getPartnerIds()) {
            sysPartnerDetailsEntity = new SysPartnerDetailsEntity();
            sysPartnerDetailsEntity.setPartnerId(item);
            sysPartnerDetailsEntity.setPartnerStatus(sysPartnerStatusDto.getIsEnable());
            list.add(sysPartnerDetailsEntity);
        }
        if(CollectionUtils.isNotEmpty(list)){
            iSysPartnerDetailsDao.batchUpdateSelective(list);
        }
    }

    @Override
    public PageInfo<SysPartnerStaffDetailsDto> findPartnerStaffPage(SysPartnerStaffQueryDto staffQueryDto) {
        PageHelper.startPage(staffQueryDto.getPageNum(), staffQueryDto.getPageSize());
        List<SysPartnerStaffDetailsDto> sysPartnerStaffDetailsDtos = sysPartnerDetailsDao.selectPartnerStoreStaffList(staffQueryDto);
        List<SysPartnerStaffDetailsDto> concatPartnerStoreStaffList = sysPartnerDetailsDao.selectConcatPartnerStoreStaffList(staffQueryDto.getPartnerId());
        if(CollectionUtils.isNotEmpty(concatPartnerStoreStaffList)){
        	try{
        		StringBuffer storeIds;
        		StringBuffer orgNames;
        		for (SysPartnerStaffDetailsDto item :sysPartnerStaffDetailsDtos) {
        			storeIds = new StringBuffer();
        			orgNames = new StringBuffer();
        			for (SysPartnerStaffDetailsDto conCatItem :concatPartnerStoreStaffList) {
        				if(conCatItem.getPartyId().equals(item.getPartyId())){
        					storeIds.append(conCatItem.getStoreId().toString());
        					storeIds.append(",");
        					orgNames.append(conCatItem.getOrgName());
        					orgNames.append(",");
        				}
        			}
        			item.setOrgName(orgNames.deleteCharAt(orgNames.length() - 1).toString());
        			item.setStoreIds(storeIds.deleteCharAt(storeIds.length() - 1).toString());
        		}
        		
        		for (SysPartnerStaffDetailsDto item :sysPartnerStaffDetailsDtos) {
        			//手机号解密再返回
        			if(StringUtils.isNotBlank(item.getPartyIphone())){
        				item.setPartyIphone(AesUtils.decryptHex(item.getPartyIphone(), ucmpAesConfig.getSecret()));
        			}
        		}
        	}catch (Exception e){
        		LOGGER.error("解密手机号失败:",e);
        		throw  new RuntimeException(e);
        	}
        }
        return new PageInfo<>(sysPartnerStaffDetailsDtos);
    }


    @Override
    @Transactional
    public void deletePartnerStaffById(Long partnerId, Long partyId,String storeIds) {
        //删除合作商人员关联
        SysPartnerStaffRelaEntity sysPartnerStaffRela = new SysPartnerStaffRelaEntity();
        sysPartnerStaffRela.setPartnerId(partnerId);
        sysPartnerStaffRela.setPartyId(partyId);
        iSysPartnerStaffRelaDao.deleteBySelective(sysPartnerStaffRela);
        //删除合作商门店人员关联
        String[] split = storeIds.split(",");
        for (String item :split) {
            SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity = new SysPartnerStaffStoreRelaEntity();
            sysPartnerStaffStoreRelaEntity.setPartnerId(partnerId);
            sysPartnerStaffStoreRelaEntity.setPartyId(partyId);
            sysPartnerStaffStoreRelaEntity.setStoreId(Long.valueOf(item));
            sysPartnerStaffStoreRelaDao.deleteBySelective(sysPartnerStaffStoreRelaEntity);

        }
    }

    @Override
    public void updateSort(String partnerId, Double sort) {
        SysPartnerDetailsEntity select = new SysPartnerDetailsEntity();
        select.setPartnerOrder(sort);
        int i = iSysPartnerDetailsDao.selectBySelectiveCount(select);
        SysPartnerDetailsEntity detailsEntity = iSysPartnerDetailsDao.load(new SysPartnerDetailsPk(Long.valueOf(partnerId)));
        if((!Objects.isNull(detailsEntity.getPartnerOrder()) && detailsEntity.getPartnerOrder().compareTo(sort) != 0) && i>0){
            throw new IllegalParameterException("当前合作商已存在该排序，更新失败!");
        }else if(Objects.isNull(detailsEntity.getPartnerOrder()) &&  i>0){
            throw new IllegalParameterException("当前合作商已存在该排序，更新失败!");
        }
        detailsEntity.setPartnerOrder(sort);
        iSysPartnerDetailsDao.updateSelective(detailsEntity);
    }

    @Override
    public List<SysStoreInfoDto> getPartnerStoreList(Long partnerId) {
        List<SysStoreInfoDto> sysStoreInfoDtos = sysStoreDetailsDao.selectStoreByPartnerId(partnerId);
        return sysStoreInfoDtos;
    }


}
