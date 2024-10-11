package com.exp.ucmp.keywords.web;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.entity.SysKeyWordEntity;
import com.exp.ucmp.keywords.dto.KeyWordsDto;
import com.exp.ucmp.keywords.service.KeyWordsService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * @date 2023年02月20日
 */
@Api(value = "关键字服务", tags = "关键字服务")
@RefreshScope
@Controller
public class KeyWordsController {
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(KeyWordsController.class);

	@Autowired
	private KeyWordsService keyWordsService;
		
	@ApiOperation(value = "查询关键字列表", notes = "查询关键字列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/key/word/list", method = RequestMethod.GET)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "keyWordsType", value = "关键字类型", required = true, paramType ="query", dataType = "Integer")})
	@JsonPropFilter(type = SysKeyWordEntity.class)
	public RestResponse<List<SysKeyWordEntity>> getKeyWordsList(@RequestParam Integer keyWordsType) {
		try {
			List<SysKeyWordEntity> result = keyWordsService.getKeyWordsList(keyWordsType);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	@ApiOperation(value = "添加关键字", notes = "添加关键字", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/key/word/add", method = RequestMethod.POST)
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "dto", value = "添加关键字实体类", required = true, paramType ="body", dataType = "KeyWordsDto")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> addKeyWords(@RequestBody KeyWordsDto dto) {
		LOGGER.info("======添加关键字===="+JsonBeanUtil.beanToJson(dto));
		try {
			keyWordsService.addKeyWords(dto);
			return new RestResponse<>();
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
}
