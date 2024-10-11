package com.exp.ucmp.sample.service;

import java.util.List;

import com.exp.ucmp.PageDto;
import com.exp.ucmp.sample.dto.SampleParameterDto;
import com.github.pagehelper.PageInfo;

/**
 * 样例
 * 
 */
public interface SampleService {

	PageInfo<SampleParameterDto> findParameterDto(PageDto pageDto);
	
	void saveParameterDto(SampleParameterDto parameterDto);
	
	List<SampleParameterDto> findParameterDtoByConsumer();
}
