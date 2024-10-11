package com.exp.ucmp.apig.smp.consumer;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.AbstractConsumer;
import com.exp.ucmp.apig.urm.consumer.UrmConsumer;
import com.exp.ucmp.dao.ISysPayConfigDao;
import com.exp.ucmp.entity.SysPayConfigEntity;
import com.exp.ucmp.pay.dto.PayDto;
import com.exp.ucmp.pay.dto.PayRefundDto;
import com.exp.ucmp.pay.utils.PayConfig;
import com.exp.ucmp.pay.utils.PayUtil;
import com.exp.ucmp.pk.SysPayConfigPk;

@Component
public class SmpConsumer extends AbstractConsumer {
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SmpConsumer.class);

	@Autowired
	private SmpProperties smpProperties;
	
	@Autowired
    private PayConfig payConfig;
	
	@Autowired
	private ISysPayConfigDao iSysPayConfigDao;

	protected enum SmpEnum { 
		// SMP接口
		getOrglist("/v1/otd/ordercenter/orglist"),
		getOrginfo("/v1/otd/ordercenter/orginfo"),
		getOrderDetail("/v1/otd/ordercenter/order/detailed"),
		getCarseries("/v1/otd/ordercenter/carseries"),
		getCartype("/v1/otd/ordercenter/cartype"),
		getVehicleproduct("/v1/otd/ordercenter/vehicleproduct"),
		getCarInfoByVin("/v1/otd/ordercenter/getCarInfoByVin"),
		allUsersInTheDepartment("/ucmp/v1/allUsersInTheDepartment"),
		getUserAndSuperiorInfo("/ucmp/v1/getUserAndSuperiorInfo"),
		channel("UCMP");

		private String value;

		private SmpEnum(String value) {
			this.value = value;
		}

		public String value() {
			return this.value;
		}
	}
	
	public enum PayEnum{ 
    	pay1("/payment/unitorder/pay","POST"),//网上收银统一下单
    	pay8("/payment/refund","POST");//退款
    	
    	private String uri;
    	
        private String method;

        public String uri() {
            return this.uri;
        }
        
        public String method() {
            return this.method;
        }

        PayEnum(String uri,String method) {
            this.uri = uri;
            this.method = method;
        }
        
        public static String getMethod(String uri) {
            for (PayEnum item: PayEnum.values()) {
                if(item.uri.equals(uri)){
                    return item.method;
                }
            }
            return null;
        }
    }

	/**
	 * 获取SMP门店组织List
	 * 
	 * @param channel
	 * @param orgType
	 * @return
	 * @throws Exception
	 */
	public String getOrglist(String channelCode, String orgType) throws Exception {
		if (StringUtil.isEmpty(channelCode)) {
			channelCode = SmpEnum.channel.value;
		}
		String url=smpProperties.getUri() + SmpEnum.getOrglist.value+"?channel="+channelCode+"&orgType="+orgType;
		
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(smpProperties.getKey())
				.secret(smpProperties.getSecret()).mediaType(MediaType.APPLICATION_JSON).method("GET")
				.url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}

	/**
	 * 
	 * 获取SMP门店信息
	 * 
	 * @param channel
	 * @param orgCode
	 * @param dcDlrId
	 * @return
	 * @throws Exception
	 */
	public String getOrginfo(String channelCode, String orgCode, String dcDlrId) throws Exception {
		if (StringUtil.isEmpty(channelCode)) {
			channelCode = SmpEnum.channel.value;
		}
		String url=smpProperties.getUri() + SmpEnum.getOrginfo.value+"?channel="+channelCode;
		if(StringUtil.isNotEmpty(orgCode)){
			url+="&orgCode="+orgCode;
		}
		if(StringUtil.isNotEmpty(dcDlrId)){
			url+="&dcDlrId="+dcDlrId;
		}
		
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(smpProperties.getKey())
				.secret(smpProperties.getSecret()).mediaType(MediaType.APPLICATION_JSON).method("GET")
				.url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}

	/**
	 * SMP获取订单详情
	 * 
	 * @param channel
	 * @param orderNum
	 * @param vin
	 * @return
	 * @throws Exception 
	 */
	public String getOrderDetail(String channelCode, String orderNum, String vin) throws Exception {
		if (StringUtil.isEmpty(channelCode)) {
			channelCode = SmpEnum.channel.value;
		}
		String url=smpProperties.getUri() + SmpEnum.getOrderDetail.value+"?channel="+channelCode;
		if(StringUtil.isNotEmpty(orderNum)){
			url+="&orderNum="+orderNum;
		}
		if(StringUtil.isNotEmpty(vin)){
			url+="&vin="+vin;
		}
		LOGGER.info("===ak==="+smpProperties.getKey()+"===SK="+smpProperties.getSecret());
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(smpProperties.getKey())
				.secret(smpProperties.getSecret()).mediaType(MediaType.APPLICATION_JSON).method("GET")
				.url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}
	
	/**
	 * SMP车型产品-工程车型
	 * 
	 * @param channel
	 * @param orderNum
	 * @param vin
	 * @return
	 * @throws Exception 
	 */
	public String getCarseries(String channelCode, String carSeriesCode, Boolean allVcc, String saleConfId) throws Exception {
		if (StringUtil.isEmpty(channelCode)) {
			channelCode = SmpEnum.channel.value;
		}
		String url=smpProperties.getUri() + SmpEnum.getCarseries.value+"?channel="+channelCode;
		if(StringUtil.isNotEmpty(carSeriesCode)){
			url+="&carSeriesCode="+carSeriesCode;
		}
		if(allVcc!=null){
			url+="&allVcc="+allVcc;
		}
		if(StringUtil.isNotEmpty(saleConfId)){
			url+="&saleConfId="+saleConfId;
		}
		LOGGER.info("===ak==="+smpProperties.getKey()+"===SK="+smpProperties.getSecret());
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(smpProperties.getKey())
				.secret(smpProperties.getSecret()).mediaType(MediaType.APPLICATION_JSON).method("GET")
				.url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}
	
	/**
	 * SMP车型产品-基础车型
	 * 
	 * @param channel
	 * @param orderNum
	 * @param vin
	 * @return
	 * @throws Exception 
	 */
	public String getCartype(String channelCode, String carSeriesCode, Boolean allVcc, String saleConfId) throws Exception {
		if (StringUtil.isEmpty(channelCode)) {
			channelCode = SmpEnum.channel.value;
		}
		String url=smpProperties.getUri() + SmpEnum.getCartype.value+"?channel="+channelCode;
		if(StringUtil.isNotEmpty(carSeriesCode)){
			url+="&carSeriesCode="+carSeriesCode;
		}
		if(allVcc!=null){
			url+="&allVcc="+allVcc;
		}
		if(StringUtil.isNotEmpty(saleConfId)){
			url+="&saleConfId="+saleConfId;
		}
		LOGGER.info("===ak==="+smpProperties.getKey()+"===SK="+smpProperties.getSecret());
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(smpProperties.getKey())
				.secret(smpProperties.getSecret()).mediaType(MediaType.APPLICATION_JSON).method("GET")
				.url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}
	
	/**
	 * SMP获取车型产品
	 * 
	 * @param channel
	 * @param orderNum
	 * @param vin
	 * @return
	 * @throws Exception 
	 */
	public String getVehicleproduct(String channelCode, String saleConfId) throws Exception {
		if (StringUtil.isEmpty(channelCode)) {
			channelCode = SmpEnum.channel.value;
		}
		String url=smpProperties.getUri() + SmpEnum.getCartype.value+"?channel="+channelCode;
		if(StringUtil.isNotEmpty(saleConfId)){
			url+="&saleConfId="+saleConfId;
		}
		LOGGER.info("===ak==="+smpProperties.getKey()+"===SK="+smpProperties.getSecret());
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(smpProperties.getKey())
				.secret(smpProperties.getSecret()).mediaType(MediaType.APPLICATION_JSON).method("GET")
				.url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}

	public String allUsersInTheDepartment(String departmentId) throws Exception {
		Map<String, Object> params = new HashMap<>();
        params.put("departmentId", departmentId);
        params.put("channel", SmpEnum.channel.value);
        LOGGER.info("===allUsersInTheDepartment==="+JsonBeanUtil.beanToJson(params));
        LOGGER.info("===ak==="+smpProperties.getKey()+"===SK="+smpProperties.getSecret());
        RequestBuilder requestBuilder = RequestBuilder.getInstance().key(smpProperties.getKey()).secret(smpProperties.getSecret())
                .mediaType(MediaType.APPLICATION_JSON).method("POST")
                .url(smpProperties.getUri() + SmpEnum.allUsersInTheDepartment.value)
                .params(params);
        LOGGER.info(requestBuilder.toString());
        return sendRequest(requestBuilder.build());
	}

	public String getUserAndSuperiorInfo(String token) throws Exception {
		Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        params.put("channel", SmpEnum.channel.value);
        LOGGER.info("===getUserAndSuperiorInfo==="+JsonBeanUtil.beanToJson(params));
        LOGGER.info("===ak==="+smpProperties.getKey()+"===SK="+smpProperties.getSecret());
        RequestBuilder requestBuilder = RequestBuilder.getInstance().key(smpProperties.getKey()).secret(smpProperties.getSecret())
                .mediaType(MediaType.APPLICATION_JSON).method("POST")
                .url(smpProperties.getUri() + SmpEnum.getUserAndSuperiorInfo.value)
                .params(params);
        LOGGER.info(requestBuilder.toString());
        return sendRequest(requestBuilder.build());
	}

	public String getCarInfoByVin(String carVin) throws Exception {
			String url=smpProperties.getUri() + SmpEnum.getCarInfoByVin.value+"?channel="+SmpEnum.channel.value+"&vin="+carVin;
			LOGGER.info("===ak==="+smpProperties.getKey()+"===SK="+smpProperties.getSecret());
			RequestBuilder requestBuilder = RequestBuilder.getInstance().key(smpProperties.getKey())
					.secret(smpProperties.getSecret()).mediaType(MediaType.APPLICATION_JSON).method("GET")
					.url(url);
			LOGGER.info("从SMP查询车辆信息数据url= "+url);
			return sendRequest(requestBuilder.build());
	}

	public String paymentUnitorderPay(PayDto payDto, SysPayConfigEntity sysPayConfigEntity) throws Exception {
//		payDto.setOrderNo(sysPayConfigEntity.getAppCode()+"_"+SmpEnum.channel.value()+"_"+payDto.getOrderNo());
		payDto.setOrderNo(payDto.getOrderNo());
		//生成签名
		String sign=PayUtil.sign(sysPayConfigEntity.getAppId(), PayEnum.getMethod(PayEnum.pay1.uri()), PayEnum.pay1.uri(), sysPayConfigEntity.getSecret());
		LOGGER.info("===统一下单支付中心签名sign==="+sign);
		Map<String, Object> params = new HashMap<>();
		if(StringUtil.isNotEmpty(payDto.getPaytype())){
			if ("2501".equals(payDto.getPaytype())) {
				params.put("paytype", "W01");
			}else{
				params.put("paytype", "A01");	
			}
			params.put("appId", sysPayConfigEntity.getAppId());
			params.put("orderNo",payDto.getOrderNo());
			params.put("amount", payDto.getAmount());
			params.put("subject", payConfig.getSubject());
			params.put("acct", payDto.getAcct());
			params.put("channel", SmpEnum.channel.value());
			LOGGER.info("===paymentUnitorderPay==="+JsonBeanUtil.beanToJson(params));
			LOGGER.info("===ak==="+payConfig.getKey()+"===SK="+payConfig.getSecret());
			
			RequestBuilder requestBuilder = RequestBuilder.getInstance().key(payConfig.getKey()).secret(payConfig.getSecret())
					.mediaType(MediaType.APPLICATION_JSON).method("POST")
					.url(payConfig.getUrl() + PayEnum.pay1.uri()).header("P-Authorization", sign).params(params);
			LOGGER.info("统一下单响应："+requestBuilder.toString());
			return sendRequest(requestBuilder.build());
		}else{
			return payDto.getOrderNo();
		}
	}

	public String paymentRefund(PayRefundDto payRefundDto) throws Exception {
		//根据车辆主体查询支付相关信息
		SysPayConfigPk sysPayConfigPk = new SysPayConfigPk(payRefundDto.getRevertBody());
		SysPayConfigEntity sysPayConfigEntity = this.iSysPayConfigDao.load(sysPayConfigPk);
		//生成签名
		String sign=PayUtil.sign(sysPayConfigEntity.getAppId(), PayEnum.getMethod(PayEnum.pay8.uri()), PayEnum.pay8.uri(), sysPayConfigEntity.getSecret());
		LOGGER.info("===退款支付中心签名sign==="+sign);
		Map<String, Object> params = new HashMap<>();
        params.put("appId", sysPayConfigEntity.getAppId());
        params.put("orderNo", sysPayConfigEntity.getAppCode()+"_"+SmpEnum.channel.value()+"_"+payRefundDto.getOrderNo());
        params.put("fee", payRefundDto.getFee());
        params.put("ext", payRefundDto.getExt());
        LOGGER.info("===ak==="+payConfig.getKey()+"===SK="+payConfig.getSecret());
        RequestBuilder requestBuilder = RequestBuilder.getInstance().key(payConfig.getKey()).secret(payConfig.getSecret())
                .mediaType(MediaType.APPLICATION_JSON).method("POST")
                .url(payConfig.getUrl() + PayEnum.pay8.uri()).header("P-Authorization", sign).params(params);
	    LOGGER.info("退款响应："+requestBuilder.toString());
	    return sendRequest(requestBuilder.build());
	}
}
