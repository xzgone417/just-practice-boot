package com.exp.ucmp.replacement.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhouchengwei
 * @date 2022年10月19日
 */


@ApiModel(value = "NewCarQueryDto", description = "新车信息查询")
public class NewCarQueryDto extends BaseModel {


    private static final long serialVersionUID = 1L;

    /**
     * 门店名
     */
    @ApiModelProperty(value = "门店名")
    private String storeName;


    /**
     * 业务标识：1601、置换，1602、销售
     */
    @ApiModelProperty(value = "业务标识：1601、置换，1602、销售")
    private String businessLogo;


    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;


    /**
     * 旧车确认状态：01、未确认，02、已确认
     */
    @ApiModelProperty(value = "旧车确认状态：01、未确认，02、已确认")
    private String oldCarConfirmSign;


    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getBusinessLogo() {
        return businessLogo;
    }

    public void setBusinessLogo(String businessLogo) {
        this.businessLogo = businessLogo;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }


    public String getOldCarConfirmSign() {
        return oldCarConfirmSign;
    }

    public void setOldCarConfirmSign(String oldCarConfirmSign) {
        this.oldCarConfirmSign = oldCarConfirmSign;
    }
}
