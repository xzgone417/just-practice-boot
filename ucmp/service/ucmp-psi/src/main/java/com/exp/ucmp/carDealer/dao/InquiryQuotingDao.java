package com.exp.ucmp.carDealer.dao;

import com.exp.ucmp.carDealer.dto.AcquisitionAllFileDto;
import com.exp.ucmp.carDealer.dto.InquiryQuotingResultDto;
import com.exp.ucmp.carDealer.dto.QuotingDto;
import com.exp.ucmp.entity.PsiCarDealerInquiryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface InquiryQuotingDao {

	/**
	 * 查询指定车商人员的询价单（包括已报价、放弃报价、等待报价）
	 * @param params 查询参数，主要涉及车商人员、欲查询的状态
	 * @return 指定条件的询价单
	 */
	List<InquiryQuotingResultDto> queryInquiryQuoting(Map<String, Object> params);

	/**
	 * 查询指定车商人员的询价单（包括已报价客户拒绝，等待报价和已接单）
	 * @param params 查询参数，主要涉及车商人员、欲查询的状态
	 * @return 指定条件的询价单
	 */
	List<InquiryQuotingResultDto> queryInquiryQuote(Map<String, Object> params);

	/**
	 * 查询指定车商人员的询价单（包括已报价等待协商）
	 * @param params 查询参数，主要涉及车商人员、欲查询的状态
	 * @return 指定条件的询价单
	 */
	List<InquiryQuotingResultDto> queryInquiryQuotingAccept(Map<String, Object> params);

	/**
	 * 查询指定车商人员的所有询价单
	 * @param params 查询参数，主要涉及车商人员、欲查询的状态
	 * @return 指定条件的询价单
	 */
	List<InquiryQuotingResultDto> queryInquiryByAll(Map<String, Object> params);

	/**
	 * 查询指定预约id的所有询价单
	 * @param params 查询参数
	 * @return 指定条件的询价单
	 */
	List<PsiCarDealerInquiryEntity> selectByReservationId(Map<String, Object> params);

	/**
	 * 根据计时器查询所到期的具体内容
	 */
	List<QuotingDto> quotingById(Long id);

	/**
	 * 更新询价表状态（放弃报价）
	 * @param psiCarDealerInquiryEntity
	 * @return
	 */
	int updateQuotingStatus(PsiCarDealerInquiryEntity psiCarDealerInquiryEntity);

	/**
	 * 查询报价文件列表
	 * @param reservationId
	 * @return
	 */
	List<AcquisitionAllFileDto> quotedMaterialList(@Param("reservationId") Long reservationId);

	int countRecord(String userData);
}
