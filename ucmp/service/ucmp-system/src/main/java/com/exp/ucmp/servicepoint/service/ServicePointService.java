package com.exp.ucmp.servicepoint.service;

import java.util.List;

import com.exp.ucmp.isp.dto.ServicePointDto;
import com.exp.ucmp.isp.dto.ServicePointTypeDto;

public interface ServicePointService {

	List<ServicePointTypeDto> getPointType();

	List<ServicePointDto> getPoint(String pointTypeCode, String pointName) throws Exception;

}
