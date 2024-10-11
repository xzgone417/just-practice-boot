package com.exp.ucmp.stock.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: CarRightDto</p>
 * <p>@Description: 车辆权益</p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/11 14:04<p>
 */
public class CarRightDto {
    @ApiModelProperty(value = "权益ID")
    private String equityId;

    @ApiModelProperty(value = "权益名称")
    private String rightName;

    public String getEquityId() {
        return equityId;
    }

    public void setEquityId(String equityId) {
        this.equityId = equityId;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }
}
