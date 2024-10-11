package com.exp.ucmp.util;

public class UcmpUtils {

	/**
	 * 生成指定位数的随机数字
	 * 
	 * @return 指定位数随机数字
	 */
	public static String generateRandomNumber(Integer length) {
		String chars = "0123456789";
		char[] rands = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * 10);
			rands[i] = chars.charAt(rand);
		}
		return new String(rands);
	}
}
