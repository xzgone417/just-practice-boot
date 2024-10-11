package com.exp.ucmp.stock.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.file.dto.FileReturnDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * @author hailele
 * @Description: 车辆记录批售Dto
 * @date 2023/2/16 10:52
 */
@ApiModel(value = "CarSaleRecordInfoDto", description = "车辆记录批售Dto")
public class CarSaleRecordInfoDto extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "选中的批售车辆id(字符串逗号拼接)")
    private String selectCarStockIds;

    @ApiModelProperty(value = "合作方")
    private String partnerName;

    @ApiModelProperty(value = "交付日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date deliverDate;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "车辆id(用作详情查看)")
    private Long stockId;



    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
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


    public String getSelectCarStockIds() {
        return selectCarStockIds;
    }

    public void setSelectCarStockIds(String selectCarStockIds) {
        this.selectCarStockIds = selectCarStockIds;
    }
}
