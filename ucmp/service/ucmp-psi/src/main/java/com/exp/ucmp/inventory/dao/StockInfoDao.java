package com.exp.ucmp.inventory.dao;

import com.exp.ucmp.entity.PsiCarServiceInfoEntity;
import com.exp.ucmp.stock.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2023/2/3 11:12
 */
public interface StockInfoDao {
    CarStorageInfoDto queryStockInfo(Long stockId);

    CarStockBasicInfoDto queryStockBasicInfo(@Param("stockId")Long stockId,@Param("vin") String vin);

    List<ServicingCompletedDto> queryServicingCompletedList(ServicingCompletedParamDto paramDto);


    List<CarServiceFileDto> queryFile(@Param("serviceId") Long serviceId,@Param("type") String type,@Param("stockId") Long stockId);

    //图片详情
    List<CarServiceFileDetailDto> queryFileDetail(Long materialId);

    List<MaintenceListDto> queryMainteanceList(MaintenceParamDto paramDto);

    List<SaveMaintenceParamDto> queryAdjustMainteanceList(@Param("stockId") Long stockId,
                                                          @Param("vin") String vin,
                                                          @Param("type") String type,
                                                          @Param("maintainType") String maintainType);

    List<CarStockGroundingDto> queryCarStockGroundingList(CarStockGroundingParamDto paramDto);

    CarStockGroundingDetailDto queryCarStockGroundingDetail(String stockId);

    List<CarRightDto> getRightList(String rightPackId);

    //查询维修项目生成时间
    String selectRepairTime(Long serviceId);

    PsiCarServiceInfoEntity selectBySelective(Long stockId);

	String getConfigTopPicUrl(String carSeriesCode);

	List<QueryMaintenceResultDto> getCollectFees();

	List<String> queryTestReportUrl(Long stockId);
}
