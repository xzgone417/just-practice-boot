package com.exp.ucmp.inventory.service;

import com.exp.ucmp.pricing.PricingJournalDto;
import com.exp.ucmp.pricing.retail.DiscountBasicDto;
import com.exp.ucmp.stock.dto.StockHistoryDto;

import java.util.List;

/**
 * @author gubonai
 * @date 2023年01月13日
 */

public interface PsiPricingService {

    /**
     * 根据车辆id查询定价日志
     * @param vhclId
     * @return
     */
    List<PricingJournalDto> queryPricingJournal(Long vhclId);

    /**
     * 车辆定价
     * @param stockId
     */
    DiscountBasicDto carPricing(Long stockId);

}
