package com.exp.ucmp.salesDelivery.service;

import java.util.List;

import com.exp.ucmp.salesDelivery.dto.DeliveryOrderContractDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderDetailsDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderFinancialDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderParamDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderPicDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderStatisticsDto;
import com.exp.ucmp.salesDelivery.dto.OrderCarTransferDto;
import com.exp.ucmp.salesDelivery.dto.OrderCarTransferInfoDto;
import com.exp.ucmp.salesDelivery.dto.OrderDeliveryProfileDto;
import com.exp.ucmp.salesDelivery.dto.OrderPaymentInfoDto;
import com.exp.ucmp.salesDelivery.dto.OrderPdiInfoDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquirerDto;
import com.github.pagehelper.PageInfo;

public interface SalesDelivryService {

	PageInfo<DeliveryOrderDto> delivryOrderList(DeliveryOrderParamDto deliveryOrderParamDto) throws Exception;

	List<OneselfAcquirerDto> delivryConsultantList(Long storeId, String searchWord, String staffType) throws Exception;

	int allotDelivryConsultant(Long orderInfoId, Long partyId, Long storeId);

	DeliveryOrderDetailsDto orderDetails(Long orderInfoId, String roleCode) throws Exception;

	void contractSave(DeliveryOrderContractDto dto) throws Exception;

	List<DeliveryOrderPicDto> contractList(Long orderInfoId);

	Long transferApply(OrderCarTransferDto dto) throws Exception;

	OrderCarTransferInfoDto transferApplyInfo(Long orderInfoId, String roleCode);

	Integer transferCancel(Long orderInfoId, String roleCode);

	OrderPaymentInfoDto paymentInfo(Long orderInfoId, String roleCode);

	int submitFinancialProof(DeliveryOrderFinancialDto dto) throws Exception;

	OrderPdiInfoDto pdiInfo(Long orderInfoId, String roleCode);

	void submitPdiInfo(OrderPdiInfoDto dto) throws Exception;

	OrderDeliveryProfileDto deliveryProfile(Long orderInfoId, String roleCode);

	int submitDeliveryProfile(OrderDeliveryProfileDto dto) throws Exception;

	DeliveryOrderStatisticsDto statistics(String userId, String departmentId, String roleCode);


}
