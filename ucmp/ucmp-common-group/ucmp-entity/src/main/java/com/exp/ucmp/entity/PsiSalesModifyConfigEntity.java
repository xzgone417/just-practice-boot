package com.exp.ucmp.entity;

import com.egrid.core.base.entity.AbstractBaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.GroupSequence;
import java.util.Date;

/**
 * t_psi_sales_modify_config
 *
 * @author
 */
@ApiModel(value = "PsiSalesModifyConfigEntity", description = "二手车销售改配记录表")
@GroupSequence({PsiSalesModifyConfigEntity.class, PsiSalesModifyConfigEntity.PsiSalesModifyConfigEntityValidGroup.class, PsiSalesModifyConfigEntity.JournalIdValidGroup.class, PsiSalesModifyConfigEntity.VhclIdValidGroup.class, PsiSalesModifyConfigEntity.PricingAmountValidGroup.class, PsiSalesModifyConfigEntity.CreateNameValidGroup.class, PsiSalesModifyConfigEntity.CreateByValidGroup.class})
public class PsiSalesModifyConfigEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
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
     * 订单当前状态
     */
    @ApiModelProperty(value = "订单当前状态")
    private String orderStatus;
    
    @ApiModelProperty(value = "商品编号")
    private String productCode;

    /**
     * 目前配车vin码
     */
    @ApiModelProperty(value = "目前配车vin码")
    private String vin;

    /**
     * 变更vin码
     */
    @ApiModelProperty(value = "变更vin码")
    private String changeVin;

    /**
     * 申请人
     */
    @ApiModelProperty(value = "申请人")
    private Long applyBy;

    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    private Date applyDate;

    /**
     * 审批人
     */
    @ApiModelProperty(value = "审批人")
    private Long approveBy;

    /**
     * 审批结果 （1.改配中 2.改配通过 3.改配驳回 4.改配取消）
     */
    @ApiModelProperty(value = "审批结果 （1.改配中 2.改配通过 3.改配驳回 4.改配取消）")
    private Integer approveResult;

    /**
     * 审批时间
     */
    @ApiModelProperty(value = "审批时间")
    private Date approveDate;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 改配来源（1.销售人员 2.总部）
     */
    @ApiModelProperty(value = "改配来源（1.销售人员 2.总部）")
    private Integer applySource;
    
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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getChangeVin() {
        return changeVin;
    }

    public void setChangeVin(String changeVin) {
        this.changeVin = changeVin;
    }

    public Long getApplyBy() {
        return applyBy;
    }

    public void setApplyBy(Long applyBy) {
        this.applyBy = applyBy;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public Long getApproveBy() {
        return approveBy;
    }

    public void setApproveBy(Long approveBy) {
        this.approveBy = approveBy;
    }

    public Integer getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(Integer approveResult) {
        this.approveResult = approveResult;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getApplySource() {
        return applySource;
    }

    public void setApplySource(Integer applySource) {
        this.applySource = applySource;
    }

    public String getRejectReasons() {
		return rejectReasons;
	}

	public void setRejectReasons(String rejectReasons) {
		this.rejectReasons = rejectReasons;
	}

	@Override
    public boolean isEmptyPk() {
        return (applyId == null) ? true : false;
    }

    @Override
    public void generatePk() {
        applyId = null;
    }

    public interface PsiSalesModifyConfigEntityValidGroup {
    }

    public interface JournalIdValidGroup {
    }

    public interface VhclIdValidGroup {
    }

    public interface PricingAmountValidGroup {
    }

    public interface CreateNameValidGroup {
    }

    public interface CreateByValidGroup {
    }

    @Override
    protected Class<?>[] validGroups() {
        return new Class[]{
                PsiSalesModifyConfigEntity.JournalIdValidGroup.class
                , PsiSalesModifyConfigEntity.VhclIdValidGroup.class
                , PsiSalesModifyConfigEntity.PricingAmountValidGroup.class
                , PsiSalesModifyConfigEntity.CreateNameValidGroup.class
                , PsiSalesModifyConfigEntity.CreateByValidGroup.class
        };
    }
}