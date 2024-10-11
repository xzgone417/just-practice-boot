package com.exp.ucmp.carService.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "CarServiceMaterialApprovalRecordListDto", description = "整备车辆材料审批记录列表Dto")
public class CarServiceMaterialApprovalRecordListDto {

    private static final long serialVersionUID = 1L;

    /**
     * 整备信息id
     */
    @ApiModelProperty(value = "整备信息id")
    private Long serviceId;

    /**
     * 审批日期
     */
    @ApiModelProperty(value = "审批日期")
    private Date approvalDate;

    /**
     * 审批结果
     */
    @ApiModelProperty(value = "审批结果")
    private String approvalResult;

    /**
     * 审批备注
     */
    @ApiModelProperty(value = "审批备注")
    private String approvalRemark;

    /**
     * 审批人
     */
    @ApiModelProperty(value = "审批人")
    private String approvalPeople;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApprovalResult() {
        return approvalResult;
    }

    public void setApprovalResult(String approvalResult) {
        this.approvalResult = approvalResult;
    }

    public String getApprovalRemark() {
        return approvalRemark;
    }

    public void setApprovalRemark(String approvalRemark) {
        this.approvalRemark = approvalRemark;
    }

    public String getApprovalPeople() {
        return approvalPeople;
    }

    public void setApprovalPeople(String approvalPeople) {
        this.approvalPeople = approvalPeople;
    }
}
