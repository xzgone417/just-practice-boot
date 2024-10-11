package com.exp.ucmp.apig.tsp.consumer;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.AbstractConsumer;
import com.exp.ucmp.tsp.dto.RegAndLoginDto;

@Component
public class TspConsumer extends AbstractConsumer{

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TspConsumer.class);
    
    @Autowired
    private TspProperties tspProperties;
    
    private static final String ENCODING = "UTF-8";
    
    private static final String HMAC_SHA = "HmacSHA256";
    
    protected enum TspEnum { 
    	// 二手车系统查询车辆、车况信息及激活数据
    	queryVehicleBasicInfo("/vehicle-core-data-service/api/v1/vehicle-foreign-open/queryVehicleBasicInfo/v1.0.0"),
    	//二手车系统查询车辆累计里程
    	queryVehicleStatus("/vehicle-dynamic-data-service/api/v1/custom/vehicle/status/1.0.0"),
    	//sign测试
    	testSign("/instance/v1/keyword"),
    	//手机号直接注册登入
    	mobilePhoneRegAndLogin("/idmc-service/registry/mobilePhoneRegAndLogin/1.1.0");

        private String url;

        private TspEnum(String value) {
            this.url = value;
        }
        
        public String url() {
            return this.url;
		}
	}
    
    public String queryVehicleBasicInfo(String vin) throws Exception{
    	String cqsString="querySource="+percentEncode("1")+"&vin="+percentEncode(vin);
    	Long timestamp = getTimestamp();
    	String sign=this.signGet(cqsString,timestamp,TspEnum.queryVehicleBasicInfo.url);
    	
    	String url=tspProperties.getUri() + TspEnum.queryVehicleBasicInfo.url+"?querySource=1&vin="+vin;
    	LOGGER.info("===queryVehicleBasicInfo的url="+url);
        HttpGet httpGet = new HttpGet(url);
        this.httpRequestGet(httpGet,sign,timestamp);

        CloseableHttpClient hp = HttpClientBuilder.create().build();
        CloseableHttpResponse res = hp.execute(httpGet);
        HttpEntity responseEntity = res.getEntity();
        String responseStr = null;
        if (responseEntity != null) {
            responseStr = StringEscapeUtils.unescapeJava(EntityUtils.toString(responseEntity));
            LOGGER.info("TSP二手车系统查询车辆、车况信息及激活数据返回信息：" + responseStr);
        }
        return responseStr;
    }
    
	public String queryVehicleStatus(Map<String,Object> paramsMap) throws Exception{
    	paramsMap.put("businessCode", tspProperties.getBusinessCode());
    	String cqsString=JsonBeanUtil.beanToJson(paramsMap);
    	Long timestamp = getTimestamp();
    	String sign=this.signPost(cqsString,timestamp,TspEnum.queryVehicleStatus.url);
    	
    	String url=tspProperties.getUri() + TspEnum.queryVehicleStatus.url;
    	LOGGER.info("===queryVehicleStatus的url="+url);
        HttpPost httpPost = new HttpPost(url);
        this.httpRequestPost(httpPost,sign,timestamp);

        httpPost.setEntity(new StringEntity(cqsString, ContentType.create("application/json", "UTF-8")));
        CloseableHttpClient hp = HttpClientBuilder.create().build();
        CloseableHttpResponse res = hp.execute(httpPost);
        HttpEntity responseEntity = res.getEntity();
        String responseStr = null;
        if (responseEntity != null) {
            responseStr = StringEscapeUtils.unescapeJava(EntityUtils.toString(responseEntity));
            LOGGER.info("TSP二手车系统查询车辆累计里程返回信息:" + responseStr);
        }
        return responseStr;
    }
    
    public String mobilePhoneRegAndLogin(RegAndLoginDto regAndLoginDto) throws Exception {
    	Map<String,Object> paramsMap=new HashMap<>();
    	paramsMap.put("mobilePhone", regAndLoginDto.getMobilePhone());
    	paramsMap.put("level1Code", tspProperties.getLevel1Code());
    	paramsMap.put("level2Code", tspProperties.getLevel2Code());
    	String cqsString=JsonBeanUtil.beanToJson(paramsMap);
    	Long timestamp = getTimestamp();
    	String sign=this.signPost(cqsString,timestamp,TspEnum.mobilePhoneRegAndLogin.url);
    	
    	String url=tspProperties.getUri() + TspEnum.mobilePhoneRegAndLogin.url;
    	LOGGER.info("===mobilePhoneRegAndLogin的url="+url);
        HttpPost httpPost = new HttpPost(url);
        this.httpRequestPost(httpPost,sign,timestamp);

        httpPost.setEntity(new StringEntity(cqsString, ContentType.create("application/json", "UTF-8")));
        CloseableHttpClient hp = HttpClientBuilder.create().build();
        CloseableHttpResponse res = hp.execute(httpPost);
        HttpEntity responseEntity = res.getEntity();
        String responseStr = null;
        if (responseEntity != null) {
            responseStr = StringEscapeUtils.unescapeJava(EntityUtils.toString(responseEntity));
            LOGGER.info("手机号直接注册登入返回信息:" + responseStr);
        }
        return responseStr;
	}
    
    private void httpRequestGet(HttpGet httpGet, String sign, Long timestamp) {
    	httpGet.setHeader("Content-Type", "application/json;charset=utf-8");
        httpGet.setHeader("channel", "UCMP");
        httpGet.setHeader("sign", sign);
        httpGet.setHeader("timestamp", timestamp.toString());
        httpGet.setHeader("accessKeyId", tspProperties.getAccessKeyId());
	}
    
    private void httpRequestPost(HttpPost httpPost, String sign, Long timestamp) {
    	httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        httpPost.setHeader("channel", "UCMP");
        httpPost.setHeader("sign", sign);
        httpPost.setHeader("timestamp", timestamp.toString());
        httpPost.setHeader("accessKeyId", tspProperties.getAccessKeyId());
	}
    
    private String signGet(String cqsString, Long timestamp, String url) throws Exception {
    	String headerToSign="accessKeyId="+tspProperties.getAccessKeyId()+"&timestamp="+timestamp;
    	String stringToSign= url + "&" + headerToSign + "&" + cqsString;
    	LOGGER.info("===tsp-mobilePhoneRegAndLogin-stringToSign==="+stringToSign);
    	return getBase64Signature(tspProperties.getAccessSecret(),stringToSign);
	}


	private String signPost(String cqsString, Long timestamp, String url) throws Exception {
    	String headerToSign="accessKeyId="+tspProperties.getAccessKeyId()+"&timestamp="+timestamp;
    	String stringToSign= url + "&" + headerToSign + "&null&" + cqsString;
    	LOGGER.info("===tsp-mobilePhoneRegAndLogin-stringToSign==="+stringToSign);
    	return getBase64Signature(tspProperties.getAccessSecret(),stringToSign);
	}

	public static void main(String[] args) throws Exception {
    	String cqsString="querySource="+percentEncode("1")+"&vin="+percentEncode("wsdhieshkhjdiwh");
    	String headerToSign="accessKeyId=testId&timestamp=1569317257000";
    	String stringToSign=TspEnum.testSign.url + "&" + headerToSign + "&" + cqsString;
    	LOGGER.info("==stringToSign=="+stringToSign);
    	String sign=getBase64Signature("testSecret",stringToSign);
    	LOGGER.info("==sign=="+sign);
	}
    
    private Long getTimestamp(){
		return System.currentTimeMillis();
    }
    
    private static String percentEncode(String value) throws UnsupportedEncodingException {
    	return value!=null?URLEncoder.encode(value, ENCODING).replace("+", "%20").replace("*","%2A").replace("%7E", "~"):null;
    }
    
    public static String getBase64Signature(String privateKey, String stringToSign) throws Exception {
	     byte[] signature = getSignature(privateKey, stringToSign);
	     return Base64.getEncoder().encodeToString(signature);
    }
    
     public static byte[] getSignature(String privateKey, String stringToSign) throws Exception {
    	 return getSignature(privateKey.getBytes(ENCODING),  stringToSign.getBytes(ENCODING));
    }
     
     public static byte[] getSignature(byte[] privateKey, byte[] stringToSign) throws Exception {
	     Mac mac = Mac.getInstance(HMAC_SHA);
	     mac.init(new SecretKeySpec(privateKey, 0, privateKey.length, HMAC_SHA ));
	     return mac.doFinal(stringToSign);
     }
}
