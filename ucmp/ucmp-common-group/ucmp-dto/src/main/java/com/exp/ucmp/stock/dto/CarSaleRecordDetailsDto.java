package com.exp.ucmp.stock.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.file.dto.FileReturnDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author hailele
 * @Description: 车辆记录批售详情Dto
 * @date 2023/2/16 10:52
 */
@ApiModel(value = "CarSaleRecordDetailsDto", description = "车辆记录批售详情Dto")
public class CarSaleRecordDetailsDto extends BaseModel {

    @ApiModelProperty(value = "车辆id(用作详情查看)")
    private Long stockId;

    @ApiModelProperty(value = "VIN码")
    private String vinCode;

    @ApiModelProperty(value = "合作方")
    private String partnerName;

    @ApiModelProperty(value = "交付日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deliverDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "批售价")
    private BigDecimal wholesalePrice;

    @ApiModelProperty(value = "批售单号")
    private String wholesaleNo;

    @ApiModelProperty(value = "收款凭证(缩略图)")
    private List<FileReturnDto> voucherFiles;

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

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public String getWholesaleNo() {
        return wholesaleNo;
    }

    public void setWholesaleNo(String wholesaleNo) {
        this.wholesaleNo = wholesaleNo;
    }

    public List<FileReturnDto> getVoucherFiles() {
        return voucherFiles;
    }

    public void setVoucherFiles(List<FileReturnDto> voucherFiles) {
        this.voucherFiles = voucherFiles;
    }
}
