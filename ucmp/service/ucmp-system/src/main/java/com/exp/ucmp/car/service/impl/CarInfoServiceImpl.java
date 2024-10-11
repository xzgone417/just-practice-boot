package com.exp.ucmp.car.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.iautos.consumer.IautosConsumer;
import com.exp.ucmp.apig.iautos.consumer.IautosProperties;
import com.exp.ucmp.car.service.CarInfoService;
import com.exp.ucmp.dao.ISysRegionDao;
import com.exp.ucmp.entity.SysRegionEntity;
import com.exp.ucmp.iautos.dto.AssessForReplaceDto;
import com.exp.ucmp.iautos.dto.AssessReturnDto;
import com.exp.ucmp.iautos.dto.CarBrandDto;
import com.exp.ucmp.iautos.dto.CarDetailDto;
import com.exp.ucmp.iautos.dto.CarModelDto;
import com.exp.ucmp.iautos.dto.CarSeriesDto;

@Service
public class CarInfoServiceImpl implements CarInfoService{
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CarInfoServiceImpl.class);
	
	@Autowired
	private IautosConsumer iautosConsumer;
	
	@Autowired
	private IautosProperties iautosProperties;
	
	@Autowired
    private ISysRegionDao iSysRegionDao;

	@Override
	public List<CarBrandDto> getPassengerBrand() throws Exception {
		String result=this.iautosConsumer.getPassengerBrand();
		List<CarBrandDto> brandList=new ArrayList<>();
		if(StringUtil.isNotEmpty(result)){
			List<Map<String,String>> resultList=JsonBeanUtil.jsonToBean(result, List.class);
			for (Map<String, String> map : resultList) {
				CarBrandDto dto=new CarBrandDto();
				dto.setId(map.get("ID"));
				dto.setInitial(map.get("Initial"));
				dto.setName(map.get("Name"));
				brandList.add(dto);
			}
		}
		Collections.sort(brandList);
		return brandList;
	}
	
	@Override
	public List<CarSeriesDto> getPassengerSeries(String brandId) throws Exception {
		if(StringUtil.isEmpty(brandId)){
			brandId=iautosProperties.getHiphiBrandId();
		}
		String result=this.iautosConsumer.getPassengerSeries(brandId);
		List<CarSeriesDto> seriesList=new ArrayList<>();
		if(StringUtil.isNotEmpty(result)){
			List<Map<String,Object>> resultList=JsonBeanUtil.jsonToBean(result, List.class);
			for (Map<String, Object> map : resultList) {
				if(map.get("CarSeries") !=null){
					List<Map<String,String>> series=(List<Map<String, String>>) map.get("CarSeries");
					for (Map<String, String> map2 : series) {
						CarSeriesDto dto=new CarSeriesDto();
						dto.setId(map2.get("ID"));
						dto.setName(map2.get("Name"));
						seriesList.add(dto);
					}
				}
			}
		}
		Collections.sort(seriesList);
		return seriesList;
	}

	@Override
	public List<String> getPassengerYear(String seriesId) throws Exception {
		String result=this.iautosConsumer.getPassengerYear(seriesId);
		List<String> yearList;
		if(StringUtil.isNotEmpty(result)){
			yearList=JsonBeanUtil.jsonToBean(result, List.class);
		}else{
			yearList=new ArrayList<>();
		}
		Collections.sort(yearList);
		return yearList;
	}

	@Override
	public List<CarModelDto> getPassengerModel(String seriesId, String purchaseYear) throws Exception {
		String result=this.iautosConsumer.getPassengerModel(seriesId, purchaseYear);
		List<CarModelDto> modelList=new ArrayList<>();
		if(StringUtil.isNotEmpty(result)){
			List<Map<String,String>> modelMap=JsonBeanUtil.jsonToBean(result, List.class);
			for (Map<String, String> map : modelMap) {
				CarModelDto dto=new CarModelDto();
				dto.setId(map.get("ID"));
				dto.setName(map.get("Name"));
				dto.setDisplacement(map.get("Displacement"));
				dto.setPrice(map.get("Price"));
				dto.setTransmissionType(map.get("TransmissionType"));
				dto.setVersionYear(map.get("VersionYear"));
				dto.setVersionDate(map.get("VersionDate"));
				dto.setProductionYear(map.get("ProductionYear"));
				modelList.add(dto);
			}
		}
		Collections.sort(modelList);
		return modelList;
	}

	@Override
	public CarDetailDto getMixWithDetail(String modelid) throws Exception {
		String result= this.iautosConsumer.getMixWithDetail(modelid);
		CarDetailDto dto=new CarDetailDto();
		if(StringUtil.isNotEmpty(result)){
			Map<String,Object> carMap=JsonBeanUtil.jsonToBean(result, HashMap.class);
			Map<String,String> brandMap = JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(carMap.get("Brand")), HashMap.class);
			CarBrandDto brand=new CarBrandDto();
			brand.setId(brandMap.get("ID"));
			brand.setInitial(brandMap.get("Initial"));
			brand.setName(brandMap.get("Name"));
			dto.setBrand(brand);
			Map<String,String> seriesMap = JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(carMap.get("CarSeries")), HashMap.class);
			CarSeriesDto series=new CarSeriesDto();
			series.setId(seriesMap.get("ID"));
			series.setName(seriesMap.get("Name"));
			dto.setCarSeries(series);
			Map<String,String> modelMap = JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(carMap.get("Model")), HashMap.class);
			CarModelDto model=new CarModelDto();
			model.setId(modelMap.get("ID"));
			model.setName(modelMap.get("Name"));
			model.setDisplacement(modelMap.get("Displacement"));
			model.setPrice(modelMap.get("Price"));
			model.setTransmissionType(modelMap.get("TransmissionType"));
			model.setVersionYear(modelMap.get("VersionYear"));
			model.setVersionDate(modelMap.get("VersionDate"));
			model.setProductionYear(modelMap.get("ProductionYear"));
			dto.setModel(model);
			Map<String,String> carMfrsMap = JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(carMap.get("CarMfrs")), HashMap.class);
			dto.setCarMfrs(carMfrsMap);
		}
		return dto;
	}

	@Override
	public AssessForReplaceDto assessrecordInfo(String id) throws Exception {
		String result= this.iautosConsumer.assessrecordInfo(id);
		if(StringUtil.isNotEmpty(result)){
			AssessReturnDto returnDto=JsonBeanUtil.jsonToBean(result, AssessReturnDto.class);
			if(100000==returnDto.getCode()){
				AssessForReplaceDto dto =new AssessForReplaceDto();
				CarDetailDto carDetailDto=this.getMixWithDetail(returnDto.getData().getModelId().toString());
				dto.setBrandId(carDetailDto.getBrand().getId());
				dto.setBrandName(carDetailDto.getBrand().getName());
				dto.setSeriesId(carDetailDto.getCarSeries().getId());
				dto.setSeriesName(carDetailDto.getCarSeries().getName());
				dto.setYear(carDetailDto.getModel().getVersionYear());
				dto.setModelId(carDetailDto.getModel().getId());
				dto.setModelName(carDetailDto.getModel().getName());
				//查询城市上级省份code
				SysRegionEntity entity=new SysRegionEntity();
				entity.setRegionLevel(3);
				if(StringUtil.isNotEmpty(returnDto.getData().getAdcode())){
					entity.setRegionCode(Long.parseLong(returnDto.getData().getAdcode()));
					SysRegionEntity cities = this.iSysRegionDao.selectBySelective(entity).get(0);
					if(cities !=null){
						dto.setCityId(Long.toString(cities.getRegionCode()));
						dto.setCityName(cities.getRegionName());
						//查询省份信息
						entity.setRegionLevel(2);
						entity.setRegionCode(cities.getParentCode());
						SysRegionEntity provinces = this.iSysRegionDao.selectBySelective(entity).get(0);
						dto.setProvinceId(Long.toString(provinces.getRegionCode()));
						dto.setProvinceName(provinces.getRegionName());
					}
				}
				dto.setGuidePrice(returnDto.getData().getGuidePrice());
				dto.setKm(returnDto.getData().getKm());
				return dto;
			}
		}
		return null;
	}

	@Override
	public List<SysRegionEntity> queryRegionList() {
		SysRegionEntity entity = new SysRegionEntity();
		entity.setRegionLevel(3);
		List<SysRegionEntity> sysRegionEntities = iSysRegionDao.selectBySelective(entity);
		return sysRegionEntities;
	}

	public static void main(String[] args) {
		String result="{\"data\":{\"id\":11,\"modelId\":335403,\"modelName\":\"爱驰U5标准续航PURE智净版前驱纯电动\",\"guidePrice\":17.99,\"firstRegDate\":\"2021-12\",\"km\":96000.00,\"adcode\":\"120100\",\"city\":\"天津市\",\"phone\":\"\",\"resBuyPriceLow\":7.56,\"resBuyPriceHigh\":8.61,\"source\":\"C0051\",\"createTime\":\"2022-07-29 10:58:39\"},\"code\":100000,\"message\":\"success\",\"datetime\":\"2022-11-01 11:38:56\"}";
		AssessReturnDto returnDto=JsonBeanUtil.jsonToBean(result, AssessReturnDto.class);
		LOGGER.info("====returnDto=="+JsonBeanUtil.beanToJson(returnDto.getData()));
	}

	/*@Override
	public List<CarModelDto> hiphiModelList() throws Exception {
		List<CarSeriesDto> seriesLsit = this.getPassengerSeries(iautosProperties.getHiphiBrandId());
		for (CarSeriesDto carSeriesDto : seriesLsit) {
			
		}
		return null;
	}*/
}
