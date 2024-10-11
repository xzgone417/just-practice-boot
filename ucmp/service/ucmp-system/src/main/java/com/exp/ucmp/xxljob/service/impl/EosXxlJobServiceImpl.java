package com.exp.ucmp.xxljob.service.impl;


import com.exp.ucmp.apig.eos.consumer.EosConsumer;
import com.exp.ucmp.apig.smp.consumer.SmpConsumer;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IJobReceiveInfoDao;
import com.exp.ucmp.dao.IJobReceiveReqDao;
import com.exp.ucmp.dao.IJobReceiveRspDao;
import com.exp.ucmp.eos.dto.UserAndSuperiorInfoDto;
import com.exp.ucmp.xxljob.dao.IXxlJobDao;
import com.exp.ucmp.xxljob.service.EosXxlJobService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.entity.JobReceiveInfoEntity;
import com.exp.ucmp.entity.JobReceiveReqEntity;
import com.exp.ucmp.entity.JobReceiveRspEntity;
import com.exp.ucmp.eos.dto.AccountInfoDto;
import com.exp.ucmp.eos.dto.EosReturnDto;
import com.exp.ucmp.eos.dto.SmpReturnDto;
import com.exp.ucmp.eos.dto.SmpUserInfoDto;
import com.exp.ucmp.model.Person;
import org.springframework.util.ObjectUtils;


@Service
public class EosXxlJobServiceImpl implements EosXxlJobService {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EosXxlJobServiceImpl.class);

    @Autowired
    private IXxlJobDao iXxlJobDao;

    @Autowired
    private IJobReceiveInfoDao iJobReceiveInfoDao;

    @Autowired
    private IJobReceiveReqDao iJobReceiveReqDao;

    @Autowired
    private IJobReceiveRspDao iJobReceiveRspDao;

    @Autowired
    private EosConsumer eosConsumer;
    
    @Autowired
    private SmpConsumer smpConsumer;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void allUsersInTheDepartment(String handlerName, String startTime, String endTime) throws Exception {
        //查询门店信息
        List<String> departmentCodeList = this.iXxlJobDao.getDepartmentCodeList();
        if (departmentCodeList != null && !departmentCodeList.isEmpty()) {
            for (String departmentCode : departmentCodeList) {
                //获取门店所有人员信息
                String result = this.eosConsumer.allUsersInTheDepartment(departmentCode);
                EosReturnDto<List<AccountInfoDto>> retrunDto = JsonBeanUtil.jsonToBean(result, EosReturnDto.class);
                Map<String, Object> paramMap = new HashMap<>();
                paramMap.put("departmentCode", departmentCode);
                addReceive(handlerName, endTime, retrunDto.getData().size(), "01", result, paramMap, "eos");
            }
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void getUsersInTheDepartment(String handlerName, String startTime, String endTime) throws Exception {
        //查询门店信息
        List<String> departmentCodeList = this.iXxlJobDao.getDepartmentCodeList();
        if (departmentCodeList != null && !departmentCodeList.isEmpty()) {
            for (String departmentCode : departmentCodeList) {
                //获取门店所有人员信息
                String result = this.eosConsumer.getUsersInTheDepartment(departmentCode);
                EosReturnDto<List<UserAndSuperiorInfoDto>> retrunDto = JsonBeanUtil.jsonToBean(result, EosReturnDto.class);
                if (Constants.CodeEnum.slfCode.value().equals(retrunDto.getCode()) && !ObjectUtils.isEmpty(retrunDto.getData())) {
                    Map<String, Object> paramMap = new HashMap<>();
                    paramMap.put("departmentCode", departmentCode);
                    addReceive(handlerName, endTime, retrunDto.getData().size(), "01", result, paramMap, "slf");
                }
            }
        }
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
	public void smpAllUsersInTheDepartment(String handlerName, String startTime, String endTime) throws Exception {
		//查询门店信息
        List<String> departmentCodeList = this.iXxlJobDao.getDepartmentCodeList();
        if (departmentCodeList != null && !departmentCodeList.isEmpty()) {
            for (String departmentCode : departmentCodeList) {
                //获取门店所有人员信息
                String result = this.smpConsumer.allUsersInTheDepartment(departmentCode);
                LOGGER.info("=====获取门店所有人员信息smp======"+result);
                SmpReturnDto retrunDto = JsonBeanUtil.jsonToBean(result, SmpReturnDto.class);
                if (Constants.CodeEnum.smpCode.value().equals(retrunDto.getCode()) && !ObjectUtils.isEmpty(retrunDto.getData())) {
                    Map<String, Object> paramMap = new HashMap<>();
                    paramMap.put("departmentCode", departmentCode);
                    addReceive(handlerName, endTime, retrunDto.getData().size(), "01", result, paramMap, "smp");
                }
            }
        }
	}

    private void addReceive(String handlerName, String endTime, Integer receiveCount, String receiveResult,
                            String result, Map<String, Object> paramMap, String type) {
        Long partyId = AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
        LOGGER.info("=====addReceive=partyId===" + partyId);
        // 记录接收到的数据信息
        JobReceiveInfoEntity jobReceiveInfoEntity = new JobReceiveInfoEntity();
        jobReceiveInfoEntity.setCreatedBy(partyId);//待定
        jobReceiveInfoEntity.setJobType(type);
        jobReceiveInfoEntity.setProcessingStatus("01");
        jobReceiveInfoEntity.setReceiveCount(receiveCount);
        jobReceiveInfoEntity.generatePk();
        jobReceiveInfoEntity.setReceiveResult(receiveResult);
        jobReceiveInfoEntity.setReceiveTaskType(handlerName);
        jobReceiveInfoEntity.setReceiveTimestamp(Long.parseLong(endTime.replace(" ", "").replace(":", "").replace("-", "")));
        jobReceiveInfoEntity.setReceiveType("http");
        jobReceiveInfoEntity.setUpdatedBy(partyId);

        this.iJobReceiveInfoDao.insert(jobReceiveInfoEntity);

        //记录请求参数
        JobReceiveReqEntity jobReceiveReqEntity = new JobReceiveReqEntity();
        jobReceiveReqEntity.setCreatedBy(partyId);
        jobReceiveReqEntity.setReceiveReqData(JsonBeanUtil.beanToJson(paramMap));
        jobReceiveReqEntity.setReceiveId(jobReceiveInfoEntity.getReceiveId());
        jobReceiveReqEntity.setUpdatedBy(partyId);

        this.iJobReceiveReqDao.insert(jobReceiveReqEntity);

        //记录响应数据
        JobReceiveRspEntity jobReceiveRspEntity = new JobReceiveRspEntity();
        jobReceiveRspEntity.setCreatedBy(partyId);
        jobReceiveRspEntity.setReceiveId(jobReceiveInfoEntity.getReceiveId());
        jobReceiveRspEntity.setReceiveRspData(result);
        jobReceiveRspEntity.setUpdatedBy(partyId);

        this.iJobReceiveRspDao.insert(jobReceiveRspEntity);
    }

	public static void main(String[] args) {
		String result="{\"code\":\"000000\",\"msg\":\"SUCCESS\",\"data\":[{\"idmAccountName\":\"DS_02\",\"userId\":\"1633388674774306818\",\"userName\":\"DS_02\",\"phoneNumber\":\"15201753103\",\"roleList\":[{\"roleCode\":\"7163020210223314224\",\"roleName\":\"交付主管\"}]},{\"idmAccountName\":\"DS_01\",\"userId\":\"1633388674744946689\",\"userName\":\"DS_01\",\"phoneNumber\":\"15201753102\",\"roleList\":[{\"roleCode\":\"7163020210223314224\",\"roleName\":\"交付主管\"}]},{\"idmAccountName\":\"DM_02\",\"userId\":\"1633388674711392257\",\"userName\":\"DM_02\",\"phoneNumber\":\"15201753101\",\"roleList\":[{\"roleCode\":\"7163020210223314224\",\"roleName\":\"交付主管\"}]},{\"idmAccountName\":\"DM_01\",\"userId\":\"1633378602224787457\",\"userName\":\"DM_01\",\"phoneNumber\":\"15201753100\",\"roleList\":[{\"roleCode\":\"7163020210223314224\",\"roleName\":\"交付主管\"}]},{\"idmAccountName\":\"\",\"userId\":\"1590232868205989889\",\"userName\":\"刘海波\",\"phoneNumber\":\"15821274007\",\"roleList\":[]},{\"idmAccountName\":\"WeiweiShen\",\"userId\":\"1376444191378632706\",\"userName\":\"沈尉伟\",\"phoneNumber\":\"17602172278\",\"roleList\":[]},{\"idmAccountName\":\"apptest105\",\"userId\":\"1376444149385261058\",\"userName\":\"apptest105\",\"phoneNumber\":\"18071742755\",\"roleList\":[{\"roleCode\":\"5067620210225450325\",\"roleName\":\"金融客户经理\"}]},{\"idmAccountName\":\"apptest102\",\"userId\":\"1366670938079207426\",\"userName\":\"apptest102\",\"phoneNumber\":\"13559010908\",\"roleList\":[{\"roleCode\":\"5067620210225450325\",\"roleName\":\"金融客户经理\"}]},{\"idmAccountName\":\"apptest87\",\"userId\":\"1366459552723496962\",\"userName\":\"apptest87\",\"phoneNumber\":\"13761164958\",\"roleList\":[{\"roleCode\":\"4467720210223534254\",\"roleName\":\"交付体验顾问\"}]},{\"idmAccountName\":\"apptest83\",\"userId\":\"1366459552698331137\",\"userName\":\"测试人员83\",\"phoneNumber\":\"18616026367\",\"roleList\":[{\"roleCode\":\"1635890330934149121\",\"roleName\":\"交付经理\"}]},{\"idmAccountName\":\"apptest84\",\"userId\":\"1366459552694136833\",\"userName\":\"apptest84\",\"phoneNumber\":\"\",\"roleList\":[{\"roleCode\":\"1635890330934149121\",\"roleName\":\"交付经理\"}]},{\"idmAccountName\":\"apptest88\",\"userId\":\"1366459552664776706\",\"userName\":\"apptest88\",\"phoneNumber\":\"\",\"roleList\":[{\"roleCode\":\"1443388676671377410\",\"roleName\":\"仓库管理&PDI检测\"}]}]}";
		SmpReturnDto retrunDto = JsonBeanUtil.jsonToBean(result, SmpReturnDto.class);
		if ("000000".equals(retrunDto.getCode()) && !ObjectUtils.isEmpty(retrunDto.getData())) {
			LOGGER.info("====角色====="+JsonBeanUtil.beanToJson(retrunDto.getData().get(0).getRoleList()));
        }
	}
}
