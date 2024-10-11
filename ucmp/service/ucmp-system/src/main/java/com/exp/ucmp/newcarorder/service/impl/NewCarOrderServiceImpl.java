package com.exp.ucmp.newcarorder.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.smp.consumer.SmpConsumer;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.entity.PsiNewCarOrderEntity;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.newcarorder.dao.NewCarOrderDao;
import com.exp.ucmp.newcarorder.service.NewCarOrderService;
import com.exp.ucmp.smp.dto.NewCarOrderDto;
import com.exp.ucmp.smp.dto.OrderDataDto;
import com.exp.ucmp.smp.dto.PayDto;
import com.exp.ucmp.smp.dto.SmpReturnDto;
import com.exp.ucmp.util.AesUtils;

@Service
public class NewCarOrderServiceImpl implements NewCarOrderService{

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NewCarOrderServiceImpl.class);
    
    @Autowired
	private SmpConsumer smpConsumer;
    
    @Autowired
    private NewCarOrderDao newCarOrderDao;
    
    @Autowired
	private UcmpAesConfig ucmpAesConfig;
    
	@Override
	public NewCarOrderDto getOrderDetail(String orderNum, String vin) throws Exception {
		String result = smpConsumer.getOrderDetail(null, orderNum,vin);
		LOGGER.info("======result="+result);
		if(StringUtil.isNotEmpty(result)){
			SmpReturnDto<Object> returnDto=JsonBeanUtil.jsonToBean(result, SmpReturnDto.class);
			if("000000".equals(returnDto.getCode())){
				OrderDataDto orderDataDto= JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(returnDto.getData()), OrderDataDto.class);
				LOGGER.info("=====orderDataDto===="+JsonBeanUtil.beanToJson(orderDataDto));
				NewCarOrderDto dto=Copiers.beanToBean(orderDataDto,OrderDataDto.class,NewCarOrderDto.class);
				dto.setAmount(orderDataDto.getReceivedAmount());
				//支付方式转换
				this.setPayType(dto,orderDataDto);
				//添加订单状态描述
				this.setStatusDesc(dto);
				//添加订单交付状态
				this.setOrderStatus(dto);
				LOGGER.info("=====dto===="+JsonBeanUtil.beanToJson(dto));
				this.changePayType(dto);
				return dto;
			}else{
				return null;
			}
		}else{
			throw new Exception("获取订单详情异常");
		}
	}

	private void setOrderStatus(NewCarOrderDto dto) {
		switch (dto.getOrderStatus()) {
		case "100":
			dto.setOrderStatusDesc("未销售确认");
			break;
		case "00":
			dto.setOrderStatusDesc("已确认");
			break;
		case "10":
			dto.setOrderStatusDesc("正在安排生产");
			break;
		case "11":
			dto.setOrderStatusDesc("生产中");
			break;
		case "12":
			dto.setOrderStatusDesc("生产下线");
			break;
		case "13":
			dto.setOrderStatusDesc("待发运");
			break;
		case "20":
			dto.setOrderStatusDesc("已做发运指令");
			break;
		case "21":
			dto.setOrderStatusDesc("发运指令取消中");
			break;
		case "22":
			dto.setOrderStatusDesc("VDC已出库");
			break;
		case "23":
			dto.setOrderStatusDesc("车辆到达DH");
			break;
		case "30":
			dto.setOrderStatusDesc("车辆入库");
			break;
		case "31":
			dto.setOrderStatusDesc("待验车");
			break;
		case "32":
			dto.setOrderStatusDesc("待客户确认验车");
			break;
		case "33":
			dto.setOrderStatusDesc("已验车");
			break;
		case "40":
			dto.setOrderStatusDesc("待提车");
			break;
		case "45":
			dto.setOrderStatusDesc("待客户确认提车");
			break;
		case "50":
			dto.setOrderStatusDesc("车辆待交付");
			break;
		case "60":
			dto.setOrderStatusDesc("交付异常");
			break;
		case "99":
			dto.setOrderStatusDesc("已交付");
			break;
		default:
			break;
		}
		
	}

	private void setStatusDesc(NewCarOrderDto dto) {
		switch (dto.getStatus()) {
		case "00":
			dto.setStatusDesc("意向金未支付");
			break;
		case "01":
			dto.setStatusDesc("已取消");
			break;
		case "02":
			dto.setStatusDesc("意向金已支付");
			break;
		case "03":
			dto.setStatusDesc("退款中");
			break;
		case "04":
			dto.setStatusDesc("自动退款失败");
			break;
		case "05":
			dto.setStatusDesc("已关闭（退款完成）");
			break;
		case "06":
			dto.setStatusDesc("已失效");
			break;
		case "16":
			dto.setStatusDesc("定金未支付");
			break;
		case "20":
			dto.setStatusDesc("定金已付待确认（大定已付）");
			break;
		case "21":
			dto.setStatusDesc("订单已锁配");
			break;
		case "22":
			dto.setStatusDesc("定金已付尾款待付");
			break;
		case "23":
			dto.setStatusDesc("首付未支付贷款未付");
			break;
		case "24":
			dto.setStatusDesc("首付已付贷款未付");
			break;
		case "30":
			dto.setStatusDesc("尾款已付待交付");
			break;
		case "99":
			dto.setStatusDesc("已完成");
			break;
		default:
			break;
		}
	}

	private void setPayType(NewCarOrderDto dto, OrderDataDto orderDataDto) {
		for (PayDto payDto : orderDataDto.getPayList()) {
			if("02".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==5){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("16".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==5){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("20".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==10){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("20".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==15){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("21".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==10){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("21".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==15){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("22".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==10){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("22".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==15){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("23".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==10){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("23".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==15){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("24".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==20){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("30".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==25){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("30".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==30){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("99".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==20){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("99".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==25){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("99".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==30){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
			if("99".equals(orderDataDto.getStatus())&&Integer.parseInt(payDto.getGatheringItemCode())==35){
				dto.setPaymentMethod(payDto.getPayType());
				dto.setPaymentTime(payDto.getGateringDate());
			}
		}
	}

	private void changePayType(NewCarOrderDto dto) {
		if(StringUtil.isNotEmpty(dto.getPaymentMethod())){
			switch (dto.getPaymentMethod()) {
			case "00":
				dto.setPaymentMethod("支付宝");
				break;
			case "01":
				dto.setPaymentMethod("微信");
				break;
			case "03":
				dto.setPaymentMethod("快捷");
				break;
			case "04":
				dto.setPaymentMethod("电汇");
				break;
			case "05":
				dto.setPaymentMethod("POS");
				break;
			default:
				dto.setPaymentMethod("现金");
				break;
			}
		}
	}

	@Override
	public void synorderstatus() {
		Long partyId=AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
		
		//查询需要同步状态的新车订单
		List<String> orderList=this.newCarOrderDao.getOrderList();
		if(orderList !=null && !orderList.isEmpty()){
			for (String orderNum : orderList) {
				try {
					NewCarOrderDto dto = this.getOrderDetail(orderNum, null);
					PsiNewCarOrderEntity entity=Copiers.beanToBean(dto, NewCarOrderDto.class, PsiNewCarOrderEntity.class);
					entity.setUpdatedBy(partyId);
					if(StringUtil.isNotEmpty(dto.getDeliveryDate())){
						if(dto.getDeliveryDate().length()==13){
							entity.setNewCarDeliveryDate(new Date(Long.parseLong(dto.getDeliveryDate())));
						}else{
							entity.setNewCarDeliveryDate(new Date(Long.parseLong(dto.getDeliveryDate()+"000")));
						}
					}
					if(StringUtil.isNotEmpty(dto.getOwnerPhone())){
						entity.setOwnerPhone(AesUtils.encryptHex(dto.getOwnerPhone(), ucmpAesConfig.getSecret()));
					}
					if(StringUtil.isNotEmpty(dto.getMainUserPhone())){
						entity.setMainUserPhone(AesUtils.encryptHex(dto.getMainUserPhone(), ucmpAesConfig.getSecret()));
					}
					entity.setNewCarOrderNo(dto.getOrderNum());
					entity.setNewCarVin(dto.getVin());
					entity.setNewCarInvoiceNo(dto.getInvoiceNo());
					//订单状态转换
					this.changeOrderStatus(dto,entity);
					//订单交付状态转换
					this.changeOrderDeliveryStatus(dto,entity);
					LOGGER.info("====同步订单状态====="+JsonBeanUtil.beanToJson(entity));
					this.newCarOrderDao.updateOrderInfoByOrderNum(entity);
				} catch (Exception e) {
					LOGGER.error("====新车订单【"+orderNum+"】同步订单信息异常",e);
				}
			}
		}
	}

	private void changeOrderDeliveryStatus(NewCarOrderDto dto, PsiNewCarOrderEntity entity) {
		switch (dto.getOrderStatus()) {
		case "100":
			entity.setOrderDeliverStatus("22100");
			break;
		case "00":
			entity.setOrderDeliverStatus("2200");
			break;
		case "10":
			entity.setOrderDeliverStatus("2210");
			break;
		case "11":
			entity.setOrderDeliverStatus("2211");
			break;
		case "12":
			entity.setOrderDeliverStatus("2212");
			break;
		case "13":
			entity.setOrderDeliverStatus("2213");
			break;
		case "20":
			entity.setOrderDeliverStatus("2220");
			break;
		case "21":
			entity.setOrderDeliverStatus("2221");
			break;
		case "22":
			entity.setOrderDeliverStatus("2222");
			break;
		case "23":
			entity.setOrderDeliverStatus("2223");
			break;
		case "30":
			entity.setOrderDeliverStatus("2230");
			break;
		case "31":
			entity.setOrderDeliverStatus("2231");
			break;
		case "32":
			entity.setOrderDeliverStatus("2232");
			break;
		case "33":
			entity.setOrderDeliverStatus("2233");
			break;
		case "40":
			entity.setOrderDeliverStatus("2240");
			break;
		case "45":
			entity.setOrderDeliverStatus("2245");
			break;
		case "50":
			entity.setOrderDeliverStatus("2250");
			break;
		case "60":
			entity.setOrderDeliverStatus("2260");
			break;
		case "99":
			entity.setOrderDeliverStatus("2299");
			break;
		default:
			break;
		}
	}

	private void changeOrderStatus(NewCarOrderDto dto, PsiNewCarOrderEntity entity) {
		switch (dto.getStatus()) {
		case "00":
			dto.setStatusDesc("2000");
			break;
		case "01":
			dto.setStatusDesc("2001");
			break;
		case "02":
			dto.setStatusDesc("2002");
			break;
		case "03":
			dto.setStatusDesc("2003");
			break;
		case "04":
			dto.setStatusDesc("2004");
			break;
		case "05":
			dto.setStatusDesc("2005");
			break;
		case "06":
			dto.setStatusDesc("2006");
			break;
		case "16":
			dto.setStatusDesc("2010");
			break;
		case "20":
			dto.setStatusDesc("2020");
			break;
		case "21":
			dto.setStatusDesc("2021");
			break;
		case "22":
			dto.setStatusDesc("2022");
			break;
		case "23":
			dto.setStatusDesc("2023");
			break;
		case "24":
			dto.setStatusDesc("2024");
			break;
		case "30":
			dto.setStatusDesc("2030");
			break;
		case "99":
			dto.setStatusDesc("2099");
			break;
		default:
			break;
		}
	}
}
