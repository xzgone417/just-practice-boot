package com.exp.ucmp.sample.tools.core;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.baidu.unbiz.easymapper.transformer.Transformer;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.copiers.Copiers.FieldMapper;
import com.egrid.core.copiers.adapter.Copier;
import com.egrid.core.copiers.mapper.MapperCopier;
import com.egrid.core.copiers.mapper.MapperFactory;
import com.exp.ucmp.sample.dto.SamplePageCopyDto;
import com.exp.ucmp.sample.dto.SamplePageDto;
import com.exp.ucmp.sample.dto.SamplePagingCopyDto;
import com.exp.ucmp.sample.dto.SamplePagingDto;
import com.exp.ucmp.sample.dto.SampleParameterCopyDto;
import com.exp.ucmp.sample.dto.SampleParameterDto;

public class CopiersSample {

	private static final Logger LOGGER = LoggerFactory.getLogger(CopiersSample.class);
	
	/**
	 * 简单的对象映射，二个类字段名、类型相同即复制
	 */
	public void copySimple() {
		SampleParameterDto source = SampleParameterDto.getInstance("参数一", "Param1", "1");
		LOGGER.info("源对象{}", source);
		SampleParameterDto target = Copiers.beanToBean(source, SampleParameterDto.class, SampleParameterDto.class);
		LOGGER.info("复制后的对象结果{}", target);
	}
	
	/**
	 * 简单的对象映射，二个类字段名、类型相同即复制
	 * 针对集合
	 */
	public void copySimples() {
		List<SampleParameterDto> source = new ArrayList<>();
		source.add(SampleParameterDto.getInstance("参数一", "Param1", "1"));
		source.add(SampleParameterDto.getInstance("参数二", "Param2", "2"));
		source.add(SampleParameterDto.getInstance("参数三", "Param3", "3"));
		LOGGER.info("源对象{}", source);
		List<SampleParameterDto> target = Copiers.beansToBeans(source, SampleParameterDto.class, SampleParameterDto.class);
		LOGGER.info("复制后的对象结果{}", target);
	}
	
	/**
	 * 简单对象复制
	 */
	public void copySimpleByMap() {
		SampleParameterDto source = SampleParameterDto.getInstance("参数一", "Param1", "1");
		LOGGER.info("源对象{}", source);
		SampleParameterCopyDto target = Copiers.beanToBean(source, SampleParameterDto.class, SampleParameterCopyDto.class);
		LOGGER.info("复制后的对象结果{}", target);
		
		List<FieldMapper<Object, Object>> list = new ArrayList<>();
		list.add(new Copiers.FieldMapper<>("createdBy", "createBy"));
		list.add(new Copiers.FieldMapper<>("createdDate", "createDate"));
		target = Copiers.beanMapBean(source, SampleParameterDto.class, SampleParameterCopyDto.class, list);
		LOGGER.info("复制并映射后的对象结果{}", target);
		
		MapperCopier<SampleParameterDto, SampleParameterCopyDto> copier = Copiers.createMapper(SampleParameterDto.class, SampleParameterCopyDto.class);
		copier.field("createdBy", "createBy").field("createdDate", "createDate");
		target = copier.register().copy(source);
		LOGGER.info("复制并映射后的对象结果{}", target);
	}
	
	public void copyOneToOneByMap() {
		SamplePageDto source = SamplePageDto.getInstance();
		LOGGER.info("源对象{}", source);
		SamplePageCopyDto target = Copiers.beanToBean(source, SamplePageDto.class, SamplePageCopyDto.class);
		LOGGER.info("嵌套对象复制(一对一): \n" + target);
		
		/* 先注册属性对应类 */
		MapperFactory.getCopyByRefMapper().mapClass(SampleParameterDto.class, SampleParameterCopyDto.class)
				.field("createdBy", "createBy").field("createdDate", "createDate").register();
		List<FieldMapper<Object, Object>> list = new ArrayList<>();
		list.add(new Copiers.FieldMapper<>("dto", "dto"));
		
		target = Copiers.beanMapBean(source, SamplePageDto.class, SamplePageCopyDto.class, list);
		LOGGER.info("嵌套对象复制(一对一): \n" + target);
	}
	
	public void copyOneToManyByMap() {
		SamplePagingDto source = SamplePagingDto.getInstance();
		LOGGER.info("源对象{}", source);
		SamplePagingCopyDto target = Copiers.beanToBean(source, SamplePagingDto.class, SamplePagingCopyDto.class);
		LOGGER.info("嵌套对象复制(一对多): \n" + target);
		
		List<FieldMapper<List<SampleParameterDto>, List<SampleParameterCopyDto>>> list = new ArrayList<>();
		list.add(new Copiers.FieldMapper<>("listParams", "listDto", new Transformer<List<SampleParameterDto>, List<SampleParameterCopyDto>>() {
			@Override
			public List<SampleParameterCopyDto> transform(List<SampleParameterDto> sources) {
				List<SampleParameterCopyDto> list = new ArrayList<>();
				if (sources != null && sources.size() > 0) {
					Copier<SampleParameterDto, SampleParameterCopyDto> copier = Copiers
							.createMapper(SampleParameterDto.class, SampleParameterCopyDto.class).field("createdBy", "createBy")
							.field("createdDate", "createDate").register();
					for (SampleParameterDto source : sources) {
						list.add(copier.copy(source));
					}
				}
				return list;
			}
		}));
		SamplePagingCopyDto dto = Copiers.beanMapBean(source, SamplePagingDto.class, SamplePagingCopyDto.class, list);
		LOGGER.info("嵌套对象复制(一对多): \n" + dto);
	}
	
	public static void main(String[] args) {
		CopiersSample sample = new CopiersSample();
		sample.copyOneToManyByMap();
	}
}
