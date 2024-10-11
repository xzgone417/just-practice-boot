package com.exp.ucmp.carDealer.service;

import com.exp.ucmp.PageDto;
import com.exp.ucmp.carDealer.dto.InquiryQueryParamDto;
import com.exp.ucmp.carDealer.dto.InquiryQueryResultDto;
import com.exp.ucmp.carDealer.dto.JobHandlerResult;
import com.github.pagehelper.PageInfo;

/**
 * 询价单，和接单有关的操作
 * @author Administrator
 *
 */
public interface InquiryReceivingService {
	/**
	 * 查询当前车商人员已接单的询价单
	 * @return 已经接单的询价单列表
	 */
	PageInfo<InquiryQueryResultDto> queryInquiryReceivingByAccept(PageDto pageDto);
	
	/**
	 * 查询当前车商人员放弃接单的询价单
	 * @return 放弃的询价单列表
	 */
	PageInfo<InquiryQueryResultDto> queryInquiryReceivingByGiveup(PageDto pageDto);
	
	/**
	 * 查询当前车商人员待接单的询价单
	 * @return 待接单询价单列表
	 */
	PageInfo<InquiryQueryResultDto> queryInquiryReceivingByAwait(InquiryQueryParamDto paramDto);
	
	/**
	 * 放弃接单
	 * 跟踪ID用于判断该跟踪单下所有询价单是否都已经接单
	 * @throws Exception 
	 */
	Boolean giveupInquiryReceiving(Long inquiryId, Long reservationId, String giveupReason) throws Exception;
	

	/**
<<<<<<< HEAD
	 * 车商人员已接单
=======
	 * 查询当前车商人员已接单的询价单
	 * @return 已经接单的询价单列表
	 * @throws Exception 
>>>>>>> dev_2303
	 */
	Boolean acceptInquiryReceiving(Long inquiryId, Long reservationId) throws Exception;
	
	/**
	 * 接单截止
	 * @throws Exception 
	 */
	JobHandlerResult receivingDeadline() throws Exception;
}
