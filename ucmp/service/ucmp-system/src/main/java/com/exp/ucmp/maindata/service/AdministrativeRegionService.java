package com.exp.ucmp.maindata.service;

import java.util.List;

import com.exp.ucmp.maindata.dto.ProvinceDto;

public interface AdministrativeRegionService {
	List<ProvinceDto> getRegisteredCity();

    List<ProvinceDto> getRegisteredCityDistrict();
}
