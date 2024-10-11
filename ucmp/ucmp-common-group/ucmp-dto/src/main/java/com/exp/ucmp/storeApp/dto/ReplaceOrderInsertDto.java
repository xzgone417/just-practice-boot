package com.exp.ucmp.storeApp.dto;
import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReplaceOrderInsertDto", description = "创建置换单入参")
public class ReplaceOrderInsertDto extends BaseModel {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "数据来源",required = true)
    private String cluesSource;

    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;


    /**
     * 顾问信息标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "顾问信息标识")
    private Long infoId;


    /**
     * 门店ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店ID")
    private Long storeId;




    /**
     * 店长Id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "店长Id")
    private Long storeManagerId;

    /**
     * 接单截止时间
     */
     
    @ApiModelProperty(value = "接单截止时间")
    private String orderReceivingDeadline;



    /**
     * 品牌
     */
    @ApiModelProperty(value = "品牌")
    private String brand;


    /**
     * 品牌中文描述
     */
     @ApiModelProperty(value = "品牌中文描述")
    private String brandChineseDescribe;

    /**
     * 车系
     */
    @ApiModelProperty(value = "车系")
    private String carSeries;


    /**
     * 车系中文描述
     */
    @ApiModelProperty(value = "车系中文描述")
    private String carSeriesChineseDescribe;


    /**
     * 车型
     */
    @ApiModelProperty(value = "车型")
    private String carType;

    /**
     * 车型中文描述
     */
    @ApiModelProperty(value = "车型中文描述")
    private String carTypeChineseDescribe;

    /**
     * 上牌时间
     */
     
    @ApiModelProperty(value = "上牌时间")
    private String licensingDate;

    /**
     * 行驶里程
     */
    @ApiModelProperty(value = "行驶里程")
    private String drivingMileage;



    /**
     * 预约检测时间
     */
     
    @ApiModelProperty(value = "预约检测时间")
    private String reservationDetectionDate;

    /**
     * 预约检测地点
     */
    @ApiModelProperty(value = "预约检测地点")
    private String reservationDetectionAddress;

    /**
     * 客户期望价格
     */
    @ApiModelProperty(value = "客户期望价格")
    private Long customerExpectPrice;

    /**
     * uid
     */
    @ApiModelProperty(value = "uid")
    private String uid;


    /**
     * sid
     */
    @ApiModelProperty(value = "sid")
    private String sid;


    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String customerName;


    /**
     * 客户手机
     */
    @ApiModelProperty(value = "客户手机")
    private String customerIphone;


    /**
     * 车商ID
     */
    /*@ApiModelProperty(value = "车商ID")
    private List<Long> carDealerId;*/

    /**
     * 制单人id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "制单人id")
    private Long makeOrderPersonId;


    /**
     * 制单人名字
     */
    @ApiModelProperty(value = "制单人名字")
    private String makeOrderPersonName;

    /**
     * 制单人手机
     */
    @ApiModelProperty(value = "制单人手机")
    private String makeOrderPersonIphone;

    /**
     * 年款
     */
    @ApiModelProperty(value = "年款")
    private String carYear;

    /**
     * 年款中文描述
     */
   @ApiModelProperty(value = "年款中文描述")
    private String carYearChineseDescribe;




    /**
     * 上牌城市
     */
    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;

    /**
     * 上牌省份
     */
    @ApiModelProperty(value = "上牌省份")
    private String licensingProvince;


    /**
     * 角色
     */
    @ApiModelProperty(value = "角色")
    private String role;


    /**
     * 店端登录人名字
     */
    @ApiModelProperty(value = "店端登录人名字")
    private String idmAccountName;


    /**
     * 店端登录人上级名字
     */
    @ApiModelProperty(value = "店端登录人上级名字")
    private String idmAccountUpName;




    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }





    public Long getStoreManagerId() {
        return storeManagerId;
    }

    public void setStoreManagerId(Long storeManagerId) {
        this.storeManagerId = storeManagerId;
    }



    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrandChineseDescribe() {
        return brandChineseDescribe;
    }

    public void setBrandChineseDescribe(String brandChineseDescribe) {
        this.brandChineseDescribe = brandChineseDescribe;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getCarSeriesChineseDescribe() {
        return carSeriesChineseDescribe;
    }

    public void setCarSeriesChineseDescribe(String carSeriesChineseDescribe) {
        this.carSeriesChineseDescribe = carSeriesChineseDescribe;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarTypeChineseDescribe() {
        return carTypeChineseDescribe;
    }

    public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
        this.carTypeChineseDescribe = carTypeChineseDescribe;
    }



    public String getDrivingMileage() {
        return drivingMileage;
    }

    public void setDrivingMileage(String drivingMileage) {
        this.drivingMileage = drivingMileage;
    }



    public String getReservationDetectionAddress() {
        return reservationDetectionAddress;
    }

    public void setReservationDetectionAddress(String reservationDetectionAddress) {
        this.reservationDetectionAddress = reservationDetectionAddress;
    }

    public Long getCustomerExpectPrice() {
        return customerExpectPrice;
    }

    public void setCustomerExpectPrice(Long customerExpectPrice) {
        this.customerExpectPrice = customerExpectPrice;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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


    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }



    public String getMakeOrderPersonName() {
        return makeOrderPersonName;
    }

    public void setMakeOrderPersonName(String makeOrderPersonName) {
        this.makeOrderPersonName = makeOrderPersonName;
    }

    public String getMakeOrderPersonIphone() {
        return makeOrderPersonIphone;
    }

    public void setMakeOrderPersonIphone(String makeOrderPersonIphone) {
        this.makeOrderPersonIphone = makeOrderPersonIphone;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getCarYearChineseDescribe() {
        return carYearChineseDescribe;
    }

    public void setCarYearChineseDescribe(String carYearChineseDescribe) {
        this.carYearChineseDescribe = carYearChineseDescribe;
    }

    public String getLicensingCity() {
        return licensingCity;
    }

    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }

    public String getLicensingProvince() {
        return licensingProvince;
    }

    public void setLicensingProvince(String licensingProvince) {
        this.licensingProvince = licensingProvince;
    }




    public String getOrderReceivingDeadline() {
        return orderReceivingDeadline;
    }

    public void setOrderReceivingDeadline(String orderReceivingDeadline) {
        this.orderReceivingDeadline = orderReceivingDeadline;
    }

    public String getLicensingDate() {
        return licensingDate;
    }

    public void setLicensingDate(String licensingDate) {
        this.licensingDate = licensingDate;
    }

    public String getReservationDetectionDate() {
        return reservationDetectionDate;
    }

    public void setReservationDetectionDate(String reservationDetectionDate) {
        this.reservationDetectionDate = reservationDetectionDate;
    }



    public Long getMakeOrderPersonId() {
        return makeOrderPersonId;
    }

    public void setMakeOrderPersonId(Long makeOrderPersonId) {
        this.makeOrderPersonId = makeOrderPersonId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public String getIdmAccountName() {
        return idmAccountName;
    }

    public void setIdmAccountName(String idmAccountName) {
        this.idmAccountName = idmAccountName;
    }

    public String getIdmAccountUpName() {
        return idmAccountUpName;
    }

    public void setIdmAccountUpName(String idmAccountUpName) {
        this.idmAccountUpName = idmAccountUpName;
    }


    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public String getCluesSource() {
        return cluesSource;
    }

    public void setCluesSource(String cluesSource) {
        this.cluesSource = cluesSource;
    }
}
