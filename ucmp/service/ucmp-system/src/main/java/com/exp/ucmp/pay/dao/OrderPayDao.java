package com.exp.ucmp.pay.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exp.ucmp.pay.dto.PayDetailsDto;
import com.exp.ucmp.pay.dto.PayRejectDto;
import com.exp.ucmp.pay.dto.QueryBankStatementDto;
import com.exp.ucmp.pay.dto.QueryOrderInfoDto;
import com.exp.ucmp.pay.dto.QueryOrderParamsDto;
import com.exp.ucmp.pay.dto.QueryStatementParamsDto;
import com.exp.ucmp.pay.dto.StatementDetailsDto;
import com.exp.ucmp.salesDelivery.dto.OrderPaymentInfoDto;
import com.exp.ucmp.sap.dto.SapBankTransferStatementDto;

public interface OrderPayDao {

	OrderPaymentInfoDto queryOrderInfo(@Param("recordId")Long recordId,@Param("orderId") Long orderId,@Param("recordCode") String recordCode);

	void updateOrderInfo(@Param("receivedPrice")Double receivedPrice,@Param("notReceivedPrice") Double notReceivedPrice,@Param("orderInfoId") Long orderInfoId,
			@Param("partyId") Long partyId,@Param("paymentItem") String paymentItem,@Param("amount") Double amount,@Param("payTime") String payTime
			,@Param("payStatus") String payStatus);

	void bankTransferStatement(SapBankTransferStatementDto sapBankTransferStatementDto);

	List<QueryOrderInfoDto> queryPaymentRecordInfo(QueryOrderParamsDto queryOrderParamsDto);

	PayDetailsDto queryPayDetails(String recordCode);

	StatementDetailsDto queryStatementDetails(String recordCode);

	List<QueryBankStatementDto> queryBankStatementInfo(QueryStatementParamsDto queryStatementParamsDto);

	void rejectPayInfo(PayRejectDto payRejectDto);

	void addMatchingRecord(StatementDetailsDto detailsDto);

	void updatePayRecordInfo(@Param("recordId") Long recordId,@Param("partyId") Long partyId,@Param("recordCode") String recordCode,@Param("payStatus") String payStatus);

	void modifyOrderInfo(@Param("receivedPrice")Double receivedPrice,@Param("notReceivedPrice") Double notReceivedPrice,@Param("orderInfoId") Long orderInfoId,
			@Param("partyId") Long partyId,@Param("paymentItem") String paymentItem,@Param("amount") Double amount,@Param("payTime") String payTime
			,@Param("payStatus") String payStatus);

	void updateBankStatementInfo(@Param("zbiiln")String zbiiln, @Param("matchingAmount")Double matchingAmount,@Param("partyId") Long partyId);

	void rollbackOrderInfo(@Param("receivedPrice")Double receivedPrice,@Param("notReceivedPrice") Double notReceivedPrice,@Param("orderInfoId") Long orderInfoId,
			@Param("partyId") Long partyId,@Param("paymentItem") String paymentItem,@Param("amount") Double amount,@Param("payTime") String payTime
			,@Param("payStatus") String payStatus);

	String getOrderNo(Long orderId);


}
