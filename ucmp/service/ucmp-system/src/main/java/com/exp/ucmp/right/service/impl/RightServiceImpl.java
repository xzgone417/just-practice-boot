package com.exp.ucmp.right.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.urc.consumer.UrcConsumer;
import com.exp.ucmp.right.service.RightService;
import com.exp.ucmp.urc.dto.RightPackSaveDto;
import com.exp.ucmp.urc.dto.RightsGrantDto;
import com.exp.ucmp.urc.dto.UrcReturnDto;

@Service
public class RightServiceImpl implements RightService {

	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(RightServiceImpl.class);

	@Autowired
	private UrcConsumer urcConsumer;
	
	/*protected enum UrcCode { 
		// URC接口
		success("000000"), 
		paramError("002000");

		private String value;

		private UrcCode(String value) {
			this.value = value;
		}

		public String value() {
			return this.value;
		}
	}*/

	@Override
	public List<Map<String, Object>> rightQueryByCondition(String rightTypeName, String grantType, String modelCode, String shapeCode)
			throws Exception {
		String result = this.urcConsumer.rightQueryByCondition(rightTypeName, grantType);
		LOGGER.info("====获取权益主数据=result=" + result);
		if (StringUtil.isNotEmpty(result)) {
			UrcReturnDto<List<Map<String,Object>>> returnDto = JsonBeanUtil.jsonToBean(result, UrcReturnDto.class);
			LOGGER.info("====returnDto==="+JsonBeanUtil.beanToJson(returnDto.getData()));
			if(Integer.parseInt(returnDto.getCode())==0){
				SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date nowDate = new Date();
				List<Map<String, Object>> list = returnDto.getData();
				List<Map<String, Object>> returnList =new ArrayList<>();
				if (list != null && !list.isEmpty()) {
					for (Map<String, Object> map : list) {
						map.put("subTypeName", map.get("subtypeName"));
						map.remove("subtypeName");
						// 筛选权益状态为已启用的
						if (Integer.parseInt(map.get("status").toString()) == 1) {
							// 有效期限制为区间时间时判断当前时间是否在有效期,其它有效期限制不用判断
							if (Integer.parseInt(map.get("timeless").toString()) == 2) {
								if (form.parse(map.get("effectTime").toString()).compareTo(nowDate) <= 0
										&& form.parse(map.get("expireTime").toString()).compareTo(nowDate) >= 0) {
									//判断是否关联车型
									if(Integer.parseInt(map.get("relatedModels").toString())==0){
										//判断工程车型代码是否匹配
										if(StringUtil.isNotEmpty(modelCode)&&modelCode.equals(map.get("modelCode").toString())){
											//判断基础车型代码是否为空或者匹配
											if(StringUtil.isEmpty(shapeCode)||map.get("shapeCode") == null
													||shapeCode.equals(map.get("shapeCode").toString())){
												returnList.add(map);
											}
										}else if(StringUtil.isEmpty(modelCode)){
											returnList.add(map);
										}
									}else{
										returnList.add(map);
									}
								}
							} else {
								//判断是否关联车型
								if(Integer.parseInt(map.get("relatedModels").toString())==0){
									//判断工程车型代码是否匹配
									if(StringUtil.isNotEmpty(modelCode)&& map.get("modelCode") !=null&&modelCode.equals(map.get("modelCode").toString())){
										//判断基础车型代码是否为空或者匹配
										if(StringUtil.isEmpty(shapeCode)||map.get("shapeCode") == null
												||shapeCode.equals(map.get("shapeCode").toString())){
											returnList.add(map);
										}
									}else if(StringUtil.isEmpty(modelCode)){
										returnList.add(map);
									}
								}else{
									returnList.add(map);
								}
							}
						}
					}
				}
				return returnList;
			}else{
				throw new Exception(returnDto.getMsg());	
			}
		} else {
			throw new Exception("获取权益主数据异常");
		}
			
	}

	@Override
	public Long rightPackSave(@Valid RightPackSaveDto rightPackSaveDto) throws Exception {
		String result = this.urcConsumer.rightPackSave(rightPackSaveDto);
		LOGGER.info("====权益包创建=result=" + result);
		if (StringUtil.isNotEmpty(result)) {
			UrcReturnDto<Object> returnDto = JsonBeanUtil.jsonToBean(result, UrcReturnDto.class);
			if(Integer.parseInt(returnDto.getCode())==0){
				return Long.parseLong(returnDto.getData().toString());
			}else{
				throw new Exception(returnDto.getMsg());
			}
		} else {
			throw new Exception("权益包创建");
		}
	}

	@Override
	public Long rightsGrant(@Valid RightsGrantDto rightsGrantDto) throws Exception {
		String result = this.urcConsumer.rightsGrant(rightsGrantDto);
		LOGGER.info("====权益发放=result=" + result);
		if (StringUtil.isNotEmpty(result)) {
			UrcReturnDto<Object> returnDto = JsonBeanUtil.jsonToBean(result, UrcReturnDto.class);
			if(Integer.parseInt(returnDto.getCode())==0){
				return Long.parseLong(returnDto.getData().toString());
			}else{
				throw new Exception(returnDto.getMsg());
			}
		} else {
			throw new Exception("权益发放");
		}
	}
	

}
