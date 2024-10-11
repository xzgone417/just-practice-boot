package com.exp.ucmp.xxljob.handler;

import com.exp.ucmp.newcarorder.service.NewCarOrderService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class NewCarOrderJobHandler {
	
	@Autowired
	private NewCarOrderService newCarOrderService;

	/**
     * Description 同步SMP 新车订单信息
     * 
     * @author xiongneng
	 * @throws Exception 
     * 
     */
	@XxlJob("synNewCarOrderHandler")
	public ReturnT<String> synorderstatus(String param) throws Exception {
		try{
			this.newCarOrderService.synorderstatus();
			return ReturnT.SUCCESS;
		}catch(Exception e){
			XxlJobLogger.log("同步SMP 新车订单信息异常："+e);
			return  ReturnT.FAIL;
		}
	}
}
