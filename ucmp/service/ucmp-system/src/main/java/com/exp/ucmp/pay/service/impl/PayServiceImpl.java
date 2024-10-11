package com.exp.ucmp.pay.service.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.exp.ucmp.dao.IPsiOrderFollowRecordDao;
import com.exp.ucmp.entity.PsiOrderFollowRecordEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.cache.redisson.cache.RedissonCache;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.esb.consumer.EmdmConsumer;
import com.exp.ucmp.apig.smp.consumer.SmpConsumer;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IPsiCarStockInfoDao;
import com.exp.ucmp.dao.IPsiSalesPaymentRecordDao;
import com.exp.ucmp.dao.ISysPayConfigDao;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.exp.ucmp.entity.PsiSalesPaymentRecordEntity;
import com.exp.ucmp.entity.SysPayConfigEntity;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pay.dao.OrderPayDao;
import com.exp.ucmp.pay.dto.AddPaymentRecordDto;
import com.exp.ucmp.pay.dto.PayCallBackDto;
import com.exp.ucmp.pay.dto.PayDetailsDto;
import com.exp.ucmp.pay.dto.PayDto;
import com.exp.ucmp.pay.dto.PayMatchingDto;
import com.exp.ucmp.pay.dto.PayRefundDto;
import com.exp.ucmp.pay.dto.PayRejectDto;
import com.exp.ucmp.pay.dto.QueryBankStatementDto;
import com.exp.ucmp.pay.dto.QueryOrderInfoDto;
import com.exp.ucmp.pay.dto.QueryOrderParamsDto;
import com.exp.ucmp.pay.dto.QueryStatementParamsDto;
import com.exp.ucmp.pay.dto.RecordDetailsDto;
import com.exp.ucmp.pay.dto.StatementDetailsDto;
import com.exp.ucmp.pay.service.PayService;
import com.exp.ucmp.pk.SysPayConfigPk;
import com.exp.ucmp.salesDelivery.dto.OrderPaymentInfoDto;
import com.exp.ucmp.sap.dto.SapBankTransferStatementDto;
import com.exp.ucmp.sap.dto.SapPayDto;
import com.exp.ucmp.smp.dto.SmpReturnDto;
import com.exp.ucmp.util.AesUtils;
import com.exp.ucmp.util.EasyExcelUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.collection.CollectionUtil;

@Service
public class PayServiceImpl implements PayService {

	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PayServiceImpl.class);
	
	@Autowired
	private SmpConsumer smpConsumer;
	
	@Autowired
	private ISysPayConfigDao iSysPayConfigDao;
	
	@Autowired
	private OrderPayDao orderPayDao;
	
	@Autowired
	private IPsiCarStockInfoDao iPsiCarStockInfoDao;
	
	@Autowired
	private RedissonCache<?> redissonCache;
	
	@Autowired
	private IPsiSalesPaymentRecordDao iPsiSalesPaymentRecordDao;

	@Autowired
	private IPsiOrderFollowRecordDao orderFollowRecordDao;
	
	@Autowired
    UcmpAesConfig ucmpAesConfig;
	
	@Autowired
	private EmdmConsumer emdmConsumer;
	
	public enum PayTypeEnum{ 
		ALIPAY("2500"),//支付宝
		WECHAT("2501"),//微信
		FAST("2503"),//快捷
		POS("2505"),//POS
		TRANSFER("2506"),//转账
		CASH("2507")//现金
		;
    	
    	private String value;
    	
        public String value() {
            return this.value;
        }
        
        PayTypeEnum(String value) {
            this.value = value;
        }
        
       /* public static String getCodeOne(String codeTwo) {
            for (PayTypeEnum item: PayTypeEnum.values()) {
                if(item.codeTwo.equals(codeTwo)){
                    return item.codeOne;
                }
            }
            return null;
        }*/
    }
	
	@Override
	@Transactional
	public void payCallBack(PayCallBackDto payCallBackDto) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		//查询付款/退款记录是否存在
		PsiSalesPaymentRecordEntity recordEntity = new PsiSalesPaymentRecordEntity(); 
		recordEntity.setOrderNo(payCallBackDto.getOrderNum());
		recordEntity.setPayStatus("2800");
		List<PsiSalesPaymentRecordEntity> recordEntityList = this.iPsiSalesPaymentRecordDao.selectBySelective(recordEntity);
		if(CollectionUtil.isNotEmpty(recordEntityList)){
			Double receivedPrice = 0.0 ;//已收金额
			Double notReceivedPrice = 0.0;//未收金额
			Double amount = Double.parseDouble(payCallBackDto.getAmount())/100;
			//查询订单信息
			OrderPaymentInfoDto dto = this.orderPayDao.queryOrderInfo(recordEntityList.get(0).getRecordId(),null, null);
			if(dto.getReceivedPrice()==null){
				dto.setReceivedPrice(0.0);
			}
			if(dto.getNotReceivedPrice()==null){
				dto.setReceivedPrice(0.0);
			}
			if(Constants.CodeEnum.smpCode.value().equals(payCallBackDto.getStatus())){
				if(Integer.parseInt(payCallBackDto.getNotifyType()) == 1){
					recordEntity.setPayStatus("2801");//付款成功
					receivedPrice = dto.getReceivedPrice() + amount;
					notReceivedPrice = dto.getNotReceivedPrice() - amount;
				}else{
					recordEntity.setPayStatus("2804");//退款成功
					receivedPrice = dto.getReceivedPrice() - amount;
					notReceivedPrice = dto.getNotReceivedPrice() + amount;
				}
				//更新订单已收金额、未收金额
			}else{
				if(Integer.parseInt(payCallBackDto.getNotifyType()) == 1){
					recordEntity.setPayStatus("2802");//付款失败
				}else{
					recordEntity.setPayStatus("2805");//退款失败
				}
			}
			//修改付款记录
			recordEntity.setRecordId(recordEntityList.get(0).getRecordId());
			recordEntity.setSerialNumber(payCallBackDto.getPaymentCenterNum());
			recordEntity.setUpdateDate(new Date());
			recordEntity.setUpdateBy(user.getPartyId());
			this.iPsiSalesPaymentRecordDao.updateSelective(recordEntity);
			//如果是小定项目，则需要锁定库存车辆
			if(recordEntityList.get(0).getPaymentItem().equals(Constants.paymentItem.INTENTIONPAY.value())){
				PsiCarStockInfoEntity psiCarStockInfoEntity = new PsiCarStockInfoEntity();
				psiCarStockInfoEntity.setStockId(dto.getStockId());
				psiCarStockInfoEntity.setStockState(Constants.STOCK_STATUS.Reserved.value());
				psiCarStockInfoEntity.setUpdatedBy(user.getPartyId());
				psiCarStockInfoEntity.setUpdatedDate(new Date());
				this.iPsiCarStockInfoDao.updateSelective(psiCarStockInfoEntity);
			}
			//修改订单信息
			this.orderPayDao.updateOrderInfo(receivedPrice,notReceivedPrice,dto.getOrderInfoId(),user.getPartyId(),
					recordEntityList.get(0).getPaymentItem(),amount,payCallBackDto.getPayTime(),recordEntity.getPayStatus());
			//订单状态记录
			String orderStatus = null;
			if(Objects.equals(recordEntityList.get(0).getPaymentItem(),"6701")){
				orderStatus = "7402";
			}
			if(new BigDecimal(notReceivedPrice).compareTo(BigDecimal.ZERO) == 0){
				orderStatus = "7404";
			}
			if(Objects.nonNull(orderStatus)){
				PsiOrderFollowRecordEntity orderFollowRecordEntity = new PsiOrderFollowRecordEntity();
				orderFollowRecordEntity.generatePk();
				orderFollowRecordEntity.setOrderInfoId(dto.getOrderInfoId());
				orderFollowRecordEntity.setFollowStatus(orderStatus);
				orderFollowRecordEntity.setCreatedBy(user.getPartyId());
				orderFollowRecordEntity.setCreatedDate(new Date());
				orderFollowRecordEntity.setIsEnable("01");
				orderFollowRecordEntity.setIsDelete("00");
				orderFollowRecordDao.insert(orderFollowRecordEntity);
			}

		}
	}

	@Override
	public String paymentUnitorderPay(PayDto payDto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		//添加支付记录
		PsiSalesPaymentRecordEntity psiSalesPaymentRecordEntity = new PsiSalesPaymentRecordEntity();
		psiSalesPaymentRecordEntity.generatePk();
		psiSalesPaymentRecordEntity.setRecordCode(this.payCode());
		//查询业务订单号
		String orderNo = this.orderPayDao.getOrderNo(payDto.getOrderId());
		payDto.setOrderNo(orderNo);
		//根据车辆主体查询支付相关信息
		SysPayConfigPk sysPayConfigPk = new SysPayConfigPk(payDto.getRevertBody());
		sysPayConfigPk.setRevertBody("7903");
		SysPayConfigEntity sysPayConfigEntity = this.iSysPayConfigDao.load(sysPayConfigPk);
		String result = this.smpConsumer.paymentUnitorderPay(payDto,sysPayConfigEntity);
		if(PayTypeEnum.ALIPAY.value().equals(payDto.getPaytype())||PayTypeEnum.WECHAT.value().equals(payDto.getPaytype())){
			LOGGER.info("====paymentUnitorderPay结果===="+result);
			if(StringUtil.isNotEmpty(result)){
				SmpReturnDto<Map<String,String>> smpReturnDto = JsonBeanUtil.jsonToBean(result, SmpReturnDto.class);
				if(Constants.CodeEnum.smpCode.value().equals(smpReturnDto.getCode())){
					psiSalesPaymentRecordEntity.setCreateBy(user.getPartyId());
					psiSalesPaymentRecordEntity.setCreateDate(new Date());
					psiSalesPaymentRecordEntity.setOrderInfoId(payDto.getOrderId());
					psiSalesPaymentRecordEntity.setPaymentAmount(new BigDecimal(payDto.getAmount()));
					psiSalesPaymentRecordEntity.setPaymentItem(payDto.getSubject());
					psiSalesPaymentRecordEntity.setProceedsBy(user.getPartyId());
					psiSalesPaymentRecordEntity.setOrderNo(payDto.getOrderNo());
					psiSalesPaymentRecordEntity.setPaymentMethod(payDto.getPaytype());
					psiSalesPaymentRecordEntity.setPayStatus("2800");
					LOGGER.info("====添加微信/支付宝支付记录参数===="+JsonBeanUtil.beanToJson(psiSalesPaymentRecordEntity));
					this.iPsiSalesPaymentRecordDao.insert(psiSalesPaymentRecordEntity);
					return smpReturnDto.getData().get("payinfo");
				}else{
					throw new Exception(smpReturnDto.getMsg());
				}
			}else{
				throw new Exception("获取支付二维码异常");
			}
		}else{
			psiSalesPaymentRecordEntity.setCreateBy(user.getPartyId());
			psiSalesPaymentRecordEntity.setCreateDate(new Date());
			psiSalesPaymentRecordEntity.setOrderInfoId(payDto.getOrderId());
			psiSalesPaymentRecordEntity.setPaymentAmount(new BigDecimal(payDto.getAmount()));
			psiSalesPaymentRecordEntity.setPaymentItem(payDto.getSubject());
			psiSalesPaymentRecordEntity.setProceedsBy(user.getPartyId());
			psiSalesPaymentRecordEntity.setOrderNo(payDto.getOrderNo());
			psiSalesPaymentRecordEntity.setPaymentMethod(payDto.getPaytype());
			psiSalesPaymentRecordEntity.setPayStatus("2800");
			LOGGER.info("====添加POS支付记录参数===="+JsonBeanUtil.beanToJson(psiSalesPaymentRecordEntity));
			this.iPsiSalesPaymentRecordDao.insert(psiSalesPaymentRecordEntity);
			Map<String,String> map= new HashMap<>();
			map.put("BUSINESS_ID", "100000003");
			map.put("AMOUNT", String.valueOf(Double.parseDouble(payDto.getAmount())));
			map.put("ORDER_NO", sysPayConfigEntity.getAppCode()+"_UCMP_"+payDto.getOrderNo());
			return JsonBeanUtil.beanToJson(map);
		}
	}
	
	private String payCode() {
		StringBuilder payCode=new StringBuilder("PAY");
		String dateStr=new SimpleDateFormat("yyyyMMdd").format(new Date());
		payCode.append(dateStr);
		String str= String.format("%08d", redissonCache.incrBy("PAYRECORDCDOE", 1L));
		payCode.append(str);
		return payCode.toString();
	}

	/*public static void main(String[] args) {
//		String result="{\"code\":\"000000\",\"msg\":\"SUCCESS\",\"data\":{\"payinfo\":\"https://syb.allinpay.com/apiweb/h5unionpay/native?key=1QNb9SsY7cJmCz8U5eI575XN\"}}";
//		SmpReturnDto<Map<String,String>> smpReturnDto = JsonBeanUtil.jsonToBean(result, SmpReturnDto.class);
//		LOGGER.info("====="+smpReturnDto.getData().get("payinfo"));
//		PsiSalesPaymentRecordEntity psiSalesPaymentRecordEntity = new PsiSalesPaymentRecordEntity();
//		psiSalesPaymentRecordEntity.generatePk();
//		LOGGER.info("====="+psiSalesPaymentRecordEntity.getRecordId());
//		String orderNum = "P08_UCMP_1234567";
//		LOGGER.info("====="+Long.parseLong(orderNum.substring(orderNum.lastIndexOf('_')+1)));
		StringBuilder payCode=new StringBuilder("PAY");
		String dateStr=new SimpleDateFormat("yyyyMMddHHmmSS").format(new Date());
		payCode.append(dateStr);
		String str= String.format("%08d", 1);
		payCode.append(str);
		LOGGER.info("====="+payCode.toString());
	}*/

	@Override
	public String paymentRefund(PayRefundDto payRefundDto) throws Exception {
		String result = this.smpConsumer.paymentRefund(payRefundDto);
		LOGGER.info("====paymentRefund结果===="+result);
		if(StringUtil.isNotEmpty(result)){
			SmpReturnDto<String> smpReturnDto = JsonBeanUtil.jsonToBean(result, SmpReturnDto.class);
			if(Constants.CodeEnum.smpCode.value().equals(smpReturnDto.getCode())){
				return smpReturnDto.getData();
			}else{
				throw new Exception(smpReturnDto.getMsg());
			}
		}else{
			throw new Exception("退款异常");
		}
	}

	@Override
	public SysPayConfigEntity revertBodyPayInfo(String revertBody) throws Exception {
		//根据车辆主体查询支付相关信息
		SysPayConfigPk sysPayConfigPk = new SysPayConfigPk(revertBody);
		return this.iSysPayConfigDao.load(sysPayConfigPk);
	}

	@Override
	@Transactional
	public Boolean addPaymentRecord(AddPaymentRecordDto addPaymentRecordDto) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		Double amount = Double.parseDouble(addPaymentRecordDto.getAmount());
		//查询订单信息
		OrderPaymentInfoDto dto = this.orderPayDao.queryOrderInfo(null,addPaymentRecordDto.getOrderId(), null);
		/*Double receivedPrice;
		if(dto.getReceivedPrice() !=null){
			receivedPrice = dto.getReceivedPrice() + amount;//已收金额
		}else{
			receivedPrice = amount;//已收金额
		}
		Double notReceivedPrice;
		if(dto.getNotReceivedPrice() !=null){
			notReceivedPrice = dto.getNotReceivedPrice() - amount;//未收金额
		}else{
			return false;
		}*/
		//添加支付记录
		PsiSalesPaymentRecordEntity psiSalesPaymentRecordEntity = new PsiSalesPaymentRecordEntity();
		psiSalesPaymentRecordEntity.generatePk();
		psiSalesPaymentRecordEntity.setRecordCode(this.payCode());
		psiSalesPaymentRecordEntity.setCreateBy(user.getPartyId());
		psiSalesPaymentRecordEntity.setCreateDate(new Date());
		psiSalesPaymentRecordEntity.setOrderInfoId(addPaymentRecordDto.getOrderId());
		psiSalesPaymentRecordEntity.setOrderNo(dto.getOrderNo());
		psiSalesPaymentRecordEntity.setPaymentAmount(new BigDecimal(addPaymentRecordDto.getAmount()));
		psiSalesPaymentRecordEntity.setPaymentItem(addPaymentRecordDto.getSubject());
		psiSalesPaymentRecordEntity.setProceedsBy(user.getPartyId());
		psiSalesPaymentRecordEntity.setPaymentMethod(addPaymentRecordDto.getPaytype());
		psiSalesPaymentRecordEntity.setPayStatus("2806");
		if(PayTypeEnum.TRANSFER.value().equals(addPaymentRecordDto.getPaytype())){
			psiSalesPaymentRecordEntity.setPaymentAccount(addPaymentRecordDto.getPaymentAccount());
			psiSalesPaymentRecordEntity.setAccountName(addPaymentRecordDto.getAccountName());
		}
		LOGGER.info("====添加线下付款(转账或现金添加付款记录)记录参数===="+JsonBeanUtil.beanToJson(psiSalesPaymentRecordEntity));
		this.iPsiSalesPaymentRecordDao.insert(psiSalesPaymentRecordEntity);
		//修改订单信息
		this.orderPayDao.updateOrderInfo(null,null,dto.getOrderInfoId(),user.getPartyId(),
				addPaymentRecordDto.getSubject(),amount,null,null);
		//订单状态记录
		/*String orderStatus = null;
		if(Objects.equals(addPaymentRecordDto.getSubject(),"6701")){
			orderStatus = "7402";
		}
		if(new BigDecimal(notReceivedPrice).compareTo(BigDecimal.ZERO) == 0){
			orderStatus = "7404";
		}
		if(Objects.nonNull(orderStatus)){
			PsiOrderFollowRecordEntity orderFollowRecordEntity = new PsiOrderFollowRecordEntity();
			orderFollowRecordEntity.generatePk();
			orderFollowRecordEntity.setOrderInfoId(dto.getOrderInfoId());
			orderFollowRecordEntity.setFollowStatus(orderStatus);
			orderFollowRecordEntity.setCreatedBy(user.getPartyId());
			orderFollowRecordEntity.setCreatedDate(new Date());
			orderFollowRecordEntity.setIsEnable("01");
			orderFollowRecordEntity.setIsDelete("00");
			orderFollowRecordDao.insert(orderFollowRecordEntity);
		}*/
		return true;
	}

	/*public static void main(String[] args) {
		String amount="1";
		LOGGER.info("======="+(String.valueOf(Double.parseDouble(amount))));
	}*/

	@Override
	public int bankTransferStatement(SapBankTransferStatementDto sapBankTransferStatementDto) {
		//校验流水是否存在
		QueryStatementParamsDto queryStatementParamsDto = new QueryStatementParamsDto();
		queryStatementParamsDto.setZbiiln(sapBankTransferStatementDto.getZbiiln());
		List<QueryBankStatementDto> list = this.orderPayDao.queryBankStatementInfo(queryStatementParamsDto);
		if(list.size()>0){
			return -1;
		}else{
			this.orderPayDao.bankTransferStatement(sapBankTransferStatementDto);
		}
		return 0;
	}

	@Override
	public PageInfo<QueryOrderInfoDto> queryPaymentRecordInfo(QueryOrderParamsDto queryOrderParamsDto) throws Exception {
		if(StringUtil.isNotEmpty(queryOrderParamsDto.getCustomerPhone())){
			queryOrderParamsDto.setCustomerPhone(AesUtils.encryptHex(queryOrderParamsDto.getCustomerPhone(), ucmpAesConfig.getSecret()));
		}
		PageHelper.startPage(queryOrderParamsDto.getPageNum(), queryOrderParamsDto.getPageSize());
		List<QueryOrderInfoDto> orderInfoDtoList=this.orderPayDao.queryPaymentRecordInfo(queryOrderParamsDto);
		for (QueryOrderInfoDto queryOrderInfoDto : orderInfoDtoList) {
			String customerIphone = AesUtils.decryptHex(queryOrderInfoDto.getCustomerPhone(), ucmpAesConfig.getSecret());
			queryOrderInfoDto.setCustomerPhone(customerIphone);
		}
		return new PageInfo<>(orderInfoDtoList);
	}

	@Override
	public void exportPaymentRecordInfo(QueryOrderParamsDto queryOrderParamsDto, HttpServletResponse response) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		if(StringUtil.isNotEmpty(queryOrderParamsDto.getCustomerPhone())){
			queryOrderParamsDto.setCustomerPhone(AesUtils.encryptHex(queryOrderParamsDto.getCustomerPhone(), ucmpAesConfig.getSecret()));
		}
		PageHelper.startPage(queryOrderParamsDto.getPageNum(), queryOrderParamsDto.getPageSize());
		List<QueryOrderInfoDto> orderInfoDtoList=this.orderPayDao.queryPaymentRecordInfo(queryOrderParamsDto);
		for (QueryOrderInfoDto queryOrderInfoDto : orderInfoDtoList) {
			String customerIphone = AesUtils.decryptHex(queryOrderInfoDto.getCustomerPhone(), ucmpAesConfig.getSecret());
			if(ucmpAesConfig.getWhite().equals(user.getPartyId())){
				queryOrderInfoDto.setCustomerPhone(customerIphone);
			}else{
				queryOrderInfoDto.setCustomerPhone(ucmpAesConfig.dataMask(customerIphone, 3, 7, "****"));
			}
		}
		EasyExcelUtils.webWriteExcel(response,orderInfoDtoList,QueryOrderInfoDto.class,"收款管理统计");
	}

	@Override
	public RecordDetailsDto queryPaymentRecordDetails(String recordCode) {
		RecordDetailsDto dto = new RecordDetailsDto();
		//查询收款单信息
		PayDetailsDto payDetailsDto =this.orderPayDao.queryPayDetails(recordCode);
		dto.setPayDetailsDto(payDetailsDto);
		//查询流水确认信息
		StatementDetailsDto statementDetailsDto = this.orderPayDao.queryStatementDetails(recordCode);
		dto.setStatementDetailsDto(statementDetailsDto);
		return dto;
	}

	@Override
	public PageInfo<QueryBankStatementDto> queryBankStatementInfo(QueryStatementParamsDto queryStatementParamsDto) {
		PageHelper.startPage(queryStatementParamsDto.getPageNum(), queryStatementParamsDto.getPageSize());
		List<QueryBankStatementDto> list = this.orderPayDao.queryBankStatementInfo(queryStatementParamsDto);
		return new PageInfo<>(list);
	}

	@Override
	public void rejectPayInfo(PayRejectDto payRejectDto) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		payRejectDto.setPartyId(user.getPartyId());
		this.orderPayDao.rejectPayInfo(payRejectDto);
	}

	@Override
	@Transactional
	public int matchingPayInfo(PayMatchingDto payMatchingDto) throws IOException {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		payMatchingDto.setPartyId(user.getPartyId());
		//查询收款单信息
		PayDetailsDto payDetailsDto =this.orderPayDao.queryPayDetails(payMatchingDto.getRecordCode());
		//一个收款单只能匹配一个流水,存在已匹配流水，匹配失败
		if(payDetailsDto.getMatchingId() != null){
			return -1;
		}
		//查询流水信息
		QueryStatementParamsDto queryStatementParamsDto = new QueryStatementParamsDto();
		queryStatementParamsDto.setZbiiln(payMatchingDto.getZbiiln());
		List<QueryBankStatementDto> list = this.orderPayDao.queryBankStatementInfo(queryStatementParamsDto);
		//收款金额大于可匹配金额,匹配失败
		if(Double.compare(payDetailsDto.getAmount(), list.get(0).getMatchingAmount())>0){
			return -2;
		}
		//修改可匹配金额
		Double matchingAmount = list.get(0).getMatchingAmount()-payDetailsDto.getAmount();
		this.orderPayDao.updateBankStatementInfo(payMatchingDto.getZbiiln(),matchingAmount,payMatchingDto.getPartyId());
		//匹配成功，修改收款状态，并修改订单的已收金额、未收金额
		OrderPaymentInfoDto dto = this.orderPayDao.queryOrderInfo(null,null,payMatchingDto.getRecordCode());
		Double receivedPrice;
		if(dto.getReceivedPrice() !=null){
			receivedPrice = dto.getReceivedPrice() + payDetailsDto.getAmount();//已收金额
		}else{
			receivedPrice = payDetailsDto.getAmount();//已收金额
		}
		Double notReceivedPrice;
		if(dto.getNotReceivedPrice() !=null && dto.getNotReceivedPrice()>0){
			notReceivedPrice = dto.getNotReceivedPrice() - payDetailsDto.getAmount();//未收金额
		}else{
			//未收金额为空或者小于等于0时匹配失败
			return -3;
		}
		//推送SAP
		SapPayDto sapPayDto = new SapPayDto();
		sapPayDto.setZbussys("UCMP");
		sapPayDto.setZborderFq(dto.getOrderNo());
		sapPayDto.setZztimestemp(String.valueOf(System.currentTimeMillis()));
		sapPayDto.setZband("Y");
		sapPayDto.setZzfptno(payMatchingDto.getZbiiln());
		sapPayDto.setBukrs(list.get(0).getBukrs());
		sapPayDto.setZshh(list.get(0).getZpwbankn());
		if(payDetailsDto.getPaymentMethod().equals(PayTypeEnum.TRANSFER.value())){
			sapPayDto.setZzftd("40");
			sapPayDto.setZpaymeth("20");
			sapPayDto.setField01(list.get(0).getZdbankn());
		}else if(payDetailsDto.getPaymentMethod().equals(PayTypeEnum.CASH.value())){
			sapPayDto.setZpaymeth("30");
		}else{
			sapPayDto.setZpaymeth("10");
		}
		sapPayDto.setZzfstatus("10");
		sapPayDto.setZdate(list.get(0).getZtrdate());
		sapPayDto.setWrbtr(String.valueOf(payDetailsDto.getAmount()));
		sapPayDto.setWaers("CNY");
//		sapPayDto.setField01(payDetailsDto.getPaymentAccount());
		sapPayDto.setField02(payDetailsDto.getPaymentItemName());
		String result = this.emdmConsumer.pushSapPayInfo(sapPayDto);
		LOGGER.info("=====营销收款同步返回结果====="+result);
		//修改订单信息
		this.orderPayDao.updateOrderInfo(receivedPrice, notReceivedPrice, dto.getOrderInfoId(), payMatchingDto.getPartyId(),
				payDetailsDto.getPaymentItem(), payDetailsDto.getAmount(), list.get(0).getReceiptDate(), "2801");
		//添加流水匹配确认记录
		StatementDetailsDto detailsDto = new StatementDetailsDto();
		Long recordId = RandomIDGennerator.get().generate();
		detailsDto.setRecordId(recordId);
		detailsDto.setRecordCode(payMatchingDto.getRecordCode());
		detailsDto.setZbiiln(payMatchingDto.getZbiiln());
		detailsDto.setZdname(list.get(0).getZdname());
		detailsDto.setZdbankn(list.get(0).getZdbankn());
		detailsDto.setReceiptMethod(payDetailsDto.getPaymentMethod());
		detailsDto.setZcrtrsamt(payDetailsDto.getAmount());
		detailsDto.setReceiptDate(list.get(0).getReceiptDate());
		detailsDto.setPartyId(payMatchingDto.getPartyId());
		detailsDto.setApprovalOperation("01");
		this.orderPayDao.addMatchingRecord(detailsDto);
		//修改收款记录信息
		this.orderPayDao.updatePayRecordInfo(detailsDto.getRecordId(),payMatchingDto.getPartyId(),payMatchingDto.getRecordCode(),"2801");
		return 1;
	}

	@Override
	@Transactional
	public int verifyPayInfo(StatementDetailsDto statementDetailsDto) throws IOException {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		statementDetailsDto.setPartyId(user.getPartyId());
		//查询收款单信息
		PayDetailsDto payDetailsDto =this.orderPayDao.queryPayDetails(statementDetailsDto.getRecordCode());
		//一个收款单只能匹配一个流水,存在已匹配流水，匹配失败
		if(payDetailsDto.getMatchingId() != null){
			return -1;
		}
		//匹配成功，修改收款状态，并修改订单的已收金额、未收金额
		OrderPaymentInfoDto dto = this.orderPayDao.queryOrderInfo(null,null,statementDetailsDto.getRecordCode());
		Double receivedPrice;
		if(dto.getReceivedPrice() !=null){
			receivedPrice = dto.getReceivedPrice() + payDetailsDto.getAmount();//已收金额
		}else{
			receivedPrice = payDetailsDto.getAmount();//已收金额
		}
		Double notReceivedPrice;
		if(dto.getNotReceivedPrice() !=null && dto.getNotReceivedPrice()>0){
			notReceivedPrice = dto.getNotReceivedPrice() - payDetailsDto.getAmount();//未收金额
		}else{
			//未收金额为空或者小于等于0时匹配失败
			return -2;
		}
		//推送SAP
		SapPayDto sapPayDto = new SapPayDto();
		sapPayDto.setZbussys("UCMP");
		sapPayDto.setZborderFq(dto.getOrderNo());
		sapPayDto.setZztimestemp(String.valueOf(System.currentTimeMillis()));
		sapPayDto.setZband("S");
		sapPayDto.setZzfptno(statementDetailsDto.getZbiiln());
		sapPayDto.setZshh(statementDetailsDto.getRecordCode());
		if(payDetailsDto.getPaymentMethod().equals(PayTypeEnum.TRANSFER.value())){
			sapPayDto.setZzftd("40");
			sapPayDto.setZpaymeth("20");
			sapPayDto.setField01(payDetailsDto.getPaymentAccount());
		}else if(payDetailsDto.getPaymentMethod().equals(PayTypeEnum.CASH.value())){
			sapPayDto.setZpaymeth("30");
		}else{
			sapPayDto.setZpaymeth("10");
		}
		sapPayDto.setZzfstatus("10");
		sapPayDto.setZdate(statementDetailsDto.getReceiptDate().substring(0, 10));
		sapPayDto.setWrbtr(String.valueOf(payDetailsDto.getAmount()));
		sapPayDto.setWaers("CNY");
		sapPayDto.setField02(payDetailsDto.getPaymentItemName());
		String result = this.emdmConsumer.pushSapPayInfo(sapPayDto);
		LOGGER.info("=====确认营销收款同步返回结果====="+result);
		//修改订单信息
		this.orderPayDao.updateOrderInfo(receivedPrice, notReceivedPrice, dto.getOrderInfoId(), statementDetailsDto.getPartyId(),
				payDetailsDto.getPaymentItem(), payDetailsDto.getAmount(), statementDetailsDto.getReceiptDate(), "2801");
		//添加流水匹配确认记录
		StatementDetailsDto detailsDto = new StatementDetailsDto();
		Long recordId = RandomIDGennerator.get().generate();
		detailsDto.setRecordId(recordId);
		detailsDto.setRecordCode(statementDetailsDto.getRecordCode());
		detailsDto.setZbiiln(statementDetailsDto.getZbiiln());
		detailsDto.setZdname(statementDetailsDto.getZdname());
		detailsDto.setZdbankn(statementDetailsDto.getZdbankn());
		detailsDto.setReceiptMethod(payDetailsDto.getPaymentMethod());
		detailsDto.setZcrtrsamt(payDetailsDto.getAmount());
		detailsDto.setReceiptDate(statementDetailsDto.getReceiptDate());
		detailsDto.setPartyId(statementDetailsDto.getPartyId());
		detailsDto.setApprovalOperation("02");
		detailsDto.setFileUrl(statementDetailsDto.getFileUrl());
		detailsDto.setMaterialId(statementDetailsDto.getMaterialId());
		this.orderPayDao.addMatchingRecord(detailsDto);
		//修改收款记录信息
		this.orderPayDao.updatePayRecordInfo(detailsDto.getRecordId(),statementDetailsDto.getPartyId(),statementDetailsDto.getRecordCode(),"2801");
		return 1;
	}

	@Override
	@Transactional
	public int unbindPayInfo(PayMatchingDto payMatchingDto) throws IOException {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		payMatchingDto.setPartyId(user.getPartyId());
		//查询收款单信息
		PayDetailsDto payDetailsDto =this.orderPayDao.queryPayDetails(payMatchingDto.getRecordCode());
		//查询流水信息
		QueryStatementParamsDto queryStatementParamsDto = new QueryStatementParamsDto();
		queryStatementParamsDto.setZbiiln(payMatchingDto.getZbiiln());
		List<QueryBankStatementDto> list = this.orderPayDao.queryBankStatementInfo(queryStatementParamsDto);
		//查询流水确认信息
		StatementDetailsDto statementDetailsDto = this.orderPayDao.queryStatementDetails(payMatchingDto.getRecordCode());
		//推送SAP
		SapPayDto sapPayDto = new SapPayDto();
		sapPayDto.setZbussys("UCMP");
		sapPayDto.setZborderFq(payDetailsDto.getOrderNum());
		sapPayDto.setZztimestemp(String.valueOf(System.currentTimeMillis()));
		sapPayDto.setZband("N");
//		sapPayDto.setZshh(payMatchingDto.getRecordCode());
		if(CollectionUtil.isEmpty(list)){
			sapPayDto.setZshh(statementDetailsDto.getZdbankn());
		}else{
			sapPayDto.setBukrs(list.get(0).getBukrs());
			sapPayDto.setZshh(list.get(0).getZpwbankn());
			sapPayDto.setZzfptno(payMatchingDto.getZbiiln());
			//修改可匹配金额
			Double matchingAmount = list.get(0).getMatchingAmount()+payDetailsDto.getAmount();
			this.orderPayDao.updateBankStatementInfo(payMatchingDto.getZbiiln(),matchingAmount,payMatchingDto.getPartyId());
		}
		
		if(payDetailsDto.getPaymentMethod().equals(PayTypeEnum.TRANSFER.value())){
			sapPayDto.setZzftd("40");
			sapPayDto.setZpaymeth("20");
			sapPayDto.setField01(list.get(0).getZdbankn());
		}else if(payDetailsDto.getPaymentMethod().equals(PayTypeEnum.CASH.value())){
			sapPayDto.setZpaymeth("30");
		}else{
			sapPayDto.setZpaymeth("10");
		}
		sapPayDto.setZzfstatus("10");
		sapPayDto.setZdate(statementDetailsDto.getReceiptDate().substring(0, 10));
		sapPayDto.setWrbtr(String.valueOf(payDetailsDto.getAmount()));
		sapPayDto.setWaers("CNY");
		sapPayDto.setField02(payDetailsDto.getPaymentItemName());
		String result = this.emdmConsumer.pushSapPayInfo(sapPayDto);
		LOGGER.info("=====解绑营销收款同步返回结果====="+result);
		
		//查询订单信息
		OrderPaymentInfoDto dto = this.orderPayDao.queryOrderInfo(null,null,payMatchingDto.getRecordCode());
		Double receivedPrice;
		if(dto.getReceivedPrice() !=null && dto.getNotReceivedPrice()>0){
			receivedPrice = dto.getReceivedPrice() - payDetailsDto.getAmount();//已收金额
		}else{
			//已收金额为空或者小于等于0时匹配失败
			return -2;
		}
		Double notReceivedPrice;
		if(dto.getNotReceivedPrice() !=null ){
			notReceivedPrice = dto.getNotReceivedPrice() + payDetailsDto.getAmount();//未收金额
		}else{
			notReceivedPrice = payDetailsDto.getAmount();
		}
		String payStatus=null;
		if(notReceivedPrice >= 0){
			payStatus = "7403";
		}
		//修改订单信息-回退已收金额、未收金额
		this.orderPayDao.rollbackOrderInfo(receivedPrice, notReceivedPrice, dto.getOrderInfoId(), payMatchingDto.getPartyId(),
				payDetailsDto.getPaymentItem(), payDetailsDto.getAmount(), null, payStatus);
		//添加流水匹配确认记录
		StatementDetailsDto detailsDto = new StatementDetailsDto();
		Long recordId = RandomIDGennerator.get().generate();
		detailsDto.setRecordId(recordId);
		detailsDto.setRecordCode(statementDetailsDto.getRecordCode());
		detailsDto.setZbiiln(statementDetailsDto.getZbiiln());
		detailsDto.setZdname(statementDetailsDto.getZdname());
		detailsDto.setZdbankn(statementDetailsDto.getZdbankn());
		detailsDto.setReceiptMethod(payDetailsDto.getPaymentMethod());
		detailsDto.setZcrtrsamt(payDetailsDto.getAmount());
		detailsDto.setReceiptDate(statementDetailsDto.getReceiptDate());
		detailsDto.setPartyId(payMatchingDto.getPartyId());
		detailsDto.setApprovalOperation("03");
		detailsDto.setFileUrl(statementDetailsDto.getFileUrl());
		detailsDto.setMaterialId(statementDetailsDto.getMaterialId());
		this.orderPayDao.addMatchingRecord(detailsDto);
		//修改收款状态
		this.orderPayDao.updatePayRecordInfo(detailsDto.getRecordId(),payMatchingDto.getPartyId(),payMatchingDto.getRecordCode(),"2806");
		return 1;
	}
	
	public static void main(String[] args) {
		LOGGER.info("====="+RandomIDGennerator.get().generate());
	}
}
