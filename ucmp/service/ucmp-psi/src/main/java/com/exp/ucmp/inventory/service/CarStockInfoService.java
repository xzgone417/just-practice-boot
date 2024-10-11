package com.exp.ucmp.inventory.service;

import com.exp.ucmp.Import.dto.ImportReturnDto;
import com.exp.ucmp.car.dto.ApproveChangePriceDto;
import com.exp.ucmp.car.dto.CarSalePriceDto;
import com.exp.ucmp.car.dto.ChangePriceDetailDto;
import com.exp.ucmp.car.dto.QueryChangePriceDto;
import com.exp.ucmp.car.dto.QueryChangePriceParamDto;
import com.exp.ucmp.stock.dto.*;
import com.exp.ucmp.transfer.dto.TransferApplyCarInfoDto;
import com.github.pagehelper.PageInfo;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.List;

public interface CarStockInfoService {


    ImportReturnDto readExcel(MultipartFile files);

    PageInfo<CarStockInfoDto> findCarStockList(CarStockInfoListQueryDto stockInfoListQueryDto,Integer type);

    /**
     * 出库车辆列表查询
     */
    PageInfo<CarStockInfoDto> findCarStockOutList(CarStockInfoListQueryDto stockInfoListQueryDto);

    //权益包选择列表查询
    PageInfo<RightActivitiesSelectListDto> selectActivitiesList(Integer pageNum,Integer pageSize);

    TransferApplyCarInfoDto findCarInfoByVinCode(String vinCode);

    void saveSaleRecord(List<MultipartFile> files, CarSaleRecordInfoDto saleRecordInfoDto);

    void updateSalePrices(List<CarStockInfoDto> carStockInfoList);

    void carVoid(Long stockId,String repealReason);

    CarSaleRecordDetailsDto getSaleRecordInfo(Long stockId);

    void updateDecisionType(Long stockId, String decisionType);

    void updateBaseStockInfo(CarStockBaseInfoDto carStockInfo);

    void uploadFormwork(MultipartFile file);

	List<String> findProductCodeList();

	void updateSalePrice(CarSalePriceDto carSalePriceDto) throws Exception;

	PageInfo<QueryChangePriceDto> queryChangePriceApproveList(QueryChangePriceParamDto paramDto) throws ParseException;

	ChangePriceDetailDto queryChangePriceApproveDetail(Long stockId, Long recordId);

	void queryChangePriceApprove(ApproveChangePriceDto paramDto) throws Exception;
}
