package com.exp.ucmp.sample.tools.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egrid.core.compress.Compress;
import com.egrid.core.compress.CompressionAlgorithm;
import com.egrid.core.compress.ICompress;
import com.exp.ucmp.sample.dto.SamplePagingDto;
import com.exp.ucmp.sample.tools.serializer.SerializerBinarySample;

/**
 * 数据压缩的样例
 *
 */
public class CompresSample {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompresSample.class);
	
	/**
	 * 将二进制数据进行压缩
	 * @throws Exception 
	 */
	public byte[] compres(byte[] value) throws Exception {
		ICompress compress = new Compress().setCompressionAlgorithm(CompressionAlgorithm.ZSTD. algorithm());
		return compress.compress(value);
	}
	
	/**
	 * 将压缩后的数据还原
	 * @throws Exception 
	 */
	public byte[] decompress(byte[] bytes) throws Exception {
		ICompress compress = new Compress().setCompressionAlgorithm(CompressionAlgorithm.ZSTD. algorithm());
		return compress.decompress(bytes);

	}
	
	public static void main(String[] args) throws Exception {
		CompresSample sample = new CompresSample();
		SerializerBinarySample serializer = new SerializerBinarySample();
		SamplePagingDto dto = SamplePagingDto.getInstance();
		byte[] value = null;
		LOGGER.info("待序列化对象\n{}", dto.toString());
		value = serializer.serializer(dto);
		LOGGER.info("对象序列化后的长度\n{}", value.length);
		
		byte[] bytes = sample.compres(value);
		LOGGER.info("压缩后的长度\n{}", bytes.length);
		value = null;
		
		value = sample.decompress(bytes);
		dto = (SamplePagingDto) serializer.deserialize(value);
		LOGGER.info("反序列化后对象\n{}", dto.toString());
	}
}
