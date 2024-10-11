package com.exp.ucmp.config;

import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author GeYiJiang
 * @Description: 华为云OBS配置类
 * @date 2022/10/25 22:15
 */
@Configuration
public class HwOBSConfig {

    private static final Logger log = LoggerFactory.getLogger(HwOBSConfig.class);

    /**
     * 访问密钥AK
     */
    @Value("${adapter.obs.accessKey}")
    private String accessKey;

    /**
     * 访问密钥SK
     */
    @Value("${adapter.obs.securityKey}")
    private String securityKey;

    /**
     * 终端节点
     */
    @Value("${adapter.obs.endPoint}")
    private String endPoint;

    /**
     * 桶
     */
    @Value("${adapter.obs.bucketName}")
    private String bucketName;
    
    @Value("${adapter.obs.uri}")
    private String fileUri;

    public HwOBSConfig() {
    }

    public HwOBSConfig(String accessKey, String securityKey, String endPoint, String bucketName) {
        this.accessKey = accessKey;
        this.securityKey = securityKey;
        this.endPoint = endPoint;
        this.bucketName = bucketName;
    }

    /**
     * @Description 获取OBS客户端实例
     * @return: com.obs.services.ObsClient
     */
    public ObsClient getInstance() {
        return new ObsClient(accessKey, securityKey, endPoint);
    }


    /**
     * @Description 销毁OBS客户端实例
     */
    public void destroy(ObsClient obsClient){
        try {
            obsClient.close();
        } catch (ObsException e) {
            log.error("obs执行失败", e);
        } catch (Exception e) {
            log.error("执行失败", e);
        }
    }

    public static String getObjectKey() {
        // 项目或者服务名称 + 日期存储方式
        return new SimpleDateFormat("yyyyMM").format(new Date()) +"/";
    }

    /**
     * 获取
     * @return accessKey
     */
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * 设置
     * @param accessKey
     */
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    /**
     * 获取
     * @return securityKey
     */
    public String getSecurityKey() {
        return securityKey;
    }

    /**
     * 设置
     * @param securityKey
     */
    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    /**
     * 获取
     * @return endPoint
     */
    public String getEndPoint() {
        return endPoint;
    }

    /**
     * 设置
     * @param endPoint
     */
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * 获取
     * @return bucketName
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * 设置
     * @param bucketName
     */
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

	public String getFileUri() {
		return fileUri;
	}

	public void setFileUri(String fileUri) {
		this.fileUri = fileUri;
	}
}
