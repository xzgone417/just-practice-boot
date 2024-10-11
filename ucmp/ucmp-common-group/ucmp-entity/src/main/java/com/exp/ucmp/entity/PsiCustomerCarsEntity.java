package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "PsiCustomerCarsEntity", description = "客户车辆表")
@GroupSequence({PsiCustomerCarsEntity.class, PsiCustomerCarsEntity.PsiCustomerCarsEntityValidGroup.class,PsiCustomerCarsEntity.ReservationIdValidGroup.class,PsiCustomerCarsEntity.CustomerIdValidGroup.class,PsiCustomerCarsEntity.BrandValidGroup.class,PsiCustomerCarsEntity.BrandChineseDescribeValidGroup.class,PsiCustomerCarsEntity.CarSeriesValidGroup.class,PsiCustomerCarsEntity.CarSeriesChineseDescribeValidGroup.class,PsiCustomerCarsEntity.CarYearValidGroup.class,PsiCustomerCarsEntity.CarYearChineseDescribeValidGroup.class,PsiCustomerCarsEntity.CarTypeValidGroup.class,PsiCustomerCarsEntity.CarTypeChineseDescribeValidGroup.class,PsiCustomerCarsEntity.LicensingCityValidGroup.class,PsiCustomerCarsEntity.LicensingProvinceValidGroup.class,PsiCustomerCarsEntity.DrivingMileageValidGroup.class,PsiCustomerCarsEntity.ColorValidGroup.class,PsiCustomerCarsEntity.LicensePlateNumValidGroup.class,PsiCustomerCarsEntity.VinCodeValidGroup.class,PsiCustomerCarsEntity.TransferTimesValidGroup.class,PsiCustomerCarsEntity.UsingNatureValidGroup.class,PsiCustomerCarsEntity.CreatedByValidGroup.class,PsiCustomerCarsEntity.CreatedDateValidGroup.class,PsiCustomerCarsEntity.UpdatedByValidGroup.class,PsiCustomerCarsEntity.UpdatedDateValidGroup.class,PsiCustomerCarsEntity.RankValidGroup.class,PsiCustomerCarsEntity.RevertBodyValidGroup.class}) 
public class PsiCustomerCarsEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "预约ID 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, ReservationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="预约ID 数字精度必须符合(19,0)", groups = {PsiCustomerCarsEntityValidGroup.class, ReservationIdValidGroup.class})
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    
    /**
     * 客户ID
     */
    @NotNull(message = "客户ID 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, CustomerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="客户ID 数字精度必须符合(19,0)", groups = {PsiCustomerCarsEntityValidGroup.class, CustomerIdValidGroup.class})
    @ApiModelProperty(value = "客户ID")
    private Long customerId;
    
    /**
     * 品牌
     */
    @NotNull(message = "品牌 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, BrandValidGroup.class})
    @Size(min=0, max=20, message="品牌 字符长度必须小于等于20", groups = {PsiCustomerCarsEntityValidGroup.class, BrandValidGroup.class})
    @ApiModelProperty(value = "品牌")
    private String brand;
    
    /**
     * 品牌中文描述
     */
    @NotNull(message = "品牌中文描述 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, BrandChineseDescribeValidGroup.class})
    @Size(min=0, max=50, message="品牌中文描述 字符长度必须小于等于50", groups = {PsiCustomerCarsEntityValidGroup.class, BrandChineseDescribeValidGroup.class})
    @ApiModelProperty(value = "品牌中文描述")
    private String brandChineseDescribe;
    
    /**
     * 车系
     */
    @NotNull(message = "车系 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, CarSeriesValidGroup.class})
    @Size(min=0, max=20, message="车系 字符长度必须小于等于20", groups = {PsiCustomerCarsEntityValidGroup.class, CarSeriesValidGroup.class})
    @ApiModelProperty(value = "车系")
    private String carSeries;
    
    /**
     * 车系中文描述
     */
    @NotNull(message = "车系中文描述 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, CarSeriesChineseDescribeValidGroup.class})
    @Size(min=0, max=100, message="车系中文描述 字符长度必须小于等于100", groups = {PsiCustomerCarsEntityValidGroup.class, CarSeriesChineseDescribeValidGroup.class})
    @ApiModelProperty(value = "车系中文描述")
    private String carSeriesChineseDescribe;
    
    /**
     * 年款
     */
    @NotNull(message = "年款 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, CarYearValidGroup.class})
    @Size(min=0, max=20, message="年款 字符长度必须小于等于20", groups = {PsiCustomerCarsEntityValidGroup.class, CarYearValidGroup.class})
    @ApiModelProperty(value = "年款")
    private String carYear;
    
    /**
     * 年款中文描述
     */
    @NotNull(message = "年款中文描述 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, CarYearChineseDescribeValidGroup.class})
    @Size(min=0, max=200, message="年款中文描述 字符长度必须小于等于200", groups = {PsiCustomerCarsEntityValidGroup.class, CarYearChineseDescribeValidGroup.class})
    @ApiModelProperty(value = "年款中文描述")
    private String carYearChineseDescribe;
    
    /**
     * 车型
     */
    @NotNull(message = "车型 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, CarTypeValidGroup.class})
    @Size(min=0, max=20, message="车型 字符长度必须小于等于20", groups = {PsiCustomerCarsEntityValidGroup.class, CarTypeValidGroup.class})
    @ApiModelProperty(value = "车型")
    private String carType;
    
    /**
     * 车型中文描述
     */
    @NotNull(message = "车型中文描述 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, CarTypeChineseDescribeValidGroup.class})
    @Size(min=0, max=200, message="车型中文描述 字符长度必须小于等于200", groups = {PsiCustomerCarsEntityValidGroup.class, CarTypeChineseDescribeValidGroup.class})
    @ApiModelProperty(value = "车型中文描述")
    private String carTypeChineseDescribe;
    
    /**
     * 上牌城市
     */
    @Size(min=0, max=50, message="上牌城市 字符长度必须小于等于50", groups = {PsiCustomerCarsEntityValidGroup.class, LicensingCityValidGroup.class})
    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;
    
    /**
     * 上牌省份
     */
    @Size(min=0, max=8, message="上牌省份 字符长度必须小于等于8", groups = {PsiCustomerCarsEntityValidGroup.class, LicensingProvinceValidGroup.class})
    @ApiModelProperty(value = "上牌省份")
    private String licensingProvince;
    
    /**
     * 上牌时间
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "上牌时间")
    private Date licensingDate;
    
    /**
     * 行驶里程
     */
    @Size(min=0, max=20, message="行驶里程 字符长度必须小于等于20", groups = {PsiCustomerCarsEntityValidGroup.class, DrivingMileageValidGroup.class})
    @ApiModelProperty(value = "行驶里程")
    private String drivingMileage;
    
    /**
     * 颜色
     */
    @Size(min=0, max=10, message="颜色 字符长度必须小于等于10", groups = {PsiCustomerCarsEntityValidGroup.class, ColorValidGroup.class})
    @ApiModelProperty(value = "颜色")
    private String color;
    
    /**
     * 车牌号
     */
    @Size(min=0, max=10, message="车牌号 字符长度必须小于等于10", groups = {PsiCustomerCarsEntityValidGroup.class, LicensePlateNumValidGroup.class})
    @ApiModelProperty(value = "车牌号")
    private String licensePlateNum;
    
    /**
     * VIN码
     */
    @Size(min=0, max=20, message="VIN码 字符长度必须小于等于20", groups = {PsiCustomerCarsEntityValidGroup.class, VinCodeValidGroup.class})
    @ApiModelProperty(value = "VIN码")
    private String vinCode;
    
    /**
     * 过户次数
     */
    @Size(min=0, max=3, message="过户次数 字符长度必须小于等于3", groups = {PsiCustomerCarsEntityValidGroup.class, TransferTimesValidGroup.class})
    @ApiModelProperty(value = "过户次数")
    private String transferTimes;
    
    /**
     * 使用性质
     */
    @Size(min=0, max=4, message="使用性质 字符长度必须小于等于4", groups = {PsiCustomerCarsEntityValidGroup.class, UsingNatureValidGroup.class})
    @ApiModelProperty(value = "使用性质")
    private String usingNature;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCustomerCarsEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCustomerCarsEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCustomerCarsEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 车辆定级 S、A、B、C
     */
    @Size(min=0, max=2, message="车辆定级 S、A、B、C 字符长度必须小于等于2", groups = {PsiCustomerCarsEntityValidGroup.class, RankValidGroup.class})
    @ApiModelProperty(value = "车辆定级 S、A、B、C")
    private String rank;
    
    /**
     * 车辆收购主体
     */
    @Size(min=0, max=100, message="车辆收购主体 字符长度必须小于等于100", groups = {PsiCustomerCarsEntityValidGroup.class, RevertBodyValidGroup.class})
    @ApiModelProperty(value = "车辆收购主体")
    private String revertBody;
    
    public PsiCustomerCarsEntity() {
    }
    
    public PsiCustomerCarsEntity(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
    }
    

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return this.brand;
    }
    
    public void setBrandChineseDescribe(String brandChineseDescribe) {
        this.brandChineseDescribe = brandChineseDescribe;
    }
    public String getBrandChineseDescribe() {
        return this.brandChineseDescribe;
    }
    
    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }
    public String getCarSeries() {
        return this.carSeries;
    }
    
    public void setCarSeriesChineseDescribe(String carSeriesChineseDescribe) {
        this.carSeriesChineseDescribe = carSeriesChineseDescribe;
    }
    public String getCarSeriesChineseDescribe() {
        return this.carSeriesChineseDescribe;
    }
    
    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }
    public String getCarYear() {
        return this.carYear;
    }
    
    public void setCarYearChineseDescribe(String carYearChineseDescribe) {
        this.carYearChineseDescribe = carYearChineseDescribe;
    }
    public String getCarYearChineseDescribe() {
        return this.carYearChineseDescribe;
    }
    
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public String getCarType() {
        return this.carType;
    }
    
    public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
        this.carTypeChineseDescribe = carTypeChineseDescribe;
    }
    public String getCarTypeChineseDescribe() {
        return this.carTypeChineseDescribe;
    }
    
    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }
    public String getLicensingCity() {
        return this.licensingCity;
    }
    
    public void setLicensingProvince(String licensingProvince) {
        this.licensingProvince = licensingProvince;
    }
    public String getLicensingProvince() {
        return this.licensingProvince;
    }
    
    public void setLicensingDate(Date licensingDate) {
        this.licensingDate = licensingDate;
    }
    public Date getLicensingDate() {
        return this.licensingDate;
    }
    
    public void setDrivingMileage(String drivingMileage) {
        this.drivingMileage = drivingMileage;
    }
    public String getDrivingMileage() {
        return this.drivingMileage;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum;
    }
    public String getLicensePlateNum() {
        return this.licensePlateNum;
    }
    
    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }
    public String getVinCode() {
        return this.vinCode;
    }
    
    public void setTransferTimes(String transferTimes) {
        this.transferTimes = transferTimes;
    }
    public String getTransferTimes() {
        return this.transferTimes;
    }
    
    public void setUsingNature(String usingNature) {
        this.usingNature = usingNature;
    }
    public String getUsingNature() {
        return this.usingNature;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Long getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Long getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getRank() {
        return this.rank;
    }
    
    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }
    public String getRevertBody() {
        return this.revertBody;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (reservationId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                reservationId = RandomIDGennerator.get().generate();
    }

    public interface PsiCustomerCarsEntityValidGroup {}
    public interface ReservationIdValidGroup {}
    public interface CustomerIdValidGroup {}
    public interface BrandValidGroup {}
    public interface BrandChineseDescribeValidGroup {}
    public interface CarSeriesValidGroup {}
    public interface CarSeriesChineseDescribeValidGroup {}
    public interface CarYearValidGroup {}
    public interface CarYearChineseDescribeValidGroup {}
    public interface CarTypeValidGroup {}
    public interface CarTypeChineseDescribeValidGroup {}
    public interface LicensingCityValidGroup {}
    public interface LicensingProvinceValidGroup {}
    public interface DrivingMileageValidGroup {}
    public interface ColorValidGroup {}
    public interface LicensePlateNumValidGroup {}
    public interface VinCodeValidGroup {}
    public interface TransferTimesValidGroup {}
    public interface UsingNatureValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface RankValidGroup {}
    public interface RevertBodyValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiCustomerCarsEntity.ReservationIdValidGroup.class
            , PsiCustomerCarsEntity.CustomerIdValidGroup.class
            , PsiCustomerCarsEntity.BrandValidGroup.class
            , PsiCustomerCarsEntity.BrandChineseDescribeValidGroup.class
            , PsiCustomerCarsEntity.CarSeriesValidGroup.class
            , PsiCustomerCarsEntity.CarSeriesChineseDescribeValidGroup.class
            , PsiCustomerCarsEntity.CarYearValidGroup.class
            , PsiCustomerCarsEntity.CarYearChineseDescribeValidGroup.class
            , PsiCustomerCarsEntity.CarTypeValidGroup.class
            , PsiCustomerCarsEntity.CarTypeChineseDescribeValidGroup.class
            , PsiCustomerCarsEntity.LicensingCityValidGroup.class
            , PsiCustomerCarsEntity.LicensingProvinceValidGroup.class
            , PsiCustomerCarsEntity.DrivingMileageValidGroup.class
            , PsiCustomerCarsEntity.ColorValidGroup.class
            , PsiCustomerCarsEntity.LicensePlateNumValidGroup.class
            , PsiCustomerCarsEntity.VinCodeValidGroup.class
            , PsiCustomerCarsEntity.TransferTimesValidGroup.class
            , PsiCustomerCarsEntity.UsingNatureValidGroup.class
            , PsiCustomerCarsEntity.CreatedByValidGroup.class
            , PsiCustomerCarsEntity.CreatedDateValidGroup.class
            , PsiCustomerCarsEntity.UpdatedByValidGroup.class
            , PsiCustomerCarsEntity.UpdatedDateValidGroup.class
            , PsiCustomerCarsEntity.RankValidGroup.class
            , PsiCustomerCarsEntity.RevertBodyValidGroup.class
        };
    }
}
