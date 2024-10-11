package com.exp.ucmp.transfer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 调拨出入库参数
 * @date 2023/3/8 11:17
 */
public class TransferWarehousingParamsDto extends BaseModel {
    @ApiModelProperty(value = "取消发运-1 出库-2 入库-3",required = true)
    private Integer option;

    @ApiModelProperty(value = "调拨申请id集合",required = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private List<Long> transferApplyIds;

    public Integer getOption() {
        return option;
    }

    public void setOption(Integer option) {
        this.option = option;
    }

    public List<Long> getTransferApplyIds() {
        return transferApplyIds;
    }

    public void setTransferApplyIds(List<Long> transferApplyIds) {
        this.transferApplyIds = transferApplyIds;
    }
}
