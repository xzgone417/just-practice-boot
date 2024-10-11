package com.exp.ucmp.servicing.service;

import com.exp.ucmp.isp.dto.QueryOrderHistoryDto;
import com.exp.ucmp.isp.dto.QuoteApplyDto;
import com.exp.ucmp.isp.dto.QuoteApprovalDto;
import com.exp.ucmp.isp.dto.QuoteOrderDto;
import com.exp.ucmp.isp.dto.QuoteStatusDto;
import com.exp.ucmp.isp.dto.WorkOrderCommonQueryDto;
import com.exp.ucmp.servicing.dto.OrderDetailDto;
import com.exp.ucmp.servicing.dto.QueryWorkOrderCommonDto;
import com.exp.ucmp.servicing.dto.QueryWorkOrderDto;

public interface ServicingService {

	String createServicing(QuoteApplyDto dto) throws Exception;

	void acceptRepairProject(QuoteOrderDto dto) throws Exception;

	void acceptRepairStatus(QuoteStatusDto dto) throws Exception;

	String quoteApproval(QuoteApprovalDto quoteApprovalDto) throws Exception;

	QueryWorkOrderDto workOrderHistory(QueryOrderHistoryDto queryOrderHistoryDto) throws Exception;

	QueryWorkOrderCommonDto workOrderQuery(WorkOrderCommonQueryDto workOrderCommonQueryDto) throws Exception;

	OrderDetailDto workOrderQueryDetails(String workOrderNo) throws Exception;

}
