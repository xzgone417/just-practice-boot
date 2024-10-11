package com.exp.ucmp.storeApp.dto;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.PsiCustomerCarsEntity;
import com.exp.ucmp.entity.PsiNewCarOrderEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.GroupSequence;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(value = "PsiNewCarOrderDto", description = "新车订单传入信息")
    public class PsiNewCarOrderDto extends BaseModel {

    private static final long serialVersionUID = 1L;


    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "新车ID 不能是Null", groups = {PsiNewCarOrderEntity.PsiNewCarOrderEntityValidGroup.class, PsiNewCarOrderEntity.NewCarIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="新车ID 数字精度必须符合(19,0)", groups = {PsiNewCarOrderEntity.PsiNewCarOrderEntityValidGroup.class, PsiNewCarOrderEntity.NewCarIdValidGroup.class})
    @ApiModelProperty(value = "新车ID")
    private Long newCarId;


    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;



    /**
     * 新车VIN码
     */
    @Size(min=0, max=30, message="新车VIN码 字符长度必须小于等于30", groups = {PsiNewCarOrderEntity.PsiNewCarOrderEntityValidGroup.class, PsiNewCarOrderEntity.NewCarVinValidGroup.class})
    @ApiModelProperty(value = "新车VIN码")
    private String newCarVin;

    /**
     * 新车发票号
     */
    @Size(min=0, max=30, message="新车发票号 字符长度必须小于等于30", groups = {PsiNewCarOrderEntity.PsiNewCarOrderEntityValidGroup.class, PsiNewCarOrderEntity.NewCarInvoiceNoValidGroup.class})
    @ApiModelProperty(value = "新车发票号")
    private String newCarInvoiceNo;

    /**
     * 新车订单号
     */
    @Size(min=0, max=50, message="新车订单号 字符长度必须小于等于50", groups = {PsiNewCarOrderEntity.PsiNewCarOrderEntityValidGroup.class, PsiNewCarOrderEntity.NewCarOrderNoValidGroup.class})
    @ApiModelProperty(value = "新车订单号")
    private String newCarOrderNo;

    /**
     * 新车交付日期
     */
    @ApiModelProperty(value = "新车交付日期")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private String newCarDeliveryDate;

    /**
     * 订单状态
     */
    @ApiModelProperty(value = "订单状态( '2001'\t '已取消'\n" +
            " '2002'\t '意向金已支付'\n" +
            " '2003'\t '退款中'\n" +
            " '2004'\t '自动退款失败'\n" +
            " '2005'\t '已关闭（退款完成）'\n" +
            " '2006'\t '已失效'\n" +
            " '2010'\t '定金未支付'\n" +
            " '2021'\t '订单已锁配'\n" +
            " '2022'\t '定金已付尾款待付'\n" +
            " '2023'\t '首付未支付贷款未付'\n" +
            " '2024'\t '首付已付贷款未付'\n" +
            " '2030'\t '尾款已付待交付'\n" +
            " '2000'\t '意向金未支付'\n" +
            " '2020'\t '定金已付待确认（大定已付）')")
    private String orderStatus;

    /**
     * 车辆所有人名称
     */
    @ApiModelProperty(value = "车辆所有人名称")
    private String ownerName;

    /**
     * 车辆所有人电话
     */
    @ApiModelProperty(value = "车辆所有人电话")
    private String ownerPhone;

    /**
     * 主用车人
     */
    @ApiModelProperty(value = "主用车人")
    private String mainUserName;

    /**
     * 主用车手机号
     */
    @ApiModelProperty(value = "主用车手机号")
    private String mainUserPhone;

    /**
     * 工程车型编码
     */
    @ApiModelProperty(value = "工程车型编码")
    private String carSeriesCode;

    /**
     * 工程车型名称
     */
    @ApiModelProperty(value = "工程车型名称")
    private String carSeries;

    /**
     * 基础车型编码
     */
    @ApiModelProperty(value = "基础车型编码")
    private String carTypeCode;

    /**
     * 基础车型名称
     */
    @ApiModelProperty(value = "基础车型名称")
    private String carType;

    /**
     * 所有人证件号
     */
    @ApiModelProperty(value = "所有人证件号")
    private String ownerCardNo;

    /**
     * 订单交付状态
     */
    @ApiModelProperty(value = "订单交付状态( '22100'\t NULL\t '未销售确认'\n" +
            " '2200'\t NULL\t '已确认'\n" +
            " '2210'\t NULL\t '正在安排生产'\n" +
            " '2211'\t NULL\t '生产中'\n" +
            " '2212'\t NULL\t '生产下线'\n" +
            " '2213'\t NULL\t '待发运'\n" +
            " '2220'\t NULL\t '已做发运指令'\n" +
            " '2221'\t NULL\t '发运指令取消中'\n" +
            " '2222'\t NULL\t 'VDC已出库'\n" +
            " '2223'\t NULL\t '车辆到达DH'\n" +
            " '2230'\t NULL\t '车辆入库'\n" +
            " '2231'\t NULL\t '待验车'\n" +
            " '2232'\t NULL\t '待客户确认验车'\n" +
            " '2233'\t NULL\t '已验车'\n" +
            " '2240'\t NULL\t '待提车'\n)")
    private String orderDeliverStatus;

    @ApiModelProperty(value = "权益OR积分选择，3401 权益 3402 积分")
    private String isRightOrPoints;

    public PsiNewCarOrderDto() {
    }

    public String getMainUserName() {
        return mainUserName;
    }

    public void setMainUserName(String mainUserName) {
        this.mainUserName = mainUserName;
    }

    public String getMainUserPhone() {
        return mainUserPhone;
    }

    public void setMainUserPhone(String mainUserPhone) {
        this.mainUserPhone = mainUserPhone;
    }

    public Long getNewCarId() {
        return newCarId;
    }

    public void setNewCarId(Long newCarId) {
        this.newCarId = newCarId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getNewCarVin() {
        return newCarVin;
    }

    public void setNewCarVin(String newCarVin) {
        this.newCarVin = newCarVin;
    }

    public String getNewCarInvoiceNo() {
        return newCarInvoiceNo;
    }

    public void setNewCarInvoiceNo(String newCarInvoiceNo) {
        this.newCarInvoiceNo = newCarInvoiceNo;
    }

    public String getNewCarOrderNo() {
        return newCarOrderNo;
    }

    public void setNewCarOrderNo(String newCarOrderNo) {
        this.newCarOrderNo = newCarOrderNo;
    }

    public String getNewCarDeliveryDate() {
        return newCarDeliveryDate;
    }

    public void setNewCarDeliveryDate(String newCarDeliveryDate) {
        this.newCarDeliveryDate = newCarDeliveryDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getCarSeriesCode() {
        return carSeriesCode;
    }

    public void setCarSeriesCode(String carSeriesCode) {
        this.carSeriesCode = carSeriesCode;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getCarTypeCode() {
        return carTypeCode;
    }

    public void setCarTypeCode(String carTypeCode) {
        this.carTypeCode = carTypeCode;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getOwnerCardNo() {
        return ownerCardNo;
    }

    public void setOwnerCardNo(String ownerCardNo) {
        this.ownerCardNo = ownerCardNo;
    }

    public String getOrderDeliverStatus() {
        return orderDeliverStatus;
    }

    public void setOrderDeliverStatus(String orderDeliverStatus) {
        this.orderDeliverStatus = orderDeliverStatus;
    }

	public String getIsRightOrPoints() {
		return isRightOrPoints;
	}

	public void setIsRightOrPoints(String isRightOrPoints) {
		this.isRightOrPoints = isRightOrPoints;
	}
}
