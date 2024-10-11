package com.exp.ucmp.carDealer.service.impl;

import com.exp.ucmp.carDealer.dto.*;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IPsiCarDealerInquiryDao;
import com.exp.ucmp.entity.PsiCarDealerInquiryEntity;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.shiro.model.User;
import com.exp.ucmp.carDealer.dao.WorkbenchHomePageDao;
import com.exp.ucmp.carDealer.service.WorkbenchHomePageService;
import com.exp.ucmp.model.Person;

import java.util.List;
import java.util.Optional;

@Service
public class WorkbenchHomePageServiceImpl implements WorkbenchHomePageService{
	
	@Autowired
	private WorkbenchHomePageDao workbenchHomePageDao;

	@Autowired
	private IPsiCarDealerInquiryDao iPsiCarDealerInquiryDao;
	/**
     * Description: 查询车商工作台首页统计数据
     * @param  partyId 人员id
     * @return 实体集合
     */
	@Override
	public WorkbenchStatisticsDto workbenchStatistics(Integer partyId) {
		User user = AuthContext.getInstance(Person.class).getCurrentUser();
		WorkbenchStatisticsDto workbenchStatisticsDto=new WorkbenchStatisticsDto();
		workbenchStatisticsDto.setPartyId(user.getPartyId());
		//查询车商人员姓名
		
		//根据车商人员id和组织id查询
//		ValuationOrderDto valuationOrderDto=this.workbenchHomePageDao.getValuationOrder();
//		workbenchStatisticsDto.setOrder(valuationOrderDto);
//		
//		OfferFollowDto offerFollowDto = this.workbenchHomePageDao.getOfferFollow();
//		workbenchStatisticsDto.setOffer(offerFollowDto);
//		
//		AcquisitionFollowDto acquisitionFollowDto = this.workbenchHomePageDao.getAcquisitionFollow();
//		workbenchStatisticsDto.setAcquisition(acquisitionFollowDto);
		
		return workbenchStatisticsDto;
	}

	/**
	 * 接单、报价数量统计
	 * @return
	 */
	@Override
	public ValuationOrderAndOfferFollowDto queryValuationOrder() {
		ValuationOrderAndOfferFollowDto valuationOrderAndOfferFollowDto = new ValuationOrderAndOfferFollowDto(0,0,0,0,0,0);
		User user = AuthContext.getInstance(Person.class).getCurrentUser();
		List<InquiryStatusDto> inquiryStatusDtoList = workbenchHomePageDao.selectValuationOrderAndOfferFollowCount(user.getOrganId(), user.getPartyId());
		if (CollectionUtils.isNotEmpty(inquiryStatusDtoList)){
			for (InquiryStatusDto inquiryStatusDto : inquiryStatusDtoList) {
				//待接单
				PsiCarDealerInquiryEntity psiCarDealerInquiryEntity = new PsiCarDealerInquiryEntity();
				psiCarDealerInquiryEntity.setCarDealerId(user.getOrganId());
				psiCarDealerInquiryEntity.setInquiryStatus(Constants.inquiryStatus.unOrderReceiving.value());
				valuationOrderAndOfferFollowDto.setPendingOrders(iPsiCarDealerInquiryDao.selectBySelectiveCount(psiCarDealerInquiryEntity));
				//未接单
				if (inquiryStatusDto.getInquiryStatus().equals(Constants.inquiryStatus.abandonOrderReceiving.value())){
					valuationOrderAndOfferFollowDto.setUnOrders(inquiryStatusDto.getCount());
				}
				//待报价
				if (inquiryStatusDto.getInquiryStatus().equals(Constants.inquiryStatus.unOffer.value())){
					valuationOrderAndOfferFollowDto.setPendingOffers(inquiryStatusDto.getCount());
				}
				//我的报价
				if (inquiryStatusDto.getInquiryStatus().equals(Constants.inquiryStatus.alreadyOffer.value())){
					valuationOrderAndOfferFollowDto.setMyOffers(inquiryStatusDto.getCount());
				}
				//未报价
				//逾期未报价
				Integer overCount = 0;
				if (inquiryStatusDto.getInquiryStatus().equals(Constants.inquiryStatus.overdueUnOffer.value())){
					overCount =inquiryStatusDto.getCount();
				}
				//放弃报价
				Integer abandonCount = 0;
				if (inquiryStatusDto.getInquiryStatus().equals(Constants.inquiryStatus.abandonOffer.value())){
					abandonCount = inquiryStatusDto.getCount();
				}
				//未报价数量
				valuationOrderAndOfferFollowDto.setUnOffers(overCount + abandonCount);

				//我的接单
				Integer myOrders = 0;
				if (inquiryStatusDto.getInquiryStatus().equals(Constants.inquiryStatus.orderReceiving.value())) {
					myOrders = inquiryStatusDto.getCount();
				}
				valuationOrderAndOfferFollowDto.setMyOrders(
						myOrders + valuationOrderAndOfferFollowDto.getPendingOffers()
								+ valuationOrderAndOfferFollowDto.getMyOrders()
								+ valuationOrderAndOfferFollowDto.getUnOffers()
				);
			}
		}
		return valuationOrderAndOfferFollowDto;
	}

	/**
	 * 收购、驳回数量统计
	 * @return
	 */
	public AcquisitionFollowDto queryAcquisitionFollow(){
		AcquisitionFollowDto acquisitionFollowDto = new AcquisitionFollowDto(0,0,0,0);
		User user = AuthContext.getInstance(Person.class).getCurrentUser();
		Long organId = user.getOrganId();
		Long partyId = user.getPartyId();
		//审批驳回
		acquisitionFollowDto.setRejected(Optional.ofNullable(workbenchHomePageDao.selectAcquisitionCount(organId, partyId,1)).orElse(0));
		//我的收购
		acquisitionFollowDto.setMyAcquisitions(Optional.ofNullable(workbenchHomePageDao.selectAcquisitionCount(organId,partyId,2)).orElse(0));
		//待收购
		acquisitionFollowDto.setPendingAcquisitions(Optional.ofNullable(workbenchHomePageDao.selectAcquisitionCount(organId, partyId, 3)).orElse(0));
		//待议价
		acquisitionFollowDto.setNegotiations(Optional.ofNullable(workbenchHomePageDao.selectAcquisitionCount(organId, partyId, 4)).orElse(0));
		return acquisitionFollowDto;
	}

	@Override
	public HomePageStatus queryStatusCount() {
		HomePageStatus homePageStatus = new HomePageStatus(0,0,0,0);
		User user = AuthContext.getInstance(Person.class).getCurrentUser();
		//待接单
		PsiCarDealerInquiryEntity psiCarDealerInquiryEntity = new PsiCarDealerInquiryEntity();
		psiCarDealerInquiryEntity.setCarDealerId(user.getOrganId());
		psiCarDealerInquiryEntity.setInquiryStatus(Constants.inquiryStatus.unOrderReceiving.value());
		int i = iPsiCarDealerInquiryDao.selectBySelectiveCount(psiCarDealerInquiryEntity);
		homePageStatus.setNotReceived(i);
		//各状态集合
		List<InquiryStatusDto> statusDtoList = workbenchHomePageDao.selectValuationOrderAndOfferFollowCount(user.getOrganId(), user.getPartyId());
		if (CollectionUtils.isNotEmpty(statusDtoList)){
			for (InquiryStatusDto inquiryStatusDto : statusDtoList) {
				//待报价
				if (inquiryStatusDto.getInquiryStatus().equals(Constants.inquiryStatus.unOffer.value())){
					homePageStatus.setNegotiations(inquiryStatusDto.getCount());
				}
				//待收购
				if (inquiryStatusDto.getInquiryStatus().equals(Constants.inquiryStatus.unAcquired.value())){
					homePageStatus.setPendingAcquisitions(inquiryStatusDto.getCount());
				}
				//待过户
				if (inquiryStatusDto.getInquiryStatus().equals(Constants.inquiryStatus.unTransfer.value())){
					homePageStatus.setNotTransferred(inquiryStatusDto.getCount());
				}
			}
		}
		return homePageStatus;
	}
}
