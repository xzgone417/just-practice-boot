package com.exp.ucmp.replacement.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(value = "ApprovalUpdateDto", description = "审批结果入参")
public class ApprovalUpdateDto extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 置换ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "置换ID")
    private Long replacementId;


    /**
     * 预约id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约id")
    private Long reservationId;

    /**
     * 审批结果
     */
    @ApiModelProperty(value = "审批结果:1401\t审批通过\n" +
            "1402\t审批驳回\n" +
            "1403\t审批关闭\n")
    private String approvalResult;

    /**
     * 权益发放
     */
    @ApiModelProperty(value = "权益发放/0:不发放/1:发放")
    private Integer rightActivitie;
    
    @ApiModelProperty(value = "权益包id")
    private Long rightId;
    
    @ApiModelProperty(value = "积分值")
    private int pointsValue;
    
    /**
     *1601置换/1602销售   业务标识
     */
    @ApiModelProperty(value = "业务标识 1601置换/1602销售")
    private String businessClassify;

    /**
     * 审批描述
     */
    @ApiModelProperty(value = "审批描述")
    private String approvalRemark;

    @ApiModelProperty(value = "置换单之前状态：1301\t待确认\n" +
            "1302\t确认通过\n" +
            "1303\t待审批\n" +
            "1304\t审批通过\n" +
            "1305\t驳回\n" +
            "1309\t关闭\n")
    private String replacementStatusBefore;

    /**
     * 最后交易上报时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后交易上报时间")
    private Date reportingDateEnd;
    
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

    public String getBusinessClassify() {
        return businessClassify;
    }

    public void setBusinessClassify(String businessClassify) {
        this.businessClassify = businessClassify;
    }

    public Date getReportingDateEnd() {
        return reportingDateEnd;
    }

    public void setReportingDateEnd(Date reportingDateEnd) {
        this.reportingDateEnd = reportingDateEnd;
    }

    public Long getReplacementId() {
        return replacementId;
    }

    public void setReplacementId(Long replacementId) {
        this.replacementId = replacementId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getReplacementStatusBefore() {
        return replacementStatusBefore;
    }

    public Integer getRightActivitie() {
        return rightActivitie;
    }

    public void setRightActivitie(Integer rightActivitie) {
        this.rightActivitie = rightActivitie;
    }

	public Long getRightId() {
		return rightId;
	}

	public void setRightId(Long rightId) {
		this.rightId = rightId;
	}

	public int getPointsValue() {
		return pointsValue;
	}

	public void setPointsValue(int pointsValue) {
		this.pointsValue = pointsValue;
	}

	public void setReplacementStatusBefore(String replacementStatusBefore) {
        this.replacementStatusBefore = replacementStatusBefore;
    }
}
