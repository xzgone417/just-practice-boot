package com.exp.ucmp.apig.idm.consumer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.AbstractConsumer;
import com.exp.ucmp.idm.dto.IdmAccountStatusDto;
import com.exp.ucmp.idm.dto.IdmUserDto;
import com.exp.ucmp.idm.dto.IdmUserStatusDto;


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
    	// ESB获取idm数据传输
    	getEmdmUrl("/v1.0/idm/goThroughApi");

        private String url;

        private IdmEnum(String value) {
            this.url = value;
        }
        public String url() {
            return this.url;
		}
	}
    
    /**
     * 创建idm用户
     * 
     * @param idmUserDto
     * @return
     * @throws Exception 
     */
    public String createUser(IdmUserDto idmUserDto) {
    	idmUserDto.setSecretId(idmProperties.getSecretId());
    	idmUserDto.setOrgId(idmProperties.getOrgId());
    	idmUserDto.setUserTypeCode(idmProperties.getUserTypeCode());
    	long now = System.currentTimeMillis();
 	   	long exp = now + 1000*180 ;//过期时间为 3 分钟
 	   	Map<String, Object> payloadMap = new HashMap<>();
 	   	payloadMap.put("user_id", idmProperties.getUserId());
 	   	payloadMap.put("iat", now);
 	   	payloadMap.put("exp", exp);
 	   	String token = createJWT( idmProperties.getKey(),payloadMap);
    	return httpURLPOSTCase(now, token, JsonBeanUtil.beanToJson(idmUserDto), "UCMP", "IDM", "S082005015B", idmProperties.getUri()+IdmEnum.getEmdmUrl.url);
    } 
    
    /**
     * 修改idm用户
     * 
     * @param idmUserDto
     * @return
     */
    public String updateUser(IdmUserDto idmUserDto) {
    	idmUserDto.setSecretId(idmProperties.getSecretId());
    	idmUserDto.setOrgId(idmProperties.getOrgId());
    	idmUserDto.setUserTypeCode(idmProperties.getUserTypeCode());
    	long now = System.currentTimeMillis();
 	   	long exp = now + 1000*180 ;//过期时间为 3 分钟
 	   	Map<String, Object> payloadMap = new HashMap<>();
 	   	payloadMap.put("user_id", idmProperties.getUserId());
 	   	payloadMap.put("iat", now);
 	   	payloadMap.put("exp", exp);
 	   	String token = createJWT( idmProperties.getKey(),payloadMap);
    	return httpURLPOSTCase(now, token, JsonBeanUtil.beanToJson(idmUserDto), "UCMP", "IDM", "S082005016B", idmProperties.getUri()+IdmEnum.getEmdmUrl.url);
    }
    
    /**
     * 修改idm用户状态
     * 
     * @param idmUserStatusDto
     * @return
     * @throws Exception 
     */
    public String updateUserStatus(IdmUserStatusDto idmUserStatusDto){
    	Map<String,Object> params=new HashMap<>();
    	params.put("Status", idmUserStatusDto.getStatus());
    	params.put("uid", idmUserStatusDto.getUid());
    	params.put("secretId", idmProperties.getSecretId());
    	params.put("isSendEmail", idmUserStatusDto.getIsSendEmail());
    	long now = System.currentTimeMillis();
 	   	long exp = now + 1000*180 ;//过期时间为 3 分钟
 	   	Map<String, Object> payloadMap = new HashMap<>();
 	   	payloadMap.put("user_id", idmProperties.getUserId());
 	   	payloadMap.put("iat", now);
 	   	payloadMap.put("exp", exp);
 	   	String token = createJWT( idmProperties.getKey(),payloadMap);
    	return httpURLPOSTCase(now, token, JsonBeanUtil.beanToJson(params), "UCMP", "IDM", "S082005014B", idmProperties.getUri()+IdmEnum.getEmdmUrl.url);
    }
    
    public static void main(String[] args) {
    	IdmUserStatusDto idmUserStatusDto=new IdmUserStatusDto();
    	idmUserStatusDto.setIsSendEmail("0");
    	idmUserStatusDto.setSecretId("");
    	idmUserStatusDto.setStatus("1");
    	idmUserStatusDto.setUid("17612147473");
    	Map<String,Object> params=Copiers.beanToMap(idmUserStatusDto);
    	params.put("Status", idmUserStatusDto.getStatus());
    	LOGGER.info("=====params="+JsonBeanUtil.beanToJson(params));
	}
    
    /**
     * 修改idm账号状态
     * 
     * @param idmUserDto
     * @return
     */
    public String updateAccountStatus(IdmAccountStatusDto idmAccountStatusDto) {
    	idmAccountStatusDto.setSecretId(idmProperties.getSecretId());
    	idmAccountStatusDto.setClientId(idmProperties.getClientId());
    	long now = System.currentTimeMillis();
 	   	long exp = now + 1000*180 ;//过期时间为 3 分钟
 	   	Map<String, Object> payloadMap = new HashMap<>();
 	   	payloadMap.put("user_id", idmProperties.getUserId());
 	   	payloadMap.put("iat", now);
 	   	payloadMap.put("exp", exp);
 	   	String token = createJWT( idmProperties.getKey(),payloadMap);
    	return httpURLPOSTCase(now, token, JsonBeanUtil.beanToJson(idmAccountStatusDto), "UCMP", "IDM", "S082005012B", idmProperties.getUri()+IdmEnum.getEmdmUrl.url);
    }
    
   /**
    * ESB 签名
    * 
    * @param key
    * @param payloadMap
    * @return
    */
   public static String createJWT(String key, Map<String, Object> payloadMap) {
		// 私钥及加密算法
		Algorithm algorithm = Algorithm.HMAC256(key);
		// 设置头信息
		Map<String, Object> headerMap = new HashMap<>();
		headerMap.put("alg", "HS256");
		headerMap.put("typ", "JWT");
		String token = JWT.create().withHeader(headerMap).withPayload(payloadMap).sign(algorithm);
		return "Bearer "+token;
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
   private static String httpURLPOSTCase(long now,String token,String body, String sourcesystem, String targetsystem,String servicename,String methodUrl) {
	   SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
           connection.setRequestProperty("servicename", servicename);
           connection.setRequestProperty("sourcesystem", sourcesystem);
           connection.setRequestProperty("targetsystem", targetsystem);
           connection.setRequestProperty("timeStamp", sd.format(new Date(now)));
           connection.setRequestProperty("requestid", UUID.randomUUID().toString());
           connection.setRequestProperty("Authorization", token);
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
        	   if(reader !=null){
        		   reader.close();
        	   }
           } catch (IOException e) {
        	   LOGGER.error("e:",e);
           }
           if(connection !=null){
        	   connection.disconnect();
           }
       }
	return null;
   }


}

