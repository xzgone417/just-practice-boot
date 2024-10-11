package com.exp.ucmp.servicing.dao;

import com.exp.ucmp.entity.PsiCarServiceRepairProjectEntity;
import com.exp.ucmp.entity.PsiCustomerReservationTrackEntity;
import com.exp.ucmp.pertner.dto.SysPartnerDetailsDto;
import com.exp.ucmp.servicing.dto.*;
import com.exp.ucmp.storeApp.dto.CarDealerMsgDto;
import com.exp.ucmp.storeApp.dto.CarDealerMsgQueryDto;
import com.exp.ucmp.storeApp.dto.ReplaceCluesDetailsDto;
import com.exp.ucmp.storeApp.dto.ReplaceCluesDetailsQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author gubonai
 * @date 2023/01/30
 * 查询整备工单信息
 */
public interface PsiServicingDao {

    /**
     * 查询整备工单列表
     * @param queryServicingParamDto
     * @return
     */
    List<QueryServicingDto> queryServicingList(QueryServicingParamDto queryServicingParamDto);

    /**
     * 查询整备审批列表
     */
    List<QueryServicingDto> queryServicingApprovalList(QueryServicingApprovalDto queryServicingParamDto);

    /**
     * 查询整备车辆信息
     */
    ServicingCarInfoDto queryServicingCarInfo(Long serviceId);

    /**
     * 查询维修项目
     */
    List<MaintenanceItemsDto> queryMaintenanceItems(Long serviceId);

    /**
     * 查询维修配件
     */
    List<RepairPartsDto> queryRepairParts(Long projectId);

    /**
     * 查询维修项目预审历史记录
     */
    List<ServiceApprovalRecordDto> queryApprovalRecord(@Param("type") Integer type, @Param("serviceId")Long serviceId);

    //维修项目
    int batchUpdateSelective(@Param("type")Integer type,@Param("list") List<Long> list,@Param("party") Long partyId,
                             @Param("isRepair")Integer isRepair);

	void updateParts(ApprovalItemsPartsDto partsDto);

	void updateItems(ApprovalItemsDto item);

	List<Long> queryStorageIdList(Long partyId);


}
