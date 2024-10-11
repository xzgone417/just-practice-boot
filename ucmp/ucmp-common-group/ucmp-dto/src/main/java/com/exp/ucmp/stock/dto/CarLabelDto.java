package com.exp.ucmp.stock.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: CarLabelDto</p>
 * <p>@Description: 车辆标签</p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/11 16:49<p>
 */
public class CarLabelDto {
    @ApiModelProperty("标签序号")
    private Integer labelSort;
    @ApiModelProperty("标签名称")
    private String labelName;
    @ApiModelProperty("标签code")
    private String labelCode;

    public Integer getLabelSort() {
        return labelSort;
    }

    public void setLabelSort(Integer labelSort) {
        this.labelSort = labelSort;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public String getLabelCode() {
        return labelCode;
    }

    public void setLabelCode(String labelCode) {
        this.labelCode = labelCode;
    }
}
