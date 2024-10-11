package com.exp.ucmp.pricing;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description: 价格试算Dto
 * @date 2023/2/6 17:15
 */
@ApiModel(value = "PriceTrialDto", description = "价格试算参数")
public class PriceTrialDto extends BaseModel {

    @ApiModelProperty(value = "车辆配置价格",required = true)
    private int carPrice;

    @ApiModelProperty(value = "输入公里数",required = true)
    private int enterKilometers;

    @ApiModelProperty(value = "输入使用天数",required = true)
    private int carUsedDays;

    @ApiModelProperty(value = "输入过户次数",required = true)
    private int transferCount;

    @ApiModelProperty(value = "退回原因(无 则不传): 字典表44")
    private String rejectReason;

    @ApiModelProperty(value = "生产年份折扣: 字典表46")
    private String production;

    @ApiModelProperty(value = "适用类型: 字典表43")
    private String useNature;

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public int getEnterKilometers() {
        return enterKilometers;
    }

    public void setEnterKilometers(int enterKilometers) {
        this.enterKilometers = enterKilometers;
    }

    public int getCarUsedDays() {
        return carUsedDays;
    }

    public void setCarUsedDays(int carUsedDays) {
        this.carUsedDays = carUsedDays;
    }

    public int getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(int transferCount) {
        this.transferCount = transferCount;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getUseNature() {
        return useNature;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public void setUseNature(String useNature) {
        this.useNature = useNature;
    }
}
