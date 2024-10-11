package com.exp.ucmp.car.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.exp.ucmp.dao.IPsiCarStockInfoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.exp.ucmp.apig.smp.consumer.SmpConsumer;
import com.exp.ucmp.apig.tsp.consumer.TspConsumer;
import com.exp.ucmp.car.dao.ICarInfoDao;
import com.exp.ucmp.car.dto.CarMainInfoDto;
import com.exp.ucmp.car.dto.OptionalPartsDto;
import com.exp.ucmp.car.dto.TspBasicsCarInfoDto;
import com.exp.ucmp.car.service.BasicsCarInfoService;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.dao.IPsiCarOptionInfoDao;
import com.exp.ucmp.entity.PsiCarOptionInfoEntity;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.smp.dto.OrderDataDto;
import com.exp.ucmp.smp.dto.SmpCarInfoReturnDto;
import com.exp.ucmp.smp.dto.SmpReturnDto;
import com.exp.ucmp.tsp.dto.TspCarInfoReturnDto;
import com.exp.ucmp.tsp.dto.TspCarStatusDto;

@Service
public class BasicsCarInfoServiceImpl implements BasicsCarInfoService {
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicsCarInfoServiceImpl.class);
	
	@Autowired
	private ICarInfoDao iCarInfoDao;
	
	@Autowired
	private IPsiCarOptionInfoDao iPsiCarOptionInfoDao;
	
	@Autowired
	private SmpConsumer smpConsumer;
	
	@Autowired
	private TspConsumer tspConsumer;

	@Autowired
	private IPsiCarStockInfoDao iPsiCarStockInfoDao;
	
	private final String smpReturnCode="000000";
	
	@Autowired
	private UcmpAesConfig ucmpAesConfig;

	@Override
	public CarMainInfoDto getCarMainInfo(Long stockId,String carVin) throws Exception {
		Long partyId = AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
		//从数据库查询现有车辆信息
		CarMainInfoDto carCurDto=this.iCarInfoDao.getCarInfoByVin(stockId,carVin);
		LOGGER.info("===从数据库查询现有车辆信息==="+JsonBeanUtil.beanToJson(carCurDto));
		if(carCurDto==null){
			return carCurDto;
		}
		if(Objects.equals(carCurDto.getStockState(),"5106")){
			//TODO:选装件先不查
			return carCurDto;
		}
		//从其它系统查询车辆信息
		CarMainInfoDto returnDto = new CarMainInfoDto();
		returnDto.setCurCarPrice(carCurDto.getCurCarPrice());
		returnDto.setCarLevel(carCurDto.getCarLevel());
		returnDto.setVin(carCurDto.getVin());
		returnDto.setLicensedFirstDate(carCurDto.getLicensedFirstDate());
		List<OptionalPartsDto> partsList =new ArrayList<>();
		List<PsiCarOptionInfoEntity> listPsiCarOptionInfoEntity =new ArrayList<>();
		//从TSP查询基础数据
		if(!StringUtil.isEmpty(ucmpAesConfig.getTspCarVin())){
			carVin=ucmpAesConfig.getTspCarVin();
		}
		TspBasicsCarInfoDto tspDto=this.queryVehicleBasicInfo(carVin);
		LOGGER.info("======从TSP查询基础数据tspDto====="+JsonBeanUtil.beanToJson(tspDto));
		if(tspDto != null){
			returnDto.setActiveTime(tspDto.getActiveTime());//首次激活时间
			returnDto.setActiveStatus(tspDto.getActiveStatus());//激活状态
			int bengin;
			if(!StringUtil.isEmpty(tspDto.getBatteryCapacity())){
				if(tspDto.getBatteryCapacity().lastIndexOf('，')>=0){
					bengin=tspDto.getBatteryCapacity().lastIndexOf('，')+1;
				}else{
					bengin=tspDto.getBatteryCapacity().lastIndexOf(',')+1;
				}
				int end=tspDto.getBatteryCapacity().toLowerCase().lastIndexOf("kwh");
				String batteryCapacity = tspDto.getBatteryCapacity().substring(bengin,end);
				returnDto.setBatteryCapacity(batteryCapacity);//电池容量
			}
			returnDto.setManufactureDate(tspDto.getManufactureTime());//出厂日期
		}
		
		//从TSP查询累计里程
		Map<String,Object> resultMap=this.queryVehicleStatus(carVin,"50003");
		LOGGER.info("======从TSP查询累计里程tspDto====="+JsonBeanUtil.beanToJson(resultMap));
		
		if(resultMap != null){
			returnDto.setActualMileage(resultMap.get("101005").toString());//实际里程
			returnDto.setShowMileage(resultMap.get("101005").toString());//表显里程
		}
		//从SMP查询车辆信息数据
		if(!StringUtil.isEmpty(ucmpAesConfig.getSmpCarVin())){
			carVin=ucmpAesConfig.getSmpCarVin();
		}
		String result = this.smpConsumer.getCarInfoByVin(carVin);
		LOGGER.info("======从SMP查询车辆信息数据====="+result);
		if(!StringUtil.isEmpty(result)){
			SmpCarInfoReturnDto smpDto=JsonBeanUtil.jsonToBean(result,SmpCarInfoReturnDto.class);
			if(smpReturnCode.equals(smpDto.getCode())&&smpDto.getData()!=null && smpDto.getData().getVehicleInfo()!=null){
				LOGGER.info("======SMP查询车辆信息======="+JsonBeanUtil.beanToJson(smpDto));
				returnDto.setCarSeriesName(smpDto.getData().getVehicleInfo().getCarSeriesCn());//工程车型
				String productCode = returnDto.getCarSeriesName().substring(returnDto.getCarSeriesName().length()-1, returnDto.getCarSeriesName().length())
						+carCurDto.getVin().substring(carCurDto.getVin().length()-6, carCurDto.getVin().length());
				returnDto.setProductCode(productCode);
				returnDto.setCarSeriesCode(smpDto.getData().getVehicleInfo().getCarSeriesCode());
				returnDto.setBaseCarTypeName(smpDto.getData().getVehicleInfo().getCarType());//基础车型
				returnDto.setBaseCarTypeCode(smpDto.getData().getVehicleInfo().getCarTypeCode());
				returnDto.setInteriorColor(smpDto.getData().getVehicleInfo().getCarIncolorName());//内饰色
				returnDto.setVehicleColor(smpDto.getData().getVehicleInfo().getCarColorName());//外饰色
				returnDto.setNewCarPrice(smpDto.getData().getVehicleInfo().getActualPrice().toString());//新车指导价
				
				//添加选装件
				if(!smpDto.getData().getVehicleInfo().getOptionsList().isEmpty()){

					CarMainInfoDto finalCarCurDto = carCurDto;
					smpDto.getData().getVehicleInfo().getOptionsList().forEach(options ->{
						OptionalPartsDto partDto = new OptionalPartsDto();
						partDto.setOptionalPartsCode(options.getFeatureCode());
						partDto.setOptionalPartsName(options.getFeatureName());
						partsList.add(partDto);
						PsiCarOptionInfoEntity entity=new PsiCarOptionInfoEntity();
						entity.generatePk();
						entity.setOptionCode(options.getFeatureCode());
						entity.setOptionName(options.getFeatureName());
						entity.setStockId(finalCarCurDto.getStockId());
						entity.setCreatedBy(partyId);
						entity.setUpdatedBy(partyId);
						listPsiCarOptionInfoEntity.add(entity);
					});
				}
			}
		}
		
		//从SMP查询其他信息
		String orderResult = this.smpConsumer.getOrderDetail(null, null, carVin);
		if(!StringUtil.isEmpty(orderResult)){
			SmpReturnDto<Object> smpReturnDto=JsonBeanUtil.jsonToBean(orderResult, SmpReturnDto.class);
			if(smpReturnCode.equals(smpReturnDto.getCode())&&smpReturnDto.getData()!=null){
				OrderDataDto orderDataDto= JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(smpReturnDto.getData()), OrderDataDto.class);
				LOGGER.info("=====orderDataDto===="+JsonBeanUtil.beanToJson(orderDataDto));
				returnDto.setLicense(orderDataDto.getCarLincense());//牌照号
				if(StringUtil.isEmpty(carCurDto.getLicensedFirstDate())){
					returnDto.setLicensedFirstDate(orderDataDto.getRegisterDate());//首次上牌日期
				}
				returnDto.setLicensedCity(orderDataDto.getCityName());//牌照属地
				if(!StringUtil.isEmpty(orderDataDto.getInvoiceDate())){
					Date invoiceDate;
					if(orderDataDto.getInvoiceDate().length()>10){
						invoiceDate = new Date(Long.valueOf(orderDataDto.getInvoiceDate()));
					}else{
						invoiceDate = new Date(Long.valueOf(orderDataDto.getInvoiceDate()+"000"));
					}
					SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");
					returnDto.setInvoiceDate(form.format(invoiceDate));//开票日期
				}
				
				if(!StringUtil.isEmpty(returnDto.getInvoiceDate())){
					SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");
					Calendar ca=Calendar.getInstance();
					ca.set(Calendar.YEAR, Integer.parseInt(returnDto.getInvoiceDate().substring(0, 4)));
					ca.set(Calendar.MONTH, Integer.parseInt(returnDto.getInvoiceDate().substring(5, 7))-1);
					ca.set(Calendar.DAY_OF_MONTH, Integer.parseInt(returnDto.getInvoiceDate().substring(8, 10)));
					ca.add(Calendar.YEAR, 5);
					returnDto.setVehicleWarrantyDate(form.format(ca.getTime())+"/15万公里");//整车质保到期日期
					ca.add(Calendar.YEAR, -2);
					returnDto.setThreePowerWarrantyDate(form.format(ca.getTime())+"/24万公里");//整车质保到期日期
				}
			}
		}
		//添加测试数据
//		returnDto.setComprehensiveRange("430");//综合续航里程
		
		CarMainInfoDto updateCurDto =new CarMainInfoDto();
		updateCurDto.setVin(carCurDto.getVin());
		//判断需不需要更新数据库信息
		if(StringUtil.isEmpty(carCurDto.getProductCode())){
			updateCurDto.setCarSeriesCode(returnDto.getCarSeriesCode());
			updateCurDto.setCarSeriesName(returnDto.getCarSeriesName());
			updateCurDto.setProductCode(returnDto.getProductCode());
			updateCurDto.setBaseCarTypeCode(returnDto.getBaseCarTypeCode());
			updateCurDto.setBaseCarTypeName(returnDto.getBaseCarTypeName());
			updateCurDto.setInteriorColor(returnDto.getInteriorColor());//内饰色
			updateCurDto.setVehicleColor(returnDto.getVehicleColor());//外饰色
			updateCurDto.setNewCarPrice(returnDto.getNewCarPrice());//新车指导价
			//新增车辆选装件信息
			LOGGER.info("===新增车辆选装件信息==="+JsonBeanUtil.beanToJson(listPsiCarOptionInfoEntity));
			if(CollectionUtils.isNotEmpty(listPsiCarOptionInfoEntity)){
				this.iPsiCarOptionInfoDao.batchInsert(listPsiCarOptionInfoEntity);
			}
		}
		
		if(StringUtil.isEmpty(carCurDto.getActiveTime())){
			updateCurDto.setActiveStatus(returnDto.getActiveStatus());
			updateCurDto.setActiveTime(returnDto.getActiveTime());
			updateCurDto.setManufactureDate(returnDto.getManufactureDate());//出厂日期
		}
		
		if(StringUtil.isEmpty(carCurDto.getBatteryCapacity())){
			updateCurDto.setBatteryCapacity(returnDto.getBatteryCapacity());//电池容量
			updateCurDto.setComprehensiveRange(returnDto.getComprehensiveRange());//综合续航里程
		}else{
			returnDto.setBatteryCapacity(carCurDto.getBatteryCapacity());//电池容量
			returnDto.setComprehensiveRange(carCurDto.getComprehensiveRange());//综合续航里程
		}
		
		if(carCurDto.getTransfersNum()!=0){
			returnDto.setTransfersNum(carCurDto.getTransfersNum());//过户次数
		}
		
		if(!StringUtil.isEmpty(carCurDto.getInsuranceDueDate())){
			returnDto.setInsuranceDueDate(carCurDto.getInsuranceDueDate());//交强险到期日期
		}
		
		if(!StringUtil.isEmpty(carCurDto.getYearlyCheckDueDate())){
			returnDto.setYearlyCheckDueDate(carCurDto.getYearlyCheckDueDate());//年检到期日期
		}
		
		if(StringUtil.isEmpty(carCurDto.getActualMileage())){
			updateCurDto.setShowMileage(returnDto.getShowMileage());//行驶里程
		}
		
		if(StringUtil.isEmpty(carCurDto.getLicense())){
			updateCurDto.setLicense(returnDto.getLicense());//车牌
		}else{
			returnDto.setLicense(carCurDto.getLicense());
		}
		
		if(StringUtil.isEmpty(carCurDto.getLicensedFirstDate())){
			if(StringUtil.isEmpty(returnDto.getLicensedFirstDate())){
				returnDto.setLicensedFirstDate("2023-01-01");//首次上牌时间
			}
			updateCurDto.setLicensedFirstDate(returnDto.getLicensedFirstDate());//首次上牌时间
		}
		
		if(StringUtil.isEmpty(carCurDto.getLicensedCity())){
			updateCurDto.setLicensedCity(returnDto.getLicensedCity());//牌照属地
		}else{
			returnDto.setLicensedCity(carCurDto.getLicensedCity());
		}
		
		if(StringUtil.isEmpty(carCurDto.getInvoiceDate())){
			updateCurDto.setInvoiceDate(returnDto.getInvoiceDate());//开票日期
		}
		
		if(StringUtil.isEmpty(carCurDto.getUsage())){
			updateCurDto.setUsage(returnDto.getUsage());//使用性质
		}
		
		//更新库存车辆信息
		LOGGER.info("===更新库存车辆信息==="+JsonBeanUtil.beanToJson(updateCurDto));
		this.iCarInfoDao.updateCarInfo(updateCurDto);
		
		//选装件
		returnDto.setOptionalPartsList(partsList);
		return returnDto;
	}
	public static void main(String[] args) {
		/*Date invoiceDate=new Date(1690170632000L);
		SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-dd");
		LOGGER.info("========="+form.format(invoiceDate));
		String d="VN1, 三元, 93.4kwh(1C)";
		LOGGER.info("========="+d.toLowerCase());*/
		String carSeriesName ="HiPhi Z";
		String carVin = "SHCNDH8HKE9ANZ4BF";
		String productCode = carSeriesName.substring(carSeriesName.length()-1, carSeriesName.length())
				+carVin.substring(carVin.length()-6, carVin.length());
		LOGGER.info("========="+productCode);
	}

	private void setUsage(CarMainInfoDto returnDto, OrderDataDto orderDataDto) {
		orderDataDto.getCarInsurance().forEach(insurance ->{
			
		});
		switch (orderDataDto.getCarInsurance().get(0).getUsage()) {
		case "1":
			returnDto.setUsage("1");
			break;
		case "2":
			returnDto.setUsage("2");
			break;
		default:
			break;
		}
		
	}

	private Map<String, Object> queryVehicleStatus(String carVin, String businessCode) throws Exception {
		Map<String,Object> paramsMap=new HashMap<>();
		paramsMap.put("vin", carVin);
		String result=this.tspConsumer.queryVehicleStatus(paramsMap);
		TspCarStatusDto dto=JsonBeanUtil.jsonToBean(result, TspCarStatusDto.class);
		if("000000".equals(dto.getCode())){
			return dto.getData();
		}
		return null;
	}

	private TspBasicsCarInfoDto queryVehicleBasicInfo(String carVin) throws Exception {
		String result =this.tspConsumer.queryVehicleBasicInfo(carVin);
		TspCarInfoReturnDto dto = JsonBeanUtil.jsonToBean(result, TspCarInfoReturnDto.class);
		if("000000".equals(dto.getCode())){
			return dto.getData();
		}
		return null;
	}


}
