package com.exp.ucmp.stock.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ServicingCompletedDto", description = "整备完成车辆Dto")
public class ServicingCompletedDto {

    private static final long serialVersionUID = 1L;

    /**
     * 库存车辆id
     */
    @ApiModelProperty(value = "库存车辆id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stockId;


    /**
     * 仓储点id
     */
    @ApiModelProperty(value = "仓储点id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long storageId;

    /**
     * 仓储点名称
     */
    @ApiModelProperty(value = "仓储点名称")
    private String storageName;


    /**
     * 仓库编码
     */
    @ApiModelProperty(value = "仓库编码")
    private String storageCode;

    /**
     * 车辆来源
     */
    @ApiModelProperty(value = "车辆来源")
    private String carSource;


    /**
     * 车源批次
     */
    @ApiModelProperty(value = "车源批次")
    private String sourceBatch;

    /**
     * 归属主体
     */
    @ApiModelProperty(value = "归属主体")
    private String revertBody;

    /**
     * VIN码
     */
    @ApiModelProperty(value = "VIN码")
    private String vinCode;


    /**
     * 决策类型
     */
    @ApiModelProperty(value = "决策类型")
    private String decisionType;


    /**
     * 工程车型名称
     */
    @ApiModelProperty(value = "工程车型名称")
    private String carSeriesName;

    /**
     * 基础车型名称
     */
    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;

    /**
     * 状态(001:在库待售/002:整备中/003:待上架/004:在售中/005:已预订/006:已售出/007:退款待上架/)
     */
    @ApiModelProperty(value = "状态(001:在库待售/002:整备中/003:待上架/004:在售中/005:已预订/006:已售出/007:退款待上架/)")
    private String stockState;
    
    @ApiModelProperty(value = "状态名称")
    private String stockStateName;

    /**
     * 是否调整
     */
    @ApiModelProperty(value = "是否修改过(001未修改002已修改)")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getCarSource() {
        return carSource;
    }

    public void setCarSource(String carSource) {
        this.carSource = carSource;
    }

    public String getSourceBatch() {
        return sourceBatch;
    }

    public void setSourceBatch(String sourceBatch) {
        this.sourceBatch = sourceBatch;
    }

    public String getRevertBody() {
        return revertBody;
    }

    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
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

    public String getStockState() {
        return stockState;
    }

    public void setStockState(String stockState) {
        this.stockState = stockState;
    }

	public String getStockStateName() {
		return stockStateName;
	}

	public void setStockStateName(String stockStateName) {
		this.stockStateName = stockStateName;
	}
}
