package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: PsiSalesModifyConfigDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/27 13:55<p>
 */
public class PsiSalesModifyConfigApproveDto {
    /**
     * 配车修改申请ID
     */
    @ApiModelProperty(value = "配车修改申请ID")
    private Long applyId;

    /**
     * 销售订单ID
     */
    @ApiModelProperty(value = "销售订单ID")
    private Long orderInfoId;

    /**
     * 变更vin码
     */
    @ApiModelProperty(value = "变更vin码")
    private String changeVin;

    /**
     * 审批结果 （1.改配中 2.改配通过 3.改配驳回 4.改配取消）
     */
    @ApiModelProperty(value = "审批结果 （1.改配中 2.改配通过 3.改配驳回 4.改配取消）")
    private Integer approveResult;
    
    @ApiModelProperty(value = "驳回原因")
    private String rejectReasons;

    public Long getApplyId() {
        return applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public String getChangeVin() {
        return changeVin;
    }

    public void setChangeVin(String changeVin) {
        this.changeVin = changeVin;
    }

    public Integer getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(Integer approveResult) {
        this.approveResult = approveResult;
    }

	public String getRejectReasons() {
		return rejectReasons;
	}

	public void setRejectReasons(String rejectReasons) {
		this.rejectReasons = rejectReasons;
	}
}
