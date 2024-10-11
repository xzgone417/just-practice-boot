package com.exp.ucmp.replacement.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * @author zhouchengwei
 * @date 2022年9月14日
 */


@ApiModel(value = "VehicleInfoDto", description = "旧车列表")
public class VehicleInfoDto extends BaseModel {


    private static final long serialVersionUID = 1L;



    /**
     * 车辆标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "车辆标识")
    private Long vehicleId;

    /**
     * 预约标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约标识")
    private Long bookingId;




    /**
     * 车型
     */
    @ApiModelProperty(value = "车型")
    private String carType;


    /**
     * vin码
     */
    @ApiModelProperty(value = "vin码")
    private String vinCode;


    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String carCardNumber;


    /**
     * 车辆颜色
     */
    @ApiModelProperty(value = "车辆颜色")
    private String carColor;


    /**
     * 使用性质
     */
    @ApiModelProperty(value = "使用性质")
    private String usingNature;


    /**
     * 过户次数
     */
    @ApiModelProperty(value = "过户次数")
    private String transferOwnershipTimes;


    /**
     * 行驶里程
     */
    @ApiModelProperty(value = "行驶里程")
    private String driverMileage;

    /**
     * 上牌时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上牌时间")
    private Date registrationTime;





    public VehicleInfoDto() {
    }


    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getCarCardNumber() {
        return carCardNumber;
    }

    public void setCarCardNumber(String carCardNumber) {
        this.carCardNumber = carCardNumber;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getUsingNature() {
        return usingNature;
    }

    public void setUsingNature(String usingNature) {
        this.usingNature = usingNature;
    }

    public String getTransferOwnershipTimes() {
        return transferOwnershipTimes;
    }

    public void setTransferOwnershipTimes(String transferOwnershipTimes) {
        this.transferOwnershipTimes = transferOwnershipTimes;
    }

    public String getDriverMileage() {
        return driverMileage;
    }

    public void setDriverMileage(String driverMileage) {
        this.driverMileage = driverMileage;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }
}
