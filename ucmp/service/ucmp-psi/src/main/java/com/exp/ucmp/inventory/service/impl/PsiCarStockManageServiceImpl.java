package com.exp.ucmp.inventory.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.clues.dto.OrderChangePriceDto;
import com.exp.ucmp.config.HwOBSConfig;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.inventory.dao.StockInfoDao;
import com.exp.ucmp.inventory.service.PsiCarStockManageService;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiCarStockInfoPk;
import com.exp.ucmp.pricing.retail.DiscountBasicDto;
import com.exp.ucmp.stock.dto.*;
import com.exp.ucmp.storeApp.dao.AllocationStateDao;
import com.exp.ucmp.storeApp.dao.ExpenseListDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author zhouchengwei
 * @date 2022年09月22日
 */
@Service
public class PsiCarStockManageServiceImpl implements PsiCarStockManageService {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PsiCarStockManageServiceImpl.class);

    @Autowired
    private IPsiCarStockHistoryDao iPsiCarStockHistoryDao;
    @Autowired
    private AllocationStateDao allocationStateDao;
    @Autowired
    private ExpenseListDao expenseListDao;
    @Autowired
    private IPsiCarCostInfoDao carCostInfoDao;
    @Autowired
    private StockInfoDao stockInfoDao;
    @Autowired
    private IPsiCarStockInfoDao iPsiCarStockInfoDao;
    @Autowired
    private IPsiCarServiceInfoDao iPsiCarServiceInfoDao;
    @Autowired
    private IPsiMainteanceItemsDao mainteanceItemsDao;
    @Autowired
    private IPsiCarOptionInfoDao carOptionInfoDao;
    @Autowired
    private HwOBSConfig hwOBSConfig;

    @Value("${adapter.authUrl}")
    private String url;



    /**
     * 根据库存车辆id查询出入库历史
     *
     * @param stockId
     * @return
     */
    @Override
    public List<StockHistoryDto> queryStockHistory(Long stockId) {
        PsiCarStockHistoryEntity psiCarStockHistoryEntity = new PsiCarStockHistoryEntity();
        List<StockHistoryDto> dtoList = new ArrayList<>();
        psiCarStockHistoryEntity.setStockId(stockId);
        List<PsiCarStockHistoryEntity> list = iPsiCarStockHistoryDao.selectBySelective(psiCarStockHistoryEntity);
        for (PsiCarStockHistoryEntity entity : list) {
            StockHistoryDto stockHistoryDto = new StockHistoryDto();
            stockHistoryDto =
                    Copiers.beanToBean(entity, PsiCarStockHistoryEntity.class, StockHistoryDto.class);
            dtoList.add(stockHistoryDto);
        }
        return dtoList;
    }

    /**
     * 查询调拨状态信息
     *
     * @param applyId
     * @return
     */
    @Override
    public AllocationStateDto queryAllocationState(String param, String type) {
        AllocationStateDto allocationStateDto = allocationStateDao.queryAllocationState(param, type);
        if (Objects.isNull(allocationStateDto)) {
            return null;
        }
        //获取到达城市信息
        List<Map<String, Object>> list = allocationStateDao.getArriveCity(allocationStateDto.getDispatchInfoId());
        LOGGER.info("==获取到达城市信息==="+JsonBeanUtil.beanToJson(list));
        if (CollectionUtil.isNotEmpty(list)) {
            allocationStateDto.setArriveCityOne((String) list.get(0).get("currentAddress"));
            allocationStateDto.setArriveTimeOne(list.get(0).get("recordTime").toString());
            if (list.size() > 1) {
                allocationStateDto.setArriveCityTwo((String) list.get(1).get("currentAddress"));
                allocationStateDto.setArriveTimeTwo(list.get(1).get("recordTime").toString());
            }
        }
        return allocationStateDto;
    }

    /**
     * 查询车辆费用清单列表
     *
     * @param vin
     * @return
     */
    @Override
    public ExpenseListDto queryExpenseList(String vin) {
        return expenseListDao.queryExpenseList(vin);
    }

    /**
     * 保存车辆费用信息
     *
     * @param paramDto
     * @return
     */
    @Override
    public String saveExpenseCost(SaveExpenseCostParamDto paramDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiCarCostInfoEntity psiCarCostInfoEntity = new PsiCarCostInfoEntity();
        psiCarCostInfoEntity.setStockId(paramDto.getStockId());
        List<PsiCarCostInfoEntity> list = carCostInfoDao.selectBySelective(psiCarCostInfoEntity);
        psiCarCostInfoEntity =
                Copiers.beanToBean(paramDto, SaveExpenseCostParamDto.class, PsiCarCostInfoEntity.class);
        if (CollectionUtil.isNotEmpty(list) && list.size() > 0) {
            psiCarCostInfoEntity.setCostInfoId(list.get(0).getCostInfoId());
            psiCarCostInfoEntity.setUpdatedBy(user.getPartyId());
            psiCarCostInfoEntity.setUpdatedDate(new Date());
            carCostInfoDao.updateSelective(psiCarCostInfoEntity);
        } else {
            psiCarCostInfoEntity.setCreatedBy(user.getPartyId());
            psiCarCostInfoEntity.setCreatedDate(new Date());
            psiCarCostInfoEntity.setUpdatedBy(user.getPartyId());
            psiCarCostInfoEntity.setUpdatedDate(new Date());
            carCostInfoDao.insertSelective(psiCarCostInfoEntity);
        }
        return "保存成功";
    }

    /*    *//**
     * 导出费用清单列表
     *
     * @param expenseListParamDto
     *//*
    @Override
    public void expenseListExport(ExpenseListParamDto expenseListParamDto, HttpServletResponse response) throws IOException {
        List<ExpenseListDto> expenseListDtos = expenseListDao.queryExpenseList(expenseListParamDto);
        EasyExcelUtils.webWriteExcel(response, expenseListDtos, ExpenseListDto.class, "车辆费用清单.xlsx");
    }*/

    /**
     * 查询车辆仓储信息
     */
    @Override
    public CarStorageInfoDto queryStockInfo(Long stockId) {
        CarStorageInfoDto carStorageInfoDto = stockInfoDao.queryStockInfo(stockId);
        return carStorageInfoDto;
    }


    /**
     * 查询车辆仓储信息
     */
    @Override
    public CarStockBasicInfoDto queryStockBasicInfo(Long stockId,String vin) {
        CarStockBasicInfoDto carStorageInfoDto = stockInfoDao.queryStockBasicInfo(stockId,vin);
        if(Objects.isNull(carStorageInfoDto)){
            //vin查询，已售出查询不到，直接返回
            return carStorageInfoDto;
        }
        carStorageInfoDto.setVin(UcmpAesConfig.dataMask(carStorageInfoDto.getVin(), 3, 14, "***********"));
        //查询检测报告URL
        List<String> testReportUrl=this.stockInfoDao.queryTestReportUrl(carStorageInfoDto.getStockId());
        if(CollectionUtil.isNotEmpty(testReportUrl)){
        	carStorageInfoDto.setTestReportUrl(hwOBSConfig.getFileUri()+testReportUrl.get(0));
        }
        return carStorageInfoDto;
    }

    /**
     * 查询车辆流转信息
     */
    @Override
    public CarStatusFlowDto queryCarStatusFlow(Long stockId) throws Exception {
//        整备按目前，点击整备完成后，就显示整备完成
//        素材审批，总部人员上传完必传图片就显示审批通过
//        维修话术，根据实际情况展示待调整、已调整
//        定价上架，显示上架时间
        CarStatusFlowDto statusFlowDto = new CarStatusFlowDto();
        //        入库
        PsiCarStockInfoEntity load = iPsiCarStockInfoDao.load(new PsiCarStockInfoPk(stockId));
        statusFlowDto.setStockType(load.getStockType());
        statusFlowDto.setWarehousDate(load.getWarehousDate());
        statusFlowDto.setCarSource(load.getCarSource());
        statusFlowDto.setStockState(load.getStockState());
        //        决策
        if (Objects.nonNull(load.getDecisionType())) {
            statusFlowDto.setDecisionType(load.getDecisionType());
        }
        if (Objects.nonNull(load.getDecisionTime())) {
            statusFlowDto.setDecisionTime(load.getDecisionTime());
        }
        //整备
        if(Arrays.asList("5103", "5104", "5105", "5106", "5107").contains(load.getStockState())){
            statusFlowDto.setServiceStart("01");
            statusFlowDto.setStartDate(load.getServiceTime());
        }
        //素材
        if(Arrays.asList("5104", "5105", "5106", "5107").contains(load.getStockState())){
            statusFlowDto.setApprovalDate(load.getGroundingTime());
        }
        //维修话术
        if(Arrays.asList("5103","5104","5105","5107").contains(load.getStockState())){
            statusFlowDto.setIsRepair("1");
        }
        if(Objects.equals("5106",load.getStockState())){
            statusFlowDto.setIsRepair("0");
        }
        List<SaveMaintenceParamDto> saveMaintenceParamDtos = stockInfoDao.queryAdjustMainteanceList(load.getStockId(), null, null, null);
        if(CollectionUtil.isNotEmpty(saveMaintenceParamDtos)){
            String maintainTime = saveMaintenceParamDtos.stream().min(Comparator.comparing(SaveMaintenceParamDto::getMaintainTime)).get().getMaintainTime();
            statusFlowDto.setUpdatedDate(new SimpleDateFormat("yyyy-MM-dd").parse(maintainTime));
        }
        //定价上架
        statusFlowDto.setGroundingDate(load.getGroundingTime());
        /*
        //        整备
        发起整备
        PsiCarServiceInfoEntity carServiceInfo = stockInfoDao.selectBySelective(stockId);
        if (Objects.nonNull(carServiceInfo)) {
            if (Objects.nonNull(carServiceInfo.getServiceState())) {
                statusFlowDto.setServiceStart(carServiceInfo.getServiceState());
            }
            if (Objects.nonNull(carServiceInfo.getStartDate())) {
                statusFlowDto.setStartDate(carServiceInfo.getStartDate());
            }
            if (Objects.nonNull(carServiceInfo.getApprovalResult())) {
                statusFlowDto.setApprovalResult(carServiceInfo.getApprovalResult());
            }
            if (Objects.nonNull(carServiceInfo.getApprovalDate())) {
                statusFlowDto.setApprovalDate(carServiceInfo.getApprovalDate());
            }
            if (Objects.nonNull(load.getGroundingTime())) {
                statusFlowDto.setGroundingDate(load.getGroundingTime());
            }
            //        维修话术调整
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String repairTime = stockInfoDao.selectRepairTime(carServiceInfo.getServiceId());
            if (StringUtils.isNotBlank(repairTime)){
                try {
                    statusFlowDto.setUpdatedDate(sdf.parse(repairTime));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
            if (StringUtils.isNotBlank(repairTime) && Constants.SERVICE_STATE.PASS.value().equals(carServiceInfo.getServiceState())){
                statusFlowDto.setIsRepair("0");
            }if (StringUtils.isNotBlank(repairTime) && !Constants.SERVICE_STATE.PASS.value().equals(carServiceInfo.getServiceState()) ){
                statusFlowDto.setIsRepair("1");
            }
        }
        */
        //        定价上架
        return statusFlowDto;
    }

    @Override
    public List<CarServiceFileDto> queryCarServicingPic(Long stockId, String type,Long serviceId) {
        List<CarServiceFileDto> list = new ArrayList<>();
        List<CarServiceFileDto> fileDtos= stockInfoDao.queryFile(serviceId, type,stockId);
        if (CollectionUtil.isNotEmpty(fileDtos)) {
            for (CarServiceFileDto fileDto : fileDtos) {
                fileDto.setDetailDtos(stockInfoDao.queryFileDetail(fileDto.getMaterialId()));
                list.add(fileDto);
            }
        }
        return list;
    }

    @Override
    public boolean retailLoading(RetailLoadingDto retailLoadingDto) throws Exception {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        //上架
        if ("on".equals(retailLoadingDto.getStatus())) {
        	//查询销售定价是否为空
        	Double salePrice= this.iPsiCarStockInfoDao.queryCarSalePrice(retailLoadingDto.getStockId());
        	if(salePrice == null){
        		throw new Exception("车辆还未定价");
        	}
        	//查询是否存在待审批的改价申请
    		DiscountBasicDto discountBasicDto = this.iPsiCarStockInfoDao.queryChangePriceInfo(retailLoadingDto.getStockId());
    		if(discountBasicDto !=null && discountBasicDto.getApproveStatus()==0){
    			throw new Exception("存在未审批改价申请");
    		}
            //    车辆状态变为在售中
            PsiCarStockInfoEntity stockInfoEntity = new PsiCarStockInfoEntity();
            stockInfoEntity.setRightPackId(retailLoadingDto.getRightPackId());
//            stockInfoEntity.setSalePrice(new BigDecimal(retailLoadingDto.getSalePrice()));
            stockInfoEntity.setStockId(retailLoadingDto.getStockId());
            stockInfoEntity.setStockState(Constants.STOCK_STATUS.ONSALE.value());
            stockInfoEntity.setGroundingTime(new Date());
            stockInfoEntity.setUpdatedBy(user.getPartyId());
            stockInfoEntity.setUpdatedDate(new Date());
            int i = iPsiCarStockInfoDao.updateSelective(stockInfoEntity);
            if ( i > 0) {
                return true;
            }
        }
        //下架
        if ("off".equals(retailLoadingDto.getStatus())) {
            //    车辆状态变为待上架
            PsiCarStockInfoEntity stockInfoEntity = new PsiCarStockInfoEntity();
            stockInfoEntity.setStockId(retailLoadingDto.getStockId());
            stockInfoEntity.setStockState(Constants.STOCK_STATUS.WAIT_PUT.value());
            stockInfoEntity.setUpdatedBy(user.getPartyId());
            stockInfoEntity.setUpdatedDate(new Date());
            int i = iPsiCarStockInfoDao.updateSelective(stockInfoEntity);
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 整备完成车辆列表
     *
     * @param paramDto
     * @return
     */
    @Override
    public PageInfo<ServicingCompletedDto> queryServicingCompletedList(ServicingCompletedParamDto paramDto) {
        PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
        List<ServicingCompletedDto> list = stockInfoDao.queryServicingCompletedList(paramDto);
        return new PageInfo<>(list);
    }

    /**
     * 查询维修项目信息
     *
     * @param paramDto
     * @return
     */
    @Override
    public PageInfo<MaintenceListDto> queryMainteanceList(MaintenceParamDto paramDto) {
        PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
        List<MaintenceListDto> list = stockInfoDao.queryMainteanceList(paramDto);
        return new PageInfo<>(list);
    }

    /**
     * 维修项目信息保存
     *
     * @param paramDtoList
     * @return
     * @throws ParseException 
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveMaintenceInfo(List<QueryMaintenceResultDto> paramDtoList) throws ParseException {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        //先删除
        PsiMainteanceItemsEntity deleteParam = new PsiMainteanceItemsEntity();
        deleteParam.setStockId(paramDtoList.get(0).getStockId());
        mainteanceItemsDao.deleteBySelective(deleteParam);
//        for (QueryMaintenceResultDto paramDto : paramDtoList) {
//            PsiMainteanceItemsEntity deleteParam = new PsiMainteanceItemsEntity();
//            deleteParam.setStockId(paramDto.getStockId());
////            deleteParam.setMaintainType(paramDto.getData().get(0).getList().get(0).getMaintainType());
//            mainteanceItemsDao.deleteBySelective(deleteParam);
//        }
        //再插入
        for (QueryMaintenceResultDto paramDto : paramDtoList) {
            if(CollectionUtil.isEmpty(paramDto.getData())){
                continue;
            }
            for (QueryMaintenceDto queryMaintenceDto : paramDto.getData()) {
				for (SaveMaintenceParamDto saveMaintenceParamDto : queryMaintenceDto.getList()) {
					PsiMainteanceItemsEntity entity = Copiers.beanToBean(saveMaintenceParamDto, SaveMaintenceParamDto.class, PsiMainteanceItemsEntity.class);
					entity.generatePk();
					entity.setMaintainTime(new SimpleDateFormat("yyyy-MM-dd").parse(saveMaintenceParamDto.getMaintainTime()));
					entity.setCreatedBy(user.getPartyId());
					entity.setCreatedDate(new Date());
					mainteanceItemsDao.insertSelective(entity);
				}
			}
		}
    }


    /**
     * 获取已调整的维修项目信息
     *
     * @param vin
     * @param type
     * @return
     */
    @Override
    public List<QueryMaintenceResultDto> queryAdjustMainteanceList(Long stockId,String vin, String type) {
    	List<QueryMaintenceResultDto> list;
        if ("1".equals(type)) {
        	//维修工单项目
        	//查询费用类型
        	 list = this.stockInfoDao.getCollectFees();
        	for (QueryMaintenceResultDto queryMaintenceResultDto : list) {
        		List<SaveMaintenceParamDto> queryList = stockInfoDao.queryAdjustMainteanceList(stockId,vin, type, queryMaintenceResultDto.getCollectFees());
        		if (CollectionUtil.isNotEmpty(queryList)) {
        			//过滤日期
        			List<String> collect = queryList.stream().map(SaveMaintenceParamDto::getTimes).distinct().collect(Collectors.toList());
        			List<QueryMaintenceDto> data = new ArrayList<>();
        			for (String o : collect) {
        				QueryMaintenceDto one = new QueryMaintenceDto();
        				//过滤数据
        				List<SaveMaintenceParamDto> oneList = queryList.stream().filter(x -> x.getTimes().equals(o)).collect(Collectors.toList());
        				one.setTimes(o);
        				one.setList(oneList);
        				data.add(one);
        			}
                    queryMaintenceResultDto.setStockId(stockId);
        			queryMaintenceResultDto.setData(data); 
        		}
        	}
        } else {
        	list=new ArrayList<>();
            //整备工单项目
            List<SaveMaintenceParamDto> listThree = stockInfoDao.queryAdjustMainteanceList(stockId,vin, type, null);
            if (CollectionUtil.isNotEmpty(listThree)) {
            	//整备工单项目不区分费用类型 
            	QueryMaintenceResultDto resultDto = new QueryMaintenceResultDto();
            	//过滤日期
                List<String> collect = listThree.stream().map(SaveMaintenceParamDto::getTimes).distinct().collect(Collectors.toList());
                
                List<QueryMaintenceDto> data = new ArrayList<>();
                for (String o : collect) {
                	QueryMaintenceDto three = new QueryMaintenceDto();
                    List<SaveMaintenceParamDto> threeList = listThree.stream().filter(x -> x.getTimes().equals(o)).collect(Collectors.toList());
                    three.setTimes(o);
                    three.setList(threeList);
                    data.add(three);
                }
                resultDto.setStockId(stockId);
                resultDto.setData(data); 
                list.add(resultDto);
            }
        }
        return list;
    }

    /**
     * 查询车辆历史维修信息
     *
     * @param vin
     * @return
     */
    @Override
    public List<MaintenceRecordDto> queryHisMaintenanceList(Long stockId,String vin) {
    	List<MaintenceRecordDto> resultList=new ArrayList<>();
    	List<QueryMaintenceResultDto>  collectFeesList = this.stockInfoDao.getCollectFees();
    	
    	MaintenceRecordDto dtoOne=new MaintenceRecordDto();
    	dtoOne.setType("001");
    	dtoOne.setTypeName("车辆维修历史");
    	//维修工单项目
        for (QueryMaintenceResultDto queryMaintenceResultDto : collectFeesList) {
        	LOGGER.info("======queryMaintenceResultDto===="+JsonBeanUtil.beanToJson(queryMaintenceResultDto));
        	List<SaveMaintenceParamDto> listOne = stockInfoDao.queryAdjustMainteanceList(stockId,vin, "1", queryMaintenceResultDto.getCollectFees());
        	LOGGER.info("======listOne===="+JsonBeanUtil.beanToJson(listOne));
        	if (CollectionUtil.isNotEmpty(listOne)) {
        		List<String> collect = listOne.stream().map(SaveMaintenceParamDto::getTimes).distinct().collect(Collectors.toList());
        		List<QueryMaintenceDto> data = new ArrayList<>();
        		for (String o : collect) {
        			QueryMaintenceDto one = new QueryMaintenceDto();
        			List<SaveMaintenceParamDto> oneList = listOne.stream().filter(x -> x.getTimes().equals(o)).collect(Collectors.toList());
        			one.setTimes(o);
        			one.setList(oneList);
        			data.add(one);
        		}
        		LOGGER.info("======data===="+JsonBeanUtil.beanToJson(data));
        		queryMaintenceResultDto.setData(data);
        	}
		}
        LOGGER.info("======collectFeesList===="+JsonBeanUtil.beanToJson(collectFeesList));
        dtoOne.setData(collectFeesList);
        LOGGER.info("======dtoOne===="+JsonBeanUtil.beanToJson(dtoOne));
        resultList.add(dtoOne);
        //整备工单项目
        MaintenceRecordDto dtoTwo=new MaintenceRecordDto();
        dtoTwo.setType("002");
        dtoTwo.setTypeName("官方二手车整备");
        List<QueryMaintenceResultDto>  collectFeesListTwo = new ArrayList<>(); 
        QueryMaintenceResultDto collectFees = new QueryMaintenceResultDto();
        List<SaveMaintenceParamDto> listThree = stockInfoDao.queryAdjustMainteanceList(stockId,vin, "2", null);
        if (CollectionUtil.isNotEmpty(listThree)) {
            List<String> collect = listThree.stream().map(SaveMaintenceParamDto::getTimes).distinct().collect(Collectors.toList());
            List<QueryMaintenceDto> data = new ArrayList<>();
            for (String o : collect) {
            	QueryMaintenceDto three = new QueryMaintenceDto();
                List<SaveMaintenceParamDto> threeList = listThree.stream().filter(x -> x.getTimes().equals(o)).collect(Collectors.toList());
                three.setTimes(o);
                three.setList(threeList);
                data.add(three);
            }
            collectFees.setData(data);
        }
        collectFeesListTwo.add(collectFees);
        dtoTwo.setData(collectFeesListTwo);
        resultList.add(dtoTwo);
        return resultList;
    }

    /**
     * 商城上架车辆列表
     *
     * @param paramDto
     * @return
     */
    @Override
    public PageInfo<CarStockGroundingDto> queryCarStockGroundingList(CarStockGroundingParamDto paramDto) {
        PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
        List<CarStockGroundingDto> list = stockInfoDao.queryCarStockGroundingList(paramDto);
        if (CollectionUtil.isNotEmpty(list)) {
            for (CarStockGroundingDto dto : list) {
                if (ObjectUtil.isNotNull(dto.getServiceId())||ObjectUtil.isNotNull(dto.getStockId())) {
                    List<CarServiceFileDto> fileDtos = stockInfoDao.queryFile(dto.getServiceId(), "9401",dto.getStockId());
                    if (CollectionUtil.isNotEmpty(fileDtos)) {
                        List<CarServiceFileDetailDto> carServiceFileDetailDtos = stockInfoDao.queryFileDetail(fileDtos.get(0).getMaterialId());
                        if (CollectionUtil.isNotEmpty(carServiceFileDetailDtos)) {
                            List<CarServiceFileDetailDto> fileDetailDtoList = carServiceFileDetailDtos.stream().filter(x -> x.getMaterialFileType().equals("9501")).collect(Collectors.toList());
                            if (CollectionUtil.isNotEmpty(fileDetailDtoList)) {
                                dto.setMaterialFileId(fileDetailDtoList.get(0).getMaterialFileId());
                                dto.setFileUrl(hwOBSConfig.getFileUri()+fileDetailDtoList.get(0).getFileUrl());
                            }
                        }
                    }
                }
                dto.setLabelList(setLabel(dto));
            }
        }
        return new PageInfo<>(list);
    }

    private List<CarLabelDto> setLabel(CarStockGroundingDto dto) {
        List<CarLabelDto> labelList = new ArrayList<>();
        Integer labelSort = 0;
        //官方权益
        if (ObjectUtil.isNotNull(dto.getRightPackId())) {
            //车辆权益项
            List<CarRightDto> rightList = stockInfoDao.getRightList(dto.getRightPackId());
            if(CollectionUtil.isNotEmpty(rightList)){
                labelSort = labelSort +1;
                CarLabelDto carLabelDto = new CarLabelDto();
                carLabelDto.setLabelSort(labelSort);
                carLabelDto.setLabelCode("6101");
                carLabelDto.setLabelName("官方权益");
                labelList.add(carLabelDto);
            }
        }
        //准新车：根据当前时间-首次上牌时间计算车龄，车龄1年以内；且行驶里程小于1万公里
        if(Objects.nonNull(dto.getFirstLicenseDate()) && Objects.nonNull(dto.getStockMileage())){
            int days = (int) ((System.currentTimeMillis() - dto.getFirstLicenseDate().getTime()) / (1000*3600*24));
            Long stockMileage = Long.valueOf(dto.getStockMileage());
            if(365 > days && 10000 > stockMileage){
                labelSort = labelSort +1;
                CarLabelDto carLabelDto = new CarLabelDto();
                carLabelDto.setLabelSort(labelSort);
                carLabelDto.setLabelCode("6102");
                carLabelDto.setLabelName("准新车");
                labelList.add(carLabelDto);
            }
        }
        //过户次数
        Integer transferCount = dto.getTransferCount();
        if(Objects.nonNull(dto.getTransferCount())){
            labelSort = labelSort +1;
            CarLabelDto carLabelDto = new CarLabelDto();
            carLabelDto.setLabelSort(labelSort);
            carLabelDto.setLabelCode("6103");
            carLabelDto.setLabelName(String.format("过户%s次",transferCount));
            labelList.add(carLabelDto);

        }
        return labelList;
    }

    @Override
    public CarStockGroundingDetailDto queryCarStockGroundingDetail(String stockId) throws ParseException {
        CarStockGroundingDetailDto dto = stockInfoDao.queryCarStockGroundingDetail(stockId);
        SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");
        if(!StringUtil.isEmpty(dto.getInvoiceDate())){
			Calendar ca=Calendar.getInstance();
			ca.set(Calendar.YEAR, Integer.parseInt(dto.getInvoiceDate().substring(0, 4)));
			ca.set(Calendar.MONTH, Integer.parseInt(dto.getInvoiceDate().substring(5, 7))-1);
			ca.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dto.getInvoiceDate().substring(8, 10)));
			ca.add(Calendar.YEAR, 5);
			dto.setWarrantyEndDate(form.format(ca.getTime())+"/15万公里");//整车质保到期日期
			ca.add(Calendar.YEAR, -2);
			dto.setElectricityEndDate(form.format(ca.getTime())+"/24万公里");//整车质保到期日期
		}
        CarStockGroundingDto dto1 = new CarStockGroundingDto();
        dto1.setRightPackId(dto.getRightPackId());
        if(StringUtil.isNotEmpty(dto.getFirstLicenseDate())){
        	dto1.setFirstLicenseDate(form.parse(dto.getFirstLicenseDate()));
        }
        dto1.setStockMileage(dto.getStockMileage());
        dto1.setTransferCount(dto.getTransferCount());
        dto.setLabelList(setLabel(dto1));
        List<CarServiceFileDto> fileDtoList = new ArrayList<>();
        PsiCarServiceInfoEntity carServiceInfo = new PsiCarServiceInfoEntity();
        carServiceInfo.setStockId(Long.parseLong(stockId));
        List<PsiCarServiceInfoEntity> serviceInfo = iPsiCarServiceInfoDao.selectBySelective(carServiceInfo);
        //外饰图片
        List<CarServiceFileDto> fileDtos;
        //内饰图片
        List<CarServiceFileDto> fileTwoDtos;
        //瑕疵图片
        List<CarServiceFileDto> fileThreeDtos;
        if (CollectionUtil.isNotEmpty(serviceInfo)) {
            //外饰图片
            fileDtos = stockInfoDao.queryFile(serviceInfo.get(0).getServiceId(), "9401",null);
            //内饰图片
            fileTwoDtos = stockInfoDao.queryFile(serviceInfo.get(0).getServiceId(), "9402",null);
            //瑕疵图片
            fileThreeDtos = stockInfoDao.queryFile(serviceInfo.get(0).getServiceId(), "9403",null);
        }else{
        	//外饰图片
            fileDtos = stockInfoDao.queryFile(null, "9401",Long.parseLong(stockId));
            //内饰图片
            fileTwoDtos = stockInfoDao.queryFile(null, "9402",Long.parseLong(stockId));
            //瑕疵图片
            fileThreeDtos = stockInfoDao.queryFile(null, "9403",Long.parseLong(stockId));
        }
        if (CollectionUtil.isNotEmpty(fileDtos)) {
        	List<CarServiceFileDetailDto> fileDetailDtosList = stockInfoDao.queryFileDetail(fileDtos.get(0).getMaterialId());
        	this.appendUrl(fileDetailDtosList);
        	fileDtos.get(0).setDetailDtos(fileDetailDtosList);
        	fileDtoList.add(fileDtos.get(0));
        }
        if (CollectionUtil.isNotEmpty(fileTwoDtos)) {
        	List<CarServiceFileDetailDto> fileDetailDtosList = stockInfoDao.queryFileDetail(fileTwoDtos.get(0).getMaterialId());
        	this.appendUrl(fileDetailDtosList);
        	fileTwoDtos.get(0).setDetailDtos(fileDetailDtosList);
        	fileDtoList.add(fileTwoDtos.get(0));
        }
        if (CollectionUtil.isNotEmpty(fileThreeDtos)) {
        	List<CarServiceFileDetailDto> fileDetailDtosList = stockInfoDao.queryFileDetail(fileThreeDtos.get(0).getMaterialId());
        	this.appendUrl(fileDetailDtosList);
        	fileThreeDtos.get(0).setDetailDtos(fileDetailDtosList);
        	fileDtoList.add(fileThreeDtos.get(0));
        }
        dto.setFileDtoList(fileDtoList);
        if (ObjectUtil.isNotNull(dto.getRightPackId())) {
            //车辆权益项
            List<CarRightDto> rightList = stockInfoDao.getRightList(dto.getRightPackId());
            dto.setRightList(rightList);
        }
        //配置亮点顶部图
        String configTopPicUrl = this.stockInfoDao.getConfigTopPicUrl(dto.getCarSeriesCode());
        dto.setConfigTopPicUrl(hwOBSConfig.getFileUri()+configTopPicUrl);
        //选装件信息
        PsiCarOptionInfoEntity entity = new PsiCarOptionInfoEntity();
        entity.setStockId(Long.valueOf(stockId));
        List<PsiCarOptionInfoEntity> optionInfoEntityList = carOptionInfoDao.selectBySelective(entity);
        dto.setOptionInfoList(optionInfoEntityList);
        //认证报告链接
        dto.setUrl(url + "?vin=" + dto.getVin());
        
        //查询更多推荐车辆
        CarStockGroundingParamDto paramDto = new CarStockGroundingParamDto();
        paramDto.setBaseCarTypeCode(dto.getBaseCarTypeCode());
        paramDto.setPageNum(1);
        paramDto.setPageSize(3);
        paramDto.setCurStockId(stockId);
        PageInfo<CarStockGroundingDto> page =this.queryCarStockGroundingList(paramDto);
        if(!CollectionUtil.isNotEmpty(page.getList())){
        	paramDto.setBaseCarTypeCode(null);
        	page =this.queryCarStockGroundingList(paramDto);
        }
        dto.setMoreList(page.getList());
        return dto;
    }

	private void appendUrl(List<CarServiceFileDetailDto> fileDetailDtosList) {
		if(CollectionUtil.isNotEmpty(fileDetailDtosList)){
    		fileDetailDtosList.forEach(detail ->{
    			detail.setFileUrl(hwOBSConfig.getFileUri()+detail.getFileUrl());
    			detail.setThumbnail(null);
    		});
    	}
	}
}
