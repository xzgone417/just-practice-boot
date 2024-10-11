package com.exp.ucmp.replacement.dto;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.GroupSequence;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(value = "RepReplacementApprovalRecordDto", description = "置换审批记录")
public class RepReplacementApprovalRecordDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 审批ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "审批ID")
    private Long approvalId;


    /**
     * 置换ID
     */
    @ApiModelProperty(value = "置换ID")
    private Long replacementId;

    /**
     * 审批结果：01、审批通过，02、审批驳回，03、审批关闭
     */
    @ApiModelProperty(value = "审批结果：01、审批通过，02、审批驳回，03、审批关闭")
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
    private Long approvalPerson;

    /**
     * 审批人名字
     */
    @ApiModelProperty(value = "审批人名字")
    private String approvalPersonName;

    /**
     * 审批时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "审批时间")
    private Date approvalDate;

    /**
     * 上报时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上报时间")
    private Date reportingDate;

    public RepReplacementApprovalRecordDto() {
    }

    public RepReplacementApprovalRecordDto(Long approvalId) {
        this.approvalId = approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }
    public Long getApprovalId() {
        return this.approvalId;
    }
    

    public void setReplacementId(Long replacementId) {
        this.replacementId = replacementId;
    }
    public Long getReplacementId() {
        return this.replacementId;
    }
    
    public void setApprovalResult(String approvalResult) {
        this.approvalResult = approvalResult;
    }
    public String getApprovalResult() {
        return this.approvalResult;
    }
    
    public void setApprovalRemark(String approvalRemark) {
        this.approvalRemark = approvalRemark;
    }
    public String getApprovalRemark() {
        return this.approvalRemark;
    }
    
    public void setApprovalPerson(Long approvalPerson) {
        this.approvalPerson = approvalPerson;
    }
    public Long getApprovalPerson() {
        return this.approvalPerson;
    }
    
    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }
    public Date getApprovalDate() {
        return this.approvalDate;
    }
    
    public void setReportingDate(Date reportingDate) {
        this.reportingDate = reportingDate;
    }
    public Date getReportingDate() {
        return this.reportingDate;
    }

    public String getApprovalPersonName() {
        return approvalPersonName;
    }

    public void setApprovalPersonName(String approvalPersonName) {
        this.approvalPersonName = approvalPersonName;
    }
}
