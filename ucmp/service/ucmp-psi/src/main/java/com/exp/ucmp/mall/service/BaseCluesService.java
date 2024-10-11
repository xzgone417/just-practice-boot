package com.exp.ucmp.mall.service;

import com.egrid.cache.redisson.cache.RedissonCache;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carDealer.service.MessagePushService;
import com.exp.ucmp.clues.dto.SalesConsultantDto;
import com.exp.ucmp.clues.dto.SalesConsultantParamDto;
import com.exp.ucmp.clues.dto.UsedCarSupervisorDto;
import com.exp.ucmp.clues.dto.UsedCarSupervisorParamDto;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.consumer.ISystemConsumer;
import com.exp.ucmp.dao.IPsiOrderFollowRecordDao;
import com.exp.ucmp.dao.IPsiSalesCustomerDao;
import com.exp.ucmp.dao.IPsiSalesMessageRecordDao;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.exp.ucmp.entity.PsiOrderFollowRecordEntity;
import com.exp.ucmp.entity.PsiSalesCustomerEntity;
import com.exp.ucmp.entity.PsiSalesMessageRecordEntity;
import com.exp.ucmp.eos.dto.GiveMessageParamDto;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.huawei.dto.SmsParamsDto;
import com.exp.ucmp.mall.dao.PsiRetentionDao;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.tsp.dto.RegAndLoginDto;
import com.exp.ucmp.util.AesUtils;
import com.google.common.base.Objects;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * <p>@ClassName: BaseCluesServiceImpl</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/27 14:27<p>
 */
public class BaseCluesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseCluesService.class);

    @Autowired
    private ISystemConsumer iSystemConsumer;
    @Autowired
    private PsiRetentionDao psiRetentionDao;
    @Autowired
    private IPsiSalesCustomerDao iPsiSalesCustomerDao;
    @Autowired
    private UcmpAesConfig ucmpAesConfig;
    @Autowired
    private MessagePushService messagePushService;
    @Autowired
    private IPsiSalesMessageRecordDao iPsiSalesMessageRecordDao;
    @Autowired
    private RedissonCache redissonCache;
    @Autowired
    private IPsiOrderFollowRecordDao orderFollowRecordDao;




    public void sendSms(String templateId,String to, String[] templateParas,String relevanceType,Long relevanceId) {
        if(StringUtils.isEmpty(to)){
            LOGGER.info("未发送短信");
            return;
        }

        String status = "02";
        try {
            SmsParamsDto smsParamsDto = new SmsParamsDto();
//            smsParamsDto.setFrom();
            smsParamsDto.setTo(AesUtils.decryptHex(to, ucmpAesConfig.getSecret()));
            smsParamsDto.setTemplateId(templateId);
            smsParamsDto.setTemplateParas(templateParas);
//            smsParamsDto.setStatusCallback();
//            smsParamsDto.setSignature();
            RestResponse<String> stringRestResponse = iSystemConsumer.batchSendSms(smsParamsDto);
            if(Objects.equal(stringRestResponse.getCode(), RestStatusCode.OK.code())){
                status = "01";
            }
            LOGGER.info("发送短信参数{},响应参数{}", templateParas,stringRestResponse);
        } catch (Exception e) {
            LOGGER.error("发送短信发生异常：", e);
        }
        //插入信息表
        PsiSalesMessageRecordEntity messageInfoEntity =new PsiSalesMessageRecordEntity();
        messageInfoEntity.generatePk();
        messageInfoEntity.setTemplateId(templateId);
        messageInfoEntity.setRelevanceType(relevanceType);
        messageInfoEntity.setMessageType("02");
        messageInfoEntity.setRelevanceId(relevanceId);
        messageInfoEntity.setRecipient(to);
        messageInfoEntity.setParam(Arrays.toString(templateParas));
        messageInfoEntity.setStatus(status);
        messageInfoEntity.setReceptionTime(new Date());
        iPsiSalesMessageRecordDao.insert(messageInfoEntity);

    }

    public void giveMessage(String templateId,
                            String originalChannel,
                            Integer receiverType,
                            String receiverId,
                            Integer senderType,
                            String senderId,
                            List<String> params) {
        try {
            GiveMessageParamDto messageParamDto = new GiveMessageParamDto();
            messageParamDto.setTemplateId(templateId);
            messageParamDto.setOriginalChannel(originalChannel);
            messageParamDto.setReceiverType(receiverType);
            messageParamDto.setReceiverId(receiverId);
            messageParamDto.setSenderType(senderType);
            messageParamDto.setSenderId(senderId);
            messageParamDto.setParams(params);
            LOGGER.info("发送消息提醒参数{}", messageParamDto);
        iSystemConsumer.giveMessage(messageParamDto);
            return;
        } catch (Exception e) {
            LOGGER.error("发送消息提醒发生异常：", e);
        }
        throw new IllegalParameterException("消息提醒发送失败");
    }

    /**
     * @param role    角色
     * @param storeId 门店ID
     * @param partyId 人员ID
     * @return
     */
    public List<SalesConsultantDto> getPartyInfo(String role, Long storeId, List<Long> storeIdList, Long partyId, List<Long> partyIdList) {
        // 查询手机号
        SalesConsultantParamDto paramDto = new SalesConsultantParamDto();
        paramDto.setRole(role);
        paramDto.setStoreId(storeId);
        paramDto.setStoreIdList(storeIdList);
        paramDto.setPartyId(partyId);
        paramDto.setPartyIdList(partyIdList);
        List<SalesConsultantDto> salesConsultantDtos = psiRetentionDao.salesConsultantList(paramDto);
        return salesConsultantDtos;
    }

    /**
     * 查询二手车主管
     *
     * @param storeId
     * @return
     */
    public List<UsedCarSupervisorDto> usedCarSupervisor(Long storeId) {
        UsedCarSupervisorParamDto paramDto = new UsedCarSupervisorParamDto();
        paramDto.setStoreId(storeId);
        return psiRetentionDao.queryUsedCarSupervisor(paramDto);
    }


    /**
     * 客户转让
     *
     * @param customerId         条件-客户ID
     * @param followStore        条件-原门店ID
     * @param changeFollowStore  变更门店ID
     * @param changeFollowPerson 变更人员ID
     * @param customerName       消息提醒参数
     * @param deliveryPlace      消息提醒参数
     */
    @Transactional(rollbackFor = Exception.class)
    public void customerAllocation(Long customerId,
                                   Long followStore,
                                   Long changeFollowStore,
                                   Long changeFollowPerson,
                                   String customerName,
                                   String deliveryPlace) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiSalesCustomerEntity psiSalesCustomerEntity = new PsiSalesCustomerEntity();
        psiSalesCustomerEntity.setCustomerId(customerId);
        psiSalesCustomerEntity.setStoreId(changeFollowStore);
        psiSalesCustomerEntity.setPartyId(changeFollowPerson);
        psiSalesCustomerEntity.setUpdatedBy(user.getPartyId());
        psiSalesCustomerEntity.setUpdatedDate(new Date());
        iPsiSalesCustomerDao.updateSelective(psiSalesCustomerEntity);
        psiRetentionDao.updateStoreClues(customerId, followStore, changeFollowStore, changeFollowPerson, user.getPartyId());
        psiRetentionDao.updateStoreOrder(customerId, null,changeFollowStore, changeFollowPerson, user.getPartyId());

        //发送消息提醒（销售人员）
        List<SalesConsultantDto> partyInfo = getPartyInfo(null, null, null, changeFollowPerson, null);
        List<String> params = new ArrayList<>();
        params.add(customerName);
        params.add(deliveryPlace);
        giveMessage(Constants.templateId.templateTitleTen.value(), "UCMP", 1, partyInfo.get(0).getStaffCode(), 0, null, params);

    }

    /**
     * 校验车辆
     * @param vin
     * @return
     */
    public PsiCarStockInfoEntity checkVin(String vin) {

        PsiCarStockInfoEntity psiCarStockInfoEntity = psiRetentionDao.selectByVinCode(vin,0);
        if (java.util.Objects.isNull(psiCarStockInfoEntity) || java.util.Objects.equals(psiCarStockInfoEntity.getStockState(), "5105")|| java.util.Objects.equals(psiCarStockInfoEntity.getStockState(), "5106")) {
            throw new IllegalParameterException("该车辆不存在或已被预订");
        }
        return psiCarStockInfoEntity;
    }

    public void createOrderFollowRecord(Long orderInfoId, String orderStatus){
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        //订单状态变更记录
        PsiOrderFollowRecordEntity orderFollowRecordEntity = new PsiOrderFollowRecordEntity();
        orderFollowRecordEntity.generatePk();
        orderFollowRecordEntity.setOrderInfoId(orderInfoId);
        orderFollowRecordEntity.setFollowStatus(orderStatus);
        orderFollowRecordEntity.setCreatedBy(user.getPartyId());
        orderFollowRecordEntity.setCreatedDate(new Date());
        orderFollowRecordEntity.setIsEnable("01");
        orderFollowRecordEntity.setIsDelete("00");
        orderFollowRecordDao.insert(orderFollowRecordEntity);
    }
    /**
     * 是否锁定车辆
     *
     * @param orderInfoId
     * @param vin
     */
    public void carLock(String orderInfoId, String vin) {
        String key = getCarLockKey(vin);
        if (redissonCache.containsKey(key)) {
            String value = (String) redissonCache.get(key);
            if (!Objects.equal(value, orderInfoId)) {
                throw new IllegalParameterException("该车辆交易中");
            }
        }

    }
    public String getUid(String customerPhone){
        try {
            //查询UID
            RestResponse<String> stringRestResponse = iSystemConsumer.urmUserUid(customerPhone);
            String uid = stringRestResponse.getResult();
            if (StringUtils.isNotEmpty(uid)) {
                return uid;
            }
            //注册
            RegAndLoginDto regAndLoginDto = new RegAndLoginDto();
            regAndLoginDto.setMobilePhone(customerPhone);
            RestResponse<String> stringRestResponse1 = iSystemConsumer.mobilePhoneRegAndLogin(regAndLoginDto);
            return stringRestResponse1.getResult();
        }catch (Exception e){
            LOGGER.error("获取UID发生异常");
        }
        return null;
    }

    /**
     * 校验改配车辆销售金额是否小于已收金额
     * @param salePrice
     * @param receivedPrice
     */
    public void checkPrice(BigDecimal salePrice,BigDecimal receivedPrice){
        BigDecimal receivedPri = java.util.Objects.nonNull(receivedPrice) ? receivedPrice : BigDecimal.ZERO;
        if(salePrice.compareTo(receivedPri) < 0){
            throw new IllegalParameterException("当前改配车辆金额小于已收金额，暂不支持改配");
        }
    }


    /**
     * 获取key
     * @param vin 车辆VIN
     * @return
     */
    public String getCarLockKey(String vin) {
        return String.format("order_vin_%s", vin);
    }
}
