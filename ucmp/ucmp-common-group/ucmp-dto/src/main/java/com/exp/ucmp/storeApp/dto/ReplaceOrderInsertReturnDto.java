package com.exp.ucmp.storeApp.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(value = "ReplaceOrderInsertReturnDto", description = "创建置换单返回参数")
public class ReplaceOrderInsertReturnDto extends BaseModel {

    private static final long serialVersionUID = 1L;




    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;

    /**
     * 业务编号
     */

    @ApiModelProperty(value = "业务编号")
    private String businessOrderNo;



    /**
     * 门店ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店ID")
    private Long storeId;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getBusinessOrderNo() {
        return businessOrderNo;
    }

    public void setBusinessOrderNo(String businessOrderNo) {
        this.businessOrderNo = businessOrderNo;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
