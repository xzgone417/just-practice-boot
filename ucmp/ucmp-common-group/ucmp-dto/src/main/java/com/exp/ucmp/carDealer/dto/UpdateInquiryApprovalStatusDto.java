package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description: 更改询价表状态dto
 * @date 2022/10/24 17:58
 */
public class UpdateInquiryApprovalStatusDto extends BaseModel {

    private static final long serialVersionUID = -2782635992093002186L;
    /**
     * 预约id
     */
    @ApiModelProperty(value = "预约id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long reservationId;

    /**
     * 审批状态
     */
    @ApiModelProperty(value = "审批状态")
    private String approvalStatus;

    public UpdateInquiryApprovalStatusDto() {
    }

    public UpdateInquiryApprovalStatusDto(Long reservationId, String approvalStatus) {
        this.reservationId = reservationId;
        this.approvalStatus = approvalStatus;
    }

    /**
     * 获取
     * @return reservationId
     */
    public Long getReservationId() {
        return reservationId;
    }

    /**
     * 设置
     * @param reservationId
     */
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * 获取
     * @return approvalStatus
     */
    public String getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * 设置
     * @param approvalStatus
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String toString() {
        return "UpdateInquiryApprovalStatusDto{reservationId = " + reservationId + ", approvalStatus = " + approvalStatus + "}";
    }
}
