package com.exp.ucmp.util;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AesUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(AesUtils.class);

	private static final String ENCRY_ALGORITHM = "AES";
	/**
	 * 加密算法/加密模式/填充类型
	 */
	private static final String CIPHER_MODE = "AES/CBC/PKCS5Padding";
	/**
	 * 设置 iv 偏移量
	 */
	private static final String IV_ = "1a6c4b262436eca3";
	/**
	 * 设置加密字符集
	 */
	private static final String CHARACTER = "UTF-8";
	/**
	 * 设置加密密码处理长度。
	 */
	private static final int PWD_SIZE = 16;

	/**
	 * 加密
	 * @param text 原始内容
	 * @param secret 密钥
	 * @return 加密后内容
	 */
	public static String encryptHex(String text, String secret) {
		try {
			byte[] cipherTextBytes = encrypt(text.getBytes(CHARACTER), pwdHandler(secret));
			String cipherText = HexUtil.encodeToString(cipherTextBytes);
			return cipherText.toUpperCase();
		} catch (Exception e) {
			LOGGER.error("[AESUtil] encrypt exception, text:" + text, e);
		}
		return null;
	}

	public static byte[] encrypt(byte[] clearTextBytes, byte[] pwdBytes) throws Exception {
		SecretKeySpec keySpec = new SecretKeySpec(pwdBytes, ENCRY_ALGORITHM);
		Cipher cipher = Cipher.getInstance(CIPHER_MODE);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(IV_.getBytes()));
		byte[] cipherTextBytes = cipher.doFinal(clearTextBytes);
		return cipherTextBytes;
	}

	/**
	 * 密码处理方法
	 */
	private static byte[] pwdHandler(String password) throws UnsupportedEncodingException {
		byte[] data = null;
		if (password == null) {
			password = "";
		}
		StringBuffer sb = new StringBuffer(PWD_SIZE);
		sb.append(password);
		while (sb.length() < PWD_SIZE) {

			sb.append("0");
		}
		if (sb.length() > PWD_SIZE) {
			sb.setLength(PWD_SIZE);
		}
		data = sb.toString().getBytes(CHARACTER);
		return data;
	}

	/**
	 * 解密
	 * @param content AES加密后的内容
	 * @param secret 密钥
	 * @return 原始内容
	 * 
	 */
	public static String decryptHex(String content, String secret) throws Exception {
		byte[] arr = HexUtil.decode(content);
		byte[] raw = pwdHandler(secret);
		SecretKeySpec skeySpec = new SecretKeySpec(raw, ENCRY_ALGORITHM);
		Cipher cipher = Cipher.getInstance(CIPHER_MODE);
		cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(IV_.getBytes()));
		byte[] original = cipher.doFinal(arr);
		return new String(original, CHARACTER);
	}
}
