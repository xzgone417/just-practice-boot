package com.exp.ucmp.car.dao;


import org.apache.ibatis.annotations.Param;

import com.exp.ucmp.car.dto.CarMainInfoDto;

public interface ICarInfoDao {

	CarMainInfoDto getCarInfoByVin(@Param("stockId") Long stockId,@Param("carVin") String carVin);

	void updateCarInfo(CarMainInfoDto updateCurDto);
    
}
