package com.exp.ucmp.xxljob.handler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.entity.JobReceiveReqEntity;
import com.exp.ucmp.xxljob.service.EmdmXxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;

@Component
public class EmdmXxlJobHandler {
	
	@Autowired
	private EmdmXxlJobService xxlJobService;
	
	/**
     * Description 同步EMDM 人员信息
     * 
     * @author xiongneng
	 * @throws Exception 
     * 
     */
	@XxlJob("emdmPersonInfoHandler")
	public ReturnT<String> getEmdmPersonInfo(String param) throws Exception {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String endTime = sdf.format(new Date());
			//1、查询上次同步信息
			JobReceiveReqEntity  jobReceiveReqEntity=this.xxlJobService.queryReveiveReqByMaxtimestamp("EMDM","HTTP","emdmPersonInfoHandler","01") ;
			//2、计算本次同步时间范围
			//2.1、 首次同步，取全量数据（开始时间/结束时间不传）
			
			String startTime;
			if(jobReceiveReqEntity == null){
				startTime=null;
			}else{
				//2.2、非首次，以上次同步结束时间为本次开始时间，当前时间为本次结束时间
				Map<String, Object> map = JsonBeanUtil.jsonToBean(jobReceiveReqEntity.getReceiveReqData(), HashMap.class);
				startTime=map.get("endTime").toString();
			}
			
			this.xxlJobService.synEmdmPersonInfo("emdmPersonInfoHandler",startTime, endTime);
			return ReturnT.SUCCESS;
		}catch(Exception e){
			XxlJobLogger.log("同步emdm人员主数据异常："+e);
			return  ReturnT.FAIL;
		}
	}
	
	/**
     * Description 同步EMDM 全量获取行政区划信息
     * 
     * @author xiongneng
	 * @throws Exception 
     * 
     */
	@XxlJob("emdmAreaInfoHandler")
	public ReturnT<String> getEmdmAreaInfo(String param) throws Exception {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String endTime = sdf.format(new Date());
			this.xxlJobService.synEmdmAreaInfo("emdmAreaInfoHandler",null, endTime);
			return ReturnT.SUCCESS;
		}catch(Exception e){
			XxlJobLogger.log("同步emdm人员主数据异常："+e);
			return  ReturnT.FAIL;
		}
	}
	
	/**
     * Description 同步EMDM 部门信息
     * 
     * @author xiongneng
	 * @throws Exception 
     * 
     */
	@XxlJob("emdmDeptInfoHandler")
	public ReturnT<String> getEmdmDeptInfo(String param) throws Exception {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String endTime = sdf.format(new Date());
			//1、查询上次同步信息
			JobReceiveReqEntity  jobReceiveReqEntity=this.xxlJobService.queryReveiveReqByMaxtimestamp("EMDM","HTTP","emdmDeptInfoHandler","01") ;
			//2、计算本次同步时间范围
			//2.1、 首次同步，取全量数据（开始时间/结束时间不传）
			
			String startTime;
			if(jobReceiveReqEntity == null){
				startTime=null;
			}else{
				//2.2、非首次，以上次同步结束时间为本次开始时间，当前时间为本次结束时间
				Map<String, Object> map = JsonBeanUtil.jsonToBean(jobReceiveReqEntity.getReceiveReqData(), HashMap.class);
				startTime=map.get("endTime").toString();
			}
			
			this.xxlJobService.synEmdmDeptInfo("emdmDeptInfoHandler",startTime, endTime);
			return ReturnT.SUCCESS;
		}catch(Exception e){
			XxlJobLogger.log("同步emdm人员主数据异常："+e);
			return  ReturnT.FAIL;
		}
	}
}
