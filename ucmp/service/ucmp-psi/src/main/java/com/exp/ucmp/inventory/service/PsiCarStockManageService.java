package com.exp.ucmp.inventory.service;

import com.exp.ucmp.entity.PsiMainteanceItemsEntity;
import com.exp.ucmp.entity.SysRegionEntity;
import com.exp.ucmp.stock.dto.*;
import com.exp.ucmp.storeApp.dto.*;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gubonai
 * @date 2023年01月13日
 */

public interface PsiCarStockManageService {

    /**
     * 根据库存车辆id查询出入库历史
     * @param stockId
     * @return
     */
    List<StockHistoryDto> queryStockHistory(Long stockId);



    /**
     * 查询车辆费用清单列表
     * @param expenseListParamDto
     * @return
     */
    ExpenseListDto  queryExpenseList(String vin);

    /**
     * Description: 保存车辆费用
     */
    String saveExpenseCost(SaveExpenseCostParamDto paramDto);

/*
    */
/**
     * 导出费用清单列表
     * @param expenseListParamDto
     *//*

    void expenseListExport(ExpenseListParamDto expenseListParamDto, HttpServletResponse response) throws IOException;
*/

    /**
     * 根据库存车辆id查询车辆仓储信息
     * @param stockId
     * @return
     */
    CarStorageInfoDto queryStockInfo(Long stockId);

    /**
     * 查询车辆基本信息
     * @param stockId
     * @param vin 
     * @return
     */
    CarStockBasicInfoDto queryStockBasicInfo(Long stockId, String vin);
    /**
     * 根据库存车辆id查询车辆流转状态
     */
    CarStatusFlowDto queryCarStatusFlow(Long stockId) throws Exception;

    /**
     * 根据库存车辆id查询车辆整备图片
     * @param serviceId 
     */
    List<CarServiceFileDto> queryCarServicingPic(Long stockId,String type, Long serviceId);

    /**
     * 零售上下架
     * @throws Exception 
     */
    boolean retailLoading(RetailLoadingDto retailLoadingDto) throws Exception;

    /**
     * 查询整备完成车辆列表
     * @param paramDto
     * @return
     */
    PageInfo<ServicingCompletedDto> queryServicingCompletedList(ServicingCompletedParamDto paramDto);

    /**
     * 查询维修项目信息
     * @param paramDto
     * @return
     */
    PageInfo<MaintenceListDto> queryMainteanceList(MaintenceParamDto paramDto);

    /**
     * 维修项目信息保存
     * @param paramDtoList
     * @return
     * @throws ParseException 
     */
    void saveMaintenceInfo(List<QueryMaintenceResultDto> paramDtoList) throws ParseException;

    /**
     * 获取已调整的维修项目信息
     * @param vin
     * @param type
     * @return
     */
    List<QueryMaintenceResultDto> queryAdjustMainteanceList(Long stockId,String vin, String type);

    /**
     * 查询历史维修信息
     * @param vin
     * @return
     */
    List<MaintenceRecordDto> queryHisMaintenanceList(Long stockId,String vin);

    /**
     * 查询商城上架车辆列表
     * @param paramDto
     * @return
     */
    PageInfo<CarStockGroundingDto> queryCarStockGroundingList(CarStockGroundingParamDto paramDto);


    CarStockGroundingDetailDto queryCarStockGroundingDetail(String stockId) throws ParseException;

    /**
     * 根据申请id查询调拨状态信息
     * @param param
     * @return
     */
    AllocationStateDto queryAllocationState(String param, String type);
}
