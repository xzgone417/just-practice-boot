package com.exp.ucmp.carDealer.service;

import com.exp.ucmp.carDealer.dto.AcquisitionRecordDto;
import com.exp.ucmp.carDealer.dto.AppraisalRecordDto;
import com.exp.ucmp.carDealer.dto.AppraisalRecordParamDto;
import com.github.pagehelper.PageInfo;

public interface AppraisalRecordService {

	PageInfo<AppraisalRecordDto> queryAppraisalRecord(AppraisalRecordParamDto paramDto) throws Exception;

	PageInfo<AcquisitionRecordDto> queryAcquisitionRecord(AppraisalRecordParamDto paramDto) throws Exception;

}
