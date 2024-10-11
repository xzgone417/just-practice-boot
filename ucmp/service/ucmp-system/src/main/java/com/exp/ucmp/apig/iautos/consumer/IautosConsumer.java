package com.exp.ucmp.apig.iautos.consumer;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.egrid.core.util.Md5Util;
import com.exp.ucmp.apig.AbstractConsumer;
import com.exp.ucmp.apig.urm.consumer.UrmConsumer;

@Component
public class IautosConsumer extends AbstractConsumer {
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UrmConsumer.class);

	@Autowired
	private IautosProperties iautosProperties;

	protected enum IautosEnum { // URM接口
		getPassengerBrand("/Maverick/Business/CarBrand/GetPassengerBrand"), 
		getPassengerSeries("/Maverick/Business/CarSeries/GetPassengerSeries"),
		getPassengerYear("/Maverick/Business/CarYear/GetPassengerYear"),
		getPassengerModel("/Maverick/Business/CarModel/GetPassengerModel"),
		getMixWithDetail("/Maverick/Business/CarMix/GetMixWithDetail"),
		assessrecordInfo("/assessapi/rv/assessrecord/info");
		private String url;

		private IautosEnum(String value) {
			this.url = value;
		}

		public String url() {
			return this.url;
		}
	}

	/**
	 * 第一车网 获取品牌列表
	 * 
	 * @param bindingType
	 * @throws Exception
	 */
	public String getPassengerBrand() throws Exception {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = form.format(new Date());
		String key =iautosProperties.getKey();
		String secret = Md5Util.getMD5String(date + iautosProperties.getSecret());
		String url=iautosProperties.getUri() + IautosEnum.getPassengerBrand.url+"?key="+key+"&date="+date+"&secret="+secret;
		
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(key)
				.secret(secret).mediaType(MediaType.APPLICATION_JSON).method("GET").url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Long requestTime=System.currentTimeMillis();
		LOGGER.info("===requestTime:" + Long.toString(requestTime).substring(0,11));
		String sign=Long.toString(requestTime).substring(0,11)+"95030ea8-e648-4d48-8073-625ede99ef7c";
		String signature = DigestUtils.md5Hex(sign);
		LOGGER.info("===md5:" + signature);
	}

	/**
	 * 根据品牌查询车系列表(带有厂商信息)
	 * 
	 * @param brandid
	 * @throws Exception
	 */
	public String getPassengerSeries(String brandid) throws Exception {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = form.format(new Date());
		String key =iautosProperties.getKey();
		String secret = Md5Util.getMD5String(brandid+date + iautosProperties.getSecret());
		String url=iautosProperties.getUri() + IautosEnum.getPassengerSeries.url+"?key="+key+"&date="+date+"&secret="+secret+"&brandid="+brandid;
		
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(key)
				.secret(secret).mediaType(MediaType.APPLICATION_JSON).method("GET").url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}

	/**
	 * 根据车系查询购买年份列表
	 * 
	 * @param seriesid
	 * @throws Exception
	 */
	public String getPassengerYear(String seriesid) throws Exception {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = form.format(new Date());
		String key =iautosProperties.getKey();
		String secret = Md5Util.getMD5String(seriesid+date + iautosProperties.getSecret());
		String url=iautosProperties.getUri() + IautosEnum.getPassengerYear.url+"?key="+key+"&date="+date+"&secret="+secret+"&seriesid="+seriesid;
		
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(key)
				.secret(secret).mediaType(MediaType.APPLICATION_JSON).method("GET").url(url);
		
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}

	/**
	 * 根据车系和购买年份查询车型列表
	 * 
	 * @param seriesid
	 * @param purchaseyear
	 * @throws Exception
	 */
	public String getPassengerModel(String seriesid, String purchaseyear) throws Exception {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = form.format(new Date());
		String key =iautosProperties.getKey();
		String secret = Md5Util.getMD5String(seriesid+purchaseyear+date + iautosProperties.getSecret() );
		String url=iautosProperties.getUri() + IautosEnum.getPassengerModel.url+"?key="+key+"&date="+date+"&secret="+secret+"&seriesid="+seriesid+"&purchaseyear="+purchaseyear;
		
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(key)
				.secret(secret).mediaType(MediaType.APPLICATION_JSON).method("GET").url(url);
		
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}
	
	/**
	 * 根据车型查询品牌、车系、年款等
	 * 
	 * @param modelid
	 * @throws Exception
	 */
	public String getMixWithDetail(String modelid) throws Exception {
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = form.format(new Date());
		String key =iautosProperties.getKey();
		String secret = Md5Util.getMD5String(modelid+date + iautosProperties.getSecret());
		String url=iautosProperties.getUri() + IautosEnum.getMixWithDetail.url+"?key="+key+"&date="+date+"&secret="+secret+"&modelid="+modelid;
		
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(key)
				.secret(secret).mediaType(MediaType.APPLICATION_JSON).method("GET").url(url);
		
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}
	
	/**
	 * 根据车型查询品牌、车系、年款等
	 * 
	 * @param modelid
	 * @throws Exception
	 */
	public String assessrecordInfo(String id) throws Exception {
		String key =iautosProperties.getPubilcSecret();
		Long requestTime=System.currentTimeMillis();
		String requestTimeStr=Long.toString(requestTime).substring(0,11);
		LOGGER.info("===requestTime:" +requestTimeStr) ;
		String sign=Long.toString(requestTime).substring(0,11)+iautosProperties.getPrivateSecret();
		String signature = DigestUtils.md5Hex(sign);
		LOGGER.info("===signature:" + signature);
		String url=iautosProperties.getAssessUri() + IautosEnum.assessrecordInfo.url+"?apiKey="+key+"&requestTime="+requestTimeStr+
				"&signature="+signature+"&id="+id;
		
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(key)
				.secret(signature).mediaType(MediaType.APPLICATION_JSON).method("GET").url(url);
		
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}

}
