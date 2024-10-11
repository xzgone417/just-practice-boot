package com.exp.ucmp.mall.service;

import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.clues.dto.*;
import com.exp.ucmp.entity.PsiSalesCustomerEntity;
import com.exp.ucmp.entity.PsiSalesModifyConfigEntity;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author gubonai
 * @date 2023年01月13日
 */

public interface PsiRetentionService {

    /**
     * 查询商城留资线索列表
     * @param retentionCluesParamDto
     * @return
     */
    PageInfo<RetentionCluesDto> queryRetentionCluesList(RetentionCluesParamDto retentionCluesParamDto) throws Exception;

    /**
     * 查询客户信息
     * @param cluesId
     * @return
     */
    CustomerInfoDto queryCluesCustomerInfo(Long cluesId) throws Exception;

    /**
     * 根据手机号查询线索列表
     * @param customerPhone
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<RetentionCluesDto> queryRetentionListByPhone(String customerPhone, Integer pageNum, Integer pageSize);

    /**
     * 跟进记录列表
     * @param cluesId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<PsiCluesFollowRecordDto> queryCluesFollowRecord(Long cluesId, Integer pageNum, Integer pageSize);

    /**
     * 查询订单列表
     * @param cluesId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<OrderInfoDto> queryOrderList(OrderInfoParamDto orderInfoParamDto) throws Exception;


    /**
     * 查询车辆信息
     * @param vin
     * @return
     */
    VhclInfoDto queryVhclInfo(String vin);

    /**
     * 查询商城已上架的vin列表
     * @param vin
     * @return
     */
    List<String> queryVinList();

    /**
     * 添加跟进
     * @param paramDto
     * @return
     */
    String saveFollow(SaveFollowDto paramDto);

    /**
     * 战败
     * @param cluesId
     * @return
     */
    String defeat(Long cluesId);

    /**
     * 保存订单
     * @param paramDto
     * @return
     */
    String saveOrder(SaveOrderDto paramDto);

    /**
     * 获取订单详情
     * @param orderInfoId
     * @return
     */
    PsiOrderInfoDto queryOrderInfo(Long orderInfoId) throws Exception;

    void cluesTransference(CluesTransferenceDto transferenceDto);

    String readExcel(MultipartFile files) throws IOException ;

    RestResponse<String> fileDownload(HttpServletRequest request, HttpServletResponse response);

    String activation(Long cluesId);

    /**
     * 总部新建改配记录
     * @param createDto
     */
    void createModify(PsiSalesModifyConfigCreateDto createDto);

    /**
     * 订单改配审核
     * @param modifyConfigApproveDto
     */
    void modifyApprove(PsiSalesModifyConfigApproveDto modifyConfigApproveDto);

    /**
     * 查询未审核改配记录
     * @param orderInfoId
     * @return
     */
    PsiSalesModifyConfigEntity modifyProcess(Long orderInfoId);

    PageInfo<SalesCustomerDto> queryCustomerInfoList(PsiSalesCustomerDto psiSalesCustomerDto);

    void legalRight(OrderLegalRightDto orderLegalRightDto) throws Exception;

    PsiSalesCustomerEntity querySalesCustomer(Long customerId);

    Long shoppingClues(CluesCreateDto cluesCreateDto);

    void uploadTemplate(MultipartFile file, Long fileId)throws Exception;

    void orderTransference(OrderTransferenceDto transferenceDto);

    void storeRedistribution(Long storeId);

    void partyRedistribution(Long partyId);

	void changePrice(OrderChangePriceDto orderChangePriceDto) throws Exception;
}
