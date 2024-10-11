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

@ApiModel(value = "PsiInquiryCarsEntity", description = "询价车辆表")
@GroupSequence({PsiInquiryCarsEntity.class, PsiInquiryCarsEntity.PsiInquiryCarsEntityValidGroup.class,PsiInquiryCarsEntity.InquiryIdValidGroup.class,PsiInquiryCarsEntity.BrandValidGroup.class,PsiInquiryCarsEntity.BrandChineseDescribeValidGroup.class,PsiInquiryCarsEntity.CarSeriesValidGroup.class,PsiInquiryCarsEntity.CarSeriesChineseDescribeValidGroup.class,PsiInquiryCarsEntity.CarYearValidGroup.class,PsiInquiryCarsEntity.CarYearChineseDescribeValidGroup.class,PsiInquiryCarsEntity.CarTypeValidGroup.class,PsiInquiryCarsEntity.CarTypeChineseDescribeValidGroup.class,PsiInquiryCarsEntity.LicensingCityValidGroup.class,PsiInquiryCarsEntity.LicensingProvinceValidGroup.class,PsiInquiryCarsEntity.DrivingMileageValidGroup.class,PsiInquiryCarsEntity.ColorValidGroup.class,PsiInquiryCarsEntity.LicensePlateNumValidGroup.class,PsiInquiryCarsEntity.VinCodeValidGroup.class,PsiInquiryCarsEntity.TransferTimesValidGroup.class,PsiInquiryCarsEntity.UsingNatureValidGroup.class,PsiInquiryCarsEntity.CreatedByValidGroup.class,PsiInquiryCarsEntity.CreatedDateValidGroup.class,PsiInquiryCarsEntity.UpdatedByValidGroup.class,PsiInquiryCarsEntity.UpdatedDateValidGroup.class}) 
public class PsiInquiryCarsEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 询价ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "询价ID 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, InquiryIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="询价ID 数字精度必须符合(19,0)", groups = {PsiInquiryCarsEntityValidGroup.class, InquiryIdValidGroup.class})
    @ApiModelProperty(value = "询价ID")
    private Long inquiryId;
    
    
    /**
     * 品牌
     */
    @NotNull(message = "品牌 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, BrandValidGroup.class})
    @Size(min=0, max=20, message="品牌 字符长度必须小于等于20", groups = {PsiInquiryCarsEntityValidGroup.class, BrandValidGroup.class})
    @ApiModelProperty(value = "品牌")
    private String brand;
    
    /**
     * 品牌中文描述
     */
    @NotNull(message = "品牌中文描述 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, BrandChineseDescribeValidGroup.class})
    @Size(min=0, max=50, message="品牌中文描述 字符长度必须小于等于50", groups = {PsiInquiryCarsEntityValidGroup.class, BrandChineseDescribeValidGroup.class})
    @ApiModelProperty(value = "品牌中文描述")
    private String brandChineseDescribe;
    
    /**
     * 车系
     */
    @NotNull(message = "车系 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, CarSeriesValidGroup.class})
    @Size(min=0, max=20, message="车系 字符长度必须小于等于20", groups = {PsiInquiryCarsEntityValidGroup.class, CarSeriesValidGroup.class})
    @ApiModelProperty(value = "车系")
    private String carSeries;
    
    /**
     * 车系中文描述
     */
    @NotNull(message = "车系中文描述 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, CarSeriesChineseDescribeValidGroup.class})
    @Size(min=0, max=100, message="车系中文描述 字符长度必须小于等于100", groups = {PsiInquiryCarsEntityValidGroup.class, CarSeriesChineseDescribeValidGroup.class})
    @ApiModelProperty(value = "车系中文描述")
    private String carSeriesChineseDescribe;
    
    /**
     * 年款
     */
    @NotNull(message = "年款 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, CarYearValidGroup.class})
    @Size(min=0, max=20, message="年款 字符长度必须小于等于20", groups = {PsiInquiryCarsEntityValidGroup.class, CarYearValidGroup.class})
    @ApiModelProperty(value = "年款")
    private String carYear;
    
    /**
     * 年款中文描述
     */
    @NotNull(message = "年款中文描述 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, CarYearChineseDescribeValidGroup.class})
    @Size(min=0, max=200, message="年款中文描述 字符长度必须小于等于200", groups = {PsiInquiryCarsEntityValidGroup.class, CarYearChineseDescribeValidGroup.class})
    @ApiModelProperty(value = "年款中文描述")
    private String carYearChineseDescribe;
    
    /**
     * 车型
     */
    @NotNull(message = "车型 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, CarTypeValidGroup.class})
    @Size(min=0, max=20, message="车型 字符长度必须小于等于20", groups = {PsiInquiryCarsEntityValidGroup.class, CarTypeValidGroup.class})
    @ApiModelProperty(value = "车型")
    private String carType;
    
    /**
     * 车型中文描述
     */
    @NotNull(message = "车型中文描述 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, CarTypeChineseDescribeValidGroup.class})
    @Size(min=0, max=200, message="车型中文描述 字符长度必须小于等于200", groups = {PsiInquiryCarsEntityValidGroup.class, CarTypeChineseDescribeValidGroup.class})
    @ApiModelProperty(value = "车型中文描述")
    private String carTypeChineseDescribe;
    
    /**
     * 上牌城市
     */
    @Size(min=0, max=50, message="上牌城市 字符长度必须小于等于50", groups = {PsiInquiryCarsEntityValidGroup.class, LicensingCityValidGroup.class})
    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;
    
    /**
     * 上牌省份
     */
    @Size(min=0, max=8, message="上牌省份 字符长度必须小于等于8", groups = {PsiInquiryCarsEntityValidGroup.class, LicensingProvinceValidGroup.class})
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
    @Digits(integer=9, fraction=0, message="行驶里程 数字精度必须符合(9,0)", groups = {PsiInquiryCarsEntityValidGroup.class, DrivingMileageValidGroup.class})
    @ApiModelProperty(value = "行驶里程")
    private Long drivingMileage;
    
    /**
     * 颜色
     */
    @Size(min=0, max=10, message="颜色 字符长度必须小于等于10", groups = {PsiInquiryCarsEntityValidGroup.class, ColorValidGroup.class})
    @ApiModelProperty(value = "颜色")
    private String color;
    
    /**
     * 车牌号
     */
    @Size(min=0, max=10, message="车牌号 字符长度必须小于等于10", groups = {PsiInquiryCarsEntityValidGroup.class, LicensePlateNumValidGroup.class})
    @ApiModelProperty(value = "车牌号")
    private String licensePlateNum;
    
    /**
     * VIN码
     */
    @Size(min=0, max=20, message="VIN码 字符长度必须小于等于20", groups = {PsiInquiryCarsEntityValidGroup.class, VinCodeValidGroup.class})
    @ApiModelProperty(value = "VIN码")
    private String vinCode;
    
    /**
     * 过户次数
     */
    @Size(min=0, max=3, message="过户次数 字符长度必须小于等于3", groups = {PsiInquiryCarsEntityValidGroup.class, TransferTimesValidGroup.class})
    @ApiModelProperty(value = "过户次数")
    private String transferTimes;
    
    /**
     * 使用性质
     */
    @Size(min=0, max=4, message="使用性质 字符长度必须小于等于4", groups = {PsiInquiryCarsEntityValidGroup.class, UsingNatureValidGroup.class})
    @ApiModelProperty(value = "使用性质")
    private String usingNature;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiInquiryCarsEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiInquiryCarsEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiInquiryCarsEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PsiInquiryCarsEntity() {
    }
    
    public PsiInquiryCarsEntity(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }
    public Long getInquiryId() {
        return this.inquiryId;
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
    
    public void setDrivingMileage(Long drivingMileage) {
        this.drivingMileage = drivingMileage;
    }
    public Long getDrivingMileage() {
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
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (inquiryId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                inquiryId = RandomIDGennerator.get().generate();
    }

    public interface PsiInquiryCarsEntityValidGroup {}
    public interface InquiryIdValidGroup {}
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

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            InquiryIdValidGroup.class
            , BrandValidGroup.class
            , BrandChineseDescribeValidGroup.class
            , CarSeriesValidGroup.class
            , CarSeriesChineseDescribeValidGroup.class
            , CarYearValidGroup.class
            , CarYearChineseDescribeValidGroup.class
            , CarTypeValidGroup.class
            , CarTypeChineseDescribeValidGroup.class
            , LicensingCityValidGroup.class
            , LicensingProvinceValidGroup.class
            , DrivingMileageValidGroup.class
            , ColorValidGroup.class
            , LicensePlateNumValidGroup.class
            , VinCodeValidGroup.class
            , TransferTimesValidGroup.class
            , UsingNatureValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
