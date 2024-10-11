package com.exp.ucmp.xxljob.service.impl;


import com.exp.ucmp.apig.channel.consumer.ChannelConsumer;
import com.exp.ucmp.apig.smp.consumer.SmpConsumer;
import com.exp.ucmp.dao.IJobReceiveInfoDao;
import com.exp.ucmp.dao.IJobReceiveReqDao;
import com.exp.ucmp.dao.IJobReceiveRspDao;
import com.exp.ucmp.xxljob.dao.IXxlJobDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.entity.JobReceiveInfoEntity;
import com.exp.ucmp.entity.JobReceiveReqEntity;
import com.exp.ucmp.entity.JobReceiveRspEntity;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.smp.dto.OrgDto;
import com.exp.ucmp.smp.dto.SmpReturnDto;
import com.exp.ucmp.smp.dto.SmpStoreReturnDto;
import com.exp.ucmp.store.dto.ChannelStoreParamDto;
import com.exp.ucmp.xxljob.service.SmpXxlJobService;


@Service
public class SmpXxlJobServiceImpl implements SmpXxlJobService {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SmpXxlJobServiceImpl.class);

	@Autowired
	private IXxlJobDao iXxlJobDao;
	
	@Autowired
	private IJobReceiveInfoDao iJobReceiveInfoDao;
	
	@Autowired
	private IJobReceiveReqDao iJobReceiveReqDao;
	
	@Autowired
	private IJobReceiveRspDao iJobReceiveRspDao;
	
	@Autowired
	private SmpConsumer smpConsumer;
	
	@Autowired
	private ChannelConsumer channelConsumer;
	
	@Override
	public JobReceiveReqEntity queryReveiveReqByMaxtimestamp(String jobType, String receiveType, String receiveTaskType, String receiveResult) {
		JobReceiveInfoEntity jobReceiveInfoEntity=new JobReceiveInfoEntity();
		jobReceiveInfoEntity.setJobType(jobType);
		jobReceiveInfoEntity.setReceiveType(receiveType);
		jobReceiveInfoEntity.setReceiveTaskType(receiveTaskType);
		jobReceiveInfoEntity.setReceiveResult(receiveResult);
		//查询信息接收表该任务最新一次成功请求的时间戳
		Long maxtimestamp=this.iXxlJobDao.selectMaxtimestampByReveive(jobReceiveInfoEntity);
		if(maxtimestamp!=null){
			jobReceiveInfoEntity.setReceiveTimestamp(maxtimestamp);
			//根据时间戳查询上次请求信息
			return this.iXxlJobDao.selectReqByTimestamp(jobReceiveInfoEntity);
		}
		return null;
	}

	@Override
	public void getOrgList(String handlerName, String startTime, String endTime) throws Exception {
		for (int i = 1; i <= 5; i++) {
			String result = this.smpConsumer.getOrglist("UCMP", Integer.toString(i));
			Map<String, Object> paramMap=new HashMap<>();
			paramMap.put("channel", "UCMP");
			paramMap.put("orgType", Integer.toString(i));
			if(StringUtil.isNotEmpty(result)){
				SmpReturnDto<List<OrgDto>> returnDto=JsonBeanUtil.jsonToBean(result, SmpReturnDto.class);
				LOGGER.info("======returnDto==="+JsonBeanUtil.beanToJson(returnDto));
				addReceive(handlerName,endTime,returnDto.getData().size(),"01",result,paramMap);
			}
		}
	}

	private void addReceive(String handlerName, String endTime, Integer receiveCount, String receiveResult, 
			String result, Map<String, Object> paramMap) {
		Long partyId=AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
		LOGGER.info("=====addReceive=partyId==="+partyId);
		// 记录接收到的数据信息
		JobReceiveInfoEntity jobReceiveInfoEntity=new JobReceiveInfoEntity();
		jobReceiveInfoEntity.setCreatedBy(partyId);//待定
		jobReceiveInfoEntity.setJobType("smp");
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
		JobReceiveReqEntity jobReceiveReqEntity=new JobReceiveReqEntity();
		jobReceiveReqEntity.setCreatedBy(partyId);
		jobReceiveReqEntity.setReceiveReqData(JsonBeanUtil.beanToJson(paramMap));
		jobReceiveReqEntity.setReceiveId(jobReceiveInfoEntity.getReceiveId());
		jobReceiveReqEntity.setUpdatedBy(partyId);
		
		this.iJobReceiveReqDao.insert(jobReceiveReqEntity);
		
		//记录响应数据
		JobReceiveRspEntity jobReceiveRspEntity=new JobReceiveRspEntity();
		jobReceiveRspEntity.setCreatedBy(partyId);
		jobReceiveRspEntity.setReceiveId(jobReceiveInfoEntity.getReceiveId());
		jobReceiveRspEntity.setReceiveRspData(result);
		jobReceiveRspEntity.setUpdatedBy(partyId);
		
		this.iJobReceiveRspDao.insert(jobReceiveRspEntity);
	}

	@Override
	public void getStoreCodeList(String handlerName, String startTime, String endTime) throws Exception {
		ChannelStoreParamDto channelStoreParamDto = new ChannelStoreParamDto();
		channelStoreParamDto.setStoreMainType("S,D");
		Map<String, Object> params = Copiers.beanToMap(channelStoreParamDto);
		String result = this.channelConsumer.storeListEnabled(params);
		if(StringUtil.isNotEmpty(result)){
			SmpStoreReturnDto returnDto=JsonBeanUtil.jsonToBean(result, SmpStoreReturnDto.class);
			LOGGER.info("======SmpStoreReturnDto==="+JsonBeanUtil.beanToJson(returnDto));
			addReceive(handlerName,endTime,returnDto.getData().getStoreList().size(),"01",result,params);
		}
	}

}
