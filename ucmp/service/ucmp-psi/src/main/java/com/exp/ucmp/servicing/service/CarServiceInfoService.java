package com.exp.ucmp.servicing.service;

import com.exp.ucmp.carService.dto.*;
import com.github.pagehelper.PageInfo;

public interface CarServiceInfoService {

    CarServiceInfoDto findCarInfoByVinCode(String vinCode) throws Exception;

    CarServiceInfoDto findCarServiceInfo(Long stockId);

    void submitCarService(CarServiceInfoDto carServiceInfoDto) throws Exception;

    PageInfo<CarServiceApprovalListInfoDto> findApprovalList(CarServiceApprovalListParamDto listParamDto,Integer type);

    CarServiceWarehouInfoDto getWarehouCarInfo(Long stockId);

    PageInfo<CarServiceMaterialApprovalRecordListDto> selectApprovalRecordList(Integer pageNum, Integer pageSize, Long serviceId);

    void submitServiceMaterialFile(Long materialFileId, String rejectReason);

    void submitServiceMaterial(Long serviceId, String approvalResult, String approvalRemark);

    void submitCancelService(Long stockId);

    PageInfo<CarApproveFileListInfoDto> findCarApproveFileList(CarApproveFileListParamDto listParamDto);

	PageInfo<QueryServiceDto> findServicingList(QueryServiceParamDto paramDto);

	QueryServiceDetailsDto findServiceDetails(Long serviceId);

	void quoteOrderApproval(CarServiceApproveDto approveDto) throws Exception;
}
