package com.exp.ucmp.evaluate.service.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.usc.consumer.UscConsumer;
import com.exp.ucmp.evaluate.service.UscEvaluateService;
import com.exp.ucmp.usc.dto.CreateEvaluationDto;
import com.exp.ucmp.usc.dto.EvaluationDetailDto;
import com.exp.ucmp.usc.dto.EvaluationReturnDto;

@Service
public class UscEvaluateServiceImpl implements UscEvaluateService{
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UscEvaluateServiceImpl.class);

	@Autowired
    private UscConsumer uscConsumer;

	@Override
	public String createEvaluation(CreateEvaluationDto createEvaluationDto) throws Exception {
		String result=this.uscConsumer.createEvaluation(createEvaluationDto);
		LOGGER.info("=====createEvaluation==result====="+result);
		if(StringUtil.isNotEmpty(result)){
			EvaluationReturnDto<String> resultMap=JsonBeanUtil.jsonToBean(result, EvaluationReturnDto.class);
			if("000000".equals(resultMap.getCode())){
				return resultMap.getData();
			}else{
				throw new Exception(resultMap.getMsg());
			}
		}else{
			throw new Exception("创建评价单失败");
		}
	}

	@Override
	public EvaluationDetailDto getEvaluationDetail(String businessNo) throws Exception {
		String result=this.uscConsumer.getEvaluationDetail(businessNo);
		if(StringUtil.isNotEmpty(result)){
			EvaluationReturnDto<Object> resultDto=JsonBeanUtil.jsonToBean(result, EvaluationReturnDto.class);
			EvaluationDetailDto dto=JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(resultDto.getData()), EvaluationDetailDto.class);
			if("000000".equals(resultDto.getCode())){
				return dto;
			}else{
				throw new Exception(resultDto.getMsg());
			}
		}else{
			throw new Exception("查询评价详情失败");
		}
	}
	
	public static void main(String[] args) {
		String result="{\"code\":\"000000\",\"msg\":\"SUCCESS\",\"data\":{\"evaluateRecordId\":\"1583292095695224833\",\"evaluateCategoryId\":null,\"businessNo\":\"1234567890\",\"userId\":\"PA679363017986461696\",\"idmId\":null,\"level\":2,\"content\":\"测试\",\"createTime\":1666321226419,\"updateTime\":null,\"deleted\":null,\"statusNotificationSms\":0,\"statusNotificationApp\":1,\"status\":1,\"startTime\":null,\"endTime\":null,\"image\":null,\"video\":null,\"nickName\":\"ksail\",\"cityName\":null,\"servicePersonnelCode\":null,\"servicePersonnelName\":null,\"reward\":null,\"mobile\":\"15139125403\",\"vinNo\":null,\"materialCode\":null,\"materialName\":null,\"storeCode\":null,\"storeName\":null,\"serviceEndTime\":null,\"cityCode\":null,\"name\":null,\"platForm\":null,\"bigAreaCode\":null,\"bigAreaName\":null,\"tagBatchNo\":\"20221018-1\",\"questionBatchNo\":\"20220418-1\",\"stationId\":null,\"stationName\":null,\"equipmentId\":null,\"statusReport\":null,\"smsReceiptCode\":null,\"smsId\":null,\"statusForm\":null,\"evaluateCategory\":{\"evaluateCategoryId\":\"9\",\"categoryCode\":\"1004000\",\"channelCode\":\"S005\",\"channelName\":\"UCMP\",\"status\":1,\"createTime\":1665192346000,\"updateTime\":1666080323991,\"deleted\":false,\"maxLevel\":5,\"batchNo\":\"20221018-1\",\"editStatus\":1,\"feedbackStatus\":0},\"tagList\":[{\"tagId\":\"1582280240053997569\",\"name\":\"电话骚扰\",\"selected\":true,\"level\":null}],\"questionList\":[{\"evaluateCategoryQuestionId\":\"1473895961263861763\",\"evaluateCategoryId\":\"9\",\"type\":\"NPS\",\"conent\":\"您向自己的亲朋同事等推荐购买高合的可能性有多少？\",\"status\":1,\"createTime\":1666022400000,\"updateTime\":1666022400000,\"deleted\":false,\"answerOption\":null,\"answerOptionList\":[{\"code\":null,\"name\":\"3\",\"selected\":true}]}],\"categoryName\":null,\"parentCategoryName\":null,\"formLink\":null}}";
		EvaluationReturnDto<Object> resultDto=JsonBeanUtil.jsonToBean(result, EvaluationReturnDto.class);
		EvaluationDetailDto dto=JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(resultDto.getData()), EvaluationDetailDto.class);
		LOGGER.info("======resultDto===="+JsonBeanUtil.beanToJson(dto));
	}
}
