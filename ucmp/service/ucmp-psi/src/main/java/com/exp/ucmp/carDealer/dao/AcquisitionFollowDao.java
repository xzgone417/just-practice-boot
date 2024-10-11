package com.exp.ucmp.carDealer.dao;

import com.exp.ucmp.carDealer.dto.AcquisitionAllFileDto;
import com.exp.ucmp.carDealer.dto.AcquisitionDetailsDto;
import com.exp.ucmp.carDealer.dto.AcquisitionQueryResultDto;
import com.exp.ucmp.carDealer.dto.AllotDeliveryCenterDto;
import com.exp.ucmp.carDealer.dto.RepOrderNeedDto;
import com.exp.ucmp.entity.PsiCarDealerInquiryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/16 9:46
 */
public interface AcquisitionFollowDao {

    /**
     * 查询待收购 待议价 已收购 未收购
     * @param type 类型 1待收购 2待议价 3已收购 4未收购
     * @param carDealerId
     * @param carDealerStaffId
     * @return
     */
    List<AcquisitionQueryResultDto> queryAcquisitionFollowByAwait(@Param("type") Integer type, @Param("carDealerId")Long carDealerId , @Param("carDealerStaffId")Long carDealerStaffId,@Param("businessOrderNo") String businessOrderNo);

    /**
     * NEW 查询收购
     * @param status
     * @param carDealerId
     * @param carDealerStaffId
     * @return
     */
    List<AcquisitionQueryResultDto> newQueryAcquisitionFollow(@Param("status") List<String> status, @Param("carDealerId")Long carDealerId , @Param("carDealerStaffId")Long carDealerStaffId, @Param("businessOrderNo")String businessOrderNo);

    /**
     * 更新 询价表
     * @param psiCarDealerInquiryEntity
     * @return
     */
    int updateInquirySelective(PsiCarDealerInquiryEntity psiCarDealerInquiryEntity);

    /**
     * 查询收购详情
     * @param reservationId
     * @return
     */
    AcquisitionDetailsDto acquisitionDetails(@Param("reservationId") Long reservationId);

    /**
     * 查询文件列表
     */

    List<AcquisitionAllFileDto> acquisitionMaterialList(@Param("reservationId") Long reservationId);

    /**
     * 驳回原因
     * @param reservationId
     * @return
     */
    String queryRejectedReason(@Param("reservationId") Long reservationId);

    /**
     * 查询置换单所需信息
     * @param reservationId
     * @return
     */
    RepOrderNeedDto queryReplacementOrderInfo(Long reservationId);

    /**
     * 查询二手车主管手机号
     * @return
     */
    List<String> queryUsedCarSupervisor(Long storeId);

	int allotDeliveryCenter(AllotDeliveryCenterDto paramDto);

	void updateTrackStatus(Long reservationId);

	Long getFileId(Long materialId);

	List<String> queryAlias(Long storeId);

}
