package com.exp.ucmp.xxljob.handler;

import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.xxljob.service.SmpXxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SmpXxlJobHandler {
	
	@Autowired
	private SmpXxlJobService xxlJobService;
	
	/**
     * Description 同步SMP 门店信息
     * 
     * @author xiongneng
	 * @throws Exception 
     * 
     */
	@XxlJob("smpOrgListHandler")
	public ReturnT<String> getOrgList(String param) throws Exception {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String endTime = sdf.format(new Date());
			this.xxlJobService.getOrgList(Constants.ReceiveTaskType.ORG_LIST_HANDLER.value(),null, endTime);
			return ReturnT.SUCCESS;
		}catch(Exception e){
			XxlJobLogger.log("同步emdm人员主数据异常："+e);
			return  ReturnT.FAIL;
		}
	}
	
	@XxlJob("smpCodeListHandler")
	public ReturnT<String> getStoreCodeList(String param) throws Exception {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String endTime = sdf.format(new Date());
			this.xxlJobService.getStoreCodeList(Constants.ReceiveTaskType.STORE_CODE_HANDLER.value(),null, endTime);
			return ReturnT.SUCCESS;
		}catch(Exception e){
			XxlJobLogger.log("同步emdm人员主数据异常："+e);
			return  ReturnT.FAIL;
		}
	}
	
}
