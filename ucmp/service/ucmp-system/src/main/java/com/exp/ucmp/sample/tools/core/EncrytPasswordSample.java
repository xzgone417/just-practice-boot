/**
 * 
 * 初米网络
 * Copyright (C) 2022 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.sample.tools.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egrid.core.util.EncrytPassword;

/**
 * 预设用户的登录密码或更改登录密码用
 * 使用Md5加密，不能恢复原有内容
 * 
 * @author Administrator
 */
public class EncrytPasswordSample {
	private static final Logger LOGGER = LoggerFactory.getLogger(EncrytPasswordSample.class);
    
    public void encrytPassword(String password) {
    	EncrytPassword pw = new EncrytPassword(password);
    	LOGGER.info("登录密码加密前的内容{}, 加密后的内容{}, salt值{}", password, pw.getEncrytPassword(), pw.getSalt());
    }
    
    public static void main(String[] args) {
    	EncrytPasswordSample sample = new EncrytPasswordSample();
    	sample.encrytPassword("000000");
    }
}
