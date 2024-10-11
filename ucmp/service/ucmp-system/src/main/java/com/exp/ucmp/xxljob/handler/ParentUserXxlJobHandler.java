package com.exp.ucmp.xxljob.handler;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dept.service.SysDeptInfoService;
import com.exp.ucmp.entity.JobReceiveInfoEntity;
import com.exp.ucmp.entity.JobReceiveRspEntity;
import com.exp.ucmp.xxljob.dao.IXxlJobDao;
import com.exp.ucmp.xxljob.service.JobReceiveRspUserInfoService;
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
 *从t_job_receive_info表定时拉取数据，更新用户信息
 */
@Component
public class ParentUserXxlJobHandler {
	
	@Autowired
	private JobReceiveRspUserInfoService sysParentUserInfoService;
    @Autowired
    private IXxlJobDao iXxlJobDao;
    @Autowired
    private SysDeptInfoService deptInfoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ParentUserXxlJobHandler.class);

    /**
     * Description 同步t_job_receive_info表人员信息
     * @author hailele
	 * @throws Exception
     */
	@XxlJob("parentUserXxlJobHandler")
	public ReturnT<String> pullPersonInfo(String param) {
//        try {
            //查询是否有拉取成功未读取的数据
            JobReceiveInfoEntity jobReceiveInfoEntity = new JobReceiveInfoEntity();
            jobReceiveInfoEntity.setReceiveTaskType(Constants.ReceiveTaskType.PERSON_INFO_HANDLER.value());
            jobReceiveInfoEntity.setProcessingStatus(Constants.JobProcessingStatus.WAIT.value());
            jobReceiveInfoEntity.setJobType(Constants.JobType.EMDM.value());
            List<JobReceiveRspEntity> rspList = iXxlJobDao.selectALLWaitRspStr(jobReceiveInfoEntity);
            if(CollectionUtils.isEmpty(rspList)){
                LOGGER.info("ParentUserXxlJobHandler[人员管理]没有拉取到需要更新的人员数据....");
            }else{
                LOGGER.info("ParentUserXxlJobHandler[人员管理]准备开始更新人员数据");
                sysParentUserInfoService.batchUpdateParentUserInfo(rspList);
            }
            return ReturnT.SUCCESS;
//        }catch (Exception e){
//            LOGGER.error("XXjob[人员管理]更新异常:{}",e);
//            throw new RuntimeException();
//        }
    }

    /**
     * Description 同步t_sys_dept_info表部门信息
     * @author hailele
     * @throws Exception
     */
    @XxlJob("emdmDeptInfoXxlJobHandler")
    public ReturnT<String> pullDeptInfo(String param) {
        try {
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
        }catch (Exception e){
            LOGGER.error("XXjob[部门信息]更新异常:{}",e);
            throw new RuntimeException();
        }
    }

}
