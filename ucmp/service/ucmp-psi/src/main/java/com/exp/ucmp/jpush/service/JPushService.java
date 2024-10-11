package com.exp.ucmp.jpush.service;


import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jiguang.common.resp.DefaultResult;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosAlert;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.utils.StringUtils;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.dao.ISysJpushRecordDao;
import com.exp.ucmp.dao.ISysJpushTemplateConfigDao;
import com.exp.ucmp.entity.SysJpushRecordEntity;
import com.exp.ucmp.entity.SysJpushTemplateConfigEntity;
import com.exp.ucmp.jPush.dto.JPushReqDto;
import com.exp.ucmp.jpush.config.JPushProperties;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.SysJpushTemplateConfigPk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>@ClassName: JPushConsumer</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/14 17:03<p>
 */
@Component
public class JPushService{
    private static final Logger LOGGER = LoggerFactory.getLogger(JPushService.class);

    @Autowired
    private JPushProperties jPushProperties;

    @Autowired
    private ISysJpushRecordDao iSysJpushRecordDao;
    
    @Autowired
    private ISysJpushTemplateConfigDao iSysJpushTemplateConfigDao;

    public static void main(String[] args) {

        /*JPushReqDto jPushReqDto = new JPushReqDto();
        jPushReqDto.setAlias(new String[]{"18621662204"});
        jPushReqDto.setTitle("放弃报价");
        jPushReqDto.setMsg("战败");
        jPushReqDto.setOrderNum("订单号");
        JPushService jPushConsumer = new JPushService();
        jPushConsumer.jPushAll(1L,"1", 100L, jPushReqDto);*/
    	LOGGER.info("==="+RandomIDGennerator.get().generate());
    	String content=" 总部分配本品收购订单, 您有一条新的本品收购订单, 您有一条新的本品收购订单，请及时查看并进行分配，订单号：{1}";
    	String params="123";
    	String[] str=params.split(",");
    	for (int i = 0; i < str.length; i++) {
    		LOGGER.info("==i+1="+"{"+(i+1)+"}");
    		content = content.replace("{"+(i+1)+"}", str[i]);
		}
    	LOGGER.info("==content="+content);
    }
    
    
    public void sendJPush(JPushReqDto jPushReqDto) {
    	LOGGER.info("==jPushReqDto=="+JsonBeanUtil.beanToJson(jPushReqDto));
    	SysJpushTemplateConfigPk sysJpushTemplateConfigPk = new SysJpushTemplateConfigPk(jPushReqDto.getjPushtemplateId());
    	SysJpushTemplateConfigEntity configEntity = this.iSysJpushTemplateConfigDao.load(sysJpushTemplateConfigPk);
    	jPushReqDto.setTitle(configEntity.getTitle());
    	String[] str = jPushReqDto.getParams().split(",");
    	String content =configEntity.getContent();
    	for (int i = 0; i < str.length; i++) {
    		content = content.replace("{"+(i+1)+"}", str[i]);
		}
    	jPushReqDto.setMsg(content);
    	jPushReqDto.setUrl(configEntity.getUrl());
    	try{
    		this.jPushAll(jPushReqDto);
    	}catch (Exception e) {
			LOGGER.error("===推送Jpush消息异常==",e);
		}
	}

    public PushResult jPushAll(JPushReqDto jPushReqDto) {
        if (jPushReqDto == null) {
            LOGGER.warn("极光推送app信息为空");
            return null;
        }
        if (StringUtils.isBlank(jPushReqDto.getTitle())
                || StringUtils.isBlank(jPushReqDto.getMsg())) {
            LOGGER.warn("极光推送app消息体异常:标题:{},内容:{},发送给人id:{}", jPushReqDto.getTitle(), jPushReqDto.getMsg(), jPushReqDto.getAlias());
            return null;
        }
        LOGGER.info("极光推送参数" + JSON.toJSONString(jPushReqDto));
        LOGGER.info("MASTER_SECRET:" + jPushProperties.getMasterSecret());
        LOGGER.info("APP_KEY:" + jPushProperties.getAppKey());
        // 创建JPushClient 极光推送的实例
        JPushClient jPushClient = new JPushClient(jPushProperties.getMasterSecret(), jPushProperties.getAppKey());
        //整理跳转参数
        Map<String, String> extras = new HashMap<>();
        extras.put("url", jPushReqDto.getUrl());
        extras.put("orderNum", jPushReqDto.getOrderNum());
        // IOS消息-标题
        IosAlert alert = IosAlert.newBuilder()
                .setTitleAndBody(jPushReqDto.getTitle(), null, jPushReqDto.getMsg())
                .build();
        // 构造一个payLoad
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(jPushReqDto.getAlias()))
                .setNotification(
                        Notification.newBuilder()
                                .addPlatformNotification(
                                        IosNotification.newBuilder()
                                                .setAlert(alert)
                                                .setBadge(+1).setSound("happy")
                                                .addExtras(extras)
                                                .build())
                                .addPlatformNotification(
                                        AndroidNotification.newBuilder()
                                                .addExtras(extras)
                                                .setAlert(jPushReqDto.getMsg())
                                                .setTitle(jPushReqDto.getTitle())
                                                .build())
                                .build())
                .setMessage(Message.newBuilder().setMsgContent(jPushReqDto.getMsg()).addExtras(extras).build())
                .setOptions(Options.newBuilder()
                .setApnsProduction(Boolean.parseBoolean(jPushProperties.getApnsProduction()))
                .build()).build();
        PushResult jpush = jpush(jPushClient, payload);
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        SysJpushRecordEntity sysJPush = new SysJpushRecordEntity();
        sysJPush.generatePk();
        sysJPush.setTemplateId(jPushReqDto.getjPushtemplateId());
        sysJPush.setType(jPushReqDto.getType());
        sysJPush.setRelevanceId(jPushReqDto.getRelevanceId());
        sysJPush.setRequestParam(JSON.toJSONString(jPushReqDto));
        sysJPush.setResponseParam(JSON.toJSONString(jpush));
        sysJPush.setCreatedBy(user.getPartyId());
        sysJPush.setCreatedDate(new Date());
        sysJPush.setUpdatedBy(user.getPartyId());
        sysJPush.setUpdatedDate(new Date());
        iSysJpushRecordDao.insert(sysJPush);
        return jpush;
    }


    public DefaultResult removeAlias(String alias, String platform) {

        // 创建JPushClient 极光推送的实例
        JPushClient jPushClient = new JPushClient(jPushProperties.getMasterSecret(), jPushProperties.getAppKey());
        DefaultResult result = null;
        try {
            result = jPushClient.deleteAlias(alias, platform);
        } catch (APIRequestException e) {
            if (e.getErrorCode() == 1011) {
                LOGGER.warn(e.getErrorMessage());
            } else {
                LOGGER.warn("删除别名异常", e);
            }
            return result;
        } catch (APIConnectionException e) {
            LOGGER.warn("删除别名异常", e);
            return result;
        }
        LOGGER.info("删除别名极光返回 pushLog" + JSON.toJSONString(result));
        return result;

    }


    /**
     * @param jPushClient
     * @param payload
     * @return
     * @author Dragon
     * @describe 消息推送
     * @date 2022年6月9日
     */
    private PushResult jpush(JPushClient jPushClient, PushPayload payload) {

        PushResult pushResult = null;
        try {
            pushResult = jPushClient.sendPush(payload);
        } catch (APIRequestException e) {
            if (e.getErrorCode() == 1011) {
                LOGGER.warn(e.getErrorMessage());
            } else {
                LOGGER.warn("消息推送异常", e);
            }
            return pushResult;
        } catch (APIConnectionException e) {
            LOGGER.warn("消息推送异常", e);
            return pushResult;
        }
        LOGGER.info("极光推送返回 pushLog" + JSON.toJSONString(pushResult));
        return pushResult;
    }

    /**
     * @param param
     * @return
     * @author Dragon
     * @describe 极光推送 - Android
     * @date 2022年6月9日
     */
    @SuppressWarnings("static-access")
    public PushResult jPushAndroid(Map<String, String> param) {
        // 创建JPushClient 极光推送的实例
        JPushClient jPushClient = new JPushClient(jPushProperties.getMasterSecret(), jPushProperties.getAppKey());
        // 推送的关键 构造一个payLoad
        PushPayload payload = PushPayload.newBuilder()
                // 指定安卓平台的用户
                .setPlatform(Platform.android())
                // 指定用户
                .setAudience(Audience.alias(param.get("ssId")).registrationId(param.get("ssId")))
                .setAudience(Audience.registrationId(param.get("ssId")))
                // 项目中的所有用户
                // .setAudience(Audience.alias("rrsfwmx")).setAudience(Audience.tag("user"))
                // 发送内容
                .setNotification(Notification.android(param.get("msg"), "极光推送NB", param))
                // 指开发环境 不设置也可以
                // .setOptions(Options.newBuilder().setApnsProduction(false).build())
                // 自定义信息
                .setMessage(Message.content(param.get("msg"))).build();

        return jpush(jPushClient, payload);
    }

    /**
     * @param param
     * @return
     * @author Dragon
     * @describe 极光推送 - IOS
     * @date 2022年6月9日
     */
    @SuppressWarnings("static-access")
    public PushResult jPushIOS(Map<String, String> param) {
        // 创建JPushClient 极光推送的实例
        JPushClient jPushClient = new JPushClient(jPushProperties.getMasterSecret(), jPushProperties.getAppKey());
        // 构造一个payLoad
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.ios())
                .setAudience(Audience.alias(param.get("ssId")).registrationId(param.get("ssId")))
                .setNotification(
                        Notification.newBuilder()
                                .addPlatformNotification(
                                        IosNotification.newBuilder().setAlert(param.get("msg")).setBadge(+1).setSound("happy").addExtras(param).build())
                                .build())
                .setMessage(Message.newBuilder().setMsgContent(param.get("msg")).addExtras(param).build()).build();

        return jpush(jPushClient, payload);
    }

}