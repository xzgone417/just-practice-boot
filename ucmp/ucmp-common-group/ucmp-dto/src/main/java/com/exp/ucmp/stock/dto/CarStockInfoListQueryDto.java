package com.exp.ucmp.stock.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "CarStockInfoListQueryDto", description = "库存车辆列表查询Dto")
public class  CarStockInfoListQueryDto extends PageDto {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "1-总部 2-门店")
    private Integer option;

    @ApiModelProperty(value = "查询不用传")
    private List<Long> storeIds;
    
    @ApiModelProperty(value = "商品代码,支持模糊查询")
	private String productCode;
    
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
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String stockState;

    /**
     * 仓储点
     */
    @ApiModelProperty(value = "仓储点")
    private String storageCode;

    /**
     * 车源批次
     */
    @ApiModelProperty(value = "车源批次")
    private String sourceBatch;

    /**
     * 库存类型
     */
    @ApiModelProperty(value = "库存类型")
    private String stockType;

    /**
     * VIN（根据vin后6位查询）
     */
    @ApiModelProperty(value = "VIN（根据vin后6位查询）")
    private String vagueVinCode;

    /**
     * VIN
     */
    @ApiModelProperty(value = "VIN")
    private String vinCode;

    /**
     * VIN
     */
    @ApiModelProperty(value = "VIN")
    private List<String> vinCodeList;

    /**
     * 归属主体
     */
    @ApiModelProperty(value = "归属主体")
    private List<String> revertBody;


    /**
     * 入库日开始时间
     */
    @ApiModelProperty(value = "入库日开始时间")
    private String warehousStartDate;
    /**
     * 入库日结束时间
     */
    @ApiModelProperty(value = "入库日结束时间")
    private String warehousEndDate;

    /**
     * 决策类型
     */
    @ApiModelProperty(value = "决策类型")
    private String decisionType;

    /**
     * 作废开始时间
     */
    @ApiModelProperty(value = "作废开始时间")
    private String repealStartDate;

    /**
     * 作废结束时间
     */
    @ApiModelProperty(value = "作废结束时间")
    private String repealEndDate;

    /**
     * 是否作废(00、否，01、是 )
     */
    @ApiModelProperty(value = "是否作废(00、否，01、是 )")
    private String repealIs;

    /**
     * 选项卡状态
     */
    @ApiModelProperty(value = "选项卡状态,前端不用传值")
    private String[] tabStockState;

    public CarStockInfoListQueryDto() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getVagueVinCode() {
        return vagueVinCode;
    }

    public void setVagueVinCode(String vagueVinCode) {
        this.vagueVinCode = vagueVinCode;
    }

    public String getStockState() {
        return stockState;
    }

    public void setStockState(String stockState) {
        this.stockState = stockState;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getSourceBatch() {
        return sourceBatch;
    }

    public void setSourceBatch(String sourceBatch) {
        this.sourceBatch = sourceBatch;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public List<String> getRevertBody() {
        return revertBody;
    }

    public void setRevertBody(List<String> revertBody) {
        this.revertBody = revertBody;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }

    public String getWarehousStartDate() {
        return warehousStartDate;
    }

    public void setWarehousStartDate(String warehousStartDate) {
        this.warehousStartDate = warehousStartDate;
    }

    public String getWarehousEndDate() {
        return warehousEndDate;
    }

    public String getRepealIs() {
        return repealIs;
    }

    public void setRepealIs(String repealIs) {
        this.repealIs = repealIs;
    }

    public void setWarehousEndDate(String warehousEndDate) {
        this.warehousEndDate = warehousEndDate;
    }

    public Integer getOption() {
        return option;
    }

    public void setOption(Integer option) {
        this.option = option;
    }

    public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public List<Long> getStoreIds() {
        return storeIds;
    }

    public String[] getTabStockState() {
        return tabStockState;
    }

    public void setTabStockState(String[] tabStockState) {
        this.tabStockState = tabStockState;
    }

    public String getRepealStartDate() {
        return repealStartDate;
    }

    public void setRepealStartDate(String repealStartDate) {
        this.repealStartDate = repealStartDate;
    }

    public String getRepealEndDate() {
        return repealEndDate;
    }

    public void setRepealEndDate(String repealEndDate) {
        this.repealEndDate = repealEndDate;
    }

    public void setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
    }

    public List<String> getVinCodeList() {
        return vinCodeList;
    }

    public void setVinCodeList(List<String> vinCodeList) {
        this.vinCodeList = vinCodeList;
    }
}
