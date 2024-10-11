package com.exp.ucmp.carDealer.service;

import com.exp.ucmp.file.dto.FileReturnDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileUploadService {

    FileReturnDto upload(MultipartFile file) throws IOException;

    /**
     * 上传模板，指定fileId
     * @param file
     * @param fileId
     * @return
     * @throws IOException
     */
    void uploadFormwork(MultipartFile file,Long fileId) throws IOException;
}
