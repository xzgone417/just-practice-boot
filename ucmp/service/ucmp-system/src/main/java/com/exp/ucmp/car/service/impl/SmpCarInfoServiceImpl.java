package com.exp.ucmp.car.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.smp.consumer.SmpConsumer;
import com.exp.ucmp.car.service.SmpCarInfoService;
import com.exp.ucmp.smp.dto.CarModelDto;
import com.exp.ucmp.smp.dto.CarSeriesDto;
import com.exp.ucmp.smp.dto.SmpReturnDto;
import com.exp.ucmp.smp.dto.VehicleproductDto;

@Service
public class SmpCarInfoServiceImpl implements SmpCarInfoService{
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SmpCarInfoServiceImpl.class);
	
	@Autowired
	private SmpConsumer smpConsumer;

	@Override
	public List<CarSeriesDto> getCarseries(String channel, String carSeriesCode, Boolean allVcc, String saleConfId) throws Exception {
		String result = smpConsumer.getCarseries(channel, carSeriesCode, allVcc, saleConfId);
		if(StringUtil.isNotEmpty(result)){
			SmpReturnDto<List<CarSeriesDto>> returnDto=JsonBeanUtil.jsonToBean(result, SmpReturnDto.class);
			if("000000".equals(returnDto.getCode())){
				return returnDto.getData();
			}else{
				throw new Exception(returnDto.getMsg());
			}
		}else{
			throw new Exception("查询SMP车型产品-工程车型异常");
		}
	}

	@Override
	public List<CarModelDto> getCartype(String channel, String carSeriesCode, Boolean allVcc, String saleConfId) throws Exception {
		String result = smpConsumer.getCartype(channel, carSeriesCode, allVcc, saleConfId);
		if(StringUtil.isNotEmpty(result)){
			SmpReturnDto<List<CarModelDto>> returnDto=JsonBeanUtil.jsonToBean(result, SmpReturnDto.class);
			if("000000".equals(returnDto.getCode())){
				return returnDto.getData();
			}else{
				throw new Exception(returnDto.getMsg());
			}
		}else{
			throw new Exception("查询SMP车型产品-工程车型异常");
		}
	}

	@Override
	public List<VehicleproductDto> getVehicleproduct(String channel, String saleConfId) throws Exception {
		String result = smpConsumer.getVehicleproduct(channel, saleConfId);
		if(StringUtil.isNotEmpty(result)){
			SmpReturnDto<List<VehicleproductDto>> returnDto=JsonBeanUtil.jsonToBean(result, SmpReturnDto.class);
			if("000000".equals(returnDto.getCode())){
				return returnDto.getData();
			}else{
				throw new Exception(returnDto.getMsg());
			}
		}else{
			throw new Exception("查询SMP车型产品-工程车型异常");
		}
	}
	
	public static void main(String[] args) {
		String result="{\"code\":\"000000\",\"msg\":\"SUCCESS\",\"data\":[{\"carSeriesCode\":\"VX1\",\"carSeriesCn\":\"VX1车\",\"carSeriesEn\":null,\"veTypeList\":[{\"carTypeId\":\"1545223479164952579\",\"carTypeCode\":\"VX1XXXXX_01\",\"carTypeCn\":\"VX1-标准版\",\"carTypeEn\":null,\"price\":\"570000.00\",\"showPrice\":\"570000.00\",\"veFaimlyList\":[{\"faimlyId\":\"1547865930025467905\",\"faimlyName\":\"车身颜色\",\"faimlyNameEn\":null,\"optionType\":1,\"featureId\":\"1547866409824485378\",\"featureName\":\"车身颜色：DARK GREY METALLIC\",\"featureNameEn\":null,\"relationShip\":\"O\",\"price\":0.00,\"showPrice\":0.00,\"faimlyCode\":\"BAC\",\"featureCode\":\"BACD\"},{\"faimlyId\":\"1547865930096771075\",\"faimlyName\":\"选装包\",\"faimlyNameEn\":null,\"optionType\":2,\"featureId\":\"1547866348457623553\",\"featureName\":\"沉浸套装_01\",\"featureNameEn\":null,\"relationShip\":\"S\",\"price\":0.00,\"showPrice\":0.00,\"faimlyCode\":\"PKG\",\"featureCode\":\"PKG201\"},{\"faimlyId\":\"1547865930025467905\",\"faimlyName\":\"车身颜色\",\"faimlyNameEn\":null,\"optionType\":1,\"featureId\":\"1547866409862234113\",\"featureName\":\"车身颜色：MATT GREY METALLIC\",\"featureNameEn\":null,\"relationShip\":\"-\",\"price\":null,\"showPrice\":null,\"faimlyCode\":\"BAC\",\"featureCode\":\"BACC\"}]}]}]}";
		SmpReturnDto<List<VehicleproductDto>> returnDto=JsonBeanUtil.jsonToBean(result, SmpReturnDto.class);
		LOGGER.info("==returnDto=="+JsonBeanUtil.beanToJson(returnDto.getData()));
	}

}
