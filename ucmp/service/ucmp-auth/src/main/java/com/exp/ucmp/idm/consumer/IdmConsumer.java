package com.exp.ucmp.idm.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.para.esc.web.common.IdmOauthApi;
import com.para.esc.web.common.MD5Util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class IdmConsumer extends AbstractConsumer {
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(IdmConsumer.class);

	@Autowired
	private IdmProperties idmProperties;

	protected enum IdmEnum {
		// idm接口
		getTokenInfo("/profile/oauth2/accessToken"), 
		getUserInfo("/profile/oauth2/profile"), 
		sendSecurityCodeDto("/service/api/v1/mobile/sendSecurityCode"), 
		getAccessTokenBySMS("/service/api/v1/mobile/getAccessTokenBySMS"),
		getTokenByPwd("/service/api/v1/mobile/accessToken");

		private String url;

		private IdmEnum(String value) {
			this.url = value;
		}

		public String url() {
			return this.url;
		}
	}

	/*
	 * public String userProfilesQuery(Map<String, Object> m, String url) throws
	 * Exception {
	 * 
	 * RequestBuilder requestBuilder =
	 * RequestBuilder.getInstance().key("111").secret("222")
	 * .mediaType(MediaType.APPLICATION_JSON).method("POST") .url(url)
	 * .header("Connection", "Keep-Alive") .header("Authorization",
	 * "Basic c21lZGk6c21lZGk=") .header("Content-Type",
	 * "application/x-www-form-urlencoded") .params(m);
	 * LOGGER.info(requestBuilder.toString());
	 * 
	 * return sendRequest(requestBuilder.build()); }
	 */

	/**
	 * 获取idm token
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public String getTokenInfo(String code) throws Exception {
		String url = idmProperties.getIdmUri() + IdmEnum.getTokenInfo.url + "?client_id=" + idmProperties.getId()
				+ "&client_secret=" + idmProperties.getSecret() + "&redirect_uri="
				+ URLEncoder.encode(idmProperties.getCallbackUrl(), "UTF-8") + "&target_uri="
				+ idmProperties.getTargetUrl() + "&code=" + code;
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(idmProperties.getId())
				.secret(idmProperties.getSecret()).mediaType(MediaType.APPLICATION_JSON).method("GET").url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}

	/**
	 * 构建idm 登录认证地址
	 * 
	 * @return
	 * @throws Exception
	 */

	public String buildIdmUrl() throws Exception {
		String targetUri=URLEncoder.encode(idmProperties.getTargetUrl(), "UTF-8");
		String clientId = idmProperties.getId();
		String callbackUrl=URLEncoder.encode(idmProperties.getCallbackUrl(), "UTF-8");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String date = df.format(new Date());
    	String timestamp = Date2TimeStamp(date,"yyyy-MM-dd HH:mm:ss"); 
		if(StringUtil.isNotEmpty(targetUri)){
			targetUri=("&target_uri="+targetUri);
		}
		String url=idmProperties.getIdmUri()+"/profile/oauth2/authorize?client_id="+clientId+"&response_type=code&redirect_uri="+callbackUrl+"&oauth_timestamp="+timestamp+targetUri;
		LOGGER.info("===buildIdmUrl="+url);
        return url;
	}

	/**
	 * 获取idm sdk token
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public String getAccessTokenParam(String code) throws Exception {
		LOGGER.info("code --> " + code);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 璁剧疆鏃ユ湡鏍煎紡
		Map<String, Object> map = new HashMap<>();
		map.put("client_id", idmProperties.getId());
		map.put("client_secret", idmProperties.getSecret());
		map.put("nonce_str", UUID.randomUUID().toString());
		map.put("oauth_timestamp", df.format(new Date()));
		map.put("grant_type", "authorization_code");
		map.put("code", code);
		map.put("redirect_uri", URLEncoder.encode(idmProperties.getCallbackUrl(), "UTF-8"));
		String url = idmProperties.getIdmUri() + "/profile/oauth2/accessToken";

		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(idmProperties.getId())
				.secret(idmProperties.getSecret()).mediaType(MediaType.APPLICATION_JSON).method("POST").url(url)
				.header("Connection", "Keep-Alive").header("Authorization", "Basic c21lZGk6c21lZGk=")
				.header("Content-Type", "application/x-www-form-urlencoded").params(map);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}

	/**
	 * 获取idm用户信息
	 * 
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	public String getUserInfo(String accessToken) throws Exception {
		String url = idmProperties.getIdmUri() + IdmEnum.getUserInfo.url + "?access_token=" + accessToken;
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(idmProperties.getId())
				.secret(idmProperties.getSecret()).mediaType(MediaType.APPLICATION_JSON).method("GET").url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}

	/**
	 * 
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public String sendSecurityCodeDto(String mobile){
		String url = idmProperties.getIdmUri() + IdmEnum.sendSecurityCodeDto.url;
		LOGGER.info("==url=="+url);
		Map<String, Object> map = new HashMap<>();
		map.put("client_id", idmProperties.getAppletClientId());
		map.put("client_secret", idmProperties.getAppletSecretId());
		map.put("mobile", mobile);
		Long timestamp = System.currentTimeMillis();
		map.put("timestamp", timestamp);
		String nonceStr = UUID.randomUUID().toString();
		map.put("nonce_str", nonceStr);
		String sign = getSign(map, idmProperties.getAppkey() + idmProperties.getAppletSecretId());
		LOGGER.info("==sign=="+sign);
		map.put("sign", sign);
		return httpURLPOSTCase(JsonBeanUtil.beanToJson(map), url);
	}

	/**
	 * 移动端--小程序使用 短信验证码获取token
	 * 
	 * @param uid
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public String getAccessTokenBySMS(String uid, String pwd){
		String url = idmProperties.getIdmUri() + IdmEnum.getAccessTokenBySMS.url;
		String nonceStr = UUID.randomUUID().toString();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 璁剧疆鏃ユ湡鏍煎紡
		String date = df.format(new Date());
		String timestamp = Date2TimeStamp(date, "yyyy-MM-dd HH:mm:ss");
		Map<String, Object> map = new HashMap<>();
		map.put("client_id", idmProperties.getAppletClientId());
		map.put("client_secret", idmProperties.getAppletSecretId());
		map.put("nonce_str", nonceStr);
		map.put("pwd", pwd);
		map.put("timestamp", timestamp);
		map.put("uid", uid);
		String sign = getSign(map, idmProperties.getAppkey() + idmProperties.getAppletSecretId());
		LOGGER.info("==sign=="+sign);
		map.put("sign", sign);
		return httpURLPOSTCase(JsonBeanUtil.beanToJson(map), url);
	}
	
	/**
	 * 移动端--小程序使用 密码获取token
	 * 
	 * @param uid
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public String getTokenByPwd(String uid, String pwd) {
		String url = idmProperties.getIdmUri() + IdmEnum.getTokenByPwd.url;
		String nonceStr = UUID.randomUUID().toString();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 璁剧疆鏃ユ湡鏍煎紡
		String date = df.format(new Date());
		String timestamp = Date2TimeStamp(date, "yyyy-MM-dd HH:mm:ss");
		Map<String, Object> map = new HashMap<>();
		map.put("client_id", idmProperties.getAppletClientId());
		map.put("client_secret", idmProperties.getAppletSecretId());
		map.put("nonce_str", nonceStr);
		map.put("pwd", pwd);
		map.put("timestamp", timestamp);
		map.put("uid", uid);
		String sign = getSign(map, idmProperties.getAppkey() + idmProperties.getAppletSecretId());
		LOGGER.info("==sign=="+sign);
		map.put("sign", sign);
		return httpURLPOSTCase(JsonBeanUtil.beanToJson(map), url);
	}

	
	/**
	 * 时间格式转换
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static String Date2TimeStamp(String dateStr, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return String.valueOf(sdf.parse(dateStr).getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	/**
	 * 生成idm移动端api sign
	 * 
	 * @param params
	 * @param secret
	 * @return
	 */
	
	public static String getSign(Map<String, Object> params,String secret){    
        String sign="";    
        StringBuilder sb = new StringBuilder();   
        Set<String> keyset=params.keySet();    
        TreeSet<String> sortSet=new TreeSet<>();    
        sortSet.addAll(keyset);    
        Iterator<String> it=sortSet.iterator();   
        //拼接字符串
        while(it.hasNext()){    
            String key=it.next();    
            String value=params.get(key).toString();    
            sb.append(key).append(value);    
        }    
        sb.append("appkey").append(secret);
        LOGGER.info("====待加密IDM签名==="+sb.toString());
        try {    
           sign=  MD5Util.md5s(sb.toString()).toUpperCase();
        } catch (Exception e) {    
        }    
        return sign;    
    } 
	
	/**
	    * ESB-POST请求
	    * 
	    * @param now
	    * @param token
	    * @param body
	    * @param sourcesystem
	    * @param targetsystem
	    * @param servicename
	    * @param methodUrl
	    * @return
	    */
	   private static String httpURLPOSTCase(String body, String methodUrl) {
		   LOGGER.info("==esb=body=="+body);
		   HttpURLConnection connection = null;
	       OutputStream dataout = null;
	       BufferedReader reader = null;
	       String line = null;
	       try {
	           URL url = new URL(methodUrl);
	           connection = (HttpURLConnection) url.openConnection();// 根据URL生成HttpURLConnection
	           connection.setDoOutput(true);// 设置是否向connection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true,默认情况下是false
	           connection.setDoInput(true); // 设置是否从connection读入，默认情况下是true;
	           connection.setRequestMethod("POST");// 设置请求方式为post,默认GET请求
	           connection.setUseCaches(false);// post请求不能使用缓存设为false
	           connection.setConnectTimeout(5000);// 连接主机的超时时间
	           connection.setReadTimeout(30000);// 从主机读取数据的超时时间
	           connection.setInstanceFollowRedirects(true);// 设置该HttpURLConnection实例是否自动执行重定向
	           connection.setRequestProperty("connection", "Keep-Alive");// 连接复用
	           connection.setRequestProperty("charset", "utf-8");

	           connection.setRequestProperty("Content-Type", "application/json");
	           connection.setRequestProperty("timeStamp", Long.toString(System.currentTimeMillis()));
	           connection.setRequestProperty("requestid", UUID.randomUUID().toString());
	           connection.setRequestProperty("Authorization", "Basic c21lZGk6c21lZGk=");
	           connection.connect();// 建立TCP连接,getOutputStream会隐含的进行connect,所以此处可以不要

	           dataout = new DataOutputStream(connection.getOutputStream());// 创建输入输出流,用于往连接里面输出携带的参数
	           dataout.write(body.getBytes());
	           dataout.flush();
	           dataout.close();

	           if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
	               reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));// 发送http请求
	               StringBuilder result = new StringBuilder();
	               // 循环读取流
	               while ((line = reader.readLine()) != null) {
	                   result.append(line).append(System.getProperty("line.separator"));//
	               }
	               LOGGER.info(result.toString());
	               return result.toString();
	           }
	       } catch (IOException e) {
	           LOGGER.error("e:",e);
	       } finally {
	           try {
	               reader.close();
	           } catch (IOException e) {
	        	   LOGGER.error("e:",e);
	           }
	           connection.disconnect();
	       }
		return null;
	   }

}
