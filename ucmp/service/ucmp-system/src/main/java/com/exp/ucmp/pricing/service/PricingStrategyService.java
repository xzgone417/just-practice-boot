package com.exp.ucmp.pricing.service;

import com.exp.ucmp.pricing.*;
import com.exp.ucmp.pricing.retail.RuleSaveDto;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 定价策略接口
 * @date 2023/1/12 16:02
 */
public interface PricingStrategyService {

    /**
     * 查询定值策略
     */
    List<PricingStrategyDto> queryPricingStrategy();

    /**
     * 查询区间策略
     */
    List<PricingStrategySectionDto> queryPricingStrategySection();

    /**
     * 更新定值策略
     */
    Boolean updateFixed(UpdateFixedParamsDto paramsDto);

    /**
     * 更新区间策略
     */
    Boolean updateSection(UpdateSectionParamsDto paramsDto);

    /**
     * 删除区间策略
     */
    Boolean deleteSection(DeleteSectionParamsDto paramsDto);

    /**
     * 价格试算
     */
    PriceTrialResultDto priceTrial(PriceTrialDto paramsDto);

    /**
     * 规则保存
     */
    boolean save(RuleSaveDto paramsDto);
    /**
     * 规则查询
     */
    RuleSaveDto query();



}
