package com.exp.ucmp.notice.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.utils.StringUtils;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.huawei.dto.RelationNumDto;
import com.exp.ucmp.huawei.dto.VoiceBundRelationDto;
import com.exp.ucmp.huawei.dto.VoiceCallDto;
import com.exp.ucmp.huawei.dto.VoiceCallbackDto;
import com.exp.ucmp.notice.dao.VoiceDao;
import com.exp.ucmp.notice.properties.HuaweiVoiceProperties;
import com.exp.ucmp.notice.service.VoiceService;
import com.exp.ucmp.notice.utils.HttpUtil;
import com.exp.ucmp.util.AesUtils;

@Service
public class VoiceSerivceImpl implements VoiceService{
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(VoiceSerivceImpl.class);
    
    @Autowired
    private HuaweiVoiceProperties huaweiVoiceProperties;
    
    @Autowired
    private UcmpAesConfig ucmpAesConfig;
    
    @Autowired
    private VoiceDao voiceDao;
    
    protected enum VoiceEnum { 
    	relationnumber("/rest/caas/relationnumber/partners/v1.0"),
    	axbStopCall("/rest/httpsessions/callStop/v2.0"),
    	axbGetRecordDownloadLink("/rest/provision/voice/record/v1.0"),
    	axbUnbindNumber("/rest/caas/relationnumber/partners/v1.0"),
    	axbModifyNumber("/rest/caas/relationnumber/partners/v1.0"),
    	axbQueryBindRelation("/rest/caas/relationnumber/partners/v1.0");

		private String url;

		private VoiceEnum(String value) {
			this.url = value;
		}

		public String url() {
			return this.url;
		}
	}
    
    public enum EventType{ 
    	//华为云语音通知事件类型
    	callin("callin"),//呼入事件
    	callout("callout"),//呼出事件
    	alerting("alerting"),//振铃事件
    	answer("answer"),//应答事件
    	disconnect("disconnect");//挂机事件
        private String value;

        public String value() {
            return this.value;
        }

        EventType(String value) {
            this.value = value;
        }
    }
    
    /**
     * 绑定虚拟号码
     * @return 
     * @throws Exception 
     * 
     */
    @Override
	public RelationNumDto voiceCall(VoiceCallDto voiceCallDto) throws Exception {
    	if(StringUtils.isEmpty(voiceCallDto.getCalled())){
    		//根据预约单号查询客户手机号
    		String called = this.voiceDao.getCalledPhone(voiceCallDto);
    		voiceCallDto.setCalled(called);
    	}
    	voiceCallDto.setCalled(AesUtils.decryptHex(voiceCallDto.getCalled(), ucmpAesConfig.getSecret()));
    	if(voiceCallDto.getCallerIsEn()==1){
    		voiceCallDto.setCaller(AesUtils.decryptHex(voiceCallDto.getCaller(), ucmpAesConfig.getSecret()));
    	}
    	String cityAreaCode=huaweiVoiceProperties.getCityAreaCode();
    	Map<String,String> areaCodeMap=JsonBeanUtil.jsonToBean(cityAreaCode, HashMap.class);
    	String relationnumberStr=huaweiVoiceProperties.getRelationNum();
    	LOGGER.info("===relationnumberStr==="+relationnumberStr);
    	List<String> relationnumberList= Arrays.asList(relationnumberStr.split(","));
    	//查询主叫号码与被叫号码是否存在绑定关系
    	for (String rela : relationnumberList) {
    		String bindRelation = this.axbQueryBindRelation(null, rela, voiceCallDto.getCaller(), voiceCallDto.getCalled(), null, null);
    		Map<String,String> voiceBundMap=JsonBeanUtil.jsonToBean(bindRelation, HashMap.class);
    		if(!"1012007".equals(voiceBundMap.get("resultcode")) && !"1010002".equals(voiceBundMap.get("resultcode"))){
    			VoiceBundRelationDto dto = JsonBeanUtil.jsonToBean(bindRelation, VoiceBundRelationDto.class);
    			if(dto.getTotalCount()>0){
    				return dto.getRelationNumList().get(0);
    			}
    		}
		}
    	
    	String cityId=null;
    	String relationnumber=null;
    	if(voiceCallDto.getPartnerStaffPartyId()==null){
    		//查询门店城市
	    	 cityId = this.voiceDao.selectCityByDepartmentId(voiceCallDto.getDepartmentId());
    	}else{
    		//查询车商城市
    		List<String> cityList=this.voiceDao.selectCityByPartyId(voiceCallDto.getPartnerStaffPartyId());
    		if(cityList !=null && !cityList.isEmpty()){
    			cityId = cityList.get(0);
    		}
    	}
    	
    	String result;
    	String areaCode=null;
    	if(!StringUtils.isEmpty(cityId)){
    		areaCode=areaCodeMap.get(cityId);
    		LOGGER.info("====绑定虚拟号码areaCode===="+areaCode);
    		if(StringUtils.isEmpty(areaCode)){
    			relationnumber=getRelationnumber(relationnumberList);
    		}
    	}else{
    		relationnumber=getRelationnumber(relationnumberList);
    		LOGGER.info("====绑定虚拟号码relationnumber===="+relationnumber);
    	}
    	String userData = voiceCallDto.getReservationId()+"_"+voiceCallDto.getCalled();
    	result = this.relationnumber(voiceCallDto.getCaller(), voiceCallDto.getCalled(),areaCode, relationnumber,userData);
    	
    	Map<String,String> resultMap=JsonBeanUtil.jsonToBean(result, HashMap.class);
    	if("0".equals(resultMap.get("resultcode"))){
    		RelationNumDto relationNumDto = JsonBeanUtil.jsonToBean(result, RelationNumDto.class);
    		return relationNumDto;
    	}else{
    		return null;
    	}
	}
    
    private String getRelationnumber(List<String> relationnumberList){
    	Random ra=new Random();
    	int index=ra.nextInt(4);
    	LOGGER.info("====index==="+index);
		return relationnumberList.get(index);
    }
    
    public static void main(String[] args) {
		String secret="JC3x2hZiNp";
//		LOGGER.info("========"+AesUtils.encryptHex("13325799234", secret));
		LOGGER.info("========"+AesUtils.encryptHex("13783505096", secret));
    	/*Random ra=new Random();
    	for (int i = 0; i < 1000; i++) {
			int index=ra.nextInt(4);
			LOGGER.info("====index==="+index);
		}*/
	}
    
    /**
     * 过滤非数字
     * @param str
     * @return
     */
    public static String getNumeric(String str) {
        String regEx="[^0-9]";  
        Pattern p = Pattern.compile(regEx);  
        Matcher m = p.matcher(str);  
        return m.replaceAll("").trim();
    }

	@Override
	public Map<String, String> axbUnbindNumber(VoiceCallDto voiceCallDto) throws Exception {
		String result = this.axbUnbindNumber(voiceCallDto.getSubscriptionId(), null);
		Map<String,String> resultMap=JsonBeanUtil.jsonToBean(result, HashMap.class);
    	return resultMap;
	}
	
	@Override
	public Map<String, String> axbQueryBindRelation(VoiceCallDto voiceCallDto) throws Exception {
		String result = this.axbQueryBindRelation(voiceCallDto.getSubscriptionId(), voiceCallDto.getRelationNum(),
				voiceCallDto.getCaller(),voiceCallDto.getCalled(),voiceCallDto.getPageIndex(),voiceCallDto.getPageSize());
		Map<String,String> resultMap=JsonBeanUtil.jsonToBean(result, HashMap.class);
		return resultMap;
	}
    
    @Override
	public void stopCall(String sessionid) throws Exception {
    	//
    	this.axbStopCall(sessionid);
    	//
    	this.axbUnbindNumber(null, null);
	}
    
    /**
     * 号码绑定,即调用AXB模式绑定接口
     * 
     * @param callerNum
     * @param calleeNum
     * @param areaCode 
     * @param relationnumber 
     * @return 
     * @throws Exception 
     */
	public String relationnumber(String callerNum, String calleeNum, String areaCode, String relationnumber,String userData) throws Exception {
		if (StringUtils.isBlank(callerNum) || StringUtils.isBlank(calleeNum)) {
			LOGGER.error("relationnumber set params error");
			throw new Exception("callerNum,calleeNum不能为空");
        }

        // 必填,AXB模式绑定接口访问URI
        String url = huaweiVoiceProperties.getUri()+VoiceEnum.relationnumber.url;

        // 封装JOSN请求
        JSONObject json = new JSONObject();
        if(!StringUtils.isEmpty(relationnumber)){
          json.put("relationNum", relationnumber); // X号码(关系号码)
        }
        json.put("callerNum", "+86"+callerNum); // A方真实号码(手机或固话)
        json.put("calleeNum", "+86"+calleeNum); // B方真实号码(手机或固话)
        if(!StringUtils.isEmpty(areaCode)){
        	json.put("areaCode", areaCode); //城市码
        }
        json.put("duration", huaweiVoiceProperties.getDuration()); //绑定关系保持时间
        
        json.put("userData", userData);

        /**
         * 选填,各参数要求请参考"AXB模式绑定接口"
         */
//         json.put("areaCode", "0755"); //城市码
//         json.put("areaMatchMode", "1"); //号码筛选方式
//         json.put("callDirection", 0); //允许呼叫的方向
//         json.put("recordFlag", false); //是否通话录音
//         json.put("recordHintTone", "recordHintTone.wav"); //录音提示音
//         json.put("maxDuration", 60); //单次通话最长时间
//         json.put("lastMinVoice", "lastMinVoice.wav"); //通话最后一分钟提示音
//         json.put("privateSms", true); //是否支持短信功能
//         JSONObject preVoice = new JSONObject();
//         preVoice.put("callerHintTone", "callerHintTone.wav"); //设置A拨打X号码时的通话前等待音
//         preVoice.put("calleeHintTone", "calleeHintTone.wav"); //设置B拨打X号码时的通话前等待音
//         json.put("preVoice", preVoice); //个性化通话前等待音

        String result = HttpUtil.sendPost(huaweiVoiceProperties.getAppKey(), huaweiVoiceProperties.getAppSecret(), url, json.toString());
        LOGGER.info("Response is :" + result);
        return result;
	}

	/**
	 * 用户通过隐私号码发起呼叫后,商户可随时终止一路呼叫,即调用终止呼叫接口
	 * 
	 * @param sessionid
	 */
	public void axbStopCall(String sessionid) {
		if (StringUtils.isBlank(sessionid)) {
            LOGGER.info("axbStopCall set params error");
            return;
        }

        // 必填,AXB模式终止呼叫接口访问URI
        String url = huaweiVoiceProperties.getUri()+VoiceEnum.axbStopCall.url;

        // 封装JOSN请求
        JSONObject json = new JSONObject();
        json.put("sessionid", sessionid); // 呼叫会话ID
        json.put("signal", "call_stop"); // 取值固定为"call_stop"

        String result = HttpUtil.sendPost(huaweiVoiceProperties.getAppKey(), huaweiVoiceProperties.getAppSecret(), url, json.toString());
        LOGGER.info("Response is :" + result);
    }
	
	/**
	 * 用户通话结束,若设置录音,则商户可以获取录音文件下载地址,即调用获取录音文件下载地址接口
	 * 
	 * @param recordDomain
	 * @param fileName
	 */
	public void axbGetRecordDownloadLink(String recordDomain, String fileName) {
        if (StringUtils.isBlank(recordDomain) || StringUtils.isBlank(fileName)) {
        	LOGGER.info("axbGetRecordDownloadLink set params error");
            return;
        }
        // 必填,AXB模式获取录音文件下载地址接口访问URI
        String url = huaweiVoiceProperties.getUri()+VoiceEnum.axbGetRecordDownloadLink.url;

        // 申明对象
        Map<String, Object> map = new HashMap<>();
        map.put("recordDomain", recordDomain); // 录音文件存储的服务器域名
        map.put("fileName", fileName); // 录音文件名

        String result = HttpUtil.sendGet(huaweiVoiceProperties.getAppKey(), huaweiVoiceProperties.getAppSecret(), url, HttpUtil.map2UrlEncodeString(map));
        LOGGER.info("Response is :" + result);
    }
	
	/**
	 * 根据业务需求,可更改绑定关系,即调用AXB模式绑定信息修改接口
	 * 
	 * @param subscriptionId
	 * @param callerNum
	 * @param calleeNum
	 */
	public void axbModifyNumber(String subscriptionId, String callerNum, String calleeNum) {
        if (StringUtils.isBlank(subscriptionId)) {
            LOGGER.info("axbModifyNumber set params error");
            return;
        }

        // 必填,AXB模式绑定信息修改接口访问URI
        String url = huaweiVoiceProperties.getUri()+VoiceEnum.axbModifyNumber.url;

        // 封装JOSN请求
        JSONObject json = new JSONObject();
        json.put("subscriptionId", subscriptionId); // 绑定关系ID
        if (!StringUtils.isBlank(callerNum)) {
            json.put("callerNum", callerNum); // 将A方修改为新的号码(手机或固话)
        }
        if (!StringUtils.isBlank(calleeNum)) {
            json.put("calleeNum", calleeNum); // 将B方修改为新的号码(手机或固话)
        }

        /**
         * 选填,各参数要求请参考"AXB模式绑定信息修改接口"
         */
//         json.put("callDirection", 0); //允许呼叫的方向
//         json.put("duration", 86400); //绑定关系保持时间
//         json.put("maxDuration", 90); //单次通话最长时间
//         json.put("lastMinVoice", "lastMinVoice.wav"); //通话最后一分钟提示音
//         json.put("privateSms", true); //是否支持短信功能
//         json.put("recordFlag", false); //是否通话录音
//         JSONObject preVoice = new JSONObject();
//         preVoice.put("callerHintTone", "callerHintTone.wav"); //设置A拨打X号码时的通话前等待音
//         preVoice.put("calleeHintTone", "calleeHintTone.wav"); //设置B拨打X号码时的通话前等待音
//         json.put("preVoice", preVoice); //个性化通话前等待音

        String result = HttpUtil.sendPut(huaweiVoiceProperties.getAppKey(), huaweiVoiceProperties.getAppSecret(), url, json.toString());
        LOGGER.info("Response is :" + result);
    }
	
	/**
	 * 隐私号码循环使用,商户可将绑定关系解绑,即调用AXB模式解绑接口
	 * 
	 * @param subscriptionId
	 * @param relationNum
	 * @return 
	 * @throws Exception 
	 */
	public String axbUnbindNumber(String subscriptionId, String relationNum) throws Exception {
        if (StringUtils.isBlank(subscriptionId) && StringUtils.isBlank(relationNum)) {
        	LOGGER.info("axbUnbindNumber set params error");
        	throw new Exception("subscriptionId不能为空");
        }

        // 必填,AXB模式解绑接口访问URI
        String url = huaweiVoiceProperties.getUri()+VoiceEnum.axbUnbindNumber.url;

        // 申明对象
        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isBlank(subscriptionId)) {
            map.put("subscriptionId", subscriptionId); // 绑定关系ID
        } else {
            map.put("relationNum", relationNum); // X号码(关系号码)
        }

        String result = HttpUtil.sendDelete(huaweiVoiceProperties.getAppKey(), huaweiVoiceProperties.getAppSecret(), url, HttpUtil.map2UrlEncodeString(map));
        LOGGER.info("Response is :" + result);
        return result;
    }
	
	/**
	 * 商户可查询已订购的隐私号码的绑定信息,即调用AXB模式绑定信息查询接口
	 * 
	 * @param subscriptionId
	 * @param relationNum
	 * @throws Exception 
	 */
	public String axbQueryBindRelation(String subscriptionId, String relationNum,String callerNum,String calleeNum,Integer pageIndex,Integer pageSize) throws Exception {
        if (StringUtils.isBlank(subscriptionId) && StringUtils.isBlank(relationNum)) {
            LOGGER.info("axbQueryBindRelation set params error");
            throw new Exception("subscriptionId,relationNum不能同时为空");
        }

        // 必填,AXB模式绑定信息查询接口访问URI
        String url = huaweiVoiceProperties.getUri()+ VoiceEnum.axbQueryBindRelation.url;

        // 申明对象
        Map<String, Object> map = new HashMap<>();
        if (!StringUtils.isBlank(subscriptionId)) {
            map.put("subscriptionId", subscriptionId); // 绑定关系ID
        } else {
            map.put("relationNum", relationNum); // X号码(关系号码)
        } 
        
        if(!StringUtils.isEmpty(callerNum)){
            map.put("callerNum", "+86"+callerNum); // X号码(关系号码)
        } 
        
        if(!StringUtils.isEmpty(calleeNum)){
            map.put("calleeNum", "+86"+calleeNum); // X号码(关系号码)
        } 
        
        if(pageIndex !=null){
        	map.put("pageIndex", 1); //查询的分页索引,从1开始编号
        }
        
        if(pageSize != null){
        	map.put("pageSize", 20); //查询的分页大小,即每次查询返回多少条数据
        }
        LOGGER.info("====map==="+JsonBeanUtil.beanToJson(map));
        String result = HttpUtil.sendGet(huaweiVoiceProperties.getAppKey(), huaweiVoiceProperties.getAppSecret(), url, HttpUtil.map2UrlEncodeString(map));
        LOGGER.info("Response is :" + result);
        return result;
    }

	@Override
	public void callback(VoiceCallbackDto voiceCallbackDto) throws Exception {
		//呼入事件
		if(EventType.callin.value().equals(voiceCallbackDto.getEventType())){
			LOGGER.info("=====呼入事件====="+JsonBeanUtil.beanToJson(voiceCallbackDto));
		}
		// 呼出事件
		if(EventType.callout.value().equals(voiceCallbackDto.getEventType())){
			LOGGER.info("=====呼出事件====="+JsonBeanUtil.beanToJson(voiceCallbackDto));
			//记录呼出事件数据
			voiceCallbackDto.getStatusInfo().setRecordId(RandomIDGennerator.get().generate());
			this.voiceDao.addCallOutInfo(voiceCallbackDto.getStatusInfo());
		}
		
		if(EventType.disconnect.value().equals(voiceCallbackDto.getEventType())){
			LOGGER.info("=====挂机事件====="+JsonBeanUtil.beanToJson(voiceCallbackDto));
			this.axbUnbindNumber(voiceCallbackDto.getStatusInfo().getSubscriptionId(), voiceCallbackDto.getStatusInfo().getRelationNum());
		}
	}

	@Override
	public Boolean callOutInfo(Long reservationId) throws Exception {
		//根据置换id查询门店顾问电话
		String calledEn=this.voiceDao.getStoreCalledPhone(reservationId);
		if(StringUtil.isEmpty(calledEn)){
			throw new Exception("查询门店顾问电话失败");
		}
		String called = AesUtils.decryptHex(calledEn, ucmpAesConfig.getSecret());
		String userData = reservationId+"_"+called;
		int count=this.voiceDao.countRecord(userData);
		if(count == 0){
			return false;
		}else{
			return true;
		}
	}

}
