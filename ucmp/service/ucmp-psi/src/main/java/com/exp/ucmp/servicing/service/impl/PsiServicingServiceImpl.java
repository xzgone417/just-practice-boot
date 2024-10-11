package com.exp.ucmp.servicing.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONObject;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.inventory.service.PsiPricingService;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiCarServiceInfoPk;
import com.exp.ucmp.pricing.PricingJournalDto;
import com.exp.ucmp.servicing.dao.PsiServicingDao;
import com.exp.ucmp.servicing.dto.*;
import com.exp.ucmp.servicing.service.PsiServicingService;
import com.github.pagehelper.Constant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author gubonai
 * @date 2023年01月14日
 */
@Service
public class PsiServicingServiceImpl implements PsiServicingService {

	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PsiServicingServiceImpl.class);

	@Autowired
	private IPsiCarStockInfoDao stockInfoDao;
	@Autowired
	private IPsiWorkOrderApprovalHistoryDao workOrderApprovalHistoryDao;
	@Autowired
	private IPsiCarServiceInquiryHistoryDao carServiceInquiryHistoryDao;
	@Autowired
	private IPsiCarServiceInfoDao carServiceInfoDao;
	@Autowired
	private PsiServicingDao psiServicingDao;
	@Autowired
	private ISysCarUsedStorageDao carUsedStorageDao;

	/**
	 * 查询工单列表
	 *
	 * @param queryServicingParamDto
	 * @return
	 */
	@Override
	public PageInfo<QueryServicingDto> queryServicingList(QueryServicingParamDto queryServicingParamDto) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		//查询当前登录人所属的交付中心org_id
		PageHelper.startPage(queryServicingParamDto.getPageNum(), queryServicingParamDto.getPageSize());
		// 门店
//		SysCarUsedStorageEntity sysCarUsedStorageEntity = new SysCarUsedStorageEntity();
//		sysCarUsedStorageEntity.setOrgId(queryServicingParamDto.getOrgId());
//		List<SysCarUsedStorageEntity> sysCarUsedStorageEntities = carUsedStorageDao.selectBySelective(sysCarUsedStorageEntity);
		List<Long> storageIdList=this.psiServicingDao.queryStorageIdList(user.getPartyId());
		if (CollectionUtil.isNotEmpty(storageIdList)) {
			queryServicingParamDto.setStorageId(storageIdList);
			return new PageInfo<>(psiServicingDao.queryServicingList(queryServicingParamDto));
		} else {
			return new PageInfo<>(new ArrayList<>());
		}
	}

	@Override
	public PageInfo<QueryServicingDto> queryServicingApprovalList(QueryServicingApprovalDto query) {
		PageHelper.startPage(query.getPageNum(), query.getPageSize());
		return new PageInfo<>(psiServicingDao.queryServicingApprovalList(query));
	}

	@Override
	public ServicingCarInfoDto queryServicingCarInfo(Long serviceId) {
		return psiServicingDao.queryServicingCarInfo(serviceId);
	}

	@Override
	public MaintenanceApprovalDto queryMaintenanceApproval(Integer type, Long serviceId) {
		MaintenanceApprovalDto approvalDto = new MaintenanceApprovalDto();
		int price = 0;
		List<MaintenanceItemsDto> dtoList = psiServicingDao.queryMaintenanceItems(serviceId);
		if (CollectionUtil.isNotEmpty(dtoList)) {
			for (MaintenanceItemsDto dto : dtoList) {
				price += dto.getTimePrice().intValue();
				if (dto.getIsComponent() == 0) {
					List<RepairPartsDto> partsList = psiServicingDao.queryRepairParts(dto.getProjectId());
					price += partsList.stream().map(RepairPartsDto::getComponentPrice)
							.reduce(BigDecimal.ZERO, BigDecimal::add).intValue();
					dto.setList(partsList);
				}
			}
		}
		List<ServiceApprovalRecordDto> records = null;
		if (type == 1)
			records = psiServicingDao.queryApprovalRecord(1, serviceId);
		if (type == 2)
			records = psiServicingDao.queryApprovalRecord(2, serviceId);
		approvalDto.setApprovalRecordList(records);
		approvalDto.setMaintenanceList(dtoList);
		approvalDto.setPrice(String.valueOf(price));
		return approvalDto;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean approval(ApprovalParamsDto paramsDto) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		PsiCarServiceInfoEntity carServiceInfo = new PsiCarServiceInfoEntity();
		carServiceInfo.setServiceId(paramsDto.getServiceId());
		PsiCarServiceInfoEntity load = carServiceInfoDao.load(new PsiCarServiceInfoPk(paramsDto.getServiceId()));
		carServiceInfo.setUpdatedBy(user.getPartyId());
		carServiceInfo.setUpdatedDate(new Date());
		carServiceInfo.setServiceState(paramsDto.getStatus());
		// 维修项目
		if (paramsDto.getType() == 1) {
			LOGGER.info("*************************维修项目开始**********************");
			// 驳回
			if (Constants.SERVICE_STATE.REJECT.value().equals(paramsDto.getStatus())) {
				if (CollectionUtil.isNotEmpty(paramsDto.getProjectList())) {
					// 维修项目是否存在配件
					paramsDto.getProjectList().forEach(item -> {
						// 存在配件
						if (item.getIsComponent() == 0) {
							int sign = 1;
							for (ApprovalItemsPartsDto part : item.getPartsList()) {
								if (part.getIsRepair() == 0) {
									sign = 0;
								}
								// 更新配件审批结果
								part.setUpdateBy(user.getPartyId());
								psiServicingDao.updateParts(part);
							}
							item.setIsRepair(sign);
						}
						// 更新项目审批结果
						item.setUpdateBy(user.getPartyId());
						psiServicingDao.updateItems(item);
					});
				}
				// 通过
			} else if (Constants.SERVICE_STATE.PASS.value().equals(paramsDto.getStatus())) {
				carServiceInfo.setServiceState(Constants.SERVICE_STATE.WAIT_GENERATE.value());
				if (CollectionUtil.isNotEmpty(paramsDto.getProjectList())) {
					// 维修项目是否存在配件
					paramsDto.getProjectList().forEach(item -> {
						// 存在配件
						if (item.getIsComponent() == 0) {
							item.getPartsList().forEach(part -> {
								// 更新配件审批结果
								part.setUpdateBy(user.getPartyId());
								psiServicingDao.updateParts(part);
							});
							item.setIsRepair(0);
						}
						// 更新项目审批结果
						item.setUpdateBy(user.getPartyId());
						psiServicingDao.updateItems(item);
					});
					// 转批售
				} else if (Constants.SERVICE_STATE.WHOLESALE.value().equals(paramsDto.getStatus())) {
					PsiCarStockInfoEntity stockInfoEntity = new PsiCarStockInfoEntity();
					stockInfoEntity.setDecisionType(Constants.DECISION_TYPE.WHOLESALE.value());
					stockInfoEntity.setStockState(Constants.STOCK_STATUS.InStockForSale.value());
					stockInfoEntity.setStockId(load.getStockId());
					stockInfoEntity.setUpdatedDate(new Date());
					stockInfoEntity.setUpdatedBy(user.getPartyId());
					stockInfoDao.updateSelective(stockInfoEntity);
				}
			}
			// 同步审批结果到ISP

			// 更新整备信息
			carServiceInfoDao.updateSelective(carServiceInfo);
			// 插入审批整备信息记录
			PsiCarServiceInquiryHistoryEntity inquiryHistoryEntity = new PsiCarServiceInquiryHistoryEntity();
			inquiryHistoryEntity.generatePk();
			inquiryHistoryEntity.setServiceId(paramsDto.getServiceId());
			inquiryHistoryEntity.setApprovalDate(new Date());
			inquiryHistoryEntity.setApprovalResult(paramsDto.getResult());
			inquiryHistoryEntity.setApprovalMark(paramsDto.getMarks());
			inquiryHistoryEntity.setApprovalPeople(user.getPersonName());
			inquiryHistoryEntity.setCreatedBy(user.getPartyId());
			inquiryHistoryEntity.setCreatedDate(new Date());
			inquiryHistoryEntity.setUpdatedBy(user.getPartyId());
			inquiryHistoryEntity.setUpdatedDate(new Date());
			inquiryHistoryEntity.setIsDelete(Constants.IsDelete.NO.value());
			inquiryHistoryEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
			carServiceInquiryHistoryDao.insert(inquiryHistoryEntity);
			LOGGER.info("*************************维修项目结束**********************");
		}else if (paramsDto.getType() == 2) {
			LOGGER.info("*************************维修工单开始**********************");
			// 驳回
			if (Constants.SERVICE_STATE.REJECT.value().equals(paramsDto.getStatus())) {
				if (CollectionUtil.isNotEmpty(paramsDto.getProjectList())) {
					// 维修项目是否存在配件
					paramsDto.getProjectList().forEach(item -> {
						// 存在配件
						if (item.getIsComponent() == 0) {
							int sign = 1;
							for (ApprovalItemsPartsDto part : item.getPartsList()) {
								if (part.getIsRepair() == 0) {
									sign = 0;
								}
								// 更新配件审批结果
								part.setUpdateBy(user.getPartyId());
								psiServicingDao.updateParts(part);
							}
							item.setIsRepair(sign);
						}
						// 更新项目审批结果
						item.setUpdateBy(user.getPartyId());
						psiServicingDao.updateItems(item);
					});
				}
				// 通过
			} else if (Constants.SERVICE_STATE.PASS.value().equals(paramsDto.getStatus())) {
				carServiceInfo.setServiceState(Constants.SERVICE_STATE.WAIT_IMPLEMENT.value());
				if (CollectionUtil.isNotEmpty(paramsDto.getProjectList())) {
					// 维修项目是否存在配件
					paramsDto.getProjectList().forEach(item -> {
						// 存在配件
						if (item.getIsComponent() == 0) {
							item.getPartsList().forEach(part -> {
								// 更新配件审批结果
								part.setUpdateBy(user.getPartyId());
								psiServicingDao.updateParts(part);
							});
							item.setIsRepair(0);
						}
						// 更新项目审批结果
						item.setUpdateBy(user.getPartyId());
						psiServicingDao.updateItems(item);
					});
				}
			}
			//同步工单审批结果到ISP
			
			//更新整备信息
			carServiceInfoDao.updateSelective(carServiceInfo);
			// 插入审批记录
			PsiWorkOrderApprovalHistoryEntity workOrder = new PsiWorkOrderApprovalHistoryEntity();
			workOrder.generatePk();
			workOrder.setServiceId(paramsDto.getServiceId());
			workOrder.setApprovalDate(new Date());
			workOrder.setApprovalResult(paramsDto.getResult());
			workOrder.setApprovalMark(paramsDto.getMarks());
			workOrder.setApprovalPeople(user.getPersonName());
			workOrder.setCreatedBy(user.getPartyId());
			workOrder.setCreatedDate(new Date());
			workOrder.setUpdatedBy(user.getPartyId());
			workOrder.setUpdatedDate(new Date());
			workOrder.setIsDelete(Constants.IsDelete.NO.value());
			workOrder.setIsEnable(Constants.IsEnable.ENABLE.value());
			workOrderApprovalHistoryDao.insert(workOrder);
			LOGGER.info("*************************维修工单结束**********************");
		}
		return true;
	}

}
