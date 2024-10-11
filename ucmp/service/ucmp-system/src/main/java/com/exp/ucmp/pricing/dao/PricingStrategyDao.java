package com.exp.ucmp.pricing.dao;

import com.exp.ucmp.pricing.PricingStrategyDto;
import com.exp.ucmp.pricing.PricingStrategySectionDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2023/1/12 16:45
 */
public interface PricingStrategyDao {

    /**
     * 定值策略查询
     * @return
     */
    List<PricingStrategyDto> selectPricingStrategy();

    /**
     * 区间策略查询
     * @return
     */
    List<PricingStrategySectionDto> selectPricingStrategySection();


    Integer count(@Param("type") String type, @Param("value")int value);

}
