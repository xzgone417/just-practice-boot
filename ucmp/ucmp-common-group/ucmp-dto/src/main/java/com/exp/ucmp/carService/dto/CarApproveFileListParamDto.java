package com.exp.ucmp.carService.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel(value = "CarApproveFileListParamDto", description = "车辆图片审批列表查询Dto")
public class CarApproveFileListParamDto extends PageDto {

    private static final long serialVersionUID = 1L;

    /**
     * 工程车型编码
     */
    @ApiModelProperty(value = "工程车型编码")
    private String carSeriesCode;

    /**
     * 基础车型编码
     */
    @ApiModelProperty(value = "基础车型编码")
    private String baseCarTypeCode;

    /**
     * 仓储点编码
     */
    @ApiModelProperty(value = "仓储点编码")
    private String storageCode;


    /**
     * 整备入库开始时间
     */
    @ApiModelProperty(value = "整备入库开始时间")
    private Date warehousStartDate;

    /**
     * 整备入库结束时间
     */
    @ApiModelProperty(value = "整备入库结束时间")
    private Date warehousEndDate;

    /**
     * VIN
     */
    @ApiModelProperty(value = "VIN")
    private String vinCode;

    /**
     * 归属主体
     */
    @ApiModelProperty(value = "归属主体")
    private List<String> revertBody;

    /**
     * 审批开始时间
     */
    @ApiModelProperty(value = "审批开始时间")
    private Date approvalStartDate;

    /**
     * 审批开始时间
     */
    @ApiModelProperty(value = "审批结束时间")
    private Date approvalEndDate;

    /**
     * 列表页面tab选项卡参数(审批结果00:驳回/01:通过;待通过不传值通过)
     */
    @ApiModelProperty(value = "列表页面tab选项卡参数(审批结果00:驳回/01:通过;待通过不传值通过)")
    private String approvalResult;

    /**
     * 整备单状态
     */
    @ApiModelProperty(value = "整备单状态（前端不用传）")
    private String serviceState;

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public Date getWarehousStartDate() {
        return warehousStartDate;
    }

    public void setWarehousStartDate(Date warehousStartDate) {
        this.warehousStartDate = warehousStartDate;
    }

    public Date getWarehousEndDate() {
        return warehousEndDate;
    }

    public void setWarehousEndDate(Date warehousEndDate) {
        this.warehousEndDate = warehousEndDate;
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

    public String getApprovalResult() {
        return approvalResult;
    }

    public Date getApprovalStartDate() {
        return approvalStartDate;
    }

    public void setApprovalStartDate(Date approvalStartDate) {
        this.approvalStartDate = approvalStartDate;
    }

    public Date getApprovalEndDate() {
        return approvalEndDate;
    }

    public void setApprovalEndDate(Date approvalEndDate) {
        this.approvalEndDate = approvalEndDate;
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

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public void setApprovalResult(String approvalResult) {
        this.approvalResult = approvalResult;
    }
}
