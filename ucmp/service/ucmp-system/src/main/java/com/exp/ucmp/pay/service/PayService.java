package com.exp.ucmp.pay.service;


import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.exp.ucmp.entity.SysPayConfigEntity;
import com.exp.ucmp.pay.dto.AddPaymentRecordDto;
import com.exp.ucmp.pay.dto.PayCallBackDto;
import com.exp.ucmp.pay.dto.PayDto;
import com.exp.ucmp.pay.dto.PayMatchingDto;
import com.exp.ucmp.pay.dto.PayRefundDto;
import com.exp.ucmp.pay.dto.PayRejectDto;
import com.exp.ucmp.pay.dto.QueryBankStatementDto;
import com.exp.ucmp.pay.dto.QueryOrderInfoDto;
import com.exp.ucmp.pay.dto.QueryOrderParamsDto;
import com.exp.ucmp.pay.dto.QueryStatementParamsDto;
import com.exp.ucmp.pay.dto.RecordDetailsDto;
import com.exp.ucmp.pay.dto.StatementDetailsDto;
import com.exp.ucmp.sap.dto.SapBankTransferStatementDto;
import com.github.pagehelper.PageInfo;

public interface PayService {

	void payCallBack(PayCallBackDto payCallBackDto);

	String paymentUnitorderPay(PayDto payDto) throws Exception;

	String paymentRefund(PayRefundDto payRefundDto) throws Exception;

	SysPayConfigEntity revertBodyPayInfo(String revertBody) throws Exception;

	Boolean addPaymentRecord(AddPaymentRecordDto addPaymentRecordDto);

	int bankTransferStatement(SapBankTransferStatementDto sapBankTransferStatementDto);

	PageInfo<QueryOrderInfoDto> queryPaymentRecordInfo(QueryOrderParamsDto queryOrderParamsDto) throws Exception;

	void exportPaymentRecordInfo(QueryOrderParamsDto queryOrderParamsDto, HttpServletResponse response) throws Exception;

	RecordDetailsDto queryPaymentRecordDetails(String recordCode);

	PageInfo<QueryBankStatementDto> queryBankStatementInfo(QueryStatementParamsDto queryStatementParamsDto);

	void rejectPayInfo(PayRejectDto payRejectDto);

	int matchingPayInfo(PayMatchingDto payMatchingDto) throws IOException;

	int verifyPayInfo(StatementDetailsDto statementDetailsDto) throws IOException;

	int unbindPayInfo(PayMatchingDto payMatchingDto) throws IOException;


}
