package com.exp.ucmp.servicing.service;

import com.exp.ucmp.pricing.PricingJournalDto;
import com.exp.ucmp.servicing.dto.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author gubonai
 * @date 2023年01月13日
 */

public interface PsiServicingService {


    /**
     * 查询工单列表
     * @param queryServicingParamDto
     * @return
     */
    PageInfo<QueryServicingDto> queryServicingList(QueryServicingParamDto queryServicingParamDto);
    //整备审批列表
    PageInfo<QueryServicingDto> queryServicingApprovalList(QueryServicingApprovalDto query);

    ServicingCarInfoDto queryServicingCarInfo(Long serviceId);

    /**
     * 维修项目列表
     */
    MaintenanceApprovalDto queryMaintenanceApproval(Integer type,Long serviceId);

    boolean approval(ApprovalParamsDto paramsDto);

}
