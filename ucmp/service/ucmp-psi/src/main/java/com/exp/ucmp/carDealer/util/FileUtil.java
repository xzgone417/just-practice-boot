package com.exp.ucmp.carDealer.util;

import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/27 15:16
 */
public class FileUtil {

    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    //photoToBase64
    public static String getPhotoBase64(MultipartFile file) throws IOException {

        String PHOTOBASE64 = null;
        byte[] bytes = null;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                file.getInputStream()  );
        bytes = new byte[bufferedInputStream.available()];
        bufferedInputStream.read(bytes);
        bufferedInputStream.close();
        PHOTOBASE64 = Base64.encodeBase64String(bytes);

        return PHOTOBASE64;

    }

    //base64转为inputStream
    public static InputStream base64ToInputStream(String base64Stream){
        byte[] bytes = Base64.decodeBase64(base64Stream);

        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);

        return stream;

    }

    //outputStream转为base64
    public static String outputStreamToBase64 (OutputStream outputStream){
        byte[] bytes = ((ByteArrayOutputStream)outputStream).toByteArray();

        String PHOTOBASE64 = Base64.encodeBase64String(bytes);

        return PHOTOBASE64;

    }

    //base64生成图片
    public static void generateImage(String imgStr) throws IOException {
        byte[] bytes = Base64.decodeBase64(imgStr);

        String imgPath = "D:\\image_after.jpg";

        OutputStream outputStream = new FileOutputStream(imgPath);

        outputStream.write(bytes);

        outputStream.flush();

        outputStream.close();

    }

    //压缩并转码
    public static String compressToBASE64(MultipartFile file) throws IOException {

        String inPHOTOBASE64 = getPhotoBase64(file);

        log.info(inPHOTOBASE64.length()/1024 + "kb");

        InputStream inputStream = base64ToInputStream(inPHOTOBASE64);

        OutputStream outputStream = new ByteArrayOutputStream();

        Thumbnails.of(inputStream).size(200,300).outputQuality(0.5).

                outputFormat("jpg").toOutputStream(outputStream);

        String outPHOTOBASE64 = outputStreamToBase64(outputStream);

        log.info(outPHOTOBASE64.length()/1024 + "kb");

        return outPHOTOBASE64;
    }

}
