package com.exp.ucmp.servicing.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exp.ucmp.carService.dto.QueryServiceDetailsDto;
import com.exp.ucmp.carService.dto.ServiceApproveRecordDto;
import com.exp.ucmp.isp.dto.QuoteComponentAddDto;
import com.exp.ucmp.isp.dto.QuoteOrderAddDto;
import com.exp.ucmp.isp.dto.QuoteOtherFeesAddDto;
import com.exp.ucmp.isp.dto.QuoteProjectAddDto;

public interface ServicingDao {

	int checkServingOrder(String ucmpOrderNo);

	void addQuoteOrder(QuoteOrderAddDto addDto);

	void addQuoteProject(List<QuoteProjectAddDto> projectAddList);

	void addQuoteComponent(List<QuoteComponentAddDto> componentAddList);

	void addQuoteOtherFees(List<QuoteOtherFeesAddDto> otherFeesAddList);

	void updateServicingSatus(@Param("quoteOrderId") Long quoteOrderId,@Param("status") String status,@Param("createdBy") Long createdBy,
			@Param("serviceNumber") String serviceNumber,@Param("planCompleteDate") String planCompleteDate,@Param("totalPrice") Double totalPrice,@Param("workOrderNo") String workOrderNo);

	QueryServiceDetailsDto findServiceDetails(String ucmpOrderNo);

	void updateCarStockStatus(@Param("partyId")Long partyId,@Param("stockStatus") String stockStatus,@Param("stockId") Long stockId);

	List<ServiceApproveRecordDto> queryRecordList(@Param("serviceId")Long serviceId,@Param("approvalResult") String approvalResult);

}
