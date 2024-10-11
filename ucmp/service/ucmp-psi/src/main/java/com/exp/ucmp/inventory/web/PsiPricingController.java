package com.exp.ucmp.inventory.web;

import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.inventory.service.PsiCarStockManageService;
import com.exp.ucmp.inventory.service.PsiPricingService;
import com.exp.ucmp.pricing.PricingJournalDto;
import com.exp.ucmp.pricing.retail.DiscountBasicDto;
import com.exp.ucmp.stock.dto.StockHistoryDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author gubonai
 * @date 2023年01月13日
 */
@Api(tags = "车辆定价接口")
@RestController
@RequestMapping("/pricing")
public class PsiPricingController {


    private static final Logger LOGGER = LoggerFactory.getLogger(PsiPricingController.class);


    @Autowired
   private PsiPricingService pricingService;


    /**
     * Description: 根据车辆id查询定价日志
     */
    @ApiOperation("根据车辆id查询定价日志")
    @ApiImplicitParams({@ApiImplicitParam(name = "vhclId", value = "车辆id", required = true)})
    @GetMapping("/queryPricingJournal")
    public RestResponse<List<PricingJournalDto>> queryPricingJournal(@RequestParam("vhclId") Long vhclId) {
        try {
            List<PricingJournalDto> pricingJournalDtoList = pricingService.queryPricingJournal(vhclId);
            return new RestResponse<>(RestStatusCode.OK, pricingJournalDtoList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 车辆定价
     */
    @ApiOperation("车辆定价")
    @ApiImplicitParams({@ApiImplicitParam(name = "stockId", value = "库存车辆id", required = true)})
    @GetMapping("/carPricing")
    public RestResponse<DiscountBasicDto> carPricing(@RequestParam("stockId") Long stockId) {
        try {
            DiscountBasicDto basicDto = pricingService.carPricing(stockId);
            return new RestResponse<>(RestStatusCode.OK, basicDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

}
