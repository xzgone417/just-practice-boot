package com.exp.ucmp.storeApp.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "CustomerOperationDto", description = "客户操作入参")
public class CustomerOperationDto extends BaseModel {




    /**
     * 预约id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约id/参与车商传入参数")
    private Long reservationId;




    /**
     * 客户操作(同意/拒绝/接洽)
     */
    @ApiModelProperty(value = "客户操作(同意0501/拒绝0503/接洽0502)")
    private String customerIntention;

    /**
     * 关闭原因
     */
    @ApiModelProperty(value = "关闭原因(0601\t无车商接单\n" +
            "0602\t无车商报价\n" +
            "0603\t无车商收购\n" +
            "0604\t客户拒绝\n)")
    private String closeReason;


    /**
     * 关闭原因细项
     */
    @ApiModelProperty(value = "关闭原因细项(如果页面可以选择就传，不能选择就不需要传,060101\t无车商接单\n" +
            "060201\t无车商报价\n" +
            "060301\t无车商收购\n" +
            "060401\t客户拒绝\n)")
    private String closeReasonDetails;

    /**
     * 关闭描述
     */
    @ApiModelProperty(value = "关闭描述(填写了就传,没填写就不传)")
    private String shutDescribe;


    public String getCustomerIntention() {
        return customerIntention;
    }

    public void setCustomerIntention(String customerIntention) {
        this.customerIntention = customerIntention;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public String getCloseReasonDetails() {
        return closeReasonDetails;
    }

    public void setCloseReasonDetails(String closeReasonDetails) {
        this.closeReasonDetails = closeReasonDetails;
    }

    public String getShutDescribe() {
        return shutDescribe;
    }

    public void setShutDescribe(String shutDescribe) {
        this.shutDescribe = shutDescribe;
    }


    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
}
