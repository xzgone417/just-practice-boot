package com.exp.ucmp.apig.esb.consumer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.AbstractConsumer;
import com.exp.ucmp.apig.urm.consumer.UrmConsumer;
import com.exp.ucmp.sap.dto.SapPayDto;


@Component
public class EmdmConsumer extends AbstractConsumer {
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UrmConsumer.class);
    
    @Autowired
	private EmdmProperties emdmProperties;
    
    protected enum EmdmEnum { 
    	// ESB获取EMDM数据接口
    	getEmdmUrl("/v1.0/emdm/goThroughApi"),
    	// esb营销收款同步
    	pushSapPayInfoUrl("/v1.0/sap/goThroughApi"),
    	jwtvalid("/v1.0/jwtvalid");

        private String url;

        private EmdmEnum(String value) {
            this.url = value;
        }
        public String url() {
            return this.url;
		}
	}
    
   /**
    * 测试jwt
    * 
    * @param targetSysId
    * @param startTime
    * @param endTime
    * @param hhrEmpid
    * @param iscPersonId
    * @return
    * @throws Exception
    */
   public String jwtvalid() throws Exception{
	   long now = System.currentTimeMillis();
	   long exp = now + 1000*180 ;//过期时间为 3 分钟
	   String userId = "10010999";
	   LOGGER.info("=========UUID.randomUUID().toString()="+UUID.randomUUID().toString());
	   String jwtSecretKey = "RV1w38rZYrO6QWinkfgaFDmsgXeatjgS";
	   Map<String, Object> payloadMap = new HashMap<>();
	   payloadMap.put("user_id", userId);
	   payloadMap.put("iat", now);
	   payloadMap.put("exp", exp);
	   String token = createJWT( jwtSecretKey,payloadMap);
	   Map<String,Object> params=new HashMap<>();
	   String body = JsonBeanUtil.beanToJson(params);
	   return httpURLPOSTCase(now, token, body,"DMY","ESB", "S99900X001B",emdmProperties.getUri()+EmdmEnum.jwtvalid.url);
   }
   
    /**
     * 人员信息
     * 
     * @param targetSysId
     * @param startTime
     * @param endTime
     * @param hhrEmpid
     * @param iscPersonId
     * @return
     * @throws Exception
     */
    public String getEmdmPersonInfo(Map<String,Object> paramMap) throws Exception{
    	String body = JsonBeanUtil.beanToJson(paramMap);
    	return this.requstEsb(body, "UCMP", "EMDM", "S082014004B",emdmProperties.getUri()+EmdmEnum.getEmdmUrl.url);
    }
    
    /**
     * 行政区划信息查询
     * 
     * @param targetSysId
     * @param startTime
     * @param endTime
     * @param areaCode
     * @param cityCode
     * @return
     * @throws Exception
     */
    public String getEmdmAreaInfo(Map<String,Object> paramMap) throws Exception{
    	String body = JsonBeanUtil.beanToJson(paramMap);
    	return this.requstEsb(body, "UCMP", "EMDM", "S082014007B",emdmProperties.getUri()+EmdmEnum.getEmdmUrl.url);
    }
    
    /**
     * 部门信息
     * 
     * @param targetSysId
     * @param startTime
     * @param endTime
     * @param hhrDeptCode
     * @return
     * @throws Exception
     */
    public String getEmdmDeptInfo(Map<String,Object> paramMap) throws Exception{
    	String body = JsonBeanUtil.beanToJson(paramMap);
    	return this.requstEsb(body, "UCMP", "EMDM", "S082014001B",emdmProperties.getUri()+EmdmEnum.getEmdmUrl.url);
    }
    
    /**
     * 车型信息
     * 
     * @param targetSysId
     * @param startTime
     * @param endTime
     * @param hhrDeptCode
     * @return
     * @throws Exception
     */
    public String getEmdmModelInfo(Map<String,Object> paramMap) throws Exception{
    	String body = JsonBeanUtil.beanToJson(paramMap);
    	return this.requstEsb(body, "UCMP", "EMDM", "S082014018B",emdmProperties.getUri()+EmdmEnum.getEmdmUrl.url);
    }
    
    public String pushSapPayInfo(SapPayDto sapPayDto) throws IOException {
    	Map<String,Object> paramMap=new HashMap<>();
    	paramMap.put("ZBUSSYS", sapPayDto.getZbussys());
    	paramMap.put("ZBORDER_FQ", sapPayDto.getZborderFq());
    	paramMap.put("ZBORDER_EX", sapPayDto.getZborderEx());
    	paramMap.put("ZZFPTNO", sapPayDto.getZzfptno());
    	paramMap.put("ZZTIMESTEMP", sapPayDto.getZztimestemp());
    	paramMap.put("ZBAND", sapPayDto.getZband());
    	paramMap.put("BUKRS", sapPayDto.getBukrs());
    	paramMap.put("ZZFTD", sapPayDto.getZzftd());
    	paramMap.put("ZSHH", sapPayDto.getZshh());
    	paramMap.put("ZZFSTATUS", sapPayDto.getZzfstatus());
    	paramMap.put("ZRECTYPE", sapPayDto.getZrectype());
    	paramMap.put("ZPAYMETH", sapPayDto.getZpaymeth());
    	paramMap.put("KUNNR", sapPayDto.getKunnr());
    	paramMap.put("ZDATE", sapPayDto.getZdate());
    	paramMap.put("ZPAYNAME", sapPayDto.getZpayname());
    	paramMap.put("WRBTR", sapPayDto.getWrbtr());
    	paramMap.put("WAERS", sapPayDto.getWaers());
    	paramMap.put("ZMEMO", sapPayDto.getZmemo());
    	paramMap.put("FIELD01", sapPayDto.getField01());
    	paramMap.put("FIELD02", sapPayDto.getField02());
    	paramMap.put("FIELD03", sapPayDto.getField03());
    	paramMap.put("FIELD04", sapPayDto.getField04());
    	paramMap.put("FIELD05", sapPayDto.getField05());
    	List<Map<String,Object>> list= new ArrayList<>();
    	list.add(paramMap);
    	String body = JsonBeanUtil.beanToJson(list);
		return this.requstEsb(body, "UCMP", "SAP", "S094011029B", emdmProperties.getUri()+EmdmEnum.pushSapPayInfoUrl.url);
	} 
    
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
   
   public String requstEsb(String body,String sourcesystem, String targetsystem,String servicename,String url) throws IOException{
	   long now = System.currentTimeMillis();
	   long exp = now + 1000*180 ;//过期时间为 3 分钟
	   Map<String, Object> payloadMap = new HashMap<>();
	   payloadMap.put("user_id", emdmProperties.getUserId());
	   payloadMap.put("iat", now);
	   payloadMap.put("exp", exp);
	   String token = createJWT( emdmProperties.getKey(),payloadMap);
	   return httpURLPOSTCase(now, token, body, sourcesystem, targetsystem, servicename,url);
   }
   
   /*private String doPost(long now,String token,Map<String,Object> params, String sourcesystem, String targetsystem,String servicename,String url) throws IOException{
	   SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   LOGGER.info("=====params===="+JsonBeanUtil.beanToJson(params));
	   HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
	    //HttpClient
	   CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
	   HttpPost httpPost = new HttpPost(url);
	   httpPost.addHeader("servicename", servicename);
	   httpPost.addHeader("sourcesystem", sourcesystem);
	   httpPost.addHeader("targetsystem", targetsystem);
	   httpPost.addHeader("timeStamp", sd.format(new Date(now)));
	   httpPost.addHeader("requestid", UUID.randomUUID().toString());
	   httpPost.addHeader("Authorization", token);
	   LOGGER.info("======ESB头信息====="+JsonBeanUtil.beanToJson(httpPost.getAllHeaders()));
	   StringEntity entity = new StringEntity(JsonBeanUtil.beanToJson(params), "UTF-8");
	   LOGGER.info("==entity=" + entity);
	   LOGGER.info("==entity=" + JsonBeanUtil.beanToJson(entity));
	   httpPost.setEntity(entity);
	   LOGGER.info("======ESB参数=====" + JsonBeanUtil.beanToJson(httpPost.getEntity()));
	   httpPost.setHeader("Content-Length", Long.toString(entity.getContentLength()));
	   HttpResponse httpResponse = closeableHttpClient.execute(httpPost);
	   //获取响应消息实体
	   HttpEntity httpEntity = httpResponse.getEntity();
	   
	   String  result=null;
	   if (httpEntity != null){
	    LOGGER.info("esb返回---"+JsonBeanUtil.beanToJson(httpEntity));
	    InputStream resContent = httpEntity.getContent();
	        byte[] bytes = new byte[resContent.available()];
	        resContent.read(bytes);
	        result = new String(bytes);
	        LOGGER.info("====result="+result);
	  }
	return result;
   }*/
   
   public static void main(String[] args) {
	   long now = System.currentTimeMillis();
	   long exp = now + 1000*180 ;//过期时间为 3 分钟
	   String user_id = "10010999";
	   SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   LOGGER.info("====="+sd.format(new Date(now)));
	   String jwt_secretKey = "RV1w38rZYrO6QWinkfgaFDmsgXeatjgS";
	   Map<String, Object> payloadMap = new HashMap<>();
	   payloadMap.put("user_id", user_id);
	   payloadMap.put("iat", now);
	   payloadMap.put("exp", exp);
	   String token = createJWT( jwt_secretKey,payloadMap);
	   System.out.println("Authorization: "+token);
	  }
   
   private static String httpURLPOSTCase(long now,String token,String body, String sourcesystem, String targetsystem,String servicename,String methodUrl) {
	   SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   HttpURLConnection connection = null;
       OutputStream dataout = null;
       BufferedReader reader = null;
       String line = null;
       try {
           URL url = new URL(methodUrl);
           connection = (HttpURLConnection) url.openConnection();// 根据URL生成HttpURLConnection
           connection.setDoOutput(true);// 设置是否向connection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true,默认情况下是false
           connection.setRequestMethod("POST");// 设置请求方式为post,默认GET请求
           connection.setUseCaches(false);// post请求不能使用缓存设为false
           connection.setConnectTimeout(30000);// 连接主机的超时时间
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
			LOGGER.info("===调用ESB接口参数==="+body);
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
//               LOGGER.info(result.toString());
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

