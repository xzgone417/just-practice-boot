package com.exp.ucmp.servicepoint.dao;

import java.util.List;

import com.exp.ucmp.isp.dto.ServicePointTypeDto;

public interface ServicePointDao {

	List<ServicePointTypeDto> getPointType();

    
}
