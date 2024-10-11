package com.exp.ucmp.pricing.retail;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description: 维修
 * @date 2023/2/9 15:56
 */
public class MaintenanceDto extends BaseModel {

    public MaintenanceDto(String type, String rate, String amount) {
        this.type = type;
        this.rate = rate;
        this.amount = amount;
    }
    public MaintenanceDto() {
    }

    @ApiModelProperty(value = "维修类型:电池/电机等维修 4401" +
            "漆面维修 4402" +
            "非重要配件更换 4403" +
            "车辆显示屏或电脑更换 4404" +
            "其他因本地政策需要披露的维修 4405")
    private String type;

    @ApiModelProperty(value = "折扣率")
    private String rate;

    @ApiModelProperty(value = "折扣金额")
    private String amount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
