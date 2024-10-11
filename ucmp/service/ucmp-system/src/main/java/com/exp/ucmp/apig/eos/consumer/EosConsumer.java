package com.exp.ucmp.apig.eos.consumer;

import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.egrid.core.shiro.context.AuthContext;
import com.exp.ucmp.dao.ISysUserBehaviorDao;
import com.exp.ucmp.dao.ISysUserBehaviorParamsDao;
import com.exp.ucmp.dao.ISysUserBehaviorResponseDao;
import com.exp.ucmp.entity.SysUserBehaviorEntity;
import com.exp.ucmp.entity.SysUserBehaviorParamsEntity;
import com.exp.ucmp.entity.SysUserBehaviorResponseEntity;
import com.exp.ucmp.eos.dto.GiveMessageParamDto;
import com.exp.ucmp.model.Person;
import com.google.gson.JsonObject;
import io.micrometer.core.instrument.util.JsonUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.egrid.core.copiers.Copiers;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.AbstractConsumer;
import com.exp.ucmp.eos.dto.MessageParamDto;

@Component
public class EosConsumer extends AbstractConsumer {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EosConsumer.class);

    @Autowired
    private EosProperties eosProperties;
    @Autowired
    private SlfProperties slfProperties;

    @Autowired
    ISysUserBehaviorDao dao;
    @Autowired
    ISysUserBehaviorParamsDao paramsDao;
    @Autowired
    ISysUserBehaviorResponseDao responseDao;

    protected enum EosEnum { // URM接口
        getUserAndSuperiorInfo("/eos/api/user/getUserAndSuperiorInfo"),
        allUsersInTheDepartment("/eos/api/user/allUsersInTheDepartment"),
        sendMessage("/eos/api/customer/sendMessage");

        private String url;

        private EosEnum(String value) {
            this.url = value;
        }

        public String url() {
            return this.url;
        }
    }

    protected enum SlfEnum { // Salesforce接口
        token("/services/oauth2/token"),
        receive("/services/apexrest/api/smp/message/receive"),
        getUserAndSuperiorlnfo("/services/apexrest/api/ucmp/getUserAndSuperiorInfo"),
        getUserslnTheDepartment("/services/apexrest/api/ucmp/getUsersInTheDepartment");

        private String url;

        private SlfEnum(String value) {
            this.url = value;
        }

        public String url() {
            return this.url;
        }
    }

    /**
     * 查询单个顾问信息以及上级信息
     *
     * @param idmAccountName
     * @throws Exception
     */
    public String getUserAndSuperiorInfo(String token, String idmAccountName) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        params.put("idmAccountName", idmAccountName);

        RequestBuilder requestBuilder = RequestBuilder.getInstance().key(eosProperties.getKey()).secret(eosProperties.getSecret())
                .mediaType(MediaType.APPLICATION_JSON).method("POST")
                .url(eosProperties.getUri() + EosEnum.getUserAndSuperiorInfo.url)
                .params(params);
        LOGGER.info(requestBuilder.toString());
        return sendRequest(requestBuilder.build());
    }

    /**
     * 查询门店下所有顾问信息
     *
     * @throws Exception
     */
    public String allUsersInTheDepartment(String departmentCode) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("departmentCode", departmentCode);

        RequestBuilder requestBuilder = RequestBuilder.getInstance().key(eosProperties.getKey()).secret(eosProperties.getSecret())
                .mediaType(MediaType.APPLICATION_JSON).method("POST")
                .url(eosProperties.getUri() + EosEnum.allUsersInTheDepartment.url)
                .params(params);
        LOGGER.info(requestBuilder.toString());
        return sendRequest(requestBuilder.build());
    }

    /**
     * 推送展厅站内信息（支持极光推送）
     *
     * @throws Exception
     */
    public String sendMessage(MessageParamDto messageParamDto) throws Exception {
        Map<String, Object> params = Copiers.beanToMap(messageParamDto);
        LOGGER.info("消息推送参数：" + JsonBeanUtil.beanToJson(params));
        RequestBuilder requestBuilder = RequestBuilder.getInstance().key(eosProperties.getKey()).secret(eosProperties.getSecret())
                .mediaType(MediaType.APPLICATION_JSON).method("POST")
                .url(eosProperties.getUri() + EosEnum.sendMessage.url)
                .params(params);
        LOGGER.info(requestBuilder.toString());
        return sendRequest(requestBuilder.build());
    }

    /**
     * 获取slf token
     *
     * @return
     * @throws Exception
     */
    public String getAccessToken() throws Exception {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(slfProperties.getUri() + SlfEnum.token.url);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("grant_type", "password"));
        params.add(new BasicNameValuePair("username", slfProperties.getUsername()));
        params.add(new BasicNameValuePair("password", slfProperties.getPassword()));
        params.add(new BasicNameValuePair("client_id", slfProperties.getClientId()));
        params.add(new BasicNameValuePair("client_secret", slfProperties.getClientSecret()));
        LOGGER.info("======获取slf token头信息params=====" + JsonBeanUtil.beanToJson(params));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, "UTF-8");
        LOGGER.info("======获取slf token头信息=====" + JsonBeanUtil.beanToJson(httpPost.getAllHeaders()));
        httpPost.setEntity(entity);
        CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpPost);
        //获取响应消息实体
        HttpEntity httpEntity = httpResponse.getEntity();
        String responseStr = null;
        if (httpEntity != null) {
            responseStr = StringEscapeUtils.unescapeJava(EntityUtils.toString(httpEntity));
        }

        return responseStr;
    }

    /**
     * 推送企信公共接口
     *
     * @throws Exception
     */
    public String giveMessage(GiveMessageParamDto messageParamDto) throws Exception {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();

        JSONObject jsonObject = null;
        try {
            //获取token
            String result = getAccessToken();
            LOGGER.info("推送企信接口获取token消息返回：" + result);
            jsonObject = JSON.parseObject(result);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            throw new Exception("获取slf系统token异常");
        }
        HttpPost httpPost = new HttpPost(slfProperties.getUri() + SlfEnum.receive.url);
        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        httpPost.setHeader("channel", "UCMP");
        httpPost.setHeader("Authorization", jsonObject.get("token_type") + " " + jsonObject.get("access_token"));
        String o = JSON.toJSONString(messageParamDto);
        LOGGER.info("======推送企信公共接口参数信息=====" + o);

        JSONObject reqObject = JSONObject.parseObject(o);
        httpPost.setEntity(new StringEntity(reqObject.toString(), ContentType.create("application/json", "UTF-8")));
        CloseableHttpClient hp = HttpClientBuilder.create().build();
        CloseableHttpResponse res = null;
        res = hp.execute(httpPost);
        HttpEntity responseEntity = res.getEntity();
        String responseStr = null;
        if (responseEntity != null) {
            String resp = StringEscapeUtils.unescapeJava(EntityUtils.toString(responseEntity));
            responseStr = resp.substring(1, resp.length() - 1);
            LOGGER.info("======推送企信公共接口返回信息=====" + responseStr);
        }
        LOGGER.info("======推送企信公共接口开始记录日志=====");
        //日志记录
        SysUserBehaviorEntity entity = new SysUserBehaviorEntity();
        entity.generatePk();
        entity.setUserId(user.getPartyId());
        entity.setBehaviorType("02");
        entity.setBehaviorTarget("SLF");
        entity.setBehaviorTargetUrl(slfProperties.getUri() + SlfEnum.receive.url);
        entity.setBehaviorTime(Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())));
        this.dao.insert(entity);

        SysUserBehaviorParamsEntity paramsEntity = new SysUserBehaviorParamsEntity();
        paramsEntity.setBehaviorId(entity.getBehaviorId());
        paramsEntity.setRequestId(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
        paramsEntity.setBehaviorTags("SLF");
        paramsEntity.setBehaviorTime(entity.getBehaviorTime());
        paramsEntity.setQueryParams(JsonBeanUtil.beanToJson(httpPost.getAllHeaders()));
        paramsEntity.setBodyParams(o);
        this.paramsDao.insert(paramsEntity);

        SysUserBehaviorResponseEntity response = new SysUserBehaviorResponseEntity();
        response.setRequestId(paramsEntity.getRequestId());
        response.setBehaviorResponse(responseStr);
        response.setResponseTime(entity.getBehaviorTime());
        this.responseDao.insert(response);
        return responseStr;
    }


    /**
     * 查询单个顾问信息以及上级信息
     *
     * @throws Exception
     */
    public String getUserAndHigherLevel(String userId) throws Exception {
        JSONObject jsonObject = null;
        try {
            //获取token
            String result = getAccessToken();
            LOGGER.info("查询单个顾问信息以及上级信息接口获取token消息返回：" + result);
            jsonObject = JSON.parseObject(result);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            throw new Exception("获取slf系统token异常");
        }
        HttpPost httpPost = new HttpPost(slfProperties.getUri() + SlfEnum.getUserAndSuperiorlnfo.url);
        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        httpPost.setHeader("channel", "UCMP");
        httpPost.setHeader("Authorization", jsonObject.get("token_type") + " " + jsonObject.get("access_token"));

        JSONObject reqObj = new JSONObject();
        reqObj.put("userId", userId);
        LOGGER.info("查询单个顾问信息以及上级信息接口userId：" + userId);
        httpPost.setEntity(new StringEntity(reqObj.toString(), ContentType.create("application/json", "UTF-8")));
        CloseableHttpClient hp = HttpClientBuilder.create().build();
        CloseableHttpResponse res = null;
        res = hp.execute(httpPost);
        HttpEntity responseEntity = res.getEntity();
        String responseStr = null;
        if (responseEntity != null) {
            responseStr = StringEscapeUtils.unescapeJava(EntityUtils.toString(responseEntity));
            LOGGER.info("查询单个顾问信息以及上级信息接口返回信息：" + responseStr);
        }
        return responseStr;
    }


    /**
     * 查询门店下所有顾问信息
     *
     * @throws Exception
     */
    public String getUsersInTheDepartment(String departmentCode) throws Exception {
        JSONObject jsonObject = null;
        try {
            //获取token
            String result = getAccessToken();
            LOGGER.info("查询门店下所有顾问信息接口获取token消息返回：" + result);
            jsonObject = JSON.parseObject(result);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            throw new Exception("获取slf系统token异常");
        }
        LOGGER.info("===查询门店下所有顾问信息接口URL==="+slfProperties.getUri() + SlfEnum.getUserslnTheDepartment.url);
        HttpPost httpPost = new HttpPost(slfProperties.getUri() + SlfEnum.getUserslnTheDepartment.url);
        httpPost.setHeader("Content-Type", "application/json;charset=utf-8");
        httpPost.setHeader("channel", "UCMP");
        httpPost.setHeader("Authorization", jsonObject.get("token_type") + " " + jsonObject.get("access_token"));

        JSONObject reqObj = new JSONObject();
        reqObj.put("departmentCode", departmentCode);
        LOGGER.info("查询门店下所有顾问信息接口门店code：" + departmentCode);

        httpPost.setEntity(new StringEntity(reqObj.toString(), ContentType.create("application/json", "UTF-8")));
        CloseableHttpClient hp = HttpClientBuilder.create().build();
        CloseableHttpResponse res = null;
        res = hp.execute(httpPost);
        HttpEntity responseEntity = res.getEntity();
        String responseStr = null;
        if (responseEntity != null) {
            responseStr = StringEscapeUtils.unescapeJava(EntityUtils.toString(responseEntity));
            LOGGER.info("查询门店下所有顾问信息接口返回信息：" + responseStr);
        }
        return responseStr;
    }
}
