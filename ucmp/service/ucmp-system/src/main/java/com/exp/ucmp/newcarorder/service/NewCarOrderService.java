package com.exp.ucmp.newcarorder.service;

import com.exp.ucmp.smp.dto.NewCarOrderDto;

public interface NewCarOrderService {

	NewCarOrderDto getOrderDetail(String orderNum, String vin) throws Exception;

	void synorderstatus();
}
