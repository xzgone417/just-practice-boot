/**
 * 
 * 初米网络
 * Copyright (C) 2022 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.sample.tools.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egrid.core.base.id.RandomIDGennerator;

/**
 * 可以生成全局唯一的Long型的主键
 * 有效时间：2076年7月31日之前，8月下旬之后，生成的主键将为负数
 * 
 * @author Administrator
 */
public class RandomIDGenneratorSample {
	private static final Logger LOGGER = LoggerFactory.getLogger(RandomIDGennerator.class);
    
	/**
	 * 生成Long类型的全局唯一键
	 */
    public void uniqueKey() {
    	Long id = RandomIDGennerator.get().generate();
    	LOGGER.info("生成的唯一键{}", id);
    }
    /**
     * 生成字符串类型的全局唯一键
     */
    public void uniqueHexKey() {
    	String id = RandomIDGennerator.get().toHexString();
    	LOGGER.info("生成的唯一键{}", id);
    }
    
    public static void main(String[] args) {
    	RandomIDGenneratorSample sample = new RandomIDGenneratorSample();
    	sample.uniqueKey();
    	sample.uniqueHexKey();
    }
    
}
