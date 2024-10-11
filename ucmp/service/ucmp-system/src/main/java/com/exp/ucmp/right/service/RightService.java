package com.exp.ucmp.right.service;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.exp.ucmp.urc.dto.RightPackSaveDto;
import com.exp.ucmp.urc.dto.RightsGrantDto;

public interface RightService {

	List<Map<String, Object>> rightQueryByCondition(String rightTypeName, String grantType, String modelCode, String shapeCode) throws Exception;

	Long rightPackSave(@Valid RightPackSaveDto rightPackSaveDto) throws Exception;

	Long rightsGrant(@Valid RightsGrantDto rightsGrantDto) throws Exception;

}
