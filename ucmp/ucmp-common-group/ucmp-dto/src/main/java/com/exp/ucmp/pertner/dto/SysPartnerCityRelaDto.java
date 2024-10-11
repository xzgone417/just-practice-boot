package com.exp.ucmp.pertner.dto;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;
import com.exp.ucmp.PageDto;
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

@ApiModel(value = "SysPartnerCityRelaDto", description = "合作商管辖城市信息")
public class SysPartnerCityRelaDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 城市标识/主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "城市标识/主键")
    private Long cityId;


    /**
     * 行政区域编码
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "行政区域编码")
    private Long regionCode;


    /**
     * 合作商标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "合作商标识")
    private Long partnerId;

    /**
     * 区域
     */
    @ApiModelProperty(value = "区域")
    private String cityArea;


    /**
     * 区域标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "区域标识")
    private Long areaId;

    /**
     * 省份
     */
    @ApiModelProperty(value = "省份")
    private String cityProvince;




    /**
     * 城市名称
     */
    @ApiModelProperty(value = "城市名称")
    private String cityName;









    public SysPartnerCityRelaDto() {
    }

    public SysPartnerCityRelaDto(Long cityId) {
        this.cityId = cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    public Long getCityId() {
        return this.cityId;
    }
    

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }
    public Long getPartnerId() {
        return this.partnerId;
    }
    
    public void setCityArea(String cityArea) {
        this.cityArea = cityArea;
    }
    public String getCityArea() {
        return this.cityArea;
    }
    
    public void setCityProvince(String cityProvince) {
        this.cityProvince = cityProvince;
    }
    public String getCityProvince() {
        return this.cityProvince;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getCityName() {
        return this.cityName;
    }


    public Long getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Long regionCode) {
        this.regionCode = regionCode;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
}
