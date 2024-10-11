package com.exp.ucmp.pricing;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description: 价格试算结果Dto
 * @date 2023/2/6 17:15
 */
@ApiModel(value = "PriceTrialResultDto", description = "价格试算结果")
public class PriceTrialResultDto extends BaseModel {

    @ApiModelProperty(value = "里程折扣")
    private String mileageDiscount;

    @ApiModelProperty(value = "折旧折扣")
    private String depreciationDiscount;

    @ApiModelProperty(value = "维修折扣")
    private String maintenanceDiscount;

    @ApiModelProperty(value = "生产年份折扣")
    private String productionDiscount;

    @ApiModelProperty(value = "过户次数折扣")
    private String transferCount;
    @ApiModelProperty(value = "使用性质折扣")
    private String useNatureDiscount;

    @ApiModelProperty(value = "合计折扣金额")
    private String totalDiscountAmount;

    @ApiModelProperty(value = "折扣率")
    private String discountRate;

    @ApiModelProperty(value = "原价")
    private String originalPrice;

    @ApiModelProperty(value = "建议价")
    private String suggestedPrice;

    public String getMileageDiscount() {
        return mileageDiscount;
    }

    public void setMileageDiscount(String mileageDiscount) {
        this.mileageDiscount = mileageDiscount;
    }

    public String getDepreciationDiscount() {
        return depreciationDiscount;
    }

    public void setDepreciationDiscount(String depreciationDiscount) {
        this.depreciationDiscount = depreciationDiscount;
    }

    public String getMaintenanceDiscount() {
        return maintenanceDiscount;
    }

    public void setMaintenanceDiscount(String maintenanceDiscount) {
        this.maintenanceDiscount = maintenanceDiscount;
    }

    public String getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(String transferCount) {
        this.transferCount = transferCount;
    }

    public String getProductionDiscount() {
        return productionDiscount;
    }

    public void setProductionDiscount(String productionDiscount) {
        this.productionDiscount = productionDiscount;
    }

    public String getUseNatureDiscount() {
        return useNatureDiscount;
    }

    public void setUseNatureDiscount(String useNatureDiscount) {
        this.useNatureDiscount = useNatureDiscount;
    }

    public String getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public void setTotalDiscountAmount(String totalDiscountAmount) {
        this.totalDiscountAmount = totalDiscountAmount;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getSuggestedPrice() {
        return suggestedPrice;
    }

    public void setSuggestedPrice(String suggestedPrice) {
        this.suggestedPrice = suggestedPrice;
    }
}
