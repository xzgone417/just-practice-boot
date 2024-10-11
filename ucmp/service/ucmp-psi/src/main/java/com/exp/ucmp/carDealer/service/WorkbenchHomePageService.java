package com.exp.ucmp.carDealer.service;

import com.exp.ucmp.carDealer.dto.*;

public interface WorkbenchHomePageService {

	public WorkbenchStatisticsDto workbenchStatistics(Integer partyId);

	/**
	 * 估价接单数、报价跟进数据统计
	 * @return
	 */
	public ValuationOrderAndOfferFollowDto queryValuationOrder();

	/**
	 * 查询收购及审批驳回数量
	 * @return
	 */
	public AcquisitionFollowDto queryAcquisitionFollow();

	/**
	 * 查询待接单、报价、收购、过户数据
	 * @return
	 */
	HomePageStatus queryStatusCount();
}
