package com.exp.ucmp.carDealer.service;

import com.exp.ucmp.PageDto;
import com.exp.ucmp.carDealer.dto.*;
import com.github.pagehelper.PageInfo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/**
 * 询价单，和报价有关的操作
 * @author Administrator
 *
 */

public interface InquiryQuotingService {

    /**
     * 查询当前车商人员已报价的询价单
     * @return 已经报价的询价单列表
     */
    PageInfo<InquiryQuotingResultDto> queryInquiryQuotingByAccept(PageDto pageDto);

    /**
     * 查询当前车商人员放弃报价的询价单
     * @return 放弃的询价单列表
     */
    PageInfo<InquiryQuotingResultDto> queryInquiryQuotingByGiveup(PageDto pageDto);

    /**
     * 查询当前车商人员待报价的询价单
     * @return 待报价询价单列表
     */
    PageInfo<InquiryQuotingResultDto> queryInquiryQuotingByAwait(PageDto pageDto);

    /**
     * 查询当前车商人员待报价和已接单的询价单
     * @return 待报价询价单列表
     */
    PageInfo<InquiryQuotingResultDto> queryInquiryQuotingAccept(QuotingQueryParamDto paramDto);

    /**
     * 查询当前车商人员已报价的询价单
     * @return 待报价询价单列表
     */
    PageInfo<InquiryQuotingResultDto> queryInquiryQuotingAwait(QuotingQueryParamDto paramDto);

    /**
     * 查询当前车商人员客户拒绝的询价单
     * @return 待报价询价单列表
     */
    PageInfo<InquiryQuotingResultDto> queryInquiryQuotingByRefusal(QuotingQueryParamDto paramDto);

    /**
     * 查询当前车商人员所有的询价单
     * @return 待报价询价单列表
     */
    PageInfo<InquiryQuotingResultDto> queryInquiryQuotingByAll(QuotingQueryParamDto paramDto);

    /**
     * 放弃接单
     * 跟踪ID用于判断该跟踪单下所有询价单是否都已经接单
     * @throws Exception 
     */
    Boolean giveupInquiryQuoting(InquiryQuotingDto paramDto) throws Exception;

    /**
     * 查询当前车商人员已接单的询价单
     * @return 已经接单的询价单列表
     * @throws Exception 
     */
    void acceptInquiryQuoting(InquiryQuotingAcceptDto paramDto) throws Exception;

    /**
     * 报价截止
     * @throws Exception 
     */
    JobHandlerResult quotingDeadline() throws Exception;

    /**
     * 查询报价详情图片
     * @param paramDto
     * @return
     */
    List<AcquisitionAllFileDto> quotingPics(AcquisitionDetailQueryDto paramDto);

}
