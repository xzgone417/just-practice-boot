package com.exp.ucmp.inventory.dao;

import com.exp.ucmp.warehouse.dto.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author GeYiJiang
 * @Description: 出入库dao
 * @date 2023/2/17 11:04
 */
public interface WarehouseDao {

    //调拨入库列表
    List<TransferWarehouseResultDto> queryTransferReceipt(WarehouseQueryDto queryDto);
    //调拨出库列表
    List<TransferWarehouseResultDto> queryTransferIssue(WarehouseQueryDto queryDto);
    //查询零售车辆列表
    List<TransferWarehouseResultDto> queryRetailOutbound(WarehouseQueryDto queryDto);
    //查询批售车辆列表
    List<TransferWarehouseResultDto> queryBatchIssue(WarehouseQueryDto queryDto);

    List<CheckWarehouseResultDto> queryCheckList(CheckWarehouseQueryDto queryDto);

    //整备出库列表
    List<CheckWarehouseResultDto> selectServiceList(CheckWarehouseQueryDto queryDto);

    //车商partyId查询orgId集合
    List<Long> selectOrgIdsByPartyId(Long partyId);

    //收购入库列表
    List<AcquisitionWarehouseResultDto> queryAcquisitionList(CheckWarehouseQueryDto queryDto);
    
	void updateServiceInfo(@Param("serviceId")Long serviceId,@Param("updateBy") Long updateBy);
	Long queryStockId(Long serviceId);

}
