package com.exp.ucmp.pay.utils;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.exp.ucmp.constant.Constants.REVERT_BODY;

import java.nio.charset.StandardCharsets;

import javax.crypto.Mac;

/**
 * HTTP协议传输工具类
 */
public class PayUtil {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PayUtil.class);
    
    public static String sign(String appId,String method,String uri,String secret){
    	String signString = System.currentTimeMillis()+"."+appId+"."+method+"."+uri;
    	LOGGER.info("====signString====="+signString);
    	Mac mac = HmacUtils.getInitializedMac(HmacAlgorithms.HMAC_SHA_512, secret.getBytes(StandardCharsets.UTF_8));
		return bytesToHex( mac.doFinal(signString.getBytes(StandardCharsets.UTF_8)))+"."+signString;
    }
    
    public static String bytesToHex(byte[] hash) {
    	StringBuilder hexString = new StringBuilder();
    	for (byte b : hash) {
    		String hex = Integer.toHexString(0xff & b);
	    	 if (hex.length() == 1) {
	    		 hexString.append('0');
	    	 }
	    	 hexString.append(hex);
    	}
    	 return hexString.toString();
	 }
    
    public static void main(String[] args) {
    	String appId="Paychannel_eJ9sH";
    	String method="POST";
    	String uri="/toast/test";
    	String secret="O07uV606vqN6v%7bm%SzrwhBlI4*q^";
		sign(appId, method, uri, secret);
	}
}