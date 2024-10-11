package com.exp.ucmp.mall.service.impl;

import com.egrid.cache.redisson.cache.RedissonCache;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.exp.ucmp.carDealer.dao.AcquisitionFollowDao;
import com.exp.ucmp.clues.dto.*;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.jPush.dto.JPushReqDto;
import com.exp.ucmp.jpush.service.JPushService;
import com.exp.ucmp.mall.dao.PsiRetentionDao;
import com.exp.ucmp.mall.dao.PsiSalesCustomerDao;
import com.exp.ucmp.mall.service.BaseCluesService;
import com.exp.ucmp.mall.service.PsiSalesRetentionService;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiOrderInfoPk;
import com.exp.ucmp.pk.PsiRetentionCluesPk;
import com.exp.ucmp.pk.PsiSalesCustomerPk;
import com.exp.ucmp.pk.SysStoreInfoPk;
import com.exp.ucmp.salesDelivery.dao.SalesDeliveryDao;
import com.exp.ucmp.salesDelivery.service.SalesDelivryService;
import com.exp.ucmp.storeApp.dto.OneselfAcquirerDto;
import com.exp.ucmp.util.AesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import jodd.util.StringUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * <p>@ClassName: PsiSalesRetentionService</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/30 15:28<p>
 */
@Service
public class PsiSalesRetentionServiceImpl extends BaseCluesService implements PsiSalesRetentionService {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PsiSalesRetentionServiceImpl.class);

    @Autowired
    private PsiRetentionDao psiRetentionDao;
    @Autowired
    private IPsiCluesFollowRecordDao psiCluesFollowRecordDao;
    @Autowired
    private IPsiRetentionCluesDao iPsiRetentionCluesDao;
    @Autowired
    private IPsiOrderInfoDao orderInfoDao;
    @Autowired
    private UcmpAesConfig ucmpAesConfig;
    @Autowired
    private PsiSalesCustomerDao salesCustomerDao;
    @Autowired
    private PsiSalesModifyConfigDao psiSalesModifyConfigDao;
    @Autowired
    private IPsiSalesCustomerDao psiSalesCustomerDao;
    @Autowired
    private IPsiSalesOrderMaterialDao iPsiSalesOrderMaterialDao;

    @Autowired
    private ISysStoreInfoDao iStoreInfoDao;
    
    @Autowired
    private AcquisitionFollowDao acquisitionFollowDao;
    
    @Autowired
	private SalesDeliveryDao salesDeliveryDao;
    
    @Autowired
    JPushService jPushService;
    
    @Autowired
    private SalesDelivryService salesDelivryService;
    @Autowired
    private RedissonCache redissonCache;

    @Override
    public PageInfo<SalesCustomerInfoDto> queryCustomerInfoList(SalesCustomerParamDto paramDto) throws Exception {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        paramDto.setStoreId(user.getOrganId());
        paramDto.setPartyId(user.getPartyId());
        //手机号查询，加密后查询
        if(Objects.nonNull(paramDto.getMultiField())){
            paramDto.setEncryptionMultiField(AesUtils.encryptHex(paramDto.getMultiField(), ucmpAesConfig.getSecret()));
        }
        PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
        List<SalesCustomerInfoDto> psiSalesCustomerEntityList = salesCustomerDao.queryCustomerList(paramDto);
        for (SalesCustomerInfoDto salesCustomerInfoDto : psiSalesCustomerEntityList) {
            salesCustomerInfoDto.setCustomerPhone(UcmpAesConfig.dataMask(
                    AesUtils.decryptHex(salesCustomerInfoDto.getEncryptionCustomerPhone(), ucmpAesConfig.getSecret()), 3, 7, "****"));
        }
        return new PageInfo<>(psiSalesCustomerEntityList);
    }

    @Override
    public SalesCustomerInfoDto querySalesCustomer(String role, String otherPartyId,Long customerId) throws Exception {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiSalesCustomerEntity load = psiSalesCustomerDao.load(new PsiSalesCustomerPk(customerId));
        SalesCustomerParamDto paramDto = new SalesCustomerParamDto();
        paramDto.setCustomerId(customerId);
        paramDto.setStoreId(user.getOrganId());
        paramDto.setPartyId(user.getPartyId());
        paramDto.setOtherPartyId(otherPartyId);
        PsiRetentionCluesEntity cluesEntity = psiRetentionDao.selectLastClues(paramDto);
        SalesCustomerInfoDto salesCustomerInfoDto= new SalesCustomerInfoDto();
        if(Objects.nonNull(cluesEntity)){
            BeanUtils.copyProperties(cluesEntity,salesCustomerInfoDto);
            salesCustomerInfoDto.setFamily(cluesEntity.getFamilySituation());
        }
        salesCustomerInfoDto.setEncryptionCustomerPhone(load.getCustomerPhone());
        salesCustomerInfoDto.setCustomerName(load.getCustomerName());
        salesCustomerInfoDto.setCustomerPhone(UcmpAesConfig.dataMask(
                AesUtils.decryptHex(load.getCustomerPhone(), ucmpAesConfig.getSecret()), 3, 7, "****"));
        return salesCustomerInfoDto;
    }

    @Override
    public PageInfo<SalesRetentionCluesDto> querySalesCluesList(SalesCluesParamDto salesCluesParamDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        salesCluesParamDto.setStoreId(user.getOrganId());
        salesCluesParamDto.setPartyId(user.getPartyId());
        PageHelper.startPage(salesCluesParamDto.getPageNum(), salesCluesParamDto.getPageSize());
        List<SalesRetentionCluesDto> salesRetentionCluesDtos = psiRetentionDao.querySalesCluesList(salesCluesParamDto);
        return new PageInfo<>(salesRetentionCluesDtos);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createClues(RetentionCluesCreateDto createDto) {
        /**
         1.校验意向vin是否存在或在售
         2.该门店是否存在该客户，不存在：异常，新建线索失败  存在：正常流程
         3.保存线索、客户
         */
        //新建线索时，手机号一样，姓名不一样，销售客户表姓名不做更新
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiCarStockInfoEntity stockInfoEntity = null;
        if(StringUtil.isNotEmpty(createDto.getVin())){
            stockInfoEntity = checkVin(createDto.getVin());
        }

        //手机号加密
        String customerPhone = null;
        if(Objects.isNull(createDto.getCustomerId()) && Objects.nonNull(createDto.getCustomerPhone())){
            customerPhone = AesUtils.encryptHex(createDto.getCustomerPhone(), ucmpAesConfig.getSecret());
        }

        PsiSalesCustomerEntity salesCustomerEntity = new PsiSalesCustomerEntity();

        PsiSalesCustomerDto salesCustomerDto = new PsiSalesCustomerDto();
        salesCustomerDto.setCustomerPhone(customerPhone);
        salesCustomerDto.setCustomerId(createDto.getCustomerId());
        List<PsiSalesCustomerEntity> psiSalesCustomerEntities = salesCustomerDao.selectByList(salesCustomerDto);
        if(CollectionUtils.isNotEmpty(psiSalesCustomerEntities)
                && !Objects.equals(user.getOrganId(),psiSalesCustomerEntities.get(0).getStoreId())){
            throw new IllegalParameterException("其他门店已存在该客户，新建线索失败！");
        }

        if(CollectionUtils.isNotEmpty(psiSalesCustomerEntities)){
            salesCustomerEntity = psiSalesCustomerEntities.get(0);
            salesCustomerEntity.setFollowBy(user.getPartyId());
            salesCustomerEntity.setFollowName(user.getPersonName());
            salesCustomerEntity.setFollowTime(new Date());
            salesCustomerEntity.setFamily(createDto.getFamilySituation());
            salesCustomerEntity.setCreatedBy(user.getPartyId());
            salesCustomerEntity.setCreatedDate(new Date());
            salesCustomerEntity.setUpdatedBy(user.getPartyId());
            salesCustomerEntity.setUpdatedDate(new Date());
            psiSalesCustomerDao.updateSelective(salesCustomerEntity);
        } else {
            salesCustomerEntity.generatePk();
            salesCustomerEntity.setStoreId(user.getOrganId());
            salesCustomerEntity.setPartyId(user.getPartyId());
            salesCustomerEntity.setDeliveryPlace(createDto.getDeliveryPlace());
            salesCustomerEntity.setCustomerName(createDto.getCustomerName());
            salesCustomerEntity.setCustomerPhone(customerPhone);
            salesCustomerEntity.setFollowBy(user.getPartyId());
            salesCustomerEntity.setFollowName(user.getPersonName());
            salesCustomerEntity.setFollowTime(new Date());
            salesCustomerEntity.setFamily(createDto.getFamilySituation());
            salesCustomerEntity.setCreatedBy(user.getPartyId());
            salesCustomerEntity.setCreatedDate(new Date());
            salesCustomerEntity.setUpdatedBy(user.getPartyId());
            salesCustomerEntity.setUpdatedDate(new Date());
            psiSalesCustomerDao.insertSelective(salesCustomerEntity);
        }



        PsiRetentionCluesEntity cluesEntity = new PsiRetentionCluesEntity();
        BeanUtils.copyProperties(createDto,cluesEntity);
        if(Objects.nonNull(stockInfoEntity)){
            cluesEntity.setStorageId(stockInfoEntity.getStorageId());
            cluesEntity.setStockId(stockInfoEntity.getStockId());
            cluesEntity.setSalePrice(stockInfoEntity.getSalePrice());
        }
        cluesEntity.generatePk();
        cluesEntity.setCluesSource(Constants.RetentionCluesSource.SCENE.getCode());
        cluesEntity.setCustomerPhone(salesCustomerEntity.getCustomerPhone());
        cluesEntity.setFollowStore(user.getOrganId());
        cluesEntity.setFollowPerson(user.getPartyId());
//        cluesEntity.setFollowTime(new Date());
        cluesEntity.setCustomerId(salesCustomerEntity.getCustomerId());
        cluesEntity.setFollowStatus(Constants.FollowStatus.NOT_FOLLOWED_UP.getCode());
        cluesEntity.setRetentionTime(new Date());
        cluesEntity.setIsShow("00");
        cluesEntity.setIsEnable("01");
        cluesEntity.setCreatedBy(user.getPartyId());
        cluesEntity.setUpdatedBy(user.getPartyId());
        cluesEntity.setIsDelete("00");
        iPsiRetentionCluesDao.insert(cluesEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void escrow(SalesOrderMaterialDto paramDto) throws Exception {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        //查询需要推送的交付主管
    	List<String> alias=this.acquisitionFollowDao.queryAlias(paramDto.getDeliveryStore());
    	//查询订单号
    	String orderNum=this.salesDeliveryDao.queryOrderNum(paramDto.getOrderInfoId());
    	JPushReqDto jPushReqDto = new JPushReqDto();
        jPushReqDto.setRelevanceId(paramDto.getOrderInfoId());
        jPushReqDto.setParams(orderNum);
        
        PsiOrderInfoEntity orderInfoEntity = new PsiOrderInfoEntity();
        //有的交付中心没有交付主管，需要随机分配给某个交付顾问
        if(CollectionUtils.isEmpty(alias)){
        	//查询交付顾问
        	List<OneselfAcquirerDto> oneselfAcquirerDto = this.salesDelivryService.delivryConsultantList(paramDto.getDeliveryStore(),null,null);
        	if(CollectionUtils.isNotEmpty(oneselfAcquirerDto)){
                Random random = new Random();
                int r=random.nextInt(oneselfAcquirerDto.size());
                orderInfoEntity.setDeliveryPerson(oneselfAcquirerDto.get(r).getPartyId());
                String[] alias1={oneselfAcquirerDto.get(r).getIdmAccountName()};
                jPushReqDto.setAlias(alias1);
                //交付主管分配订单至自己或顾问
                jPushReqDto.setjPushtemplateId(Constants.jPushtemplateId.JPUSHSEVEN.value());
            }
        }else{
        	//销售人员转交付至交付主管
        	jPushReqDto.setAlias(alias.toArray(new String[alias.size()]));
    		jPushReqDto.setjPushtemplateId(Constants.jPushtemplateId.JPUSHSIXTH.value());
        }
        orderInfoEntity.setOrderInfoId(paramDto.getOrderInfoId());
        orderInfoEntity.setDeliveryStore(paramDto.getDeliveryStore());
        orderInfoEntity.setOrderStatus("7409");
        if(Objects.nonNull(orderInfoEntity.getDeliveryPerson())){
            orderInfoEntity.setOrderStatus("7403");
        }
        orderInfoEntity.setUpdatedBy(user.getPartyId());
        orderInfoEntity.setUpdatedDate(new Date());
        orderInfoDao.updateSelective(orderInfoEntity);
        createOrderFollowRecord(orderInfoEntity.getOrderInfoId(),orderInfoEntity.getOrderStatus());
        List<PsiSalesOrderMaterialEntity> list = new ArrayList<>();
        for (SalesOrderMaterialDto.OrderMaterial orderMaterial : paramDto.getOrderMaterialList()) {
            PsiSalesOrderMaterialEntity psiSalesOrderMaterialEntity = new PsiSalesOrderMaterialEntity();
            BeanUtils.copyProperties(orderMaterial,psiSalesOrderMaterialEntity);
            psiSalesOrderMaterialEntity.setOrderInfoId(paramDto.getOrderInfoId());
            psiSalesOrderMaterialEntity.setUploadPerson(user.getPartyId());
            psiSalesOrderMaterialEntity.setUploadDate(new Date());
            list.add(psiSalesOrderMaterialEntity);
        }
        iPsiSalesOrderMaterialDao.batchInsert(list);
        if(Objects.isNull(jPushReqDto.getjPushtemplateId())){
            LOGGER.info("转交付-订单号：{}，模板ID为空",paramDto.getOrderInfoId());
            return;
        }
        jPushService.sendJPush(jPushReqDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String cancelOrder(SalesOrderCancelDto cancelDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        //修改订单表状态
        PsiOrderInfoEntity psiOrderInfoEntity = new PsiOrderInfoEntity();
        psiOrderInfoEntity.setOrderInfoId(cancelDto.getOrderInfoId());
        psiOrderInfoEntity.setCancelRemark(cancelDto.getCancelRemark());
        psiOrderInfoEntity.setOrderStatus("7407");
        psiOrderInfoEntity.setUpdatedBy(user.getPartyId());
        psiOrderInfoEntity.setUpdatedDate(new Date());
        orderInfoDao.updateSelective(psiOrderInfoEntity);
        createOrderFollowRecord(psiOrderInfoEntity.getOrderInfoId(),psiOrderInfoEntity.getOrderStatus());
        return "取消成功";
    }



    @Override
    public PsiOrderInfoDto queryOrderInfo(Long orderInfoId) throws Exception {
        PsiOrderInfoDto psiOrderInfoEntities = psiRetentionDao.queryDetails(orderInfoId);
        if(Objects.nonNull(psiOrderInfoEntities.getEncryptionCustomerPhone())){
            psiOrderInfoEntities.setCustomerPhone(UcmpAesConfig.dataMask(AesUtils.decryptHex(psiOrderInfoEntities.getEncryptionCustomerPhone(), ucmpAesConfig.getSecret()), 3, 7, "****"));
        }
//        List<PsiSalesOrderMaterialDto> orderMaterialDtos = psiSalesOrderMaterialDao.selectByOrderInfoId(orderInfoId);
//        psiOrderInfoEntities.setSalesOrderMaterialDtoList(orderMaterialDtos);
        return psiOrderInfoEntities;
    }


    /**
     * 添加跟进
     *
     * @param paramDto
     * @return
     */
    @Override
    public String saveFollow(SalesSaveFollowDto paramDto) {
        PsiCarStockInfoEntity psiCarStockInfoEntity = null;
        //校验vin
        if(StringUtil.isNotEmpty(paramDto.getVin())){
            psiCarStockInfoEntity = checkVin(paramDto.getVin());
        }
        Date date = new Date();
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiCluesFollowRecordEntity psiCluesFollowRecordEntity =
                Copiers.beanToBean(paramDto, SalesSaveFollowDto.class, PsiCluesFollowRecordEntity.class);
        psiCluesFollowRecordEntity.generatePk();
        psiCluesFollowRecordEntity.setFollowTime(date);
        psiCluesFollowRecordEntity.setCreatedBy(user.getPartyId());
        psiCluesFollowRecordEntity.setCreatedDate(date);
        psiCluesFollowRecordEntity.setUpdatedBy(user.getPartyId());
        psiCluesFollowRecordEntity.setUpdatedDate(date);
        psiCluesFollowRecordEntity.setFollowStore(user.getOrganId());
        psiCluesFollowRecordEntity.setFollowPerson(user.getPartyId());
        psiCluesFollowRecordEntity.setFollowStatus("01");
        psiCluesFollowRecordDao.insertSelective(psiCluesFollowRecordEntity);

        //修改线索表跟进状态
        PsiRetentionCluesEntity retentionCluesEntity = iPsiRetentionCluesDao.load(new PsiRetentionCluesPk(paramDto.getCluesId()));
//        retentionCluesEntity.setCluesId(paramDto.getCluesId());
        if(Objects.nonNull(psiCarStockInfoEntity)){
            retentionCluesEntity.setStockId(psiCarStockInfoEntity.getStockId());
            retentionCluesEntity.setStorageId(psiCarStockInfoEntity.getStorageId());
            retentionCluesEntity.setSalePrice(psiCarStockInfoEntity.getSalePrice());
        }
        retentionCluesEntity.setModelCode(paramDto.getModelCode());
        retentionCluesEntity.setModelName(paramDto.getModelName());
        retentionCluesEntity.setFollowTime(date);
        retentionCluesEntity.setLastFollowTime(date);
        retentionCluesEntity.setFollowStatus(Constants.FollowStatus.FOLLOWED_UP.getCode());
        retentionCluesEntity.setUpdatedBy(user.getPartyId());
        retentionCluesEntity.setUpdatedDate(date);
        iPsiRetentionCluesDao.update(retentionCluesEntity);
        return "保存成功";
    }

    /**
     * 创建订单
     *
     * @param paramDto
     * @return
     */
    @Override
    public OrderRespDto createOrder(SalesOrderCreateDto paramDto) {
        //校验vin
        PsiCarStockInfoEntity psiCarStockInfoEntity = checkVin(paramDto.getCarVin());
        if(Objects.nonNull(paramDto.getCluesId())){
            PsiRetentionCluesEntity cluesEntity = iPsiRetentionCluesDao.load(new PsiRetentionCluesPk(paramDto.getCluesId()));
            if(Objects.isNull(cluesEntity) || Objects.equals(Constants.FollowStatus.GENERATE_ORDER.getCode(),cluesEntity.getFollowStatus())
                || Objects.equals(Constants.FollowStatus.DEFEAT.getCode(),cluesEntity.getFollowStatus())){
                throw new IllegalParameterException("已生成订单或线索战败");
            }
        }
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiOrderInfoEntity orderInfoEntity =
                Copiers.beanToBean(paramDto, SalesOrderCreateDto.class, PsiOrderInfoEntity.class);
        //生成单号
        String orderNumber = PsiRetentionServiceImpl.getOddNumbers(psiRetentionDao.findNewOddNumbers());
        orderInfoEntity.generatePk();
        orderInfoEntity.setOrderNo(orderNumber);
        orderInfoEntity.setOrderPrice(psiCarStockInfoEntity.getSalePrice());
        orderInfoEntity.setCarPrice(psiCarStockInfoEntity.getSalePrice());
        orderInfoEntity.setCustomerPhone(AesUtils.encryptHex(paramDto.getCustomerPhone(),ucmpAesConfig.getSecret()));
        orderInfoEntity.setStockId(String.valueOf(psiCarStockInfoEntity.getStockId()));
        orderInfoEntity.setExteriorColor(psiCarStockInfoEntity.getCarColour());
        orderInfoEntity.setInteriorColor(psiCarStockInfoEntity.getInteriorColor());
        orderInfoEntity.setReceivablePrice(psiCarStockInfoEntity.getSalePrice());
        orderInfoEntity.setNotReceivedPrice(psiCarStockInfoEntity.getSalePrice());
        orderInfoEntity.setBaseCarTypeName(psiCarStockInfoEntity.getBaseCarTypeName());
        orderInfoEntity.setOrderStatus("7401");
        orderInfoEntity.setSalesStore(user.getOrganId());
        orderInfoEntity.setFollowPerson(user.getPartyId());
        orderInfoEntity.setCreatedBy(user.getPartyId());
        orderInfoEntity.setCreatedDate(new Date());
        orderInfoEntity.setUpdatedBy(user.getPartyId());
        orderInfoEntity.setUpdatedDate(new Date());
        orderInfoDao.insertSelective(orderInfoEntity);
        //订单状态变更记录
        createOrderFollowRecord(orderInfoEntity.getOrderInfoId(),orderInfoEntity.getOrderStatus());
        //线索状态修改
        if(Objects.nonNull(paramDto.getCluesId())){
            PsiRetentionCluesEntity retentionCluesEntity = new PsiRetentionCluesEntity();
            retentionCluesEntity.setCluesId(paramDto.getCluesId());
            retentionCluesEntity.setFollowStatus(Constants.FollowStatus.GENERATE_ORDER.getCode());
            iPsiRetentionCluesDao.updateSelective(retentionCluesEntity);
        }
        OrderRespDto orderRespDto = new OrderRespDto();
        orderRespDto.setOrderInfoId(orderInfoEntity.getOrderInfoId());
        orderRespDto.setOrderNo(orderInfoEntity.getOrderNo());
        orderRespDto.setDeposit(orderInfoEntity.getDeposit());
        orderRespDto.setVin(orderInfoEntity.getCarVin());
        orderRespDto.setRevertBody(psiCarStockInfoEntity.getRevertBody());
        orderRespDto.setOrderPrice(orderInfoEntity.getOrderPrice());
        return orderRespDto;
    }

    @Override
    public String updateOrder(SalesOrderUpdateDto updateDto) {
        PsiCarStockInfoEntity psiCarStockInfoEntity = checkVin(updateDto.getCarVin());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiOrderInfoEntity orderInfoEntity =
                Copiers.beanToBean(updateDto, SalesOrderUpdateDto.class, PsiOrderInfoEntity.class);
        orderInfoEntity.setCarPrice(psiCarStockInfoEntity.getSalePrice());
        orderInfoEntity.setOrderPrice(psiCarStockInfoEntity.getSalePrice());
//        orderInfoEntity.setCustomerPhone(AesUtils.encryptHex(updateDto.getCustomerPhone(),ucmpAesConfig.getSecret()));
        orderInfoEntity.setStockId(String.valueOf(psiCarStockInfoEntity.getStockId()));
        orderInfoEntity.setExteriorColor(psiCarStockInfoEntity.getCarColour());
        orderInfoEntity.setInteriorColor(psiCarStockInfoEntity.getInteriorColor());
        orderInfoEntity.setReceivablePrice(psiCarStockInfoEntity.getSalePrice());
        orderInfoEntity.setNotReceivedPrice(psiCarStockInfoEntity.getSalePrice());
        orderInfoEntity.setBaseCarTypeName(psiCarStockInfoEntity.getBaseCarTypeName());
        orderInfoEntity.setOrderStatus("7401");
        orderInfoEntity.setFollowPerson(user.getPartyId());
        orderInfoEntity.setUpdatedBy(user.getPartyId());
        orderInfoEntity.setUpdatedDate(new Date());
        orderInfoDao.updateSelective(orderInfoEntity);
        return "保存成功";
    }


    @Override
    public String defeat(Long cluesId) {
        PsiRetentionCluesEntity psiRetentionCluesEntity = new PsiRetentionCluesEntity();
        psiRetentionCluesEntity.setCluesId(cluesId);
        psiRetentionCluesEntity.setFollowStatus(Constants.FollowStatus.DEFEAT.getCode());
        iPsiRetentionCluesDao.updateSelective(psiRetentionCluesEntity);
        return "操作成功";
    }

    /**
     * 查询订单列表信息
     *
     * @param orderInfoParamDto
     * @return
     */
    @Override
    public PageInfo<OrderInfoDto> queryOrderList(OrderInfoParamDto orderInfoParamDto) throws Exception {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        orderInfoParamDto.setStoreId(user.getOrganId());
        orderInfoParamDto.setPartyId(user.getPartyId());
        PageHelper.startPage(orderInfoParamDto.getPageNum(), orderInfoParamDto.getPageSize());
        List<OrderInfoDto> orderInfoDtoList = psiRetentionDao.queryOrderList(orderInfoParamDto);
        for (OrderInfoDto orderInfoDto : orderInfoDtoList) {
            orderInfoDto.setCustomerPhone(UcmpAesConfig.dataMask(AesUtils.decryptHex(orderInfoDto.getCustomerPhone(), ucmpAesConfig.getSecret()), 3, 7, "****"));
        }

        return new PageInfo<>(orderInfoDtoList);
    }

    @Override
    public List<PsiCluesFollowRecordDto> listCluesFollowRecord(Long cluesId) {
        PsiCluesFollowRecordEntity psiCluesFollowRecordEntity = new PsiCluesFollowRecordEntity();
        psiCluesFollowRecordEntity.setCluesId(cluesId);
        psiCluesFollowRecordEntity.setIsEnable("01");
        List<PsiCluesFollowRecordDto> psiCluesFollowRecordEntityList = psiRetentionDao.queryCluesFollowRecord(psiCluesFollowRecordEntity);
        return psiCluesFollowRecordEntityList;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saleCreateModify(PsiSalesModifyConfigCreateDto createDto) throws Exception {
        PsiCarStockInfoEntity psiCarStockInfoEntity = checkVin(createDto.getChangeVin());
        PsiOrderInfoEntity load = orderInfoDao.load(new PsiOrderInfoPk(createDto.getOrderInfoId()));
        //校验改配车辆销售金额是否小于已收金额
        checkPrice(psiCarStockInfoEntity.getSalePrice(),load.getReceivedPrice());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiSalesModifyConfigEntity psiSalesModifyConfigEntity = Copiers.beanToBean(createDto, PsiSalesModifyConfigCreateDto.class, PsiSalesModifyConfigEntity.class);
        psiSalesModifyConfigEntity.generatePk();
        psiSalesModifyConfigEntity.setApproveResult(Constants.ApproveResult.PROCESS.getCode());
        psiSalesModifyConfigEntity.setApplyBy(user.getPartyId());
        psiSalesModifyConfigEntity.setApplyDate(new Date());
        psiSalesModifyConfigEntity.setApplySource(1);
        psiSalesModifyConfigDao.insert(psiSalesModifyConfigEntity);
        //修改订单表状态
        PsiOrderInfoEntity psiOrderInfoEntity = new PsiOrderInfoEntity();
        psiOrderInfoEntity.setOrderInfoId(psiSalesModifyConfigEntity.getOrderInfoId());
        psiOrderInfoEntity.setOrderStatus("7408");
        psiOrderInfoEntity.setUpdatedBy(user.getPartyId());
        psiOrderInfoEntity.setUpdatedDate(new Date());
        orderInfoDao.updateSelective(psiOrderInfoEntity);
        createOrderFollowRecord(psiOrderInfoEntity.getOrderInfoId(),psiOrderInfoEntity.getOrderStatus());
        //销售申请改配：发送短信给对应的二手车主管
        List<UsedCarSupervisorDto> usedCarSupervisorDtos = usedCarSupervisor(user.getOrganId());
        if(CollectionUtils.isNotEmpty(usedCarSupervisorDtos)){
            SysStoreInfoEntity storeInfo = iStoreInfoDao.load(new SysStoreInfoPk(load.getSalesStore()));
            for (UsedCarSupervisorDto usedCarSupervisorDto : usedCarSupervisorDtos) {
                sendSms(Constants.sendMessage.sendMessageSixteenth.value(),usedCarSupervisorDto.getStaffIphone(), new String[]{
                        String.valueOf(storeInfo.getOrgName()),
                        load.getOrderNo()},"02",createDto.getOrderInfoId());
            }

        }

    }

    @Override
    public PageInfo<SalesRetentionCluesDto> queryUndistributedCluesList(SalesCluesParamDto salesCluesParamDto) throws Exception{
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        salesCluesParamDto.setStoreId(user.getOrganId());
        salesCluesParamDto.setEmptyFollowPerson("01");
        //手机号查询，加密后查询
        if(Objects.nonNull(salesCluesParamDto.getMultiField())){
            salesCluesParamDto.setEncryptionMultiField(AesUtils.encryptHex(salesCluesParamDto.getMultiField(), ucmpAesConfig.getSecret()));
        }
        PageHelper.startPage(salesCluesParamDto.getPageNum(), salesCluesParamDto.getPageSize());
        List<SalesRetentionCluesDto> salesRetentionCluesDtos = psiRetentionDao.querySalesCluesList(salesCluesParamDto);
        for (SalesRetentionCluesDto salesRetentionCluesDto : salesRetentionCluesDtos) {
            salesRetentionCluesDto.setCustomerPhone(UcmpAesConfig.dataMask(
                    AesUtils.decryptHex(salesRetentionCluesDto.getEncryptionCustomerPhone(), ucmpAesConfig.getSecret()), 3, 7, "****"));
        }
        return new PageInfo<>(salesRetentionCluesDtos);
    }

    @Override
    public void cluesAllocation(CluesTransferenceDto transferenceDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiRetentionCluesEntity load = iPsiRetentionCluesDao.load(new PsiRetentionCluesPk(transferenceDto.getCluesId()));
        if(Objects.isNull(load)){
            throw new IllegalParameterException("该线索不存在");
        }
        customerAllocation(load.getCustomerId(),null,transferenceDto.getFollowStore(),
                transferenceDto.getFollowPerson(),load.getCustomerName(),load.getDeliveryPlace());
//        PsiSalesCustomerEntity psiSalesCustomerEntity = new PsiSalesCustomerEntity();
//        psiSalesCustomerEntity.setCustomerId(load.getCustomerId());
//        psiSalesCustomerEntity.setStoreId(transferenceDto.getFollowStore());
//        psiSalesCustomerEntity.setPartyId(transferenceDto.getFollowPerson());
//        psiSalesCustomerEntity.setUpdatedBy(user.getPartyId());
//        psiSalesCustomerEntity.setUpdatedDate(new Date());
//        psiSalesCustomerDao.updateSelective(psiSalesCustomerEntity);
//        psiRetentionDao.updateStoreClues(load.getCustomerId(),
//                transferenceDto.getFollowStore(),transferenceDto.getFollowStore(),transferenceDto.getFollowPerson(),user.getPartyId());
//        psiRetentionDao.updateStoreOrder(load.getCustomerId(),
//                transferenceDto.getFollowStore(),transferenceDto.getFollowStore(),transferenceDto.getFollowPerson(),user.getPartyId());
//        //发送消息提醒（销售人员）
//        List<SalesConsultantDto> partyInfo = getPartyInfo(null, null, null, transferenceDto.getFollowPerson(),null);
//        SalesCustomerParamDto paramDto = new SalesCustomerParamDto();
//        paramDto.setCustomerId(load.getCustomerId());
//        paramDto.setStoreId(transferenceDto.getFollowStore());
//        List<String> params = new ArrayList<>();
//        params.add(load.getCustomerName());
//        params.add(load.getDeliveryPlace());
//        giveMessage(null,"UCMP",1,partyInfo.get(0).getStaffCode(),0,null,params);
    }

    @Override
    public List<SalesConsultantDto> salesConsultantList(SalesConsultantParamDto paramDto) throws Exception {

        if(com.alibaba.cloud.commons.lang.StringUtils.isNotEmpty(paramDto.getMultiField())){
            paramDto.setEncryptionMultiField(AesUtils.encryptHex(paramDto.getMultiField(), ucmpAesConfig.getSecret()));
        }
        paramDto.setStaffStatus("01");
        paramDto.setQualificationStatus("01");
        List<SalesConsultantDto> list =psiRetentionDao.salesConsultantList(paramDto);
        for (SalesConsultantDto salesConsultantDto : list) {
            salesConsultantDto.setStaffIphone(UcmpAesConfig.dataMask(
                    AesUtils.decryptHex(salesConsultantDto.getEncryptionStaffIphone(), ucmpAesConfig.getSecret()), 3, 7, "****"));

        }
        return list;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void customerAllocation(CustomerTransferenceDto transferenceDto) {
        SalesCustomerParamDto paramDto = new SalesCustomerParamDto();
        paramDto.setCustomerId(transferenceDto.getCustomerId());
        paramDto.setStoreId(transferenceDto.getStoreId());
        PsiRetentionCluesEntity cluesEntity = psiRetentionDao.selectLastClues(paramDto);
        customerAllocation(transferenceDto.getCustomerId(),null,transferenceDto.getStoreId(),
                transferenceDto.getPartyId(),cluesEntity.getCustomerName(),cluesEntity.getDeliveryPlace());
//        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
//        PsiSalesCustomerEntity psiSalesCustomerEntity = new PsiSalesCustomerEntity();
//        psiSalesCustomerEntity.setCustomerId(transferenceDto.getCustomerId());
//        psiSalesCustomerEntity.setStoreId(transferenceDto.getStoreId());
//        psiSalesCustomerEntity.setPartyId(transferenceDto.getPartyId());
//        psiSalesCustomerEntity.setUpdatedBy(user.getPartyId());
//        psiSalesCustomerEntity.setUpdatedDate(new Date());
//        psiSalesCustomerDao.updateSelective(psiSalesCustomerEntity);
//        psiRetentionDao.updateStoreClues(transferenceDto.getCustomerId(),
//                transferenceDto.getStoreId(),transferenceDto.getStoreId(),transferenceDto.getPartyId(),user.getPartyId());
//        psiRetentionDao.updateStoreOrder(transferenceDto.getCustomerId(),
//                transferenceDto.getStoreId(),transferenceDto.getStoreId(),transferenceDto.getPartyId(),user.getPartyId());
//        //发送消息提醒（销售人员）
//        List<SalesConsultantDto> partyInfo = getPartyInfo(null, null, null, transferenceDto.getPartyId(),null);
//        SalesCustomerParamDto paramDto = new SalesCustomerParamDto();
//        paramDto.setCustomerId(transferenceDto.getCustomerId());
//        paramDto.setStoreId(transferenceDto.getStoreId());
//        PsiRetentionCluesEntity cluesEntity = psiRetentionDao.selectLastClues(paramDto);
//        List<String> params = new ArrayList<>();
//        params.add(cluesEntity.getCustomerName());
//        params.add(cluesEntity.getDeliveryPlace());
//        giveMessage(null,"UCMP",1,partyInfo.get(0).getStaffCode(),0,null,params);
    }

    public PsiCarStockInfoEntity checkVinState(String orderInfoId,String vin){
        //车辆是否在售
        PsiCarStockInfoEntity psiCarStockInfoEntity = checkVin(vin);
        //车辆是否已被锁定
        carLock(orderInfoId,vin);
        //车辆锁定
        redissonCache.put(getCarLockKey(vin), orderInfoId);
        redissonCache.expire(getCarLockKey(vin), TimeUnit.MINUTES, 15L);
        return psiCarStockInfoEntity;
    }
}
