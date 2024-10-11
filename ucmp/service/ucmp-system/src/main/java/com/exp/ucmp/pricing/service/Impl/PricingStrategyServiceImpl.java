package com.exp.ucmp.pricing.service.Impl;

import com.alibaba.nacos.common.utils.CollectionUtils;
import com.egrid.cache.redisson.cache.RedissonCache;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.ISysPricingRulesDao;
import com.exp.ucmp.dao.ISysPricingStrategyDetailsDao;
import com.exp.ucmp.dao.ISysPricingStrategyDetailsSectionDao;
import com.exp.ucmp.entity.SysPricingRulesEntity;
import com.exp.ucmp.entity.SysPricingStrategyDetailsEntity;
import com.exp.ucmp.entity.SysPricingStrategyDetailsSectionEntity;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pricing.*;
import com.exp.ucmp.pricing.dao.PricingStrategyDao;
import com.exp.ucmp.pricing.retail.RuleSaveDto;
import com.exp.ucmp.pricing.service.PricingStrategyService;
import com.exp.ucmp.pricing.web.PricingStrategyController;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author GeYiJiang
 * @Description: 定价策略实现类
 * @date 2023/1/12 16:03
 */
@Service
public class PricingStrategyServiceImpl implements PricingStrategyService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PricingStrategyServiceImpl.class);

    @Autowired
    PricingStrategyDao pricingStrategyDao;

    @Autowired
    ISysPricingStrategyDetailsDao detailsDao;

    @Autowired
    ISysPricingStrategyDetailsSectionDao sectionDao;

    @Autowired
    ISysPricingRulesDao rulesDao;

    @Autowired
    RedissonCache redissonCache;

    @Override//    定值
    public List<PricingStrategyDto> queryPricingStrategy() {
        return pricingStrategyDao.selectPricingStrategy();
    }

    @Override//     区间
    public List<PricingStrategySectionDto> queryPricingStrategySection() {
        return pricingStrategyDao.selectPricingStrategySection();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateFixed(UpdateFixedParamsDto paramsDto) {

        List<SysPricingStrategyDetailsEntity> list = new ArrayList<>();
        for (FixedParamsDto fixedParamsDto : paramsDto.getList()) {
            SysPricingStrategyDetailsEntity details = Copiers.beanToBean(fixedParamsDto, FixedParamsDto.class, SysPricingStrategyDetailsEntity.class);
            list.add(details);
        }
        int i = detailsDao.batchUpdateSelective(list);
        return i>0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateSection(UpdateSectionParamsDto paramsDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<SysPricingStrategyDetailsSectionEntity> list = new ArrayList<>();

        SysPricingStrategyDetailsSectionEntity delete = new SysPricingStrategyDetailsSectionEntity();
        for (Long aLong : paramsDto.getList().stream().map(SectionParamsDto::getStrategyId).collect(Collectors.toList())) {
            delete.setStrategyId(aLong);
            sectionDao.deleteBySelective(delete);
        }
        for (SectionParamsDto sectionParamsDto : paramsDto.getList()) {
            SysPricingStrategyDetailsSectionEntity sectionEntity = Copiers.beanToBean(sectionParamsDto, SectionParamsDto.class, SysPricingStrategyDetailsSectionEntity.class);
            	LOGGER.info("======更新区间定价策略======"+JsonBeanUtil.beanToJson(sectionEntity));
            	sectionEntity.generatePk();
                sectionEntity.setCreatedDate(new Date());
                sectionEntity.setCreatedBy(user.getPartyId());
                sectionEntity.setUpdatedBy(user.getPartyId());
                sectionEntity.setUpdatedDate(new Date());
                sectionEntity.setIsDelete(Constants.IsDelete.NO.value());
                sectionEntity.setIsEnable(Constants.IsEnable.ENABLE.value());
                if(sectionParamsDto.getIsSource()!=2){
                	sectionEntity.setIsSource(1);
                }else{
                	sectionEntity.setIsSource(0);
                }
                list.add(sectionEntity);
        }
        int i = sectionDao.batchInsert(list);
        return i > 0;
    }

    @Override
    public Boolean deleteSection(DeleteSectionParamsDto paramsDto) {
        SysPricingStrategyDetailsSectionEntity sectionEntity = new SysPricingStrategyDetailsSectionEntity();
        sectionEntity.setStrategyDetailsId(paramsDto.getStrategyDetailsId());
        int i = sectionDao.deleteBySelective(sectionEntity);
        return i > 0;
    }

    /** 里程折扣计算 */
    private int mileCount(int n,List<String> mileageList,List<Integer> left,List<Integer> right){
        if (n==1){
            return 0;
        }else {
            if (n==3 || n==2){
                if (0 == Integer.parseInt(mileageList.get(0))){
                    return mileCount(n-1,mileageList,left,right) + (right.get(n-2) * Integer.parseInt( mileageList.get(n-2)));
                }else {
                    return mileCount(n-1,mileageList,left,right) + (right.get(n-2)-left.get(n-2)) * Integer.parseInt( mileageList.get(n-2));
                }
            }else {
                return mileCount(n-1,mileageList,left,right) + (right.get(n-2)-left.get(n-2)) * Integer.parseInt(mileageList.get(n-2)) ;
            }
        }
    }

    /** 月份折扣计算 */
    private double depreciationCount(int n,int price,List<String> depreciationList,List<Integer> left,List<Integer> right){
        if (n==1){
            return 0;
        }else {
            return depreciationCount(n-1,price,depreciationList,left,right)
                    + (right.get(n-2)-left.get(n-2)) * ( Double.valueOf(depreciationList.get(n-2)) * price /100 );
        }
    }

    /**价格试算*/
    @Override
    public PriceTrialResultDto priceTrial(PriceTrialDto paramsDto) {
        PriceTrialResultDto resultDto = new PriceTrialResultDto();
        //定值
        List<PricingStrategyDto> strategyDtos = pricingStrategyDao.selectPricingStrategy();
        //区间
        List<PricingStrategySectionDto> sectionDtos = pricingStrategyDao.selectPricingStrategySection();
        /** 里程折扣 */
        double mileage = 0;
        List<String> mileageList = sectionDtos.stream().filter(a -> Constants.SectionDiscountStatus.Mile.value().equals(a.getDetailsType()) ).map(PricingStrategySectionDto::getDetailsValue).collect(Collectors.toList());
        List<Integer> left = sectionDtos.stream().filter(a -> Constants.SectionDiscountStatus.Mile.value().equals(a.getDetailsType()) ).map(PricingStrategySectionDto::getLeftValue).collect(Collectors.toList());
        List<Integer> right = sectionDtos.stream().filter(a -> Constants.SectionDiscountStatus.Mile.value().equals(a.getDetailsType()) ).map(PricingStrategySectionDto::getRightValue).collect(Collectors.toList());

        int count = Optional.ofNullable(pricingStrategyDao.count(Constants.SectionDiscountStatus.Mile.value(), paramsDto.getEnterKilometers())).orElse(0);
        if (2 < count) {
            mileage = (paramsDto.getEnterKilometers()-left.get(count-1)) * Integer.parseInt(mileageList.get(count-1))
                    + mileCount(count, mileageList, left, right);
        }
        else if (0 == count){
            mileage = 0;
        }else if (1 == count){
            if (0 == Integer.parseInt(mileageList.get(0))){
                mileage = 0;
            }else {
                mileage = paramsDto.getEnterKilometers() * Integer.parseInt(mileageList.get(0));
            }
        }else if (2 == count){
            if (0 == Integer.parseInt(mileageList.get(0))){
                mileage = paramsDto.getEnterKilometers() * Integer.parseInt(mileageList.get(1));
            }else{
                mileage = (paramsDto.getEnterKilometers()-left.get(1)) * Integer.parseInt(mileageList.get(1)) + right.get(0) * Integer.parseInt(mileageList.get(0));
            }
        }
        resultDto.setMileageDiscount(String.valueOf(Math.round(mileage)));

        /** 折旧折扣 */
        double depreciation = 0;
        List<String> depreciationList = sectionDtos.stream().filter(a -> Constants.SectionDiscountStatus.Month.value().equals(a.getDetailsType()) ).map(PricingStrategySectionDto::getDetailsValue).collect(Collectors.toList());
        List<Integer> depreciationRight = sectionDtos.stream().filter(a -> Constants.SectionDiscountStatus.Month.value().equals(a.getDetailsType())).map(PricingStrategySectionDto::getRightValue).collect(Collectors.toList());
        List<Integer> depreciationLeft = sectionDtos.stream().filter(a -> Constants.SectionDiscountStatus.Month.value().equals(a.getDetailsType())).map(PricingStrategySectionDto::getLeftValue).collect(Collectors.toList());
        if ( (paramsDto.getCarUsedDays() / 7) < 1){
            depreciation = 0;
        }
        if (paramsDto.getCarUsedDays() / 7 == 1){
            depreciation = 0.25 * depreciationRight.get(0) * Double.valueOf(depreciationList.get(0)) * paramsDto.getCarPrice() /100;
        }
        if (paramsDto.getCarUsedDays() / 7 == 2){
            depreciation = 0.5 * depreciationRight.get(0) * Double.valueOf(depreciationList.get(0)) * paramsDto.getCarPrice() /100;
        }
        if ((paramsDto.getCarUsedDays() / 7) ==3){
            depreciation = 0.75 * depreciationRight.get(0) * Double.valueOf(depreciationList.get(0)) * paramsDto.getCarPrice()/100;
        }

        if ((paramsDto.getCarUsedDays() / 7) >= 4 && (paramsDto.getCarUsedDays() / 7) < 20){
                depreciation = 1 * depreciationRight.get(0) * Double.valueOf(depreciationList.get(0)) * paramsDto.getCarPrice()/100 +
                        (paramsDto.getCarUsedDays()*1.0/30 - depreciationRight.get(0)) * Double.valueOf(depreciationList.get(1)) * paramsDto.getCarPrice()/100;
        }
        if ((paramsDto.getCarUsedDays() / 7) >=20 && (paramsDto.getCarUsedDays() / 7) < 48){
                depreciation =
                        1 * depreciationRight.get(0) * Double.valueOf(depreciationList.get(0)) * paramsDto.getCarPrice()/100 +
                                (depreciationRight.get(1) - depreciationRight.get(0)) * Double.valueOf(depreciationList.get(1)) * paramsDto.getCarPrice()/100 +
                                (paramsDto.getCarUsedDays()*1.0/30 - depreciationRight.get(1)) * Double.valueOf(depreciationList.get(2)) * paramsDto.getCarPrice()/100;
        }
        if ((paramsDto.getCarUsedDays() / 7) >= 48 && (paramsDto.getCarUsedDays() / 30 ) < 36){
                depreciation = 1 * depreciationRight.get(0) * Double.valueOf(depreciationList.get(0)) * paramsDto.getCarPrice()/100 +
                        (depreciationRight.get(1) - depreciationRight.get(0)) * Double.valueOf(depreciationList.get(1)) * paramsDto.getCarPrice()/100 +
                        (depreciationRight.get(2) - depreciationRight.get(1)) * Double.valueOf(depreciationList.get(2)) * paramsDto.getCarPrice()/100 +
                        (paramsDto.getCarUsedDays()*1.0/30 - depreciationRight.get(2)) * Double.valueOf(depreciationList.get(3)) * paramsDto.getCarPrice()/100;
        }
        if ((paramsDto.getCarUsedDays() / 30 ) >= 36){
            int num = Optional.ofNullable(pricingStrategyDao.count(Constants.SectionDiscountStatus.Month.value(), paramsDto.getCarUsedDays()/30)).orElse(0);
            if (num>4){
                depreciation = (paramsDto.getCarUsedDays()*1.0/30 - depreciationLeft.get(num-1))
                        * Double.valueOf(depreciationList.get(num-1)) * paramsDto.getCarPrice()/100
                        + depreciationCount(num, paramsDto.getCarPrice(),depreciationList,depreciationLeft,depreciationRight);
            }
        }

        resultDto.setDepreciationDiscount(String.valueOf(Math.round(depreciation)));

        /** 过户次数折扣 */
        double transferCount = 0;
        List<String> transfer1 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.transferCountStatus.One.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
        List<String> transfer2 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.transferCountStatus.Two.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
        List<String> transfer3 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.transferCountStatus.Three.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
        List<String> transfer4 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.transferCountStatus.Four.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
        List<String> transfer5 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.transferCountStatus.Other.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
        if (paramsDto.getTransferCount() == 1 ){
            transferCount = paramsDto.getCarPrice() * Double.valueOf(transfer1.get(0)) /100;
        }else if (paramsDto.getTransferCount() == 2){
            transferCount = paramsDto.getCarPrice() * Double.valueOf(transfer2.get(0)) /100;
        }
        else if (paramsDto.getTransferCount() == 3){
            transferCount = paramsDto.getCarPrice() * Double.valueOf(transfer3.get(0)) /100;
        }else if (paramsDto.getTransferCount() == 4){
            transferCount = paramsDto.getCarPrice() * Double.valueOf(transfer4.get(0)) /100;
        }else if (paramsDto.getTransferCount() > 4){
            transferCount = paramsDto.getCarPrice() * Double.valueOf(transfer5.get(0)) /100;
        }
        resultDto.setTransferCount(String.valueOf(Math.round(transferCount)));
        //  维修折扣
        double maintenanceDiscount = 0;
        if (StringUtils.isNotBlank(paramsDto.getRejectReason())){
            if (paramsDto.getRejectReason().equals(Constants.maintenanceStatus.Battery.value())){
                List<String> maintenance1 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.maintenanceStatus.Battery.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
                maintenanceDiscount = paramsDto.getCarPrice() * Double.valueOf(maintenance1.get(0))/100;
            }if (paramsDto.getRejectReason().equals(Constants.maintenanceStatus.PaintWork.value())){
                List<String> maintenance2 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.maintenanceStatus.PaintWork.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
                maintenanceDiscount = paramsDto.getCarPrice() * Double.valueOf(maintenance2.get(0))/100;
            }if (paramsDto.getRejectReason().equals(Constants.maintenanceStatus.noImportant.value())){
                List<String> maintenance3 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.maintenanceStatus.noImportant.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
                maintenanceDiscount = paramsDto.getCarPrice() * Double.valueOf(maintenance3.get(0))/100;
            }if (paramsDto.getRejectReason().equals(Constants.maintenanceStatus.Display.value())){
                List<String> maintenance4 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.maintenanceStatus.Display.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
                maintenanceDiscount = paramsDto.getCarPrice() * Double.valueOf(maintenance4.get(0))/100;
            }if (paramsDto.getRejectReason().equals(Constants.maintenanceStatus.Other.value())){
                List<String> maintenance5 = strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.maintenanceStatus.Other.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
                maintenanceDiscount = paramsDto.getCarPrice() * Double.valueOf(maintenance5.get(0))/100;
            }
        }
        resultDto.setMaintenanceDiscount(String.valueOf(Math.round(maintenanceDiscount)));
        //  生产年份折扣
        double productionDiscount = 0;

        if (StringUtils.isNotBlank(paramsDto.getProduction())){
            if (paramsDto.getProduction().equals(Constants.ProductionYearDiscountStatus.YearCumulative.value())){
                List<String> production1= strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.ProductionYearDiscountStatus.YearCumulative.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
                productionDiscount = paramsDto.getCarPrice() * Double.valueOf(production1.get(0))/100;
            }if (paramsDto.getProduction().equals(Constants.ProductionYearDiscountStatus.ModelYearChange.value())){
                List<String> production2= strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.ProductionYearDiscountStatus.ModelYearChange.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
                productionDiscount = paramsDto.getCarPrice() * Double.valueOf(production2.get(0))/100;
            }
        }
        resultDto.setProductionDiscount(String.valueOf(Math.round(productionDiscount)));

        //  使用性质折扣
        double useNatureDiscount = 0;
        if (StringUtils.isNotBlank(paramsDto.getUseNature())){
            if (paramsDto.getUseNature().equals(Constants.useNatureStatus.GeneralEnterpriseOperation.value())){
                //一般企业-营运
                List<String> useNature1= strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.useNatureStatus.GeneralEnterpriseOperation.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
                useNatureDiscount = paramsDto.getCarPrice() * Double.valueOf(useNature1.get(0))/100;
            }if (paramsDto.getUseNature().equals(Constants.useNatureStatus.GeneralEnterpriseNoOperation.value())){
                //一般企业-非营运
                List<String> useNature2= strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.useNatureStatus.GeneralEnterpriseNoOperation.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
                useNatureDiscount = paramsDto.getCarPrice() * Double.valueOf(useNature2.get(0))/100;
            }if (paramsDto.getUseNature().equals(Constants.useNatureStatus.LeasingCompanyOperation.value())){
                //租赁公司-营运
                List<String> useNature3= strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.useNatureStatus.LeasingCompanyOperation.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
                useNatureDiscount = paramsDto.getCarPrice() * Double.valueOf(useNature3.get(0))/100;
            }if (paramsDto.getUseNature().equals(Constants.useNatureStatus.LeasingCompanyNoOperation.value())){
                //租赁公司-非营运
                List<String> useNature4= strategyDtos.stream().filter(a -> a.getDetailsType().equals(Constants.useNatureStatus.LeasingCompanyNoOperation.value())).map(PricingStrategyDto::getDetailsValue).collect(Collectors.toList());
                useNatureDiscount = paramsDto.getCarPrice() * Double.valueOf(useNature4.get(0))/100;
            }
        }
        resultDto.setUseNatureDiscount(String.valueOf(Math.round(useNatureDiscount)));
        //  合计折扣金额
        double total = Math.round(mileage + depreciation + maintenanceDiscount + productionDiscount + transferCount + useNatureDiscount);
        resultDto.setTotalDiscountAmount(String.valueOf(Math.round(total)));
        //  折扣率
        double rate = total / paramsDto.getCarPrice();
        resultDto.setDiscountRate(String.format("%.2f",rate * 100));
        //  原价
        resultDto.setOriginalPrice(String.valueOf(paramsDto.getCarPrice()));
        //  建议价
        resultDto.setSuggestedPrice(String.valueOf(Math.round(paramsDto.getCarPrice() - total)));
        return resultDto;
    }

    @Override
    public boolean save(RuleSaveDto paramsDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<SysPricingRulesEntity> rulesList = rulesDao.selectBySelective(new SysPricingRulesEntity());
        SysPricingRulesEntity rulesEntity = Copiers.beanToBean(paramsDto,RuleSaveDto.class, SysPricingRulesEntity.class);
        if (CollectionUtils.isEmpty(rulesList)){
            rulesEntity.generatePk();
            String code = String.format("%04d", redissonCache.incrBy("ruleCode", 1L));
            redissonCache.expire("ruleCode", TimeUnit.HOURS,24L);
            String ruleNumber = new SimpleDateFormat("yyyyMMdd").format(new Date()).concat(code);
            ruleNumber = "CL" + ruleNumber;
            rulesEntity.setRuleNumber(ruleNumber);
            rulesEntity.setCreatedBy(user.getPartyId());
            rulesEntity.setCreatedDate(new Date());
            rulesEntity.setUpdatedBy(user.getPartyId());
            rulesEntity.setUpdatedDate(new Date());
            int insert = rulesDao.insert(rulesEntity);
            return insert>0;
        }else {
            rulesEntity.setRuleId(rulesList.get(0).getRuleId());
            rulesEntity.setUpdatedBy(user.getPartyId());
            rulesEntity.setUpdatedDate(new Date());
            int update = rulesDao.updateSelective(rulesEntity);
            return update>0;
        }
    }

    @Override
    public RuleSaveDto query() {
        RuleSaveDto ruleSaveDto = new RuleSaveDto();
        List<SysPricingRulesEntity> rulesEntity = rulesDao.selectBySelective(new SysPricingRulesEntity());
        if (CollectionUtils.isEmpty(rulesEntity)) return null;
        ruleSaveDto = Copiers.beanToBean(rulesEntity.get(0),SysPricingRulesEntity.class,RuleSaveDto.class);
        return ruleSaveDto;
    }
}
