package com.exp.ucmp.car.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exp.ucmp.car.dto.MaintenanceInfoDto;
import com.exp.ucmp.car.dto.MaintenanceItemDto;
import com.exp.ucmp.car.dto.OtherFeesDto;
import com.exp.ucmp.car.dto.RepairPartsDto;
import com.exp.ucmp.car.service.MaintenanceInfoService;

@Service
public class MaintenanceInfoServiceImpl implements MaintenanceInfoService {

	@Override
	public List<MaintenanceInfoDto> maintenanceInfo(String carVin) {
		// 从ISP获取维修历史数据
		List<MaintenanceInfoDto> returnList=new ArrayList<>();
		/*//返回组装，主类
		MaintenanceInfoDto returnDto=new MaintenanceInfoDto();
		returnDto.setAddress("高合交付中心（金桥）");
		returnDto.setCost("349.00");
		returnDto.setMaintenanceDate("2020-10-09");
		returnDto.setMileage("1000");
		returnDto.setWorkOrderNo("001");
		returnDto.setMaintenanceType("PDI维修");
		//子类,维修项目集合
		List<MaintenanceItemDto> maintenanceItemList=new ArrayList<>();
		MaintenanceItemDto itemDto=new MaintenanceItemDto();
		itemDto.setAmount("160");
		itemDto.setItemCode("fs");
		itemDto.setItemName("车辆清洗");
		itemDto.setReceivableAmount("160");
		itemDto.setTimeNum("2");
		itemDto.setTimePrice("80");
		maintenanceItemList.add(itemDto);
		//子类,维修配件集合
		List<RepairPartsDto> repairPartsList=new ArrayList<>();
		RepairPartsDto partsDto=new RepairPartsDto();
		partsDto.setAmount("20");
		partsDto.setPartsCode("fsd");
		partsDto.setPartsName("测试零件");
		partsDto.setPartsNum("1");
		partsDto.setPartsPrice("20");
		partsDto.setReceivableAmount("20");
		repairPartsList.add(partsDto);
		//子类,其他费用集合
		List<OtherFeesDto> otherFeesList=new ArrayList<>();
		OtherFeesDto feesDto=new OtherFeesDto();
		feesDto.setItemAmount("100");
		feesDto.setItemCode("fees");
		feesDto.setItemName("测试费用");
		feesDto.setReceivableAmount("100");
		otherFeesList.add(feesDto);
		
		returnDto.setMaintenanceItemList(maintenanceItemList);
		returnDto.setRepairPartsList(repairPartsList);
		returnDto.setOtherFeesList(otherFeesList);
		
		returnList.add(returnDto);*/
		return returnList;
	}


}
