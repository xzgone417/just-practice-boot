package com.exp.ucmp.warehouse.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author hailele
 * @Description: 出入库查询条件dto
 * @date 2023/2/17 10:10
 */
@ApiModel(value = "WarehouseQueryDto", description = "出入库查询条件dto")
public class CheckWarehouseQueryDto extends PageDto {

    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;

    @ApiModelProperty(value = "基础车型")
    private String baseCarTypeName;

    @ApiModelProperty(value = "vin")
    private String vin;

    @ApiModelProperty(value = "orgId(不用传)")
    private Long orgId;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getCarSeriesName() {
        return carSeriesName;
    }

    public void setCarSeriesName(String carSeriesName) {
        this.carSeriesName = carSeriesName;
    }

    public String getBaseCarTypeName() {
        return baseCarTypeName;
    }

    public void setBaseCarTypeName(String baseCarTypeName) {
        this.baseCarTypeName = baseCarTypeName;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}
