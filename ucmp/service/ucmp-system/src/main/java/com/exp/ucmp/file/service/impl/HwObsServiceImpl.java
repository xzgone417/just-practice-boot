package com.exp.ucmp.file.service.impl;

import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.config.HwOBSConfig;
import com.exp.ucmp.file.service.HwObsService;
import com.obs.services.ObsClient;
import com.obs.services.exception.ObsException;
import com.obs.services.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/26 9:33
 */
@Service
public class HwObsServiceImpl implements HwObsService {

    private static final Logger log = LoggerFactory.getLogger(HwObsServiceImpl.class);

    @Autowired
    private HwOBSConfig hwOBSConfig;

    @Override
    public boolean delete(String objectKey) {
        return false;
    }

    @Override
    public boolean delete(List<String> objectKeys) {
        return false;
    }

    @Override
    public String fileUpload(MultipartFile uploadFile, String objectKey) {

        ObsClient obsClient = null;
        try {
            String bucketName = hwOBSConfig.getBucketName();
            log.info("判断桶bucketName" + bucketName);
            obsClient = hwOBSConfig.getInstance();
            log.info("初始化OBS");
            // 判断桶是否存在
            boolean exists = obsClient.headBucket(bucketName);
            log.info("判断桶是否存在" + exists);
            if(!exists){
                // 若不存在，则创建桶
                HeaderResponse response = obsClient.createBucket(bucketName);
                log.info("创建桶成功" + response.getRequestId());
            }
            InputStream inputStream = uploadFile.getInputStream();
            long available = inputStream.available();
            PutObjectRequest request = new PutObjectRequest(bucketName,objectKey,inputStream);

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(available);
            request.setMetadata(objectMetadata);
            // 设置对象访问权限为公共读
            request.setAcl(AccessControlList.REST_CANNED_PUBLIC_READ);
            PutObjectResult result = obsClient.putObject(request);

            // 读取该已上传对象的URL
            log.info("已上传对象的URL" + JsonBeanUtil.beanToJson(result));
            return result.getObjectUrl();
        } catch (ObsException e) {
            log.error("obs上传失败", e);
        } catch (IOException e) {
            log.error("上传失败", e);
        }finally {
            hwOBSConfig.destroy(obsClient);
        }
        return null;
    }

    @Override
    public InputStream fileDownload(String objectKey) {
        ObsClient obsClient = null;
        try {
            String bucketName = hwOBSConfig.getBucketName();
            obsClient = hwOBSConfig.getInstance();
            ObsObject obsObject = obsClient.getObject(bucketName, objectKey);
            return obsObject.getObjectContent();
        } catch (ObsException e) {
            log.error("obs文件下载失败", e);
        } finally {
            hwOBSConfig.destroy(obsClient);
        }
        return null;
    }
}
