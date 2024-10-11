package com.exp.ucmp.servicing.dao;

import com.exp.ucmp.carService.dto.*;
import com.exp.ucmp.isp.dto.QuoteComponentDto;
import com.exp.ucmp.isp.dto.QuoteOtherFeesDto;
import com.exp.ucmp.isp.dto.QuoteProjectDto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * t_psi_car_service_info表DAO
 * @author hailele
 * @date 2023-2-11
 */
public interface CarServiceInfoDao {

    CarServiceInfoDto findCarInfoByVinCode(String vinCode);

    CarServiceInfoDto findCarServiceInfo(Long stockId);

    List<CarServiceApprovalListInfoDto> findApprovalList(CarServiceApprovalListParamDto listParamDto);

    List<CarApproveFileListInfoDto> findCarApproveFileList(CarApproveFileListParamDto listParamDto);

	List<QueryServiceDto> findServicingList(QueryServiceParamDto paramDto);

	QueryServiceDetailsDto findServiceDetails(Long serviceId);

	List<QuoteProjectDto> queryProjectList(Long quoteOrderId);

	List<QuoteComponentDto> queryComponentList(Long projectId);

	List<QuoteOtherFeesDto> queryOtherFeesList(Long projectId);

	void addApproveRecord(ServiceApproveRecordDto recordDto);

	void updateProject(QuoteProjectApproveDto projectDto);

	void updateComponent(QuoteComponentApproveDto componentDto);

	void updateOtherFees(QuoteOtherFeesApproveDto otherFeesDto);

	List<ServiceApproveRecordDto> queryRecordList(Long serviceId);

	void updateServiceStatus(@Param("status")String status,@Param("partyId") Long partyId,@Param("serviceId") Long serviceId,
			@Param("recordId") Long recordId,@Param("preApprovalStatus") String preApprovalStatus);

	void updateServiceInfo(@Param("materialApprovalRecordId")Long materialApprovalRecordId,@Param("serviceId") Long serviceId,
			@Param("partyId") Long partyId,@Param("approvalResult") String approvalResult);
}
