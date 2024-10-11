package com.exp.ucmp.carDealer.service;

import com.exp.ucmp.PageDto;
import com.exp.ucmp.carDealer.dto.*;
import com.exp.ucmp.entity.PsiBusinessNodesMaterialEntity;
import com.exp.ucmp.file.dto.MaterialParamDto;
import com.github.pagehelper.PageInfo;

/**
 * @author GeYiJiang
 * @Description: 收购跟进
 * @date 2022/10/16 10:40
 */
public interface AcquisitionFollowService {

    /**
     * 待收购
     * @param pageDto
     * @return 待收购列表
     */
    PageInfo<AcquisitionQueryResultDto> queryUnAcquired(PageDto pageDto);

    /**
     * 待议价
     * @param pageDto
     * @return 待议价列表
     */
    PageInfo<AcquisitionQueryResultDto> queryUnNegotiated(PageDto pageDto);

    /**
     * 已收购
     * @param pageDto
     * @return 已收购列表
     */
    PageInfo<AcquisitionQueryResultDto> queryAcquired(PageDto pageDto);

    /**
     * 未收购
     * @param pageDto
     * @return 未收购
     */
    PageInfo<AcquisitionQueryResultDto> queryNotAcquired(PageDto pageDto);

    /**
     * 审批驳回
     * @param pageDto
     * @return
     */
    PageInfo<AcquisitionQueryResultDto> queryRejected(AcquisitionQueryParamDto pageDto);

    /**
     * 放弃收购
     * @param reservationId
     * @return
     */
    Boolean abandonAcquisition(Long reservationId,String acquisitionAbandonedReason);

    /**
     * ***********************NEW收购查询********************************
     */
    /**
     * NEW 待收购
     * @param pageDto
     * @return
     */
    PageInfo<AcquisitionQueryResultDto> newQueryUnAcquired(AcquisitionQueryParamDto pageDto);

    /**
     * 待过户
     * @param pageDto
     * @return
     */
    PageInfo<AcquisitionQueryResultDto> queryUnTransfer(AcquisitionQueryParamDto pageDto);

    /**
     * 已完成
     * @param pageDto
     * @return
     */
    PageInfo<AcquisitionQueryResultDto> QueryCompleted(AcquisitionQueryParamDto pageDto);

    /**
     * 已上报
     * @param pageDto
     * @return
     */
    PageInfo<AcquisitionQueryResultDto> QueryReported(AcquisitionQueryParamDto pageDto);

    /**
     * 关闭/失效
     * @param pageDto
     * @return
     */
    PageInfo<AcquisitionQueryResultDto> QueryClosedOrInvalid(AcquisitionQueryParamDto pageDto);

    /**
     * NEW 放弃收购
     * @param reservationId
     * @return
     * @throws Exception 
     */
    Boolean newAbandonAcquisition(Long reservationId,String acquisitionAbandonedReason) throws Exception;

    /**
     * 收购详情
     * @param reservationId
     * @return
     */
    AcquisitionDetailsDto acquisitionDetails(Long reservationId);

    /**
     * 返回业务节点数据
     * @param businessNodesQueryDto
     * @return
     */
    PageInfo<PsiBusinessNodesMaterialEntity> queryBusinessNodesMaterialEntity(BusinessNodesQueryDto businessNodesQueryDto);

    /**
     * 批量删除文件
     * @param fileDto
     * @return
     */
    Boolean batchDeleteFile(BatchDeleteFileDto fileDto);

    /**
     * 收购材料文件保存
     */
    Long savaMaterials(MaterialParamDto paramDto);

    /**
     * 收购材料信息保存
     * @param materialUploadDto
     * @return
     */
    Boolean saveAcquisitionMaterial(AcquisitionMaterialUploadDto materialUploadDto);

    /**
     * 获取objKey
     * @param fileId
     * @param materialId 
     * @return
     */
    String getObjKey(String fileId, String materialId);

    /**
     * 更改询价表审批状态
     */
    Boolean updateInquiryApprovalStatus(Long reservationId,String approvalStatus);

    /**
     * 手机号加密
     * @param phone
     * @return
     */
    String decryptionPhone(String phone);

    /**
     * 更新数据库表手机号、身份证等 数据
     * @return
     */
    void updateData();

	boolean allotDeliveryCenter(AllotDeliveryCenterDto paramDto);

}
