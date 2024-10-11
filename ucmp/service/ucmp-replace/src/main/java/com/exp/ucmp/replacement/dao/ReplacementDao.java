package com.exp.ucmp.replacement.dao;


import com.exp.ucmp.carDealer.dto.SaveTransactionPriceDto;
import com.exp.ucmp.carService.dto.OneselfApproveDto;
import com.exp.ucmp.carService.dto.OneselfPutIntoStorageDto;
import com.exp.ucmp.replacement.dto.*;
import com.exp.ucmp.storeApp.dto.OneselfCarPicDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022/09/13
 * 查询合作商信息
 */
public interface ReplacementDao {

    public List<RepReplacementApprovalReturnDto> selectReplaceApproval(RepReplacementApprovalDto repReplacementApprovalDto);

    public List<RepReplacementApprovalReturnDto> selectOldConfirm(RepReplacementApprovalDto repReplacementApprovalDto);

    public List<PsiCustomerCarsDto> selectOldCar(PsiCustomerCarsQueryDto psiCustomerCarsQueryDto);

    public List<RepReplacementMaterialDto> selectMaterial(RepReplacementMaterialQueryDto repReplacementMaterialQueryDto);

    public List<RepReplacementApprovalRecordDto> selectApprovalHistory(ApprovalHistoryDto approvalHistoryDto);

    public List<ReplacementOrderQueryDto> selectReplacementOrder(@Param("paramsDto") ReplacementOrderQueryParamsDto paramsDto);
    
    public ReplaceDetailsDto getReplaceDetails(@Param("reservationId") Long reservationId);

	public OldCarInfoDto getOldCarInfo(@Param("reservationId") Long reservationId);

	public List<TakeOrdersDto> getTakeOrders(@Param("reservationId") Long reservationId);

	public List<QuoteRecordDto> getQuoteRecord(@Param("reservationId") Long reservationId);

	public List<AcquisitionRecordDto> getAcquisitionRecord(@Param("reservationId") Long reservationId);

    String selectApprovalName(@Param("partyId")Long partyId);

    String selectCodeByValue(String code);

	public void updateInquiry(SaveTransactionPriceDto dto);

	public void updateAcquisition(SaveTransactionPriceDto dto);

	public void updateAcquisitionStatus(OneselfApproveDto dto);

	public void updateInquiryStatus(OneselfApproveDto dto);

	public List<OneselfCarPicDto> queryPic(@Param("reservationId")Long reservationId,@Param("typeList") List<String> typeList);

	public void putIntoStorage(OneselfPutIntoStorageDto dto);

	public void updateApproval(@Param("isGrant")Integer isGrant,@Param("reservationId") Long reservationId,@Param("partyId") Long partyId);

	public List<ReplacementOrderQueryDto> selectReplacementOrderNew(@Param("paramsDto")ReplacementOrderQueryParamsDto paramsDto);

	public void updateApprovalStatus(OneselfApproveDto dto);

	public Long getApprovalId(Long reservationId);

	public OldCarInfoDto getOldCarInfoNew(Long reservationId);

	public String getBusinessType(Long reservationId);

	public void updateInquiryStatusNew(OneselfPutIntoStorageDto dto);

	public PsiNewCarOrderDto selectNewCarOrderInfo(Long reservationId);

	public int countCar(String vinCode);

	public CarStorageInfoDto queryCarInfo(Long reservationId);

	public void updateCustomerCars(OneselfApproveDto dto);

	public List<String> queryAlias(Long reservationId);

	public String queryOrderNum(Long reservationId);

	public List<ReplacementOrderExportNewDto> selectReplacementExportOrderNew(ReplacementOrderQueryParamsDto paramsDto);

	public void updateApprovalDel(@Param("reservationId")Long reservationId,@Param("partyId") Long partyId);

	public String getCampaignName(Long reservationId);

	public Integer getPointsValue(Long reservationId);

}
