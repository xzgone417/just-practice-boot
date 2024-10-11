package com.exp.ucmp.salesDelivery.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.exp.ucmp.salesDelivery.dto.DeliveryOrderDetailsDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderFinancialDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderParamDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderPicDto;
import com.exp.ucmp.salesDelivery.dto.OrderCarTransferInfoDto;
import com.exp.ucmp.salesDelivery.dto.OrderDeliveryProfileDto;
import com.exp.ucmp.salesDelivery.dto.OrderPaymentInfoDto;
import com.exp.ucmp.salesDelivery.dto.OrderPaymentRecordDto;
import com.exp.ucmp.salesDelivery.dto.OrderPdiInfoDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquirerDto;

public interface SalesDeliveryDao {

	List<DeliveryOrderDto> delivryOrderList(DeliveryOrderParamDto deliveryOrderParamDto);

	List<OneselfAcquirerDto> delivryConsultantList(@Param("storeId")Long storeId,@Param("searchWord") String searchWord,@Param("phoneNumber") String phoneNumber,@Param("roleList") List<String> roleList);

	Integer countUndoneNum(OneselfAcquirerDto oneselfAcquirerDto);

	int checkConsultant(@Param("orderInfoId")Long orderInfoId,@Param("partyId") Long partyId,@Param("storeId") Long storeId);

	int checkOrderStatus(Long orderInfoId);

	int updateOrderInfo(@Param("orderInfoId")Long orderInfoId,@Param("partyId") Long partyId,@Param("updateBy") Long updateBy,@Param("status") String status,@Param("isAll") int isAll,@Param("storeId") Long storeId);

	DeliveryOrderDetailsDto orderDetails(@Param("orderInfoId") Long orderInfoId,@Param("partyId") Long partyId,@Param("isAll") Integer isAll,@Param("storeId")Long storeId);

	void clearMaterial(@Param("orderInfoId")Long orderInfoId,@Param("materialType") List<String> materialType);

	int checkStoreOrder(@Param("orderInfoId")Long orderInfoId,@Param("storeId")Long storeId);

	List<DeliveryOrderPicDto> materialList(@Param("orderInfoId")Long orderInfoId,@Param("materialType") List<String> materialType);

	Map<String, String> getOrderCarInfo(Long orderInfoId);

	OrderCarTransferInfoDto transferApplyInfo(@Param("orderInfoId")Long orderInfoId,@Param("isAll") Integer isAll,@Param("storeId")Long storeId,@Param("partyId") Long partyId);

	void updateTransferApplyInfo(@Param("transferApplyId")Long transferApplyId,@Param("updateBy") Long updateBy);

	OrderPaymentInfoDto paymentInfo(@Param("orderInfoId")Long orderInfoId,@Param("isAll") Integer isAll,@Param("storeId")Long storeId,@Param("partyId") Long partyId);

	List<OrderPaymentRecordDto> paymentRecord(@Param("orderInfoId")Long orderInfoId, @Param("storeId")Long storeId, @Param("roleCode") String roleCode);

	void updateFinancialLoan(DeliveryOrderFinancialDto dto);

	int checkOrderConsultant(DeliveryOrderFinancialDto dto);

	int checkOrderConsultant(@Param("updateBy")Long updateBy,@Param("orderInfoId") Long orderInfoId, @Param("storeId")Long storeId);

	void updateFinancialLoan(@Param("orderInfoId")Long orderInfoId,@Param("receivedPrice") Double receivedPrice,
			@Param("notReceivedPrice") Double notReceivedPrice,@Param("amount") Double amount,@Param("updateBy")Long updateBy,
			@Param("orderStatus") String orderStatus,@Param("setPaymentSum") Double setPaymentSum,@Param("balancePaymentSum") Double balancePaymentSum,
			@Param("otherPayments")Double otherPayments);

	OrderPdiInfoDto pdiInfo(@Param("orderInfoId")Long orderInfoId,@Param("isAll") Integer isAll,@Param("storeId")Long storeId,@Param("partyId") Long partyId);

	void updateOrderPdiInfo(@Param("orderInfoId")Long orderInfoId,@Param("pdiStatus")String pdiStatus,@Param("pdiResult") String pdiResult,
			@Param("partyId") Long partyId);

	Long checkOrderTransferInfo(Long orderInfoId);

	OrderDeliveryProfileDto deliveryProfile(@Param("orderInfoId")Long orderInfoId,@Param("isAll") Integer isAll,@Param("storeId")Long storeId,@Param("partyId") Long partyId);

	void updateMainUserInfo(OrderDeliveryProfileDto dto);

	void updateOderStatus(OrderDeliveryProfileDto dto);

	Long queryPartyId(String userId);

	Long queryStoreId(String departmentId);

	Integer countUnAllocatedNum(Long storeId);

	Integer countUnFullPaymentNum(@Param("partyId")Long partyId,@Param("storeId") Long storeId);

	Integer countUnDeliveryNum(@Param("partyId")Long partyId,@Param("storeId") Long storeId);

	Integer countDeliveredNum(@Param("partyId")Long partyId,@Param("storeId") Long storeId);

	List<String> queryAlias(Long partyId);

	String queryOrderNum(Long orderInfoId);

	void updateStockCarStatus(@Param("orderInfoId")Long orderInfoId, @Param("partyId")Long partyId);


}
