package com.exp.ucmp.servicing.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2023/2/18 17:36
 */
@ApiModel(value = "MaintenanceApprovalDto",description = "维修审批结果返回")
public class MaintenanceApprovalDto extends BaseModel {

    @ApiModelProperty(value = "费用")
    private String price;

    @ApiModelProperty(value = "维修项目list")
    private List<MaintenanceItemsDto> maintenanceList;

    @ApiModelProperty(value = "维修项目审批list")
    private List<ServiceApprovalRecordDto> approvalRecordList;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<MaintenanceItemsDto> getMaintenanceList() {
        return maintenanceList;
    }

    public void setMaintenanceList(List<MaintenanceItemsDto> maintenanceList) {
        this.maintenanceList = maintenanceList;
    }

    public List<ServiceApprovalRecordDto> getApprovalRecordList() {
        return approvalRecordList;
    }

    public void setApprovalRecordList(List<ServiceApprovalRecordDto> approvalRecordList) {
        this.approvalRecordList = approvalRecordList;
    }
}
