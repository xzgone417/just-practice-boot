package com.exp.ucmp.store.service.impl;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.idm.dto.IdmUserStatusDto;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.partner.dao.SysPartnerStaffInfoDao;
import com.exp.ucmp.pertner.dto.SysPartnerDetailsDto;
import com.exp.ucmp.pk.SysPartnerStaffInfoPk;
import com.exp.ucmp.pk.SysPartnerStaffStoreRelaPk;
import com.exp.ucmp.pk.SysStorePartnerRelaPk;
import com.exp.ucmp.staff.dto.PartyRoleRelaDto;
import com.exp.ucmp.store.dao.PsiSalesDao;
import com.exp.ucmp.store.dao.SysStoreDetailsDao;
import com.exp.ucmp.store.dto.*;
import com.exp.ucmp.store.service.SysStoreDetailsService;
import com.exp.ucmp.user.service.IdmUserService;
import com.exp.ucmp.util.AesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SysStoreDetailsServiceImpl implements SysStoreDetailsService {
    @Autowired
    private SysStoreDetailsDao sysStoreDetailsDao;

    @Autowired
    private ISysStoreInfoDao iSysStoreInfoDao;

    @Autowired
    private ISysStaffAreaLogDao iSysStaffAreaLogDao;

    @Autowired
    private ISysStaffDetailsDao iSysStaffDetailsDao;

    @Autowired
    private SysPartnerStaffInfoDao sysPartnerStaffInfoDao;

    @Autowired
    private ISysStorePartnerRelaDao iSysStorePartnerRelaDao;
    @Autowired
    private ISysPartnerStaffInfoDao iSysPartnerStaffInfoDao;
    @Autowired
    private ISysPartnerStaffStoreRelaDao iSysPartnerStaffStoreRelaDao;
    @Autowired
    private UcmpAesConfig ucmpAesConfig;
    @Autowired
    private ILoginInfoDao iLoginInfoDao;
    @Autowired
    private ISysStoreStaffInfoDao iSysStoreStaffInfoDao;
    @Autowired
    private IPartyRelationshipDao iPartyRelationshipDao;
    @Autowired
    private IdmUserService idmUserService;

    @Autowired
    private ISysStoreStaffDetailsDao iSysStoreStaffDetailsDao;

    @Autowired
    private  IStorePartyRoleRelaDao iStorePartyRoleRelaDao;
    @Autowired
    private PsiSalesDao psiSalesDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(SysStoreDetailsServiceImpl.class);

    /**
     * Description: 根据条件查询集合实体(门店信息)
     * @param sysStoreInfoQueryDto 查询条件
     * @return 实体集合
     */
    @Override
    public PageInfo<SysStoreInfoDto> queryStoreMsg(SysStoreInfoQueryDto sysStoreInfoQueryDto) {
        PageHelper.startPage(sysStoreInfoQueryDto.getPageNum(), sysStoreInfoQueryDto.getPageSize());
        List<SysStoreInfoDto> sysStoreDetailsList = sysStoreDetailsDao.selectStoreMsg(sysStoreInfoQueryDto);
        PageInfo<SysStoreInfoDto> page = new PageInfo<>(sysStoreDetailsList);
        return page;
    }

    @Override
    public List<SysStoreInfoDto> listStoreInfo(SysStoreInfoQueryDto sysStoreInfoQueryDto) {
        List<SysStoreInfoDto> sysStoreDetailsList = sysStoreDetailsDao.selectStoreMsg(sysStoreInfoQueryDto);
        return sysStoreDetailsList;
    }

    @Override
    public List<SysFindStoreByNameDto> queryStoreByStoreName(SysFindStoreByNameParamsDto paramsDto){
        return sysStoreDetailsDao.selectStoreByStoreName(paramsDto.getStoreName(), paramsDto.getPartnerId());
    }

    @Override
    public List<SysFindPartnerByNameDto> queryPartnerByName(String name) {
        return sysStoreDetailsDao.selectSysPartnerByName(name);
    }


    /**
     * Description: 根据条件查询集合实体(门店人员信息)
     * @param sysStoreStaffInfoQueryDto 查询条件
     * @return 实体集合
     */
    @Override
    public PageInfo<SysStoreStaffInfoDto> queryStoreStaff(SysStoreStaffInfoQueryDto sysStoreStaffInfoQueryDto){
        PageHelper.startPage(sysStoreStaffInfoQueryDto.getPageNum(), sysStoreStaffInfoQueryDto.getPageSize());
        List<SysStoreStaffInfoDto> sysStoreDetailsList = this.listStoreStaffInfo(sysStoreStaffInfoQueryDto);
        PageInfo<SysStoreStaffInfoDto> page = new PageInfo<SysStoreStaffInfoDto>(sysStoreDetailsList);
        return page;
    }

    public List<SysStoreStaffInfoDto> listStoreStaffInfo(SysStoreStaffInfoQueryDto sysStoreStaffInfoQueryDto){
        //手机号加密查询
        if(StringUtils.isNotBlank(sysStoreStaffInfoQueryDto.getStaffIphone())){
            sysStoreStaffInfoQueryDto.setStaffIphone(AesUtils.encryptHex(sysStoreStaffInfoQueryDto.getStaffIphone(), ucmpAesConfig.getSecret()));
        }
        List<SysStoreStaffInfoDto> sysStoreDetailsList = sysStoreDetailsDao.selectStoreStaff(sysStoreStaffInfoQueryDto);
        try {
            //手机号解密再返回
            for (SysStoreStaffInfoDto item :sysStoreDetailsList) {
                if(StringUtils.isNotBlank(item.getStaffIphone())){
                    item.setStaffIphone(AesUtils.decryptHex(item.getStaffIphone(), ucmpAesConfig.getSecret()));
                }
            }
        }catch (Exception e){
            LOGGER.error("手机号解密失败=========",e);
        }
        return sysStoreDetailsList;
    }



    /**
     * Description: 门店状态改变(门店状态：启用01/禁用00（当前门店是否能在APP端可见）)
     * @param sysStoreStatusDto 查询条件
     */
    @Override
    public void modifyStoreStatus(SysStoreStatusDto sysStoreStatusDto) {
        SysStoreInfoEntity sysStoreInfoEntity = new SysStoreInfoEntity();
        sysStoreInfoEntity.setStoreId(sysStoreStatusDto.getStoreId());
        sysStoreInfoEntity.setIsEnable(sysStoreStatusDto.getIsEnable());
        iSysStoreInfoDao.updateSelective(sysStoreInfoEntity);
    }

    /**
     * Description: 批量门店状态改变
     * @param sysStoreStatusDto
     */
    @Override
    public void batchModifyStoreStatus(SysStoreStatusDto sysStoreStatusDto) {
        SysStoreInfoEntity sysStoreInfoEntity;
        List<SysStoreInfoEntity> list = new ArrayList<>();
        for (Long item : sysStoreStatusDto.getStoreIds()) {
            sysStoreInfoEntity = new SysStoreInfoEntity();
            sysStoreInfoEntity.setStoreId(item);
            sysStoreInfoEntity.setIsEnable(sysStoreStatusDto.getIsEnable());
            list.add(sysStoreInfoEntity);
        }
        if(CollectionUtils.isNotEmpty(list)){
            iSysStoreInfoDao.batchUpdateSelective(list);
        }
    }

    /**
     * Description: 修改门店官二资质状态
     * @param sysStoreStatusDto 查询条件
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String modifyQualificationStatus(SysStoreStatusDto sysStoreStatusDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        SysStoreInfoEntity sysStoreInfoEntity = new SysStoreInfoEntity();
        sysStoreInfoEntity.setStoreId(sysStoreStatusDto.getStoreId());
        sysStoreInfoEntity.setQualificationStatus(sysStoreStatusDto.getQualificationStatus());
        sysStoreInfoEntity.setUpdatedBy(user.getPartyId());
        sysStoreInfoEntity.setUpdatedDate(new Date());
        iSysStoreInfoDao.updateSelective(sysStoreInfoEntity);
        //官二资质为禁用时相关的销售客户，重新流转到分配池中
        if(Objects.equals(sysStoreStatusDto.getQualificationStatus(),"00")){
            psiSalesDao.redistributionCustomer(sysStoreStatusDto.getStoreId(),user.getPartyId());
            psiSalesDao.redistributionClues(sysStoreStatusDto.getStoreId(),user.getPartyId());
            psiSalesDao.redistributionOrder(sysStoreStatusDto.getStoreId(),user.getPartyId());
            psiSalesDao.updateConfig(sysStoreStatusDto.getStoreId(),user.getPartyId());
            return "该门店相关的销售信息，已重新流转线索池！";
        }
        return "1";
    }

    /**
     * 批量修改门店官二资质状态
     * @param sysStoreStatusDto
     */
    @Override
    public void batchQualificationStatus(SysStoreStatusDto sysStoreStatusDto) {
        SysStoreInfoEntity sysStoreInfoEntity;
        List<SysStoreInfoEntity> list = new ArrayList<>();
        for (Long item : sysStoreStatusDto.getStoreIds()) {
            sysStoreInfoEntity = new SysStoreInfoEntity();
            sysStoreInfoEntity.setStoreId(item);
            sysStoreInfoEntity.setQualificationStatus(sysStoreStatusDto.getQualificationStatus());
            list.add(sysStoreInfoEntity);
        }
        if(CollectionUtils.isNotEmpty(list)){
            iSysStoreInfoDao.batchUpdateSelective(list);
        }
    }
    /**
     * Description: 门店员工改变(人员状态：启用01/禁用00)
     * @param sysStoreStaffStatusDto 查询条件
     */
    @Override
    public void modifyStoreStaffStatus(SysStoreStaffStatusDto sysStoreStaffStatusDto) {
        SysStaffDetailsEntity sysStaffDetailsEntity = new SysStaffDetailsEntity();
        sysStaffDetailsEntity =
                Copiers.beanToBean(sysStoreStaffStatusDto, SysStoreStaffStatusDto.class, SysStaffDetailsEntity.class);
        iSysStaffDetailsDao.updateSelective(sysStaffDetailsEntity);
    }


    /**
     * Description: 新增门店信息
     * @param sysStoreAddDto 门店信息集合
     */
    @Override
    public void insertStore(SysStoreAddDto sysStoreAddDto) {
        SysStoreInfoEntity sysStoreInfoEntity = new SysStoreInfoEntity();
        List<SysStoreInfoEntity> sysStoreInfoEntityList = new ArrayList<>();
        for (int i = 0; i <sysStoreAddDto.getSysStoreInfoDtoList().size() ; i++) {
            SysStoreInfoDto sysStoreInfoDto = sysStoreAddDto.getSysStoreInfoDtoList().get(i);
            sysStoreInfoEntity =
                    Copiers.beanToBean(sysStoreInfoDto, SysStoreInfoDto.class, SysStoreInfoEntity.class);
            sysStoreInfoEntity.generatePk();
            sysStoreInfoEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            sysStoreInfoEntity.setUpdatedBy(sysStoreInfoEntity.getCreatedBy());
            int sysStoreCount = iSysStoreInfoDao.selectBySelectiveCount(sysStoreInfoEntity);
            if (sysStoreCount>0){
                throw new IllegalParameterException("门店(" + sysStoreInfoDto.getStoreCode() + ")已存在，不能新增!");
            }else {
                sysStoreInfoEntityList.add(sysStoreInfoEntity);
            }

        }
            iSysStoreInfoDao.batchInsert(sysStoreInfoEntityList);

    }

    @Override
    public PageInfo<SysPartnerStaffInfoDto> findPartnerStaffInfo(Long storeId,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysPartnerStaffInfoDto> staffInfoDtos = sysPartnerStaffInfoDao.selectPartnerStaffInfoByStoreId(storeId);
        try {
            //手机号解密再返回
            for (SysPartnerStaffInfoDto item :staffInfoDtos) {
                if(StringUtils.isNotBlank(item.getPartnerStaffIphone())){
                    item.setPartnerStaffIphone(AesUtils.decryptHex(item.getPartnerStaffIphone(), ucmpAesConfig.getSecret()));
                }
            }
        }catch (Exception e){
            LOGGER.error("手机号解密失败=========",e);
        }
        return new PageInfo<>(staffInfoDtos);
    }

    @Override
    public PageInfo<SysPartnerDetailsDto> findPartnerDetails(Long storeId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<SysPartnerDetailsDto> detailsByStoreId = sysPartnerStaffInfoDao.findPartnerDetailsByStoreId(storeId);
        return new PageInfo<>(detailsByStoreId);
    }
    @Transactional
    @Override
    public void modifyPartnerStatus(Long relaId, String isEnable) {
        SysStorePartnerRelaEntity sysStorePartnerRelaEntity = new SysStorePartnerRelaEntity();
        sysStorePartnerRelaEntity.setIsEnable(isEnable);
        sysStorePartnerRelaEntity.setRelaId(relaId);
        iSysStorePartnerRelaDao.updateSelective(sysStorePartnerRelaEntity);
        //同时禁用t_sys_partner_staff_store_rela合作商人员门店关系表
        SysStorePartnerRelaPk relaPk = new SysStorePartnerRelaPk();
        relaPk.setRelaId(relaId);
        SysStorePartnerRelaEntity load = iSysStorePartnerRelaDao.load(relaPk);
        if(!Objects.isNull(load)) {
            SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRela = new SysPartnerStaffStoreRelaEntity();
            sysPartnerStaffStoreRela.setStoreId(load.getStoreId());
            sysPartnerStaffStoreRela.setPartnerId(load.getPartnerId());
            List<SysPartnerStaffStoreRelaEntity> storeRelaEntities = iSysPartnerStaffStoreRelaDao.selectBySelective(sysPartnerStaffStoreRela);
            //storeRelaEntities.stream().forEach(item->{ item.setIsEnable(isEnable)};
            storeRelaEntities.stream().forEach(item->{item.setIsEnable(isEnable);});
            iSysPartnerStaffStoreRelaDao.batchUpdate(storeRelaEntities);
        }
    }
    @Transactional
    @Override
    public void modifyPartnerStaffStatus(Long relaId, String isEnable) {
        SysPartnerStaffStoreRelaEntity sysStorePartnerRelaEntity = new SysPartnerStaffStoreRelaEntity();
        sysStorePartnerRelaEntity.setIsEnable(isEnable);
        sysStorePartnerRelaEntity.setRelaId(relaId);
        iSysPartnerStaffStoreRelaDao.updateSelective(sysStorePartnerRelaEntity);
        SysPartnerStaffStoreRelaPk relaPk = new SysPartnerStaffStoreRelaPk();
        relaPk.setRelaId(relaId);
        SysPartnerStaffStoreRelaEntity load = iSysPartnerStaffStoreRelaDao.load(relaPk);
        //再次判断启用禁用，更改登录状态
        if(!Objects.isNull(load)){
            LoginInfoEntity loginInfoEntity = new LoginInfoEntity();
            loginInfoEntity.setPartyId(load.getPartyId());
            List<LoginInfoEntity> infoEntities = iLoginInfoDao.selectBySelective(loginInfoEntity);
            infoEntities.stream().forEach(item->{ item.setValidMark
                    (Constants.IsEnable.ENABLE.value().equals(isEnable)?Constants.ValidMark.VALID.value():Constants.ValidMark.TEMP_FAIL.value());});
            iLoginInfoDao.batchUpdate(infoEntities);


            //同时idm账号更新状态
            IdmUserStatusDto idmUserStatusDto = new IdmUserStatusDto();
            try {
                SysPartnerStaffInfoEntity load1 = iSysPartnerStaffInfoDao.load(new SysPartnerStaffInfoPk(load.getPartyId()));
                if(Objects.isNull(load1)){
                    LOGGER.error("[门店管理]车商指定人状态更改时，没有找到对应车商指定人信息,partyId:{}",load1.getPartyId());
                }else{
                    idmUserStatusDto.setStatus(Constants.IsEnable.ENABLE.value().equals(isEnable)? "1" : "0");
                    idmUserStatusDto.setIsSendEmail("0");
                    idmUserStatusDto.setUid(AesUtils.decryptHex(load1.getPartnerStaffIphone(), ucmpAesConfig.getSecret()));
                    idmUserService.updateUserStatus(idmUserStatusDto);
                }
            } catch (Exception e) {
                LOGGER.error("[门店管理]车商指定人状态更改时，更新idm账号状态报错");
                LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
                new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
            }
        }


    }

    /**
     * 临时接口
     */
    @Override
    public void testStoreRelationship() {
        //获取所有的门店人员数据
        List<SysStoreStaffInfoEntity> storeStaffInfoEntities = iSysStoreStaffInfoDao.selectBySelective(new SysStoreStaffInfoEntity());
        List<PartyRelationshipEntity> relationshipEntities = iPartyRelationshipDao.selectBySelective(new PartyRelationshipEntity());

        Map<String, PartyRelationshipEntity> relationshipMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(relationshipEntities)){
            relationshipMap = relationshipEntities.stream().collect(Collectors.toMap(p -> String.valueOf(p.getSrcPartyId())+p.getTagPartyId(), p -> p ));
        }
        PartyRelationshipEntity relationshipEntity;
        List<PartyRelationshipEntity> partyRelationshipList = new LinkedList<>();
        Long userBy= AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
        for (SysStoreStaffInfoEntity item :storeStaffInfoEntities) {
            String key = String.valueOf(item.getPartyId())+item.getStoreId();
            if(!relationshipMap.containsKey(key)){
                //创建补充数据
                relationshipEntity = new PartyRelationshipEntity();
                relationshipEntity.generatePk();
                relationshipEntity.setRelationshipTypeCode(Constants.RelationshipTypeCode.USER.value());
                relationshipEntity.setSrcPartyId(item.getPartyId());
                //这一块填写门店id
                relationshipEntity.setTagPartyId(item.getStoreId());
                relationshipEntity.setCreatedBy(userBy);
                relationshipEntity.setUpdatedBy(userBy);
                partyRelationshipList.add(relationshipEntity);
            }
        }
        if(CollectionUtils.isNotEmpty(partyRelationshipList)){
            iPartyRelationshipDao.batchInsert(partyRelationshipList);
        }

    }

    @Override
    public void editStoreStaffRole(PartyRoleRelaDto partyRoleRelaDto) {
        StorePartyRoleRelaEntity relaEntity = new StorePartyRoleRelaEntity();
        relaEntity.setPartyId(partyRoleRelaDto.getPartyId());
        relaEntity.setRoleId(partyRoleRelaDto.getSelectRoleId());
        if(partyRoleRelaDto.isRoleFlag()){
            int i = iStorePartyRoleRelaDao.selectBySelectiveCount(relaEntity);
            if(i > 0){
                throw new IllegalParameterException("当前人员已存在该角色信息，不能新增!");
            }
            relaEntity.generatePk();
            relaEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            relaEntity.setUpdatedBy(relaEntity.getCreatedBy());
            iStorePartyRoleRelaDao.insert(relaEntity);
        }else{
            iStorePartyRoleRelaDao.deleteBySelective(relaEntity);
        }

    }

	@Override
	public List<DeliveryCenterDto> findDeliveryCenter(String storeName) {
		return this.sysStoreDetailsDao.findDeliveryCenter(storeName);
	}

    /**
     * 修改门店人员官二资质状态
     * @param sysStoreStaffQualificationStatusDto
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String modifyStoreStaffQualificationStatus(SysStoreStaffQualificationStatusDto sysStoreStaffQualificationStatusDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        SysStoreStaffDetailsEntity sysStoreStaffDetailsEntity = new SysStoreStaffDetailsEntity();
        sysStoreStaffDetailsEntity =
                Copiers.beanToBean(sysStoreStaffQualificationStatusDto, SysStoreStaffQualificationStatusDto.class, SysStoreStaffDetailsEntity.class);
        iSysStoreStaffDetailsDao.updateSelective(sysStoreStaffDetailsEntity);
        //官二资质为禁用时相关的销售客户，重新流转到分配池中
        if(Objects.equals(sysStoreStaffQualificationStatusDto.getQualificationStatus(),"00")){
            psiSalesDao.redistributionCustomerParty(sysStoreStaffQualificationStatusDto.getPartyId(),user.getPartyId());
            psiSalesDao.redistributionCluesParty(sysStoreStaffQualificationStatusDto.getPartyId(),user.getPartyId());
            psiSalesDao.redistributionOrderParty(sysStoreStaffQualificationStatusDto.getPartyId(),user.getPartyId());
            return "该人员相关的销售信息，已重新流转线索池！";
        }
        return "1";
    }


}
