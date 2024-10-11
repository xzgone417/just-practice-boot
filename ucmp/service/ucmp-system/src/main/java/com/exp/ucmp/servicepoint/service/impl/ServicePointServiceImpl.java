package com.exp.ucmp.servicepoint.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.exp.ucmp.apig.isp.consumer.IspConsumer;
import com.exp.ucmp.isp.dto.IspSiteReturnDto;
import com.exp.ucmp.isp.dto.ServicePointDto;
import com.exp.ucmp.isp.dto.ServicePointTypeDto;
import com.exp.ucmp.servicepoint.dao.ServicePointDao;
import com.exp.ucmp.servicepoint.service.ServicePointService;

import cn.hutool.core.collection.CollectionUtil;

@Service
public class ServicePointServiceImpl implements ServicePointService{
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ServicePointServiceImpl.class);
	
	@Autowired
	private ServicePointDao servicePointDao;
	
	@Autowired
	private IspConsumer ispConsumer;

	@Override
	public List<ServicePointTypeDto> getPointType() {
		return this.servicePointDao.getPointType();
	}

	@Override
	public List<ServicePointDto> getPoint(String pointTypeCode, String pointName) throws Exception {
		Map<String, Object> paramMap=new HashMap<>();
		//网点类型
		List<String> siteTypes=new ArrayList<>();
		if(!StringUtil.isEmpty(pointTypeCode)){
			siteTypes.add(pointTypeCode);
		}else{
			List<ServicePointTypeDto> typeList = this.servicePointDao.getPointType();
			for (ServicePointTypeDto servicePointTypeDto : typeList) {
				siteTypes.add(servicePointTypeDto.getPointTypeCode());
			}
		}
		paramMap.put("siteTypes", siteTypes);
		//网点名称
		if(!StringUtil.isEmpty(pointName)){
			paramMap.put("siteName", pointName);
		}
		//营业状态
		paramMap.put("operatingStatus", "N");
		
		//调用ISP接口查询
		String result = ispConsumer.querySite(paramMap);
		LOGGER.info("====查询服务网点返回数据====="+result);
		IspSiteReturnDto returnDto = JsonBeanUtil.jsonToBean(result, IspSiteReturnDto.class);
		List<ServicePointDto> returnList=new ArrayList<>();
		if("200".equals(returnDto.getCode())&&CollectionUtil.isNotEmpty(returnDto.getData())){
			returnDto.getData().forEach(data ->{
				ServicePointDto pointDto=new ServicePointDto();
				pointDto.setPointCode(data.getSiteCode());
				pointDto.setPointName(data.getShortName());
				pointDto.setPointType(data.getSiteType());
				returnList.add(pointDto);
			});
		}
		return returnList;
	}

}
