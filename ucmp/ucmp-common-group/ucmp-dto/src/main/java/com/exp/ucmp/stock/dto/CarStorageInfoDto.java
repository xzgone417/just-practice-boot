package com.exp.ucmp.stock.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author GeYiJiang
 * @Description: 车辆仓储信息
 * @date 2023/2/3 10:52
 */
@ApiModel(value = "CarStorageInfoDto", description = "车辆仓储信息Dto")
public class CarStorageInfoDto extends BaseModel {

    @ApiModelProperty(value = "仓储点名称")
    private String storageName;

    @ApiModelProperty(value = "仓储点地址")
    private String storageAddress;

    @ApiModelProperty(value = "所在城市")
    private String city;

    @ApiModelProperty(value = "所在省份")
    private String province;

    @ApiModelProperty(value = "库存类型")
    private String stockType;

    @ApiModelProperty(value = "入库时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date warehousDate;

    @ApiModelProperty(value = "退款入库时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date refundWarehousDate;

    @ApiModelProperty(value = "交付出库时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deliverDate;

    @ApiModelProperty(value = "整备状态(00:待反馈 01:已反馈待审批 02:已通过-待生成工单 03:已生成工单-待实施 04:实施完成 05:已验收入库 06:驳回 07:放弃整备-转批售 08:取消整备")
    private String serviceStart;

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public Date getWarehousDate() {
        return warehousDate;
    }

    public void setWarehousDate(Date warehousDate) {
        this.warehousDate = warehousDate;
    }

    public Date getRefundWarehousDate() {
        return refundWarehousDate;
    }

    public void setRefundWarehousDate(Date refundWarehousDate) {
        this.refundWarehousDate = refundWarehousDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getServiceStart() {
        return serviceStart;
    }

    public void setServiceStart(String serviceStart) {
        this.serviceStart = serviceStart;
    }

    public String getStorageAddress() {
        return storageAddress;
    }

    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
