package com.exp.ucmp.mall.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import com.exp.ucmp.carDealer.dto.JobHandlerResult;
import com.exp.ucmp.clues.dto.PsiRetentionCluesParamDto;
import com.exp.ucmp.clues.dto.SalesConsultantDto;
import com.exp.ucmp.clues.dto.SalesConsultantParamDto;
import com.exp.ucmp.clues.dto.UsedCarSupervisorDto;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IPsiOrderInfoDao;
import com.exp.ucmp.dao.ISysStoreInfoDao;
import com.exp.ucmp.entity.PsiOrderInfoEntity;
import com.exp.ucmp.entity.PsiRetentionCluesEntity;
import com.exp.ucmp.entity.PsiSalesCustomerEntity;
import com.exp.ucmp.mall.dao.PsiRetentionDao;
import com.exp.ucmp.mall.service.BaseCluesService;
import com.exp.ucmp.mall.service.CluesJobService;
import com.exp.ucmp.util.AesUtils;
import jodd.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * <p>@ClassName: CluesService</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/24 14:15<p>
 */
@Service
public class CluesJobServiceImpl extends BaseCluesService implements CluesJobService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CluesJobServiceImpl.class);

    @Autowired
    private PsiRetentionDao psiRetentionDao;

    @Autowired
    private IPsiOrderInfoDao iPsiOrderInfoDao;

    @Autowired
    private UcmpAesConfig ucmpAesConfig;

    @Autowired
    private ISysStoreInfoDao iSysStoreInfoDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JobHandlerResult clues() {
        //修改人员或门店官二资质为“禁用”时，会重新流转到线索池
        //人员当前状态禁用或人员转店或人员已删除，客户全部流转到门店线索池进行重新分配
        //查询线索所有的跟进人
        List<PsiSalesCustomerEntity> allFollowPersonList = psiRetentionDao.selectAllPerson("01", "01", null);
        if (CollectionUtil.isEmpty(allFollowPersonList)) {
            LOGGER.info("销售人员无对应客户！");
            return null;
        }
        Map<Long, Long> allFollowPerson = allFollowPersonList.stream().collect(Collectors.toMap(PsiSalesCustomerEntity::getPartyId, PsiSalesCustomerEntity::getStoreId));
        //需要重新流转的人员
        List<Long> againAllocation = new ArrayList<>(allFollowPerson.keySet());
        //只查人员状态为“启用“，并官二资质为”启用“
        SalesConsultantParamDto paramDto = new SalesConsultantParamDto();
        paramDto.setPartyIdList(new ArrayList<>(allFollowPerson.keySet()));
        paramDto.setStaffStatus("01");
        paramDto.setQualificationStatus("01");
        List<SalesConsultantDto> salesConsultantDtos = psiRetentionDao.salesConsultantList(paramDto);
        List<Long> allPerson = salesConsultantDtos.stream().map(SalesConsultantDto::getPartyId).collect(Collectors.toList());
        List<String> allStorePerson = salesConsultantDtos.stream().map(item -> item.getStoreId() + "_" + item.getPartyId()).collect(Collectors.toList());
        //人员已删除或禁用
        againAllocation.removeAll(allPerson);
        //人员转店
        for (Long partyId : allFollowPerson.keySet()) {
            Long storeId = allFollowPerson.get(partyId);
            String key = String.format("%s_%s", storeId, partyId);
            if (!allStorePerson.contains(key)) {
                againAllocation.add(partyId);
            }
        }
        if (CollectionUtil.isEmpty(againAllocation)) {
            LOGGER.info("未有需要重新流转的线索");
            return null;
        }
        psiRetentionDao.redistributionCustomerId(againAllocation);
        psiRetentionDao.redistributionClues(againAllocation);
        psiRetentionDao.redistributionOrder(againAllocation);
        LOGGER.info("重新流转到分配池-->" + againAllocation);
        return null;
    }

//    @Override
//    public JobHandlerResult clues() {
//        List<Long> allFollowPerson = psiRetentionDao.selectAllPerson();
//        if (CollectionUtil.isEmpty(allFollowPerson)) {
//            LOGGER.info("暂无待跟进、跟进中的线索");
//            return null;
//        }
//        SalesConsultantParamDto paramDto = new SalesConsultantParamDto();
//        paramDto.setPartyIdList(allFollowPerson);
//        paramDto.setStaffStatus("01");
//        List<SalesConsultantDto> salesConsultantDtos = psiRetentionDao.salesConsultantList(paramDto);
//        List<Long> allPerson = salesConsultantDtos.stream().map(SalesConsultantDto::getPartyId).collect(Collectors.toList());
//        allFollowPerson.removeAll(allPerson);
//        if (CollectionUtil.isEmpty(allFollowPerson)) {
//            LOGGER.info("未有离职人员");
//            return null;
//        }
//        psiRetentionDao.redistribution(allFollowPerson);
//        LOGGER.info("重新待分配-->" + allFollowPerson);
//        return null;
//    }

    /**
     * 线索15天未分配或15天无跟进记录或订单转交付前15天未变状态，发送提醒给店长和业务；
     *
     * @return
     */
    @Override
    public JobHandlerResult remind() throws Exception {
        //所有的二手车主管
        List<UsedCarSupervisorDto> allUsedCarSupervisor = psiRetentionDao.queryUsedCarSupervisor(null);
        store(allUsedCarSupervisor);
        person(allUsedCarSupervisor);
        follow(allUsedCarSupervisor);
        order(allUsedCarSupervisor);
        return null;
    }

    /**
     * 线索15天未分配店
     *
     * @throws Exception
     */
    @Override
    public JobHandlerResult store(List<UsedCarSupervisorDto> allUsedCarSupervisor) throws Exception {
        JobHandlerResult jobHandlerResult = new JobHandlerResult();
        if (CollectionUtil.isEmpty(allUsedCarSupervisor)) {
            jobHandlerResult.addMessasge("暂无二手车主管");
            return jobHandlerResult;
        }
        Map<String, List<UsedCarSupervisorDto>> usedCarSupervisorMap = allUsedCarSupervisor.stream().collect(Collectors.groupingBy(UsedCarSupervisorDto::getStaffIphone));
//        Map<String, Long> phonePartyMap = allUsedCarSupervisor.stream().collect(Collectors.toMap(UsedCarSupervisorDto::getStaffIphone, UsedCarSupervisorDto::getPartyId));
        //查询线索15天未分配店
        PsiRetentionCluesParamDto cluesParamDto = new PsiRetentionCluesParamDto();
        cluesParamDto.setFollowStatusList(
                Arrays.asList(Constants.FollowStatus.NOT_FOLLOWED_UP.getCode(), Constants.FollowStatus.FOLLOWED_UP.getCode()));
        cluesParamDto.setIsEmptyFollowStore("01");
        cluesParamDto.setUpdatedDate(getTime());
        List<PsiRetentionCluesEntity> emptyStoreList = psiRetentionDao.selectByCluesList(cluesParamDto);
        //发送短信(二手车主管)
        if (CollectionUtil.isEmpty(emptyStoreList)) {
            LOGGER.info("暂无超过线索15天未分配到店的");
            jobHandlerResult.addMessasge("暂无超过线索15天未分配到店的");
            return jobHandlerResult;
        }
//        Set<String> customerNameList = emptyStoreList.stream().map(PsiRetentionCluesEntity::getCustomerName).collect(Collectors.toSet());
        for (String staffIphone : usedCarSupervisorMap.keySet()) {
            if (StringUtils.isEmpty(staffIphone)) {
                continue;
            }
            jobHandlerResult.addMessasge("二手车主管："+ staffIphone+",有"+emptyStoreList.size()+"条线索15天未分配店");
            for (PsiRetentionCluesEntity cluesEntity : emptyStoreList) {
                sendSms(Constants.sendMessage.sendMessageTwentieth.value(), staffIphone, new String[]{
                    cluesEntity.getCustomerName(),
                        cluesEntity.getDeliveryPlace()},"03",cluesEntity.getCluesId());
            }
            //发送短信(二手车主管)
//            sendSms(Constants.templateId.sendMessageTwentieth.value(), staffIphone, new String[]{
//                    String.valueOf(emptyStoreList.size()),
//                    StringUtils.join(customerNameList, "、")});
        }
        return jobHandlerResult;
    }

    /**
     * 线索15天未分配人
     *
     * @throws Exception
     */
    public JobHandlerResult person(List<UsedCarSupervisorDto> allUsedCarSupervisor) throws Exception {
        JobHandlerResult jobHandlerResult = new JobHandlerResult();

        //查询线索15天未分配人
        PsiRetentionCluesParamDto cluesParamDto = new PsiRetentionCluesParamDto();
        cluesParamDto.setFollowStatusList(
                Arrays.asList(Constants.FollowStatus.NOT_FOLLOWED_UP.getCode(), Constants.FollowStatus.FOLLOWED_UP.getCode()));
        cluesParamDto.setIsEmptyFollowStore("00");
        cluesParamDto.setIsEmptyFollowPerson("01");
        cluesParamDto.setUpdatedDate(getTime());
        List<PsiRetentionCluesEntity> emptyPersonList = psiRetentionDao.selectByCluesList(cluesParamDto);
        return sendReminder(allUsedCarSupervisor, emptyPersonList,jobHandlerResult);
    }

    /**
     * 线索15天未更新跟进
     *
     * @throws Exception
     */
    public JobHandlerResult follow(List<UsedCarSupervisorDto> allUsedCarSupervisor) throws Exception {
        JobHandlerResult jobHandlerResult =  new JobHandlerResult();
        //查询线索15天未分配人
        PsiRetentionCluesParamDto cluesParamDto = new PsiRetentionCluesParamDto();
        cluesParamDto.setFollowStatusList(
                Arrays.asList(Constants.FollowStatus.NOT_FOLLOWED_UP.getCode(), Constants.FollowStatus.FOLLOWED_UP.getCode()));
        cluesParamDto.setIsEmptyFollowStore("00");
        cluesParamDto.setIsEmptyFollowPerson("00");
        cluesParamDto.setLastFollowTime(getTime());
        List<PsiRetentionCluesEntity> notFollowList = psiRetentionDao.selectByCluesList(cluesParamDto);
        if (CollectionUtil.isEmpty(notFollowList)) {
            LOGGER.info("暂无线索15天未更新跟进");
            jobHandlerResult.addMessasge("暂无线索15天未更新跟进");
            return jobHandlerResult;
        }
        Map<Long, Long> storePersonMap = notFollowList.stream().collect(Collectors.toMap(PsiRetentionCluesEntity::getFollowStore, PsiRetentionCluesEntity::getFollowPerson));
        Set<Long> storeIds = notFollowList.stream().map(PsiRetentionCluesEntity::getFollowStore).collect(Collectors.toSet());
        //获取店长
        SalesConsultantParamDto paramDto = new SalesConsultantParamDto();
        paramDto.setRole(Constants.slfRole.SH.value());
        paramDto.setStoreIdList(new ArrayList<>(storeIds));
        List<SalesConsultantDto> shInfoList = psiRetentionDao.salesConsultantList(paramDto);
        Map<Long, SalesConsultantDto> storeShMap = shInfoList.stream().collect(Collectors.toMap(SalesConsultantDto::getStoreId, Function.identity()));
        //获取MO
        SalesConsultantParamDto moParamDto = new SalesConsultantParamDto();
        moParamDto.setRoleList(Constants.slfRole.getAllMo());
        moParamDto.setStoreIdList(new ArrayList<>(storeIds));
        List<SalesConsultantDto> moInfoList = psiRetentionDao.salesConsultantList(moParamDto);
        Map<Long, SalesConsultantDto> storeMoMap = moInfoList.stream().collect(Collectors.groupingBy(SalesConsultantDto::getStoreId, Collectors.collectingAndThen(
                Collectors.reducing((t1, t2) -> t1.getStoreId() > t2.getStoreId() ? t1 : t2),
                Optional::get)));

        //获取负责人
        Map<Long, SalesConsultantDto> storeMcMap = new HashMap<>();
        Set<Long> parsonList = notFollowList.stream().filter(item -> Objects.nonNull(item.getFollowPerson())).map(PsiRetentionCluesEntity::getFollowPerson).collect(Collectors.toSet());
        if(parsonList.size() > 0){
            SalesConsultantParamDto mcParamDto = new SalesConsultantParamDto();
            mcParamDto.setPartyIdList(new ArrayList<>(parsonList));
            List<SalesConsultantDto> mcInfoList = psiRetentionDao.salesConsultantList(mcParamDto);
            storeMcMap = mcInfoList.stream().collect(Collectors.toMap(SalesConsultantDto::getPartyId, Function.identity()));
        }
        //发送短信(二手车主管)
        //所有的二手车主管
        if(CollectionUtil.isNotEmpty(allUsedCarSupervisor)){
            Map<String, List<Long>> phoneStoreMap = allUsedCarSupervisor.stream().collect(Collectors.groupingBy(UsedCarSupervisorDto::getStaffIphone, Collectors.mapping(UsedCarSupervisorDto::getStoreId, Collectors.toList())));
            for (String staffIphone : phoneStoreMap.keySet()) {
                //二手车主管授权的门店
                List<Long> storeIdList = phoneStoreMap.get(staffIphone);
                //获取该主管未分配到人门店
                List<PsiRetentionCluesEntity> cluesEntities = notFollowList.stream().filter(item -> storeIdList.contains(item.getFollowStore())).collect(Collectors.toList());
                if (CollectionUtil.isEmpty(cluesEntities)) {
                    continue;
                }
                jobHandlerResult.addMessasge("二手车主管："+ AesUtils.decryptHex(staffIphone, ucmpAesConfig.getSecret())+"有"+cluesEntities.size()+"条线索长时间未跟进");
                for (PsiRetentionCluesEntity cluesEntity : cluesEntities) {
                    String head = "";
                    String storeName = "";
                    SalesConsultantDto moParty = storeMoMap.get(cluesEntity.getFollowStore());
                    if (Objects.isNull(moParty) && Objects.nonNull(cluesEntity.getFollowPerson())) {
                        SalesConsultantDto mcInfo = storeMcMap.get(cluesEntity.getFollowPerson());
                        head = mcInfo.getStaffName();
                        storeName = moParty.getStoreName();
                    } else {
                        head = moParty.getStaffName();
                        storeName = moParty.getStoreName();
                    }
                    sendSms(Constants.sendMessage.sendMessageEighteenth.value(),staffIphone, new String[]{
                            storeName, head, cluesEntity.getCustomerName()},"03",cluesEntity.getCluesId());
                }
                //获取所有未分配的客户名称
//                List<String> customerNameList = cluesEntities.stream().map(PsiRetentionCluesEntity::getCustomerName).collect(Collectors.toList());
                //发送短信(二手车主管)
//                sendSms(Constants.sendMessage.sendMessageEighteenth.value(),staffIphone, new String[]{
//                        String.valueOf(cluesEntities.size()),
//                        StringUtils.join(customerNameList, ",")});
            }
        }


        for (PsiRetentionCluesEntity cluesEntity : notFollowList) {
            if(Objects.isNull(cluesEntity.getFollowStore())){
                continue;
            }
            SalesConsultantDto storeSh = storeShMap.get(cluesEntity.getFollowStore());
            String head = "";
            String storeName = "";
            SalesConsultantDto moParty = storeMoMap.get(cluesEntity.getFollowStore());
            if (Objects.isNull(moParty) && Objects.nonNull(cluesEntity.getFollowPerson())) {
                SalesConsultantDto mcInfo = storeMcMap.get(cluesEntity.getFollowPerson());
                head = mcInfo.getStaffName();
                storeName = moParty.getStoreName();
            } else {
                head = moParty.getStaffName();
                storeName = moParty.getStoreName();
            }
            jobHandlerResult.addMessasge("人员编号："+  storeSh.getStaffCode()+",线索ID:"+cluesEntity.getCluesId()+"线索长时间未跟进");
            List<String> params = new ArrayList<>();
            params.add(storeName);
            params.add(head);
            params.add(cluesEntity.getCustomerName());
            giveMessage(Constants.templateId.templateTitleTwelve.value(), "UCMP", 1, storeSh.getStaffCode(), 0, null, params);
        }
        return jobHandlerResult;
    }

    /**
     * 订单长时间停留状态（15天）
     *
     * @throws Exception
     */
    public JobHandlerResult order(List<UsedCarSupervisorDto> allUsedCarSupervisor) throws Exception {
        JobHandlerResult jobHandlerResult = new JobHandlerResult();
        PsiOrderInfoEntity psiOrderInfoEntity = new PsiOrderInfoEntity();
        psiOrderInfoEntity.setIsDelete("00");
        psiOrderInfoEntity.setIsEnable("01");
        psiOrderInfoEntity.setUpdatedDate(getTime());
        List<PsiOrderInfoEntity> orderInfoEntityList = psiRetentionDao.listByOrder(psiOrderInfoEntity);
        if (CollectionUtil.isEmpty(orderInfoEntityList)) {
            LOGGER.info("暂无长时间停留的订单");
            jobHandlerResult.addMessasge("暂无长时间停留的订单");
            return jobHandlerResult;
        }
        //当门店或人员 官二资质关闭时，该名下的客户会流转到线索池里进行重新分配，门店或出行顾问会为空

        Set<Long> storeIds = orderInfoEntityList.stream().map(PsiOrderInfoEntity::getSalesStore).collect(Collectors.toSet());
        //获取MO
        SalesConsultantParamDto moParamDto = new SalesConsultantParamDto();
        moParamDto.setRoleList(Constants.slfRole.getAllMo());
        moParamDto.setStoreIdList(new ArrayList<>(storeIds));
        List<SalesConsultantDto> moInfoList = psiRetentionDao.salesConsultantList(moParamDto);
        Map<Long, SalesConsultantDto> storeMoMap = new HashMap<>();
        if(CollectionUtil.isNotEmpty(moInfoList)){
            storeMoMap = moInfoList.stream().collect(Collectors.groupingBy(SalesConsultantDto::getStoreId, Collectors.collectingAndThen(
                    Collectors.reducing((t1, t2) -> t1.getStoreId() > t2.getStoreId() ? t1 : t2),
                    Optional::get)));
        }
        //获取负责人
        Map<Long, SalesConsultantDto> storeMcMap = new HashMap<>();
        Set<Long> parsonList = orderInfoEntityList.stream().filter(item -> Objects.nonNull(item.getFollowPerson())).map(PsiOrderInfoEntity::getFollowPerson).collect(Collectors.toSet());
        if(parsonList.size() > 0){
            SalesConsultantParamDto mcParamDto = new SalesConsultantParamDto();
            mcParamDto.setPartyIdList(new ArrayList<>(parsonList));
            List<SalesConsultantDto> mcInfoList = psiRetentionDao.salesConsultantList(mcParamDto);
            storeMcMap = mcInfoList.stream().collect(Collectors.toMap(SalesConsultantDto::getPartyId, Function.identity()));
        }
        if(CollectionUtil.isNotEmpty(allUsedCarSupervisor)){
            //所有的二手车主管
            Map<String, List<Long>> phoneStoreMap = allUsedCarSupervisor.stream().collect(Collectors.groupingBy(UsedCarSupervisorDto::getStaffIphone, Collectors.mapping(UsedCarSupervisorDto::getStoreId, Collectors.toList())));
            for (String staffIphone : phoneStoreMap.keySet()) {
                //二手车主管授权的门店
                List<Long> storeIdList = phoneStoreMap.get(staffIphone);
                //获取该二手车主管订单
                List<PsiOrderInfoEntity> orderInfoEntities = orderInfoEntityList.stream().filter(item -> storeIdList.contains(item.getSalesStore())).collect(Collectors.toList());
                if (CollectionUtil.isEmpty(orderInfoEntities)) {
                    continue;
                }
                jobHandlerResult.addMessasge("二手车主管："+ AesUtils.decryptHex(staffIphone, ucmpAesConfig.getSecret())+"有"+orderInfoEntities.size()+"条订单长时间未跟进");
                for (PsiOrderInfoEntity orderInfoEntity : orderInfoEntities) {
                    String head = "";
                    String storeName = "";
                    SalesConsultantDto moParty = storeMoMap.get(orderInfoEntity.getSalesStore());
                    if (Objects.isNull(moParty) && Objects.nonNull(orderInfoEntity.getFollowPerson())) {
                        SalesConsultantDto mcInfo = storeMcMap.get(orderInfoEntity.getFollowPerson());
                        head = mcInfo.getStaffName();
                        storeName = moParty.getStoreName();
                    } else {
                        head = moParty.getStaffName();
                        storeName = moParty.getStoreName();
                    }
                    //发送短信(二手车主管)
                    sendSms(Constants.sendMessage.sendMessageSeventeenth.value(),staffIphone, new String[]{
                            orderInfoEntity.getOrderNo(),storeName,head},"03",orderInfoEntity.getOrderInfoId());
                }
            }
        }

        //企微提醒（店长）
        //企微提醒（店长）一条一条提醒
        if (storeIds.size() == 0) {
            LOGGER.info("订单未分配到店");
            jobHandlerResult.addMessasge("订单未分配到店");
            return jobHandlerResult;
        }
        //获取店长
        SalesConsultantParamDto paramDto = new SalesConsultantParamDto();
        paramDto.setRole(Constants.slfRole.SH.value());
        paramDto.setStoreIdList(new ArrayList<>(storeIds));
        List<SalesConsultantDto> shInfoList = psiRetentionDao.salesConsultantList(paramDto);
        Map<Long, SalesConsultantDto> storeShMap = shInfoList.stream().collect(Collectors.toMap(SalesConsultantDto::getStoreId, Function.identity()));
        for (PsiOrderInfoEntity orderInfoEntity : orderInfoEntityList) {
            if(Objects.isNull(orderInfoEntity.getSalesStore())){
                continue;
            }
            SalesConsultantDto salesConsultantDto = storeShMap.get(orderInfoEntity.getSalesStore());
            if(Objects.isNull(salesConsultantDto)){
                continue;
            }
            String head = "";
            String storeName = "";
            SalesConsultantDto moParty = storeMoMap.get(orderInfoEntity.getSalesStore());
            if (Objects.isNull(moParty) && Objects.nonNull(orderInfoEntity.getFollowPerson())) {
                SalesConsultantDto mcInfo = storeMcMap.get(orderInfoEntity.getFollowPerson());
                head = mcInfo.getStaffName();
                storeName = moParty.getStoreName();
            } else {
                head = moParty.getStaffName();
                storeName = moParty.getStoreName();
            }
            jobHandlerResult.addMessasge("人员编号："+  salesConsultantDto.getStaffCode()+",订单号:"+orderInfoEntity.getOrderNo()+"订单长时间未跟进");
            List<String> params = new ArrayList<>();
            params.add(orderInfoEntity.getOrderNo());
            params.add(salesConsultantDto.getStoreName());
            params.add(head);
            giveMessage(Constants.templateId.templateTitleThirteen.value(), "UCMP", 1, salesConsultantDto.getStaffCode(), 0, null, params);
        }
        return jobHandlerResult;
    }


    private JobHandlerResult sendReminder(List<UsedCarSupervisorDto> allUsedCarSupervisor, List<PsiRetentionCluesEntity> cluesEntityList,JobHandlerResult jobHandlerResult) throws Exception {
        if (CollectionUtil.isEmpty(cluesEntityList)) {
            LOGGER.info("线索15天未分配人");
            jobHandlerResult.addMessasge("线索15天未分配人");
        }
        //发送短信(二手车主管)
        if (CollectionUtil.isEmpty(allUsedCarSupervisor)) {
            Map<String, List<Long>> phoneStoreMap = allUsedCarSupervisor.stream().collect(Collectors.groupingBy(UsedCarSupervisorDto::getStaffIphone, Collectors.mapping(UsedCarSupervisorDto::getStoreId, Collectors.toList())));

            for (String staffIphone : phoneStoreMap.keySet()) {
                //二手车主管授权的门店
                List<Long> storeIdList = phoneStoreMap.get(staffIphone);
                //获取该主管未分配到人门店
                List<PsiRetentionCluesEntity> cluesEntities = cluesEntityList.stream().filter(item -> storeIdList.contains(item.getFollowStore())).collect(Collectors.toList());
                if (CollectionUtil.isEmpty(cluesEntities)) {
                    continue;
                }
                jobHandlerResult.addMessasge("二手车主管："+ staffIphone +"有"+cluesEntities.size()+"条线索15天未分配人");
                for (PsiRetentionCluesEntity cluesEntity : cluesEntities) {
                    sendSms(Constants.sendMessage.sendMessageTwentieth.value(), staffIphone, new String[]{
                            cluesEntity.getCustomerName(),
                            cluesEntity.getDeliveryPlace()}, "03", cluesEntity.getCluesId());
                }
//            //获取所有未分配的客户名称
//            List<String> customerNameList = cluesEntities.stream().map(PsiRetentionCluesEntity::getCustomerName).collect(Collectors.toList());
//            //发送短信(二手车主管)
//                sendSms(Constants.sendMessage.sendMessageTwentieth.value(),staffIphone, new String[]{
//                        String.valueOf(cluesEntities.size()),
//                        StringUtils.join(customerNameList, "、")});
            }
        }
        //企微提醒（店长）
        Map<Long, List<PsiRetentionCluesEntity>> storeCluesList = cluesEntityList.stream().collect(Collectors.groupingBy(PsiRetentionCluesEntity::getFollowStore));
        SalesConsultantParamDto paramDto = new SalesConsultantParamDto();
        paramDto.setRole(Constants.slfRole.SH.value());
        paramDto.setStoreIdList(new ArrayList<>(storeCluesList.keySet()));
        List<SalesConsultantDto> salesConsultantDtos = psiRetentionDao.salesConsultantList(paramDto);
        Map<Long, SalesConsultantDto> storeShMap = salesConsultantDtos.stream().collect(Collectors.toMap(SalesConsultantDto::getStoreId, Function.identity()));
        for (PsiRetentionCluesEntity psiRetentionCluesEntity : cluesEntityList) {
            SalesConsultantDto salesConsultantDto = storeShMap.get(psiRetentionCluesEntity.getFollowStore());
            if(Objects.isNull(salesConsultantDto)){
                continue;
            }
            jobHandlerResult.addMessasge("人员编号："+  salesConsultantDto.getStaffCode()+",线索ID:"+psiRetentionCluesEntity.getCluesId()+"线索15天未分配人");
            List<String> params = new ArrayList<>();
            params.add(String.valueOf(storeCluesList.size()));
            params.add(psiRetentionCluesEntity.getCustomerName());
            giveMessage(Constants.templateId.templateTitleEleven.value(), "UCMP", 1, salesConsultantDto.getStaffCode(), 0, null, params);

        }
        return jobHandlerResult;
    }


    public Date getTime() {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, -15);//指定的日期上减去15天
        Date date = calendar.getTime();
        return date;
    }
}
