package com.exp.ucmp.apig.channel.web;


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

import com.egrid.core.copiers.Copiers;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.apig.channel.consumer.ChannelConsumer;
import com.exp.ucmp.smp.dto.SmpStoreReturnDto;
import com.exp.ucmp.store.dto.ChannelStoreParamDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * @author xiongneng
 * @date 2022年09月29日
 */
@Api(value = "ChannelApig.API", tags = "ChannelApig接口调试")
@RefreshScope
@Controller
public class ChannelController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ChannelController.class);
    
    @Autowired
    private ChannelConsumer channelConsumer;
    
    /**
     * <p>Description: 查询单个顾问信息以及上级信息</p>
     * @return 
     */
    @ApiOperation(value = "门店列表查询接口", notes = "查询组织下最新门店列表信息，不包含已经停用的门店", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/store/v1/list/enabled", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "channelStoreParamDto", value = "查询营销渠道门店列表参数类", required = false, paramType ="body", dataType = "ChannelStoreParamDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> storeListEnabled(@RequestBody ChannelStoreParamDto channelStoreParamDto) {
        try {
    		Map<String, Object> params = Copiers.beanToMap(channelStoreParamDto);
        	String result = channelConsumer.storeListEnabled(params);
    		return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    public static void main(String[] args) {
		String result="{\"code\":\"000000\",\"msg\":\"SUCCESS\",\"data\":{\"storeList\":[{\"id\":1548859268286500865,\"storeCode\":\"HS00061\",\"storeFullName\":\"高合体验店 HiPhi Hub（长沙岳麓）\",\"storeName\":\"长沙岳麓体验店\",\"sapCode\":\"800185\",\"storeStatus\":\"1\",\"storeType\":\"0\",\"storeMainType\":\"S\",\"storeServiceType\":\"H\",\"cpCode\":\"CP0021\",\"cpFullName\":\"高合（长沙）汽车销售服务有限责任公司\",\"orgId\":56,\"orgCode\":\"HH000056\",\"orgName\":\"长沙（S直营）\",\"province\":\"430000\",\"city\":\"430100\",\"district\":\"430104\",\"isClientShow\":\"1\",\"isReserveTestDrive\":\"1\",\"isReserveCustomerService\":\"0\",\"isEnable\":\"1\",\"creator\":\"SYSTEM\",\"modifier\":\"SYSTEM\",\"createTimestamp\":1685513946326,\"modifiedTimestamp\":1700793634851,\"smpStoreId\":\"1548859268286500865\"},{\"id\":263,\"storeCode\":\"HS00102\",\"storeFullName\":\"长沙运达汇\",\"storeName\":\"长沙运达汇体验店体验店\",\"storeNameEn\":\"\",\"sapCode\":\"\",\"storeStatus\":\"0\",\"storeType\":\"0\",\"storeMainType\":\"S\",\"storeServiceType\":\"H\",\"cpCode\":\"CP0068\",\"cpFullName\":\"自营店（虚拟）\",\"orgId\":131,\"orgCode\":\"HH000130\",\"orgName\":\"长沙（S合作直营）\",\"province\":\"430000\",\"city\":\"430100\",\"district\":\"430111\",\"isClientShow\":\"0\",\"isReserveTestDrive\":\"0\",\"isReserveCustomerService\":\"0\",\"isEnable\":\"1\",\"creator\":\"YanqingMo\",\"modifier\":\"SYSTEM\",\"createTimestamp\":1687861015649,\"modifiedTimestamp\":1700793635487,\"openingDate\":\"1693411200000\",\"smpStoreId\":\"263\"},{\"id\":3121420210325122275,\"storeCode\":\"HD00009\",\"storeFullName\":\"高合交付中心（长沙岳麓）\",\"storeName\":\"长沙交付中心\",\"sapCode\":\"H038\",\"storeStatus\":\"1\",\"storeType\":\"3\",\"storeMainType\":\"D\",\"storeServiceType\":\"H\",\"cpCode\":\"CP0021\",\"cpFullName\":\"高合（长沙）汽车销售服务有限责任公司\",\"orgId\":7150220210325756744,\"orgCode\":\"HH000196\",\"orgName\":\"长沙子公司（D） \",\"province\":\"430000\",\"city\":\"430100\",\"district\":\"430104\",\"isClientShow\":\"1\",\"isReserveTestDrive\":\"1\",\"isReserveCustomerService\":\"0\",\"isEnable\":\"1\",\"creator\":\"SYSTEM\",\"modifier\":\"SYSTEM\",\"createTimestamp\":1685513946326,\"modifiedTimestamp\":1700793635656,\"openingDate\":\"1685548800000\",\"smpStoreId\":\"3121420210325122275\"},{\"id\":1405052747136757761,\"storeCode\":\"HS00024\",\"storeFullName\":\"高合体验店 HiPhi Hub（长沙悦方ID MALL）\",\"storeName\":\"长沙悦方ID MALL\",\"sapCode\":\"800061\",\"storeStatus\":\"1\",\"storeType\":\"0\",\"storeMainType\":\"S\",\"storeServiceType\":\"H\",\"cpCode\":\"CP0021\",\"cpFullName\":\"高合（长沙）汽车销售服务有限责任公司\",\"orgId\":56,\"orgCode\":\"HH000056\",\"orgName\":\"长沙（S直营）\",\"province\":\"430000\",\"city\":\"430100\",\"district\":\"430103\",\"isClientShow\":\"0\",\"isReserveTestDrive\":\"1\",\"isReserveCustomerService\":\"0\",\"isEnable\":\"1\",\"creator\":\"SYSTEM\",\"modifier\":\"SYSTEM\",\"createTimestamp\":1685513946326,\"modifiedTimestamp\":1700793635851,\"smpStoreId\":\"1405052747136757761\"},{\"id\":218,\"storeCode\":\"PD00019\",\"storeFullName\":\"高合交付中心（长沙益达)\",\"storeName\":\"高合交付中心（长沙益达)\",\"storeNameEn\":\"\",\"sapCode\":\"\",\"storeStatus\":\"0\",\"storeType\":\"3\",\"storeMainType\":\"D\",\"storeServiceType\":\"P\",\"cpCode\":\"CP0053\",\"cpFullName\":\"长沙市骏威汽车销售服务有限公司\",\"orgId\":7150220210325756744,\"orgCode\":\"HH000196\",\"orgName\":\"长沙子公司（D） \",\"province\":\"430000\",\"city\":\"430100\",\"district\":\"430121\",\"isClientShow\":\"0\",\"isReserveTestDrive\":\"0\",\"isReserveCustomerService\":\"0\",\"isEnable\":\"1\",\"creator\":\"YanqingMo\",\"modifier\":\"SYSTEM\",\"createTimestamp\":1687309281412,\"modifiedTimestamp\":1699514483860,\"openingDate\":\"1696003200000\",\"smpStoreId\":\"218\"},{\"id\":1515941424850403329,\"storeCode\":\"HS00054\",\"storeFullName\":\"高合快闪店HiPhi POP（长沙大悦城）\",\"storeName\":\"长沙大悦城快闪店\",\"sapCode\":\"800175\",\"storeStatus\":\"1\",\"storeType\":\"1\",\"storeMainType\":\"S\",\"storeServiceType\":\"H\",\"cpCode\":\"CP0021\",\"cpFullName\":\"高合（长沙）汽车销售服务有限责任公司\",\"orgId\":56,\"orgCode\":\"HH000056\",\"orgName\":\"长沙（S直营）\",\"province\":\"430000\",\"city\":\"430100\",\"district\":\"430105\",\"isClientShow\":\"1\",\"isReserveTestDrive\":\"1\",\"isReserveCustomerService\":\"0\",\"isEnable\":\"1\",\"creator\":\"SYSTEM\",\"modifier\":\"SYSTEM\",\"createTimestamp\":1685513946326,\"modifiedTimestamp\":1700793636016,\"smpStoreId\":\"1515941424850403329\"},{\"id\":216,\"storeCode\":\"PS00038\",\"storeFullName\":\"高合用户中心（长沙益达)\",\"storeName\":\"高合用户中心（长沙益达)\",\"storeNameEn\":\"\",\"sapCode\":\"\",\"storeStatus\":\"0\",\"storeType\":\"7\",\"storeMainType\":\"S\",\"storeServiceType\":\"P\",\"cpCode\":\"CP0053\",\"cpFullName\":\"长沙市骏威汽车销售服务有限公司\",\"orgId\":131,\"orgCode\":\"HH000130\",\"orgName\":\"长沙（S合作直营）\",\"province\":\"430000\",\"city\":\"430100\",\"district\":\"430121\",\"isClientShow\":\"0\",\"isReserveTestDrive\":\"0\",\"isReserveCustomerService\":\"0\",\"isEnable\":\"1\",\"creator\":\"YanqingMo\",\"modifier\":\"SYSTEM\",\"createTimestamp\":1687309147799,\"modifiedTimestamp\":1699514664164,\"openingDate\":\"1696003200000\",\"smpStoreId\":\"216\"},{\"id\":219,\"storeCode\":\"PS00039\",\"storeFullName\":\"高合体验店Hiphi Hub（长沙益达)\",\"storeName\":\"高合体验店Hiphi Hub（长沙益达)\",\"storeNameEn\":\"\",\"sapCode\":\"\",\"storeStatus\":\"0\",\"storeType\":\"0\",\"storeMainType\":\"S\",\"storeServiceType\":\"P\",\"cpCode\":\"CP0053\",\"cpFullName\":\"长沙市骏威汽车销售服务有限公司\",\"orgId\":131,\"orgCode\":\"HH000130\",\"orgName\":\"长沙（S合作直营）\",\"province\":\"430000\",\"city\":\"430100\",\"district\":\"430104\",\"isClientShow\":\"0\",\"isReserveTestDrive\":\"0\",\"isReserveCustomerService\":\"0\",\"isEnable\":\"1\",\"creator\":\"YanqingMo\",\"modifier\":\"SYSTEM\",\"createTimestamp\":1687309397804,\"modifiedTimestamp\":1699514664648,\"openingDate\":\"1690732800000\",\"smpStoreId\":\"219\"}]}}";
		SmpStoreReturnDto returnDto=JsonBeanUtil.jsonToBean(result, SmpStoreReturnDto.class);
		LOGGER.info("======SmpStoreReturnDto==="+JsonBeanUtil.beanToJson(returnDto.getData().getStoreList()));
	}
}
