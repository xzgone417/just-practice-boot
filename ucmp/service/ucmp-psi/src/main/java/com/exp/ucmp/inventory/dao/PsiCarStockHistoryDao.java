package com.exp.ucmp.inventory.dao;

import com.exp.ucmp.servicing.dto.StorageHistoryListInfoDto;

import java.util.List;

/**
 * t_psi_car_service_inquiry_history表DAO
 * @author hailele
 * @date 2023-2-28
 */
public interface PsiCarStockHistoryDao {


    List<StorageHistoryListInfoDto> selectStorageHistoryList(Long stockId);

}
