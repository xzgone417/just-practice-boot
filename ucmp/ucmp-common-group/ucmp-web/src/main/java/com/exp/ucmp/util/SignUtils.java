package com.exp.ucmp.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SignUtils {
	
	/**
	 * 构建签名
	 *
	 * @param paramsMap 参数
	 * @param secret 密钥
	 * @return
	 */
	public static String createSign(Map<String, ?> paramsMap, String channel, String timestamp, String secret) {
		Set<String> keySet = paramsMap.keySet();
		List<String> paramNames = new ArrayList<String>(keySet);
		Collections.sort(paramNames);
		StringBuilder paramNameValue = new StringBuilder();
		for (String paramName : paramNames) {
			paramNameValue.append(paramName).append(paramsMap.get(paramName));
		}
		String source = secret + channel + timestamp + paramNameValue.toString() + secret;
		return encryptUpper(source);
	}

	/**
	 * 
	 * 生成md5,全部大写
	 *
	 * @param input
	 * @return
	 * 
	 */
	public static String encryptUpper(String input) {
		if (input == null || "".equals(input)) {
			throw new IllegalArgumentException("The argument input can not be empty.");
		}
		try {
			// 计算后获得字节数组,这就是那128位了
			byte[] buff = encryptMD5(input);
			// 把数组每一字节（一个字节占八位）换成16进制连成md5字符串
			return HexUtil.encodeToString(buff).toUpperCase();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * MD5签名
	 */
	public static byte[] encryptMD5(String data) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		return md.digest(data.getBytes("UTF-8"));
	}
}
