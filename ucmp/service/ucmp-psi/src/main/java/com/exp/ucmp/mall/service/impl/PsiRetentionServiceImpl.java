package com.exp.ucmp.mall.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.car.dto.ChangePriceParamDto;
import com.exp.ucmp.carDealer.service.AcquisitionFollowService;
import com.exp.ucmp.carDealer.service.FileUploadService;
import com.exp.ucmp.carDealer.service.HwObsService;
import com.exp.ucmp.clues.dto.*;
import com.exp.ucmp.config.HwOBSConfig;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.inventory.dao.PsiCarStockInfoDao;
import com.exp.ucmp.inventory.service.impl.PsiPricingServiceImpl;
import com.exp.ucmp.mall.dao.PsiRetentionDao;
import com.exp.ucmp.mall.dao.PsiSalesCustomerDao;
import com.exp.ucmp.mall.dao.PsiSalesOrderMaterialDao;
import com.exp.ucmp.mall.dao.SysRightActivitiesDao;
import com.exp.ucmp.mall.service.BaseCluesService;
import com.exp.ucmp.mall.service.PsiRetentionService;
import com.exp.ucmp.mall.util.entity.CluesInfoImportExcelEntity;
import com.exp.ucmp.mall.util.listener.CluesInfoImportExtraListener;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.*;
import com.exp.ucmp.pricing.retail.DiscountBasicDto;
import com.exp.ucmp.stock.dto.CarStockInfoDto;
import com.exp.ucmp.stock.dto.CarStockInfoListQueryDto;
import com.exp.ucmp.storeApp.fegin.ActivitiesFegin;
import com.exp.ucmp.urc.dto.RightsGrantDto;
import com.exp.ucmp.util.AesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import com.obs.services.exception.ObsException;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author gubonai
 * @date 2023年02月6日
 */
@Service
public class PsiRetentionServiceImpl extends BaseCluesService implements PsiRetentionService {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PsiRetentionServiceImpl.class);

    @Autowired
    private PsiRetentionDao psiRetentionDao;
    @Autowired
    private IPsiRetentionCluesDao iPsiRetentionCluesDao;
    @Autowired
    private IPsiCluesFollowRecordDao psiCluesFollowRecordDao;
    @Autowired
    private IPsiOrderFollowRecordDao orderFollowRecordDao;
    @Autowired
    private IPsiCarStockInfoDao carStockInfoDao;
    @Autowired
    private IPsiOrderInfoDao orderInfoDao;
    @Autowired
    ActivitiesFegin activitiesFegin;
    @Autowired
    private PsiCarStockInfoDao psiCarStockInfoDao;
    @Autowired
    private IPsiSalesCustomerDao psiSalesCustomerDao;
    @Autowired
    private PsiSalesCustomerDao salesCustomerDao;
    @Autowired
    private AcquisitionFollowService acquisitionFollowService;
    @Autowired
    private HwObsService hwObsService;
    @Autowired
    private PsiSalesModifyConfigDao psiSalesModifyConfigDao;

    @Autowired
    private PsiSalesOrderMaterialDao psiSalesOrderMaterialDao;

    @Autowired
    private UcmpAesConfig ucmpAesConfig;

    @Autowired
    private IPsiCluesStoreConfigDao iPsiCluesStoreConfigDao;

    @Autowired
    private SysRightActivitiesDao sysRightActivitiesDao;

    @Autowired
    private ISysRightActivitiesDistributeDetailsDao iSysRightActivitiesDistributeDetailsDao;

    @Autowired
    private ISysRegionDao iSysRegionDao;

    @Autowired
    private FileUploadService fileUploadService;
    
    @Autowired
    private HwOBSConfig hwOBSConfig;
    
    @Autowired
    private PsiPricingServiceImpl psiPricingServiceImpl;

    /**
     * 查询商城留资线索列表
     *
     * @param retentionCluesParamDto
     * @return
     */
    @Override
    public PageInfo<RetentionCluesDto> queryRetentionCluesList(RetentionCluesParamDto retentionCluesParamDto) throws Exception {
//        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        retentionCluesParamDto.setIsShow("01");
        if (StringUtils.isNotEmpty(retentionCluesParamDto.getCustomerPhone())) {
            retentionCluesParamDto.setCustomerPhone(AesUtils.encryptHex(retentionCluesParamDto.getCustomerPhone(), ucmpAesConfig.getSecret()));
        }
        //二手车主管所授权的门店(授权门店、创建人（导入）、商城线索（所有的二手车主管）)
//        retentionCluesParamDto.setIsEmpower("01");
//        retentionCluesParamDto.setEmpowerStoreIds(getEmpowerStoreId());
//        retentionCluesParamDto.setEmpowerCreatedBy(user.getPartyId());
//        retentionCluesParamDto.setEmpowerCluesSource(Constants.RetentionCluesSource.SHOPPING.getCode());
        PageHelper.startPage(retentionCluesParamDto.getPageNum(), retentionCluesParamDto.getPageSize());
        List<RetentionCluesDto> retentionCluesDtoList = psiRetentionDao.queryRetentionCluesList(retentionCluesParamDto);
        for (RetentionCluesDto retentionCluesDto : retentionCluesDtoList) {
            retentionCluesDto.setCustomerPhone(AesUtils.decryptHex(retentionCluesDto.getCustomerPhone(), ucmpAesConfig.getSecret()));
        }
        return new PageInfo<>(retentionCluesDtoList);
    }

    /**
     * 查询客户信息
     *
     * @param cluesId
     * @return
     */
    @Override
    public CustomerInfoDto queryCluesCustomerInfo(Long cluesId) throws Exception {
        CustomerInfoDto customerInfoDto = psiRetentionDao.queryCluesCustomerInfo(new PsiRetentionCluesPk(cluesId));
        customerInfoDto.setCustomerPhone(AesUtils.decryptHex(customerInfoDto.getCustomerPhone(), ucmpAesConfig.getSecret()));
        customerInfoDto.setCustomerCharacterName(Constants.CustomerCharacter.getName(customerInfoDto.getCustomerCharacter()));
        customerInfoDto.setPurchaseTimeName(Constants.PurchaseTime.getName(customerInfoDto.getPurchaseTime()));
        customerInfoDto.setFamilySituationName(Constants.FamilySituation.getName(customerInfoDto.getFamilySituation()));
        return customerInfoDto;
    }

    /**
     * 根据手机号查线索列表
     *
     * @param customerPhone
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<RetentionCluesDto> queryRetentionListByPhone(String customerPhone, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        RetentionCluesParamDto retentionCluesParamDto = new RetentionCluesParamDto();
        retentionCluesParamDto.setIsShow("02");
        retentionCluesParamDto.setCustomerPhone(customerPhone);
        List<RetentionCluesDto> retentionCluesDtoList = psiRetentionDao.queryRetentionCluesList(retentionCluesParamDto);
        return new PageInfo<>(retentionCluesDtoList);
    }

    /**
     * 跟进记录列表
     *
     * @param cluesId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<PsiCluesFollowRecordDto> queryCluesFollowRecord(Long cluesId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PsiCluesFollowRecordEntity psiCluesFollowRecordEntity = new PsiCluesFollowRecordEntity();
        psiCluesFollowRecordEntity.setCluesId(cluesId);
        psiCluesFollowRecordEntity.setIsEnable("01");
        List<PsiCluesFollowRecordDto> psiCluesFollowRecordEntityList = psiRetentionDao.queryCluesFollowRecord(psiCluesFollowRecordEntity);
        return new PageInfo<>(psiCluesFollowRecordEntityList);
    }

    /**
     * 查询订单列表信息
     *
     * @param orderInfoParamDto
     * @return
     */
    @Override
    public PageInfo<OrderInfoDto> queryOrderList(OrderInfoParamDto orderInfoParamDto) throws Exception {
        if (StringUtils.isNotEmpty(orderInfoParamDto.getCustomerPhone())) {
            orderInfoParamDto.setCustomerPhone(AesUtils.encryptHex(orderInfoParamDto.getCustomerPhone(), ucmpAesConfig.getSecret()));
        }
        orderInfoParamDto.setSalesStoreList(getEmpowerStoreId());
        PageHelper.startPage(orderInfoParamDto.getPageNum(), orderInfoParamDto.getPageSize());
        List<OrderInfoDto> orderInfoDtoList = psiRetentionDao.queryOrderList(orderInfoParamDto);
        for (OrderInfoDto orderInfoDto : orderInfoDtoList) {
            orderInfoDto.setCustomerPhone(AesUtils.decryptHex(orderInfoDto.getCustomerPhone(), ucmpAesConfig.getSecret()));
        }
        return new PageInfo<>(orderInfoDtoList);
    }


    /**
     * 获取车辆信息
     *
     * @param vin
     * @return
     */
    @Override
    public VhclInfoDto queryVhclInfo(String vin) {
        PsiCarStockInfoEntity psiCarStockInfoEntity = new PsiCarStockInfoEntity();
        VhclInfoDto customerInfoDto = new VhclInfoDto();
        psiCarStockInfoEntity.setVinCode(vin);
        psiCarStockInfoEntity.setStockState("5104");
        List<PsiCarStockInfoEntity> psiCarStockInfoEntities = carStockInfoDao.selectBySelective(psiCarStockInfoEntity);
        if (CollectionUtil.isNotEmpty(psiCarStockInfoEntities)) {
            customerInfoDto =
                    Copiers.beanToBean(psiCarStockInfoEntities.get(0), PsiCarStockInfoEntity.class, VhclInfoDto.class);
        }
        return customerInfoDto;
    }

    /**
     * 查询商城已上架vin列表
     *
     * @param
     * @return
     */
    @Override
    public List<String> queryVinList() {
        return psiRetentionDao.queryVinList();
    }

    /**
     * 添加跟进
     *
     * @param paramDto
     * @return
     */
    @Override
    public String saveFollow(SaveFollowDto paramDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiCluesFollowRecordEntity psiCluesFollowRecordEntity = new PsiCluesFollowRecordEntity();
        psiCluesFollowRecordEntity =
                Copiers.beanToBean(paramDto, SaveFollowDto.class, PsiCluesFollowRecordEntity.class);
        psiCluesFollowRecordEntity.generatePk();
        psiCluesFollowRecordEntity.setCreatedBy(user.getPartyId());
        psiCluesFollowRecordEntity.setCreatedDate(new Date());
        psiCluesFollowRecordEntity.setUpdatedBy(user.getPartyId());
        psiCluesFollowRecordEntity.setUpdatedDate(new Date());
        psiCluesFollowRecordEntity.setFollowPerson(user.getPartyId());
        psiCluesFollowRecordEntity.setFollowStatus("01");
        psiCluesFollowRecordDao.insertSelective(psiCluesFollowRecordEntity);

        //修改线索表跟进状态
        PsiRetentionCluesEntity retentionCluesEntity = new PsiRetentionCluesEntity();
        retentionCluesEntity.setCluesId(paramDto.getCluesId());
        retentionCluesEntity.setFollowStatus("7802");
        iPsiRetentionCluesDao.updateSelective(retentionCluesEntity);
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
     * 保存订单
     *
     * @param paramDto
     * @return
     */
    @Override
    public String saveOrder(SaveOrderDto paramDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiOrderInfoEntity orderInfoEntity = new PsiOrderInfoEntity();
        orderInfoEntity =
                Copiers.beanToBean(paramDto, SaveOrderDto.class, PsiOrderInfoEntity.class);
        orderInfoEntity.setOrderPrice(orderInfoEntity.getReceivablePrice());
        if (Objects.isNull(paramDto.getOrderInfoId())) {
            //生成单号
            String orderNumber = getOddNumbers(psiRetentionDao.findNewOddNumbers());
            orderInfoEntity.generatePk();
            orderInfoEntity.setOrderNo(orderNumber);
            orderInfoEntity.setOrderStatus("7802");
            orderInfoEntity.setCreatedBy(user.getPartyId());
            orderInfoEntity.setCreatedDate(new Date());
            orderInfoEntity.setUpdatedBy(user.getPartyId());
            orderInfoEntity.setUpdatedDate(new Date());
            orderInfoDao.insertSelective(orderInfoEntity);
            //订单状态变更记录
            PsiOrderFollowRecordEntity orderFollowRecordEntity = new PsiOrderFollowRecordEntity();
            orderFollowRecordEntity.setOrderInfoId(orderInfoEntity.getOrderInfoId());
            orderFollowRecordEntity.setFollowStatus("7802");
            orderFollowRecordEntity.setCreatedBy(user.getPartyId());
            orderFollowRecordEntity.setCreatedDate(new Date());
            orderFollowRecordEntity.setIsEnable("01");
            orderFollowRecordEntity.setIsDelete("00");
            orderFollowRecordDao.insert(orderFollowRecordEntity);
        } else {
            if (ObjectUtil.isNotNull(orderInfoEntity.getBalancePaymentTime())) {
                //尾款已支付
                //获取用车人的uid
                //RestResponse<String> restResponse=systemConsumer.urmUserUid(orderInfoEntity.getMainUserPhone());
                //获取权益包编号
                PsiCarStockInfoEntity carStockInfoEntity = new PsiCarStockInfoEntity();
                carStockInfoEntity.setVinCode(orderInfoEntity.getCarVin());
                List<PsiCarStockInfoEntity> psiCarStockInfoEntities = carStockInfoDao.selectBySelective(carStockInfoEntity);
                //发放权益包
                RightsGrantDto grantDto = new RightsGrantDto();
                grantDto.setRightPackId(psiCarStockInfoEntities.get(0).getRightPackId());
                //grantDto.setSuperId(restResponse.getResult());
                grantDto.setSuperId("PA679363017986461696");
                grantDto.setVin(orderInfoEntity.getCarVin());
                RestResponse<Long> rightsGrant = activitiesFegin.rightsGrant(grantDto);
                LOGGER.error("====[权益发放]activitiesFegin.rightsGrant调用接口返回:{}", JSON.toJSONString(rightsGrant));

                //订单状态变更记录
                PsiOrderFollowRecordEntity orderFollowRecordEntity = new PsiOrderFollowRecordEntity();
                orderFollowRecordEntity.setOrderInfoId(orderInfoEntity.getOrderInfoId());
                orderFollowRecordEntity.setFollowStatus("7803");
                orderFollowRecordEntity.setCreatedBy(user.getPartyId());
                orderFollowRecordEntity.setCreatedDate(new Date());
                orderFollowRecordEntity.setIsEnable("01");
                orderFollowRecordEntity.setIsDelete("00");
                orderFollowRecordDao.insert(orderFollowRecordEntity);
                //订单状态修改为已支付
                orderInfoEntity.setOrderStatus("7803");
            }
            orderInfoEntity.setUpdatedBy(user.getPartyId());
            orderInfoEntity.setUpdatedDate(new Date());
            orderInfoDao.updateSelective(orderInfoEntity);
        }
        return "保存成功";
    }

    /**
     * 获取订单详情
     *
     * @param orderInfoId
     * @return
     */
    @Override
    public PsiOrderInfoDto queryOrderInfo(Long orderInfoId) throws Exception {
        PsiOrderInfoDto psiOrderInfoEntities = psiRetentionDao.queryDetails(orderInfoId);
        if (Objects.nonNull(psiOrderInfoEntities.getEncryptionCustomerPhone())) {
            psiOrderInfoEntities.setCustomerPhone(AesUtils.decryptHex(psiOrderInfoEntities.getEncryptionCustomerPhone(), ucmpAesConfig.getSecret()));
        }
        List<PsiSalesOrderMaterialDto> orderMaterialDtos = psiSalesOrderMaterialDao.selectByOrderInfoId(orderInfoId);
        psiOrderInfoEntities.setSalesOrderMaterialDtoList(orderMaterialDtos);
        //查询收款记录
        List<PayRecordDto> payRecordList = psiRetentionDao.queryPayRecords(orderInfoId);
        psiOrderInfoEntities.setPayRecordList(payRecordList);
        //查询最新一条改价记录
        OrderChangePriceDto orderChangePriceDto = this.psiRetentionDao.queryChangePrice(orderInfoId);
        if(orderChangePriceDto != null){
        	//查询改价材料
        	List<OrderChangeFileDto> fileList = this.psiRetentionDao.queryFileList(orderChangePriceDto.getRecordId());
        	this.appendUrl(fileList);
        	orderChangePriceDto.setFileList(fileList);
        }
        psiOrderInfoEntities.setOrderChangePriceDto(orderChangePriceDto);
        return psiOrderInfoEntities;
    }
    
    private void appendUrl(List<OrderChangeFileDto> picDtoList) {
		if(picDtoList != null && !picDtoList.isEmpty()){
			for (OrderChangeFileDto oneselfCarPicDto : picDtoList) {
				oneselfCarPicDto.setFileUrl(hwOBSConfig.getFileUri()+oneselfCarPicDto.getFileUrl());
			}
		}
	}

    @Override
    public void cluesTransference(CluesTransferenceDto transferenceDto) {
        /**
         *
         一位客户对应一家门店且对应一位销售
         需求：转让为客户整体转让，页面操作一条线索，则该客户下所有的线索、订单 整体转让
         ps：线索、订单已完成的历史数据，不做改动，
         1.线索是待跟进、跟进中，修改跟进人、门店
         2.订单转交付前，销售门店、出行顾问 进行变更
         3.销售客户表，直接更新客户门店、跟进人
         *
         */
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiRetentionCluesEntity load = iPsiRetentionCluesDao.load(new PsiRetentionCluesPk(transferenceDto.getCluesId()));
        if (Objects.isNull(load)) {
            throw new IllegalParameterException("该线索不存在");
        }
        //线索分配
        if (Objects.isNull(load.getCustomerId())) {
            PsiSalesCustomerEntity psiSalesCustomerEntity = new PsiSalesCustomerEntity();
            psiSalesCustomerEntity.generatePk();
            psiSalesCustomerEntity.setStoreId(transferenceDto.getFollowStore());
            psiSalesCustomerEntity.setPartyId(transferenceDto.getFollowPerson());
            psiSalesCustomerEntity.setCustomerPhone(load.getCustomerPhone());
            psiSalesCustomerEntity.setCustomerName(load.getCustomerName());
            psiSalesCustomerEntity.setModelCode(load.getModelCode());
            psiSalesCustomerEntity.setModelName(load.getModelName());
            psiSalesCustomerEntity.setDeliveryPlace(load.getDeliveryPlace());
            if(Objects.nonNull(load.getStockId())){
                //车辆查询
                PsiCarStockInfoEntity stockInfo = carStockInfoDao.load(new PsiCarStockInfoPk(load.getStockId()));
                psiSalesCustomerEntity.setVin(stockInfo.getVinCode());
            }
            psiSalesCustomerEntity.setFollowBy(transferenceDto.getFollowPerson());
            psiSalesCustomerEntity.setFollowName(psiRetentionDao.selectPersonName(transferenceDto.getFollowPerson()));
            psiSalesCustomerEntity.setCustomerCharacter(load.getCustomerCharacter());
            psiSalesCustomerEntity.setPurchaseTime(load.getPurchaseTime());
            psiSalesCustomerEntity.setFamily(load.getFamilySituation());
            psiSalesCustomerEntity.setFollowTime(new Date());
            psiSalesCustomerEntity.setCreatedBy(user.getPartyId());
            psiSalesCustomerEntity.setCreatedDate(new Date());
            psiSalesCustomerEntity.setUpdatedBy(user.getPartyId());
            psiSalesCustomerEntity.setUpdatedDate(new Date());
            psiSalesCustomerDao.insertSelective(psiSalesCustomerEntity);
            psiRetentionDao.updatePhoneFollowPerson(psiSalesCustomerEntity.getCustomerPhone(),
                    psiSalesCustomerEntity.getCustomerId(),
                    transferenceDto.getFollowStore(),
                    transferenceDto.getFollowPerson(),user.getPartyId());
            //发送提醒
            List<SalesConsultantDto> partyInfo = getPartyInfo(null, null, null, transferenceDto.getFollowPerson(),null);
            List<String> params = new ArrayList<>();
            params.add(load.getCustomerName());
            params.add(load.getDeliveryPlace());
            giveMessage(null,"UCMP",1,partyInfo.get(0).getStaffCode(),0,null,params);
            return;
        }
        //转让
        customerAllocation(load.getCustomerId(),null,transferenceDto.getFollowStore(),
                transferenceDto.getFollowPerson(),load.getCustomerName(),load.getDeliveryPlace());
//        //转让
//        PsiSalesCustomerEntity psiSalesCustomerEntity = new PsiSalesCustomerEntity();
//        psiSalesCustomerEntity.setCustomerId(load.getCustomerId());
//        psiSalesCustomerEntity.setStoreId(transferenceDto.getFollowStore());
//        psiSalesCustomerEntity.setPartyId(transferenceDto.getFollowPerson());
//        psiSalesCustomerEntity.setUpdatedBy(user.getPartyId());
//        psiSalesCustomerEntity.setUpdatedDate(new Date());
//        psiSalesCustomerDao.updateSelective(psiSalesCustomerEntity);
//        psiRetentionDao.updateStoreClues(load.getCustomerId(), load.getFollowStore(),
//                transferenceDto.getFollowStore(), transferenceDto.getFollowPerson(), user.getPartyId());
//        psiRetentionDao.updateStoreOrder(load.getCustomerId(), load.getFollowStore(),
//                transferenceDto.getFollowStore(), transferenceDto.getFollowPerson(), user.getPartyId());
//
//        //发送消息提醒（销售人员）
//        List<SalesConsultantDto> partyInfo = getPartyInfo(null, null, null, transferenceDto.getFollowPerson(),null);
//        List<String> params = new ArrayList<>();
//        params.add(load.getCustomerName());
//        params.add(load.getDeliveryPlace());
//        giveMessage(null,"UCMP",1,partyInfo.get(0).getStaffCode(),0,null,params);

    }

    @Override
    @Transactional
    public String readExcel(MultipartFile file) throws IOException {

        if (file.isEmpty()) {
            throw new RuntimeException("文件异常,请重新选择");
        }
        String fileName = file.getOriginalFilename();
        StringBuffer result = new StringBuffer();
        //判断文件类型
        if (StringUtils.isNotBlank(fileName)) {
            if (!fileName.endsWith(ExcelTypeEnum.XLS.getValue()) && !fileName.endsWith(ExcelTypeEnum.XLSX.getValue())) {
                throw new RuntimeException("文件格式错误,请重新选择 xlsx 或 xls 格式文件");
            }
            List<CluesInfoImportExcelEntity> datas = new ArrayList<>();
            try {
                //有个很重要的点 ExcelListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
                EasyExcel.read(file.getInputStream(), CluesInfoImportExcelEntity.class,
                        new CluesInfoImportExtraListener(datas)).sheet().doRead();
            } catch (Exception e) {
                e.printStackTrace();
            }


            if (CollectionUtils.isEmpty(datas)) {
                throw new RuntimeException("导入的模板文件不能为空!");
            }
            //手机号加密
            for (CluesInfoImportExcelEntity data : datas) {
                if (Objects.isNull(data.getMsg())) {
                    data.setEncryptionPhone(AesUtils.encryptHex(data.getCustomerPhone(), ucmpAesConfig.getSecret()));
                }
            }

            Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
            //销售客户表
            Map<String, PsiSalesCustomerEntity> customerPhoneMap = new HashMap<>();
            List<String> customerPhoneList = datas.stream().filter(item -> Objects.nonNull(item.getCustomerPhone()))
                    .map(CluesInfoImportExcelEntity::getEncryptionPhone).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(customerPhoneList)) {
                List<PsiSalesCustomerEntity> psiSalesCustomerEntities = psiRetentionDao.selectAllPerson(null,null,customerPhoneList);
                if (CollectionUtils.isNotEmpty(psiSalesCustomerEntities)) {
                    customerPhoneMap = psiSalesCustomerEntities.stream().collect(Collectors.toMap(key -> key.getCustomerPhone(), entity -> entity));
                }
            }
            //车辆库存表
            Map<String, CarStockInfoDto> carStockInfoMap = new HashMap<>();
            List<String> vinList = datas.stream().filter(item -> Objects.nonNull(item.getCustomerPhone()))
                    .map(CluesInfoImportExcelEntity::getVin).collect(Collectors.toList());
            if (CollectionUtils.isNotEmpty(vinList)) {
                CarStockInfoListQueryDto carStockInfoListQueryDto = new CarStockInfoListQueryDto();
                carStockInfoListQueryDto.setVinCodeList(vinList);
                carStockInfoListQueryDto.setStockState("5104");
                carStockInfoListQueryDto.setRepealIs("00");
                carStockInfoListQueryDto.setDecisionType("2301");
                List<CarStockInfoDto> carStockInfoDtos = psiCarStockInfoDao.selectCarStockList(carStockInfoListQueryDto);
                if (CollectionUtils.isNotEmpty(carStockInfoDtos)) {
                    carStockInfoMap = carStockInfoDtos.stream().collect(Collectors.toMap(CarStockInfoDto::getVinCode, entity -> entity));
                }
            }
            //线索分配
            Map<String, PsiCluesStoreConfigEntity> cluesStoreMap = new HashMap<>();
            PsiCluesStoreConfigEntity configParamEntity = new PsiCluesStoreConfigEntity();
            configParamEntity.setStatus("01");
            List<PsiCluesStoreConfigEntity> psiCluesStoreConfigEntities = iPsiCluesStoreConfigDao.selectBySelective(configParamEntity);
            if (CollectionUtils.isNotEmpty(psiCluesStoreConfigEntities)) {
                cluesStoreMap = psiCluesStoreConfigEntities.stream().collect(Collectors.toMap(PsiCluesStoreConfigEntity::getCityName, entity -> entity));
            }
            // 城市
            SysRegionEntity sysRegionEntity = new SysRegionEntity();
            sysRegionEntity.setRegionLevel(3);
            List<SysRegionEntity> sysRegionList = iSysRegionDao.selectBySelective(sysRegionEntity);
            List<String> cityName = sysRegionList.stream().map(SysRegionEntity::getRegionName).collect(Collectors.toList());


            List<PsiRetentionCluesEntity> list = new ArrayList<>();
            List<PsiSalesCustomerEntity> insertPsiSalesCustomerEntity = new ArrayList<>();
            List<PsiSalesCustomerEntity> updatePsiSalesCustomerEntity = new ArrayList<>();
            List<String> updateCluesOrder = new ArrayList<>();
            for (CluesInfoImportExcelEntity data : datas) {
                if (Objects.nonNull(data.getMsg())) {
                    continue;
                }
                //校验vin
                CarStockInfoDto carStockInfoDto = null;
                if (StringUtils.isNotEmpty(data.getVin())) {
                    carStockInfoDto = carStockInfoMap.get(data.getVin());
                    if (Objects.isNull(carStockInfoDto)) {
                        data.setMsg("vin有误;");
                        continue;
                    }
                }

                //校验意向上牌地
                if (!cityName.contains(data.getDeliveryPlace())) {
                    data.setMsg("城市有误;");
                    continue;
                }
                PsiSalesCustomerEntity salesCustomer = customerPhoneMap.get(data.getEncryptionPhone());
                PsiSalesCustomerEntity psiSalesCustomerEntity = new PsiSalesCustomerEntity();
                if (Objects.nonNull(salesCustomer)){
                    BeanUtils.copyProperties(salesCustomer,psiSalesCustomerEntity);
                }
                if(Objects.isNull(psiSalesCustomerEntity.getStoreId())){
                    //该客户未分配到店，根据城市分配
                    PsiCluesStoreConfigEntity cluesStoreConfigEntity = cluesStoreMap.get(data.getDeliveryPlace());
                    if(Objects.nonNull(cluesStoreConfigEntity)){
                        psiSalesCustomerEntity.setStoreId(cluesStoreConfigEntity.getStoreId());
                        updateCluesOrder.add(data.getEncryptionPhone());
                    }
                }
//                    psiSalesCustomerEntity.setModelCode("123");  意向车型不做校验，code暂无需填写（意向车型调用SMP接口，数据获取不到）
                psiSalesCustomerEntity.setModelName(data.getShapeName());
                psiSalesCustomerEntity.setDeliveryPlace(data.getDeliveryPlace());
                psiSalesCustomerEntity.setVin(data.getVin());
                psiSalesCustomerEntity.setUpdatedBy(user.getPartyId());
                psiSalesCustomerEntity.setUpdatedDate(new Date());
                if (Objects.isNull(salesCustomer)){
                    psiSalesCustomerEntity.generatePk();
                    psiSalesCustomerEntity.setCustomerPhone(data.getEncryptionPhone());
                    psiSalesCustomerEntity.setCustomerName(data.getCustomerName());
                    psiSalesCustomerEntity.setCreatedBy(user.getPartyId());
                    psiSalesCustomerEntity.setCreatedDate(new Date());
                    insertPsiSalesCustomerEntity.add(psiSalesCustomerEntity);
                    customerPhoneMap.put(psiSalesCustomerEntity.getCustomerPhone(), psiSalesCustomerEntity);
                } else {
                    updatePsiSalesCustomerEntity.add(psiSalesCustomerEntity);
                }
                PsiRetentionCluesEntity addClues = new PsiRetentionCluesEntity();
                if (Objects.nonNull(carStockInfoDto)) {
                    addClues.setStockId(carStockInfoDto.getStockId());
                    addClues.setStorageId(carStockInfoDto.getStorageId());
                    addClues.setSalePrice(carStockInfoDto.getSalePrice());
                }
                addClues.generatePk();
                addClues.setFollowStore(psiSalesCustomerEntity.getStoreId());
                addClues.setFollowPerson(psiSalesCustomerEntity.getPartyId());
                addClues.setCustomerId(psiSalesCustomerEntity.getCustomerId());
                addClues.setCluesSource(Constants.RetentionCluesSource.IMPORT.getCode());
                addClues.setCustomerName(data.getCustomerName());
                addClues.setCustomerPhone(data.getEncryptionPhone());
                addClues.setModelName(data.getShapeName());
                addClues.setDeliveryPlace(data.getDeliveryPlace());
                addClues.setFollowStatus(Constants.FollowStatus.NOT_FOLLOWED_UP.getCode());
                addClues.setRetentionTime(new Date());
                addClues.setIsShow("00");
                addClues.setIsEnable("01");
                addClues.setCreatedBy(user.getPartyId());
                addClues.setCreatedDate(new Date());
                addClues.setUpdatedBy(user.getPartyId());
                addClues.setUpdatedDate(new Date());
                addClues.setIsDelete("00");
                list.add(addClues);
            }
            if (CollectionUtils.isNotEmpty(insertPsiSalesCustomerEntity)) {
                psiSalesCustomerDao.batchInsert(insertPsiSalesCustomerEntity);
            }
            if (CollectionUtils.isNotEmpty(list)) {
                iPsiRetentionCluesDao.batchInsert(list);
            }
            if (CollectionUtils.isNotEmpty(updatePsiSalesCustomerEntity)) {
                psiRetentionDao.batchUpdateCustomer(updatePsiSalesCustomerEntity);
            }
            //场景：导入文件中手机号一样，线索由多条，意向上牌地不一样，其中一条可通过配置分配到店；（ps：根据上牌地分配）
            //其他线索未分配到店时，进行转让或客户分配时，会分配到同一销售人员（ps：根据上牌地分配，如果直接分配到人,则需要修改）
//            for (String phone : updateCluesOrder) {
//                PsiSalesCustomerEntity salesCustomerEntity = customerPhoneMap.get(phone);
//                //1.有线索未分配
//                psiRetentionDao.updatePhoneFollowPerson(phone, salesCustomerEntity.getCustomerId(),
//                        salesCustomerEntity.getStoreId(), salesCustomerEntity.getPartyId(),user.getPartyId());
//                //2.有订单未分配
//                psiRetentionDao.updateStoreOrder(salesCustomerEntity.getCustomerId(),null,
//                        salesCustomerEntity.getStoreId(),salesCustomerEntity.getPartyId(),user.getPartyId());
//            }

            //未分配到人：发送消息提醒给店长  分配到人：发送消息提醒给銷售人員（取一條線索發送）
            Map<Long, List<PsiRetentionCluesEntity>> listMap = list.stream().filter(item -> (Objects.nonNull(item.getFollowStore()) && Objects.isNull(item.getFollowPerson()))).collect(Collectors.groupingBy(PsiRetentionCluesEntity::getFollowStore));
            if(MapUtils.isNotEmpty(listMap)){
                //店长
                List<SalesConsultantDto> partyInfoList = getPartyInfo(Constants.slfRole.SH.value(), null,new ArrayList<>(listMap.keySet()),null,null);
                if(CollectionUtils.isNotEmpty(partyInfoList)){
                    for (SalesConsultantDto salesConsultantDto : partyInfoList) {
                        List<PsiRetentionCluesEntity> cluesEntities = listMap.get(salesConsultantDto.getStoreId());
                        List<String> params = new ArrayList<>();
                        params.add(String.valueOf(cluesEntities.size()));
                        params.add(cluesEntities.stream().distinct().map(PsiRetentionCluesEntity::getCustomerName).collect(Collectors.joining("、")));
                        giveMessage(Constants.templateId.templateTitleNine.value(),"UCMP",1,salesConsultantDto.getStaffCode(),0,null,params);
                    }
                }
            }
            Map<Long, List<PsiRetentionCluesEntity>> listPartyMap = list.stream().filter(item -> (Objects.nonNull(item.getFollowStore()) && Objects.nonNull(item.getFollowPerson()))).collect(Collectors.groupingBy(PsiRetentionCluesEntity::getFollowPerson));
            if(MapUtils.isNotEmpty(listPartyMap)){
                //銷售人員
                List<SalesConsultantDto> partyInfoList = getPartyInfo(null, null,null,null,new ArrayList<>(listPartyMap.keySet()));
                if(CollectionUtils.isNotEmpty(partyInfoList)){
                    for (SalesConsultantDto salesConsultantDto : partyInfoList) {
                        List<PsiRetentionCluesEntity> cluesEntities = listPartyMap.get(salesConsultantDto.getPartyId());
                        List<String> params = new ArrayList<>();
                        params.add(cluesEntities.get(0).getCustomerName());
                        params.add(cluesEntities.get(0).getDeliveryPlace());
                        giveMessage(Constants.templateId.templateTitleTen.value(),"UCMP",1,salesConsultantDto.getStaffCode(),0,null,params);
                    }
                }
            }
            int allSize = datas.size();
            int successSize = list.size();
            int failSize = allSize - successSize;
            result.append("导入成功");
            if (failSize > 0) {
                result.append(successSize);
                result.append("条，失败");
                result.append(failSize);
                result.append("条！失败原因：必填字段为空或VIN、意向上牌地有误");
                return result.toString();
            }
        }

        return "1";
    }

    @Override
    public RestResponse<String> fileDownload(HttpServletRequest request, HttpServletResponse response) {
        String objKey = acquisitionFollowService.getObjKey("998", null);
        try (InputStream inputStream = hwObsService.fileDownload(objKey);
             BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream())) {
            // 为防止 文件名出现乱码
            final String userAgent = request.getHeader("USER-AGENT");
            // IE浏览器
            if (StringUtils.contains(userAgent, "MSIE")) {
                objKey = URLEncoder.encode(objKey, "UTF-8");
            } else {
                // google,火狐浏览器
                if (StringUtils.contains(userAgent, "Mozilla")) {
                    objKey = new String(objKey.getBytes(), "ISO8859-1");
                } else {
                    // 其他浏览器
                    objKey = URLEncoder.encode(objKey, "UTF-8");
                }
            }
            IoUtil.copy(inputStream, outputStream);

            return new RestResponse<>(RestStatusCode.OK);
        } catch (ObsException | IOException e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
        }
        return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
    }

    @Override
    public String activation(Long cluesId) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        //修改线索状态并更新跟进人（ps：客户进行了跨店转让后激活，需要把跟进人更新成最新的）
        //战败激活：无跟进记录：7801待跟进 有跟进记录：7802跟进中
        String followStatus = Constants.FollowStatus.NOT_FOLLOWED_UP.getCode();
        PsiCluesFollowRecordEntity psiCluesFollowRecordEntity = new PsiCluesFollowRecordEntity();
        psiCluesFollowRecordEntity.setCluesId(cluesId);
        List<PsiCluesFollowRecordEntity> psiCluesFollowRecordEntities = psiCluesFollowRecordDao.selectBySelective(psiCluesFollowRecordEntity);
        if (CollectionUtils.isNotEmpty(psiCluesFollowRecordEntities)) {
            followStatus = Constants.FollowStatus.FOLLOWED_UP.getCode();
        }

        PsiRetentionCluesEntity psiRetentionCluesEntity = iPsiRetentionCluesDao.load(new PsiRetentionCluesPk(cluesId));
        PsiSalesCustomerEntity customerEntity = psiSalesCustomerDao.load(new PsiSalesCustomerPk(psiRetentionCluesEntity.getCustomerId()));
        psiRetentionCluesEntity.setFollowStatus(followStatus);
        psiRetentionCluesEntity.setFollowStore(customerEntity.getStoreId());
        psiRetentionCluesEntity.setFollowPerson(customerEntity.getPartyId());
        psiRetentionCluesEntity.setUpdatedBy(user.getPartyId());
        psiRetentionCluesEntity.setUpdatedDate(new Date());
        iPsiRetentionCluesDao.update(psiRetentionCluesEntity);
        if(Objects.isNull(psiRetentionCluesEntity.getFollowPerson())){
            LOGGER.info("线索激活跟进人为空，未发送消息提醒，线索ID：{} 跟进门店：{} 跟进人：{}",psiRetentionCluesEntity.getCluesId(),
                    psiRetentionCluesEntity.getFollowStore(),psiRetentionCluesEntity.getFollowPerson());
            return "操作成功";
        }
        //发送消息提醒给所属销售人员
        List<SalesConsultantDto> partyInfo = getPartyInfo(null, null,null, psiRetentionCluesEntity.getFollowPerson(),null);
        if(CollectionUtils.isNotEmpty(partyInfo)){
            List<String> params = new ArrayList<>();
            params.add(psiRetentionCluesEntity.getCustomerName());
            params.add(psiRetentionCluesEntity.getDeliveryPlace());
            giveMessage(Constants.templateId.templateTitleSixteen.value(), "UCMP",1,partyInfo.get(0).getStaffCode(),0,null,params);
        }
        return "操作成功";
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createModify(PsiSalesModifyConfigCreateDto createDto) {
        PsiCarStockInfoEntity psiCarStockInfoEntity = checkVin(createDto.getChangeVin());
        //车辆是否已被锁定
        carLock(String.valueOf(createDto.getOrderInfoId()),createDto.getChangeVin());
        PsiOrderInfoEntity load = orderInfoDao.load(new PsiOrderInfoPk(createDto.getOrderInfoId()));
        //校验改配车辆销售金额是否小于已收金额
        checkPrice(psiCarStockInfoEntity.getSalePrice(),load.getReceivedPrice());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiSalesModifyConfigEntity psiSalesModifyConfigEntity = Copiers.beanToBean(createDto, PsiSalesModifyConfigCreateDto.class, PsiSalesModifyConfigEntity.class);
        psiSalesModifyConfigEntity.generatePk();
        psiSalesModifyConfigEntity.setApproveResult(Constants.ApproveResult.SUCCESS.getCode());
        psiSalesModifyConfigEntity.setApplyBy(user.getPartyId());
        psiSalesModifyConfigEntity.setApplyDate(new Date());
        psiSalesModifyConfigEntity.setApproveBy(user.getPartyId());
        psiSalesModifyConfigEntity.setApproveDate(new Date());
        psiSalesModifyConfigEntity.setApplySource(2);
        psiSalesModifyConfigDao.insert(psiSalesModifyConfigEntity);
        PsiOrderInfoEntity psiOrderInfoEntity = new PsiOrderInfoEntity();
        psiOrderInfoEntity.setOrderInfoId(createDto.getOrderInfoId());
        psiOrderInfoEntity.setCarVin(createDto.getChangeVin());
        psiOrderInfoEntity.setOrderPrice(psiCarStockInfoEntity.getSalePrice());
        psiOrderInfoEntity.setStockId(String.valueOf(psiCarStockInfoEntity.getStockId()));
        psiOrderInfoEntity.setReceivablePrice(psiCarStockInfoEntity.getSalePrice());
        psiOrderInfoEntity.setReceivedPrice(load.getReceivedPrice());
        //计算未收款金额
        BigDecimal receivedPrice = java.util.Objects.nonNull(load.getReceivedPrice()) ? load.getReceivedPrice() : BigDecimal.ZERO;
        Double notReceivedPrice = psiCarStockInfoEntity.getSalePrice().doubleValue()-receivedPrice.doubleValue();
        psiOrderInfoEntity.setNotReceivedPrice(BigDecimal.valueOf(notReceivedPrice));
        orderInfoDao.updateSelective(psiOrderInfoEntity);
        //更新库存状态
        List<PsiCarStockInfoEntity> listPsiCarStockInfoEntity = new ArrayList<>();
        PsiCarStockInfoEntity update1 = new PsiCarStockInfoEntity();
        update1.setVinCode(psiSalesModifyConfigEntity.getVin());
        update1.setStockState("5104");
        update1.setStockId(Long.valueOf(load.getStockId()));
        PsiCarStockInfoEntity update2 = new PsiCarStockInfoEntity();
        update2.setVinCode(psiSalesModifyConfigEntity.getChangeVin());
        update2.setStockState("5105");
        update2.setStockId(psiCarStockInfoEntity.getStockId());
        listPsiCarStockInfoEntity.add(update1);
        listPsiCarStockInfoEntity.add(update2);
        psiRetentionDao.batchUpdateStockState(listPsiCarStockInfoEntity);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modifyApprove(PsiSalesModifyConfigApproveDto dto) {
        /**
         改配驳回：更新销售申请的改配记录,更新订单状态
         改配通过：
         1.校验vin是否在售
         2.1总部更改了vin:销售申请改配记录取消，新增一条总部申请改配记录
         2.2总部未更改了vin:销售申请改配记录通过，
         3.更新订单信息
         4.车辆库存修改（原vin车辆库存状态 改为：在售中； 变更vin车辆库存状态：已预订）
         */
        PsiOrderInfoEntity load = orderInfoDao.load(new PsiOrderInfoPk(dto.getOrderInfoId()));
        //模板ID
        String templateId = null;
        PsiSalesModifyConfigEntity psiSalesModifyConfigEntity = psiSalesModifyConfigDao.selectByPrimaryKey(dto.getApplyId());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        if (Objects.equals(Constants.ApproveResult.REJECT.getCode(), dto.getApproveResult())) {
            templateId = Constants.templateId.templateTitleFifteen.value();
            psiSalesModifyConfigEntity.setApproveBy(user.getPartyId());
            psiSalesModifyConfigEntity.setApproveResult(Constants.ApproveResult.REJECT.getCode());
            psiSalesModifyConfigEntity.setApproveDate(new Date());
            psiSalesModifyConfigEntity.setRejectReasons(dto.getRejectReasons());
            psiSalesModifyConfigDao.updateByPrimaryKeySelective(psiSalesModifyConfigEntity);
            PsiOrderInfoEntity psiOrderInfoEntity = new PsiOrderInfoEntity();
            psiOrderInfoEntity.setOrderInfoId(psiSalesModifyConfigEntity.getOrderInfoId());
            psiOrderInfoEntity.setOrderStatus(psiSalesModifyConfigEntity.getOrderStatus());
            orderInfoDao.updateSelective(psiOrderInfoEntity);
            createOrderFollowRecord(psiOrderInfoEntity.getOrderInfoId(),psiOrderInfoEntity.getOrderStatus());
        }
        if (Objects.equals(Constants.ApproveResult.SUCCESS.getCode(), dto.getApproveResult())) {
            templateId = Constants.templateId.templateTitleFourteen.value();
            //车辆是否在售
            PsiCarStockInfoEntity psiCarStockInfoEntity = checkVin(dto.getChangeVin());
            //车辆是否已被锁定
            carLock(String.valueOf(dto.getOrderInfoId()),dto.getChangeVin());
            psiSalesModifyConfigEntity.setApproveBy(user.getPartyId());
            psiSalesModifyConfigEntity.setApproveResult(Constants.ApproveResult.SUCCESS.getCode());
            psiSalesModifyConfigEntity.setApproveDate(new Date());
            //总部是否修改了vin
            Boolean isUpdate = false;
            if (!Objects.equals(psiSalesModifyConfigEntity.getChangeVin(), dto.getChangeVin())) {
                isUpdate = true;
                //总部修改了vin，销售人员申请改配取消
                psiSalesModifyConfigEntity.setApproveResult(Constants.ApproveResult.CANCEL.getCode());
                psiSalesModifyConfigEntity.setRemark("总部修改vin,取消该申请");
            }
            //更新改配记录
            psiSalesModifyConfigDao.updateByPrimaryKey(psiSalesModifyConfigEntity);
            //总部修改了vin，新增一条改配记录，并直接审核通过
            if (isUpdate) {
                PsiSalesModifyConfigEntity insert = new PsiSalesModifyConfigEntity();
                insert.generatePk();
                insert.setOrderInfoId(psiSalesModifyConfigEntity.getOrderInfoId());
                insert.setOrderStatus(psiSalesModifyConfigEntity.getOrderStatus());
                insert.setVin(psiSalesModifyConfigEntity.getVin());
                insert.setChangeVin(dto.getChangeVin());
                insert.setApplyBy(user.getPartyId());
                insert.setApplyDate(new Date());
                insert.setApproveBy(user.getPartyId());
                insert.setApproveDate(new Date());
                insert.setApproveResult(Constants.ApproveResult.SUCCESS.getCode());
                insert.setApplySource(2);
                psiSalesModifyConfigDao.insert(insert);
            }
            //修改订单表状态
            PsiOrderInfoEntity psiOrderInfoEntity = new PsiOrderInfoEntity();
            psiOrderInfoEntity.setOrderInfoId(psiSalesModifyConfigEntity.getOrderInfoId());
            psiOrderInfoEntity.setOrderStatus(psiSalesModifyConfigEntity.getOrderStatus());
            psiOrderInfoEntity.setOrderPrice(psiCarStockInfoEntity.getSalePrice());
            psiOrderInfoEntity.setCarVin(dto.getChangeVin());
            psiOrderInfoEntity.setStockId(psiCarStockInfoEntity.getStockId().toString());
            psiOrderInfoEntity.setOrderPrice(psiCarStockInfoEntity.getSalePrice());
            psiOrderInfoEntity.setReceivablePrice(psiCarStockInfoEntity.getSalePrice());
            psiOrderInfoEntity.setReceivedPrice(load.getReceivedPrice());
            //计算未收款金额
            BigDecimal receivedPrice = java.util.Objects.nonNull(load.getReceivedPrice()) ? load.getReceivedPrice() : BigDecimal.ZERO;
            Double notReceivedPrice = psiCarStockInfoEntity.getSalePrice().doubleValue()-receivedPrice.doubleValue();
            psiOrderInfoEntity.setNotReceivedPrice(BigDecimal.valueOf(notReceivedPrice));
            orderInfoDao.updateSelective(psiOrderInfoEntity);
            createOrderFollowRecord(psiOrderInfoEntity.getOrderInfoId(),psiOrderInfoEntity.getOrderStatus());
            //更新库存状态
            List<PsiCarStockInfoEntity> listPsiCarStockInfoEntity = new ArrayList<>();
            PsiCarStockInfoEntity update1 = new PsiCarStockInfoEntity();
            update1.setVinCode(psiSalesModifyConfigEntity.getVin());
            update1.setStockState("5104");
            update1.setStockId(Long.valueOf(load.getStockId()));
            PsiCarStockInfoEntity update2 = new PsiCarStockInfoEntity();
            update2.setVinCode(psiSalesModifyConfigEntity.getChangeVin());
            update2.setStockState("5105");
            update2.setStockId(psiCarStockInfoEntity.getStockId());
            listPsiCarStockInfoEntity.add(update1);
            listPsiCarStockInfoEntity.add(update2);
            psiRetentionDao.batchUpdateStockState(listPsiCarStockInfoEntity);
        }

        //发送消息提醒给店长及所属销售人员
        List<String> params = new ArrayList<>();
        params.add(load.getOrderNo());
        //店长
        List<SalesConsultantDto> partyInfoList = getPartyInfo(Constants.slfRole.SH.value(), load.getSalesStore(),null,null,null);
        if(CollectionUtils.isNotEmpty(partyInfoList)){
            for (SalesConsultantDto salesConsultantDto : partyInfoList) {
                giveMessage(templateId,"UCMP",1,salesConsultantDto.getStaffCode(),0,null,params);
            }
            //店长与出行顾问是同一个人，则消息提醒只发送给店长，出行顾问不再发送
            if(Objects.equals(partyInfoList.get(0).getPartyId(),load.getFollowPerson())){
                return;
            }
        }

        //销售人员
        List<SalesConsultantDto> partyInfo = getPartyInfo(null, null, null, load.getFollowPerson(),null);
        if(CollectionUtils.isNotEmpty(partyInfo)){
            giveMessage(templateId,"UCMP",1,partyInfo.get(0).getStaffCode(),0,null,params);
        }

    }

    @Override
    public PsiSalesModifyConfigEntity modifyProcess(Long orderInfoId) {
        PsiSalesModifyConfigEntity entity = new PsiSalesModifyConfigEntity();
        entity.setOrderInfoId(orderInfoId);
        entity.setApproveResult(Constants.ApproveResult.PROCESS.getCode());
        List<PsiSalesModifyConfigEntity> modifyConfigEntities = psiSalesModifyConfigDao.selectBySelective(entity);
        if (CollectionUtils.isNotEmpty(modifyConfigEntities)) {
        	String productCode = psiSalesModifyConfigDao.queryProductCode(modifyConfigEntities.get(0).getChangeVin());
        	modifyConfigEntities.get(0).setProductCode(productCode);
            return modifyConfigEntities.get(0);
        }
        return null;
    }

    @Override
    public PageInfo<SalesCustomerDto> queryCustomerInfoList(PsiSalesCustomerDto psiSalesCustomerDto) {
        PageHelper.startPage(psiSalesCustomerDto.getPageNum(), psiSalesCustomerDto.getPageSize());
        List<SalesCustomerDto> psiSalesCustomerEntityList = salesCustomerDao.queryList(psiSalesCustomerDto);
        return new PageInfo<>(psiSalesCustomerEntityList);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void legalRight(OrderLegalRightDto orderLegalRightDto) throws Exception {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();

        PsiCarStockInfoEntity stockInfoEntity = carStockInfoDao.load(new PsiCarStockInfoPk(orderLegalRightDto.getStockId()));
        if (Objects.isNull(stockInfoEntity) || Objects.isNull(stockInfoEntity.getRightPackId())) {
            throw new IllegalParameterException("该车辆未关联权益包");
        }
        PsiSalesCustomerEntity customerEntity = psiSalesCustomerDao.load(new PsiSalesCustomerPk(orderLegalRightDto.getCustomerId()));
        String uid = customerEntity.getUid();
        String customerPhone = AesUtils.decryptHex(customerEntity.getCustomerPhone(), ucmpAesConfig.getSecret());
        List<SysRightActivitiesEntity> rightActivitiesEntities = sysRightActivitiesDao.selectByRightPackId(stockInfoEntity.getRightPackId());
        if (StringUtils.isEmpty(uid)) {
            uid = getUid(customerPhone);
            if (StringUtils.isEmpty(uid)) {
                throw new IllegalParameterException("获取该客户UID失败");
            }
            PsiSalesCustomerEntity update = new PsiSalesCustomerEntity();
            update.setCustomerId(customerEntity.getCustomerId());
            update.setUid(uid);
            psiSalesCustomerDao.updateSelective(update);
        }
        //发放权益包
        RightsGrantDto grantDto = new RightsGrantDto();
        grantDto.setRightPackId(stockInfoEntity.getRightPackId());
//        grantDto.setIdmId(customerEntity.getUid());
        grantDto.setSuperId(uid);
        grantDto.setVin(stockInfoEntity.getVinCode());
        RestResponse<Long> rightsGrant = activitiesFegin.rightsGrant(grantDto);
        LOGGER.error("====[权益发放]activitiesFegin.rightsGrant调用接口返回:{}", JSON.toJSONString(rightsGrant));
        if (RestStatusCode.OK.code() == rightsGrant.getCode()) {
            //同时权益活动发放明细表新增一条数据
            SysRightActivitiesDistributeDetailsEntity distributeDetailsEntity = new SysRightActivitiesDistributeDetailsEntity();
            distributeDetailsEntity.generatePk();
            distributeDetailsEntity.setRightPackId(stockInfoEntity.getRightPackId());
            distributeDetailsEntity.setRightGrantId(rightsGrant.getResult());
            distributeDetailsEntity.setCustomerName(customerEntity.getCustomerName());
            distributeDetailsEntity.setCustomerIphone(customerEntity.getCustomerPhone());
            distributeDetailsEntity.setDistributeDate(new Date());
            distributeDetailsEntity.setCampaignName(rightActivitiesEntities.get(0).getCampaignName());
            distributeDetailsEntity.setCreatedBy(user.getPartyId());
            distributeDetailsEntity.setUpdatedBy(user.getPartyId());
            iSysRightActivitiesDistributeDetailsDao.insertSelective(distributeDetailsEntity);
        }
        PsiOrderInfoEntity psiOrderInfoEntity = new PsiOrderInfoEntity();
        psiOrderInfoEntity.setOrderInfoId(orderLegalRightDto.getOrderInfoId());
        psiOrderInfoEntity.setLegalRight(orderLegalRightDto.getLegalRight());
        psiOrderInfoEntity.setUpdatedBy(user.getPartyId());
        psiOrderInfoEntity.setUpdatedDate(new Date());
        orderInfoDao.updateSelective(psiOrderInfoEntity);
    }

    @Override
    public PsiSalesCustomerEntity querySalesCustomer(Long customerId) {
        PsiSalesCustomerEntity load = psiSalesCustomerDao.load(new PsiSalesCustomerPk(customerId));
        return load;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long shoppingClues(CluesCreateDto cluesCreateDto) {
        /**
         *
         1.校验vin是否存在或在售
         2.1 客户已分配门店，该线索直接分配店、人
         2.2 当2.1不满足时，根据城市分配；1.城市分配到店；直接分配到店
         3.客户已分配到店;重新更新线索、订单，跟进门店、跟进人（ps:客户可能会存在未分配的线索和订单，一位客户对应一家门店一位销售人员）
         4.线索保存
         *
         */
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();

      //新增线索下发时需校验车辆状态
        PsiCarStockInfoEntity psiCarStockInfoEntity = psiRetentionDao.selectByVinCode(cluesCreateDto.getVin(),1);
        if(psiCarStockInfoEntity == null){
        	//已售出或不存在
        	return -3L;
        }else if(psiCarStockInfoEntity.getStockState().equals(Constants.STOCK_STATUS.Reserved.value())){
        	//已预定
        	return -1L;
        }else if(psiCarStockInfoEntity.getStockState().equals(Constants.STOCK_STATUS.RefundPending.value())||psiCarStockInfoEntity.getStockState().equals(Constants.STOCK_STATUS.WAIT_PUT.value())){
        	//已下架
        	return -2L;
        }
        //手机号加密
        String encryptPhone = AesUtils.encryptHex(cluesCreateDto.getCustomerPhone(), ucmpAesConfig.getSecret());
        //查询城市名称
        SysRegionEntity sysRegion = iSysRegionDao.load(new SysRegionPk(Long.valueOf(cluesCreateDto.getDeliveryPlace())));

        List<PsiSalesCustomerEntity> psiSalesCustomerEntityList = psiRetentionDao.selectAllPerson(null,null,Arrays.asList(encryptPhone));
        PsiSalesCustomerEntity salesCustomerEntity = new PsiSalesCustomerEntity();
        if(CollectionUtil.isNotEmpty(psiSalesCustomerEntityList)){
            BeanUtils.copyProperties(psiSalesCustomerEntityList.get(0),salesCustomerEntity);
        }
        Boolean isAllocation = false;
        //该客户未分配到店，根据城市分配
        if(Objects.isNull(salesCustomerEntity.getStoreId())){
            //根据城市查询对应的门店
            PsiCluesStoreConfigEntity psiCluesStoreConfigEntity = new PsiCluesStoreConfigEntity();
            psiCluesStoreConfigEntity.setCityName(sysRegion.getRegionName());
            psiCluesStoreConfigEntity.setStatus("01");
            List<PsiCluesStoreConfigEntity> psiCluesStoreConfigEntities = iPsiCluesStoreConfigDao.selectBySelective(psiCluesStoreConfigEntity);
            if(CollectionUtil.isNotEmpty(psiCluesStoreConfigEntities)){
                salesCustomerEntity.setStoreId(psiCluesStoreConfigEntities.get(0).getStoreId());
                isAllocation = true;
            }
        }
        salesCustomerEntity.setModelCode(cluesCreateDto.getModelCode());
        salesCustomerEntity.setModelName(cluesCreateDto.getModelName());
        salesCustomerEntity.setDeliveryPlace(sysRegion.getRegionName());
        salesCustomerEntity.setVin(psiCarStockInfoEntity.getVinCode());
//        salesCustomerEntity.setCustomerCharacter(cluesCreateDto.getCustomerCharacter());
//        salesCustomerEntity.setPurchaseTime(cluesCreateDto.getPurchaseTime());
//        salesCustomerEntity.setFamily(cluesCreateDto.getFamilySituation());
//        salesCustomerEntity.setFollowBy(); 未分配
//        salesCustomerEntity.setFollowName(); 未分配
        salesCustomerEntity.setFollowTime(new Date());
        salesCustomerEntity.setUpdatedBy(user.getPartyId());
        salesCustomerEntity.setUpdatedDate(new Date());
        if (Objects.isNull(salesCustomerEntity.getCustomerId())) {
            salesCustomerEntity.generatePk();
            salesCustomerEntity.setUid(cluesCreateDto.getUid());
            salesCustomerEntity.setCustomerPhone(encryptPhone);
            salesCustomerEntity.setCustomerName(cluesCreateDto.getCustomerName());
            salesCustomerEntity.setCreatedBy(user.getPartyId());
            salesCustomerEntity.setCreatedDate(new Date());
            psiSalesCustomerDao.insert(salesCustomerEntity);
        } else {
            psiSalesCustomerDao.update(salesCustomerEntity);

        }
        //可先不修改，分配时，同一客户下所有的线索或订单都会转到一位销售人员（ps：根据上牌地分配，如果直接分配到人,则需要修改）
//        if(isAllocation){
//            //1.有线索未分配
//            psiRetentionDao.updatePhoneFollowPerson(encryptPhone, salesCustomerEntity.getCustomerId(),
//                    salesCustomerEntity.getStoreId(), salesCustomerEntity.getPartyId(),user.getPartyId());
//            //2.有订单未分配
//            psiRetentionDao.updateStoreOrder(salesCustomerEntity.getCustomerId(),null,
//                    salesCustomerEntity.getStoreId(),salesCustomerEntity.getPartyId(),user.getPartyId());
//        }

        PsiRetentionCluesEntity psiRetentionCluesEntity = new PsiRetentionCluesEntity();
        BeanUtils.copyProperties(cluesCreateDto, psiRetentionCluesEntity);
        psiRetentionCluesEntity.generatePk();
        psiRetentionCluesEntity.setCustomerPhone(encryptPhone);
        psiRetentionCluesEntity.setCustomerId(salesCustomerEntity.getCustomerId());
        psiRetentionCluesEntity.setCluesSource(Constants.RetentionCluesSource.SHOPPING.getCode());
        psiRetentionCluesEntity.setStockId(psiCarStockInfoEntity.getStockId());
        psiRetentionCluesEntity.setStorageId(psiCarStockInfoEntity.getStorageId());
        psiRetentionCluesEntity.setSalePrice(psiCarStockInfoEntity.getSalePrice());
        psiRetentionCluesEntity.setRetentionTime(new Date());
        psiRetentionCluesEntity.setFollowStore(salesCustomerEntity.getStoreId());
        psiRetentionCluesEntity.setFollowPerson(salesCustomerEntity.getPartyId());
//        psiRetentionCluesEntity.setFollowTime(new Date());
        psiRetentionCluesEntity.setCluesSource(Constants.RetentionCluesSource.SHOPPING.getCode());
        psiRetentionCluesEntity.setFollowStatus(Constants.FollowStatus.NOT_FOLLOWED_UP.getCode());
//        psiRetentionCluesEntity.setCustomerCharacter(); 请求参数没有
//        psiRetentionCluesEntity.setPurchaseTime(); 请求参数没有
//        psiRetentionCluesEntity.setFamilySituation(); 请求参数没有
        psiRetentionCluesEntity.setDeliveryPlace(sysRegion.getRegionName());
        psiRetentionCluesEntity.setIsShow("00");
        psiRetentionCluesEntity.setCreatedBy(user.getPartyId());
        psiRetentionCluesEntity.setCreatedDate(new Date());
        psiRetentionCluesEntity.setUpdatedBy(user.getPartyId());
        psiRetentionCluesEntity.setUpdatedDate(new Date());
        psiRetentionCluesEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
        psiRetentionCluesEntity.setIsDelete(Constants.IsDelete.NO.value());
        iPsiRetentionCluesDao.insert(psiRetentionCluesEntity);
        return psiRetentionCluesEntity.getCluesId();
    }

    @Override
    public void uploadTemplate(MultipartFile file, Long fileId) throws Exception {
        fileUploadService.uploadFormwork(file, fileId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void orderTransference(OrderTransferenceDto transferenceDto) {
        /**
         *
         一位客户对应一家门店且对应一位销售
         需求：转让为客户整体转让，页面操作一条线索，则该客户下所有的线索、订单 整体转到新店
         *
         */
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiOrderInfoEntity load = orderInfoDao.load(new PsiOrderInfoPk(transferenceDto.getOrderInfoId()));
        if (Objects.isNull(load)) {
            throw new IllegalParameterException("该订单不存在");
        }
        PsiSalesCustomerEntity psiSalesCustomerEntity = new PsiSalesCustomerEntity();
        psiSalesCustomerEntity.setCustomerId(load.getCustomerId());
        psiSalesCustomerEntity.setStoreId(transferenceDto.getSalesStore());
        psiSalesCustomerEntity.setPartyId(transferenceDto.getFollowPerson());
        psiSalesCustomerEntity.setUpdatedBy(user.getPartyId());
        psiSalesCustomerEntity.setUpdatedDate(new Date());
        psiSalesCustomerDao.updateSelective(psiSalesCustomerEntity);
        psiRetentionDao.updateStoreClues(load.getCustomerId(), load.getSalesStore(),
                transferenceDto.getSalesStore(), transferenceDto.getFollowPerson(), user.getPartyId());
        psiRetentionDao.updateStoreOrder(load.getCustomerId(), null,
                transferenceDto.getSalesStore(), transferenceDto.getFollowPerson(), user.getPartyId());
        //发送消息提醒（销售人员）
        List<SalesConsultantDto> partyInfo = getPartyInfo(null, null, null, transferenceDto.getFollowPerson(),null);
        PsiSalesCustomerEntity customerEntity = psiSalesCustomerDao.load(new PsiSalesCustomerPk(load.getCustomerId()));
        List<String> params = new ArrayList<>();
        params.add(customerEntity.getCustomerName());
        params.add(load.getLicensingCity());
        giveMessage(null,"UCMP",1,partyInfo.get(0).getStaffCode(),0,null,params);
    }

    @Override
    public void storeRedistribution(Long storeId) {
        //门店取消官二资质，门店下所有的客户流转到线索池
        //1.客户、线索、订单 所有的进行中的订单，跟进门店、跟进人置空
        //2.配置清空
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        psiRetentionDao.redistributionStoreCustomer(storeId);
        psiRetentionDao.updateStoreClues(null,storeId,null,null,user.getPartyId());
        psiRetentionDao.updateStoreOrder(null,storeId,null,null,user.getPartyId());
    }

    @Override
    public void partyRedistribution(Long storeId) {
        //门店取消官二资质，门店下所有的客户流转到线索池
        //1.客户、线索、订单 所有的进行中的订单，跟进门店、跟进人置空
//        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
//        psiRetentionDao.redistributionStoreCustomer(storeId);
//        psiRetentionDao.updateStoreClues(null,storeId,null,null,user.getPartyId());
//        psiRetentionDao.updateStoreOrder(null,storeId,null,null,user.getPartyId());
    }

    /**
     * 获取当前登录人所授权的门店
     * @return
     */
    private List<Long> getEmpowerStoreId(){
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        UsedCarSupervisorParamDto paramDto = new UsedCarSupervisorParamDto();
        paramDto.setPartyId(user.getPartyId());
        List<UsedCarSupervisorDto> usedCarSupervisorDtos = psiRetentionDao.queryUsedCarSupervisor(paramDto);
        if(CollectionUtil.isNotEmpty(usedCarSupervisorDtos)){
            return usedCarSupervisorDtos.stream().map(UsedCarSupervisorDto::getStoreId).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 订单号生成
     */
    public static String getOddNumbers(String maxOddNumbers) {
        String newOddNumber = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String formatDate = simpleDateFormat.format(new Date());
        if (maxOddNumbers != null) {
            //截取后四位数
            String endNum = maxOddNumbers.substring(10);
            int endIntNum = Integer.parseInt(endNum);
            int newEndIntNum = 10000 + endIntNum + 1;
            String newEndNum = String.valueOf(newEndIntNum).substring(1);
            //生成单号
            newOddNumber = formatDate + newEndNum;
            return newOddNumber;
        } else {
            newOddNumber = formatDate + "0001";
            return newOddNumber;
        }
    }

	@Override
	@Transactional
	public void changePrice(OrderChangePriceDto orderChangePriceDto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		orderChangePriceDto.setPartyId(user.getPartyId());
		orderChangePriceDto.setRecordId(RandomIDGennerator.get().generate());
		//查询车辆id
		Long stockId=this.psiRetentionDao.queryStockId(orderChangePriceDto.getOrderInfoId());
		if(stockId == null){
			throw new Exception("订单管理车辆不存在，请联系系统管理员");
		}
		//查询车辆的模型建议价
		Double suggestedPrice = this.psiRetentionDao.querySuggestedPrice(stockId);
		if(suggestedPrice == null){
			//获取车辆定价
			DiscountBasicDto discountBasicDto = this.psiPricingServiceImpl.carPricing(stockId);
			suggestedPrice = Double.parseDouble(discountBasicDto.getSuggestedPrice());
		}
		if(suggestedPrice.compareTo(orderChangePriceDto.getNewPrice())<=0){
			//变更订单价格
			this.psiRetentionDao.changeOrderPrice(orderChangePriceDto);
			//变更库存车辆销售定价
			this.psiRetentionDao.changeCarSalePrice(orderChangePriceDto);
			orderChangePriceDto.setIsEnable("01");
		}else{
			//添加改价审批申请
			ChangePriceParamDto paramDto = new ChangePriceParamDto();
			paramDto.setRecordId(RandomIDGennerator.get().generate());
			paramDto.setStockId(stockId);
			paramDto.setOrderRecordId(orderChangePriceDto.getRecordId());
			paramDto.setCurPrice(orderChangePriceDto.getOlderPrice());
			paramDto.setSuggestedPrice(suggestedPrice);
			paramDto.setChangePrice(orderChangePriceDto.getNewPrice());
			paramDto.setChangeReason(orderChangePriceDto.getChangeReasons());
			paramDto.setOaCode(orderChangePriceDto.getOaCode());
			paramDto.setApproveStatus(0);
			paramDto.setCreatedBy(user.getPartyId());
			paramDto.setUpdatedBy(user.getPartyId());
			this.psiCarStockInfoDao.addChangePriceRecord(paramDto);
			
			//库存车辆表添加改价记录id
			this.psiCarStockInfoDao.updateCarStockInfo(paramDto);
			
			orderChangePriceDto.setIsEnable("00");
		}
		//添加订单改价记录
		this.psiRetentionDao.addChangPriceRecord(orderChangePriceDto);
		//添加改价凭证
		if(CollectionUtil.isNotEmpty(orderChangePriceDto.getFileList())){
			orderChangePriceDto.getFileList().forEach(dto ->{
				dto.setRecordId(orderChangePriceDto.getRecordId());
				dto.setPartyId(user.getPartyId());
			});
			this.psiRetentionDao.addChangPriceFile(orderChangePriceDto.getFileList());
		}
	}
}
