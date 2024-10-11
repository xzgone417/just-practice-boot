package com.exp.ucmp.apig.esb.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.apig.esb.consumer.EmdmConsumer;
import com.exp.ucmp.emdm.dto.AreaDataDto;
import com.exp.ucmp.emdm.dto.DeptDto;
import com.exp.ucmp.emdm.dto.EmdmAreaReturnDto;
import com.exp.ucmp.emdm.dto.EmdmDeptReturnDto;
import com.exp.ucmp.emdm.dto.EmdmReturnDto;
import com.exp.ucmp.emdm.dto.ModelParamDto;
import com.exp.ucmp.emdm.dto.PersonDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * @author xiongneng
 * @date 2022年07月12日
 */
@Api(value = "EmdmApig.API", tags = "EmdmApig接口调试")
@RefreshScope
@Controller
public class EmdmController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmdmController.class);
    
    @Autowired
	private EmdmConsumer emdmConsumer;
    

    /**
     * <p>Description: 测试JWT</p>
     * @return 用户档案
     */
    @ApiOperation(value = "jwtvalid", notes = "jwtvalid", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/emdm/jwt", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> getEmdmPersonInfo() {
        try {
        	String result = emdmConsumer.jwtvalid();
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 人员信息同步</p>
     * @return 用户档案
     */
    @ApiOperation(value = "EMDM(人员信息同步)", notes = "人员信息同步", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/emdm/getEmdmPersonInfo", method = RequestMethod.GET)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "targetSysId", value = "调用系统名称", required = true, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "startTime", value = "开始时间", required = false, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "endTime", value = "结束时间", required = false, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "hhrEmpid", value = "人员编号", required = false, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "iscPersonId", value = "ISC人员ID", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = PersonDto.class)
    public RestResponse<List<PersonDto> > getEmdmPersonInfo(@RequestParam(value="targetSysId", required=true) String targetSysId,
    		@RequestParam(value="startTime", required=false) String startTime,@RequestParam(value="endTime", required=false) String endTime,
    		@RequestParam(value="hhrEmpid", required=false) String hhrEmpid,@RequestParam(value="iscPersonId", required=false) String iscPersonId) {
        try {
        	Map<String,Object> paramMap=new HashMap<>();
        	paramMap.put("targetSysId", targetSysId);
        	if(startTime !=null){
        		paramMap.put("startTime", startTime);
        	}
        	if(endTime != null){
        		paramMap.put("endTime", endTime);
        	}
        	if(StringUtil.isNotEmpty(hhrEmpid)){
        		paramMap.put("hhrEmpid", hhrEmpid);
        	}
        	if(StringUtil.isNotEmpty(iscPersonId)){
        		paramMap.put("iscPersonId", iscPersonId);
        	}

        	String result = emdmConsumer.getEmdmPersonInfo(paramMap);
        	EmdmReturnDto emdmReturnDto=JsonBeanUtil.jsonToBean(result, EmdmReturnDto.class);
            return new RestResponse<>(emdmReturnDto.getData());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    public static void main(String[] args) {
		String result="{\"total\":8,\"code\":\"S\",\"data\":[{\"hhrEducationExperience\":\"\",\"dispatchInfoList\":null,\"hhrStatus\":\"N\",\"hhrCompanyNameZh\":\"上海华延人力资源管理有限公司\",\"lastUpdateDate\":\"2019-12-04 19:51:26\",\"hhrRankCode\":\"G09\",\"hhrTerminationDate\":\"2019-03-23\",\"hhrPerBiographicalAttr09\":\"\",\"hhrOtherContact\":\"\",\"idmAccountName\":null,\"hhrImg\":\"15c48c132ec544379bfd363da3f5089e\",\"hhrDeptZhName\":\"\",\"hhrOrgDeptAttr04\":\"华人运通（江苏）技术有限公司\",\"hhrEndDate\":\"1900-01-01 00:00:00\",\"hhrDeptCode\":\"696\",\"hhrEmpid\":\"H000060\",\"hhrOrgDeptAttr02\":\"\",\"hhrOrgDeptAttr03\":\"上海\",\"hhrLocation\":\"SHANGHAI\",\"hhrPerBiographicalAttr14\":\"\",\"hhrPositionCode\":\"200778\",\"hhrPerBiographicalAttr15\":\"\",\"hhrPerBiographicalAttr12\":\"\",\"hhrPerArchivesAttr15\":\"\",\"hhrPerBiographicalAttr13\":\"\",\"hhrFirstworkingDate\":\"2007-07-01\",\"version\":3,\"hhrDirectEmpid\":\"\",\"hhrSaleStar\":\"\",\"hhrCompanyEffeDate\":\"2017-01-01 00:00:00\",\"hhrPerArchivesAttr13\":\"\",\"hhrCompanyCode\":\"H015\",\"idmUserTypeName\":null,\"hhrEmpRcd\":\"1\",\"hhrCompanyNameEn\":\"Shanghai Huayan Human Resource Management Co., Ltd.\",\"idmEmail\":null,\"hhrQyWeixin\":\"H000060\",\"hhrOrgCompanyAttr08\":\"886859042205\",\"hhrOrgCompanyAttr05\":\"\",\"hhrOrgPosnAttr06\":\"否\",\"hhrCompanyStatus\":\"有效\",\"hhrOrgCompanyAttr04\":\"445574277071\",\"hhrOrgPosnAttr05\":\"否\",\"hhrOrgCompanyAttr07\":\"01104258\",\"hhrOrgPosnAttr04\":\"办公室\",\"hhrOtherName\":\"Liangxu LI\",\"hhrEmpClass\":\"10\",\"hhrPosnLocation\":\"上海\",\"hhrDeptManagerPosition\":\"\",\"hhrEffeDate\":\"2019-03-23 00:00:00\",\"hhrGender\":\"M\",\"iscPersonId\":null,\"hhrOrgCompanyAttr01\":\"中国银行\",\"hhrOrgPosnAttr02\":\"正式员工\",\"hhrOrgCompanyAttr03\":\"中国银行上海大连路支行\",\"hhrOrgCompanyAttr02\":\"91310230MA1JYTML2J\",\"hhrName\":\"李良旭\",\"hhrIndirectEmpid\":\"\",\"hhrFirstEntryTime\":\"\"},{\"hhrEducationExperience\":\"本科\",\"dispatchInfoList\":null,\"hhrStatus\":\"N\",\"hhrCompanyNameZh\":\"华人运通（江苏）技术有限公司上海分公司 \",\"lastUpdateDate\":\"2019-12-04 19:52:23\",\"hhrRankCode\":\"G06\",\"hhrTerminationDate\":\"2019-11-13\",\"hhrPerBiographicalAttr09\":\"\",\"hhrOtherContact\":\"\",\"idmAccountName\":\"QingdongZhang\",\"hhrImg\":\"15c48c132ec544379bfd363da3f5089e\",\"hhrDeptZhName\":\"\",\"hhrOrgDeptAttr04\":\"华人运通（江苏）技术有限公司\",\"hhrEndDate\":\"1900-01-01 00:00:00\",\"hhrDeptCode\":\"1546\",\"hhrEmpid\":\"H000862\",\"hhrOrgDeptAttr02\":\"\",\"hhrOrgDeptAttr03\":\"上海\",\"hhrLocation\":\"SHANGHAI\",\"hhrPerBiographicalAttr14\":\"\",\"hhrPositionCode\":\"200854\",\"hhrPerBiographicalAttr15\":\"\",\"hhrPerBiographicalAttr12\":\"\",\"hhrPerArchivesAttr15\":\"\",\"hhrPerBiographicalAttr13\":\"\",\"hhrFirstworkingDate\":\"2001-09-01\",\"version\":3,\"hhrDirectEmpid\":\"\",\"hhrSaleStar\":\"\",\"hhrCompanyEffeDate\":\"2017-01-01 00:00:00\",\"hhrPerArchivesAttr13\":\"\",\"hhrCompanyCode\":\"H003\",\"idmUserTypeName\":\"正式员工\",\"hhrEmpRcd\":\"1\",\"hhrCompanyNameEn\":\"Human Horizons (Jiangsu) Technology Co.,Ltd. Shanghai Branch\",\"idmEmail\":\"qingdong_zhang@human-horizons.com\",\"hhrQyWeixin\":\"H000862\",\"hhrOrgCompanyAttr08\":\"887805035205\",\"hhrOrgCompanyAttr05\":\"\",\"hhrOrgPosnAttr06\":\"否\",\"hhrCompanyStatus\":\"有效\",\"hhrOrgCompanyAttr04\":\"435177019403\",\"hhrOrgPosnAttr05\":\"否\",\"hhrOrgCompanyAttr07\":\"01241625\",\"hhrOrgPosnAttr04\":\"办公室\",\"hhrOtherName\":\"Qingdong ZHANG\",\"hhrEmpClass\":\"10\",\"hhrPosnLocation\":\"上海\",\"hhrDeptManagerPosition\":\"\",\"hhrEffeDate\":\"2019-11-13 00:00:00\",\"hhrGender\":\"M\",\"iscPersonId\":null,\"hhrOrgCompanyAttr01\":\"中国农业银行\",\"hhrOrgPosnAttr02\":\"正式员工\",\"hhrOrgCompanyAttr03\":\"中国银行上海市分行\",\"hhrOrgCompanyAttr02\":\"91310110MA1G8WTN7B\",\"hhrName\":\"张庆东\",\"hhrIndirectEmpid\":\"\",\"hhrFirstEntryTime\":\"\"},{\"hhrEducationExperience\":\"本科\",\"dispatchInfoList\":null,\"hhrStatus\":\"N\",\"hhrCompanyNameZh\":\"华人运通（江苏）技术有限公司上海分公司 \",\"lastUpdateDate\":\"2019-12-04 19:52:22\",\"hhrRankCode\":\"G04\",\"hhrTerminationDate\":\"2019-11-28\",\"hhrPerBiographicalAttr09\":\"\",\"hhrOtherContact\":\"\",\"idmAccountName\":\"YunlongShi\",\"hhrImg\":\"15c48c132ec544379bfd363da3f5089e\",\"hhrDeptZhName\":\"\",\"hhrOrgDeptAttr04\":\"华人运通（江苏）技术有限公司\",\"hhrEndDate\":\"1900-01-01 00:00:00\",\"hhrDeptCode\":\"791\",\"hhrEmpid\":\"H000853\",\"hhrOrgDeptAttr02\":\"\",\"hhrOrgDeptAttr03\":\"上海\",\"hhrLocation\":\"SHANGHAI\",\"hhrPerBiographicalAttr14\":\"\",\"hhrPositionCode\":\"200853\",\"hhrPerBiographicalAttr15\":\"\",\"hhrPerBiographicalAttr12\":\"\",\"hhrPerArchivesAttr15\":\"\",\"hhrPerBiographicalAttr13\":\"\",\"hhrFirstworkingDate\":\"2011-07-01\",\"version\":3,\"hhrDirectEmpid\":\"\",\"hhrSaleStar\":\"\",\"hhrCompanyEffeDate\":\"2017-01-01 00:00:00\",\"hhrPerArchivesAttr13\":\"\",\"hhrCompanyCode\":\"H003\",\"idmUserTypeName\":\"正式员工\",\"hhrEmpRcd\":\"1\",\"hhrCompanyNameEn\":\"Human Horizons (Jiangsu) Technology Co.,Ltd. Shanghai Branch\",\"idmEmail\":\"yunlong_shi@human-horizons.com\",\"hhrQyWeixin\":\"H000853\",\"hhrOrgCompanyAttr08\":\"887805035205\",\"hhrOrgCompanyAttr05\":\"\",\"hhrOrgPosnAttr06\":\"否\",\"hhrCompanyStatus\":\"有效\",\"hhrOrgCompanyAttr04\":\"435177019403\",\"hhrOrgPosnAttr05\":\"否\",\"hhrOrgCompanyAttr07\":\"01241625\",\"hhrOrgPosnAttr04\":\"办公室\",\"hhrOtherName\":\"Yunlong SHI\",\"hhrEmpClass\":\"10\",\"hhrPosnLocation\":\"上海\",\"hhrDeptManagerPosition\":\"\",\"hhrEffeDate\":\"2019-11-28 00:00:00\",\"hhrGender\":\"M\",\"iscPersonId\":null,\"hhrOrgCompanyAttr01\":\"中国农业银行\",\"hhrOrgPosnAttr02\":\"正式员工\",\"hhrOrgCompanyAttr03\":\"中国银行上海市分行\",\"hhrOrgCompanyAttr02\":\"91310110MA1G8WTN7B\",\"hhrName\":\"施云龙\",\"hhrIndirectEmpid\":\"\",\"hhrFirstEntryTime\":\"\"},{\"hhrEducationExperience\":\"硕士\",\"dispatchInfoList\":null,\"hhrStatus\":\"N\",\"hhrCompanyNameZh\":\"华人运通（江苏）技术有限公司\",\"lastUpdateDate\":\"2019-12-04 19:52:10\",\"hhrRankCode\":\"G09\",\"hhrTerminationDate\":\"2019-10-17\",\"hhrPerBiographicalAttr09\":\"\",\"hhrOtherContact\":\"\",\"idmAccountName\":\"XuanmingDing\",\"hhrImg\":\"15c48c132ec544379bfd363da3f5089e\",\"hhrDeptZhName\":\"\",\"hhrOrgDeptAttr04\":\"华人运通（江苏）技术有限公司\",\"hhrEndDate\":\"1900-01-01 00:00:00\",\"hhrDeptCode\":\"677\",\"hhrEmpid\":\"H000043\",\"hhrOrgDeptAttr02\":\"\",\"hhrOrgDeptAttr03\":\"上海\",\"hhrLocation\":\"SHANGHAI\",\"hhrPerBiographicalAttr14\":\"\",\"hhrPositionCode\":\"200838\",\"hhrPerBiographicalAttr15\":\"\",\"hhrPerBiographicalAttr12\":\"\",\"hhrPerArchivesAttr15\":\"\",\"hhrPerBiographicalAttr13\":\"\",\"hhrFirstworkingDate\":\"2009-02-01\",\"version\":3,\"hhrDirectEmpid\":\"\",\"hhrSaleStar\":\"\",\"hhrCompanyEffeDate\":\"2017-01-01 00:00:00\",\"hhrPerArchivesAttr13\":\"\",\"hhrCompanyCode\":\"H001\",\"idmUserTypeName\":\"正式员工\",\"hhrEmpRcd\":\"1\",\"hhrCompanyNameEn\":\"Human Horizons (Jiangsu) Technology Co.,Ltd.\",\"idmEmail\":\"Xuanming_Ding@human-horizons.com\",\"hhrQyWeixin\":\"H000043\",\"hhrOrgCompanyAttr08\":\"120190011311\",\"hhrOrgCompanyAttr05\":\"J310009300401\",\"hhrOrgPosnAttr06\":\"否\",\"hhrCompanyStatus\":\"有效\",\"hhrOrgCompanyAttr04\":\"10429201040218676\",\"hhrOrgPosnAttr05\":\"否\",\"hhrOrgCompanyAttr07\":\"10273055\",\"hhrOrgPosnAttr04\":\"办公室\",\"hhrOtherName\":\"Xuanming DING\",\"hhrEmpClass\":\"10\",\"hhrPosnLocation\":\"上海\",\"hhrDeptManagerPosition\":\"\",\"hhrEffeDate\":\"2019-10-17 00:00:00\",\"hhrGender\":\"M\",\"iscPersonId\":null,\"hhrOrgCompanyAttr01\":\"中国农业银行\",\"hhrOrgPosnAttr02\":\"正式员工\",\"hhrOrgCompanyAttr03\":\"农业银行盐城新都支行\",\"hhrOrgCompanyAttr02\":\"91320991MA1R5TD96A\",\"hhrName\":\"丁烜明\",\"hhrIndirectEmpid\":\"\",\"hhrFirstEntryTime\":\"\"}]}";
		EmdmReturnDto emdmReturnDto=JsonBeanUtil.jsonToBean(result, EmdmReturnDto.class);
		LOGGER.info("==emdmReturnDto===="+JsonBeanUtil.beanToJson(emdmReturnDto.getData()));
	}
    
    /**
     * <p>Description: 行政区划信息查询</p>
     * @return 上牌城市
     */
    @ApiOperation(value = "获取上牌城市", notes = "获取上牌城市(目前假数据，数据结构和字段后续会有调整)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/emdm/getRegisteredCity", method = RequestMethod.GET)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "targetSysId", value = "调用系统名称", required = true, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "startTime", value = "开始时间", required = false, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "endTime", value = "结束时间", required = false, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "areaCode", value = "省市区编码", required = false, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "cityCode", value = "电话区号", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<AreaDataDto> getRegisteredCity(@RequestParam(value="targetSysId", required=true) String targetSysId,
    		@RequestParam(value="startTime", required=false) String startTime,@RequestParam(value="endTime", required=false) String endTime,
    		@RequestParam(value="areaCode", required=false) String areaCode,@RequestParam(value="cityCode", required=false) String cityCode,
    		@RequestParam(value="pageIndex", required=false) Integer pageIndex,@RequestParam(value="pageSize", required=false) Integer pageSize) {
        try {
//        	String result = "[{\"provinceId\":\"1010\",\"provinceName\":\"上海市\",\"cities\":[{\"cityId\":\"1011\",\"cityName\":\"上海\"}]},{\"provinceId \":\"1020\",\"provinceName\":\"江苏省\",\"cities\":[{\"cityId\":\"1021\",\"cityName\":\"南京\"},{\"cityId\":\"1022\",\"cityName\":\"苏州\"},{\"cityId\":\"1023\",\"cityName\":\"无锡\"}]}]";
        	Map<String,Object> paramMap=new HashMap<>();
        	paramMap.put("targetSysId", targetSysId);
        	if(startTime !=null){
        		paramMap.put("startTime", startTime);
        	}
        	if(endTime != null){
        		paramMap.put("endTime", endTime);
        	}
        	if(StringUtil.isNotEmpty(areaCode)){
        		paramMap.put("areaCode", areaCode);
        	}
        	if(StringUtil.isNotEmpty(cityCode)){
        		paramMap.put("cityCode", cityCode);
        	}
        	
        	paramMap.put("pageIndex", pageIndex);
        	paramMap.put("pageSize", pageSize);
        	
        	String result = this.emdmConsumer.getEmdmAreaInfo(paramMap);
            EmdmAreaReturnDto returnDto=JsonBeanUtil.jsonToBean(result, EmdmAreaReturnDto.class);
        	return new RestResponse<>(returnDto.getData());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 部门信息</p>
     * @return 部门信息
     */
    @ApiOperation(value = "获取部门信息", notes = "部门信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/emdm/getDeptInfo", method = RequestMethod.GET)
    @ApiOperationSupport(order = 4)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<DeptDto>> getEmdmDeptInfo(@RequestParam(value="targetSysId", required=true) String targetSysId,
    		@RequestParam(value="startTime", required=false) String startTime,@RequestParam(value="endTime", required=false) String endTime,
    		@RequestParam(value="hhrDeptCode", required=false) String hhrDeptCode) {
        try {
        	Map<String,Object> paramMap=new HashMap<>();
        	paramMap.put("targetSysId", targetSysId);
        	paramMap.put("pageIndex", 1);
        	paramMap.put("pageSize", 1000);

        	if(StringUtil.isNotEmpty(startTime)){
        		paramMap.put("startTime", startTime);
        	}
        	if(StringUtil.isNotEmpty(endTime)){
        		paramMap.put("endTime", endTime);
        	}
        	if(StringUtil.isNotEmpty(hhrDeptCode)){
        		paramMap.put("areaCode", hhrDeptCode);
        	}
        	
            String result = this.emdmConsumer.getEmdmDeptInfo(paramMap);
            EmdmDeptReturnDto returnDto=JsonBeanUtil.jsonToBean(result, EmdmDeptReturnDto.class);
            
        	return new RestResponse<>(returnDto.getData());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 车型信息</p>
     * @return 车型信息
     */
    @ApiOperation(value = "获取车型信息", notes = "车型信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/emdm/getEmdmModelInfo", method = RequestMethod.POST)
    @ApiImplicitParams({
		@ApiImplicitParam(name = "modelParamDto", value = "权益包创建参数类", required = true, paramType = "body", dataType = "ModelParamDto")})
    @ApiOperationSupport(order = 4)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> getEmdmModelInfo(@RequestBody @Valid ModelParamDto modelParamDto) {
        try {
        	Map<String,Object> paramMap=Copiers.beanToBean(modelParamDto, ModelParamDto.class, HashMap.class);
        	paramMap.put("targetSysId", modelParamDto.getTargetSysId());
    		LOGGER.info("===paramMap==="+JsonBeanUtil.beanToJson(paramMap));
            String result = this.emdmConsumer.getEmdmModelInfo(paramMap);
//            EmdmDeptReturnDto returnDto=JsonBeanUtil.jsonToBean(result, EmdmDeptReturnDto.class);
            
        	return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
