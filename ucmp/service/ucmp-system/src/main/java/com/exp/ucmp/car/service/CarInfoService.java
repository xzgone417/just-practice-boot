package com.exp.ucmp.car.service;

import java.util.List;

import com.exp.ucmp.entity.SysRegionEntity;
import com.exp.ucmp.iautos.dto.AssessForReplaceDto;
import com.exp.ucmp.iautos.dto.CarBrandDto;
import com.exp.ucmp.iautos.dto.CarDetailDto;
import com.exp.ucmp.iautos.dto.CarModelDto;
import com.exp.ucmp.iautos.dto.CarSeriesDto;

public interface CarInfoService {

	List<CarBrandDto> getPassengerBrand() throws Exception;

	List<CarSeriesDto> getPassengerSeries(String brandId) throws Exception;

	List<String> getPassengerYear(String seriesId) throws Exception;

	List<CarModelDto> getPassengerModel(String seriesId, String purchaseYear) throws Exception;

	CarDetailDto getMixWithDetail(String modelid) throws Exception;

	AssessForReplaceDto assessrecordInfo(String id) throws Exception;

	List<SysRegionEntity> queryRegionList();

	/*List<CarModelDto> hiphiModelList() throws Exception;*/
}
