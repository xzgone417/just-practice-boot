package com.exp.ucmp.mall.service;

import com.exp.ucmp.clues.dto.*;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>@ClassName: PsiSalesRetentionService</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/30 15:27<p>
 */
public interface PsiSalesRetentionService {

    PageInfo<SalesCustomerInfoDto> queryCustomerInfoList(SalesCustomerParamDto paramDto) throws Exception;

    SalesCustomerInfoDto querySalesCustomer(String role,String otherPartyId, Long customerId) throws Exception;

    PageInfo<SalesRetentionCluesDto> querySalesCluesList(SalesCluesParamDto salesCluesParamDto);

    void createClues(RetentionCluesCreateDto createDto);

    String saveFollow(SalesSaveFollowDto paramDto);

    String defeat(Long cluesId);

    List<PsiCluesFollowRecordDto> listCluesFollowRecord(Long cluesId);

    PageInfo<OrderInfoDto> queryOrderList(OrderInfoParamDto orderInfoParamDto) throws Exception;

    PsiOrderInfoDto queryOrderInfo(Long orderInfoId) throws Exception;

    OrderRespDto createOrder(SalesOrderCreateDto paramDto);

    String updateOrder(SalesOrderUpdateDto paramDto);

    /**
     * 销售新建改配记录
     * @param createDto
     */
    void saleCreateModify(PsiSalesModifyConfigCreateDto createDto) throws Exception;


    void escrow(SalesOrderMaterialDto paramDto) throws Exception;

    String cancelOrder(SalesOrderCancelDto cancelDto);

    PageInfo<SalesRetentionCluesDto> queryUndistributedCluesList(SalesCluesParamDto salesCluesParamDto) throws Exception;

    void cluesAllocation(CluesTransferenceDto transferenceDto);

    List<SalesConsultantDto> salesConsultantList(SalesConsultantParamDto paramDto)throws Exception;

    void customerAllocation(CustomerTransferenceDto transferenceDto);

    PsiCarStockInfoEntity checkVinState(String orderInfoId,String vin);
}
