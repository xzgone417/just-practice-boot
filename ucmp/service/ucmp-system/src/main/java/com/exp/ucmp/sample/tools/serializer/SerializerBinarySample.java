package com.exp.ucmp.sample.tools.serializer;

import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egrid.core.serializer.util.SerializeUtil;

import com.exp.ucmp.sample.dto.SamplePagingDto;

/**
 * 序列化和反序列化的样例(二进制)
 *
 */
public class SerializerBinarySample {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SerializerBinarySample.class);
	/**
	 * 将对象序列化成二进制对象，序列化工具采用了FST。
	 * 
	 * @param obj 待序列化对象，该对象需要实现Serializable接口
	 * @return 序列化结果
	 * @throws Exception 序列化抛出异常
	 */
	public byte[] serializer(Serializable obj) throws Exception {
		/*注意getSerializer()*/
		return SerializeUtil.getSerializer().serialize(obj);
	}
	/**
	 * 将对象序列化成二进制对象，并且对序列化的结果进行数据压缩，序列化工具采用了FST，压缩算法使用了ZSTD。
	 * 需注意，序列化结果压缩了，那反序列化也需要使用通过压缩进行反序列化
	 * 
	 * @param obj 待序列化对象，该对象需要实现Serializable接口
	 * @return 序列化结果
	 * @throws Exception 序列化抛出异常
	 */
	public byte[] serializerByCompress(Serializable obj) throws Exception {
		/*注意getCompressSerializer()*/
		return SerializeUtil.getCompressSerializer().serialize(obj);
	}
	
	/**
	 * 反序列化，将序列化的二进制数据反序列化为对象
	 * 
	 * @param aryByte 序列化的二进制数据
	 * @return 对象
	 * @throws Exception 反序列化抛出异常
	 */
	public Object deserialize(byte[] aryByte) throws Exception {
		/*注意getSerializer()*/
		return SerializeUtil.getSerializer().deserialize(aryByte);
	}
	/**
	 * 反序列化，将序列化的二进制数据反序列化为对象
	 * 
	 * @param aryByte 序列化的二进制数据
	 * @return 对象
	 * @throws Exception 反序列化抛出异常
	 */
	public Object deserializeByCompress(byte[] aryByte) throws Exception {
		/*注意getCompressSerializer()*/
		return SerializeUtil.getCompressSerializer().deserialize(aryByte);
	}
	
	public static void main(String[] args) {
		SerializerBinarySample sample = new SerializerBinarySample();
		SamplePagingDto dto = SamplePagingDto.getInstance();
		byte[] ary = null;
		try {
			LOGGER.info("待序列化对象\n{}", dto.toString());
			ary = sample.serializer(dto);
			LOGGER.info("序列化的二进制结果，其大小为{}", ary.length);
		} catch (Exception ex) {
			LOGGER.error("序列化出现了异常，异常内容为{}", ex.getMessage());
		}

		try {
			Object obj = sample.deserialize(ary);
			LOGGER.info("反序列化的结果\n{}", obj);
		} catch (Exception ex) {
			LOGGER.error("反序列化出现了异常，异常内容为{}", ex.getMessage());
		} finally {
			ary = null;
		}
		
		
		try {
			ary = sample.serializerByCompress(dto);
			LOGGER.info("经过压缩的序列化二进制结果，其大小为{}", ary.length);
		} catch (Exception ex) {
			LOGGER.error("序列化出现了异常，异常内容为{}", ex.getMessage());
		}

		try {
			Object obj = sample.deserializeByCompress(ary);
			LOGGER.info("反序列化的结果\n{}", obj);
		} catch (Exception ex) {
			LOGGER.error("反序列化出现了异常，异常内容为{}", ex.getMessage());
		}
		
	}
	
}
