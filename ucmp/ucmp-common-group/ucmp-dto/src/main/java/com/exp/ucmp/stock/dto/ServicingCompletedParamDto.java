/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.stock.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


@ApiModel(value = "ServicingCompletedParamDto", description = "整备完成车辆列表查询参数")
public class ServicingCompletedParamDto extends PageDto {

    /**
     * 工程车型
     */
    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;

    /**
     * 基础车型
     */
    @ApiModelProperty(value = "基础车型")
    private String baseCarTypeName;


    /**
     * 仓储点
     */
    @ApiModelProperty(value = "仓储点")
    private String storageCode;

    /**
     * VIN
     */
    @ApiModelProperty(value = "VIN")
    private String vinCode;


    /**
     * 归属主体
     */
    @ApiModelProperty(value = "归属主体")
    private String revertBody;

    @ApiModelProperty(value = "1可调整2已售出")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getRevertBody() {
        return revertBody;
    }

    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }
}
