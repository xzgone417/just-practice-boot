package com.exp.ucmp.transfer.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "TransferApplyCarInfoDto", description = "调拨申请车辆信息DTO")
public class TransferApplyCarInfoDto {

    private static final long serialVersionUID = 1L;
    /**
     * 调度申请id
     */
    @ApiModelProperty(value = "调度申请id")
    private Long transferApplyId;

    /**
     * 库存车辆id
     */
    @ApiModelProperty(value = "库存车辆id")
    private Long stockId;


    /**
     * VIN
     */
    @ApiModelProperty(value = "VIN")
    private String vinCode;

    /**
     * 库存类型
     */
    @ApiModelProperty(value = "库存类型")
    private String stockType;

    /**
     * 库龄
     */
    @ApiModelProperty(value = "库龄")
    private Integer stockAge;

    /**
     * 仓储负责人
     */
    @ApiModelProperty(value = "仓储负责人")
    private String managerName;

    /**
     * 所在仓储点地址
     */
    @ApiModelProperty(value = "所在仓储点")
    private String storageAddress;
    
    /**
     * 所在仓储点地址
     */
    @ApiModelProperty(value = "所在仓储点名称")
    private String storageName;
    
    /**
     * 所在仓储点地址id
     */
    @ApiModelProperty(value = "所在仓储点id")
    private Long storageId;
    /**
     * 负责人手机号
     */
    @ApiModelProperty(value = "负责人手机号")
    private String managerPhone;

    /**
     * 申请调往仓储点id
     */
    @ApiModelProperty(value = "申请调往仓储点id")
    private Long transferStorageId;

    /**
     * 开始调拨时间
     */
    @ApiModelProperty(value = "开始调拨时间")
    private Date startTime;

    /**
     * 期望到达时间
     */
    @ApiModelProperty(value = "期望到达时间")
    private Date expectedTime;


    /**
     * 调拨类型
     */
    @ApiModelProperty(value = "调拨类型")
    private String transferType;

    /**
     * 调拨状态
     */
    @ApiModelProperty(value = "调拨状态")
    private String transferStatus;

    /**
     * 调拨入库时间
     */
    @ApiModelProperty(value = "调拨入库时间(提交的时候不用传)")
    private Date warehousDate;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String marks;

    public TransferApplyCarInfoDto() {
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public Integer getStockAge() {
        return stockAge;
    }

    public void setStockAge(Integer stockAge) {
        this.stockAge = stockAge;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getStorageAddress() {
        return storageAddress;
    }

    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }

    public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public Long getTransferStorageId() {
        return transferStorageId;
    }

    public void setTransferStorageId(Long transferStorageId) {
        this.transferStorageId = transferStorageId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Long getTransferApplyId() {
        return transferApplyId;
    }

    public void setTransferApplyId(Long transferApplyId) {
        this.transferApplyId = transferApplyId;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getExpectedTime() {
        return expectedTime;
    }

    public void setExpectedTime(Date expectedTime) {
        this.expectedTime = expectedTime;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public Date getWarehousDate() {
        return warehousDate;
    }

    public void setWarehousDate(Date warehousDate) {
        this.warehousDate = warehousDate;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }
}
