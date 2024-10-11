package com.exp.ucmp.inventory.service.impl;

import com.egrid.core.copiers.Copiers;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.car.dto.CarMainInfoDto;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.consumer.ISystemConsumer;
import com.exp.ucmp.dao.IPsiCarStockInfoDao;
import com.exp.ucmp.dao.IPsiPricingJournalDao;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.exp.ucmp.entity.PsiPricingJournalEntity;
import com.exp.ucmp.inventory.service.PsiPricingService;
import com.exp.ucmp.pk.PsiCarStockInfoPk;
import com.exp.ucmp.pricing.PriceTrialDto;
import com.exp.ucmp.pricing.PriceTrialResultDto;
import com.exp.ucmp.pricing.PricingJournalDto;
import com.exp.ucmp.pricing.PricingStrategyDto;
import com.exp.ucmp.pricing.retail.DiscountBasicDto;
import com.exp.ucmp.pricing.retail.MaintenanceDto;
import com.exp.ucmp.pricing.retail.UseNatureDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author gubonai
 * @date 2023年01月14日
 */
@Service
public class PsiPricingServiceImpl implements PsiPricingService {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PsiPricingServiceImpl.class);

    @Autowired
    private IPsiPricingJournalDao iPsiPricingJournalDao;
    @Autowired
    private IPsiCarStockInfoDao carStockInfoDao;
    @Autowired
    private ISystemConsumer systemConsumer;

    /**
     * 根据车辆id查询定价日志
     * @param vhclId
     * @return
     */
    @Override
    public List<PricingJournalDto> queryPricingJournal(Long vhclId) {
        PsiPricingJournalEntity pricingJournalEntity = new PsiPricingJournalEntity();
        List<PricingJournalDto> dtoList = new ArrayList<>();
        pricingJournalEntity.setVhclId(vhclId);
        List<PsiPricingJournalEntity> list = iPsiPricingJournalDao.selectBySelective(pricingJournalEntity);
        for (PsiPricingJournalEntity entity : list) {
            PricingJournalDto pricingJournalDto = new PricingJournalDto();
            pricingJournalDto =
                    Copiers.beanToBean(entity, PsiPricingJournalEntity.class, PricingJournalDto.class);
            dtoList.add(pricingJournalDto);
        }
        return dtoList;
    }

    @Override
    public DiscountBasicDto carPricing(Long stockId) {
        DiscountBasicDto basicDto = new DiscountBasicDto();
        PriceTrialDto priceTrialDto = new PriceTrialDto();
        PsiCarStockInfoEntity stockInfo = carStockInfoDao.load(new PsiCarStockInfoPk(stockId));
        LOGGER.info("stockInfo:",JsonBeanUtil.beanToJson(stockInfo));
        //设置当前车辆销售价格
        basicDto.setPrice(stockInfo.getSalePrice());
        //车辆原价
//        RestResponse<CarMainInfoDto> carMainInfo = systemConsumer.getCarMainInfo(stockInfo.getVinCode(),stockId);
        CarMainInfoDto carMainInfo=this.carStockInfoDao.getCarInfoByVin(stockId,stockInfo.getVinCode());
        LOGGER.info("车辆基本信息：{}",JsonBeanUtil.beanToJson(carMainInfo));
        if(carMainInfo != null){
        	if ( Objects.nonNull(carMainInfo.getNewCarPrice())){
                priceTrialDto.setCarPrice((int)Double.parseDouble(carMainInfo.getNewCarPrice()));
                basicDto.setNewCarPrice(Double.parseDouble(carMainInfo.getNewCarPrice()));
            }else{
            	priceTrialDto.setCarPrice(5700000);
            	basicDto.setNewCarPrice((double) 5700000);
            }
            //过户次数
            if(stockInfo.getTransferCount()==null){
            	stockInfo.setTransferCount(0);
            }
            priceTrialDto.setTransferCount(stockInfo.getTransferCount());
            
            //行驶里程  取车辆从TSP获取的表显里程
            if(carMainInfo.getShowMileage() != null){
            	priceTrialDto.setEnterKilometers((int)Double.parseDouble(carMainInfo.getShowMileage()));
            }else{
            	priceTrialDto.setEnterKilometers(0);
            }
            //使用天数
            Date date = new Date();
            if(stockInfo.getFirstLicenseDate() !=null){
            	priceTrialDto.setCarUsedDays((int) ( (date.getTime() - stockInfo.getFirstLicenseDate().getTime() ) / (1000*3600*24) ));
            }

            PriceTrialResultDto trialResultDto = systemConsumer.priceTrial(priceTrialDto).getResult();
            //建议价
            basicDto.setSuggestedPrice(trialResultDto.getSuggestedPrice());

            //公里折扣
            double mileRate = Double.valueOf(trialResultDto.getMileageDiscount()) / priceTrialDto.getCarPrice() * 100;
            Map<String,String> mileMap = new HashMap<>();
            mileMap.put(String.format("%.2f", mileRate),trialResultDto.getMileageDiscount());
            basicDto.setMileageDiscount(mileMap);

            //月份折扣
            double monthRate = Double.valueOf(trialResultDto.getDepreciationDiscount()) / priceTrialDto.getCarPrice() * 100;
            Map<String,String> monthMap = new HashMap<>();
            monthMap.put(String.format("%.2f", monthRate),trialResultDto.getDepreciationDiscount());
            basicDto.setDepreciationDiscount(monthMap);

            //过户次数
            double transferRate = Double.valueOf(trialResultDto.getTransferCount()) / priceTrialDto.getCarPrice() * 100;
            Map<String,String> transferMap = new HashMap<>();
            transferMap.put(String.format("%.2f", transferRate),trialResultDto.getTransferCount());
            basicDto.setTransferCount(transferMap);

            //定值数据
            List<PricingStrategyDto> strategyDtos = systemConsumer.find().getResult();
            //维修折扣
            List<String> maintenance1 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.maintenanceStatus.Battery.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
            List<String> maintenance2 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.maintenanceStatus.PaintWork.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
            List<String> maintenance3 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.maintenanceStatus.noImportant.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
            List<String> maintenance4 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.maintenanceStatus.Display.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
            List<String> maintenance5 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.maintenanceStatus.Other.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
            List<MaintenanceDto> maintenanceDtos = new ArrayList<>();
            maintenanceDtos.add(new MaintenanceDto(Constants.maintenanceStatus.Battery.value(),maintenance1.get(0),String.valueOf(Math.round(priceTrialDto.getCarPrice() * Double.parseDouble(maintenance1.get(0))/100))));
            maintenanceDtos.add(new MaintenanceDto(Constants.maintenanceStatus.PaintWork.value(),maintenance2.get(0),String.valueOf(Math.round(priceTrialDto.getCarPrice() * Double.parseDouble(maintenance2.get(0))/100))));
            maintenanceDtos.add(new MaintenanceDto(Constants.maintenanceStatus.noImportant.value(),maintenance3.get(0),String.valueOf(Math.round(priceTrialDto.getCarPrice() * Double.parseDouble(maintenance3.get(0))/100))));
            maintenanceDtos.add(new MaintenanceDto(Constants.maintenanceStatus.Display.value(),maintenance4.get(0),String.valueOf(Math.round(priceTrialDto.getCarPrice() * Double.parseDouble(maintenance4.get(0))/100))));
            maintenanceDtos.add(new MaintenanceDto(Constants.maintenanceStatus.Other.value(),maintenance5.get(0),String.valueOf(Math.round(priceTrialDto.getCarPrice() * Double.parseDouble(maintenance5.get(0))/100))));
            basicDto.setMaintenanceDtos(maintenanceDtos);

            //营运类型
            //一般企业-营运
            List<String> useNature1= strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.useNatureStatus.GeneralEnterpriseOperation.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
            //一般企业-非营运
            List<String> useNature2= strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.useNatureStatus.GeneralEnterpriseNoOperation.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
            //租赁公司-营运
            List<String> useNature3= strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.useNatureStatus.LeasingCompanyOperation.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
            //租赁公司-非营运
            List<String> useNature4= strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.useNatureStatus.LeasingCompanyNoOperation.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
            List<UseNatureDto> useNatureDtos = new ArrayList<>();
            useNatureDtos.add(new UseNatureDto(Constants.useNatureStatus.GeneralEnterpriseOperation.value(),useNature1.get(0),String.valueOf(Math.round(priceTrialDto.getCarPrice() * Double.valueOf(useNature1.get(0))/100))));
            useNatureDtos.add(new UseNatureDto(Constants.useNatureStatus.GeneralEnterpriseNoOperation.value(),useNature2.get(0),String.valueOf(Math.round(priceTrialDto.getCarPrice() * Double.valueOf(useNature2.get(0))/100))));
            useNatureDtos.add(new UseNatureDto(Constants.useNatureStatus.LeasingCompanyOperation.value(),useNature3.get(0),String.valueOf(Math.round(priceTrialDto.getCarPrice() * Double.valueOf(useNature3.get(0))/100))));
            useNatureDtos.add(new UseNatureDto(Constants.useNatureStatus.LeasingCompanyNoOperation.value(),useNature4.get(0),String.valueOf(Math.round(priceTrialDto.getCarPrice() * Double.valueOf(useNature4.get(0))/100))));
            basicDto.setUseNatureDtos(useNatureDtos);
            //生产年份折扣
            
            //查询改价审批信息
            DiscountBasicDto changePriceDto = this.carStockInfoDao.queryChangePriceInfo(stockId);
            if(changePriceDto != null){
            	basicDto.setApproveStatus(changePriceDto.getApproveStatus());
            	basicDto.setApproveStatusName(changePriceDto.getApproveStatusName());
            	basicDto.setRejectReason(changePriceDto.getRejectReason());
            	basicDto.setPrice(changePriceDto.getPrice());
            	basicDto.setCurCarPrice(changePriceDto.getCurCarPrice());
            }
        }
        return basicDto;
    }
}
