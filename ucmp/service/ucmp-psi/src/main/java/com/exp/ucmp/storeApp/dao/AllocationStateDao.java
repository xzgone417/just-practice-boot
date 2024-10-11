package com.exp.ucmp.storeApp.dao;

import com.exp.ucmp.eos.dto.ReservationDto;
import com.exp.ucmp.eos.dto.ReservationParamDto;
import com.exp.ucmp.stock.dto.AllocationStateDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AllocationStateDao {

	AllocationStateDto queryAllocationState(@Param("param") String param,@Param("type")  String type);

	List<Map<String, Object>> getArriveCity(Long dispatchInfoId);
}
