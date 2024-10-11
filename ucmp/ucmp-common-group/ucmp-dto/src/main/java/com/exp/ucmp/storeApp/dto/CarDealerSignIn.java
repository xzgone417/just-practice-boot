package com.exp.ucmp.storeApp.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.PsiCarDealerInquiryEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Date;
@ApiModel(value = "CarDealerSignIn", description = "车商签到传入参数")
public class CarDealerSignIn extends BaseModel {
    private static final long serialVersionUID = 1L;

    /**
     * 报价截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "报价截止时间")
    private Date quoteDeadline;


    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
   @ApiModelProperty(value = "预约ID")
    private Long reservationId;

    /**
     * 车商ID
     */
    @ApiModelProperty(value = "车商ID")
    private Long carDealerId;

    public Long getCarDealerId() {
        return carDealerId;
    }

    public void setCarDealerId(Long carDealerId) {
        this.carDealerId = carDealerId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getQuoteDeadline() {
        return quoteDeadline;
    }

    public void setQuoteDeadline(Date quoteDeadline) {
        this.quoteDeadline = quoteDeadline;
    }
}
