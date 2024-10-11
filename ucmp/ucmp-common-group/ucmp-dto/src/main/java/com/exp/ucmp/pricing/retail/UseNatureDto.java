package com.exp.ucmp.pricing.retail;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description: 维修
 * @date 2023/2/9 15:56
 */
public class UseNatureDto extends BaseModel {
    public UseNatureDto() {
    }

    public UseNatureDto(String type, String rate, String amount) {
        this.type = type;
        this.rate = rate;
        this.amount = amount;
    }

    @ApiModelProperty(value = "适用类型" +
            "一般企业-营运 4301\n" +
            "一般企业-非营运 4302\n" +
            "租赁公司-营运 4303\n" +
            "租赁公司-非营运 4304")
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
