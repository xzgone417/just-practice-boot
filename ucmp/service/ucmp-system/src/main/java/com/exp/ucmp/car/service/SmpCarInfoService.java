package com.exp.ucmp.car.service;

import java.util.List;

import com.exp.ucmp.smp.dto.CarModelDto;
import com.exp.ucmp.smp.dto.CarSeriesDto;
import com.exp.ucmp.smp.dto.VehicleproductDto;

public interface SmpCarInfoService {

	List<CarSeriesDto> getCarseries(String channel, String carSeriesCode, Boolean allVcc, String saleConfId) throws Exception;

	List<CarModelDto> getCartype(String channel, String carSeriesCode, Boolean allVcc, String saleConfId) throws Exception;

	List<VehicleproductDto> getVehicleproduct(String channel, String saleConfId) throws Exception;


}
