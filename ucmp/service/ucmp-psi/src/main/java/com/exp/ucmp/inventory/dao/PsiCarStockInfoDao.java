package com.exp.ucmp.inventory.dao;

import com.exp.ucmp.car.dto.ApproveChangePriceDto;
import com.exp.ucmp.car.dto.CarMainInfoDto;
import com.exp.ucmp.car.dto.CarSalePriceDto;
import com.exp.ucmp.car.dto.ChangePriceParamDto;
import com.exp.ucmp.car.dto.QueryChangePriceDto;
import com.exp.ucmp.car.dto.QueryChangePriceParamDto;
import com.exp.ucmp.clues.dto.OrderChangeFileDto;
import com.exp.ucmp.clues.dto.OrderChangePriceDto;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.exp.ucmp.stock.dto.CarStockInfoDto;
import com.exp.ucmp.stock.dto.CarStockInfoListQueryDto;
import com.exp.ucmp.transfer.dto.TransferApplyCarInfoDto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * t_psi_car_stock_info表DAO
 * @author hailele
 * @date 2023-1-31
 */
public interface PsiCarStockInfoDao {


    List<CarStockInfoDto> selectCarStockList(CarStockInfoListQueryDto stockInfoListQueryDto);

    /**
     * 查询出库车辆列表
     */
    List<CarStockInfoDto> selectCarStockOutList(CarStockInfoListQueryDto stockInfoListQueryDto);

    /**
     * 根据VIN码查询车辆信息
     * @param vinCode
     * @return
     */
    TransferApplyCarInfoDto findCarInfoByVinCode(String vinCode);

    /**
     * Description: 根据条件查询集合实体（不包括已售出的车辆信息）
     * @param psiCarStockInfoEntity 查询条件
     * @return 实体集合
     */
    List<PsiCarStockInfoEntity> selectNewBySelective(PsiCarStockInfoEntity psiCarStockInfoEntity);

	List<String> findProductCodeList();

	void updateSalePrice(CarSalePriceDto carSalePriceDto);

	void addChangePriceRecord(ChangePriceParamDto paramDto);

	void updateCarStockInfo(ChangePriceParamDto paramDto);

	List<QueryChangePriceDto> queryChangePriceApproveList(QueryChangePriceParamDto paramDto);

	CarMainInfoDto getCarInfoByVin(Long stockId);

	OrderChangePriceDto queryChangePriceInfo(@Param("recordId") Long recordId,@Param("stockId") Long stockId);

	List<OrderChangeFileDto> queryFileList(Long recordId);

	void updateChangeRecordInfo(ApproveChangePriceDto paramDto);

	Long queryOrderRecordId(Long recordId);


}
