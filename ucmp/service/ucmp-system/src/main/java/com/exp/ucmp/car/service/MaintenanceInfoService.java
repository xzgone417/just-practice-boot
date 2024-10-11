package com.exp.ucmp.car.service;

import java.util.List;

import com.exp.ucmp.car.dto.MaintenanceInfoDto;

public interface MaintenanceInfoService {

	List<MaintenanceInfoDto> maintenanceInfo(String carVin);


}
