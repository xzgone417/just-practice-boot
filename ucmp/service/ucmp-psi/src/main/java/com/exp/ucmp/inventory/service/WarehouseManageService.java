package com.exp.ucmp.inventory.service;

import com.exp.ucmp.servicing.dto.StorageHistoryListInfoDto;
import com.exp.ucmp.warehouse.dto.*;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 出入库管理
 * @date 2023/2/16 17:59
 */
public interface WarehouseManageService {

    boolean isDeliveryCenter();
    //零售 批售出库
    boolean batchDelivery(BatchDeliveryParamsDto paramsDto);

    //查询调拨入库列表
    PageInfo<TransferWarehouseResultDto> transferReceipt(WarehouseQueryDto queryDto);

    //查询调拨出库列表
    PageInfo<TransferWarehouseResultDto> transferIssue(WarehouseQueryDto queryDto);

    //查询零售车辆列表
    PageInfo<TransferWarehouseResultDto> retailOutbound(WarehouseQueryDto queryDto);


    //查询批售车辆列表
    PageInfo<TransferWarehouseResultDto> batchIssue(WarehouseQueryDto queryDto);

    //查询验收入库列表
    PageInfo<CheckWarehouseResultDto> checkList(CheckWarehouseQueryDto queryDto);

    Long uploadServiceMaterialFile(Long serviceId, MultipartFile file, String materialType, String materialFileType,String chineseDescription,
    		Integer fileSort, Long stockId);

    void submitStorage(Long stockId);

    PageInfo<StorageHistoryListInfoDto> selectStorageHistoryList(Long stockId,Integer pageNum, Integer pageSize);

    PageInfo<CheckWarehouseResultDto> serviceList(CheckWarehouseQueryDto queryDto);

    void deleteServiceMaterialFile(Long materialFileId);

    void submitOutStorages(String serviceIds);

    void updateMaterialFileRemarks(Long materialFileId, String chineseDescription);

    PageInfo<AcquisitionWarehouseResultDto> acquisitionList(CheckWarehouseQueryDto queryDto);
}
