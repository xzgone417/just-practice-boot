package com.exp.ucmp.xxljob.handler;

import com.exp.ucmp.storage.service.CarUsedStorageService;
import com.exp.ucmp.xxljob.service.SmpXxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarUsedStorageJobHandler {

	@Autowired
	private CarUsedStorageService usedStorageService;
	/**
     * Description 同步仓储点信息
     * @author hailele
     */
	@XxlJob("carUsedStorageHandler")
	public ReturnT<String> carUsedStorageHandler(String param) throws Exception {
		usedStorageService.synUsedStorage();
		return ReturnT.SUCCESS;
	}
	
}
