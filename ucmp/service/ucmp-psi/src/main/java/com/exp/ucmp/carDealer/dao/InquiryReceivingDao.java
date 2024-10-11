package com.exp.ucmp.carDealer.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.exp.ucmp.carDealer.dto.InquiryQueryResultDto;
import com.exp.ucmp.carDealer.dto.InquiryStatusCountDto;
import com.exp.ucmp.entity.PsiCarDealerInquiryEntity;
import com.exp.ucmp.entity.PsiCustomerReservationTrackEntity;

/**
 * 询价单接单的ORM操作
 * @author Administrator
 *
 */
public interface InquiryReceivingDao {

	/**
	 * 查询指定车商人员已完成接单的询价单（包括已接单、放弃接单）
	 * @param params 查询参数，主要涉及车商人员、欲查询的状态
	 * @return 指定条件的询价单
	 */
	List<InquiryQueryResultDto> queryInquiryReceivingByComplete(Map<String, Object> params);
	
	/**
	 * 查询指定车商人员待接单的询价单
	 * @param params 查询参数，主要涉及车商、门店
	 * @return 指定条件的询价单
	 */
	List<InquiryQueryResultDto> queryInquiryReceivingByAwait(Map<String, Object> params);
	
	/**
	 * 完成接单
	 * @param entity
	 * @return 更新的行数
	 */
	int completeReceiving(PsiCarDealerInquiryEntity entity);
	
	/**
	 * 统计各询价单各状态的数量
	 * @param reservationId
	 * @return
	 */
	List<InquiryStatusCountDto> countInquiryByStatus(@Param("reservationId") Long reservationId);
	
	/**
	 * 查询指定状态，晚于指定时间的预约跟踪单
	 * @param params
	 * @return
	 */
	List<PsiCustomerReservationTrackEntity> selectTrackByDeadlineTime(Map<String, Object> params);
}
