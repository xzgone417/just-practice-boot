package com.exp.ucmp.car.service;


import com.exp.ucmp.car.dto.CarMainInfoDto;

public interface BasicsCarInfoService {

	CarMainInfoDto getCarMainInfo(Long stockId, String carVin) throws Exception;


}
