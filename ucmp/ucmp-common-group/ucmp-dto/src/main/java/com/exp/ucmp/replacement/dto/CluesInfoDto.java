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


@ApiModel(value = "CluesInfoDto", description = "线索列表")
public class CluesInfoDto extends PageDto {


    private static final long serialVersionUID = 1L;



    /**
     * 预约标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约标识")
    private Long bookingId;

    /**
     * 线索标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "线索标识")
    private Long cluesId;


    /**
     * 客户标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "客户标识")
    private Long customerId;

    /**
     * 门店名称
     */
    @ApiModelProperty(value = "门店名称")
    private String storeName;


    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称")
    private String customerName;


    /**
     * 客户手机
     */
    @ApiModelProperty(value = "客户手机")
    private String customerIphone;


    /**
     * 线索来源
     */
    @ApiModelProperty(value = "线索来源")
    private String cluesSource;


    /**
     * 线索状态
     */
    @ApiModelProperty(value = "线索状态'01' '待预约', '02' '进行中', ''03' '待核审', '04' '已驳回', '05' '已通过', '09' '审核关闭', '01', '6406191811811870964', '2022-08-12 13:37:59', '6406191811811870964', '2022-08-12 13:37:59'\n")
    private String cluesStatus;


    /**
     * 车型
     */
    @ApiModelProperty(value = "车型")
    private String carType;


    /**
     * 顾问名称
     */
    @ApiModelProperty(value = "顾问名称")
    private String staffName;

    /**
     * 下发时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "下发时间")
    private Date underIssuedTime;


    /**
     * 预约检测时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预约检测时间")
    private Date scheduledTestTime;


    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;


    public CluesInfoDto() {
    }


    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getCluesId() {
        return cluesId;
    }

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIphone() {
        return customerIphone;
    }

    public void setCustomerIphone(String customerIphone) {
        this.customerIphone = customerIphone;
    }

    public String getCluesSource() {
        return cluesSource;
    }

    public void setCluesSource(String cluesSource) {
        this.cluesSource = cluesSource;
    }

    public String getCluesStatus() {
        return cluesStatus;
    }

    public void setCluesStatus(String cluesStatus) {
        this.cluesStatus = cluesStatus;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public Date getUnderIssuedTime() {
        return underIssuedTime;
    }

    public void setUnderIssuedTime(Date underIssuedTime) {
        this.underIssuedTime = underIssuedTime;
    }

    public Date getScheduledTestTime() {
        return scheduledTestTime;
    }

    public void setScheduledTestTime(Date scheduledTestTime) {
        this.scheduledTestTime = scheduledTestTime;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}