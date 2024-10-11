package com.exp.ucmp.evaluate.service;

import com.exp.ucmp.usc.dto.CreateEvaluationDto;
import com.exp.ucmp.usc.dto.EvaluationDetailDto;

public interface UscEvaluateService {

	String createEvaluation(CreateEvaluationDto createEvaluationDto) throws Exception;

	EvaluationDetailDto getEvaluationDetail(String businessNo) throws Exception;


}
