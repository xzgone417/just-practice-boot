package com.exp.ucmp.apig.usc.consumer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.AbstractConsumer;
import com.exp.ucmp.usc.dto.CreateEvaluationDto;
import com.exp.ucmp.util.UcmpUtils;

@Component
public class UscConsumer extends AbstractConsumer {
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UscConsumer.class);

	@Autowired
	private UscProperties uscProperties;

	protected enum UscEnum { // URM接口
		evaluation("/api/evaluate/"), 
		createEvaluation("/createEvaluation"),
		notifyEvaluation("/notifyEvaluation"),
		getEvaluationDetail("/getEvaluationDetail");

		private String url;

		private UscEnum(String value) {
			this.url = value;
		}

		public String url() {
			return this.url;
		}
	}

	/**
	 * 创建评价单
	 * 
	 * @param channel
	 * @param orgType
	 * @return
	 * @throws Exception
	 */
	public String createEvaluation(CreateEvaluationDto dto) throws Exception {
		dto.setCategoryCode(uscProperties.getCategoryCode());
		//
		dto.setTraceId(this.buildUrcTraceId());
		String dtoStr = JsonBeanUtil.beanToJson(dto);
		Map<String, Object> paramMap = JsonBeanUtil.jsonToBean(dtoStr, HashMap.class);
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(uscProperties.getKey())
				.secret(uscProperties.getSecret())
				.mediaType(MediaType.APPLICATION_JSON).method("POST").url(uscProperties.getUri()
						+ UscEnum.evaluation.url + uscProperties.getChannleCode() + UscEnum.createEvaluation.url)
				.params(paramMap);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}
	
	/**
	 * 通知客户评价
	 * 
	 * @param channel
	 * @param orgType
	 * @return
	 * @throws Exception
	 */
	public String notifyEvaluation(String businessNo) throws Exception {
		String url=uscProperties.getUri()+UscEnum.evaluation.url + uscProperties.getChannleCode() + UscEnum.notifyEvaluation.url;
		url+=("?businessNo="+businessNo+"&traceId="+this.buildUrcTraceId()+"&categoryCode="+uscProperties.getCategoryCode());
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(uscProperties.getKey())
				.secret(uscProperties.getSecret())
				.mediaType(MediaType.APPLICATION_JSON).method("GET").url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}

	/**
	 * 
	 * 查询评价详情
	 * 
	 * @param businessNo 业务编码
	 * @param traceId 事务Id
	 * @return
	 * @throws Exception
	 */
	public String getEvaluationDetail(String businessNo) throws Exception {
		String categoryCode = uscProperties.getCategoryCode();

		String url = uscProperties.getUri() + UscEnum.evaluation.url + uscProperties.getChannleCode()
				+ UscEnum.getEvaluationDetail.url + "?businessNo=" + businessNo + "&traceId=" + buildUrcTraceId() + "&categoryCode="
				+ categoryCode;

		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(uscProperties.getKey())
				.secret(uscProperties.getSecret()).mediaType(MediaType.APPLICATION_JSON).method("GET").url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}
	
	private String buildUrcTraceId() {
		SimpleDateFormat form = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = form.format(new Date());
		return "uscCommentsService-"+ date + "-" + UcmpUtils.generateRandomNumber(5);
	}
	
	public static void main(String[] args) {
		SimpleDateFormat form = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = form.format(new Date());
		LOGGER.info("=====dto="+"uscCommentsService-"+ date+"-" + UcmpUtils.generateRandomNumber(5));
	}

}
