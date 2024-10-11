package com.exp.ucmp.storeApp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exp.ucmp.eos.dto.ReservationDto;
import com.exp.ucmp.eos.dto.ReservationParamDto;
import com.exp.ucmp.storeApp.dto.AcquisitionWarehousingDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquirerDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquisitionDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquisitionParamDto;
import com.exp.ucmp.storeApp.dto.OneselfCarPicDto;
import com.exp.ucmp.storeApp.dto.OneselfOrderDetailsDto;

public interface ReservationDao {

	List<ReservationDto> reservationList(ReservationParamDto reservationparamdto);

	Long queryPartyId(String userId);

	Long queryStoreId(String departmentId);

	Integer countUnAllocatedNum(Long storeId);

	Integer countUnAcquisitionNum(@Param("partyId") Long partyId,@Param("storeId") Long storeId);

	Integer countUnApproveNum(@Param("partyId") Long partyId,@Param("storeId") Long storeId);
	
	Integer countApprovalRejectionNum(@Param("partyId") Long partyId,@Param("storeId") Long storeId);
	
	Integer countPendingStockNum(@Param("partyId") Long partyId,@Param("storeId") Long storeId);
	
	Integer countWarehousedNumm(@Param("partyId") Long partyId,@Param("storeId") Long storeId);

	List<OneselfAcquisitionDto> acquisitionList(OneselfAcquisitionParamDto paramDto);

	List<OneselfAcquirerDto> acquirerList(@Param("storeId") Long storeId,@Param("roleList") List<String> roleList,@Param("searchWord") String searchWord,@Param("phoneNumber") String phoneNumber);

	Integer countUndoneNum(OneselfAcquirerDto oneselfAcquirerDto);

	int allotAcquirer(@Param("inquiryId") Long inquiryId,@Param("partyId") Long partyId,@Param("updateBy") Long updateBy);

	int check(@Param("partyId") Long partyId,@Param("inquiryId") Long inquiryId,@Param("roleList") List<String> roleList);

	OneselfOrderDetailsDto queryOrderDetails(@Param("inquiryId") Long inquiryId,@Param("partyId") Long partyId,@Param("isAll") Integer isAll);

	List<OneselfCarPicDto> queryPic(@Param("reservationId") Long reservationId,@Param("typeList") List<String> typeList,@Param("tag") String tag);

	void updateAcquisitionStatus(AcquisitionWarehousingDto dto);

	void updateInquiryStatus(AcquisitionWarehousingDto dto);

	Double queryDealPriceEnd(Long reservationId);

	List<String> getReason(Long reservationId);

	Long getReservationId(Long inquiryId);

	void clearAcquisitionMaterial(@Param("reservationId")Long reservationId,@Param("type") int type);

	int countReplaceNum(Long reservationId);

	void updateInquiry(Long reservationId);

	String queryRevertBody(Long reservationId);

	List<String> queryAlias(Long partyId);

	String queryOrderNum(Long inquiryId);

}
