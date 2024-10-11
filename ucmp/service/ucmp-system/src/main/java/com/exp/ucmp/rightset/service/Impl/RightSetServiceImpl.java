package com.exp.ucmp.rightset.service.Impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.egrid.cache.redisson.cache.RedissonCache;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.ISysRightActivitiesDao;
import com.exp.ucmp.dao.ISysRightActivitiesDetailsDao;
import com.exp.ucmp.dao.ISysRightActivitiesDistributeDetailsDao;
import com.exp.ucmp.entity.SysRightActivitiesDetailsEntity;
import com.exp.ucmp.entity.SysRightActivitiesDistributeDetailsEntity;
import com.exp.ucmp.entity.SysRightActivitiesEntity;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.SysRightActivitiesDetailsPk;
import com.exp.ucmp.right.service.RightService;
import com.exp.ucmp.rightset.dao.RightSetDao;
import com.exp.ucmp.rightset.dto.*;
import com.exp.ucmp.rightset.service.RightSetService;
import com.exp.ucmp.urc.dto.RightPackSaveDto;
import com.exp.ucmp.util.AesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author GeYiJiang
 * @Description: 权益设置实现类
 * @date 2022/11/18 14:11
 */
@Service
@Transactional
public class RightSetServiceImpl implements RightSetService {
    @Autowired
    UcmpAesConfig ucmpAesConfig;
    @Autowired
    RightSetDao rightSetDao;

    @Autowired
    ISysRightActivitiesDetailsDao detailsDao;

    @Autowired
    ISysRightActivitiesDao activitiesDao;

    @Autowired
    RightService rightService;

    @Autowired
    RedissonCache redissonCache;

    @Autowired
    ISysRightActivitiesDistributeDetailsDao distributeDetailsDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(RightSetServiceImpl.class);

    @Override
    public PageInfo<RightSetPageDto> selectRightSetList(RightSetQueryParamsDto paramsDto) {
        PageHelper.startPage(paramsDto.getPageNum(),paramsDto.getPageSize());
        List<RightSetPageDto> setPageDtos = rightSetDao.selectRightSetList(paramsDto);
        if (CollectionUtils.isNotEmpty(setPageDtos)){
            for (RightSetPageDto dto : setPageDtos) {
                SysRightActivitiesDistributeDetailsEntity detailsEntity = new SysRightActivitiesDistributeDetailsEntity();
                detailsEntity.setRightPackId(dto.getRightPackId());
                dto.setDistributeCount(distributeDetailsDao.selectBySelectiveCount(detailsEntity));
            }
        }
        return new PageInfo<>(setPageDtos);
    }
    @Override
    public PageInfo<RightActivitiesDetailsPageDto> findActivitiesDetailsPage(@Valid String rightId, @Valid Integer pageNum, @Valid Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        SysRightActivitiesDetailsEntity rightActivitiesDetailsEntity = new SysRightActivitiesDetailsEntity();
        rightActivitiesDetailsEntity.setRightId(Long.valueOf(rightId));
        rightActivitiesDetailsEntity.setIsDelete(Constants.IsDelete.NO.value());
        rightActivitiesDetailsEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
        List<SysRightActivitiesDetailsEntity> rightActivitiesDetailsEntities = detailsDao.selectBySelective(rightActivitiesDetailsEntity);
        List<RightActivitiesDetailsPageDto> pageDtos = Copiers.beansToBeans(rightActivitiesDetailsEntities, SysRightActivitiesDetailsEntity.class, RightActivitiesDetailsPageDto.class);
        PageInfo<RightActivitiesDetailsPageDto> detailsPageDtoPageInfo = new PageInfo<>(pageDtos);
        detailsPageDtoPageInfo.setPageNum(pageNum);
        detailsPageDtoPageInfo.setPageSize(pageSize);
        detailsPageDtoPageInfo.setTotal(detailsDao.selectBySelectiveCount(rightActivitiesDetailsEntity));
        return detailsPageDtoPageInfo;
    }

    @Override
    public PageInfo<DistributeDetailsPageDto> findDistributeDetailsPage(DistributeDetailsPageQueryDto detailsPageQueryDto) {
        PageHelper.startPage(detailsPageQueryDto.getPageNum(), detailsPageQueryDto.getPageSize());
        SysRightActivitiesDistributeDetailsEntity rightActivitiesDetailsEntity = new SysRightActivitiesDistributeDetailsEntity();
        rightActivitiesDetailsEntity.setRightPackId(Long.valueOf(detailsPageQueryDto.getRightPackId()));
        rightActivitiesDetailsEntity.setCampaignName(detailsPageQueryDto.getCampaignName());
        //手机号加密查询
        if(StringUtils.isNotBlank(detailsPageQueryDto.getCustomerIphone())){
            rightActivitiesDetailsEntity.setCustomerIphone(AesUtils.encryptHex(detailsPageQueryDto.getCustomerIphone(), ucmpAesConfig.getSecret()));
        }
        rightActivitiesDetailsEntity.setIsDelete(Constants.IsDelete.NO.value());
        rightActivitiesDetailsEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
        List<SysRightActivitiesDistributeDetailsEntity> rightActivitiesDetailsEntities = distributeDetailsDao.selectBySelective(rightActivitiesDetailsEntity);
        List<DistributeDetailsPageDto> pageDtos = Copiers.beansToBeans(rightActivitiesDetailsEntities, SysRightActivitiesDistributeDetailsEntity.class, DistributeDetailsPageDto.class);
        try {
            //手机号解密再返回
            for (DistributeDetailsPageDto item :pageDtos) {
                if(StringUtils.isNotBlank(item.getCustomerIphone())){
                    item.setCustomerIphone(AesUtils.decryptHex(item.getCustomerIphone(), ucmpAesConfig.getSecret()));
                }
            }
        }catch (Exception e){
            LOGGER.error("手机号解密失败=========",e);
        }

        return new PageInfo<>(pageDtos);
    }

    @Override
    public RightActivitiesDetailsPageDto findActivitiesDetails(String detailId) {
        SysRightActivitiesDetailsEntity  load = detailsDao.load(new SysRightActivitiesDetailsPk(Long.valueOf(detailId)));
        return Copiers.beanToBean(load,SysRightActivitiesDetailsEntity.class,RightActivitiesDetailsPageDto.class);
    }


    /**
     * 权益活动设置
     * @param setSaveDto 设置入参
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean savaRightSet(RightSetSaveDto setSaveDto) throws Exception {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        RightPackSaveDto rightPackSaveDto = new RightPackSaveDto();
        List<RightSetDetailSaveDto> detailList = setSaveDto.getDetailList();
        SysRightActivitiesEntity activities = new SysRightActivitiesEntity();
        BeanUtils.copyProperties(setSaveDto,activities);
        //拿到所有权益id
        if (CollectionUtils.isNotEmpty(detailList)){
            List<Long> rightIds = detailList.stream().map(RightSetDetailSaveDto::getId).collect(Collectors.toList());
            //权益包创建
            //是否限时 Integer 2 M 0不限、1限期、2区间时间
            rightPackSaveDto.setCampaignName(activities.getCampaignName());
            rightPackSaveDto.setTimeless(2);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = dateFormat.parse(setSaveDto.getStartDate().concat(" 00:00:00"));
            Date end = dateFormat.parse(setSaveDto.getEndDate().concat(" 23:59:59"));
            activities.setStartDate(start);
            activities.setEndDate(end);
            rightPackSaveDto.setEffectTime(dateFormat.format( start ) );
            rightPackSaveDto.setExpireTime(dateFormat.format(end ) );
            //类型 置换
            rightPackSaveDto.setType(11);
            rightPackSaveDto.setRightList(rightIds);
        }

        //权益包id
        Long rightPackId = rightService.rightPackSave(rightPackSaveDto);
        activities.setRightPackId(rightPackId);
//        String code = String.format("%04d", redissonCache.incrBy("campaignCode", 1L));
//        redissonCache.expire("campaignCode", TimeUnit.HOURS,24L);
//        String campaignCode = new SimpleDateFormat("yyyyMMdd").format(new Date()).concat(code);
//        campaignCode = "PB" + campaignCode;
//        activities.setCampaignCode(campaignCode);
//        String personName = rightSetDao.selectPersonName(user.getPartyId());
//        activities.setCreatedPersonName(user.getLoginName());
//        if (StringUtils.isNotBlank(personName)){
//            activities.setCreatedPersonName(personName);
//        }
        activities.setIsEnable(Constants.IsEnable.ENABLE.value());
        activities.setIsDelete(Constants.IsDelete.NO.value());
        activities.setCreatedBy(user.getPartyId());
        activities.setUpdatedBy(user.getPartyId());
        activities.setCreatedDate(new Date());
        activities.setUpdatedDate(new Date());
        Long rightId = RandomIDGennerator.get().generate();
        activities.setRightId(rightId);
        int insert = activitiesDao.insert(activities);


        if (CollectionUtils.isNotEmpty(detailList)){
            for (RightSetDetailSaveDto detailSaveDto : detailList) {
                SysRightActivitiesDetailsEntity detailsEntity = new SysRightActivitiesDetailsEntity();
                BeanUtils.copyProperties(detailSaveDto,detailsEntity);
                detailsEntity.generatePk();
                detailsEntity.setEquityId(detailSaveDto.getId());
                detailsEntity.setRightId(rightId);
                detailsEntity.setDetailsTrigger(detailSaveDto.getTrigger());
                detailsEntity.setRightName(detailSaveDto.getName());
                detailsEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
                detailsEntity.setIsDelete(Constants.IsDelete.NO.value());
                detailsEntity.setCreatedBy(user.getPartyId());
                detailsEntity.setUpdatedBy(user.getPartyId());
                detailsEntity.setCreatedDate(new Date());
                detailsEntity.setUpdatedDate(new Date());
                detailsDao.insert(detailsEntity);
            }
        }
        if (insert>0){
            return true;
        }
        return false;
    }

    @Override
    public Map<String, String> rightSetNeed() {
        Map<String,String> map = new HashMap<>();
        Long codeIncr = redissonCache.incrBy("campaign:code", 1L);
        String code = String.format("%04d", codeIncr);
        if (codeIncr == 1){
            redissonCache.expire("campaign:code", TimeUnit.HOURS,24L);
        }
        String campaignCode = new SimpleDateFormat("yyyyMMdd").format(new Date()).concat(code);
        campaignCode = "PB" + campaignCode;

        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        String createdPersonName = rightSetDao.selectPersonName(user.getPartyId());
        if (StringUtils.isNotBlank(createdPersonName)){
            map.put("createdPersonName",createdPersonName);
        }else {
            map.put("createdPersonName",user.getLoginName());
        }
        map.put("campaignCode",campaignCode);

        return map;
    }

    @Override
    public Boolean updateRightStatus(RightStatusUpdateDto updateDto) {
        SysRightActivitiesEntity activitiesEntity = new SysRightActivitiesEntity();
        activitiesEntity.setRightId(updateDto.getRightId());
        activitiesEntity.setIsEnable(Constants.IsEnable.DISABLE.value());
        int updateSelective = activitiesDao.updateSelective(activitiesEntity);
        if (updateSelective > 0){
            return true;
        }
        return false;
    }
    
	@Override
	public List<RightSetPageDto> findRightActivities(RightSetQueryParamsDto paramsDto) {
		paramsDto.setFlag(1);
		return rightSetDao.selectRightSetList(paramsDto);
	}

}
