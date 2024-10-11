package com.exp.ucmp.maindata.service.impl;


import com.exp.ucmp.dao.ISysRegionDao;
import com.exp.ucmp.entity.SysRegionEntity;
import com.exp.ucmp.maindata.dto.CitiesDto;
import com.exp.ucmp.maindata.dto.DistrictDto;
import com.exp.ucmp.maindata.dto.ProvinceDto;
import com.exp.ucmp.maindata.service.AdministrativeRegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class AdministrativeRegionServiceImpl implements AdministrativeRegionService {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AdministrativeRegionServiceImpl.class);

    @Autowired
    private ISysRegionDao iSysRegionDao;

	@Override
	public List<ProvinceDto> getRegisteredCity() {
		List<ProvinceDto> provinceList=new ArrayList<>();
		SysRegionEntity entity=new SysRegionEntity();
		entity.setRegionLevel(2);
		//查询省份列表
		List<SysRegionEntity> list = this.iSysRegionDao.selectBySelective(entity);
		for (SysRegionEntity sysRegionEntity : list) {
			ProvinceDto dto= new ProvinceDto();
			dto.setProvinceId(Long.toString(sysRegionEntity.getRegionCode()));
			dto.setProvinceName(sysRegionEntity.getRegionName());
			//查询城市列表
			entity.setParentCode(sysRegionEntity.getRegionCode());
			entity.setRegionLevel(3);
			List<SysRegionEntity> citieslist = this.iSysRegionDao.selectBySelective(entity);
			List<CitiesDto> cityList = new ArrayList<>();
			for (SysRegionEntity city : citieslist) {
				CitiesDto cityDto=new CitiesDto();
				cityDto.setCityId(Long.toString(city.getRegionCode()));
				cityDto.setCityName(city.getRegionName());
				cityList.add(cityDto);
			}
			dto.setCities(cityList);
			if(!cityList.isEmpty()){
				provinceList.add(dto);
			}
		}
		return provinceList;
	}

	@Override
	public List<ProvinceDto> getRegisteredCityDistrict() {
		//查询省份列表
		SysRegionEntity entity=new SysRegionEntity();
		entity.setRegionLevel(2);
		List<SysRegionEntity> provinceEntitys = this.iSysRegionDao.selectBySelective(entity);

		//查询城市列表
		SysRegionEntity cityEntity=new SysRegionEntity();
		cityEntity.setRegionLevel(3);
		List<SysRegionEntity> citiesEntitys = this.iSysRegionDao.selectBySelective(cityEntity);

		//查询区县列表
		SysRegionEntity districtEntity=new SysRegionEntity();
		districtEntity.setRegionLevel(4);
		List<SysRegionEntity> districtEntitys = this.iSysRegionDao.selectBySelective(districtEntity);
		ProvinceDto dto;
		CitiesDto cityDto;
		DistrictDto districtDto;
		List<CitiesDto> cityList;
		List<DistrictDto> districtList;

		List<ProvinceDto> provinceList=new ArrayList<>();
		for (SysRegionEntity sysRegionEntity : provinceEntitys) {
			dto= new ProvinceDto();
			dto.setProvinceId(Long.toString(sysRegionEntity.getRegionCode()));
			dto.setProvinceName(sysRegionEntity.getRegionName());
			cityList = new ArrayList<>();
			for (SysRegionEntity citieItem : citiesEntitys) {
				if(citieItem.getParentCode().equals(sysRegionEntity.getRegionCode())){
					districtList = new ArrayList<>();
					for (SysRegionEntity districtItem : districtEntitys) {
						if(districtItem.getParentCode().equals(citieItem.getRegionCode())){
							districtDto = new DistrictDto();
							districtDto.setDistrictId(Long.toString(districtItem.getRegionCode()));
							districtDto.setDistrictName(districtItem.getRegionName());
							districtList.add(districtDto);
						}
					}
					cityDto=new CitiesDto();
					cityDto.setCityId(Long.toString(citieItem.getRegionCode()));
					cityDto.setCityName(citieItem.getRegionName());
					cityDto.setDistricts(districtList);
					cityList.add(cityDto);
				}
			}
			dto.setCities(cityList);
			if(!cityList.isEmpty()){
				provinceList.add(dto);
			}
		}
		return provinceList;
	}


}
