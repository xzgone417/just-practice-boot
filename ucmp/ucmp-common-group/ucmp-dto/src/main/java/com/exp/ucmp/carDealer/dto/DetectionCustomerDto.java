package com.exp.ucmp.carDealer.dto;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class DetectionCustomerDto {
    /**
     * 预约ID
     */
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;

    /**
     * 预约单号
     */
    @ApiModelProperty(value = "预约单号")
    private String businessOrderNo;

    /**
     * 预约检测时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预约检测时间")
    private Date reservationDetectionDate;

    /**
     * 预约检测地点
     */
    @ApiModelProperty(value = "预约检测地点")
    private String reservationDetectionAddress;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String customerIphone;

    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String licensePlateNum;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Date getReservationDetectionDate() {
        return reservationDetectionDate;
    }

    public void setReservationDetectionDate(Date reservationDetectionDate) {
        this.reservationDetectionDate = reservationDetectionDate;
    }

    public String getReservationDetectionAddress() {
        return reservationDetectionAddress;
    }

    public void setReservationDetectionAddress(String reservationDetectionAddress) {
        this.reservationDetectionAddress = reservationDetectionAddress;
    }

    public String getCustomerIphone() {
        return customerIphone;
    }

    public void setCustomerIphone(String customerIphone) {
        this.customerIphone = customerIphone;
    }

    public String getLicensePlateNum() {
        return licensePlateNum;
    }

    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum;
    }

    public String getBusinessOrderNo() {
        return businessOrderNo;
    }

    public void setBusinessOrderNo(String businessOrderNo) {
        this.businessOrderNo = businessOrderNo;
    }
}
