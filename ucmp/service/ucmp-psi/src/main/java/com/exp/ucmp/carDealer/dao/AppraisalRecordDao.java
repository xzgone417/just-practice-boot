package com.exp.ucmp.carDealer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exp.ucmp.carDealer.dto.AcquisitionMaterialDto;
import com.exp.ucmp.carDealer.dto.AcquisitionRecordDto;
import com.exp.ucmp.carDealer.dto.AppraisalRecordDto;

public interface AppraisalRecordDao {

	List<AppraisalRecordDto> queryAppraisalRecord(@Param("partyId")Long partyId);

	List<AcquisitionRecordDto> queryAcquisitionRecord(@Param("partyId") Long partyId);

	List<AcquisitionMaterialDto> queryAcquisitionMaterial(@Param("reservationId")Long reservationId);

}
