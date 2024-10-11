package com.exp.ucmp.stock.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarStockGroundingParamDto", description = "商城车辆上架列表查询参数")
public class CarStockGroundingParamDto extends PageDto{

    @ApiModelProperty(value = "城市名称")
    private String city;

    @ApiModelProperty(value = "工程车型")
    private String carSeriesCode;
    
    @ApiModelProperty(value = "基础车型名称code")
    private String baseCarTypeCode;

    @ApiModelProperty(value = "排序类型(1价格低到高2价格高到低3里程少到多4车龄新到旧)")
    private String type;
    
    @ApiModelProperty(value = "当前页库存车辆ID")
    private String curStockId;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCarSeriesCode() {
		return carSeriesCode;
	}

	public void setCarSeriesCode(String carSeriesCode) {
		this.carSeriesCode = carSeriesCode;
	}

	public String getBaseCarTypeCode() {
		return baseCarTypeCode;
	}

	public void setBaseCarTypeCode(String baseCarTypeCode) {
		this.baseCarTypeCode = baseCarTypeCode;
	}

	public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public String getCurStockId() {
		return curStockId;
	}

	public void setCurStockId(String curStockId) {
		this.curStockId = curStockId;
	}
}
