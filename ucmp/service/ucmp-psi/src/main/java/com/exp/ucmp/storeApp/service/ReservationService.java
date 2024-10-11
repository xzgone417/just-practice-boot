package com.exp.ucmp.storeApp.service;

import java.util.List;

import com.exp.ucmp.eos.dto.ReservationDto;
import com.exp.ucmp.eos.dto.ReservationParamDto;
import com.exp.ucmp.storeApp.dto.AcquisitionWarehousingDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquirerDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquisitionDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquisitionParamDto;
import com.exp.ucmp.storeApp.dto.OneselfOrderDetailsDto;
import com.exp.ucmp.storeApp.dto.OneselfOrderPicsDto;
import com.exp.ucmp.storeApp.dto.OneselfStatisticsDto;
import com.exp.ucmp.storeApp.dto.TransferOwnershipDto;
import com.github.pagehelper.PageInfo;

public interface ReservationService {

	List<ReservationDto> reservationList(ReservationParamDto reservationparamdto);

	OneselfStatisticsDto statistics(String userId, String departmentId, String roleCode);

	PageInfo<OneselfAcquisitionDto> acquisitionList(OneselfAcquisitionParamDto paramDto) throws Exception;

	List<OneselfAcquirerDto> acquirerList(Long storeId, String searchWord) throws Exception;

	int allotAcquirer(Long inquiryId, Long partyId);

	OneselfOrderDetailsDto orderDetails(Long inquiryId, String roleCode);

	OneselfOrderPicsDto orderPics(Long reservationId);

	void acquisitionWarehousing(AcquisitionWarehousingDto dto) throws Exception;

	void transferOwnership(TransferOwnershipDto dto);

}
