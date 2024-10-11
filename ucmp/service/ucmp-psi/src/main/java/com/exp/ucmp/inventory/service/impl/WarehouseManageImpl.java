package com.exp.ucmp.inventory.service.impl;

import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carDealer.service.FileUploadService;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.file.dto.FileReturnDto;
import com.exp.ucmp.inventory.dao.PsiCarStockHistoryDao;
import com.exp.ucmp.inventory.dao.WarehouseDao;
import com.exp.ucmp.inventory.service.WarehouseManageService;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiCarServiceInfoPk;
import com.exp.ucmp.pk.PsiCarServiceMaterialFilePk;
import com.exp.ucmp.pk.PsiCarServiceMaterialPk;
import com.exp.ucmp.pk.PsiCarStockInfoPk;
import com.exp.ucmp.servicing.dto.StorageHistoryListInfoDto;
import com.exp.ucmp.warehouse.dto.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2023/2/16 18:00
 */
@Service
public class WarehouseManageImpl implements WarehouseManageService {

    @Autowired
    private IPsiCarStockInfoDao stockInfoDao;

    @Autowired
    private IPsiCarStockHistoryDao historyDao;

    @Autowired
    private WarehouseDao warehouseDao;

    @Autowired
    private IPsiOrderFollowRecordDao orderFollowRecordDao;

    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private ISysFileMsgDao iSysFileMsgDao;

    @Autowired
    private IPsiCarServiceMaterialDao iPsiCarServiceMaterialDao;

    @Autowired
    private IPsiCarServiceMaterialFileDao iPsiCarServiceMaterialFileDao;

    @Autowired
    private IPsiCarServiceInfoDao iPsiCarServiceInfoDao;

    @Autowired
    private  IPsiCarStockHistoryDao iPsiCarStockHistoryDao;
    @Autowired
    private PsiCarStockHistoryDao carStockHistoryDao;
    @Autowired
    private IPsiRetentionCluesDao retentionCluesDao;
    @Autowired
    private IPsiOrderInfoDao orderInfoDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseManageImpl.class);

    @Override
    public boolean isDeliveryCenter() {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<Long> list = warehouseDao.selectOrgIdsByPartyId(user.getPartyId());
        return list.size()>0 ;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchDelivery(BatchDeliveryParamsDto paramsDto) {
        // 出库后数据在库存管理-出库车辆列表显示；所有的出库入库都要记录日志；
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<PsiCarStockHistoryEntity> historyEntities = new ArrayList<>();
        List<PsiCarStockInfoEntity> listPsiCarStockInfoEntity = new ArrayList<>();
        Date nowDate = new Date();
        for (int i = 0; i < paramsDto.getStockIds().size(); i++) {
            PsiCarStockInfoEntity load = stockInfoDao.load(new PsiCarStockInfoPk(paramsDto.getStockIds().get(i)));
            PsiCarStockHistoryEntity historyEntity = new PsiCarStockHistoryEntity();
            PsiCarStockInfoEntity update = new PsiCarStockInfoEntity();
            update.setStockId(load.getStockId());
            update.setDeliverDate(nowDate);
            update.setUpdatedDate(nowDate);
            update.setUpdatedBy(user.getPartyId());
            listPsiCarStockInfoEntity.add(update);
            //零售
            if (1 == paramsDto.getType()){
                historyEntity.setStockType(Constants.ReceiptType.RetailOutbound.value());
            }
            //批售
            if (2 == paramsDto.getType()){
                historyEntity.setStockType(Constants.ReceiptType.BatchIssue.value());
            }
            historyEntity.generatePk();
            historyEntity.setStockId(paramsDto.getStockIds().get(i));
            historyEntity.setStorageName(load.getStorageName());
            historyEntity.setStockDate(nowDate);
            historyEntity.setCreatedBy(user.getPartyId());
            historyEntity.setUpdatedBy(user.getPartyId());
            historyEntity.setCreatedDate(nowDate);
            historyEntity.setUpdatedDate(nowDate);
            historyEntity.setCreateName(user.getPersonName());
            historyEntities.add(historyEntity);
        }
        //更新库存车的交付出库时间
        this.stockInfoDao.batchUpdateSelective(listPsiCarStockInfoEntity);
        
        if (historyDao.batchInsert(historyEntities)>0){
        	return true;
        } 
        return false;
    }

    @Override
    public PageInfo<TransferWarehouseResultDto> transferReceipt(WarehouseQueryDto queryDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<Long> storeIds = warehouseDao.selectOrgIdsByPartyId(user.getPartyId());
        queryDto.setStoreIds(storeIds);
        PageHelper.startPage(queryDto.getPageNum(),queryDto.getPageSize());
        List<TransferWarehouseResultDto> transferReceipt = warehouseDao.queryTransferReceipt(queryDto);
        return new PageInfo<>(transferReceipt);
    }

    @Override
    public PageInfo<CheckWarehouseResultDto> serviceList(CheckWarehouseQueryDto queryDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        queryDto.setOrgId(user.getOrganId());
        PageHelper.startPage(queryDto.getPageNum(),queryDto.getPageSize());
        List<CheckWarehouseResultDto> transferReceipt = warehouseDao.selectServiceList(queryDto);
        return new PageInfo<>(transferReceipt);
    }


    @Override
    public PageInfo<TransferWarehouseResultDto> transferIssue(WarehouseQueryDto queryDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<Long> storeIds = warehouseDao.selectOrgIdsByPartyId(user.getPartyId());
        queryDto.setStoreIds(storeIds);
        PageHelper.startPage(queryDto.getPageNum(),queryDto.getPageSize());
        List<TransferWarehouseResultDto> transferIssue = warehouseDao.queryTransferIssue(queryDto);
        return new PageInfo<>(transferIssue);
    }
    @Override//查询零售车辆列表
    public PageInfo<TransferWarehouseResultDto> retailOutbound(WarehouseQueryDto queryDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<Long> storeIds = warehouseDao.selectOrgIdsByPartyId(user.getPartyId());
        queryDto.setStoreIds(storeIds);
        PageHelper.startPage(queryDto.getPageNum(),queryDto.getPageSize());
        List<TransferWarehouseResultDto> retailOutbound = warehouseDao.queryRetailOutbound(queryDto);
        return new PageInfo<>(retailOutbound);
    }



    @Override//查询批售车辆列表
    public PageInfo<TransferWarehouseResultDto> batchIssue(WarehouseQueryDto queryDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<Long> storeIds = warehouseDao.selectOrgIdsByPartyId(user.getPartyId());
        queryDto.setStoreIds(storeIds);
        PageHelper.startPage(queryDto.getPageNum(),queryDto.getPageSize());
        List<TransferWarehouseResultDto> batchIssue = warehouseDao.queryBatchIssue(queryDto);
        return new PageInfo<>(batchIssue);
    }

    @Override
    public PageInfo<CheckWarehouseResultDto> checkList(CheckWarehouseQueryDto queryDto) {
        PageHelper.startPage(queryDto.getPageNum(),queryDto.getPageSize());
        List<CheckWarehouseResultDto> batchIssue = warehouseDao.queryCheckList(queryDto);
        return new PageInfo<>(batchIssue);
    }
    @Transactional
    @Override
    public void deleteServiceMaterialFile(Long materialFileId) {
        PsiCarServiceMaterialFileEntity load = iPsiCarServiceMaterialFileDao.load(new PsiCarServiceMaterialFilePk(materialFileId));
        iPsiCarServiceMaterialFileDao.delete(new PsiCarServiceMaterialFilePk(materialFileId));
        //更新文件底表的文件状态
        SysFileMsgEntity sysFileMsgEntity = new SysFileMsgEntity();
        sysFileMsgEntity.setFileId(materialFileId);
        sysFileMsgEntity.setFileStatuss(Constants.fileStatus.deleted.value());
        iSysFileMsgDao.updateSelective(sysFileMsgEntity);
        //如果子表里面已经没有记录，就删除主表材料数据
        PsiCarServiceMaterialFileEntity psiCarServiceMaterialFileEntity = new PsiCarServiceMaterialFileEntity();
        psiCarServiceMaterialFileEntity.setMaterialId(load.getMaterialId());
        int count = iPsiCarServiceMaterialFileDao.selectBySelectiveCount(psiCarServiceMaterialFileEntity);
        if(count == 0){
            iPsiCarServiceMaterialDao.delete(new PsiCarServiceMaterialPk(load.getMaterialId()));
        }
    }



    @Transactional
    @Override
    public Long uploadServiceMaterialFile(Long serviceId, MultipartFile file, String materialType, String materialFileType,
    		String chineseDescription,Integer fileSort, Long stockId) {
    	if(stockId == null){
    		stockId =  this.warehouseDao.queryStockId(serviceId);
    	}
        String fileName = file.getOriginalFilename();
        if (!fileName.endsWith(".jpg") && !fileName.endsWith(".png")&& !fileName.endsWith(".jpeg")) {
            throw new RuntimeException("文件格式错误,请重新选择 jpg 或 png 格式文件");
        }
        FileReturnDto upload;
        try{
            upload = fileUploadService.upload(file);
            LOGGER.info("====整备图片上传upload==="+JsonBeanUtil.beanToJson(upload));
        }catch (Exception e){
            LOGGER.error("[整备验收图片材料上传]上传图片时报错",e);
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            throw new RuntimeException(e.getMessage());
        }
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();

        PsiCarServiceMaterialEntity carServiceMaterialEntity = new PsiCarServiceMaterialEntity();
        carServiceMaterialEntity.setServiceId(serviceId);
        carServiceMaterialEntity.setStockId(stockId);
        carServiceMaterialEntity.setMaterialType(materialType);
        List<PsiCarServiceMaterialEntity> list = iPsiCarServiceMaterialDao.selectBySelective(carServiceMaterialEntity);
        //主表没有记录的话就新增
        if(CollectionUtils.isEmpty(list)){
            carServiceMaterialEntity.generatePk();
            carServiceMaterialEntity.setCreatedBy(user.getPartyId());
            carServiceMaterialEntity.setUpdatedBy(user.getPartyId());
            iPsiCarServiceMaterialDao.insertSelective(carServiceMaterialEntity);
        }else{
        	carServiceMaterialEntity.setMaterialId(list.get(0).getMaterialId());
        }
        PsiCarServiceMaterialFileEntity psiCarServiceMaterialFileEntity = new PsiCarServiceMaterialFileEntity();
        psiCarServiceMaterialFileEntity.setMaterialId(carServiceMaterialEntity.getMaterialId());
        psiCarServiceMaterialFileEntity.setMaterialFileType(materialFileType);
        psiCarServiceMaterialFileEntity.setMaterialFileId(upload.getFileId());
        psiCarServiceMaterialFileEntity.setFileSort(fileSort);
        psiCarServiceMaterialFileEntity.setThumbnail(upload.getThumbnailFile());
        psiCarServiceMaterialFileEntity.setChineseDescription(chineseDescription);
        psiCarServiceMaterialFileEntity.setCreatedBy(user.getPartyId());
        psiCarServiceMaterialFileEntity.setUpdatedBy(user.getPartyId());
        LOGGER.info("====整备图片上传psiCarServiceMaterialFileEntity==="+JsonBeanUtil.beanToJson(psiCarServiceMaterialFileEntity));
        iPsiCarServiceMaterialFileDao.insertSelective(psiCarServiceMaterialFileEntity);

        return psiCarServiceMaterialFileEntity.getMaterialFileId();
    }
    @Transactional
    @Override
    public void submitStorage(Long serviceId) {
    	Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiCarServiceInfoEntity load = iPsiCarServiceInfoDao.load(new PsiCarServiceInfoPk(serviceId));
        PsiCarStockInfoEntity psiCarStockInfoEntity = stockInfoDao.load(new PsiCarStockInfoPk(load.getStockId()));
        String  stockType = Constants.ReceiptType.SERVICE_PUT_STORAGE.value();
       /* //整备验收入库后，车辆整备信息状态变为已验收入库
        load.setServiceState(Constants.SERVICE_STATE.WAREHOUS.value());
        iPsiCarServiceInfoDao.updateSelective(load);*/
        //整备验收入库后，库存车辆状态变为待上架     整备完成后就直接变成待上架了，无需此逻辑
        /*psiCarStockInfoEntity.setStockState(Constants.STOCK_STATUS.WAIT_PUT.value());
        stockInfoDao.updateSelective(psiCarStockInfoEntity);*/
        //同时出入库历史表新增一条记录
        PsiCarStockHistoryEntity psiCarStockHistoryEntity = new PsiCarStockHistoryEntity();
        psiCarStockHistoryEntity.setStockId(psiCarStockInfoEntity.getStockId());
        psiCarStockHistoryEntity.setStorageName(psiCarStockInfoEntity.getStorageName());
        psiCarStockHistoryEntity.setStockType(stockType);
        psiCarStockHistoryEntity.setCreateName(user.getPersonName());
        psiCarStockHistoryEntity.setCreatedBy(user.getPartyId());
        psiCarStockHistoryEntity.setUpdatedBy(user.getPartyId());
        iPsiCarStockHistoryDao.insertSelective(psiCarStockHistoryEntity);
        
        //变更整备单信息
        this.warehouseDao.updateServiceInfo(serviceId,user.getPartyId());
    }
    @Override
    public void submitOutStorages(String serviceIds) {
        String[] split = serviceIds.split(",");
        List<PsiCarServiceInfoEntity> carServiceInfoEntities = new ArrayList<>();
        List<PsiCarStockHistoryEntity> carStockHistoryEntityList = new ArrayList<>();
        for (String serviceId:split) {
            PsiCarServiceInfoEntity load = iPsiCarServiceInfoDao.load(new PsiCarServiceInfoPk(Long.valueOf(serviceId)));
            //整备出库后，整备状态是实施完成
            load.setServiceState(Constants.SERVICE_STATE.FINISH.value());
            carServiceInfoEntities.add(load);

            PsiCarStockInfoEntity psiCarStockInfoEntity = stockInfoDao.load(new PsiCarStockInfoPk(load.getStockId()));
            String stockType =  Constants.ReceiptType.SERVICE_OUTBOUND.value();
            //同时出入库历史表新增一条记录
            Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
            PsiCarStockHistoryEntity psiCarStockHistoryEntity = new PsiCarStockHistoryEntity();
            psiCarStockHistoryEntity.setStockId(psiCarStockInfoEntity.getStockId());
            psiCarStockHistoryEntity.setStorageName(psiCarStockInfoEntity.getStorageName());
            psiCarStockHistoryEntity.setStockDate(new Date());
            psiCarStockHistoryEntity.setStockType(stockType);
            psiCarStockHistoryEntity.setCreateName(user.getPersonName());
            psiCarStockHistoryEntity.setCreatedBy(user.getPartyId());
            psiCarStockHistoryEntity.setCreatedDate(new Date());
            psiCarStockHistoryEntity.setUpdatedBy(user.getPartyId());
            psiCarStockHistoryEntity.setUpdatedDate(new Date());
            carStockHistoryEntityList.add(psiCarStockHistoryEntity);
        }
        if(CollectionUtils.isNotEmpty(carServiceInfoEntities)){
            iPsiCarServiceInfoDao.batchUpdateSelective(carServiceInfoEntities);
        }
        if(CollectionUtils.isNotEmpty(carStockHistoryEntityList)){
            iPsiCarStockHistoryDao.batchInsert(carStockHistoryEntityList);
        }
    }

    @Override
    public void updateMaterialFileRemarks(Long materialFileId, String chineseDescription) {
        PsiCarServiceMaterialFileEntity serviceMaterialFileEntity= new PsiCarServiceMaterialFileEntity();
        serviceMaterialFileEntity.setMaterialFileId(materialFileId);
        serviceMaterialFileEntity.setChineseDescription(chineseDescription);
        iPsiCarServiceMaterialFileDao.updateSelective(serviceMaterialFileEntity);
    }

    @Override
    public PageInfo<AcquisitionWarehouseResultDto> acquisitionList(CheckWarehouseQueryDto queryDto) {
        PageHelper.startPage(queryDto.getPageNum(),queryDto.getPageSize());
        List<AcquisitionWarehouseResultDto> batchIssue = warehouseDao.queryAcquisitionList(queryDto);
        return new PageInfo<>(batchIssue);
    }

    @Override
    public PageInfo<StorageHistoryListInfoDto> selectStorageHistoryList(Long stockId,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PsiCarStockHistoryEntity carStockHistoryEntity = new PsiCarStockHistoryEntity();
        carStockHistoryEntity.setStockId(stockId);
        List<StorageHistoryListInfoDto> psiCarStockHistoryEntities = carStockHistoryDao.selectStorageHistoryList(stockId);
        return new PageInfo<>(psiCarStockHistoryEntities);
    }


}
