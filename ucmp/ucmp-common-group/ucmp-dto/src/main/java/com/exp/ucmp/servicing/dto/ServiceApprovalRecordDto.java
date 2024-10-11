package com.exp.ucmp.servicing.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author GeYiJiang
 * @Description: 整备审批历史dto
 * @date 2023/2/18 15:31
 */
@ApiModel(value = "ServiceApprovalRecordDto",description = "整备审批历史结果")
public class ServiceApprovalRecordDto extends BaseModel {

//    @ApiModelProperty(value = "业务id")
//    private Long materialApprovalRecordId;
//    @ApiModelProperty(value = "'整备信息id'")
//    private Long serviceId;
    @ApiModelProperty(value = "审批日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date approvalDate;
    @ApiModelProperty(value = "审批结果")
    private String approvalResult;
    @ApiModelProperty(value = "审批备注")
    private String approvalMark;

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

    public String getApprovalMark() {
        return approvalMark;
    }

    public void setApprovalMark(String approvalMark) {
        this.approvalMark = approvalMark;
    }
}
