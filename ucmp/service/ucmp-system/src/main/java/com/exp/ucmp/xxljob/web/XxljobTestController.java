package com.exp.ucmp.xxljob.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IJobReceiveReqDao;
import com.exp.ucmp.dao.ISysStoreInfoDao;
import com.exp.ucmp.dept.service.SysDeptInfoService;
import com.exp.ucmp.entity.JobReceiveInfoEntity;
import com.exp.ucmp.entity.JobReceiveReqEntity;
import com.exp.ucmp.entity.JobReceiveRspEntity;
import com.exp.ucmp.entity.SysStoreInfoEntity;
import com.exp.ucmp.pk.JobReceiveReqPk;
import com.exp.ucmp.store.service.SysStoreInfoService;
import com.exp.ucmp.xxljob.dao.IXxlJobDao;
import com.exp.ucmp.xxljob.service.EmdmXxlJobService;
import com.exp.ucmp.xxljob.service.JobReceiveRspUserInfoService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.xxl.job.core.biz.model.ReturnT;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * 
 * @author xiongneng
 * @date 2022年10月09日
 */
@Api(value = "xxljob调试", tags = "xxljob调试")
@RefreshScope
@Controller
public class XxljobTestController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(XxljobTestController.class);
	@Autowired
	private SysDeptInfoService deptInfoService;
    @Autowired
	private EmdmXxlJobService xxlJobService;
	@Autowired
	private IXxlJobDao iXxlJobDao;
	@Autowired
	private JobReceiveRspUserInfoService sysParentUserInfoService;
	@Autowired
	private ISysStoreInfoDao storeInfoDao;
    @Autowired
    private IJobReceiveReqDao receiveReqDao;

	@Autowired
	private SysStoreInfoService sysStoreInfoService;
    /**
     * <p>Description: xxljob调试</p>
     * @return 部门信息
     */
    @ApiOperation(value = "xxljob调试", notes = "xxljob调试", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/xxljob/emdm/getEmdmPersonInfo", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "param", value = "参数", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public ReturnT<String> getEmdmPersonInfo(@RequestParam(value="param", required=false)String param) throws Exception {
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String endDate = sdf.format(new Date());
			//1、查询上次同步信息
			JobReceiveReqEntity  jobReceiveReqEntity=this.xxlJobService.queryReveiveReqByMaxtimestamp("EMDM","HTTP","emdmPersonInfoHandler","1") ;
			LOGGER.info("======jobReceiveReqEntity="+JsonBeanUtil.beanToJson(jobReceiveReqEntity));
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
			LOGGER.info("======startTime="+startTime+",endDate="+endDate);
			this.xxlJobService.synEmdmPersonInfo("emdmPersonInfoHandler",startTime, endDate);
				return ReturnT.SUCCESS;
		}catch(Exception e){
			LOGGER.error("同步emdm人员主数据异常："+e);
			return  ReturnT.FAIL;
		}
	}

	/**
	 * 更新门店人员定时任务测试接口
	 */
	@RequestMapping(value = "/api/xxljob/updateStoreUser", method = RequestMethod.POST)
	public ReturnT<String> updateStoreUser() {
		try{
			//查询是否有拉取成功未读取的数据
			JobReceiveInfoEntity jobReceiveInfoEntity = new JobReceiveInfoEntity();
			jobReceiveInfoEntity.setReceiveTaskType(Constants.ReceiveTaskType.ALL_USER_HANDLER.value());
			jobReceiveInfoEntity.setProcessingStatus(Constants.JobProcessingStatus.WAIT.value());
			jobReceiveInfoEntity.setJobType(Constants.JobType.EOS.value());
			List<JobReceiveRspEntity> rspList = iXxlJobDao.selectALLWaitRspByStoreStaff(jobReceiveInfoEntity);
			if(CollectionUtils.isEmpty(rspList)){
				LOGGER.info("storeStaffInfoXxlJobHandler1[门店管理]没有拉取到需要更新的门店人员数据....");
			}else{
				LOGGER.info("storeStaffInfoXxlJobHandler1[门店管理]准备开始更新门店人员数据");
				rspList.forEach(rsp->{
                    JSONObject jsonObject = JSON.parseObject(rsp.getReceiveRspData());
                    Object data = jsonObject.get("data");
                    //判断数据请求成功.门店人员数据为空的情况
                    if(jsonObject.get("code").equals("200") && data != null && CollectionUtils.isEmpty(jsonObject.getJSONArray("data"))){
                        //找到对应的请求门店id
                        JobReceiveReqPk pk = new JobReceiveReqPk(rsp.getReceiveId());
                        JobReceiveReqEntity load = receiveReqDao.load(pk);
                        Object code = JSON.parseObject(load.getReceiveReqData()).get("departmentCode");
                        String orgId = code.toString();
                        //再根据orgId查询到门店
                        SysStoreInfoEntity storeInfo = new SysStoreInfoEntity();
                        storeInfo.setOrgId(orgId);
                        List<SysStoreInfoEntity> storeInfoEntityList = storeInfoDao.selectBySelective(storeInfo);
                        LOGGER.info("storeStaffInfoXxlJobHandler[门店管理]门店id为:{}的门店暂无人员数据，准备清除",storeInfoEntityList.get(0).getStoreId());
                        xxlJobService.refreshStoreStaffRela(storeInfoEntityList.get(0).getStoreId(),rsp.getReceiveId());
                    }
                    if(!Objects.isNull(data) && !CollectionUtils.isEmpty(jsonObject.getJSONArray("data")) && jsonObject.get("code").equals("200")){
                        xxlJobService.synEosUserInfo(rsp);
                    }
				});
			}
			return ReturnT.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return  ReturnT.FAIL;
		}
	}

	/**
	 * 更新门店地区定时任务测试接口
	 */
	@RequestMapping(value = "/api/xxljob/synStoreArea", method = RequestMethod.POST)
	public ReturnT<String> synStoreArea() {
		try{
			//查询所有地区字段为空的门店数据
			List<SysStoreInfoEntity> storeInfoEntities = storeInfoDao.selectBySelective(new SysStoreInfoEntity());
			List<SysStoreInfoEntity> storeInfoEntitie = storeInfoEntities.stream().filter(item->Objects.isNull(item.getAreaCode())).collect(Collectors.toList());
			if(CollectionUtils.isEmpty(storeInfoEntitie)){
				LOGGER.info("storeAreaInfoXxlJobHandler[门店地区]没有拉取到需要更新地区的门店数据....");
			}else{
				LOGGER.info("storeAreaInfoXxlJobHandler[门店地区]准备开始更新门店地区数据");
				sysStoreInfoService.synStoreArea(storeInfoEntitie);
			}
			return ReturnT.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return  ReturnT.FAIL;
		}
	}


	/**
	 * 测试接口
	 */
	@RequestMapping(value = "/api/parentUserInfo/test", method = RequestMethod.POST)
	public RestResponse<String> parentUserInfo() {
		try {
			//查询是否有拉取成功未读取的数据
			JobReceiveInfoEntity jobReceiveInfoEntity = new JobReceiveInfoEntity();
			jobReceiveInfoEntity.setReceiveTaskType(Constants.ReceiveTaskType.PERSON_INFO_HANDLER.value());
			jobReceiveInfoEntity.setProcessingStatus(Constants.JobProcessingStatus.WAIT.value());
			List<JobReceiveRspEntity> rspList = iXxlJobDao.selectALLWaitRspStr(jobReceiveInfoEntity);
			if(CollectionUtils.isEmpty(rspList)){
				LOGGER.info("XXjob[人员管理]没有拉取到需要更新的人员数据....");
			}else{
				LOGGER.info("XXjob[人员管理]准备开始更新人员数据");
				sysParentUserInfoService.batchUpdateParentUserInfo(rspList);
			}
			return new RestResponse<>(RestStatusCode.OK);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
		}
	}

	/**
	 * 更新部门定时任务测试接口
	 */
	@RequestMapping(value = "/api/xxljob/synDept", method = RequestMethod.POST)
	public ReturnT<String> synDept() {
		try{
			//查询是否有拉取成功未读取的数据
			JobReceiveInfoEntity jobReceiveInfoEntity = new JobReceiveInfoEntity();
			jobReceiveInfoEntity.setReceiveTaskType(Constants.ReceiveTaskType.DEPT_INFO_HANDLER.value());
			jobReceiveInfoEntity.setProcessingStatus(Constants.JobProcessingStatus.WAIT.value());
			jobReceiveInfoEntity.setJobType(Constants.JobType.EMDM.value());
			List<JobReceiveRspEntity> rspList = iXxlJobDao.selectALLWaitRspStr(jobReceiveInfoEntity);
			if(CollectionUtils.isEmpty(rspList)){
				LOGGER.info("emdmDeptInfoXxlJobHandler[部门信息]没有拉取到需要更新的部门信息....");
			}else{
				LOGGER.info("emdmDeptInfoXxlJobHandler[部门信息]准备开始更新门店人员数据");
				rspList.forEach(rsp->{
					JSONObject jsonObject = JSON.parseObject(rsp.getReceiveRspData());
					Object data = jsonObject.get("data");
					if(!Objects.isNull(data) && jsonObject.get("status").equals("200")){
						deptInfoService.synEmdmDeptInfo(rsp);
					}
				});
			}
			return ReturnT.SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
			return  ReturnT.FAIL;
		}
	}


}
