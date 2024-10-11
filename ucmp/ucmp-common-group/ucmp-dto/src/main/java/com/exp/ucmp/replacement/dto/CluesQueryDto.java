package com.exp.ucmp.replacement.dto;

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


@ApiModel(value = "CluesQueryDto", description = "线索列表查询条件")
public class CluesQueryDto extends PageDto {


    private static final long serialVersionUID = 1L;





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
     * 创建开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建开始时间")
    private Date createdDateStart;


    /**
     * 创建结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建结束时间")
    private Date createdDateEnd;


    public CluesQueryDto() {
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

    public Date getCreatedDateStart() {
        return createdDateStart;
    }

    public void setCreatedDateStart(Date createdDateStart) {
        this.createdDateStart = createdDateStart;
    }

    public Date getCreatedDateEnd() {
        return createdDateEnd;
    }

    public void setCreatedDateEnd(Date createdDateEnd) {
        this.createdDateEnd = createdDateEnd;
    }
}
