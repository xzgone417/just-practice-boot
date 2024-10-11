package com.exp.ucmp.sample.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.PageDto;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.sample.consumer.SampleConsumer;
import com.exp.ucmp.sample.dto.SampleParameterDto;
import com.exp.ucmp.sample.service.SampleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 样例
 *
 */
@Service
public class SampleServiceImpl implements SampleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceImpl.class);

	@Autowired
	private SampleConsumer sampleConsumer;
	
	@Override
	public PageInfo<SampleParameterDto> findParameterDto(PageDto pageDto) {
		PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
		List<SampleParameterDto> list = new ArrayList<>();
		list.add(SampleParameterDto.getInstance("王五", "John", "50"));
		list.add(SampleParameterDto.getInstance("李四", "Anthony", "36"));
		list.add(SampleParameterDto.getInstance("张三", "Bill", "21"));
		list.add(SampleParameterDto.getInstance("武二", "James", "58"));
		return new PageInfo<SampleParameterDto>(list);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void saveParameterDto(SampleParameterDto parameterDto) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		LOGGER.debug("当前登录用户的Token {}, 对应的用户ID {}", user.getToken(), user.getPartyId());
	}

	@Override
	public List<SampleParameterDto> findParameterDtoByConsumer() {
		PageDto pageDto = new PageDto();
		pageDto.setPageNum(1);
		pageDto.setPageSize(10);
		RestResponse<PageInfo<SampleParameterDto>> response = sampleConsumer.find(pageDto);
		return response.getResult().getList();
	}
}
