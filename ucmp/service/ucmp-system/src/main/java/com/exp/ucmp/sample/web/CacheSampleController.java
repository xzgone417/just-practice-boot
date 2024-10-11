package com.exp.ucmp.sample.web;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

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
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.sample.dto.CacheReqDto;
import com.exp.ucmp.sample.dto.SampleParameterDto;
import com.exp.ucmp.sample.tools.cache.RedissonLockSample;
import com.exp.ucmp.sample.tools.cache.RedissonPublishSample;
import com.exp.ucmp.sample.tools.cache.RedissonSample;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "CacheSample.API", tags = "CacheSample样例接口")
@RefreshScope
@Controller
public class CacheSampleController {
	 /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CacheSampleController.class);

    @Autowired
    private RedissonSample redissonSample;
    
    @Autowired
    private RedissonPublishSample publishSample;
    
    @Autowired
    private RedissonLockSample lockSample;

    /**
     * Description: 设置缓存
     */
    @ApiOperation(value = "设置缓存(general)", notes = "设置缓存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/general", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1, includeParameters = {"cacheReqDto.key", "cacheReqDto.generalValue"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cacheReqDto", value = "参数信息", required = true, paramType ="body", dataType = "CacheReqDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> general(@RequestBody CacheReqDto cacheReqDto) {
        try {
        	redissonSample.general(cacheReqDto.getKey(), cacheReqDto.getGeneralValue());
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 获取缓存
     */
    @ApiOperation(value = "获取缓存(general)", notes = "获取缓存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/general", method = RequestMethod.GET)
    @ApiOperationSupport(order = 2)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> general(@RequestParam("key") String key) {
        try {
        	String result = redissonSample.general(key);
            return new RestResponse<>(RestStatusCode.OK, result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 设置缓存
     */
    @ApiOperation(value = "设置缓存(map)", notes = "设置缓存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/map", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3, includeParameters = {"type", "cacheReqDto.key", "cacheReqDto.mapValue"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型", required = true, paramType ="query", dataType = "String", allowableValues = "map,mapcache"), 
            @ApiImplicitParam(name = "cacheReqDto", value = "参数信息", required = true, paramType ="body", dataType = "CacheReqDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> map(@RequestParam("type") String type, @RequestBody CacheReqDto cacheReqDto) {
        try {
        	if (type.equals("map")) {
        		redissonSample.map(cacheReqDto.getKey(), cacheReqDto.getMapValue());
        	} else if (type.equals("mapcache")) {
        		redissonSample.mapcache(cacheReqDto.getKey(), cacheReqDto.getMapValue());
        	}
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 获取缓存
     */
    @ApiOperation(value = "获取缓存(map)", notes = "获取缓存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/map", method = RequestMethod.GET)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type", value = "类型", required = true, paramType ="query", dataType = "String", allowableValues = "map,mapcache"),
        @ApiImplicitParam(name = "key", value = "Key", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Map> map(@RequestParam("type") String type, @RequestParam("key") String key) {
        try {
        	Map result = null;
        	if (type.equals("map")) {
        		result = redissonSample.map(key);
        	} else if (type.equals("mapcache")) {
        		result = redissonSample.mapcache(key);
        	}
        	
            return new RestResponse<>(RestStatusCode.OK, result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 设置缓存
     */
    @ApiOperation(value = "设置缓存(multimap)", notes = "设置缓存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/multimap", method = RequestMethod.POST)
    @ApiOperationSupport(order = 5, includeParameters = {"type", "cacheReqDto.key", "cacheReqDto.multimapValue"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型", required = true, paramType ="query", dataType = "String", allowableValues = "set,setcache,list,listcache"), 
            @ApiImplicitParam(name = "cacheReqDto", value = "参数信息", required = true, paramType ="body", dataType = "CacheReqDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> multimap(@RequestParam("type") String type, @RequestBody CacheReqDto cacheReqDto) {
        try {
        	if (type.equals("set")) {
        		redissonSample.setMultimap(cacheReqDto.getKey(), cacheReqDto.getSetMultimapValue());
        	} else if (type.equals("setcache")) {
        		redissonSample.setMultimapCache(cacheReqDto.getKey(), cacheReqDto.getSetMultimapValue());
        	} else if (type.equals("list")) {
        		redissonSample.listMultimap(cacheReqDto.getKey(), cacheReqDto.getMultimapValue());
        	} else if (type.equals("listcache")) {
        		redissonSample.listMultimapCache(cacheReqDto.getKey(), cacheReqDto.getMultimapValue());
        	}
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 获取缓存
     */
    @ApiOperation(value = "获取缓存(multimap)", notes = "获取缓存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/multimap", method = RequestMethod.GET)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type", value = "类型", required = true, paramType ="query", dataType = "String", allowableValues = "set,setcache,list,listcache"),
        @ApiImplicitParam(name = "key", value = "Key", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Map> multimap(@RequestParam("type") String type, @RequestParam("key") String key) {
        try {
        	Map result = null;
        	if (type.equals("set")) {
        		result = redissonSample.setMultimap(key);
        	} else if (type.equals("setcache")) {
        		result = redissonSample.setMultimapCache(key);
        	} else if (type.equals("list")) {
        		result = redissonSample.listMultimap(key);
        	} else if (type.equals("listcache")) {
        		result = redissonSample.listMultimapCache(key);
        	}
        	
            return new RestResponse<>(RestStatusCode.OK, result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 设置缓存
     */
    @ApiOperation(value = "设置缓存(collection)", notes = "设置缓存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/collection", method = RequestMethod.POST)
    @ApiOperationSupport(order = 7, includeParameters = {"type", "cacheReqDto.key", "cacheReqDto.collectionValue"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "type", value = "类型", required = true, paramType ="query", dataType = "String", allowableValues = "set,setcache,list"), 
            @ApiImplicitParam(name = "cacheReqDto", value = "参数信息", required = true, paramType ="body", dataType = "CacheReqDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> collection(@RequestParam("type") String type, @RequestBody CacheReqDto cacheReqDto) {
        try {
        	if (type.equals("set")) {
        		redissonSample.set(cacheReqDto.getKey(), new HashSet(cacheReqDto.getCollectionValue()));
        	} else if (type.equals("setcache")) {
        		redissonSample.setCache(cacheReqDto.getKey(), new HashSet(cacheReqDto.getCollectionValue()));
        	} else if (type.equals("list")) {
        		redissonSample.list(cacheReqDto.getKey(), cacheReqDto.getCollectionValue());
        	} 
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 获取缓存
     */
    @ApiOperation(value = "获取缓存(collection)", notes = "获取缓存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/collection", method = RequestMethod.GET)
    @ApiOperationSupport(order = 8)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "type", value = "类型", required = true, paramType ="query", dataType = "String", allowableValues = "set,setcache,list"),
        @ApiImplicitParam(name = "key", value = "Key", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Collection> collection(@RequestParam("type") String type, @RequestParam("key") String key) {
        try {
        	Collection result = null;
        	if (type.equals("set")) {
        		result = redissonSample.set(key);
        	} else if (type.equals("setcache")) {
        		result = redissonSample.setCache(key);
        	} else if (type.equals("list")) {
        		result = redissonSample.list(key);
        	} 
        	
            return new RestResponse<>(RestStatusCode.OK, result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 设置缓存
     */
    @ApiOperation(value = "设置缓存(queue)", notes = "设置缓存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/queue", method = RequestMethod.POST)
    @ApiOperationSupport(order = 9, includeParameters = {"cacheReqDto.key", "cacheReqDto.collectionValue"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cacheReqDto", value = "参数信息", required = true, paramType ="body", dataType = "CacheReqDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> queue(@RequestBody CacheReqDto cacheReqDto) {
        try {
        	redissonSample.queue(cacheReqDto.getKey(), cacheReqDto.getCollectionValue());
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 获取缓存
     */
    @ApiOperation(value = "获取缓存(queue)", notes = "获取缓存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/queue", method = RequestMethod.GET)
    @ApiOperationSupport(order = 10)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "key", value = "Key", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Collection> queue(@RequestParam("key") String key) {
        try {
        	Collection result = redissonSample.queue(key);
        	
            return new RestResponse<>(RestStatusCode.OK, result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 设置缓存
     */
    @ApiOperation(value = "设置缓存(delayedQueue)", notes = "设置缓存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/delayedQueue", method = RequestMethod.POST)
    @ApiOperationSupport(order = 11, includeParameters = {"cacheReqDto.key", "cacheReqDto.delayedQueueValue"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cacheReqDto", value = "参数信息", required = true, paramType ="body", dataType = "CacheReqDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> delayedQueue(@RequestBody CacheReqDto cacheReqDto) {
        try {
        	redissonSample.delayedQueue(cacheReqDto.getKey(), cacheReqDto.getDelayedQueueValue());
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    

    /**
     * Description: 获取缓存
     */
    @ApiOperation(value = "设置并获取缓存(incrAnddecr)", notes = "设置并获取缓存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/incrAnddecr", method = RequestMethod.POST)
    @ApiOperationSupport(order = 12, includeParameters = {"type", "cacheReqDto.key", "cacheReqDto.numberValue"})
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "type", value = "类型", required = true, paramType ="query", dataType = "String", allowableValues = "incr,decr"),
        @ApiImplicitParam(name = "key", value = "Key", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Long> incrAnddecr(@RequestParam("type") String type, @RequestBody CacheReqDto cacheReqDto) {
        try {
        	Long result = null;
        	if (type.equals("incr")) {
        		result = redissonSample.incrBy(cacheReqDto.getKey(), cacheReqDto.getNumberValue().longValue());
        	} else if (type.equals("decr")) {
        		result = redissonSample.decrBy(cacheReqDto.getKey(), cacheReqDto.getNumberValue().longValue());
        	} 
            return new RestResponse<>(RestStatusCode.OK, result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    

    /**
     * Description: 消息发布
     */
    @ApiOperation(value = "发布消息(publish)", notes = "发布消息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/publish", method = RequestMethod.POST)
    @ApiOperationSupport(order = 13, ignoreParameters = {"parameterDto.createdBy", "parameterDto.createdDate"})
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "parameterDto", value = "参数信息", required = true, paramType ="body", dataType = "SampleParameterDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Long> publish(@RequestBody SampleParameterDto parameterDto) {
        try {
        	publishSample.publish(parameterDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    

    /**
     * Description: 锁，效果只能看日志
     */
    @ApiOperation(value = "锁(lock)", notes = "锁", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/cache/lock", method = RequestMethod.GET)
    @ApiOperationSupport(order = 14)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "type", value = "类型", required = true, paramType ="query", dataType = "String", allowableValues = "reentrant,fair,countdownlatch"),
    	@ApiImplicitParam(name = "lockName", value = "锁名", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Long> lock(@RequestParam("type") String type, @RequestParam("lockName") String lockName) {
        try {
        	lockSample.lock(type, lockName);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
