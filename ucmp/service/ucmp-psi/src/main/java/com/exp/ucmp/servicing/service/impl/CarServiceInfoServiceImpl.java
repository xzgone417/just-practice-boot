package com.exp.ucmp.servicing.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson.JSON;
import com.egrid.cache.redisson.cache.RedissonCache;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carService.dto.*;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IPsiCarServiceInfoDao;
import com.exp.ucmp.dao.IPsiCarServiceMaterialApprovalRecordDao;
import com.exp.ucmp.dao.IPsiCarServiceMaterialFileDao;
import com.exp.ucmp.dao.IPsiCarStockInfoDao;
import com.exp.ucmp.dao.ISysStaffDetailsDao;
import com.exp.ucmp.entity.PsiCarServiceInfoEntity;
import com.exp.ucmp.entity.PsiCarServiceMaterialApprovalRecordEntity;
import com.exp.ucmp.entity.PsiCarServiceMaterialFileEntity;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.exp.ucmp.isp.dto.IspQuoteApplyReturnDto;
import com.exp.ucmp.isp.dto.QuoteApplyDto;
import com.exp.ucmp.isp.dto.QuoteApprovalDto;
import com.exp.ucmp.isp.dto.QuoteComponentDto;
import com.exp.ucmp.isp.dto.QuoteOtherFeesDto;
import com.exp.ucmp.isp.dto.QuoteProjectDto;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiCarServiceMaterialFilePk;
import com.exp.ucmp.pk.PsiCarStockInfoPk;
import com.exp.ucmp.pk.SysStaffDetailsPk;
import com.exp.ucmp.servicing.dao.CarServiceInfoDao;
import com.exp.ucmp.servicing.fegin.ServicingFegin;
import com.exp.ucmp.servicing.service.CarServiceInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.collection.CollectionUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CarServiceInfoServiceImpl implements CarServiceInfoService {
    @Autowired
    private CarServiceInfoDao carServiceInfoDao;
    @Autowired
    private IPsiCarServiceInfoDao iPsiCarServiceInfoDao;
    @Autowired
    private IPsiCarStockInfoDao iPsiCarStockInfoDao;
    @Autowired
    private IPsiCarServiceMaterialApprovalRecordDao iPsiCarServiceMaterialApprovalRecordDao;
    @Autowired
    private IPsiCarServiceMaterialFileDao iPsiCarServiceMaterialFileDao;
    @Autowired
    RedissonCache redissonCache;
    
    @Autowired
    ServicingFegin servicingFegin;
    
    @Autowired
    ISysStaffDetailsDao iSysStaffDetailsDao;

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceInfoServiceImpl.class);


    @Override
    public CarServiceInfoDto findCarInfoByVinCode(String vinCode) throws Exception {
        CarServiceInfoDto carServiceInfoDto = carServiceInfoDao.findCarInfoByVinCode(vinCode);
        if(carServiceInfoDto == null ){
        	throw new Exception(vinCode+"车辆不存在");
        }
        if(StringUtils.isBlank(carServiceInfoDto.getServiceNumber())){
            carServiceInfoDto.setServiceNumber(generatenNumber());
        }
        /*else{
        	throw new Exception("存在未完成的整备单:"+carServiceInfoDto.getServiceNumber());
        }*/
        if(carServiceInfoDto.getStartDate() == null){
            carServiceInfoDto.setStartDate(new Date());
        }
        if(StringUtils.isBlank(carServiceInfoDto.getStartPeople())){
            Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
            carServiceInfoDto.setStartPeople(user.getPersonName());
        }
        return carServiceInfoDto;
    }

    @Override
    public CarServiceInfoDto findCarServiceInfo(Long stockId) {
        CarServiceInfoDto carServiceInfo= carServiceInfoDao.findCarServiceInfo(stockId);
        return carServiceInfo;
    }
    
    @Transactional
    @Override
    public void submitCarService(CarServiceInfoDto carServiceInfoDto) throws Exception {
        PsiCarStockInfoEntity load = iPsiCarStockInfoDao.load(new PsiCarStockInfoPk(carServiceInfoDto.getStockId()));
        PsiCarServiceInfoEntity psiCarServiceInfoEntity =new PsiCarServiceInfoEntity();
        psiCarServiceInfoEntity.setServiceNumber(carServiceInfoDto.getServiceNumber());
        int count = this.iPsiCarServiceInfoDao.selectBySelectiveCount(psiCarServiceInfoEntity);
        if(count >0){
        	throw new Exception("整备单:"+carServiceInfoDto.getServiceNumber()+"已存在");
        }
        if(!Constants.STOCK_TYPE.OutletInventory.value().equals(load.getStockType())){
            throw new Exception("只有库存类型为网点库存时可以发起整备");
        }
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        
        //添加整备数据
        PsiCarServiceInfoEntity carServiceInfoEntity =
                Copiers.beanToBean(carServiceInfoDto, CarServiceInfoDto.class, PsiCarServiceInfoEntity.class);
        carServiceInfoEntity.setPlanStartDate(new Date());
        carServiceInfoEntity.setUpdatedBy(user.getPartyId());
        carServiceInfoEntity.setUpdatedDate(new Date());
        carServiceInfoEntity.setStartDate(carServiceInfoEntity.getUpdatedDate());
        carServiceInfoEntity.setStartPeopleId(user.getPartyId());
        carServiceInfoEntity.setStartPeople(user.getPersonName());
        carServiceInfoEntity.generatePk();
        carServiceInfoEntity.setServiceState(Constants.SERVICE_STATE.WAIT_FEEDBACK.value());
        carServiceInfoEntity.setCreatedBy(user.getPartyId());
        carServiceInfoEntity.setCreatedDate(new Date());
        carServiceInfoEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
        carServiceInfoEntity.setIsDelete(Constants.IsDelete.NO.value());
        
        //推送ISP
        QuoteApplyDto dto = new QuoteApplyDto();
        dto.setUcmpOrderNo(carServiceInfoDto.getServiceNumber());
        dto.setSiteType(carServiceInfoDto.getPlaceTypeCode());
        dto.setSiteName(carServiceInfoDto.getServicePlace());
        dto.setSiteCode(carServiceInfoDto.getServicePlaceCode());
        dto.setVin(carServiceInfoDto.getVinCode());
        String plateNo = this.iPsiCarStockInfoDao.load(new PsiCarStockInfoPk(carServiceInfoDto.getStockId())).getLicenseNumber();
        dto.setPlateNo(plateNo);
        String creatorEmpId = this.iSysStaffDetailsDao.load(new SysStaffDetailsPk(user.getPartyId())).getStaffCode();
        dto.setCreatorEmpId(creatorEmpId);
        dto.setCreatorName(user.getPersonName());
        dto.setExpectDeliveryTime(carServiceInfoDto.getExpectEndTime().getTime());
        dto.setOrderSource("SECOND_HAND");
        RestResponse<String> result = this.servicingFegin.createServicing(dto);
        LOGGER.info("====[预估报价单申请]调用接口返回:{}", JSON.toJSONString(result));
        if(RestStatusCode.OK.code() == result.getCode()){
        	IspQuoteApplyReturnDto returnDto = JsonBeanUtil.jsonToBean(result.getResult(), IspQuoteApplyReturnDto.class);
        	if(returnDto.getCode() == null || !returnDto.getCode().equals(Constants.CodeEnum.eosCode.value())){
        		throw new Exception("提交报价单申请失败，原因："+returnDto.getMsg());
        	}
        	carServiceInfoEntity.setQuoteOrderNo(returnDto.getData());
        }
        iPsiCarServiceInfoDao.insertSelective(carServiceInfoEntity);
        //车辆发起整备后，车辆状态同时更新为整备中
        PsiCarStockInfoEntity stockInfoEntity = new PsiCarStockInfoEntity();
        stockInfoEntity.setStockState(Constants.STOCK_STATUS.Servicing.value());
        stockInfoEntity.setStockId(carServiceInfoDto.getStockId());
        iPsiCarStockInfoDao.updateSelective(stockInfoEntity);
    }

    @Override
    public PageInfo<CarServiceApprovalListInfoDto> findApprovalList(CarServiceApprovalListParamDto listParamDto,Integer type) {
        //tab页类型(1:维修项目反馈/2:维修工单反馈)
    	listParamDto.setType(type);
        if(1 == type){
            listParamDto.setTabState(Constants.SERVICE_STATE.getProjectFeedbackTab());
        }else{
            listParamDto.setTabState(Constants.SERVICE_STATE.getWorkOrderFeedbackTab());
        }
        PageHelper.startPage(listParamDto.getPageNum(), listParamDto.getPageSize());
        List<CarServiceApprovalListInfoDto> list = carServiceInfoDao.findApprovalList(listParamDto);
        return new PageInfo<>(list);
    }
    
    @Override
    public CarServiceWarehouInfoDto getWarehouCarInfo(Long stockId) {
        PsiCarStockInfoEntity load = iPsiCarStockInfoDao.load(new PsiCarStockInfoPk(stockId));
        CarServiceWarehouInfoDto serviceWarehouInfoDto = Copiers.beanToBean(load, PsiCarStockInfoEntity.class, CarServiceWarehouInfoDto.class);
        return serviceWarehouInfoDto;
    }

    @Override
    public PageInfo<CarServiceMaterialApprovalRecordListDto> selectApprovalRecordList(Integer pageNum, Integer pageSize, Long serviceId) {
        PsiCarServiceMaterialApprovalRecordEntity serviceMaterialApprovalRecordEntity = new PsiCarServiceMaterialApprovalRecordEntity();
        serviceMaterialApprovalRecordEntity.setServiceId(serviceId);
        PageHelper.startPage(pageNum, pageSize);
        List<PsiCarServiceMaterialApprovalRecordEntity> psiCarServiceMaterialApprovalRecordEntities = iPsiCarServiceMaterialApprovalRecordDao.selectBySelective(serviceMaterialApprovalRecordEntity);
        List<CarServiceMaterialApprovalRecordListDto> recordListDtos = Copiers.beansToBeans(psiCarServiceMaterialApprovalRecordEntities, PsiCarServiceMaterialApprovalRecordEntity.class, CarServiceMaterialApprovalRecordListDto.class);
        return new PageInfo<>(recordListDtos);
    }

    @Override
    public void submitServiceMaterialFile(Long materialFileId, String rejectReason) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiCarServiceMaterialFileEntity load = iPsiCarServiceMaterialFileDao.load(new PsiCarServiceMaterialFilePk(materialFileId));
        String [] reasons=rejectReason.split(",");
        rejectReason="";
        for (int i = 0; i < reasons.length; i++) {
        	if(i==0){
        		rejectReason=this.iPsiCarStockInfoDao.selectDictValue(reasons[i]);
        	}else{
        		rejectReason=rejectReason+","+this.iPsiCarStockInfoDao.selectDictValue(reasons[i]);
        	}
		}
        load.setRejectReason(rejectReason);
        load.setApprovalDate(new Date());
        load.setApprovalPeopleId(user.getPartyId());
        iPsiCarServiceMaterialFileDao.updateSelective(load);

    }

    @Override
    public void submitServiceMaterial(Long serviceId, String approvalResult, String approvalRemark) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiCarServiceMaterialApprovalRecordEntity materialApprovalRecordEntity = new PsiCarServiceMaterialApprovalRecordEntity();
        materialApprovalRecordEntity.generatePk();
        materialApprovalRecordEntity.setServiceId(serviceId);
        materialApprovalRecordEntity.setApprovalResult(approvalResult);
        materialApprovalRecordEntity.setApprovalRemark(approvalRemark);
        materialApprovalRecordEntity.setApprovalPeopleId(user.getPartyId());
        materialApprovalRecordEntity.generatePk();
        materialApprovalRecordEntity.setCreatedBy(user.getPartyId());
        materialApprovalRecordEntity.setUpdatedBy(user.getPartyId());
        iPsiCarServiceMaterialApprovalRecordDao.insertSelective(materialApprovalRecordEntity);
        
        //修改整备信息
        this.carServiceInfoDao.updateServiceInfo(materialApprovalRecordEntity.getMaterialApprovalRecordId(),
        		materialApprovalRecordEntity.getServiceId(),user.getPartyId(),approvalResult);
    }
    
    @Transactional
    @Override
    public void submitCancelService(Long stockId) {
        PsiCarServiceInfoEntity carServiceInfoEntity = new PsiCarServiceInfoEntity();
        carServiceInfoEntity.setStockId(stockId);
        List<PsiCarServiceInfoEntity> serviceInfoEntities = iPsiCarServiceInfoDao.selectBySelective(carServiceInfoEntity);
        PsiCarServiceInfoEntity serviceInfoEntity = serviceInfoEntities.get(0);
        serviceInfoEntity.setServiceState(Constants.SERVICE_STATE.CANCEL.value());
        iPsiCarServiceInfoDao.updateSelective(serviceInfoEntity);
    }

    @Override
    public PageInfo<CarApproveFileListInfoDto> findCarApproveFileList(CarApproveFileListParamDto listParamDto) {
        PageHelper.startPage(listParamDto.getPageNum(), listParamDto.getPageSize());
        //总部人员登录后点击车辆图片审批菜单，总查看所有门店整备验收入库的车辆
//        listParamDto.setServiceState(Constants.SERVICE_STATE.WAREHOUS.value());
        List<CarApproveFileListInfoDto> recordListDtos = carServiceInfoDao.findCarApproveFileList(listParamDto);
        return new PageInfo<>(recordListDtos);
    }
    //生成整备单号
    private  String generatenNumber(){
        Long codeIncr = redissonCache.incrBy("service:no", 1L);
        String code = String.format("%04d", codeIncr);
        if (codeIncr == 1){
            redissonCache.expire("service:no", TimeUnit.HOURS,24L);
        }
        String campaignCode = new SimpleDateFormat("yyyyMMdd").format(new Date()).concat(code);
        campaignCode = "ZB" + campaignCode;
        return  campaignCode;
    }

    @Override
   	public PageInfo<QueryServiceDto> findServicingList(QueryServiceParamDto paramDto) {
    	PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
    	List<QueryServiceDto> list = carServiceInfoDao.findServicingList(paramDto);
    	return new PageInfo<>(list);
   	}

	@Override
	public QueryServiceDetailsDto findServiceDetails(Long serviceId) {
		//查询整备基础信息
		QueryServiceDetailsDto detailsDto = this.carServiceInfoDao.findServiceDetails(serviceId);
		if(detailsDto != null){
			//查询整备项目信息
			List<QuoteProjectDto> projectList = this.carServiceInfoDao.queryProjectList(detailsDto.getQuoteOrderId());
			if(CollectionUtil.isNotEmpty(projectList)){
				for (QuoteProjectDto quoteProjectDto : projectList) {
					//查询维修配件
					List<QuoteComponentDto> componentList = this.carServiceInfoDao.queryComponentList(quoteProjectDto.getProjectId());
					quoteProjectDto.setComponentList(componentList);
					//查询其他费用
					List<QuoteOtherFeesDto> otherFeesList = this.carServiceInfoDao.queryOtherFeesList(quoteProjectDto.getProjectId());
					quoteProjectDto.setOtherFeesList(otherFeesList);
				}
			}
			detailsDto.setProjectList(projectList);
			//查询审批记录
			List<ServiceApproveRecordDto> recordList = this.carServiceInfoDao.queryRecordList(serviceId);
			detailsDto.setRecordList(recordList);
		}
		return detailsDto;
	}

	@Override
	public void quoteOrderApproval(CarServiceApproveDto approveDto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		//查询整备基础信息
		QueryServiceDetailsDto detailsDto = this.carServiceInfoDao.findServiceDetails(approveDto.getServiceId());
		//整备状态
		String status;
		//推送ISP的参数类
		QuoteApprovalDto quoteApprovalDto=new QuoteApprovalDto();
		//记录审批参数
		ServiceApproveRecordDto recordDto=new ServiceApproveRecordDto();
		recordDto.setCreatedBy(user.getPartyId());
		recordDto.setUpdateBy(user.getPartyId());
		recordDto.setApprovalPeopleId(user.getPartyId());
		recordDto.setApprovalRemark(approveDto.getApproveRemark());
		recordDto.setRecordId(RandomIDGennerator.get().generate());
		recordDto.setServiceId(approveDto.getServiceId());
		
		quoteApprovalDto.setUcmpOrderNo(approveDto.getServiceNumber());
		if(approveDto.getApproveResult()==0){
			quoteApprovalDto.setStatus("PASS");
			recordDto.setApprovalResult("00");
			status=Constants.SERVICE_STATE.WAIT_GENERATE.value();
		}else if(approveDto.getApproveResult()==1){
			quoteApprovalDto.setStatus("REJECT");
			recordDto.setApprovalResult("01");
			status=Constants.SERVICE_STATE.REJECT.value();
		}else{
			quoteApprovalDto.setStatus("GIVE_UP");
			recordDto.setApprovalResult("02");
			status=Constants.SERVICE_STATE.WHOLESALE.value();
		}
		quoteApprovalDto.setRemark(approveDto.getApproveRemark());
		quoteApprovalDto.setApprovalName(user.getPersonName());
		//推送审批结果给ISP
		String creatorEmpId = this.iSysStaffDetailsDao.load(new SysStaffDetailsPk(user.getPartyId())).getStaffCode();
		quoteApprovalDto.setApprovalEmpId(creatorEmpId);
		RestResponse<String> result = this.servicingFegin.quoteApproval(quoteApprovalDto);
        LOGGER.info("====[预估报价单审批]调用接口返回:{}", JSON.toJSONString(result));
        if(RestStatusCode.OK.code() == result.getCode()){
        	IspQuoteApplyReturnDto returnDto = JsonBeanUtil.jsonToBean(result.getResult(), IspQuoteApplyReturnDto.class);
        	if(returnDto.getCode()== null || !returnDto.getCode().equals(Constants.CodeEnum.eosCode.value())){
        		throw new Exception("预估报价单审批失败，原因："+returnDto.getMsg());
        	}else{
        		//添加审批记录
        		this.carServiceInfoDao.addApproveRecord(recordDto);
        		
        		for (QuoteProjectApproveDto projectDto : approveDto.getProjectList()) {
        			projectDto.setUpdateBy(user.getPartyId());
        			//更新维修项目信息
        			this.carServiceInfoDao.updateProject(projectDto);
        			//更新维修配件信息
        			if(CollectionUtil.isNotEmpty(projectDto.getComponentList())){
        				for (QuoteComponentApproveDto componentDto : projectDto.getComponentList()) {
        					componentDto.setUpdateBy(user.getPartyId());
        					this.carServiceInfoDao.updateComponent(componentDto);
						}
        			}
        			
        			//更新其他费用信息
        			if(CollectionUtil.isNotEmpty(projectDto.getOtherFeesList())){
        				for (QuoteOtherFeesApproveDto otherFeesDto : projectDto.getOtherFeesList()) {
        					otherFeesDto.setUpdateBy(user.getPartyId());
        					this.carServiceInfoDao.updateOtherFees(otherFeesDto);
						}
        			}
				}
        		
        		//更新整备状态
        		this.carServiceInfoDao.updateServiceStatus(status,user.getPartyId(),approveDto.getServiceId(),recordDto.getRecordId(),detailsDto.getServiceState());
        	}
        }
	}

}
