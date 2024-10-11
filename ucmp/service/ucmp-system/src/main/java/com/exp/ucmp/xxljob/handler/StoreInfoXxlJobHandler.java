package com.exp.ucmp.xxljob.handler;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IJobReceiveReqDao;
import com.exp.ucmp.dao.ISysStoreInfoDao;
import com.exp.ucmp.entity.JobReceiveInfoEntity;
import com.exp.ucmp.entity.JobReceiveReqEntity;
import com.exp.ucmp.entity.JobReceiveRspEntity;
import com.exp.ucmp.entity.SysStoreInfoEntity;
import com.exp.ucmp.pk.JobReceiveReqPk;
import com.exp.ucmp.store.service.SysStoreInfoService;
import com.exp.ucmp.xxljob.dao.IXxlJobDao;
import com.exp.ucmp.xxljob.service.EmdmXxlJobService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * @author hailele
 * @date 2022年10月20日
 *从t_job_receive_info表定时拉取数据，更新门店信息
 */
@Component
public class StoreInfoXxlJobHandler {
	
	@Autowired
	private SysStoreInfoService sysStoreInfoService;
    @Autowired
    private ISysStoreInfoDao storeInfoDao;
    @Autowired
    private IJobReceiveReqDao receiveReqDao;
    @Autowired
    private EmdmXxlJobService xxlJobService;
    @Autowired
    private IXxlJobDao iXxlJobDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(StoreInfoXxlJobHandler.class);
    
    /**
     * Description 同步t_sys_store_info门店表信息
     * @author hailele
	 * @throws Exception
     */
	@XxlJob("storeInfoXxlJobHandler")
	public ReturnT<String> pullStoreInfo(String param) {
        try {
            //查询是否有拉取成功未读取的数据
            JobReceiveInfoEntity jobReceiveInfoEntity = new JobReceiveInfoEntity();
            jobReceiveInfoEntity.setReceiveTaskType(Constants.ReceiveTaskType.ORG_LIST_HANDLER.value());
            jobReceiveInfoEntity.setProcessingStatus(Constants.JobProcessingStatus.WAIT.value());
            jobReceiveInfoEntity.setJobType(Constants.JobType.SMP.value());
            List<JobReceiveRspEntity> rspList = iXxlJobDao.selectALLWaitRspStr(jobReceiveInfoEntity);
            if(CollectionUtils.isEmpty(rspList)){
                LOGGER.info("StoreInfoXxlJobHandler[门店管理]没有拉取到需要更新的门店数据....");
            }else{
                LOGGER.info("StoreInfoXxlJobHandler[门店管理]准备开始更新门店数据");
                if (!CollectionUtils.isEmpty(rspList)){
                    rspList.forEach(rsp->{
                        sysStoreInfoService.synSmpStoresInfo(rsp);
                    });
                }
            }
            return ReturnT.SUCCESS;
        }catch (Exception e){
            LOGGER.error("XXjob[门店管理]更新异常:{}",e);
            throw new RuntimeException();
        }
    }
	
	@XxlJob("storeCodeXxlJobHandler")
	public ReturnT<String> pullStoreCode(String param) {
        try {
            //查询是否有拉取成功未读取的数据
            JobReceiveInfoEntity jobReceiveInfoEntity = new JobReceiveInfoEntity();
            jobReceiveInfoEntity.setReceiveTaskType(Constants.ReceiveTaskType.STORE_CODE_HANDLER.value());
            jobReceiveInfoEntity.setProcessingStatus(Constants.JobProcessingStatus.WAIT.value());
            jobReceiveInfoEntity.setJobType(Constants.JobType.SMP.value());
            List<JobReceiveRspEntity> rspList = iXxlJobDao.selectALLWaitRspStr(jobReceiveInfoEntity);
            if(CollectionUtils.isEmpty(rspList)){
                LOGGER.info("storeCodeXxlJobHandler[门店Code同步]没有拉取到需要更新的门店数据....");
            }else{
                LOGGER.info("storeCodeXxlJobHandler[门店Code同步]准备开始更新门店数据");
                if (!CollectionUtils.isEmpty(rspList)){
                    rspList.forEach(rsp->{
                        sysStoreInfoService.synStoreCodeInfo(rsp);
                    });
                }
            }
            return ReturnT.SUCCESS;
        }catch (Exception e){
            LOGGER.error("XXjob[门店Code同步]更新异常:{}",e);
            throw new RuntimeException();
        }
    }


    /**
     * Description 同步t_sys_store_staff_info门店人员表
     * @author hailele
     * @throws Exception
     *
     */
    @XxlJob("storeStaffInfoXxlJobHandler")
    public ReturnT<String> pullStoreStaffInfo(String param){
    	try{
    		//查询是否有拉取成功未读取的数据
    		JobReceiveInfoEntity jobReceiveInfoEntity = new JobReceiveInfoEntity();
    		jobReceiveInfoEntity.setReceiveTaskType(Constants.ReceiveTaskType.ALL_USER_HANDLER.value());
    		jobReceiveInfoEntity.setProcessingStatus(Constants.JobProcessingStatus.WAIT.value());
    		jobReceiveInfoEntity.setJobType(Constants.JobType.EOS.value());
    		List<JobReceiveRspEntity> rspList = iXxlJobDao.selectALLWaitRspByStoreStaff(jobReceiveInfoEntity);
    		
    		//EOS
    		if(CollectionUtils.isEmpty(rspList)){
    			LOGGER.info("storeStaffInfoXxlJobHandler[门店管理]没有拉取到需要更新的门店人员数据....");
    		}else{
    			LOGGER.info("storeStaffInfoXxlJobHandler[门店管理]准备开始更新门店人员数据");
    			for (JobReceiveRspEntity rsp : rspList) {
    				JSONObject jsonObject = JSON.parseObject(rsp.getReceiveRspData());
    				Object data = jsonObject.get("data");
    				//判断数据请求成功.门店人员数据为空的情况
    				if(jsonObject.get("code").equals(Constants.CodeEnum.eosCode.value()) && data != null && CollectionUtils.isEmpty(jsonObject.getJSONArray("data"))){
    					LOGGER.info("storeStaffInfoXxlJobHandler[门店人员定时任务]receiveId:{}的记录没有人员数据，准备清除下面对应人员",rsp.getReceiveId());
    					//找到对应的请求门店id
    					JobReceiveReqPk pk = new JobReceiveReqPk(rsp.getReceiveId());
    					JobReceiveReqEntity load = receiveReqDao.load(pk);
    					LOGGER.info("storeStaffInfoXxlJobHandler="+JsonBeanUtil.beanToJson(load.getReceiveReqData()));
    					Object code = JSON.parseObject(load.getReceiveReqData()).get("departmentCode");
    					String orgId = code.toString();
    					//再根据orgId查询到门店
    					SysStoreInfoEntity storeInfo = new SysStoreInfoEntity();
    					storeInfo.setOrgId(orgId);
    					List<SysStoreInfoEntity> storeInfoEntityList = storeInfoDao.selectBySelective(storeInfo);
    					if(!storeInfoEntityList.isEmpty()){
    						xxlJobService.refreshStoreStaffRela(storeInfoEntityList.get(0).getStoreId(),rsp.getReceiveId());
    						LOGGER.info("storeStaffInfoXxlJobHandler[门店管理]门店id为:{}的门店暂无人员数据，准备清除",storeInfoEntityList.get(0).getStoreId());
    					}
    				}
    				if(!Objects.isNull(data) && !CollectionUtils.isEmpty(jsonObject.getJSONArray("data")) && jsonObject.get("code").equals(Constants.CodeEnum.eosCode.value())){
    					xxlJobService.synEosUserInfo(rsp);
    				}
    			}
    		}
    		
    		return ReturnT.SUCCESS;
    	}catch (Exception e) {
    		LOGGER.error("===storeStaffInfoXxlJobHandler异常===",e);
			return ReturnT.FAIL;
		}
    }
    
    /**
     * Description 同步t_sys_store_staff_info门店人员表
     * @author xiongneng
     * @throws Exception
     *
     */
    @XxlJob("slfStoreStaffInfoXxlJobHandler")
    public ReturnT<String> pullSlfStoreStaffInfo(String param){
    	try{
	    	 //查询是否有拉取成功未读取的数据
	        JobReceiveInfoEntity jobReceiveInfoEntity = new JobReceiveInfoEntity();
	    	//SLF
	        jobReceiveInfoEntity.setReceiveTaskType(Constants.ReceiveTaskType.SLF_ALL_USER_HANDLER.value());
	        jobReceiveInfoEntity.setJobType(Constants.JobType.SLF.value());
	        jobReceiveInfoEntity.setProcessingStatus(Constants.JobProcessingStatus.WAIT.value());
	        List<JobReceiveRspEntity> slfRspList = iXxlJobDao.selectALLWaitRspByStoreStaff(jobReceiveInfoEntity);
	        
	        if(slfRspList !=null && !slfRspList.isEmpty()){
	        	LOGGER.info("=====[从slf获取到人员数据，准备更新]====");
	        	for (JobReceiveRspEntity slf : slfRspList) {
	        		JSONObject jsonObject = JSON.parseObject(slf.getReceiveRspData());
	                Object data = jsonObject.get("data");
	                //找到对应的请求门店id
	                JobReceiveReqPk pk = new JobReceiveReqPk(slf.getReceiveId());
	                JobReceiveReqEntity load = receiveReqDao.load(pk);
	                Object code = JSON.parseObject(load.getReceiveReqData()).get("departmentCode");
	                String orgId = code.toString();
	              //判断数据请求成功.门店人员数据为空的情况
	                if(jsonObject.get("code").equals(Constants.CodeEnum.slfCode.value()) && data != null && CollectionUtils.isEmpty(jsonObject.getJSONArray("data"))){
	                    //再根据orgId查询到门店
	                    SysStoreInfoEntity storeInfo = new SysStoreInfoEntity();
	                    storeInfo.setOrgId(orgId);
	                    List<SysStoreInfoEntity> storeInfoEntityList = storeInfoDao.selectBySelective(storeInfo);
	                    if(!storeInfoEntityList.isEmpty()){
	                    	xxlJobService.refreshStoreStaffRela(storeInfoEntityList.get(0).getStoreId(),slf.getReceiveId());
	                    	LOGGER.info("slfStoreStaffInfoXxlJobHandler[门店管理]门店id为:{}的门店暂无人员数据，准备清除",storeInfoEntityList.get(0).getStoreId());
	                    }
	                }else if(!Objects.isNull(data) && !CollectionUtils.isEmpty(jsonObject.getJSONArray("data")) && jsonObject.get("code").equals(Constants.CodeEnum.slfCode.value())){
	                    xxlJobService.synSlfUserInfo(slf,orgId);
	                }
	    		}
	        }
			return ReturnT.SUCCESS;
    	}catch (Exception e) {
    		LOGGER.error("===slfStoreStaffInfoXxlJobHandler异常===",e);
			return ReturnT.FAIL;
		}
    }
    
    /**
     * Description 同步t_sys_store_staff_info门店人员表
     * @author xiongneng
     * @throws Exception
     *
     */
    @XxlJob("smpStoreStaffInfoXxlJobHandler")
    public ReturnT<String> pullSmpStoreStaffInfo(String param){
    	try{
	    	//查询是否有拉取成功未读取的数据
	        JobReceiveInfoEntity jobReceiveInfoEntity = new JobReceiveInfoEntity();
	      //SMP
	        jobReceiveInfoEntity.setReceiveTaskType(Constants.ReceiveTaskType.SMP_ALL_USER_HANDLER.value());
	        jobReceiveInfoEntity.setJobType(Constants.JobType.SMP.value());
	        jobReceiveInfoEntity.setProcessingStatus(Constants.JobProcessingStatus.WAIT.value());
	        List<JobReceiveRspEntity> smpRspList = iXxlJobDao.selectALLWaitRspByStoreStaff(jobReceiveInfoEntity);
	        
	        if(smpRspList !=null && !smpRspList.isEmpty()){
	        	LOGGER.info("=====[从smp获取到人员数据，准备更新]====");
	        	for (JobReceiveRspEntity smp : smpRspList) {
	        		JSONObject jsonObject = JSON.parseObject(smp.getReceiveRspData());
	                Object data = jsonObject.get("data");
	                //找到对应的请求门店id
	                JobReceiveReqPk pk = new JobReceiveReqPk(smp.getReceiveId());
	                JobReceiveReqEntity load = receiveReqDao.load(pk);
	                Object code = JSON.parseObject(load.getReceiveReqData()).get("departmentCode");
	                String orgId = code.toString();
	              //判断数据请求成功.门店人员数据为空的情况
	                if(jsonObject.get("code").equals(Constants.CodeEnum.smpCode.value()) && data != null && CollectionUtils.isEmpty(jsonObject.getJSONArray("data"))){
	                    //再根据orgId查询到门店
	                    SysStoreInfoEntity storeInfo = new SysStoreInfoEntity();
	                    storeInfo.setOrgId(orgId);
	                    List<SysStoreInfoEntity> storeInfoEntityList = storeInfoDao.selectBySelective(storeInfo);
	                    if(!storeInfoEntityList.isEmpty()){
	                    	xxlJobService.refreshStoreStaffRela(storeInfoEntityList.get(0).getStoreId(),smp.getReceiveId());
	                    	LOGGER.info("smpStoreStaffInfoXxlJobHandler[门店管理]门店id为:{}的门店暂无人员数据，准备清除",storeInfoEntityList.get(0).getStoreId());
	                    }
	                }else if(!Objects.isNull(data) && !CollectionUtils.isEmpty(jsonObject.getJSONArray("data")) && jsonObject.get("code").equals(Constants.CodeEnum.smpCode.value())){
	                    xxlJobService.synSmpUserInfo(smp,orgId);
	                }
	    		}
	        }
			return ReturnT.SUCCESS;
	    }catch (Exception e) {
			LOGGER.error("===smpStoreStaffInfoXxlJobHandler异常===",e);
			return ReturnT.FAIL;
		}
    }
    

	public  static  void  main(String[] arg){
        JobReceiveReqEntity load = new JobReceiveReqEntity();
        load.setReceiveReqData("{\"departmentCode\":\"7656320210325304011\"}");
        System.out.println(load.getReceiveReqData());

        load.setReceiveId(123L);
        Object code = JSON.parseObject(load.getReceiveReqData()).get("departmentCode");
        System.out.println("门店id:"+code);
    }
    /**
     * Description 同步t_sys_store_info门店表的地区字段
     * @author hailele
     * @throws Exception
     */
    @XxlJob("storeAreaInfoXxlJobHandler")
    public ReturnT<String> pullStoreAreaInfo(String param) throws Exception {
        try {
            //查询所有地区字段为空的门店数据
            List<SysStoreInfoEntity> storeInfoEntities = storeInfoDao.selectBySelective(new SysStoreInfoEntity());
            if(CollectionUtils.isEmpty(storeInfoEntities)){
                LOGGER.info("storeAreaInfoXxlJobHandler[门店地区]没有拉取到需要更新地区的门店数据....");
            }else{
                LOGGER.info("storeAreaInfoXxlJobHandler[门店地区]准备开始更新门店地区数据{}条",storeInfoEntities.size());
                sysStoreInfoService.synStoreArea(storeInfoEntities);
            }
            return ReturnT.SUCCESS;
        }catch (Exception e){
            LOGGER.error("XXjob[门店地区]更新异常:{}",e);
            throw new RuntimeException();
        }
    }


}
