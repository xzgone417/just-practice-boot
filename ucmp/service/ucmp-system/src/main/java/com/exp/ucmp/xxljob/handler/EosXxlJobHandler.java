package com.exp.ucmp.xxljob.handler;

import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.xxljob.service.EosXxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EosXxlJobHandler {
	
	@Autowired
	private EosXxlJobService xxlJobService;
	
	/**
     * Description 同步SMP 门店人员信息
     * 
     * @author xiongneng
	 * @throws Exception 
     * 
     */
	@XxlJob("eosAllUsersHandler")
	public ReturnT<String> allUsersInTheDepartment(String param) throws Exception {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String endTime = sdf.format(new Date());
			this.xxlJobService.allUsersInTheDepartment(Constants.ReceiveTaskType.ALL_USER_HANDLER.value(),null, endTime);
			return ReturnT.SUCCESS;
		}catch(Exception e){
			XxlJobLogger.log("同步emdm人员主数据异常："+e);
			return  ReturnT.FAIL;
		}
	}

	/**
	 * Description 同步SLF 门店人员信息
	 *
	 * @author gubonai
	 * @throws Exception
	 *
	 */
	@XxlJob("slfAllUsersHandler")
	public ReturnT<String> getUsersInTheDepartment(String param) throws Exception {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String endTime = sdf.format(new Date());
			this.xxlJobService.getUsersInTheDepartment(Constants.ReceiveTaskType.SLF_ALL_USER_HANDLER.value(),null, endTime);
			return ReturnT.SUCCESS;
		}catch(Exception e){
			XxlJobLogger.log("同步slf门店人员数据异常："+e);
			return  ReturnT.FAIL;
		}
	}
	
	/**
	 * Description 同步SMP 交付中心人员信息
	 *
	 * @author xiongneng
	 * @throws Exception
	 *
	 */
	@XxlJob("smpAllUsersHandler")
	public ReturnT<String> smpAllUsersInTheDepartment(String param) throws Exception {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String endTime = sdf.format(new Date());
			this.xxlJobService.smpAllUsersInTheDepartment(Constants.ReceiveTaskType.SMP_ALL_USER_HANDLER.value(),null, endTime);
			return ReturnT.SUCCESS;
		}catch(Exception e){
			XxlJobLogger.log("同步slf门店人员数据异常："+e);
			return  ReturnT.FAIL;
		}
	}
}
