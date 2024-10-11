package com.exp.ucmp.logistics.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.exp.ucmp.apig.esb.consumer.VlmsProperties;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IPsiCarTransferApplyDao;
import com.exp.ucmp.dao.IPsiDispatchInfoDao;
import com.exp.ucmp.dao.IPsiTransferRouteInfoDao;
import com.exp.ucmp.entity.PsiCarTransferApplyEntity;
import com.exp.ucmp.entity.PsiDispatchInfoEntity;
import com.exp.ucmp.entity.PsiTransferRouteInfoEntity;
import com.exp.ucmp.logistics.dao.LogisticsDao;
import com.exp.ucmp.logistics.dto.DispatchRequestDto;
import com.exp.ucmp.logistics.dto.TransitPointInfoDto;
import com.exp.ucmp.logistics.service.LogisticsService;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiTransferRouteInfoPk;

@Service
public class LogisticsServiceImpl implements LogisticsService{
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LogisticsServiceImpl.class);
	
	@Autowired
	private VlmsProperties vlmsProperties;
	
	@Autowired
	private LogisticsDao logisticsDao;
	
	@Autowired
	private IPsiDispatchInfoDao iPsiDispatchInfoDao;
	
	@Autowired
	private IPsiCarTransferApplyDao iPsiCarTransferApplyDao;
	
	@Autowired
	private IPsiTransferRouteInfoDao iPsiTransferRouteInfoDao;
	
	protected enum LogisticsEnum { 
    	// 提交调拨申请到ESB数据接口
		submitTransferApplication("/v1.0/vlms/goThroughApi");

        private String url;

        private LogisticsEnum(String value) {
            this.url = value;
        }
        public String url() {
            return this.url;
		}
	}

	@Override
	public String submitTransferApplication(DispatchRequestDto dispatchRequestDto) throws IOException {
		//参数转换
		Map<String,Object> paramMap=changeMap(dispatchRequestDto);
		LOGGER.info("==物流发运参数paramMap=="+JsonBeanUtil.beanToJson(paramMap));
		return this.requstEsb(paramMap, "UCMP", "VLMS", "S094079001A", vlmsProperties.getUri()+LogisticsEnum.submitTransferApplication.url);
	}

	private Map<String, Object> changeMap(DispatchRequestDto dispatchRequestDto) {
		Map<String,Object> paramMap=new HashMap<>();
		paramMap.put("ZBUSTP", dispatchRequestDto.getZbustp());//业务类型
		paramMap.put("VHCLE", dispatchRequestDto.getVhcle());//内部车辆编号
		paramMap.put("VHVIN", dispatchRequestDto.getVhvin());//车辆识别代码VIN
		paramMap.put("WERKS", dispatchRequestDto.getWerks());//发货工厂
		paramMap.put("requestNo", dispatchRequestDto.getRequestNo());//请求编号
		if(StringUtil.isEmpty(dispatchRequestDto.getStartNode())){
			paramMap.put("startNode",null );//出发节点
		}else{
			paramMap.put("startNode",dispatchRequestDto.getStartNode() );//出发节点
		}
		paramMap.put("LGORT", dispatchRequestDto.getLgort());//发货库位
		paramMap.put("Z_MATNR", dispatchRequestDto.getzMatnr());//变式物料号
		paramMap.put("KUNNR", dispatchRequestDto.getKunnr());//客户
		paramMap.put("NAME", dispatchRequestDto.getName());//客户名称
		if(StringUtil.isEmpty(dispatchRequestDto.getEndNode())){
			paramMap.put("endNode",null );//到达节点
		}else{
			paramMap.put("endNode",dispatchRequestDto.getEndNode() );//到达节点
		}
		if(StringUtil.isEmpty(dispatchRequestDto.getzRewerk())){
			paramMap.put("Z_REWERK",null );//收货工厂
		}else{
			paramMap.put("Z_REWERK",dispatchRequestDto.getzRewerk() );//收货工厂
		}
		paramMap.put("Z_RELGORT", dispatchRequestDto.getzRelgort());//收货库存地
		paramMap.put("Z_ADDRESS", dispatchRequestDto.getzAddress());//收货地址
		paramMap.put("Z_RECEIVER", dispatchRequestDto.getzReceiver());//接收人
		paramMap.put("Z_CONTACT", dispatchRequestDto.getzContact());//联系方式
		paramMap.put("WADAT", dispatchRequestDto.getWadat());//发货日期
		paramMap.put("LFIMG", dispatchRequestDto.getLfimg());//数量
		paramMap.put("MEINS", dispatchRequestDto.getMeins());//基本单位
		paramMap.put("startAddress", dispatchRequestDto.getStartAddress());//发货地址
		paramMap.put("carModel", dispatchRequestDto.getCarModel());//车型
		paramMap.put("senderList", dispatchRequestDto.getSenderList());//发货人联系方式
		paramMap.put("receiverList", dispatchRequestDto.getReceiverList());//收货人联系方式
		paramMap.put("businessType", dispatchRequestDto.getBusinessType());//发运类型
		paramMap.put("requestTime", dispatchRequestDto.getRequestTime());//请求时间
		paramMap.put("shippingTime", dispatchRequestDto.getShippingTime());//可发运时间
		paramMap.put("receivingTime", dispatchRequestDto.getReceivingTime());//可收货时间
		paramMap.put("carType", dispatchRequestDto.getCarType());//车辆类型
		return paramMap;
	}
	
	public String requstEsb(Map<String,Object> map,String sourcesystem, String targetsystem,String servicename,String url) throws IOException{
	   long now = System.currentTimeMillis();
	   long exp = now + 1000*180 ;//过期时间为 3 分钟
	   Map<String, Object> payloadMap = new HashMap<>();
	   LOGGER.info("==user_id=="+vlmsProperties.getUserId());
	   payloadMap.put("user_id", vlmsProperties.getUserId());
	   payloadMap.put("iat", now);
	   payloadMap.put("exp", exp);
	   LOGGER.info("==key=="+vlmsProperties.getKey());
	   String token = createJWT( vlmsProperties.getKey(),payloadMap);
	   return httpURLPOSTCase(now, token, map, sourcesystem, targetsystem, servicename,url);
   }
	
	public static String createJWT(String key, Map<String, Object> payloadMap) {
		// 私钥及加密算法
		Algorithm algorithm = Algorithm.HMAC256(key);
		// 设置头信息
		Map<String, Object> headerMap = new HashMap<>();
		headerMap.put("alg", "HS256");
		headerMap.put("typ", "JWT");
		String token = JWT.create().withHeader(headerMap).withPayload(payloadMap).sign(algorithm);
		return "Bearer "+token;
	}
	
	private static String httpURLPOSTCase(long now,String token,Map<String,Object> params, String sourcesystem, String targetsystem,String servicename,String methodUrl) {
	   SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	   HttpURLConnection connection = null;
       OutputStream dataout = null;
       BufferedReader reader = null;
       String line = null;
       try {
           URL url = new URL(methodUrl);
           connection = (HttpURLConnection) url.openConnection();// 根据URL生成HttpURLConnection
           connection.setDoOutput(true);// 设置是否向connection输出，因为这个是post请求，参数要放在http正文内，因此需要设为true,默认情况下是false
           connection.setRequestMethod("POST");// 设置请求方式为post,默认GET请求
           connection.setUseCaches(false);// post请求不能使用缓存设为false
           connection.setConnectTimeout(3000);// 连接主机的超时时间
           connection.setReadTimeout(3000);// 从主机读取数据的超时时间
           connection.setInstanceFollowRedirects(true);// 设置该HttpURLConnection实例是否自动执行重定向
           connection.setRequestProperty("connection", "Keep-Alive");// 连接复用
           connection.setRequestProperty("charset", "utf-8");

           connection.setRequestProperty("Content-Type", "application/json");
           connection.setRequestProperty("servicename", servicename);
           connection.setRequestProperty("sourcesystem", sourcesystem);
           connection.setRequestProperty("targetsystem", targetsystem);
           connection.setRequestProperty("timeStamp", sd.format(new Date(now)));
           connection.setRequestProperty("requestid", UUID.randomUUID().toString());
           connection.setRequestProperty("Authorization", token);
           connection.connect();// 建立TCP连接,getOutputStream会隐含的进行connect,所以此处可以不要

           dataout = new DataOutputStream(connection.getOutputStream());// 创建输入输出流,用于往连接里面输出携带的参数
			String body = JsonBeanUtil.beanToJson(params);
           dataout.write(body.getBytes());
           dataout.flush();
           dataout.close();

           if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
               reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));// 发送http请求
               StringBuilder result = new StringBuilder();
               // 循环读取流
               while ((line = reader.readLine()) != null) {
                   result.append(line).append(System.getProperty("line.separator"));//
               }
               LOGGER.info("==请求VLMS返回结果=="+result.toString());
               return result.toString();
           }
       } catch (IOException e) {
           LOGGER.error("e:",e);
       } finally {
           try {
               reader.close();
           } catch (IOException e) {
        	   LOGGER.error("e:",e);
           }
           connection.disconnect();
       }
	return null;
   }
	
	@Transactional
	@Override
	public Map<String, String> synTransitPointInfo(TransitPointInfoDto transitPointInfoDto) throws ParseException {
		Map<String,String> resultMap=new HashMap<>();
		Long partyId=AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
		SimpleDateFormat form;
		if(transitPointInfoDto.getArrivingTime().trim().length()>10){
			form=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}else{
			form=new SimpleDateFormat("yyyy-MM-dd");
		}
		//根据requestNo 匹配调拨申请
		PsiCarTransferApplyEntity psiCarTransferApplyEntity = new PsiCarTransferApplyEntity();
		psiCarTransferApplyEntity.setDispatchNumber(transitPointInfoDto.getRequestNo());
		List<PsiCarTransferApplyEntity> applyentityList = this.iPsiCarTransferApplyDao.selectBySelective(psiCarTransferApplyEntity);
		Long dispatchInfoId ;
		if(applyentityList!= null && !applyentityList.isEmpty()){
			//更新调度申请信息
			PsiCarTransferApplyEntity applyentity = new PsiCarTransferApplyEntity();
			applyentity.setTransferApplyId(applyentityList.get(0).getTransferApplyId());
			applyentity.setFeedbackEstimatedArrivalTime(form.parse(transitPointInfoDto.getArrivingTime()));
			Integer shippingStatus=Integer.parseInt(transitPointInfoDto.getShippingStatus());
			
			if(applyentityList.get(0).getTransferStatus()==null){
				if(shippingStatus==1){
					applyentity.setTransferStatus(Constants.TRANSFER_STATUS.WAIT_SHIPP.value());
				}else if(shippingStatus==2){
					applyentity.setTransferStatus(Constants.TRANSFER_STATUS.DISPATCH.value());
				}else if(shippingStatus==5){
					applyentity.setTransferStatus(Constants.TRANSFER_STATUS.CANCEL.value());
				}
			}else if(applyentityList.get(0).getTransferStatus().equals(Constants.TRANSFER_STATUS.WAIT_SHIPP.value())){
				if(shippingStatus==2){
					applyentity.setTransferStatus(Constants.TRANSFER_STATUS.DISPATCH.value());
				}else if(shippingStatus ==3){
					applyentity.setTransferStatus(Constants.TRANSFER_STATUS.TRANSPORT.value());
				}else if(shippingStatus==5){
					applyentity.setTransferStatus(Constants.TRANSFER_STATUS.CANCEL.value());
				}
			}else if(applyentityList.get(0).getTransferStatus().equals(Constants.TRANSFER_STATUS.DISPATCH.value())
					||applyentityList.get(0).getTransferStatus().equals(Constants.TRANSFER_STATUS.WAIT_OUTBOUND.value())
					||applyentityList.get(0).getTransferStatus().equals(Constants.TRANSFER_STATUS.OUTBOUND.value())){
				if(shippingStatus ==3){
					applyentity.setTransferStatus(Constants.TRANSFER_STATUS.TRANSPORT.value());
				}else if(shippingStatus==4){
					applyentity.setTransferStatus(Constants.TRANSFER_STATUS.WAIT_WAREHOUS.value());
				}else if(shippingStatus==5){
					applyentity.setTransferStatus(Constants.TRANSFER_STATUS.CANCEL.value());
				}
			}else if(applyentityList.get(0).getTransferStatus().equals(Constants.TRANSFER_STATUS.TRANSPORT.value())){
				if(shippingStatus==4){
					applyentity.setTransferStatus(Constants.TRANSFER_STATUS.WAIT_WAREHOUS.value());
				}
			}else if(applyentityList.get(0).getTransferStatus().equals(Constants.TRANSFER_STATUS.WAIT_CANCEL.value())){
				if(shippingStatus == 5){
					applyentity.setTransferStatus(Constants.TRANSFER_STATUS.CANCEL.value());
				}
			}else{
				applyentity.setTransferStatus(null);
			}
			//更新调度申请信息
			this.iPsiCarTransferApplyDao.updateSelective(applyentity);
			
			//查询调度信息是否存在，不存在新增，存在修改
			PsiDispatchInfoEntity psiDispatchInfoEntity = new PsiDispatchInfoEntity();
			psiDispatchInfoEntity.setDispatchApplyId(applyentityList.get(0).getTransferApplyId());
			List<PsiDispatchInfoEntity> infoEntityList = this.iPsiDispatchInfoDao.selectBySelective(psiDispatchInfoEntity);
			
			psiDispatchInfoEntity.setDispatchNumber(transitPointInfoDto.getRequestNo());
			psiDispatchInfoEntity.setDispatchStatus("240"+transitPointInfoDto.getShippingStatus());
			psiDispatchInfoEntity.setCarrierName(transitPointInfoDto.getCarrierName());
			psiDispatchInfoEntity.setDriverName(transitPointInfoDto.getDriverName());
			psiDispatchInfoEntity.setDriverPhone(transitPointInfoDto.getDriverMobile());
			psiDispatchInfoEntity.setCarLicense(transitPointInfoDto.getLicenseNumber());
			psiDispatchInfoEntity.setDeparture(this.logisticsDao.getAddressById(applyentityList.get(0).getStorageId()));
			psiDispatchInfoEntity.setDestination(this.logisticsDao.getAddressById(applyentityList.get(0).getTransferStorageId()));
			psiDispatchInfoEntity.setCarVin(transitPointInfoDto.getVin());
			psiDispatchInfoEntity.setIsEnable("01");
			psiDispatchInfoEntity.setIsDelete("00");
			psiDispatchInfoEntity.setCreatedBy(partyId);
			psiDispatchInfoEntity.setUpdatedBy(partyId);
			if("2".equals(transitPointInfoDto.getShippingStatus())){
				psiDispatchInfoEntity.setDispatchEffectiveTime(new Date());//调度生效时间
				psiDispatchInfoEntity.setActualDepartureTime(new Date());//实际出发时间
			}
			psiDispatchInfoEntity.setEstimatedTime(form.parse(transitPointInfoDto.getArrivingTime()));
			
			if(infoEntityList!=null && !infoEntityList.isEmpty()){
				dispatchInfoId=infoEntityList.get(0).getDispatchInfoId();
				//存在修改
				psiDispatchInfoEntity.setDispatchInfoId(dispatchInfoId);
				this.iPsiDispatchInfoDao.updateSelective(psiDispatchInfoEntity);
			}else{
				//不存在新增
				psiDispatchInfoEntity.generatePk();
				this.iPsiDispatchInfoDao.insert(psiDispatchInfoEntity);
				dispatchInfoId = psiDispatchInfoEntity.getDispatchInfoId();
			}
			//运输在途
			if("3".equals(transitPointInfoDto.getShippingStatus())){
				//查询在途点位信息
				PsiTransferRouteInfoEntity psiTransferRouteInfoEntity = new PsiTransferRouteInfoEntity();
				psiTransferRouteInfoEntity.setDispatchInfoId(dispatchInfoId);
				List<PsiTransferRouteInfoEntity> routeInfoEntityList = this.iPsiTransferRouteInfoDao.selectBySelective(psiTransferRouteInfoEntity);
				if(routeInfoEntityList!=null && !routeInfoEntityList.isEmpty()){
					//存在点位信息,先删除原有信息，再新增
					routeInfoEntityList.forEach(routeInfo ->{
						PsiTransferRouteInfoPk psiTransferRouteInfoPk=new PsiTransferRouteInfoPk(routeInfo.getRouteId());
						//删除
						this.iPsiTransferRouteInfoDao.delete(psiTransferRouteInfoPk);
					});
				}
				//新增
				List<PsiTransferRouteInfoEntity> listPsiTransferRouteInfoEntity = new ArrayList<>();
				transitPointInfoDto.getNowLocationList().forEach(nowlocation ->{
					PsiTransferRouteInfoEntity newRouteInfo=new PsiTransferRouteInfoEntity();
					newRouteInfo.setDispatchInfoId(dispatchInfoId);
					newRouteInfo.setCurrentAddress(nowlocation.getNowLocation());
					newRouteInfo.generatePk();
					newRouteInfo.setCreatedBy(partyId);
					newRouteInfo.setUpdatedBy(partyId);
					try {
						newRouteInfo.setRecordTime(form.parse(nowlocation.getOperateTime()));
					} catch (ParseException e) {
						LOGGER.error("时间格式转换报错",e);
					}
					listPsiTransferRouteInfoEntity.add(newRouteInfo);
				});
				this.iPsiTransferRouteInfoDao.batchInsert(listPsiTransferRouteInfoEntity);
			}
			
			resultMap.put("Code", "S");
			resultMap.put("Desc", "接收成功");
			resultMap.put("RequestId", UUID.randomUUID().toString());
			resultMap.put("ServiceName", "S079094001C");
		}else{
			resultMap.put("Code", "F");
			resultMap.put("Desc", "接收失败,调度申请不存在");
			resultMap.put("RequestId", UUID.randomUUID().toString());
			resultMap.put("ServiceName", "S079094001C");
		}
		return resultMap;
	} 

	public static void main(String[] args) {
		LOGGER.info("====UUID==="+UUID.randomUUID().toString());
	}
}
