package com.exp.ucmp.storage.service.impl;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.alibaba.nacos.common.utils.StringUtils;
import com.egrid.cache.redisson.cache.RedissonCache;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.ISysCarUsedStorageDao;
import com.exp.ucmp.dao.ISysStoreInfoDao;
import com.exp.ucmp.entity.SysCarUsedStorageEntity;
import com.exp.ucmp.entity.SysStoreInfoEntity;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.SysCarUsedStoragePk;
import com.exp.ucmp.storage.service.CarUsedStorageService;
import com.exp.ucmp.usedstorage.dto.*;
import com.exp.ucmp.util.AesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class CarUsedStorageServiceImpl implements CarUsedStorageService {

    @Autowired
    private UcmpAesConfig ucmpAesConfig;

    @Autowired
    private ISysStoreInfoDao iSysStoreInfoDao;

    @Autowired
    private ISysCarUsedStorageDao iSysCarUsedStorageDao;

    @Autowired
    RedissonCache redissonCache;

    private static final Logger LOGGER = LoggerFactory.getLogger(CarUsedStorageServiceImpl.class);

    @Override
    public List<SysUsedStorageListDto> findList() {
        //查询所有销售总公司
        SysStoreInfoEntity storeInfo = new SysStoreInfoEntity();
        storeInfo.setSyncIsEnable(Constants.IsEnable.ENABLE.value());
        storeInfo.setOrgType(Constants.OrgType.PARENT_OFFICE.getOrgCode());
        List<SysStoreInfoEntity> oldEntities = iSysStoreInfoDao.selectBySelective(storeInfo);
        List<SysUsedStorageListDto> oldList = Copiers.beansToBeans(oldEntities, SysStoreInfoEntity.class, SysUsedStorageListDto.class);

        //查询所有交付中心
        storeInfo = new SysStoreInfoEntity();
        storeInfo.setOrgType(Constants.OrgType.SUBMIT_CORE.getOrgCode());
        storeInfo.setSyncIsEnable(Constants.IsEnable.ENABLE.value());
        List<SysStoreInfoEntity> secondEntities = iSysStoreInfoDao.selectBySelective(storeInfo);
        List<SysUsedStorageDeliveryListDto> secondList = Copiers.beansToBeans(secondEntities, SysStoreInfoEntity.class, SysUsedStorageDeliveryListDto.class);

        //查询所有仓库
        SysCarUsedStorageEntity usedStorageEntity = new SysCarUsedStorageEntity();
        List<SysCarUsedStorageEntity> thirdEntities = iSysCarUsedStorageDao.selectBySelective(usedStorageEntity);
        List<SysUsedStorageListInfoDto> thirdList = Copiers.beansToBeans(thirdEntities, SysCarUsedStorageEntity.class, SysUsedStorageListInfoDto.class);
        //查询所有的直属仓储点
        SysCarUsedStorageEntity usedStorageEntity1 = new SysCarUsedStorageEntity();
        usedStorageEntity1.setOrgId(Long.valueOf(oldEntities.get(0).getOrgId()));
        List<SysCarUsedStorageEntity> directlyEntities = iSysCarUsedStorageDao.selectBySelective(usedStorageEntity1);
        List<SysUsedStorageDeliveryListDto> directlyList = new LinkedList<>();
        for (SysCarUsedStorageEntity item : directlyEntities) {
            SysUsedStorageDeliveryListDto deliveryListDto = new SysUsedStorageDeliveryListDto();
            deliveryListDto.setOrgType("6");
            deliveryListDto.setOrgName(item.getStorageName());
            deliveryListDto.setStorageId(item.getStorageId().toString());
            directlyList.add(deliveryListDto);
        }
        for (SysUsedStorageListDto oldItem : oldList) {
            //只有一个总公司，下面的交付中心都属于一个
            //查询交付中心所属仓库
            for (SysUsedStorageDeliveryListDto secondItem :secondList) {
                List<SysUsedStorageListInfoDto> storageList = new ArrayList<>();
                for (SysUsedStorageListInfoDto storageItem :thirdList) {
                    if(secondItem.getOrgId().equals(storageItem.getOrgId().toString())){
                        storageList.add(storageItem);
                    }
                }
                secondItem.setStorageInfoList(storageList);
            }
            secondList.addAll(directlyList);
            oldItem.setChildList(secondList);
        }
        return oldList;

        /**
        List<SysUsedStorageListDto> usedStorages = null;
        SysStoreInfoEntity storeInfo = new SysStoreInfoEntity();
        if(StringUtils.isBlank(paramDto.getOrgId())){
            //直接返回销售中心
            storeInfo.setOrgType(Constants.OrgType.PARENT_OFFICE.getOrgCode());
            List<SysStoreInfoEntity> infoEntities = iSysStoreInfoDao.selectBySelective(storeInfo);
            storeInfo.setOrgType(Constants.OrgType.SUBMIT_CORE.getOrgCode());
            int count = iSysStoreInfoDao.selectBySelectiveCount(storeInfo);
            usedStorages = Copiers.beansToBeans(infoEntities, SysStoreInfoEntity.class, SysUsedStorageListDto.class);
            usedStorages.stream().forEach(item->{
                    item.setIsChild(count > 0 ? "1":"0");
            });
        }else{
            //判断类型，如果是销售总公司返回所有交付中心
            if(Constants.OrgType.PARENT_OFFICE.getOrgCode().equals(paramDto.getOrgType())){
                storeInfo.setOrgType(Constants.OrgType.SUBMIT_CORE.getOrgCode());
                List<SysStoreInfoEntity> infoEntities = iSysStoreInfoDao.selectBySelective(storeInfo);
                usedStorages = Copiers.beansToBeans(infoEntities, SysStoreInfoEntity.class, SysUsedStorageListDto.class);
                usedStorages.stream().forEach(item->{
                    //判断该交付中心下面是否有仓库
                    SysCarUsedStorageEntity storageEntity = new SysCarUsedStorageEntity();
                    storageEntity.setOrgId(Long.valueOf(item.getOrgId()));
                    int count = iSysCarUsedStorageDao.selectBySelectiveCount(storageEntity);
                    item.setIsChild(count > 0 ? "1":"0");
                });
            }else if(Constants.OrgType.SUBMIT_CORE.getOrgCode().equals(paramDto.getOrgType())){
                //如果是交付中心就查询出下面所有的仓库
                SysCarUsedStorageEntity usedStorageEntity = new SysCarUsedStorageEntity();
                usedStorageEntity.setOrgId(Long.valueOf(paramDto.getOrgId()));
                List<SysCarUsedStorageEntity> storageEntities = iSysCarUsedStorageDao.selectBySelective(usedStorageEntity);
                usedStorages = Copiers.beansToBeans(storageEntities, SysCarUsedStorageEntity.class, SysUsedStorageListDto.class);
            }
        }
        return usedStorages;
        **/
    }

    @Override
    public List<SysUsedStorageSelectListDto> findSelectList(Long storeId) {
        SysCarUsedStorageEntity usedStorageEntity = new SysCarUsedStorageEntity();
        usedStorageEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
        usedStorageEntity.setIsDelete(Constants.IsDelete.NO.value());
        usedStorageEntity.setOrgId(storeId);
        List<SysCarUsedStorageEntity> storageEntities = iSysCarUsedStorageDao.selectBySelective(usedStorageEntity);
        List<SysUsedStorageSelectListDto> usedStorages = Copiers.beansToBeans(storageEntities, SysCarUsedStorageEntity.class, SysUsedStorageSelectListDto.class);
        return usedStorages;
    }

    @Override
    public void addUsedStorage(SysUsedStorageInfoDto usedStorageInfoDto) {
            SysCarUsedStorageEntity carUsedStorageEntity =
                    Copiers.beanToBean(usedStorageInfoDto, SysUsedStorageInfoDto.class, SysCarUsedStorageEntity.class);
            carUsedStorageEntity.setStorageCode(generatenNumber());
            carUsedStorageEntity.setIsManualCreation(Constants.IS_MANUAL_CREATION.YES.value());
            carUsedStorageEntity.generatePk();
            carUsedStorageEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            carUsedStorageEntity.setUpdatedBy(carUsedStorageEntity.getCreatedBy());
            if(StringUtils.isNotBlank(usedStorageInfoDto.getManagerPhone())){
                carUsedStorageEntity.setManagerPhone(AesUtils.encryptHex(usedStorageInfoDto.getManagerPhone(), ucmpAesConfig.getSecret()));
            }
            iSysCarUsedStorageDao.insertSelective(carUsedStorageEntity);

    }
    //生成仓储编码
    private  String generatenNumber(){
        Long codeIncr = redissonCache.incrBy("storage:no", 1L);
        String code = String.format("%04d", codeIncr);
        if (codeIncr == 1){
            redissonCache.expire("storage:no", TimeUnit.HOURS,24L);
        }
        String campaignCode = new SimpleDateFormat("yyyyMMdd").format(new Date()).concat(code);
        campaignCode = "UC" + campaignCode;
        return  campaignCode;
    }

    @Override
    public void updateUsedStorage(SysUsedStorageInfoDto usedStorageInfoDto) {
//        SysCarUsedStorageEntity load = iSysCarUsedStorageDao.load(new SysCarUsedStoragePk(usedStorageInfoDto.getStorageId()));
//        SysCarUsedStorageEntity carUsedStorageEntity = new SysCarUsedStorageEntity();
//        carUsedStorageEntity.setStorageCode(usedStorageInfoDto.getStorageCode());
//        int count = iSysCarUsedStorageDao.selectBySelectiveCount(carUsedStorageEntity);
//        if (!load.getStorageCode().equals(usedStorageInfoDto.getStorageCode())&& count > 0) {
//            throw new IllegalParameterException("仓库编码为:" + usedStorageInfoDto.getStorageCode() + "的仓储点已存在");
//        } else {
//            carUsedStorageEntity =
//                    Copiers.beanToBean(usedStorageInfoDto, SysUsedStorageInfoDto.class, SysCarUsedStorageEntity.class);
//            carUsedStorageEntity.setUpdatedBy(carUsedStorageEntity.getCreatedBy());
//            carUsedStorageEntity.setUpdatedDate(new Date());
//            if(StringUtils.isNotBlank(usedStorageInfoDto.getManagerPhone())){
//                carUsedStorageEntity.setManagerPhone(AesUtils.encryptHex(usedStorageInfoDto.getManagerPhone(), ucmpAesConfig.getSecret()));
//            }
//            iSysCarUsedStorageDao.updateSelective(carUsedStorageEntity);
//        }
        SysCarUsedStorageEntity carUsedStorageEntity =
                Copiers.beanToBean(usedStorageInfoDto, SysUsedStorageInfoDto.class, SysCarUsedStorageEntity.class);
        carUsedStorageEntity.setUpdatedBy(carUsedStorageEntity.getCreatedBy());
        carUsedStorageEntity.setUpdatedDate(new Date());
        if(StringUtils.isNotBlank(usedStorageInfoDto.getManagerPhone())){
            carUsedStorageEntity.setManagerPhone(AesUtils.encryptHex(usedStorageInfoDto.getManagerPhone(), ucmpAesConfig.getSecret()));
        }
        iSysCarUsedStorageDao.updateSelective(carUsedStorageEntity);

    }

    @Override
    public SysUsedStorageInfoDto getUsedStorageInfo(Long storageId) {
        SysCarUsedStorageEntity load = iSysCarUsedStorageDao.load(new SysCarUsedStoragePk(storageId));
        try {
            //手机号解密再返回
            if(StringUtils.isNotBlank(load.getManagerPhone())){
                load.setManagerPhone(AesUtils.decryptHex(load.getManagerPhone(), ucmpAesConfig.getSecret()));
            }
        }catch (Exception e){
            LOGGER.error("手机号解密失败=========",e);
        }
        return Copiers.beanToBean(load,SysCarUsedStorageEntity.class,SysUsedStorageInfoDto.class);
    }
    @Transactional
    @Override
    public void synUsedStorage() {
        //查询所有交付中心门店数据
        SysStoreInfoEntity storeInfoEntity = new SysStoreInfoEntity();
        storeInfoEntity.setOrgType(Constants.OrgType.SUBMIT_CORE.getOrgCode());
        storeInfoEntity.setSyncIsEnable(Constants.IsEnable.ENABLE.value());
        List<SysStoreInfoEntity> sysStoreInfoEntityList = iSysStoreInfoDao.selectBySelective(storeInfoEntity);

        //查询所有根据交付中心创建的仓储店数据
        SysCarUsedStorageEntity storageEntity = new SysCarUsedStorageEntity();
        storageEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
        storageEntity.setIsDelete(Constants.IsDelete.NO.value());
        storageEntity.setIsManualCreation("01");
        List<SysCarUsedStorageEntity> usedStorageEntities = iSysCarUsedStorageDao.selectBySelective(storageEntity);
        Map<String, SysCarUsedStorageEntity> usedStorageMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(usedStorageEntities)){
            usedStorageMap = usedStorageEntities.stream().collect(Collectors.toMap(p -> p.getOrgId().toString(), p -> p));
        }
        List<SysCarUsedStorageEntity> insertUsedStorage = new LinkedList<>();
        List<SysCarUsedStorageEntity> updateUsedStorage = new LinkedList<>();
        Long userBy= AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
        SysCarUsedStorageEntity usedStorageEntity;
        for (SysStoreInfoEntity item : sysStoreInfoEntityList) {
            if(usedStorageMap.containsKey(item.getOrgId())){
                 //存在的仓储点更新
                 usedStorageEntity = usedStorageMap.get(item.getOrgCode());
                 usedStorageEntity.setUpdatedBy(userBy);
                 usedStorageEntity.setUpdatedDate(new Date());
                 usedStorageEntity.setStorageName(item.getOrgName().endsWith("仓库")?item.getOrgName():item.getOrgName()+"仓库");
                 usedStorageEntity.setStorageAddress(item.getLinkAddr());
                 usedStorageEntity.setCity(item.getCity());
                 usedStorageEntity.setCityId(item.getCityId());
                 usedStorageEntity.setProvince(item.getProvince());
                 usedStorageEntity.setProvinceId(item.getProvinceId());
                 updateUsedStorage.add(usedStorageEntity);
             }else{
                 usedStorageEntity = new SysCarUsedStorageEntity();
                 usedStorageEntity.generatePk();
                 usedStorageEntity.setStorageName(item.getOrgName().endsWith("仓库")?item.getOrgName():item.getOrgName()+"仓库");
                 usedStorageEntity.setStorageAddress(item.getLinkAddr());
                 usedStorageEntity.setStorageCode(generatenNumber());
                 usedStorageEntity.setCity(item.getCity());
                 usedStorageEntity.setCityId(item.getCityId());
                 usedStorageEntity.setProvince(item.getProvince());
                 usedStorageEntity.setProvinceId(item.getProvinceId());
                 usedStorageEntity.setOrgId(Long.valueOf(item.getOrgId()));
                 usedStorageEntity.setIsManualCreation(Constants.IS_MANUAL_CREATION.NO.value());
                 usedStorageEntity.setCreatedBy(userBy);
                 usedStorageEntity.setCreatedDate(new Date());
                 usedStorageEntity.setUpdatedBy(userBy);
                 usedStorageEntity.setUpdatedDate(new Date());
                 usedStorageEntity.setDefaultMoveAddress(Constants.DEFAULT_MOVE_ADDRESS.YES.value());
                 usedStorageEntity.setIsDelete(Constants.IsDelete.NO.value());
                 usedStorageEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
                 insertUsedStorage.add(usedStorageEntity);
             }
        }
        if(CollectionUtils.isNotEmpty(updateUsedStorage)){
            iSysCarUsedStorageDao.batchUpdate(updateUsedStorage);
        }
        if(CollectionUtils.isNotEmpty(insertUsedStorage)){
            iSysCarUsedStorageDao.batchInsert(insertUsedStorage);
        }

    }

    public static  void  main(String[] args){
        String name ="xx中心";
        System.out.println(name.endsWith("仓库")?name:name+"仓库");
    }

	@Override
	public List<UsedStorageInfoDto> queryList(String usedstorageName) {
		return this.iSysCarUsedStorageDao.queryList(usedstorageName);
	}
}
