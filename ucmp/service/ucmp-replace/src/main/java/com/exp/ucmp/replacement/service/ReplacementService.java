package com.exp.ucmp.replacement.service;

import com.exp.ucmp.carDealer.dto.AcquisitionAllFileDto;
import com.exp.ucmp.carDealer.dto.SaveTransactionPriceDto;
import com.exp.ucmp.carService.dto.OneselfApproveDto;
import com.exp.ucmp.carService.dto.OneselfPutIntoStorageDto;
import com.exp.ucmp.replacement.dto.*;
import com.exp.ucmp.storeApp.dto.OneselfAssessPicsDto;
import com.github.pagehelper.PageInfo;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;


/**
 * @author zhouchengwei
 * @date 2022年10月16日
 */
public interface ReplacementService {

    /**
     * Description: 根据条件查询集合实体(置换审批信息)
     * @param repReplacementApprovalDto 查询条件
     * @return 实体集合
     */
    public PageInfo<RepReplacementApprovalReturnDto> queryReplaceApproval(RepReplacementApprovalDto repReplacementApprovalDto);



    /**
     * Description: 旧车确认列表
     * @return 实体集合
     */

    public PageInfo<RepReplacementApprovalReturnDto> queryOldConfirm(RepReplacementApprovalDto repReplacementApprovalDto);



    /**
     * Description: 新车信息查询
     * @param newCarQueryDto 查询条件
     * @return 实体集合
     */

    public List<PsiNewCarOrderDto> queryNewCar(NewCarQueryDto newCarQueryDto);;


    /**
     * Description: 旧车信息查询
     * @param psiCustomerCarsQueryDto 查询条件
     * @return 实体集合
     */

    public List<PsiCustomerCarsDto> queryOldCar(PsiCustomerCarsQueryDto psiCustomerCarsQueryDto);


    /**
     * Description: 材料分类查询
     * @param repReplacementMaterialQueryDto 查询条件
     * @return 实体集合
     */

    public List<RepReplacementMaterialDto> materialSort(RepReplacementMaterialQueryDto repReplacementMaterialQueryDto);


    /**
     * Description: 文件列表
     * @param sysFileMsgQueryDto 查询条件
     * @return 实体集合
     */

    public List<SysFileMsgDto> queryFileList(SysFileMsgQueryDto sysFileMsgQueryDto);



    /**
     * Description: 审批
     * @param approvalUpdateDto 查询条件
     * @return 审批
     * @throws Exception 
     */

    public void approval(ApprovalUpdateDto approvalUpdateDto) throws Exception;


    /**
     * Description: 审批历史
     * @param approvalHistoryDto 查询条件
     * @return 审批
     */

    public List<RepReplacementApprovalRecordDto> queryApprovalHistory(ApprovalHistoryDto approvalHistoryDto);

    /**
     * 置换单查询
     * @param paramsDto
     * @return
     */
    public PageInfo<ReplacementOrderQueryDto> selectReplacementOrder(ReplacementOrderQueryParamsDto paramsDto);

    /**
     * 导出置换单查询
     * @param paramsDto
     * @return
     */
    void replacementOrderExport(ReplacementOrderQueryParamsDto paramsDto, HttpServletResponse response) throws IOException, ParseException;/**

     * 导出置换审批
     * @param paramsDto
     * @return
     */
    void replacementApprovalExport(RepReplacementApprovalDto paramsDto, HttpServletResponse response) throws IOException, ParseException;
    
    public ReplaceDetailsDto getReplaceDetails(Long reservationId);

    public List<AcquisitionAllFileDto> getReplaceDetailsPic(Long reservationId);

    /**
     * 置换单激活
     */
    boolean activate(Long reservationId);

	public OneselfAssessPicsDto getHipiReplaceDetailsPic(Long reservationId);

	public void saveTransactionPrice(SaveTransactionPriceDto dto);

	public void oneselfApproval(OneselfApproveDto dto);

	public void putIntoStorage(OneselfPutIntoStorageDto dto);

	public void grantRights(Long reservationId, String businessClassify, Integer isGrant) throws Exception;

	public ReplaceDetailsNewDto getReplaceDetailsNew(Long reservationId) throws Exception;
	
	public void replacementOrderExportNew(ReplacementOrderQueryParamsDto paramsDto, HttpServletResponse response) throws IOException, Exception;

	public void logicDeleteReplace(Long reservationId);

}
