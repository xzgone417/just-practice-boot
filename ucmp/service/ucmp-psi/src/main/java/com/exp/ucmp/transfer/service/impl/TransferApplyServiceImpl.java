package com.exp.ucmp.transfer.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.common.utils.StringUtils;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.consumer.ISystemConsumer;
import com.exp.ucmp.dao.IPsiCarStockHistoryDao;
import com.exp.ucmp.dao.IPsiCarStockInfoDao;
import com.exp.ucmp.dao.IPsiCarTransferApplyDao;
import com.exp.ucmp.dao.ISysCarUsedStorageDao;
import com.exp.ucmp.entity.PsiCarStockHistoryEntity;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.exp.ucmp.entity.PsiCarTransferApplyEntity;
import com.exp.ucmp.entity.SysCarUsedStorageEntity;
import com.exp.ucmp.inventory.dao.WarehouseDao;
import com.exp.ucmp.logistics.dto.DispatchRequestDto;
import com.exp.ucmp.logistics.dto.ReceiverDto;
import com.exp.ucmp.logistics.dto.SenderDto;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiCarStockInfoPk;
import com.exp.ucmp.pk.PsiCarTransferApplyPk;
import com.exp.ucmp.pk.SysCarUsedStoragePk;
import com.exp.ucmp.transfer.dao.CarTransferApplyDao;
import com.exp.ucmp.transfer.dto.TransferApplyCarInfoDto;
import com.exp.ucmp.transfer.dto.TransferCarApplyQueryDto;
import com.exp.ucmp.transfer.dto.TransferCarApplyResultDto;
import com.exp.ucmp.transfer.dto.TransferCarApplyStatusDto;
import com.exp.ucmp.transfer.service.TransferApplyService;
import com.exp.ucmp.util.AesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxl.job.core.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class TransferApplyServiceImpl implements TransferApplyService {
	@Autowired
	private IPsiCarTransferApplyDao iPsiCarTransferApplyDao;

    @Autowired
    private CarTransferApplyDao carTransferApplyDao;

    @Autowired
    private IPsiCarStockHistoryDao stockHistoryDao;

    @Autowired
    private ISysCarUsedStorageDao carUsedStorageDao;

    @Autowired
    private ISystemConsumer systemConsumer;

    @Autowired
    WarehouseDao warehouseDao;

    @Autowired
    IPsiCarStockInfoDao carStockInfoDao;

    @Autowired
    private UcmpAesConfig ucmpAesConfig;

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferApplyServiceImpl.class);


	@Override
	public TransferApplyCarInfoDto findTransferApplyInfo(Long dispatchApplyId) {
        PsiCarTransferApplyEntity load = iPsiCarTransferApplyDao.load(new PsiCarTransferApplyPk(dispatchApplyId));
        TransferApplyCarInfoDto applyCarInfoDto =
                Copiers.beanToBean(load, PsiCarTransferApplyEntity.class, TransferApplyCarInfoDto.class);
        return applyCarInfoDto;
	}
    @Transactional
    @Override
    public void submitTransferApply(Integer operation, TransferApplyCarInfoDto transferApplyCarInfoDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        

        PsiCarTransferApplyEntity  transferApplyEntity =
                Copiers.beanToBean(transferApplyCarInfoDto, TransferApplyCarInfoDto.class, PsiCarTransferApplyEntity.class);
        transferApplyEntity.setUpdatedBy(user.getPartyId());
        transferApplyEntity.setUpdatedDate(new Date());
        String dispatchNumber=null;
        if(1 == operation){
        	//提交调拨申请到VLMS
        	dispatchNumber = sendVLMS(transferApplyCarInfoDto);
        	//更新调拨状态
        	transferApplyEntity.setIsSubmit(Constants.IS_SUBMIT.SUBMIT.value());
        	transferApplyEntity.setTransferStatus(Constants.TRANSFER_STATUS.WAIT_SHIPP.value());
        }
        if(null == transferApplyCarInfoDto.getTransferApplyId()){
            transferApplyEntity.generatePk();
            transferApplyEntity.setInitiator(user.getPartyId());
            transferApplyEntity.setInitiatorTime(new Date());
            transferApplyEntity.setIsSubmit(Constants.IS_SUBMIT.WAIT_SUBMIT.value());
            transferApplyEntity.setCreatedBy(user.getPartyId());
            transferApplyEntity.setCreatedDate(new Date());
            transferApplyEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
            transferApplyEntity.setIsDelete(Constants.IsDelete.NO.value());
            transferApplyEntity.setDispatchNumber(dispatchNumber);
            iPsiCarTransferApplyDao.insertSelective(transferApplyEntity);
        }
        iPsiCarTransferApplyDao.updateSelective(transferApplyEntity);

    }

    private String sendVLMS(TransferApplyCarInfoDto transferApplyCarInfoDto) {
        SysCarUsedStorageEntity storageEntity = carUsedStorageDao.load(new SysCarUsedStoragePk(transferApplyCarInfoDto.getStorageId()));

        SysCarUsedStorageEntity targetStorageEntity = carUsedStorageDao.load(new SysCarUsedStoragePk(transferApplyCarInfoDto.getTransferStorageId()));
        PsiCarStockInfoEntity stockInfoEntity = carStockInfoDao.load(new PsiCarStockInfoPk(transferApplyCarInfoDto.getStockId()));
        //同时更新库存类型为调拨申请中
        stockInfoEntity.setStockType(Constants.STOCK_TYPE.TransferApply.value());
        carStockInfoDao.updateSelective(stockInfoEntity);

        DispatchRequestDto dispatchRequestDto = new DispatchRequestDto();
        dispatchRequestDto.setZbustp("40");
        dispatchRequestDto.setCarModel(stockInfoEntity.getBaseCarTypeName());
        List<ReceiverDto> list = new ArrayList<>();
        ReceiverDto receiverDto = new ReceiverDto();
        receiverDto.setReceiver(targetStorageEntity.getManagerName());
        try {
            //手机号解密再返回
            if(StringUtils.isNotBlank(targetStorageEntity.getManagerPhone())){
                receiverDto.setReceiverContact(AesUtils.decryptHex(targetStorageEntity.getManagerPhone(), ucmpAesConfig.getSecret()));
                dispatchRequestDto.setzContact(receiverDto.getReceiverContact());
            }
        }catch (Exception e){
            LOGGER.error("手机号解密失败=========",e);
        }
        list.add(receiverDto);
        dispatchRequestDto.setReceiverList(list);
        List<SenderDto> sendList = new ArrayList<>();
        SenderDto senderDto = new SenderDto();
        senderDto.setSender(storageEntity.getManagerName());
        try {
            //手机号解密再返回
            if(StringUtils.isNotBlank(storageEntity.getManagerPhone())){
                senderDto.setSenderContact(AesUtils.decryptHex(storageEntity.getManagerPhone(), ucmpAesConfig.getSecret()));
            }
        }catch (Exception e){
            LOGGER.error("手机号解密失败=========",e);
        }
        sendList.add(senderDto);
        dispatchRequestDto.setLfimg("1");
        //dispatchRequestDto.setStartNode(null);
        //dispatchRequestDto.setEndNode(null);
        dispatchRequestDto.setWadat(DateUtil.formatDateTime(transferApplyCarInfoDto.getStartTime()));
        dispatchRequestDto.setzReceiver(targetStorageEntity.getManagerName());
        dispatchRequestDto.setRequestTime(DateUtil.formatDateTime(new Date()));
        dispatchRequestDto.setShippingTime(DateUtil.formatDateTime(transferApplyCarInfoDto.getStartTime()));
        dispatchRequestDto.setRequestTime(DateUtil.formatDateTime(transferApplyCarInfoDto.getExpectedTime()));
        dispatchRequestDto.setSenderList(sendList);
        dispatchRequestDto.setStartAddress(storageEntity.getStorageAddress());
        dispatchRequestDto.setVhvin(stockInfoEntity.getVinCode());
        dispatchRequestDto.setzAddress(targetStorageEntity.getStorageAddress());
        LOGGER.info("发运指令接口调用参数：{}",JSON.toJSONString(dispatchRequestDto));
        RestResponse<String> stringRestResponse = systemConsumer.submitTransferApplication(dispatchRequestDto);
        LOGGER.info("发运指令接口调用返回：{}",stringRestResponse.getResult());
        JSONObject jsonObject = JSON.parseObject(stringRestResponse.getResult());
        LOGGER.info("发运指令接口调用返回的调度编号：{}",jsonObject.get("requestNo"));
        return  jsonObject.get("requestNo").toString();
    }

    public static  void  main(String[] args){
        String s = DateUtil.formatDateTime(new Date());
        System.out.println(s);
    }
    /**
     * 查询申请列表
     */
    @Override
    public PageInfo<TransferCarApplyResultDto> findList(TransferCarApplyQueryDto queryDto) {
        PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize());
        List<TransferCarApplyResultDto> list = carTransferApplyDao.selectApplyList(queryDto);
        return new PageInfo<>(list);
    }

    @Override
    public PageInfo<TransferCarApplyResultDto> registerList(TransferCarApplyQueryDto queryDto) {
        PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize());
        List<TransferCarApplyResultDto> list = carTransferApplyDao.selectRegisterList(queryDto);
        return new PageInfo<>(list);
    }

    /**
     * 调拨发运状态列表
     */
    @Override
    public PageInfo<TransferCarApplyStatusDto> findStatusList(TransferCarApplyQueryDto queryDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<Long> storeIds = warehouseDao.selectOrgIdsByPartyId(user.getPartyId());
        queryDto.setStoreIds(storeIds);
        PageHelper.startPage(queryDto.getPageNum(), queryDto.getPageSize());
        List<TransferCarApplyStatusDto> list = carTransferApplyDao.selectApplyStatusList(queryDto);
        if (CollectionUtil.isNotEmpty(list)){
            for (TransferCarApplyStatusDto applyStatusDto : list) {
                //库龄
                Date date = new Date();
                int stockDay = 0;
                if (Objects.nonNull(applyStatusDto.getOutDate())){
                    stockDay  = (int) (( date.getTime()-applyStatusDto.getOutDate().getTime() ) /(1000*3600*24));
                }
                applyStatusDto.setStockAge(stockDay);
                //车龄
                int carDay = 0;
                if (Objects.nonNull(applyStatusDto.getInvoicingDate())){
                    carDay = (int) ( (date.getTime() - applyStatusDto.getInvoicingDate().getTime() ) / (1000*3600*24) );
                }
                applyStatusDto.setCarAge(carDay);
            }
        }
        return new PageInfo<>(list);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean transferWarehousing(Integer option, List<Long> transferApplyIds) {
         Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiCarStockHistoryEntity stockHistory = new PsiCarStockHistoryEntity();
        SysCarUsedStorageEntity storageEntity = new SysCarUsedStorageEntity();
        PsiCarTransferApplyEntity transferApply = new PsiCarTransferApplyEntity();
        List<PsiCarTransferApplyEntity> transferApplyEntities = new ArrayList<>();
        List<PsiCarStockHistoryEntity> stockHistoryEntities = new ArrayList<>();
        PsiCarStockInfoEntity stockInfoEntity = new PsiCarStockInfoEntity();
        //取消发运
        if (option ==1){
            transferApply.setTransferApplyId(transferApplyIds.get(0));
            List<PsiCarTransferApplyEntity> applyEntityList = iPsiCarTransferApplyDao.selectBySelective(transferApply);
            if (CollectionUtil.isEmpty(applyEntityList)){
            	return false;
            } 

            SysCarUsedStorageEntity storageEntity1 = carUsedStorageDao.load(new SysCarUsedStoragePk(applyEntityList.get(0).getStorageId()));
            SysCarUsedStorageEntity targetStorageEntity = carUsedStorageDao.load(new SysCarUsedStoragePk(applyEntityList.get(0).getTransferStorageId()));
            PsiCarStockInfoEntity stockInfoEntity1 = carStockInfoDao.load(new PsiCarStockInfoPk(applyEntityList.get(0).getStockId()));
            //同时更新库存类型为调拨申请中
            stockInfoEntity1.setStockType(Constants.STOCK_TYPE.OutletInventory.value());
            carStockInfoDao.updateSelective(stockInfoEntity1);

            DispatchRequestDto dispatchRequestDto = new DispatchRequestDto();
            dispatchRequestDto.setZbustp("41");
            dispatchRequestDto.setCarModel(stockInfoEntity1.getBaseCarTypeName());
            List<ReceiverDto> list = new ArrayList<>();
            ReceiverDto receiverDto = new ReceiverDto();
            receiverDto.setReceiver(targetStorageEntity.getManagerName());
            try {
                //手机号解密再返回
                if(StringUtils.isNotBlank(targetStorageEntity.getManagerPhone())){
                    receiverDto.setReceiverContact(AesUtils.decryptHex(targetStorageEntity.getManagerPhone(), ucmpAesConfig.getSecret()));
                    dispatchRequestDto.setzContact(receiverDto.getReceiverContact());
                }
            }catch (Exception e){
                LOGGER.error("手机号解密失败=========",e);
            }
            list.add(receiverDto);
            dispatchRequestDto.setReceiverList(list);
            List<SenderDto> sendList = new ArrayList<>();
            SenderDto senderDto = new SenderDto();
            senderDto.setSender(storageEntity1.getManagerName());
            try {
                //手机号解密再返回
                if(StringUtils.isNotBlank(storageEntity1.getManagerPhone())){
                    senderDto.setSenderContact(AesUtils.decryptHex(storageEntity1.getManagerPhone(), ucmpAesConfig.getSecret()));
                }
            }catch (Exception e){
                LOGGER.error("手机号解密失败=========",e);
            }
            sendList.add(senderDto);
            dispatchRequestDto.setLfimg("1");
            dispatchRequestDto.setRequestNo(applyEntityList.get(0).getDispatchNumber());
            dispatchRequestDto.setWadat(DateUtil.formatDateTime(applyEntityList.get(0).getStartTime()));
            dispatchRequestDto.setzReceiver(targetStorageEntity.getManagerName());
            dispatchRequestDto.setRequestTime(DateUtil.formatDateTime(new Date()));
            dispatchRequestDto.setShippingTime(DateUtil.formatDateTime(applyEntityList.get(0).getStartTime()));
            dispatchRequestDto.setRequestTime(DateUtil.formatDateTime(applyEntityList.get(0).getExpectedTime()));
            dispatchRequestDto.setSenderList(sendList);
            dispatchRequestDto.setStartAddress(storageEntity1.getStorageAddress());
            dispatchRequestDto.setVhvin(stockInfoEntity1.getVinCode());
            dispatchRequestDto.setzAddress(targetStorageEntity.getStorageAddress());
            LOGGER.info("发运指令接口调用参数：{}",JSON.toJSONString(dispatchRequestDto));
            RestResponse<String> stringRestResponse = systemConsumer.submitTransferApplication(dispatchRequestDto);
            LOGGER.info("发运指令接口调用返回：{}",stringRestResponse.getResult());
            JSONObject jsonObject = JSON.parseObject(stringRestResponse.getResult());
            LOGGER.info("发运指令接口调用返回的调度编号：{}",jsonObject.get("requestNo"));

            //调物流接口
            transferApply.setTransferStatus(Constants.TRANSFER_STATUS.CANCEL.value());
            transferApply.setUpdatedDate(new Date());
            transferApply.setUpdatedBy(user.getPartyId());
//            stockInfoEntity.setStockType(Constants.STOCK_TYPE.TransferApply.value());
            if (iPsiCarTransferApplyDao.updateSelective(transferApply)>0){
            	return true;
            } 
        } else {
            for (int i = 0; i < transferApplyIds.size(); i++) {
                transferApply.setTransferApplyId(transferApplyIds.get(i));
                List<PsiCarTransferApplyEntity> applyEntityList = iPsiCarTransferApplyDao.selectBySelective(transferApply);
                SysCarUsedStorageEntity load = carUsedStorageDao.load(new SysCarUsedStoragePk(applyEntityList.get(0).getTransferStorageId()));
                if (CollectionUtil.isEmpty(applyEntityList)){
                	return false;
                } 
                if (option == 2){
                    load = carUsedStorageDao.load(new SysCarUsedStoragePk(applyEntityList.get(0).getStorageId()));
                    transferApply.setTransferStatus(Constants.TRANSFER_STATUS.TRANSPORT.value());
                    transferApply.setDeliveryTime(new Date());
                    //调拨出库 插入出入库历史表
                    stockInfoEntity.setStockType(Constants.STOCK_TYPE.TransferInTransit.value());
                    storageEntity.setStorageId(applyEntityList.get(0).getStorageId());
                    stockHistory.setStockType(Constants.ReceiptType.TransferIssue.value());
                }
                if (option == 3){
                    load = carUsedStorageDao.load(new SysCarUsedStoragePk(applyEntityList.get(0).getTransferStorageId()));
                    transferApply.setTransferStatus(Constants.TRANSFER_STATUS.WAREHOUS.value());
                    transferApply.setWarehousDate(new Date());
                    //调拨入库 插入出入库历史表
                    stockInfoEntity.setStockType(Constants.STOCK_TYPE.OutletInventory.value());
                    stockInfoEntity.setStorageId(applyEntityList.get(0).getTransferStorageId());
                    stockInfoEntity.setWarehousDate(new Date());
                    stockInfoEntity.setStorageId(applyEntityList.get(0).getTransferStorageId());
//                    storageEntity.setStorageId(applyEntityList.get(0).getTransferStorageId());
                    stockHistory.setStockType(Constants.ReceiptType.TransferReceipt.value());
                }
                //更新库存表状态
                stockInfoEntity.setStockId(applyEntityList.get(0).getStockId());
                stockInfoEntity.setStorageName(load.getStorageName());
                stockInfoEntity.setStorageCode(load.getStorageCode());
                carStockInfoDao.updateSelective(stockInfoEntity);
                transferApply.setUpdatedDate(new Date());
                transferApply.setUpdatedBy(user.getPartyId());
                transferApplyEntities.add(transferApply);
                stockHistory.generatePk();
                stockHistory.setStockId(applyEntityList.get(0).getStockId());
                stockHistory.setStockDate(new Date());
                List<SysCarUsedStorageEntity> storageEntities = carUsedStorageDao.selectBySelective(storageEntity);
                if (CollectionUtil.isEmpty(storageEntities)){
                	return false;
                } 
                stockHistory.setStorageName(storageEntities.get(0).getStorageName());
                stockHistory.setCreatedDate(new Date());
                stockHistory.setCreateName(user.getPersonName());
                stockHistory.setCreatedBy(user.getPartyId());
                stockHistory.setUpdatedBy(user.getPartyId());
                stockHistory.setUpdatedDate(new Date());
                stockHistoryEntities.add(stockHistory);
            }
            int i = iPsiCarTransferApplyDao.batchUpdateSelective(transferApplyEntities);
            int i1 = stockHistoryDao.batchInsert(stockHistoryEntities);
            if (i>0&&i1>0){
            	return true;
            } 
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean submitOrClose(Integer option, Long transferApplyId) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiCarTransferApplyEntity transferApply = new PsiCarTransferApplyEntity();
        transferApply.setTransferApplyId(transferApplyId);
        PsiCarTransferApplyEntity load = iPsiCarTransferApplyDao.load(new PsiCarTransferApplyPk(transferApplyId));
        //提交
        if (option == 1){
            PsiCarStockInfoEntity stockInfoEntity = carStockInfoDao.load(new PsiCarStockInfoPk(load.getStockId()));
            //同时更新库存类型为调拨申请中
            stockInfoEntity.setStockType(Constants.STOCK_TYPE.TransferApply.value());
            carStockInfoDao.updateSelective(stockInfoEntity);
            TransferApplyCarInfoDto transferApplyCarInfoDto =
                    Copiers.beanToBean(load, PsiCarTransferApplyEntity.class,TransferApplyCarInfoDto.class);
            String sendVLMS = sendVLMS(transferApplyCarInfoDto);
            transferApply.setDispatchNumber(sendVLMS);
            transferApply.setIsSubmit(Constants.IS_SUBMIT.SUBMIT.value());
            transferApply.setTransferStatus(Constants.TRANSFER_STATUS.WAIT_SHIPP.value());
        }
        //关闭
        if (option ==2){
            transferApply.setIsSubmit(Constants.IS_SUBMIT.CLOSE.value());
        }
        transferApply.setUpdatedBy(user.getPartyId());
        transferApply.setUpdatedDate(new Date());
        int i = iPsiCarTransferApplyDao.updateSelective(transferApply);
        return i>0;
    }
}
