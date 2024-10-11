package com.exp.ucmp.notice.utils;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

import com.exp.ucmp.util.AesUtils;

public class JasyptTest {

    public static void main(String[] args) throws Exception {
    	
    	// 1. 创建加解密工具实例
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        // 2. 加解密配置
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        //测试环境：justdoit  生成环境：hiphi-ucmp
        config.setPassword("justdoit");
        config.setAlgorithm("PBEWithHmacSHA512AndAES_128");
//        config.setAlgorithm("PBEWITHHMACSHA512ANDAES_256");
        // 为减少配置文件的书写，以下都是 Jasyp 3.x 版本，配置文件默认配置
        config.setKeyObtentionIterations( "1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
    	
    	//加密信息
    	String encryptedText = encryptor.encrypt("13783505096");
    	System.out.println("encryptedText:" + encryptedText);
    	
    	System.out.println(encryptor.decrypt("aLRpscQ7fmjv/CbzjhnrRZqtdejx7fgBV/eA/KHahUoCN46ykkVji6tztRP17wRD"));
    	
//    	System.out.println(AesUtils.decryptHex("AA366179D6577FF327DCBDB5CBDBE97A", "Hn9AQTUAYuMFNbUw"));
    }
}



/**
 * ENC(encryptedText)
 */
