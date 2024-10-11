package com.exp.ucmp.inventory.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.egrid.cache.redisson.cache.RedissonCache;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.Import.dto.ImportReturnDto;
import com.exp.ucmp.car.dto.ApproveChangePriceDto;
import com.exp.ucmp.car.dto.CarMainInfoDto;
import com.exp.ucmp.car.dto.CarSalePriceDto;
import com.exp.ucmp.car.dto.ChangePriceDetailDto;
import com.exp.ucmp.car.dto.ChangePriceParamDto;
import com.exp.ucmp.car.dto.QueryChangePriceDto;
import com.exp.ucmp.car.dto.QueryChangePriceParamDto;
import com.exp.ucmp.carDealer.dao.RightActivitiesDao;
import com.exp.ucmp.carDealer.service.FileUploadService;
import com.exp.ucmp.carDealer.util.excel.entity.CarStockInfoImportExcelEntity;
import com.exp.ucmp.carDealer.util.excel.listener.CarStockInfoImportExtraListener;
import com.exp.ucmp.clues.dto.OrderChangeFileDto;
import com.exp.ucmp.clues.dto.OrderChangePriceDto;
import com.exp.ucmp.config.HwOBSConfig;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.PsiCarSaleRecordEntity;
import com.exp.ucmp.entity.PsiCarSaleRecordFileEntity;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.exp.ucmp.entity.PsiPricingJournalEntity;
import com.exp.ucmp.entity.SysCarUsedStorageEntity;
import com.exp.ucmp.file.dto.FileReturnDto;
import com.exp.ucmp.inventory.dao.PsiCarFileDao;
import com.exp.ucmp.inventory.dao.PsiCarStockInfoDao;
import com.exp.ucmp.inventory.dao.WarehouseDao;
import com.exp.ucmp.inventory.service.CarStockInfoService;
import com.exp.ucmp.mall.dao.PsiRetentionDao;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiCarStockInfoPk;
import com.exp.ucmp.pk.SysCarUsedStoragePk;
import com.exp.ucmp.pricing.retail.DiscountBasicDto;
import com.exp.ucmp.pricing.retail.MaintenanceDto;
import com.exp.ucmp.pricing.retail.UseNatureDto;
import com.exp.ucmp.stock.dto.*;
import com.exp.ucmp.transfer.dto.TransferApplyCarInfoDto;
import com.exp.ucmp.util.AesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;

import cn.hutool.core.collection.CollectionUtil;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class CarStockInfoServiceImpl implements CarStockInfoService {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CarStockInfoServiceImpl.class);

	@Autowired
	private IPsiCarStockInfoDao ipsiCarStockInfoDao;

    @Autowired
    private PsiCarStockInfoDao psiCarStockInfoDao;
	@Autowired
	private RightActivitiesDao rightActivitiesDao;
    @Autowired
    UcmpAesConfig ucmpAesConfig;

    @Autowired
    RedissonCache redissonCache;

	@Autowired
	private FileUploadService fileUploadService;
    @Autowired
    private IPsiCarSaleRecordDao iPsiCarSaleRecordDao;
    @Autowired
    private IPsiCarSaleRecordFileDao iPsiCarRecordFileDao;
    @Autowired
    private PsiCarFileDao psiCarFileDao;
    @Autowired
    WarehouseDao warehouseDao;
    @Autowired
    private ISysCarUsedStorageDao iSysCarUsedStorageDao;
    
    @Autowired
    private IPsiPricingJournalDao journalDao;
    
    @Autowired
    private PsiRetentionDao psiRetentionDao;
    
    @Autowired
    private PsiPricingServiceImpl psiPricingServiceImpl;
    
    @Autowired
    private HwOBSConfig hwOBSConfig;
    
    @Autowired
    private IPsiCarStockInfoDao iPsiCarStockInfoDao;

	@Override
	public ImportReturnDto readExcel(MultipartFile file) {
		if (file.isEmpty()) {
			throw new RuntimeException("文件异常,请重新选择");
		}
		String fileName = file.getOriginalFilename();
		ImportReturnDto result = null;
		//判断文件类型
        if (StringUtils.isNotBlank(fileName)) {
            if (!fileName.endsWith(ExcelTypeEnum.XLS.getValue()) && !fileName.endsWith(ExcelTypeEnum.XLSX.getValue())) {
                throw new RuntimeException("文件格式错误,请重新选择 xlsx 或 xls 格式文件");
			}
			List<PsiCarStockInfoEntity> datas = new ArrayList<>();
			try {
				//有个很重要的点 ExcelListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
				EasyExcel.read(file.getInputStream(), CarStockInfoImportExcelEntity.class,
						new CarStockInfoImportExtraListener(datas)).sheet().doRead();
			} catch (Exception e) {
			    LOGGER.error("====Excel读取异常====",e);
			}
            if(CollectionUtils.isNotEmpty(datas)){
                result = batchInsertOrUpdate(datas);
            }else{
                throw new RuntimeException("导入的模板文件不能为空!");
            }
		}
        return  result;
	}


    @Transactional
    public ImportReturnDto batchInsertOrUpdate(List<PsiCarStockInfoEntity> datas) {
    	LOGGER.info("==datas=="+JsonBeanUtil.beanToJson(datas));
    	ImportReturnDto returnDto = new ImportReturnDto();
        //查询所有的库存车辆信息
        PsiCarStockInfoEntity stockInfoEntity = new PsiCarStockInfoEntity();
        stockInfoEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
        stockInfoEntity.setIsDelete(Constants.IsDelete.NO.value());
        List<PsiCarStockInfoEntity> usedStorageEntities = ipsiCarStockInfoDao.selectNewBySelective(stockInfoEntity);
        Map<String, PsiCarStockInfoEntity> carStockInfoMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(usedStorageEntities)){
            carStockInfoMap = usedStorageEntities.stream().collect(Collectors.toMap(p -> p.getVinCode(), p -> p));
        }
        //查询所有的仓储点信息
        SysCarUsedStorageEntity carUsedStorageEntity = new SysCarUsedStorageEntity();
        carUsedStorageEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
        carUsedStorageEntity.setIsDelete(Constants.IsDelete.NO.value());
        List<SysCarUsedStorageEntity> carUsedStorageEntities = iSysCarUsedStorageDao.selectBySelective(carUsedStorageEntity);
        Map<String, SysCarUsedStorageEntity> carUsedStorageMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(carUsedStorageEntities)){
            carUsedStorageMap = carUsedStorageEntities.stream().collect(Collectors.toMap(p -> p.getStorageCode(), p -> p));
        }
        List<PsiCarStockInfoEntity> insertList = new LinkedList<>();
        List<PsiCarStockInfoEntity> errorList = new LinkedList<>();
        List<PsiCarStockInfoEntity> errorStorageList = new LinkedList<>();
        Long userBy = AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
        for (PsiCarStockInfoEntity  item : datas) {
        	LOGGER.info("=====item====="+JsonBeanUtil.beanToJson(item));
        	//20231020日业务要求导入车辆时去掉仓库限制
        	if(!StringUtil.isEmpty(item.getStorageCode())){
        		if( carUsedStorageMap.containsKey(item.getStorageCode())){
        			item.setStorageName(carUsedStorageMap.get(item.getStorageCode()).getStorageName());
        			item.setStorageId(carUsedStorageMap.get(item.getStorageCode()).getStorageId());
        		}else{
        			//如果仓库不存在，则导入失败
        			PsiCarStockInfoEntity carStockInfoEntity = new PsiCarStockInfoEntity();
        			carStockInfoEntity.setStorageCode(item.getStorageCode());
        			errorStorageList.add(carStockInfoEntity);
        			continue;
        		}
        	}

            if(carStockInfoMap.containsKey(item.getVinCode()) &&
                ! Constants.STOCK_STATUS.Sold.value().equals(carStockInfoMap.get(item.getVinCode()).getStockState()) ){
                //如果表里已经存在这条vin车辆数据，并且状态并不是已售出状态则不允许导入
                PsiCarStockInfoEntity carStockInfoEntity = carStockInfoMap.get(item.getVinCode());
                errorList.add(carStockInfoEntity);
            }else{
                //新增
                item.setCarSource(Constants.CAR_SOURCE.IMPORT.value());
                item.setStockType(Constants.STOCK_TYPE.OutletInventory.value());
                item.generatePk();
                item.setIsDelete(Constants.IsDelete.NO.value());
                item.setIsEnable(Constants.IsEnable.ENABLE.value());
                item.setRepealIs(Constants.IS_REPEAL.NO.value());
                //当车辆导入后，初始状态为在库待售
                item.setStockState(Constants.STOCK_STATUS.InStockForSale.value());
                item.setCreatedBy(userBy);
                item.setUpdatedBy(userBy);
                insertList.add(item);
            }
        }
        StringBuffer result = new StringBuffer();
        result.append("导入成功");
        if(CollectionUtils.isNotEmpty(insertList)){
            ipsiCarStockInfoDao.batchInsert(insertList);
        }
        result.append(insertList.size());
        result.append("条，导入失败");
        result.append(errorList.size()+errorStorageList.size());
        result.append("条");
        if(CollectionUtils.isNotEmpty(errorList)){
            result.append("。失败原因:车架号为[");
            for (PsiCarStockInfoEntity item: errorList) {
                result.append(item.getVinCode());
                result.append(",");
            }
            //去掉最后一个逗号
            result.deleteCharAt(result.length() - 1);
            result.append("]的车辆数据已存在且未售出");
        }
        if(CollectionUtils.isNotEmpty(errorStorageList)){
            result.append("。仓库编码[");
            for (PsiCarStockInfoEntity item: errorStorageList) {
                result.append(item.getStorageCode());
                result.append(",");
            }
            //去掉最后一个逗号
            result.deleteCharAt(result.length() - 1);
            result.append("]不正确");
        }
        if(errorList.isEmpty() && errorStorageList.isEmpty()){
        	returnDto.setFlag(1);
        }else if(insertList.isEmpty()){
        	returnDto.setFlag(2);
        }else{
        	returnDto.setFlag(3);
        }
        returnDto.setResult(result.toString());
        return returnDto;
    }
    /**
     * 初版方法
    @Transactional
    public void batchInsertOrUpdate(List<PsiCarStockInfoEntity> datas) {
        //查询所有的库存车辆信息
        PsiCarStockInfoEntity stockInfoEntity = new PsiCarStockInfoEntity();
        stockInfoEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
        stockInfoEntity.setIsDelete(Constants.IsDelete.NO.value());
        List<PsiCarStockInfoEntity> usedStorageEntities = ipsiCarStockInfoDao.selectBySelective(stockInfoEntity);
        Map<String, PsiCarStockInfoEntity> carStockInfoMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(usedStorageEntities)){
            carStockInfoMap = usedStorageEntities.stream().collect(Collectors.toMap(p -> p.getVinCode(), p -> p));
        }
        //查询所有的仓储点信息
        SysCarUsedStorageEntity carUsedStorageEntity = new SysCarUsedStorageEntity();
        carUsedStorageEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
        carUsedStorageEntity.setIsDelete(Constants.IsDelete.NO.value());
        List<SysCarUsedStorageEntity> carUsedStorageEntities = iSysCarUsedStorageDao.selectBySelective(carUsedStorageEntity);
        Map<String, SysCarUsedStorageEntity> carUsedStorageMap = new HashMap<>();
        if(CollectionUtils.isNotEmpty(carUsedStorageEntities)){
            carUsedStorageMap = carUsedStorageEntities.stream().collect(Collectors.toMap(p -> p.getStorageCode(), p -> p));
        }
        List<PsiCarStockInfoEntity> insertList = new LinkedList<>();
        List<PsiCarStockInfoEntity> updateList = new LinkedList<>();
        Long userBy = AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
        for (PsiCarStockInfoEntity  item : datas) {
            if(carUsedStorageMap.containsKey(item.getStorageCode())){
                item.setStorageName(carUsedStorageMap.get(item.getStorageCode()).getStorageName());
                item.setStorageId(carUsedStorageMap.get(item.getStorageCode()).getStorageId());
            }
            if(carStockInfoMap.containsKey(item.getVinCode())){
                PsiCarStockInfoEntity carStockInfoEntity = carStockInfoMap.get(item.getVinCode());
                //更新
                carStockInfoEntity.setSourceBatch(item.getSourceBatch());
                carStockInfoEntity.setRevertBody(item.getRevertBody());
                carStockInfoEntity.setCarType(item.getCarType());
                carStockInfoEntity.setCarNature(item.getCarNature());
                carStockInfoEntity.setPurchasePrice(item.getPurchasePrice());
                carStockInfoEntity.setLicensePlace(item.getLicensePlace());
                carStockInfoEntity.setLicenseNumber(item.getLicenseNumber());
                carStockInfoEntity.setStorageCode(item.getStorageCode());
                carStockInfoEntity.setStorageName(item.getStorageName());
                carStockInfoEntity.setStorageId(item.getStorageId());
                carStockInfoEntity.setFirstLicenseDate(item.getFirstLicenseDate());
                carStockInfoEntity.setAccidentInsuranceEndDate(item.getAccidentInsuranceEndDate());
                carStockInfoEntity.setYearlyInspectionEndDate(item.getYearlyInspectionEndDate());
                carStockInfoEntity.setInvoicingDate(item.getInvoicingDate());
                carStockInfoEntity.setTransferCount(item.getTransferCount());
                carStockInfoEntity.setUpdatedDate(new Date());
                carStockInfoEntity.setUpdatedBy(userBy);
                updateList.add(carStockInfoEntity);
            }else{
                //新增
                item.setCarSource("导入车源");
                item.setStockType(Constants.STOCK_TYPE.OutletInventory.value());
                item.generatePk();
                item.setIsDelete(Constants.IsDelete.NO.value());
                item.setIsEnable(Constants.IsEnable.ENABLE.value());
                item.setRepealIs(Constants.IS_REPEAL.NO.value());
                //当车辆导入后，初始状态为在库待售
                item.setStockState(Constants.STOCK_STATUS.InStockForSale.value());
                item.setCreatedBy(userBy);
                item.setUpdatedBy(userBy);
                insertList.add(item);
            }
        }
        if(CollectionUtils.isNotEmpty(insertList)){
            ipsiCarStockInfoDao.batchInsert(insertList);
        }
        if(CollectionUtils.isNotEmpty(updateList)){
            ipsiCarStockInfoDao.batchUpdateSelective(updateList);
        }
    }**/

    @Override
	public PageInfo<CarStockInfoDto> findCarStockList(CarStockInfoListQueryDto stockInfoListQueryDto,Integer type) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<Long> storeIds = new ArrayList<>();
        if (2 == stockInfoListQueryDto.getOption()){
            storeIds = warehouseDao.selectOrgIdsByPartyId(user.getPartyId());
        }
        //tab选项卡类型1：
        //库存车辆列表  在库待售、整备中、待上架、在售中、已预订、已售出、退款待上架
        if(1 == type){
            stockInfoListQueryDto.setTabStockState(Constants.STOCK_STATUS.getStockTab());
            stockInfoListQueryDto.setRepealIs(Constants.IS_REPEAL.NO.value());
        }else if(2 == type){
            //2：作废车辆列表
            //已作废车辆
            stockInfoListQueryDto.setRepealIs(Constants.IS_REPEAL.YES.value());
        }else{
        	//3:APP端查询销售车辆
        	stockInfoListQueryDto.setRepealIs(Constants.IS_REPEAL.NO.value());
        	stockInfoListQueryDto.setTabStockState(Constants.STOCK_STATUS.getSaleTab());
        	stockInfoListQueryDto.setStockState(null);
        	stockInfoListQueryDto.setDecisionType("2303");//决策不为批售，包含零售和未决策
        }
        PageHelper.startPage(stockInfoListQueryDto.getPageNum(), stockInfoListQueryDto.getPageSize());
        stockInfoListQueryDto.setStoreIds(storeIds);
		List<CarStockInfoDto> sysPartnerDetailsOrders = psiCarStockInfoDao.selectCarStockList(stockInfoListQueryDto);
		LOGGER.info("====库存车辆===="+JsonBeanUtil.beanToJson(sysPartnerDetailsOrders));
		//计算:库龄=当前时间-入库时间
        // 车龄=当前时间-首次上牌时间
        for (CarStockInfoDto item : sysPartnerDetailsOrders) {
            if(null != item.getWarehousDate()){
                int days = (int) ((System.currentTimeMillis() - item.getWarehousDate().getTime()) / (1000*3600*24));
                item.setStockAge(days);
            }
            if(null != item.getFirstLicenseDate()){
                int days = (int) ((System.currentTimeMillis() - item.getFirstLicenseDate().getTime()) / (1000*3600*24));
                item.setCarAge(days);
            }
        }
		return new PageInfo<>(sysPartnerDetailsOrders);
	}

	@Override
	public PageInfo<CarStockInfoDto> findCarStockOutList(CarStockInfoListQueryDto stockInfoListQueryDto) {
		PageHelper.startPage(stockInfoListQueryDto.getPageNum(), stockInfoListQueryDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<Long> storeIds = new ArrayList<>();
        if (2 == stockInfoListQueryDto.getOption()){
            storeIds = warehouseDao.selectOrgIdsByPartyId(user.getPartyId());
        }
        stockInfoListQueryDto.setStoreIds(storeIds);
        List<CarStockInfoDto> sysPartnerDetailsOrders = psiCarStockInfoDao.selectCarStockOutList(stockInfoListQueryDto);
		if (com.alibaba.nacos.common.utils.CollectionUtils.isNotEmpty(sysPartnerDetailsOrders)){
			for (CarStockInfoDto stockInfoDto : sysPartnerDetailsOrders) {
				//库龄
				int stockDay  = 0 ;
                if (Objects.nonNull(stockInfoDto.getOutTime()) && Objects.nonNull(stockInfoDto.getWarehousDate())){
                    stockDay = (int) (( stockInfoDto.getOutTime().getTime()-stockInfoDto.getWarehousDate().getTime() ) /(1000*3600*24));
                }
				stockInfoDto.setStockAge(stockDay);
				//车龄
                int carDay = 0;
				Date date = new Date();
                if (Objects.nonNull(stockInfoDto.getFirstLicenseDate())){
                    carDay = (int) ( (date.getTime() - stockInfoDto.getFirstLicenseDate().getTime() ) / (1000*3600*24) );
                }
				stockInfoDto.setCarAge(carDay);
			}
		}
		return new PageInfo<>(sysPartnerDetailsOrders);
	}

	@Override
	public PageInfo<RightActivitiesSelectListDto> selectActivitiesList(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
        List<RightActivitiesSelectListDto> listDtos = rightActivitiesDao.selectActivitiesList();
        return new PageInfo<>(listDtos);
	}


	@Override
	public TransferApplyCarInfoDto findCarInfoByVinCode(String vinCode) {
		TransferApplyCarInfoDto applyCarInfoDto = psiCarStockInfoDao.findCarInfoByVinCode(vinCode);
        //手机号解密
        try {
            applyCarInfoDto.setManagerPhone(AesUtils.decryptHex(applyCarInfoDto.getManagerPhone(),ucmpAesConfig.getSecret()));
        } catch (Exception e) {
            e.printStackTrace();
        }
		return applyCarInfoDto;
	}

	@Transactional
	@Override
    public void saveSaleRecord(List<MultipartFile> files, CarSaleRecordInfoDto saleRecordInfoDto){
        LinkedList<FileReturnDto> filesList = new LinkedList<>();
        try{
            for (MultipartFile file: files) {
                String fileName = file.getOriginalFilename();
                if (!fileName.endsWith(".jpg") && !fileName.endsWith(".png")) {
                    throw new RuntimeException("文件格式错误,请重新选择 jpg 或 png 格式文件");
                }
                FileReturnDto upload = fileUploadService.upload(file);
                filesList.add(upload);
            }
        }catch (Exception e){
            LOGGER.error("[记录批售]上传收款凭证文件时报错",e);
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            throw new RuntimeException(e.getMessage());
        }
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<PsiCarSaleRecordEntity> insert = new ArrayList<>();
        List<PsiCarSaleRecordFileEntity> insertFile = new ArrayList<>();
        List<PsiCarStockInfoEntity> carStockInfoEntityList = new ArrayList<>();
        PsiCarSaleRecordEntity recordEntity;
        String[] split = saleRecordInfoDto.getSelectCarStockIds().split(",");
        for (String id : split) {
            PsiCarStockInfoEntity item = ipsiCarStockInfoDao.load(new PsiCarStockInfoPk(Long.parseLong(id)));
            //更新车辆状态为已售出
            item.setStockState(Constants.STOCK_STATUS.Sold.value());
            carStockInfoEntityList.add(item);
            recordEntity = Copiers.beanToBean(item, PsiCarStockInfoEntity.class, PsiCarSaleRecordEntity.class);

            recordEntity.setDeliverDate(saleRecordInfoDto.getDeliverDate());
            recordEntity.setPartnerName(saleRecordInfoDto.getPartnerName());
            recordEntity.setRemark(saleRecordInfoDto.getRemark());
            recordEntity.setWholesalePrice(item.getSalePrice());
            //生成单号
            recordEntity.setWholesaleNo(generatenNumber());
            recordEntity.setUpdatedBy(user.getPartyId());
            recordEntity.setUpdatedDate(new Date());
            recordEntity.generatePk();
            recordEntity.setCreatedBy(user.getPartyId());
            recordEntity.setCreatedDate(new Date());
            recordEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
            recordEntity.setIsDelete(Constants.IsDelete.NO.value());
            insert.add(recordEntity);
            //生成对应文件表对象
            int sort = 0;
            for (FileReturnDto fileItem :filesList) {
                sort ++;
                PsiCarSaleRecordFileEntity fileEntity = new PsiCarSaleRecordFileEntity();
                fileEntity.setSaleRecordId(recordEntity.getSaleRecordId());
                fileEntity.setFileId(fileItem.getFileId());
                fileEntity.setThumbnail(fileItem.getThumbnailFile());
                fileEntity.setFileOrder(sort);
                fileEntity.setUpdatedBy(user.getPartyId());
                fileEntity.setUpdatedDate(new Date());
                fileEntity.setCreatedDate(new Date());
                fileEntity.generatePk();
                fileEntity.setCreatedBy(user.getPartyId());
                insertFile.add(fileEntity);
            }

        }

        //统一新增
        if(CollectionUtils.isNotEmpty(insert)){
            iPsiCarSaleRecordDao.batchInsert(insert);
        }
        //统一新增
        if(CollectionUtils.isNotEmpty(insertFile)){
            iPsiCarRecordFileDao.batchInsert(insertFile);
        }
        //同时更新车辆状态为已售出
        if(CollectionUtils.isNotEmpty(carStockInfoEntityList)){
            ipsiCarStockInfoDao.batchUpdateSelective(carStockInfoEntityList);
        }

    }

    /**
     * 车辆销售定价修改(记录批售方接口)
     * @param carStockInfoList
     */
    @Override
    public void updateSalePrices(List<CarStockInfoDto> carStockInfoList) {
        PsiCarStockInfoEntity carStockInfoEntity;
        List<PsiCarStockInfoEntity> list = new ArrayList<>();
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        for (CarStockInfoDto item : carStockInfoList) {
            if(! Objects.isNull(item.getSalePrice())){
                carStockInfoEntity = Copiers.beanToBean(item, CarStockInfoDto.class, PsiCarStockInfoEntity.class);
                carStockInfoEntity.setUpdatedDate(new Date());
                carStockInfoEntity.setUpdatedBy(user.getPartyId());
                list.add(carStockInfoEntity);
            }
        }
        if(CollectionUtils.isNotEmpty(list)){
            ipsiCarStockInfoDao.batchUpdateSelective(list);
        }

    }

    @Override
    public void carVoid(Long stockId,String repealReason) {
        PsiCarStockInfoEntity load = ipsiCarStockInfoDao.load(new PsiCarStockInfoPk(stockId));
        load.setRepealIs(Constants.IS_REPEAL.YES.value());
        load.setRepealReason(repealReason);
        load.setRepealDate(new Date());
        ipsiCarStockInfoDao.updateSelective(load);

    }

    @Override
    public CarSaleRecordDetailsDto getSaleRecordInfo(Long stockId) {
        PsiCarSaleRecordEntity recordEntity = new PsiCarSaleRecordEntity();
        recordEntity.setStockId(stockId);
        List<PsiCarSaleRecordEntity> recordEntities = iPsiCarSaleRecordDao.selectBySelective(recordEntity);
        if(CollectionUtils.isEmpty(recordEntities)){
            LOGGER.error("[记录批售]没有找到对应的批售记录!stockId:{}",stockId);
            throw new RuntimeException("没有找到对应的批售记录!");
        }
        PsiCarSaleRecordEntity saleRecordEntity = recordEntities.get(0);
        CarSaleRecordDetailsDto recordDetailsDto = Copiers.beanToBean(saleRecordEntity, PsiCarSaleRecordEntity.class, CarSaleRecordDetailsDto.class);
        //查询对应的收款凭证文件
        List<FileReturnDto> fileReturnDtos = psiCarFileDao.selectSaleRecordFile(saleRecordEntity.getSaleRecordId());
        recordDetailsDto.setVoucherFiles(fileReturnDtos);
        return recordDetailsDto;
    }

    @Override
    public void updateDecisionType(Long stockId, String decisionType) {
        PsiCarStockInfoEntity stockInfoEntity = new PsiCarStockInfoEntity();
        stockInfoEntity.setStockId(stockId);
        stockInfoEntity.setDecisionType(decisionType);
        stockInfoEntity.setDecisionTime(new Date());
        ipsiCarStockInfoDao.updateSelective(stockInfoEntity);
    }

    @Override
    public void updateBaseStockInfo(CarStockBaseInfoDto carStockInfo) {
        PsiCarStockInfoEntity infoEntity = Copiers.beanToBean(carStockInfo, CarStockBaseInfoDto.class, PsiCarStockInfoEntity.class);
        if(carStockInfo.getStorageId() !=null){
        	SysCarUsedStorageEntity sysCarUsedStorageEntity = this.iSysCarUsedStorageDao.load(new SysCarUsedStoragePk(carStockInfo.getStorageId()));
        	infoEntity.setStorageCode(sysCarUsedStorageEntity.getStorageCode());
        	infoEntity.setStorageName(sysCarUsedStorageEntity.getStorageName());
        }
        if(!StringUtil.isEmpty(carStockInfo.getBatteryCapacity())){
        	infoEntity.setBatteryCapacity(Double.parseDouble(carStockInfo.getBatteryCapacity()));
        }
        ipsiCarStockInfoDao.updateSelective(infoEntity);
    }

    @Override
    public void uploadFormwork(MultipartFile file) {
        try {
            fileUploadService.uploadFormwork(file,Long.valueOf("999"));
        }catch (Exception e){
            LOGGER.error("上传导入模板文件失败!");
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            throw new RuntimeException(e.getMessage());
        }
    }


    private  String generatenNumber(){
        Long codeIncr = redissonCache.incrBy("wholesale:no", 1L);
        String code = String.format("%04d", codeIncr);
        if (codeIncr == 1){
            redissonCache.expire("wholesale:no", TimeUnit.HOURS,24L);
        }
        String campaignCode = new SimpleDateFormat("yyyyMMdd").format(new Date()).concat(code);
        campaignCode = "PS" + campaignCode;
        return  campaignCode;
    }


	@Override
	public List<String> findProductCodeList() {
		return this.psiCarStockInfoDao.findProductCodeList();
	}


	@Override
	@Transactional
	public void updateSalePrice(CarSalePriceDto carSalePriceDto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		carSalePriceDto.setPartyId(user.getPartyId());
		//11月29日 业务要求先不上改价审批
		//获取车辆定价
		DiscountBasicDto discountBasicDto = this.psiPricingServiceImpl.carPricing(carSalePriceDto.getStockId());
		//计算建议价
		Double suggestedPrice = Double.parseDouble(discountBasicDto.getSuggestedPrice());
		Double maintenanceDiscount = null;
		Double useNatureDiscount = null;
		if(!StringUtil.isEmpty(carSalePriceDto.getMaintenanceType())){
			for (MaintenanceDto maintenanceDto : discountBasicDto.getMaintenanceDtos()) {
				if(maintenanceDto.getType().equals(carSalePriceDto.getMaintenanceType())){
					maintenanceDiscount= Double.parseDouble(maintenanceDto.getAmount());
					break;
				}
			}
			if(maintenanceDiscount == null){
				throw new Exception("维修折扣类型不存在");
			}
		}
		if(!StringUtil.isEmpty(carSalePriceDto.getUseNatureType())){
			for (UseNatureDto useNatureDto : discountBasicDto.getUseNatureDtos()) {
				if(useNatureDto.getType().equals(carSalePriceDto.getUseNatureType())){
					useNatureDiscount= Double.parseDouble(useNatureDto.getAmount());
					break;
				}
			}
			if(useNatureDiscount == null){
				throw new Exception("运营性质折扣类型不存在");
			}
		}
		if(maintenanceDiscount == null){
			maintenanceDiscount=0.0;
		}
		if(useNatureDiscount == null){
			useNatureDiscount=0.0;
		}
		suggestedPrice = suggestedPrice -maintenanceDiscount-useNatureDiscount;
		LOGGER.info("====建议价==="+suggestedPrice);
		LOGGER.info("====对比值==="+suggestedPrice.compareTo(carSalePriceDto.getSalePrice()));
		//销售定价大于等于建议价时直接更新销售定价
		if(suggestedPrice.compareTo(carSalePriceDto.getSalePrice())<=0){
			this.psiCarStockInfoDao.updateSalePrice(carSalePriceDto);
			//插入定价记录
            PsiPricingJournalEntity psiPricingJournalEntity = new PsiPricingJournalEntity();
            psiPricingJournalEntity.generatePk();
            psiPricingJournalEntity.setVhclId(carSalePriceDto.getStockId());
            psiPricingJournalEntity.setCreateName(user.getLoginName());
            psiPricingJournalEntity.setCreateBy(user.getPartyId());
            psiPricingJournalEntity.setCreateDate(new Date());
            psiPricingJournalEntity.setPricingAmount(new BigDecimal(carSalePriceDto.getSalePrice()));
            journalDao.insert(psiPricingJournalEntity);
		//销售定价小于建议价时需要审批
		}else{
			//查询是否存在待审批的改价申请
			DiscountBasicDto ddto = this.iPsiCarStockInfoDao.queryChangePriceInfo(carSalePriceDto.getStockId());
			if(ddto !=null && ddto.getApproveStatus()==0){
				throw new Exception("存在未审批改价申请");
			}
			
			if(carSalePriceDto.getCurSalePrice() == null || carSalePriceDto.getCurSalePrice() <=0 ){
				throw new Exception("销售定价小于建议价,当前价格不可为空或0");
			}
			
			if(carSalePriceDto.getSalePrice() == null ||carSalePriceDto.getSalePrice()<=0){
				throw new Exception("销售定价小于建议价,修改后价格不可为空或0");
			}
			
			if(StringUtil.isEmpty(carSalePriceDto.getChangeReason())){
				throw new Exception("销售定价小于建议价,改价原因不可为空");
			}
			
			if(StringUtil.isEmpty(carSalePriceDto.getOaCode())){
				throw new Exception("销售定价小于建议价,OA编号不可为空");
			}
			//添加改价审批申请
			ChangePriceParamDto paramDto = new ChangePriceParamDto();
			paramDto.setRecordId(RandomIDGennerator.get().generate());
			paramDto.setStockId(carSalePriceDto.getStockId());
			paramDto.setCurPrice(carSalePriceDto.getCurSalePrice());
			paramDto.setSuggestedPrice(suggestedPrice);
			paramDto.setChangePrice(carSalePriceDto.getSalePrice());
			paramDto.setChangeReason(carSalePriceDto.getChangeReason());
			paramDto.setOaCode(carSalePriceDto.getOaCode());
			paramDto.setApproveStatus(0);
			paramDto.setCreatedBy(user.getPartyId());
			paramDto.setUpdatedBy(user.getPartyId());
			this.psiCarStockInfoDao.addChangePriceRecord(paramDto);
			
			//库存车辆表添加改价记录id
			this.psiCarStockInfoDao.updateCarStockInfo(paramDto);
			//添加改价凭证
			if(CollectionUtil.isNotEmpty(carSalePriceDto.getProofMaterials())){
				carSalePriceDto.getProofMaterials().forEach(dto ->{
					dto.setRecordId(paramDto.getRecordId());
					dto.setPartyId(user.getPartyId());
				});
				this.psiRetentionDao.addChangPriceFile(carSalePriceDto.getProofMaterials());
			}
		}
		
	}

	@Override
	public PageInfo<QueryChangePriceDto> queryChangePriceApproveList(QueryChangePriceParamDto paramDto) throws ParseException {
		PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
		List<QueryChangePriceDto> list=this.psiCarStockInfoDao.queryChangePriceApproveList(paramDto);
		for (QueryChangePriceDto item : list) {
			SimpleDateFormat form =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if(null != item.getWarehousDate()){
                int days = (int) ((System.currentTimeMillis() - form.parse(item.getWarehousDate()).getTime()) / (1000*3600*24));
                item.setStockAge(days);
            }
            if(null != item.getFirstLicenseDate()){
                int days = (int) ((System.currentTimeMillis() - form.parse(item.getFirstLicenseDate()).getTime()) / (1000*3600*24));
                item.setCarAge(days);
            }
        }
		return new PageInfo<>(list);
	}


	@Override
	public ChangePriceDetailDto queryChangePriceApproveDetail(Long stockId, Long recordId) {
		ChangePriceDetailDto detailDto = new ChangePriceDetailDto();
		//查询车辆基本信息
		CarMainInfoDto carCurDto=this.psiCarStockInfoDao.getCarInfoByVin(stockId);
		detailDto.setCarMainInfoDto(carCurDto);
		//查询改价信息
		OrderChangePriceDto orderChangePriceDto = this.psiCarStockInfoDao.queryChangePriceInfo(recordId,stockId);
		if(orderChangePriceDto !=null ){
			//查询改价材料
        	List<OrderChangeFileDto> fileList = this.psiCarStockInfoDao.queryFileList(recordId);
        	this.appendUrl(fileList);
        	orderChangePriceDto.setFileList(fileList);
		}
		detailDto.setOrderChangePriceDto(orderChangePriceDto);
		return detailDto;
	}
	
	private void appendUrl(List<OrderChangeFileDto> picDtoList) {
		if(picDtoList != null && !picDtoList.isEmpty()){
			for (OrderChangeFileDto oneselfCarPicDto : picDtoList) {
				oneselfCarPicDto.setFileUrl(hwOBSConfig.getFileUri()+oneselfCarPicDto.getFileUrl());
			}
		}
	}


	@Override
	@Transactional
	public void queryChangePriceApprove(ApproveChangePriceDto paramDto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		paramDto.setUpdateBy(user.getPartyId());
		if(paramDto.getApproveStatus()==2 && StringUtil.isEmpty(paramDto.getRejectReason())){
			throw new Exception("审核驳回时，驳回原因不能为空");
		}
		
		if(paramDto.getApproveStatus()==null||paramDto.getApproveStatus()<=0||paramDto.getApproveStatus()>2){
			throw new Exception("请选择审批结果");
		}
		//查询改价信息
		OrderChangePriceDto orderChangePriceDto = this.psiCarStockInfoDao.queryChangePriceInfo(paramDto.getRecordId(),null);
		//修改改价记录
		this.psiCarStockInfoDao.updateChangeRecordInfo(paramDto);
		if(paramDto.getApproveStatus()==1){
			//查询订单改价记录id
			Long orderRecordId = this.psiCarStockInfoDao.queryOrderRecordId(paramDto.getRecordId());
			if(orderRecordId != null){
				//启用订单改价记录
				this.psiRetentionDao.updateChangPriceRecord(orderRecordId);
				//查询订单id
				Long orderId = this.psiRetentionDao.queryOrderId(orderRecordId);
				orderChangePriceDto.setOrderInfoId(orderId);
				orderChangePriceDto.setPartyId(user.getPartyId());
				//变更订单价格
				this.psiRetentionDao.changeOrderPrice(orderChangePriceDto);
			}
			//变更库存车辆销售定价
			CarSalePriceDto carSalePriceDto=new CarSalePriceDto(); 
			carSalePriceDto.setSalePrice(orderChangePriceDto.getNewPrice());
			carSalePriceDto.setPartyId(user.getPartyId());
			carSalePriceDto.setStockId(orderChangePriceDto.getStockId());
			carSalePriceDto.setOaCode(orderChangePriceDto.getOaCode());
			this.psiCarStockInfoDao.updateSalePrice(carSalePriceDto);
		}
	}
	
	public static void main(String[] args) {
		LOGGER.info("===="+RandomIDGennerator.get().generate());
	}
}
