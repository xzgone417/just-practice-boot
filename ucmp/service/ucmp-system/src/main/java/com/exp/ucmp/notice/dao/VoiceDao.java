package com.exp.ucmp.notice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.exp.ucmp.huawei.dto.VoiceCallDto;

public interface VoiceDao {

	String selectCityByDepartmentId(@Param("departmentId") String departmentId);

	List<String> selectCityByPartyId(@Param("partnerStaffPartyId")Long partnerStaffPartyId);

	String getCalledPhone(VoiceCallDto voiceCallDto);

	void addCallOutInfo(VoiceCallDto statusInfo);

	String getStoreCalledPhone(Long reservationId);

	Integer countRecord(String userData);

}
