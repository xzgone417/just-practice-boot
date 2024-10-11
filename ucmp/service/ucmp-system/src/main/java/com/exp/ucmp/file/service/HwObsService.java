package com.exp.ucmp.file.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/26 9:31
 */
public interface HwObsService {

    boolean delete(String objectKey);

    boolean delete(List<String> objectKeys);

    String fileUpload(MultipartFile uploadFile, String objectKey);

    InputStream fileDownload(String objectKey);

}
