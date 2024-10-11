package com.exp.ucmp.transfer.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 调拨车辆申请列表查询条件
 * @date 2023/2/13 13:51
 */
@ApiModel(value = "TransferCarApplyQueryDto", description = "调拨车辆申请列表查询条件")
public class TransferCarApplyQueryDto extends PageDto {

    @ApiModelProperty(value = "调拨发运状态-1调拨入库-2调拨出库-3")
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @ApiModelProperty(value = "vin")
    private String vin;

    @ApiModelProperty(value = "所在仓储点")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long storageId;

    @ApiModelProperty(value = "调往仓储点id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long transferStorageId;

    @ApiModelProperty(value = "状态(调拨申请：字典表查：52)（调拨登记：00待提交 02关闭）")
    private String transferStatus;

    @ApiModelProperty(value = "调拨类型")
    private String transferType;

    @ApiModelProperty(value = "不用传")
    private List<Long> storeIds;

    public List<Long> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public Long getTransferStorageId() {
        return transferStorageId;
    }

    public void setTransferStorageId(Long transferStorageId) {
        this.transferStorageId = transferStorageId;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }
}
