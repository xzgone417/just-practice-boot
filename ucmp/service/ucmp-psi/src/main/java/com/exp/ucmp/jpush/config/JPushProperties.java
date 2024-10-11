package com.exp.ucmp.jpush.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * <p>@ClassName: JPushProperties</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/14 17:03<p>
 */
@Configuration
@RefreshScope
public class JPushProperties {

    @Value("${adapter.jgPush.appKey}")
    private String appKey="ee3566b781c439aaa95f950f";

    @Value("${adapter.jgPush.masterSecret}")
    private String masterSecret="355026339d21ecfb0441f11a";

    @Value("${adapter.jgPush.apnsProduction}")
    private String apnsProduction="false";

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getMasterSecret() {
        return masterSecret;
    }

    public void setMasterSecret(String masterSecret) {
        this.masterSecret = masterSecret;
    }

    public String getApnsProduction() {
        return apnsProduction;
    }

    public void setApnsProduction(String apnsProduction) {
        this.apnsProduction = apnsProduction;
    }
}
